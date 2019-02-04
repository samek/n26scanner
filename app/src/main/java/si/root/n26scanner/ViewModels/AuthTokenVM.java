package si.root.n26scanner.ViewModels;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.Objects;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import si.root.n26scanner.Models.AuthToken;
import si.root.n26scanner.scannerApp;

public class AuthTokenVM extends ViewModel {

    MutableLiveData<AuthToken> Auth;


    public LiveData<AuthToken> GetAuthToken(String username, String password) {

        if (Auth==null || Auth.getValue()==null)  {
            Auth = new MutableLiveData<>();
            callLogin(username, password);
        } else {
            if (Auth.getValue().getExpiresIn()<getCtime()) {
                Auth = new MutableLiveData<>();
                callLogin(username, password);
            }
        }
        return Auth;
    }


    private void callLogin(String username, String password) {

        OkHttpClient client = new OkHttpClient();

        client.newCall(buildRequest(username,password)).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Auth.postValue(null);
            }

            @Override
            public void onResponse(Response response) throws IOException {

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                AuthToken a =  gson.fromJson(response.body().string(), AuthToken.class);
                if (a.getError()!=null) {
                    Auth.postValue(null);
                } else {
                    a.setExpiresIn(getCtime()+a.getExpiresIn());
                    Auth.postValue(a);
                }
            }
        });

    }

    private int getCtime() {
        return (int) (System.currentTimeMillis() / 1000L);
    }
    private Request buildRequest(String username, String password) {
        String url  = scannerApp.n26BaseUrl+"/oauth/token";
        HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();
        httpBuider
                .addQueryParameter("username",username)
                .addQueryParameter("grant_type","password")
                .addQueryParameter("password",password);

        Request request = new Request.Builder()
                .url(httpBuider.build())
                .header("Authorization", "Basic bXktdHJ1c3RlZC13ZHBDbGllbnQ6c2VjcmV0")
                .post(RequestBody.create(MediaType.parse("application/json"), "{}"))
                .build();
        return request;
    }
}

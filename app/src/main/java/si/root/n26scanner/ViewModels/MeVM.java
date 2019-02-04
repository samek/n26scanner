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

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import si.root.n26scanner.Models.AuthToken;
import si.root.n26scanner.Models.Me;
import si.root.n26scanner.scannerApp;

public class MeVM extends ViewModel {

    MutableLiveData<Me> me;


    public LiveData<Me> GetMeInfo(String token) {

        if (me ==null || me.getValue()==null)  {
            me = new MutableLiveData<>();
            callMeInfo(token);
        } else {

        }
        return me;
    }


    private void callMeInfo(String token) {

        OkHttpClient client = new OkHttpClient();

        client.newCall(buildRequest(token)).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                me.postValue(null);
            }

            @Override
            public void onResponse(Response response) throws IOException {

                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                Me a =  gson.fromJson(response.body().string(), Me.class);
                me.postValue(a);

            }
        });

    }

    private Request buildRequest(String token) {
        String url  = scannerApp.n26BaseUrl+"/api/me";
        HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();


        Request request = new Request.Builder()
                .url(httpBuider.build())
                .header("Authorization", "Bearer "+token)
                .get()
                .build();
        return request;
    }
}

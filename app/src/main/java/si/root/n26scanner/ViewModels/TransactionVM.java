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
import si.root.n26scanner.Models.Transaction;
import si.root.n26scanner.Models.TransactionResponse;
import si.root.n26scanner.Models.TransferRequest;
import si.root.n26scanner.scannerApp;

public class TransactionVM extends ViewModel {

    MutableLiveData<TransactionResponse> TsR;

    //($amount, $pin, $bic, $iban, $name, $reference)
    public LiveData<TransactionResponse> MakeTransaction(String token, String pin, Float amount, String bic, String iban, String name, String reference) {
        TsR = new MutableLiveData<>();
        Gson gson = new GsonBuilder().create();

        //Create transaction obj//
        TransferRequest tsr = new TransferRequest();
        Transaction ts = new Transaction();
        ts.setAmount(amount);
        ts.setPartnerBic(bic);
        ts.setReferenceText(reference);
        ts.setType("DT");
        ts.setPartnerIban(iban);
        ts.setPartnerName(name);
        tsr.setPin(pin);
        tsr.setTransaction(ts);
        /////////////////////////
        String transactionJson = gson.toJson(tsr);

        callTransaction(token, transactionJson);
        return TsR;
    }


    private void callTransaction(String token, String transaction) {


        OkHttpClient client = new OkHttpClient();

        client.newCall(buildRequest(token,transaction)).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                TsR.postValue(null);
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String body = response.body().string();
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                System.out.println(body);
                TransactionResponse a = gson.<TransactionResponse>fromJson(body, TransactionResponse.class);
                TsR.postValue(a);
            }
        });

    }


    private Request buildRequest(String token,  String  tr ) {
        String url  = scannerApp.n26BaseUrl+"/api/transactions";
        HttpUrl.Builder httpBuider = HttpUrl.parse(url).newBuilder();

        Request request = new Request.Builder()
                .url(httpBuider.build())
                .header("Authorization", "Bearer "+token)
                .post(RequestBody.create(MediaType.parse("application/json"), tr))
                .build();
        return request;
    }
}

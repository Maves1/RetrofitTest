package ru.mavesoft.retrofittest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    Retrofit retrofit;
    TBSServer tbsServer;
    String baseUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        baseUrl = "https://tbs-server.herokuapp.com/";

        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        tbsServer = retrofit.create(TBSServer.class);

        TestClass testClass = new TestClass();
        testClass.execute("");
    }

    class TestClass extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            String result = "";
            try {
                Response response = tbsServer.registerUser("Qq", "fdfdf").execute();
                result = Integer.toString(response.code());
            } catch (IOException ex) {

            }

            Log.i("TEST", result);
            return result;
        }
    }
}

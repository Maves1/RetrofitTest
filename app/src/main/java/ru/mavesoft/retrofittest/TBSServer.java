package ru.mavesoft.retrofittest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface TBSServer {
    @Headers({
            "X-Parse-Application-Id: tbsServer",
            "X-Parse-REST-API-Key: idkfdhtyrwq113n54"
    })

    @POST("reguser")
    Call<String> registerUser(@Query("login") String login, @Query("password") String password);
}

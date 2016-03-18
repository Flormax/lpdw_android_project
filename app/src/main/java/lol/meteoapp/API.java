package lol.meteoapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface API {

    @Headers("Accept: application/json")
    @GET("weather?q=London,uk&appid=b1b15e88fa797225412429c1c50c122a")
    Call<CurrentWeather> getLastMessage();
}
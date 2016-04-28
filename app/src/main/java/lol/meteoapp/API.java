package lol.meteoapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @Headers("Accept: application/json")
    @GET("weather?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<CurrentWeather> getTodayByCity(@Query("q") String cityName);

    @Headers("Accept: application/json")
    @GET("forecast?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<ForecastWeather> getForecastByCity(@Query("q") String cityName);

    @Headers("Accept: application/json")
    @GET("forecast?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<CurrentWeather> getTodayByCoo(@Query("lat") long lat, @Query("lon") long lon);

    @Headers("Accept: application/json")
    @GET("forecast?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<ForecastWeather> getForecastByCoo(@Query("lat") long lat, @Query("lon") long lon);
}
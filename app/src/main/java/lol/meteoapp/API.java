package lol.meteoapp;

import lol.meteoapp.JSON_PARSING.CurrentWeather;
import lol.meteoapp.JSON_PARSING.ForecastWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface API {
    @Headers("Accept: application/json")
    @GET("weather?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<CurrentWeather> getTodayByCity(@Query("q") String cityName,
                                        @Query("units") String unitsFormat);

    @Headers("Accept: application/json")
    @GET("forecast?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<ForecastWeather> getForecastByCity(@Query("q") String cityName,
                                            @Query("units") String unitsFormat);

    @Headers("Accept: application/json")
    @GET("weather?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<CurrentWeather> getTodayByCoo(@Query("lat") double lat,
                                       @Query("lon") double lon,
                                       @Query("units") String unitsFormat);

    @Headers("Accept: application/json")
    @GET("forecast?&appid=e56a3908ef9901a8a73e62cad60e27cb")
    Call<ForecastWeather> getForecastByCoo(@Query("lat") double lat,
                                           @Query("lon") double lon,
                                           @Query("units") String unitsFormat);
}
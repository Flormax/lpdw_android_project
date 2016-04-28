package lol.meteoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;


public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "MyLogs";
    public MyCity myCity;
    public long longitude;
    public long latitude;
    public TextView cityName;
    public TextView weather;
    public TextView temp;
    public String[] days;
    public View forecastViews[];
    public ForecastWeather forecast;

    public HomeFragment() {
    }

    public HomeFragment(MyCity myCity) {
        this.myCity = myCity;
    }

    public HomeFragment(long lon, long lat){
        longitude = lon;
        latitude = lat;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);

        sendRequest();
        setHasOptionsMenu(true);
        View fragContainer = inflater.inflate(R.layout.home, container, false);
        cityName = (TextView) fragContainer.findViewById(R.id.today_title);
        weather = (TextView) fragContainer.findViewById(R.id.today_weather);
        temp = (TextView) fragContainer.findViewById(R.id.today_temp_icon);
        days = new String[5];



        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());

        LinearLayout forecastContainer = (LinearLayout) fragContainer.findViewById(R.id.ll_weather5days);

        this.forecastViews = new View[forecastContainer != null ? forecastContainer.getChildCount() : 0];
        for (int i = 0; i < (forecastContainer != null ? forecastContainer.getChildCount() : 0); i++) {
            this.forecastViews[i] = forecastContainer.getChildAt(i);
        }

        if (forecastContainer != null) {
            forecastContainer.setOnClickListener(this);
        }

        for (int i = 0; i < 5; i++) {
            instance.add(Calendar.DAY_OF_MONTH, 1);
            String format = simpleDateFormat.format(instance.getTimeInMillis());
            String day = format.substring(0, 1).toUpperCase() + format.substring(1).toLowerCase();
            ((TextView) this.forecastViews[i].findViewById(R.id.day_icon)).setText(day);
            days[i] = day;
        }

        Icons.setBigIconsHashMap();
        Icons.setSmallIconsHashMap();
        return fragContainer;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle
            savedInstanceState) {

    }

    public void sendRequest(){
        Retrofit TodayRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API todayApi = TodayRetrofit.create(API.class);

        Call<CurrentWeather> todayCall = myCity != null ? todayApi.getTodayByCity(this.myCity.name) : todayApi.getTodayByCoo(latitude, longitude);

                todayCall.enqueue(new Callback<CurrentWeather>() {
                    public void onResponse(Call<CurrentWeather> todayCall, Response<CurrentWeather> todayResponse) {
                        setTodayData(todayResponse.body());
                    }

                    @Override
                    public void onFailure(Call<CurrentWeather> todayCall, Throwable t) {
                        Log.d("FAIL REQUEST TODAY", "Shit happens :/");
            }
        });

        Retrofit forecastRetrofit = new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
        API forecastApi = forecastRetrofit.create(API.class);


        if(myCity != null){
            Call<ForecastWeather> forecastCall = forecastApi.getForecastByCity(this.myCity.name);
        } else {
            Call<ForecastWeather> forecastCall = forecastApi.getForecastByCoo(latitude, longitude);
        }
        forecastCall.enqueue(new Callback<ForecastWeather>() {
            public void onResponse(Call<ForecastWeather> forecastCall, Response<ForecastWeather> forecastResponse) {
                setForecastData(forecastResponse.body());
            }

            @Override
            public void onFailure(Call<ForecastWeather> forecastCall, Throwable t) {
                Log.d("FAIL REQUEST TODAY", "Shit happens :/");
            }
        });
    }

    public void setTodayData(CurrentWeather weather) {
        this.cityName.setText(this.myCity.name);
        this.weather.setText(weather.weather[0].description);
        String temp = String.valueOf(Math.round(weather.main.temp - 273.15));
        temp += "°";
        this.temp.setText(temp);
        this.temp.setCompoundDrawablesWithIntrinsicBounds(Icons.BIG_ICONS.get(weather.weather[0].id), 0, 0, 0);
    }

    public void setForecastData(ForecastWeather forecast) {
        for (int i = 0; i < 5; i++) {
//            ((TextView) this.forecastViews[i].findViewById(R.id.day_icon)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, Icons.SMALL_ICONS.get(forecast.list[i].weather[0].id));
//            ((TextView) this.forecastViews[i].findViewById(R.id.day_temp)).setText(String.valueOf(Math.round(forecast.list[i].main.temp_max - 273.15)));
//            ((TextView) this.forecastViews[i].findViewById(R.id.night_temp)).setText(String.valueOf(Math.round(forecast.list[i].main.temp_min - 273.15)));
//            daycards.get(i).img = Icons.BIG_ICONS.get(forecast.list[i].weather[0].id);
//            daycards.get(i).prev = forecast.list[i].weather[0].description;
//            daycards.get(i).temp_max = String.valueOf(forecast.list[i].main.temp_min);
//            daycards.get(i).temp_min = String.valueOf(forecast.list[i].main.temp_max);
        }
        this.forecast = forecast;
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ll_weather5days){
            Intent intent = new Intent(this.getContext(), ForecastActivity.class);
            intent.putExtra("city", myCity.name);
            intent.putExtra("days", days);
            intent.putExtra("forecast", forecast);
            startActivity(intent);
        }
    }
}

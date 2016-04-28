package lol.meteoapp;

import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentWeather {

    public CurrentWeather() {}

    public String name;
    public Sys sys;
    public Weather[] weather;
    public Main main;
    public Wind wind;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Main {
        public int temp;
        public int pressure;
        public int humidity;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Wind{
        public int speed;
        public int deg;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Sys{
        public String country;
    }

    @Override
    public String toString() {
        Log.v("weather__NAME", this.name);
        //Log.v("weather__BASE", this.base);
        Log.v("weather__WEATHER_descr", this.weather[0].description);
        Log.v("weather__MAIN_temp", String.valueOf(Math.round(this.main.temp - 273.15)));
        Log.v("weather__MAIN_pressure", String.valueOf(this.main.pressure));
        Log.v("weather__MAIN_humidity", String.valueOf(this.main.humidity));
        Log.v("weather__WIND_speed", String.valueOf(this.wind.speed));
        Log.v("weather__WIND_deg", String.valueOf(this.wind.deg));
        Log.v("weather__SYS_cntrycode", this.sys.country);
        return super.toString();
    }
}
//{"coord":{"lon":-122.09,"lat":37.39},
//        "sys":{"type":3,"id":168940,"message":0.0297,"country":"US","sunrise":1427723751,"sunset":1427768967},
//        "weather":[{"id":800,"main":"Clear","description":"Sky is Clear","icon":"01n"}],
//        "base":"stations",
//        "main":{"temp":285.68,"humidity":74,"pressure":1016.8,"temp_min":284.82,"temp_max":286.48},
//        "wind":{"speed":0.96,"deg":285.001},
//        "clouds":{"all":0},
//        "dt":1427700245,
//        "id":0,
//        "name":"Mountain View",
//        "cod":200}


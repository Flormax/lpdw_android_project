package lol.meteoapp.JSON_PARSING;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastWeather implements Parcelable {
    public ForecastWeather(){}

    public City city;
    public List[] list;

    protected ForecastWeather(Parcel in) {
        this.city = in.readParcelable(City.class.getClassLoader());
        this.list = in.createTypedArray(List.CREATOR);
    }

    public static final Creator<ForecastWeather> CREATOR = new Creator<ForecastWeather>() {
        @Override
        public ForecastWeather createFromParcel(Parcel in) {
            return new ForecastWeather(in);
        }

        @Override
        public ForecastWeather[] newArray(int size) {
            return new ForecastWeather[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(city, flags);
        dest.writeTypedArray(list, flags);
    }
}

package lol.meteoapp.JSON_PARSING;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main implements Parcelable{

    public Main(){}

    public int temp_min;
    public int temp_max;
    public int pressure;
    public int humidity;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(temp_min);
        dest.writeInt(temp_max);
        dest.writeInt(pressure);
        dest.writeInt(humidity);
    }

    protected Main(Parcel in) {
        temp_min = in.readInt();
        temp_max = in.readInt();
        pressure = in.readInt();
        humidity = in.readInt();
    }

    public static final Creator<Main> CREATOR = new Creator<Main>() {
        @Override
        public Main createFromParcel(Parcel in) {
            return new Main(in);
        }

        @Override
        public Main[] newArray(int size) {
            return new Main[size];
        }
    };
}

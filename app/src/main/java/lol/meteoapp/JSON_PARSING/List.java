package lol.meteoapp.JSON_PARSING;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class List implements Parcelable{

    public List(){}

    public Main main;
    public String description;
    public Weather[] weather;
    public Wind wind;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(main, flags);
        dest.writeString(description);
        dest.writeTypedArray(weather, flags);
        dest.writeParcelable(wind, flags);
    }

    protected List(Parcel in) {
        main = in.readParcelable(Main.class.getClassLoader());
        description = in.readString();
        weather = in.createTypedArray(Weather.CREATOR);
        wind = in.readParcelable(Wind.class.getClassLoader());
    }

    public static final Creator<List> CREATOR = new Creator<List>() {
        @Override
        public List createFromParcel(Parcel in) {
            return new List(in);
        }

        @Override
        public List[] newArray(int size) {
            return new List[size];
        }
    };
}

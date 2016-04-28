package lol.meteoapp;

import android.support.annotation.DrawableRes;

public class Daycard {
    public String day;
    public String prev;
    public String temp_min;
    public String temp_max;
    @DrawableRes
    public int img;

    public Daycard(String day, String prev, String temp_min, String temp_max, int img){
        this.day = day;
        this.prev = prev;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
        this.img = img;
    }

    public Daycard(){ }
}

package lol.meteoapp;

import android.support.annotation.DrawableRes;

public class Daycard {
    public String day;
    public String prev;
    public String temp;
    public String rainPercent;
    @DrawableRes
    public int img;

    public Daycard(String day, String prev, String temp, String rainPercent, int img){
        this.day = day;
        this.prev = prev;
        this.temp = temp;
        this.rainPercent = rainPercent;
        this.img = img;
    }
}

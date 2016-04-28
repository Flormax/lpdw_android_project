package lol.meteoapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class IndexAdapter extends FragmentPagerAdapter {

    public List<HomeFragment> frags;

    public IndexAdapter(FragmentManager fm, Context context) {
        super(fm);
        DatabaseHelper db = DatabaseHelper.getInstance(context);
        frags = new ArrayList<>();
        List<MyCity> cities = db.getAllCities();
        db.close();
        for (MyCity myCity : cities) {
            frags.add(new HomeFragment(myCity));
        }
    }

    public void insert() {
        //frags.add(0, );
    }

    public void remove(int position) {
        frags.remove(position);
    }

    @Override
    public HomeFragment getItem(int position) {
        return this.frags.get(position);
    }

    @Override
    public int getCount() {
        return this.frags.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return frags.get(position).myCity.name;
    }
}
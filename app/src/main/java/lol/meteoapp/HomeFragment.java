package lol.meteoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class HomeFragment extends Fragment implements View.OnClickListener{
    private static final String TAG = "MyLogs";
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle
            savedInstanceState) {

        Calendar instance = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE", Locale.getDefault());

        LinearLayout weather_5days = (LinearLayout) view.findViewById(R.id.ll_weather5days);
        View weather_5days_views[] = new View[weather_5days != null ? weather_5days.getChildCount() : 0];
        for (int i = 0; i < (weather_5days != null ? weather_5days.getChildCount() : 0); i++) {
            weather_5days_views[i] = weather_5days.getChildAt(i);
        }

        for (int i = 0; i < 5; i++) {
            instance.add(Calendar.DAY_OF_MONTH, 1);
            String format = simpleDateFormat.format(instance.getTimeInMillis());
            String day = format.substring(0, 1).toUpperCase() + format.substring(1).toLowerCase();
            ((TextView) weather_5days_views[i].findViewById(R.id.day_icon)).setText(day);
        }

        ((TextView) weather_5days_views[0].findViewById(R.id.day_icon)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.weather_snow);
        ((TextView) weather_5days_views[1].findViewById(R.id.day_icon)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.weather_rain);
        ((TextView) weather_5days_views[2].findViewById(R.id.day_icon)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.weather_few_clouds);
        ((TextView) weather_5days_views[3].findViewById(R.id.day_icon)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.weather_snow);
        ((TextView) weather_5days_views[4].findViewById(R.id.day_icon)).setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, R.drawable.weather_snow);

        ((TextView) weather_5days_views[0].findViewById(R.id.day_temp)).setText("1°");
        ((TextView) weather_5days_views[1].findViewById(R.id.day_temp)).setText("2°");
        ((TextView) weather_5days_views[2].findViewById(R.id.day_temp)).setText("-5°");
        ((TextView) weather_5days_views[3].findViewById(R.id.day_temp)).setText("2°");
        ((TextView) weather_5days_views[4].findViewById(R.id.day_temp)).setText("0°");

        ((TextView) weather_5days_views[0].findViewById(R.id.night_temp)).setText("-4°");
        ((TextView) weather_5days_views[1].findViewById(R.id.night_temp)).setText("-8°");
        ((TextView) weather_5days_views[2].findViewById(R.id.night_temp)).setText("-12°");
        ((TextView) weather_5days_views[3].findViewById(R.id.night_temp)).setText("-6°");
        ((TextView) weather_5days_views[4].findViewById(R.id.night_temp)).setText("-9°");

        if (weather_5days != null) {
            weather_5days.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ll_weather5days){
            Intent intent = new Intent(this.getContext(), DetailsPrevActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_cities){
            Intent intent = new Intent(this.getActivity(), CitiesActivity.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.ll_weather5days){
            Intent intent = new Intent(this.getContext(), DetailsPrevActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getActivity().getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}

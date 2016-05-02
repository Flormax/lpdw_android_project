package lol.meteoapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class IndexActivity extends AppCompatActivity {
    private IndexAdapter adapter;
    private TabLayout tablayout;
    private LocationManager lm;

    //Pour générer l'onglet en fonction de la position actuelle
    LocationListener onLocationChange = new LocationListener(){
        public void onLocationChanged(Location loc) {
            HomeFragment hf = new HomeFragment(loc.getLatitude(), loc.getLongitude());
            tablayout = (TabLayout) findViewById(R.id.sliding_tabs);

            adapter = new IndexAdapter(getSupportFragmentManager(), getApplicationContext());

            adapter.frags.add(0, hf);
            ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
            if (pager != null) {
                pager.setAdapter(adapter);
            }

            tablayout.setupWithViewPager(pager);

            if (pager != null) {
                pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
            }
        }
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {}
        @Override
        public void onProviderEnabled(String provider) {}
        @Override
        public void onProviderDisabled(String provider) {}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_viewpager);

        //Initilisation des ressources static
        WeatherRessources.setBigIconsHashMap();
        WeatherRessources.setSmallIconsHashMap();
        WeatherRessources.setDescriptionsHashMap();

        lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        lm.requestSingleUpdate(lm.GPS_PROVIDER, onLocationChange, getMainLooper());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_cities){
            Intent intent = new Intent(this, CitiesActivity.class);
            int requestCode = 1;
            startActivityForResult(intent, requestCode);
        } else if(item.getItemId() == R.id.menu_settings) {
            FragmentManager mFragmentManager = getFragmentManager();
            FragmentTransaction mFragmentTransaction = mFragmentManager
                    .beginTransaction();
            PreferencesFragment mPrefsFragment = new PreferencesFragment();
            mFragmentTransaction.replace(android.R.id.content, mPrefsFragment);
            mFragmentTransaction.commit();
        }
        return super.onOptionsItemSelected(item);
    }

    //Si le nombre de villes à changer (+/-), on reset l'activity pour mettre à jour la liste d'onglets
    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        if(requestCode == 1) {
            if(resultCode == RESULT_OK){
                if(data.getIntExtra("citiesCount", 0) != tablayout.getTabCount()+1){
                    Intent intent = getIntent();
                    finish();
                    startActivity(intent);
                }
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}
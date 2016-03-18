package lol.meteoapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

public class IndexActivity extends AppCompatActivity implements View.OnClickListener{

    private IndexAdapter adapter;
    private TabLayout tablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.index_viewpager);

        tablayout = (TabLayout) findViewById(R.id.sliding_tabs);

        this.adapter = new IndexAdapter(getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        if (pager != null) {
            pager.setAdapter(adapter);
        }

        tablayout.setupWithViewPager(pager);

        if (pager != null) {
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        }

        View onclick_card = findViewById(R.id.ll_weather5days);
        if (onclick_card != null) {
            onclick_card.setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ll_weather5days){
            Intent intent = new Intent(this, DetailsPrevActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
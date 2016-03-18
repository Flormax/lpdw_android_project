package lol.meteoapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class IndexActivity extends AppCompatActivity{

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
        tablayout.addTab(tablayout.newTab().setText("Tab 1"));
        tablayout.addTab(tablayout.newTab().setText("Tab 2"));
        tablayout.addTab(tablayout.newTab().setText("Tab 3"));

        tablayout.setupWithViewPager(pager);

        if (pager != null) {
            pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        }
    }
}
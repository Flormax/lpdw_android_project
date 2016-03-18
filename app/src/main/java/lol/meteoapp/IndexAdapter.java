package lol.meteoapp;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class IndexAdapter extends FragmentPagerAdapter {

    private final List fragments;

    public IndexAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        Fragment frag;

        fragments.add(new FragmentEditor());
        fragments.add(new FragmentEditor());
        fragments.add(new FragmentEditor());

        for (int i = 0; i < fragments.size(); i++) {
            ((Fragment) fragments.get(i)).getFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        }

    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "tab 1";
            case 1:
                return "tab 2";
            case 2:
                return "tab 3";
            default:
                return "toto";
        }
    }


}
package com.uygulamalarim.istanbul_times_news_app_retrofit.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.uygulamalarim.istanbul_times_news_app_retrofit.Fragments.EconomyFragment;
import com.uygulamalarim.istanbul_times_news_app_retrofit.Fragments.EntertainmentFragment;
import com.uygulamalarim.istanbul_times_news_app_retrofit.Fragments.HealthFragment;
import com.uygulamalarim.istanbul_times_news_app_retrofit.Fragments.HomeFragment;
import com.uygulamalarim.istanbul_times_news_app_retrofit.Fragments.ScienceFragment;
import com.uygulamalarim.istanbul_times_news_app_retrofit.Fragments.SportsFragment;

public class PagerAdapter extends FragmentPagerAdapter {
    int tabcount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new EconomyFragment();
            case 2:
                return new SportsFragment();
            case 3:
                return new EntertainmentFragment();
            case 4:
                return new ScienceFragment();
            case 5:
                return new HealthFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabcount;
    }
}

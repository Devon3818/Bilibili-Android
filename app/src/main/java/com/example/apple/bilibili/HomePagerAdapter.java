package com.example.apple.bilibili;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by apple on 2018/3/30.
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES;
    private Fragment[] fragments;

    public HomePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        TITLES = context.getResources().getStringArray(R.array.sections);
        fragments = new Fragment[TITLES.length];
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            fragments[position] = HomeLiveFragment.newInstance();
        }
        if(position == 3){
            fragments[position] = HomeRegionFragment.newInstance();
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }
}

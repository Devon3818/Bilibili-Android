package com.example.apple.bilibili;

import android.app.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.Toolbar;

import com.flyco.tablayout.SlidingTabLayout;

/**
 * Created by apple on 2018/3/29.
 */

public class HomePageFragment extends Fragment {

    Toolbar mToolbar;
    ViewPager mViewPager;
    SlidingTabLayout mSlidingTab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.fragment_home_pager,container,false);
        mToolbar = view.findViewById(R.id.toolbar);
        //((MainActivity) getActivity()).setSupportActionBar(mToolbar);
        mToolbar.inflateMenu(R.menu.menu_main);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewPager = view.findViewById(R.id.view_pager);
        mSlidingTab = view.findViewById(R.id.sliding_tabs);
        initViewPager();
    }

    public static HomePageFragment newInstance() {
        return new HomePageFragment();
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    private void initViewPager(){
        HomePagerAdapter homePagerAdapter = new HomePagerAdapter(getChildFragmentManager(),getActivity().getApplicationContext());
        mViewPager.setOffscreenPageLimit(5);
        mViewPager.setAdapter(homePagerAdapter);
        mSlidingTab.setViewPager(mViewPager);
        mViewPager.setCurrentItem(0);
    }
}

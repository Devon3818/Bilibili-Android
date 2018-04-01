package com.example.apple.bilibili;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by apple on 2018/4/1.
 */

public class HomeRegionFragment extends Fragment {

    RecyclerView recyclerView;

    public static HomeRegionFragment newInstance() {
        return new HomeRegionFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_region,container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle_reg);
        initViewPager();
    }

    public void initViewPager(){
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),3));
        HomeRegionItemAdapter homeRegionItemAdapter = new HomeRegionItemAdapter(recyclerView);
        recyclerView.setAdapter(homeRegionItemAdapter);
    }
}

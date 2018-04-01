package com.example.apple.bilibili;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by apple on 2018/3/30.
 */

public class HomeLiveFragment extends Fragment {

    LiveAppIndexAdapter liveAppIndexAdapter;
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_live,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycle);
        initViewPager();
    }

    public static HomeLiveFragment newInstance() {
        return new HomeLiveFragment();
    }

    private void initViewPager(){
        liveAppIndexAdapter = new LiveAppIndexAdapter(getActivity());

        recyclerView.setAdapter(liveAppIndexAdapter);
        GridLayoutManager layout = new GridLayoutManager(getActivity(),12);
        layout.setOrientation(LinearLayoutManager.VERTICAL);
        layout.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if( position == 0 ){
                    return 12;
                }
                if( position < 5 ){
                    return 3;
                }
                else{
                    return 6;
                }
            }
        });
        recyclerView.setLayoutManager(layout);

    }
}

package com.example.apple.bilibili;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by apple on 2018/3/31.
 */

public class LiveAppIndexAdapter extends RecyclerView.Adapter {

    Context mContext;
    List imgList = new ArrayList();

    public LiveAppIndexAdapter(Context context){
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 1 ){
            return new LiveBannerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_live_banner,parent,false));
        }else{
            return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.test_view2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        if( position == 0 ){
            return 1;
        }else{
            return 0;
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        public ItemViewHolder(View itemView) {
            super(itemView);
        }
    }

    class LiveBannerViewHolder extends RecyclerView.ViewHolder {

        public LiveBannerViewHolder(View itemView) {
            super(itemView);
            imgList.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
            imgList.add("http://ww4.sinaimg.cn/large/006uZZy8jw1faic1xjab4j30ci08cjrv.jpg");
            Banner banner = (Banner) itemView.findViewById(R.id.banner);
            banner.setImages(imgList).setImageLoader(new GlideImageLoader()).start();
        }
    }

    class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }



}

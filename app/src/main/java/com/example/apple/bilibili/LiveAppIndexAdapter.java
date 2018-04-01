package com.example.apple.bilibili;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
    private int[] entranceIconRes = new int[]{
            R.drawable.live_home_follow_anchor,
            R.drawable.live_home_live_center,
            R.drawable.live_home_search_room,
            R.drawable.live_home_all_category
    };

    private String[] entranceTitles = new String[]{
            "关注主播", "直播中心",
            "搜索直播", "全部分类"
    };

    public LiveAppIndexAdapter(Context context){
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == 1 ){
            return new LiveBannerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_live_banner,parent,false));
        }
        if(viewType == 2){
            return new LiveEntranceViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_live_entrance,parent,false));
        }else{
            return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.test_view2,parent,false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        position -= 1;
        if( holder instanceof LiveEntranceViewHolder ){
            LiveEntranceViewHolder liveEntranceViewHolder = (LiveEntranceViewHolder) holder;
            liveEntranceViewHolder.title.setText(entranceTitles[position]);
            Glide.with(mContext)
                    .load(entranceIconRes[position])
                    .into(((LiveEntranceViewHolder) holder).image);
        }

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    @Override
    public int getItemViewType(int position) {
        if( position == 0 ){
            return 1;
        }
        if( position < 5 ){
            return 2;
        }
        else{
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

    class LiveEntranceViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView image;

        public LiveEntranceViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.live_entrance_title);
            image = itemView.findViewById(R.id.live_entrance_image);
        }
    }

    class GlideImageLoader extends ImageLoader {

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context).load(path).into(imageView);
        }
    }



}

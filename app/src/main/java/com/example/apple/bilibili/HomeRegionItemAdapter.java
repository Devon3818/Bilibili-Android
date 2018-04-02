package com.example.apple.bilibili;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by apple on 2018/4/1.
 */

public class HomeRegionItemAdapter extends RecyclerView.Adapter {

    Context mContext;

    private String[] itemNames = new String[]{
        "直播", "番剧", "动画",
                "音乐", "舞蹈", "游戏",
                "科技", "生活", "鬼畜",
                "时尚", "广告", "娱乐",
                "电影", "电视剧", "游戏中心",
    };

    private int[] itemIcons = new int[]{
            R.drawable.ic_category_live, R.drawable.ic_category_t13,
            R.drawable.ic_category_t1, R.drawable.ic_category_t3,
            R.drawable.ic_category_t129, R.drawable.ic_category_t4,
            R.drawable.ic_category_t36, R.drawable.ic_category_t160,
            R.drawable.ic_category_t119, R.drawable.ic_category_t155,
            R.drawable.ic_category_t165, R.drawable.ic_category_t5,
            R.drawable.ic_category_t23, R.drawable.ic_category_t11,
            R.drawable.ic_category_game_center
    };

    public HomeRegionItemAdapter(Context context){
        mContext = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_home_region,parent,false));
        //return new ItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.fragment_home_region,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mItemIcon.setImageResource(itemIcons[position]);
            itemViewHolder.mItemText.setText(itemNames[position]);
        }
    }

    @Override
    public int getItemCount() {
        return itemNames.length;
    }

    public int getItemViewType(int position) {
        return position;
    }


    class ItemViewHolder extends RecyclerView.ViewHolder {

        public ImageView mItemIcon;
        public TextView mItemText;

        public ItemViewHolder(View itemView) {
            super(itemView);
            mItemIcon = itemView.findViewById(R.id.dv_item_icon);
            mItemText = itemView.findViewById(R.id.dv_item_title);
        }
    }
}

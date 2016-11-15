package com.iqiyi.zhenzhen.waterfall;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by zhenzhen on 2016/11/15.
 */

public class WaterFallAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<PersonCard> mData;

    public WaterFallAdapter(Context mContext, List<PersonCard> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item, null);
        return new MyViewHolder(view);
    }

    /**
     * 将数据源的数据绑定到相应控件上
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder holder1 = (MyViewHolder) holder;
        PersonCard card = mData.get(position);
        Uri uri = Uri.parse(card.getAvatarUrl());
        holder1.userAvatar.setImageURI(uri);
        holder1.userAvatar.getLayoutParams().height = card.getImgHeight();
        holder1.userName.setText(card.getName());
    }

    @Override
    public int getItemCount() {

        if(mData != null){
            return mData.size();
        }
        return 0;
    }


    /**
     * 将view的控件引用在成员变量上
     */
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public SimpleDraweeView userAvatar;
        public TextView userName;

        public MyViewHolder(View itemView) {
            super(itemView);
            userAvatar = (SimpleDraweeView) itemView.findViewById(R.id.user_avastar);
            userName = (TextView) itemView.findViewById(R.id.usr_name);
        }
    }
}

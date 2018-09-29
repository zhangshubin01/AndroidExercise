package com.padtast.recyclerviewlibrary.paymentrecord.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.padtast.recyclerviewlibrary.Adapter.BusinessAdapter;
import com.padtast.recyclerviewlibrary.R;
import com.padtast.recyclerviewlibrary.paymentrecord.bean.paymentTrecordBean;

import java.util.List;

/**
 * @author zhangshubin
 * @time 2018-09-29 14:26
 * @email shubin.zhang@ucarinc.com
 * @tel 3487
 * @desc
 */
public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {
    private Context mContext;
    private List<paymentTrecordBean> list;

    /**
     *@author zhangshubin
     *@time 2018/9/29
     *@desc
     */
    public TitleAdapter(Context context,List<paymentTrecordBean> mList){
       this.mContext = context;
       this.list = mList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_title, parent, false);
        TitleAdapter.MyViewHolder myViewHolder = new TitleAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(View itemView) {
            super(itemView);
        }
    }
}

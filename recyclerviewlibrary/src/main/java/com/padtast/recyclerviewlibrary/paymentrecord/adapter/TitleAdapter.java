package com.padtast.recyclerviewlibrary.paymentrecord.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padtast.recyclerviewlibrary.Adapter.ProductAdapter;
import com.padtast.recyclerviewlibrary.MainActivity;
import com.padtast.recyclerviewlibrary.R;
import com.padtast.recyclerviewlibrary.R2;
import com.padtast.recyclerviewlibrary.paymentrecord.Myview;
import com.padtast.recyclerviewlibrary.paymentrecord.bean.paymentTrecordBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zhangshubin
 * @time 2018-09-29 14:26
 * @tel 3487
 * @desc
 */
public class TitleAdapter extends RecyclerView.Adapter<TitleAdapter.MyViewHolder> {

    private Context                  mContext;
    private List<List<paymentTrecordBean.paymentTrecordBean1>> list;

    /**
     * @author zhangshubin
     * @time 2018/9/29
     * @desc
     */
    public TitleAdapter(Context context, List<List<paymentTrecordBean.paymentTrecordBean1>> mList) {
        this.mContext = context;
        this.list = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_title, null, false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if(holder.recyclerView.getAdapter() == null){
            holder.recyclerView.setAdapter(new SecondaryTitleAdapter(mContext, list.get(position)));
            DividerItemDecoration divider = new DividerItemDecoration(mContext,DividerItemDecoration.VERTICAL);
            holder.recyclerView.addItemDecoration(divider);
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.recyclerView)
        Myview   recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(itemView.getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            linearLayoutManager.setAutoMeasureEnabled(true);
            recyclerView.setLayoutManager(linearLayoutManager);
        }



    }
}

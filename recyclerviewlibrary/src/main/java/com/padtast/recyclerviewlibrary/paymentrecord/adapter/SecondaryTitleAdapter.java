package com.padtast.recyclerviewlibrary.paymentrecord.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.padtast.recyclerviewlibrary.Adapter.ProductAdapter;
import com.padtast.recyclerviewlibrary.R;
import com.padtast.recyclerviewlibrary.R2;
import com.padtast.recyclerviewlibrary.paymentrecord.Myview;
import com.padtast.recyclerviewlibrary.paymentrecord.bean.paymentTrecordBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zhangshubin
 * @time 2018-09-29 16:45
 * @email shubin.zhang@ucarinc.com
 * @tel 3487
 * @desc
 */
public class SecondaryTitleAdapter extends RecyclerView.Adapter<SecondaryTitleAdapter.MyViewHolder> {


    private Context                                      mContext;
    private List<paymentTrecordBean.paymentTrecordBean1> list;

    /**
     * @author zhangshubin
     * @time 2018/9/29
     * @desc
     */
    public SecondaryTitleAdapter(Context context, List<paymentTrecordBean.paymentTrecordBean1> mList) {
        this.mContext = context;
        this.list = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_secondary_title, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        paymentTrecordBean.paymentTrecordBean1   paymentTrecordBean1 = list.get(position);
        holder.text2.setText(paymentTrecordBean1.getName());
        holder.text3.setText(paymentTrecordBean1.getMoney());
        if(paymentTrecordBean1.getList()!=null){
            if(holder.recyclerView1.getAdapter() == null){
                holder.recyclerView1.setAdapter(new SecondaryTitle2Adapter(mContext, list.get(position).getList()));
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
                linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                linearLayoutManager.setAutoMeasureEnabled(true);
                holder.recyclerView1.setLayoutManager(linearLayoutManager);

                holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(holder.recyclerView1.getVisibility() ==View.GONE){
                            holder.recyclerView1.setVisibility(View.VISIBLE);
                        }else{
                            holder.recyclerView1.setVisibility(View.GONE);
                        }

                    }
                });
            }
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.text2)
        TextView       text2;
        @BindView(R2.id.text3)
        TextView       text3;
        @BindView(R2.id.recyclerView1)
        Myview         recyclerView1;
        @BindView(R2.id.relativeLayout)
        RelativeLayout relativeLayout;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

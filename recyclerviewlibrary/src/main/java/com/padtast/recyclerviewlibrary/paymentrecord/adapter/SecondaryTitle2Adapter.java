package com.padtast.recyclerviewlibrary.paymentrecord.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.padtast.recyclerviewlibrary.R;
import com.padtast.recyclerviewlibrary.R2;
import com.padtast.recyclerviewlibrary.paymentrecord.bean.paymentTrecordBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zhangshubin
 * @time 2018-09-29 16:45
 * @tel 3487
 * @desc
 */
public class SecondaryTitle2Adapter extends RecyclerView.Adapter<SecondaryTitle2Adapter.MyViewHolder> {



    private Context                                      mContext;
    private List<paymentTrecordBean.paymentTrecordBean2> list;

    /**
     * @author zhangshubin
     * @time 2018/9/29
     * @desc
     */
    public SecondaryTitle2Adapter(Context context, List<paymentTrecordBean.paymentTrecordBean2> mList) {
        this.mContext = context;
        this.list = mList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_secondary_title3, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        paymentTrecordBean.paymentTrecordBean2 paymentTrecordBean1 = list.get(position);
        holder.text4.setText(paymentTrecordBean1.getName());
        holder.text5.setText(paymentTrecordBean1.getMoney());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R2.id.text4)
        TextView text4;
        @BindView(R2.id.text5)
        TextView text5;

        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}

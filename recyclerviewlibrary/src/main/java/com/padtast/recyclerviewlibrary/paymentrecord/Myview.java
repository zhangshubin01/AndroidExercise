package com.padtast.recyclerviewlibrary.paymentrecord;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * @author zhangshubin
 * @time 2018-09-29 18:13
 * @tel 3487
 * @desc
 */
public class Myview  extends RecyclerView {
    public Myview(@NonNull Context context) {
        super(context);
    }


    public Myview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }
    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
//        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthSpec, heightSpec);
    }
//
//    @Override
//    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state,
//                          int widthSpec, int heightSpec) {
//
//        final int widthMode = View.MeasureSpec.getMode(widthSpec);
//        final int heightMode = View.MeasureSpec.getMode(heightSpec);
//        final int widthSize = View.MeasureSpec.getSize(widthSpec);
//        final int heightSize = View.MeasureSpec.getSize(heightSpec);
//        int measureWidth = 0;
//        int measureHeight = 0;
//        int count;
//        if (mMaxItemCount < 0 || getItemCount() < mMaxItemCount) {
//            count = getItemCount();
//        } else {
//            count = mMaxItemCount;
//        }
//        for (int i = 0; i < count; i++) {
//            int[] measuredDimension = getChildDimension(recycler, i);
//            if (measuredDimension == null || measuredDimension.length != 2)
//                return;
//            if (getOrientation() == HORIZONTAL) {
//                measureWidth = measureWidth + measuredDimension[0];
//           //<!--获取最大高度-->
//                        measureHeight = Math.max(measureHeight, measuredDimension[1]);
//            } else {
//                measureHeight = measureHeight + measuredDimension[1];
//            //<!--获取最大宽度-->
//                        measureWidth = Math.max(measureWidth, measuredDimension[0]);
//            }
//        }
//
//        measureHeight = heightMode == View.MeasureSpec.EXACTLY ? heightSize : measureHeight;
//        measureWidth = widthMode == View.MeasureSpec.EXACTLY ? widthSize : measureWidth;
//        if (getOrientation() == VERTICAL && measureWidth > widthSize) {
//            measureWidth = widthSize;
//        } else if (getOrientation() == HORIZONTAL && measureHeight > heightSize) {
//            measureHeight = heightSize;
//        }
//        setMeasuredDimension(measureWidth, measureHeight);
//    }
//
//
//    private int[] getChildDimension(RecyclerView.Recycler recycler, int position) {
//        try {
//            int[] measuredDimension = new int[2];
//            View view = recycler.getViewForPosition(position);
//            //测量childView，以便获得宽高（包括ItemDecoration的限制）
//            super.measureChildWithMargins(view, 0, 0);
//            //获取childView，以便获得宽高（包括ItemDecoration的限制），以及边距
//            RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
//            measuredDimension[0] = getDecoratedMeasuredWidth(view) + p.leftMargin + p.rightMargin;
//            measuredDimension[1] = getDecoratedMeasuredHeight(view) + p.bottomMargin + p.topMargin;
//            return measuredDimension;
//        } catch (Exception e) {
//            Log.d("LayoutManager", e.toString());
//        }
//        return null;
//    }
//

}

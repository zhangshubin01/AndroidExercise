package com.padtast.androidexercise.ImageBlendsIntoBackgroundColorPackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.padtast.androidexercise.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author zhangshubin
 */
public class Main3Activity extends AppCompatActivity {


    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_main)
    ImageView ivMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        ButterKnife.bind(this);

        ivBg.post(new Runnable() {
            @Override
            public void run() {
                pickColor();
            }
        });

    }

    private void pickColor() {
        Glide.with(this).asBitmap().load(R.drawable.bg_invert_image)
                //获取bitmap
                .into(new SimpleTarget<Bitmap>(750, 750) {

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        //获取Palette对象有同步和异步两种方式，建议使用异步获取Palette对象
                        Palette.from(resource).generate(new Palette.PaletteAsyncListener() {
                            @Override
                            public void onGenerated(Palette palette) {
                                if (palette == null) {
                                    return;
                                }
                                //获取到活跃的深色的颜色（可传默认值）
                                if (palette.getDarkVibrantColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    //获取到活跃的深色的颜色（可传默认值）, // 获取图片中最活跃的颜色（也可以说整个图片出现最多的颜色）（可传默认值）
                                    createLinearGradientBitmap(palette.getDarkVibrantColor(Color.TRANSPARENT), palette.getVibrantColor(Color.TRANSPARENT));
                                    //获取到柔和的深色的颜色（可传默认值）
                                } else if (palette.getDarkMutedColor(Color.TRANSPARENT) != Color.TRANSPARENT) {
                                    //获取到柔和的深色的颜色（可传默认值）, 获取图片中一个最柔和的颜色（可传默认值)
                                    createLinearGradientBitmap(palette.getDarkMutedColor(Color.TRANSPARENT), palette.getMutedColor(Color.TRANSPARENT));
                                } else {
                                    //获取到柔和的明亮的颜色（可传默认值）,获取到活跃的明亮的颜色（可传默认值）
                                    createLinearGradientBitmap(palette.getLightMutedColor(Color.TRANSPARENT), palette.getLightVibrantColor(Color.TRANSPARENT));
                                }
                            }
                        });
                        ivMain.setImageBitmap(getImageToChange(resource));
                    }
                });
    }


    //创建线性渐变背景色
    private void createLinearGradientBitmap(int darkColor, int color) {
        int bgColors[] = new int[2];
        bgColors[0] = darkColor;
        bgColors[1] = color;

        Bitmap bgBitmap = Bitmap.createBitmap(ivBg.getWidth(), ivBg.getHeight(), Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas();
        Paint paint = new Paint();
        canvas.setBitmap(bgBitmap);
        canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        LinearGradient gradient = new LinearGradient(0, 0, 0, bgBitmap.getHeight(), bgColors[0], bgColors[1], Shader.TileMode.CLAMP);
        //设置着色器
        paint.setShader(gradient);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0, 0, bgBitmap.getWidth(), bgBitmap.getHeight());
        canvas.drawRoundRect(rectF, 20, 20, paint);
        canvas.drawRect(rectF, paint);
        ivBg.setImageBitmap(bgBitmap);
    }


    //修改透明度
    private static Bitmap getImageToChange(Bitmap mBitmap) {
//        LogUtils.d("with=" + mBitmap.getWidth() + "--height=" + mBitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_4444);
        int mWidth = mBitmap.getWidth();
        int mHeight = mBitmap.getHeight();
        for (int i = 0; i < mHeight; i++) {
            for (int j = 0; j < mWidth; j++) {
                // 返回 像素点上的 颜色
                int color = mBitmap.getPixel(j, i);


                //获取 16进制码
                //表达式顺序是“aabbggrr”，其中“aa=alpha”（00到ff）；“bb=blue”（00到ff）；“gg=green”（00到ff)；“rr=red”（00到ff）
                int g = Color.green(color);
                int r = Color.red(color);
                int b = Color.blue(color);
                int a = Color.alpha(color);

                float index = i * 1.0f / mHeight;
                if (index > 0.5f) {
                    float temp = i - mHeight / 2.0f;
                    a = 255 - (int) (temp / 375 * 255);
                }
                color = Color.argb(a, r, g, b);
                createBitmap.setPixel(j, i, color);
            }
        }
        return createBitmap;
    }
}

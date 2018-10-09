package com.padtast.androidexercise;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.padtast.recyclerviewlibrary.paymentrecord.activity.PaymentRecordActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dsd();
    }
    /**
     *@author zhangshubin
     *@time 2018/9/25
     *@desc
     */
    public void dsd(){
      findViewById(R.id.textivew).setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent view = new Intent(MainActivity.this, PaymentRecordActivity.class);
              startActivity(view);
          }
      });
    }
    private static final String KEY_ = "";
}

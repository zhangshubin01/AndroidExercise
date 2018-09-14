package com.padtast.androidexercise.BroadcastPackage.SDReceiverExercise;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.padtast.androidexercise.R;

public class SdCardTester extends AppCompatActivity {
    BroadcastReceiver mReceiver;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sd_card_tester);

        mReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if(intent.getAction() == Intent.ACTION_MEDIA_MOUNTED){
                    Log.i("ACTION_MEDIA_MOUNTED",Intent.ACTION_MEDIA_MOUNTED);
                }else if(intent.getAction() == Intent.ACTION_MEDIA_UNMOUNTED){
                    Log.i("ACTION_MEDIA_UNMOUNTED",Intent.ACTION_MEDIA_UNMOUNTED);
                }
            }
        };
        Log.i("myLoger","加载完成");
        IntentFilter filter = new IntentFilter();
         ////插入SD卡并且已正确安装（识别）时发出的广播
        //
        ////广播：扩展介质被插入，而且已经被挂载。
        filter.addAction(Intent.ACTION_MEDIA_MOUNTED);
        //ACTION_MEDIA_UNMOUNTED
        //只可以说明 sd 卡没有 mount 在文件系统上面，不可以说明其已经从卡槽移除。
        filter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
        filter.addDataScheme("file");
        registerReceiver(mReceiver, filter);


////        UsbBroadcast usbBroadcast  = new UsbBroadcast();
//        IntentFilter usbFilter= new IntentFilter();
//        usbFilter.addAction(Intent.ACTION_MEDIA_MOUNTED);
//        usbFilter.addAction(Intent.ACTION_MEDIA_REMOVED);
//        usbFilter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
//        usbFilter.addAction(Intent.ACTION_MEDIA_EJECT);
//
////sd卡存在，但还没有挂载
//        usbFilter.addAction(Intent.ACTION_MEDIA_UNMOUNTED);
//
////sd卡被插入，且已经挂载
//        usbFilter.addAction(Intent.ACTION_MEDIA_MOUNTED);
//
////开始扫描
//        usbFilter.addAction(Intent.ACTION_MEDIA_SCANNER_STARTED);
//
////扫描完成
//        usbFilter.addAction(Intent.ACTION_MEDIA_SCANNER_FINISHED);
//
////SD卡移除
//        usbFilter.addAction(Intent.ACTION_MEDIA_REMOVED);
//
//// sd卡作为 USB大容量存储被共享，挂载被解除
//        usbFilter.addAction(Intent.ACTION_MEDIA_SHARED);
//
//// sd卡已经从sd卡插槽拔出，但是挂载点还没解除
//        usbFilter.addAction(Intent.ACTION_MEDIA_BAD_REMOVAL);
//        usbFilter.addDataScheme("file");
//        registerReceiver(mReceiver,usbFilter);

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        unregisterReceiver(mReceiver);
    }
}

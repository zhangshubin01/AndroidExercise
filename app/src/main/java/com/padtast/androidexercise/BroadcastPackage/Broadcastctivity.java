package com.padtast.androidexercise.BroadcastPackage;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.padtast.androidexercise.R;

public class Broadcastctivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcastctivity);

        //解决高版本的android系统 接收不到广播的问题
        //在 sendBroadcast（intent）方法之前，用intent 对象调用一下  setComponent（ new ComponentName（''参数一'',''参数二''））  参数一是你的包名，参数二是你的接收器的路径
        Intent intent =new Intent( "com.example.wenhaibo.androidstudy_broadcast02.MY_BROADCAST" );
        intent.setComponent( new ComponentName( "com.example.wenhaibo.androidstudy_broadcast02" ,
                "com.example.wenhaibo.androidstudy_broadcast02.MyBroadCastReceiver") );
        sendBroadcast( intent );
    }

    /**
     * 动态 广播
     *
     * 广播 接受类
     *
     */
    class  Boots extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {

        }
    }

    /**
     * 本地广播的发送
     * @param context
     * @param action
     */
    public static void sendLocalBroadcast(Context context,String action){

        Intent intent = new Intent(action);
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(context);
        localBroadcastManager.sendBroadcast(intent);

    }

    /**
     *  本地广播的接收器的注册
     */
    private  void  setBroadcast(){
//        IntentFilter intentFilter = new IntentFilter();
//        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(getApplicationContext());
//
//        intentFilter.addAction(new BroadcastUtil().action_next);
//        Boots nasbr = new Boots();
//        //注册本地广播接收器
//        localBroadcastManager.registerReceiver(nasbr, intentFilter);
    }

}

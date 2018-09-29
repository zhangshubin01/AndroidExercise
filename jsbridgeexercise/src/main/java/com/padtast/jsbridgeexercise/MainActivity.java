package com.padtast.jsbridgeexercise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        JsBridge();

    }
    /**
     *@author zhangshubin
     *@time 2018/9/25
     *@desc  JSBridge  使用
     */
    public void JsBridge(){

       BridgeWebView webView = this.findViewById(R.id.bridge_webview);
//        webView.loadUrl("file:///jsbridgeexercise/src/main/assets/jsbridge.html");
       webView.loadUrl("file:///android_asset/jsbridge.html");
        webView.getSettings().setJavaScriptEnabled(true);
//        webView.loadUrl("https://www.baidu.com");
        //提供操作给Js调用submitFromWeb
        webView.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Log.d("JSBridge  使用","调用submitFromWeb");
                function.onCallBack("dssdd");
            }
        });
    }

    public void setBridge() {

    }

    /**
     *
     */
    public void setds(){


    }

//   /**
//    *@author zhangshubin
//    *@time 2018/9/21
//    *@desc
//    */
//   public void (){
//
//   }

}

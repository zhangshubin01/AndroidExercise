package com.padtast.androidexercise.HandlerPackage;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.padtast.androidexercise.R;

import java.lang.ref.WeakReference;

/**
 * @author zhangshubin
 */
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    /**
     * 非静态内部类 有内存泄漏的可能
     * 在java中非静态内部类和匿名内部类都会隐式持有当前类的外部引用，
     * 由于Handler是非静态内部类所以其持有当前Activity的隐式引用，
     * 如果Handler没有被释放，其所持有的外部引用也就是Activity也不可能被释放，
     * 当一个对象一句不需要再使用了，本来该被回收时，
     * 而有另外一个正在使用的对象持有它的引用从而导致它不能被回收，
     * 这导致本该被回收的对象不能被回收而停留在堆内存中，
     * 这就产生了内存泄漏(上面的例子就是这个原因)。最终也就造成了OOM.
     */
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }

        @Override
        public String getMessageName(Message message) {
            return super.getMessageName(message);
        }
    };

    /**
     * 3.Handler内存泄漏解决方法
     * 解决这个问题思路就是使用静态内部类并继承Handler时（或者也可以单独存放成一个类文件）。
     * 因为静态的内部类不会持有外部类的引用，所以不会导致外部类实例的内存泄露。
     * 当你需要在静态内部类中调用外部的Activity时，我们可以使用弱引用来处理。
     * 另外关于同样也需要将Runnable设置为静态的成员属性。
     */
    private static class MyHandler extends Handler{
        //持有弱引用HandlerActivity,GC回收时会被回收掉.
        private final WeakReference<Main2Activity> mActivty;
        public MyHandler(Main2Activity activity){
            mActivty =new WeakReference<Main2Activity>(activity);
        }
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    }
    private static final Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            //执行我们的业务逻辑
        }
    };

}

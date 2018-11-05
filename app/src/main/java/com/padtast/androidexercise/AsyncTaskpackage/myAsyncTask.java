package com.padtast.androidexercise.AsyncTaskpackage;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * @author zhangshubin
 * @time 2018-10-10 15:10
 * @email shubin.zhang@ucarinc.com
 * @tel 3487
 * @desc
 * AsyncTask　<Params, Progress, Result>
 *
 *
 * Params: 这个泛型指定的是我们传递给异步任务执行时的参数的类型
 *
 *
 * Progress: 这个泛型指定的是我们的异步任务在执行的时候将执行的进度返回给UI线程的参数的类型
 *
 *
 * Result: 这个泛型指定的异步任务执行完后返回给UI线程的结果的类型
 * 我们在定义一个类继承AsyncTask类的时候，必须要指定好这三个泛型的类型，如果都不指定的话，则都将其写成Void，例如：
 * AsyncTask <Void, Void, Void>
 *
 *
 */
public class myAsyncTask extends AsyncTask<String,Integer,Bitmap> {
    /**
     *
     * onPreExecute(): 这个方法是在执行异步任务之前的时候执行，并且是在UI Thread当中执行的，通常我们在这个方法里做一些UI控件的初始化的操作，例如弹出要给ProgressDialog
     */
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //这里是在异步操作之前执行，运行在UI线程，一般显示给用户：此时即将要去加载图片了

        //此处将progressBar设置为可见.
        // progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    protected Bitmap doInBackground(java.lang.String... strings) {
        //这里执行耗时操作，此例子中，是网络请求图片的操作
        Bitmap bitmap = null;

        String url = strings[0];//获取加载的图片的url

        //......
        //以上是网络请求图片的代码，并将图片封装到bitmap中

        publishProgress(22);//此方法的调用将会触发onProgressUpdatef方法的调用

        return bitmap;
    }


    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        //此方法运行于UI线程,一般用来更新进度
        //progressBar.setProgress(values[0]);


    }


    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        //此方法中bitmap是doInBackground执行完成后返回的，而且此方法运行在UI线程，更新UI

        //隐藏progressBar
        //progressBar.setVisibility(View.GONE);
        //更新imageView
        //imageView.setImageBitmap(bitmap);

    }

}

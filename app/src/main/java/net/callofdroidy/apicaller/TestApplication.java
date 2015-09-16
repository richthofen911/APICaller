package net.callofdroidy.apicaller;

import android.app.Application;

/**
 * Created by richthofen80 on 9/16/15.
 */
public class TestApplication extends Application {

    public static APICaller apiCaller;
    public static MyRequestQueue mRequestQueue;

    public void onCreate(){
        super.onCreate();
        mRequestQueue = MyRequestQueue.getInstance(this);
        apiCaller = APICaller.getInstance(this, mRequestQueue);
    }

    public MyRequestQueue getMyRequestQueue(){
        return mRequestQueue;
    }

    public APICaller getApiCaller(){
        return apiCaller;
    }
}

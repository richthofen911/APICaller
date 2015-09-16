package net.callofdroidy.apicaller;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by richthofen80 on 9/16/15.
 */
public class MyRequestQueue {
    private static MyRequestQueue mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private MyRequestQueue(Context cxt) {
        mCtx = cxt;
        mRequestQueue = getRequestQueue();
    }

    public static synchronized MyRequestQueue getInstance(Context cxt) {
        if (mInstance == null) {
            mInstance = new MyRequestQueue(cxt);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void add(Request<T> req) {
        getRequestQueue().add(req);
    }

}

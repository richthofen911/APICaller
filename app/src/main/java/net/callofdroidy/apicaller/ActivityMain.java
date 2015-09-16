package net.callofdroidy.apicaller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;

public class ActivityMain extends AppCompatActivity {

    String urlBase = "http://100.64.203.108:7070";
    String urlPath = "/cmd/ls -al";
    APICaller apiCaller;
    MyRequestQueue mRequestQueue;
    private TestApplication testApplication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testApplication = (TestApplication)getApplication();

        apiCaller = testApplication.getApiCaller();
        mRequestQueue = testApplication.getMyRequestQueue();
        apiCaller.setAPI(urlBase, urlPath, null, Request.Method.GET);
        apiCaller.execAPI(new APICaller.VolleyCallback() {
            @Override
            public void onDelivered(String result) {
                ((TextView) findViewById(R.id.tv_display)).setText(result);
                Log.e("response", result);
            }
        });

    }

}

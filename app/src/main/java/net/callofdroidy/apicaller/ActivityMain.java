package net.callofdroidy.apicaller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.Request;

public class ActivityMain extends AppCompatActivity {

    String urlBase = "http://192.168.2.11:8080";
    String urlAction = "/cmd/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        APICaller apiCaller = new APICaller(getApplicationContext());
        apiCaller.setAPI(urlBase, urlAction, null, Request.Method.GET);
        apiCaller.execAPI(new APICaller.VolleyCallback() {
            @Override
            public void onDelivered(String result) {
                Log.e("response", result);
            }
        });

    }

}

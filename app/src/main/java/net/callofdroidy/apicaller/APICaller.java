package net.callofdroidy.apicaller;

import android.content.Context;
import android.os.AsyncTask;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by Tuotuo on 13/09/2015.
 */
public class APICaller {
    private String APIUrl;
    private int requestMethod; //Request.Method.GET is an int
    private StringRequest requestCallAPI;
    private RequestQueue requestQueue;
    private Context context;

    private AsyncTask APIExecuter;

    public APICaller(Context cxt){
        this.context = cxt;
        requestQueue = Volley.newRequestQueue(context);
    }

    public void setAPI(String urlBase, String urlAction, String urlParams, int method){
        if(urlParams == null)
            APIUrl = urlBase + urlAction;
        else
            APIUrl = urlBase + urlAction + urlParams;
        requestMethod = method;
    }

    public interface VolleyCallback{
        void onDelivered(String result);
    }

    public void execAPI(final VolleyCallback callback){
        if(APIUrl == null){
            callback.onDelivered("API has not been set yet");
        }else {
            requestCallAPI = new StringRequest(requestMethod, APIUrl, new Response.Listener<String>(){
                @Override
                public void onResponse(String response){
                    requestCallAPI.markDelivered();
                    callback.onDelivered(response.replace("\\", ""));
                }
            }, new Response.ErrorListener(){
                @Override
                public void onErrorResponse(VolleyError error){
                    requestCallAPI.markDelivered();
                    callback.onDelivered(error.toString());
                }
            });
            requestQueue.add(requestCallAPI);
        }
    }
}

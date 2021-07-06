package com.tpjava2.appjob.utils;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class RequestManager {
    private static com.tpjava2.appjob.utils.RequestManager instance = null;
private Context context;
private RequestQueue requestQueue;
    public RequestManager(Context context) {
        this.context = context;
        this.requestQueue = requestQueue;
    }
    private RequestQueue getRequestQueue() {
        if(requestQueue == null) {
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static com.tpjava2.appjob.utils.RequestManager getInstance(Context context){
        if(instance == null){
            instance = new com.tpjava2.appjob.utils.RequestManager(context);
        }
        return instance;
    }
    public void addToRequestQueue(Request request) {
        getRequestQueue().add(request);
    }


}

package com.tpjava2.appjob.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class StringRequestWithToken extends StringRequest {

    private Context context;

    public StringRequestWithToken(Context context,int method, String url, Response.Listener<String> listener, @Nullable Response.ErrorListener errorListener) {
        super(method, url, listener, errorListener);
        this.context = context;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {

        SharedPreferences preferences = context.getSharedPreferences("MesPreferences",Context.MODE_PRIVATE);
        Map<String, String> params = new HashMap<>();
        String token = preferences.getString("token","");
        params.put("Content-Type","application/json; charset=UTF-8");
        params.put("Authorization","Bearer "+token);
        return params;
    }
}

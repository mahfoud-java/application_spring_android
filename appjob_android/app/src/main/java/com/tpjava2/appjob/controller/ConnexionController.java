package com.tpjava2.appjob.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.tpjava2.appjob.R;
import com.tpjava2.appjob.utils.RequestManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class ConnexionController {
    private static ConnexionController instance = null;

    public ConnexionController() {
    }

    public static ConnexionController getInstance(){
        if(instance == null){
            instance = new ConnexionController();
        }
        return instance;
    }

    public interface SuccessLoginListener {
        void onsuccessLoginListener();
    }

    public void connexion(Context context,String email, String password, SuccessLoginListener listener ) {
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                context.getResources().getString(R.string.url_spring)+"authentification",
                token -> {
                    Toast.makeText(context, token, Toast.LENGTH_LONG).show();
                    SharedPreferences preferences = context.getSharedPreferences("MesPreferences", context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("token",token);
                    editor.apply();
                    listener.onsuccessLoginListener();
                },
                erreur -> {
                    System.out.println("erreur");
                    Toast.makeText(context, erreur.getMessage(), Toast.LENGTH_LONG).show();
                    erreur.printStackTrace();
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("Content-Type","application/json; charset=UTF-8");
                return params;
            }

            @Override
            public byte[] getBody() throws AuthFailureError {
                JSONObject jsonUtilisateur = new JSONObject();
                try {
                    jsonUtilisateur.put("email", email);
                    jsonUtilisateur.put("password", password);
                    return jsonUtilisateur.toString().getBytes(StandardCharsets.UTF_8);
                }catch (JSONException e){
                    e.printStackTrace();
                }
                return null;
            }
        };

        RequestManager.getInstance(context).addToRequestQueue(stringRequest);
        //Toast.makeText(context,pseudo+" "+password,Toast.LENGTH_LONG).show();
    }
}

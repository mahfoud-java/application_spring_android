package com.tpjava2.appjob.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.android.volley.Request;
import com.tpjava2.appjob.R;
import com.tpjava2.appjob.model.Utilisateur;
import com.tpjava2.appjob.utils.JsonObjectRequestWithToken;
import com.tpjava2.appjob.utils.RequestManager;

import org.json.JSONException;

public class UtilisateurController {

    private static UtilisateurController instance = null;

    public UtilisateurController() {
    }

    public static UtilisateurController getInstance(){
        if(instance == null){
            instance = new UtilisateurController();
        }
        return instance;
    }

    public interface UtilisateurConnecteListener{
        void onUtilisateurConnecteListener(Utilisateur utilisateur);
    }

    public void getInformationUtilisateurConnecte(Context context, UtilisateurConnecteListener listener) {
        JsonObjectRequestWithToken request = new JsonObjectRequestWithToken(
                context,
                Request.Method.GET,
                context.getResources().getString(R.string.url_spring)+"user/utilisateur-connecte",
                null,
                jsonUtilisateur -> {
                    try {
                        Utilisateur utilisateur = new Utilisateur(jsonUtilisateur);
                        listener.onUtilisateurConnecteListener(utilisateur);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                erreur -> System.out.println("erreur")
        );
        RequestManager.getInstance(context).addToRequestQueue(request);
    }

}

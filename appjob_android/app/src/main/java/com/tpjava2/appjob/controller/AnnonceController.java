package com.tpjava2.appjob.controller;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.tpjava2.appjob.R;
import com.tpjava2.appjob.model.Annonce;
import com.tpjava2.appjob.model.Utilisateur;
import com.tpjava2.appjob.utils.JsonArrayRequestWithToken;
import com.tpjava2.appjob.utils.JsonObjectRequestWithToken;
import com.tpjava2.appjob.utils.RequestManager;
import com.tpjava2.appjob.utils.StringRequestWithToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class AnnonceController {

    private static AnnonceController instance = null;

    public AnnonceController() {
    }

    public static AnnonceController getInstance(){
        if(instance == null){
            instance = new AnnonceController();
        }
        return instance;
    }

    public interface Save {
        void onSave(String urlNote);
    }

    public interface Delete {
        void onDelete(String urlAnnonce);
    }

    public interface AnnonceListener{
        void onAnnonceListener(List<Annonce> annonces);
    }

    public void getAnnonces(Context context, AnnonceListener listener) {
        JsonArrayRequestWithToken request = new JsonArrayRequestWithToken(
                context,
                Request.Method.GET,
                context.getResources().getString(R.string.url_spring)+"annonces",
                null,
                jsonAnnonces -> {
                    try {
                        List<Annonce> listAnnonce = new ArrayList<>();

                        for (int i = 0; i < jsonAnnonces.length(); i++) {
                            JSONObject jsonAnnonce = jsonAnnonces.getJSONObject(i);

                            listAnnonce.add(new Annonce(jsonAnnonce));
                        }

                        listener.onAnnonceListener(listAnnonce);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                },
                erreur -> {
                    erreur.printStackTrace();
                    System.out.println("erreur");
                }
        );
        RequestManager.getInstance(context).addToRequestQueue(request);
    }

    public void getAnnonce(Context context, AnnonceListener listener) {
        JsonObjectRequestWithToken request = new JsonObjectRequestWithToken(
                context,
                Request.Method.GET,
                context.getResources().getString(R.string.url_spring)+"annonces/1",
                null,
                jsonAnnonce -> {

                    try {
                        Annonce annonce = new Annonce(jsonAnnonce);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                },
                erreur -> {
                    erreur.printStackTrace();
                    System.out.println("erreur");
                }
        );
        RequestManager.getInstance(context).addToRequestQueue(request);
    }

    public void save(Context context, Annonce annonce, Save saveListener) throws JSONException {
        String url = "annonce/add";
        JSONObject jsonBody = annonce.toJson();
        StringRequestWithToken request = new StringRequestWithToken(
                context,
                Request.Method.POST,
                context.getResources().getString(R.string.url_spring) + url,
                urlNote ->{
                    saveListener.onSave(urlNote);
                },
                messageErreur -> {
                    System.out.println("message erreur");
                }
        ){
            @Override
            public byte[] getBody() throws AuthFailureError {

                return jsonBody.toString().getBytes(StandardCharsets.UTF_8);

            }
        };

        RequestManager.getInstance(context).addToRequestQueue(request);

    }

    public void delete(Context context, Annonce annonce, Delete deleteListener) throws JSONException {
        String url = "annonce/delete/"+annonce.getId();
        JSONObject jsonBody = annonce.toJson();
        StringRequestWithToken request = new StringRequestWithToken(
                context,
                Request.Method.DELETE,
                context.getResources().getString(R.string.url_spring) + url,
                urlNote ->{
                    deleteListener.onDelete(urlNote);
                },
                messageErreur -> {
                    System.out.println("message erreur");
                }
        ){
            @Override
            public byte[] getBody() throws AuthFailureError {

                return jsonBody.toString().getBytes(StandardCharsets.UTF_8);

            }
        };

        RequestManager.getInstance(context).addToRequestQueue(request);

    }
}

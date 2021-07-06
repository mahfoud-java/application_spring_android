package com.tpjava2.appjob.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Utilisateur implements Serializable {
    private int id;
    private String email;


    public Utilisateur(JSONObject jsonUtilisateur) throws JSONException {
        id = jsonUtilisateur.getInt("id");
        email = jsonUtilisateur.getString("email");

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

package com.tpjava2.appjob.model;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Diplome implements Serializable {

    private Integer id;

    private String denomination;

    public Diplome(JSONObject object) throws JSONException {
        id = object.getInt("id");
        denomination = object.getString("denomination");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    public JSONObject toJson() throws JSONException {
        JSONObject jsonDiplome = new JSONObject();
        jsonDiplome.put("id",this.getId());
        jsonDiplome.put("denomination",this.getDenomination());


        return jsonDiplome;
    }
}

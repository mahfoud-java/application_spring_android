package com.tpjava2.appjob.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Annonce implements Serializable {
    private Integer id;

    private String intitule;
    private String description;
    private Integer nbPoste;
    private Integer salaire;

    private Diplome diplome;

    public Annonce(JSONObject jsonObject) throws JSONException {
        id = jsonObject.getInt("id");
        intitule = jsonObject.getString("intitule");
        description = jsonObject.getString("descriptifDuPoste");
        nbPoste = jsonObject.getInt("nbPostes");
        salaire = jsonObject.getInt("salaire");


     diplome = new Diplome(jsonObject.getJSONObject("diplome"));
    }

    public Annonce() {

    }


    public JSONObject toJson() throws JSONException {
        JSONObject jsonAnnonce = new JSONObject();
        jsonAnnonce.put("id",this.getId());
        jsonAnnonce.put("intitule",this.getIntitule());
        jsonAnnonce.put("descriptifDuPoste",this.getDescription());
        jsonAnnonce.put("nbPostes", this.getNbPoste());
        jsonAnnonce.put("salaire",this.getSalaire());
        jsonAnnonce.put("diplome",diplome.toJson());

        return jsonAnnonce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public Integer getNbPoste() {
        return nbPoste;
    }

    public void setNbPoste(Integer nbPoste) {
        this.nbPoste = nbPoste;
    }

    public Integer getSalaire() {
        return salaire;
    }

    public void setSalaire(Integer salaire) {
        this.salaire = salaire;
    }
}

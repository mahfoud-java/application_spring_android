package com.tpjava2.appjob.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.appjob.R;
import com.tpjava2.appjob.controller.AnnonceController;
import com.tpjava2.appjob.model.Annonce;
import com.tpjava2.appjob.model.Diplome;

import org.json.JSONException;
import org.json.JSONObject;

public class ModifierAnnonceActivity extends AppCompatActivity {
    private Annonce annonce;
    private EditText intitule;
    private EditText description;
    private EditText nbPoste;
    private EditText salaire;
    private Spinner spinnerModif;
    private BottomAppBar bottomAppBarModif;
    int idDiplome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_annonce);
        annonce = (Annonce) getIntent().getSerializableExtra("annonce");
        intitule = findViewById(R.id.editText_intitule);
        intitule.setText(annonce.getIntitule(), null);

        description = findViewById(R.id.editText_descriptif);
        description.setText(annonce.getDescription(), null);

        nbPoste = findViewById(R.id.editText_n_poste);
        nbPoste.setText(""+annonce.getNbPoste(), null);

        salaire = findViewById(R.id.editText_salaires);
        salaire.setText(""+annonce.getSalaire(), null);

        spinnerModif = findViewById(R.id.spinner_modif);
bottomAppBarModif = findViewById(R.id.bottomAppBar_modif);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.liste_diplome, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinnerModif.setAdapter(adapter);

        spinnerModif.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idDiplome = position + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bottomAppBarModif.setOnMenuItemClickListener(menuItem -> {
            if(menuItem.getItemId() == R.id.menuItem_save){
                annonce.setIntitule(intitule.getText().toString());
                annonce.setDescription(description.getText().toString());
                annonce.setNbPoste(Integer.valueOf(nbPoste.getText().toString()));
                annonce.setSalaire(Integer.valueOf(salaire.getText().toString()));

                try {
                    JSONObject object = new JSONObject();

                    object.put("id", idDiplome);
                    object.put("denomination", "");
                    Diplome diplome = new Diplome(object);

                    annonce.setDiplome(diplome);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                try {
                    AnnonceController.getInstance().save(this,
                            annonce,
                            urlNote -> {
                                Intent intent = new Intent(
                                        this,
                                        OffreActivity.class
                                );
                                startActivity(intent);

                            }


                    );
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                return  true;
            }






            return false;});
      /*  validerModif.setOnClickListener(v -> {


            annonce.setIntitule(intitule.getText().toString());
            annonce.setDescription(description.getText().toString());
            annonce.setNbPoste(Integer.valueOf(nbPoste.getText().toString()));
            annonce.setSalaire(Integer.valueOf(salaire.getText().toString()));

            try {
                JSONObject object = new JSONObject();

                object.put("id", idDiplome);
                object.put("denomination", "");
                Diplome diplome = new Diplome(object);

                annonce.setDiplome(diplome);
            } catch (JSONException e) {
                e.printStackTrace();
            }


            try {
                AnnonceController.getInstance().save(this,
                        annonce,
                        urlNote -> {
                            Intent intent = new Intent(
                                    this,
                                    OffreActivity.class
                            );
                            startActivity(intent);

                        }


                );
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });*/

    }
}
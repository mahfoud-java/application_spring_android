package com.tpjava2.appjob.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.appjob.R;
import com.tpjava2.appjob.controller.AnnonceController;
import com.tpjava2.appjob.model.Annonce;
import com.tpjava2.appjob.model.Diplome;

import org.json.JSONException;
import org.json.JSONObject;

public class AjouterAnnonceActivity extends AppCompatActivity {
    private Button buttonValider;

    private EditText editTextIntitule;
    private EditText editTextDescription;;
    private EditText editTextNbPoste;
    private EditText editTextSalaire;
    private EditText editTextDiplome;
    int idDiplome;
    private BottomAppBar bottomAppBarAjouter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_annonce);
        init();
    }

    private void init() {
        buttonValider = findViewById(R.id.button_valider);

        editTextIntitule = findViewById(R.id.editText_intitule_poste);
        editTextDescription = findViewById(R.id.editText_descriptif_poste);
        editTextNbPoste = findViewById(R.id.editText_nb_poste);
        editTextSalaire = findViewById(R.id.editText_salaire);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        bottomAppBarAjouter = findViewById(R.id.bottomAppBar_ajouter);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.liste_diplome, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

      spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                            @Override
                                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                idDiplome = position + 1;
                                            }

                                            @Override
                                            public void onNothingSelected(AdapterView<?> parent) {

                                            }
                                        });
        bottomAppBarAjouter.setOnMenuItemClickListener(menuItem -> {
            if(menuItem.getItemId() == R.id.menuItem_save){
                Annonce annonce = new Annonce();


                annonce.setIntitule(editTextIntitule.getText().toString());
                annonce.setDescription(editTextDescription.getText().toString());
                annonce.setNbPoste(Integer.valueOf(editTextNbPoste.getText().toString()));
                annonce.setSalaire(Integer.valueOf(editTextSalaire.getText().toString()));

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
           /*   buttonValider.setOnClickListener(v -> {

                  Annonce annonce = new Annonce();


                  annonce.setIntitule(editTextIntitule.getText().toString());
                  annonce.setDescription(editTextDescription.getText().toString());
                  annonce.setNbPoste(Integer.valueOf(editTextNbPoste.getText().toString()));
                  annonce.setSalaire(Integer.valueOf(editTextSalaire.getText().toString()));

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
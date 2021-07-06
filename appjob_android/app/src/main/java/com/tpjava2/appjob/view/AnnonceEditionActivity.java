package com.tpjava2.appjob.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.tpjava2.appjob.R;
import com.tpjava2.appjob.controller.AnnonceController;
import com.tpjava2.appjob.model.Annonce;

import org.json.JSONException;

public class AnnonceEditionActivity extends AppCompatActivity {

    private Annonce annonce;
    private TextView textViewDescriptionAnnonce;
    private TextView textViewIntituleAnnonce;
    private TextView textViewSalaireAnnonce;
    private TextView textViewNbPosteAnnonce;
    private TextView textViewDiplomeAnnonce;
    private Button delete;
    BottomAppBar bottomAppBar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonce_edition);
        init();
    }

    private void init() {
        textViewDescriptionAnnonce = findViewById(R.id.textView_description_annonce);
        textViewIntituleAnnonce = findViewById(R.id.textView_intitule_annonce);
        textViewSalaireAnnonce = findViewById(R.id.textView_salaire_annonce);
        textViewNbPosteAnnonce = findViewById(R.id.textView_nb_poste_annonce);
        textViewDiplomeAnnonce = findViewById(R.id.textView_diplome_annonce);
        bottomAppBar2 = findViewById(R.id.bottomAppBar2);
        annonce = (Annonce) getIntent().getSerializableExtra("annonce");

        bottomAppBar2.setOnMenuItemClickListener(menuItem -> {
            if(menuItem.getItemId() == R.id.menuItem_save){
                try {
                    AnnonceController.getInstance().delete(this,
                            annonce,
                            urlNote -> {
                                Intent intent = new Intent(
                                        this,
                                        OffreActivity.class
                                );
                                startActivity(intent);

                            });
                }catch (JSONException e) {
                    e.printStackTrace();
                }
                return  true;
            }
            if(menuItem.getItemId() == R.id.menuItem_modifier) {

                Intent intent = new Intent(
                        this,
                        ModifierAnnonceActivity.class
                );
                intent.putExtra("annonce",annonce);
                startActivity(intent);



                return  true;
            }





            return false;});






        textViewDescriptionAnnonce.setText(annonce.getDescription());
        textViewIntituleAnnonce.setText(annonce.getIntitule()+" H/F");
        textViewSalaireAnnonce.setText("Salaire du poste : "+String.valueOf(annonce.getSalaire())+" $");
        textViewNbPosteAnnonce.setText("Nombre de postes à pourvoir : "+String.valueOf(annonce.getNbPoste()));
        textViewDiplomeAnnonce.setText("Niveau exigé pour le poste : "+annonce.getDiplome().getDenomination());
    }
}
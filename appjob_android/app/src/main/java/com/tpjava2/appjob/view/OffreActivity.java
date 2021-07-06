package com.tpjava2.appjob.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.tpjava2.appjob.R;
import com.tpjava2.appjob.controller.AnnonceController;
import com.tpjava2.appjob.model.Annonce;
import com.tpjava2.appjob.view.adapter.ListeAnnoncesAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class OffreActivity extends AppCompatActivity {

    RecyclerView recyclerViewAnnonces;
   TextView email;
    FloatingActionButton floatingActionButtonAjouterAnnonce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annonces);

        init();
    }

    private void init() {

        recyclerViewAnnonces = findViewById(R.id.recyclerView_listeAnnonces);
        recyclerViewAnnonces.setLayoutManager(new LinearLayoutManager(this));
        this.floatingActionButtonAjouterAnnonce = findViewById(R.id.floatingActionButton_ajouter_annonce);
email = findViewById(R.id.textView_email_user);
email.setText((String) getIntent().getSerializableExtra("email"));


        AnnonceController.getInstance().getAnnonces(this,
                listeAnnonce -> {

                    recyclerViewAnnonces.setAdapter(new ListeAnnoncesAdapter(listeAnnonce, v -> {
                        Intent intent = new Intent(
                                this,
                                AnnonceEditionActivity.class

                        );
                        intent.putExtra("annonce",v);

                        startActivity(intent);
                    }));
                }
        );

        floatingActionButtonAjouterAnnonce.setOnClickListener(v -> {


                            Intent intent =new Intent(
                                    this,
                                    AjouterAnnonceActivity.class
                            );
                            startActivity(intent);




        });






    }
}
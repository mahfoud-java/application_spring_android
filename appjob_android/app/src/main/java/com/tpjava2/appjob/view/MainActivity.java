package com.tpjava2.appjob.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tpjava2.appjob.R;
import com.tpjava2.appjob.controller.ConnexionController;
import com.tpjava2.appjob.controller.UtilisateurController;

public class MainActivity extends AppCompatActivity {


    private EditText textEmail;
    private EditText textPassword;
    private Button buttonConnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        this.textEmail = findViewById(R.id.text_email);
        this.textPassword = findViewById(R.id.text_password);
        this.buttonConnexion = findViewById(R.id.button_connexion);

        this.buttonConnexion.setOnClickListener((View v) -> ConnexionController.getInstance()
                .connexion(this,textEmail.getText().toString(),textPassword.getText().toString(),
                        () -> {
                    Intent intent = new Intent(this,OffreActivity.class);

                            startActivity(intent);
                        }));
    }



}
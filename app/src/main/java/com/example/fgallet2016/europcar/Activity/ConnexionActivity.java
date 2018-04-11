package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.fgallet2016.europcar.DAO.UtilisateurDAO;
import com.example.fgallet2016.europcar.Fragment.ConnexionFragment;
import com.example.fgallet2016.europcar.Model.Utilisateur;
import com.example.fgallet2016.europcar.R;

public class ConnexionActivity extends AppCompatActivity implements ConnexionFragment.OnFragmentInteractionListener{

    private EditText emailUser;
    private EditText motDePasse;
    private EditText token;

    private UtilisateurDAO utilisateurDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


    }

    @Override
    public void seConnecter() {
        emailUser = findViewById(R.id.adresse_mail);
        motDePasse = findViewById(R.id.mot_de_passe);
        token = findViewById(R.id.token);

        Utilisateur utilisateur = new Utilisateur();

        //utilisateur = utilisateurDAO.findUser(emailUser.getText().toString(), motDePasse.getText().toString(), token.getText().toString());


        if (emailUser.getText().toString().equals("a")
                && motDePasse.getText().toString().equals("a")
                && token.getText().toString().equals("a")){

            Intent intent = new Intent(ConnexionActivity.this, ListeReservationActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(ConnexionActivity.this,"L'email, le mot de passe ou le token ne sont pas corrects",
                    Toast.LENGTH_SHORT).show();
        }


    }

}

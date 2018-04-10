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

import com.example.fgallet2016.europcar.Fragment.ConnexionFragment;
import com.example.fgallet2016.europcar.Model.Utilisateur;
import com.example.fgallet2016.europcar.R;

public class ConnexionActivity extends AppCompatActivity implements ConnexionFragment.OnFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);


    }

    @Override
    public void seConnecter() {
        ConnexionTask task = new ConnexionTask();
        task.execute();
    }


    public class ConnexionTask extends AsyncTask<Utilisateur, Integer, Boolean> {
        @Override
        protected Boolean doInBackground(Utilisateur... utilisateurs) {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                    publishProgress(i, 10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            SharedPreferences sharedPreferences =
                    getSharedPreferences("user", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();

            EditText emailUser = findViewById(R.id.adresse_mail);
            EditText motDePasse = findViewById(R.id.mot_de_passe);
            EditText token = findViewById(R.id.token);


            return true;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            /*Intent intent = new Intent(ConnexionActivity.this, );
            startActivity(intent);*/
        }
    }
}

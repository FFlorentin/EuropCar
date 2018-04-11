package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fgallet2016.europcar.Fragment.InscriptionFragment;
import com.example.fgallet2016.europcar.Model.Utilisateur;
import com.example.fgallet2016.europcar.R;

public class InscriptionActivity extends AppCompatActivity implements InscriptionFragment.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
    }

    @Override
    public void ajoutInscrit() {
        Intent intent = new Intent(InscriptionActivity.this, ModifAgenceActivity.class);
        intent.putExtra("user",
                new Utilisateur(
                        1,
                        "zef@gmail.com",
                        "sdoks"));
        startActivity(intent);
    }
}

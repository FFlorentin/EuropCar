package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fgallet2016.europcar.R;

import org.w3c.dom.Text;

public class LocationVehiculeActivity extends AppCompatActivity {

    private TextView raison_social;
    private TextView siret;
    private TextView voie;
    private TextView code_postal;
    private TextView ville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_vehicule);

        Intent intent = getIntent();

        raison_social = findViewById(R.id.raison_social);
        raison_social.setText(intent.getStringExtra("raison_social"));

        siret = findViewById(R.id.siret);
        siret.setText(intent.getStringExtra("siret"));

        voie = findViewById(R.id.voie);
        voie.setText(intent.getStringExtra("voie"));

        code_postal = findViewById(R.id.code_postal);
        code_postal.setText(intent.getStringExtra("code_postal"));

        ville = findViewById(R.id.ville);
        ville.setText(intent.getStringExtra("ville"));

    }
}

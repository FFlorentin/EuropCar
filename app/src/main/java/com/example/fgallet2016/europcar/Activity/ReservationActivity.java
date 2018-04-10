package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.fgallet2016.europcar.Model.Vehicule;
import com.example.fgallet2016.europcar.R;

import java.util.List;

public class ReservationActivity extends AppCompatActivity {

    private TextView idVehicule;
    private TextView libelle;
    private TextView locationMin;
    private TextView locationMax;
    private TextView tarifMin;
    private TextView tarifMax;
    private TextView nbPlace;

    private Vehicule vehicules;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
    }

    @Override
    protected void onResume() {
        super.onResume();



        Intent intent = getIntent();
        int id = intent.getIntExtra("id_vehicule",0);

        // Appel du service pour récupérer le véhicule
        Vehicule vehicule = this.vehicules.getVehiculeById(id);

        idVehicule = findViewById(R.id.id_vehicule);
        libelle = findViewById(R.id.libelle);
        locationMin = findViewById(R.id.location_min);
        locationMax = findViewById(R.id.location_max);
        tarifMin = findViewById(R.id.tarif_min);
        tarifMax = findViewById(R.id.tarif_max);
        nbPlace = findViewById(R.id.nb_place);

        idVehicule.setText(String.valueOf(vehicule.getVehiculeID()));
        libelle.setText(vehicule.getLibelle());
        locationMin.setText(String.valueOf(vehicule.getLocationMin()));
        locationMax.setText(String.valueOf(vehicule.getLocationMax()));
        tarifMin.setText(String.valueOf(vehicule.getTarifMin()));
        tarifMax.setText(String.valueOf(vehicule.getTarifMax()));
        nbPlace.setText(String.valueOf(vehicule.getNbPlaces()));


    }
}

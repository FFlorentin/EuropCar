package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.fgallet2016.europcar.Fragment.ListeReservationFragment;
import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.R;

import java.util.ArrayList;
import java.util.List;

public class ListeReservationActivity extends AppCompatActivity {

    private ImageButton bouton_liste_vehicule;

    private ListeReservationFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_reservation);
    }

    @Override
    protected void onResume() {
        super.onResume();

        fragment = (ListeReservationFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_liste_resultat);

        List<Reservation> reservations = new ArrayList<>();
        reservations.add(new Reservation("Audi A3","01-06-2015","09-06-2015","15€"));
        reservations.add(new Reservation("Porche Cayenne","02-04-2012","18-06-2012","30€"));
        reservations.add(new Reservation("Fiat Panda","09-12-2017","15-12-2017","0.50€"));
        reservations.add(new Reservation("Opel Insigna","22-09-2002","26-09-2002","10€"));
        reservations.add(new Reservation("Renault Scénic","18-11-2014","19-11-2014","5€"));
        reservations.add(new Reservation("Citroen C3","19-11-2015","19-11-2016","6€"));

        fragment.setListe(reservations);

        bouton_liste_vehicule = findViewById(R.id.bouton_liste_vehicule);

        bouton_liste_vehicule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListeReservationActivity.this, ListeVehiculeActivity.class);
                startActivity(intent);
            }
        });



    }
}

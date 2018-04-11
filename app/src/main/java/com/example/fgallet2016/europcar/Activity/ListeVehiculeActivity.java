package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fgallet2016.europcar.Fragment.ListeReservationFragment;
import com.example.fgallet2016.europcar.Fragment.ListeVehiculeFragment;
import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.Model.Vehicule;
import com.example.fgallet2016.europcar.R;

import java.util.ArrayList;
import java.util.List;

public class ListeVehiculeActivity extends AppCompatActivity {

    private ListeVehiculeFragment fragment;

    private ListView liste_vehicule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_vehicule);
    }

    @Override
    protected void onResume() {
        super.onResume();

        fragment = (ListeVehiculeFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_liste_vehicule);

        final List<Vehicule> vehicules = new ArrayList<>();
        vehicules.add(new Vehicule("1","Audi A3",5,5,5,1,0));
        vehicules.add(new Vehicule("2","Porche Cayenne",5,2,6,200,15));
        vehicules.add(new Vehicule("3","Fiat Panda",5,1,3,56,1));
        vehicules.add(new Vehicule("4","Opel Insigna",3,1,6,2,1));
        vehicules.add(new Vehicule("5","Renault Scénic",2,5,856,6,2));
        vehicules.add(new Vehicule("6","Citroen C3",3,5,1,51,6));

        fragment.setListe(vehicules);

        liste_vehicule = findViewById(R.id.liste_vehicule);

        liste_vehicule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListeVehiculeActivity.this, ReservationActivity.class);
                intent.putExtra("id_vehicule", vehicules.get(i).getId());
                startActivity(intent);

            }
        });

    }
}


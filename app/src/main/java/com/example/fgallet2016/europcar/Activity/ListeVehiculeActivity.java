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
import com.example.fgallet2016.europcar.Service.VehiculeService;

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


        VehiculeService service = new VehiculeService();

        final List<Vehicule> vehicules = service.generateTestSet();

        fragment.setListe(vehicules);

        liste_vehicule = findViewById(R.id.liste_vehicule);

        liste_vehicule.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListeVehiculeActivity.this, ReservationActivity.class);
                intent.putExtra("id_vehicule", vehicules.get(i).getId());
                intent.putExtra("libelle", vehicules.get(i).getLibelle());
                intent.putExtra("location_min", vehicules.get(i).getLocationMin());
                intent.putExtra("location_max", vehicules.get(i).getLocationMax());
                intent.putExtra("tarif_min", vehicules.get(i).getTarifMin());
                intent.putExtra("tarif_max", vehicules.get(i).getTarifMax());
                intent.putExtra("nb_place", vehicules.get(i).getNbPlaces());

                startActivity(intent);

            }
        });

    }
}


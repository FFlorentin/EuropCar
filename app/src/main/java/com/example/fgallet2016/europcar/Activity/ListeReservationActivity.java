package com.example.fgallet2016.europcar.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.fgallet2016.europcar.Adapter.ReservationAdapter;
import com.example.fgallet2016.europcar.Adapter.VehiculeAdapter;
import com.example.fgallet2016.europcar.Fragment.ListeReservationFragment;
import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.R;
import com.example.fgallet2016.europcar.Service.ReservationService;

import java.util.ArrayList;
import java.util.List;

public class ListeReservationActivity extends AppCompatActivity {

    private ImageButton bouton_liste_vehicule;
    private ListView listReservation;

    private ReservationAdapter reservationAdapter;

    private ListeReservationFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_reservation);

        listReservation = findViewById(R.id.liste_reservation);

        listReservation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Reservation reservation = (Reservation) reservationAdapter.getItem(position);
                Intent intent = new Intent(ListeReservationActivity.this, RetourActivity.class);
                intent.putExtra("id", reservation.getId());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ReservationService service = new ReservationService();

        reservationAdapter = new ReservationAdapter(this, R.layout.ligne_reservation, service.getList());

        listReservation.setAdapter(reservationAdapter);

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

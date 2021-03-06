package com.example.fgallet2016.europcar.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fgallet2016.europcar.Adapter.ReservationAdapter;
import com.example.fgallet2016.europcar.Adapter.VehiculeAdapter;
import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.Model.Vehicule;
import com.example.fgallet2016.europcar.R;

import java.util.List;

public class ListeVehiculeFragment extends Fragment {

    public ListeVehiculeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste_vehicule, container, false);
    }

    public void setListe(List<Vehicule> vehicules){

        ListView listeResultats = this.getView().findViewById(R.id.liste_vehicule);

        ArrayAdapter adapter = new VehiculeAdapter(
                this.getContext(),
                R.layout.ligne_vehicule,
                vehicules);

        listeResultats.setAdapter(adapter);



    }
}

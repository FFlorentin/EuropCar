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
import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.R;

import java.util.List;

public class ListeReservationFragment extends Fragment {

    public ListeReservationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_liste_reservation, container, false);
    }

    public void setListe(List<Reservation> reservations){

        ListView listeResultats = this.getView().findViewById(R.id.liste_reservation);

        ArrayAdapter adapter = new ReservationAdapter(
                this.getContext(),
                R.layout.ligne_reservation,
                reservations);

        listeResultats.setAdapter(adapter);



    }
}

package com.example.fgallet2016.europcar.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.R;

import java.util.List;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class ReservationAdapter extends ArrayAdapter<Reservation> {


    private Context context;
    private int layout;
    private List<Reservation> reservations;

    private TextView vehicule;
    private TextView dateDebut;
    private TextView dateFin;
    private TextView tarifJournalier;

    public ReservationAdapter(@NonNull Context context, int resource, @NonNull List<Reservation> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.reservations = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layout, parent, false);
        }

        Reservation reservation = this.getItem(position);

        vehicule = convertView.findViewById(R.id.vehicule_id);
        dateDebut = convertView.findViewById(R.id.date_debut);
        dateFin = convertView.findViewById(R.id.date_fin);
        tarifJournalier = convertView.findViewById(R.id.tarif_journalier);

        vehicule.setText(reservation.getVehicule());
        dateDebut.setText(reservation.getDateDebut());
        dateFin.setText(reservation.getDateFin());
        tarifJournalier.setText(reservation.getTarifJournalier());

        return convertView;


    }
}

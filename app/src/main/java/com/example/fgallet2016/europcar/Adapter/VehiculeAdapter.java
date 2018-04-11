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
import com.example.fgallet2016.europcar.Model.Vehicule;
import com.example.fgallet2016.europcar.R;

import java.util.List;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class VehiculeAdapter extends ArrayAdapter<Vehicule> {


    private Context context;
    private int layout;
    private List<Vehicule> vehicules;

    private TextView idVehicule;
    private TextView libelle;
    private TextView locationMin;
    private TextView locationMax;
    private TextView tarifMin;
    private TextView tarifMax;
    private TextView nbPlace;

    public VehiculeAdapter(@NonNull Context context, int resource, @NonNull List<Vehicule> objects) {
        super(context, resource, objects);
        this.context = context;
        this.layout = resource;
        this.vehicules = objects;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(this.layout, parent, false);
        }

        Vehicule vehicule = this.vehicules.get(position);

        idVehicule = convertView.findViewById(R.id.id_vehicule);
        libelle = convertView.findViewById(R.id.libelle);
        locationMin = convertView.findViewById(R.id.location_min);
        locationMax = convertView.findViewById(R.id.location_max);
        tarifMin = convertView.findViewById(R.id.tarif_min);
        tarifMax = convertView.findViewById(R.id.tarif_max);
        nbPlace = convertView.findViewById(R.id.nb_place);

        idVehicule.setText(String.valueOf(vehicule.getId()));
        libelle.setText(vehicule.getLibelle());
        locationMin.setText(String.valueOf(vehicule.getLocationMin()));
        locationMax.setText(String.valueOf(vehicule.getLocationMax()));
        tarifMin.setText(String.valueOf(vehicule.getTarifMin()));
        tarifMax.setText(String.valueOf(vehicule.getTarifMax()));
        nbPlace.setText(String.valueOf(vehicule.getNbPlaces()));

        return convertView;


    }
}

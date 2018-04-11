package com.example.fgallet2016.europcar.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.fgallet2016.europcar.Model.Vehicule;

import java.util.List;

public class VehiculeService {

    private List<Vehicule> vehicules;

    public VehiculeService() {
    }


    public Vehicule getVehiculeById(int id) {
        for (Vehicule vehicule : this.vehicules) {
            if (vehicule.getId().equals(id)) {
                return vehicule;
            }
        }
        return null;
    }

}

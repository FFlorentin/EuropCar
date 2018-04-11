package com.example.fgallet2016.europcar.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.fgallet2016.europcar.Model.Vehicule;

import java.util.ArrayList;
import java.util.List;

public class VehiculeService {

    private static final VehiculeService ourInstance = new VehiculeService();
    private List<Vehicule> vehicules;

    public static VehiculeService getInstance() {
        return ourInstance;
    }

    public VehiculeService() {
        this.vehicules = new ArrayList<>();
        this.generateTestSet();
    }

    public List<Vehicule> getList() {
        return this.vehicules;
    }

    public Vehicule getVehiculeById(String id) {
        for (Vehicule vehicule : this.vehicules) {
            if (vehicule.getId() == id) {
                return vehicule;
            }
        }
        return null;
    }

    public void add(Vehicule vehicule) {
        this.vehicules.add(vehicule);
    }

    public void delete(String id) {
        for (Vehicule vehicule : this.vehicules) {
            if (vehicule.getId() == id) {
                this.vehicules.remove(vehicule);
                return;
            }
        }
    }

    public List<Vehicule> generateTestSet() {
        if (this.vehicules.isEmpty()) {
            this.vehicules.add(new Vehicule("1","Audi A3",5,5,5,1,0));
            this.vehicules.add(new Vehicule("2","Porche Cayenne",5,2,6,200,15));
            this.vehicules.add(new Vehicule("3","Fiat Panda",5,1,3,56,1));
            this.vehicules.add(new Vehicule("4","Opel Insigna",3,1,6,2,1));
            this.vehicules.add(new Vehicule("5","Renault Scénic",2,5,856,6,2));
            this.vehicules.add(new Vehicule("6","Citroen C3",3,5,1,51,6));
        }

        return vehicules;
    }

}

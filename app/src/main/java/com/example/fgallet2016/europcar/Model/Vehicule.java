package com.example.fgallet2016.europcar.Model;

import java.util.List;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class Vehicule {

    private int vehiculeID;
    private String libelle;
    private int nbPlaces;
    private int locationMin;
    private int locationMax;
    private int tarifMax;
    private int tarifMin;
    private List<Vehicule> vehicules;

    public List<Vehicule> getList() {
        return this.vehicules;
    }

    public Vehicule getVehiculeById(int id) {
        for (Vehicule vehicule : this.vehicules) {
            if (vehicule.getVehiculeID() == id) {
                return vehicule;
            }
        }
        return null;
    }

    public Vehicule(int vehiculeID, String libelle, int nbPlaces, int locationMin, int locationMax, int tarifMax, int tarifMin) {
        this.vehiculeID = vehiculeID;
        this.libelle = libelle;
        this.nbPlaces = nbPlaces;
        this.locationMin = locationMin;
        this.locationMax = locationMax;
        this.tarifMax = tarifMax;
        this.tarifMin = tarifMin;
    }

    public Vehicule(String libelle, int nbPlaces, int locationMin, int locationMax, int tarifMax, int tarifMin) {
        this.libelle = libelle;
        this.nbPlaces = nbPlaces;
        this.locationMin = locationMin;
        this.locationMax = locationMax;
        this.tarifMax = tarifMax;
        this.tarifMin = tarifMin;
    }

    public Vehicule() {

    }

    public int getVehiculeID() {
        return vehiculeID;
    }

    public void setVehiculeID(int vehiculeID) {
        this.vehiculeID = vehiculeID;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(int nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public int getLocationMin() {
        return locationMin;
    }

    public void setLocationMin(int locationMin) {
        this.locationMin = locationMin;
    }

    public int getLocationMax() {
        return locationMax;
    }

    public void setLocationMax(int locationMax) {
        this.locationMax = locationMax;
    }

    public int getTarifMax() {
        return tarifMax;
    }

    public void setTarifMax(int tarifMax) {
        this.tarifMax = tarifMax;
    }

    public int getTarifMin() {
        return tarifMin;
    }

    public void setTarifMin(int tarifMin) {
        this.tarifMin = tarifMin;
    }
}

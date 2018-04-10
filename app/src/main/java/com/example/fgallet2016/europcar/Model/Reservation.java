package com.example.fgallet2016.europcar.Model;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class Reservation {

   private String vehicule;
   private String dateDebut;
   private String dateFin;
   private String tarifJournalier;

    public Reservation(String vehicule, String dateDebut, String dateFin, String tarifJournalier) {
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tarifJournalier = tarifJournalier;
    }

    public Reservation() {

    }

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public String getTarifJournalier() {
        return tarifJournalier;
    }

    public void setTarifJournalier(String tarifJournalier) {
        this.tarifJournalier = tarifJournalier;
    }
}

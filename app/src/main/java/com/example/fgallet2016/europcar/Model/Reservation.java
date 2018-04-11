package com.example.fgallet2016.europcar.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class Reservation implements Parcelable{

    private String id;
    private String vehicule;
    private String dateDebut;
    private String dateFin;
    private String tarifJournalier;

    public Reservation(String id, String vehicule, String dateDebut, String dateFin, String tarifJournalier) {
        this.id= id;
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tarifJournalier = tarifJournalier;
    }

    public Reservation(String vehicule, String dateDebut, String dateFin, String tarifJournalier) {
        this.vehicule = vehicule;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.tarifJournalier = tarifJournalier;
    }

    public Reservation() {

    }

    protected Reservation(Parcel in) {
        id = in.readString();
        vehicule = in.readString();
        dateDebut = in.readString();
        dateFin = in.readString();
        tarifJournalier = in.readString();
    }

    public static final Creator<Reservation> CREATOR = new Creator<Reservation>() {
        @Override
        public Reservation createFromParcel(Parcel in) {
            return new Reservation(in);
        }

        @Override
        public Reservation[] newArray(int size) {
            return new Reservation[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(vehicule);
        dest.writeString(dateDebut);
        dest.writeString(dateFin);
        dest.writeString(tarifJournalier);
    }
}

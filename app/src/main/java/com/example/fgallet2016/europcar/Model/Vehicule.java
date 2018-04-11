package com.example.fgallet2016.europcar.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class Vehicule implements Parcelable{
    private String id;
    private Integer nbPlaces;
    private Integer locationMin;
    private Integer locationMax;
    private float tarifMin;
    private float tarifMax;
    private float tarifMoyen;
    private boolean isDisponible;
    private String libelle;

    public Vehicule() {
    }

    public Vehicule(String id, Integer nbPlaces, Integer locationMin, Integer locationMax,
                    float tarifMin, float tarifMax, float tarifMoyen,
                    boolean isDisponible, String libelle) {
        this.id = id;
        this.nbPlaces = nbPlaces;
        this.locationMin = locationMin;
        this.locationMax = locationMax;
        this.tarifMin = tarifMin;
        this.tarifMax = tarifMax;
        this.tarifMoyen = tarifMoyen;
        this.isDisponible = isDisponible;
        this.libelle = libelle;
    }

    public Vehicule(String id, String libelle, Integer nbPlaces, Integer locationMin, Integer locationMax,
                    float tarifMin, float tarifMax) {
        this.id = id;
        this.nbPlaces = nbPlaces;
        this.locationMin = locationMin;
        this.locationMax = locationMax;
        this.tarifMin = tarifMin;
        this.tarifMax = tarifMax;
        this.libelle = libelle;
    }

    protected Vehicule(Parcel in) {
        id = in.readString();
        if (in.readByte() == 0) {
            nbPlaces = null;
        } else {
            nbPlaces = in.readInt();
        }
        if (in.readByte() == 0) {
            locationMin = null;
        } else {
            locationMin = in.readInt();
        }
        if (in.readByte() == 0) {
            locationMax = null;
        } else {
            locationMax = in.readInt();
        }
        tarifMin = in.readFloat();
        tarifMax = in.readFloat();
        tarifMoyen = in.readFloat();
        isDisponible = in.readByte() != 0;
        libelle = in.readString();
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getNbPlaces() {
        return nbPlaces;
    }

    public void setNbPlaces(Integer nbPlaces) {
        this.nbPlaces = nbPlaces;
    }

    public Integer getLocationMin() {
        return locationMin;
    }

    public void setLocationMin(Integer locationMin) {
        this.locationMin = locationMin;
    }

    public Integer getLocationMax() {
        return locationMax;
    }

    public void setLocationMax(Integer locationMax) {
        this.locationMax = locationMax;
    }

    public float getTarifMin() {
        return tarifMin;
    }

    public void setTarifMin(float tarifMin) {
        this.tarifMin = tarifMin;
    }

    public float getTarifMax() {
        return tarifMax;
    }

    public void setTarifMax(float tarifMax) {
        this.tarifMax = tarifMax;
    }

    public float getTarifMoyen() {
        return tarifMoyen;
    }

    public void setTarifMoyen(float tarifMoyen) {
        this.tarifMoyen = tarifMoyen;
    }

    public boolean isDisponible() {
        return isDisponible;
    }

    public void setDisponible(boolean disponible) {
        isDisponible = disponible;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        if (nbPlaces == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(nbPlaces);
        }
        if (locationMin == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(locationMin);
        }
        if (locationMax == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(locationMax);
        }
        dest.writeFloat(tarifMin);
        dest.writeFloat(tarifMax);
        dest.writeFloat(tarifMoyen);
        dest.writeByte((byte) (isDisponible ? 1 : 0));
        dest.writeString(libelle);
    }
}

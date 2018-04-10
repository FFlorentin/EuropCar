package com.example.fgallet2016.europcar.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class Agence implements Parcelable{
    private String id;
    private String raisonSociale;
    private String siret;
    private String voie;
    private String codePostal;
    private String ville;

    public Agence() {
    }


    public Agence(String id, String raisonSociale, String siret, String voie, String codePostal, String ville) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.siret = siret;
        this.voie = voie;
        this.codePostal = codePostal;
        this.ville = ville;
    }


    protected Agence(Parcel in) {
        id = in.readString();
        raisonSociale = in.readString();
        siret = in.readString();
        voie = in.readString();
        codePostal = in.readString();
        ville = in.readString();
    }

    public static final Creator<Agence> CREATOR = new Creator<Agence>() {
        @Override
        public Agence createFromParcel(Parcel in) {
            return new Agence(in);
        }

        @Override
        public Agence[] newArray(int size) {
            return new Agence[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getSiret() {
        return siret;
    }

    public void setSiret(String siret) {
        this.siret = siret;
    }

    public String getVoie() {
        return voie;
    }

    public void setVoie(String voie) {
        this.voie = voie;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id='" + id + '\'' +
                ", raisonSociale='" + raisonSociale + '\'' +
                ", siret='" + siret + '\'' +
                ", voie='" + voie + '\'' +
                ", codePostal='" + codePostal + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(raisonSociale);
        dest.writeString(siret);
        dest.writeString(voie);
        dest.writeString(codePostal);
        dest.writeString(ville);
    }
}

package com.example.fgallet2016.europcar.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrateur on 11/04/2018.
 */

public class Retour implements Parcelable{
    private String id;
    private String reservationId;
    private boolean isEndommage;
    private boolean isPleinEffectue;
    private Integer nbKmEffectues;
    private String photo;

    public Retour() {
    }

    public Retour(String id, String reservationId, boolean isEndommage, boolean isPleinEffectue, Integer nbKmEffectues, String photo) {
        this.id = id;
        this.reservationId = reservationId;
        this.isEndommage = isEndommage;
        this.isPleinEffectue = isPleinEffectue;
        this.nbKmEffectues = nbKmEffectues;
        this.photo = photo;
    }

    protected Retour(Parcel in) {
        id = in.readString();
        reservationId = in.readString();
        isEndommage = in.readByte() != 0;
        isPleinEffectue = in.readByte() != 0;
        if (in.readByte() == 0) {
            nbKmEffectues = null;
        } else {
            nbKmEffectues = in.readInt();
        }
        photo = in.readString();
    }

    public static final Creator<Retour> CREATOR = new Creator<Retour>() {
        @Override
        public Retour createFromParcel(Parcel in) {
            return new Retour(in);
        }

        @Override
        public Retour[] newArray(int size) {
            return new Retour[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public boolean isEndommage() {
        return isEndommage;
    }

    public void setEndommage(boolean endommage) {
        isEndommage = endommage;
    }

    public boolean isPleinEffectue() {
        return isPleinEffectue;
    }

    public void setPleinEffectue(boolean pleinEffectue) {
        isPleinEffectue = pleinEffectue;
    }

    public Integer getNbKmEffectues() {
        return nbKmEffectues;
    }

    public void setNbKmEffectues(Integer nbKmEffectues) {
        this.nbKmEffectues = nbKmEffectues;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(reservationId);
        dest.writeByte((byte) (isEndommage ? 1 : 0));
        dest.writeByte((byte) (isPleinEffectue ? 1 : 0));
        if (nbKmEffectues == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(nbKmEffectues);
        }
        dest.writeString(photo);
    }
}

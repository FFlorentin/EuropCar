package com.example.fgallet2016.europcar.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by fgallet2016 on 09/04/2018.
 */

public class Utilisateur implements Parcelable{
    private Integer id;
    private String email;
    private String password;

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    protected Utilisateur(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        email = in.readString();
        password = in.readString();
    }

    public static final Creator<Utilisateur> CREATOR = new Creator<Utilisateur>() {
        @Override
        public Utilisateur createFromParcel(Parcel in) {
            return new Utilisateur(in);
        }

        @Override
        public Utilisateur[] newArray(int size) {
            return new Utilisateur[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(this.getEmail());
        parcel.writeString(this.getPassword());
    }
}
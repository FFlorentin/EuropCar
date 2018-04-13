package com.example.fgallet2016.europcar.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.fgallet2016.europcar.Model.Reservation;
import com.example.fgallet2016.europcar.Model.Vehicule;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {


    private static final ReservationService ourInstance = new ReservationService();
    private List<Reservation> reservations;

    public static ReservationService getInstance() {
        return ourInstance;
    }

    public ReservationService() {
        this.reservations = new ArrayList<>();
        this.generateTestSet();
    }

    public List<Reservation> getList() {
        return this.reservations;
    }

    public Reservation getReservationById(String id) {
        for (Reservation reservation : this.reservations) {
            if (reservation.getId().equals(id)) {
                return reservation;
            }
        }
        return null;
    }

    public void add(Reservation reservation) {
        this.reservations.add(reservation);
    }

    public void delete(String id) {
        for (Reservation reservation : this.reservations) {
            if (reservation.getId().equals(id)) {
                this.reservations.remove(reservation);
                return;
            }
        }
    }

    public List<Reservation> generateTestSet() {
        if (this.reservations.isEmpty()) {
            reservations.add(new Reservation("1", "Audi A3","01-06-2015","09-06-2015","15€"));
            reservations.add(new Reservation("2","Porche Cayenne","02-04-2012","18-06-2012","30€"));
            reservations.add(new Reservation("3","Fiat Panda","09-12-2017","15-12-2017","0.50€"));
            reservations.add(new Reservation("4","Opel Insigna","22-09-2002","26-09-2002","10€"));
            reservations.add(new Reservation("5","Renault Scénic","18-11-2014","19-11-2014","5€"));
            reservations.add(new Reservation("6","Citroen C3","19-11-2015","19-11-2016","6€"));
        }

        return reservations;
    }
}

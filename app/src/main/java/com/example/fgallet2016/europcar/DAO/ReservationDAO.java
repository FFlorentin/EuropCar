package com.example.fgallet2016.europcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fgallet2016.europcar.Model.Reservation;

/**
 * Created by Administrateur on 10/04/2018.
 */

@Dao
public interface ReservationDAO {
    @Insert
    String insert(Reservation reservation);

    @Insert
    String[] insertAll(Reservation... reservations);

    @Delete
    void delete(Reservation reservation);

    @Update
    void update(Reservation reservation);

    @Query("SELECT * FROM reservation WHERE id = (:id) LIMIT 1")
    Reservation getById(String id);
}

package com.example.fgallet2016.europcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fgallet2016.europcar.Model.Vehicule;

import java.util.List;

/**
 * Created by Administrateur on 10/04/2018.
 */

@Dao
public interface VehiculeDAO {
    @Insert
    String insert(Vehicule vehicule);

    @Insert
    String[] insertAll(Vehicule... vehicules);

    @Delete
    void delete(Vehicule vehicule);

    @Update
    void update(Vehicule vehicule);

    @Query("SELECT * FROM vehicule WHERE id = (:id) LIMIT 1")
    Vehicule getById(String id);

    @Query("SELECT * FROM vehicule WHERE libelle = (:libelle)")
    List<Vehicule> getByLibelle(String libelle);
}

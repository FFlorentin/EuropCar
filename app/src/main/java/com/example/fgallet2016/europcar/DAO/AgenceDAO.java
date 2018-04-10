package com.example.fgallet2016.europcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fgallet2016.europcar.Model.Agence;

/**
 * Created by Administrateur on 10/04/2018.
 */

@Dao
public interface AgenceDAO {
    @Insert
    String insert(Agence agence);

    @Insert
    String[] insertAll(Agence... agences);

    @Delete
    void delete(Agence agence);

    @Update
    void update(Agence agence);

    @Query("SELECT * FROM agence WHERE id = (:id) LIMIT 1")
    Agence getById(String id);

}

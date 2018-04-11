package com.example.fgallet2016.europcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fgallet2016.europcar.Model.Retour;

/**
 * Created by Administrateur on 11/04/2018.
 */

@Dao
public interface RetourDAO {
    @Insert
    String insert(Retour retour);

    @Insert
    String[] insertAll(Retour... retours);

    @Delete
    void delete(Retour retour);

    @Update
    void update(Retour retour);

    @Query("SELECT * FROM retour WHERE id = (:id) LIMIT 1")
    Retour getById(String id);
}

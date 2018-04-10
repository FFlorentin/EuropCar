package com.example.fgallet2016.europcar.DAO;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.fgallet2016.europcar.Model.Utilisateur;

import java.util.List;

/**
 * Created by Administrateur on 10/04/2018.
 */

@Dao
public interface UtilisateurDAO {
    @Insert
    String insert(Utilisateur utilisateur);

    @Insert
    String[] insertAll(Utilisateur... utilisateurs);

    @Delete
    void delete(Utilisateur utilisateur);

    @Update
    void update(Utilisateur utilisateur);

    @Query("SELECT * FROM utilisateur WHERE id = (:id) LIMIT 1")
    Utilisateur getById(String id);

}

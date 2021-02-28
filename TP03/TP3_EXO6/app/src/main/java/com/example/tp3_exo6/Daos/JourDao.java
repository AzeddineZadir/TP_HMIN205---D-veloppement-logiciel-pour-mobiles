package com.example.tp3_exo6.Daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tp3_exo6.Entitys.Jour;

import java.util.List;

@Dao
public interface JourDao {

    @Insert
    public void insert (Jour jour);

    @Query("SELECT * FROM jour_table")
    LiveData<List<Jour>> loadAlljour();
}

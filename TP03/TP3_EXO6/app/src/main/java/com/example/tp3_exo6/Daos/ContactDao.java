package com.example.tp3_exo6.Daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.tp3_exo6.Entitys.Contact;

import java.util.List;

@Dao
public interface ContactDao {

    @Insert
    public void insert (Contact contact);

    @Query("SELECT * FROM contact_table")
    List<Contact> loadAllContacts();
}

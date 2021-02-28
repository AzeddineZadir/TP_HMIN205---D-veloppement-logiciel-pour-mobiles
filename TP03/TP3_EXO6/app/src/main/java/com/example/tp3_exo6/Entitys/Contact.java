package com.example.tp3_exo6.Entitys;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "contact_table")
public class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id ;
    @ColumnInfo(name = "contact_code")
    private String contact_code ;

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "nom")
    private String nom ;

    @ColumnInfo(name = "prenom")
    private String prenom ;

    @ColumnInfo(name = "numero")
    private String num ;

    @ColumnInfo(name = "age")
    private int age ;



    public Contact(String contact_code, String nom, String prenom, String num, int age) {
        this.contact_code = contact_code;
        this.nom = nom;
        this.prenom = prenom;
        this.num = num;
        this.age = age;
    }


    public String getPrenom() {
        return prenom;
    }

    public int getId() {
        return id;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getContact_code() {
        return contact_code;
    }

    public void setContact_code(String contact_code) {
        this.contact_code = contact_code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

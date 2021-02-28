package com.example.tp3_exo6;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.tp3_exo6.Daos.ContactDao;
import com.example.tp3_exo6.Daos.JourDao;
import com.example.tp3_exo6.Entitys.Contact;
import com.example.tp3_exo6.Entitys.Jour;

import java.util.concurrent.Executors;


@Database(entities = {Contact.class, Jour.class},version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ContactDao contactDao();
    public abstract JourDao jourDao();

    private static AppDataBase INSTANCE;
    public synchronized static AppDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    // initialisation d'une base de donné

    private static AppDataBase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                AppDataBase.class,
                "AppDataBase")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        Executors.newSingleThreadScheduledExecutor().execute(new Runnable() {
                            @Override
                            public void run() {

                                Contact c1 = new Contact("nocode","nom","prenom","00000000000",23);
                                Jour j1 = new Jour("08h-10h : Rencontre avec MR ","10h-12h : Travailler le dossier recrutement ","14h-16h : Réunion équipe" ,"16h-18h : Préparation dossier vente.");
                                getInstance(context).contactDao().insert(c1);
                                getInstance(context).jourDao().insert(j1);
                            }
                        });
                    }
                })
                .build();
    }
}

package com.example.appentregas.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.appentregas.dao.EntregaDao;
import com.example.appentregas.model.Entrega;

@Database(entities = {Entrega.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EntregaDao entregaDao();
}

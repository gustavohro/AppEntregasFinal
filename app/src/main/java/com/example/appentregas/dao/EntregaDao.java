package com.example.appentregas.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.appentregas.model.Entrega;

import java.util.List;

@Dao
public interface EntregaDao {
    @Insert
    void inserirEntrega(Entrega entrega);

    @Query("SELECT * FROM entregas")
    List<Entrega> listarEntregas();
}

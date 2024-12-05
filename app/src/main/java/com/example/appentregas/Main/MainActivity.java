package com.example.appentregas.Main;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.example.appentregas.adapter.EntregaAdapter;
import com.example.appentregas.database.AppDatabase;
import com.example.appentregas.model.Entrega;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private EntregaAdapter adapter;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);

        // Configurar banco de dados
        database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "app_entregas"
        ).allowMainThreadQueries().build();

        // Configurar RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        carregarEntregas();

        fab.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddEntregaActivity.class));
        });
    }

    private void carregarEntregas() {
        List<Entrega> entregas = database.entregaDao().listarEntregas();
        adapter = new EntregaAdapter(entregas);
        recyclerView.setAdapter(adapter);
    }
}

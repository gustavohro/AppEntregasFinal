package com.example.appentregas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.appentregas.database.AppDatabase;
import com.example.appentregas.model.Entrega;

public class AddEntregaActivity extends AppCompatActivity {

    private EditText edtNome, edtTelefone, edtEndereco;
    private Button btnSalvar;
    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entrega);

        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEndereco = findViewById(R.id.edtEndereco);
        btnSalvar = findViewById(R.id.btnSalvar);

        database = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "app_entregas"
        ).allowMainThreadQueries().build();

        btnSalvar.setOnClickListener(v -> {
            Entrega entrega = new Entrega();
            entrega.setNome(edtNome.getText().toString());
            entrega.setTelefone(edtTelefone.getText().toString());
            entrega.setEndereco(edtEndereco.getText().toString());

            database.entregaDao().inserirEntrega(entrega);
            finish();
        });
    }
}


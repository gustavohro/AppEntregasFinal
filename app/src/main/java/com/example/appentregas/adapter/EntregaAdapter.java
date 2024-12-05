package com.seuprojeto.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appentregas.R;
import com.example.appentregas.model.Entrega;

import java.util.List;

public class EntregaAdapter extends RecyclerView.Adapter<EntregaAdapter.EntregaViewHolder> {

    private List<Entrega> entregas;

    public EntregaAdapter(List<Entrega> entregas) {
        this.entregas = entregas;
    }

    @NonNull
    @Override
    public EntregaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_entrega, parent, false);
        return new EntregaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EntregaViewHolder holder, int position) {
        Entrega entrega = entregas.get(position);
        holder.txtNome.setText(entrega.getNome());
        holder.txtTelefone.setText(entrega.getTelefone());
        holder.txtEndereco.setText(entrega.getEndereco());
    }

    @Override
    public int getItemCount() {
        return entregas.size();
    }

    public static class EntregaViewHolder extends RecyclerView.ViewHolder {
        TextView txtNome, txtTelefone, txtEndereco;

        public EntregaViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtTelefone = itemView.findViewById(R.id.txtTelefone);
            txtEndereco = itemView.findViewById(R.id.txtEndereco);
        }
    }
}

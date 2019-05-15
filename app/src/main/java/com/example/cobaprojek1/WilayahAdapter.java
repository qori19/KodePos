package com.example.cobaprojek1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class WilayahAdapter extends RecyclerView.Adapter<WilayahAdapter.ViewHolder>{
    Context context;
    List <WilayahModel> wilayahModels = new ArrayList<>();

    public WilayahAdapter(Context context, List<WilayahModel> wilayahModels){
        this.context = context;
        this.wilayahModels = wilayahModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_view, viewGroup, false); // menghubungkan ke layout
        ViewHolder holder = new ViewHolder(view); // deklarasi class ViewHolder di baris 46
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.tvNama.setText(wilayahModels.get(i).getNamaWilayah());
        viewHolder.tvKode.setText(wilayahModels.get(i).getKodePos());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(context, wilayahModels.get(i).getKodePos(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return wilayahModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvKode;
        TextView tvNama;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.kabu);
            tvKode = itemView.findViewById(R.id.kode_pos);
        }
    }
}

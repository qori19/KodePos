package com.example.cobaprojek1.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cobaprojek1.R;
import com.example.cobaprojek1.model.KotaKab;

import java.util.List;


public class AdapterKokab extends RecyclerView.Adapter<AdapterKokab.Holder> {
    Context context;
    List<KotaKab> kotaKabs;
    SharedPreferences pref;

    public AdapterKokab(Context context, List<KotaKab> kotaKabs) {
        this.context = context;
        this.kotaKabs = kotaKabs;
    }

    @NonNull
    @Override
    public AdapterKokab.Holder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new AdapterKokab.Holder(view);
    }

    @Override
    public void onBindViewHolder(AdapterKokab.Holder holder, final int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return kotaKabs.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView kec, kel, kode;
        private RelativeLayout kokab;

        public Holder(View itemView) {
            super(itemView);
            kec = itemView.findViewById(R.id.kecamatan);
            kel = itemView.findViewById(R.id.kelurahan);
            kode = itemView.findViewById(R.id.kode_pos);
            kokab = itemView.findViewById(R.id.kabu);
        }

        public void bind(final int position) {
            kec.setText(kotaKabs.get(position).getKecamatan());
            kel.setText(kotaKabs.get(position).getKelurahan());
            kode.setText(kotaKabs.get(position).getKodepos());
            kokab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }

    }
}

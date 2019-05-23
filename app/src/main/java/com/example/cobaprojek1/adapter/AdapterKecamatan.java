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
import android.widget.Toast;

import com.example.cobaprojek1.R;
import com.example.cobaprojek1.model.Kecamatan;

import java.util.List;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class AdapterKecamatan extends RecyclerView.Adapter<AdapterKecamatan.Holder> {
    Context context;
    List<Kecamatan> kecamatans;
    SharedPreferences pref;

    public AdapterKecamatan(Context context, List<Kecamatan> kecamatans) {
        this.context = context;
        this.kecamatans = kecamatans;
    }

    @NonNull
    @Override
    public AdapterKecamatan.Holder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view, parent, false);
        return new AdapterKecamatan.Holder(view);
    }

    @Override
    public void onBindViewHolder(AdapterKecamatan.Holder holder, final int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return kecamatans.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView kec, kel, kode;
        private RelativeLayout list_kec;

        public Holder(View itemView) {
            super(itemView);
            kec = itemView.findViewById(R.id.kecamatan);
            kel = itemView.findViewById(R.id.kelurahan);
            kode = itemView.findViewById(R.id.kode_pos);
            list_kec = itemView.findViewById(R.id.list_view_Kecamatan);
        }

        public void bind(final int position) {
            kec.setText(kecamatans.get(position).getKecamatan());
            kel.setText(kecamatans.get(position).getKelurahan());
            kode.setText(kecamatans.get(position).getKodepos());
            list_kec.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, kecamatans.get(position).getKodepos(),Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}

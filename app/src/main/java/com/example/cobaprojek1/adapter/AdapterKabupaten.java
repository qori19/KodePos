package com.example.cobaprojek1.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.cobaprojek1.Fragment.KecamatanFragment;
import com.example.cobaprojek1.R;
import com.example.cobaprojek1.model.DataPos;

import java.util.List;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class AdapterKabupaten extends RecyclerView.Adapter<AdapterKabupaten.Holder> {
    Context context;
    List<DataPos> dataPos;
    SharedPreferences pref;

    public AdapterKabupaten(Context context, List<DataPos> dataPos) {
        this.context = context;
        this.dataPos = dataPos;
    }

    @NonNull
    @Override
    public AdapterKabupaten.Holder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view2, parent, false);
        return new AdapterKabupaten.Holder(view);
    }

    @Override
    public void onBindViewHolder(AdapterKabupaten.Holder holder, final int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return dataPos.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        private TextView nama;
        private RelativeLayout kabupaten;

        public Holder(View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.kabupaten);
            kabupaten = itemView.findViewById(R.id.list_view_Kabupaten);
        }

        public void bind(final int position) {
            nama.setText(dataPos.get(position).getNama());
            kabupaten.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pref = context.getApplicationContext().getSharedPreferences("kabupaten", Context.MODE_PRIVATE);
                    final SharedPreferences.Editor editor = pref.edit();
                    editor.putString("idkab", dataPos.get(position).getKode());
                    editor.putString("nkab", dataPos.get(position).getNama());
                    editor.apply();

                    Fragment fragment = new KecamatanFragment();
                    FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.container, fragment);
                    transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

        }
    }
}

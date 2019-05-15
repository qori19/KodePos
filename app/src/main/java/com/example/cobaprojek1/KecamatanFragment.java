package com.example.cobaprojek1;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobaprojek1.adapter.AdapterKokab;
import com.example.cobaprojek1.model.DataPos;
import com.example.cobaprojek1.model.KotaKab;
import com.example.cobaprojek1.presenter.MainPresenter;
import com.example.cobaprojek1.presenter.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class KecamatanFragment extends Fragment implements MainView {
    List<KotaKab> DataKokab = new ArrayList<>();
    MainPresenter mainPresenter;
    SharedPreferences pref;
    private RecyclerView recyclerView;
    private AdapterKokab adapter;


    public KecamatanFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kecamatan, container, false);

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rv1);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new AdapterKokab(getContext(), DataKokab);
        recyclerView.setAdapter(adapter);
        pref = getActivity().getApplicationContext().getSharedPreferences("kabupaten", Context.MODE_PRIVATE);
        String nkab = pref.getString("nkab", "");
        String idkab = pref.getString("idkab", "");
        mainPresenter = new MainPresenter(this);
        mainPresenter.loadkokab(idkab);

    }


    @Override
    public void getSucces(List<DataPos> data) {

    }

    @Override
    public void getKokabSuccess(List<KotaKab> datakokab) {
        this.DataKokab.clear();
        this.DataKokab.addAll(datakokab);
        this.adapter.notifyDataSetChanged();

    }

    @Override
    public void onError(String errorMsg) {
    }

    @Override
    public void onFailure(String failureMsg) {

    }

}

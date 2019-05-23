package com.example.cobaprojek1.Fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobaprojek1.adapter.AdapterProvinsi;
import com.example.cobaprojek1.model.DataPos;
import com.example.cobaprojek1.model.Kecamatan;
import com.example.cobaprojek1.presenter.MainPresenter;
import com.example.cobaprojek1.presenter.MainView;
import com.example.cobaprojek1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class ProvinsiFragment extends Fragment implements MainView {
    List<DataPos> DataProv = new ArrayList<>();
    AdapterProvinsi adapter;
    MainPresenter mainPresenter;
    SharedPreferences pref;
    FragmentManager fragmentmanager;

    public ProvinsiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_provinsi, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new AdapterProvinsi(getContext(), DataProv);
        recyclerView.setAdapter(adapter);
        pref = getActivity().getApplicationContext().getSharedPreferences("Save save an", Context.MODE_PRIVATE);
        mainPresenter = new MainPresenter(this);
        mainPresenter.loadprov();
    }

    @Override
    public void getSucces(List<DataPos> data) {
        this.DataProv.clear();
        this.DataProv.addAll(data);
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public void getKokabSuccess(List<Kecamatan> datakokab) {

    }

    @Override
    public void onError(String errorMsg) {
    }

    @Override
    public void onFailure(String failureMsg) {

    }
}
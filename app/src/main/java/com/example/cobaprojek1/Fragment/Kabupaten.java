package com.example.cobaprojek1.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobaprojek1.R;
import com.example.cobaprojek1.adapter.AdapterKabupaten;
import com.example.cobaprojek1.model.DataPos;
import com.example.cobaprojek1.model.Kecamatan;
import com.example.cobaprojek1.presenter.MainPresenter;
import com.example.cobaprojek1.presenter.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class Kabupaten extends Fragment implements MainView {
    List<DataPos> DataKab = new ArrayList<>();
    AdapterKabupaten adapter;
    MainPresenter mainPresenter;
    SharedPreferences pref;


    public Kabupaten() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kabupaten, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new AdapterKabupaten(getContext(), DataKab);
        recyclerView.setAdapter(adapter);
        pref = getActivity().getApplicationContext().getSharedPreferences("DATA1", Context.MODE_PRIVATE);
        String np = pref.getString("np", "");
        String pid = pref.getString("pid", "");
        Log.d("ERR-", pid);
        mainPresenter = new MainPresenter(this);
        mainPresenter.loadkab(pid);
    }

    @Override
    public void getSucces(List<DataPos> data) {
        this.DataKab.clear();
        this.DataKab.addAll(data);
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

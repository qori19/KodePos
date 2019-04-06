package com.example.cobaprojek1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class WilayahFragment extends Fragment implements MainView {

    List<WilayahModel> wilayahModels = new ArrayList<>();
    WilayahAdapter adapter;

    public WilayahFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wilayah, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new WilayahAdapter(getContext(), wilayahModels);
        recyclerView.setAdapter(adapter);
        WilayahPresenter data = new WilayahPresenter(this,getContext());
        data.setData();
    }

    @Override
    public void onSuccess(List<WilayahModel> wilayahModels) {
        this.wilayahModels.clear();
        this.wilayahModels.addAll(wilayahModels);
        this.adapter.notifyDataSetChanged();
    }

}

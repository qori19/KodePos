package com.example.cobaprojek1;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class WilayahPresenter {
    Context context;
    List<WilayahModel> wilayahModels = new ArrayList<>();
    MainView view;
    public WilayahPresenter(MainView view, Context context){
        this.view=view;
        this.context=context;
    }

    public void setData(){
        WilayahModel wilayah;
        wilayah= new WilayahModel("Majasari", "44193");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Cibiuk Kidul", "44193");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Cipareuan", "44193");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Lingkungpasir", "44193");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Cibiuk Kaler", "44193");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Margahayu", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Sindangsari", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Tambaksari", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Margacinta", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Karangsari", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Leuwigoong", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Dungusiku", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Karanganyar", "44192");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Sukasenang", "44191");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Sukaratu", "44191");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Sukaraja", "44191");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Sukamukti", "44191");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Sukakarya", "44191");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Sukalaksana", "44191");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Karyasari", "44191");
        wilayahModels.add(wilayah);
        wilayah= new WilayahModel("Pamekarsari", "44191");
        wilayahModels.add(wilayah);

        view.onSuccess(wilayahModels);
    }
}

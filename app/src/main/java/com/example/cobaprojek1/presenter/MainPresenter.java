package com.example.cobaprojek1.presenter;

import com.example.cobaprojek1.connection.BaseApp;
import com.example.cobaprojek1.model.DataPos;
import com.example.cobaprojek1.model.Kecamatan;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface {
    private MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    }

    @Override
    public void loadprov() {
        final List<DataPos> dataPoslist = new ArrayList<>();
        BaseApp.apiService2.getDataProvinsi().enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    Type mapType = new TypeToken<Map<String, String>>() {
                    }.getType();
                    ArrayList<DataPos> pos = new ArrayList<>();
                    Map<String, String> map = gson.fromJson(response.body(), mapType);
                    for (String key : map.keySet()) {
                        DataPos dataPos = new DataPos();
                        dataPos.setKode(key);
                        dataPos.setNama(map.get(key));
                        dataPoslist.add(dataPos);
                    }
                    mainView.getSucces(dataPoslist);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                mainView.onFailure(t.getMessage());
            }


        });
    }

    @Override
    public void loadkab(String urlProv) {
        final List<DataPos> datakab = new ArrayList<>();
        BaseApp.apiService2.getDataKabupaten(urlProv).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    Type mapType = new TypeToken<Map<String, String>>() {
                    }.getType();
                    Map<String, String> map = gson.fromJson(response.body(), mapType);
                    for (String key : map.keySet()) {
                        DataPos dataPos = new DataPos();
                        dataPos.setKode(key);
                        dataPos.setNama(map.get(key));
                        datakab.add(dataPos);
                    }
                    mainView.getSucces(datakab);
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                mainView.onError(t.getMessage());
            }
        });
    }

    public void loadkokab(String urlKokab) {
        BaseApp.apiService1.getKotaKab(urlKokab).enqueue(new Callback<List<Kecamatan>>() {

            @Override
            public void onResponse(Call<List<Kecamatan>> call, Response<List<Kecamatan>> response) {
                mainView.getKokabSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Kecamatan>> call, Throwable t) {
                mainView.onError(t.getMessage());
            }
        });
    }

}

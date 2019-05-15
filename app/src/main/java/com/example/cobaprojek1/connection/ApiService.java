package com.example.cobaprojek1.connection;

import com.example.cobaprojek1.model.KotaKab;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/list_propinsi.json")
    Call<String> getDataProvinsi();

    @GET("/list_kotakab/{id}.json")
    Call<String> getDataKabupaten(@Path("id") String id);

    @GET("/kota_kab/{id}.json")
    Call<List<KotaKab>> getKotaKab(@Path("id") String id);


}
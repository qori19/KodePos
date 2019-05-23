package com.example.cobaprojek1.connection;

import com.example.cobaprojek1.model.Kecamatan;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public interface ApiService {

    @GET("/list_propinsi.json")
    Call<String> getDataProvinsi();

    @GET("/list_kotakab/{id}.json")
    Call<String> getDataKabupaten(@Path("id") String id);

    @GET("/kota_kab/{id}.json")
    Call<List<Kecamatan>> getKotaKab(@Path("id") String id);


}
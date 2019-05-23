package com.example.cobaprojek1.presenter;

import com.example.cobaprojek1.model.DataPos;
import com.example.cobaprojek1.model.Kecamatan;

import java.util.List;

public interface MainView {
    void getSucces(List<DataPos> data);

    void getKokabSuccess(List<Kecamatan> Kecamatan);

    void onError(String errorMsg);

    void onFailure(String failureMsg);
}

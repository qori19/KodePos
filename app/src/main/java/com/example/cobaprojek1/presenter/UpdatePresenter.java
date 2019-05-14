package com.example.cobaprojek1.presenter;

import android.content.Context;

import com.example.cobaprojek1.connection.BaseApp;
import com.example.cobaprojek1.model.update.CreateResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdatePresenter {
    private Context context;
    private UpdateView updateView;

    public UpdatePresenter(Context context, UpdateView updateView) {
        this.context = context;
        this.updateView = updateView;
    }

    public void update(String token ,String name){
        BaseApp.loginService.updateUser(token,name).enqueue(new Callback<CreateResponse>() {
            @Override
            public void onResponse(Call<CreateResponse> call, Response<CreateResponse> response) {
                if (response.isSuccessful()) {
                    updateView.onSucces(response.body());
                } else {
                    updateView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<CreateResponse> call, Throwable t) {
                updateView.onFailure(t.getMessage());
            }
        });

    }
}


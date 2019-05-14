package com.example.cobaprojek1.presenter;

import android.content.Context;

import com.example.cobaprojek1.connection.BaseApp;
import com.example.cobaprojek1.model.postlogin.PostLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private Context context;
    private LoginView loginView;

    public LoginPresenter(Context context, LoginView loginView) {
        this.context = context;
        this.loginView = loginView;
    }

    public void login(String email, String password) {
        BaseApp.loginService.PostUserResponse(email, password).enqueue(new Callback<PostLoginResponse>() {
            @Override
            public void onResponse(Call<PostLoginResponse> call, Response<PostLoginResponse> response) {
                if (response.isSuccessful()) {
                    loginView.onSucces(response.body());
                } else {
                    loginView.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<PostLoginResponse> call, Throwable t) {
                loginView.onFailure(t.getMessage());
            }
        });
    }
}

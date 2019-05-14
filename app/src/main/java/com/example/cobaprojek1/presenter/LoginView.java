package com.example.cobaprojek1.presenter;

import com.example.cobaprojek1.model.postlogin.PostLoginResponse;

public interface LoginView {
    void onSucces(PostLoginResponse login);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}

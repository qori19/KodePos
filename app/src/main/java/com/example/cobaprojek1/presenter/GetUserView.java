package com.example.cobaprojek1.presenter;

import com.example.cobaprojek1.model.get_user.LoginResponse;

public interface GetUserView {
    void onSucces(LoginResponse loginResponse);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}

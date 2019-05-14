package com.example.cobaprojek1.presenter;

public interface RegisView {
    void onSucces(String regis);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}

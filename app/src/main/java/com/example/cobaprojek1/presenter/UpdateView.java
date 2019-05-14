package com.example.cobaprojek1.presenter;

import com.example.cobaprojek1.model.update.CreateResponse;

public interface UpdateView {
    void onSucces(CreateResponse update);
    void onError(String errorMessage);
    void onFailure(String failureMessage);
}

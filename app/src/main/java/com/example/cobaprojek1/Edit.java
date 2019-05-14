package com.example.cobaprojek1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cobaprojek1.connection.Addpreferenceconfig;
import com.example.cobaprojek1.model.get_user.LoginResponse;
import com.example.cobaprojek1.model.update.CreateResponse;
import com.example.cobaprojek1.presenter.GetUserPresenter;
import com.example.cobaprojek1.presenter.GetUserView;
import com.example.cobaprojek1.presenter.UpdatePresenter;
import com.example.cobaprojek1.presenter.UpdateView;

public class Edit extends AppCompatActivity implements UpdateView, GetUserView {
    EditText nama, telpon;
    Button kembali, simpan;
    UpdatePresenter updatePresenter;
    GetUserPresenter getUserPresenter;
    private Addpreferenceconfig sharedPreferenceconfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_form);

        getUserPresenter = new GetUserPresenter(getApplicationContext(),this);
        sharedPreferenceconfig = new Addpreferenceconfig(getApplicationContext());
        getUserPresenter.ambil(sharedPreferenceconfig.getToken());

        nama = findViewById(R.id.isinama);
        telpon = findViewById(R.id.number);
        kembali = findViewById(R.id.cancel);
        simpan = findViewById(R.id.save);

        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void updateUser(View view) {
        String username = nama.getText().toString();
        updatePresenter = new UpdatePresenter(getApplicationContext(), this);
        updatePresenter.update(sharedPreferenceconfig.getToken(),username);

    }

    @Override
    public void onSucces(LoginResponse loginResponse) {
        nama.setText(loginResponse.getNama());
    }

    @Override
    public void onSucces(CreateResponse update) {
        Toast.makeText(getApplicationContext(), "Updated!", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getApplicationContext(), failureMessage, Toast.LENGTH_SHORT).show();
    }
}

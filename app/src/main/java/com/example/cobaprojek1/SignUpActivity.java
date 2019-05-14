package com.example.cobaprojek1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cobaprojek1.presenter.RegisPresenter;
import com.example.cobaprojek1.presenter.RegisView;

public class SignUpActivity extends AppCompatActivity implements RegisView {
    EditText nama, email, passw;
    Button kembali, simpan;
    RegisPresenter regisPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nama = findViewById(R.id.isinamasp);
        email = findViewById(R.id.isiesp);
        passw = findViewById(R.id.isipsp);
        simpan = findViewById(R.id.savesp);
        kembali = findViewById(R.id.cancelsp);

        regisPresenter = new RegisPresenter(getApplicationContext(),this);
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regisPresenter.create(nama.getText().toString(),email.getText().toString(), passw.getText().toString());
            }
        });

    }

    @Override
    public void onSucces(String regis) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getApplicationContext(),errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getApplicationContext(),failureMessage,Toast.LENGTH_SHORT).show();
    }
}

package com.example.cobaprojek1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText etNama, etPassword;
    Button btnKirim;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String user,pass;
    Boolean savelogin;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etNama = findViewById(R.id.b);
        btnKirim = findViewById(R.id.btn);
        etPassword = findViewById(R.id.d);
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();
        editor.putBoolean("savelogin",true);
        editor.apply();

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = etNama.getText().toString();
                String pass = etPassword.getText().toString();
                if (user.equals("admin") && pass.equals ("admin")){
                    Toast.makeText(Login.this, "Login Berhasil", Toast.LENGTH_LONG).show();
                    editor = sharedPreferences.edit();
                    editor.putString("logged", "logged");
                    editor.commit();
                    savelogin = sharedPreferences.getBoolean("savelogin", false);
                    if (savelogin == true) {
                        Intent a = new Intent(getApplicationContext(), MainActivity.class);
                        a.putExtra("username", user);
                        a.putExtra("password", pass);
                        startActivity(a);
                    }

                }
            else{
                    Toast.makeText(Login.this, "Username dan Password di simpan", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

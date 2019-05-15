package com.example.cobaprojek1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cobaprojek1.connection.Addpreferenceconfig;
import com.example.cobaprojek1.model.postlogin.PostLoginResponse;
import com.example.cobaprojek1.presenter.LoginPresenter;
import com.example.cobaprojek1.presenter.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView {
    private Addpreferenceconfig preferenceconfig;
    private EditText Username, UserPassword;
    private LoginPresenter loginPresenter;
    private Button btnSign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


        preferenceconfig = new Addpreferenceconfig(getApplicationContext());
        Username = findViewById(R.id.user_name);
        UserPassword = findViewById(R.id.user_password);
        btnSign = findViewById(R.id.btn_sign);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
            }
        });

        if (preferenceconfig.readLoginStatus()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    public void loginUser(View view) {
        String username = Username.getText().toString();
        String userpassword = UserPassword.getText().toString();
        loginPresenter = new LoginPresenter(getApplicationContext(),this);
        loginPresenter.login(username,userpassword);
    }

    @Override
    public void onSucces(PostLoginResponse login) {
        preferenceconfig.writeLoginStatus(true);
        preferenceconfig.token(login.getToken());
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
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

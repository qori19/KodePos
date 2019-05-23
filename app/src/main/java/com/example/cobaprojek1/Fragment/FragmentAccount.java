package com.example.cobaprojek1.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cobaprojek1.Edit;
import com.example.cobaprojek1.LoginActivity;
import com.example.cobaprojek1.R;
import com.example.cobaprojek1.connection.Addpreferenceconfig;
import com.example.cobaprojek1.model.get_user.LoginResponse;
import com.example.cobaprojek1.model.update.CreateResponse;
import com.example.cobaprojek1.presenter.GetUserPresenter;
import com.example.cobaprojek1.presenter.GetUserView;
import com.example.cobaprojek1.presenter.UpdateView;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class FragmentAccount extends Fragment implements GetUserView, UpdateView {
    View v;
    private Button btn_logout, btnEdit;
    EditText isi;
    Addpreferenceconfig sharedPreferences;
    TextView userrr;
    Boolean savelogin;
    String kata,email,hp;
    GetUserPresenter getUserPresenter;

    public FragmentAccount() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_account, container, false);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnEdit = view.findViewById(R.id.edit);
        btn_logout = view.findViewById(R.id.btn_logout);
        isi = view.findViewById(R.id.isie);
        userrr = view.findViewById(R.id.nama);

        getUserPresenter = new GetUserPresenter(getContext(),this);
        sharedPreferences= new Addpreferenceconfig(getContext());
        getUserPresenter.ambil(sharedPreferences.getToken());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ganti = new Intent(getActivity().getApplicationContext(), Edit.class);
                startActivity(ganti);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.logout(sharedPreferences.getToken());
                startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
    }
    @Override
    public void onSucces(LoginResponse loginResponse){
        userrr.setText(loginResponse.getNama());
        isi.setText(loginResponse.getEmail());
    }

    @Override
    public void onSucces(CreateResponse update) {
        Toast.makeText(getContext(),"Update",Toast.LENGTH_SHORT).show();
        userrr.setText(update.getName());
    }

    @Override
    public void onError(String errorMessage) {
        Toast.makeText(getContext(),"Error"+errorMessage,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String failureMessage) {
        Toast.makeText(getContext(),"OnFailure" + failureMessage,Toast.LENGTH_SHORT).show();
    }
}

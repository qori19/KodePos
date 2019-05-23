package com.example.cobaprojek1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.cobaprojek1.Fragment.FragmentAccount;
import com.example.cobaprojek1.Fragment.ProvinsiFragment;

/**
 * Created by Qori Fatkhul Kurniyadi on 15/05/2019
 * Nim : 124170036
 * github : github.com/qori19
 */

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{
    BottomNavigationView bottomNavigationView;
    Fragment fragment;
    TextView userr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bnv);
        loadFragment(new ProvinsiFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment){
        if(fragment!=null){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.menu1:
                fragment = new ProvinsiFragment();
                break;

            case R.id.menu2:
                fragment = new FragmentAccount();
                break;
        }
        return loadFragment(fragment);
    }
}

package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity implements CompanyAdaper.onCompanyClick{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,new CompanyListFragment())
                .commit();
    }

    @Override
    public void onCompanyItemClick(Company company) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,DetailFragment.newInstance(company))
                .addToBackStack("")
                .commit();
    }
}
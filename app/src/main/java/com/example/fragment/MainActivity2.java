package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

            getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container,new DetailFragment())
                .commit();
    }
}
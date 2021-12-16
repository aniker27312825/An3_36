package com.geektech.an3_36.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.geektech.an3_36.R;
import com.geektech.an3_36.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
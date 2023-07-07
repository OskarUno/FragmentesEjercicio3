package com.awakelab.oskar.fragmentesejercicio3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.awakelab.oskar.fragmentesejercicio3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
package com.example.utsaplikasiperhitungangaji;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivityDikiReski extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_diki_reski);

        View btnGajiPegawai = findViewById(R.id.btnGajiPegawai);
        View btnPetunjuk = findViewById(R.id.btnPetunjuk);
        View btnTentang = findViewById(R.id.btnTentang);
        View btnExit = findViewById(R.id.btnExit);

        btnGajiPegawai.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityDikiReski.this, GajiActivityDikiReski.class);
            startActivity(intent);
        });

        btnPetunjuk.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityDikiReski.this, PetunjukActivityDikiReski.class);
            startActivity(intent);
        });

        btnTentang.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivityDikiReski.this, TentangActivityDikiReski.class);
            startActivity(intent);
        });

        btnExit.setOnClickListener(v -> finishAffinity());
    }
}
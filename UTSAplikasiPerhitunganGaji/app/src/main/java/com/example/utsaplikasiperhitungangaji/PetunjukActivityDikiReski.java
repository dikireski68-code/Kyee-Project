package com.example.utsaplikasiperhitungangaji;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PetunjukActivityDikiReski extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petunjuk_diki_reski);

        Button btnKembali = findViewById(R.id.btnKembaliPetunjuk);
        btnKembali.setOnClickListener(v -> finish());
    }
}
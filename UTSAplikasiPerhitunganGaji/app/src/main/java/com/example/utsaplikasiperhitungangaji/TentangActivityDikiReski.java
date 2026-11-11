package com.example.utsaplikasiperhitungangaji;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TentangActivityDikiReski extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang_diki_reski);

        Button btnKembali = findViewById(R.id.btnKembaliTentang);
        btnKembali.setOnClickListener(v -> finish());
    }
}
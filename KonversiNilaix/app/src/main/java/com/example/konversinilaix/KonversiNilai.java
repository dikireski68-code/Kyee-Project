package com.example.konversinilaix;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class KonversiNilai extends AppCompatActivity {
    EditText edTugas, edKehadiran, edNama, edUTS, edUAS, edNilaiAngka, edHuruf;
    Button btHitung;
    String vHuruf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        edTugas = findViewById(R.id.edTugas);
        edKehadiran = findViewById(R.id.edKehadiran);
        edNama = findViewById(R.id.edNama);
        edUTS = findViewById(R.id.edUTS);
        edUAS = findViewById(R.id.edUAS);
        edNilaiAngka = findViewById(R.id.edNilaiAngka);
        edHuruf = findViewById(R.id.edHuruf);
        btHitung = findViewById(R.id.btHitung);

        btHitung.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               float Tugas = Float.parseFloat(edTugas.getText().toString());
               float kehadiran = Float.parseFloat(edKehadiran.getText().toString());

               double nilai_angka = (0.4 * Tugas) + (0.6 * kehadiran);

               if (nilai_angka>=80){
                   vHuruf = "A";
               }
               else if(nilai_angka>=70){
                   vHuruf ="B";
               }else{
                   vHuruf="C";
               }

               edNilaiAngka.setText(""+ nilai_angka);
               edHuruf.setText(""+ vHuruf);
           }
       });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}
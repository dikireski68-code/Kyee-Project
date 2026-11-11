package com.example.utsaplikasiperhitungangaji;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.util.Locale;

public class GajiActivityDikiReski extends AppCompatActivity {

    private EditText etNik, etNama, etGajiPokok, etTunjanganJabatan, etJumlahHariKerja;
    private EditText etTunjanganMakan, etTunjanganTransportasi, etGajiKotor, etGajiBersih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaji_diki_reski);

        etNik = findViewById(R.id.etNik);
        etNama = findViewById(R.id.etNama);
        etGajiPokok = findViewById(R.id.etGajiPokok);
        etTunjanganJabatan = findViewById(R.id.etTunjanganJabatan);
        etJumlahHariKerja = findViewById(R.id.etJumlahHariKerja);

        Button btnHitung = findViewById(R.id.btnHitung);

        etTunjanganMakan = findViewById(R.id.etTunjanganMakan);
        etTunjanganTransportasi = findViewById(R.id.etTunjanganTransportasi);
        etGajiKotor = findViewById(R.id.etGajiKotor);
        etGajiBersih = findViewById(R.id.etGajiBersih);

        btnHitung.setOnClickListener(v -> hitungGaji());
    }

    private void hitungGaji() {
        String strNik = etNik.getText().toString().trim();
        String strNama = etNama.getText().toString().trim();
        String strGajiPokok = etGajiPokok.getText().toString().trim();
        String strTunjanganJabatan = etTunjanganJabatan.getText().toString().trim();
        String strHariKerja = etJumlahHariKerja.getText().toString().trim();

        if (TextUtils.isEmpty(strNik)) {
            etNik.setError("Nomor Induk Karyawan wajib diisi");
            etNik.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strNama)) {
            etNama.setError("Nama Karyawan wajib diisi");
            etNama.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strGajiPokok)) {
            etGajiPokok.setError("Gaji Pokok wajib diisi");
            etGajiPokok.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strTunjanganJabatan)) {
            etTunjanganJabatan.setError("Tunjangan Jabatan wajib diisi");
            etTunjanganJabatan.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(strHariKerja)) {
            etJumlahHariKerja.setError("Jumlah Hari Kerja wajib diisi");
            etJumlahHariKerja.requestFocus();
            return;
        }

        try {
            double gajiPokok = Double.parseDouble(strGajiPokok);
            double tunjJabatan = Double.parseDouble(strTunjanganJabatan);
            int hariKerja = Integer.parseInt(strHariKerja);


            double tunjMakan = hariKerja * 10000.0;


            double tunjTransport = hariKerja * 5000.0;


            double gajiKotor = gajiPokok + tunjJabatan + tunjMakan + tunjTransport;


            double pajak = 0.10 * gajiKotor;


            double gajiBersih = gajiKotor - pajak;

            DecimalFormat formatter = new DecimalFormat("#,###.##");

            etTunjanganMakan.setText(String.format(Locale.getDefault(), "Rp %s", formatter.format(tunjMakan)));
            etTunjanganTransportasi.setText(String.format(Locale.getDefault(), "Rp %s", formatter.format(tunjTransport)));
            etGajiKotor.setText(String.format(Locale.getDefault(), "Rp %s", formatter.format(gajiKotor)));
            etGajiBersih.setText(String.format(Locale.getDefault(), "Rp %s", formatter.format(gajiBersih)));

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Format angka tidak valid!", Toast.LENGTH_SHORT).show();
        }
    }
}
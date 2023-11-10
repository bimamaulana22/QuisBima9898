package com.sar.bima_ti3b_kuis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nilai_tugas, nilai_quis, nilai_uts, nilai_uas;
    Button hitung, bersihkan;
    TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nilai_tugas = (EditText) findViewById(R.id.nilai_tugas);
        nilai_quis = (EditText) findViewById(R.id.nilai_quis);
        nilai_uts = (EditText) findViewById(R.id.nilai_uts);
        nilai_uas = (EditText) findViewById(R.id.nilai_uas);

        hitung = (Button)findViewById(R.id.hitung);
        bersihkan = (Button) findViewById(R.id.bersihkan);
        hasil = (TextView) findViewById(R.id.hasil);

        hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try{

                int tugas = Integer.parseInt(nilai_tugas.getText().toString());
                int quis = Integer.parseInt(nilai_quis.getText().toString());
                int uts = Integer.parseInt(nilai_uts.getText().toString());
                int uas = Integer.parseInt(nilai_uas.getText().toString());

                int tg = (int)  (((double) tugas) * 0.20);
                int qu = (int)  (((double) quis) * 0.20);
                int ut = (int)  (((double) uts) * 0.30);
                int ua = (int)  (((double) uas) * 0.30);

                int result = tg + qu + ut + ua ;
                hasil.setText(String.valueOf(result));



                } catch (Throwable e){
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan Angka pertama & Kedua", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });



        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nilai_tugas.setText("");
                nilai_quis.setText("");
                nilai_uts.setText("");
                nilai_uas.setText("");
                hasil.setText("0");
                nilai_tugas.requestFocus();
            }
        });
    }
}

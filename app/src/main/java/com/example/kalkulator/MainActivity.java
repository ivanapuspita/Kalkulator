package com.example.kalkulator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button BTNakar, BTNpangkat, BTNfaktorial, BTNpersen;
    private TextView TVhasil;
    private EditText ETangka1, ETangka2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //menghubungkan id pada MainActivity dengan id yang ada di layout
        BTNakar = findViewById(R.id.BTN_akar);
        BTNpangkat = findViewById(R.id.BTN_pangkat);
        BTNfaktorial = findViewById(R.id.BTN_faktorial);
        BTNpersen = findViewById(R.id.BTN_persen);
        TVhasil = findViewById(R.id.TV_hasil);
        ETangka1 = findViewById(R.id.ET_angka1);
        ETangka2 = findViewById(R.id.ET_angka2);

        BTNakar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //mengubah string menjadi double
                    String sAngka1 = ETangka1.getText().toString();
                    String sAngka2 = ETangka2.getText().toString();
                    double angka1 = Double.parseDouble(sAngka1);
                    double angka2 = Double.parseDouble(sAngka2);

                    //memasukkan rumus untuk menghitung akar
                    double dangka2 = 1/angka2;
                    double akar = Math.pow(angka1, dangka2);
                    //mengubah double menjadi string agar dapat dibaca
                    String sAkar = String.valueOf(akar);
                    //menampilkan hasil pada TVhasil
                    TVhasil.setText(sAkar);
                } catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"Field tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BTNpangkat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //mengubah string menjadi double
                    String sAngka1 = ETangka1.getText().toString();
                    String sAngka2 = ETangka2.getText().toString();
                    double angka1 = Double.parseDouble(sAngka1);
                    double angka2 = Double.parseDouble(sAngka2);
                    //memasukkan rumus untuk menghitung pangkat
                    double pagkat = Math.pow(angka1, angka2);
                    //mengubah double menjadi string agar dapat dibaca
                    String sPangkat = String.valueOf(pagkat);
                    //menampilkan hasil pada TVhasil
                    TVhasil.setText(sPangkat);
                } catch (NumberFormatException nfe){
                    Toast.makeText(getApplicationContext(),"Field tidak boleh kosong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        BTNfaktorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int angka1 = Integer.parseInt(ETangka1.getText().toString());
                faktorial(angka1);
            }
            //rumus untuk menghitung faktorial
            private void faktorial(int angka1) {
                int faktorial=1, i;
                for(i=angka1; i>0; i--){
                    faktorial *=i;
                }
                //mengubah menjadi string agar dapat dibaca
                String sfaktorial = String.valueOf(faktorial);
                //menampilkan hasil pada TVhasil
                TVhasil.setText(sfaktorial);
            }
        });

        BTNpersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mengubah string menjadi double
                String sAngka1 = ETangka1.getText().toString();
                double angka1 = Double.parseDouble(sAngka1);
                //rumus untuk menghitung persen
                double persen = angka1 / 100;
                //mengubah menjadi string agar dapat dibaca
                String sPersen = String.valueOf(persen);
                //menampilkan hasil pada TVhasil
                TVhasil.setText(sPersen);
            }
        });


    }
}
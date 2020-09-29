package com.example.a07_interaksi_pengguna_room_7_;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class resultpage extends AppCompatActivity {
    TextView txtHello;
    TextView txtHello1;
    TextView txtHello2;
    TextView txtRadio;
    TextView txtJurusan;

    private  String nama;
    private  String KEY_NAME = "NAMA";
    private  String nim;
    private  String KEY_NIM = "NIM";
    private  String tanggal;
    private  String KEY_DATE = "DATE";
    private  String radio;
    private  String KEY_JENISKELAMIN = "RADIO_BUTTON";
    private  String jurusan;
    private  String KEY_JURUSAN = "JURUSAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);

        txtHello = (TextView) findViewById(R.id.txtHello);
        Bundle extras = getIntent().getExtras();
        nama = extras.getString(KEY_NAME);
        txtHello.setText(nama);

        txtHello1 = (TextView) findViewById(R.id.txtHello1);
        nim = extras.getString(KEY_NIM);
        txtHello1.setText(nim);

        txtHello2 = (TextView) findViewById(R.id.txtHello2);
        tanggal = extras.getString(KEY_DATE);
        txtHello2.setText(tanggal);

        txtRadio = (TextView) findViewById(R.id.txtRadio);
        radio = extras.getString(KEY_JENISKELAMIN);
        txtRadio.setText(radio);

        txtJurusan = (TextView) findViewById(R.id.txtJurusan);
        jurusan = extras.getString(KEY_JURUSAN);
        txtJurusan.setText(jurusan);




    }
}
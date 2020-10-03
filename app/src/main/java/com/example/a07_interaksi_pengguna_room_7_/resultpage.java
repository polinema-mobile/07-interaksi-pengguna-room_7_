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

    private  String KEY_BIODATA = "BIODATA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);
        Bundle extras = getIntent().getExtras();
        Biodata biodata = extras.getParcelable(KEY_BIODATA);

        txtHello = (TextView) findViewById(R.id.txtNama);
        txtHello.setText(biodata.getNama());

        txtHello1 = (TextView) findViewById(R.id.txtNim);
        txtHello1.setText(biodata.getNim());

        txtHello2 = (TextView) findViewById(R.id.txtTTG);
        txtHello2.setText(biodata.getTanggal());

        txtRadio = (TextView) findViewById(R.id.txtKelamin);
        txtRadio.setText(biodata.getJenisKelamin());

        txtJurusan = (TextView) findViewById(R.id.txtJurusan);
        txtJurusan.setText(biodata.getJurusan());



    }
}
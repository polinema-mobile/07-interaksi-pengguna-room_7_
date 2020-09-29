package com.example.a07_interaksi_pengguna_room_7_;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PrivateKey;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] users = { "Teknik Informatika", "Teknik Sipil", "Teknik Mesin", "Teknik Kimia", "Akuntansi", "Teknik Elektro" };
    EditText name,NIM,textdate;
    RadioButton radioJk;
    Calendar calendar;
    DatePickerDialog datePickerDialog;
    RadioGroup radioGroup;
    Button buttonSubmit;
    Spinner spin;


    private String KEY_NAME = "NAMA";
    private String KEY_NIM = "NIM";
    private String KEY_JENISKELAMIN = "RADIO_BUTTON";
    private String KEY_DATE = "DATE";
    private String KEY_JURUSAN = "JURUSAN";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // mencari id dari layout dan dimasukkan ke variabel
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        name = (EditText) findViewById(R.id.editTextNama);
        NIM = (EditText) findViewById(R.id.editTextNim);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        textdate = (EditText) findViewById(R.id.editTextDate);
        spin = (Spinner) findViewById(R.id.spinner1);
        textdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calendar= Calendar.getInstance();
                int hari =calendar.get(Calendar.DAY_OF_MONTH);
                int bulan =calendar.get(Calendar.MONTH);
                int tahun =calendar.get(Calendar.YEAR);

                datePickerDialog=new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int mhari, int mbulan, int mtahun) {
                        textdate.setText(mhari+"/"+(mbulan+1)+"/"+mtahun);
                    }
                }, hari, bulan, tahun);
                datePickerDialog.show();
            }
        });


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, users);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);
        spin.setOnItemSelectedListener(this);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitHasil();
            }
        });


    }

    private void submitHasil() {
        try { //GET DATA
            String nama = name.getText().toString();
            String nim = NIM.getText().toString();
            String tanggal = textdate.getText().toString();
            int radio = radioGroup.getCheckedRadioButtonId(); //mengambil nilai id dari radio
            String jurusan = spin.getSelectedItem().toString();
            if (nama != "" && nim != ""){
                Intent i = new Intent(MainActivity.this, resultpage.class); //SEND DATA
                i.putExtra(KEY_NAME, nama);
                i.putExtra(KEY_NIM, nim);
                i.putExtra(KEY_DATE,tanggal);
                i.putExtra(KEY_JENISKELAMIN, cekJenisKelamin(radio));
                i.putExtra(KEY_JURUSAN, jurusan);
                startActivity(i);
            }else{
                Toast.makeText(getApplication(), "diisi ", Toast.LENGTH_SHORT);
            }
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(getApplication(), "Error, Coba Lagi!",Toast.LENGTH_SHORT);
        }
    }

    private String cekJenisKelamin(int jk) {
        radioJk = findViewById(jk);
        return radioJk.getText().toString();
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,long id) {
        Toast.makeText(getApplicationContext(), "Selected User: "+users[position] ,Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }
}
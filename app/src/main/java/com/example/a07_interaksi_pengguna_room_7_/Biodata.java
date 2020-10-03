package com.example.a07_interaksi_pengguna_room_7_;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.Calendar;

public class Biodata implements Parcelable {
    String nama,nim,tanggal,jurusan,jenisKelamin;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.nim);
        dest.writeString(this.tanggal);
        dest.writeString(this.jurusan);
        dest.writeString(this.jenisKelamin);
    }

    public Biodata(String nama, String nim, String tanggal, String jurusan, String jenisKelamin) {
        this.nama = nama;
        this.nim = nim;
        this.tanggal = tanggal;
        this.jurusan = jurusan;
        this.jenisKelamin = jenisKelamin;
    }

    protected Biodata(Parcel in) {
        this.nama = in.readString();
        this.nim = in.readString();
        this.tanggal = in.readString();
        this.jurusan = in.readString();
        this.jenisKelamin = in.readString();
    }

    public static final Creator<Biodata> CREATOR = new Creator<Biodata>() {
        @Override
        public Biodata createFromParcel(Parcel source) {
            return new Biodata(source);
        }

        @Override
        public Biodata[] newArray(int size) {
            return new Biodata[size];
        }

    };

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getJurusan() {
        return jurusan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }
}

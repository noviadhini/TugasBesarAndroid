package com.example.novia.semangat.model;

/**
 * Created by Novia on 16/01/2018.
 */

public class Penginapan
{
    String id;
    String nama;
    String alamat;
    String telp;
    String deskripsi;
    String Image;

    public Penginapan() {
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getTelp() {
        return telp;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getImage() {
        return Image;
    }

    public Penginapan(String id, String nama, String alamat, String telp, String deskripsi, String image) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.telp = telp;
        this.deskripsi = deskripsi;
        Image = image;
    }
}

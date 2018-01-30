package com.example.novia.semangat.model;

/**
 * Created by TOSHIBA-97 on 1/22/2018.
 */

public class Gambar
{
    int photoid;
    public Gambar(){
        super();
    }

    public Gambar(int photoid) {
        this.photoid = photoid;
    }

    public int getPhotoid() {
        return photoid;
    }

    public void setPhotoid(int photoid) {
        this.photoid = photoid;
    }
}

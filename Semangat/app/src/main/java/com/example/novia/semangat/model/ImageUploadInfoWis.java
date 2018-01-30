package com.example.novia.semangat.model;

/**
 * Created by TOSHIBA-97 on 1/27/2018.
 */

public class ImageUploadInfoWis {
    public String imageName;

    public String imageURL;
    public String alamat;
    public String telp;
    public String deskripsi;

    public String getAlamat() {
        return alamat;
    }

    public String getTelp() {
        return telp;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public ImageUploadInfoWis(String imageName, String imageURL, String alamat, String telp, String deskripsi) {
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.alamat = alamat;
        this.telp = telp;
        this.deskripsi = deskripsi;
    }

    public ImageUploadInfoWis() {

    }


    public String getImageName() {
        return imageName;
    }

    public String getImageURL() {
        return imageURL;
    }
}

package com.reynaldynurcahyo.formbiodata;

import android.os.Parcel;
import android.os.Parcelable;

public class Biodata implements Parcelable {

    private String nama, ttl, jenkel, alamat, agama, sk, pekerjaan;

    protected Biodata(Parcel in) {
        nama = in.readString();
        ttl = in.readString();
        jenkel = in.readString();
        alamat = in.readString();
        agama = in.readString();
        sk = in.readString();
        pekerjaan = in.readString();
    }

    public Biodata() {

    }

    public static final Creator<Biodata> CREATOR = new Creator<Biodata>() {
        @Override
        public Biodata createFromParcel(Parcel in) {
            return new Biodata(in);
        }

        @Override
        public Biodata[] newArray(int size) {
            return new Biodata[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nama);
        dest.writeString(ttl);
        dest.writeString(jenkel);
        dest.writeString(alamat);
        dest.writeString(agama);
        dest.writeString(sk);
        dest.writeString(pekerjaan);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }

    public String getPekerjaan() {
        return pekerjaan;
    }

    public void setPekerjaan(String pekerjaan) {
        this.pekerjaan = pekerjaan;
    }
}

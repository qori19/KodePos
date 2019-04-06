package com.example.cobaprojek1;

public class WilayahModel {
    String namaWilayah;

    String kodepos;

    public WilayahModel(String namaWilayah, String kodepos){
        this.namaWilayah = namaWilayah;
        this.kodepos = kodepos;
    }
    public String getNamaWilayah() {
        return namaWilayah;
    }


    public String getKodePos() {
        return kodepos;
    }

    public void setKodePos(String kodepos) { this.kodepos = kodepos; }
}

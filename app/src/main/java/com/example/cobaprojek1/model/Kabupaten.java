package com.example.cobaprojek1.model;

public class Kabupaten {
    private String kecamatan;
    private String kodepos;
    private String kelurahan;

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getKodepos() {
        return kodepos;
    }

    public void setKodepos(String kodepos) {
        this.kodepos = kodepos;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    @Override
    public String toString() {
        return
                "Kabupaten{" +
                        "kecamatan = '" + kecamatan + '\'' +
                        ",kodepos = '" + kodepos + '\'' +
                        ",kelurahan = '" + kelurahan + '\'' +
                        "}";
    }
}
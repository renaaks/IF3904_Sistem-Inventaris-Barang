/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Novelty Octaviani
 */
public class Barang_Masuk {
    private String kodeBarang;
    private String kodeBarangMasuk;
    private String kodePermohonan;
    private String tanggalMasuk;
    private String idPemohon;
    private int jumlahBarang;

    public Barang_Masuk(String kodeBarang, String kodeBarangMasuk, String kodePermohonan, String idPemohon, int jumlahBarang, String tanggalMasuk) {
        this.kodeBarang = kodeBarang;
        this.kodeBarangMasuk = kodeBarangMasuk;
        this.kodePermohonan = kodePermohonan;
        this.idPemohon = idPemohon;
        this.jumlahBarang = jumlahBarang;
        this.tanggalMasuk = tanggalMasuk;
    }

    public int getjumlahBarang() {
        return jumlahBarang;
    }

    public void setjumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getkodeBarang() {
        return kodeBarang;
    }

    public void setkodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getkodeBarangMasuk() {
        return kodeBarangMasuk;
    }

    public void setkodeBarangMasuk(String kodeBarangMasuk) {
        this.kodeBarangMasuk = kodeBarangMasuk;
    }

    public String getkodePermohonan() {
        return kodePermohonan;
    }

    public void setkodePermohonan(String kodePermohonan) {
        this.kodePermohonan = kodePermohonan;
    }

    public String gettanggalMasuk() {
        return tanggalMasuk;
    }

    public void settanggalMasuk(String tanggalMasuk) {
        this.tanggalMasuk = tanggalMasuk;
    }

    public String getidPemohon() {
        return idPemohon;
    }

    public void setidPemohon(String idPemohon) {
        this.idPemohon = idPemohon;
    }
    
    
}

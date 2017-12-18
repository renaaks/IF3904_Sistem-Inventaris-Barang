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
public class Barang_Keluar {
    private String kodeBarangMasuk;
    private String kodeBarangKeluar;
    private String kondisiBarang;
    private String tanggalKeluar;
    private String idPemohon;
    private int jumlahBarang;

    

    public Barang_Keluar(String kodeBarangMasuk, String kodeBarangKeluar,String idPemohon,int jumlahBarang,String kondisiBarang, String tanggalKeluar) {
       
        this.kodeBarangMasuk = kodeBarangMasuk;
        this.kodeBarangKeluar = kodeBarangKeluar;
        this.idPemohon = idPemohon;
        this.jumlahBarang = jumlahBarang;
        this.kondisiBarang = kondisiBarang;
        this.tanggalKeluar = tanggalKeluar;
    }

    public String getidPemohon() {
        return idPemohon;
    }

    public int getjumlahBarang() {
        return jumlahBarang;
    }

    public void setjumlahBarang(int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    public void setidPemohon(String idPemohon) {
        this.idPemohon = idPemohon;
    }


    

    public String getkodeBarangMasuk() {
        return kodeBarangMasuk;
    }

    public void setkodeBarangMasuk(String kodeBarangMasuk) {
        this.kodeBarangMasuk = kodeBarangMasuk;
    }

    public String getkodeBarangKeluar() {
        return kodeBarangKeluar;
    }

    public void setkodeBarangKeluar(String kodeBarangKeluar) {
        this.kodeBarangKeluar = kodeBarangKeluar;
    }

    public String getkondisiBarang() {
        return kondisiBarang;
    }

    public void setKondisiBarang(String kondisiBarang) {
        this.kondisiBarang = kondisiBarang;
    }

    public String gettanggalKeluar() {
        return tanggalKeluar;
    }

    public void settanggalKeluar(String tanggalKeluar) {
        this.tanggalKeluar = tanggalKeluar;
    }
    
    
}

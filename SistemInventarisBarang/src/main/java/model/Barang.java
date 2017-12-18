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
public class Barang {
    private String kodeBarang;
    private String namaBarang;
    private String jenisBarang;
    private int jumlahBarang;

    public Barang(String kodeBarang, String namaBarang, String jenisBarang, int jumlahBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jenisBarang = jenisBarang;
        this.jumlahBarang = jumlahBarang;
    }

    public String getkodeBarang() {
        return kodeBarang;
    }

    public void setkodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getnamaBarang() {
        return namaBarang;
    }

    public void setnamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public String getjenisBarang() {
        return jenisBarang;
    }

    public void setjenisBarang(String jenisBarang) {
        this.jenisBarang = jenisBarang;
    }

    public int getjumlahBarang() {
        return jumlahBarang;
    }

    public void setjumlahBarang (int jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Novelty Octaviani
 */
public class Barang {
    private String Kode_Barang;
    private String Nama_Barang;
    private String Jenis_Barang;
    private int Jumlah_Barang;

    public Barang(String Kode_Barang, String Nama_Barang, String Jenis_Barang, int Jumlah_Barang) {
        this.Kode_Barang = Kode_Barang;
        this.Nama_Barang = Nama_Barang;
        this.Jenis_Barang = Jenis_Barang;
        this.Jumlah_Barang = Jumlah_Barang;
    }

    public String getKode_Barang() {
        return Kode_Barang;
    }

    public void setKode_Barang(String Kode_Barang) {
        this.Kode_Barang = Kode_Barang;
    }

    public String getNama_Barang() {
        return Nama_Barang;
    }

    public void setNama_Barang(String Nama_Barang) {
        this.Nama_Barang = Nama_Barang;
    }

    public String getJenis_Barang() {
        return Jenis_Barang;
    }

    public void setJenis_Barang(String Jenis_Barang) {
        this.Jenis_Barang = Jenis_Barang;
    }

    public int getJumlah_Barang() {
        return Jumlah_Barang;
    }

    public void setJumlah_Barang (int Jumlah_Barang) {
        this.Jumlah_Barang = Jumlah_Barang;
    }
    
    
}

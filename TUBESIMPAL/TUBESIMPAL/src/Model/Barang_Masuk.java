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
public class Barang_Masuk {
    private String Kode_Barang;
    private String Kode_Barang_Masuk;
    private String Kode_Permohonan;
    private String Tanggal_Masuk;
    private String Id_Pemohon;

    public Barang_Masuk(String Kode_Barang, String Kode_Barang_Masuk, String Kode_Permohonan, String Tanggal_Masuk, String Id_Pemohon) {
        this.Kode_Barang = Kode_Barang;
        this.Kode_Barang_Masuk = Kode_Barang_Masuk;
        this.Kode_Permohonan = Kode_Permohonan;
        this.Tanggal_Masuk = Tanggal_Masuk;
        this.Id_Pemohon = Id_Pemohon;
    }

    public String getKode_Barang() {
        return Kode_Barang;
    }

    public void setKode_Barang(String Kode_Barang) {
        this.Kode_Barang = Kode_Barang;
    }

    public String getKode_Barang_Masuk() {
        return Kode_Barang_Masuk;
    }

    public void setKode_Barang_Masuk(String Kode_Barang_Masuk) {
        this.Kode_Barang_Masuk = Kode_Barang_Masuk;
    }

    public String getKode_Permohonan() {
        return Kode_Permohonan;
    }

    public void setKode_Permohonan(String Kode_Permohonan) {
        this.Kode_Permohonan = Kode_Permohonan;
    }

    public String getTanggal_Masuk() {
        return Tanggal_Masuk;
    }

    public void setTanggal_Masuk(String Tanggal_Masuk) {
        this.Tanggal_Masuk = Tanggal_Masuk;
    }

    public String getId_Pemohon() {
        return Id_Pemohon;
    }

    public void setId_Pemohon(String Id_Pemohon) {
        this.Id_Pemohon = Id_Pemohon;
    }
    
    
}

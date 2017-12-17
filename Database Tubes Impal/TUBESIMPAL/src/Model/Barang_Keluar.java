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
public class Barang_Keluar {
    private String Kode_Barang_Masuk;
    private String Kode_Barang_Keluar;
    private String Kondisi_Barang;
    private String Tanggal_Keluar;
    private String Id_Pemohon;
    private int jumlah_barang;

    

    public Barang_Keluar(String Kode_Barang_Masuk, String Kode_Barang_Keluar,String Id_Pemohon,int jumlah_barang,String Kondisi_Barang, String Tanggal_Keluar) {
       
        this.Kode_Barang_Masuk = Kode_Barang_Masuk;
        this.Kode_Barang_Keluar = Kode_Barang_Keluar;
        this.Id_Pemohon = Id_Pemohon;
        this.jumlah_barang = jumlah_barang;
        this.Kondisi_Barang = Kondisi_Barang;
        this.Tanggal_Keluar = Tanggal_Keluar;
    }

    public String getId_Pemohon() {
        return Id_Pemohon;
    }

    public int getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(int jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
    }
    public void setId_Pemohon(String Id_Pemohon) {
        this.Id_Pemohon = Id_Pemohon;
    }


    

    public String getKode_Barang_Masuk() {
        return Kode_Barang_Masuk;
    }

    public void setKode_Barang_Masuk(String Kode_Barang_Masuk) {
        this.Kode_Barang_Masuk = Kode_Barang_Masuk;
    }

    public String getKode_Barang_Keluar() {
        return Kode_Barang_Keluar;
    }

    public void setKode_Barang_Keluar(String Kode_Barang_Keluar) {
        this.Kode_Barang_Keluar = Kode_Barang_Keluar;
    }

    public String getKondisi_Barang() {
        return Kondisi_Barang;
    }

    public void setKondisi_Barang(String Kondisi_Barang) {
        this.Kondisi_Barang = Kondisi_Barang;
    }

    public String getTanggal_Keluar() {
        return Tanggal_Keluar;
    }

    public void setTanggal_Keluar(String Tanggal_Keluar) {
        this.Tanggal_Keluar = Tanggal_Keluar;
    }
    
    
}

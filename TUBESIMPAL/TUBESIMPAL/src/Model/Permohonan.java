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
public class Permohonan {
    private String Kode_Permohonan;
    private String Kode_Barang;
    private String Jumlah_Barang;
    private String Keterangan;
    private String Status;

    public Permohonan(String Kode_Permohonan, String Kode_Barang, String Jumlah_Barang, String Keterangan, String Status) {
        this.Kode_Permohonan = Kode_Permohonan;
        this.Kode_Barang = Kode_Barang;
        this.Jumlah_Barang = Jumlah_Barang;
        this.Keterangan = Keterangan;
        this.Status = Status;
    }

    public String getKode_Permohonan() {
        return Kode_Permohonan;
    }

    public void setKode_Permohonan(String Kode_Permohonan) {
        this.Kode_Permohonan = Kode_Permohonan;
    }

    public String getKode_Barang() {
        return Kode_Barang;
    }

    public void setKode_Barang(String Kode_Barang) {
        this.Kode_Barang = Kode_Barang;
    }

    public String getJumlah_Barang() {
        return Jumlah_Barang;
    }

    public void setJumlah_Barang(String Jumlah_Barang) {
        this.Jumlah_Barang = Jumlah_Barang;
    }

    public String getKeterangan() {
        return Keterangan;
    }

    public void setKeterangan(String Keterangan) {
        this.Keterangan = Keterangan;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
}

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
public class Permohonan {
    private String kodePermohonan;
    private String kodeBarang;
    private Integer jumlahBarang;
    private String keterangan;
    private String status;
    private String idPemohon;

    public Permohonan(String kodePermohonan, String kodeBarang, String idPemohon, Integer jumlahBarang, String keterangan, String status ) {
        this.kodePermohonan = kodePermohonan;
        this.kodeBarang = kodeBarang;
        this.jumlahBarang = jumlahBarang;
        this.keterangan = keterangan;
        this.status = status;
        this.idPemohon = idPemohon;
    }

    public String getidPemohon() {
        return idPemohon;
    }

    public void setidPemohon(String idPemohon) {
        this.idPemohon = idPemohon;
    }

    public String getkodePermohonan() {
        return kodePermohonan;
    }

    public void setkodePermohonan(String kodePermohonan) {
        this.kodePermohonan = kodePermohonan;
    }

    public String getkodeBarang() {
        return kodeBarang;
    }

    public void setkodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public Integer getjumlahBarang() {
        return jumlahBarang;
    }

    public void setjumlahBarang(Integer jumlahBarang) {
        this.jumlahBarang = jumlahBarang;
    }

    public String getketerangan() {
        return keterangan;
    }

    public void setketerangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getstatus() {
        return status;
    }

    public void setstatus(String status) {
        this.status = status;
    }
    
    
}

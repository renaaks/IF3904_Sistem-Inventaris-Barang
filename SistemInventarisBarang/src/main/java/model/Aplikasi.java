/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.DataBarangLogistik;
import view.LaporanLogistik;
import view.PendataanBarang;
import view.PermohonanLogistik;
import view.PermohonanPemohon;

/**
 *
 * @author Novelty Octaviani
 */
public class Aplikasi {
    private Connect data;
    
    public Aplikasi(){
        this.data = new Connect();
        data.tryConnect();
    }
    
    
    public Pemohon cekpemohon(String username, String password) {
        if (data.loginPemohon(username, password)!= null){
            return data.loginPemohon(username, password);
        } else {
            return null;
        }
    }
    
    public Barang carikodebarang (String kodeBarang){
        if (data.caridatabarang(kodeBarang)!= null){
            return data.caridatabarang(kodeBarang);
        }else {
            return null;
        }
    }
    
    public void addpermohonan(Permohonan per) {
        data.savepermohonan(per);
    }
    
   

    public void showTabelPermohonan(PermohonanPemohon view, String id) {
        data.loadDataPermohonan(view,id);
    }

    

    public void showTabelBarang(DataBarangLogistik view) {
       data.loadDataBarang(view);
    }

    public void addbarang(Barang brg) {
        data.savebarang(brg);
    }

    public void showTabelBarangMasukLaporanLogistik(LaporanLogistik view) {
        data.loadDataBarangMasukLaporanLogistik(view);
    }

    public void showTabelBarangKeluarLaporanLogistik(LaporanLogistik view) {
        data.loadDataBarangKeluarLaporanLogistik(view);
    }

    

    public Barang_Masuk carikodebarangmasuk(String kodeBarangMasuk) {
        if (data.caridatabarangmasuk(kodeBarangMasuk)!= null){
            return data.caridatabarangmasuk(kodeBarangMasuk);
        }else {
            return null;
        }
    }

    public void addbarangkeluar(Barang_Keluar brgkeluar) {
        data.savebarangkeluar(brgkeluar);
    }

    public void showTabelBarangKeluarPemohon(PendataanBarang view, String idPemohon) {
        data.loadDataBarangKeluarPemohon(view, idPemohon);
    }

    public void showTabelBarangMasukPemohon(PendataanBarang view, String idPemohon) {
        data.loadDataBarangMasukPemohon(view, idPemohon);
    }

    public void updateBarangMasuk(String kodeBarangMasuk, int sisaBarang) {
        data.ubahBarangMasuk(kodeBarangMasuk, sisaBarang);
    }


    public Permohonan carikodepermohonan(String kodepermohonan) {
        if (data.carikodepermohonan(kodepermohonan)!= null){
            return data.carikodepermohonan(kodepermohonan);
        }else {
            return null;
        }}

    public void updatepermohonan(String kodepermohonan, String status) {
        data.ubahpermohonan(kodepermohonan,status);
    }

    public void showTabelPermohonan(PermohonanLogistik view) {
        data.loaddatapermohonanditerima(view);
        data.loaddatapermohonanditolak(view);
        data.loaddatapermohonanmenunggu(view);
    }

    public void tambahbarangmasuk(Permohonan prmhn,String tglmsk) {
        data.savebarangmasuk(prmhn, tglmsk);
    }

    public void updateBarang(Permohonan prmhn) {
       data.ubahBarang(prmhn);
    }

    public void showTabelBarangPemohon(PermohonanPemohon view) {
        data.loadDataBarangPemohon(view);
    }

    public int cariJumlahBarang(String kodeBarang) {
        return data.jumlahbarang(kodeBarang);
    }
}

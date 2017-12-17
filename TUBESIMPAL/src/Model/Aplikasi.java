/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connect;
import View.DataBarangLogistik;
import View.LaporanLogistik;
import View.PendataanBarang;
import View.PermohonanLogistik;
import View.PermohonanPemohon;

/**
 *
 * @author Novelty Octaviani
 */
public class Aplikasi {
    private Barang barang;
    private Barang_Keluar barangKeluar;
    private Barang_Masuk barangMasuk;
    private Pemohon pemohon;
    private Permohonan permohonan;
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
    
    public Barang carikodebarang (String Kode_Barang){
        if (data.caridatabarang(Kode_Barang)!= null){
            return data.caridatabarang(Kode_Barang);
        }else {
            return null;
        }
    }
    
    public void addpermohonan(Permohonan per) {
        data.savepermohonan(per);
    }
    
   

    public void showTabelPermohonan(PermohonanPemohon view, String id) {
        data.LoadDataPermohonan(view,id);
    }

    

    public void showTabelBarang(DataBarangLogistik view) {
       data.LoadDataBarang(view);
    }

    public void addbarang(Barang brg) {
        data.savebarang(brg);
    }

    public void showTabelBarangMasukLaporanLogistik(LaporanLogistik view) {
        data.LoadDataBarangMasukLaporanLogistik(view);
    }

    public void showTabelBarangKeluarLaporanLogistik(LaporanLogistik view) {
        data.LoadDataBarangKeluarLaporanLogistik(view);
    }

    

    public Barang_Masuk carikodebarangmasuk(String kode_barang_masuk) {
        if (data.caridatabarangmasuk(kode_barang_masuk)!= null){
            return data.caridatabarangmasuk(kode_barang_masuk);
        }else {
            return null;
        }
    }

    public void addbarangkeluar(Barang_Keluar brgkeluar) {
        data.savebarangkeluar(brgkeluar);
    }

    public void showTabelBarangKeluarPemohon(PendataanBarang view, String id_Pemohon) {
        data.LoadDataBarangKeluarPemohon(view, id_Pemohon);
    }

    public void showTabelBarangMasukPemohon(PendataanBarang view, String id_Pemohon) {
        data.loadDataBarangMasukPemohon(view, id_Pemohon);
    }

    public void updateBarangMasuk(String kode_barang_masuk, int sisaBarang) {
        data.ubahBarangMasuk(kode_barang_masuk, sisaBarang);
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
        data.LoadDataBarangPemohon(view);
    }

    public int cariJumlahBarang(String kode_Barang) {
        return data.jumlahbarang(kode_Barang);
    }


   


   
}

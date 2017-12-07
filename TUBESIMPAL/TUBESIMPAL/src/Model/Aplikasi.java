/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Connect;

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
    
}

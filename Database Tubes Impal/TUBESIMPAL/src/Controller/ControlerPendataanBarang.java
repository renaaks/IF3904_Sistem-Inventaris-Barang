/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import Model.Barang_Keluar;
import Model.Barang_Masuk;
import Model.Pemohon;
import View.PendataanBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerPendataanBarang implements ActionListener{
    
    private Aplikasi model;
    private PendataanBarang view;
    private Connect data=new Connect();
    private Pemohon p;
    
    ControlerPendataanBarang (Aplikasi model, Pemohon p){
        this.p = p;
        this.model = model;
        data.tryConnect();
        view = new PendataanBarang();
        view.setVisible(true);
        view.addListener(this);
        Random r = new Random();
        int randId = r.nextInt(999-111) + 111;
        view.getTfbarangkeluarpemohon().setText("BRGKLR"+Integer.toString(randId));
        model.showTabelBarangKeluarPemohon(view,p.getId_Pemohon());
        model.showTabelBarangMasukPemohon(view,p.getId_Pemohon());
    }
      
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getBtnaddbarangkeluarpemohon()){
        if (view.getTfkodebarangmasukpemohon().getText().equals("")||view.getTfkondisibarangpemohon().getText().equals("")||view.getTftanggalkeluarpemohon().getText().equals("")||view.getTfjumlahbarangkeluar().getText().equals("")){
               JOptionPane.showMessageDialog(null, "lengkapi data terlebih dahulu");
           }
           else {
               String kode_barang_keluar = view.getTfbarangkeluarpemohon().getText();
               String kode_barang_masuk = view.getTfkodebarangmasukpemohon().getText();
               int jumlah_barang = Integer.parseInt(view.getTfjumlahbarangkeluar().getText());
               String kondisi_barang = view.getTfkondisibarangpemohon().getText();
               String tanggal_keluar = view.getTftanggalkeluarpemohon().getText();
               if (model.carikodebarangmasuk(kode_barang_masuk) != null){ //cari kode barang
                   //cek apakah jumlah barang mencukupi
                    Barang_Masuk brg = model.carikodebarangmasuk(kode_barang_masuk);
                    if (brg.getJumlah_barang()>=jumlah_barang) {
                        int sisaBarang = brg.getJumlah_barang()-jumlah_barang;
                        model.updateBarangMasuk(kode_barang_masuk, sisaBarang);
                        Barang_Keluar brgkeluar = new Barang_Keluar (kode_barang_masuk, kode_barang_keluar, p.getId_Pemohon(), jumlah_barang, kondisi_barang, tanggal_keluar);
                        model.addbarangkeluar(brgkeluar);
                        model.showTabelBarangKeluarPemohon(view,p.getId_Pemohon());
                        model.showTabelBarangMasukPemohon(view, p.getId_Pemohon());
                    } else {
                        JOptionPane.showMessageDialog(null, "Jumlah data barang yang tersedia tidak mencukupi");
                    }
               }else {
               JOptionPane.showMessageDialog(null, "Kode barang yang anda masukan tidak sesuai");
               }
           }
           
        } else if (source == view.getBtnbackpendataanbarangpemohon()){
            new ControlerMenuPemohon(model,p);
            view.dispose();
        } else if (source == view.getBtnlogoutpendataanbarangpemohon()){
            new ControlerLogin(model);
            view.dispose();
        }
        view.refresh("");
    }
}

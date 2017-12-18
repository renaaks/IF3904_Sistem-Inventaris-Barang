/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import model.Barang_Keluar;
import model.Barang_Masuk;
import model.Connect;
import model.Pemohon;
import view.PendataanBarang;
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
        model.showTabelBarangKeluarPemohon(view,p.getidPemohon());
        model.showTabelBarangMasukPemohon(view,p.getidPemohon());
    }
      
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getBtnaddbarangkeluarpemohon()){
        if (view.getTfkodebarangmasukpemohon().getText().equals("")||view.getTfkondisibarangpemohon().getText().equals("")||view.getTftanggalkeluarpemohon().getText().equals("")||view.getTfjumlahbarangkeluar().getText().equals("")){
               JOptionPane.showMessageDialog(null, "lengkapi data terlebih dahulu");
           }
           else {
               String kodeBarangKeluar = view.getTfbarangkeluarpemohon().getText();
               String kodeBarangMasuk = view.getTfkodebarangmasukpemohon().getText();
               int jumlahBarang = Integer.parseInt(view.getTfjumlahbarangkeluar().getText());
               String kondisiBarang = view.getTfkondisibarangpemohon().getText();
               String tanggalKeluar = view.getTftanggalkeluarpemohon().getText();
               if (model.carikodebarangmasuk(kodeBarangMasuk) != null){ //cari kode barang
                   //cek apakah jumlah barang mencukupi
                    Barang_Masuk brg = model.carikodebarangmasuk(kodeBarangMasuk);
                    if (brg.getjumlahBarang()>=jumlahBarang) {
                        int sisaBarang = brg.getjumlahBarang()-jumlahBarang;
                        model.updateBarangMasuk(kodeBarangMasuk, sisaBarang);
                        Barang_Keluar brgkeluar = new Barang_Keluar (kodeBarangMasuk, kodeBarangKeluar, p.getidPemohon(), jumlahBarang, kondisiBarang, tanggalKeluar);
                        model.addbarangkeluar(brgkeluar);
                        model.showTabelBarangKeluarPemohon(view,p.getidPemohon());
                        model.showTabelBarangMasukPemohon(view, p.getidPemohon());
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

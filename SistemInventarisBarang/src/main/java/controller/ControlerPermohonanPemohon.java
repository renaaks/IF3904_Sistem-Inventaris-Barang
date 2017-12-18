/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import model.Barang;
import model.Connect;
import model.Pemohon;
import model.Permohonan;
import view.PermohonanPemohon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerPermohonanPemohon implements ActionListener {
    private Aplikasi model;
    private PermohonanPemohon view;
    private Connect data=new Connect();
    private Pemohon p;
    
    ControlerPermohonanPemohon(Aplikasi model, Pemohon p){
        this.p = p;
        this.model = model;
        data.tryConnect();
        view = new PermohonanPemohon();
        view.setVisible(true);
        view.addListener(this);
        Random r = new Random();
        int randId = r.nextInt(999-111) + 111;
        view.getTfkodepermohonanpemohon().setText("PRMHN"+Integer.toString(randId));
        model.showTabelPermohonan(view,p.getidPemohon());
        model.showTabelBarangPemohon(view);
    }
 
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
        if (source == view.getBtnaddpermohonanpemohon()){
            if (view.getTfjumlahbarangpemohon().getText().equals("")||view.getTfketeranganpemohon().getText().equals("")||view.getTfkodebarangpemohon().getText().equals("")||view.getTfkodepermohonanpemohon().getText().equals("")){
               JOptionPane.showMessageDialog(null, "lengkapi data terlebih dahulu");
           }
           else {
               String keteranganPemohon = view.getTfketeranganpemohon().getText();
               String kodeBarang = view.getTfkodebarangpemohon().getText();
               String kodePermohonan = view.getTfkodepermohonanpemohon().getText();
               int jumlah_barang = Integer.parseInt(view.getTfjumlahbarangpemohon().getText());
               String status = "menunggu";
               if (model.carikodebarang(kodeBarang) != null){ //cari kode barang
                   //cek apakah jumlah barang mencukupi
                    Barang brg = model.carikodebarang(kodeBarang);
                    if (brg.getjumlahBarang()>=jumlah_barang) {
                        Permohonan permohonan = new Permohonan(kodePermohonan, kodeBarang, p.getidPemohon(), jumlah_barang, keteranganPemohon, status);
                        model.addpermohonan(permohonan);
                        model.showTabelPermohonan(view,p.getidPemohon());
                    } else {
                        JOptionPane.showMessageDialog(null, "Jumlah data barang yang tersedia tidak mencukupi");
                    }
               }else {
               JOptionPane.showMessageDialog(null, "Kode barang yang anda masukan tidak sesuai");
               }
           }
       }else if (source == view.getBtnbackpermohonanpemohon()){
           new ControlerMenuPemohon(model,p);
           view.dispose();
       } else if (source == view.getBtnlogoutpermohonanpemohon()){
           new ControlerLogin(model);
           view.dispose();
       }
       view.refresh("");
    }
}

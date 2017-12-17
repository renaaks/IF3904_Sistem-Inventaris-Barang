/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import Model.Barang;
import Model.Pemohon;
import Model.Permohonan;
import View.PermohonanPemohon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerPermohonanPemohon implements ActionListener{
    
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
        model.showTabelPermohonan(view,p.getId_Pemohon());
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
               String keteranganpemohon = view.getTfketeranganpemohon().getText();
               String kode_barang = view.getTfkodebarangpemohon().getText();
               String kode_permohonan = view.getTfkodepermohonanpemohon().getText();
               int jumlah_barang = Integer.parseInt(view.getTfjumlahbarangpemohon().getText());
               String status = "menunggu";
               if (model.carikodebarang(kode_barang) != null){ //cari kode barang
                   //cek apakah jumlah barang mencukupi
                    Barang brg = model.carikodebarang(kode_barang);
                    if (brg.getJumlah_Barang()>=jumlah_barang) {
                        Permohonan permohonan = new Permohonan(kode_permohonan, kode_barang, p.getId_Pemohon(), jumlah_barang, keteranganpemohon, status);
                        model.addpermohonan(permohonan);
                        model.showTabelPermohonan(view,p.getId_Pemohon());
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

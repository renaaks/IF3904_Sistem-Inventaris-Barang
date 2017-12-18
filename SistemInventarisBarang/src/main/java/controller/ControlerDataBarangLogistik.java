/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import model.Barang;
import model.Connect;
import view.DataBarangLogistik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerDataBarangLogistik implements ActionListener {
    private Aplikasi model;
    private DataBarangLogistik view;
    private Connect data=new Connect();
    
    ControlerDataBarangLogistik(Aplikasi model){
        this.model = model;
        data.tryConnect();
        view = new DataBarangLogistik();
        view.setVisible(true);
        view.addListener((ActionListener) this);
        Random r = new Random();
        int randId = r.nextInt(999-111) + 111;
        view.getTfkodebarangdatabaranglogistik().setText("BRG"+Integer.toString(randId));
        model.showTabelBarang(view);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getBtnadddatabaranglogistik()){
            if (view.getTfkodebarangdatabaranglogistik().getText().equals("")||view.getTfjenisbarangdatabaranglogistik().getText().equals("")||view.getTfjumlahbarangdatabaranglogistik().getText().equals("")||view.getTfnamabarangdatabaranglogistik().getText().equals("")){
                JOptionPane.showMessageDialog(null, "lengkapi data terlebih dahulu");
            }
            else{
                String kodebarang = view.getTfkodebarangdatabaranglogistik().getText();
                String namabarang = view.getTfnamabarangdatabaranglogistik().getText();
                String jenisbarang = view.getTfjenisbarangdatabaranglogistik().getText();
                int jumlahbarang = Integer.parseInt(view.getTfjumlahbarangdatabaranglogistik().getText());
                Barang brg = new Barang(kodebarang, namabarang, jenisbarang, jumlahbarang);
                model.addbarang(brg);
                model.showTabelBarang(view);
            }
        view.refresh("");
        } else if (source == view.getBtnbackdatabaranglogistik()){
            new ControlerMenuLogistik(model);
            view.dispose();
        } else if (source == view.getBtnlogoutdatabaranglogistik()){
            new ControlerLogin(model);
            view.dispose();
        }
    view.refresh("");
    }
}

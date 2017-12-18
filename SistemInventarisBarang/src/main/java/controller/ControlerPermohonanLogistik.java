/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import model.Connect;
import model.Permohonan;
import view.PermohonanLogistik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerPermohonanLogistik implements ActionListener{
    private Aplikasi model;
    private PermohonanLogistik view;
    private Connect data=new Connect();

    
    ControlerPermohonanLogistik (Aplikasi model){
        this.model = model;
        data.tryConnect();
        view = new PermohonanLogistik();
        view.setVisible(true);
        view.addListener(this);
        view.getRbtolak().setSelected(true);
        model.showTabelPermohonan(view);
    }
    
 
   
    @Override
    public void actionPerformed(ActionEvent ae) {
      Object source = ae.getSource();
      if (source == view.getBtnaddpermohonanlogistik()){
         if (view.getTfkodepermohonanlogistik().getText().equals("")||view.getTftanggalbarangmasuklogistik().getText().equals("")) {
             JOptionPane.showMessageDialog(null, " Lengkapi data terlebih dahulu ");
         } else {
                String kodepermohonan = view.getTfkodepermohonanlogistik().getText();
                String tanggalbarangmasuk = view.getTftanggalbarangmasuklogistik().getText();
                Permohonan prmhn = model.carikodepermohonan(kodepermohonan);
                if ((prmhn != null)&&(prmhn.getstatus().equals("menunggu"))){
                    String status="";  
                    int jumlah = model.cariJumlahBarang(prmhn.getkodeBarang());
                    if (view.getRbterima().isSelected()){
                        if (jumlah >= prmhn.getjumlahBarang()){
                            status="diterima";
                            model.updatepermohonan(kodepermohonan,status);
                            JOptionPane.showMessageDialog(null, " Permohonan telah diterima");
                            model.tambahbarangmasuk(prmhn,tanggalbarangmasuk);
                            model.updateBarang(prmhn);
                        } else {
                            JOptionPane.showMessageDialog(null, "barang kurang");
                        }
                    } else {
                        status="ditolak";
                        model.updatepermohonan(kodepermohonan,status);
                        JOptionPane.showMessageDialog(null, " Permohonan telah ditolak");
                    }
                    model.showTabelPermohonan(view);
               }else {
                    JOptionPane.showMessageDialog(null, " kode permohonan tidak ditemukan atau permohonan telah divalidasi sebelumnya");
                }
          }
      }else if (source == view.getBtnbackpermohonanlogistik()){
          new ControlerMenuLogistik(model);
          view.dispose();
      } else if (source == view.getBtnlogoutpermohonanlogistik()){
          new ControlerLogin(model);
          view.dispose();
      }
      view.refresh("");
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import View.LaporanLogistik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Novelty Octaviani
 */
public class ControlerLaporanLogistik implements ActionListener{
    private Aplikasi model;
    private LaporanLogistik view;
    private Connect data=new Connect();

    
    ControlerLaporanLogistik(Aplikasi model){
        this.model = model;
        data.tryConnect();
        view = new LaporanLogistik();
        view.setVisible(true);
        view.addListener(this);
    }
    
     
      
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       if (source == view.getBtnbacklaporanlogistik()){
           new ControlerMenuLogistik(model);
           view.dispose();
       } else if (source == view.getBtnlogoutlaporanlogistik()){
           new ControlerLogin(model);
           view.dispose();
       }
    }
}

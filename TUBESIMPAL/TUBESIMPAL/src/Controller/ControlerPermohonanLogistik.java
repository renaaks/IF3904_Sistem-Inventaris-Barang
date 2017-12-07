/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import View.PermohonanLogistik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerPermohonanLogistik implements ActionListener {

    private Aplikasi model;
    private PermohonanLogistik view;
    private Connect data=new Connect();

    
    ControlerPermohonanLogistik (Aplikasi model){
        this.model = model;
        data.tryConnect();
        view = new PermohonanLogistik();
        view.setVisible(true);
        view.addListener(this);
    }
    
    
   
    @Override
    public void actionPerformed(ActionEvent ae) {
      Object source = ae.getSource();
      if (source == view.getBtnaddpermohonanlogistik()){
          
      }else if (source == view.getBtnbackpermohonanlogistik()){
          new ControlerMenuLogistik(model);
          view.dispose();
      } else if (source == view.getBtnlogoutpermohonanlogistik()){
          new ControlerLogin(model);
          view.dispose();
      }
    }
    
}

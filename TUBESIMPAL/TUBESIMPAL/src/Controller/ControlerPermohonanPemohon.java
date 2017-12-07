/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import Model.Pemohon;
import View.PermohonanPemohon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    }
     
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       if (source == view.getBtnaddpermohonanpemohon()){
           
       }else if (source == view.getBtnbackpermohonanpemohon()){
           new ControlerMenuPemohon(model,p);
           view.dispose();
       } else if (source == view.getBtnlogoutpermohonanpemohon()){
           new ControlerLogin(model);
           view.dispose();
       }
    }
}

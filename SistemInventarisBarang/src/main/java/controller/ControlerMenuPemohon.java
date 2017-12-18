/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import model.Connect;
import model.Pemohon;
import view.MenuPemohon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerMenuPemohon implements ActionListener {
    private Aplikasi model;
    private MenuPemohon view;
    private Connect data=new Connect();
    private Pemohon p;

    
    ControlerMenuPemohon(Aplikasi model, Pemohon p){
        this.model = model;
        this.p = p;
        data.tryConnect();
        view = new MenuPemohon();
        view.setVisible(true);
        view.addListener(this);
    }



   
    @Override
    public void actionPerformed(ActionEvent ae) {
       Object source = ae.getSource();
       if (source == view.getBtnlogoutpemohon()){
           new ControlerLogin(model);
           view.dispose();
       }else if (source == view.getBtnpendataanbarangpemohon()){
           new ControlerPendataanBarang(model,p);
           view.dispose();
       }else if (source == view.getBtnpermohonanpemohon()){
           new ControlerPermohonanPemohon(model,p);
           view.dispose();
       }
    }
}

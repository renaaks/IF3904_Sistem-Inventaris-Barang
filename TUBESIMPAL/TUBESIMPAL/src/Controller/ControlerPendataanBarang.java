/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import Model.Pemohon;
import View.PendataanBarang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

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
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getBtnaddbarangkeluarpemohon()){
            
        } else if (source == view.getBtnbackpendataanbarangpemohon()){
            new ControlerMenuPemohon(model,p);
            view.dispose();
        } else if (source == view.getBtnlogoutpendataanbarangpemohon()){
            new ControlerLogin(model);
            view.dispose();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import View.DataBarangLogistik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerDataBarangLogistik implements ActionListener{
    private Aplikasi model;
    private DataBarangLogistik view;
    private Connect data=new Connect();
    
    ControlerDataBarangLogistik(Aplikasi model){
        this.model = model;
        data.tryConnect();
        view = new DataBarangLogistik();
        view.setVisible(true);
        view.addListener(this);
        Random r = new Random();
        int randId = r.nextInt(999-111) + 111;
        view.getTfkodebarangdatabaranglogistik().setText("BRG"+Integer.toString(randId));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getBtnadddatabaranglogistik()){
            
        } else if (source == view.getBtnbackdatabaranglogistik()){
            new ControlerMenuLogistik(model);
            view.dispose();
        } else if (source == view.getBtnlogoutdatabaranglogistik()){
            new ControlerLogin(model);
            view.dispose();
        }
    }
    
}

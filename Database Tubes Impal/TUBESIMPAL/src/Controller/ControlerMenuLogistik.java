/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Connect;
import Model.Aplikasi;
import View.MenuLogistik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerMenuLogistik implements ActionListener {

    private Aplikasi model;
    private MenuLogistik view;
    private Connect data=new Connect();

    
    ControlerMenuLogistik (Aplikasi model){
        this.model = model;
        data.tryConnect();
        view = new MenuLogistik();
        view.setVisible(true);
        view.addListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getBtnlogout()){
            new ControlerLogin(model);
            view.dispose();
        }else if (source == view.getBtndatabaranglogistik()){
            new ControlerDataBarangLogistik(model);
            view.dispose();
        }else if (source == view.getBtnlaporanlogistik()){
            new ControlerLaporanLogistik(model);
            view.dispose();
        }else if (source == view.getBtnpermohonanlogistik()){
            new ControlerPermohonanLogistik(model);
            view.dispose();
        }
    }
    
}

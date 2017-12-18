/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Aplikasi;
import model.Connect;
import model.Pemohon;
import view.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Novelty Octaviani
 */
public class ControlerLogin implements ActionListener{
    private Aplikasi model;
    private Login view;
    private Connect data=new Connect();

    
    public ControlerLogin(Aplikasi model){
        this.model = model;
        
        data.tryConnect();
        
        view = new Login();
        view.setVisible(true);
        view.addListener(this);
    }


    
   


    

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source == view.getBtnlogin()){
            String username = view.getTfusername().getText();
            String password = view.getTfpassword().getText();
            if (username.equals("")|| password.equals("")){
                JOptionPane.showMessageDialog(null, " username atau password harus terisi ");
            }
            else {
                if (username.equals("logistik") && password.equals("logistik")){
                    new ControlerMenuLogistik(model);
                    view.dispose();
                }else if (model.cekpemohon(username,password) != null){
                    Pemohon p = model.cekpemohon(username, password);
                    new ControlerMenuPemohon(model,p);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau password tidak terdaftar");
                }
            }
            view.refresh("");
        }
    }
}

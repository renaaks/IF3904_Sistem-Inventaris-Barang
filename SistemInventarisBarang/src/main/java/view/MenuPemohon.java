/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Novelty Octaviani
 */
public class MenuPemohon extends javax.swing.JFrame {

    /**
     * Creates new form MenuPemohon
     */
    public MenuPemohon() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnpermohonanpemohon = new javax.swing.JButton();
        btnpendataanbarangpemohon = new javax.swing.JButton();
        btnlogoutpemohon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Menu Pemohon");

        btnpermohonanpemohon.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnpermohonanpemohon.setText("Permohonan");

        btnpendataanbarangpemohon.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnpendataanbarangpemohon.setText("Pendataan Barang");

        btnlogoutpemohon.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jLabel2)
                .addContainerGap(155, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnpermohonanpemohon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnpendataanbarangpemohon, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnlogoutpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(57, 57, 57)
                .addComponent(btnpermohonanpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnpendataanbarangpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addComponent(btnlogoutpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void addListener(ActionListener e){
        btnpendataanbarangpemohon.addActionListener(e);
        btnpermohonanpemohon.addActionListener(e);
        btnlogoutpemohon.addActionListener(e);
        
    }
    public JButton getBtnpendataanbarangpemohon() {
        return btnpendataanbarangpemohon;
    }

    public JButton getBtnpermohonanpemohon() {
        return btnpermohonanpemohon;
    }

    public JButton getBtnlogoutpemohon() {
        return btnlogoutpemohon;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlogoutpemohon;
    private javax.swing.JButton btnpendataanbarangpemohon;
    private javax.swing.JButton btnpermohonanpemohon;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}

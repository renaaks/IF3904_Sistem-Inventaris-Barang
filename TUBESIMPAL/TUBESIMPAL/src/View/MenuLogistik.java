/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Novelty Octaviani
 */
public class MenuLogistik extends javax.swing.JFrame {

    /**
     * Creates new form MenuLogistik
     */
    public MenuLogistik() {
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

        jLabel1 = new javax.swing.JLabel();
        btnpermohonanlogistik = new javax.swing.JButton();
        btndatabaranglogistik = new javax.swing.JButton();
        btnlaporanlogistik = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setText("Menu Logistik");

        btnpermohonanlogistik.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnpermohonanlogistik.setText("Permohonan");
        btnpermohonanlogistik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpermohonanlogistikActionPerformed(evt);
            }
        });

        btndatabaranglogistik.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btndatabaranglogistik.setText("Data Barang");

        btnlaporanlogistik.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnlaporanlogistik.setText("Laporan");
        btnlaporanlogistik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlaporanlogistikActionPerformed(evt);
            }
        });

        btnlogout.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnpermohonanlogistik, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(btndatabaranglogistik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnlaporanlogistik, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)))
                .addContainerGap(196, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(80, 80, 80)
                .addComponent(btnpermohonanlogistik, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndatabaranglogistik, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btnlaporanlogistik, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(btnlogout)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlaporanlogistikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlaporanlogistikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlaporanlogistikActionPerformed

    private void btnpermohonanlogistikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpermohonanlogistikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpermohonanlogistikActionPerformed
    
    public void addListener(ActionListener e){
        btndatabaranglogistik.addActionListener(e);
        btnlaporanlogistik.addActionListener(e);
        btnlogout.addActionListener(e);
        btnpermohonanlogistik.addActionListener(e);
                
    }
    public JButton getBtndatabaranglogistik() {
        return btndatabaranglogistik;
    }

    public JButton getBtnlaporanlogistik() {
        return btnlaporanlogistik;
    }

    public JButton getBtnlogout() {
        return btnlogout;
    }

    public JButton getBtnpermohonanlogistik() {
        return btnpermohonanlogistik;
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndatabaranglogistik;
    private javax.swing.JButton btnlaporanlogistik;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnpermohonanlogistik;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}

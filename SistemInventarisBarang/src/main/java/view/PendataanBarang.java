/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Novelty Octaviani
 */
public class PendataanBarang extends javax.swing.JFrame {

    /**
     * Creates new form PendataanBarang
     */
    public PendataanBarang() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelbarangkeluarpemohon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelbarangmasukpemohon = new javax.swing.JTable();
        tfbarangkeluarpemohon = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfkodebarangmasukpemohon = new javax.swing.JTextField();
        tfkondisibarangpemohon = new javax.swing.JTextField();
        tftanggalkeluarpemohon = new javax.swing.JTextField();
        btnaddbarangkeluarpemohon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfjumlahbarangkeluar = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnbackpendataanbarangpemohon = new javax.swing.JButton();
        btnlogoutpendataanbarangpemohon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setText("Pendataan Barang");

        tabelbarangkeluarpemohon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Barang Masuk", "Kode Barang Keluar", "Jumlah Barang", "Kondisi Barang", "Tanggal Keluar"
            }
        ));
        jScrollPane2.setViewportView(tabelbarangkeluarpemohon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lihat Barang Keluar", jPanel2);

        tabelbarangmasukpemohon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Kode Barang", "Kode Barang Masuk", "Kode Permohonan", "Jumlah Barang", "Tanggal Masuk"
            }
        ));
        jScrollPane1.setViewportView(tabelbarangmasukpemohon);

        tfbarangkeluarpemohon.setEditable(false);
        tfbarangkeluarpemohon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfbarangkeluarpemohonActionPerformed(evt);
            }
        });

        jLabel1.setText("Kode barang keluar :");

        jLabel3.setText("Kode barang masuk :");

        jLabel4.setText("Kondisi barang        :");

        jLabel5.setText("Tanggal keluar        :");

        btnaddbarangkeluarpemohon.setText("ADD");

        jLabel6.setText("Jumlah barang        :");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Penambahan Barang Keluar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnaddbarangkeluarpemohon)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel3))
                                        .addGap(1, 1, 1)))
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(tfbarangkeluarpemohon)
                                    .addComponent(tfkodebarangmasukpemohon)
                                    .addComponent(tfkondisibarangpemohon)
                                    .addComponent(tftanggalkeluarpemohon, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                                    .addComponent(tfjumlahbarangkeluar)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfbarangkeluarpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfkodebarangmasukpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfjumlahbarangkeluar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfkondisibarangpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tftanggalkeluarpemohon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(btnaddbarangkeluarpemohon)
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Lihat Barang Masuk", jPanel1);

        btnbackpendataanbarangpemohon.setText("Back");

        btnlogoutpendataanbarangpemohon.setText("Logout");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnbackpendataanbarangpemohon)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlogoutpendataanbarangpemohon)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbackpendataanbarangpemohon)
                    .addComponent(btnlogoutpendataanbarangpemohon))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfbarangkeluarpemohonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfbarangkeluarpemohonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfbarangkeluarpemohonActionPerformed

    public void addListener(ActionListener e){
        btnaddbarangkeluarpemohon.addActionListener(e);
        btnbackpendataanbarangpemohon.addActionListener(e);
        btnlogoutpendataanbarangpemohon.addActionListener(e);
                
    }
    
    public JButton getBtnaddbarangkeluarpemohon() {
        return btnaddbarangkeluarpemohon;
    }

    public JButton getBtnbackpendataanbarangpemohon() {
        return btnbackpendataanbarangpemohon;
    }

    public JButton getBtnlogoutpendataanbarangpemohon() {
        return btnlogoutpendataanbarangpemohon;
    }

    public JTable getTabelbarangkeluarpemohon() {
        return tabelbarangkeluarpemohon;
    }

    public JTable getTabelbarangmasukpemohon() {
        return tabelbarangmasukpemohon;
    }

    public JTextField getTfbarangkeluarpemohon() {
        return tfbarangkeluarpemohon;
    }

    public JTextField getTfkodebarangmasukpemohon() {
        return tfkodebarangmasukpemohon;
    }

    public JTextField getTfkondisibarangpemohon() {
        return tfkondisibarangpemohon;
    }

    public JTextField getTftanggalkeluarpemohon() {
        return tftanggalkeluarpemohon;
    }

    public JTextField getTfjumlahbarangkeluar() {
        return tfjumlahbarangkeluar;
    }

    
    public void refresh(String s){
        tfkodebarangmasukpemohon.setText(s);
        tfkondisibarangpemohon.setText(s);
        tftanggalkeluarpemohon.setText(s);
        tfjumlahbarangkeluar.setText(s);
        Random r = new Random();
        int randId = r.nextInt(999-111) + 111;
        tfbarangkeluarpemohon.setText("BRGKLR"+Integer.toString(randId));
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaddbarangkeluarpemohon;
    private javax.swing.JButton btnbackpendataanbarangpemohon;
    private javax.swing.JButton btnlogoutpendataanbarangpemohon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelbarangkeluarpemohon;
    private javax.swing.JTable tabelbarangmasukpemohon;
    private javax.swing.JTextField tfbarangkeluarpemohon;
    private javax.swing.JTextField tfjumlahbarangkeluar;
    private javax.swing.JTextField tfkodebarangmasukpemohon;
    private javax.swing.JTextField tfkondisibarangpemohon;
    private javax.swing.JTextField tftanggalkeluarpemohon;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import com.sun.org.apache.xalan.internal.xsltc.runtime.BasisLibrary;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kontrol.kontrol_masakan;

/**
 *
 * @author RPL22
 */
public class masakan extends javax.swing.JInternalFrame {
    kontrol_masakan k;
    String idmasakan,namamasakan,statusmakanan;
    int harga;
            
    /**
     * Creates new form user
     */
    public masakan() {
        initComponents();
        k = new kontrol_masakan();
        tampildata();
        setobjek(false);
        baru.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtidmasakan = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnamamasakan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtharga = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbmasakan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        baru = new javax.swing.JButton();
        update = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        cbstatus = new javax.swing.JComboBox();
        canceledit = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("MASAKAN");

        jLabel2.setText("ID Masakan          :");

        jLabel3.setText("Nama Masakan     : ");

        jLabel4.setText("Harga                   :");

        jLabel5.setText("Status Masakan   :");

        tbmasakan.setBackground(new java.awt.Color(204, 204, 204));
        tbmasakan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Masakan", "Nama Masakan", "Harga", "Status Masakan"
            }
        ));
        tbmasakan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbmasakanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbmasakan);

        jLabel7.setText("| List Masakan");

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        baru.setText("Baru");
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });

        cbstatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Status", "Tersedia", "Kosong" }));

        canceledit.setText("Cancel Edit");
        canceledit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceleditActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 1, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(195, 195, 195)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(canceledit)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel2))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtidmasakan, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtharga)
                                            .addComponent(txtnamamasakan)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(baru)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(update)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(simpan)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hapus))
                                            .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtidmasakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnamamasakan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtharga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(baru)
                    .addComponent(update)
                    .addComponent(simpan)
                    .addComponent(hapus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(canceledit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        simpandata();
        baru.setEnabled(true);
        simpan.setEnabled(true);
        hapus.setEnabled(false);
        update.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_simpanActionPerformed

    private void tbmasakanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbmasakanMouseClicked
        // TODO add your handling code here:
        setformtable();
        baru.setEnabled(true);
        edit.setEnabled(true);
        hapus.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_tbmasakanMouseClicked

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        hapusdata();
        baru.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        update.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_hapusActionPerformed

    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        // TODO add your handling code here:
        setobjek(true);
        baru();
        txtidmasakan.requestFocus();
        simpan.setEnabled(true);
        update.setEnabled(false);
        edit.setEnabled(false);
        hapus.setEnabled(false);
        update.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_baruActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
        updatedata();
        update.setEnabled(true);
        edit.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        baru.setEnabled(true);
        canceledit.setVisible(false);
    }//GEN-LAST:event_updateActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        // TODO add your handling code here:
        setobjek(true);
        edit.setVisible(true);
        update.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        baru.setEnabled(false);
        canceledit.setVisible(true);
    }//GEN-LAST:event_editActionPerformed

    private void canceleditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceleditActionPerformed
        // TODO add your handling code here:
        baru();
        baru.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
    }//GEN-LAST:event_canceleditActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton baru;
    private javax.swing.JButton canceledit;
    private javax.swing.JComboBox cbstatus;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tbmasakan;
    private javax.swing.JTextField txtharga;
    private javax.swing.JTextField txtidmasakan;
    private javax.swing.JTextField txtnamamasakan;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
private void simpandata() {
        idmasakan = txtidmasakan.getText();
        namamasakan = txtnamamasakan.getText();
        harga = Integer.parseInt(txtharga.getText());
        statusmakanan = (String) cbstatus.getSelectedItem();
        
        if (txtidmasakan.getText().isEmpty() || txtnamamasakan.getText().isEmpty() || txtharga.getText().isEmpty() || cbstatus.getSelectedIndex()== 0) {
          JOptionPane.showMessageDialog(rootPane,"data harus diisi","infromasi",JOptionPane.INFORMATION_MESSAGE);
        } else {
        k.simpandata(idmasakan, namamasakan, harga, statusmakanan);
        JOptionPane.showMessageDialog(rootPane,"Data berhasil disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        tampildata();
        baru();
        setobjek(false);
        }
        
        
     
}

private void tampildata () {
    DefaultTableModel dtm = (DefaultTableModel) tbmasakan.getModel();
    dtm.setRowCount(0);
    k.tampildata(dtm);
    tbmasakan.setModel(dtm);
}

private void setformtable() {
     txtidmasakan.setText(tbmasakan.getValueAt(tbmasakan.getSelectedRow(), 0).toString());
     txtnamamasakan.setText(tbmasakan.getValueAt(tbmasakan.getSelectedRow(), 1).toString());
     txtharga.setText(tbmasakan.getValueAt(tbmasakan.getSelectedRow(), 2).toString());
     cbstatus.setSelectedItem(tbmasakan.getValueAt(tbmasakan.getSelectedRow(), 3).toString());
     
}

private void hapusdata() {
    idmasakan = txtidmasakan.getText();
    
    int conf = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan menghapus data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
    if (conf == 0) {
        k.hapusdata(idmasakan);
    JOptionPane.showMessageDialog(rootPane,"Data berhasil dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
    tampildata();
    baru();
    setobjek(false);
    }
    
} 

private void updatedata() {
        idmasakan = txtidmasakan.getText();
        namamasakan = txtnamamasakan.getText();
        harga = Integer.parseInt(txtharga.getText());
        statusmakanan = (String) cbstatus.getSelectedItem();
        
        int conf = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan mengubah data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (conf == 0) {
            k.updatedata(idmasakan, namamasakan, conf, statusmakanan);
            tampildata();
            baru();
            setobjek(false);
        }
    }

private void baru() {
    txtidmasakan.setText(null);
    txtnamamasakan.setText(null);
    txtharga.setText(null);
    cbstatus.setSelectedIndex(0);
}

private void setobjek(boolean b) {
    txtidmasakan.setEnabled(b);
    txtnamamasakan.setEnabled(b);
    txtharga.setEnabled(b);
    cbstatus.setEnabled(b);
}
    


}

    















package gui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kontrol.kontrol_biaya;
import kontrol.kontrol_laporan;


public class biaya extends javax.swing.JDialog {
    DefaultTableModel dt;
    kontrol_biaya p;
    String id,tanggal,keterangan,biaya,saldo;
    kontrol_laporan kl;
    
   public void no() {
        DefaultTableModel dtm = (DefaultTableModel) tbbiaya.getModel();
        int jumlah = dtm.getRowCount();
        for (int i = 0; i < jumlah; i++);
            int nomor;
            nomor = jumlah + 1;
            txtID.setText(Integer.toString(nomor));   
    } 
    
private void simpandata() {
    id = txtID.getText();
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    String tanggal = String.valueOf(date.format(Btanggal.getDate()));
    keterangan = txtKet.getText();
    biaya = txtBiaya.getText();
    saldo = txtSaldo.getText();
    if (txtID.getText().isEmpty() ||  tanggal.isEmpty() || txtKet.getText().isEmpty() || txtBiaya.getText().isEmpty() || txtSaldo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(rootPane,"Silahkan isi data terlebih dahulu !","Informasi",JOptionPane.INFORMATION_MESSAGE);
    } else {
        p.simpandata(id,tanggal,keterangan,biaya,saldo);
        JOptionPane.showMessageDialog(rootPane,"Data berhasil disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        tampildata();
        baru();
        setobjek(false);
    }
}

private void tampildata () {
    DefaultTableModel dtm = (DefaultTableModel) tbbiaya.getModel();
    dtm.setRowCount(0);
    String cari = null;
    p.tampildata(dtm);
    tbbiaya.setModel(dtm);
}

private void setformtable() {
    txtID.setText(tbbiaya.getValueAt(tbbiaya.getSelectedRow(), 0).toString());
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date tgl = null;
        try {
            tgl = date.parse((String) tbbiaya.getValueAt(tbbiaya.getSelectedRow(), 1).toString());
        } catch (ParseException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    Btanggal.setDate(tgl); 
    txtKet.setText(tbbiaya.getValueAt(tbbiaya.getSelectedRow(), 2).toString());
    txtBiaya.setText(tbbiaya.getValueAt(tbbiaya.getSelectedRow(), 3).toString());
    txtSaldo.setText(tbbiaya.getValueAt(tbbiaya.getSelectedRow(), 4).toString());
     
}

private void hapusdata() {
    id = txtID.getText();
    int conf = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan menghapus data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
    if (conf == 0) {
        p.hapusdata(id);
    JOptionPane.showMessageDialog(rootPane,"Data berhasil dihapus","Informasi",JOptionPane.INFORMATION_MESSAGE);
    tampildata();
        baru();
        setobjek(false);
    }
} 

private void updatedata() {
    id = txtID.getText();
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    String tanggal = String.valueOf(date.format(Btanggal.getDate()));
    keterangan = txtKet.getText();
    biaya = txtBiaya.getText();
    saldo = txtSaldo.getText();
        int conf = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan mengubah data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (conf == 0) {
            p.updatedata(id,tanggal,keterangan,biaya,saldo);
            tampildata();
            baru();
            setobjek(false);   
        }
    }

private void baru() {
    txtKet.setText(null);
    txtBiaya.setText(null);
    txtSaldo.setText(null); 
    no();
}

private void setobjek(boolean b) {
    txtID.setEditable(false);
    txtKet.setEnabled(b);
    txtBiaya.setEnabled(b);
    txtSaldo.setEnabled(b);  
}

private void sum(){
    DefaultTableModel dtm = (DefaultTableModel) tbbiaya.getModel();
        int jumlah = dtm.getRowCount();
        int saldoakhir =0;
        int nilaiBiaya =0;
        int akhir =0;
        for (int i = 0; i < jumlah; i++) {
            int dataSaldo = Integer.valueOf(dtm.getValueAt(i, 3).toString());
            saldoakhir += dataSaldo;
        }
            nilaiBiaya = Integer.parseInt(txtBiaya.getText());
            akhir = saldoakhir + nilaiBiaya;
            txtSaldo.setText(Integer.toString((int) akhir));
}
   
   

    public biaya(JFrame jFrame, boolean b) {
        initComponents();
        p = new kontrol_biaya();
        kl = new kontrol_laporan();
        tampildata();
        no();
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbbiaya = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        baru = new javax.swing.JButton();
        update = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        canceledit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtBiaya = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        txtKet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Btanggal = new com.toedter.calendar.JDateChooser();
        cetak = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Keterangan    ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 70, 20));

        tbbiaya.setBackground(new java.awt.Color(204, 204, 204));
        tbbiaya.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tanggal", "Keterangan", "Biaya", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbbiaya.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbbiayaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbbiaya);
        if (tbbiaya.getColumnModel().getColumnCount() > 0) {
            tbbiaya.getColumnModel().getColumn(0).setResizable(false);
            tbbiaya.getColumnModel().getColumn(1).setResizable(false);
            tbbiaya.getColumnModel().getColumn(2).setResizable(false);
            tbbiaya.getColumnModel().getColumn(3).setResizable(false);
            tbbiaya.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 450, 251));

        jLabel7.setText("| List Pengeluaran Biaya");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        simpan.setText("Simpan");
        simpan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel1.add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, 70, -1));

        hapus.setText("Hapus");
        hapus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel1.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 200, -1, -1));

        baru.setText("Baru");
        baru.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });
        jPanel1.add(baru, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, -1, -1));

        update.setText("Update");
        update.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, -1, -1));

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 270, -1));

        canceledit.setText("Cancel Edit");
        canceledit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceleditActionPerformed(evt);
            }
        });
        jPanel1.add(canceledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("|Buku Biaya");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel5.setText("Biaya");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 70, 20));

        txtBiaya.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBiayaKeyReleased(evt);
            }
        });
        jPanel1.add(txtBiaya, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 240, -1));
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, -1));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, -1));

        jLabel9.setText("ID ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 70, 20));

        jLabel10.setText("Saldo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, 20));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        jPanel1.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 330, 200, -1));
        jPanel1.add(txtKet, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 240, -1));

        jLabel6.setText("Tanggal    ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 70, 20));
        jPanel1.add(Btanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 130, -1));

        cetak.setText("Cetak Laporan");
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        jPanel1.add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbbiayaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbbiayaMouseClicked
        setformtable();
        baru.setEnabled(true);
        edit.setEnabled(true);
        hapus.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_tbbiayaMouseClicked

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        simpandata();
        baru.setEnabled(true);
        simpan.setEnabled(true);
        hapus.setEnabled(false);
        update.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
        sum();
        no();
    }//GEN-LAST:event_simpanActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        hapusdata();
        baru.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        update.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
        sum();
        no();
    }//GEN-LAST:event_hapusActionPerformed

    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        baru();
        no();
        setobjek(true);
        Btanggal.requestFocus();
        simpan.setEnabled(true);
        update.setEnabled(false);
        edit.setEnabled(false);
        hapus.setEnabled(false);
        update.setEnabled(false);
        canceledit.setVisible(false);
        sum();
    }//GEN-LAST:event_baruActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        updatedata();
        update.setEnabled(true);
        edit.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        baru.setEnabled(true);
        canceledit.setVisible(false);
        sum();
        no();
    }//GEN-LAST:event_updateActionPerformed

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed
        setobjek(true);
        edit.setVisible(true);
        update.setEnabled(true);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        baru.setEnabled(false);
        canceledit.setVisible(true);
        txtID.setEnabled(false);
    }//GEN-LAST:event_editActionPerformed

    private void canceleditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceleditActionPerformed
        baru();
        baru.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
    }//GEN-LAST:event_canceleditActionPerformed

    private void txtBiayaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBiayaKeyReleased
        // TODO add your handling code here:
        sum();
    }//GEN-LAST:event_txtBiayaKeyReleased

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        // TODO add your handling code here:
        String lokasi = "src/report/biaya.jrxml";
        HashMap map = new HashMap();
        kl.cetakbiaya(lokasi);
    }//GEN-LAST:event_cetakActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        DefaultTableModel dtm = (DefaultTableModel) tbbiaya.getModel();
        dtm.setRowCount(0);
        String cari = null;
        p.tampildata(dtm);
        tbbiaya.setModel(dtm);
    }//GEN-LAST:event_txtCariKeyReleased

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(biaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(biaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(biaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(biaya.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                biaya dialog = new biaya(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser Btanggal;
    private javax.swing.JButton baru;
    private javax.swing.JButton canceledit;
    private javax.swing.JButton cetak;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tbbiaya;
    private javax.swing.JTextField txtBiaya;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtKet;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
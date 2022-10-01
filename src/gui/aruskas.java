package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import kontrol.kontrol_aruskas;
import kontrol.kontrol_laporan;


public class aruskas extends javax.swing.JDialog {
    DefaultTableModel dt;
    kontrol_aruskas p;
    String id,keterangan,tanggal,pemasukan,pengeluaran,saldo;
    kontrol_laporan kl;
    
    public void no() {
        DefaultTableModel dtm = (DefaultTableModel) tbkas.getModel();
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
    pemasukan = txtMasuk.getText();
    pengeluaran = txtKeluar.getText();
    saldo = txtSaldo.getText();
    if (txtID.getText().isEmpty() ||  tanggal.isEmpty() || txtKet.getText().isEmpty() || txtMasuk.getText().isEmpty() || txtKeluar.getText().isEmpty() || txtSaldo.getText().isEmpty()) {
        JOptionPane.showMessageDialog(rootPane,"Silahkan isi data terlebih dahulu !","Informasi",JOptionPane.INFORMATION_MESSAGE);
    } else {
        p.simpandata(id,tanggal,keterangan,pemasukan,pengeluaran,saldo);
        JOptionPane.showMessageDialog(rootPane,"Data berhasil disimpan","Informasi",JOptionPane.INFORMATION_MESSAGE);
        tampildata();
        baru();
        setobjek(false);
    }
}

private void tampildata () {
    DefaultTableModel dtm = (DefaultTableModel) tbkas.getModel();
    dtm.setRowCount(0);
    String cari = null;
    p.tampildata(dtm);
    tbkas.setModel(dtm);
}

private void setformtable() {
    txtID.setText(tbkas.getValueAt(tbkas.getSelectedRow(), 0).toString());
    SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date tgl = null;
        try {
            tgl = date.parse((String) tbkas.getValueAt(tbkas.getSelectedRow(), 1).toString());
        } catch (ParseException ex) {
            Logger.getLogger(transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    Btanggal.setDate(tgl); 
    txtKet.setText(tbkas.getValueAt(tbkas.getSelectedRow(), 2).toString());
    txtMasuk.setText(tbkas.getValueAt(tbkas.getSelectedRow(), 3).toString());
    txtKeluar.setText(tbkas.getValueAt(tbkas.getSelectedRow(), 4).toString());
    txtSaldo.setText(tbkas.getValueAt(tbkas.getSelectedRow(), 5).toString());
     
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
    pemasukan = txtMasuk.getText();
    pengeluaran = txtKeluar.getText();
    saldo = txtSaldo.getText();
        int conf = JOptionPane.showConfirmDialog(rootPane,"Apakah anda yakin akan mengubah data ini ?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (conf == 0) {
            p.updatedata(id,keterangan,tanggal,pemasukan,pengeluaran,saldo);
            tampildata();
            baru();
            setobjek(false);   
        }
    }

private void baru() {
    txtKet.setText(null);
    txtMasuk.setText(null);
    txtKeluar.setText(null);
}

private void setobjek(boolean b) {
    txtID.setEditable(false);
    Btanggal.setEnabled(b);
    RBMasuk.setEnabled(b);
    RBKeluar.setEnabled(b);
    txtKet.setEnabled(b);
    txtMasuk.setEnabled(b);
    txtKeluar.setEnabled(b);  
}

private void sum(){
    DefaultTableModel dtm = (DefaultTableModel) tbkas.getModel();
        int jumlah = dtm.getRowCount();
        int masuk =0;
        int keluar =0;
        for (int i = 0; i < jumlah; i++) {
            int datamasuk = Integer.valueOf(dtm.getValueAt(i, 3).toString());
            int datakeluar = Integer.valueOf(dtm.getValueAt(i, 4).toString());
            masuk += datamasuk;
            keluar += datakeluar;
        }
        Lmasuk.setText(Integer.toString(masuk));
        Lkeluar.setText(Integer.toString(keluar));   
        int saldo_total,jum_masuk,jum_keluar;
            jum_masuk = Integer.parseInt(Lmasuk.getText());
            jum_keluar = Integer.parseInt(Lkeluar.getText());
            saldo_total = jum_masuk - jum_keluar;
            Lsaldo.setText(Integer.toString((int) saldo_total));
}
    
public void hitungmasuk(){
        int masuk,saldo_,akhir;
            masuk = Integer.parseInt(txtMasuk.getText());
            saldo_ = Integer.parseInt(Lsaldo.getText());
            akhir = saldo_ + masuk;
            txtSaldo.setText(Integer.toString((int) akhir));
}
    
public void hitungkeluar(){
        int keluar,saldo_,akhir;
            keluar = Integer.parseInt(txtKeluar.getText());
            saldo_ = Integer.parseInt(Lsaldo.getText());
            akhir = saldo_ - keluar;
            txtSaldo.setText(Integer.toString((int) akhir));
}
    
   
    public aruskas(JFrame jFrame, boolean b) {
        initComponents();
        kl = new kontrol_laporan();
        p = new kontrol_aruskas();
        tampildata();
        no();
        setobjek(false);
        baru.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
        canceledit.setVisible(false);
        txtSaldo.setEditable(false);
        bg.add(RBMasuk);
        bg.add(RBKeluar);
        LabelKeluar.setVisible(false);
        LabelMasuk.setVisible(false);
        Lmasuk.setVisible(false);
        Lkeluar.setVisible(false);
        Lsaldo.setVisible(false);
        txtMasuk.setVisible(false);
        txtKeluar.setVisible(false);
        sum();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkas = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        simpan = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        baru = new javax.swing.JButton();
        update = new javax.swing.JButton();
        edit = new javax.swing.JButton();
        canceledit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        LabelMasuk = new javax.swing.JLabel();
        LabelKeluar = new javax.swing.JLabel();
        txtKeluar = new javax.swing.JTextField();
        txtMasuk = new javax.swing.JTextField();
        txtSaldo = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCari = new javax.swing.JTextField();
        txtKet = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Btanggal = new com.toedter.calendar.JDateChooser();
        RBMasuk = new javax.swing.JRadioButton();
        RBKeluar = new javax.swing.JRadioButton();
        Lmasuk = new javax.swing.JLabel();
        Lkeluar = new javax.swing.JLabel();
        Lsaldo = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Keterangan    ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 70, 20));

        tbkas.setBackground(new java.awt.Color(204, 204, 204));
        tbkas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tanggal", "Keterangan", "Pemasukan", "Pengeluaran", "Saldo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbkas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbkas);
        if (tbkas.getColumnModel().getColumnCount() > 0) {
            tbkas.getColumnModel().getColumn(0).setResizable(false);
            tbkas.getColumnModel().getColumn(1).setResizable(false);
            tbkas.getColumnModel().getColumn(2).setResizable(false);
            tbkas.getColumnModel().getColumn(3).setResizable(false);
            tbkas.getColumnModel().getColumn(4).setResizable(false);
            tbkas.getColumnModel().getColumn(5).setResizable(false);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 450, 230));

        jLabel7.setText("| List Pengeluaran");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, 20));

        simpan.setText("Simpan");
        simpan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel1.add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, 70, -1));

        hapus.setText("Hapus");
        hapus.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        jPanel1.add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        baru.setText("Baru");
        baru.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });
        jPanel1.add(baru, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        update.setText("Update");
        update.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 230, -1, -1));

        edit.setText("Edit");
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        jPanel1.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 270, -1));

        canceledit.setText("Cancel Edit");
        canceledit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceleditActionPerformed(evt);
            }
        });
        jPanel1.add(canceledit, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("|Buku Kas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        LabelMasuk.setText("Pemasukan");
        jPanel1.add(LabelMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 70, 20));

        LabelKeluar.setText("Pengeluaran    ");
        jPanel1.add(LabelKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 100, 20));

        txtKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKeluarActionPerformed(evt);
            }
        });
        txtKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeluarKeyReleased(evt);
            }
        });
        jPanel1.add(txtKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, -1));

        txtMasuk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMasukKeyReleased(evt);
            }
        });
        jPanel1.add(txtMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 240, -1));
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 240, -1));
        jPanel1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 130, -1));

        jLabel9.setText("ID");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 70, 20));

        jLabel10.setText("Saldo");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, -1, 20));

        txtCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCariKeyReleased(evt);
            }
        });
        jPanel1.add(txtCari, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 330, 220, -1));
        jPanel1.add(txtKet, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 240, -1));

        jLabel6.setText("Tanggal    ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 70, 20));
        jPanel1.add(Btanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 130, -1));

        RBMasuk.setText("Pemasukan");
        RBMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBMasukActionPerformed(evt);
            }
        });
        jPanel1.add(RBMasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, -1, -1));

        RBKeluar.setText("Pengeluaran");
        RBKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBKeluarActionPerformed(evt);
            }
        });
        jPanel1.add(RBKeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, -1, -1));

        Lmasuk.setText("Lmasuk");
        jPanel1.add(Lmasuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, -1, -1));

        Lkeluar.setText("Lkeluar");
        jPanel1.add(Lkeluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, -1, -1));

        Lsaldo.setText("Lsaldo");
        jPanel1.add(Lsaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 600, -1, -1));

        jButton1.setText("Cetak Laporan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, -1, -1));

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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbkasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkasMouseClicked
        setformtable();
        baru.setEnabled(true);
        edit.setEnabled(true);
        hapus.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        canceledit.setVisible(false);
    }//GEN-LAST:event_tbkasMouseClicked

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
        setobjek(true);
        Btanggal.requestFocus();
        simpan.setEnabled(true);
        update.setEnabled(false);
        edit.setEnabled(false);
        hapus.setEnabled(false);
        update.setEnabled(false);
        canceledit.setVisible(false);
        sum();
        no();
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
        sum();
    }//GEN-LAST:event_editActionPerformed

    private void canceleditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceleditActionPerformed
        baru();
        baru.setEnabled(true);
        update.setEnabled(false);
        simpan.setEnabled(false);
        hapus.setEnabled(false);
        edit.setEnabled(false);
        sum();
    }//GEN-LAST:event_canceleditActionPerformed

    private void txtKeluarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeluarKeyReleased
        // TODO add your handling code here:
        hitungkeluar();
    }//GEN-LAST:event_txtKeluarKeyReleased

    private void RBMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBMasukActionPerformed
        // TODO add your handling code here:
        LabelMasuk.setVisible(true);
        txtMasuk.setVisible(true);
        txtMasuk.setText("");
        LabelKeluar.setVisible(false);
        txtKeluar.setVisible(false);
        txtKeluar.setText("0");
    }//GEN-LAST:event_RBMasukActionPerformed

    private void RBKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBKeluarActionPerformed
        // TODO add your handling code here:
        LabelMasuk.setVisible(false);
        txtMasuk.setVisible(false);
        txtMasuk.setText("0");
        LabelKeluar.setVisible(true);
        txtKeluar.setVisible(true);
        txtKeluar.setText("");
    }//GEN-LAST:event_RBKeluarActionPerformed

    private void txtMasukKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMasukKeyReleased
        // TODO add your handling code here:
        hitungmasuk();
    }//GEN-LAST:event_txtMasukKeyReleased

    private void txtKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKeluarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String lokasi = "src/report/aruskas.jrxml";
        HashMap map = new HashMap();
        kl.cetakkas(lokasi);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCariKeyReleased
        DefaultTableModel dtm = (DefaultTableModel) tbkas.getModel();
        dtm.setRowCount(0);
        String cari = null;
        p.tampildata(dtm);
        tbkas.setModel(dtm);
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
            java.util.logging.Logger.getLogger(aruskas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aruskas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aruskas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aruskas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                aruskas dialog = new aruskas(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel LabelKeluar;
    private javax.swing.JLabel LabelMasuk;
    private javax.swing.JLabel Lkeluar;
    private javax.swing.JLabel Lmasuk;
    private javax.swing.JLabel Lsaldo;
    private javax.swing.JRadioButton RBKeluar;
    private javax.swing.JRadioButton RBMasuk;
    private javax.swing.JButton baru;
    private javax.swing.ButtonGroup bg;
    private javax.swing.JButton canceledit;
    private javax.swing.JButton edit;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tbkas;
    private javax.swing.JTextField txtCari;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtKeluar;
    private javax.swing.JTextField txtKet;
    private javax.swing.JTextField txtMasuk;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
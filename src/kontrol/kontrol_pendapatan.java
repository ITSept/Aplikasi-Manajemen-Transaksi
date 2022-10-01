/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontrol;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class kontrol_pendapatan extends koneksi {
    public kontrol_pendapatan() {
        setkonek();
    }
    
    
    public void simpandata(String id, String tanggal, String pendapatan, String jumlah, String keluar, String saldo) {
        String sql = "INSERT INTO pendapatan VALUES ('"+id+"','"+tanggal+"','"+pendapatan+"','"+jumlah+"','"+keluar+"','"+saldo+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_pendapatan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM pendapatan";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[6];
            while(rs.next()) {
                data[0] = rs.getString("id");
                data[1] = rs.getDate("tanggal");
                data[2] = rs.getString("pendapatan");
                data[3] = rs.getString("jumlah");
                data[4] = rs.getString("keluar");
                data[5] = rs.getString("saldo");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_pendapatan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata(String id, String tanggal, String pendapatan, String jumlah, String keluar, String saldo) {
         String sql = "UPDATE pendapatan SET tanggal = '"+tanggal+"', pendapatan = '"+pendapatan+"', jumlah = '"+jumlah+"', keluar = '"+keluar+"', saldo = '"+saldo+"' WHERE idkas = '"+id+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_pendapatan.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String id) {
        String sql = "DELETE FROM pendapatan WHERE id = '"+id+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_pendapatan.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
}

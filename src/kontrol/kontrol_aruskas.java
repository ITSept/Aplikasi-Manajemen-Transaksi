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

public class kontrol_aruskas extends koneksi {
    public kontrol_aruskas() {
        setkonek();
    }
    
    
    public void simpandata(String id, String tanggal, String keterangan, String pemasukan, String pengeluaran, String saldo) {
        String sql = "INSERT INTO aruskas VALUES ('"+id+"','"+tanggal+"','"+keterangan+"','"+pemasukan+"','"+pengeluaran+"','"+saldo+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_aruskas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//      public ResultSet total (String saldo) {
//        String sql = "SELECT SUM(pemasukan*pengeluaran) AS saldo FROM aruskas";
//        try {
//            rs = st.executeQuery(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(kontrol_aruskas.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return rs;
//    }
    
    
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM aruskas";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[6];
            while(rs.next()) {
                data[0] = rs.getString("idkas");
                data[1] = rs.getDate("tanggal");
                data[2] = rs.getString("keterangan");
                data[3] = rs.getString("pemasukan");
                data[4] = rs.getString("pengeluaran");
                data[5] = rs.getString("saldo");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_aruskas.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata(String id, String tanggal, String keterangan, String pemasukan, String pengeluaran, String saldo) {
         String sql = "UPDATE aruskas SET tanggal = '"+tanggal+"', keterangan = '"+keterangan+"', pemasukan = '"+pemasukan+"', pengeluaran = '"+pengeluaran+"', saldo = '"+saldo+"' WHERE idkas = '"+id+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_aruskas.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String id) {
        String sql = "DELETE FROM aruskas WHERE idkas = '"+id+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_aruskas.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
}

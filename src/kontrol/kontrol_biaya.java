/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontrol;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class kontrol_biaya extends koneksi {
    public kontrol_biaya() {
        setkonek();
    }
    
    
    public void simpandata(String id, String tanggal, String keterangan, String biaya,  String saldo) {
        String sql = "INSERT INTO biaya VALUES ('"+id+"','"+tanggal+"','"+keterangan+"','"+biaya+"','"+saldo+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_biaya.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM biaya";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[5];
            while(rs.next()) {
                data[0] = rs.getString("id");
                data[1] = rs.getDate("tanggal");
                data[2] = rs.getString("keterangan");
                data[3] = rs.getString("biaya");
                data[4] = rs.getString("saldo");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_biaya.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata(String id, String tanggal, String keterangan, String biaya,  String saldo) {
        String sql = "UPDATE biaya SET tanggal = '"+tanggal+"', keterangan = '"+keterangan+"', biaya = '"+biaya+"', saldo = '"+saldo+"' WHERE id = '"+id+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_biaya.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String id) {
        String sql = "DELETE FROM biaya WHERE id = '"+id+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_biaya.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }

}

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
import static jdk.nashorn.internal.runtime.Debug.id;

public class kontrol_menu extends koneksi {
    public kontrol_menu() {
        setkonek();
    }
        
    public void simpandata(String idmenu, String namamenu, int harga, String statusmenu) {
       String sql = "INSERT INTO menu VALUES ('"+idmenu+"','"+namamenu+"','"+harga+"','"+statusmenu+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM menu";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[4];
            while(rs.next()) {
                data[0] = rs.getString("id_menu");
                data[1] = rs.getString("nama_menu");
                data[2] = rs.getInt("harga");
                data[3] = rs.getString("status_menu");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata(String idmenu, String namamenu, int harga, String statusmakanan) {
         String sql = "UPDATE menu SET nama_menu = '"+namamenu+"', harga = '"+harga+"', status_menu = '"+statusmakanan+"' WHERE id_menu = '"+idmenu+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String idmenu) {
        String sql = "DELETE FROM menu WHERE id_menu = '"+idmenu+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_menu.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
      
      public ResultSet cari(String cari) throws Exception {
          String sql = "SELECT * FROM menu WHERE id_menu = '"+cari+"'";
          return rs = st.executeQuery(sql);
      }

      public ResultSet caridata(DefaultTableModel dtm, String cari) {
        try {
            String sql = "SELECT * FROM menu WHERE id_menu LIKE '%"+cari+"%' OR nama_menu LIKE '%"+cari+"%' OR harga LIKE '%"+cari+"%'";
            rs = st.executeQuery(sql);
            Object [] data = new Object[4];
                while(rs.next()) {
                data[0] = rs.getString("id_menu");
                data[1] = rs.getString("nama_menu");
                data[2] = rs.getInt("harga");
                data[3] = rs.getString("status_menu");
                dtm.addRow(data);
                
             }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
         
        
        
      }
     
        
        
      }


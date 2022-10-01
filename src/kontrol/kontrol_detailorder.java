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

public class kontrol_detailorder extends koneksi {
    public kontrol_detailorder() {
        setkonek();
    }
    
    public void simpandata(String iddetail, String idorder, String idmenu, String qty, String statusdetail) {
       String sql = "INSERT INTO detail_order VALUES ('"+iddetail+"','"+idorder+"','"+idmenu+"','"+qty+"','"+statusdetail+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_detailorder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM detail_order";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[5];
            while(rs.next()) {
                data[0] = rs.getString("id_detail_order");
                data[1] = rs.getString("id_order");
                data[2] = rs.getString("id_menu");
                data[3] = rs.getString("qty");
                data[4] = rs.getString("status_detail_order");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_detailorder.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata (String iddetail, String idorder, String idmenu, String qty, String statusdetail) {
         String sql = "UPDATE detail_order SET id_order = '"+idorder+"', id_menu = '"+idmenu+"', qty = '"+qty+"', status_detail_order = '"+statusdetail+"'WHERE id_menu = '"+idmenu+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_detailorder.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      public void hapusdata(String iddetail) {
        String sql = "DELETE FROM detail_order WHERE id_detail_order = '"+iddetail+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_detailorder.class.getName()).log(Level.SEVERE, null, ex);
        } 
      }
      
      public ResultSet setcomboidorder() throws SQLException{
          String sql = "SELECT id_order FROM order";
          return rs = st.executeQuery(sql);
      }
      
      public ResultSet setcomboidmenu() throws SQLException{
          String sql = "SELECT id_menu FROM menu";
          return rs = st.executeQuery(sql);
      }
      
      public ResultSet cariidorder(String cari) throws SQLException {
          String sql = "SELECT * FROM order WHERE id_order = '"+cari+"'";
          return rs = st.executeQuery(sql);
      }
      
       public ResultSet cariidmenu(String cari) throws SQLException {
          String sql = "SELECT * FROM menu WHERE id_menu = '"+cari+"'";
          return rs = st.executeQuery(sql);
}
}

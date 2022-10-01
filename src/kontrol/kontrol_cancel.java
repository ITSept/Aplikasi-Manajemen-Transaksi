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

public class kontrol_cancel extends koneksi {
    public kontrol_cancel() {
        setkonek();
    }
    
     public void tampildata (DefaultTableModel dtm){
        String sql = "SELECT * FROM `order`";
        try {
            rs = st.executeQuery(sql);
            Object [] data = new Object[6];
            while(rs.next()) {
                data[0] = rs.getString("id_order");
                data[1] = rs.getString("no_meja");
                data[2] = rs.getDate("tanggal");
                data[3] = rs.getString("id_user");
                data[4] = rs.getString("qty");
                data[5] = rs.getString("status_order");
                dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_cancel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updatedata (String idorder, String nomeja, String tanggal, String iduser, String qty, String statusorder) {
         String sql = "UPDATE `order` SET no_meja = '"+nomeja+"', tanggal = '"+tanggal+"', id_user = '"+iduser+"', qty = '"+qty+"', status_order = '"+statusorder+"' WHERE id_order = '"+idorder+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_cancel.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
      
}

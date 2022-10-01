/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kontrol;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


public class kontrol_transaksi extends koneksi{
    public kontrol_transaksi(){
        setkonek();
    }
    public void tampil(DefaultTableModel dtm,String cari){
    String sql = "SELECT * FROM menu,detail_order WHERE menu.id_menu=detail_order.id_menu AND detail_order.id_order =  '"+cari+"'";
        try {
            rs=st.executeQuery(sql);
            Object[] data = new Object[4];
            while(rs.next()){
            data[0]=rs.getString("id_detail_order");
            data[1]=rs.getString("id_order");
            data[2]=rs.getString("nama_menu");
            data[3]=rs.getString("qty");
            dtm.addRow(data);
            }
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet total (String total) {
        String sql = "SELECT SUM(menu.harga*detail_order.qty) AS total FROM menu,detail_order WHERE menu.id_menu ="
                + " detail_order.id_menu AND detail_order.id_order = '"+total+"' GROUP BY detail_order.id_order";
        try {
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public void simpandata(String iduser, String idorder, String tanggal, double total) {
        String sql = "INSERT INTO transaksi VALUES (null,'"+iduser+"','"+idorder+"','"+tanggal+"','"+total+"')";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_transaksi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void tampil(String a) throws SQLException {
        String sql = "SELECT id_transaksi FROM transaksi WHERE id_order = '"+a+"'";
        st.executeQuery(sql);
        
        
    }
    
    public void hapusdata(String iddetail) {
        String sql = "DELETE FROM detail_order WHERE id_detail_order = '"+iddetail+"'";
        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(kontrol_order.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
       
    
}

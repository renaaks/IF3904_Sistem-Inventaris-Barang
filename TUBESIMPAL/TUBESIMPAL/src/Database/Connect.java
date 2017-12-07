/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.Pemohon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Novelty Octaviani
 */
public class Connect {
    private String server="jdbc:mysql://localhost/datainventarisbarang"; //ini mesti diganti
    private String dbUser="root";
    private String dbPwd="";
    Statement statement;
    Connection connection;
    private DefaultTableModel _tabel;
    
    public void tryConnect(){
        try{
            connection = DriverManager.getConnection(server, dbUser, dbPwd);
            statement = connection.createStatement();
        } catch(SQLException ex){
            System.out.println("Tidak bisa connect");
        }
    }

    public Pemohon loginPemohon(String username, String password) {
        try{
            String query="SELECT * FROM PEMOHON WHERE id_Pemohon= '"+username+"' "
                    +"AND Password = '"+password+"'";
            ResultSet rs=statement.executeQuery(query);
            Pemohon p = null;
            while(rs.next()){
                p = new Pemohon(rs.getString(1),rs.getString(2),rs.getString(3));
            }
            return p;
        }catch(SQLException ex){
            System.out.println("Login Gagal"+ex);
            return null;
        }
    }
}

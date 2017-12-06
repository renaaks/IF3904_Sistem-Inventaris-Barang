/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
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
}

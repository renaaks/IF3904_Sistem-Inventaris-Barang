/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import View.PermohonanPemohon;
import Model.Barang;
import Model.Barang_Keluar;
import Model.Barang_Masuk;
import Model.Pemohon;
import Model.Permohonan;
import View.DataBarangLogistik;
import View.LaporanLogistik;
import View.PendataanBarang;
import View.PermohonanLogistik;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;
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
    
    public Barang caridatabarang (String Kode_Barang){
        try{
            String query="SELECT * FROM BARANG WHERE Kode_Barang= '"+Kode_Barang+"' ";
            ResultSet rs=statement.executeQuery(query);
            Barang brg = null;
            while(rs.next()){
                brg = new Barang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
            return brg;
        }catch(SQLException ex){
            System.out.println("Login Gagal"+ex);
            return null;
        }
    }
    
    public void savepermohonan(Permohonan per){
        try{
            String query="INSERT INTO PERMOHONAN(Kode_Permohonan, Kode_Barang, Id_Pemohon, Jumlah_Barang, Keterangan, Status) VALUES("+
                    "'"+per.getKode_Permohonan()+"',"+
                    "'"+per.getKode_Barang()+"',"+
                    "'"+per.getId_Pemohon()+"',"+
                    "'"+per.getJumlah_Barang()+"',"+
                    "'"+per.getKeterangan()+"',"+
                    "'"+per.getStatus()+"')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "berhasil menambahkan data permohonan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data permohonan gagal disimpan");
        }
    }
    public void LoadDataPermohonan(PermohonanPemohon view, String id){
        String[] kolom = {"Kode_Permohonan","Kode_Barang","Jumlah_Barang","Keterangan","Status"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonanpemohon().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "" + "SELECT * from permohonan where id_Pemohon = '"+id+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Permohonan = rs.getString(1);
                String Kode_Barang = rs.getString(2);
                int Jumlah_Barang = rs.getInt(4);
                String Keterangan = rs.getString(5);
                String Status = rs.getString(6);
                Object[] data = {Kode_Permohonan,Kode_Barang,Jumlah_Barang,Keterangan,Status};
                _tabel.addRow(data);
            }
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }
    
    public void HapusTabel(){
        int row = _tabel.getRowCount();
        for (int i = 0;i < row;i++){
            _tabel.removeRow(0);
        }
    }

    public void savebarang(Barang brg) {
        try{
            String query="INSERT INTO BARANG(Kode_Barang, Nama_Barang, Jenis_Barang, Jumlah_Barang) VALUES("+
                    "'"+brg.getKode_Barang()+"',"+
                    "'"+brg.getNama_Barang()+"',"+
                    "'"+brg.getJenis_Barang()+"',"+
                    "'"+brg.getJumlah_Barang()+"')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data barang berhasil dimasukan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal dimasukkan");
        }
        }

    public void LoadDataBarang(DataBarangLogistik view) {
        String[] kolom = {"Kode_Barang","Nama_Barang","Jenis_Barang","Jumlah_Barang"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabeldatabaranglogistik().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "" + "SELECT * from Barang";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Barang = rs.getString(1);
                String Nama_Barang = rs.getString(2);
                String Jenis_Barang = rs.getString(3);
                int Jumlah_Barang = rs.getInt(4);
                Object[] data = {Kode_Barang,Nama_Barang,Jenis_Barang, Jumlah_Barang};
                _tabel.addRow(data);
            }
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public void LoadDataBarangMasukLaporanLogistik(LaporanLogistik view) {
        String[] kolom = {"Kode_Barang","Kode_Barang_Masuk","Kode_Permohonan","Id_Pemohon","jumlah_barang","Tanggal_Masuk"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangmasuklaporanlogistik().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "" + "SELECT * from barang_masuk";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Barang = rs.getString(1);
                String Kode_Barang_Masuk = rs.getString(2);
                String Kode_Permohonan = rs.getString(3);
                String Id_Pemohon = rs.getString(4);
                int Jumlah_Barang = rs.getInt(5);
                String Tanggal_Masuk = rs.getString(6);
                Object[] data = {Kode_Barang,Kode_Barang_Masuk,Kode_Permohonan, Id_Pemohon, Jumlah_Barang,Tanggal_Masuk};
                _tabel.addRow(data);
            }
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(5).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public void LoadDataBarangKeluarLaporanLogistik(LaporanLogistik view) {
       String[] kolom = {"Kode_Barang_Masuk","Kode_Barang_Keluar","Id_Pemohon","Jumah_Barang","Kondisi_Barang","Tanggal_Keluar"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangkeluarlaporanlogistik().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "" + "SELECT * from barang_keluar";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Barang_Masuk = rs.getString(1);
                String Kode_Barang_Keluar = rs.getString(2);
                String Id_Pemohon = rs.getString(3);
                int Jumlah_Barang = rs.getInt(4);
                String Kondisi_Barang = rs.getString(5);
                String Tanggal_Keluar = rs.getString(6);
                Object[] data = {Kode_Barang_Masuk,Kode_Barang_Keluar,Id_Pemohon,Jumlah_Barang, Kondisi_Barang, Tanggal_Keluar};
                _tabel.addRow(data);
            }
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(5).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public Barang_Masuk caridatabarangmasuk(String kode_barang_masuk) {
    try{
            String query="SELECT * FROM BARANG_MASUK WHERE Kode_Barang_Masuk= '"+kode_barang_masuk+"' ";
            ResultSet rs=statement.executeQuery(query);
            Barang_Masuk brg = null;
            while(rs.next()){
                brg = new Barang_Masuk (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
            }
            return brg;
        }catch(SQLException ex){
            System.out.println("Login Gagal"+ex);
            return null;
        }    
    }

    public void savebarangkeluar(Barang_Keluar brgkeluar) {
        try{
            String query="INSERT INTO BARANG_KELUAR (Kode_Barang_Masuk, Kode_Barang_Keluar, Id_Pemohon, Jumlah_Barang, Kondisi_barang, tanggal_keluar) VALUES("+
                    "'"+brgkeluar.getKode_Barang_Masuk()+"',"+
                    "'"+brgkeluar.getKode_Barang_Keluar()+"',"+
                    "'"+brgkeluar.getId_Pemohon()+"',"+
                    "'"+brgkeluar.getJumlah_barang()+"',"+
                    "'"+brgkeluar.getKondisi_Barang()+"',"+
                    "'"+brgkeluar.getTanggal_Keluar()+"')";
            
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "berhasil menambahkan data barang keluar");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data barang keluar gagal disimpan");
        }
    }

    public void LoadDataBarangKeluarPemohon(PendataanBarang view, String id) {
        String[] kolom = {"Kode_Barang_Masuk","Kode_Barang_Keluar","Jumah_Barang","Kondis_Barang","Tanggal_Keluar"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangkeluarpemohon().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "SELECT * from barang_keluar where id_Pemohon = '"+id+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Barang_Masuk = rs.getString(1);
                String Kode_Barang_Keluar = rs.getString(2);
                int Jumlah_Barang = rs.getInt(4);
                String Kondisi_Barang = rs.getString(5);
                String Tanggal_Keluar = rs.getString(6);
                Object[] data = {Kode_Barang_Masuk,Kode_Barang_Keluar,Jumlah_Barang, Kondisi_Barang, Tanggal_Keluar};
                _tabel.addRow(data);
            }
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public Object carikodebarangmasuk(String kode_barang_masuk) {
    try{
            String query="SELECT * FROM BARANG_MASUK WHERE Kode_Barang= '"+kode_barang_masuk+"' ";
            ResultSet rs=statement.executeQuery(query);
            Barang_Masuk brg = null;
            while(rs.next()){
                brg = new Barang_Masuk (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
            }
            return brg;
        }catch(SQLException ex){
            System.out.println("Login Gagal"+ex);
            return null;
        } 
    }

    public void loadDataBarangMasukPemohon(PendataanBarang view, String id_Pemohon) {
        String[] kolom = {"Kode Barang", "Kode Barang Masuk","Kode Permohonan","Jumah_Barang","Tanggal Masuk"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangmasukpemohon().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "SELECT * from BARANG_MASUK where id_Pemohon = '"+id_Pemohon+"'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Barang = rs.getString(1);
                String Kode_Barang_Masuk = rs.getString(2);
                String Kode_Permohonan = rs.getString(3);
                int Jumlah_Barang = rs.getInt(5);
                String Tanggal_Masuk = rs.getString(6);
                Object[] data = {Kode_Barang, Kode_Barang_Masuk,Kode_Permohonan,Jumlah_Barang, Tanggal_Masuk};
                _tabel.addRow(data);
            }
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public void ubahBarangMasuk(String kode_barang_masuk, int sisaBarang) {
        try {
            String sql = "UPDATE barang_masuk SET Jumlah_Barang= '"+sisaBarang+
                    "' WHERE Kode_Barang_Masuk= '"+kode_barang_masuk+"'";
            statement.execute(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Update Data Failed");
        }
    }

    public Permohonan carikodepermohonan(String kodepermohonan) {
       try{
            String query="SELECT * FROM PERMOHONAN WHERE Kode_Permohonan= '"+kodepermohonan+"'";
            ResultSet rs=statement.executeQuery(query);
            Permohonan prmhn = null;
            while(rs.next()){
                prmhn = new Permohonan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
            }
            return prmhn;
        }catch(SQLException ex){
            System.out.println("Login Gagal"+ex);
            return null;
        }
    }

    public void ubahpermohonan(String kodepermohonan, String status) {
        try {
            String sql = "UPDATE permohonan SET status= '"+status+
                    "' WHERE Kode_Permohonan= '"+kodepermohonan+"'";
            statement.execute(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Update Data Failed");
        }
    }

    public void loaddatapermohonanditerima(PermohonanLogistik view) {
        String[] kolom = {"Kode_Permohonan", "Kode_Barang","Id_Pemohon","Jumah_Barang","Keterangan"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonandisetujuilogistik().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "SELECT * from permohonan where status = 'diterima'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Permohonan = rs.getString(1);
                String Kode_Barang = rs.getString(2);
                String Id_Pemohon = rs.getString(3);
                int Jumlah_Barang = rs.getInt(4);
                String Keterangan = rs.getString(5);
                Object[] data = {Kode_Permohonan, Kode_Barang,Id_Pemohon,Jumlah_Barang, Keterangan};
                _tabel.addRow(data);
            }
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public void loaddatapermohonanmenunggu(PermohonanLogistik view) {
        String[] kolom = {"Kode_Permohonan", "Kode_Barang","Id_Pemohon","Jumah_Barang","Keterangan"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonanlogistik().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "SELECT * from permohonan where status = 'menunggu'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Permohonan = rs.getString(1);
                String Kode_Barang = rs.getString(2);
                String Id_Pemohon = rs.getString(3);
                int Jumlah_Barang = rs.getInt(4);
                String Keterangan = rs.getString(5);
                Object[] data = {Kode_Permohonan, Kode_Barang,Id_Pemohon,Jumlah_Barang, Keterangan};
                _tabel.addRow(data);
            }
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public void loaddatapermohonanditolak(PermohonanLogistik view) {
        String[] kolom = {"Kode_Permohonan", "Kode_Barang","Id_Pemohon","Jumah_Barang","Keterangan"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonanditolaklogistik().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "SELECT * from permohonan where status = 'ditolak'";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Permohonan = rs.getString(1);
                String Kode_Barang = rs.getString(2);
                String Id_Pemohon = rs.getString(3);
                int Jumlah_Barang = rs.getInt(4);
                String Keterangan = rs.getString(5);
                Object[] data = {Kode_Permohonan, Kode_Barang,Id_Pemohon,Jumlah_Barang, Keterangan};
                _tabel.addRow(data);
            }
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

    public void savebarangmasuk(Permohonan prmhn,String tglmsk) {
        Random r = new Random();
        int randId = r.nextInt(999-111) + 111;
        String s = "PRMHN"+Integer.toString(randId);
        try{
            String query="INSERT INTO BARANG_MASUK (kode_Barang, Kode_Barang_Masuk, Kode_Permohonan, Id_Pemohon, Jumlah_Barang, tanggal_masuk) VALUES("+
                    "'"+prmhn.getKode_Barang()+"',"+
                    "'"+s+"',"+
                    "'"+prmhn.getKode_Permohonan()+"',"+
                    "'"+prmhn.getId_Pemohon()+"',"+
                    "'"+prmhn.getJumlah_Barang()+"',"+
                    "'"+tglmsk+"')";
            
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "berhasil menambahkan data barang keluar");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data barang keluar gagal disimpan");
        }
    }
    
    public int jumlahbarang(String kode){
        try{
            String query="SELECT jumlah_barang FROM barang WHERE Kode_barang= '"+kode+"'";
            ResultSet rs=statement.executeQuery(query);
            int jumlah = 0;
            while(rs.next()){
                jumlah = rs.getInt(1);
            }
            return jumlah;
        }catch(SQLException ex){
            System.out.println("Gagal"+ex);
            return 0;
        }
    }

    public void ubahBarang(Permohonan prmhn) {
        try {
            int total = jumlahbarang(prmhn.getKode_Barang())-prmhn.getJumlah_Barang();
            String sql = "UPDATE barang SET jumlah_barang= '"+total+
                    "' WHERE Kode_barang= '"+prmhn.getKode_Barang()+"'";
            statement.execute(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Update Data Failed");
        }
    }

    public void LoadDataBarangPemohon(PermohonanPemohon view) {
        String[] kolom = {"Kode_Barang","Nama_Barang","Jenis_Barang","Jumlah_Barang"};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabeldatainventarispemohon().setModel(_tabel);
        try{
            HapusTabel();
            String sql = "" + "SELECT * from Barang";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                String Kode_Barang = rs.getString(1);
                String Nama_Barang = rs.getString(2);
                String Jenis_Barang = rs.getString(3);
                int Jumlah_Barang = rs.getInt(4);
                Object[] data = {Kode_Barang,Nama_Barang,Jenis_Barang, Jumlah_Barang};
                _tabel.addRow(data);
            }
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,"gagal");
        }
    }

}
    
    



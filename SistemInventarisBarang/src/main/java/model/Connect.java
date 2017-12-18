/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import view.DataBarangLogistik;
import view.LaporanLogistik;
import view.PendataanBarang;
import view.PermohonanLogistik;
import view.PermohonanPemohon;
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
    Statement statement;
    Connection connection;
    private DefaultTableModel _tabel;
    private String gagalCari = "Pencarian Gagal";
    private String kBaarang = "Kode Barang";
    private String jumlahBaarang = "Jumlah Barang";
    private String kdPeermohonan = "Kode Permohonan";
    private String keeterangan = "Keterangan";
    private String kdeBaarangMasuk = "Kode Barang Masuk";
    private String kodBaarangKeluar = "Kode Barang Keluar";
    private String kondisiBaarang = "Kondisi Barang";
    private String update = "Update Data Failed";
    private String staatus = "Status";
    private String iddPemohon = "Id Pemohon";
    private String taanggalKeluar = "Tanggal Keluar";
    private String taanggalMasuk = "Tanggal Masuk";
    private String gagal = "Gagal";
    private ResultSet rs;
    public void tryConnect(){
        String server="jdbc:mysql://localhost/datainventarisbarang"; //ini mesti diganti
        String user="root";
        String pw="";
        try{
            connection = DriverManager.getConnection(server, user, pw);
            statement = connection.createStatement();
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Tidak bisa connect");
        }
    }

    public Pemohon loginPemohon(String username, String password) {
        try{
            String query="SELECT * FROM PEMOHON WHERE id_Pemohon= '"+username+"' "
                    +"AND Password = '"+password+"'";
            rs=statement.executeQuery(query);
            Pemohon p = null;
            while(rs.next()){
                p = new Pemohon(rs.getString(1),rs.getString(2),rs.getString(3));
            }
            return p;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "loginGagal");
            return null;
        }
    }
    
    public Barang caridatabarang (String kodeBarang){
        try{
            String query="SELECT * FROM BARANG WHERE Kode_Barang= '"+kodeBarang+"' ";
            rs=statement.executeQuery(query);
            Barang brg = null;
            while(rs.next()){
                brg = new Barang(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            }
            return brg;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,gagalCari);
            return null;
        }
    }
    
    public void savepermohonan(Permohonan per){
        try{
            String query="INSERT INTO PERMOHONAN(Kode_Permohonan, Kode_Barang, Id_Pemohon, Jumlah_Barang, Keterangan, Status) VALUES("+
                    "'"+per.getkodePermohonan()+"',"+
                    "'"+per.getkodeBarang()+"',"+
                    "'"+per.getidPemohon()+"',"+
                    "'"+per.getjumlahBarang()+"',"+
                    "'"+per.getketerangan()+"',"+
                    "'"+per.getstatus()+"')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "berhasil menambahkan data permohonan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data permohonan gagal disimpan");
        }
    }
    public void loadDataPermohonan(PermohonanPemohon view, String id){
        String[] kolom = {kdPeermohonan,kBaarang,jumlahBaarang,keeterangan,staatus};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonanpemohon().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "" + "SELECT * from permohonan where id_Pemohon = '"+id+"'";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodePermohonan = rs.getString(1);
                String kodeBarang = rs.getString(2);
                int jumlahBarang = rs.getInt(4);
                String keterangan = rs.getString(5);
                String status = rs.getString(6);
                Object[] data = {kodePermohonan,kodeBarang,jumlahBarang,keterangan,status};
                _tabel.addRow(data);
            }
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonanpemohon().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }
    
    public void hapusTabel(){
        int row = _tabel.getRowCount();
        for (int i = 0;i < row;i++){
            _tabel.removeRow(0);
        }
    }

    public void savebarang(Barang brg) {
        try{
            String query="INSERT INTO BARANG(Kode_Barang, Nama_Barang, Jenis_Barang, Jumlah_Barang) VALUES("+
                    "'"+brg.getkodeBarang()+"',"+
                    "'"+brg.getnamaBarang()+"',"+
                    "'"+brg.getjenisBarang()+"',"+
                    "'"+brg.getjumlahBarang()+"')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "Data barang berhasil dimasukan");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data gagal dimasukkan");
        }
        }

    public void loadDataBarang(DataBarangLogistik view) {
        String[] kolom = {kBaarang,"Nama Barang","Jenis_Barang",jumlahBaarang};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabeldatabaranglogistik().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "" + "SELECT * from Barang";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodeBarang = rs.getString(1);
                String namaBarang = rs.getString(2);
                String jenisBarang = rs.getString(3);
                int jumlahBarang = rs.getInt(4);
                Object[] data = {kodeBarang,namaBarang,jenisBarang, jumlahBarang};
                _tabel.addRow(data);
            }
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabeldatabaranglogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public void loadDataBarangMasukLaporanLogistik(LaporanLogistik view) {
        String[] kolom = {kBaarang,kdeBaarangMasuk,kdPeermohonan,iddPemohon,jumlahBaarang,taanggalMasuk};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangmasuklaporanlogistik().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "" + "SELECT * from barang_masuk";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodeBarang = rs.getString(1);
                String kodeBarangMasuk = rs.getString(2);
                String kodePermohonan = rs.getString(3);
                String idPemohon = rs.getString(4);
                int jumlahBarang = rs.getInt(5);
                String tanggalMasuk = rs.getString(6);
                Object[] data = {kodeBarang,kodeBarangMasuk,kodePermohonan, idPemohon, jumlahBarang,tanggalMasuk};
                _tabel.addRow(data);
            }
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
            view.getTabelbarangmasuklaporanlogistik().getColumnModel().getColumn(5).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public void loadDataBarangKeluarLaporanLogistik(LaporanLogistik view) {
       String[] kolom = {kdeBaarangMasuk,kodBaarangKeluar,iddPemohon,jumlahBaarang,kondisiBaarang,taanggalKeluar};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangkeluarlaporanlogistik().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "" + "SELECT * from barang_keluar";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodeBarangMasuk = rs.getString(1);
                String kodeBarangKeluar = rs.getString(2);
                String idPemohon = rs.getString(3);
                int jumlahBarang = rs.getInt(4);
                String kondisiBarang = rs.getString(5);
                String tanggalKeluar = rs.getString(6);
                Object[] data = {kodeBarangMasuk,kodeBarangKeluar,idPemohon,jumlahBarang,kondisiBarang,tanggalKeluar};
                _tabel.addRow(data);
            }
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
            view.getTabelbarangkeluarlaporanlogistik().getColumnModel().getColumn(5).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public Barang_Masuk caridatabarangmasuk(String kodeBarangMasuk) {
    try{
            String query="SELECT * FROM BARANG_MASUK WHERE Kode_Barang_Masuk= '"+kodeBarangMasuk+"' ";
            rs=statement.executeQuery(query);
            Barang_Masuk brg = null;
            while(rs.next()){
                brg = new Barang_Masuk (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
            }
            return brg;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, gagalCari);
            return null;
        }    
    }

    public void savebarangkeluar(Barang_Keluar brgkeluar) {
        try{
            String query="INSERT INTO BARANG_KELUAR (Kode_Barang_Masuk, Kode_Barang_Keluar, Id_Pemohon, Jumlah_Barang, Kondisi_barang, tanggal_keluar) VALUES("+
                    "'"+brgkeluar.getkodeBarangMasuk()+"',"+
                    "'"+brgkeluar.getkodeBarangKeluar()+"',"+
                    "'"+brgkeluar.getidPemohon()+"',"+
                    "'"+brgkeluar.getjumlahBarang()+"',"+
                    "'"+brgkeluar.getkondisiBarang()+"',"+
                    "'"+brgkeluar.gettanggalKeluar()+"')";
            
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "berhasil menambahkan data barang keluar");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data barang keluar gagal disimpan");
        }
    }

    public void loadDataBarangKeluarPemohon(PendataanBarang view, String id) {
        String[] kolom = {kdeBaarangMasuk,kodBaarangKeluar,jumlahBaarang,kondisiBaarang,taanggalKeluar};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangkeluarpemohon().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "SELECT * from barang_keluar where id_Pemohon = '"+id+"'";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodeBarangMasuk = rs.getString(1);
                String kodeBarangKeluar = rs.getString(2);
                int jumlahBarang = rs.getInt(4);
                String kondisiBarang = rs.getString(5);
                String tanggalKeluar = rs.getString(6);
                Object[] data = {kodeBarangMasuk,kodeBarangKeluar,jumlahBarang, kondisiBarang,tanggalKeluar};
                _tabel.addRow(data);
            }
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public Object carikodebarangmasuk(String kodeBarangMasuk) {
    try{
            String query="SELECT * FROM BARANG_MASUK WHERE Kode_Barang= '"+kodeBarangMasuk+"' ";
            rs=statement.executeQuery(query);
            Barang_Masuk brg = null;
            while(rs.next()){
                brg = new Barang_Masuk (rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getString(6));
            }
            return brg;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, gagalCari);
            return null;
        } 
    }

    public void loadDataBarangMasukPemohon(PendataanBarang view, String idPemohon) {
        String[] kolom = {kBaarang, kdeBaarangMasuk,kdPeermohonan,jumlahBaarang,taanggalMasuk};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelbarangmasukpemohon().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "SELECT * from BARANG_MASUK where id_Pemohon = '"+idPemohon+"'";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodeBarang = rs.getString(1);
                String kodeBarangMasuk = rs.getString(2);
                String kodePermohonan = rs.getString(3);
                int jumlahBarang = rs.getInt(5);
                String tanggalMasuk = rs.getString(6);
                Object[] data = {kodeBarang, kodeBarangMasuk,kodePermohonan,jumlahBarang, tanggalMasuk};
                _tabel.addRow(data);
            }
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelbarangkeluarpemohon().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public void ubahBarangMasuk(String kodeBarangMasuk, int sisaBarang) {
        try {
            String sql = "UPDATE barang_masuk SET Jumlah_Barang= '"+sisaBarang+
                    "' WHERE Kode_Barang_Masuk= '"+kodeBarangMasuk+"'";
            statement.execute(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,update);
        }
    }

    public Permohonan carikodepermohonan(String kodepermohonan) {
       try{
            String query="SELECT * FROM PERMOHONAN WHERE Kode_Permohonan= '"+kodepermohonan+"'";
            rs=statement.executeQuery(query);
            Permohonan prmhn = null;
            while(rs.next()){
                prmhn = new Permohonan(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
            }
            return prmhn;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, gagalCari);
            return null;
        }
    }

    public void ubahpermohonan(String kodepermohonan, String status) {
        try {
            String sql = "UPDATE permohonan SET status= '"+status+
                    "' WHERE Kode_Permohonan= '"+kodepermohonan+"'";
            statement.execute(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,update);
        }
    }

    public void loaddatapermohonanditerima(PermohonanLogistik view) {
        String[] kolom = {kdPeermohonan, kBaarang,iddPemohon,jumlahBaarang,keeterangan};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonandisetujuilogistik().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "SELECT * from permohonan where status = 'diterima'";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodePermohonan = rs.getString(1);
                String kodeBarang = rs.getString(2);
                String idPemohon = rs.getString(3);
                int jumlahBarang = rs.getInt(4);
                String keterangan = rs.getString(5);
                Object[] data = {kodePermohonan, kodeBarang,idPemohon,jumlahBarang, keterangan};
                _tabel.addRow(data);
            }
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonandisetujuilogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public void loaddatapermohonanmenunggu(PermohonanLogistik view) {
        String[] kolom = {kdPeermohonan, kBaarang,iddPemohon,jumlahBaarang,keeterangan};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonanlogistik().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "SELECT * from permohonan where status = 'menunggu'";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodePermohonan = rs.getString(1);
                String kodeBarang = rs.getString(2);
                String idPemohon = rs.getString(3);
                int jumlahBarang = rs.getInt(4);
                String keterangan = rs.getString(5);
                Object[] data = {kodePermohonan,kodeBarang,idPemohon,jumlahBarang,keterangan};
                _tabel.addRow(data);
            }
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonanlogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public void loaddatapermohonanditolak(PermohonanLogistik view) {
        String[] kolom = {kdPeermohonan, kBaarang,iddPemohon,jumlahBaarang,keeterangan};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabelpermohonanditolaklogistik().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "SELECT * from permohonan where status = 'ditolak'";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodePermohonan = rs.getString(1);
                String kodeBarang = rs.getString(2);
                String idPemohon = rs.getString(3);
                int jumlahBarang = rs.getInt(4);
                String keterangan = rs.getString(5);
                Object[] data = {kodePermohonan, kodeBarang,idPemohon,jumlahBarang,keterangan};
                _tabel.addRow(data);
            }
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(3).setPreferredWidth(100);
            view.getTabelpermohonanditolaklogistik().getColumnModel().getColumn(4).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }

    public void savebarangmasuk(Permohonan prmhn,String tglmsk) {
        Random r = new Random();
        int randId = r.nextInt(999-111) + 111;
        String s = "PRMHN"+Integer.toString(randId);
        try{
            String query="INSERT INTO BARANG_MASUK (kode_Barang, Kode_Barang_Masuk, Kode_Permohonan, Id_Pemohon, Jumlah_Barang, tanggal_masuk) VALUES("+
                    "'"+prmhn.getkodeBarang()+"',"+
                    "'"+s+"',"+
                    "'"+prmhn.getkodePermohonan()+"',"+
                    "'"+prmhn.getidPemohon()+"',"+
                    "'"+prmhn.getjumlahBarang()+"',"+
                    "'"+tglmsk+"')";
            
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            rs = statement.getGeneratedKeys();
            JOptionPane.showMessageDialog(null, "berhasil menambahkan data barang keluar");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Data barang keluar gagal disimpan");
        }
    }
    
    public int jumlahbarang(String kode){
        try{
            String query="SELECT jumlah_barang FROM barang WHERE Kode_barang= '"+kode+"'";
            rs=statement.executeQuery(query);
            int jumlah = 0;
            while(rs.next()){
                jumlah = rs.getInt(1);
            }
            return jumlah;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,gagal);
            return 0;
        }
    }

    public void ubahBarang(Permohonan prmhn) {
        try {
            int total = jumlahbarang(prmhn.getkodeBarang())-prmhn.getjumlahBarang();
            String sql = "UPDATE barang SET jumlah_barang= '"+total+
                    "' WHERE Kode_barang= '"+prmhn.getkodeBarang()+"'";
            statement.execute(sql);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,update);
        }
    }

    public void loadDataBarangPemohon(PermohonanPemohon view) {
        String[] kolom = {kBaarang,"Nama_Barang","Jenis_Barang",jumlahBaarang};
        _tabel = new DefaultTableModel(null,kolom){
            Class[] types = new Class [] {
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class,
               java.lang.String.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
            // Agar table tidak bisa diedit
            @Override
            public boolean isCellEditable(int row, int col) {
                int cola = _tabel.getColumnCount();
                return (col < cola) ? false : true;
            }
        };
        view.getTabeldatainventarispemohon().setModel(_tabel);
        try{
            hapusTabel();
            String sql = "" + "SELECT * from Barang";
            rs = statement.executeQuery(sql);
            while(rs.next()){
                String kodeBarang = rs.getString(1);
                String namaBarang = rs.getString(2);
                String jenisBarang = rs.getString(3);
                int jumlahBarang = rs.getInt(4);
                Object[] data = {kodeBarang,namaBarang,jenisBarang, jumlahBarang};
                _tabel.addRow(data);
            }
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(0).setPreferredWidth(100);
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(1).setPreferredWidth(100);
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(2).setPreferredWidth(100);
            view.getTabeldatainventarispemohon().getColumnModel().getColumn(3).setPreferredWidth(100);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null,gagal);
        }
    }
}

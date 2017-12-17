/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Novelty Octaviani
 */
public class Pemohon {
    private String Id_Pemohon;
    private String Password;
    private String Instansi_Pemohon;

    public Pemohon(String Id_Pemohon, String Password, String Instansi_Pemohon) {
        this.Id_Pemohon = Id_Pemohon;
        this.Password = Password;
        this.Instansi_Pemohon = Instansi_Pemohon;
    }

    
    public String getId_Pemohon() {
        return Id_Pemohon;
    }

    public void setId_Pemohon(String Id_Pemohon) {
        this.Id_Pemohon = Id_Pemohon;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getInstansi_Pemohon() {
        return Instansi_Pemohon;
    }

    public void setInstansi_Pemohon(String Instansi_Pemohon) {
        this.Instansi_Pemohon = Instansi_Pemohon;
    }
    
}

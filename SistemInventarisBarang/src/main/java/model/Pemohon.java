/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Novelty Octaviani
 */
public class Pemohon {
    private String idPemohon;
    private String password;
    private String instansiPemohon;

    public Pemohon(String idPemohon, String password, String instansiPemohon) {
        this.idPemohon = idPemohon;
        this.password = password;
        this.instansiPemohon = instansiPemohon;
    }

    
    public String getidPemohon() {
        return idPemohon;
    }

    public void setidPemohon(String idPemohon) {
        this.idPemohon = idPemohon;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public String getinstansiPemohon() {
        return instansiPemohon;
    }

    public void setinstansiPemohon(String instansiPemohon) {
        this.instansiPemohon = instansiPemohon;
    }
    
}

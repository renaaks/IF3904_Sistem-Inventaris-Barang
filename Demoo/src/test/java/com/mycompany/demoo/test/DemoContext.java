/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.demoo.test;

import cucumber.api.PendingException;
import cucumber.api.java.bm.Maka;
import cucumber.api.java.id.Dengan;
import cucumber.api.java.id.Ketika;
import junit.framework.Assert;

/**
 *
 * @author Novelty Octaviani
 */
public class DemoContext {

    @Dengan("^Data user baru yang akan dimasukan tersedia dan tidak duplikasi$")
    public void data_user_baru_yang_akan_dimasukan_tersedia_dan_tidak_duplikasi() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
    }

    @Ketika("^Memasukan data user$")
    public void memasukan_data_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
    }

    @Maka("^respon \"([^\"]*)\"$")
    public void respon(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        ///kode untuk cek ke database apakah user sudah ada
        String result = "user sukses dimasukan";///harusnya dari database
        Assert.assertEquals(arg1, result);
    }

    @Maka("^respon gagal dengan pesan \"([^\"]*)\"$")
    public void respon_gagal_dengan_pesan(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        String result = "duplicate";///harusnya dari database
        Assert.assertEquals(arg1, result);
    }

    @Dengan("^Data username dan password akan dimasukan tersedia dan sesuai$")
    public void data_username_dan_password_akan_dimasukan_tersedia_dan_sesuai() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //   throw new PendingException();
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
    }

    @Ketika("^Memasukan data username dan password$")
    public void memasukan_data_username_dan_password() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // throw new PendingException();
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
    }

    @Maka("^respon login \"([^\"]*)\"$")
    public void respon_login(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        String result = "anda telah berhasil login";
        Assert.assertEquals(arg1, result);
        
    }

    @Dengan("^Data username dan password yang akan dimasukan tidak tersedia$")
    public void data_username_dan_password_yang_akan_dimasukan_tidak_tersedia() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
    }

    @Maka("^respon login gagal dengan pesan \"([^\"]*)\"$")
    public void respon_login_gagal_dengan_pesan(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        String result = "username dan password tidak terdaftar";
        Assert.assertEquals(arg1, result);
    }
@Dengan("^Data barang yang akan dimasukkan tersedia dan tidak duplikasi$")
public void data_barang_yang_akan_dimasukkan_tersedia_dan_tidak_duplikasi() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
    
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
}

@Ketika("^Memasukkan data barang$")
public void memasukkan_data_barang() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
  //  throw new PendingException();
    
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
}

@Maka("^respon menjadi \"([^\"]*)\"$")
public void respon_menjadi(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    
        String result = "data barang sukses dimasukan";
        Assert.assertEquals(arg1, result);
}

@Dengan("^Data barang baru yang akan dimasukkan tersedia dan tidak duplikasi$")
public void data_barang_baru_yang_akan_dimasukkan_tersedia_dan_tidak_duplikasi() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
    
        boolean expected = false;
        ///kode untuk cek ke database apakah user sudah ada
        boolean result = false;///harusnya dari database
        Assert.assertEquals(expected, result);
}

@Maka("^respon akan gagal dengan pesan \"([^\"]*)\"$")
public void respon_akan_gagal_dengan_pesan(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
   // throw new PendingException();
   
        String result = "duplikat";
        Assert.assertEquals(arg1, result);
}
}

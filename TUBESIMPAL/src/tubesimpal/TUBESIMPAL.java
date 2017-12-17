/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesimpal;

import Database.Connect;

/**
 *
 * @author Novelty Octaviani
 */
public class TUBESIMPAL {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Connect c = new Connect();
       c.tryConnect();
    }
    
}

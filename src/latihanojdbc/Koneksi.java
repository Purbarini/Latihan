/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package latihanojdbc;

import java.sql.Connection;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Toshiba
 */
public class Koneksi {

    public Connection koneksi;
    
    public Connection getKoneksi() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setServerName("localhost");
            ods.setPortNumber(1521);
            ods.setServiceName("XE");
            ods.setUser("system");
            ods.setPassword("rini260595");
            ods.setDriverType("thin");
            koneksi = ods.getConnection();
            koneksi.createStatement().execute("alter session set current_schema=hr");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return koneksi;
        
    }
}

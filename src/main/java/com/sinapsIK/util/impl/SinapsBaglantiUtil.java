/*
 * Copyright (C) 2019 Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.util.impl;

import com.sinapsIK.util.BaglantiUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
// Dep. Inj. yaparken hangi implementasyonun doğrusu olduğunu sisteme tanıtmak için Component şerhi eklenir. @Bean tanımı varken gereksiz
// @Component("database")
public class SinapsBaglantiUtil implements BaglantiUtil{

    java.sql.Connection con;
    
    @Value("${database.url}")
    private String url;
    
    @Value("${database.user}")
    private String user;
    
    @Value("${database.pass}")
    private String pass;

//    public SinapsBaglantiUtil(String url, String user, String pass) {
//        this.url = url;
//        this.user = user;
//        this.pass = pass;
//    }

    @Override
    public Connection ac() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = (Connection) DriverManager
                    .getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SinapsBaglantiUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (Connection) con;
    }
    
    @Override
    public void kapat(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(SinapsBaglantiUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

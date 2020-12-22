/*
 * Copyright (C) 2019 Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.util.impl;

import com.sinapsIK.util.BaglantiUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
// Dep. Inj. yaparken hangi implementasyonun doğrusu olduğunu sisteme tanıtmak için Component şerhi eklenir. @Bean tanımı varken gereksiz
// @Component("database")
public class SentezBaglantiUtil implements BaglantiUtil{
    
    java.sql.Connection con;
    
    private final String url = "jdbc:sqlserver://120.120.13.7:1433;database=DEVSENTEZLIVE;";
    
    private final String user = "sa";
    
    private final String pass = "Sentez452*";

    @Override
    public Connection ac() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = (Connection) DriverManager
                    .getConnection(url, user, pass);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UretimBaglantiUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (Connection) con;
    }
    
    @Override
    public void kapat(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(UretimBaglantiUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

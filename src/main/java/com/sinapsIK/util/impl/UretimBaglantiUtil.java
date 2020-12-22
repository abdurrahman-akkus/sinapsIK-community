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
public class UretimBaglantiUtil implements BaglantiUtil{

    java.sql.Connection con;
    
    private final String url = "jdbc:mysql://120.120.16.51:3307/uretim?useUnicode=true&characterEncoding=utf8&useLegacyDatetimeCode=false&serverTimezone=Turkey";
    
    private final String user = "root";
    
    private final String pass = "1234567AbcFark";

    @Override
    public Connection ac() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
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

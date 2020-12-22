/*
 * Copyright (C) 2019 Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
public class SutunUtil {

    public SutunUtil() {
    }

    /**
     * Bu metod Arraylist olarak aldığı veriyi SQL için sutun adlarını döndürür.
     * @param sutunlar Sutun adlarını içeren ArrayList'i alır
     * @return Sutun adlarını String olarak geri döndürür.
     */
    public String sutunString(ArrayList<String> sutunlar) {
        String sutun = "";
        for (Iterator<String> it = sutunlar.iterator(); it.hasNext();) {
            sutun += it.next() + ",";
        }
        return sutun.substring(0, sutun.length() - 1);
    }
    
    public String degerString(ArrayList<String> degerler) {
        String sutun = "";
        for (Iterator<String> it = degerler.iterator(); it.hasNext();) {
            sutun += "\""+ it.next() + "\",";
        }
        return sutun.substring(0, sutun.length() - 1);
    }
}

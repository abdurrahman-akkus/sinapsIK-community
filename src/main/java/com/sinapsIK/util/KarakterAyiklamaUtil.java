/*
 * Copyright (C) 2019 Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 * Bu yazılımın tüm hakları Algoritim Bilişim'e aittir.
 */
package com.sinapsIK.util;

/**
 *
 * @author Abdurrahman AKKUŞ <iletisim@algoritimbilisim.com>
 */
public class KarakterAyiklamaUtil {

    public String turkceKarakterAyiklama(String anaKelime) {
       char [][] karakterler = {
                                {'Ü', 'U'},
                                {'Ö', 'O'},
                                {'Ç', 'C'},
                                {'Ş', 'S'},
                                {'İ', 'I'},
                                {'Ğ', 'g'},
                                {'ö', 'o'},
                                {'ç', 'c'},
                                {'ş', 's'},
                                {'ı', 'i'},
                                {'ğ', 'g'},
                                {'ü', 'u'}
                                };
       
        for (char[] karakter:karakterler) {
           anaKelime = anaKelime.replace(karakter[0], karakter[1]);
        }
       return anaKelime;
    }
    
    public String simgeAyiklama(String anaKelime) {
       char [] karakterler = {' ', '.', '*', '/', '\\', '&','+','-','#','(',')','[',']','<','>',',',';','%','=','|','$'};
       if(anaKelime==null) return ""; 
       
        for (char karakter:karakterler) {
           anaKelime = anaKelime.replace(karakter, '_');
        }
       return anaKelime;
    }
    
}

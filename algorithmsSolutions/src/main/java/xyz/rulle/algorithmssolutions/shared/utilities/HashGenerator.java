/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.utilities;


/**
 *
 * @author Michael
 */
public class HashGenerator{
    public static int firstChar(String key){
        char charVal = key.charAt(0);
        return (charVal * 13)%32;
    }
    
    public static int lastChar(String key){
        char charVal = key.charAt(key.length()-1);
        return (charVal * 13) % 32;
    }
    
    public static int allChars(String key){
        int res = 0;
        char[] charAray = key.toCharArray();
        for (char c : charAray) {
            res += c;
        }
        return res % 32;
    }
}

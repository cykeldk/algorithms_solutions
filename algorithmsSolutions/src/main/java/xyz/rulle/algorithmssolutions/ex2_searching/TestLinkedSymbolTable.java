/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.ex2_searching;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import xyz.rulle.algorithmssolutions.shared.datastructures.LinkedSymbolTable;
import xyz.rulle.algorithmssolutions.shared.utilities.FileUtility;

/**
 *
 * @author Michael
 */
public class TestLinkedSymbolTable {
    public static void main(String[] args) throws IOException {
        String filepath = new File("/src/main/resources/shakespeare-complete-works.txt").getAbsolutePath();
        String basepath = new File("").getAbsolutePath();
        String path = basepath + filepath.replaceFirst("C:", "");
        String delimiterPattern = "[^A-Za-z]";
        String[] allShake = FileUtility.toStringArray(path, delimiterPattern);
        
        String[] subShake = Arrays.copyOfRange(allShake, 0, 100000);
        
        LinkedSymbolTable lst = new LinkedSymbolTable();
        
        for (String string : subShake){
            lst.put(string, 1);
        }
        
        for (String string : lst.keys()){
            System.out.println(string + " : " + lst.get(string));
        }
    }
}

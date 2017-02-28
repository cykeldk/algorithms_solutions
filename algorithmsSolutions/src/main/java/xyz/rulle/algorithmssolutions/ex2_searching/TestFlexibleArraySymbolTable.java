/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.ex2_searching;

import xyz.rulle.algorithmssolutions.shared.datastructures.FlexibleArraySymbolTable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import xyz.rulle.algorithmssolutions.shared.utilities.FileUtility;

/**
 *
 * @author Michael
 */
public class TestFlexibleArraySymbolTable {
    public static void main(String[] args) throws IOException {
        String filepath = new File("/src/main/resources/shakespeare-complete-works.txt").getAbsolutePath();
        String basepath = new File("").getAbsolutePath();
        String path = basepath + filepath.replaceFirst("C:", "");
        String delimiterPattern = "[^A-Za-z]";
        String[] allShake = FileUtility.toStringArray(path, delimiterPattern);
        
        String[] subShake = Arrays.copyOfRange(allShake, 0, 100);
        
        FlexibleArraySymbolTable fast = new FlexibleArraySymbolTable();
        
        
        
        for (String string : subShake){
            fast.put(string, 1);
        }
        
        for (String string : fast.keys()){
            System.out.println(string + " : " + fast.get(string));
        }
    }
}

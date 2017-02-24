/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.ex2_searching;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import xyz.rulle.algorithmssolutions.shared.datastructures.BinarySearchTree;
import xyz.rulle.algorithmssolutions.shared.utilities.FileUtility;

/**
 *
 * @author Michael
 */
public class TestBinarySearchTree {

    public static void main(String[] args) throws IOException {
        String filepath = new File("/src/main/resources/shakespeare-complete-works.txt").getAbsolutePath();
        String basepath = new File("").getAbsolutePath();
        String path = basepath + filepath.replaceFirst("C:", "");
        String delimiterPattern = "[^A-Za-z]";
        String[] allShake = FileUtility.toStringArray(path, delimiterPattern);

        String[] subShake = Arrays.copyOfRange(allShake, 0, 100000);
        // String[] subShake = {"citron", "beta","and", "citron", "dør", "elefant"};

        BinarySearchTree<String, Integer> lst = new BinarySearchTree();

        for (String string : allShake) {
            int value = 1;
            try {
                value = lst.get(string) + 1;
                lst.put(string, value);
            } catch (NullPointerException ex) {
                lst.put(string, value);
            }
        }
        
        lst.reBalance();
        System.out.println("done rebalancing");
        lst.reBalance();
        System.out.println("done rebalancing");
        
        System.out.println("sorted = " + lst.isSorted());
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.ex2_searching.hashing;

import java.io.File;
import java.io.IOException;
import xyz.rulle.algorithmssolutions.shared.interfaces.HashFunction;
import xyz.rulle.algorithmssolutions.shared.utilities.FileUtility;

/**
 *
 * @author Michael
 */
public class TestHash {
    public static void main(String[] args) throws IOException {
        
        String filepath = new File("/src/main/resources/shakespeare-complete-works.txt").getAbsolutePath();
        String basepath = new File("").getAbsolutePath();
        String path = basepath + filepath.replaceFirst("C:", "");
        String delimiterPattern = "[^A-Za-z]";
        String[] words = FileUtility.toStringArray(path, delimiterPattern);
        
        runHash(words, new HashFunction(){
            @Override
            public int function(String key){
                int res = 0;
                char[] chars = key.toCharArray();
                for (char c : chars) {
                    res += c;
                }
                return res %32;
            }
        });
    }
    
    public static void runHash(String[] words, HashFunction hash){
        int average = words.length / 32;
        int max = 0;
        int min = words.length;
        int wordCounter = 0;
        
        int[] counts = new int[32];
        
        for (int i = 0; i < words.length; i++) {
            counts[hash.function(words[i])] += 1;
        }
        
        for (int i = 0; i < counts.length; i++) {
            System.out.print("values in " + i + ": \t");
            if (counts[i] < min) min = counts[i];
                
            else if ( counts[i]> max) max = counts[i];
            
            for (int j = counts[i]; j > 0; j--) {
                if (j%100 == 0) System.out.print("#");
            }
            System.out.println("");
        }
        System.out.println("Average is:\t" + average);
        System.out.println("Max is:\t" + max);
        System.out.println("Min is:\t" + min);
    }
}

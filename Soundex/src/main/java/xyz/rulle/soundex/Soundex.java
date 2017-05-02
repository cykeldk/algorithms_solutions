/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.soundex;

import java.util.ArrayList;

/**
 *
 * @author Michael
 */
public class Soundex {

    private static final String[] USAREPLACE = {
        "[BFPV]",
        "[CGJKQSXZ]",
        "[DT]",
        "[L]",
        "[MN]",
        "[R]"
    };
    private static final String USAREMOVE = "[AEIOUY]";

    public static void main(String[] args) {
        System.out.println("hyperbolic : " + sdex("hyperbolic"));
        System.out.println("Pfister : " + sdex("Pfister"));
        System.out.println("Robert : " + sdex("Robert"));
        System.out.println("Rupert : " + sdex("Rupert"));
        System.out.println("Rubin : " + sdex("Rubin"));
        System.out.println("Ashcraft : " + sdex("Ashcraft"));
        System.out.println("Ashcroft : " + sdex("Ashcroft"));
    }

    public static String sdex(String data) {
        data = data.toUpperCase();
        String res = data.substring(0, 1);
        String startMatch = "";
        String rest = data.substring(1);
        
        for (int i = 1; i <= USAREPLACE.length; i++) {
            if (res.matches(USAREPLACE[i - 1])) {
                startMatch = USAREPLACE[i - 1];
                break;
            }
        }
        
        if (startMatch.length() > 0) {
            while (rest.substring(0, 1).matches(startMatch)) {
                rest = rest.substring(1);
            }
        }

        rest = rest.replaceAll("[WH]", "");
        for (int i = 1; i <= USAREPLACE.length; i++) {
            rest = rest.replaceAll(USAREPLACE[i - 1], "" + i);
        }

        rest = rest.replaceAll(USAREMOVE, "");
        res = res + rest;

        for (int i = 0; i < res.length() - 1; i++) {

            if (res.charAt(i) == res.charAt(i + 1)) {
                res = res.substring(0, i) + res.substring(i + 1);
            }
        }

        if (res.length() > 4) {
            res = res.substring(0, 4);
        }

        while (res.length() < 4) {
            res = res.concat("0");
        }
        return res;
    }
}

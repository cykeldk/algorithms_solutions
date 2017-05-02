/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.soundex;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class SoundexTest {
    
    public SoundexTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Soundex.
     */
    
    @Test
    public void testSdexRobert() {
        System.out.println("sdex : Robert");
        String data = "Robert";
        String expResult = "R163";
        String result = Soundex.sdex(data);
        System.out.println("EXPECTED: " + expResult);
        System.out.println("RESULT: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSdexRupert() {
        System.out.println("sdex : Rupert");
        String data = "Rupert";
        String expResult = "R163";
        String result = Soundex.sdex(data);
        System.out.println("EXPECTED: " + expResult);
        System.out.println("RESULT: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSdexRubin() {
        System.out.println("sdex : Rubin");
        String data = "Rubin";
        String expResult = "R150";
        String result = Soundex.sdex(data);
        System.out.println("EXPECTED: " + expResult);
        System.out.println("RESULT: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSdexAshcraft() {
        System.out.println("sdex : Ashcraft");
        String data = "Ashcraft";
        String expResult = "A261";
        String result = Soundex.sdex(data);
        System.out.println("EXPECTED: " + expResult);
        System.out.println("RESULT: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSdexAshcroft() {
        System.out.println("sdex : Ashcroft");
        String data = "Ashcroft";
        String expResult = "A261";
        String result = Soundex.sdex(data);
        System.out.println("EXPECTED: " + expResult);
        System.out.println("RESULT: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSdexTymczak() {
        System.out.println("sdex : Tymczak");
        String data = "Tymczak";
        String expResult = "T522";
        String result = Soundex.sdex(data);
        System.out.println("Tymczak = " + Soundex.sdex(data));
        System.out.println("EXPECTED: " + expResult);
        System.out.println("RESULT: " + result);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testSdexPfister() {
        System.out.println("sdex : Pfister");
        String data = "Pfister";
        String expResult = "P236";
        String result = Soundex.sdex(data);
        System.out.println("EXPECTED: " + expResult);
        System.out.println("RESULT: " + result);
        assertEquals(expResult, result);
    }
    
//    @Test
//    public void testAlphabet() {
//        System.out.println("sdex : Alphabet");
//        String data = "Alphabet";
//        String expResult = "A413";
//        String result = Soundex.sdex(data);
//        System.out.println("EXPECTED: " + expResult);
//        System.out.println("RESULT: " + result);
//        assertEquals(expResult, result);
//    }
}

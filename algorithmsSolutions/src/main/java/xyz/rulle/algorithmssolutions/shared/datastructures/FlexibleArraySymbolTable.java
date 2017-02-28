/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.datastructures;

import java.util.ArrayList;
import java.util.List;
import xyz.rulle.algorithmssolutions.shared.interfaces.SymbolTable;

/**
 *
 * @author Michael
 *
 *
 */
public class FlexibleArraySymbolTable implements SymbolTable<String, Integer> {

    FlexibleArray<SymbolTable> rowContainer;
    private int size = 0;
    private int rowCounter = 32; // default value
    private FlexibleArray<Integer> badRows;

    public FlexibleArraySymbolTable() {
        rowContainer = new FlexibleArray();
        for (int i = 0; i < rowCounter; i++) {
            SymbolTable tmp = new ArraySymbolTable();
            rowContainer.add(tmp);
        }
        badRows = new FlexibleArray();
    }

    @Override
    public void put(String key, Integer value) {
        Word w = new Word(key, value);
        int theHash = hash(key);
        rowContainer.get(theHash).put(key, value);
        if (rowContainer.get(theHash).size() > rowCounter) {
            badRows.add(theHash);
        }
        size++;
    }

    @Override
    public Integer get(String key) {
        int theHash = hash(key);
        SymbolTable tmp = rowContainer.get(theHash);
        return (Integer) tmp.get(key);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<String> keys() {
        
        ArrayList<String> res = new ArrayList();
        for (int i = 0; i < rowCounter; i++) {
//            System.out.println("printing array " + i);
            SymbolTable ast = rowContainer.get(i);
//            System.out.println("array " + i + " has size: " + fa.size());
            if (ast.size() > 0) {
                for (String key : (List<String>)ast.keys()) {
                    res.add(key);
                }
            }

        }
        return res;
    }

    private int hash(String key) {
        int res = 0;

        for (char c : key.toCharArray()) {
            res += c;
        }
        res = res % rowCounter;
//        System.out.println("hash is: " + res);
        return res;
    }

    public FlexibleArray<Integer> getBadRows() {
        return badRows;
    }
}

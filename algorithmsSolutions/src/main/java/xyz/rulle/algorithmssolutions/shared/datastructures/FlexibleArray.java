/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.datastructures;

import java.util.Iterator;

/**
 *
 * @author Michael
 */
public class FlexibleArray<T>{
    private T[] array1;
    private T[] array2;
    private int length;
    private int split;
    
    public FlexibleArray(T type){
        array1 = (T[]) new Object[1];
        array2 = (T[]) new Object[2];
        length = 0;
    }
    
    public void add(T element){
        if (length < array1.length){
            array1[length]=element;
            length += 1;
        }
        else{
            array2[split] = array1[split];
            array2[length] = element;
            split++;
            length++;
            if(length >= array2.length) makeNew();
        }
    }
    
    public T get(int index){
        if (index >= split && index < array1.length) return  array1[index];
        else return array2[index];
    }
    
    public void set(int index, T element){
        if (split < length && length < array1.length) array1[index] = element;
        else array2[index] = element;
    }
    
    public int size(){
        return length;
    }
    
    public int indexOf(T element){
        for (int i = 0; i < length; i++) {
            if (element.equals(get(i))) return i;
        }
        return -1;
    }
    
    private void makeNew(){
        array1 = array2;
        array2 = (T[]) new Object[length * 2];
        split = 0;
    }
    
    private void printArray(T[] toPrint){
        for (T t : toPrint) {
            System.out.println(t.toString());
        }
    }
    
    @Override
    public String toString(){
        String res = "";
        for (int i = 0; i < length; i++) {
            res += get(i);
        }
        return res;
    }
}

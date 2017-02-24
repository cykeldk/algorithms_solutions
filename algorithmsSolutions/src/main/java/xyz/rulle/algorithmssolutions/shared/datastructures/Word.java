/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.datastructures;

import java.util.Objects;

/**
 *
 * @author Michael
 */
public class Word {
    private String word;
    private int count;
    
    @Override
    public int hashCode(){
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.word);
        return hash;
    }
    
    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        
        if (obj == null) return false;
        
        if (getClass() != obj.getClass()) return false;
        
        final Word other = (Word) obj;
        if (!Objects.equals(this.word, other.word)) return false;
        return true;
    }
    
    public Word(String word, int count){
        this.word = word;
        this.count = count;
    }
    
    public int getCount(){
        return count;
    }
    
    public void setCount(int count){
        this.count = count;
    }
    
    public String getWord(){
        return word;
    }
    
    public void setWord(String word){
        this.word = word;
    }
    
}

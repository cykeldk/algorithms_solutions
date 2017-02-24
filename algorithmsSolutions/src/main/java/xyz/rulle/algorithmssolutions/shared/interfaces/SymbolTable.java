/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.interfaces;

/**
 *
 * @author Michael
 */
public interface SymbolTable<K, V> {
    
    void put(K key, V value);
    
    V get(K key);
    
    int size();
    
    Iterable<K> keys();
    
    default void delete(K key){
        put(key, null);
    }
    
    default boolean contains(K key){
        return get(key) != null;
    }
    
    default boolean isEmpty(){
        return size() == 0;
    }
}

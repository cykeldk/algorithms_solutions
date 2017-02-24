/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Michael
 * @param <K>
 * @param <V>
 */
public class BinarySearchTree<K extends Comparable<K>, V> {

    private K key;
    private V value;
    private BinarySearchTree<K, V> left;
    private BinarySearchTree<K, V> right;
    private boolean root = false;

    public BinarySearchTree() {
    
    }

    public BinarySearchTree(K key, V value) {
        this.key = key;
        this.value = value;
        this.root = true;
    }

    public void put(K key, V value) {

        if (this.key == null) {
            this.key = key;
            this.value = value;
            this.root = true;
            System.out.println("first root: " + this.key);
            return;
        }
        if (key.compareTo(this.key)<0){
            if (this.root){
//                System.out.println("sending " + key + " to the left");
            }
            if (left == null) left = new BinarySearchTree(key, value);
            else left.put(key, value);
        }
        else if (key.compareTo(this.key)>0){
            if (this.root){
//                System.out.println("sending " + key + " to the right");
            }
            if (right == null) right = new BinarySearchTree(key, value);
            else right.put(key, value);
        }
        else this.value = value;
    }

    public V get(K key) {
        if (key.compareTo(this.key) < 0) {
            if (left == null) {
                return null;
            }
            return left.get(key);
        } else if (key.compareTo(this.key) > 0) {
            if (right == null) {
                return null;
            }
            return right.get(key);
        } else {
            return this.value;
        }
    }

    public List<K> keys() {
        ArrayList<K> keys = new ArrayList();
        
        if (left != null) {
            keys.addAll(left.keys());

        }
        keys.add(this.key);
        if (right != null) {
            keys.addAll(right.keys());
        }

        
/*
        System.out.println("keys under " + this.key + ": ");
        for (int i = 0; i < keys.size(); i++) {
            System.out.println(keys.get(i));
        }
*/
        return keys;

    }
    
    public boolean isSorted(){
        List<K> tmpList = keys();
        K tmpKey = tmpList.get(0);
        for (int i = 0; i < tmpList.size(); i++) {
            if (tmpKey.compareTo(tmpList.get(i)) > 0){
                return false;
            }
            tmpKey = tmpList.get(i);
        }
        return true;
    }
    
    
    
    public BinarySearchTree reBalance(){
        BinarySearchTree res;
        boolean balanced = isBalanced();
//        System.out.println("this is balanced, it's " + balanced);
        if (isBalanced()) res = this;
        else{
            res = makeNew(keys(), this);
        }
        return res;
        
    }
    
    public boolean isBalanced(){
        int leftCounter = 0;
        int rightCounter = 0;
        
        if (left != null){
            BinarySearchTree tmpLeft = left;
            while(tmpLeft != null){
                tmpLeft = tmpLeft.left;
                leftCounter++;
//                System.out.println("incremented LEFT");
            }
        }
        if (right != null){
            BinarySearchTree tmpRight = right;
            while(tmpRight != null){
                tmpRight = tmpRight.left;
                rightCounter++;
//                System.out.println("incremented RIGHT");
            }
        }
        
        System.out.println("depth left tree: " + leftCounter);
        System.out.println("depth right tree: " + rightCounter);
        if (Math.abs(leftCounter - rightCounter)>= 3) return false;
        else return true;
    }
    
    
    private BinarySearchTree makeNew(List<K> oldKeys, BinarySearchTree old){
        int newRootsIndex = oldKeys.size()/2;
        
        K newRootKey = oldKeys.get(newRootsIndex);
        
        BinarySearchTree res = new BinarySearchTree(newRootKey, old.get(newRootKey));
        System.out.println("new root: "+ newRootKey);
        oldKeys.remove(newRootsIndex);
        
        Random rnd = new Random();
        while(!oldKeys.isEmpty()){
            K k = oldKeys.remove(rnd.nextInt(oldKeys.size()));
            res.put(k, old.get(k));
        }
        return res;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.utilities;

/**
 *
 * @author Michael
 */
import java.util.Arrays;

/**
 *
 * @author michael
 */
public class SortingAlgorithms { 
   public static String[] insertionSort(String[] insertionArray){
        
//        String key;
//        int counter;
//        int comparison = 0;
        for (int i = 1; i < insertionArray.length; i++) {
            String key = insertionArray[i];
            if(key.compareTo(insertionArray[i-1])<0){
//                // System.out.println("if " + key + " : " + " : " + insertionArray[i-1] + " : " + key.compareTo(insertionArray[i-1]));
//                continue;
//            }
//            else{
                int counter = i;
                while(counter - 1 >= 0 && key.compareTo(insertionArray[counter - 1])<0){
                    // System.out.println("else " + key + " : " + insertionArray[i-1] + " : " + key.compareTo(insertionArray[i-1]));
                    insertionArray[counter] = insertionArray[counter-1];
                    counter--;
                }
                insertionArray[counter] = key;
            }
        }
        return insertionArray;
    }
    
    
    public static String[] selectionSort(String[] selectionArray){
        int indexOfLowest;
        String temp;
        for (int i = 0; i < selectionArray.length; i++){
            indexOfLowest = i;
            for (int j = i+1; j < selectionArray.length; j++){
                if (selectionArray[j].compareTo(selectionArray[indexOfLowest])<0){
                    indexOfLowest = j;
                }
            }
            temp = selectionArray[i];
            selectionArray[i] = selectionArray[indexOfLowest];
            selectionArray[indexOfLowest] = temp;
        }
        return selectionArray;
    }
    
    public static boolean isSorted(String[] testThis){
        String temp = testThis[0];
        for (int i = 1; i < testThis.length; i++) {
            if (temp.compareTo(testThis[i])>0){
                return false;
            }
            temp = testThis[i];
        }
        return true;
    }
    
    //Nicklas merge sort addition:
    
    //Sorts stupidly fast!
    public static void mergeSort(String[] names) {
        //Split the list if more than 1 element
        //base case would therefore be when 1 element is left in the array.
        if (names.length > 1) {
            String[] left = new String[names.length / 2];
            String[] right = new String[names.length - names.length / 2];

            for (int i = 0; i < left.length; i++) {
                left[i] = names[i];
            }

            for (int i = 0; i < right.length; i++) {
                right[i] = names[i + names.length / 2];
            }
            //recursive calls to split the lists again.
            mergeSort(left);
            mergeSort(right);
            
            //merge it all back together :)
            merge(names, left, right);
        }
    }

    private static void merge(String[] names, String[] left, String[] right) {
        int a = 0;//index for list a
        int b = 0;//index for list b
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && left[a].compareToIgnoreCase(right[b]) < 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }
    
    public static String[] mergeSort2(String[] selectionArray){
        int length = selectionArray.length;
        if (length <= 1){
            return selectionArray;
        }
        String[] leftArray = Arrays.copyOfRange(selectionArray, 0, length/2);
        String[] rightArray = Arrays.copyOfRange(selectionArray, length/2, selectionArray.length);
        leftArray = mergeSort2(leftArray);
        rightArray = mergeSort2(rightArray);
        return merge2(leftArray, rightArray);
    }

    private static String[] merge2(String[] left, String[] right){
        String[] res = new String[left.length + right.length];
        
        
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < res.length; i++) {
            if (leftCount >= left.length){
//                System.out.println("left count >= size");
                System.arraycopy(right, rightCount, res, i, right.length - rightCount);
                return res;
            }
            else if(rightCount >= right.length){
//                System.out.println("right count >= size");
                System.arraycopy(left, leftCount, res, i, left.length - leftCount);
                return res;
            }
            else if(left[leftCount].compareToIgnoreCase(right[rightCount])<=0){
//                System.out.println("adding from left to result");
                res[i] = left[leftCount];
                leftCount++;
            }
            else{
//                System.out.println("adding from right to result");
                res[i] = right[rightCount];
                rightCount++;
            }
//            System.out.println("printing resulting array after each loop");
//        printArray(res);
            
        }
//        System.out.println("printing resulting array before return statement");
//        printArray(res);
        
        // merge2 sort took 328784 milliseconds
        /*
        for (int i = 0; i < res.length; i++) {
            if (left.length < 1){
                System.arraycopy(right, 0, res, i, right.length);
                return res;
            }
            else if(right.length < 1){
                System.arraycopy(left, 0, res, i, left.length);
                return res;
            }
            else if(left[0].compareToIgnoreCase(right[0])<=0){
                res[i] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            }
            else{
                res[i] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }
        */
        return res;
    }
    
    public static void printArray(String[] print){
        int counter = 0;
        int wordsPerLine = 30;
        while (counter<print.length){
            for (int i = 0; i < wordsPerLine; i++) {
                if(counter < print.length) System.out.print(print[counter] + " ");
                counter++;
            }
            System.out.println("");
        }
    }
}
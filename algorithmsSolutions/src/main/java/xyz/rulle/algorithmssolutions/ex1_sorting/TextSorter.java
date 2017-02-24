/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.ex1_sorting;

/**
 *
 * @author Michael
 */
import xyz.rulle.algorithmssolutions.shared.utilities.SortingAlgorithms;
import xyz.rulle.algorithmssolutions.shared.utilities.Stopwatch;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import xyz.rulle.algorithmssolutions.shared.utilities.FileUtility;
/**
 *
 * @author michael
 */
public class TextSorter {
    private static String[] shakespeare;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int sizeLimit = 50;
        boolean ok = false;
        Stopwatch sw = new Stopwatch();
        
//        String path = "C:\\Users\\nickl\\Documents\\Algorithms\\Shakespear\\shakespeare-complete-works.txt";
//        String path = "C:\\datamatiker\\algorithms_course\\shakespeare\\shakespeare_original_complete.txt";
        String path = "C:\\Users\\Michael\\Documents\\NetBeansProjects\\SortingAlgorithms\\shakespeare-complete-works.txt";
        String delimiterPattern = "[^A-Za-z]";
        try {
            shakespeare = FileUtility.toStringArray(path, delimiterPattern);
        } catch (IOException ex) {
            Logger.getLogger(TextSorter.class.getName()).log(Level.SEVERE, null, ex);
        }
        //part of file
//        String[] toBeSorted = Arrays.copyOfRange(shakespeare, 0, sizeLimit);
        
        //full file
        String[] toBeSorted = shakespeare;
        
//        String[] insertionSorted = toBeSorted.clone();
//        String[] selectionSorted = toBeSorted.clone();
        String[] mergeSorted = toBeSorted.clone();
        String[] mergeSorted2 = toBeSorted.clone();
        
        //Selection sort
//        sw.start();
//        SortingAlgorithms.selectionSort(selectionSorted);
//        sw.stop();
//        ok = SortingAlgorithms.isSorted(selectionSorted);
//        System.out.println("is it sorted: " + ok);
//        
//        System.out.println("selection sort took " + sw.timeElapsed() + " milliseconds");
//        
//        //Insertion sort
//        sw.start();
//        SortingAlgorithms.insertionSort(insertionSorted);
//        sw.stop();
//        ok = SortingAlgorithms.isSorted(insertionSorted);
//        System.out.println("is it sorted: " + ok);
//        
//        System.out.println("insertion sort took " + sw.timeElapsed() + " milliseconds");
        
        //Merge sort
        sw.start();
        SortingAlgorithms.mergeSort(mergeSorted);
        sw.stop();
        ok = SortingAlgorithms.isSorted(mergeSorted);
        System.out.println("is it sorted: " + ok);
        
        System.out.println("merge sort took " + sw.timeElapsed() + " milliseconds");
        
        // merge Sort 2
        
        sw.start();
        mergeSorted2 = SortingAlgorithms.mergeSort2(mergeSorted2);
        sw.stop();
        ok = SortingAlgorithms.isSorted(mergeSorted2);
        System.out.println("is it sorted: " + ok);
//        SortingAlgorithms.printArray(mergeSorted2);
        System.out.println("merge2 sort took " + sw.timeElapsed() + " milliseconds");
        
        
    }
}

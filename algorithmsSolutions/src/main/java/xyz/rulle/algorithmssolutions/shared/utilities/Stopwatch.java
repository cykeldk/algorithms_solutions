/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.rulle.algorithmssolutions.shared.utilities;

/**
 *
 * @author Nicklas Molving
 */
public class Stopwatch {
    
    private long startTime;
    private long stopTime;
//    private long elapsedTime;
    
    public void start(){
        startTime = System.currentTimeMillis();
    }
    
    public void stop(){
        stopTime = System.currentTimeMillis();
    }
    
    public long timeElapsed(){
        return stopTime-startTime;
    }
    
    
}
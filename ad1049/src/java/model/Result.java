/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.model;

/**
 *
 * @author g14949tk
 */
public class Result {
    public Result(){}
    public Result(int c){
        count = c;
    }
    private int count=0;
    public void countUp(){
        count++;
    }
    public void setResult(int c){
        count = c;
    }
    public int getCount(){
        return count;
    }
}

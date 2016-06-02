/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.model;

/**
 *
 * @author g14949tk
 */
public class Data {
        String data;
        int order;
    public Data(String data, int order){
        this.data = data;
        this.order = order;
    }
    public String getData(){return data;}
    public int getOrder(){return order;}
}

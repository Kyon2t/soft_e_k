/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.model;

/**
 *
 * @author g14949tk
 */
public class Quest {
    private String q1 = "        ";
    private String q2 = "        ";
    private int answer;
    public Quest(){}
    public Quest(String q1, String q2, int answer){
        this.q1 = q1;
        this.q2 = q2;
        this.answer = answer;
    }
    public String getQuest1(){return q1;}
    public String getQuest2(){return q2;}
    public int getAnswer(){ return answer;}
}

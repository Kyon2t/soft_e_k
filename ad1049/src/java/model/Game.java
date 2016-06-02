/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.model;

import java.util.List;
import java.util.Random;

/**
 *
 * @author g14949tk
 */
public class Game {
    int answer=0;
    List<Data> data;
    String answerA;
    String answerB;
    int count;
    void setAnswer(int answerA, int answerB){ //3
        answer = 100;//A
        if(answerA>answerB){
            answer = 200;//B
        }
    }
    public int getAnswer(){
        return answer;
    }
    public String getQuest1(){
        return answerA;
    }
    public String getQuest2(){
        return answerB;
    }
    public Game(){}
    public Game(List<Data> data){
        this.data = data;
        Random rn = new Random();
        int a = rn.nextInt(5);
        int b = rn.nextInt(5);
        while(a == b) {b = rn.nextInt(5);}
        answerA = data.get(a).getData();
        int numA = data.get(a).getOrder();
        answerB = data.get(b).getData();
        int numB = data.get(b).getOrder();
        setAnswer(numA, numB);
    }
}

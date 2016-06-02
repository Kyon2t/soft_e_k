/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.dao;
import java.model.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author g14910he
 */
public class DataDAO {
      List<Data> japanList = new ArrayList<Data>();
      List<Data> numberList = new ArrayList<Data>();
      List<Data> characterList = new ArrayList<Data>();
      List<Data> paperList = new ArrayList<Data>();
      List<Data> planetList = new ArrayList<Data>();
      List<Data> countryList = new ArrayList<Data>();
      
    public void findAll(){
        Connection conn = null;
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/db1049";
            conn = DriverManager.getConnection(driverURL, "ek", "ek");
            String sql1 = "SELECT PREFECTURE, ORDERS FROM JAPAN";
            PreparedStatement pStmt = conn.prepareStatement(sql1);
            ResultSet rs = pStmt.executeQuery();
            while(rs.next()){
                String prefecture = rs.getString("PREFECTURE");
                int orders = rs.getInt("ORDERS");
                Data data = new Data(prefecture, orders);
                japanList.add(data);
            }
            String sql2 = "SELECT NUMBER, ORDERS FROM NUMBERS";
            PreparedStatement pStmt2 = conn.prepareStatement(sql2);
            rs = pStmt2.executeQuery();
            while(rs.next()){
                String number = rs.getString("NUMBER");
                int orders = rs.getInt("ORDERS");
                Data data = new Data(number, orders);
                numberList.add(data);
            }
            String sql3 = "SELECT CHARACTERS, ORDERS FROM CHARACTERS";
            PreparedStatement pStmt3 = conn.prepareStatement(sql3);
            rs = pStmt3.executeQuery();
            while(rs.next()){
                String character = rs.getString("CHARACTERS");
                int orders = rs.getInt("ORDERS");
                Data data = new Data(character, orders);
                characterList.add(data);
            }
            String sql4 = "SELECT PAPER, ORDERS FROM PAPERS";
            PreparedStatement pStmt4 = conn.prepareStatement(sql4);
            rs = pStmt4.executeQuery();
            while(rs.next()){
                String paper = rs.getString("PAPER");
                int orders = rs.getInt("ORDERS");
                Data data = new Data(paper, orders);
                paperList.add(data);
            }
            String sql5 = "SELECT PLANET, ORDERS FROM PLANETS";
            PreparedStatement pStmt5 = conn.prepareStatement(sql5);
            rs = pStmt5.executeQuery();
            while(rs.next()){
                String planet = rs.getString("PLANET");
                int orders = rs.getInt("ORDERS");
                Data data = new Data(planet, orders);
                planetList.add(data);
            }
            String sql6 = "SELECT COUNTRY, ORDERS FROM COUNTRYS";
            PreparedStatement pStmt6 = conn.prepareStatement(sql6);
            rs = pStmt6.executeQuery();
            while(rs.next()){
                String country = rs.getString("COUNTRY");
                int orders = rs.getInt("ORDERS");
                Data data = new Data(country, orders);
                countryList.add(data);
            }          
        } catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }finally{
            if(conn!= null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public List<Data> getList(){
        List<Data> presentList = new ArrayList<Data>();
        Random rn = new Random();
        int select = rn.nextInt(6);
        if(select == 0) presentList = japanList;
        else if(select == 1) presentList = numberList;
        else if(select == 2) presentList = characterList;
        else if(select == 3) presentList = paperList;
        else if(select == 4) presentList = planetList;
        else if(select == 5) presentList = countryList;
        else presentList = null;
        return presentList;
    }
}

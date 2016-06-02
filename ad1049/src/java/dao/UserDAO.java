/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.model.Login;
import java.model.User;

/**
 *
 * @author g14910he
 */
public class UserDAO {
     private final String DRIVER_NAME = "org.apache.derby.jdbc.ClientDriver";
  private final String JDBC_URL =
       "jdbc:derby://localhost:1527/db1049"; 
          
  private final String DB_USER = "ek";
  private final String DB_PASS = "ek";

   public User findByLogin(Login login) {
       
    Connection conn = null;
    User user = null;
    try {
      Class.forName(DRIVER_NAME);
      conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);

      String sql = "SELECT USERID, PASS FROM REGISTER WHERE USERID = ? AND PASS = ?";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, login.getId());
      pStmt.setString(2, login.getPass());

      ResultSet rs = pStmt.executeQuery();

      if (rs.next()) {
        String id = rs.getString("USERID");
        String pass = rs.getString("PASS");
        user = new User(id, pass);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return null;
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
      return null;
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
          return null;
        }
      }
    }
    return user;
  }  

    public boolean addUser(User user) {       
    Connection conn = null;
    int result = 0;
    
    try {
      Class.forName(DRIVER_NAME);
      conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);
      String sql = "INSERT INTO REGISTER(USERID, PASS) VALUES(?, ?)";
      PreparedStatement pStmt = conn.prepareStatement(sql);
      pStmt.setString(1, user.getId());
      pStmt.setString(2, user.getPass());
      result = pStmt.executeUpdate();
     
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    if (result == 1) {
         return true;
      }else{
          return false;
      }
     
    }
}

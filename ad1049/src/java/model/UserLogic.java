/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.model;

import java.dao.UserDAO;

/**
 *
 * @author g14910he
 */
public class UserLogic {
    public boolean addUser(User user){
        UserDAO dao = new UserDAO();
        boolean use = dao.addUser(user);
        return use;
    }
}

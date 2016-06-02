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
public class LoginLogic {
    public boolean execute(Login login){
        UserDAO dao = new UserDAO();
        User user = dao.findByLogin(login);
        return user != null;
    }
}

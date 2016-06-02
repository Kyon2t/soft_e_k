/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.model.User;
import java.model.UserLogic;

/*
 *
 * @author g14910he
 */
//web.xml(name = "UserServlet", urlPatterns = {"/UserServlet"})
public class UserServlet extends HttpServlet {

                                                                                                                                                                  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    

    User user = new User(id, pass);
    UserLogic al = new UserLogic();
    boolean result = al.addUser(user);

    if (result) { 
      HttpSession session = request.getSession();
      session.setAttribute("id", id);

      RequestDispatcher dispatcher =
          request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
      dispatcher.forward(request, response);
      
    } else { 
        HttpSession session = request.getSession();
        session.setAttribute("id", null);
      response.sendRedirect("/ad1049/UserServlet");
    }
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

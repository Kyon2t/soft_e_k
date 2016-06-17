/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.api.server.spi.auth.common.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.google.apphosting.api.UserServicePb.UserService;

import model.Login;
import model.LoginLogic;

/**
 *
 * @author g14910he
 */
//web.xml(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //protected void processRequest(HttpServletRequest request, HttpServletResponse response)
     //       throws ServletException, IOException {
      //  response.setContentType("text/html;charset=UTF-8");
      //  PrintWriter out = response.getWriter();
      //  try {
      //      /* TODO output your page here. You may use following sample code. */
      //      out.println("<html>");
      //      out.println("<head>");
      //      out.println("<title>Servlet LoginServlet</title>");            
      //      out.println("</head>");
     //       out.println("<body>");
     //       out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
     //       out.println("</body>");
     //       out.println("</html>");
     //   } finally {            
     //       out.close();
     //   }
    //}
    

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
    	
    	com.google.appengine.api.users.UserService userService = UserServiceFactory.getUserService();
    	 
    	 // ページURLを取得
        String url      = req.getRequestURI();
 
        // 画面出力開始
        resp.setContentType("text/html");
        resp.getWriter().println( "<html>" );
        resp.getWriter().println( "<title>login / logout</title>");
        resp.getWriter().println( "<a href=\"./\">home</a><br/><br/>" );
        
        com.google.appengine.api.users.User user = userService.getCurrentUser();
 
        // ログイン状態か確認
        if( userService.isUserLoggedIn() )
        {
            // ユーザ情報とログアウト用リンクの取得
            String  name        = userService.getCurrentUser().getNickname();
            String  email       = userService.getCurrentUser().getEmail();
            String  userID      = userService.getCurrentUser().getUserId();
            String  logoutURL   = userService.createLogoutURL( url );
 
            // ユーザ情報を出力
            resp.getWriter().println( String.format( "user : %s - <a href=\"%s\">logout</a><br/>" , name , logoutURL ) );
            resp.getWriter().println( String.format( "userID   : %s<br/>" , userID ) );
            resp.getWriter().println( String.format( "email    : %s<br/>" , email ) );
 
            // 管理者の場合は更に出力
            if( userService.isUserAdmin() ){ resp.getWriter().println( "you are the administrator.<br/>" ); }
        }else{
            // ログインURLを作成
            String  loginURL    = userService.createLoginURL( url );
 
            // ログインリンクを表示
            resp.getWriter().println( String.format( "<a href='%s'>login</a>" , loginURL ) );
        }
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
        Login login = new Login(id,pass);
        LoginLogic lo = new LoginLogic();
        boolean result = lo.execute(login);
        
        if(result){
            HttpSession session = request.getSession();
            session.setAttribute("id", id);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/loginDone.jsp");
        dispatcher.forward(request, response);
        }else{
             RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        dispatcher.forward(request, response);
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

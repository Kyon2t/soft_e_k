/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package java.servlet;

import java.dao.DataDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.model.Data;
import java.model.Game;
import java.model.Quest;
import java.model.Result;

/**
 *
 * @author g14949tk
 */
//web.xml(name = "GameServlet", urlPatterns = {"/GameServlet"})
public class GameServlet extends HttpServlet {
    public String answer;
    public List<Data> presentGame;
    public int answerA;
    public int answerB;
    long start;

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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet GameServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GameServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

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
        String forwardPath = null;       
        String action = request.getParameter("action");
        DataDAO dada = new DataDAO();
        dada.findAll(); 
        boolean isRunning = true;
        Game g;
        Quest quest;
        Result r;
        long now = 0;
        int count = 0;
        while(isRunning){
            now = System.currentTimeMillis();
            if(now>20000+start){
                break;
            }
            if(action == null){
                forwardPath = "/WEB-INF/jsp/game.jsp";
            }else if(action.equals("a")){
                HttpSession session = request.getSession();
                Quest q = (Quest)session.getAttribute("quest");
                r = (Result)session.getAttribute("result");
                if(q.getAnswer()== 100){r.countUp();}
                session.setAttribute("result",r);
                session.removeAttribute("quest");
            }else if(action.equals("b")){
                HttpSession session = request.getSession();
                Quest q = (Quest)session.getAttribute("quest");
                r = (Result)session.getAttribute("result");
                if(q.getAnswer()== 200){r.countUp();}
                session.setAttribute("result",r);
                session.removeAttribute("quest");
            }
            presentGame = dada.getList();
            g = new Game(presentGame);
            String q1 = g.getQuest1();
            String q2 = g.getQuest2();
            int ans = g.getAnswer();
            quest = new Quest(q1, q2,ans);
            request.setCharacterEncoding("UTF-8");
            HttpSession session = request.getSession();
            session.setAttribute("quest",quest);
            forwardPath = "/WEB-INF/jsp/game.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
            dispatcher.forward(request, response);
        }
        forwardPath = "/WEB-INF/jsp/game.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
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
        start = System.currentTimeMillis();
        DataDAO dada = new DataDAO();
        dada.findAll();
        presentGame = dada.getList();
        Game g = new Game(presentGame);
        String q1 = g.getQuest1();
        String q2 = g.getQuest2();
        int ans = g.getAnswer();
        Quest quest = new Quest(q1, q2, ans);
        Result rs = new Result(0);
        HttpSession session = request.getSession();
        session.setAttribute("quest",quest);
        session.setAttribute("result",rs);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/game.jsp");
        dispatcher.forward(request, response);
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

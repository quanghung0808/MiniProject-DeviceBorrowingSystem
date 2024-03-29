/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duonght.LoginGoogle;

import duonght.dao.AccountDao;
import duonght.dto.Account;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Trung Duong
 */
public class LoginHandler extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        if (code == null || code.isEmpty()) {
            RequestDispatcher dis = request.getRequestDispatcher("Login.jsp");
            dis.forward(request, response);
        } else {
            String accessToken = GoogleUtils.getToken(code);
            GooglePojo googlePojo = GoogleUtils.getUserInfo(accessToken);
            String email = googlePojo.getEmail();
            Account acc = AccountDao.checkLogin(email);
            System.out.println("Image: " + googlePojo.getPicture());
            if (acc == null) {
                request.setAttribute("ERROR", "Your Email Not Allow!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            } else {
                if (acc.getRoleID().equals("AD")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("Admin", googlePojo);
                    session.setAttribute("AdminDB", acc);
                    request.getRequestDispatcher("getAllAccount").forward(request, response);
                }
                if (acc.getRoleID().equals("MD")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("ManagerDevice", googlePojo);
                    session.setAttribute("ManagerDeviceDB", acc);
                    request.getRequestDispatcher("MainController?search=&action=SearchDevice").forward(request, response);
                }
                if (acc.getRoleID().equals("MR")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("ManagerRequest", googlePojo);
                    session.setAttribute("ManagerRequestBD", acc);
                    request.getRequestDispatcher("MainController?action=LoadAllRequestManager").forward(request, response);
                }
                if (acc.getRoleID().equals("US")) {
                    HttpSession session = request.getSession();
                    session.setAttribute("HomepageUser", googlePojo);
                    session.setAttribute("HomepageUserBD", acc);
                    request.getRequestDispatcher("MainController?filter=&action=HomeSearchDevice").forward(request, response);
                }   
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Acer
 */
public class signup extends HttpServlet {
    //Connection con= MyDb.connectdb();
    PreparedStatement ps=null;
    ResultSet rs=null;
    
    public signup() {
    }
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
        String signin = "INSERT INTO BobloxInfo (username, email, password) VALUES (?, ?, ?)";
        //String checkuser = "SELECT * FROM BRICKPLAYERINFO WHERE USERNAME = ?";
        
        try (PrintWriter out = response.getWriter()) {
            String uname = request.getParameter("uname");
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            MyDb db = new MyDb();
            Connection con = db.connectdb();
            
            //Statement stmt = con.createStatement();
            //stmt.executeUpdate(email)
            System.out.println("inserted into the table");
            
            ps = con.prepareStatement(signin);
            ps.setString(1, uname);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.executeUpdate();
            
            response.sendRedirect("LogIn.html");
        } catch (SQLException ex) {
            System.out.println("nothing happened");
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

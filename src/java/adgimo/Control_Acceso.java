/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adgimo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adrián
 */
public class Control_Acceso extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String usuario = request.getParameter("usuario");
            String pass = request.getParameter("pass");
            boolean usuarioValido=false;
            
            if(usuario!="usuario" && pass!="usuario"){
                request.setAttribute("error","Usuario o Password incorrecto");
                
            
            //redireccionamos al jsp
                RequestDispatcher dispatcher=request.getRequestDispatcher("index.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (IOException ex) {
                    Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(usuario=="usuario" && pass=="usuario"){
                usuarioValido=true;
                request.setAttribute("usuarioValido", usuarioValido);
                
                 RequestDispatcher dispatcher=request.getRequestDispatcher("menu.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (IOException ex) {
                    Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
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
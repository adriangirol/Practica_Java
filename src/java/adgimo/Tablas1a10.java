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
 * @author 2DAW
 */
public class Tablas1a10 extends HttpServlet {

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
            String Resultado;
            Resultado=this.Todas_las_Tablas();
            request.setAttribute("Resultado",Resultado);
            
            RequestDispatcher dispatcher=request.getRequestDispatcher("Tablas.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (IOException ex) {
                    Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    protected String Todas_las_Tablas() {

        String html = "";

        html += "<table border='1'>";

        for (int i = 1; i <= 10; i++) {

            html += "<td>";
            for (int x = 1; x <= 10; x++) {
                if (x == 1) {
                    html += "<h3>Tabla del " + i + "</h3><br><hr>";
                }
                html += i + " x " + x + " = " + (i * x) + "<br>";
            }
            //Para insertar una nueva fila.
            html += "</td>";
            if (i % 3 ==0) {
                            html += "</tr><tr>";
            }
        }
        html += "</table>";
        return html;
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

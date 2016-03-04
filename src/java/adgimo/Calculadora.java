/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adgimo;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 2DAW
 */
public class Calculadora extends HttpServlet {

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
            boolean Acti_resultado=false;
            float resultado;
            
            //variables de recogida del formulario
             String op1;
             String op2;
             String operacion;
             //recogida del formulario
             op1 = request.getParameter("oper1");
             op2 = request.getParameter("oper2");
             operacion = request.getParameter("operacion");
             request.setAttribute("operacion",operacion);
             //transformacion a float de los operandos
             float operando1=Float.parseFloat(op1);
             request.setAttribute("operando1",operando1);
             float operando2=Float.parseFloat(op2);
             request.setAttribute("operando2",operando2);
             switch(operacion){
                 case "+":
                     //calculamos el resultado
                    resultado= Suma(operando1,operando2);
                        //Enviamos el resultado al jsp
                        request.setAttribute("resultado",resultado);
                        request.setAttribute("Activo",Acti_resultado=true);
                        //redireccionamos al jsp
                        response.sendRedirect("/Calculadora.jsp"); 
                    break;
                 case "-": 
                    resultado= Resta(operando1,operando2);
                        request.setAttribute("resultado",resultado);
                        request.setAttribute("Activo",Acti_resultado=true);
                        response.sendRedirect("/Calculadora.jsp"); 
                    break;
                 case "*": 
                    resultado= Multiplicar(operando1,operando2);
                        request.setAttribute("resultado",resultado);
                        request.setAttribute("Activo",Acti_resultado=true);
                        response.sendRedirect("/Calculadora.jsp"); 
                    break;
                 case "/":
                     resultado= Dividir(operando1,operando2);
                        request.setAttribute("resultado",resultado);
                        request.setAttribute("Activo",Acti_resultado=true);
                        response.sendRedirect("/Calculadora.jsp"); 
                    break;
                 default:
                     out.println("El operando no es correcto");
                     break;
             }

        }
    }
     static float Suma(float n1,float n2){
        float resultado= n1+n2;
        return resultado;
    }
    static float Resta(float n1,float n2){
        float resultado= n1-n2;
        return resultado;
    }
    static float Multiplicar(float n1,float n2){
        float resultado= n1*n2;
        return resultado;
    }
    static float Dividir(float n1,float n2){
        float resultado= n1/n2;
        return resultado;
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

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
            
            float resultado=0;
            
            //variables de recogida del formulario
             String op1;
             String op2;
             String operacion;
             //recogida del formulario
             op1 = request.getParameter("oper1");
             op2 = request.getParameter("oper2");
             operacion = request.getParameter("Operacion");
             request.setAttribute("operacion",operacion);
             
             if(Comun.isNumeric(op1)&& Comun.isNumeric(op2)){
             //transformacion a float de los operandos
             float operando1=Float.parseFloat(op1);
             float operando2=Float.parseFloat(op2);
             
            
             //envio de valores para jsp
             request.setAttribute("operando1",Float.toString(operando1));
             request.setAttribute("operando2",Float.toString(operando2));
             switch(operacion){
                 case "+":
                     //calculamos el resultado
                    resultado= Suma(operando1,operando2);
                        
                        
                    break;
                 case "-": 
                    resultado= Resta(operando1,operando2);

                    break;
                 case "*": 
                    resultado= Comun.Multiplicar(operando1,operando2);

                    break;
                 case "/":
                     resultado= Dividir(operando1,operando2);

                    break;
                 default:
                     
                     request.setAttribute("resultado","El operando no es correcto");
                     Redireccion(request,response,"Calculadora.jsp"); 
                     break;
             }
             //Enviamos el resultado al jsp
                request.setAttribute("resultado",Float.toString(resultado));
            }else
             {
                 request.setAttribute("error","Los valores deben ser numericos.");
             }    //redireccionamos al jsp
                 RequestDispatcher dispatcher=request.getRequestDispatcher("Calculadora.jsp");
                try {
                    dispatcher.forward(request,response);
                } catch (IOException ex) {
                    Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
                }

        
        }
    }
    
    /**
     * 
     * @param n1
     * @param n2
     * @return Suma de los parametros
     */
     static float Suma(float n1,float n2){
        float resultado= n1+n2;
        return resultado;
    }
     /**
      * 
      * @param n1
      * @param n2
      * @return Resta de los parametros
      */
    static float Resta(float n1,float n2){
        float resultado= n1-n2;
        return resultado;
    }
    
    /**
     * 
     * @param n1
     * @param n2
     * @return la division de los parametros
     */
    static float Dividir(float n1,float n2){
        float resultado= n1/n2;
        return resultado;
    }
    /**
     * 
     * @param request
     * @param response
     * @param redireccion donde enviamos el renvio
     * @throws ServletException 
     */
    static void Redireccion( HttpServletRequest request, HttpServletResponse response,String redireccion) throws ServletException{
   
    RequestDispatcher dispatcher=request.getRequestDispatcher(redireccion);
        try {
            dispatcher.forward(request,response);
        } catch (IOException ex) {
            Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
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

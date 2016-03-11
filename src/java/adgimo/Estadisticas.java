/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adgimo;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletConfig;

/**
 *
 * @author 2DAW
 */
public class Estadisticas extends HttpServlet {

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
            if (request == null) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("Estadisticas_user.jsp");
                try {
                    dispatcher.forward(request, response);
                } catch (IOException ex) {
                    Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //Recoger paginador (20);
                
                String pro = CreaSelect();
                String total = totalUser();
                request.setAttribute("provincias", pro);
                request.setAttribute("total", total);
                int totaluser = Integer.parseInt(total);
                //recogida
                if (request.getParameter("provincia") != null ||request.getParameter("provincia")=="todas") {
                    String provincia = (String) request.getParameter("provincia");
                    request.setAttribute("provincia", provincia);
                    String tabla = Usuarios_Por_Provincia(provincia);
                    //Envio
                    request.setAttribute("tabla", tabla);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Estadisticas_user.jsp");

                    try {
                        dispatcher.forward(request, response);
                    } catch (IOException ex) {
                        Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    String tabla = TodasProvincias();
                    request.setAttribute("tabla", tabla);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("Estadisticas_user.jsp");

                    try {
                        dispatcher.forward(request, response);
                    } catch (IOException ex) {
                        Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }

    protected String Usuarios_Por_Provincia(String provincia) {
        String tabla_user = "<td> <h3>apellido1</h3> </td><td> <h3>Total</h3> </td><td><h3>Porcentaje</h3></td><tr>";
        String query = null;
        query = "SELECT distinct apellido1, count(apellido1) as total, (count(apellido1)*100)/(SELECT count(*) FROM t_usuarios) as porcentaje FROM t_usuarios u INNER JOIN t_provincias p on u.prov_cod = p.cod WHERE p.nombre='"+provincia+"' GROUP BY apellido1 ORDER BY total LIMIT 0,21";
        ResultSet resultSet = null;
        try {
            synchronized (statment) {
                resultSet = statment.executeQuery(query);
            }
            while (resultSet.next()) {
                tabla_user += "<td>" + resultSet.getString("apellido1") + "<td>" + resultSet.getString("total") + "<td>" + resultSet.getString("porcentaje") + "<tr>";
            }
        } catch (SQLException ex) {
            out.println("Error");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                            "No se pudo cerrar el Resulset", ex);
                }
            }
        }
        return tabla_user;
    }

    protected String TodasProvincias() {
        String tabla_user = "<td> <h3>apellido1</h3> </td><td> <h3>Total</h3> </td><td><h3>Porcentaje</h3></td><tr>";
        String query = null;
        query = "SELECT distinct apellido1, count(apellido1) as total, (count(apellido1)*100)/(SELECT count(*) from t_usuarios) as porcentaje FROM t_usuarios GROUP BY apellido1 ORDER BY apellido1 LIMIT 0, 21;";
        ResultSet resultSet = null;
        try {
            synchronized (statment) {
                resultSet = statment.executeQuery(query);
            }
            while (resultSet.next()) {
                tabla_user += "<td>" + resultSet.getString("apellido1") + "<td>" + resultSet.getString("total") + "<td>" + resultSet.getString("porcentaje") + "<tr>";
            }
        } catch (SQLException ex) {
            out.println("Error");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                            "No se pudo cerrar el Resulset", ex);
                }
            }
        }
        return tabla_user;
    }

    protected String totalUser() {
        String total = "";
        String query = null;
        query = "SELECT count(*) as total FROM t_usuarios";
        ResultSet resultSet = null;
        try {
            synchronized (statment) {
                resultSet = statment.executeQuery(query);
            }
            while (resultSet.next()) {
                total = resultSet.getString("total");
            }
        } catch (SQLException ex) {
            out.println("Error");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                            "No se pudo cerrar el Resulset", ex);
                }
            }
        }
        return total;
    }

    protected String CreaSelect() {

        String SelectCompleto = "";
        String query = null;
        query = "SELECT nombre FROM t_provincias";
        ResultSet resultSet = null;
        try {
            synchronized (statment) {
                resultSet = statment.executeQuery(query);
            }
            SelectCompleto = "<select name='provincia'><option value='todas'>- Todas -</options><br>";
            while (resultSet.next()) {

                String Nombre = resultSet.getString("nombre");
                SelectCompleto += "<option value='" + Nombre + "'>" + Nombre + "</options><br>";
            }
            SelectCompleto += "</select>";
        } catch (SQLException ex) {
            out.println("Error");
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                            "No se pudo cerrar el Resulset", ex);
                }
            }
        }
        return SelectCompleto;
    }

    private Statement statment = null;
    private Connection conexion = null;

    @Override
    public void init(ServletConfig config) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/usuarios", "root", "");
            statment = conexion.createStatement();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                    "No se pudo cargar el driver de la base de datos", ex);
        } catch (SQLException ex) {
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                    "No se pudo obtener la conexión a la base de datos", ex);
        }
    }

    @Override
    public void destroy() {
        try {
            statment.close();
        } catch (SQLException ex) {
            Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                    "No se pudo cerrar el objeto Statement", ex);
        } finally {
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(Estadisticas.class.getName()).log(Level.SEVERE,
                        "No se pudo cerrar el objeto Conexion", ex);
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

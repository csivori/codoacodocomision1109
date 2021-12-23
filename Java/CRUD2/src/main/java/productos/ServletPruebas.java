package productos;

import config.BaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServletPruebas", urlPatterns = {"/ServletPruebas"})
public class ServletPruebas extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Resource(name="jdbc/Productos")
    private DataSource miPool;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (
            PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletPruebas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletPruebas at " + request.getContextPath() + "</h1>");
            out.println("<h2>Variables: miConexion, stmt, y rs DECLARADAS!!</h2>");
            BaseDeDatos bd = new BaseDeDatos();
            Connection miConexion = null;
            Statement stmt = null;
            ResultSet rs = null;        
            try{
                out.println("<h2>Entro al 'try' voy a INSTANCIAR la variable: miConexion!!</h2>");
//                miConexion = miPool.getConnection();
                miConexion = bd.getConection();
                out.println("<h2>Variable: miConexion INSTANCIADA desde bd " + bd.toString() + " / miPool " + miPool.toString() + "</h2>");
                stmt = miConexion.createStatement();
                out.println("<h2>Statement Creado desde miConexion " + miConexion.toString() + "</h2>");
                rs = stmt.executeQuery("SELECT * FROM PRODUCTOS");
                out.println("<h2>Query Ejecutado desde stmt " + stmt.toString() + "</h2>");
                while (rs.next()){
                    String nombre = rs.getString("Nombre");
                    out.println("<h2>" + nombre + "</h2>");
                }
            } catch (SQLException e) {
                out.println("<h2>ERROR.toString(): " + e.toString() + "</h2>");
                out.println("<h2>ERROR.getMessage(): " + e.getMessage() + "</h2>");
                e.printStackTrace();
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

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

package productos;

import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet(name = "ServletPruebas", urlPatterns = {"/ServletPruebas"})
public class ServletPruebas extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    @Resource(name="jdbc/Productos")
    private DataSource miPool;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            Connection miConexion = null;
            Statement stmt = null;
            ResultSet rs = null;
            try{
                miConexion = miPool.getConection();
                stmt = miConexion.createStatement();
                rs = stmt.executeQuery("SELECT * FROM PRODUCTOS");
            } catch (Exception e) {e.printStackTrace();}


            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletPruebas</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ServletPruebas at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
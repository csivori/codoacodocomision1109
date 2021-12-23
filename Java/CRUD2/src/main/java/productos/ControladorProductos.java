package productos;

import config.BaseDeDatos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "ControladorProductos", urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ModeloProducto modeloProducto;
    
    @Resource(name="jdbc/Productos")
    private DataSource miPool;

    @Override
    public void init() throws ServletException {
        super.init(); 
        try{
            this.modeloProducto = new ModeloProducto(new BaseDeDatos());
        } catch (Exception e) {throw new ServletException(e);}
    }
        
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Producto> productos;
        try{
            productos = modeloProducto.getProductos();
            request.setAttribute("LISTAPRODUCTOS", productos);
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
            miDispatcher.forward(request, response);
        } catch (Exception e) {e.printStackTrace();}    
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

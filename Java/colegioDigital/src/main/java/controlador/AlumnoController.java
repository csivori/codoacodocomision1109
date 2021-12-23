package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.AlumnoDAO;
import base.UtilidadesParaServlet;

@WebServlet(name = "AlumnoController", urlPatterns = {"/AlumnoController"})
public class AlumnoController extends HttpServlet {

    private AlumnoDAO alumnoDAO;
    private UtilidadesParaServlet utils;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            this.alumnoDAO = new AlumnoDAO();
            this.utils = new UtilidadesParaServlet("msgError.jsp", "", "/colegioDigital");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        AlumnoDAO alumnoDAO = new AlumnoDAO();
        String accion = null;
        try {
            RequestDispatcher dispatcher = null;
            Exception e = this.alumnoDAO.getUltimaExcepcion();
            if (e == null) {
                accion = request.getParameter("accion");
                if (utils.estaLogeado()) {
                    utils.setAttributeUsuarioActual(request);
                    if (accion == null || accion.isEmpty()) {
                        dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
//                        dispatcher = utils.getRequestDispatcher(request, "Vistas/alumnos.jsp");
                        dispatcher.forward(request, response);

                    } else if (accion.equals("ingresar")) {
                        utils.setUsuarioActual(request.getParameter("usuario"), request);
                        dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
//                        dispatcher = utils.getRequestDispatcher(request, "Vistas/alumnos.jsp");
                        dispatcher.forward(request, response);

                    } else if (accion.equals("reingresar")) {
                        dispatcher = request.getRequestDispatcher("Vistas/Login.jsp");
//                        dispatcher = utils.getRequestDispatcher(request, "Vistas/alumnos.jsp");
                        dispatcher.forward(request, response);

                    } else if (accion.equals("nuevo")) {
                        dispatcher = request.getRequestDispatcher("Vistas/nuevo.jsp");
//                        dispatcher = utils.getRequestDispatcher(request, "Vistas/nuevo.jsp");
                        dispatcher.forward(request, response);

                    } else if (accion.equals("modificar") || accion.equals("eliminar")) {
                        String id = request.getParameter("id");
                        Alumno alumno = alumnoDAO.mostrarAlumno(Integer.parseInt(id));
                        request.setAttribute("ALUMNO", alumno);
                        request.setAttribute("TITULO", utils.capitalize(accion));
                        dispatcher = request.getRequestDispatcher("Vistas/modificar.jsp");
                        dispatcher.forward(request, response);

                    } else if (accion.equals("insertar")) {
                        if (validarAlumno("0", request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("email"), request.getParameter("telefono"))) {
                            if (alumnoDAO.insertarAlumno(request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("email"), request.getParameter("telefono"))) {
                                utils.msgSuccess("Alumno ingresado con Exito!", request, response, "AlumnoController");
                                return;
                            } else {
                                utils.msgError("El Alumno " + request.getParameter("nombre") + " no se pudo Grabar!", request, response, "AlumnoController?accion=nuevo");
                                return;
                            }
                        } else {
                            String errMsg = validarAlumnoErrorMsg("0", request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("email"), request.getParameter("telefono"));
                            utils.msgError("El Alumno " + request.getParameter("nombre") + " no se pudo Grabar!<BR>"
                                    + errMsg, request, response, "Vistas/nuevo.jsp");
//                            utils.msgError("El Alumno " + request.getParameter("nombre") + " no se pudo Grabar!<BR>"
//                                    + errMsg, request, response, "AlumnoController?accion=insertar");
                            return;
                        }
                    } else if (accion.equals("Modificar") || accion.equals("Eliminar")) {
                        if (utils.validarCampoInteger(request.getParameter("id"))) {
                            int idAlumno = Integer.parseInt(request.getParameter("id"));
                            if (accion.equals("Modificar")) {
                                if (validarAlumno(request.getParameter("iden"), request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("email"), request.getParameter("telefono"))) {
                                    Alumno alumno = new Alumno(Integer.parseInt(request.getParameter("iden")), request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("email"), request.getParameter("telefono"));
                                    if (alumnoDAO.modificarAlumno(idAlumno, alumno)) {
                                        utils.msgSuccess("Alumno actualizado con Exito!", request, response, "AlumnoController");
                                        return;
                                    } else {
                                        utils.msgError("La actualización del Alumno: " + alumno.toString() + " no se pudo Grabar!", request, response, "AlumnoController?accion=modificar&id=" + idAlumno);
                                        return;
                                    }
                                } else {
                                    String errMsg = validarAlumnoErrorMsg(request.getParameter("iden"), request.getParameter("nombre"), request.getParameter("apellido"), request.getParameter("email"), request.getParameter("telefono"));
                                    utils.msgError("La actualización del Alumno: " + request.getParameter("id") + " no se pudo Grabar!<BR>"
                                            + errMsg, request, response, "AlumnoController?accion=modificar&id=" + idAlumno);
                                    return;
                                }
                            } else {
                                if (alumnoDAO.eliminarAlumno(idAlumno)) {
                                    utils.msgSuccess("Alumno eliminado con Exito!", request, response, "AlumnoController");
                                    return;
                                } else {
                                    utils.msgError("La eliminación del Alumno: " + idAlumno + " no se pudo Ejecutar!", request, response, "AlumnoController?accion=eliminar&id=" + idAlumno);
                                    return;
                                }
                            }
                        } else {
                            utils.msgError("La " + ((accion.equals("Modificar")) ? "modificación" : "eliminación") + " del Alumno: " + request.getParameter("id") + " no se pudo Ejecutar!<BR>"
                                    + utils.validarCampoIntegerErrorMsg("El ID", "del Alumno", request.getParameter("id")), request, response, "AlumnoController");
                            return;
                        }
                    } else {
                        PrintWriter out = response.getWriter();
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head><title>ERROR</title></head>");
                        out.println("<body>");
                        out.println("<h2>Error accion inválida: " + accion + "...</h2>");
                        out.println("<a class=\"btn btn-warning\" href=\"AlumnoController\">Continuar</a>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                } else {     
                    if (accion == null || accion.isEmpty()) {
//                        dispatcher = request.getRequestDispatcher("Vistas/Login.jsp");
                        dispatcher = utils.getRequestDispatcher(request, "./Vistas/Login.jsp");
                        dispatcher.forward(request, response);

                    } else if (accion.equals("ingresar")) {
                        if (this.alumnoDAO.validarLogin(request.getParameter("usuario"), request.getParameter("password"))) {
                            utils.setUsuarioActual(request.getParameter("usuario"), request);
//                            dispatcher = request.getRequestDispatcher("AlumnoController");
                            dispatcher = request.getRequestDispatcher("Vistas/alumnos.jsp");
                            dispatcher.forward(request, response);
                        } else {
                            utils.msgError("Usuario o Password Inválidos! (" + request.getParameter("usuario") + " / " + request.getParameter("password") + ")", request, response, "Vistas/Login.jsp");
                            return;
                        }

                    }
                }
            } else {
                utils.msgError(e.toString(), request, response, "AlumnoController");
                return;
            }
        } catch (Exception e) {
//            e.printStackTrace();
            utils.msgError(e, request, response, "AlumnoController?accion=" + accion);
            return;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

// METODOS PRIVADOS
    private boolean validarAlumno(String id, String nombre, String apellido, String email, String telefono) {
        String errMsg = validarAlumnoErrorMsg(id, nombre, apellido, email, telefono);
        return errMsg.equals("");
    }

    private String validarAlumnoErrorMsg(String id, String nombre, String apellido, String email, String telefono) {
        String msgError = "";
// Valido el id
        msgError += utils.validarCampoIntegerErrorMsg("El ID", "del Alumno", id);

// Valido el nombre 
        msgError += utils.validarLargoCampoErrorMsg("El Nombre", "del Alumno", nombre, 100);

// Valido el apellido 
        msgError += utils.validarLargoCampoErrorMsg("El Apellido", "del Alumno", apellido, 100);

// Valido el email
        msgError += utils.validarEmailErrorMsg("El Correo", "del Alumno", email);

// Valido el telefono        
        msgError += utils.validarTelefonoErrorMsg("El Teléfono", "del Alumno", telefono);

        return msgError;
    }    
}

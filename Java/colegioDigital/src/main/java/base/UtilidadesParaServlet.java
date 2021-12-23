package base;


import java.io.IOException;
import static java.time.LocalDate.now;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UtilidadesParaServlet {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    
    private String webPageJSPMsgError = ""; // Nombre Pag.Web a utilizar para Error
    private String webPageJSPNextStep = "";
    private String webPageTagErrorMsg = ""; // Teg (default: "<BR>-") para mostrar cada error
    private String pathApp = ""; // Path App
    private ManejadorDeSesion s = null;
    
// CONSTRUCTORES
    
    public UtilidadesParaServlet(String usuarioActual, String pathApp){this("msgError.jsp", usuarioActual, pathApp);}
    public UtilidadesParaServlet(String webPageJSPMsgError, String usuarioActual, String pathControlador){this(webPageJSPMsgError, "", "<BR>-", usuarioActual, pathControlador);}
    public UtilidadesParaServlet(String webPageJSPMsgError, String webPageJSPNextStep, String webPageTagErrorMsg, String usuarioActual, String pathApp){
        this.webPageJSPMsgError = webPageJSPMsgError;
        this.webPageJSPNextStep = webPageJSPNextStep;
        this.webPageTagErrorMsg = webPageTagErrorMsg;
        this.s = new ManejadorDeSesion(usuarioActual);
        this.pathApp = pathApp;
    }

// GETTERs & SETTERs
// OVERRIDES
    @Override
    public String toString() {return "UtilidadesParaServlet(webPageJSPMsgError: " + webPageJSPMsgError +
            " / webPageJSPNextStep:" + webPageJSPNextStep + " / webPageTagErrorMsg:" + webPageTagErrorMsg +
            " / pathApp:" + pathApp + " / " + s.toString() + ")";}
    public boolean equals(UtilidadesParaServlet objeto){return this == objeto;}

// METODOS PUBLICOS

    public boolean estaLogeado() {
        return this.s.estaLogeado();
    }

    public void setAttributeUsuarioActual(HttpServletRequest request){ 
        this.s.setAttributeUsuarioActual(request);
    }    

    public void setUsuarioActual(String usuarioActual, HttpServletRequest request) {
        this.s.setUsuarioActual(usuarioActual, request);
    }

// METODOS VARIOS UTILES

    public String capitalize(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

// METODOS para MENSAJES al USUARIO de ERROR o INFORMACION para SERVLETS
    
    public void msgSuccess(String msg, HttpServletRequest request, HttpServletResponse response) {msgSuccess(msg, "BRAVO!", request, response, this.webPageJSPNextStep);}
    public void msgSuccess(String msg, String titulo, HttpServletRequest request, HttpServletResponse response) {msgSuccess(msg, titulo, request, response, this.webPageJSPNextStep);}
    public void msgSuccess(String msg, HttpServletRequest request, HttpServletResponse response, String nextStep) {msgSuccess(msg, "BRAVO!", request, response, nextStep);}
    public void msgSuccess(String msg, String titulo, HttpServletRequest request, HttpServletResponse response, String nextStep) {msgBase("success", msg, titulo, request, response, nextStep);}
    public void msgError(String msg, HttpServletRequest request, HttpServletResponse response) {msgError(msg, "ERROR!", request, response, this.webPageJSPNextStep);}
    public void msgError(Exception ex, HttpServletRequest request, HttpServletResponse response) {msgError(ex, request, response, this.webPageJSPNextStep);}
    public void msgError(Exception ex, HttpServletRequest request, HttpServletResponse response, String nextStep) {
        String msg = ex.getLocalizedMessage();
        msg = ex.getMessage();
        msg = ex.toString();
        msgError(msg, "ERROR!", request, response, nextStep);
    }
    public void msgError(String msg, String titulo, HttpServletRequest request, HttpServletResponse response) {msgError(msg, titulo, request, response, this.webPageJSPNextStep);}
    public void msgError(String msg, HttpServletRequest request, HttpServletResponse response, String nextStep) {msgError(msg, "ERROR!", request, response, nextStep);}
    public void msgError(String msg, String titulo, HttpServletRequest request, HttpServletResponse response, String nextStep) {msgBase("danger", msg, titulo, request, response, nextStep, true);}
    public void msgError(String msg, String titulo, HttpServletRequest request, HttpServletResponse response, String nextStep, boolean bReintentar) {msgBase("danger", msg, titulo, request, response, nextStep, bReintentar);}
    public void msgBase(String tipo, String msg, String titulo, HttpServletRequest request, HttpServletResponse response, String nextStep) {msgBase(tipo, msg, titulo, request, response, nextStep, false);}
    public void msgBase(String tipo, String msg, String titulo, HttpServletRequest request, HttpServletResponse response, String nextStep, boolean bReintentar) {
        try{
            request.setAttribute("TITULO", capitalize(titulo));
            request.setAttribute("MENSAJE", (msg + ((bReintentar)?"<br><br>Por favor, inténtelo nuevamente":"")));
            request.setAttribute("PROX_PASO", nextStep);
            request.setAttribute("TIPO", tipo);
            RequestDispatcher dispatcher = request.getRequestDispatcher(webPageJSPMsgError);
            dispatcher.forward(request, response);
        } catch (IOException e) {e.printStackTrace();
        } catch (ServletException ex) {Logger.getLogger(UtilidadesParaServlet.class.getName()).log(Level.SEVERE, null, ex);}
    }

// METODOS de VALIDACION de CAMPOS de INGRESO
    
    public boolean validarCampoInteger(String campoValor) {return (validarCampoIntegerErrorMsg("", "", campoValor).equals(""));}
    public String validarCampoIntegerErrorMsg(String campoNombre, String entidadNombre, String campoValor) {
        try {
            int i = Integer.parseInt(campoValor);
        } catch (NumberFormatException e) {
            return this.webPageTagErrorMsg + campoNombre + getMuestraCampoParaErrorMsg(campoValor, 10) + entidadNombre + " NO es un Número Válido!";
        }
        return "";
    }

    public String validarLargoCampoErrorMsg(String campoNombre, String entidadNombre, String campoValor, int maxLargo) {        
        if (campoValor.length() > maxLargo) {
            return this.webPageTagErrorMsg + campoNombre + getMuestraCampoParaErrorMsg(campoValor, ((maxLargo > 25) ? 25 : maxLargo)) + entidadNombre + " supera los " + maxLargo + " caracteres de largo (" + campoValor.length() + ")!";
        } else {
            return "";
        }
    }
    
    public String validarTelefonoErrorMsg(String campoNombre, String entidadNombre, String campoValor) {
// PATRON:
//        Inicia si o si con "+", 
//        luego entre 7 y 14 dígitos entre "0" y "9" o " ", "(", ")",
//        luego un solo " " o "-"
//        luego entre 4 dígitos entre "0" y "9"
//
        Pattern p = Pattern.compile("\\+[0-9 )(]{7,14}([ -])?[0-9]{4}$"); 
        Matcher m = p.matcher(campoValor);
        if (m.matches()) {
            return "";
        } else {
            return this.webPageTagErrorMsg + campoNombre + getMuestraCampoParaErrorMsg(campoValor, 20) + entidadNombre + " NO es un Número Telefónico Válido! (+### ### ####-####)";
        }
    }
    
    public String validarEmailErrorMsg(String campoNombre, String entidadNombre, String campoValor) {
// PATRON:
//        Inicia si o si con [\w-]+, donde \w = [a-zA-Z0-9_] y adicionalmente también permite "-" y "+" significa {1,} o sea 1 o mas de esos caracteres 
//        luego \@
//        luego ([\w-]{1,63}) para el dominio permite una palabra de entre 1 y 63 digitos con caracteres a-z, A-Z, 0-9, "_", ó "-"
//        luego espero 1 o 2 extensiones de dominio (XEj: ".com" o ".com.ar")
//              (\.[a-zA-Z]{2,6}) para la extensión del dominio donde permite una palabra de 2 a 6 digitos con caracteres a-z, ó A-Z
//        luego "$" ya que así debe terminar el email.
//
//        Pattern p = Pattern.compile("^[\\w-+]+(\\.[\\w-]{1,62}){0,126}@[\\w-]{1,63}(\\.[\\w-]{1,62})+/[\\w-]+$");
        Pattern p = Pattern.compile("^([\\w-.]+)\\@([\\w-]{1,63})(\\.[a-zA-Z]{2,6}){1,2}$");
        Matcher m = p.matcher(campoValor);
        if (m.matches()) {
            return "";
        } else {
            return this.webPageTagErrorMsg + campoNombre + getMuestraCampoParaErrorMsg(campoValor, 20) + entidadNombre + " NO es una Dirección de Correo Electrónico Válida! (xx@xx.xx)";
        }
    }
    
    public String getMuestraCampoParaErrorMsg(String campoValor, int maxLargo) {
        if (campoValor == null) {
            return " (null) ";
        } else if (campoValor.isEmpty()) {
            return " (vacio) ";
        } else if (campoValor.length() > maxLargo) {
            return " (" + campoValor.substring(0, maxLargo) + "...) ";
        } else {
            return " (" + campoValor + ") ";
        }
    }

// METODOS de MANEJO de REFERENCIAS a PAGINAS de la APP

    public String getPathApp() {
        return this.pathApp;
    }
    
    public RequestDispatcher getRequestDispatcher(HttpServletRequest request, String webPage){
        String pathWebPage = this.getPathApp();
        if ((pathWebPage.length() > 0) && ((webPage.charAt(0) != '/') && (webPage.charAt(0) != '\\') && (webPage.charAt(0) != '.'))) {
            pathWebPage += "/" + webPage;
        } else {
            pathWebPage = webPage;
        }
       return request.getRequestDispatcher(pathWebPage);
    }
    
// METODOS PRIVADOS

}

class ManejadorDeSesion{
    private String usuarioActual = null; // Mantiene el Usuario Logeado
    private LocalDate fechaYHoraLogin = null; // Mantiene la Fecha y Hora en que el Usuario se Logueó
    
    public ManejadorDeSesion(String usuarioActual){
        this.usuarioActual = usuarioActual;
        this.fechaYHoraLogin = now();
    }
    
// METODOS de MANEJO de USUARIO LOGEADO

    public boolean estaLogeado() {
        return !((this.usuarioActual == null) || (this.usuarioActual.isEmpty()));
    }

    public void setUsuarioActual(String usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public void setUsuarioActual(String usuarioActual, HttpServletRequest request) {
        this.setUsuarioActual(usuarioActual);
        this.setAttributeUsuarioActual(request);
    }

    public String getUsuarioActual() {
        return this.usuarioActual;
    }

    public void setAttributeUsuarioActual(HttpServletRequest request){ 
        request.setAttribute("LOGGED_USR", this.getUsuarioActual() + " [ingreso:" + this.fechaYHoraLogin.toString() + "]");
    }    

// OVERRIDES
    @Override
    public String toString() {return "ManejadorDeSesion(usuarioActual: " + usuarioActual +
                                     " / fechaYHoraLogin:" + fechaYHoraLogin + ")";
    }
}
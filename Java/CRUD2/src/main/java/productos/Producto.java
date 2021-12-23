package productos;

import java.util.Date;
import java.util.Objects;
import java.sql.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Producto {
// ATRIBUTOS PUBLICOS
private String cArt;
private String seccion;
private String nArt;
private float precio;
private Date fecha;
private String importado;
private String origen;
private Blob foto;
private Date ts;
// ATRIBUTOS PRIVADOS

// CONSTRUCTORES
public Producto(String cArt, String seccion, String nArt, float precio, Date fecha, String importado, String origen, Blob foto, Date ts){
        this.cArt = cArt;
        this.seccion = seccion;
        this.nArt = nArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.origen = origen;
        this.foto = foto;
        this.ts = ts;
}

    public Producto(String seccion, String nArt, float precio, Date fecha, String importado, String origen, Blob foto, Date ts) {
        this.seccion = seccion;
        this.nArt = nArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.origen = origen;
        this.foto = foto;
        this.ts = ts;
    }

// GETTERs & SETTERs

    public String getcArt() {
        return cArt;
    }

    public void setcArt(String cArt) {
        this.cArt = cArt;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getnArt() {
        return nArt;
    }

    public void setnArt(String nArt) {
        this.nArt = nArt;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public Blob getFoto() {
        return foto;
    }

    public void setFoto(Blob foto) {
        this.foto = foto;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }    
    
// OVERRIDES
    @Override
    public String toString() {
        return "Productos [cArt]:" + cArt + " [seccion]:" + seccion + " [nArt]:" + nArt + " [precio]:" + precio + " [fecha]:" + fecha + " [importado]:" + importado + " [origen]:" + origen + " [TS]:" + ts;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.cArt, other.cArt)) {
            return false;
        }
        if (!Objects.equals(this.seccion, other.seccion)) {
            return false;
        }
        if (!Objects.equals(this.nArt, other.nArt)) {
            return false;
        }
        if (!Objects.equals(this.importado, other.importado)) {
            return false;
        }
        if (!Objects.equals(this.origen, other.origen)) {
            return false;
        }
        if (!Objects.equals(this.precio, other.precio)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }

// METODOS PUBLICOS

// METODOS PRIVADOS

}

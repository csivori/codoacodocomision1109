package modelo;

public class Alumno {
// ATRIBUTOS PUBLICOS

// ATRIBUTOS PRIVADOS
    private int id;
    private String nombre, apellido, email, telefono;
// CONSTRUCTORES

    public Alumno(int id, String nombre, String apellido, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
    }
// GETTERs & SETTERs

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

// OVERRIDES
    @Override
    public String toString() {
        return "Alumno(id:" + id + ", Nombre:" + nombre + ", Apellido:" + apellido + ", Email:" + email + ", Teléfono:" + telefono + ")";
    }

    public boolean equals(Alumno objeto) {
        return ((this.id == objeto.id) && (this.nombre == objeto.nombre) && (this.apellido == objeto.apellido) && (this.email == objeto.email) && (this.telefono == objeto.telefono));
    }

// METODOS PUBLICOS
// METODOS PRIVADOS
}
package proyectoFinal.clases;

public class Usuarios {
    private String nombre;
    private long identificacion;
    private int edad;
    private long telefono;
    private String membresia;

    public Usuarios() {
    }

    public Usuarios(String nombre, long identificacion, int edad, long telefono, String membresia) {this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.telefono = telefono;
        this.membresia = membresia;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public long getIdentificacion() {return identificacion;}
    public void setIdentificacion(long identificacion) {this.identificacion = identificacion;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public long getTelefono() {return telefono;}
    public void setTelefono(long telefono) {this.telefono = telefono;}
    public String getMembresias() {return membresia;}
    public void setMembresias(String membresia) {this.membresia = membresia;}

    }




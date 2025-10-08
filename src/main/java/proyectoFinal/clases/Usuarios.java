package proyectoFinal.clases;

public class Usuarios {
    private String nombre;
    private int identificacion;
    private int edad;
    private int telefono;
    private String membresia;

    public Usuarios() {
    }

    public Usuarios(String nombre, int identificacion, int edad, int telefono, String membresia) {this.nombre = nombre;
        this.identificacion = identificacion;
        this.edad = edad;
        this.telefono = telefono;
        this.membresia = membresia;}

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public int getIdentificacion() {return identificacion;}
    public void setIdentificacion(int identificacion) {this.identificacion = identificacion;}
    public int getEdad() {return edad;}
    public void setEdad(int edad) {this.edad = edad;}
    public int getTelefono() {return telefono;}
    public void setTelefono(int telefono) {this.telefono = telefono;}
    public String getMembresias() {return membresia;}
    public void setMembresias(String membresia) {this.membresia = membresia;}

    }




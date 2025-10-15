package proyectoFinal.clases;

public class Clases {
    private String nombre;
    private String tipo;
    private String horario;
    private int cupo_Maximo;
    private Entrenador entrenador;

    public Clases(String nombre, String tipo, String horario, int cupo_Maximo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.horario = horario;
        this.cupo_Maximo = cupo_Maximo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public int getCupo_Maximo() {
        return cupo_Maximo;
    }

    public void setCupo_Maximo(int cupo_Maximo) {
        this.cupo_Maximo = cupo_Maximo;
    }
}


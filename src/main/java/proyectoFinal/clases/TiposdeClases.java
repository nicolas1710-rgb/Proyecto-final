package proyectoFinal.clases;

public enum TiposdeClases {
    zumba("Zumba"),
    yoga("Yoga"),
    spinning("Spinning"),
    boxeo("Boxeo");
    private final String nombre;

    TiposdeClases(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return nombre;
    }
}

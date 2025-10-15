package proyectoFinal.clases;
import java.time.LocalDate;

public class Membresias {
    private TipoMembresia tipo;
    private DuracionMembresia duracion;
    private double costo;
    private LocalDate fechaInicio;
    private LocalDate fechaVencimiento;
    private boolean activa;

    public Membresias(TipoMembresia tipo, DuracionMembresia duracion, LocalDate fechaInicio) {
        this.tipo = tipo;
        this.duracion = duracion;
        this.costo = tipo.getPrecio(duracion); //  precio automático pene
        this.fechaInicio = fechaInicio;
        this.fechaVencimiento = fechaInicio.plusDays(duracion.getDias());
        this.activa = verificarEstado();
    }

    public boolean verificarEstado() {
        return !LocalDate.now().isAfter(fechaVencimiento);
    }

    @Override
    public String toString() {
        return tipo + " - " + duracion + " | $" + costo +
                " | Estado: " + (activa ? "Activa" : "Vencida") +
                "\nDesde: " + fechaInicio + " hasta: " + fechaVencimiento;
    }
}

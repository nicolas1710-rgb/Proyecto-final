package proyectoFinal.clases;

import javax.swing.plaf.multi.MultiPopupMenuUI;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

public class Recepcionista {
    private String usuario;
    private int contrasena;
    private Gimnasio gimnasio;
    private List<String> asistencias;
    public Recepcionista(){}
    public Recepcionista(String usuario , int contrasena){
        this.usuario = usuario;
        this.contrasena= contrasena;
        this.asistencias = new ArrayList<>();
    }
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public int getContrasena(){ return contrasena;}
    public void setContraena(int contrasena){ this.contrasena=contrasena;}



    public void RegistrarUsuario (Scanner sc, Gimnasio gimnasio){
        Usuarios user= new Usuarios();
        System.out.println("Ingrese el nombre del usuario");
        user.setNombre(sc.nextLine());
        System.out.println("Ingrese la identificacion del usuario");
        user.setIdentificacion(sc.nextInt());
        System.out.println("Ingrese la edad del usuario");
        user.setEdad(sc.nextInt());
        System.out.println("Ingrese el telefono del usuario");
        user.setTelefono(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese el tipo de membresia del usuario");
        user.setMembresias(sc.nextLine());
        gimnasio.getListaUsuarios().add(user);
        System.out.println(" Usuario creado correctamente");
    }
public void asignarMembresia(Scanner sc, Gimnasio gimnasio){
        System.out.println("Ingrese el id del usuario");
        int identificacion=sc.nextInt();
        sc.nextLine();
        boolean encontrado=false;
        for(Usuarios u:gimnasio.getListaUsuarios()){
            if(u.getIdentificacion()==identificacion){
                encontrado=true;
                System.out.println("Usuario encontrado su nombre es:"+ u.getNombre());
                System.out.println("¿Que membresia desea asignar?");
                System.out.println("1. Basica");
                System.out.println("2. Premium");
                System.out.println("3. VIP");
                int opcion=sc.nextInt();
                String tipoMembresia="";
                switch(opcion){
                    case 1:
                        tipoMembresia=(" La membresia adquirida es la basica");

                        break;
                    case 2:
                        tipoMembresia=(" La membresia adquirida es la premium");

                        break;
                    case 3:
                        tipoMembresia=(" La membresia adquirida es la VIP");
                        break;
                    default:
                        System.out.println("opcion invalida");
                        return;
                }
                u.setMembresias(tipoMembresia);
                System.out.println("Membresia asignada correctamente:"+tipoMembresia);
                break;
            }
        }if(!encontrado){
            System.out.println("Usuario no encontrado");
    }

}
public void registrarAsistencia(Scanner sc, Gimnasio gym) {
    System.out.println("Ingrese el nombre del usuario: ");
    String nombreUsuario = sc.nextLine();

    System.out.println("Seleccione la clase grupal: ");
    for(TiposdeClases tipo : TiposdeClases.values()){
        System.out.println("- " + tipo);
    }
    System.out.println("Clase elegida : ");
    String claseSeleccionda = sc.nextLine().toUpperCase();
    try {
        TiposdeClases tipoClase = TiposdeClases.valueOf(claseSeleccionda);
        String registro = nombreUsuario + " - " + tipoClase + " - " + LocalDate.now();
        asistencias.add(registro);
        System.out.println("Asistencia registrada correctamente: " + registro);
    }catch (IllegalArgumentException e){
        System.out.println("Clase no valida. Intente nuevamente");
    }
}
public void mostrarAsistencias() {
    if(asistencias.isEmpty()) {
        System.out.println("No hay asistencias registradas todavia.");
    }else {
        System.out.println("Asistencias registradas por " + usuario);
        for (String registro : asistencias) {
            System.out.println(registro);
        }
    }
}

public static void  validarIngreso(Scanner sc, Gimnasio gimnasio) {
        System.out.println("Ingrese la identificacion del usuario");
        int identificacion=sc.nextInt();
        sc.nextLine();
        boolean encontrado=false;
        for(Usuarios u:gimnasio.getListaUsuarios()){
            if(u.getIdentificacion()==identificacion){
                encontrado=true;
                System.out.println("Usuario encontrado:");
                System.out.println("Nombre: " + u.getNombre());
                System.out.println("ID: " + u.getIdentificacion());
                System.out.println("Edad: " + u.getEdad());
                System.out.println("Teléfono: " + u.getTelefono());
                System.out.println("Membresía: " + u.getMembresias());
                 break;
            }
            }if(!encontrado){
        System.out.println ("Usuario no encontrado");
    }

}



}



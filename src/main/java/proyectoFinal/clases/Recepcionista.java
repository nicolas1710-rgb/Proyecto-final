package proyectoFinal.clases;

import javax.swing.plaf.multi.MultiPopupMenuUI;
import java.util.Scanner;

public class Recepcionista {
    private String usuario;
    private int contraseña;
    private Gimnasio gimnasio;
    public Recepcionista(){}
    public Recepcionista(String usuario , int contraseña){
        this.usuario = usuario;
        this.contraseña= contraseña;
    }
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public int getContraseña(){ return contraseña;}
    public void setContraeña(int contraseña){ this.contraseña=contraseña;}

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



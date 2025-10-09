package proyectoFinal.clases;

import java.util.Scanner;

public class Administrador {
    private String usuario;
    private int contraseña;
    public Administrador(){
    }
    public Administrador(String usuario, int contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }
    public String getUsuario() {return usuario;}
    public void setUsuario(String usuario) {this.usuario = usuario;}
    public int getContraseña() {return contraseña;}
    public void setContraseña(int contraseña) {this.contraseña = contraseña;}

    public void RegistrarEntrenador (Scanner sc, Gimnasio gimnasio){
        Entrenador entrenador= new Entrenador();
        System.out.println("Ingrese el nombre del entrenador");
        entrenador.setNombre(sc.nextLine());
        System.out.println("Ingrese la identificacion del entrenador");
        entrenador.setIdentificacion(sc.nextInt());
        System.out.println("Ingrese la edad del entrenador");
        entrenador.setEdad(sc.nextInt());
        System.out.println("Ingrese el telefono del entrenador");
        entrenador.setTelefono(sc.nextInt());
        sc.nextLine();
        System.out.println("Ingrese la especialidad del entrenador");
        entrenador.setEspecialidad(sc.nextLine());
        System.out.println("Ingrese el salario del entrenador");
        entrenador.setSalario(sc.nextDouble());
        gimnasio.getListaEntrenadores().add(entrenador);
        System.out.println(" Entrenador creado correctamente");
    }
}

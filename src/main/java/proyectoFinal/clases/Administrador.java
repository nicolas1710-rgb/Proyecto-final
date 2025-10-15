package proyectoFinal.clases;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Administrador {
    private String usuario;
    private int contrasena;

    public Administrador(){
    }

    public Administrador(String usuario, int contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getContrasena() {
        return contrasena;
    }

    public void setContrasena(int contrasena) {
        this.contrasena = contrasena;
    }

    public void RegistrarEntrenador(Scanner sc, Gimnasio gimnasio) {
        int identificacion = -1;
        boolean entradaValida = false;

        while(!entradaValida) {
            System.out.println("Ingrese la identificacion del entrenador: ");
            try {
                identificacion = sc.nextInt();
                sc.nextLine();
                entradaValida = true;
            }catch (InputMismatchException e){
                System.out.println("La identificacion del entrenador es incorrecta");
                sc.nextLine();
            }
        }
        Entrenador entrenadorEncontrado = obtenerEntrenador(identificacion, gimnasio);
        if (entrenadorEncontrado == null) {
            Entrenador entrenador = new Entrenador();
            entrenador.setIdentificacion(identificacion);

            System.out.println("Ingrese el nombre del entrenador");
            entrenador.setNombre(sc.nextLine());
            System.out.println("Ingrese la edad del entrenador");
            entrenador.setEdad(sc.nextInt());
            System.out.println("Ingrese el telefono del entrenador");
            entrenador.setTelefono(sc.nextLong());
            sc.nextLine();
            System.out.println("Ingrese la especialidad del entrenador");
            entrenador.setEspecialidad(sc.nextLine());
            System.out.println("Ingrese el salario del entrenador");
            entrenador.setSalario(sc.nextDouble());
            gimnasio.getListaEntrenadores().add(entrenador);
            System.out.println(" Entrenador creado correctamente");
        } else {
            System.out.println("Entrenador existente");
        }
    }

    public Entrenador obtenerEntrenador(int identificacion, Gimnasio gimnasio) {
        Entrenador entrenadorEncontrado = null;
        for (Entrenador entrenador : gimnasio.getListaEntrenadores()) {
            if (entrenador.getIdentificacion() == identificacion) {
                entrenadorEncontrado = entrenador;
                break;
            }
        }
        return entrenadorEncontrado;
    }

    public Clases buscarNombreClases (String nombre, Gimnasio gimnasio){
        Clases nombreClases = null;
        for (Clases clases : gimnasio.getListaClases()){
            if (clases.getNombre().equalsIgnoreCase(nombre)){
                nombreClases = clases;
            }
        }
        return nombreClases;
    }

    public void modificarEntrenador(Scanner sc, Gimnasio gimnasio) {
        int identificacion;
        boolean entradaValida = false;

        while(!entradaValida) {
            System.out.println("Ingrese la identificacion del entrenador: ");
            try {
                identificacion = sc.nextInt();
                sc.nextLine();

                Entrenador entrenadorEncontrado = obtenerEntrenador(identificacion, gimnasio);

                for (Entrenador entrenador : gimnasio.getListaEntrenadores()) {
                    if (entrenadorEncontrado != null) {
                        entradaValida = true;
                        System.out.println("Ingrese el nuevo nombre del entrenador");
                        entrenador.setNombre(sc.nextLine());
                        System.out.println("Ingrese la nueva edad del entrenador");
                        entrenador.setEdad(sc.nextInt());
                        System.out.println("Ingrese el nuevo telefono del entrenador");
                        entrenador.setTelefono(sc.nextLong());
                        sc.nextLine();
                        System.out.println("Ingrese la especialidad del entrenador");
                        entrenador.setEspecialidad(sc.nextLine());
                        System.out.println("Ingrese el salario del entrenador");
                        entrenador.setSalario(sc.nextDouble());
                        System.out.println(" Entrenador actualizado correctamente");
                    } else {
                        System.out.println("Entrenador no existente");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Error, debe ingresar solo números enteros.");}
            sc.nextLine();
        }
    }

    public void eliminarEntrenador(Scanner sc, Gimnasio gimnasio) {
        int identificacion;
        boolean entradaValida = false;

        while(!entradaValida) {
            System.out.println("Ingrese la identificacion del entrenador: ");
            try{
                identificacion = sc.nextInt();
                sc.nextLine();

                Entrenador entrenadorEncontrado = obtenerEntrenador(identificacion, gimnasio);
                if (entrenadorEncontrado != null) {
                    gimnasio.getListaEntrenadores().remove(entrenadorEncontrado);
                    System.out.println(" Entrenador eliminado correctamente");
                    entradaValida = true;
                }else{
                    System.out.println("Entrenador no existente");
                }
            }catch (InputMismatchException e){
                System.out.println("Error, debe ingresar solo números enteros.");
            }
        }
    }

    public void asignarEntrenadorClase(Scanner sc, Gimnasio gimnasio) {
        int identificacion;
        boolean entradaValida = false;
        Entrenador entrenadorEncontrado = null;

        while (!entradaValida) {
            System.out.print("Ingrese la identificación del entrenador: ");
            try {
                identificacion = sc.nextInt();
                sc.nextLine();

                entrenadorEncontrado = obtenerEntrenador(identificacion, gimnasio);
                if (entrenadorEncontrado != null) {
                    entradaValida = true;
                } else {
                    System.out.println("No se encontró ningún entrenador con esa identificación.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error, Debe ingresar solo números enteros.");
                sc.nextLine();
            }
        }

        System.out.print("Ingrese el nombre de la clase: ");
        String nombreClase = sc.nextLine();
        Clases claseEncontrada = buscarNombreClases(nombreClase, gimnasio);

        if (claseEncontrada == null) {
            System.out.println("Clase no existente.");
            return;
        }

        claseEncontrada.setEntrenador(entrenadorEncontrado);
        System.out.println("La clase " + claseEncontrada.getNombre() + " fue asignada al entrenador: " + entrenadorEncontrado.getNombre());
    }
}

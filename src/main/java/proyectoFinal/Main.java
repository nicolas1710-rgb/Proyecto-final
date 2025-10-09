package proyectoFinal;

import proyectoFinal.clases.Administrador;
import proyectoFinal.clases.Gimnasio;
import proyectoFinal.clases.Recepcionista;
import proyectoFinal.clases.Usuarios;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gimnasio gym = inicializarDatos();
        int opcion;
        do {
            System.out.println("||||||| Bienvenido al gimnasio UQ Fit |||||||");
            System.out.println("Seleccione una de las opciones para poder ingresar");
            System.out.println("1. Marca esta opcion si eres recepcionista ");
            System.out.println("2. Marca esta opcion si eres adminstrador ");
            System.out.println("3. Si quieres conocer informacion sobre nuestras membresias");
            System.out.println("4. Marca esta opcion si eres usuario");
            System.out.println("0. Si quieres salir del menu");
            opcion = sc.nextInt();
            sc.nextLine();
            //a
            switch (opcion) {
                case 1:
                    if (ingresoRecepcionista(sc, gym)) {
                        System.out.println("Ha sido exitoso el ingreso");
                        menuRecepcionista(sc, gym);
                    } else {
                        System.out.println("El usuario o la contraseña ingresada no es valido");
                    }
                    break;
                case 2:
                    if (ingresoAdministrador(sc, gym)) {
                        menuAdministrador(sc, gym);
                    } else {
                        System.out.println("El usuario o la contraseña ingresada no es valido");
                    }
                    break;
            }


        } while (opcion != 0);
    }
    public static Gimnasio inicializarDatos() {
        Gimnasio gimnasio = new Gimnasio();
        Recepcionista recepcionista = new Recepcionista("pepe", 123);
        gimnasio.getListaRecepcionistas().add(recepcionista);
        Administrador administrador = new Administrador("Admin", 12345);
        gimnasio.setAdministrador(administrador);
        Usuarios usuario= new Usuarios("Pedro",100, 18,30549271,"VIP");
        gimnasio.getListaUsuarios().add(usuario);
        return gimnasio;
    }

    public static boolean ingresoRecepcionista(Scanner sc, Gimnasio gym) {
        System.out.println("Ingrese su usuario");
        String usuarioIngresado = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        int contraseñaIngresada = sc.nextInt();
        sc.nextLine();
        boolean UsuarioCorrecto = false;
        for (Recepcionista r : gym.getListaRecepcionistas()) {
            if (r.getUsuario().equalsIgnoreCase(usuarioIngresado) && r.getContraseña() == contraseñaIngresada) {
                UsuarioCorrecto = true;
            }
        }
        return true;
    }

    public static boolean ingresoAdministrador(Scanner sc, Gimnasio gym) {
        Gimnasio gimnasio = new Gimnasio();
        System.out.println("Ingrese su usuario");
        String usuarioIngresado = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        int contraseñaIngresada = sc.nextInt();
        sc.nextLine();
        boolean UsuarioCorrecto = false;

        if (gimnasio.getAdministrador().equals(usuarioIngresado) && gimnasio.getAdministrador().equals(contraseñaIngresada)) {
            UsuarioCorrecto = true;
        }

        return true;
    }

    public static void menuRecepcionista(Scanner sc, Gimnasio gym) {
        int opcion;
        Recepcionista recepcionista = new Recepcionista();
        do {

            System.out.println("¬¬¬¬¬¬¬¬¬Bienvenido al menu del recepcionista¬¬¬¬¬¬¬¬¬");
            System.out.println("Seleccione una de las opciones que requiera");
            System.out.println("1. Si desea crear un nuevo usuario(cliente)");
            System.out.println("2. Si deseas asignar algun tipo de membresia a algun usuario");
            System.out.println("3. Si deseas reservar a un usuario a alguna clase");
            System.out.println("4. Si deseas validar el ingreso de un usuario por medio de su id");
            System.out.println("5. Si deseas generar algun tipo de reporte");
            System.out.println("0. si desea salir del menu");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    recepcionista.RegistrarUsuario(sc, gym);
                    break;
                case 2:
                    recepcionista.asignarMembresia(sc, gym);
                    break;
                case 4:
                    recepcionista.validarIngreso(sc, gym);
                    ;
                    break;

            }

        } while (opcion != 0);

    }

    public static void menuAdministrador(Scanner sc, Gimnasio gym) {
        int opcion;
        Administrador administrador= new Administrador();
        do {

            System.out.println("¬¬¬¬¬¬¬¬¬Bienvenido al menu del administrador¬¬¬¬¬¬¬¬¬");
            System.out.println("Seleccione una de las opciones que requiera");
            System.out.println("1. Si desea crear un nuevo entrenador");
            System.out.println("2. Si desea modificar un entrenador");
            System.out.println("3. Si desea eliminar un entrenador");
            System.out.println("4. Si desea asignar un entrenador a una clase");
            System.out.println("5. Control de acceso mediante credenciales de usuario.");
            System.out.println("6. Manejo de excepciones: Implementación de mecanismos para manejar errores.");
            System.out.println("Generación de reportes avanzados: Estadísticas de asistencia, ingresos por membresías y clases más populares.");
            System.out.println("0. si desea salir del menu");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    administrador.RegistrarEntrenador(sc, gym);
                    break;
            }
        }while (opcion!=0);
    }
}
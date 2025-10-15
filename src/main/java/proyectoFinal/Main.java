package proyectoFinal;

import proyectoFinal.clases.*;

import java.util.InputMismatchException;
import java.util.Scanner;

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
        Recepcionista recepcionista = new Recepcionista("Pene", 123);
        gimnasio.getListaRecepcionistas().add(recepcionista);
        Administrador administrador = new Administrador("Admin", 12345);
        gimnasio.setAdministrador(administrador);
        Usuarios usuario= new Usuarios("Pedro",100, 18,30549271,"VIP");
        gimnasio.getListaUsuarios().add(usuario);
        Usuarios usuario_2 = new Usuarios("Martha", 75329178, 34, 3115135958L, "VIP");
        gimnasio.getListaUsuarios().add(usuario_2);
        Usuarios usuario_3 = new Usuarios("Angel", 1057643164, 20, 3115135958L, "VIP");
        gimnasio.getListaUsuarios().add(usuario_3);
        Usuarios usuario_4 = new Usuarios("Yuliexis", 1098406737, 21, 3115135958L, "VIP");
        gimnasio.getListaUsuarios().add(usuario_4);
        Usuarios usuario_5 = new Usuarios("Jhoanny", 1059250274, 17, 3115135958L, "VIP");
        gimnasio.getListaUsuarios().add(usuario_5);
        Entrenador entrenador = new Entrenador("Veneco", 1200000, "Nicolás", 1097860571, 27, 3024587763L);
        gimnasio.getListaEntrenadores().add(entrenador);
        //la mano de obra veneca es mas barata 😘
        Entrenador entrenador_2 = new Entrenador("Exclavo", 1300000, "Cristian", 1097561274, 39, 3113171910L);
        gimnasio.getListaEntrenadores().add(entrenador_2);
        Entrenador entrenador_3 = new Entrenador("Boliviano", 1500000, "Santiago", 1059340562, 22, 3115135638L);
        gimnasio.getListaEntrenadores().add(entrenador_3);
        return gimnasio;
    }

    public static boolean ingresoRecepcionista(Scanner sc, Gimnasio gym) {
        System.out.println("Ingrese su usuario");
        String usuarioIngresado = sc.nextLine();
        System.out.println("Ingrese su contraseña");
        int contrasenaIngresada = sc.nextInt();
        sc.nextLine();
        boolean UsuarioCorrecto = false;
        for (Recepcionista r : gym.getListaRecepcionistas()) {
            if (r.getUsuario().equalsIgnoreCase(usuarioIngresado) && r.getContrasena() == contrasenaIngresada) {
                UsuarioCorrecto = true;
            }
        }
        return true;
    }

    public static boolean ingresoAdministrador(Scanner sc, Gimnasio gym) {
        System.out.println("Ingrese su usuario");
        String usuarioIngresado = sc.nextLine();

        int contrasenaIngresada = -1;
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Ingrese su contraseña");
            try {
                contrasenaIngresada = sc.nextInt();
                sc.nextLine();
                entradaValida = true;
            }catch (InputMismatchException e){
                System.out.println("Error, la contraseña debe ser un numero entero.");
                sc.nextLine();
            }
        }

        Administrador admin = gym.getAdministrador();
        if (admin.getUsuario().equalsIgnoreCase(usuarioIngresado) && admin.getContrasena() == contrasenaIngresada){
            System.out.println("Usuario correcto, ingresando a menú de Administrador...");
            return true;
        }else{
            System.out.println("Usuario incorrecto, verifique si el usuario o la contraseña son correctas.");
            return false;
        }
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
            System.out.println("4. Si desea mostrar las asistencias de las clases");
            System.out.println("5. Si deseas validar el ingreso de un usuario por medio de su id");
            System.out.println("6. Si deseas generar algun tipo de reporte");
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
                case 3:
                    recepcionista.registrarAsistencia(sc, gym);
                    break;
                case 4:
                    recepcionista.mostrarAsistencias();
                    break;
                case 5:
                    recepcionista.validarIngreso(sc, gym);
                    break;
                case 6:
            }

        } while (opcion != 0);

    }

    public static void menuAdministrador(Scanner sc, Gimnasio gym) {
        Administrador administrador = new Administrador();
        int opcion;

        do {

            System.out.println("¬¬¬¬¬¬¬¬¬Bienvenido al menu del administrador¬¬¬¬¬¬¬¬¬");
            System.out.println("Seleccione una de las opciones que requiera");
            System.out.println("1. Si desea crear un nuevo entrenador");
            System.out.println("2. Si desea modificar un entrenador");
            System.out.println("3. Si desea eliminar un entrenador");
            System.out.println("4. Si desea asignar un entrenador a una clase");
            System.out.println("5. Generación de reportes avanzados: Estadísticas de asistencia, ingresos por membresías y clases más populares.");
            System.out.println("0. si desea salir del menu");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    administrador.RegistrarEntrenador(sc, gym);
                    break;
                case 2:
                    administrador.modificarEntrenador(sc, gym);
                    break;
                case 3:
                    administrador.eliminarEntrenador(sc, gym);
                    break;
                case 4:
                    administrador.asignarEntrenadorClase(sc, gym);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no permitida");
                    break;
            }
        } while (opcion != 0);
    }
}
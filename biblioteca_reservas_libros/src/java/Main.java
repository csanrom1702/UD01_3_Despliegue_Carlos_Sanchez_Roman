package java;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * La clase Main es la clase principal del programa de gestión de biblioteca.
 * Permite a los usuarios listar libros, crear reservas, cancelar reservas y listar reservas activas.
 */
public class Main {
    private static ArrayList<Libro> libros = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    /**
     * Método principal del programa.
     * @param args Argumentos de línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        // Crear libros de ejemplo y agregarlos a la lista de libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "1234567890");
        Libro libro2 = new Libro("El Gran Gatsby", "F. Scott Fitzgerald", "9876543210");
        libros.add(libro1);
        libros.add(libro2);

        Scanner scanner = new Scanner(System.in);

        // Bucle principal del menú
        while (true) {
            System.out.println("Biblioteca - Menú Principal");
            System.out.println("1. Listado de Libros");
            System.out.println("2. Crear Reserva");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Listado de Reservas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    listarLibros();
                    break;
                case 2:
                    crearReserva(scanner);
                    break;
                case 3:
                    cancelarReserva(scanner);
                    break;
                case 4:
                    listarReservas();
                    break;
                case 5:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    /**
     * Muestra un listado de todos los libros disponibles y reservados.
     */
    private static void listarLibros() {
        System.out.println("Listado de Libros:");
        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }

    /**
     * Permite a un usuario crear una reserva para un libro si está disponible.
     * @param scanner Scanner para recibir la entrada del usuario.
     */
    private static void crearReserva(Scanner scanner) {
        System.out.print("Ingrese el ISBN del libro que desea reservar: ");
        String isbn = scanner.nextLine();

        Libro libro = buscarLibroPorISBN(isbn);

        if (libro == null) {
            System.out.println("El libro con el ISBN " + isbn + " no se encuentra en la biblioteca.");
        } else {
            if (libro.getEstado() == EstadoLibro.DISPONIBLE) {
                System.out.print("Ingrese su nombre de usuario: ");
                String usuario = scanner.nextLine();

                Reserva reserva = new Reserva(usuario, libro, new Date(), null);
                reservas.add(reserva);
                libro.setEstado(EstadoLibro.RESERVADO);

                System.out.println("Reserva exitosa.");
            } else {
                System.out.println("El libro con el ISBN " + isbn + " ya está reservado.");
            }
        }
    }

    /**
     * Permite a un usuario cancelar una reserva que haya hecho.
     * @param scanner Scanner para recibir la entrada del usuario.
     */
    private static void cancelarReserva(Scanner scanner) {
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();

        Reserva reserva = buscarReservaPorUsuario(usuario);

        if (reserva == null) {
            System.out.println("No tiene reservas activas.");
        } else {
            Libro libro = reserva.getLibro();
            libro.setEstado(EstadoLibro.DISPONIBLE);
            reservas.remove(reserva);

            System.out.println("Cancelación de reserva exitosa.");
        }
    }

    /**
     * Muestra un listado de todas las reservas activas con detalles del libro y del usuario.
     */
    private static void listarReservas() {
        System.out.println("Listado de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println("Usuario: " + reserva.getUsuario());
            System.out.println("Libro: " + reserva.getLibro().getTitulo());
            System.out.println("Fecha de Reserva: " + reserva.getFechaReserva());
            System.out.println("Fecha de Devolución: " + reserva.getFechaDevolucion());
            System.out.println();
        }
    }

    /**
     * Busca un libro en la lista de libros por su ISBN.
     * @param isbn ISBN del libro a buscar.
     * @return El libro encontrado o null si no se encuentra.
     */
    private static Libro buscarLibroPorISBN(String isbn) {
        for (Libro libro : libros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    /**
     * Busca una reserva por el nombre de usuario del usuario que la hizo.
     * @param usuario Nombre de usuario del usuario que hizo la reserva.
     * @return La reserva encontrada o null si no se encuentra.
     */
    private static Reserva buscarReservaPorUsuario(String usuario) {
        for (Reserva reserva : reservas) {
            if (reserva.getUsuario().equals(usuario)) {
                return reserva;
            }
        }
        return null;
    }
}
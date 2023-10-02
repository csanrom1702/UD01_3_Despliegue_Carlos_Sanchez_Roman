package java;
import java.util.Date;

/**
 * La clase Reserva representa una reserva de un libro realizada por un usuario en la biblioteca.
 */
public class Reserva {
    private String usuario;
    private Libro libro;
    private Date fechaReserva;
    private Date fechaDevolucion;

    /**
     * Constructor de la clase Reserva.
     *
     * @param usuario         El nombre del usuario que realiza la reserva.
     * @param libro           El libro que se reserva.
     * @param fechaReserva    La fecha en que se realiza la reserva.
     * @param fechaDevolucion La fecha de devolución prevista del libro.
     */
    public Reserva(String usuario, Libro libro, Date fechaReserva, Date fechaDevolucion) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaReserva = fechaReserva;
        this.fechaDevolucion = fechaDevolucion;
    }

    /**
     * Obtiene el nombre del usuario que realizó la reserva.
     *
     * @return El nombre del usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Obtiene el libro que se reservó.
     *
     * @return El libro reservado.
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Obtiene la fecha en que se realizó la reserva.
     *
     * @return La fecha de reserva.
     */
    public Date getFechaReserva() {
        return fechaReserva;
    }

    /**
     * Obtiene la fecha de devolución prevista del libro.
     *
     * @return La fecha de devolución prevista.
     */
    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }
}
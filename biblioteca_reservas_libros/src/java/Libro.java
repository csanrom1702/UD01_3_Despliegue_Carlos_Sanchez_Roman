package java;

/**
 * La clase Libro representa un libro en la biblioteca, con información como título, autor, ISBN y estado de disponibilidad.
 */
public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private EstadoLibro estado;

    /**
     * Constructor de la clase Libro.
     *
     * @param titulo El título del libro.
     * @param autor  El autor del libro.
     * @param isbn   El ISBN del libro.
     */
    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.estado = EstadoLibro.DISPONIBLE;
    }

    /**
     * Obtiene el título del libro.
     *
     * @return El título del libro.
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return El autor del libro.
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Obtiene el ISBN del libro.
     *
     * @return El ISBN del libro.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Obtiene el estado de disponibilidad del libro.
     *
     * @return El estado del libro (DISPONIBLE o RESERVADO).
     */
    public EstadoLibro getEstado() {
        return estado;
    }

    /**
     * Establece el estado de disponibilidad del libro.
     *
     * @param estado El nuevo estado del libro.
     */
    public void setEstado(EstadoLibro estado) {
        this.estado = estado;
    }

    /**
     * Representa el libro como una cadena de texto.
     *
     * @return Una cadena que representa el libro con sus atributos.
     */
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", estado=" + estado +
                '}';
    }
}
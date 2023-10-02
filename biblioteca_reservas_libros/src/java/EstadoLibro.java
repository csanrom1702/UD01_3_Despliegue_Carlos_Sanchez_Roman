package java;

/**
 * Enumeración que representa los posibles estados de un libro en una biblioteca.
 * Puede ser DISPONIBLE o RESERVADO.
 */
public enum EstadoLibro {
    /**
     * Representa el estado en el que un libro está disponible para ser prestado.
     */
    DISPONIBLE,

    /**
     * Representa el estado en el que un libro ha sido reservado por un usuario y no está disponible para préstamo.
     */
    RESERVADO
}
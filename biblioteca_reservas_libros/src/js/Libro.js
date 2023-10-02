/**
 * Clase que representa un libro en una biblioteca.
 * @class
 */
class Libro {
    /**
     * Crea una instancia de la clase Libro.
     * @constructor
     * @param {string} titulo - El título del libro.
     * @param {string} autor - El autor del libro.
     * @param {string} isbn - El ISBN (Número de Identificación del Libro) del libro.
     */
    constructor(titulo, autor, isbn) {
      /**
       * El título del libro.
       * @type {string}
       */
      this.titulo = titulo;
  
      /**
       * El autor del libro.
       * @type {string}
       */
      this.autor = autor;
  
      /**
       * El ISBN (Número de Identificación del Libro) del libro.
       * @type {string}
       */
      this.isbn = isbn;
  
      /**
       * El estado del libro (puede ser "DISPONIBLE" o "RESERVADO").
       * @type {string}
       */
      this.estado = EstadoLibro.DISPONIBLE;
    }
  
    /**
     * Obtiene el título del libro.
     * @returns {string} - El título del libro.
     */
    getTitulo() {
      return this.titulo;
    }
  
    /**
     * Obtiene el autor del libro.
     * @returns {string} - El autor del libro.
     */
    getAutor() {
      return this.autor;
    }
  
    /**
     * Obtiene el ISBN del libro.
     * @returns {string} - El ISBN del libro.
     */
    getIsbn() {
      return this.isbn;
    }
  
    /**
     * Obtiene el estado del libro.
     * @returns {string} - El estado del libro (puede ser "DISPONIBLE" o "RESERVADO").
     */
    getEstado() {
      return this.estado;
    }
  
    /**
     * Establece el estado del libro.
     * @param {string} estado - El estado del libro (puede ser "DISPONIBLE" o "RESERVADO").
     */
    setEstado(estado) {
      this.estado = estado;
    }
  
    /**
     * Devuelve una representación en cadena del libro.
     * @returns {string} - Una cadena que representa el libro en formato legible.
     */
    toString() {
      return `Libro{titulo='${this.titulo}', autor='${this.autor}', isbn='${this.isbn}', estado=${this.estado}}`;
    }
  }
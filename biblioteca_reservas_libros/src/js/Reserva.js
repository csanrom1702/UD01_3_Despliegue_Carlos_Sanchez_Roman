/**
 * Clase que representa una reserva de un libro en una biblioteca.
 * @class
 */
class Reserva {
    /**
     * Crea una instancia de la clase Reserva.
     * @constructor
     * @param {string} usuario - El nombre de usuario del cliente que realiza la reserva.
     * @param {Libro} libro - El libro que se ha reservado.
     * @param {Date} fechaReserva - La fecha en la que se realizó la reserva.
     * @param {Date} fechaDevolucion - La fecha de devolución prevista del libro reservado.
     */
    constructor(usuario, libro, fechaReserva, fechaDevolucion) {
      /**
       * El nombre de usuario del cliente que realiza la reserva.
       * @type {string}
       */
      this.usuario = usuario;
  
      /**
       * El libro que se ha reservado.
       * @type {Libro}
       */
      this.libro = libro;
  
      /**
       * La fecha en la que se realizó la reserva.
       * @type {Date}
       */
      this.fechaReserva = fechaReserva;
  
      /**
       * La fecha de devolución prevista del libro reservado.
       * @type {Date}
       */
      this.fechaDevolucion = fechaDevolucion;
    }
  
    /**
     * Obtiene el nombre de usuario del cliente que realizó la reserva.
     * @returns {string} - El nombre de usuario del cliente.
     */
    getUsuario() {
      return this.usuario;
    }
  
    /**
     * Obtiene el libro que se ha reservado.
     * @returns {Libro} - El libro reservado.
     */
    getLibro() {
      return this.libro;
    }
  
    /**
     * Obtiene la fecha en la que se realizó la reserva.
     * @returns {Date} - La fecha de reserva.
     */
    getFechaReserva() {
      return this.fechaReserva;
    }
  
    /**
     * Obtiene la fecha de devolución prevista del libro reservado.
     * @returns {Date} - La fecha de devolución prevista.
     */
    getFechaDevolucion() {
      return this.fechaDevolucion;
    }
  }
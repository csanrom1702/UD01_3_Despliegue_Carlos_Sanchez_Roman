/**
 * @file Este archivo contiene un programa que gestiona una biblioteca de libros y reservas.
 * @module Biblioteca
 */

const Libro = require('./Libro');
const Reserva = require('./Reserva');

/**
 * Enumeración que define los estados posibles de un libro.
 * @enum {string}
 */
const EstadoLibro = {
  DISPONIBLE: 'DISPONIBLE',
  RESERVADO: 'RESERVADO',
};

const libro1 = new Libro('Cien años de soledad', 'Gabriel García Márquez', '1234567890');
const libro2 = new Libro('El Gran Gatsby', 'F. Scott Fitzgerald', '9876543210');
const libros = [libro1, libro2];

const reservas = [];

const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

/**
 * Función que muestra el menú principal de la biblioteca.
 */
function mostrarMenu() {
  console.log('Biblioteca - Menú Principal');
  console.log('1. Listado de Libros');
  console.log('2. Crear Reserva');
  console.log('3. Cancelar Reserva');
  console.log('4. Listado de Reservas');
  console.log('5. Salir');

  rl.question('Seleccione una opción: ', (opcion) => {
    switch (opcion) {
      case '1':
        listarLibros();
        break;
      case '2':
        crearReserva();
        break;
      case '3':
        cancelarReserva();
        break;
      case '4':
        listarReservas();
        break;
      case '5':
        console.log('Saliendo del programa.');
        rl.close();
        break;
      default:
        console.log('Opción no válida. Por favor, seleccione una opción válida.');
        mostrarMenu();
    }
  });
}

/**
 * Función que muestra el listado de libros disponibles en la biblioteca.
 */
function listarLibros() {
  console.log('Listado de Libros:');
  libros.forEach((libro) => {
    console.log(libro.toString());
  });
  mostrarMenu();
}

/**
 * Función que busca un libro por su ISBN.
 * @param {string} isbn - El ISBN del libro a buscar.
 * @returns {Libro|null} - El libro encontrado o null si no se encuentra.
 */
function buscarLibroPorISBN(isbn) {
  return libros.find((libro) => libro.getIsbn() === isbn);
}

/**
 * Función que permite crear una reserva de un libro.
 */
function crearReserva() {
  rl.question('Ingrese el ISBN del libro que desea reservar: ', (isbn) => {
    const libro = buscarLibroPorISBN(isbn);

    if (!libro) {
      console.log(`El libro con el ISBN ${isbn} no se encuentra en la biblioteca.`);
      mostrarMenu();
    } else {
      if (libro.getEstado() === EstadoLibro.DISPONIBLE) {
        rl.question('Ingrese su nombre de usuario: ', (usuario) => {
          const reserva = new Reserva(usuario, libro, new Date(), null);
          reservas.push(reserva);
          libro.setEstado(EstadoLibro.RESERVADO);

          console.log('Reserva exitosa.');
          mostrarMenu();
        });
      } else {
        console.log(`El libro con el ISBN ${isbn} ya está reservado.`);
        mostrarMenu();
      }
    }
  });
}

/**
 * Función que busca una reserva por el nombre de usuario.
 * @param {string} usuario - El nombre de usuario para buscar la reserva.
 * @returns {Reserva|null} - La reserva encontrada o null si no se encuentra.
 */
function buscarReservaPorUsuario(usuario) {
  return reservas.find((reserva) => reserva.getUsuario() === usuario);
}

/**
 * Función que permite cancelar una reserva de un libro.
 */
function cancelarReserva() {
  rl.question('Ingrese su nombre de usuario: ', (usuario) => {
    const reserva = buscarReservaPorUsuario(usuario);

    if (!reserva) {
      console.log('No tiene reservas activas.');
      mostrarMenu();
    } else {
      const libro = reserva.getLibro();
      libro.setEstado(EstadoLibro.DISPONIBLE);
      reservas.splice(reservas.indexOf(reserva), 1);

      console.log('Cancelación de reserva exitosa.');
      mostrarMenu();
    }
  });
}

/**
 * Función que muestra el listado de reservas realizadas.
 */
function listarReservas() {
  console.log('Listado de Reservas:');
  reservas.forEach((reserva) => {
    console.log(`Usuario: ${reserva.getUsuario()}`);
    console.log(`Libro: ${reserva.getLibro().getTitulo()}`);
    console.log(`Fecha de Reserva: ${reserva.getFechaReserva()}`);
    console.log(`Fecha de Devolución: ${reserva.getFechaDevolucion()}`);
    console.log();
  });
  mostrarMenu();
}

mostrarMenu();
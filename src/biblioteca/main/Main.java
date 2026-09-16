
package biblioteca.main;

import biblioteca.servicio.BibliotecaService;
import biblioteca.servicio.EstadoDisponibilidad;
import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Usuario;
import biblioteca.modelo.LibroDigital;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Autor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {

  
    public static void main(String[] args) {
        
        System.out.println(
                "=========================================="
        );

        System.out.println(
                "        SISTEMA DE BIBLIOTECA"
        );

        System.out.println(
                "=========================================="
        );

        BibliotecaService biblioteca =
                new BibliotecaService();

        // ========================================================
        // CREAR AUTOR
        // ========================================================

        Autor autor = new Autor(
                1,
                "Gabriel García Márquez",
                "Colombiana",
                new Date()
        );

        biblioteca.registrarAutor(autor);

        // ========================================================
        // CREAR LIBRO
        // ========================================================

        Libro libro = new Libro(
                1,
                "Cien años de soledad",
                "978-0307474728",
                1967
        );

        biblioteca.registrarLibro(libro);

        // ========================================================
        // CREAR LIBRO DIGITAL
        // ========================================================

        LibroDigital libroDigital =
                new LibroDigital(
                        2,
                        "Introducción a Java",
                        "978-0000000000",
                        2025,
                        "PDF",
                        4.5,
                        "https://ejemplo.com/java",
                        true
                );

        biblioteca.registrarLibro(libroDigital);

        // ========================================================
        // AGREGACIÓN
        // ========================================================

        autor.agregarLibro(libro);
        autor.agregarLibro(libroDigital);

        System.out.println(
                "\n---------- AUTOR ----------"
        );

        System.out.println(
                autor.obtenerInfo()
        );

        autor.escribirLibro();

        // ========================================================
        // MOSTRAR LIBROS
        // ========================================================

        System.out.println(
                "\n---------- LIBROS ----------"
        );

        System.out.println(
                libro.obtenerInfo()
        );

        System.out.println(
                libroDigital.obtenerInfo()
        );

        // ========================================================
        // POLIMORFISMO
        // ========================================================

        System.out.println(
                "\n---------- POLIMORFISMO ----------"
        );

        List<Libro> listaLibros =
                new ArrayList<>();

        listaLibros.add(libro);
        listaLibros.add(libroDigital);

        for (Libro item : listaLibros) {

            System.out.println(
                    "Procesando: "
                    + item.getTitulo()
            );

            item.prestar();
        }

        // ========================================================
        // USUARIO
        // ========================================================

        System.out.println(
                "\n---------- USUARIO ----------"
        );

        Usuario usuario = new Usuario(
                1,
                "María López",
                "1000000000",
                "Estudiante"
        );

        usuario.registrar();

        biblioteca.registrarUsuario(usuario);

        System.out.println(
                usuario.obtenerInfo()
        );

        // ========================================================
        // PREPARAR LIBRO PARA PRÉSTAMO
        // ========================================================

        libro.setEstado(
                EstadoDisponibilidad.DISPONIBLE
        );

        // ========================================================
        // PRÉSTAMO
        // ========================================================

        System.out.println(
                "\n---------- PRÉSTAMO ----------"
        );

        Date fechaPrestamo = new Date();

        Date fechaDevolucion =
                new Date(
                        fechaPrestamo.getTime()
                        + (7L * 24 * 60 * 60 * 1000)
                );

        Prestamo prestamo =
                new Prestamo(
                        1,
                        fechaPrestamo,
                        fechaDevolucion,
                        usuario,
                        libro
                );

        biblioteca.registrarPrestamo(
                prestamo
        );

        System.out.println(
                "Estado del libro: "
                + libro.getEstado()
        );

        // ========================================================
        // DEVOLUCIÓN
        // ========================================================

        System.out.println(
                "\n---------- DEVOLUCIÓN ----------"
        );

        prestamo.devolver();

        System.out.println(
                "Estado del libro: "
                + libro.getEstado()
        );

        System.out.println(
                "Días de atraso: "
                + prestamo.calcularDiasAtraso()
        );

        // ========================================================
        // LIBRO DIGITAL
        // ========================================================

        System.out.println(
                "\n---------- LIBRO DIGITAL ----------"
        );

        libroDigital.setEstado(
                EstadoDisponibilidad.DISPONIBLE
        );

        libroDigital.descargar();

        libroDigital.leerEnLinea();

        System.out.println(
                libroDigital.obtenerInfo()
        );

        // ========================================================
        // SOBRECARGA
        // ========================================================

        System.out.println(
                "\n---------- SOBRECARGA ----------"
        );

        libro.setEstado(
                EstadoDisponibilidad.DISPONIBLE
        );

        Date nuevaFechaDevolucion =
                new Date(
                        System.currentTimeMillis()
                        + (10L * 24 * 60 * 60 * 1000)
                );

        prestamo.registrar(
                nuevaFechaDevolucion
        );

        // ========================================================
        // FINAL
        // ========================================================

        System.out.println(
                "\n=========================================="
        );

        System.out.println(
                "    PROGRAMA EJECUTADO CORRECTAMENTE"
        );

        System.out.println(
                "=========================================="
        );
    }
}
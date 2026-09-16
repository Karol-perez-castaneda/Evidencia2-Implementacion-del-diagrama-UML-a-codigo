
package biblioteca.servicio;

import biblioteca.modelo.Prestamo;
import biblioteca.modelo.Usuario;
import biblioteca.modelo.Libro;
import biblioteca.modelo.Autor;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Usuario> usuarios;
    private List<Prestamo> prestamos;

        public BibliotecaService() {

            libros = new ArrayList<>();
            autores = new ArrayList<>();
            usuarios = new ArrayList<>();
            prestamos = new ArrayList<>();
        }

        public void registrarLibro(Libro libro) {

            if (libro != null && !libros.contains(libro)) {
                libros.add(libro);
            }
        }

        public void registrarAutor(Autor autor) {

            if (autor != null && !autores.contains(autor)) {
                autores.add(autor);
            }
        }

        public void registrarUsuario(Usuario usuario) {

            if (usuario != null && !usuarios.contains(usuario)) {
                usuarios.add(usuario);
            }
        }

        public void registrarPrestamo(Prestamo prestamo) {

            if (prestamo != null
                    && !prestamos.contains(prestamo)) {

                prestamos.add(prestamo);

                prestamo.registrar();
            }
        }

        public List<Libro> getLibros() {
            return libros;
        }

        public List<Autor> getAutores() {
            return autores;
        }

        public List<Usuario> getUsuarios() {
            return usuarios;
        }

        public List<Prestamo> getPrestamos() {
            return prestamos;
        }
    }


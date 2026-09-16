
package biblioteca.modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Autor {
    
    private int idAutor;
    private String nombre;
    private String nacionalidad;
    private Date fechaNacimiento;

    // Agregación: un autor puede tener varios libros
    private List<Libro> libros;

   public Autor(int idAutor, String nombre, String nacionalidad,Date fechaNacimiento) {

            this.idAutor = idAutor;
            this.nombre = nombre;
            this.nacionalidad = nacionalidad;
            this.fechaNacimiento = fechaNacimiento;
            this.libros = new ArrayList<>();
        }

        public void escribirLibro() {
            System.out.println(
                    nombre + " tiene "
                    + libros.size()
                    + " libro(s) registrado(s)."
            );
        }

        public void agregarLibro(Libro libro) {

            if (libro != null && !libros.contains(libro)) {
                libros.add(libro);
            }
        }

        public String obtenerInfo() {

            return "ID: " + idAutor
                    + " | Autor: " + nombre
                    + " | Nacionalidad: " + nacionalidad
                    + " | Cantidad de libros: " + libros.size();
        }

        public int getIdAutor() {
            return idAutor;
        }

        public void setIdAutor(int idAutor) {
            this.idAutor = idAutor;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getNacionalidad() {
            return nacionalidad;
        }

        public void setNacionalidad(String nacionalidad) {
            this.nacionalidad = nacionalidad;
        }

        public Date getFechaNacimiento() {
            return fechaNacimiento;
        }

        public void setFechaNacimiento(Date fechaNacimiento) {
            this.fechaNacimiento = fechaNacimiento;
        }

        public List<Libro> getLibros() {
            return libros;
        }
    }

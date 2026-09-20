
package biblioteca.modelo;

import biblioteca.servicio.EstadoDisponibilidad;


public class Libro {
    
    private int idLibro;
        private String titulo;
        private String isbn;
        private int anioPublicacion;
        private EstadoDisponibilidad estado;

        public Libro(int idLibro, String titulo, String isbn,int anioPublicacion) {

            this.idLibro = idLibro;
            this.titulo = titulo;
            this.isbn = isbn;
            this.anioPublicacion = anioPublicacion;
            this.estado = EstadoDisponibilidad.DISPONIBLE;
        }

        public void prestar() {

            if (estado == EstadoDisponibilidad.DISPONIBLE) {

                estado = EstadoDisponibilidad.PRESTADO;

                System.out.println(
                        "El libro \"" + titulo
                        + "\" fue prestado correctamente."
                );

            } else {

                System.out.println(
                        "El libro \"" + titulo
                        + "\" no está disponible."
                );
            }
        }

        // Sobrecarga
        public void actualizarEstado() {

            if (estado == EstadoDisponibilidad.PRESTADO) {
                estado = EstadoDisponibilidad.DISPONIBLE;
            }
        }

        // Sobrecarga
        public void actualizarEstado(
                EstadoDisponibilidad nuevoEstado) {

            if (nuevoEstado != null) {
                estado = nuevoEstado;
            }
        }

        public boolean estaDisponible() {
            return estado == EstadoDisponibilidad.DISPONIBLE;
        }

        public String obtenerInfo() {

            return "ID: " + idLibro
                    + " | Título: " + titulo
                    + " | ISBN: " + isbn
                    + " | Año: " + anioPublicacion
                    + " | Estado: " + estado;
        }

        public int getIdLibro() {
            return idLibro;
        }

        public void setIdLibro(int idLibro) {
            this.idLibro = idLibro;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public int getAnioPublicacion() {
            return anioPublicacion;
        }

        public void setAnioPublicacion(int anioPublicacion) {
            this.anioPublicacion = anioPublicacion;
        }

        public EstadoDisponibilidad getEstado() {
            return estado;
        }

        public void setEstado(EstadoDisponibilidad estado) {
            this.estado = estado;
        }
    }

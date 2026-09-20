
package biblioteca.modelo;

import biblioteca.servicio.EstadoDisponibilidad;

public class LibroDigital extends Libro {

        private String formato;
        private double tamanoArchivo;
        private String urlDescarga;
        private boolean protegido;

        public LibroDigital(
                int idLibro,
                String titulo,
                String isbn,
                int anioPublicacion,
                String formato,
                double tamanoArchivo,
                String urlDescarga,
                boolean protegido) {

            super(
                    idLibro,
                    titulo,
                    isbn,
                    anioPublicacion
            );

            this.formato = formato;
            this.tamanoArchivo = tamanoArchivo;
            this.urlDescarga = urlDescarga;
            this.protegido = protegido;
        }

        public void descargar() {

            System.out.println(
                    "Descargando libro digital: "
                    + getTitulo()
            );

            System.out.println(
                    "URL: " + urlDescarga
            );
        }

        public void leerEnLinea() {

            System.out.println(
                    "Leyendo en línea: "
                    + getTitulo()
            );
        }

        // Sobrescritura
        @Override
        public void prestar() {

            if (estaDisponible()) {

                setEstado(
                        EstadoDisponibilidad.PRESTADO
                );

                System.out.println(
                        "Acceso al libro digital \""
                        + getTitulo()
                        + "\" habilitado."
                );

            } else {

                System.out.println(
                        "El libro digital \""
                        + getTitulo()
                        + "\" no está disponible."
                );
            }
        }

        // Sobrescritura
        @Override
        public String obtenerInfo() {

            return super.obtenerInfo()
                    + " | Formato: " + formato
                    + " | Tamaño: " + tamanoArchivo + " MB"
                    + " | Protegido: " + protegido;
        }

        public String getFormato() {
            return formato;
        }

        public void setFormato(String formato) {
            this.formato = formato;
        }

        public double getTamanoArchivo() {
            return tamanoArchivo;
        }

        public void setTamanoArchivo(double tamanoArchivo) {
            this.tamanoArchivo = tamanoArchivo;
        }

        public String getUrlDescarga() {
            return urlDescarga;
        }

        public void setUrlDescarga(String urlDescarga) {
            this.urlDescarga = urlDescarga;
        }

        public boolean isProtegido() {
            return protegido;
        }

        public void setProtegido(boolean protegido) {
            this.protegido = protegido;
        }
    }
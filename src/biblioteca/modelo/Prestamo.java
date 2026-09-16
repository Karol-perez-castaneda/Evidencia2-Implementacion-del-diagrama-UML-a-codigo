
package biblioteca.modelo;

import biblioteca.servicio.EstadoDisponibilidad;
import java.util.Date;


public class Prestamo {
    
    private int idPrestamo;
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Date fechaDevolucionReal;
    private String estado;

    // Asociación con Usuario
    private Usuario usuario;

        // Asociación con Libro
    private Libro libro;

    public Prestamo(
        int idPrestamo,
        Date fechaPrestamo,
        Date fechaDevolucion,
        Usuario usuario,
        Libro libro) {

            this.idPrestamo = idPrestamo;
            this.fechaPrestamo = fechaPrestamo;
            this.fechaDevolucion = fechaDevolucion;
            this.usuario = usuario;
            this.libro = libro;
            this.estado = "ACTIVO";
        }

        public void registrar() {

            if (usuario == null || libro == null) {

                System.out.println(
                        "No se puede registrar el préstamo."
                );

                return;
            }

            if (!libro.estaDisponible()) {

                System.out.println(
                        "El libro no está disponible."
                );

                return;
            }

            libro.prestar();

            estado = "ACTIVO";

            usuario.agregarPrestamo(this);

            System.out.println(
                    "Préstamo registrado para: "
                    + usuario.getNombre()
            );
        }

        // Sobrecarga
        public void registrar(Date nuevaFechaDevolucion) {

            this.fechaDevolucion = nuevaFechaDevolucion;

            registrar();
        }

        public void devolver() {

            if (libro == null) {
                return;
            }

            libro.setEstado(
                    EstadoDisponibilidad.DISPONIBLE
            );

            fechaDevolucionReal = new Date();

            estado = "DEVUELTO";

            System.out.println(
                    "Libro devuelto correctamente."
            );
        }

        public int calcularDiasAtraso() {

            if (fechaDevolucion == null
                    || fechaDevolucionReal == null) {

                return 0;
            }

            long diferencia =
                    fechaDevolucionReal.getTime()
                    - fechaDevolucion.getTime();

            long dias =
                    diferencia / (1000L * 60 * 60 * 24);

            return dias > 0 ? (int) dias : 0;
        }

        public int getIdPrestamo() {
            return idPrestamo;
        }

        public void setIdPrestamo(int idPrestamo) {
            this.idPrestamo = idPrestamo;
        }

        public Date getFechaPrestamo() {
            return fechaPrestamo;
        }

        public void setFechaPrestamo(Date fechaPrestamo) {
            this.fechaPrestamo = fechaPrestamo;
        }

        public Date getFechaDevolucion() {
            return fechaDevolucion;
        }

        public void setFechaDevolucion(Date fechaDevolucion) {
            this.fechaDevolucion = fechaDevolucion;
        }

        public Date getFechaDevolucionReal() {
            return fechaDevolucionReal;
        }

        public void setFechaDevolucionReal(
                Date fechaDevolucionReal) {

            this.fechaDevolucionReal = fechaDevolucionReal;
        }

        public String getEstado() {
            return estado;
        }

        public void setEstado(String estado) {
            this.estado = estado;
        }

        public Usuario getUsuario() {
            return usuario;
        }

        public void setUsuario(Usuario usuario) {
            this.usuario = usuario;
        }

        public Libro getLibro() {
            return libro;
        }

        public void setLibro(Libro libro) {
            this.libro = libro;
        }
    }
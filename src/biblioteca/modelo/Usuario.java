
package biblioteca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private int idUsuario;
    private String nombre;
    private String documento;
    private String tipoUsuario;
    private List<Prestamo> prestamos;

public Usuario(int idUsuario, String nombre, String documento,String tipoUsuario) {

            this.idUsuario = idUsuario;
            this.nombre = nombre;
            this.documento = documento;
            this.tipoUsuario = tipoUsuario;
            this.prestamos = new ArrayList<>();
        }

        public void registrar() {
            System.out.println(
                    "Usuario registrado correctamente: " + nombre
            );
        }

        public void agregarPrestamo(Prestamo prestamo) {
            if (prestamo != null && !prestamos.contains(prestamo)) {
                prestamos.add(prestamo);
            }
        }

        public String obtenerInfo() {
            return "ID: " + idUsuario
                    + " | Nombre: " + nombre
                    + " | Documento: " + documento
                    + " | Tipo: " + tipoUsuario;
        }

        public int getIdUsuario() {
            return idUsuario;
        }

        public void setIdUsuario(int idUsuario) {
            this.idUsuario = idUsuario;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getDocumento() {
            return documento;
        }

        public void setDocumento(String documento) {
            this.documento = documento;
        }

        public String getTipoUsuario() {
            return tipoUsuario;
        }

        public void setTipoUsuario(String tipoUsuario) {
            this.tipoUsuario = tipoUsuario;
        }

        public List<Prestamo> getPrestamos() {
            return prestamos;
        }
    }
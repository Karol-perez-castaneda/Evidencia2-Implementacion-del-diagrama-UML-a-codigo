# EA2 - Implementación del Diagrama UML a Codigo

## Sistema de Biblioteca 


## Información de la actividad

**Tema:** Sistema de Biblioteca

**Asignatura:** PROGRAMACIÓN II: ORIENTADA A OBJETOS AVANZADA - PREICA2602B010093

**Docente:** BORIS ALBERTO SALLEG

**Grupo:** 7

**Fecha:** 12/09/2026

---


## Integrantes

1. EMILSE CAVADIA TORDECILLA
2. CRISTIAN CAMILO DEOSSA BOLIVAR
3. JOSE WILBER MURILLO MURILLO
4. KAROL LICETH PEREZ CASTAÑEDA
5. NICOLE VALENTINA QUEVEDO FRANCO


---

# 1. Descripción del proyecto

Este proyecto corresponde a la **Actividad Evaluativa 2 (EA2)** de la asignatura Programación II: Orientada a Objetos Avanzada.

El proyecto consiste en implementar en lenguaje **Java** el diagrama de clases UML realizado previamente para un **Sistema de Biblioteca**.

El sistema permite representar diferentes elementos de una biblioteca, como usuarios, autores, libros, libros digitales y préstamos.

Durante la implementación se aplican conceptos de Programación Orientada a Objetos, como:

- Encapsulamiento.
- Abstracción.
- Herencia.
- Polimorfismo.
- Sobrecarga.
- Sobrescritura de métodos.
- Asociación.
- Agregación.
- Uso de listas (`List` y `ArrayList`).
- Principios SOLID.

---

# 2. Objetivo general

Implementar en lenguaje Java el diagrama de clases UML del Sistema de Biblioteca, aplicando los principales conceptos de Programación Orientada a Objetos y buenas prácticas de diseño de software.

---

# 3. Objetivos específicos

- Traducir al lenguaje Java las clases, atributos y métodos definidos en el diagrama UML.
- Aplicar el encapsulamiento mediante atributos privados y métodos getters y setters.
- Implementar la relación de herencia entre `Libro` y `LibroDigital`.
- Aplicar polimorfismo utilizando objetos de diferentes tipos mediante una referencia de la clase `Libro`.
- Implementar sobrecarga y sobrescritura de métodos.
- Representar las relaciones entre `Autor`, `Libro`, `Usuario` y `Prestamo`.
- Utilizar listas para representar relaciones de varios objetos.
- Aplicar al menos tres principios SOLID.
- Comprobar el funcionamiento del sistema mediante una clase `Main`.
- Utilizar Git y GitHub para evidenciar el trabajo colaborativo del grupo.

---

# 4. Tecnologías utilizadas

- **Lenguaje:** Java
- **JDK:** Java Development Kit
- **IDE:** NetBeans / Visual Studio Code
- **Control de versiones:** Git
- **Repositorio:** GitHub
- **Paradigma:** Programación Orientada a Objetos

---

# 5. Estructura del proyecto

```text
EA2_Biblioteca_Java/
│
├── src/
│   │
│   ├── modelo/
│   │   ├── Autor.java
│   │   ├── EstadoDisponibilidad.java
│   │   ├── Libro.java
│   │   ├── LibroDigital.java
│   │   ├── Prestamo.java
│   │   └── Usuario.java
│   │
│   ├── servicio/
│   │   └── BibliotecaService.java
│   │
│   └── main/
│       └── Main.java
│
├── README.md
└── .gitignore
```

---

# 6. Descripción de las clases

## Usuario

La clase `Usuario` representa a las personas que utilizan el sistema de biblioteca.

Contiene los siguientes atributos:

```text
idUsuario
nombre
documento
tipoUsuario
```

También contiene los métodos:

```text
registrar()
obtenerInfo()
```

Los atributos están definidos como `private`, aplicando el principio de encapsulamiento.

---

## Autor

La clase `Autor` representa a los autores de los libros.

Sus atributos son:

```text
idAutor
nombre
nacionalidad
fechaNacimiento
```

Sus principales métodos son:

```text
escribirLibro()
obtenerInfo()
```

Además, contiene una lista de libros:

```java
private List<Libro> libros;
```

Esto permite representar la relación entre un autor y varios libros.

---

## Libro

La clase `Libro` representa un libro dentro de la biblioteca.

Sus atributos son:

```text
idLibro
titulo
isbn
añoPublicacion
estado
```

Sus métodos principales son:

```text
prestar()
actualizarEstado()
obtenerInfo()
```

El estado del libro se controla mediante el enumerado:

```java
EstadoDisponibilidad
```

---

## LibroDigital

La clase `LibroDigital` representa un libro en formato digital.

Esta clase hereda de `Libro`:

```java
public class LibroDigital extends Libro
```

Además de los atributos heredados, tiene:

```text
formato
tamañoArchivo
urlDescarga
protegido
```

Sus métodos principales son:

```text
descargar()
leerEnLinea()
```

También sobrescribe algunos métodos de la clase `Libro`.

---

## Prestamo

La clase `Prestamo` representa el préstamo de un libro a un usuario.

Sus atributos son:

```text
idPrestamo
fechaPrestamo
fechaDevolucion
fechaDevolucionReal
estado
```

Además, se relaciona con:

```text
Usuario
Libro
```

Sus métodos principales son:

```text
registrar()
devolver()
calcularDiasAtraso()
```

También se implementó una sobrecarga del método `registrar()`.

---

## EstadoDisponibilidad

`EstadoDisponibilidad` es un `enum` que permite representar los diferentes estados de un libro.

Los estados definidos son:

```java
DISPONIBLE
PRESTADO
RESERVADO
EN_MANTENIMIENTO
```

Esto permite controlar de manera sencilla la disponibilidad de los libros.

---

## BibliotecaService

La clase `BibliotecaService` permite centralizar algunas operaciones generales del sistema.

Mantiene listas de:

```text
Libros
Autores
Usuarios
Prestamos
```

De esta manera se separan algunas operaciones generales de las clases que representan los objetos del sistema.

---

# 7. Relaciones del diagrama UML

El código implementa las principales relaciones definidas en el diagrama de clases.

## Asociación Usuario - Préstamo

Un usuario puede realizar varios préstamos.

En Java esta relación se representa mediante la referencia al objeto `Usuario` dentro de `Prestamo`:

```java
private Usuario usuario;
```

---

## Asociación Préstamo - Libro

Cada préstamo utiliza un libro.

En Java:

```java
private Libro libro;
```

Esto permite saber qué libro está relacionado con cada préstamo.

---

## Agregación Autor - Libro

En el diagrama UML la relación entre `Autor` y `Libro` está representada mediante un rombo blanco, que corresponde a una **agregación**.

Un autor puede estar relacionado con cero o muchos libros.

En Java se representa utilizando una lista:

```java
private List<Libro> libros;
```

Y se utiliza:

```java
public void agregarLibro(Libro libro)
```

para agregar libros al autor.

---

## Herencia Libro - LibroDigital

`LibroDigital` hereda de `Libro`.

La implementación es:

```java
public class LibroDigital extends Libro
```

Esto permite reutilizar las características de `Libro` y agregar características propias de los libros digitales.

---

## Estado del libro

La clase `Libro` utiliza el enumerado `EstadoDisponibilidad`:

```java
private EstadoDisponibilidad estado;
```

Esto permite que un libro pueda estar:

```text
DISPONIBLE
PRESTADO
RESERVADO
EN_MANTENIMIENTO
```

---

# 8. Pilares de la Programación Orientada a Objetos

## Encapsulamiento

Los atributos de las clases se declararon como `private`.

Ejemplo:

```java
private int idLibro;
private String titulo;
private String isbn;
```

Para acceder a estos atributos se utilizan métodos getters y setters.

Esto ayuda a proteger la información interna de los objetos.

---

## Abstracción

El sistema representa elementos del mundo real mediante clases.

Por ejemplo:

```text
Usuario
Autor
Libro
LibroDigital
Prestamo
```

Cada clase representa un elemento específico del sistema de biblioteca.

---

## Herencia

La clase `LibroDigital` hereda de `Libro`:

```java
public class LibroDigital extends Libro
```

Esto permite reutilizar características y comportamientos de la clase principal.

---

## Polimorfismo

El polimorfismo se demuestra utilizando una lista de tipo `Libro` que puede contener objetos `Libro` y `LibroDigital`.

Ejemplo:

```java
List<Libro> listaLibros = new ArrayList<>();

listaLibros.add(libro);
listaLibros.add(libroDigital);
```

Posteriormente se puede recorrer la lista:

```java
for (Libro item : listaLibros) {
    item.prestar();
}
```

Aunque la referencia es de tipo `Libro`, cuando encuentra un `LibroDigital`, se ejecuta el comportamiento sobrescrito de esa clase.

---

# 9. Sobrecarga de métodos

La sobrecarga se implementó en la clase `Prestamo`.

Existe un método:

```java
public void registrar()
```

y otra versión:

```java
public void registrar(Date nuevaFechaDevolucion)
```

Ambos tienen el mismo nombre, pero reciben diferentes parámetros.

Esto demuestra la sobrecarga de métodos en Java.

---

# 10. Sobrescritura de métodos

La clase `LibroDigital` sobrescribe métodos de `Libro`.

Por ejemplo:

```java
@Override
public void prestar()
```

También se sobrescribe:

```java
@Override
public String obtenerInfo()
```

La anotación `@Override` indica que el método está reemplazando el comportamiento heredado de la clase padre.

---

# 11. Principios SOLID aplicados

## 1. SRP - Principio de Responsabilidad Única

Cada clase tiene una responsabilidad clara.

Por ejemplo:

- `Usuario` maneja la información del usuario.
- `Autor` maneja la información del autor y sus libros.
- `Libro` maneja la información y estado del libro.
- `Prestamo` maneja la información del préstamo.
- `BibliotecaService` maneja operaciones generales del sistema.

De esta manera se evita colocar toda la lógica del programa en una sola clase.

---

## 2. OCP - Principio Abierto/Cerrado

La clase `Libro` puede ampliarse mediante nuevas clases sin necesidad de modificar directamente su funcionamiento principal.

Por ejemplo:

```java
public class LibroDigital extends Libro
```

De esta manera se puede agregar un nuevo tipo de libro aprovechando las características existentes.

---

## 3. LSP - Principio de Sustitución de Liskov

Un objeto `LibroDigital` puede utilizarse en lugares donde el programa espera un objeto `Libro`.

Por ejemplo:

```java
List<Libro> libros = new ArrayList<>();
```

La lista puede contener:

```text
Libro
LibroDigital
```

Esto demuestra que la clase hija puede ser utilizada como la clase padre.

---

# 12. Ejecución del programa

La clase principal del proyecto es:

```text
Main.java
```

Al ejecutar el programa se crean diferentes objetos y se prueba su funcionamiento.

Entre las operaciones realizadas se encuentran:

1. Creación de un autor.
2. Creación de un libro.
3. Creación de un libro digital.
4. Relación entre autor y libros.
5. Creación de un usuario.
6. Registro de un préstamo.
7. Cambio del estado del libro.
8. Devolución del libro.
9. Cálculo de días de atraso.
10. Descarga y lectura del libro digital.
11. Demostración del polimorfismo.

---

# 13. Ejemplo de salida del programa

Al ejecutar `Main.java` se obtiene una salida similar a:

```text
======================================
      SISTEMA DE BIBLIOTECA
======================================

--- AUTORES ---
Autor: Gabriel García Márquez | Nacionalidad: Colombiana | Libros: 2

--- LIBROS ---
Libro: Cien años de soledad | ISBN: 978-0307474728 | Año: 1967
Libro: Introducción a Java | ISBN: 978-0000000000 | Año: 2025

--- POLIMORFISMO ---
El libro "Cien años de soledad" fue prestado.
Acceso al libro digital "Introducción a Java" habilitado.

--- PRÉSTAMO ---
Usuario registrado: Usuario de prueba
Préstamo registrado para: Usuario de prueba

--- DEVOLUCIÓN ---
Libro devuelto correctamente.

--- LIBRO DIGITAL ---
Descargando el libro digital: Introducción a Java
Leyendo en línea: Introducción a Java

======================================
Programa ejecutado correctamente.
======================================
```

---

# 14. Pruebas realizadas

Para comprobar el funcionamiento del sistema se realizaron las siguientes pruebas:

| Prueba | Resultado |
|---|---|
| Crear usuario | ✅ Correcto |
| Registrar autor | ✅ Correcto |
| Registrar libro | ✅ Correcto |
| Registrar libro digital | ✅ Correcto |
| Relacionar autor con libros | ✅ Correcto |
| Realizar préstamo | ✅ Correcto |
| Cambiar estado del libro | ✅ Correcto |
| Devolver libro | ✅ Correcto |
| Calcular días de atraso | ✅ Correcto |
| Descargar libro digital | ✅ Correcto |
| Leer libro digital en línea | ✅ Correcto |
| Demostrar polimorfismo | ✅ Correcto |
| Sobrecarga de métodos | ✅ Correcto |
| Sobrescritura de métodos | ✅ Correcto |

---

# 15. Evidencias de ejecución

A continuación se deben agregar las capturas de pantalla de la ejecución del programa.

### Evidencia 1 - Ejecución de Main

**Insertar aquí captura de pantalla.**

---

### Evidencia 2 - Registro y préstamo

**Insertar aquí captura de pantalla.**

---

### Evidencia 3 - Devolución y libro digital

**Insertar aquí captura de pantalla.**

---

# 16. Repositorio GitHub

El proyecto se encuentra disponible en el siguiente repositorio:

**Repositorio:**  
https://github.com/Karol-perez-castaneda/Evidencia2-Implementacion-del-diagrama-UML-a-codigo.git

---

# 17. Video de sustentación

En el video de sustentación se explica:

- El funcionamiento general del sistema.
- Las clases implementadas.
- Las relaciones entre las clases.
- El encapsulamiento.
- La herencia.
- El polimorfismo.
- La sobrecarga.
- La sobrescritura.
- Los principios SOLID aplicados.
- La ejecución del programa mediante `Main`.

**Video de sustentación:**  
LINK VIDEO: https://drive.google.com/file/d/1zPtsoDcpSJHn4EJTrtdr3RzqJcFzmbBE/view?usp=
drive_link

---

# 18. Conclusión

La implementación del Sistema de Biblioteca permitió llevar a la práctica el diseño realizado mediante UML y comprender cómo las clases, atributos, métodos y relaciones se pueden representar en Java.

Durante el desarrollo se aplicaron los principales conceptos de Programación Orientada a Objetos, especialmente el encapsulamiento, la herencia, el polimorfismo, la sobrecarga y la sobrescritura.

También se aplicaron los principios SOLID de responsabilidad única, abierto/cerrado y sustitución de Liskov, buscando que el código estuviera organizado y fuera fácil de comprender y mantener.

Finalmente, el uso de Git y GitHub permitió trabajar de manera colaborativa y dejar evidencia de los aportes realizados por cada integrante del grupo.

---

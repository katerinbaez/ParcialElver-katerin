# 🎓 Sistema de Gestión de Proyectos de Grado - UTS

Este proyecto final es un sistema desarrollado para la **gestión de proyectos de grado en la Universidad de Santander (UTS)**.  

El sistema permite registrar, asignar y gestionar los proyectos de grado de los estudiantes, integrando roles como coordinador, director, evaluador y administrador.

---

## 📌 Estado del Proyecto

✅ Proyecto finalizado
✅ Proyecto Desplegado

El sistema se encuentra completamente desarrollado e implementado. Proporciona una interfaz web con Thymeleaf, lógica de negocio con Spring y persistencia con JPA sobre H2.

---

## 🚀 Tecnologías Utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Spring Data JPA
- H2 Database
- Thymeleaf
- Bootstrap 5
- Maven

---

## 📚 Funcionalidades Principales

- Registro de estudiantes, docentes y coordinadores
- Registro de proyectos de grado por parte de estudiantes
- Asignación de director y evaluadores por parte del coordinador
- Aprobación, observación y calificación del anteproyecto
- Consulta del estado del proyecto por todos los roles
- Reportes académicos y administrativos
- Autenticación y control de acceso por rol

---

## 🏗️ Estructura del Proyecto

```plaintext
src
└── main
    ├── java
    │   └── com
    │       └── uts
    │           └── proyectogrado
    │               ├── controller          # Controladores del sistema
    │               ├── model               # Entidades JPA
    │               ├── repository          # Interfaces de acceso a datos
    │               ├── service             # Lógica de negocio
    │               └── ProyectoGradoApplication.java  # Clase principal
    └── resources
        ├── templates                      # Vistas Thymeleaf
        ├── static                         # CSS, JS, imágenes
        └── application.properties         # Configuración general
```
---
## ⚙️ Configuración de la Base de Datos
El sistema utiliza H2 por defecto. Puedes acceder a la consola web para visualizar las tablas y datos en ejecución.
```
spring.datasource.url=jdbc:h2:mem:proyectosUts
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
---

## 👥 Roles del Sistema
- Administrador: CRUD de usuarios (docentes, coordinadores, estudiantes).

- Coordinador: Propone ideas, asigna directores/evaluadores, gestiona estados.

- Director: Supervisa proyectos, califica anteproyectos.

- Evaluador: Revisa, observa y califica proyectos asignados.

- Estudiante: Registra su proyecto, su compañero, consulta estado y calificaciones.

---

## 🚀 ¿Cómo ejecutar el proyecto?
Pasos claros para ejecutar el proyecto localmente:

1. Clonar el repositorio.

2. Abrirlo en un IDE.

3. Ejecutar la clase principal.

4. Acceder a http://localhost:PORT.

5. Accede a la consola: http://localhost:PORT/h2-console



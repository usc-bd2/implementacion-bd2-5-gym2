# Proyecto BDII — Sistema de Gestión de Gimnasio

## Descripción

Aplicación de escritorio en Java para la gestión de un gimnasio. El sistema permite realizar tanto operaciones de administración como operaciones de usuario, incluyendo gestión de clases, sesiones, salas, equipamiento, productos, reservas y valoraciones.

## Funcionalidades principales

### Administración:

- Gestión de usuarios registrados.
- Gestión de clases y actividades ofertadas.
- Programación y mantenimiento de sesiones.
- Administración de salas y equipamiento.
- Gestión de trabajadores y asignaciones.
- Control de productos disponibles.
- Supervisión de reservas y uso de instalaciones.
- Consulta de informes de ocupación y funcionamiento.

### Usuarios:

- Consulta de clases, sesiones y disponibilidad.
- Gestión de reservas de plazas.
- Consulta de salas y equipamiento.
- Realización y seguimiento de pedidos de productos.
- Consulta y gestión de valoraciones sobre clases.
- Acceso al historial de actividad personal.
- Gestión de datos de perfil.

## Estructura del proyecto

La aplicación está desarrollada en Java siguiendo una arquitectura en capas que separa la presentación, la lógica de aplicación y el acceso a datos.

- **Aplicacion:** contiene la fachada principal del sistema, las entidades de dominio y los gestores de lógica.
- **BaseDatos:** contiene la conexión JDBC, la fachada de base de datos y los DAO con las operaciones SQL.
- **GUI:** contiene las ventanas y la interacción con el usuario.

```
├── README.md
├── init_db.bash                      // Script para inicializar la base de datos con los scripts SQL.
├── Gym.properties
├── lib
│   └── postgresql.jar
├── sql
│   ├── create.sql
│   ├── insertion.sql
│   └── reset.sql
└── src
    ├── Aplicacion
    │   ├── FachadaAplicacion.java    // Coordina la interacción entre la GUI y los gestores.
    │   ├── GestorEntidad.java        // Implementa la lógica de negocio para una entidad concreta.
    │   └── Entidad.java              // Clase que representa una entidad del dominio con sus atributos y métodos.
    ├── BaseDatos
    │   ├── AbstractDAO.java          // Centraliza el acceso a la conexión JDBC para todos los DAOs.
    │   ├── DAOEntidad.java           // Implementa las operaciones SQL para una entidad concreta.
    │   └── FachadaBaseDatos.java     // Gestiona la conexión con el servidor y la inicialización de los DAO.
    └── GUI
        ├── FachadaGUI.java           // Gestiona la interacción entre las ventanas y la lógica de aplicación.
        ├── VContenedor.java          // JFrame principal que actúa como contenedor de las demás ventanas.
        ├── VEntidad.form             // Diseño visual de la ventana generado por NetBeans.
        └── VEntidad.java             // Ventana específica para la gestión de una entidad.
```

## Requisitos

- Java JDK 17 o compatible
- PostgreSQL
- NetBeans (proyecto Java with Ant)
- Driver JDBC de PostgreSQL 

## Archivo de configuración

Debe existir un archivo `Gym.properties` en la raíz del proyecto con los parámetros del entorno correspondiente.

```
gestor=postgresql
servidor=localhost
puerto=5432
baseDatos=nombre_basedatos
usuario=usuario
clave=clave
```

## Inicializar proyecto

1. **Crear la base de datos PostgreSQL**. Puede utilizarse los parametros de conexión definidos en `Gym.properties` para crear la base de datos. De otra forma, se puede crear la base de datos manualmente y luego configurar `Gym.properties` para que apunte a ella.

2. Ejecutar el script `init_db.bash` para crear la base de datos y cargar los datos iniciales.
    ```
    chmod +x init_db.bash
    ./init_db.bash
    ``` 
3. Abrir el proyecto en NetBeans y seleccionar `Clean and Build` para compilar la aplicación.

4. Ejecutar la aplicación con `Run Project`.


## Autores:
- Rañó Myro, Maria, maria.rano@rai.usc.es
- Rosas Archiveque, Amado, amado.rosas@rai.usc.es
# Sistema Donde Beto - JDBC Inventario

Proyecto desarrollado en Java utilizando JDBC y MySQL como parte de la evidencia GA7-220501096-AA2-EV01 del SENA.

## Tecnologías utilizadas

- Java JDK 17
- NetBeans
- MySQL Workbench
- JDBC
- Git y GitHub

## Funcionalidades implementadas

Se desarrolló un módulo de inventario conectado a una base de datos MySQL utilizando JDBC.

El sistema cuenta con operaciones CRUD:

- CREATE -> Insertar productos
- READ -> Consultar productos
- UPDATE -> Actualizar stock
- DELETE -> Eliminar productos

## Estructura del proyecto

El proyecto está organizado en paquetes:

- conexion
- modelos
- dao

## Base de datos

Se utilizó la base de datos `donde_beto`, basada en el proyecto original desarrollado previamente.

## Observaciones

- El método DELETE quedó comentado en el archivo Main para evitar eliminar registros cada vez que se ejecuta el programa.
- Se siguieron estándares básicos de nombramiento de variables, clases, métodos y paquetes.
- La conexión a MySQL se realizó utilizando JDBC.

## Autor

Sebastián González
SENA
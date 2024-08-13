# GymArena

GymArena por el momento es una aplicación de consola en Java diseñada para gestionar la base de datos de clientes de un gimnasio. La aplicación permite agregar, modificar, buscar y eliminar clientes, así como mostrar la lista de todos los clientes registrados.

## Funcionalidades

- Mostrar lista de clientes: Ver todos los clientes registrados.
- Buscar cliente: Encontrar un cliente por su ID único.
- Agregar nuevo cliente: Añadir un nuevo cliente a la base de datos con su nombre, apellido y tipo de membresía.
- Modificar cliente: Actualizar la información de un cliente existente.
- Eliminar cliente: Eliminar un cliente de la base de datos.

![image](https://github.com/user-attachments/assets/83eb8004-6af8-452d-a3ed-049ab7952c2e)

## Instalación

Para configurar y ejecutar el proyecto en tu máquina local, sigue estos pasos:

### Requisitos Previos

- **Java 17 o superior**: Asegúrate de tener instalada la versión correcta de Java.
- **Maven**: Utilizado para gestionar las dependencias del proyecto y construir el proyecto.
- **MySQL**: El sistema de base de datos utilizado para almacenar los datos de los clientes.

### Pasos

1. **Clonar el repositorio:**

    ```sh
    git clone <url-del-repositorio>
    cd GymArena
    ```

2. **Configurar la base de datos:**

    - Configura una base de datos MySQL llamada `gymarena`.
    - Actualiza los detalles de conexión a la base de datos en la clase `Conexion.java`:

    ```java
    String url = "jdbc:mysql://localhost:3306/gymarena";
    String usuario = "root"; // Tu usuario de MySQL
    String password = "root"; // Tu contraseña de MySQL
    ```

3. **Compilar el proyecto:**

    ```sh
    mvn clean install
    ```

4. **Ejecutar la aplicación:**

    - Ejecuta la aplicación desde la clase `GymArena`.
    - Sigue las instrucciones en pantalla para utilizar las funcionalidades del sistema.

## Uso

Al iniciar la aplicación, se mostrará un menú con las siguientes opciones:

- **Mostrar lista de clientes**: Muestra todos los clientes registrados en la base de datos.
- **Buscar cliente**: Busca un cliente por su ID único.
- **Agregar usuario**: Agrega un nuevo cliente al sistema.
- **Modificar usuario**: Modifica los datos de un cliente existente.
- **Eliminar usuario**: Elimina un cliente de la base de datos.

package Modelo; // Define el paquete al que pertenece esta clase

import java.sql.Connection; // Importa la clase Connection para manejar la conexión a la base de datos
import java.sql.DriverManager; // Importa la clase DriverManager para obtener la conexión a la base de datos
import java.sql.SQLException; // Importa la clase SQLException para manejar excepciones SQL

public class Conexion {
    
    Connection con; // Objeto Connection para establecer la conexión

    // Método para obtener la conexión a la base de datos
    public Connection getConnection() {
        try {
            // URL de la base de datos incluyendo el servidor, puerto, nombre de la base de datos y zona horaria
            String myBD = "jdbc:mysql://localhost:3306/proyectod?serverTimezone=UTC";
            // Obtiene la conexión a la base de datos con el usuario "root" y contraseña vacía
            con = DriverManager.getConnection(myBD, "root", "");
            return con; // Retorna la conexión si es exitosa
        } catch (SQLException e) {
            // Muestra un mensaje de error en la consola en caso de excepción
            System.out.println(e.toString());
        }
        return null; // Retorna null si la conexión falla
    }
}


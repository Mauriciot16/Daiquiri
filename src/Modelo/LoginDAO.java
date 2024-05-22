
package Modelo; // Define el paquete al que pertenece esta clase

import java.sql.Connection; // Importa la clase Connection para manejar la conexión a la base de datos
import java.sql.PreparedStatement; // Importa la clase PreparedStatement para manejar sentencias SQL preparadas
import java.sql.ResultSet; // Importa la clase ResultSet para manejar los resultados de las consultas SQL
import java.sql.SQLException; // Importa la clase SQLException para manejar excepciones SQL
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas
import java.util.List; // Importa la clase List para usar listas

public class LoginDAO {
    // Atributos para la conexión y manipulación de la base de datos
    Connection con; // Objeto de conexión a la base de datos
    PreparedStatement ps; // Objeto para sentencias SQL preparadas
    ResultSet rs; // Objeto para almacenar los resultados de las consultas SQL
    Conexion cn = new Conexion(); // Instancia de la clase Conexion para obtener la conexión

    // Método para verificar el login del usuario
    public login log(String correo, String pass) {
        login l = new login(); // Crea una nueva instancia de la clase login
        String sql = "SELECT * FROM usuarios WHERE correo = ? AND pass = ?"; // Sentencia SQL para buscar un usuario con correo y contraseña
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la sentencia SQL
            ps.setString(1, correo); // Establece el primer parámetro (correo)
            ps.setString(2, pass); // Establece el segundo parámetro (contraseña)
            rs = ps.executeQuery(); // Ejecuta la consulta y obtiene los resultados
            if (rs.next()) { // Si encuentra un registro
                // Establece los valores del objeto login con los datos obtenidos de la base de datos
                l.setId(rs.getInt("id"));
                l.setNombre(rs.getString("nombre"));
                l.setCorreo(rs.getString("correo"));
                l.setPass(rs.getString("pass"));
                l.setRol(rs.getString("rol"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime cualquier error que ocurra durante la consulta
        }
        return l; // Retorna el objeto login con los datos del usuario
    }

    // Método para registrar un nuevo usuario en la base de datos
    public boolean Registrar(login reg) {
        String sql = "INSERT INTO usuarios (nombre, correo, pass, rol) VALUES (?,?,?,?)"; // Sentencia SQL para insertar un nuevo usuario
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la sentencia SQL
            // Establece los valores de los parámetros en la sentencia SQL
            ps.setString(1, reg.getNombre());
            ps.setString(2, reg.getCorreo());
            ps.setString(3, reg.getPass());
            ps.setString(4, reg.getRol());
            ps.execute(); // Ejecuta la inserción
            return true; // Retorna true si la inserción fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime cualquier error que ocurra durante la inserción
            return false; // Retorna false si hubo un error
        }
    }

    // Método para listar todos los usuarios de la base de datos
    public List ListarUsuarios() {
        List<login> Lista = new ArrayList(); // Crea una lista para almacenar los usuarios
        String sql = "SELECT * FROM usuarios"; // Sentencia SQL para seleccionar todos los usuarios
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la sentencia SQL
            rs = ps.executeQuery(); // Ejecuta la consulta y obtiene los resultados
            while (rs.next()) { // Recorre los resultados
                login lg = new login(); // Crea una nueva instancia de la clase login
                // Establece los valores del objeto login con los datos obtenidos de la base de datos
                lg.setId(rs.getInt("id"));
                lg.setNombre(rs.getString("nombre"));
                lg.setCorreo(rs.getString("correo"));
                lg.setRol(rs.getString("rol"));
                Lista.add(lg); // Añade el objeto login a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime cualquier error que ocurra durante la consulta
        }
        return Lista; // Retorna la lista de usuarios
    }
}

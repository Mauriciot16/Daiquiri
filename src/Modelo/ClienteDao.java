package Modelo; // Define el paquete al que pertenece esta clase

import java.sql.Connection; // Importa la clase Connection para manejar la conexión a la base de datos
import java.sql.PreparedStatement; // Importa la clase PreparedStatement para ejecutar consultas SQL precompiladas
import java.sql.ResultSet; // Importa la clase ResultSet para manejar los resultados de las consultas SQL
import java.sql.SQLException; // Importa la clase SQLException para manejar excepciones SQL
import java.util.ArrayList; // Importa la clase ArrayList para manejar listas dinámicas
import java.util.List; // Importa la clase List para definir listas
import javax.swing.JOptionPane; // Importa JOptionPane para mostrar cuadros de diálogo

/**
 *
 * @author jhony
 */
public class ClienteDao {
    
    // Atributos para manejar la conexión y las consultas SQL
    Conexion cn = new Conexion(); // Instancia de la clase Conexion para obtener la conexión a la base de datos
    Connection con; // Objeto Connection para establecer la conexión
    PreparedStatement ps; // Objeto PreparedStatement para ejecutar las consultas SQL
    ResultSet rs; // Objeto ResultSet para almacenar los resultados de las consultas

    // Método para registrar un nuevo cliente en la base de datos
    public boolean RegistrarCliente(Cliente cl){
        String sql = "INSERT INTO clientes (dni, nombre, telefono, direccion) VALUES (?,?,?,?)"; // Consulta SQL para insertar un cliente
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            // Establece los valores de los parámetros en la consulta SQL
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.execute(); // Ejecuta la consulta SQL
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            // Muestra un mensaje de error en caso de excepción
            JOptionPane.showMessageDialog(null, e.toString());
            return false; // Retorna false si la operación falló
        } finally {
            try {
                con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); // Muestra un mensaje de error en la consola
            }
        }
    }
    
    // Método para listar todos los clientes de la base de datos
    public List<Cliente> ListarCliente(){
        List<Cliente> ListaCl = new ArrayList<>(); // Crea una lista para almacenar los clientes
        String sql = "SELECT * FROM clientes"; // Consulta SQL para seleccionar todos los clientes
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            rs = ps.executeQuery(); // Ejecuta la consulta SQL y obtiene los resultados
            while (rs.next()) { // Itera sobre los resultados
                Cliente cl = new Cliente(); // Crea una nueva instancia de Cliente
                // Establece los valores de los atributos del cliente con los datos obtenidos
                cl.setId(rs.getInt("id"));
                cl.setDni(rs.getString("dni"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
                ListaCl.add(cl); // Agrega el cliente a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); // Muestra un mensaje de error en la consola
        }
        return ListaCl; // Retorna la lista de clientes
    }
    
    // Método para eliminar un cliente de la base de datos por su id
    public boolean EliminarCliente(int id){
        String sql = "DELETE FROM clientes WHERE id = ?"; // Consulta SQL para eliminar un cliente
        try {
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            ps.setInt(1, id); // Establece el valor del parámetro en la consulta SQL
            ps.execute(); // Ejecuta la consulta SQL
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Muestra un mensaje de error en la consola
            return false; // Retorna false si la operación falló
        } finally {
            try {
                con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException ex) {
                System.out.println(ex.toString()); // Muestra un mensaje de error en la consola
            }
        }
    }
    
    // Método para modificar los datos de un cliente en la base de datos
    public boolean ModificarCliente(Cliente cl){
        String sql = "UPDATE clientes SET dni=?, nombre=?, telefono=?, direccion=? WHERE id=?"; // Consulta SQL para actualizar un cliente
        try {
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            // Establece los valores de los parámetros en la consulta SQL
            ps.setString(1, cl.getDni());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion());
            ps.setInt(5, cl.getId());
            ps.execute(); // Ejecuta la consulta SQL
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Muestra un mensaje de error en la consola
            return false; // Retorna false si la operación falló
        } finally {
            try {
                con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); // Muestra un mensaje de error en la consola
            }
        }
    }
    
    // Método para buscar un cliente en la base de datos por su dni
    public Cliente Buscarcliente(int dni){
        Cliente cl = new Cliente(); // Crea una nueva instancia de Cliente
        String sql = "SELECT * FROM clientes WHERE dni = ?"; // Consulta SQL para buscar un cliente por su dni
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            ps.setInt(1, dni); // Establece el valor del parámetro en la consulta SQL
            rs = ps.executeQuery(); // Ejecuta la consulta SQL y obtiene los resultados
            if (rs.next()) { // Si se encuentra un resultado
                // Establece los valores de los atributos del cliente con los datos obtenidos
                cl.setId(rs.getInt("id"));
                cl.setNombre(rs.getString("nombre"));
                cl.setTelefono(rs.getString("telefono"));
                cl.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); // Muestra un mensaje de error en la consola
        }
        return cl; // Retorna el cliente encontrado
    }
}

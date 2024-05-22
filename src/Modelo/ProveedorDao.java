package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;
    
    // Método para registrar un proveedor en la base de datos
    public boolean RegistrarProveedor(Proveedor pr){
        String sql = "INSERT INTO proveedor(ruc, nombre, telefono, direccion) VALUES (?,?,?,?)";
        try {
           con = cn.getConnection(); // Obtiene la conexión a la base de datos
           ps = con.prepareStatement(sql); // Prepara la consulta SQL
           // Establece los valores de los parámetros en la consulta SQL
           ps.setString(1, pr.getRuc());
           ps.setString(2, pr.getNombre());
           ps.setString(3, pr.getTelefono());
           ps.setString(4, pr.getDireccion());
           ps.execute(); // Ejecuta la consulta SQL
           return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime el error en caso de excepción
            return false; // Retorna false si ocurre algún error
        } finally {
            try {
                con.close(); // Cierra la conexión con la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); // Imprime el error en caso de excepción al cerrar la conexión
            }
        }
    }
    
    // Método para listar todos los proveedores de la base de datos
    public List ListarProveedor(){
        List<Proveedor> Listapr = new ArrayList(); // Crea una lista para almacenar los proveedores
        String sql = "SELECT * FROM proveedor"; // Consulta SQL para obtener todos los proveedores
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            rs = ps.executeQuery(); // Ejecuta la consulta SQL y obtiene el resultado
            while (rs.next()) { // Itera sobre el resultado
                Proveedor pr = new Proveedor(); // Crea un objeto Proveedor
                // Establece los atributos del proveedor con los valores obtenidos de la consulta
                pr.setId(rs.getInt("id"));
                pr.setRuc(rs.getString("ruc"));
                pr.setNombre(rs.getString("nombre"));
                pr.setTelefono(rs.getString("telefono"));
                pr.setDireccion(rs.getString("direccion"));
                Listapr.add(pr); // Agrega el proveedor a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime el error en caso de excepción
        } finally {
            try {
                con.close(); // Cierra la conexión con la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); // Imprime el error en caso de excepción al cerrar la conexión
            }
        }
        return Listapr; // Retorna la lista de proveedores
    }
    
    // Método para eliminar un proveedor de la base de datos dado su ID
    public boolean EliminarProveedor(int id){
        String sql = "DELETE FROM proveedor WHERE id = ? "; // Consulta SQL para eliminar un proveedor por su ID
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            ps.setInt(1, id); // Establece el valor del parámetro en la consulta SQL
            ps.execute(); // Ejecuta la consulta SQL
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime el error en caso de excepción
            return false; // Retorna false si ocurre algún error
        } finally {
            try {
                con.close(); // Cierra la conexión con la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); // Imprime el error en caso de excepción al cerrar la conexión
            }
        }
    }
    
    // Método para modificar los datos de un proveedor en la base de datos
    public boolean ModificarProveedor(Proveedor pr){
        String sql = "UPDATE proveedor SET ruc=?, nombre=?, telefono=?, direccion=? WHERE id=?"; // Consulta SQL para modificar los datos de un proveedor
        try {
            con = cn.getConnection(); // Obtiene la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            // Establece los valores de los parámetros en la consulta SQL
            ps.setString(1, pr.getRuc());
            ps.setString(2, pr.getNombre());
            ps.setString(3, pr.getTelefono());
            ps.setString(4, pr.getDireccion());
            ps.setInt(5, pr.getId());
            ps.execute(); // Ejecuta la consulta SQL
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime el error en caso de excepción
            return false; // Retorna false si ocurre algún error
        } finally {
                 try {
                con.close(); // Cierra la conexión con la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); // Imprime el error en caso de excepción al cerrar la conexión
            }
        }
    }
}

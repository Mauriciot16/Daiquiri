
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase ProductosDao proporciona métodos para interactuar con la tabla "productos" en la base de datos.
 * Permite registrar, listar, eliminar y modificar productos en la base de datos.
 */
public class ProductosDao {
    Connection con; // Objeto Connection para la conexión a la base de datos
    Conexion cn = new Conexion(); // Instancia de la clase Conexion para establecer la conexión
    
    PreparedStatement ps; // Objeto PreparedStatement para ejecutar consultas preparadas
    ResultSet rs; // Objeto ResultSet para almacenar los resultados de las consultas
    
    /**
     * Registra un nuevo producto en la base de datos.
     * @param pro El producto a registrar.
     * @return true si el registro fue exitoso, false si ocurrió un error.
     */
    public boolean RegistrarProductos(Productos pro){
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?,?,?,?,?)"; // Consulta SQL para insertar un nuevo producto
        try {
            con = cn.getConnection(); // Establece la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            // Establece los parámetros de la consulta con los datos del producto
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.execute(); // Ejecuta la consulta
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime cualquier error SQL en la consola
            return false; // Retorna false si ocurrió un error
        }
    }
    
    /**
     * Obtiene una lista de todos los productos en la base de datos.
     * @return Una lista de objetos Productos que representan los productos en la base de datos.
     */
    public List ListarProductos(){
        List<Productos> Listapro = new ArrayList(); // Lista para almacenar los productos
        String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN productos p ON pr.id = p.proveedor ORDER BY p.id DESC"; // Consulta SQL para obtener los productos
        try {
            con = cn.getConnection(); // Establece la conexión a la base de datos
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            rs = ps.executeQuery(); // Ejecuta la consulta y obtiene los resultados
            // Itera sobre los resultados y crea objetos Productos con los datos obtenidos
            while (rs.next()) {               
                Productos pro = new Productos();
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setProveedor(rs.getInt("id_proveedor"));
                pro.setProveedorPro(rs.getString("nombre_proveedor"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
                Listapro.add(pro); // Agrega el producto a la lista
            }
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime cualquier error SQL en la consola
        } finally {
            try {
                con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException ex) {
                System.out.println(ex.toString()); // Imprime cualquier error de cierre de conexión en la consola
            }
        }
        return Listapro; // Retorna la lista de productos
    }
    
    /**
     * Elimina un producto de la base de datos.
     * @param id El ID del producto a eliminar.
     * @return true si la eliminación fue exitosa, false si ocurrió un error.
     */
    public boolean EliminarProductos(int id){
        String sql = "DELETE FROM productos WHERE id = ?"; // Consulta SQL para eliminar un producto por su ID
        try {
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            ps.setInt(1, id); // Establece el parámetro ID en la consulta
            ps.execute(); // Ejecuta la consulta
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime cualquier error SQL en la consola
            return false; // Retorna false si ocurrió un error
        } finally {
            try {
                con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException ex) {
                System.out.println(ex.toString()); // Imprime cualquier error de cierre de conexión en la consola
            }
        }
    }
    
    /**
     * Modifica la información de un producto en la base de datos.
     * @param pro El producto con la información actualizada.
     * @return true si la modificación fue exitosa, false si ocurrió un error.
     */
    public boolean ModificarProductos(Productos pro){
        String sql = "UPDATE productos SET codigo=?, nombre=?, proveedor=?, stock=?, precio=? WHERE id=?"; // Consulta SQL para actualizar un producto
        try {
            ps = con.prepareStatement(sql); // Prepara la consulta SQL
            // Establece los parámetros de la consulta con los datos actualizados del producto
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setInt(3, pro.getProveedor());
            ps.setInt(4, pro.getStock());
            ps.setDouble(5, pro.getPrecio());
            ps.setInt(6, pro.getId());
            ps.execute(); // Ejecuta la consulta
            return true; // Retorna true si la operación fue exitosa
        } catch (SQLException e) {
            System.out.println(e.toString()); // Imprime cualquier error SQL en la consola
            return false; // Retorna false si ocurrió un error
        } finally {
            try {
                con.close(); // Cierra la conexión a la base de datos
            } catch (SQLException e) {
                System.out.println(e.toString()); // Imprime cualquier error de cierre de conexión en la consola
            }
        }
    }
     // Método para buscar un producto por su código
    public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setId(rs.getInt("id"));
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    }
    
    // Método para buscar un producto por su ID
    public Productos BuscarId(int id){
        Productos pro = new Productos();
        String sql = "SELECT pr.id AS id_proveedor, pr.nombre AS nombre_proveedor, p.* FROM proveedor pr INNER JOIN productos p ON p.proveedor = pr.id WHERE p.id = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                pro.setId(rs.getInt("id"));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setProveedor(rs.getInt("proveedor"));
                pro.setProveedorPro(rs.getString("nombre_proveedor"));
                pro.setStock(rs.getInt("stock"));
                pro.setPrecio(rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pro;
    }
    
    // Método para buscar un proveedor por su nombre
    public Proveedor BuscarProveedor(String nombre){
        Proveedor pr = new Proveedor();
        String sql = "SELECT * FROM proveedor WHERE nombre = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()) {
                pr.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return pr;
    }
    
    // Método para buscar los datos de configuración
    public Config BuscarDatos(){
        Config conf = new Config();
        String sql = "SELECT * FROM config";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                conf.setId(rs.getInt("id"));
                conf.setRuc(rs.getString("ruc"));
                conf.setNombre(rs.getString("nombre"));
                conf.setTelefono(rs.getString("telefono"));
                conf.setDireccion(rs.getString("direccion"));
                conf.setMensaje(rs.getString("mensaje"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return conf;
    }
    
    // Método para modificar los datos de configuración
    public boolean ModificarDatos(Config conf){
       String sql = "UPDATE config SET ruc=?, nombre=?, telefono=?, direccion=?, mensaje=? WHERE id=?";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, conf.getRuc());
           ps.setString(2, conf.getNombre());
           ps.setString(3, conf.getTelefono());
           ps.setString(4, conf.getDireccion());
           ps.setString(5, conf.getMensaje());
           ps.setInt(6, conf.getId());
           ps.execute();
           return true;
       } catch (SQLException e) {
           System.out.println(e.toString());
           return false;
       } finally {
           try {
               con.close();
           } catch (SQLException e) {
               System.out.println(e.toString());
           }
       }
   }
}
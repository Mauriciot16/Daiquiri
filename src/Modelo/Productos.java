
package Modelo; // Define el paquete al que pertenece esta clase

// Definición de la clase Productos
public class Productos {
    // Atributos privados de la clase Productos
    private int id; // Identificador del producto
    private String codigo; // Código del producto
    private String nombre; // Nombre del producto
    private int proveedor; // Identificador del proveedor del producto
    private String proveedorPro; // Nombre del proveedor del producto
    private int stock; // Cantidad de stock del producto
    private double precio; // Precio del producto
    
    // Constructor por defecto
    public Productos() {
    }

    // Constructor con parámetros
    public Productos(int id, String codigo, String nombre, int proveedor, String proveedorPro, int stock, double precio) {
        this.id = id; // Asigna el identificador del producto
        this.codigo = codigo; // Asigna el código del producto
        this.nombre = nombre; // Asigna el nombre del producto
        this.proveedor = proveedor; // Asigna el identificador del proveedor del producto
        this.proveedorPro = proveedorPro; // Asigna el nombre del proveedor del producto
        this.stock = stock; // Asigna la cantidad de stock del producto
        this.precio = precio; // Asigna el precio del producto
    }

    // Métodos getter y setter para acceder y modificar los atributos de la clase
    
    // Obtiene el identificador del producto
    public int getId() {
        return id;
    }

    // Establece el identificador del producto
    public void setId(int id) {
        this.id = id;
    }

    // Obtiene el código del producto
    public String getCodigo() {
        return codigo;
    }

    // Establece el código del producto
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    // Obtiene el nombre del producto
    public String getNombre() {
        return nombre;
    }

    // Establece el nombre del producto
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Obtiene el identificador del proveedor del producto
    public int getProveedor() {
        return proveedor;
    }

    // Establece el identificador del proveedor del producto
    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    // Obtiene el nombre del proveedor del producto
    public String getProveedorPro() {
        return proveedorPro;
    }

    // Establece el nombre del proveedor del producto
    public void setProveedorPro(String proveedorPro) {
        this.proveedorPro = proveedorPro;
    }

    // Obtiene la cantidad de stock del producto
    public int getStock() {
        return stock;
    }

    // Establece la cantidad de stock del producto
    public void setStock(int stock) {
        this.stock = stock;
    }

    // Obtiene el precio del producto
    public double getPrecio() {
        return precio;
    }

    // Establece el precio del producto
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}

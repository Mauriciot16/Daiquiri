
package Modelo;

public class Proveedor {
    private int id; // Identificador único del proveedor
    private String ruc; // Número de RUC del proveedor
    private String nombre; // Nombre del proveedor
    private String telefono; // Número de teléfono del proveedor
    private String direccion; // Dirección del proveedor
    
    // Constructor por defecto
    public Proveedor(){
        
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Proveedor(int id, String ruc, String nombre, String telefono, String direccion) {
        this.id = id;
        this.ruc = ruc;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    // Métodos para acceder y modificar el ID del proveedor
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Métodos para acceder y modificar el RUC del proveedor
    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    // Métodos para acceder y modificar el nombre del proveedor
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos para acceder y modificar el teléfono del proveedor
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Métodos para acceder y modificar la dirección del proveedor
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

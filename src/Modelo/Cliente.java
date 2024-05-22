
package Modelo; 

/**
 *
 * @author jhony
 */
public class Cliente {
    // Atributos privados de la clase Cliente
    private int id; // Identificador único del cliente
    private String dni; // Documento Nacional de Identidad del cliente
    private String nombre; // Nombre del cliente
    private String telefono; // Número de teléfono del cliente
    private String direccion; // Dirección del cliente

    // Constructor por defecto
    public Cliente() {
    }

    // Constructor parametrizado que inicializa todos los atributos
    public Cliente(int id, String dni, String nombre, String telefono, String direccion) {
        this.id = id; // Inicializa el atributo id con el valor pasado como parámetro
        this.dni = dni; // Inicializa el atributo dni con el valor pasado como parámetro
        this.nombre = nombre; // Inicializa el atributo nombre con el valor pasado como parámetro
        this.telefono = telefono; // Inicializa el atributo telefono con el valor pasado como parámetro
        this.direccion = direccion; // Inicializa el atributo direccion con el valor pasado como parámetro
    }

    // Método getter para el atributo id
    public int getId() {
        return id; // Retorna el valor del atributo id
    }

    // Método setter para el atributo id
    public void setId(int id) {
        this.id = id; // Establece el valor del atributo id
    }

    // Método getter para el atributo dni
    public String getDni() {
        return dni; // Retorna el valor del atributo dni
    }

    // Método setter para el atributo dni
    public void setDni(String dni) {
        this.dni = dni; // Establece el valor del atributo dni
    }

    // Método getter para el atributo nombre
    public String getNombre() {
        return nombre; // Retorna el valor del atributo nombre
    }

    // Método setter para el atributo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece el valor del atributo nombre
    }

    // Método getter para el atributo telefono
    public String getTelefono() {
        return telefono; // Retorna el valor del atributo telefono
    }

    // Método setter para el atributo telefono
    public void setTelefono(String telefono) {
        this.telefono = telefono; // Establece el valor del atributo telefono
    }

    // Método getter para el atributo direccion
    public String getDireccion() {
        return direccion; // Retorna el valor del atributo direccion
    }

    // Método setter para el atributo direccion
    public void setDireccion(String direccion) {
        this.direccion = direccion; // Establece el valor del atributo direccion
    }
}
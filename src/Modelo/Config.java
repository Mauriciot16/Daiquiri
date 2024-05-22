package Modelo; // Define el paquete al que pertenece esta clase

public class Config {
    // Atributos privados de la clase Config
    private int id; // Identificador único de la configuración
    private String ruc; // RUC (Registro Único de Contribuyentes) de la configuración
    private String nombre; // Nombre asociado a la configuración
    private String telefono; // Teléfono de contacto asociado a la configuración
    private String direccion; // Dirección física asociada a la configuración
    private String mensaje; // Mensaje adicional de la configuración
    
    // Constructor por defecto que no inicializa atributos
    public Config() {
        
    }

    // Constructor parametrizado que inicializa todos los atributos
    public Config(int id, String ruc, String nombre, String telefono, String direccion, String mensaje) {
        this.id = id; // Inicializa el atributo id con el valor pasado como parámetro
        this.ruc = ruc; // Inicializa el atributo ruc con el valor pasado como parámetro
        this.nombre = nombre; // Inicializa el atributo nombre con el valor pasado como parámetro
        this.telefono = telefono; // Inicializa el atributo telefono con el valor pasado como parámetro
        this.direccion = direccion; // Inicializa el atributo direccion con el valor pasado como parámetro
        this.mensaje = mensaje; // Inicializa el atributo mensaje con el valor pasado como parámetro
    }

    // Método getter para el atributo id
    public int getId() {
        return id; // Retorna el valor del atributo id
    }

    // Método setter para el atributo id
    public void setId(int id) {
        this.id = id; // Establece el valor del atributo id
    }

    // Método getter para el atributo ruc
    public String getRuc() {
        return ruc; // Retorna el valor del atributo ruc
    }

    // Método setter para el atributo ruc
    public void setRuc(String ruc) {
        this.ruc = ruc; // Establece el valor del atributo ruc
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

    // Método getter para el atributo mensaje
    public String getMensaje() {
        return mensaje; // Retorna el valor del atributo mensaje
    }

    // Método setter para el atributo mensaje
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje; // Establece el valor del atributo mensaje
    }
}

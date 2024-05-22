package Modelo; // Define el paquete al que pertenece esta clase

public class Detalle {
    // Atributos privados de la clase Detalle
    private int id; // Identificador único del detalle
    private int id_pro; // Identificador del producto
    private int cantidad; // Cantidad de productos
    private double precio; // Precio del producto
    private int id_venta; // Identificador de la venta asociada
    
    // Constructor por defecto que no inicializa atributos
    public Detalle() {
        
    }

    // Constructor parametrizado que inicializa todos los atributos
    public Detalle(int id, int id_pro, int cantidad, double precio, int id_venta) {
        this.id = id; // Inicializa el atributo id con el valor pasado como parámetro
        this.id_pro = id_pro; // Inicializa el atributo id_pro con el valor pasado como parámetro
        this.cantidad = cantidad; // Inicializa el atributo cantidad con el valor pasado como parámetro
        this.precio = precio; // Inicializa el atributo precio con el valor pasado como parámetro
        this.id_venta = id_venta; // Inicializa el atributo id_venta con el valor pasado como parámetro
    }

    // Método getter para el atributo id
    public int getId() {
        return id; // Retorna el valor del atributo id
    }

    // Método setter para el atributo id
    public void setId(int id) {
        this.id = id; // Establece el valor del atributo id
    }

    // Método getter para el atributo id_pro
    public int getId_pro() {
        return id_pro; // Retorna el valor del atributo id_pro
    }

    // Método setter para el atributo id_pro
    public void setId_pro(int id_pro) {
        this.id_pro = id_pro; // Establece el valor del atributo id_pro
    }

    // Método getter para el atributo cantidad
    public int getCantidad() {
        return cantidad; // Retorna el valor del atributo cantidad
    }

    // Método setter para el atributo cantidad
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad; // Establece el valor del atributo cantidad
    }

    // Método getter para el atributo precio
    public double getPrecio() {
        return precio; // Retorna el valor del atributo precio
    }

    // Método setter para el atributo precio
    public void setPrecio(double precio) {
        this.precio = precio; // Establece el valor del atributo precio
    }

    // Método getter para el atributo id_venta
    public int getId_venta() {
        return id_venta; // Retorna el valor del atributo id_venta
    }

    // Método setter para el atributo id_venta
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta; // Establece el valor del atributo id_venta
    }
}

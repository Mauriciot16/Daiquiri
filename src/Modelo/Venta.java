
package Modelo;

public class Venta {
    private int id; // Identificador de la venta
    private int cliente; // ID del cliente asociado a la venta
    private String nombre_cli; // Nombre del cliente asociado a la venta
    private String vendedor; // Nombre del vendedor responsable de la venta
    private double total; // Total de la venta
    private String fecha; // Fecha de la venta

    // Constructor vacío
    public Venta(){

    }

    // Constructor con todos los atributos
    public Venta(int id, int cliente, String nombre_cli, String vendedor, double total, String fecha) {
        this.id = id;
        this.cliente = cliente;
        this.nombre_cli = nombre_cli;
        this.vendedor = vendedor;
        this.total = total;
        this.fecha = fecha;
    }

    // Métodos para obtener y establecer los valores de los atributos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
package Modelo; // Define el paquete al que pertenece esta clase

public class Combo {
    // Atributos privados de la clase Combo
    private int id; // Identificador único del combo
    private String nombre; // Nombre del combo

    // Constructor parametrizado que inicializa todos los atributos
    public Combo(int id, String nombre) {
        this.id = id; // Inicializa el atributo id con el valor pasado como parámetro
        this.nombre = nombre; // Inicializa el atributo nombre con el valor pasado como parámetro
    }

    // Método getter para el atributo id
    public int getId() {
        return id; // Retorna el valor del atributo id
    }

    // Método setter para el atributo id
    public void setId(int id) {
        this.id = id; // Establece el valor del atributo id
    }

    // Método getter para el atributo nombre
    public String getNombre() {
        return nombre; // Retorna el valor del atributo nombre
    }

    // Método setter para el atributo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre; // Establece el valor del atributo nombre
    }
    
    // Método sobrescrito toString para retornar el nombre del combo
    @Override
    public String toString(){
        return this.getNombre(); // Retorna el nombre del combo
    }
}

package Modelo; // Define el paquete al que pertenece esta clase

import java.awt.event.KeyEvent; // Importa la clase KeyEvent para manejar eventos de teclado
import javax.swing.JTextField; // Importa la clase JTextField para trabajar con campos de texto en Swing

public class Eventos {

    // Método para manejar eventos de teclado y permitir solo letras
    public void textKeyPress(KeyEvent evt) {
        // Declaramos una variable y le asignamos el carácter del evento
        char car = evt.getKeyChar();
        // Si el carácter no es una letra (minúscula o mayúscula), espacio o retroceso, consume el evento
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume(); // Consume el evento para que no se procese
        }
    }

    // Método para manejar eventos de teclado y permitir solo números
    public void numberKeyPress(KeyEvent evt) {
        // Declaramos una variable y le asignamos el carácter del evento
        char car = evt.getKeyChar();
        // Si el carácter no es un número o retroceso, consume el evento
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume(); // Consume el evento para que no se procese
        }
    }

    // Método para manejar eventos de teclado y permitir números decimales
    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField) {
        // Declaramos una variable y le asignamos el carácter del evento
        char car = evt.getKeyChar();
        // Si el carácter no es un número, punto decimal o retroceso, consume el evento
        // También verifica que no haya más de un punto decimal en el campo de texto
        if ((car < '0' || car > '9') && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume(); // Consume el evento para que no se procese
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume(); // Consume el evento para que no se procese
        }
    }
}

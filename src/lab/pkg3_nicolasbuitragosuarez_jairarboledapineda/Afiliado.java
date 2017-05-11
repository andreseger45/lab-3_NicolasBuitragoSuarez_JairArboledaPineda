/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

/**
 *
 * @author Nicolás
 */
public class Afiliado {
    private final int codigo;
    private final String nombre;
    private int numTelefono;

    public Afiliado(int codigo, String nombre, int numTelefono) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numTelefono = numTelefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(int numTelefono) {
        this.numTelefono = numTelefono;
    }
    
}

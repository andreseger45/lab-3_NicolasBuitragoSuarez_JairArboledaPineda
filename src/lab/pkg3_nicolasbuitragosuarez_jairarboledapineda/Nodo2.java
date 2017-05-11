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
public class Nodo2 {
    private final Libro libro;
    private Nodo2 link3;

    public Nodo2(Libro libro, Nodo2 link3) {
        this.libro = libro;
        this.link3 = link3;
    }

    public Libro getLibro() {
        return libro;
    }

    public Nodo2 getLink3() {
        return link3;
    }

    public void setLink3(Nodo2 link3) {
        this.link3 = link3;
    }
    
}

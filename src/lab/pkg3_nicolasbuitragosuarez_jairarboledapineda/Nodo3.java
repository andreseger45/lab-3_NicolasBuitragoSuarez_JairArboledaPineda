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
public class Nodo3 {
    private Libro libro;
    private Nodo3 rlink;
    private Nodo3 llink;

    public Nodo3(Libro libro) {
        this.libro = libro;
        this.llink = null;
        this.rlink = null;
    }

    public Libro getLibro() {
        return libro;
    }

    public Nodo3 getRlink() {
        return rlink;
    }

    public void setRlink(Nodo3 rlink) {
        this.rlink = rlink;
    }

    public Nodo3 getLlink() {
        return llink;
    }

    public void setLlink(Nodo3 llink) {
        this.llink = llink;
    }
    
}

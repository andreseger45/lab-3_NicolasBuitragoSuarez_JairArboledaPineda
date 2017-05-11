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
public class Nodo1 {
    private final String autor;
    private Nodo2 link1;
    private Nodo1 link2;

    public Nodo1(String autor, Nodo2 link1, Nodo1 link2) {
        this.autor = autor;
        this.link1 = link1;
        this.link2 = link2;
    }

    public Nodo1(String autor) {
        this.autor = autor;
        this.link1 = null;
        this.link2 = null;
    }

    public String getAutor() {
        return autor;
    }

    public Nodo2 getLink1() {
        return link1;
    }

    public Nodo1 getLink2() {
        return link2;
    }

    public void setLink1(Nodo2 link1) {
        this.link1 = link1;
    }

    public void setLink2(Nodo1 link2) {
        this.link2 = link2;
    }
    
}

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
public class Nodo {
    private final Afiliado afiliado;
    private Nodo2 link1;
    private Nodo link2;

    public Nodo(Afiliado afiliado, Nodo2 link1, Nodo link2) {
        this.afiliado = afiliado;
        this.link1 = link1;
        this.link2 = link2;
    }

    public Afiliado getAfiliado() {
        return afiliado;
    }

    public Nodo2 getLink1() {
        return link1;
    }

    public Nodo getLink2() {
        return link2;
    }

    public void setLink1(Nodo2 link1) {
        this.link1 = link1;
    }

    public void setLink2(Nodo link2) {
        this.link2 = link2;
    }
    
}

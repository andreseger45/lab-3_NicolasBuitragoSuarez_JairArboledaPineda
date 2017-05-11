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
public class MultiListaAutores {
    private Nodo1 PTR;
    private int tamaño;

    public MultiListaAutores() {
        this.PTR = null;
        this.tamaño = 0;
    }

    public Nodo1 getPTR() {
        return PTR;
    }

    public void setPTR(Nodo1 PTR) {
        this.PTR = PTR;
    }

    public int getTamaño() {
        return tamaño;
    }
    
    public boolean estaVacia(){
        return PTR==null;
    }
    
    public void addAutor(Libro libro){
        Nodo1 P = new Nodo1(libro.getAutor(), new Nodo2 (libro,null), PTR);
        PTR = P;
        tamaño++;
    }
    /**
     * Función que se encarga de añadir un nubo libro libro a la multilista
     * @param libro
     * @return true   si se añadio el libro con exito, 
     *         false  si el libro ya existe y no se añadio
     */
    public boolean addLibro(Libro libro) {
        if (!estaVacia()) {
            if(codigoRepetido(libro.getCodigo())) return false;
            Nodo1 A = PTR;
            while (!(A.getAutor().equals(libro.getAutor()))) {
                if (A.getLink2() == null) {
                    break;
                }
                A = A.getLink2();

            }
            if (A.getAutor().equals(libro.getAutor())) {
                Nodo2 L = A.getLink1();
                if (L != null) {
                    while (!(L.getLibro().getTitulo().equals(libro.getTitulo()))) {
                        L = L.getLink3();
                        if (L == null) {
                            break;
                        }
                    }
                    if (L == null) {
                        A.setLink1(new Nodo2(libro, A.getLink1()));
                        return true;
                    }
                    return false;//El libro ya existe
                } else {
                    A.setLink1(new Nodo2(libro, A.getLink1()));
                    return true;
                }
            } else {
                addAutor(libro);
                return true;
            }
        } else {
            addAutor(libro);
            return true;
        }
    }
    
    public boolean codigoRepetido(int codigo){
        Nodo1 P = PTR;
        while(P!=null){
            Nodo2 L = P.getLink1();
            while(L!=null){
                if(codigo==L.getLibro().getCodigo()){
                    return true;
                }
                L = L.getLink3();
            }
            P = P.getLink2();
        }
        return false;
    }
    
    public void imprimir(){
        System.out.println("");
        System.out.println("");System.out.println("");
        Nodo1 P = PTR;
        while(P!=null){
            System.out.println(P.getAutor());
            Nodo2 L = P.getLink1();
            while(L!=null){
                System.out.println("    Ti: "+L.getLibro().getTitulo()+"    Cod: "+L.getLibro().getCodigo());
                L = L.getLink3();
            }
            P = P.getLink2();
        }
    }
    
}

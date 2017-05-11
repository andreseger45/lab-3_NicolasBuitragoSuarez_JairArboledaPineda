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
public class ListaEjemplar {
    private Nodo3 PTR;
    private Nodo3 ULT;
    private int tamaño;

    public ListaEjemplar() {
        this.PTR = null;
        this.ULT = null;
        this.tamaño = 0;
    }

    public Nodo3 getPTR() {
        return PTR;
    }

    public void setPTR(Nodo3 PTR) {
        this.PTR = PTR;
    }

    public Nodo3 getULT() {
        return ULT;
    }

    public void setULT(Nodo3 ULT) {
        this.ULT = ULT;
    }
    
    public boolean estaVacia(){
        return PTR == null;
    }
    
    public int getTamaño(){
        return tamaño;
    }
    
    public void add(Libro libro){
        Nodo3 P = new Nodo3(libro);
        if (estaVacia()) {
            PTR = P;
            ULT = P;
        } else{
            P.setLlink(ULT);
            ULT.setRlink(P);
            ULT = P;
        }
        tamaño++;
    } 
  
//    public int getPosicion(int nc){
//        if (buscar(nc)) {
//            Nodo3 P = PTR;
//            int i = 0;
//            while(!(nc==P.getnCuenta())){
//                i ++;
//                P = P.getRlink();
//            }
//            return i;
//        } else {
////            System.out.println("Error en getPosicion");
//            return -1;
//        }
//    }
//    
//    public boolean buscar(int nc){
//        Nodo3 P = PTR;
////        boolean sw = false;
//        while(P != null){
//            if (nc==P.getnCuenta()){
//                return true;
//            }
//            else{
//                P = P.getRlink();
//            }
//        }
//        return false;
//    }
    
    public Nodo3 getInfoPos(int posicion){
        if(posicion>=0 && posicion<tamaño){
            if (posicion == 0) {
                return PTR;
            }else{
                Nodo3 P = PTR;
                for (int i = 0; i < posicion; i++) {
                    P = P.getRlink();
                }
                return P;
            }
        } else {
            System.out.println("Error en getInfoPos");
            return null;
        }
    }
    
    public void imprimir(){
        System.out.println("");
        System.out.println("\n\n\nEjemplares");
        Nodo3 P = PTR;
        while(P!=null){
            System.out.println("Autor: " + P.getLibro().getAutor());
            String e; if(P.getLibro().isEstado()){e="true";}else{e="false";}
            System.out.println("    Ti: "+P.getLibro().getTitulo()+"    Cod: "+P.getLibro().getCodigo());
            System.out.println("   Estado: "+e+ "   fechaDev: "+P.getLibro().getFechaDevolucion().getFecha());
            P=P.getRlink();
        }
    }
}

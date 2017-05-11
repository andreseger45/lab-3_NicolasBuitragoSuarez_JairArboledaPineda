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
public class MultiListaAfiliados {
    private Nodo PTR;
    private int tamaño;

    public MultiListaAfiliados() {
        this.PTR = null;
        this.tamaño = 0;
    }

    public Nodo getPTR() {
        return PTR;
    }

    public void setPTR(Nodo PTR) {
        this.PTR = PTR;
    }

    public int getTamaño() {
        return tamaño;
    }
    
    public boolean estaVacia(){
        return PTR==null;
    }
    
    public void addAfiliado (Afiliado afi){
//        try {
            if (estaVacia()) {
                PTR = new Nodo(afi, null, null);
            } else {
                Nodo P = PTR, antep = null;
                while (P != null) {
                    if (P.getAfiliado().getCodigo() > afi.getCodigo()) {
                        break;
                    }
                    antep = P;
                    P = P.getLink2();
                }
                if(antep!=null){
                    antep.setLink2(new Nodo(afi, null, P));
                }else{
                    Nodo t = new Nodo (afi,null,PTR);
                    PTR = t;
                }
            }
            tamaño++;
//        } catch (Exception e) {
//            System.out.println("ERROR");
//        }
        
    }
    
    public void imprimir(){
        System.out.println("\n\n\n\n");
        Nodo P = PTR;
        while(P!=null){
            System.out.println(P.getAfiliado().getCodigo()+"    "+P.getAfiliado().getNombre()+"");
            Nodo2 Q = P.getLink1();
            while(Q!=null){
                System.out.println("    "+Q.getLibro().getTitulo()+"    dev: "+Q.getLibro().getFechaDevolucion().getFecha());
                Q = Q.getLink3();
            }
            P = P.getLink2();
        }
    }
}

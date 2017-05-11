/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.DevolverLibro.DAutor;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.DevolverLibro.DLibro;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.EscogerLibro.tblEscogerLibro;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.PrestarLibro.lblAutor;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.PrestarLibro.lblLibro;

/**
 *
 * @author Nicolás
 */
public class DataManager {
    public MultiListaAutores autores = new MultiListaAutores();
    public MultiListaAfiliados afiliados = new MultiListaAfiliados();
    public ListaEjemplar ejemplares = new ListaEjemplar();
    
    public void agregarLibro(Libro libro){
        if (!autores.addLibro(libro)) {
            JOptionPane.showMessageDialog(null, "El libro ya existe o el codigo es invalido.", "Error", 0);
        } else {
            ejemplares.add(libro);
        }
    }
    
    public boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("") == false);
    }
    
    public boolean contieneNumero(String str){
        for (int i = 0; i < str.length(); i++) {
            if (str.matches(".*\\d+.*")) {
                return true;
            }
        }
        return false;
    } 
    
    /**
     * Es una funcion que recibe un DefaultTableModel de una tabla y con este se encarga de limbiar todas 
     * las filas de la tabla
     * @param model Es el DefaultTableModel de la tabla a la que se le an a limpiar las filas
     */
    public void clearTable(DefaultTableModel model){
        while (model.getRowCount() > 0) {                
                model.removeRow(0);
            }
    }
    
    public void escogerLibro(){
        EscogerLibro escLibro = new EscogerLibro(null,true,true);
        escLibro.setLocationRelativeTo(null);
        escLibro.setResizable(false);
        
        DefaultTableModel model = (DefaultTableModel) tblEscogerLibro.getModel();
        clearTable(model);
        for (int i = 0; i < ejemplares.getTamaño(); i++) {
            if(ejemplares.getInfoPos(i).getLibro().isEstado()){
                model.addRow(new Object[] {ejemplares.getInfoPos(i).getLibro().getCodigo(),ejemplares.getInfoPos(i).getLibro().getTitulo(),ejemplares.getInfoPos(i).getLibro().getAutor()});
            }
        }
        
        escLibro.setVisible(true);
    }
    
    public Libro libro = null;
    
    public void getLibro(int pos){
        libro = ejemplares.getInfoPos(pos).getLibro();
        if(!libro.isEstado()){
            getLibro(pos+1);
        }
    }
    
    public void setLibro(){
        lblLibro.setText(libro.getTitulo());
        lblAutor.setText(libro.getAutor());
        lblAutor.setVisible(true);
        lblLibro.setVisible(true);
    }
    
    public boolean verificarCodigo(int cod){
        Nodo P = afiliados.getPTR();
        while(P!=null){
            if(P.getAfiliado().getCodigo()==cod){
                return true;
            }
            P=P.getLink2();
        }
        return false;
    }
    
    public boolean prestarLibro(int codAfiliado, java.util.Date fecha){
       Nodo3 P = ejemplares.getPTR();
        while(P!=null){
            if(P.getLibro().equals(libro)||P.getLibro().getCodigo()==libro.getCodigo()){
                if(P.getLibro().isEstado()){
                    P.getLibro().setEstado(false);
                    Fecha f = new Fecha(new java.text.SimpleDateFormat("dd/MM/yyyy").format(fecha));
                    P.getLibro().setFechaDevolucion(f.devolucion((java.util.Date) fecha));
                    P.getLibro().setCodigoAfiliado(codAfiliado);
                    prestarLibro(codAfiliado,P.getLibro());
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "El libro que inteta prestar no se encuentra disponible.", "Error", 0);
                }
                break;
            }
            P=P.getRlink();
        }
        if(P==null){
            JOptionPane.showMessageDialog(null, "El libro que inteta prestar no existe en nuestro inventario.", "Error", 0);
        }return false; 
    }
    
    public void prestarLibro(int cod,Libro libro){
        Nodo P = afiliados.getPTR();
        while(P!=null){
            if (P.getAfiliado().getCodigo() == cod) {
                Nodo2 Q = P.getLink1();
                P.setLink1(new Nodo2(libro,Q));
                break;
            }
            P = P.getLink2();
        }
    }
    
    public Libro Dlibro = null;
    
    public void escogerDLibro(int cod){
        EscogerLibro escLibro = new EscogerLibro(null,true,false);
        escLibro.setLocationRelativeTo(null);
        escLibro.setResizable(false);
        
        DefaultTableModel model = (DefaultTableModel) tblEscogerLibro.getModel();
        clearTable(model);
        Nodo P = afiliados.getPTR();
        while(P!=null){
            if (P.getAfiliado().getCodigo() == cod) {
                Nodo2 Q = P.getLink1();
                while(Q!=null){
                    model.addRow(new Object[] {Q.getLibro().getCodigo(),Q.getLibro().getTitulo(),Q.getLibro().getAutor()});
                    Q = Q.getLink3();
                }
                break;
            }
            P = P.getLink2();
        }
        escLibro.setVisible(true);
    }
    
    public void getDLibro(int pos){
        Dlibro = ejemplares.getInfoPos(pos).getLibro();
        if(Dlibro.isEstado()){
            getLibro(pos+1);
        }
    }
    
    public void setDLibro(){
        DLibro.setText(Dlibro.getTitulo());
        DAutor.setText(Dlibro.getAutor());
        DAutor.setVisible(true);
        DLibro.setVisible(true);
    }
    
    public boolean devolverLibro(int codAfiliado, java.util.Date fecha){
        Nodo3 P = ejemplares.getPTR();
        while(P!=null){
            if(P.getLibro().equals(libro)||P.getLibro().getCodigo()==libro.getCodigo()){
                if(P.getLibro().isEstado()){
                    P.getLibro().setEstado(false);
                    Fecha f = new Fecha(new java.text.SimpleDateFormat("dd/MM/yyyy").format(fecha));
                    P.getLibro().setFechaDevolucion(f.devolucion((java.util.Date) fecha));
                    P.getLibro().setCodigoAfiliado(codAfiliado);
                    devolverLibro(codAfiliado,P.getLibro());
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "El libro que inteta prestar no se encuentra disponible.", "Error", 0);
                }
                break;
            }
            P=P.getRlink();
        }
        if(P==null){
            JOptionPane.showMessageDialog(null, "El libro que inteta prestar no existe en nuestro inventario.", "Error", 0);
        }return false;
    }
    
    public void devolverLibro(int cod,Libro libro){
        Nodo P = afiliados.getPTR();
        while(P!=null){
            if (P.getAfiliado().getCodigo() == cod) {
                Nodo2 Q = P.getLink1();
                while(Q!=null){
                    if(Q.getLibro().equals(libro)||Q.getLibro().getCodigo()==libro.getCodigo()){
                        
                        break;
                    }
                    Q = Q.getLink3();
                }
                break;
            }
            P = P.getLink2();
        }
    }
    
    public void librosMulta(){
       Nodo3 P = ejemplares.getPTR();
       while(P!=null){
//           if(P.getLibro())
       }
       
    }
    
    public void afiliadosMulta(){
        Nodo P = afiliados.getPTR();
        while(P!=null){
            if(P.getAfiliado().getMulta()>0){
                
            }
            P=P.getLink2();
        }
    }
    
}

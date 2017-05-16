/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.DevolverLibro.DAutor;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.DevolverLibro.DLibro;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.DevolverLibro.fechaDev;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.EscogerLibro.tblEscogerLibro;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.LibrosMulta.tblLibroMulta;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.PrestarLibro.lblAutor;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.PrestarLibro.lblLibro;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.VerAfiliados.tblAfiliados;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.VerLibros.tblVerLibros;

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
    
    public void escogerLibro(int cod){
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
        int k = 0;
        for (int i = 0; i < ejemplares.getTamaño(); i++) {
            if(ejemplares.getInfoPos(i).getLibro().isEstado()){
                
                if(k==pos){
                    libro = ejemplares.getInfoPos(i).getLibro();
                }
                k++;
            }
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
    
    private int codigoAfiliado;
    
    public void escogerDLibro(int cod){
        codigoAfiliado = cod;
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
                    model.addRow(new Object[] {Q.getLibro().getCodigo(),Q.getLibro().getTitulo(),Q.getLibro().getAutor(),Q.getLibro().getFechaDevolucion().getFecha()});
                    Q = Q.getLink3();
                }
                break;
            }
            P = P.getLink2();
        }
        escLibro.setVisible(true);
    }
    
    public void getDLibro(int pos){
        Nodo P = afiliados.getPTR(); int i = 0;
        while(P!=null){
            if (P.getAfiliado().getCodigo() == codigoAfiliado) {
                Nodo2 Q = P.getLink1();
                while(Q!=null){
                    if(i==pos){
                        Dlibro = Q.getLibro();
                    }
                    Q = Q.getLink3();i++;
                }
                break;
            }
            P = P.getLink2();
        }
    }
    
    public void setDLibro(){
        DLibro.setText(Dlibro.getTitulo());
        DAutor.setText(Dlibro.getAutor());
        fechaDev.setText(Dlibro.getFechaDevolucion().getFecha());
        DAutor.setVisible(true);
        DLibro.setVisible(true);
        fechaDev.setVisible(true);
    }
    
    public boolean devolverLibro(int codAfiliado, java.util.Date fecha){
        Nodo3 P = ejemplares.getPTR();
        while(P!=null){
            if(P.getLibro().equals(Dlibro)||P.getLibro().getCodigo()==Dlibro.getCodigo()){
                if(!P.getLibro().isEstado()){
                    devolverLibro(codAfiliado,P.getLibro(), fecha);
                    P.getLibro().setEstado(true);
                    P.getLibro().setFechaDevolucion(new Fecha(0,0,0000));
                    P.getLibro().setCodigoAfiliado(-1);
                    
                    return true;
                }else{
                    JOptionPane.showMessageDialog(null, "El libro que inteta entregar no se encuentra disponible.", "Error", 0);
                }
                break;
            }
            P=P.getRlink();
        }
        if(P==null){
            JOptionPane.showMessageDialog(null, "El libro que inteta entregar no existe en nuestro inventario.", "Error", 0);
        }return false;
    }
    
    
    public Fecha getFecha (Date fecha) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        return new Fecha(new java.text.SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime()));
    }
    
    public void devolverLibro(int cod,Libro libro,java.util.Date fecha){
        Nodo P = afiliados.getPTR();
        while(P!=null){
            if (P.getAfiliado().getCodigo() == cod) {
                Nodo2 Q = P.getLink1(), anteq = null;
                while(Q!=null){
                    if(Q.getLibro().equals(libro)||Q.getLibro().getCodigo()==libro.getCodigo()){
                        if(Q.equals(P.getLink1())){
                            P.setLink1(Q.getLink3());
                        }else{
                            if(anteq!=null) anteq.setLink3(Q.getLink3());
                        }
                        break;
                    }
                    anteq = Q;
                    Q = Q.getLink3();
                }
                int m = (int)libro.getFechaDevolucion().diferencia(getFecha(fecha));
                if(m>0){
                    m=m*1000;
                    JOptionPane.showMessageDialog(null, "La fecha de devolucion ha expirado. Tiene una multa de $"+m+".", "Atencion", 1);
                }
                break;
            }
            P = P.getLink2();
        }
    }
    
    private Afiliado findAfiliado(int cod){
        Nodo P = afiliados.getPTR();
        if(verificarCodigo(cod)&&P!=null){
            while(P!=null){
                if(P.getAfiliado().getCodigo()==cod){
                    return P.getAfiliado();
                }
                P = P.getLink2();
            }
        }else{
            System.out.println("Error codigo Archivo libros");
            return null;
        }
        return P.getAfiliado();
    }
    
    public void librosMulta(){
       LibrosMulta  librosMulta = new LibrosMulta(null,true);
       librosMulta.setLocationRelativeTo(null);
       librosMulta.setResizable(false);
       Nodo3 P = ejemplares.getPTR();
       DefaultTableModel model = (DefaultTableModel) tblLibroMulta.getModel();
       
       while(P!=null){
           int m = (int) P.getLibro().getFechaDevolucion().diferencia(getFecha(new Date()));
           if (m > 0 && !P.getLibro().isEstado()) {
               m = m * 1000;
               Afiliado a = findAfiliado(P.getLibro().getCodigoAfiliado());
               model.addRow(new Object[]{P.getLibro().getCodigo(),P.getLibro().getTitulo(),P.getLibro().getAutor(),P.getLibro().getFechaDevolucion().getFecha(), m,a.getCodigo(),a.getNombre(),a.getNumTelefono()});
               //m = m * 1000;
               //JOptionPane.showMessageDialog(null, "La fecha de devolucion ha expirado. Tiene una multa de $" + m + ".", "Atencion", 1);
           }
           P = P.getRlink();
       }
       librosMulta.setVisible(true);
    }   

    
    public void verAfiliados (){
        VerAfiliados verAfiliados = new VerAfiliados(null,true);
        verAfiliados.setLocationRelativeTo(null);
        verAfiliados.setResizable(false);
        
        DefaultTableModel model = (DefaultTableModel) tblAfiliados.getModel();
        Nodo P = afiliados.getPTR();
        for (int i = 0; i < afiliados.getTamaño(); i++) {
            model.addRow(new Object[]{P.getAfiliado().getCodigo(),P.getAfiliado().getNombre(),P.getAfiliado().getNumTelefono()});
            P = P.getLink2();
        }
        
        verAfiliados.setVisible(true);
        
    }
    
    public void verLibros(){
        VerLibros verlibros = new VerLibros (null,true);
        verlibros.setLocationRelativeTo(null);
        verlibros.setResizable(false);
        DefaultTableModel model = (DefaultTableModel) tblVerLibros.getModel();
        Nodo3 P = ejemplares.getPTR();
        String e;
        while(P != null){
            if(P.getLibro().isEstado()){
                e = "Disponible";
            }else{
                e = "No disponible";
            }
            model.addRow(new Object[]{P.getLibro().getCodigo(),P.getLibro().getTitulo(),P.getLibro().getAutor(),e});
            P = P.getRlink();
        }
        verlibros.setVisible(true);
    }
    
    public void getAfiliados() throws IOException{
        FileReader fra =null;
        try {
            File Afiliados = new File("Afiliados.txt");
            fra = new FileReader(Afiliados);
            BufferedReader afi = new BufferedReader(fra);
            String a = afi.readLine();
            a = afi.readLine();
            while (a != null) {                
                String[] c = a.split(",");//System.out.println("c.length = "+c.length);
                afiliados.addAfiliado(new Afiliado(Integer.parseInt(c[0]),c[1],Integer.parseInt(c[2])));
                a = afi.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error DataManager getAfiliados =    "+e.getMessage());
        }finally{
            try {
                if (fra != null) {
                    fra.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public Date getDate(Fecha fecha){
        Date date = new Date(fecha.getAño()-1900,fecha.getMes()-1,fecha.getDia()-4);
        return date;
    }
    
    public void getLibros() throws IOException{
        FileReader frl =null;
        try {
            File Libros = new File("Libros.txt");
            frl = new FileReader(Libros);
            BufferedReader bfl = new BufferedReader(frl);
            String l = bfl.readLine();
            l = bfl.readLine();
            while (l != null) {                
                String[] c = l.split(",");
                if(c.length==3){
                    agregarLibro(new Libro(Integer.parseInt(c[0]),c[1],c[2]));
                }else{
                    Libro libro = new Libro(Integer.parseInt(c[0]),c[1],c[2]);
                    agregarLibro(libro);
                    this.libro=libro; int cod = Integer.parseInt(c[4]);//System.out.println("C[4] = "+cod);
                    prestarLibro(Integer.parseInt(c[4]),getDate(new Fecha(c[3])));
                }
                l = bfl.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error DataManager getLibros =    "+e.getMessage());
        }finally{
            try {
                if (frl != null) {
                    frl.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void actualizar() {
        int eleccion = JOptionPane.showOptionDialog(null, "¿Seguro que desea cerrar la aplicacion?", "Mensaje de Confirmacion",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Si", "No"}, "Si");
        if (eleccion == JOptionPane.YES_OPTION) {

            FileWriter fw = null;
            try {
                fw = new FileWriter("Libros.txt", false);
                PrintWriter pw = new PrintWriter(fw);
                String linea = "Codigo , Titulo , Autor , Fecha dev. , cod. Afiliado";
                pw.print(linea);
                pw.println();
                for (int i = 0; i < ejemplares.getTamaño(); i++) {
                    if(ejemplares.getInfoPos(i).getLibro().isEstado()){
                        linea = Integer.toString(ejemplares.getInfoPos(i).getLibro().getCodigo()) + "," + ejemplares.getInfoPos(i).getLibro().getTitulo()+ "," +
                            ejemplares.getInfoPos(i).getLibro().getAutor();
                    }else{
                    linea = Integer.toString(ejemplares.getInfoPos(i).getLibro().getCodigo()) + "," + ejemplares.getInfoPos(i).getLibro().getTitulo()+ "," +
                            ejemplares.getInfoPos(i).getLibro().getAutor()+ "," +ejemplares.getInfoPos(i).getLibro().getFechaDevolucion().getFecha()+ "," +Integer.toString(ejemplares.getInfoPos(i).getLibro().getCodigoAfiliado());
                    }
                    pw.print(linea);
                    pw.println();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Error al guardar libros.txt ");
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            
            fw = null;
            try {
                fw = new FileWriter("Afiliados.txt", false);
                PrintWriter pw = new PrintWriter(fw);
                String linea = "Codigo , Nombre, Telefono";
                pw.print(linea);
                pw.println();
                Nodo P = afiliados.getPTR();
                while (P != null) {
                    linea = Integer.toString(P.getAfiliado().getCodigo())+ "," + P.getAfiliado().getNombre()+ "," + Integer.toString(P.getAfiliado().getNumTelefono());
                    pw.print(linea);
                    pw.println();
                    P = P.getLink2();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Error al guardar el afiliados.txt");
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            System.exit(0);
        }
    }
}

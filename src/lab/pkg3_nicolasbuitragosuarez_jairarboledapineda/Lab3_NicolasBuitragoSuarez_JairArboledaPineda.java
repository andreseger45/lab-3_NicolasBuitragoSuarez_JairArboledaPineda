package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

import java.io.IOException;

/**
 *
 * @author Nicolás
 */
public class Lab3_NicolasBuitragoSuarez_JairArboledaPineda {

    public static DataManager dm = new DataManager();
    
    public static void main(String[] args) throws IOException {
        try {

            javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
            javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        dm.getAfiliados();
//        dm.afiliados.addAfiliado(new Afiliado(82260,"Luis Perez",3738262));
//        dm.afiliados.addAfiliado(new Afiliado(92258,"Carlos Yepez",3826374));
//        dm.afiliados.addAfiliado(new Afiliado(82257,"Nicolas Buitrago",3569374));
//        dm.afiliados.addAfiliado(new Afiliado(92259,"Maria Consuegra",3459812));
//        dm.afiliados.addAfiliado(new Afiliado(82835,"Jair Arboleda",3459812));
        
        dm.getLibros();

//        dm.agregarLibro(new Libro(1234,"Exodo","Leon Uris"));
//        dm.agregarLibro(new Libro(5678,"Rayuela","Julio Cortazar"));
//        dm.agregarLibro(new Libro(3101,"El mundo y sus demonios","Carl Sagan"));
//        dm.agregarLibro(new Libro(9287,"El principe","Nicolas Maquiavelo"));
//        dm.agregarLibro(new Libro(2137,"Cien años de soledad","Gabriel Garcia"));
//        dm.agregarLibro(new Libro(5643,"Todos los nombres","Jose Saramago"));
//        dm.agregarLibro(new Libro(2735,"El nombre de la rosa","Umberto Eco"));
//        
//        dm.getLibro(0);
//        dm.prestarLibro(82257, new java.util.Date(117,4,4));
//        dm.getLibro(0);
//        dm.prestarLibro(92258, new java.util.Date(117,3,2));
//        dm.getLibro(1);
//        dm.prestarLibro(82835, new java.util.Date(117,4,6));
        
//        dm.afiliados.imprimir();
//        dm.ejemplares.imprimir();
        Principal principal = new Principal();
        principal.setResizable(false);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
    
}

package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

/**
 *
 * @author Nicolás
 */
public class Lab3_NicolasBuitragoSuarez_JairArboledaPineda {

    public static DataManager dm = new DataManager();
    
    public static void main(String[] args) {
        try {

            javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
            javax.swing.JDialog.setDefaultLookAndFeelDecorated(true);
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        dm.afiliados.addAfiliado(new Afiliado(82260,"Luis",4));
        dm.afiliados.addAfiliado(new Afiliado(82258,"Carlos",2));
        dm.afiliados.addAfiliado(new Afiliado(82257,"Nicolas",1));
        dm.afiliados.addAfiliado(new Afiliado(82259,"Maria",3));
        
        dm.agregarLibro(new Libro(1234,"Exodo","Leon Uris"));
        dm.agregarLibro(new Libro(5678,"Rayuela","Julio Cortazar"));
        dm.agregarLibro(new Libro(3101,"El mundo y sus demonios","Carl Sagan"));
        dm.agregarLibro(new Libro(9287,"El principe","Nicolas Maquiavelo"));
        dm.agregarLibro(new Libro(2137,"Cien años de soledad","Gabriel Garcia"));
        dm.getLibro(0);
        dm.prestarLibro(82257, new java.util.Date(117,4,4));
        
        
//        Fecha f = new Fecha("10/05/2017");f.diferencia(new Fecha(14,05,2017));
//        System.out.println("f= "+f.getDia()+" + "+f.getMes()+" + "+f.getAño());
        
//        dm.afiliados.imprimir();
        
        Principal principal = new Principal();
        principal.setResizable(false);
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
    
}

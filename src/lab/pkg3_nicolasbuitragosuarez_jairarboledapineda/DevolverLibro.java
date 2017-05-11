/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg3_nicolasbuitragosuarez_jairarboledapineda;

import javax.swing.JOptionPane;
import static lab.pkg3_nicolasbuitragosuarez_jairarboledapineda.Lab3_NicolasBuitragoSuarez_JairArboledaPineda.dm;

/**
 *
 * @author Nicolás
 */
public class DevolverLibro extends javax.swing.JDialog {

    /**
     * Creates new form PrestarLibro
     */
    public DevolverLibro(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        java.text.SimpleDateFormat model = new java.text.SimpleDateFormat("dd/MM/yyyy");
        fecha.setEditor(new javax.swing.JSpinner.DateEditor(fecha, model.toPattern()));
        DAutor.setVisible(false);
        DLibro.setVisible(false);
    }
    
    /**
     * Funcion que se encarge de añadir elementos al jcombobox
     */
    public void libros(){
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        codigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        DAutor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        DLibro = new javax.swing.JLabel();
        fecha = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Entregar libro");

        jButton1.setText("Entregar libro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo:");

        jLabel3.setText("Libro:");

        jLabel1.setText("Autor:");

        DAutor.setText("jLabel4");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/books-img.png"))); // NOI18N

        jButton2.setText("Escoger libro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        DLibro.setText("jLabel4");

        fecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));

        jLabel4.setText("Fecha:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel5))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(jButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DLibro)
                            .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DAutor)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DLibro))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DAutor)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        System.out.println("fecha = "+new java.text.SimpleDateFormat("dd/MM/yyyy").format(fecha.getValue()));
//        Fecha f=new Fecha(new java.text.SimpleDateFormat("dd/MM/yyyy").format(fecha.getValue()));
//        System.out.println("dev = "+f.devolucion((java.util.Date)fecha.getValue()).getFecha());
        try {
            if(dm.isNumeric(codigo.getText())){
            if (!dm.verificarCodigo(Integer.parseInt(codigo.getText()))) {
                JOptionPane.showMessageDialog(null, "El codigo de afiliado que ingreso no existe.", "Error", 0);
                codigo.setText("");
            } else {
                dm.devolverLibro(Integer.parseInt(codigo.getText()), (java.util.Date) fecha.getValue());
                dm.ejemplares.imprimir();
                dm.afiliados.imprimir();
                System.out.println("__________________________");
                this.dispose();
            }
            }else {
                JOptionPane.showMessageDialog(null, "El codigo solo debe estar comformado por numeros. Intentelo de nuevo.", "Error", 0);
                codigo.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema con los datos ingresados. Intentelo de nuevo.", "Error", 0);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            if (dm.isNumeric(codigo.getText())) {
                if (!dm.verificarCodigo(Integer.parseInt(codigo.getText()))) {
                    JOptionPane.showMessageDialog(null, "El codigo de afiliado que ingreso no existe.", "Error", 0);
                    codigo.setText("");

                } else {
                    dm.escogerDLibro(Integer.parseInt(codigo.getText()));
                }
            } else {
                JOptionPane.showMessageDialog(null, "El codigo solo debe estar comformado por numeros. Intentelo de nuevo.", "Error", 0);
                codigo.setText("");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema con los datos ingresados. Intentelo de nuevo.", "Error", 0);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DevolverLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DevolverLibro dialog = new DevolverLibro(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel DAutor;
    public static javax.swing.JLabel DLibro;
    private javax.swing.JTextField codigo;
    private javax.swing.JSpinner fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}

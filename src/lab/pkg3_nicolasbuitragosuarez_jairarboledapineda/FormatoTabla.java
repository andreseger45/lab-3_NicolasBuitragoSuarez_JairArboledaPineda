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
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


class FormatoTabla extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable jTable1, Object value, boolean selected, boolean focused, int row, int column) {
        {
            setEnabled(jTable1 == null || jTable1.isEnabled());
            {
                if ("Disponible".equals(jTable1.getValueAt(row, column))) {
                    this.setOpaque(true);
                    this.setBackground(Color.GREEN);
//                    this.setForeground(Color.BLACK);
                } else if ("No disponible".equals(jTable1.getValueAt(row, column))) {
                    this.setOpaque(true);
                    this.setBackground(Color.RED);
//                    this.setForeground(Color.BLACK);
                } else {
                    this.setOpaque(false);
                }
                super.getTableCellRendererComponent(jTable1, value, selected, focused, row, column);
                return this;
            }
        }
    }
}

package Paint2D;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author curro
 */
public class CellRendererColor extends MiCellRenderer<Color>{
    
    @Override
    public Component getListCellRendererComponent(JList jlist, Color e, int i, boolean seleccion, boolean foco) {
       
        PanelColor panel=new PanelColor(e);
        
        if(seleccion){
            panel.setBackground(Color.LIGHT_GRAY);
        }
        else{
            panel.setBackground(Color.WHITE);
        }
        
        return panel;
    }
    
}

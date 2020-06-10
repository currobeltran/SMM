/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paint2D;

import java.awt.Component;
import java.awt.color.ColorSpace;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author curro
 */
public class CellRendererColorSpace extends MiCellRenderer<Integer>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Integer> jlist, Integer e, int i, boolean bln, boolean bln1) {
        JLabel salida=new JLabel();
        
        switch(e){
            case ColorSpace.CS_GRAY: 
                salida.setText("Gray");
            break;
                
            case ColorSpace.CS_sRGB:
                salida.setText("RGB");
            break;
                
            case ColorSpace.CS_PYCC:
                salida.setText("YCC");
            break;
        }
        
        return salida;
    }
    
}

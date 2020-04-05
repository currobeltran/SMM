/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author curro
 */
public class MiCellRenderer extends JLabel implements ListCellRenderer{

    MiCellRenderer(){
        setOpaque(true);
    }
    
    @Override
    public Component getListCellRendererComponent(JList jlist, Object e, int i, boolean seleccion, boolean foco) {
        
        setIcon(new ColorIcon((Color)e));
        
        if(seleccion){
            setBackground(Color.LIGHT_GRAY);
        }
        else{
            setBackground(Color.WHITE);
        }
        
        return this;
    }
    
}

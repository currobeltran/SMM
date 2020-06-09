/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paint2D;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import sm.image.KernelProducer;
/**
 *
 * @author curro
 */
public class CellRendererFiltros extends JLabel implements ListCellRenderer<Integer>{

    @Override
    public Component getListCellRendererComponent(JList<? extends Integer> jlist, Integer e, int i, boolean bln, boolean bln1) {
        JLabel salida=new JLabel();
        
        switch(e){
            case KernelProducer.TYPE_BINOMIAL_3x3:
                salida.setText("Binomial");
            break;
                
            case KernelProducer.TYPE_ENFOQUE_3x3:
                salida.setText("Enfoque");
            break;
                
            case KernelProducer.TYPE_LAPLACIANA_3x3:
                salida.setText("Laplaciana");
            break;
                
            case KernelProducer.TYPE_MEDIA_3x3:
                salida.setText("Media");
            break;
                
            case KernelProducer.TYPE_RELIEVE_3x3:
                salida.setText("Relieve");
            break;
                
            case 6:
                salida.setText("Media 5x5");
            break;
                
            case 7:
                salida.setText("Media 7x7");
            break;
        }
        
        return salida;
    }

}

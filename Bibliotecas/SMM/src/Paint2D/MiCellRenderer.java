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

/**
 *
 * @author curro
 */
public abstract class MiCellRenderer<T> extends JLabel implements ListCellRenderer<T>{
    
    @Override
    public abstract Component getListCellRendererComponent(JList<? extends T> jlist, T e, int i, boolean bln, boolean bln1);
}

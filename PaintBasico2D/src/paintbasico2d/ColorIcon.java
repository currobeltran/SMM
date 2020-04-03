/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.border.Border;

/**
 *
 * @author curro
 */
public class ColorIcon implements javax.swing.Icon{

    private Color c;
    private RoundRectangle2D r=new RoundRectangle2D.Float();
    
    ColorIcon(Color c){
        super();
        this.c=c;
    }
    
    @Override
    public void paintIcon(Component comp, Graphics g, int x, int y) {
        JComponent comp2=(JComponent)comp;
        
        Graphics2D g2d=(Graphics2D) g;
        g2d.setColor(c);
        g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        
        r.setRoundRect(x+5, y, 25, 25, 10, 10);
        
        g2d.fill(r);
        
        g2d.setColor(Color.BLACK);
        
        g2d.draw(r);
    }

    @Override
    public int getIconWidth() {
        return 25;
    }

    @Override
    public int getIconHeight() {
        return 25;
    }
    
}

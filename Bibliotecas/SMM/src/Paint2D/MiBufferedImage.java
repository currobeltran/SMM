/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paint2D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author curro
 */
public class MiBufferedImage extends BufferedImage{

    public MiBufferedImage(int w, int h, int i2) {
        super(w, h, i2);
        Graphics2D g2d=(Graphics2D)this.getGraphics();
        
        g2d.setPaint(Color.WHITE);
        Rectangle r=new Rectangle(w,h);
        
        g2d.fill(r);
    }
    
}

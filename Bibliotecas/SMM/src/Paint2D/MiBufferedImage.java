/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paint2D;

import MiGraphics2D.Drawable;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author curro
 */
public class MiBufferedImage extends Drawable{

    private BufferedImage imagen;
    
    public MiBufferedImage(BufferedImage img){
        this.imagen=img;
    }
    
    public MiBufferedImage(int w, int h, int i2) {
        this.imagen=new BufferedImage(w, h, i2);
        Graphics2D g2d=(Graphics2D)imagen.getGraphics();
        
        g2d.setPaint(Color.WHITE);
        Rectangle r=new Rectangle(w,h);
        
        g2d.fill(r);
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
       
    @Override
    public void draw(Graphics2D g2d, Lienzo l) {
        if(imagen!=null){
            g2d.drawImage(imagen, 0, 0, l);
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package paintbasico2d;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author curro
 */
public class MiElipse2D extends Ellipse2D.Double{
    
    MiElipse2D(){
        super();
    }

    MiElipse2D(Point2D p, int i, int i0) {
        super(p.getX(),p.getY(),i,i0);
    }
    
    public void setLocation(Point2D pos){
        this.setFrame(new Rectangle2D.Double(pos.getX(), pos.getY(), this.width, this.height));
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paint2D;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author curro
 */
public class MiLinea2D extends Line2D.Double{

    public MiLinea2D(){
        super();
    }
    
    public MiLinea2D(Point2D point, Point2D point0) {
        super(point,point0);
    }
    
    public boolean isNear(Point2D p){
        return this.ptLineDist(p)<=2.0;
    }

    @Override
    public boolean contains(Point2D p){
        return this.isNear(p);
    }
    
    public void setLocation(Point2D pos){
        double dx=pos.getX()-this.getX1();
        double dy=pos.getY()-this.getY1();
        Point2D newp2=new Point2D.Double(this.getX2()+dx,this.getY2()+dy);
        this.setLine(pos,newp2);
    }
}

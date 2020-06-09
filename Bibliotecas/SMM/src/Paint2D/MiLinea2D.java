/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paint2D;

import MiGraphics2D.MiGraphics2D;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

/**
 *
 * @author curro
 */
public class MiLinea2D extends MiGraphics2D{

    private Line2D linea;
    
    public MiLinea2D(Point2D point, Point2D point0, Paint colorTrazo, Paint colorRelleno, int trazo, boolean relleno,
            boolean alisado, boolean transparencia, boolean discontinuidad, boolean liso,
            boolean degradadoHorizontal, Color colorDegradado1, Color colorDegradado2) {
        
        super(colorTrazo, colorRelleno, trazo, relleno, alisado, transparencia, discontinuidad, liso,
                degradadoHorizontal, colorDegradado1, colorDegradado2);
        
        linea=new Line2D.Double(point, point0);
        setFigura(linea);
    }
    
    public boolean isNear(Point2D p){
        return linea.ptLineDist(p)<=2.0;
    }

    @Override
    public boolean contains(Point2D p){
        return this.isNear(p);
    }
    
    @Override
    public void setLocation(Point2D pos){
        double dx=pos.getX()-linea.getX1();
        double dy=pos.getY()-linea.getY1();
        Point2D newp2=new Point2D.Double(linea.getX2()+dx,linea.getY2()+dy);
        linea.setLine(pos,newp2);
    }

    @Override
    public void modify(Point2D nuevo1, Point2D nuevo2) {
        linea.setLine(nuevo1, nuevo2);
    }
}

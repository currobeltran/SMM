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
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author curro
 */
public class MiElipse2D extends MiGraphics2D{
    
    private Ellipse2D.Double elipse;

    public MiElipse2D(Point2D p, int i, int i0, Paint colorTrazo, Paint colorRelleno, int trazo, boolean relleno,
            boolean alisado, boolean transparencia, boolean discontinuidad, boolean liso,
            boolean degradadoHorizontal, Color colorDegradado1, Color colorDegradado2) {
        
        super(colorTrazo, colorRelleno, trazo,relleno,alisado,transparencia, discontinuidad, liso,
                degradadoHorizontal, colorDegradado1, colorDegradado2);
        
        elipse=new Ellipse2D.Double(p.getX(), p.getY(), i, i0);
        setFigura(elipse);
    }

    @Override
    public boolean contains(Point2D p) {
        if(elipse.getFrame().contains(p)){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public void setLocation(Point2D pos){
        elipse.setFrame(new Rectangle2D.Double(pos.getX(), pos.getY(), elipse.width, elipse.height));
    }   

    @Override
    public void modify(Point2D nuevo1, Point2D nuevo2) {
        elipse.setFrameFromDiagonal(nuevo1, nuevo2);
    }
    
}

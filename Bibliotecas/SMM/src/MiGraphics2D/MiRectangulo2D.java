/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MiGraphics2D;

import java.awt.Color;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.geom.Point2D;

/**
 *
 * @author curro
 */
public class MiRectangulo2D extends MiGraphics2D{

    private Rectangle rectangulo;
    
    public MiRectangulo2D(int x, int y, int ancho, int alto, Paint colorTrazo, Paint colorRelleno, int trazo, boolean relleno,
            boolean alisado, boolean transparencia, boolean discontinuidad, boolean liso,
            boolean degradadoHorizontal, Color colorDegradado1, Color colorDegradado2) {
        
        super(colorTrazo, colorRelleno, trazo,relleno,alisado,transparencia, discontinuidad, liso,
                degradadoHorizontal, colorDegradado1, colorDegradado2);
        
        rectangulo=new Rectangle(x, y, ancho, alto);
        setFigura(rectangulo);
    }
    
    @Override
    public void setLocation(Point2D pos) {
        rectangulo.setLocation((Point) pos);
    }

    @Override
    public boolean contains(Point2D p) {
        return rectangulo.contains((Point) p);
    }

    @Override
    public void modify(Point2D nuevo1, Point2D nuevo2) {
        rectangulo.setFrameFromDiagonal(nuevo1, nuevo2);
    }
    
}

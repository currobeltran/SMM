/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MiGraphics2D;

import Paint2D.Lienzo;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author curro
 */
public abstract class MiGraphics2D{
    private Paint colorTrazo;
    private Paint colorRelleno;
    private Color color1;
    private Color color2;
    private GradientPaint colorDegradado;
    
    private int trazo=1;
    private boolean relleno=false;
    private boolean alisado=false;
    private boolean transparencia=false;
    private Shape figura;
    private BufferedImage imagenFondo;
    private boolean selected=false;
    private boolean discontinuidad=false;
    private boolean liso=true;
    private boolean degradadoHorizontal=false;
    private float gradoTransparencia;
    
    private final float dash[]={10.0f};
    
    public MiGraphics2D(Paint colorTrazo, Paint colorRelleno, int trazo, boolean relleno, boolean alisado, 
            boolean transparencia, boolean discontinuidad, boolean liso, boolean degradadoHorizontal, 
            Color color1, Color color2, float gradoTransparencia){
        this.colorTrazo=colorTrazo;
        this.colorRelleno=colorRelleno;
        this.trazo=trazo;
        this.relleno=relleno;
        this.alisado=alisado;
        this.transparencia=transparencia;
        this.discontinuidad=discontinuidad;
        this.liso=liso;
        this.degradadoHorizontal=degradadoHorizontal;
        this.color1=color1;
        this.color2=color2;
        this.gradoTransparencia=gradoTransparencia;
    }

    public Paint getColorTrazo() {
        return colorTrazo;
    }

    public void setColorTrazo(Paint colorTrazo) {
        this.colorTrazo = colorTrazo;
    }

    public Paint getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(Paint colorRelleno) {
        this.colorRelleno = colorRelleno;
    }
    
    public int getTrazo() {
        return trazo;
    }

    public void setTrazo(int trazo) {
        this.trazo = trazo;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public boolean isAlisado() {
        return alisado;
    }

    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
    }

    public boolean isTransparencia() {
        return transparencia;
    }

    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
    }

    public Shape getFigura() {
        return figura;
    }

    public void setFigura(Shape figura) {
        this.figura = figura;
    }

    public BufferedImage getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(BufferedImage imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isDiscontinuidad() {
        return discontinuidad;
    }

    public void setDiscontinuidad(boolean discontinuidad) {
        this.discontinuidad = discontinuidad;
    }

    public boolean isLiso() {
        return liso;
    }

    public void setLiso(boolean liso) {
        this.liso = liso;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    public boolean isDegradadoHorizontal() {
        return degradadoHorizontal;
    }

    public void setDegradadoHorizontal(boolean degradadoHorizontal) {
        this.degradadoHorizontal = degradadoHorizontal;
    }

    public float getGradoTransparencia() {
        return gradoTransparencia;
    }

    public void setGradoTransparencia(float gradoTransparencia) {
        this.gradoTransparencia = gradoTransparencia;
    }
           
    public abstract void setLocation(Point2D pos);
    
    public abstract boolean contains(Point2D p);
    
    public abstract void modify(Point2D nuevo1, Point2D nuevo2);
    
    public void draw(Graphics2D g2d, Lienzo l){
         
        if(imagenFondo!=null){
            g2d.drawImage(imagenFondo, 0, 0, l);
        }
        
        if(discontinuidad){
            g2d.setStroke(new BasicStroke(trazo, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 10.0f, dash, 0.0f)); 
        }
        else{
            g2d.setStroke(new BasicStroke(trazo));
        }
        
        if(transparencia){
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, gradoTransparencia));
        }
        else{            
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
        
        if(alisado){
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
        }
        else{
            g2d.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF));
        }
        
        if(relleno){
            if(!liso){
                if(this.degradadoHorizontal){
                    Point2D puntoIzq=new Point2D.Float(0,figura.getBounds().height/2);
                    Point2D puntoDer=new Point2D.Float(figura.getBounds().width,figura.getBounds().height/2); 

                    colorDegradado=new GradientPaint(puntoIzq,color1,puntoDer,color2);
                }
                else{
                    Point2D puntoArr=new Point2D.Float(figura.getBounds().width/2,figura.getBounds().height);
                    Point2D puntoAbj=new Point2D.Float(figura.getBounds().width/2,0);

                    colorDegradado=new GradientPaint(puntoArr,color1,puntoAbj,color2);
                }
                g2d.setPaint(colorDegradado);
            }
            else{
                g2d.setPaint(colorRelleno);
            }
            g2d.fill(figura);
        }
             
        g2d.setPaint(colorTrazo);
        g2d.draw(figura);
        
        if(selected){
            g2d.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 10.0f, dash, 0.0f));
            g2d.draw(figura.getBounds2D());
        }    
    }
}

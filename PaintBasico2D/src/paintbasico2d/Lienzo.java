package paintbasico2d;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 *
 * @author Francisco Beltrán Sánchez
 */
public class Lienzo extends javax.swing.JPanel {
    
    //Atributos de la clase
    private Herramientas herramienta=Herramientas.Punto;
    private ArrayList<Shape> formas=new ArrayList();
    private Line2D lineaActiva;
    private Rectangle cuadradoActivo;
    private Ellipse2D ovaloActivo;
    private Point2D paux;
    private BasicStroke grosor=new BasicStroke(1);
    private Paint color=Color.BLACK;
    private boolean relleno=false;

    //Getters y setters de los atributos de la clase
    
    public void setHerramienta(Herramientas herramienta) {
        this.herramienta = herramienta;
    }

    public Herramientas getHerramienta() {
        return herramienta;
    }

    public void setGrosor(BasicStroke grosor) {
        this.grosor = grosor;
        this.repaint();
    }

    public void setColor(Paint color) {
        this.color = color;
        this.repaint();
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
        this.repaint();
    }

    public boolean isRelleno() {
        return relleno;
    }
    
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
    }// </editor-fold>//GEN-END:initComponents

    /**
     * En esta funcion y la siguiente igualamos pfinal a pinicial ya que, al ser
     * estos los dos eventos que provocan el dibujado de una nueva figura, 
     * necesitamos reinciar el valor de los atributos que definen la geometría 
     * de la nueva forma. 
     * 
     * Para pinicial vemos cual ha sido el punto donde se ha generado el evento
     * (click o presión), y este valor se lo establecemos a pfinal, ya que en un
     * primer instante el punto inicial y el final deben ser iguales hasta que 
     * generemos un evento que actualice el valor del atributo pfinal (eventos 
     * mouseDragged y mouseReleased).
     * 
     * Cuando estén todos los atributos actualizados tras el evento, llamamos al
     * método paint(), el cual dibujará los cambios en el lienzo.
     */
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(herramienta==Herramientas.Punto)
            formas.add(new Line2D.Float(evt.getPoint(), evt.getPoint()));
        
        this.repaint();
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        paux=evt.getPoint();
        
        switch(herramienta){
            case Linea:
                formas.add(new Line2D.Double(evt.getPoint(), evt.getPoint()));
            break;
                
            case Cuadrado:
                formas.add(new Rectangle(evt.getX(), evt.getY(), 0, 0));
            break;
                
            case Ovalo:
                formas.add(new Ellipse2D.Double(evt.getX(), evt.getY(), 0, 0));
            break;
        }
                
        this.repaint();     
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        switch(herramienta){
            case Linea:
                lineaActiva=(Line2D)formas.get(formas.size()-1);
                lineaActiva.setLine(lineaActiva.getP1(), evt.getPoint());
            break;
                
            case Cuadrado:
                cuadradoActivo=(Rectangle)formas.get(formas.size()-1);
                cuadradoActivo.setFrameFromDiagonal(paux,evt.getPoint());
            break;
                
            case Ovalo:
                ovaloActivo=(Ellipse2D)formas.get(formas.size()-1);
                ovaloActivo.setFrameFromDiagonal(paux, evt.getPoint());
            break;
        }
        
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        formMouseDragged(evt);
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        Graphics2D g2d=(Graphics2D)g; 
        
        g2d.setPaint(color);
        
        g2d.setStroke(grosor);
         
        for(Shape s : formas){
            if(!relleno)
                g2d.draw(s);
            else
                g2d.fill(s);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

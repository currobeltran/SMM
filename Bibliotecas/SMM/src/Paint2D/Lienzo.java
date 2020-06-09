package Paint2D;

import MiGraphics2D.MiGraphics2D;
import MiGraphics2D.MiRectangulo2D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Francisco Beltrán Sánchez
 */
public class Lienzo extends javax.swing.JPanel {
    
    //Atributos de la clase
    private Herramientas herramienta=Herramientas.Punto;
    private ArrayList<MiGraphics2D> formas=new ArrayList();
    private Point2D p1;
    private int grosor=1;
    
    private Paint colorTrazo=Color.BLACK;
    private Paint colorRelleno=Color.BLACK;
    private Paint colorDegradado1=Color.BLACK;
    private Paint colorDegradado2=Color.BLACK;
    
    private boolean rellenoColorActivado=false;
    private boolean relleno=false;
    private boolean editar=false;
    private boolean transparencia=false;
    private boolean alisado=false;
    private MiGraphics2D formaSeleccionada=null;
    private BufferedImage imagenFondo;
    private boolean discontinuidad=false;
    private boolean liso=true;
    private boolean degradadoHorizontal=false;
    private ArrayList<LienzoListener> lienzoEventListeners=new ArrayList();
    
    //Getters y setters de los atributos de la clase
    
    public void setHerramienta(Herramientas herramienta) {
        this.herramienta = herramienta;
    }

    public Herramientas getHerramienta() {
        return herramienta;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
        this.repaint();
    }

    public int getGrosor() {
        return grosor;
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
    
    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
        this.repaint();
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    public boolean isEditar(){
        return editar;
    }

    public void setTransparencia(boolean transparencia) {
        this.transparencia = transparencia;
        this.repaint();
    }

    public boolean isTransparencia() {
        return transparencia;
    }
    
    public void setAlisado(boolean alisado) {
        this.alisado = alisado;
        this.repaint();
    }

    public boolean isAlisado() {
        return alisado;
    }

    public MiGraphics2D getFormaSeleccionada() {
        return formaSeleccionada;
    }

    public boolean isRellenoColorActivado() {
        return rellenoColorActivado;
    }

    public void setRellenoColorActivado(boolean rellenoColorActivado) {
        this.rellenoColorActivado = rellenoColorActivado;
    }

    public boolean isDiscontinuidad() {
        return discontinuidad;
    }

    public void setDiscontinuidad(boolean discontinuidad) {
        this.discontinuidad = discontinuidad;
    }

    public Paint getcolorDegradado1() {
        return colorDegradado1;
    }

    public void setcolorDegradado1(Paint colorDegradado1) {
        this.colorDegradado1 = colorDegradado1;
    }

    public Paint getcolorDegradado2() {
        return colorDegradado2;
    }

    public void setcolorDegradado2(Paint colorDegradado2) {
        this.colorDegradado2 = colorDegradado2;
    }

    public boolean isLiso() {
        return liso;
    }

    public void setLiso(boolean liso) {
        this.liso = liso;
    }

    public boolean isDegradadoHorizontal() {
        return degradadoHorizontal;
    }

    public void setDegradadoHorizontal(boolean degradadoHorizontal) {
        this.degradadoHorizontal = degradadoHorizontal;
    }
    
    public BufferedImage getImagenFondo(boolean drawVector) {
        if(drawVector){
            BufferedImage imgout=new BufferedImage(imagenFondo.getWidth(),
                                                   imagenFondo.getHeight(),
                                                   imagenFondo.getType());
            
            boolean opacoActual=this.isOpaque();
            if(imagenFondo.getColorModel().hasAlpha()){
                this.setOpaque(false);
            }
            
            this.paint(imgout.createGraphics());
            this.setOpaque(opacoActual);
            return(imgout);
        }
        
        else
            return imagenFondo;
    }

    public void setImagenFondo(BufferedImage imagenFondo) {
        this.imagenFondo = imagenFondo;
        if(imagenFondo!=null){
            setPreferredSize(new Dimension(imagenFondo.getWidth(),imagenFondo.getHeight()));
            if(formaSeleccionada!=null){
                formaSeleccionada.setImagenFondo(imagenFondo);
            }
        }
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
        });
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Al presionar con el raton en el lienzo, dependiendo del modo, pueden 
     * ocurrir dos cosas:
     *      - Se crea una nueva figura si no estamos en modo editar dependiendo
     *      de cual sea la herramienta seleccionada
     *      - Se selecciona la figura que este situada en el punto donde se haya
     *      generado el evento
     * @param evt 
     */
    
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if(formaSeleccionada!=null){
            formaSeleccionada.setSelected(false);
        }
        
        if(!editar)
            createShape(evt);
        else if(formaSeleccionada!=null){
            formaSeleccionada=setSelectedShape(evt.getPoint());
            cambiarAtributosSegunForma();
            
            if(formaSeleccionada!=null){
                formaSeleccionada.setSelected(true);
                notifyEdicionFigura(null);
            }
        }
        this.repaint();    
    }//GEN-LAST:event_formMousePressed

    /**
     * En los dos eventos siguientes, se llama a la misma funcion, la cual se 
     * encarga de actualizar una figura ya creada. Dependiendo del modo, pueden
     * ocurrir dos cosas:
     *      - Si el modo editar esta activado, la figura seleccionada se 
     *      desplazará al lugar donde llevemos el raton.
     *      - En cambio, si este modo está desactivado, la figura que se creó 
     *      anteriormente al presionar cambiará de forma dependiendo del tipo 
     *      que sea.
     * @param evt 
     */
    
    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        updateShape(evt);
        this.repaint();
    }//GEN-LAST:event_formMouseDragged

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        updateShape(evt);
        this.repaint();
    }//GEN-LAST:event_formMouseReleased

    private void createShape(java.awt.event.MouseEvent evt){
        p1=evt.getPoint();
        
        switch(herramienta){
            case Punto:
                formaSeleccionada=new MiLinea2D(evt.getPoint(), evt.getPoint(), colorTrazo, colorRelleno, grosor, relleno,
                alisado, transparencia, discontinuidad, liso, degradadoHorizontal, (Color)colorDegradado1, 
                (Color) colorDegradado2);
            break;

            case Linea:
                formaSeleccionada=new MiLinea2D(evt.getPoint(), evt.getPoint(), colorTrazo, colorRelleno, grosor, relleno,
                alisado, transparencia, discontinuidad, liso, degradadoHorizontal, (Color)colorDegradado1, 
                (Color) colorDegradado2);
            break;

            case Cuadrado:
                formaSeleccionada=new MiRectangulo2D(evt.getX(), evt.getY(), 0, 0, colorTrazo, colorRelleno, grosor, relleno,
                alisado, transparencia, discontinuidad, liso, degradadoHorizontal, (Color)colorDegradado1, 
                (Color) colorDegradado2);
            break;

            case Ovalo:
                formaSeleccionada=new MiElipse2D(evt.getPoint(), 0, 0, colorTrazo, colorRelleno, grosor, relleno,
                alisado, transparencia, discontinuidad, liso, degradadoHorizontal, (Color)colorDegradado1, 
                (Color) colorDegradado2);
            break;
        }
        
        if(formaSeleccionada!=null){
            formas.add(formaSeleccionada);
        }
        
    }
    
    private void updateShape(java.awt.event.MouseEvent evt){
        MiGraphics2D s;
        
        if(editar){
            s=formaSeleccionada;
            if(s!=null)
                s.setLocation(evt.getPoint());
        }
        
        else{
            s=formas.get(formas.size()-1);
        
            if(s instanceof MiLinea2D && herramienta!=Herramientas.Punto){
                ((MiLinea2D)s).modify(p1,evt.getPoint());
            }     

            else if(s instanceof MiRectangulo2D){
                ((MiRectangulo2D)s).modify(p1,evt.getPoint());
            }

            else if(s instanceof MiElipse2D){
                ((MiElipse2D)s).modify(p1, evt.getPoint());
            }
        }
    }
    
    /**
     * Método que revisa si alguna figura del vector de formas del lienzo 
     * contiene el Point2D enviado como argumento.
     * @param p. Punto que debe contener la figura a seleccionar.
     * @return Shape s que contenga el punto, si no existen coincidencias 
     * devuelve null
     */
    
    private MiGraphics2D setSelectedShape(Point2D p){
        for (MiGraphics2D s : formas){
            if(s.contains(p)){
                return s;
            }
        }
        return null;
    }
    
    public void addLienzoListener(LienzoListener listener){
        if(listener!=null){
            lienzoEventListeners.add(listener);
        }
    }
    
    private void notifyEdicionFigura(LienzoEvent evt){
        if(!lienzoEventListeners.isEmpty()){
            for(LienzoListener listener : lienzoEventListeners){
                listener.edicionFigura(evt);
            }
        }
    }
    
    private void cambiarAtributosSegunForma(){
        if(formaSeleccionada!=null){
            colorRelleno=formaSeleccionada.getColorRelleno();
            colorTrazo=formaSeleccionada.getColorTrazo();
            discontinuidad=formaSeleccionada.isDiscontinuidad();
            relleno=formaSeleccionada.isRelleno();
            transparencia=formaSeleccionada.isTransparencia();
            alisado=formaSeleccionada.isAlisado();
        }
    }
    
    /**
     * Método que pinta los elementos que contenga el vector de formas
     * de la clase.
     * @param g 
     */
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        
        for(MiGraphics2D s : formas){
            s.draw(g2d, this);
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}

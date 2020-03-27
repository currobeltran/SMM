package PaintBasico;

import java.awt.Color;
import java.awt.Point;
import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author Francisco Beltrán Sánchez
 */
public class MarcoPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MarcoPrincipal
     */
    public MarcoPrincipal() {
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

        barraSuperior = new javax.swing.JPanel();
        menuHerramientas = new javax.swing.JToolBar();
        modoPunto = new javax.swing.JToggleButton();
        modoLinea = new javax.swing.JToggleButton();
        modoRectangulo = new javax.swing.JToggleButton();
        modoElipse = new javax.swing.JToggleButton();
        barraInferior = new javax.swing.JPanel();
        selectorColores = new javax.swing.JPanel();
        botonNegro = new javax.swing.JToggleButton();
        botonRojo = new javax.swing.JToggleButton();
        botonAzul = new javax.swing.JToggleButton();
        botonBlanco = new javax.swing.JToggleButton();
        botonAmarillo = new javax.swing.JToggleButton();
        botonVerde = new javax.swing.JToggleButton();
        modoRelleno = new javax.swing.JCheckBox();
        barraEstado = new javax.swing.JLabel();
        lienzo1 = new PaintBasico.Lienzo();
        barraMenu = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        opcionNuevo = new javax.swing.JMenuItem();
        opcionAbrir = new javax.swing.JMenuItem();
        opcionGuardar = new javax.swing.JMenuItem();
        menuEdicion = new javax.swing.JMenu();
        visibilidadBarraEstado = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        barraSuperior.setLayout(new java.awt.BorderLayout());

        modoPunto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaintBasico/iconos/Lapiz.gif"))); // NOI18N
        modoPunto.setFocusable(false);
        modoPunto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modoPunto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modoPunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoPuntoActionPerformed(evt);
            }
        });
        menuHerramientas.add(modoPunto);

        modoLinea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaintBasico/iconos/Linea.gif"))); // NOI18N
        modoLinea.setFocusable(false);
        modoLinea.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modoLinea.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modoLinea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoLineaActionPerformed(evt);
            }
        });
        menuHerramientas.add(modoLinea);

        modoRectangulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaintBasico/iconos/Rectangulo.gif"))); // NOI18N
        modoRectangulo.setFocusable(false);
        modoRectangulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modoRectangulo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modoRectangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoRectanguloActionPerformed(evt);
            }
        });
        menuHerramientas.add(modoRectangulo);

        modoElipse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaintBasico/iconos/Ovalo.gif"))); // NOI18N
        modoElipse.setFocusable(false);
        modoElipse.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modoElipse.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        modoElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoElipseActionPerformed(evt);
            }
        });
        menuHerramientas.add(modoElipse);

        barraSuperior.add(menuHerramientas, java.awt.BorderLayout.CENTER);

        getContentPane().add(barraSuperior, java.awt.BorderLayout.PAGE_START);

        barraInferior.setLayout(new java.awt.BorderLayout());

        selectorColores.setLayout(new java.awt.GridLayout(2, 0));

        botonNegro.setBackground(new java.awt.Color(0, 0, 0));
        botonNegro.setForeground(new java.awt.Color(0, 0, 0));
        botonNegro.setMaximumSize(new java.awt.Dimension(30, 30));
        botonNegro.setMinimumSize(new java.awt.Dimension(30, 30));
        botonNegro.setPreferredSize(new java.awt.Dimension(30, 30));
        botonNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNegroActionPerformed(evt);
            }
        });
        selectorColores.add(botonNegro);

        botonRojo.setBackground(new java.awt.Color(255, 0, 0));
        botonRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRojoActionPerformed(evt);
            }
        });
        selectorColores.add(botonRojo);

        botonAzul.setBackground(new java.awt.Color(0, 0, 255));
        botonAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAzulActionPerformed(evt);
            }
        });
        selectorColores.add(botonAzul);

        botonBlanco.setBackground(new java.awt.Color(255, 255, 255));
        botonBlanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBlancoActionPerformed(evt);
            }
        });
        selectorColores.add(botonBlanco);

        botonAmarillo.setBackground(new java.awt.Color(255, 255, 0));
        botonAmarillo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAmarilloActionPerformed(evt);
            }
        });
        selectorColores.add(botonAmarillo);

        botonVerde.setBackground(new java.awt.Color(0, 255, 0));
        botonVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVerdeActionPerformed(evt);
            }
        });
        selectorColores.add(botonVerde);

        barraInferior.add(selectorColores, java.awt.BorderLayout.LINE_START);

        modoRelleno.setText("Relleno");
        modoRelleno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoRellenoActionPerformed(evt);
            }
        });
        barraInferior.add(modoRelleno, java.awt.BorderLayout.LINE_END);

        barraEstado.setText("Hola");
        barraEstado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        barraInferior.add(barraEstado, java.awt.BorderLayout.SOUTH);

        getContentPane().add(barraInferior, java.awt.BorderLayout.PAGE_END);
        getContentPane().add(lienzo1, java.awt.BorderLayout.CENTER);

        menuArchivo.setText("Archivo");

        opcionNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaintBasico/iconos/Goma.gif"))); // NOI18N
        opcionNuevo.setText("Nuevo");
        opcionNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionNuevoActionPerformed(evt);
            }
        });
        menuArchivo.add(opcionNuevo);

        opcionAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaintBasico/iconos/NuevoBoceto.GIF"))); // NOI18N
        opcionAbrir.setText("Abrir");
        opcionAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(opcionAbrir);

        opcionGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PaintBasico/iconos/Guardar.gif"))); // NOI18N
        opcionGuardar.setText("Guardar");
        opcionGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionGuardarActionPerformed(evt);
            }
        });
        menuArchivo.add(opcionGuardar);

        barraMenu.add(menuArchivo);

        menuEdicion.setText("Edición");

        visibilidadBarraEstado.setText("Ver barra de estado");
        visibilidadBarraEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visibilidadBarraEstadoActionPerformed(evt);
            }
        });
        menuEdicion.add(visibilidadBarraEstado);

        barraMenu.add(menuEdicion);

        setJMenuBar(barraMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Para limpiar la pantalla generamos un punto en una posición del lienzo
     * que no sea visible, y la establecemos como punto inicial y final de una 
     * figura.
    */
    private void opcionNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionNuevoActionPerformed
        lienzo1.setPinicial(new Point(-10,-10));
        lienzo1.setPfinal(lienzo1.getPinicial());
        
        lienzo1.repaint();
    }//GEN-LAST:event_opcionNuevoActionPerformed

    /**
     * Acciones realizadas al seleccionar en la barra de herramientas el modo
     * punto. A parte de modificar el atributo herramienta de la clase lienzo,
     * se modifica el atributo de selección de los botones de herramientas, evitando que esten 
     * dos o más seleccionados, o que si se pulsa dos veces el mismo no se 
     * deseleccione el botón de la herramienta actual, indicando de manera clara
     * cual es la forma de dibujo seleccionada.
     *
     * @param evt 
     */
    private void modoPuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoPuntoActionPerformed
        lienzo1.setHerramienta(Herramientas.Punto);
        
        modoLinea.setSelected(false);
        modoRectangulo.setSelected(false);
        modoElipse.setSelected(false);
        modoPunto.setSelected(true);
        
        
        barraEstado.setText("Modo punto");
    }//GEN-LAST:event_modoPuntoActionPerformed

    /**
     * Acciones realizadas al seleccionar en la paleta de colores el rojo.
     * 
     * @param evt 
     */
    private void botonRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRojoActionPerformed
        lienzo1.setColor(Color.RED);
        barraEstado.setText("Color rojo seleccionado");
    }//GEN-LAST:event_botonRojoActionPerformed

    /**
     * Acciones realizadas al seleccionar en la paleta de colores el negro.
     * 
     * @param evt 
     */
    private void botonNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNegroActionPerformed
        lienzo1.setColor(Color.BLACK);
        barraEstado.setText("Color negro seleccionado");
    }//GEN-LAST:event_botonNegroActionPerformed

    /**
     * Acciones realizadas al seleccionar en la barra de herramientas el modo
     * línea. A parte de modificar el atributo herramienta de la clase lienzo,
     * se modifica el atributo de selección de los botones de herramientas, evitando que esten 
     * dos o más seleccionados, o que si se pulsa dos veces el mismo no se 
     * deseleccione el botón de la herramienta actual, indicando de manera clara
     * cual es la forma de dibujo seleccionada.
     * 
     * @param evt 
     */
    private void modoLineaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoLineaActionPerformed
        lienzo1.setHerramienta(Herramientas.Linea);
        
        modoPunto.setSelected(false);
        modoRectangulo.setSelected(false);
        modoElipse.setSelected(false);
        modoLinea.setSelected(true);
        
        barraEstado.setText("Modo línea");
    }//GEN-LAST:event_modoLineaActionPerformed

    /**
     * Acciones realizadas al seleccionar en la barra de herramientas el modo
     * rectángulo. A parte de modificar el atributo herramienta de la clase lienzo,
     * se modifica el atributo de selección de los botones de herramientas, evitando que esten 
     * dos o más seleccionados, o que si se pulsa dos veces el mismo no se 
     * deseleccione el botón de la herramienta actual, indicando de manera clara
     * cual es la forma de dibujo seleccionada.
     * 
     * @param evt 
     */
    private void modoRectanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoRectanguloActionPerformed
        lienzo1.setHerramienta(Herramientas.Cuadrado);
        
        modoPunto.setSelected(false);
        modoLinea.setSelected(false);
        modoElipse.setSelected(false);
        modoRectangulo.setSelected(true);
        
        barraEstado.setText("Modo rectángulo");
    }//GEN-LAST:event_modoRectanguloActionPerformed

    /**
     * Acciones realizadas al seleccionar en la barra de herramientas el modo
     * elipse/óvalo. A parte de modificar el atributo herramienta de la clase lienzo,
     * se modifica el atributo de selección de los botones de herramientas, evitando que esten 
     * dos o más seleccionados, o que si se pulsa dos veces el mismo no se 
     * deseleccione el botón de la herramienta actual, indicando de manera clara
     * cual es la forma de dibujo seleccionada.
     * 
     * @param evt 
     */
    private void modoElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoElipseActionPerformed
        lienzo1.setHerramienta(Herramientas.Ovalo);
        
        modoPunto.setSelected(false);
        modoLinea.setSelected(false);
        modoRectangulo.setSelected(false);
        modoElipse.setSelected(true);
                
        barraEstado.setText("Modo elipse");
    }//GEN-LAST:event_modoElipseActionPerformed

    /**
     * Acciones realizadas al seleccionar en la paleta de colores el azul.
     * 
     * @param evt 
     */
    private void botonAzulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAzulActionPerformed
        lienzo1.setColor(Color.BLUE);
        barraEstado.setText("Color azul seleccionado");
    }//GEN-LAST:event_botonAzulActionPerformed

    /**
     * Acciones realizadas al seleccionar en la paleta de colores el blanco.
     * 
     * @param evt 
     */
    private void botonBlancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBlancoActionPerformed
        lienzo1.setColor(Color.WHITE);
        barraEstado.setText("Color blanco seleccionado");
    }//GEN-LAST:event_botonBlancoActionPerformed

    /**
     * Acciones realizadas al seleccionar en la paleta de colores el amarillo.
     * 
     * @param evt 
     */
    private void botonAmarilloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAmarilloActionPerformed
        lienzo1.setColor(Color.YELLOW);
        barraEstado.setText("Color amarillo seleccionado");
    }//GEN-LAST:event_botonAmarilloActionPerformed

    /**
     * Acciones realizadas al seleccionar en la paleta de colores el verde.
     * 
     * @param evt 
     */
    private void botonVerdeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVerdeActionPerformed
        lienzo1.setColor(Color.GREEN);
        barraEstado.setText("Color verde seleccionado");
    }//GEN-LAST:event_botonVerdeActionPerformed

    /**
     * Acciones realizadas al marcar/desmarcar la casilla del modo relleno.
     * 
     * @param evt 
     */
    private void modoRellenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modoRellenoActionPerformed
        lienzo1.setRelleno(!lienzo1.isRelleno());
        if(lienzo1.isRelleno())
            barraEstado.setText("Relleno activado");
        else
            barraEstado.setText("Relleno desactivado");
    }//GEN-LAST:event_modoRellenoActionPerformed

    /**
     * Accion realizada al seleccionar en el menu de edición la visibilidad de 
     * la barra de estado.
     * 
     * @param evt 
     */
    private void visibilidadBarraEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visibilidadBarraEstadoActionPerformed
        barraEstado.setVisible(!barraEstado.isVisible());
    }//GEN-LAST:event_visibilidadBarraEstadoActionPerformed

    /**
     * Accion realizada al seleccionar en el menu de archivo la opción abrir. No
     * se abre ningún archivo ya que no tendría sentido en el programa, solo se 
     * abre la ventana de diálogo correspondiente.
     * 
     * @param evt 
     */
    private void opcionAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAbrirActionPerformed
        JFileChooser dlg=new JFileChooser();
        int resp=dlg.showOpenDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            File f =dlg.getSelectedFile();
        }
    }//GEN-LAST:event_opcionAbrirActionPerformed

    /**
     * Accion realizada al seleccionar en el menu de archivo la opción guardar. No
     * se guarda ningún archivo ya que no tendría sentido en el programa, solo se 
     * abre la ventana de diálogo correspondiente.
     * 
     * @param evt 
     */
    private void opcionGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionGuardarActionPerformed
        JFileChooser dlg=new JFileChooser();
        int resp=dlg.showSaveDialog(this);
        if(resp==JFileChooser.APPROVE_OPTION){
            File f =dlg.getSelectedFile();
        }
    }//GEN-LAST:event_opcionGuardarActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barraEstado;
    private javax.swing.JPanel barraInferior;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JPanel barraSuperior;
    private javax.swing.JToggleButton botonAmarillo;
    private javax.swing.JToggleButton botonAzul;
    private javax.swing.JToggleButton botonBlanco;
    private javax.swing.JToggleButton botonNegro;
    private javax.swing.JToggleButton botonRojo;
    private javax.swing.JToggleButton botonVerde;
    private PaintBasico.Lienzo lienzo1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenu menuEdicion;
    private javax.swing.JToolBar menuHerramientas;
    private javax.swing.JToggleButton modoElipse;
    private javax.swing.JToggleButton modoLinea;
    private javax.swing.JToggleButton modoPunto;
    private javax.swing.JToggleButton modoRectangulo;
    private javax.swing.JCheckBox modoRelleno;
    private javax.swing.JMenuItem opcionAbrir;
    private javax.swing.JMenuItem opcionGuardar;
    private javax.swing.JMenuItem opcionNuevo;
    private javax.swing.JPanel selectorColores;
    private javax.swing.JMenuItem visibilidadBarraEstado;
    // End of variables declaration//GEN-END:variables
}
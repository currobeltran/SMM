/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica8;

import Paint2D.Lienzo;
import Paint2D.Lienzo;

/**
 *
 * @author curro
 */
public class MarcoSecundario extends javax.swing.JInternalFrame {
    
    /**
     * Creates new form MarcoSecundario
     */
    public MarcoSecundario() {
        initComponents();
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
    }

    public Lienzo getLienzo(){
        return lienzo;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lienzo = new Paint2D.Lienzo();

        javax.swing.GroupLayout lienzoLayout = new javax.swing.GroupLayout(lienzo);
        lienzo.setLayout(lienzoLayout);
        lienzoLayout.setHorizontalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        lienzoLayout.setVerticalGroup(
            lienzoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        getContentPane().add(lienzo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Paint2D.Lienzo lienzo;
    // End of variables declaration//GEN-END:variables
}

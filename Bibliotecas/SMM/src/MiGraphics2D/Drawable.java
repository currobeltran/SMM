/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MiGraphics2D;

import Paint2D.Lienzo;
import java.awt.Graphics2D;

/**
 *
 * @author curro
 */
public abstract class Drawable {
    public abstract void draw(Graphics2D g2d, Lienzo l);
}

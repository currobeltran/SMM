/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Paint2D;

import java.awt.image.Kernel;

/**
 *
 * @author curro
 */
public class MisFiltros {
    public static float[] media5x5=new float[25];
    public static float[] media7x7=new float[49];
    
    public static Kernel createMedia5x5(){
        for(int i=0; i<25; i++){
            media5x5[i]=0.1f;
        }
        
        return new Kernel(5,5,media5x5);
    }
    
    public static Kernel createMedia7x7(){
        for(int i=0; i<49; i++){
            media7x7[i]=0.1f;
        }
        
        return new Kernel(7,7,media7x7);
    }
}

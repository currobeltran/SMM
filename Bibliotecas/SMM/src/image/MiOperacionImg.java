/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package image;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import sm.image.BufferedImageOpAdapter;

/**
 *
 * @author curro
 */
public class MiOperacionImg extends BufferedImageOpAdapter{ //NO FUNCIONA

    private int umbral;
    private int diferencia;
    
    public MiOperacionImg(int umbral, int diferencia){
        this.umbral=umbral;
        this.diferencia=diferencia;
    }
    
    @Override
    public BufferedImage filter(BufferedImage src, BufferedImage dest) {
        if(src==null){
            throw new NullPointerException("src image is null");
        }
        
        if(dest==null){
            dest=createCompatibleDestImage(src,null);
        }
        
        WritableRaster srcRaster=src.getRaster();
        WritableRaster destRaster=dest.getRaster();
        int[] pixelComp=new int[srcRaster.getNumBands()];
        int[] pixelCompDest=new int[destRaster.getNumBands()];
        
        for(int x=0; x<src.getWidth(); x++)
            for(int y=0; y<src.getHeight(); y++){
                srcRaster.getPixel(x, y, pixelComp);
                int media=(pixelComp[0]+pixelComp[1]+pixelComp[2])/3;
                
                if(media<(umbral-diferencia)){
                    pixelCompDest[0]=0+(pixelComp[0]/2);
                    pixelCompDest[1]=(48/2)+(pixelComp[1]/2);
                    pixelCompDest[2]=(80/2)+(pixelComp[2]/2);
                }
                else if(media>(umbral+diferencia)){
                    pixelCompDest[0]=(218/2)+(pixelComp[0]/2);
                    pixelCompDest[1]=(20/2)+(pixelComp[1]/2);
                    pixelCompDest[2]=(21/2)+(pixelComp[2]/2);
                }
                else{
                    pixelCompDest[0]=(255/2)+(pixelComp[0]/2);
                    pixelCompDest[1]=(200/2)+(pixelComp[1]/2);
                    pixelCompDest[2]=(87/2)+(pixelComp[2]/2);
                }
                
                destRaster.setPixel(x, y, pixelCompDest);
            }
        
        return dest;
    }
    
}

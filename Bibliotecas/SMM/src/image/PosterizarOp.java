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
public class PosterizarOp extends BufferedImageOpAdapter{

    private int niveles;
    
    public PosterizarOp(int niveles){
        this.niveles=niveles;
    }
    
    /**
     * La posterizacion consiste en reducir el numero de colores presentes en 
     * una imagen a un numero determinado de niveles. Este efecto se vera 
     * claramente en zonas donde los colores tengan unos valores muy similares 
     * entre ellos, ya que pasaran a tener el mismo color.
     * 
     * Este efecto se consigue con la operacion k*Math.floor(sample/k); siendo
     * k=256 entre los niveles de color establecidos; y sample el valor
     * de un componente de un pixel. Por tanto, tendremos que recorrer todos los 
     * componentes de todos los pixeles de la imagen aplicando esta formula. 
     * 
     * Ademas, en la funcion vemos dos condiciones para comprobar tanto si se 
     * ha pasado una imagen fuente nula (que lanza un error) como destino (que
     * aplica la funcion createCompatibleDestImage para generar una copia de 
     * la fuente en la variable dest).
     * 
     * 
     * @param src
     * @param dest
     * @return 
     */
    
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
        int sample;
        
        for(int x=0; x<src.getWidth(); x++)
            for(int y=0; y<src.getHeight(); y++)
                for(int band=0; band<srcRaster.getNumBands(); band++){
                    sample=srcRaster.getSample(x,y,band);
                    int k=256/niveles;
                    sample=(int)(k*Math.floor(sample/k));
                    destRaster.setSample(x,y,band,sample);
                }
        return dest;
    }
    
}

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
public class RedOp extends BufferedImageOpAdapter{
    
    private int umbral;
    
    public RedOp(int umbral){
        this.umbral=umbral;
    }

    /**
     * Al aplicar la siguiente funcion sobre una imagen, se cambian todos los
     * colores de la imagen que no sean rojo por su correspondiente tonalidad
     * de gris. Esto se consigue recorriendo cada pixel de la imagen y 
     * comprobando que la diferencia entre la banda roja y la suma de las otras 
     * dos es mayor o igual que un umbral definido a la hora de crear el objeto.
     * Si es asi, el pixel se queda con su valor original, pero si no se cambia
     * el valor de todos los componentes a la media de las 3 bandas, convirtiendo
     * ese pixel a su valor de gris correspondiente.
     * 
     * La forma de actuar es similar al posterizado, ya que obtenemos el Raster
     * tanto de la fuente como del destino para poder obtener las caracteristicas
     * necesarias de un determinado pixel y poder editarlo respectivamente. 
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
        int[] pixelComp=new int[srcRaster.getNumBands()];
        int[] pixelCompDest=new int[destRaster.getNumBands()];
        
        for(int x=0; x<src.getWidth(); x++)
            for(int y=0; y<src.getHeight(); y++){
                srcRaster.getPixel(x, y, pixelComp);
                
                int dif=pixelComp[0]-(pixelComp[1]+pixelComp[2]);
                
                if(dif<umbral){
                    int media=(pixelComp[0]+pixelComp[1]+pixelComp[2])/3;
                    for(int i=0; i<3; i++){
                        pixelCompDest[i]=media;
                    }
                }
                else{
                    pixelCompDest=pixelComp;
                }
                
                destRaster.setPixel(x, y, pixelCompDest);
            }
        return dest;
    }
    
}

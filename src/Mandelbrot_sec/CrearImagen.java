/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mandelbrot_sec;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *Clase que genera la imagen de extensión "png" y lle da color al mandelbrot
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class CrearImagen {
    /**
     * Metodo acomoda por medio de colores y genera la imagen en un archivo .png
     * @param tam recibe el tamaño de la imagen para poder calcular el cili
     * @param maximo recibe el maximo de iteraciones que contiene el arreglo
     * @param dimension recibe el aareglo donde se formó el mandelbrot
     * @throws IOException 
     */
    public static void crearImagen(int tam,int maximo,int[][] dimension) throws IOException{
        BufferedImage imagen = new BufferedImage(tam,tam,BufferedImage.TYPE_INT_ARGB);
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                int k=dimension[i][j];
                float posicion;
                Color color;
                if(k==0){
                    color = new Color(12,3,12);
                }
                else if(k==1){
                    color = new Color(16,4,16);
                }
                else if(k==maximo-6 || k==maximo-10 || k==maximo-12){
                    color = new Color(87, 35, 100);
                }
                else if(k<maximo/3){
                    posicion=(float)k/maximo;
                    color = new Color(posicion,0,posicion);
                }else if(k<maximo/2){
                    posicion=(float)k/maximo;
                    color = new Color(posicion,posicion,posicion);
                }
                else if(k<maximo){
                    color= new Color(255,255,255);
                }
                
                else{
                    color= new Color(0,0,0);
                }
                imagen.setRGB(i,j,color.getRGB());
            }
        }
        ImageIO.write(imagen,"PNG", new File("Imagen.png"));
    }
}

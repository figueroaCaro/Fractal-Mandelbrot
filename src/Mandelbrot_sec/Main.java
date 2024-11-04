/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Mandelbrot_sec;

/**
 * Clse principal del proyecto donde se forma el mandelbrot
 * @author Castillo Soto Jacqueline, Figueroa Ruiz Carolina, Isidro Castro Karen Cristina
 */
public class Main {

    /**
     * Metodo principal con las instrucciones a realizar
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        int tam= 5025;
        int maximo= 30;
        int[][] dimension = new int[tam][tam];
       Long inicio=System.currentTimeMillis();
       for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                double aux1=(4.0*i-2*tam)/tam;
                double aux2=(4.0*j-2*tam)/tam;
                double aux3=aux1;
                double aux4=aux2;
                int cont=0;
                while(cont<maximo&& aux3*aux3+aux4*aux4<4.0){
                    double forma1= aux1+aux3*aux3-aux4*aux4;
                    double forma2= aux2+2*aux3*aux4;
                    aux3=forma1;
                    aux4=forma2;
                    cont++;
                } 
                dimension[i][j]=cont;
                        
            }
        }
       
       Long fin=System.currentTimeMillis();
       System.out.println("Tiempo: "+((float)(fin-inicio)/1000)+" segundos");
       CrearImagen.crearImagen(tam,maximo,dimension);
    }
    
}

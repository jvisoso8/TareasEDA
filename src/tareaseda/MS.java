/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaseda;
import java.util.Random;
/**
 *
 * @author FARAMBURA
 */
public class MS {
    
     public static int [] mergeSort(int[] arre)
    {
        if (arre.length <= 1) {
            return arre;
        }
        int n = arre.length;
        int[] primero = new int[n/2];
        int[] segundo = new int[n - primero.length];
        System.arraycopy(arre, 0, primero, 0, primero.length);
        System.arraycopy(arre, primero.length, segundo, 0, segundo.length);
        mergeSort(primero);
        mergeSort(segundo);
        merge(primero, segundo, arre);
        return arre;
    }
     
     private static void merge(int[] prim, int[] seg, int[] res)
    {
        int nprim = 0;
        int nseg = 0;
        int nres = 0;
        while (nprim < prim.length && nseg < seg.length){
            if (prim[nprim] < (seg[nseg])){
                res[nres] = prim[nprim];
                nprim++;
            }
            else{
                res[nres] = seg[nseg];
                nseg++;
            }
            nres++;
        }
        System.arraycopy(prim, nprim, res, nres, prim.length - nprim);
        System.arraycopy(seg, nseg, res, nres, seg.length - nseg);
    }
    
     private static void imprime(int[] arre){
         for(int i =0; i<arre.length; i++)
             System.out.println(arre[i]);
    }
     
     public static void main(String[] args) {
        //Numero de objetos en el arreglo es igual a x.
         
         int x = 10000;
        
        int [] a = new int[x];
        Random rand = new Random();
        for(int i =0; i<x; i++){ 
            int  n = rand.nextInt(x);
            a[i]=n;
        }
        //imprime(a);
        double  t1 = System.currentTimeMillis();
        mergeSort(a);
        double t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        //System.out.println("***************************************");
        //imprime(a);
     }
}
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adgimo;

/**
 *
 * @author 2DAW
 */
public class Comun {
    
    /**
     * Compruba si es numerico un valor pasado
     * @param cadena
     * @return 
     */
    public static boolean isNumeric(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
    }
    /**
     * 
     * @param n1
     * @param n2
     * @return la multiplicacion de los parametros
     */
    public static float Multiplicar(float n1,float n2){
        float resultado= n1*n2;
        return resultado;
    }
}

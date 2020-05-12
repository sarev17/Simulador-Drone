/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drone;


import javax.swing.JOptionPane;
import jpl.Query;

/**
 *@author andre
 *this class connect the java aplication whit prolog server, for that we use the library jpl.jar
 */

public class Conexao {

        
    /**
     *@param a[]
     * sensors:send a binary array corresponding to the four drone's sensor
     * example a[] = [0,1,1,0] -> sensor 2 and 3 is colliding 
     *@return result[]
     * Return the coordinates from new drone's position
     */
     
    
    public double[] conectar(int[] a) {

        try {
            String connection = "consult('src/drone/Prolog.pl')";
            Query con = new Query(connection);
            System.out.println(connection + "   " + (con.hasMoreSolutions() ? "ACEITO" : "FALHA"));
          
            String consulta = "coordenada([+"+a[0]+","+a[1]+","+a[2]+","+a[3]+","+a[4]+","+a[5]+"],X).";
            Query executar = new Query(consulta);

            String s = (executar.oneSolution().toString()).replaceAll("[^0-9]", " ");
            String[] saida = s.split(" ");
            double[] result = new double[2];
           
            result[0] = Double.parseDouble(saida[7]);
            result[1] = Double.parseDouble(saida[13]);
            
               con.close();
                return result;
        
            
        } catch (NumberFormatException e) {
            
            
            JOptionPane.showMessageDialog(null, "sensores "+a[0]+" "+a[1]+" "+a[2]+" "+a[3]+"\n"+ e);
            return null;
        }
        
    

}
}

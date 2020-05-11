/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drone;

import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javax.swing.JOptionPane;
import jpl.Query;

/**
 *
 * @author andre
 */
public class Conexao {
    
    
   

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
            
               /* System.out.println(
                        saida[7]+" "+saida[13]
                );*/
            
               con.close();
                return result;
        
            
            //if (executar.hasSolution()) {
            //  System.out.println("A soma é: " + executar.oneSolution().get("C").toString());
            //}
        } catch (NumberFormatException e) {
            
            
            JOptionPane.showMessageDialog(null, "sensores "+a[0]+" "+a[1]+" "+a[2]+" "+a[3]+"\n"+ e);
            return null;
        }
        
    

}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoadFreylegastoseminario;
import SoadFreylegastoseminario.ventanas.VentanaLogin;
import SoadFreylegastoseminario.ventanas.VentanaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JWindow;
/**
 *
 * @author ODETH
 */
public class Principal {
    public static void main(String a[]){
        JWindow ventanaTeporal = new JWindow();
        ventanaTeporal.setSize(500,300);
        ventanaTeporal.setLocationRelativeTo(null);
        ventanaTeporal.setVisible(true);
        try{
            Thread.sleep(10000);
            ventanaTeporal.dispose();
        }catch (InterruptedException ex){
            Logger.getLogger(VentanaLogin.class.getName()).log(Level.SEVERE,null,ex);
            
        }
       
        
        
        
        
        
        
        
        
        
        
        
        
        VentanaPrincipal v  = new VentanaPrincipal();
        v.setExtendedState(VentanaPrincipal.MAXIMIZED_BOTH);
       //v.setLocationRelativeTo(null);
       v.setVisible(true);
    }
    
}

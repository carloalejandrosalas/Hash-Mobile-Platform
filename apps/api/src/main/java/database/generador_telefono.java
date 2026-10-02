package database;

//created by carlo salas 14/marzo/2015


import java.util.Random;
import static java.lang.Integer.parseInt;

import javax.swing.JOptionPane;

public class generador_telefono {

static void capturar(){
Random numero = new Random();

String codigo="662";

int N1 = numero.nextInt(6);
int N2 = numero.nextInt(9);
int N3 = numero.nextInt(9);
int N4 = numero.nextInt(9);
int N5 = numero.nextInt(9);
int N6 = numero.nextInt(9);
int N7 = numero.nextInt(9);

System.out.println("");

String telefono= (codigo+N1+N2+N3+N4+N5+N6+N7);

System.out.println("El telefono "+telefono+" fue generado exitosamente");
}    
    
    
    
public static void main(String[] args){
 System.out.println("H0LA USUARI0 S0Y EL SITEMA, ¿C0M0 ESTAS?");

capturar();
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       
capturar();       

//se han generado 50 telefonos
JOptionPane.showMessageDialog(null, "Se han creado 50 telefonos exitosamente","Telefonos",JOptionPane.PLAIN_MESSAGE);

System.out.println("");
System.out.println("Created & design by Carlo Salas 14/marzo/2015");



}

}

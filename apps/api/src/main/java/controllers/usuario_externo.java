/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import database.conectar;
import java.awt.event.ItemEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Carlo Salas
 */
public class usuario_externo extends javax.swing.JFrame {

    /**
     * Creates new form usuario_externo
     */
    public usuario_externo() {
        initComponents();
    }
    
    void limpiar(){
        c_ciudad.setSelectedIndex(0);
        c_codigo.removeAllItems(); 
        c_codigo.addItem("000");
        c_compañia.setSelectedIndex(0);
        t_numero.setText("");
    }

    public String[] getCiudadesSonora(String estado){
        String[] ciudades = new String[73];
        {
            ciudades[0] = "Selecciona una ciudad";
            ciudades[1] = "Aconchi"  ;
            ciudades[2] = "Agua Prieta";
            ciudades[3] = "Alamos";
            ciudades[4] = "Altar";
            ciudades[5] = "Arivechi";
            ciudades[6] = "Arizpe";
            ciudades[7] = "Atil";
            ciudades[8] = "Bacadéhuachi";
            ciudades[9] = "Bacanora";
            ciudades[10] = "Bacerac";
            ciudades[11] = "Bacoachi";
            ciudades[12] = "Bácum";
            ciudades[13] = "Banámichi";
            ciudades[14] = "Baviácora";
            ciudades[15] = "Bavispe";
            ciudades[16] = "Benjamín Hill";
            ciudades[17] = "Caborca";
            ciudades[18] = "Cajeme";
            ciudades[19] = "Cananea";
            ciudades[20] = "Carbó";
            ciudades[21] = "La Colorada";
            ciudades[22] = "Cucurpe";
            ciudades[23] = "Cumpas";
            ciudades[24] = "Divisaderos";
            ciudades[25] = "Empalme";
            ciudades[26] = "Etchojoa";
            ciudades[27] = "Fronteras";
            ciudades[28] = "Granados";
            ciudades[29] = "Guaymas";
            ciudades[30] = "Hermosillo";
            ciudades[31] = "Huachineras";
            ciudades[32] = "Huásabas";
            ciudades[33] = "Huatabampo";
            ciudades[34] = "Huépac";
            ciudades[35] = "Imuris";
            ciudades[36] = "Magdalena";
            ciudades[37] = "Mazatán";
            ciudades[38] = "Moctezuma";
            ciudades[39] = "Naco";
            ciudades[40] = "Nácori Chico";
            ciudades[41] = "Nacozari de García";
            ciudades[42] = "Navojoa";
            ciudades[43] = "Nogales";
            ciudades[44] = "Onavas";
            ciudades[45] = "Opodepe";
            ciudades[46] = "Oquitoa";
            ciudades[47] = "Pitiquito";
            ciudades[48] = "Puerto Peñasco";
            ciudades[49] = "Quiriego";
            ciudades[50] = "Rayón";
            ciudades[51] = "Rosario";
            ciudades[52] = "Sahuaripa";
            ciudades[53] = "San Felipe de Jesús";
            ciudades[54] = "San Javier";
            ciudades[55] = "San Luis Río Colorado";
            ciudades[56] = "San Miguel de Horcasitas";
            ciudades[57] = "San Pedro de la Cueva";
            ciudades[58] = "Santa Ana";
            ciudades[59] = "Santa Cruz";
            ciudades[60] = "Sáric";
            ciudades[61] = "Soyopa";
            ciudades[62] = "Suaqui Grande";
            ciudades[63] = "Tepache";
            ciudades[64] = "Trincheras";
            ciudades[65] = "Tubutama";
            ciudades[66] = "Ures";
            ciudades[67] = "Villa Hidalgo";
            ciudades[68] = "Villa Pesqueira";
            ciudades[69] = "Yécora";
            ciudades[70] = "General Plutarco Elías Calles";
            ciudades[71] = "Benito Juárez";
            ciudades[72] = "San Ignacio Río Muerto";
        
        
    }
        return ciudades;
  }
      
      public String[] getCiudadesChihuahua(String estado){
        String[] ciudades = new String[67];
        ciudades[0] = "Selecciona una ciudad";
           ciudades[1]= "Ahumada";     
	   ciudades[2]= "Aldama";
	   ciudades[3]= "Allende";	   
	   ciudades[4]= "Aquiles Serdán";
           ciudades[5]= "Ascensión";
	   ciudades[6]= "Bachíniva";
           ciudades[7]= "Balleza";
           ciudades[8]= "Batopilas";
           ciudades[9]= "Bocoyna";
           ciudades[10]= "Buenaventura";
           ciudades[11]= "Camargo";
           ciudades[12]= "Carichí";
           ciudades[13]= "Casas Grandes";
           ciudades[14]= "Coronado";
           ciudades[15]= "Coyame del Sotol";
           ciudades[16]= "La Cruz";
           ciudades[17]= "Cuauhtémoc";
           ciudades[18]= "Cusihuiriachi";
           ciudades[19]= "Chihuahua";
           ciudades[20]= "Chínipas";
           ciudades[21]= "Delicias";
           ciudades[22]= "Dr. Belisario Domínguez";
           ciudades[23]= "Galeana";
           ciudades[24]= "Santa Isabel";
           ciudades[25]= "Gómez Farías";
           ciudades[26]= "Gran Morelos";
           ciudades[27]= "Guachochi";
           ciudades[28]= "Guadalupe";
           ciudades[29]= "Guadalupe y Calvo";
           ciudades[30]= "Guazapares";
           ciudades[31]= "Guerrero";
           ciudades[32]= "Hidalgo del Parral";
           ciudades[33]= "Huejotitán";
           ciudades[34]= "Ignacio Zaragoza";
           ciudades[35]= "Janos";
           ciudades[36]= "Juárez";
           ciudades[37]= "Julimes";
           ciudades[38]= "López";
           ciudades[39]= "Madera";
           ciudades[40]= "Maguarichi";
           ciudades[41]= "Manuel Benavides";
           ciudades[42]= "Matachí";
           ciudades[43]= "Matamoros";
           ciudades[44]= "Meoqui";
           ciudades[45]= "Morelos";
           ciudades[46]= "Moris";
           ciudades[47]= "Namiquipa";
           ciudades[48]= "Nonoava";
           ciudades[49]= "Nuevo Casas Grandes";
           ciudades[50]= "Ocampo";
           ciudades[51]= "Ojinaga";
           ciudades[52]= "Praxedis G. Guerrero";
           ciudades[53]= "Riva Palacio";
           ciudades[54]= "Rosales";
           ciudades[55]= "Rosario";
           ciudades[56]= "San Francisco de Borja";
           ciudades[57]= "San Francisco de Conchos";
           ciudades[58]= "San Francisco del Oro";
           ciudades[59]= "Santa Bárbara";
           ciudades[60]= "Satevó";
           ciudades[61]= "Saucillo";
           ciudades[62]= "Temósachic";
           ciudades[63]= "El Tule";
           ciudades[64]= "Urique";
           ciudades[65]= "Uruachi";
           ciudades[66]= "Valle de Zaragoza";
           
           return ciudades; 
      }
      
      public String[] getCiudadesBajaCalifornia(String estado){
          String[] ciudades = new String[7];
           
           ciudades[0] = "Selecciona una ciudad";
           ciudades[1]= "Ensenada";
	   ciudades[2]= "Mexicali";
	   ciudades[3]= "Tecate";	   
	   ciudades[4]= "Tijuana";
           ciudades[5]= "Playas de Rosarito";
           ciudades[6] = "San Luis Rio Colorado";
            
           return ciudades;
      }
      
      public String[] getCiudadesBajaCaliforniaSur(String estado){
      String[] ciudades = new String[6];
      
           ciudades[0]=   "Selecciona una ciudad";
           ciudades[1]=   "Comondú";
	   ciudades[2]=   "Mulegé";
	   ciudades[3]=   "La Paz";	   
	   ciudades[4]=   "Los Cabos";
           ciudades[5]=   "Loreto";
           
           return ciudades;
      }
      
      public String[] getCiudadesSinaloa(String estado){
        String[] ciudades = new String[19];
            
           ciudades[0] ="Selecciona una ciudad";
           ciudades[1]= "Ahome";
	   ciudades[2]= "Angostura";
	   ciudades[3]= "Badiraguato";	   
	   ciudades[4]= "Concordia";
           ciudades[5]= "Cosalá";
	   ciudades[6]= "Culiacán";
           ciudades[7]= "Choix";
           ciudades[8]= "Elota";
           ciudades[9]= "Escuinapa";
           ciudades[10]= "El Fuerte";
           ciudades[11]= "Guasave";
           ciudades[12]= "Mazatlán";
           ciudades[13]= "Mocorito";
           ciudades[14]= "Rosario";
           ciudades[15]= "Salvador Alvarado";
           ciudades[16]= "San Ignacio";
           ciudades[17]= "Sinaloa";
           ciudades[18]= "Navolato";
           
            
        return ciudades;
    }
     
      public String[] getCodigo(String ciudad){
        String[] codigo = new String[3];
                    if(ciudad.equalsIgnoreCase("........")){
                        codigo[0] = "000";
                        codigo[1] = "........";
                        codigo[2] = "........";
                    }
                    
                    if(ciudad.equalsIgnoreCase("Selecciona una ciudad")){
                        codigo[0] = "000";
                        codigo[1] = "........";
                        codigo[2] = "........";
                    }
//Estado Sonora..........
                    
                    if(ciudad.equalsIgnoreCase("Aconchi")){
                    codigo[0] = "623";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }

                    
                    if(ciudad.equalsIgnoreCase("Agua Prieta")){
                    codigo[0] = "633";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }
                    
                    if(ciudad.equalsIgnoreCase("Alamos")){
                    codigo[0] ="647";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }
                    
                    if(ciudad.equalsIgnoreCase("Altar")){
                    codigo[0] ="637";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }
                    
                    if(ciudad.equalsIgnoreCase("Arivechi")){
                    codigo[0] ="634";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }
                    
                    if(ciudad.equalsIgnoreCase("Arizpe")){
                    codigo[0] ="634";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }
                    
                    if(ciudad.equalsIgnoreCase("Atil")){
                    codigo[0] ="637";  
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }
                
                    if(ciudad.equalsIgnoreCase("Bacadéhuachi")){
                    codigo[0] ="634";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }
                    
                    if(ciudad.equalsIgnoreCase("Bacanora")){
                    codigo[0] ="634";
                    codigo[1] = "........";
                    codigo[2] = "........";
                    }

                    if(ciudad.equalsIgnoreCase("Bacerac")){
                    codigo[0] ="634";
                    codigo[1] = "........";
                    codigo[2] = "........";
                     }

                    if(ciudad.equalsIgnoreCase("Bacoachi")){
                         codigo[0] ="645";
                         codigo[1] = "........";
                         codigo[2] = "........";
                    }
                     
                    if(ciudad.equalsIgnoreCase("Bácum")){
                         codigo[0] ="643";
                         codigo[1] ="644";
                         codigo[2] = "........";
                     }
                     
                    if(ciudad.equalsIgnoreCase("Banámichi")){
                         codigo[0] ="623";
                         codigo[1] = "........";
                         codigo[2] = "........";
                     }
                     
                    if(ciudad.equalsIgnoreCase("Baviácora")){
                         codigo[0] ="623";
                         codigo[1] = "........";
                         codigo[2] = "........";
                     }
                     
                    if(ciudad.equalsIgnoreCase("Bavispe")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Benjamín Hill")){
                     codigo[0] ="641";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Caborca")){
                     codigo[0] ="637";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                    
                    if(ciudad.equalsIgnoreCase("Cajeme")){
                     codigo[0] ="643";
                     codigo[1] ="644";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Cananea")){
                     codigo[0] ="645";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Carbó")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    
                    if(ciudad.equalsIgnoreCase("La Colorada")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Cucurpe")){
                     codigo[0] ="632";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Cumpas")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Divisaderos")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Empalme")){
                     codigo[0] ="622";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Etchojoa")){
                     codigo[0] ="643";
                     codigo[1] ="647";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Fronteras")){
                     codigo[0] ="633";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Granados")){
                     codigo[0] ="667";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Guaymas")){
                     codigo[0] ="622";
                     codigo[1] = "643";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Hermosillo")){
                     codigo[0] ="662";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Huachineras")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Huásabas")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                    if(ciudad.equalsIgnoreCase("Huatabampo")){
                     codigo[0] ="647";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                    
                     if(ciudad.equalsIgnoreCase("Huépac")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Imuris")){
                     codigo[0] ="632";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Magdalena")){
                     codigo[0] ="632";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Mazatán")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Moctezuma")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Naco")){
                     codigo[0] ="633";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Nácori Chico")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Nacozari de García")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Navojoa")){
                     codigo[0] ="642";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Nogales")){
                     codigo[0] ="631";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Onavas")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Opodepe")){
                     codigo[0] ="641";
                     codigo[1] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Oquitoa")){
                     codigo[0] ="637";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Pitiquito")){
                     codigo[0] ="637";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Puerto Peñasco")){
                     codigo[0] ="638";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Quiriego")){
                     codigo[0] ="647";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Rayón")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Rosario")){
                     codigo[0] ="647";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Sahuaripa")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("San Felipe de Jesús")){
                     codigo[0] ="686";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("San Javier")){
                     codigo[0] ="653";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("San Luis Río Colorado")){
                     codigo[0] ="653";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("San Miguel de Horcasitas")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("San Pedro de la Cueva")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     
                     if(ciudad.equalsIgnoreCase("Santa Ana")){
                     codigo[0] ="641";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Santa Cruz")){
                     codigo[0] ="645";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Sáric")){
                     codigo[0] ="637";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Soyopa")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Suaqui Grande")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Tepache")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Trincheras")){
                     codigo[0] ="641";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Tubutama")){
                     codigo[0] ="637";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Ures")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Villa Hidalgo")){
                     codigo[0] ="634";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Villa Pesqueira")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Yécora")){
                     codigo[0] ="623";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("General Plutarco Elías Calles")){
                     codigo[0] ="651";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Benito Juárez")){
                     codigo[0] ="643";
                     codigo[1] ="644";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("San Ignacio Río Muerto")){
                     codigo[0] ="643";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("San Ignacio Río Muerto")){
                     codigo[0] ="643";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("San Ignacio Río Muerto")){
                     codigo[0] ="643";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("San Ignacio Río Muerto")){
                     codigo[0] ="643";
                     codigo[1] = "........";
                     codigo[2] = "........";
                     }
                     
//Estado Baja california...
                     
                     if(ciudad.equalsIgnoreCase("Ensenada")){
                     codigo[0]="616";
                     codigo[1]="646";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Mexicali")){
                     codigo[0]="653";
                     codigo[1]="658";
                     codigo[2]="686";
                     }
                     if(ciudad.equalsIgnoreCase("Tecate")){
                     codigo[0]="665";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Tijuana")){
                     codigo[0]="664";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Playas de Rosarito")){
                     codigo[0]="661";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("San Luis Rio Colorado")){
                     codigo[0]="653";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     
//Estado Baja california sur...
                     
                     if(ciudad.equalsIgnoreCase("Comondú")){
                     codigo[0]="613";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Mulegé")){
                     codigo[0]="615";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("La Paz")){
                     codigo[0]="612";
                     codigo[1]="624";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Los Cabos")){
                     codigo[0]="624";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Loreto")){
                     codigo[0]="613";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     
//Estado de Sinaloa.......
                     if(ciudad.equalsIgnoreCase("Ahome")){
                     codigo[0]="668";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Angostura")){
                     codigo[0]="697";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Badiraguato")){
                     codigo[0]="697";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Concordia")){
                     codigo[0]="694";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Cosalá")){
                     codigo[0]="696";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }if(ciudad.equalsIgnoreCase("Culiacán")){
                     codigo[0]="667";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Choix")){
                     codigo[0]="698";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Elota")){
                     codigo[0]="696";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Escuinapa")){
                     codigo[0]="695";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("El Fuerte")){
                     codigo[0]="698";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Guasave")){
                     codigo[0]="687";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Mazatlán")){
                     codigo[0]="669";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Mocorito")){
                     codigo[0]="673";
                     codigo[1]="697";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Rosario")){
                     codigo[0]="694";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Salvador Alvarado")){
                     codigo[0]="673";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("San Ignacio")){
                     codigo[0]="696";
                     codigo[1]="........";
                     codigo[2]="........";
                     }
                     if(ciudad.equalsIgnoreCase("Sinaloa")){
                     codigo[0]="687";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Navolato")){
                     codigo[0]="672";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     
//Estado de Chihuahua......
                     if(ciudad.equalsIgnoreCase("Ahumada")){
                     codigo[0]="656";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Aldama")){
                     codigo[0]="614";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Allende")){
                     codigo[0]="628";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Aquiles Serdán")){
                     codigo[0]="614";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Ascensión")){
                     codigo[0]="636";
                     codigo[1]="656";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Bachíniva")){
                     codigo[0]="659";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Balleza")){
                     codigo[0]="649";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Batopilas")){
                     codigo[0]="649";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Bocoyna")){
                     codigo[0]="635";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Buenaventura")){
                     codigo[0]="636";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Camargo")){
                     codigo[0]="648";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Carichí")){
                     codigo[0]="635";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Casas Grandes")){
                     codigo[0]="636";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Coronado")){
                     codigo[0]="629";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Coyame del Sotol")){
                     codigo[0]="626";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("La Cruz")){
                     codigo[0]="648";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Cuauhtémoc")){
                     codigo[0]="625";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Cusihuiriachi")){
                     codigo[0]="625";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                    
                     if(ciudad.equalsIgnoreCase("Chihuahua")){
                     codigo[0]="614";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Chínipas")){
                     codigo[0]="635";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Delicias")){
                     codigo[0]="639";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Dr. Belisario Domínguez")){
                     codigo[0]="625";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     
                     if(ciudad.equalsIgnoreCase("Galeana")){
                     codigo[0]="636";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Santa Isabel")){
                     codigo[0]="614";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Gómez Farías")){
                     codigo[0]="652";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Gran Morelos")){
                     codigo[0]="625";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Guachochi")){
                     codigo[0]="649";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Guadalupe")){
                     codigo[0]="656";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                     if(ciudad.equalsIgnoreCase("Guadalupe y Calvo")){
                     codigo[0]="649";
                     codigo[1]="........";
                     codigo[2] = "........";
                     }
                   
           
                    if(ciudad.equalsIgnoreCase("Guazapares")){
                              codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    
                    }
                    if(ciudad.equalsIgnoreCase("Guerrero")){
                             codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Hidalgo del Parral")){
                    codigo[0]="627";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    
                    
                    if(ciudad.equalsIgnoreCase("Ignacio Zaragoza")){
                    codigo[0]="636";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Janos")){
                    codigo[0]="636";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Juárez")){
                    codigo[0]="656";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Julimes")){
                    codigo[0]="621";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("López")){
                    codigo[0]="629";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Madera")){
                    codigo[0]="652";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Maguarichi")){
                    codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Manuel Benavides")){
                    codigo[0]="626";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Matachí")){
                    codigo[0]="659";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Matamoros")){
                    codigo[0]="628";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Meoqui")){
                    codigo[0]="639";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Morelos")){
                    codigo[0]="639";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Moris")){
                    codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Namiquipa")){
                    codigo[0]="659";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Nonoava")){
                    codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Nuevo Casas Grandes")){
                    codigo[0]="636";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Ocampo")){
                    codigo[0]="635";
                    codigo[1]="649";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Ojinaga")){
                    codigo[0]="626";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Praxedis G. Guerrero")){
                    codigo[0]="614";
                    codigo[1]="656";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Riva Palacio")){
                    codigo[0]="614";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Rosales")){
                    codigo[0]="639";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Rosario")){
                    codigo[0]="649";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("San Francisco de Borja")){
                    codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("San Francisco de Conchos")){
                    codigo[0]="648";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("San Francisco del Oro")){
                    codigo[0]="628";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Santa Bárbara")){
                    codigo[0]="628";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Satevó")){
                    codigo[0]="614";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Saucillo")){
                    codigo[0]="621";
                    codigo[1]="639";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Temósachic")){
                    codigo[0]="659";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("El Tule")){
                    codigo[0]="649";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Urique")){
                              codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Uruachi")){
                              codigo[0]="635";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
                    if(ciudad.equalsIgnoreCase("Valle de Zaragoza")){
                              codigo[0]="649";
                              codigo[1]="........";
                              codigo[2] = "........";    

                    }
           
                     
                     
//fin de codigo ciudades........
                     
                     return codigo;
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        c_compañia = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        t_numero = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        c_estado = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        c_ciudad = new javax.swing.JComboBox();
        c_codigo = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NUEVO TELEFONO EXTERNO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        c_compañia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona una compañia", "Telcel", "Movistar", "Nextel", "Iusacell", "Unefon", "Otra" }));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Compañia:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Telefono:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Estado:");

        c_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un estado", "Baja california", "Baja california sur", "Chihuahua", "Sinaloa", "Sonora" }));
        c_estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_estadoItemStateChanged(evt);
            }
        });
        c_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_estadoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Ciudad:");

        c_ciudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin especificar estado" }));
        c_ciudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_ciudadItemStateChanged(evt);
            }
        });

        c_codigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "000" }));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("GENERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SALIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(c_compañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(c_estado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(c_ciudad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(c_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_compañia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(c_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(c_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(c_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       String codigo=c_codigo.getSelectedItem().toString();
       String numero=t_numero.getText();
       
        if(c_compañia.getSelectedItem().equals("Selecciona una compañia")){
            JOptionPane.showMessageDialog(null, "Selccione una compañia","error",JOptionPane.ERROR_MESSAGE);
        }
       
       else if(codigo.equals("000")){
        JOptionPane.showMessageDialog(null, "El codigo no es valido","error",JOptionPane.ERROR_MESSAGE);
    }
    
    else{
       String telefono=(codigo+numero);
            
    
    String sql="INSERT INTO telefonos(compañia,telefono,verdadero)VALUES(?,?,?)";
                try {

                    PreparedStatement psd= cn.prepareStatement(sql);
                    psd.setString(1, c_compañia.getSelectedItem().toString());
                    psd.setString(2, telefono);
                    psd.setString(3, "SI");
                    
                    int n=psd.executeUpdate();
                    if (n>0){
                        JOptionPane.showMessageDialog(null,"Nuevo telefono registrado");
                        
                        
                        
                        }else{
                        JOptionPane.showMessageDialog(null, "Paso algo malo con el numero volver a intentar","Verifica",JOptionPane.ERROR_MESSAGE);
                    }
                
                } catch (SQLException ex ) {
                    System.out.println("Error pstmt.executeQuery():"+ex);
                    JOptionPane.showMessageDialog(null, "Este telefono ya esta registrado","Verifica",JOptionPane.ERROR_MESSAGE);
                    
                    
                    
                    
                }
            
    
    
    
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void c_estadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_estadoItemStateChanged
         String estado= c_estado.getSelectedItem().toString();

        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
          
            
            if(estado.equalsIgnoreCase("Sonora")){

                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesSonora(this.c_estado.getSelectedItem().toString())));

               
                c_codigo.removeAllItems();
                c_codigo.addItem("000");

            }

            if(estado.equalsIgnoreCase("Chihuahua")){

                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesChihuahua(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");

            }

            if(estado.equalsIgnoreCase("Baja California")){
                 this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesBajaCalifornia(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");

            }

            if(estado.equalsIgnoreCase("Baja California Sur")){

                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesBajaCaliforniaSur(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");
            }

           if(estado.equalsIgnoreCase("Sinaloa")){
                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesSinaloa(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");
            }
            
           if(estado.equalsIgnoreCase("Selecciona un estado")){
               c_ciudad.removeAllItems();
               c_ciudad.addItem("Sin especificar");
               c_codigo.removeAllItems();
               c_codigo.addItem("000");
               
           } 

        }
    }//GEN-LAST:event_c_estadoItemStateChanged

    private void c_ciudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_ciudadItemStateChanged
          if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            
            this.c_codigo.setModel(new DefaultComboBoxModel(this.getCodigo(this.c_ciudad.getSelectedItem().toString())));
            c_codigo.removeItem("........");
            c_codigo.removeItem("........");
            c_ciudad.removeItem("Selecciona una ciudad");
           
        }
    }//GEN-LAST:event_c_ciudadItemStateChanged

    private void c_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_estadoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(usuario_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(usuario_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(usuario_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(usuario_externo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new usuario_externo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox c_ciudad;
    private javax.swing.JComboBox c_codigo;
    private javax.swing.JComboBox c_compañia;
    private javax.swing.JComboBox c_estado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField t_numero;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
 Connection cn= cc.conexion();
}

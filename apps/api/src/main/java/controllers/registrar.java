
package controllers;

import database.conectar;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class registrar extends javax.swing.JInternalFrame {

    
    public registrar() {
        initComponents();
        invisible();
        Limitar();
        t_fecha.setText(fechaActual());
    }
    
     
    public void validator() {
        String correo = t_correo.getText();
        if(isEmail(correo)){
            System.out.println("El Mail "+correo+" es correcto");
            checkc.setVisible(true);
            errorc.setVisible(false);
        }else{
            System.out.println("Mail incorrecto");
            
            t_correo.setText("");
            checkc.setVisible(false);
            errorc.setVisible(true);
        }
        
    }
    
    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^[\\w\\-\\_]+(\\.[\\w\\-\\_]+)*@([A-Za-z0-9-]+\\.)+[A-Za-z]{2,4}$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            return true;
        }else{
            return false;
        }        
    }
    
    
    public void verificarTelefono(String telefono){
       String cap="";
       
       String sql="SELECT * FROM telefonos WHERE telefono='"+telefono+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("verdadero");
                
            }
            if(cap.equals("SI"))
            {
                  
                     checkn.setVisible(true);
                     errorn.setVisible(false);
            }else{
            
                t_numero.setText("");
                errort.setVisible(true);
                checkt.setVisible(false);
                JOptionPane.showMessageDialog(null,"Este telefono no esta registrado en ningun chip","Verifica",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoSistema.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void verificarGratis(String gratis)
    {
        String cap="";
        String sql="SELECT * FROM usuario WHERE telefono='"+gratis+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("plan");
            }
            if(cap.equals("SI"))
            {
                  
                     checkg.setVisible(true);
                     errorg.setVisible(false);
            }
            if(cap.equals("NO"))
            {
            
                     checkg.setVisible(true);
                     errorg.setVisible(false);
                     
                     
            }
            if((!cap.equals("SI"))&& (!cap.equals("NO")))
            {
                t_numg.setText("");
                errorg.setVisible(true);
                checkg.setVisible(false);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
    
     public void verificarFrecuente(String frecuente)
    {
        String cap="";
        String sql="SELECT * FROM usuario WHERE telefono='"+frecuente+"'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                cap=rs.getString("plan");
            }
            if(cap.equals("SI"))
            {
                  
                     checkf.setVisible(true);
                     errorf.setVisible(false);
            }
            if(cap.equals("NO"))
            {
            
                     checkf.setVisible(true);
                     errorf.setVisible(false);
                     
            }
            if((!cap.equals("SI"))&& (!cap.equals("NO")))
            {
                t_numf.setText("");
                checkf.setVisible(false);
                errorf.setVisible(true);
                     
            }
        } catch (SQLException ex) {
            Logger.getLogger(IngresoSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        }
    
     public void Limitar(){
    
    t_numero.setDocument(new LimitarCaracter(t_numero,7));
    t_numg.setDocument(new LimitarCaracter(t_numg,10));
    t_numf.setDocument(new LimitarCaracter(t_numf,10));
    t_plan.setDocument(new LimitarCaracter(t_plan,2));
    t_nombre.setDocument(new LimitarCaracter(t_nombre,30)); 
}
    
     void limpiar(){
    t_nombre.setText("");
    t_numero.setText("");
    t_local.setText("");
    t_numg.setText("0000000000");
    t_numf.setText("0000000000");
    t_plan.setText("");
    SI.setSelected(false);
    NO.setSelected(false);
    verifica.setSelected(false);
    trampa.setSelected(true);
    c_plan.removeAllItems();
    c_plan.addItem("Sin plan");
    t_correo.setText("");
    SI.setSelected(false);
    NO.setSelected(false);
} 
     
     void invisible(){
        checkc.setVisible(false);
        checke.setVisible(false);
        checkf.setVisible(false);
        checkg.setVisible(false);
        checkl.setVisible(false);
        checkm.setVisible(false);
        checkn.setVisible(false);
        checkt.setVisible(false);
        errorc.setVisible(false);
        errore.setVisible(false);
        errorf.setVisible(false);
        errorg.setVisible(false);
        errorl.setVisible(false);
        errorm.setVisible(false);
        errorn.setVisible(false);
        errort.setVisible(false);
        t_plan.setVisible(false);
        c_plan.addItem("Sin plan");
        trampa.setVisible(false);
                
     }




    
    @SuppressWarnings("unchecked")
      public static String fechaActual(){
    Date fecha=new Date();
    SimpleDateFormat formatoFecha=new SimpleDateFormat("dd/MMMM/YYYY");
    
    return formatoFecha.format(fecha);
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
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        b2 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        c_estado = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        c_ciudad = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        t_nombre = new javax.swing.JTextField();
        t_numg = new javax.swing.JTextField();
        t_numf = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        t_fecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        SI = new javax.swing.JRadioButton();
        NO = new javax.swing.JRadioButton();
        verifica = new javax.swing.JCheckBox();
        t_numero = new javax.swing.JTextField();
        c_codigo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        t_local = new javax.swing.JTextField();
        c_plan = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        t_correo = new javax.swing.JTextField();
        texto = new javax.swing.JLabel();
        checkn = new javax.swing.JLabel();
        errorn = new javax.swing.JLabel();
        checke = new javax.swing.JLabel();
        errore = new javax.swing.JLabel();
        checkl = new javax.swing.JLabel();
        errorl = new javax.swing.JLabel();
        checkm = new javax.swing.JLabel();
        errorm = new javax.swing.JLabel();
        checkt = new javax.swing.JLabel();
        errort = new javax.swing.JLabel();
        checkc = new javax.swing.JLabel();
        errorc = new javax.swing.JLabel();
        checkg = new javax.swing.JLabel();
        errorg = new javax.swing.JLabel();
        checkf = new javax.swing.JLabel();
        errorf = new javax.swing.JLabel();
        trampa = new javax.swing.JRadioButton();
        t_plan = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registrar Usuario");
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INGRESAR USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        b2.setBackground(new java.awt.Color(51, 51, 51));
        b2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b2.setForeground(new java.awt.Color(255, 255, 255));
        b2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/guardar.png"))); // NOI18N
        b2.setText("GUARDAR");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(51, 51, 51));
        b4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        b4.setText("SALIR");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b3.setBackground(new java.awt.Color(51, 51, 51));
        b3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        b3.setForeground(new java.awt.Color(255, 255, 255));
        b3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/limpiar.png"))); // NOI18N
        b3.setText("LIMPIAR");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        c_estado.setBackground(new java.awt.Color(240, 240, 240));
        c_estado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        c_estado.setForeground(new java.awt.Color(51, 51, 51));
        c_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige un estado", "Baja California", "Baja California Sur", "Chihuahua", "Sinaloa", "Sonora" }));
        c_estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_estadoItemStateChanged(evt);
            }
        });
        c_estado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_estadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                c_estadoMousePressed(evt);
            }
        });
        c_estado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_estadoActionPerformed(evt);
            }
        });
        c_estado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                c_estadoKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Estado:");

        c_ciudad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        c_ciudad.setForeground(new java.awt.Color(51, 51, 51));
        c_ciudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin especificar" }));
        c_ciudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_ciudadItemStateChanged(evt);
            }
        });
        c_ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                c_ciudadMouseClicked(evt);
            }
        });
        c_ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_ciudadActionPerformed(evt);
            }
        });
        c_ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                c_ciudadKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Municipio");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nombre:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Numero gratis:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Numero frecuente:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Plan:");

        t_nombre.setBackground(new java.awt.Color(51, 51, 51));
        t_nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t_nombre.setForeground(new java.awt.Color(255, 255, 255));
        t_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_nombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                t_nombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_nombreFocusLost(evt);
            }
        });
        t_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_nombreActionPerformed(evt);
            }
        });
        t_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nombreKeyTyped(evt);
            }
        });

        t_numg.setBackground(new java.awt.Color(51, 51, 51));
        t_numg.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t_numg.setForeground(new java.awt.Color(255, 255, 255));
        t_numg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_numg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_numgFocusLost(evt);
            }
        });
        t_numg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_numgActionPerformed(evt);
            }
        });
        t_numg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                t_numgKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numgKeyTyped(evt);
            }
        });

        t_numf.setBackground(new java.awt.Color(51, 51, 51));
        t_numf.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t_numf.setForeground(new java.awt.Color(255, 255, 255));
        t_numf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_numf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_numfFocusLost(evt);
            }
        });
        t_numf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_numfActionPerformed(evt);
            }
        });
        t_numf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numfKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Fecha de ingreso:");

        t_fecha.setEditable(false);
        t_fecha.setBackground(new java.awt.Color(153, 153, 153));
        t_fecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t_fecha.setForeground(new java.awt.Color(255, 255, 255));
        t_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_fecha.setText("Dia/Mes/Año");

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar_ultimo_user.png"))); // NOI18N
        jButton1.setText(" ULTIMO REGISTRADO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SI.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(SI);
        SI.setForeground(new java.awt.Color(255, 255, 255));
        SI.setText("SI");
        SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SIActionPerformed(evt);
            }
        });

        NO.setBackground(new java.awt.Color(51, 51, 51));
        buttonGroup1.add(NO);
        NO.setForeground(new java.awt.Color(255, 255, 255));
        NO.setText("NO");
        NO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NOActionPerformed(evt);
            }
        });

        verifica.setBackground(new java.awt.Color(51, 51, 51));
        verifica.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        verifica.setForeground(new java.awt.Color(255, 255, 255));
        verifica.setText("Ya verifique los datos, deseo guardar");

        t_numero.setBackground(new java.awt.Color(51, 51, 51));
        t_numero.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t_numero.setForeground(new java.awt.Color(255, 255, 255));
        t_numero.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_numeroFocusLost(evt);
            }
        });
        t_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numeroKeyTyped(evt);
            }
        });

        c_codigo.setBackground(new java.awt.Color(240, 240, 240));
        c_codigo.setForeground(new java.awt.Color(102, 102, 102));
        c_codigo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "000" }));
        c_codigo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_codigoItemStateChanged(evt);
            }
        });
        c_codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_codigoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Localidad");

        t_local.setBackground(new java.awt.Color(51, 51, 51));
        t_local.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t_local.setForeground(new java.awt.Color(255, 255, 255));
        t_local.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_localFocusLost(evt);
            }
        });

        c_plan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Correo:");

        t_correo.setBackground(new java.awt.Color(51, 51, 51));
        t_correo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        t_correo.setForeground(new java.awt.Color(255, 255, 255));
        t_correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_correoFocusLost(evt);
            }
        });

        texto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setText("Tipo de plan:");

        checkn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checkl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checkm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checkt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errort.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checkc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checkg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checkf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        buttonGroup1.add(trampa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel10)
                        .addGap(32, 32, 32)
                        .addComponent(t_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(c_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(checke)
                        .addGap(10, 10, 10)
                        .addComponent(errore))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(c_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(checkm)
                        .addGap(10, 10, 10)
                        .addComponent(errorm))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(t_local, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(checkl)
                        .addGap(10, 10, 10)
                        .addComponent(errorl))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(t_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(checkn)
                        .addGap(10, 10, 10)
                        .addComponent(errorn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(c_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(t_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkt)
                        .addGap(10, 10, 10)
                        .addComponent(errort))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel11)
                        .addGap(93, 93, 93)
                        .addComponent(t_correo, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(checkc)
                        .addGap(10, 10, 10)
                        .addComponent(errorc))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(t_numg, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(checkg)
                        .addGap(10, 10, 10)
                        .addComponent(errorg))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel6)
                        .addGap(24, 24, 24)
                        .addComponent(t_numf, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(checkf)
                        .addGap(10, 10, 10)
                        .addComponent(errorf))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(SI)
                        .addGap(5, 5, 5)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(trampa))
                            .addComponent(NO)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(texto)
                        .addGap(61, 61, 61)
                        .addComponent(c_plan, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(t_plan, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(b2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b3)
                        .addGap(41, 41, 41)
                        .addComponent(b4)
                        .addGap(24, 24, 24))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(verifica)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(133, 133, 133))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(t_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(c_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checke)
                    .addComponent(errore))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(c_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkm)
                    .addComponent(errorm))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(t_local, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkl)
                    .addComponent(errorl))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(t_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkn)
                    .addComponent(errorn))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(c_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkt)
                    .addComponent(errort))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(t_correo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkc)
                    .addComponent(errorc))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(t_numg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkg)
                    .addComponent(errorg))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(t_numf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkf)
                    .addComponent(errorf))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(SI)
                    .addComponent(trampa)
                    .addComponent(NO))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto)
                    .addComponent(c_plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t_plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(verifica)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                    .addComponent(b3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void t_correoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_correoFocusLost
        validator();
    }//GEN-LAST:event_t_correoFocusLost

    private void t_localFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_localFocusLost
        if(t_local.getText().isEmpty()){
            checkl.setVisible(false);
            

        }else{
            checkl.setVisible(true);

        }

    }//GEN-LAST:event_t_localFocusLost

    private void c_codigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_codigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_codigoActionPerformed

    private void c_codigoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_codigoItemStateChanged
        t_numero.setText("");
    }//GEN-LAST:event_c_codigoItemStateChanged

    private void t_numeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numeroKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
            char d=evt.getKeyChar();
            if(d<'0' || d>'9')evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_t_numeroKeyTyped

    private void t_numeroFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_numeroFocusLost
        String telefono = t_numero.getText();
        String codigo = c_codigo.getSelectedItem().toString();
        String telefono_codigo  =(codigo+telefono);
        
        verificarTelefono(telefono_codigo);
        
        if(t_numero.getText().isEmpty()){
            errort.setVisible(true);
            checkt.setVisible(false);

        }

        else if(c_codigo.getSelectedItem().equals("000")){
            errort.setVisible(true);
            checkt.setVisible(false);
        
        

        }else{
            errort.setVisible(false);
            checkt.setVisible(true);

        }

    }//GEN-LAST:event_t_numeroFocusLost

    private void NOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NOActionPerformed
        c_plan.removeAllItems();
        c_plan.addItem("Sin plan");
    }//GEN-LAST:event_NOActionPerformed

    private void SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SIActionPerformed
        c_plan.setVisible(true);
        texto.setVisible(true);
        c_plan.removeAllItems();
        c_plan.addItem("Hash Pro");
        c_plan.addItem("Hash Plus Todo Destino Consumo Controlado");
        c_plan.addItem("Más x Menos por Segundo Todo Destino");
        c_plan.addItem("Plan Hash200");
        c_plan.addItem("Plan Hash100");

    }//GEN-LAST:event_SIActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultar abrir=new consultar();
        abrir.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void t_numfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numfKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);

        }
        char d=evt.getKeyChar();
        if(d<'0' || d>'9'){

            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_t_numfKeyTyped

    private void t_numfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_numfActionPerformed
        // TODO add your handling code here:
        t_numf.requestFocus();
        t_numf.transferFocus();
    }//GEN-LAST:event_t_numfActionPerformed

    private void t_numfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_numfFocusLost
        String numero_frecuente=t_numf.getText();
        verificarFrecuente(numero_frecuente);
    }//GEN-LAST:event_t_numfFocusLost

    private void t_numgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numgKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);

        }
        char d=evt.getKeyChar();
        if(d<'0' || d>'9'){

            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_t_numgKeyTyped

    private void t_numgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numgKeyReleased

    }//GEN-LAST:event_t_numgKeyReleased

    private void t_numgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_numgActionPerformed
        // TODO add your handling code here:
        t_numg.requestFocus();
        t_numg.transferFocus();
    }//GEN-LAST:event_t_numgActionPerformed

    private void t_numgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_numgFocusLost
        String numero_gratis=t_numg.getText();
        verificarGratis(numero_gratis);

    }//GEN-LAST:event_t_numgFocusLost

    private void t_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nombreKeyTyped
        // TODO add your handling code here:
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);

        }

        char tecla;
        tecla=evt.getKeyChar();
        if(!Character.isLetter(tecla)&&tecla!= KeyEvent.VK_SPACE&&tecla!=KeyEvent.VK_BACK_SPACE){
            evt.consume();
            getToolkit().beep();

        }

    }//GEN-LAST:event_t_nombreKeyTyped

    private void t_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nombreActionPerformed
        // TODO add your handling code here:
        t_nombre.transferFocus();
    }//GEN-LAST:event_t_nombreActionPerformed

    private void t_nombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nombreFocusLost
        if(t_nombre.getText().isEmpty()){
            checkn.setVisible(false);
            errorn.setVisible(true);
        }else{
            checkn.setVisible(true);
            errorn.setVisible(false);
        }

    }//GEN-LAST:event_t_nombreFocusLost

    private void t_nombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_nombreFocusGained

    }//GEN-LAST:event_t_nombreFocusGained

    private void c_ciudadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_ciudadKeyReleased

    }//GEN-LAST:event_c_ciudadKeyReleased

    private void c_ciudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_ciudadActionPerformed

    }//GEN-LAST:event_c_ciudadActionPerformed

    private void c_ciudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_ciudadMouseClicked

    }//GEN-LAST:event_c_ciudadMouseClicked

    private void c_ciudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_ciudadItemStateChanged

        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            t_local.setText("");
            t_numero.setText("");
            errorm.setVisible(false);
            this.c_codigo.setModel(new DefaultComboBoxModel(this.getCodigo(this.c_ciudad.getSelectedItem().toString())));
            c_codigo.removeItem("........");
            c_codigo.removeItem("........");
            c_ciudad.removeItem("Selecciona una ciudad");
            checkm.setVisible(true);
        }

    }//GEN-LAST:event_c_ciudadItemStateChanged

    private void c_estadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_c_estadoKeyTyped

    }//GEN-LAST:event_c_estadoKeyTyped

    private void c_estadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_estadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_c_estadoActionPerformed

    private void c_estadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_estadoMousePressed

    }//GEN-LAST:event_c_estadoMousePressed

    private void c_estadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_c_estadoMouseClicked

    }//GEN-LAST:event_c_estadoMouseClicked

    private void c_estadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_estadoItemStateChanged
        String estado= c_estado.getSelectedItem().toString();

        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            errorm.setVisible(false);
            errore.setVisible(false);
            checke.setVisible(true);
            checkm.setVisible(false);
            t_numero.setText("");
            checkt.setVisible(false);
            
            if(estado.equalsIgnoreCase("Sonora")){

                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesSonora(this.c_estado.getSelectedItem().toString())));

               
                c_codigo.removeAllItems();
                c_codigo.addItem("000");

            }

            else if(estado.equalsIgnoreCase("Chihuahua")){

                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesChihuahua(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");

            }

            else if(estado.equalsIgnoreCase("Baja California")){
                 this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesBajaCalifornia(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");

            }

            else if(estado.equalsIgnoreCase("Baja California Sur")){

                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesBajaCaliforniaSur(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");
            }

           else if(estado.equalsIgnoreCase("Sinaloa")){
                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesSinaloa(this.c_estado.getSelectedItem().toString())));

                c_codigo.removeAllItems();
                c_codigo.addItem("000");
            }
            
           else{
               c_ciudad.removeAllItems();
               c_ciudad.addItem("Sin especificar");
               c_codigo.removeAllItems();
               c_codigo.addItem("000");
               checke.setVisible(false);
               errore.setVisible(false);
               checkm.setVisible(false);
               errorm.setVisible(false);
           } 

        }
    }//GEN-LAST:event_c_estadoItemStateChanged

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        limpiar();
        invisible();
        c_estado.setSelectedIndex(0);

    }//GEN-LAST:event_b3ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_b4ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        validator();
        String verificar_final=t_numg.getText();

        if(verifica.isSelected()){

            String numero_gratis=t_numg.getText();
            String numero_frecuente=t_numf.getText();
            
            String local=c_ciudad.getSelectedItem().toString();

            if(SI.isSelected()==true){
                t_plan.setText("SI");
            }

            if(NO.isSelected()==true){
                t_plan.setText("NO");
            }

            if(t_local.getText().isEmpty()){
                t_local.setText(local);
            }

            if(t_local.getText().equals("Sin especificar")){
                t_local.setText("");
            }

            if(t_local.getText().equals("Selecciona una ciudad")){
                t_local.setText("");
            }

            String fecha_ingreso,estado,ciudad,localidad,nombre,codigo,telefono,correo,numerog,numerof,splan,tipo_plan;

            String sql="";
            fecha_ingreso=t_fecha.getText();
            estado=c_estado.getSelectedItem().toString();
            ciudad=c_ciudad.getSelectedItem().toString();
            localidad= t_local.getText();
            nombre=t_nombre.getText();
            telefono=t_numero.getText();
            correo=t_correo.getText();
            numerog=t_numg.getText();
            numerof=t_numf.getText();
            splan=t_plan.getText();
            tipo_plan=c_plan.getSelectedItem().toString();
            codigo=c_codigo.getSelectedItem().toString();

            String codigo_telefono= (codigo+telefono);
            validator();
            verificarTelefono(codigo_telefono);
            verificarGratis(numero_gratis);
            verificarFrecuente(numero_frecuente);

            if(c_estado.getSelectedItem().equals("Elige un estado")){
                c_ciudad.removeAllItems();
                c_ciudad.addItem("Sin especificar");
                c_codigo.removeAllItems();
                c_codigo.addItem("000");

                errore.setVisible(true);
                errorm.setVisible(true);
                checkm.setVisible(false);
                JOptionPane.showMessageDialog(null, "Seleccione o especifique un estado valido","error",JOptionPane.ERROR_MESSAGE);
            }

            else if(c_ciudad.getSelectedItem().equals("Selecciona una ciudad")){
                errorm.setVisible(true);
                checkm.setVisible(false);
                JOptionPane.showMessageDialog(null, "Seleccione una ciudad valida","error",JOptionPane.ERROR_MESSAGE);
            }

            else if(c_ciudad.getSelectedItem().equals("Sin especificar")){
                JOptionPane.showMessageDialog(null, "Seleccione una ciudad valida","error",JOptionPane.ERROR_MESSAGE);

            }
            else if(t_nombre.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Ingrese un nombre","error",JOptionPane.ERROR_MESSAGE);
            }

            else  if(c_codigo.getSelectedItem().equals("000")){
                checkt.setVisible(false);
                errort.setVisible(true);
                JOptionPane.showMessageDialog(null,"le falto el codigo","error",JOptionPane.ERROR_MESSAGE);

            }

            else if(t_numero.getText().isEmpty()){
                checkt.setVisible(false);
                errort.setVisible(true);
                JOptionPane.showMessageDialog(null,"Ingrese un numero","error",JOptionPane.ERROR_MESSAGE);
            }

            else if(t_numg.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"El numero gratis no existe","error",JOptionPane.ERROR_MESSAGE);
            }

            else if(t_correo.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "El Mail "+correo+" es incorrecto","error",JOptionPane.ERROR_MESSAGE);
                errorc.setVisible(true);
                checkc.setVisible(false);

                JOptionPane.showMessageDialog(null, "Ponga un correo valido","error",JOptionPane.ERROR_MESSAGE);
            }
            
            else if(t_numf.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"El numero frecuente no existe","error",JOptionPane.ERROR_MESSAGE);
            }

            else if(!numero_gratis.equals("0000000000") && !numero_frecuente.equals("0000000000")){

                JOptionPane.showMessageDialog(null, "No se puede repetir el numero gratis");
            }

            else if(t_plan.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"¿Tiene Plan?","error",JOptionPane.ERROR_MESSAGE);
            }

            else{

                sql="INSERT INTO usuario(fecha_ingreso,estado,ciudad,localidad,nombre,telefono,correo,numero_gratis,numero_frecuente,plan,tipo_plan)VALUES(?,?,?,?,?,?,?,?,?,?,?) ";
                try {

                    PreparedStatement psd= cn.prepareStatement(sql);
                    psd.setString(1,fecha_ingreso);
                    psd.setString(2,estado);
                    psd.setString(3,ciudad);
                    psd.setString(4,localidad);
                    psd.setString(5,nombre);
                    psd.setString(6,codigo_telefono);
                    psd.setString(7,correo);
                    psd.setString(8,numerog);
                    psd.setString(9,numerof);
                    psd.setString(10,splan);
                    psd.setString(11,tipo_plan);
                    int n=psd.executeUpdate();
                    if (n>0){
                        JOptionPane.showMessageDialog(null,"Usuario Registrado");

                        limpiar();
                        invisible();
                    }
                } catch (SQLException ex ) {
                    System.out.println("Error pstmt.executeQuery():"+ex);

                    JOptionPane.showMessageDialog(null,"Este telefono ya esta registrado","error",JOptionPane.ERROR_MESSAGE);
                }
            }

            SI.setSelected(false);
            NO.setSelected(false);
        }else{
            JOptionPane.showMessageDialog(null,"Verifique primero para guardar");

        }

    }//GEN-LAST:event_b2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton NO;
    private javax.swing.JRadioButton SI;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox c_ciudad;
    private javax.swing.JComboBox c_codigo;
    private javax.swing.JComboBox c_estado;
    private javax.swing.JComboBox c_plan;
    private javax.swing.JLabel checkc;
    private javax.swing.JLabel checke;
    private javax.swing.JLabel checkf;
    private javax.swing.JLabel checkg;
    private javax.swing.JLabel checkl;
    private javax.swing.JLabel checkm;
    private javax.swing.JLabel checkn;
    private javax.swing.JLabel checkt;
    // private nicon.notify.gui.desktopNotify.ControllerDesktopNotify controllerDesktopNotify1;
    private javax.swing.JLabel errorc;
    private javax.swing.JLabel errore;
    private javax.swing.JLabel errorf;
    private javax.swing.JLabel errorg;
    private javax.swing.JLabel errorl;
    private javax.swing.JLabel errorm;
    private javax.swing.JLabel errorn;
    private javax.swing.JLabel errort;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField t_correo;
    private javax.swing.JTextField t_fecha;
    private javax.swing.JTextField t_local;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_numero;
    private javax.swing.JTextField t_numf;
    private javax.swing.JTextField t_numg;
    private javax.swing.JTextField t_plan;
    private javax.swing.JLabel texto;
    private javax.swing.JRadioButton trampa;
    private javax.swing.JCheckBox verifica;
    // End of variables declaration//GEN-END:variables
 conectar cc= new conectar();
    Connection cn= cc.conexion();



}

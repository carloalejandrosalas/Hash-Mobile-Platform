
package controllers;


import database.conectar;

import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class reporte_usuarios extends javax.swing.JInternalFrame {
    JTextField calendario = new JTextField();

    DefaultTableModel model;
 
    public reporte_usuarios() {
        initComponents();
        cargar("");
        calendario.setEnabled(false);
        c_mes.setEnabled(false);
        rd_sin.setVisible(false);
        t_fecha.setVisible(false);
        
    }
    
   
    void calendario(){
        String estado = c_estado.getSelectedItem().toString();
        String ciudad = c_ciudad.getSelectedItem().toString();
        String conf_fecha_general;
        String conf_estado;
        String conf_ciudad;
        
        if(rd_fecha.isSelected()==true){
        conf_fecha_general= "SI";
        }else{
        conf_fecha_general= "NO";
        }
        
        if(c_estado.getSelectedItem().equals("Elige un estado")){
        conf_estado=  "NO";
        }else{
        conf_estado = "SI";
        }
    
        if(c_ciudad.getSelectedItem().equals("Sin especificar estado")){
            conf_ciudad=  "NO";
        }else{
            conf_ciudad = "SI";
        }

        if(c_ciudad.getSelectedItem().equals("Selecciona una ciudad")){
            conf_ciudad=  "NO";
        }else{
            conf_ciudad = "SI";
        }
        
        
        //String dia = Integer.toString(calendario.getCalendar().get(Calendar.DAY_OF_MONTH));
        //String mes = Integer.toString(calendario.getCalendar().get(Calendar.MONTH)+1);
        //String year = Integer.toString(calendario.getCalendar().get(Calendar.YEAR));

        String dia = "";
        String mes = "";
        String year = "";

        int MES;
        int DIA;
        MES = Integer.parseInt(mes);
        DIA = Integer.parseInt(dia);


switch(MES){
           case 1:
               mes="enero";
               break;
               
           case 2:
               mes="febrero";
               break;
               
           case 3:
               mes="marzo";
               break;
               
            case 4:
               mes="abril";
               break; 
            
            case 5:
               mes="mayo";
               break;
            
            case 6:
               mes="junio";
               break;
            
            case 7:
               mes="julio";
               break;
            
            case 8:
               mes="agosto";
               break;
            
            case 9:
               mes="septiembre";
               break;
               
            case 10:
               mes="octubre";
               break;
               
            case 11:
               mes="noviembre";
               break;
               
            case 12:
               mes="diciembre";
               break;
               
            default: 
               JOptionPane.showMessageDialog(null, "no elegiste ningun mes");
               break;
       }
       
       switch(DIA){
           case 1:
               dia="01";
               break;
           
           case 2:
               dia="02";
               break;
           
           case 3:
               dia="03";
               break;
           
           case 4:
               dia="04";
               break;
           
           case 5:
               dia="05";
               break;
           
           case 6:
               dia="06";
               break;
           
           case 7:
               dia="07";
               break;
           
           case 8:
               dia="08";
               break;
           
           case 9:
               dia="09";
               break;    
       }
       
       
      String fecha = (dia + "/" + mes+ "/" + year);
       t_fecha.setText(fecha);
       
      
        
      if((conf_fecha_general.equals("SI") && conf_estado.equals("SI")) && conf_ciudad.equals("SI")){
          System.out.println("El estado es "+estado+",la ciudad es "+ciudad+" y la fecha es "+fecha+"");
          
          DefaultTableModel model= new DefaultTableModel();
          String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
          model.setColumnIdentifiers(Titulos);
          this.tabla.setModel(model);
          try { 
   
        String sql="SELECT * FROM usuario WHERE ciudad  like '%"+ciudad+"%' AND fecha_ingreso LIKE '%"+fecha+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
      }
     
      else if((conf_fecha_general.equals("SI") && conf_estado.equals("SI"))){
          System.out.println("El estado es "+estado+" y la fecha es "+fecha+"");
          DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
    model.setColumnIdentifiers(Titulos);
           this.tabla.setModel(model);
    try { 
   
    String sql="SELECT * FROM usuario WHERE estado  like '%"+estado+"%' AND fecha_ingreso LIKE '%"+fecha+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
      }
      
      else{
          System.out.println("la fecha es "+fecha+"");
          DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
    model.setColumnIdentifiers(Titulos);
           this.tabla.setModel(model);
    try { 
   
    String sql="SELECT * FROM usuario where fecha_ingreso like '%"+fecha+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
      }
    }
   
    
    void cargar(String valor){
   DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
        model.setColumnIdentifiers(Titulos);
            this.tabla.setModel(model);
    try { 
   
   String sql="SELECT * FROM usuario";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
   
}
    
    @SuppressWarnings("unchecked")
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        porfecha = new javax.swing.ButtonGroup();
        estadociudad = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        c_estado = new javax.swing.JComboBox();
        btnbuscar = new javax.swing.JButton();
        t_fecha = new javax.swing.JTextField();
        c_mes = new javax.swing.JComboBox();
        //calendario = new com.toedter.calendar.JDateChooser();
        c_ciudad = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        rd_fecha = new javax.swing.JRadioButton();
        rd_mes = new javax.swing.JRadioButton();
        rd_sin = new javax.swing.JRadioButton();
        rd_todo = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("REPORTE CLIENTES");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BUSCAR:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        c_estado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elige un estado", "Baja California", "Baja California Sur", "Chihuahua", "Sinaloa", "Sonora" }));
        c_estado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        c_estado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_estadoItemStateChanged(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(153, 153, 153));
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        btnbuscar.setText("BUSCAR");
        btnbuscar.setAlignmentX(0.5F);
        btnbuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        t_fecha.setEditable(false);
        t_fecha.setBackground(new java.awt.Color(255, 255, 255));
        t_fecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_fecha.setText("Sin especificar fecha");
        t_fecha.setToolTipText("");
        t_fecha.setBorder(null);
        t_fecha.setCaretColor(new java.awt.Color(240, 240, 240));
        t_fecha.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        t_fecha.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        t_fecha.setSelectionColor(new java.awt.Color(240, 240, 240));
        t_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t_fechaActionPerformed(evt);
            }
        });

        c_mes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elija un mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo ", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        c_mes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                c_mesItemStateChanged(evt);
            }
        });

        // calendario.setDateFormatString("dd/MMMM/yyyy");
        calendario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calendarioMouseClicked(evt);
            }
        });

        c_ciudad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sin especificar estado" }));

        jLabel1.setText("Estado:");

        jLabel2.setText("Ciudad:");

        porfecha.add(rd_fecha);
        rd_fecha.setText("Fecha");
        rd_fecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_fechaActionPerformed(evt);
            }
        });

        porfecha.add(rd_mes);
        rd_mes.setText("Por Mes");
        rd_mes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_mesActionPerformed(evt);
            }
        });

        porfecha.add(rd_sin);
        rd_sin.setText("Sin especificar fecha");
        rd_sin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_sinActionPerformed(evt);
            }
        });

        rd_todo.setText("Mostrar todos");
        rd_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_todoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rd_todo))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(c_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(rd_mes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(c_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rd_fecha))
                    .addComponent(rd_sin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(calendario, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(t_fecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(calendario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(t_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_ciudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(rd_mes)
                            .addComponent(c_mes, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_fecha))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_todo)
                            .addComponent(rd_sin))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte.png"))); // NOI18N
        jButton2.setText("GENERAR REPORTE");
        jButton2.setAlignmentX(0.5F);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(153, 153, 153));
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        b4.setText("SALIR");
        b4.setAlignmentX(0.5F);
        b4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
    String conf_estado;
    String conf_ciudad;
    String conf_mes;
    String conf_fecha_general;
    String estado = c_estado.getSelectedItem().toString();
    String ciudad = c_ciudad.getSelectedItem().toString();
    String mes_general= c_mes.getSelectedItem().toString();
      
    rd_todo.setSelected(false);
    
    
    if(c_estado.getSelectedItem().equals("Elige un estado")){
        conf_estado=  "NO";
    }else{
        conf_estado = "SI";
    }
    
    if(c_ciudad.getSelectedItem().equals("Sin especificar estado")){
        conf_ciudad=  "NO";
    }else{
        conf_ciudad = "SI";
    }
    
    if(c_ciudad.getSelectedItem().equals("Selecciona una ciudad")){
        conf_ciudad=  "NO";
    }else{
        conf_ciudad = "SI";
    }
    
if(c_mes.getSelectedItem().equals("Elija un mes")){
        conf_mes= "NO";
    }else{
        conf_mes= "SI";
        
    }
    
    if(rd_fecha.isSelected()==true){
        conf_fecha_general= "SI";
    }else{
        conf_fecha_general= "NO";
    }
    
    
    //Empieza la busqueda!!!!!
    
   
    if(conf_mes.equals("SI") && conf_estado.equals("SI") && conf_ciudad.equals("SI") ) {
                System.out.println("El estado es "+estado+" y la ciudad es "+ciudad+" y el mes es "+mes_general+" ");
     
    DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
    model.setColumnIdentifiers(Titulos);
           this.tabla.setModel(model);
    try { 
   
    String sql="SELECT * FROM usuario WHERE ciudad  like '%"+ciudad+"%' AND fecha_ingreso LIKE '%"+mes_general+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    }
    
    else if((conf_fecha_general.equals("SI") && conf_estado.equals("SI")) && conf_ciudad.equals("SI"))   {
       
                calendario();
    }
    
    else if(conf_estado.equals("SI") && conf_ciudad.equals("SI")){
        System.out.println("El estado es "+estado+" y la ciudad es "+ciudad+" ");
        
    DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
    model.setColumnIdentifiers(Titulos);
           this.tabla.setModel(model);
    try { 
   
    String sql="SELECT * FROM usuario WHERE ciudad  like '%"+ciudad+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    }
    
    else if(conf_estado.equals("SI")&& conf_mes.equals("SI")){
    System.out.println("El estado es "+estado+" y el mes es "+mes_general+" ");
   
    DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
    model.setColumnIdentifiers(Titulos);
           this.tabla.setModel(model);
    try { 
   
    String sql="SELECT * FROM usuario WHERE estado  like '%"+estado+"%' AND fecha_ingreso LIKE '%"+mes_general+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    }
    
    else if(conf_estado.equals("SI")&& conf_fecha_general.equals("SI")){
        calendario();
    }
    
    else if(conf_estado.equals("SI")){
        System.out.println("EL estado es "+estado+"");
        DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
    model.setColumnIdentifiers(Titulos);
           this.tabla.setModel(model);
    try { 
   
    String sql="SELECT * FROM usuario WHERE estado LIKE '%"+estado+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    }
    
    else if(conf_mes.equals("SI")){
        System.out.println("EL mes es "+mes_general+"");
        
        DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
    model.setColumnIdentifiers(Titulos);
           this.tabla.setModel(model);
    try { 
   
    String sql="SELECT * FROM usuario WHERE fecha_ingreso LIKE '%"+mes_general+"%' ";
                String []registros= new String[10];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("numero_gratis");
                    registros[7]=rs.getString("numero_frecuente");
                    registros[8]=rs.getString("plan");
                    registros[9]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
    }
    
    else if(conf_fecha_general.equals("SI")){
        calendario();
    }
    
    else{
        System.out.println("Sin accion todavia ");
        JOptionPane.showMessageDialog(null, "No ha especificado lo que busca","ESPECIFICA",JOptionPane.PLAIN_MESSAGE);
    }
    
       
    
}//GEN-LAST:event_btnbuscarActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
// TODO add your handling code here:
    List lista = new ArrayList();
    
    
    for(int i=0;i<tabla.getRowCount();i++)
    {
        listaclientes clientes= new listaclientes(tabla.getValueAt(i, 0).toString(), 
                tabla.getValueAt(i, 1).toString(), tabla.getValueAt(i, 2).toString(), 
                tabla.getValueAt(i, 3).toString(),tabla.getValueAt(i, 4).toString(),
                tabla.getValueAt(i, 5).toString(), tabla.getValueAt(i, 8).toString(),
                tabla.getValueAt(i, 9).toString());
                
                
        lista.add(clientes);
    }

    
    
}//GEN-LAST:event_jButton2ActionPerformed

    private void t_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_fechaActionPerformed
     
    }//GEN-LAST:event_t_fechaActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        dispose();
    }//GEN-LAST:event_b4ActionPerformed

    private void c_estadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_estadoItemStateChanged
       String estado= c_estado.getSelectedItem().toString();
        
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(estado.equalsIgnoreCase("Sonora")){
                
            
                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesSonora(this.c_estado.getSelectedItem().toString())));
                
                
                
            }
            
            else if(estado.equalsIgnoreCase("Chihuahua")){        
             
                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesChihuahua(this.c_estado.getSelectedItem().toString())));
            
                
            }
            
            
                
           else if(estado.equalsIgnoreCase("Baja California")){        
                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesBajaCalifornia(this.c_estado.getSelectedItem().toString())));
            
                
            }
            
            
                
           else if(estado.equalsIgnoreCase("Baja California Sur")){        
                
                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesBajaCaliforniaSur(this.c_estado.getSelectedItem().toString())));
            
                }
             
            
                
           else if(estado.equalsIgnoreCase("Sinaloa")){        
                this.c_ciudad.setModel(new DefaultComboBoxModel(this.getCiudadesSinaloa(this.c_estado.getSelectedItem().toString())));
            
           }else{
               c_ciudad.removeAllItems();
               c_ciudad.addItem("Sin especificar estado");
           }
        }
    }//GEN-LAST:event_c_estadoItemStateChanged

    private void calendarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calendarioMouseClicked
       c_mes.setEnabled(false);
    }//GEN-LAST:event_calendarioMouseClicked

    private void c_mesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_c_mesItemStateChanged
        
    }//GEN-LAST:event_c_mesItemStateChanged

    private void rd_fechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_fechaActionPerformed
        calendario.setEnabled(true);
        c_mes.setEnabled(false);
        rd_sin.setVisible(true);
        c_mes.setSelectedIndex(0);
    }//GEN-LAST:event_rd_fechaActionPerformed

    private void rd_mesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_mesActionPerformed
        
        calendario.setEnabled(false);
        c_mes.setEnabled(true);
        rd_sin.setVisible(true);
        
    }//GEN-LAST:event_rd_mesActionPerformed

    private void rd_sinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_sinActionPerformed
        c_mes.setSelectedIndex(0);
        c_mes.setEnabled(false);
        calendario.setEnabled(false);
        rd_sin.setVisible(false);
    }//GEN-LAST:event_rd_sinActionPerformed

    private void rd_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_todoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_todoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b4;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JComboBox c_ciudad;
    private javax.swing.JComboBox c_estado;
    private javax.swing.JComboBox c_mes;
    private javax.swing.ButtonGroup estadociudad;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup porfecha;
    private javax.swing.JRadioButton rd_fecha;
    private javax.swing.JRadioButton rd_mes;
    private javax.swing.JRadioButton rd_sin;
    private javax.swing.JRadioButton rd_todo;
    private javax.swing.JTextField t_fecha;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
conectar cc= new conectar();
Connection cn = cc.conexion();


}

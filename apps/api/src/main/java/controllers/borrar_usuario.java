
package controllers;

import database.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class borrar_usuario extends javax.swing.JInternalFrame {
DefaultTableModel model;

    
    public borrar_usuario() {
        initComponents();
        cargar_todo();
        c_plan.setEnabled(false);
        t_registros.setText(""+tabla.getRowCount());
    }

    
   void cargar_todo(){
        
                
        
            DefaultTableModel modelo= new DefaultTableModel();
            String [] titulos={"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","PLAN","TIPO DE PLAN"}; 
            modelo.setColumnIdentifiers(titulos);
            this.tabla.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM usuario";

                String []registros= new String[8];
                

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("plan");
                    registros[7]=rs.getString("tipo_plan");

                    
                    modelo.addRow(registros);

                }
                tabla.setModel(modelo);
                t_registros.setText(""+tabla.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        
   }
    
   void cargar_nombre(){
   DefaultTableModel model= new DefaultTableModel();
   
   String nombre= t_buscar.getText();
   String [] titulos={"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","PLAN","TIPO DE PLAN"}; 
   String [] registros= new String[8];
   
   
   String sql="SELECT * FROM usuario WHERE nombre  LIKE '%"+nombre+"%'";
  
   
   model = new DefaultTableModel(null,titulos);
   
   try {
   
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        while(rs.next()){
            registros[0]=rs.getString("estado");
            registros[1]=rs.getString("ciudad");
            registros[2]=rs.getString("localidad");
            registros[3]=rs.getString("nombre");
            registros[4]=rs.getString("telefono");
            registros[5]=rs.getString("correo");
            registros[6]=rs.getString("plan");
            registros[7]=rs.getString("tipo_plan");
          model.addRow(registros);
        }
        tabla.setModel(model);
        t_registros.setText(""+tabla.getRowCount());
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
   
}
    
   void cargar_plan(){
        String plan=c_plan.getSelectedItem().toString();
                
        if(c_plan.getSelectedItem().equals("Seleccione un plan")){
                    
                JOptionPane.showMessageDialog(null, "Elija un plan valido","error",JOptionPane.ERROR_MESSAGE);
            
            }else{
            DefaultTableModel modelo= new DefaultTableModel();
            String [] titulos={"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","PLAN","TIPO DE PLAN"}; 
            modelo.setColumnIdentifiers(titulos);
            this.tabla.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM usuario WHERE tipo_plan='"+plan+"'";

                String []registros= new String[8];
                

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("plan");
                    registros[7]=rs.getString("tipo_plan");

                    
                    modelo.addRow(registros);
                   

                }
                tabla.setModel(modelo);
                t_registros.setText(""+tabla.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
   void cargar_telefono(){
          String telefono= t_buscar.getText();
            
            DefaultTableModel modelo= new DefaultTableModel();
            String [] titulos={"ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","PLAN","TIPO DE PLAN"}; 
            modelo.setColumnIdentifiers(titulos);
            this.tabla.setModel(modelo);
            try {

                
                String ConsultaSQL="SELECT * FROM usuario WHERE  telefono = '"+telefono+"'";

                String []registros= new String[8];
                

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0]=rs.getString("estado");
                    registros[1]=rs.getString("ciudad");
                    registros[2]=rs.getString("localidad");
                    registros[3]=rs.getString("nombre");
                    registros[4]=rs.getString("telefono");
                    registros[5]=rs.getString("correo");
                    registros[6]=rs.getString("plan");
                    registros[7]=rs.getString("tipo_plan");
        
                    
                    modelo.addRow(registros);

                }
                tabla.setModel(modelo);
                t_registros.setText(""+tabla.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        
   } 
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puntos = new javax.swing.ButtonGroup();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        rd_nombre = new javax.swing.JRadioButton();
        rd_telefono = new javax.swing.JRadioButton();
        rd_plan = new javax.swing.JRadioButton();
        t_buscar = new javax.swing.JTextField();
        c_plan = new javax.swing.JComboBox();
        b_buscar = new javax.swing.JButton();
        rd_todo = new javax.swing.JRadioButton();
        t_registros = new javax.swing.JTextField();
        b4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Borrar Usuario");
        setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        tabla.setBackground(new java.awt.Color(51, 51, 51));
        tabla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabla.setForeground(new java.awt.Color(255, 255, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ESTADO", "CIUDAD", "LOCALIDAD", "NOMBRE", "TELEFONOS", "PLAN", "TIPO DE PLAN"
            }
        ));
        tabla.setComponentPopupMenu(jPopupMenu2);
        tabla.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1144, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtro de busqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(153, 153, 153))); // NOI18N

        rd_nombre.setBackground(new java.awt.Color(51, 51, 51));
        puntos.add(rd_nombre);
        rd_nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_nombre.setForeground(new java.awt.Color(255, 255, 255));
        rd_nombre.setText("Por nombre");
        rd_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_nombreActionPerformed(evt);
            }
        });

        rd_telefono.setBackground(new java.awt.Color(51, 51, 51));
        puntos.add(rd_telefono);
        rd_telefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_telefono.setForeground(new java.awt.Color(255, 255, 255));
        rd_telefono.setText("Por telefono ");
        rd_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_telefonoActionPerformed(evt);
            }
        });

        rd_plan.setBackground(new java.awt.Color(51, 51, 51));
        puntos.add(rd_plan);
        rd_plan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_plan.setForeground(new java.awt.Color(255, 255, 255));
        rd_plan.setText("Por plan");
        rd_plan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rd_plan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_planActionPerformed(evt);
            }
        });

        t_buscar.setBackground(new java.awt.Color(51, 51, 51));
        t_buscar.setForeground(new java.awt.Color(255, 255, 255));

        c_plan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un plan", "Telcel Pro", "Telcel Plus Todo Destino Consumo Controlado", "Más x Menos por Segundo Todo Destino", "Plan 200", "Plan 100" }));

        b_buscar.setBackground(new java.awt.Color(51, 51, 51));
        b_buscar.setForeground(new java.awt.Color(51, 51, 51));
        b_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });

        rd_todo.setBackground(new java.awt.Color(51, 51, 51));
        puntos.add(rd_todo);
        rd_todo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_todo.setForeground(new java.awt.Color(255, 255, 255));
        rd_todo.setText("Mostrar todos");
        rd_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_todoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_nombre)
                    .addComponent(rd_todo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rd_telefono)
                    .addComponent(rd_plan))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(c_plan, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(b_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rd_nombre)
                            .addComponent(rd_telefono)
                            .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(c_plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rd_plan)
                            .addComponent(rd_todo)))
                    .addComponent(b_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        t_registros.setEditable(false);
        t_registros.setBackground(new java.awt.Color(51, 51, 51));
        t_registros.setForeground(new java.awt.Color(255, 255, 255));
        t_registros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b4.setBackground(new java.awt.Color(51, 51, 51));
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

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar2.png"))); // NOI18N
        jButton1.setText("ELIMINAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Numero de usuarios:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(b4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(t_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(t_registros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 4, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rd_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_nombreActionPerformed
        if(rd_nombre.isSelected()==true)
        {
            c_plan.setSelectedIndex(0);
            c_plan.setEnabled(false);
            t_buscar.setText("");
            t_buscar.setEnabled(true);
            
        }
    }//GEN-LAST:event_rd_nombreActionPerformed

    private void rd_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_telefonoActionPerformed
        if(rd_telefono.isSelected()==true)
        {
            c_plan.setSelectedIndex(0);
            c_plan.setEnabled(false);
            t_buscar.setEnabled(true);
            t_buscar.setText("");
        }
    }//GEN-LAST:event_rd_telefonoActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        if(rd_telefono.isSelected()==true)
        {
            cargar_telefono();

        }
        if(rd_nombre.isSelected()==true)
        {
            cargar_nombre();
        
        }
        
        if(rd_plan.isSelected()==true)
        {
            cargar_plan();
            }
        
        
    }//GEN-LAST:event_b_buscarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
             
    int fila = tabla.getSelectedRow();
    String telefono="";
    if(fila>=0){
    telefono=tabla.getValueAt(fila, 4).toString();
    if(JOptionPane.showConfirmDialog(null,"¿Desea eliminar al usuario ? ¿Esta seguro?","Eliminar",1)==0){
    try {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM usuario WHERE  telefono ='"+telefono+"'");
        pst.executeUpdate();
        
        if(rd_nombre.isSelected()==true){
            cargar_nombre();
        }
        
        if(rd_telefono.isSelected()==true){
            cargar_telefono();
        }
        
        if(rd_plan.isSelected()==true){
            cargar_plan();
        }
        
        if(rd_todo.isSelected()==true){
            cargar_todo();
        }
        
    } catch (Exception e) {
    }
    }
    }
    else{
            JOptionPane.showMessageDialog(null, "Seleccione un usuario para 'Eliminar'");
        }
    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int fila = tabla.getSelectedRow();
    String nombre="";
    if(fila>=0){
    nombre=tabla.getValueAt(fila, 3).toString();
    if(JOptionPane.showConfirmDialog(null,"¿Desea eliminar al usuario "+nombre+"? ¿Esta seguro?","Eliminar",1)==0){
    
    if(nombre.equals("CPRINCIPAL")){
        JOptionPane.showMessageDialog(null, "El usuario "+nombre+" no se puede borrar por razones de programacion");
    }else{
    
        try {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM usuario WHERE nombre='"+nombre+"'");
        pst.executeUpdate();
        
    } catch (Exception e) {
    }
    }
    }
    }else{
            JOptionPane.showMessageDialog(null, "Seleccione a un usuario para Eliminar");
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        dispose();
    }//GEN-LAST:event_b4ActionPerformed

    private void rd_planActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_planActionPerformed
        c_plan.setSelectedIndex(0);
        c_plan.setEnabled(true);
        t_buscar.setEnabled(false);
        t_buscar.setText("");
    }//GEN-LAST:event_rd_planActionPerformed

    private void rd_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_todoActionPerformed
       cargar_todo();
       c_plan.setSelectedIndex(0);
       c_plan.setEnabled(false);
       t_buscar.setEnabled(false);
    }//GEN-LAST:event_rd_todoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b4;
    private javax.swing.JButton b_buscar;
    private javax.swing.JComboBox c_plan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.ButtonGroup puntos;
    private javax.swing.JRadioButton rd_nombre;
    private javax.swing.JRadioButton rd_plan;
    private javax.swing.JRadioButton rd_telefono;
    private javax.swing.JRadioButton rd_todo;
    private javax.swing.JTextField t_buscar;
    private javax.swing.JTextField t_registros;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    conectar cc= new conectar();
    Connection cn= cc.conexion();
}

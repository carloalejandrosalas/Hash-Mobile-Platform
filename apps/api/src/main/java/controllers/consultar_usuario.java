
package controllers;

import database.conectar;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class consultar_usuario extends javax.swing.JInternalFrame {
DefaultTableModel model;
    
    public consultar_usuario() {
        initComponents();
        cargar("");
        t_buscar.setEnabled(false);
        
        t_registros.setText(""+tabla.getRowCount());
    }

    
    
    void cargar(String valor){
   DefaultTableModel model= new DefaultTableModel();
    String []Titulos = {"CODIGO","FECHA DE INGRESO","ESTADO","LOCALIDAD","CIUDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
    
        model.setColumnIdentifiers(Titulos);
            this.tabla.setModel(model);
    try { 
   
   String sql="SELECT * FROM usuario WHERE nombre  LIKE '%"+valor+"%'";
                String []registros= new String[12];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    registros[0]=rs.getString("codigo");
                    registros[1]=rs.getString("fecha_ingreso");
                    registros[2]=rs.getString("estado");
                    registros[3]=rs.getString("ciudad");
                    registros[4]=rs.getString("localidad");
                    registros[5]=rs.getString("nombre");
                    registros[6]=rs.getString("telefono");
                    registros[7]=rs.getString("correo");
                    registros[8]=rs.getString("numero_gratis");
                    registros[9]=rs.getString("numero_frecuente");
                    registros[10]=rs.getString("plan");
                    registros[11]=rs.getString("tipo_plan");
                    model.addRow(registros);
                }
                
     tabla.setModel(model);
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex);
    }
   
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        puntos = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        t_registros = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rd_telefono = new javax.swing.JRadioButton();
        t_buscar = new javax.swing.JTextField();
        b_buscar = new javax.swing.JButton();
        rd_todo = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rd_nombre = new javax.swing.JRadioButton();
        b4 = new javax.swing.JButton();
        b_mostrar = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Usuario");
        setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

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

        t_registros.setEditable(false);
        t_registros.setBackground(new java.awt.Color(0, 51, 51));
        t_registros.setForeground(new java.awt.Color(255, 255, 255));
        t_registros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Usuarios Telcel:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(t_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_registros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        rd_telefono.setBackground(new java.awt.Color(255, 255, 255));
        puntos.add(rd_telefono);
        rd_telefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_telefono.setText("Por telefono ");
        rd_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_telefonoActionPerformed(evt);
            }
        });

        t_buscar.setForeground(new java.awt.Color(51, 0, 0));

        b_buscar.setBackground(new java.awt.Color(0, 51, 51));
        b_buscar.setForeground(new java.awt.Color(255, 255, 255));
        b_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        b_buscar.setText("BUSCAR");
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });

        rd_todo.setBackground(new java.awt.Color(255, 255, 255));
        puntos.add(rd_todo);
        rd_todo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_todo.setSelected(true);
        rd_todo.setText("Mostrar todos los usuarios");
        rd_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_todoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("BUSCAR:");

        rd_nombre.setBackground(new java.awt.Color(255, 255, 255));
        puntos.add(rd_nombre);
        rd_nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_nombre.setText("Por nombre");
        rd_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_nombreActionPerformed(evt);
            }
        });

        b4.setBackground(new java.awt.Color(0, 51, 51));
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

        b_mostrar.setBackground(new java.awt.Color(0, 51, 51));
        b_mostrar.setForeground(new java.awt.Color(255, 255, 255));
        b_mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cargar.png"))); // NOI18N
        b_mostrar.setText("ACTUALIZAR");
        b_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_mostrarActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jRadioButton1.setText("Mostrar ultimos 20");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(b_mostrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(b4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(rd_telefono)
                                .addGap(0, 0, 0)
                                .addComponent(rd_nombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rd_todo)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(b_buscar)
                        .addGap(259, 259, 259))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_telefono)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(rd_nombre)
                                .addComponent(jRadioButton1)
                                .addComponent(rd_todo)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(b_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b4)
                    .addComponent(b_mostrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_mostrarActionPerformed
        cargar("");
         t_registros.setText(""+tabla.getRowCount());
    }//GEN-LAST:event_b_mostrarActionPerformed

    private void rd_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_telefonoActionPerformed
        if(rd_telefono.isSelected()==true)
        {

            t_buscar.setEnabled(true);
            t_buscar.setText("");
        }
    }//GEN-LAST:event_rd_telefonoActionPerformed

    private void b_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_buscarActionPerformed
        String telefono=t_buscar.getText();
        String nombre=t_buscar.getText();

        if(rd_nombre.isSelected()==true)
        {
            DefaultTableModel modelo= new DefaultTableModel();
            String []Titulos = {"CODIGO","FECHA DE INGRESO","ESTADO","LOCALIDAD","CIUDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
            modelo.setColumnIdentifiers(Titulos);
            this.tabla.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM usuario WHERE nombre='"+nombre+"'";

                String []registros= new String[12];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0]=rs.getString("codigo");
                    registros[1]=rs.getString("fecha_ingreso");
                    registros[2]=rs.getString("estado");
                    registros[3]=rs.getString("ciudad");
                    registros[4]=rs.getString("localidad");
                    registros[5]=rs.getString("nombre");
                    registros[6]=rs.getString("telefono");
                    registros[7]=rs.getString("correo");
                    registros[8]=rs.getString("numero_gratis");
                    registros[9]=rs.getString("numero_frecuente");
                    registros[10]=rs.getString("plan");
                    registros[11]=rs.getString("tipo_plan");
                    modelo.addRow(registros);

                }
                tabla.setModel(modelo);
                t_registros.setText(""+tabla.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if(rd_telefono.isSelected()==true)
        {
            DefaultTableModel modelo= new DefaultTableModel();
            String []Titulos = {"CODIGO","FECHA DE INGRESO","ESTADO","LOCALIDAD","CIUDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
            modelo.setColumnIdentifiers(Titulos);
            this.tabla.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM usuario WHERE nombre='"+telefono+"'";

                String []registros= new String[12];

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(ConsultaSQL);
                while(rs.next())
                {
                    registros[0]=rs.getString("codigo");
                    registros[1]=rs.getString("fecha_ingreso");
                    registros[2]=rs.getString("estado");
                    registros[3]=rs.getString("ciudad");
                    registros[4]=rs.getString("localidad");
                    registros[5]=rs.getString("nombre");
                    registros[6]=rs.getString("telefono");
                    registros[7]=rs.getString("correo");
                    registros[8]=rs.getString("numero_gratis");
                    registros[9]=rs.getString("numero_frecuente");
                    registros[10]=rs.getString("plan");
                    registros[11]=rs.getString("tipo_plan");
                    modelo.addRow(registros);

                }
                tabla.setModel(modelo);
                t_registros.setText(""+tabla.getRowCount());
            } catch (SQLException ex) {
                Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

        
    }//GEN-LAST:event_b_buscarActionPerformed

    private void rd_todoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_todoActionPerformed
        if(rd_todo.isSelected()==true)
        {
            cargar("");
            t_buscar.setEnabled(false);
            t_buscar.setText("");
        }
    }//GEN-LAST:event_rd_todoActionPerformed

    private void rd_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_nombreActionPerformed
        if(rd_nombre.isSelected()==true)
        {

            t_buscar.setText("");
            t_buscar.setEnabled(true);

        }
    }//GEN-LAST:event_rd_nombreActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        dispose();
    }//GEN-LAST:event_b4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b4;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup puntos;
    private javax.swing.JRadioButton rd_nombre;
    private javax.swing.JRadioButton rd_telefono;
    private javax.swing.JRadioButton rd_todo;
    private javax.swing.JTextField t_buscar;
    private javax.swing.JTextField t_registros;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    conectar cc= new conectar();
    Connection cn= cc.conexion();
}

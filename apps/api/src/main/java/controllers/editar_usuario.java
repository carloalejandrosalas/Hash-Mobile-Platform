/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Carlo Salas
 */
public class editar_usuario extends javax.swing.JInternalFrame {
DefaultTableModel model;
    /**
     * Creates new form editar_usuario
     */
    public editar_usuario(){
        initComponents();
        limpiar();
        bloquear();
        Limitar();
        cargar("");
        t_numero.setEnabled(false);
        t_nombre.setEnabled(false);
        t_codigo.setEnabled(false);
        t_buscar.setEnabled(false);
        t_registros.setText(""+tabla.getRowCount());
        si.setEnabled(false);
        no.setEnabled(false);
        
        c_plan.setVisible(false);
        checkf.setVisible(false);
        errorf.setVisible(false);
        checkg.setVisible(false);
        errorg.setVisible(false);
        t_tipo.setVisible(false);
    }
    
    void verificarGratis(String gratis)
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
    
     void verificarFrecuente(String frecuente)
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
    
    t_numero.setDocument(new LimitarCaracter(t_numero,10));
    t_numg.setDocument(new LimitarCaracter(t_numg,10));
    t_numf.setDocument(new LimitarCaracter(t_numf,10));
    t_plan.setDocument(new LimitarCaracter(t_plan,2));
}

    
      void cargar(String valor){
      DefaultTableModel model= new DefaultTableModel();    
      String []titulos = {"CODIGO","FECHA DE INGRESO","ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
      String [] registros= new String[12];
   
      String sql="SELECT * FROM usuario WHERE nombre  LIKE '%"+valor+"%'" ;
  
   
   model = new DefaultTableModel(null,titulos);
   
   try {
   
        Statement st= cn.createStatement();
        ResultSet rs=st.executeQuery(sql);
        
        while(rs.next()){
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
      
       
      
      
    
     void limpiar(){
    checkf.setVisible(false);
    checkg.setVisible(false);
    errorf.setVisible(false);
    errorg.setVisible(false);
    t_nombre.setText("");
    t_numero.setText("");
    t_numg.setText("");
    t_numf.setText("");
    t_plan.setText("");
    t_codigo.setText("");
    si.setEnabled(false);
    no.setEnabled(false);
    c_plan.setVisible(false);
    c_plan.removeAllItems();
    r_ejemplo.setVisible(false);
    r_ejemplo.setSelected(true);
  }

void bloquear(){
    t_codigo.setEnabled(false);
    t_nombre.setEnabled(false);
    t_numero.setEnabled(false);
    t_numg.setEnabled(false);
    t_numf.setEnabled(false);
    t_plan.setEnabled(false);
    b_actualizar.setEnabled(false);
    b_cancelar.setEnabled(false);
    si.setEnabled(false);
    no.setEnabled(false);
}
void desbloquear(){
    t_codigo.setEnabled(true);
    t_nombre.setEnabled(true);
    t_numero.setEnabled(true);
    t_numg.setEnabled(true);
    t_numf.setEnabled(true);
    t_plan.setEnabled(true);
    b_actualizar.setEnabled(true);
    b_cancelar.setEnabled(true);
    si.setEnabled(true);
    no.setEnabled(true);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rd_todo = new javax.swing.JRadioButton();
        b_buscar = new javax.swing.JButton();
        t_buscar = new javax.swing.JTextField();
        rd_telefono = new javax.swing.JRadioButton();
        rd_nombre = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        t_numg = new javax.swing.JTextField();
        t_nombre = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t_codigo = new javax.swing.JTextField();
        b_cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        t_numero = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        t_plan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        b_actualizar = new javax.swing.JButton();
        t_numf = new javax.swing.JTextField();
        t_registros = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        b4 = new javax.swing.JButton();
        si = new javax.swing.JRadioButton();
        no = new javax.swing.JRadioButton();
        c_plan = new javax.swing.JComboBox();
        r_ejemplo = new javax.swing.JRadioButton();
        checkf = new javax.swing.JLabel();
        errorf = new javax.swing.JLabel();
        checkg = new javax.swing.JLabel();
        errorg = new javax.swing.JLabel();
        t_tipo = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Editar Usuario");

        jButton1.setBackground(new java.awt.Color(51, 51, 0));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/tuerca2.png"))); // NOI18N
        jButton1.setText("EDITAR");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("BUSCAR:");

        rd_todo.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_todo);
        rd_todo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_todo.setSelected(true);
        rd_todo.setText("Mostrar todos los usuarios");
        rd_todo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rd_todo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_todoActionPerformed(evt);
            }
        });

        b_buscar.setBackground(new java.awt.Color(51, 51, 0));
        b_buscar.setForeground(new java.awt.Color(255, 255, 255));
        b_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/buscar.png"))); // NOI18N
        b_buscar.setText("BUSCAR");
        b_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_buscarActionPerformed(evt);
            }
        });

        t_buscar.setForeground(new java.awt.Color(51, 0, 0));

        rd_telefono.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_telefono);
        rd_telefono.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_telefono.setText("Por telefono ");
        rd_telefono.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rd_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_telefonoActionPerformed(evt);
            }
        });

        rd_nombre.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rd_nombre);
        rd_nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rd_nombre.setText("Por nombre");
        rd_nombre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rd_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_nombreActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("Numero frecuente:");

        t_numg.setForeground(new java.awt.Color(102, 51, 0));
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numgKeyTyped(evt);
            }
        });

        t_nombre.setForeground(new java.awt.Color(102, 51, 0));
        t_nombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Numero gratis:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 102, 102));
        jLabel12.setText("Nombre:");

        t_codigo.setEditable(false);
        t_codigo.setBackground(new java.awt.Color(255, 255, 204));
        t_codigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        b_cancelar.setBackground(new java.awt.Color(51, 51, 0));
        b_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        b_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelar.png"))); // NOI18N
        b_cancelar.setText("CANCELAR");
        b_cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_cancelarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Codigo:");

        t_numero.setEditable(false);
        t_numero.setBackground(new java.awt.Color(255, 255, 204));
        t_numero.setForeground(new java.awt.Color(102, 51, 0));
        t_numero.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_numero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numeroKeyTyped(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Numero:");

        t_plan.setEditable(false);
        t_plan.setForeground(new java.awt.Color(240, 240, 240));
        t_plan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_plan.setBorder(null);
        t_plan.setDisabledTextColor(new java.awt.Color(240, 240, 240));
        t_plan.setSelectedTextColor(new java.awt.Color(240, 240, 240));
        t_plan.setSelectionColor(new java.awt.Color(240, 240, 240));
        t_plan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_planKeyTyped(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Plan:");

        b_actualizar.setBackground(new java.awt.Color(51, 51, 0));
        b_actualizar.setForeground(new java.awt.Color(255, 255, 255));
        b_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/seleccionar.png"))); // NOI18N
        b_actualizar.setText("CONFIRMAR");
        b_actualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_actualizarActionPerformed(evt);
            }
        });

        t_numf.setForeground(new java.awt.Color(102, 51, 0));
        t_numf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        t_numf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                t_numfFocusLost(evt);
            }
        });
        t_numf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_numfKeyTyped(evt);
            }
        });

        t_registros.setEditable(false);
        t_registros.setBackground(new java.awt.Color(51, 51, 0));
        t_registros.setForeground(new java.awt.Color(255, 255, 255));
        t_registros.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        b4.setBackground(new java.awt.Color(51, 51, 0));
        b4.setForeground(new java.awt.Color(255, 255, 255));
        b4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/salir.png"))); // NOI18N
        b4.setText("SALIR");
        b4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        buttonGroup2.add(si);
        si.setText("SI");
        si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siActionPerformed(evt);
            }
        });

        buttonGroup2.add(no);
        no.setText("NO");
        no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noActionPerformed(evt);
            }
        });

        buttonGroup2.add(r_ejemplo);
        r_ejemplo.setText("SIN VALOR");

        checkf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        checkg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N

        errorg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/error.png"))); // NOI18N

        t_tipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        t_tipo.setForeground(new java.awt.Color(102, 102, 102));
        t_tipo.setText("Tipo plan:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(t_plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rd_telefono)
                                .addGap(0, 0, 0)
                                .addComponent(rd_nombre)
                                .addGap(0, 0, 0)
                                .addComponent(rd_todo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(4, 4, 4)
                                .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addComponent(b_buscar)
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(233, 233, 233)
                        .addComponent(t_registros, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1244, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(460, 460, 460)
                        .addComponent(b_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(b_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(346, 346, 346)
                        .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(t_numero, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(t_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(t_tipo)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel15)))
                                .addGap(82, 82, 82)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(si)
                                        .addGap(5, 5, 5)
                                        .addComponent(no)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(r_ejemplo))
                                    .addComponent(c_plan, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(t_numf, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkf)
                                        .addGap(6, 6, 6)
                                        .addComponent(errorf))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(45, 45, 45)
                                        .addComponent(t_numg, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(checkg)
                                        .addGap(6, 6, 6)
                                        .addComponent(errorg)))))))
                .addGap(7, 7, 7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(t_plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rd_telefono)
                            .addComponent(rd_nombre)
                            .addComponent(rd_todo))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(t_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(b_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(t_registros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(t_numg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkg)
                            .addComponent(errorg))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(t_numf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkf)
                            .addComponent(errorf))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(si)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(no)
                                .addComponent(r_ejemplo)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(t_tipo)
                            .addComponent(c_plan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(t_codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(t_numero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(t_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b_actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(b4))))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        dispose();
    }//GEN-LAST:event_b4ActionPerformed

    private void t_numfKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numfKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
            char d=evt.getKeyChar();
            if(d<'0' || d>'9')evt.consume();
        }
    }//GEN-LAST:event_t_numfKeyTyped

    private void b_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_actualizarActionPerformed
        // TODO add your handling code here:
       String telefono=t_numero.getText();
       String numero_gratis=t_numg.getText();
       verificarGratis(numero_gratis);
       String numero_frecuente=t_numf.getText();
       verificarFrecuente(numero_frecuente);      

            if(si.isSelected()==true){
                t_plan.setText("SI");
            }

            if(no.isSelected()==true){
                t_plan.setText("NO");
            }
            
            if(t_numg.getText().equals(telefono)){
                JOptionPane.showMessageDialog(null, "NO PUEDES PONER TU MISMO NUMERO COMO NUMERO GRATIS","VALIDAR",JOptionPane.ERROR_MESSAGE);
            }
            
            else if(t_numf.getText().equals(telefono)){
                JOptionPane.showMessageDialog(null, "NO PUEDES PONER TU MISMO NUMERO COMO NUMERO FRECUENTE","VALIDAR",JOptionPane.ERROR_MESSAGE);
            }
            
            else if(t_numg.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Pon un numero gratis valido","VALIDAR",JOptionPane.ERROR_MESSAGE);
            
            }
             else if(t_numf.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Pon un numero frecuente valido","VALIDAR",JOptionPane.ERROR_MESSAGE);
            }
             
            else if(t_numf.getText().equals(numero_gratis)){
                JOptionPane.showMessageDialog(null, "Este numero ya esta como numero gratis","VALIDAR",JOptionPane.ERROR_MESSAGE);
            
            }else{
            
            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE usuario SET nombre='"+t_nombre.getText()+"',telefono='"+t_numero.getText()+"',numero_gratis='"+t_numg.getText()+"',numero_frecuente='"+t_numf.getText()+"',plan='"+t_plan.getText()+"',tipo_plan='"+c_plan.getSelectedItem().toString()+"' WHERE codigo='"+t_codigo.getText()+"'");
                pst.executeUpdate();

            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
            si.setSelected(false);
            no.setSelected(false);
            cargar("");
            bloquear();
            limpiar();
          }
    }//GEN-LAST:event_b_actualizarActionPerformed

    private void t_planKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_planKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);

        }
        char d=evt.getKeyChar();
        if(d<'A' || d>'Z')evt.consume();
    }//GEN-LAST:event_t_planKeyTyped

    private void t_numeroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numeroKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
            char d=evt.getKeyChar();
            if(d<'0' || d>'9')evt.consume();
        }
    }//GEN-LAST:event_t_numeroKeyTyped

    private void b_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_cancelarActionPerformed
        bloquear();
        limpiar();
        checkf.setVisible(false);
        errorf.setVisible(false);
        checkg.setVisible(false);
        errorg.setVisible(false);
        si.setSelected(false);
        no.setSelected(false);
    }//GEN-LAST:event_b_cancelarActionPerformed

    private void t_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nombreKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);

        }
        char d=evt.getKeyChar();
        if(d<'A' || d>'Z')evt.consume();
    }//GEN-LAST:event_t_nombreKeyTyped

    private void t_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_nombreActionPerformed

    private void t_numgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_numgKeyTyped
        char c=evt.getKeyChar();
        if(Character.isLowerCase(c)){
            String cad=(""+c).toUpperCase();
            c=cad.charAt(0);
            evt.setKeyChar(c);
            char d=evt.getKeyChar();
            if(d<'0' || d>'9')evt.consume();
        }
    }//GEN-LAST:event_t_numgKeyTyped

    private void t_numgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t_numgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_t_numgActionPerformed

    private void rd_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_nombreActionPerformed
        if(rd_nombre.isSelected()==true)
        {
            t_buscar.setText("");
            t_buscar.setEnabled(true);

        }
    }//GEN-LAST:event_rd_nombreActionPerformed

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
            cargar(t_buscar.getText());
            t_registros.setText(""+tabla.getRowCount());
        }

        if(rd_telefono.isSelected()==true)
        {
            DefaultTableModel modelo= new DefaultTableModel();
            String []Titulos = {"CODIGO","FECHA DE INGRESO","ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","CORREO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN","TIPO DE PLAN"};
            modelo.setColumnIdentifiers(Titulos);
            this.tabla.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM usuario WHERE telefono='"+telefono+"'";

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

        if(rd_todo.isSelected()==true)
        {
            DefaultTableModel modelo= new DefaultTableModel();
            String []Titulos = {"CODIGO","FECHA DE INGRESO","ESTADO","CIUDAD","LOCALIDAD","NOMBRE","TELEFONO","NUMERO GRATIS","NUMERO FRECUENTE","PLAN"};
            modelo.setColumnIdentifiers(Titulos);
            this.tabla.setModel(modelo);
            try {

                String ConsultaSQL="SELECT * FROM usuario";

                String []registros= new String[9];

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
                    registros[7]=rs.getString("numero_gratis");
                    registros[8]=rs.getString("numero_frecuente");
                    registros[9]=rs.getString("plan");

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
            t_buscar.setEnabled(false);
            t_buscar.setText("");

            cargar("");
            t_registros.setText(""+tabla.getRowCount());

        }

    }//GEN-LAST:event_rd_todoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int fila=tabla.getSelectedRow();
        if(fila>=0){

            t_codigo.setText(tabla.getValueAt(fila, 0).toString());
            t_nombre.setText(tabla.getValueAt(fila, 5).toString());
            t_numero.setText(tabla.getValueAt(fila, 6).toString());
            t_numg.setText(tabla.getValueAt(fila, 8).toString());
            t_numf.setText(tabla.getValueAt(fila, 9).toString());
            t_plan.setText(tabla.getValueAt(fila, 10).toString());
            
           
       
            
            
            if(t_plan.getText().equals("SI")){
                si.setSelected(true);
                t_tipo.setVisible(true);
                c_plan.setVisible(true);
                c_plan.removeAllItems();
                c_plan.addItem("Telcel Pro"); 
                c_plan.addItem("Telcel Plus Todo Destino Consumo Controlado");
                c_plan.addItem("Más x Menos por Segundo Todo Destino");
                c_plan.addItem("Plan 200");
                c_plan.addItem("Plan 100");

            }

            if(t_plan.getText().equals("NO")){
                t_tipo.setVisible(false);
                no.setSelected(true);
                 c_plan.setVisible(false);
       
                c_plan.removeAllItems();
                c_plan.addItem("Sin plan");
            }
        
            
            c_plan.setSelectedItem(tabla.getValueAt(fila, 11).toString());
            desbloquear();
       
        
            
            
        
        
        }
        else{
            JOptionPane.showMessageDialog(null,"Seleccione una fila para Modificar");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void siActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siActionPerformed
        t_tipo.setVisible(true);
        c_plan.setVisible(true);
                c_plan.removeAllItems();
                c_plan.addItem("Telcel Pro"); 
                c_plan.addItem("Telcel Plus Todo Destino Consumo Controlado");
                c_plan.addItem("Más x Menos por Segundo Todo Destino");
                c_plan.addItem("Plan 200");
                c_plan.addItem("Plan 100");
                
    }//GEN-LAST:event_siActionPerformed

    private void noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noActionPerformed
        t_tipo.setVisible(false);
        c_plan.setVisible(false);
       
                c_plan.removeAllItems();
                c_plan.addItem("Sin plan");
    }//GEN-LAST:event_noActionPerformed

    private void t_numgFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_numgFocusLost
        String numero_gratis=t_numg.getText();
       verificarGratis(numero_gratis);
        
    }//GEN-LAST:event_t_numgFocusLost

    private void t_numfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_t_numfFocusLost
       
        String numero_frecuente=t_numf.getText();
       verificarFrecuente(numero_frecuente);
    }//GEN-LAST:event_t_numfFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b4;
    private javax.swing.JButton b_actualizar;
    private javax.swing.JButton b_buscar;
    private javax.swing.JButton b_cancelar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox c_plan;
    private javax.swing.JLabel checkf;
    private javax.swing.JLabel checkg;
    private javax.swing.JLabel errorf;
    private javax.swing.JLabel errorg;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton no;
    private javax.swing.JRadioButton r_ejemplo;
    private javax.swing.JRadioButton rd_nombre;
    private javax.swing.JRadioButton rd_telefono;
    private javax.swing.JRadioButton rd_todo;
    private javax.swing.JRadioButton si;
    private javax.swing.JTextField t_buscar;
    private javax.swing.JTextField t_codigo;
    private javax.swing.JTextField t_nombre;
    private javax.swing.JTextField t_numero;
    private javax.swing.JTextField t_numf;
    private javax.swing.JTextField t_numg;
    private javax.swing.JTextField t_plan;
    private javax.swing.JTextField t_registros;
    private javax.swing.JLabel t_tipo;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    conectar cc= new conectar();
    Connection cn= cc.conexion();
}

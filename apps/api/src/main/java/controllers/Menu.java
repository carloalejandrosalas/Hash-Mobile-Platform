
package controllers;

import javax.swing.ImageIcon;


public class Menu extends javax.swing.JFrame {
notificacion jct = new notificacion( this );
  
    public Menu() {
        initComponents();
        escritorio.setBorder(new ImagenFondo());
        this.setExtendedState(Menu.MAXIMIZED_BOTH);
        this.setTitle("Sistema de telefonia - HashNetwork");
        
    }
    
   

    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        principal = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        hash_user = new javax.swing.JMenu();
        nuevo_usuario = new javax.swing.JMenuItem();
        usuario_consultar = new javax.swing.JMenuItem();
        usario_editar = new javax.swing.JMenuItem();
        usuario_baja = new javax.swing.JMenuItem();
        report_user = new javax.swing.JMenuItem();
        credit_hash = new javax.swing.JMenu();
        promo = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        help = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());

        escritorio.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Hashtag.png"))); // NOI18N

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel1)
                .addContainerGap(1146, Short.MAX_VALUE))
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(escritorioLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1)
                .addContainerGap(164, Short.MAX_VALUE))
        );
        escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 0));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        principal.setBackground(new java.awt.Color(0, 0, 0));
        principal.setText("Principal");

        jMenuItem1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuItem1.setText("Bienvenido");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        principal.add(jMenuItem1);

        jMenuItem10.setText("Ganancias");
        principal.add(jMenuItem10);

        jMenuItem15.setText("Nuevo sistema-usuario");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        principal.add(jMenuItem15);

        jMenuItem16.setText("Contacto");
        principal.add(jMenuItem16);

        jMenuItem2.setText("Generar telefonos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        principal.add(jMenuItem2);

        jMenuBar1.add(principal);

        hash_user.setBackground(new java.awt.Color(0, 0, 0));
        hash_user.setText("HashUser");
        hash_user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hash_userActionPerformed(evt);
            }
        });

        nuevo_usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo_usuario.png"))); // NOI18N
        nuevo_usuario.setText("Nuevo Ingreso");
        nuevo_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevo_usuarioActionPerformed(evt);
            }
        });
        hash_user.add(nuevo_usuario);

        usuario_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/consultar_usuario.png"))); // NOI18N
        usuario_consultar.setText("Consultar");
        usuario_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_consultarActionPerformed(evt);
            }
        });
        hash_user.add(usuario_consultar);

        usario_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/editar_usuario.png"))); // NOI18N
        usario_editar.setText("Editar");
        usario_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usario_editarActionPerformed(evt);
            }
        });
        hash_user.add(usario_editar);

        usuario_baja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/borrar_usuario.png"))); // NOI18N
        usuario_baja.setText("Baja de usuario");
        hash_user.add(usuario_baja);

        report_user.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reporte_usuario.png"))); // NOI18N
        report_user.setText("Reportes");
        hash_user.add(report_user);

        jMenuBar1.add(hash_user);

        credit_hash.setBackground(new java.awt.Color(0, 0, 0));
        credit_hash.setText("CreditHash");
        jMenuBar1.add(credit_hash);

        promo.setBackground(new java.awt.Color(0, 0, 0));
        promo.setText("Promociones");
        jMenuBar1.add(promo);
        jMenuBar1.add(jMenu7);

        help.setBackground(new java.awt.Color(255, 255, 255));
        help.setText("Ayuda");
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void hash_userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hash_userActionPerformed
       
    }//GEN-LAST:event_hash_userActionPerformed

    private void nuevo_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevo_usuarioActionPerformed
        registrar b= new registrar();
        escritorio.add(b);
        b.show();
    }//GEN-LAST:event_nuevo_usuarioActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_helpActionPerformed

    private void usario_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usario_editarActionPerformed
        editar_usuario b= new editar_usuario();
        escritorio.add(b);
        b.show();
    }//GEN-LAST:event_usario_editarActionPerformed

    private void usuario_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_consultarActionPerformed
       consultar_usuario b= new consultar_usuario();
        escritorio.add(b);
        b.show();
    }//GEN-LAST:event_usuario_consultarActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu credit_hash;
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu hash_user;
    private javax.swing.JMenu help;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem nuevo_usuario;
    private javax.swing.JMenu principal;
    private javax.swing.JMenu promo;
    private javax.swing.JMenuItem report_user;
    private javax.swing.JMenuItem usario_editar;
    private javax.swing.JMenuItem usuario_baja;
    private javax.swing.JMenuItem usuario_consultar;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoadFreylegastoseminario.ventanas;

import SoadFreylegastoseminario.bd.crud.UsuarioJpaController;
import SoadFreylegastoseminario.bd.crud.exceptions.PreexistingEntityException;
import SoadFreylegastoseminario.bd.tablas.Usuario;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ODETH
 */
public class VentanaLogin extends javax.swing.JDialog {
     
    private Usuario u;
    /**
     * Creates new form VentanaCrudUsuario
     */
    private VentanaPrincipal ventanaPpal;
    public VentanaLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        ventanaPpal = (VentanaPrincipal)parent;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoClave = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Iniciar Sesion en el Sistema");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("EMAIL:");

        campoEmail.setToolTipText("Ingrese la cedula");
        campoEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoEmailMouseClicked(evt);
            }
        });
        campoEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoEmailActionPerformed(evt);
            }
        });
        campoEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoEmailKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoEmailKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CLAVE:");

        campoClave.setToolTipText("Ingrese la clave");
        campoClave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoClaveMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                campoClaveMousePressed(evt);
            }
        });
        campoClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoClaveActionPerformed(evt);
            }
        });
        campoClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoClaveKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(campoClave))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/Usuario96.png"))); // NOI18N

        botonAgregar.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/agregar48.png"))); // NOI18N
        botonAgregar.setMnemonic('A');
        botonAgregar.setToolTipText("guarda los datos de los usuario en la base de datos");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonSalir.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/borrar48.png"))); // NOI18N
        botonSalir.setMnemonic('C');
        botonSalir.setToolTipText("Limpia los valores del formulario");
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonLimpiar.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/limpiar48.png"))); // NOI18N
        botonLimpiar.setMnemonic('C');
        botonLimpiar.setToolTipText("Limpia los valores del formulario");
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(botonSalir)
                        .addGap(33, 33, 33)
                        .addComponent(botonLimpiar)
                        .addGap(34, 34, 34)
                        .addComponent(botonAgregar)
                        .addGap(30, 30, 30))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botonAgregar)
                    .addComponent(botonLimpiar)
                    .addComponent(botonSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // verificado
        
        
        if(validarCampo(campoEmail)== false){
            JOptionPane.showMessageDialog(this, "El Email");
            return;
        }
        if(validarCampo(campoEmail)== false){
            JOptionPane.showMessageDialog(this,"El email es");
            return;
            
        }
         if (validarCampo(campoClave)  == false){
           JOptionPane.showMessageDialog(this, "verifico clave");
            return;
       }
         String email = campoEmail.getText();
         String clave = String.valueOf(campoClave.getPassword());
         EntityManagerFactory conexion = Persistence.createEntityManagerFactory("conexion_bd");
         UsuarioJpaController crud = new UsuarioJpaController(conexion);
         Query consulta = crud.getEntityManager().createNamedQuery("Usuario.findByEmail");
         consulta.setParameter("email", email);
         
     
         try{
             u = (Usuario)consulta.getSingleResult();    
                 
         
             if(u.getClave().equals(clave)){
                 JOptionPane.showMessageDialog(this, "saludos"+ u.getNombre());
                    this.dispose();
                 }else{
                       JOptionPane.showMessageDialog(this, "clave incorrecta");
                 }
         }catch(Exception error){
                 JOptionPane.showMessageDialog(this, "Usuario no existe");
                         }
         
         
    }//GEN-LAST:event_botonAgregarActionPerformed
    
    public void guardarUsuario(){
       
        //paso 1: recuperar los??datos del formulario
        String cc = campoEmail.getText();
        char[] pass = campoClave.getPassword();
        String clave = String.valueOf(pass);
       
        //paso 2: crear un objeto o instancia de la clase
        u = new Usuario();
        //Paso3: setear configurar o cambiar los valores 
        u.setCedula(cc);
      
        clave = (clave.isEmpty())? null : clave;
        u.setClave(clave);
        
        //paso 4: conectarse a la base de datos
        EntityManagerFactory conexion =Persistence.createEntityManagerFactory("conexion_bd");
        // paso5: crear un objeto de la clase usuario de la clase jpa controller
        UsuarioJpaController crudUser = new UsuarioJpaController(conexion);
         //INSERT INTO USUARIOS ('XXX',............
        try {
           
            crudUser.create(u);
            int total = crudUser.getUsuarioCount();
            String mensaje = "Usuario Guardado con Exito\n Total :"+total;
            JOptionPane.showMessageDialog(this,mensaje);
             botonLimpiarActionPerformed(null);
        } catch (PreexistingEntityException error) {
           JOptionPane.showMessageDialog(this,"El usuario fue registrado previamente");
            
        } catch (Exception ex){
            JOptionPane.showMessageDialog(this,"Error: No guardo el usuario");
        }
        
    }
    
    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        //verificado
        campoEmail.setText("");
        campoClave.setText("");
        
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
    //verificado
      int res = JOptionPane.showConfirmDialog(this, "Desea cerrar la aplicacion","Confirmar", JOptionPane.YES_NO_OPTION);
      if(res == JOptionPane.YES_NO_OPTION){
          System.exit(0);
          
      }
        
        
       

    }//GEN-LAST:event_botonSalirActionPerformed

    private void campoEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEmailKeyTyped
        // si
        /*
        char tecla = evt.getKeyChar();
        if(Character.isDigit(tecla)== false){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();

        }*/
       /* char tecla = evt.getKeyChar();
        if(Character.isAlphabetic(tecla) || Character.isDigit(tecla)){

        }else{
              evt.consume();
              getToolkit().beep();
}*/
       
        // Patr??n para validar el email
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
 
        // El email a validar
        String tecla = "info@programacionextrema.com";
 
        Matcher mather = pattern.matcher(tecla);
 
        if (mather.find() == true) {
            System.out.println("El email ingresado es v??lido.");
        } else {
            System.out.println("El email ingresado es inv??lido.");
        }
    
    }//GEN-LAST:event_campoEmailKeyTyped

    private void campoEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEmailKeyPressed
        // si
        campoEmail.setBackground(Color.white);

    }//GEN-LAST:event_campoEmailKeyPressed

    private void campoEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoEmailMouseClicked
        // si
        campoEmail.setBackground(Color.white);
    }//GEN-LAST:event_campoEmailMouseClicked
    /*private void itemReporteActionPerformed(java.awt.event.ActionEvent evt) {                                            
      
    }*/   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
    }//GEN-LAST:event_formWindowOpened

    private void campoClaveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoClaveMousePressed
        // 
        
        
    }//GEN-LAST:event_campoClaveMousePressed

    private void campoClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoClaveKeyPressed
        // si
        campoClave.setBackground(Color.white);
    }//GEN-LAST:event_campoClaveKeyPressed

    private void campoClaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoClaveMouseClicked
        // si
        campoClave.setBackground(Color.white);
        
        
    }//GEN-LAST:event_campoClaveMouseClicked

    private void campoEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoEmailActionPerformed
        // verificado pero no hay nada pendiente
    }//GEN-LAST:event_campoEmailActionPerformed

    private void campoClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoClaveActionPerformed
        // verificado creado no hay nada
    }//GEN-LAST:event_campoClaveActionPerformed
       
    
    
    public boolean validarCampo(JTextField campo){
        String dato = campo.getText();
        dato = dato.trim();
        if(dato.isEmpty()){
            campo.setText("");
            campo.setBackground(Color.RED);
            campo.requestFocus();
            return false;
        }
        else{
            return true;
            
        }
    }
    
    public boolean validarEmail(String email){
        int tam = email.length();
        boolean espacio = true;
        int numArroba = 0;
        if(email.charAt(0) == 'o'){
            return false;
        }
        if(email.charAt(tam-1) == '0'){
            return false;
        }
        for(int i = 0; i < tam; i++){
        char letra = email.charAt(i);
        if(letra == ' '){
            return false;
        }
        if(letra == '@'){
            numArroba += 1;
        }
    }
    if( numArroba == 0 || numArroba > 1){
        return false;
    }
    return true;
   
}
    
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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaLogin dialog = new VentanaLogin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAgregar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonSalir;
    private javax.swing.JPasswordField campoClave;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

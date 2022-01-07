/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoadFreylegastoseminario.ventanas;

import SoadFreylegastoseminario.bd.crud.UsuarioJpaController;
import SoadFreylegastoseminario.bd.crud.exceptions.IllegalOrphanException;
import SoadFreylegastoseminario.bd.crud.exceptions.NonexistentEntityException;
import SoadFreylegastoseminario.bd.crud.exceptions.PreexistingEntityException;
import SoadFreylegastoseminario.bd.tablas.Usuario;
import java.awt.Color;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author ODETH
 */
public class VentanaCrudUsuario extends javax.swing.JDialog {
     
    private Usuario u;
    /**
     * Creates new form VentanaCrudUsuario
     */
    private VentanaPrincipal ventanaPpal;
    public VentanaCrudUsuario(java.awt.Frame parent, boolean modal) {
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
        campoCedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoClave = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        campoNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoEmail = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        botonAgregar = new javax.swing.JButton();
        botonBuscar = new javax.swing.JButton();
        botonEliminar = new javax.swing.JButton();
        botonReporte = new javax.swing.JButton();
        botonLimpiar = new javax.swing.JButton();
        botonEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 153, 153));
        jLabel1.setText("Formulario Datos Proyecto");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("CEDULA");

        campoCedula.setToolTipText("Ingrese la cedula");
        campoCedula.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoCedulaMouseClicked(evt);
            }
        });
        campoCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoCedulaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCedulaKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("CLAVE");

        campoClave.setToolTipText("Ingrese la clave");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("NOMBRE");

        campoNombre.setToolTipText("Ingrese el nombre");
        campoNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoNombreMouseClicked(evt);
            }
        });
        campoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNombreActionPerformed(evt);
            }
        });
        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoNombreKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("EMAIL");

        campoEmail.setToolTipText("ingrese el email");
        campoEmail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                campoEmailMouseClicked(evt);
            }
        });
        campoEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                campoEmailKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(campoCedula)
                        .addComponent(campoClave, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                    .addComponent(campoNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(campoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/chart-add-icon48.png"))); // NOI18N

        botonAgregar.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/agregar48.png"))); // NOI18N
        botonAgregar.setMnemonic('A');
        botonAgregar.setToolTipText("guarda los datos de los usuario en la base de datos");
        botonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        botonBuscar.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/buscar48.png"))); // NOI18N
        botonBuscar.setMnemonic('C');
        botonBuscar.setToolTipText("Limpia los valores del formulario");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonEliminar.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/borrar48.png"))); // NOI18N
        botonEliminar.setMnemonic('C');
        botonEliminar.setToolTipText("Limpia los valores del formulario");
        botonEliminar.setEnabled(false);
        botonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        botonReporte.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/reporte48.png"))); // NOI18N
        botonReporte.setMnemonic('C');
        botonReporte.setToolTipText("Limpia los valores del formulario");
        botonReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteActionPerformed(evt);
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

        botonEditar.setFont(new java.awt.Font("Arial Black", 1, 8)); // NOI18N
        botonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/iconos/editar48.png"))); // NOI18N
        botonEditar.setMnemonic('C');
        botonEditar.setToolTipText("Limpia los valores del formulario");
        botonEditar.setEnabled(false);
        botonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonEditarActionPerformed(evt);
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
                        .addComponent(botonLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonReporte)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botonEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(botonEditar)
                        .addGap(28, 28, 28)
                        .addComponent(botonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonBuscar)
                    .addComponent(botonAgregar)
                    .addComponent(botonEliminar)
                    .addComponent(botonReporte)
                    .addComponent(botonLimpiar)
                    .addComponent(botonEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        
        //paso1 recuperar los datos del formulario
        if(validarCampo(campoCedula) == false) {
            JOptionPane.showMessageDialog(this, "La Cedula es Necesaria");
            return;
        }
        String cc = campoCedula.getText();
        //paso 2 conecte BD
        //Paso 3 conecte BD
        EntityManagerFactory conexion = Persistence.createEntityManagerFactory("conexion_bd");
        // paso 4 crear un obj de la clase usuarioJpaController
        UsuarioJpaController crudUser = new UsuarioJpaController(conexion);
        // paso5 buscar el objeto en la bd
         u = crudUser.findUsuario(cc);
        if(u != null){
            campoCedula.setText(u.getCedula());
            campoClave.setText(u.getClave());
            campoNombre.setText(u.getNombre());
            campoEmail.setText(u.getEmail());
            botonEditar.setEnabled(true);
            botonEliminar.setEnabled(true);
            
        }
        else{
            botonEditar.setEnabled(false);
            JOptionPane.showMessageDialog(this,"Usuario con cedula:"+cc+"No existe");
        }
        
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void campoCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaKeyTyped
        // TODO add your handling code here:
        char tecla = evt.getKeyChar();
        if(Character.isDigit(tecla)== false){
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            
            
        }
    }//GEN-LAST:event_campoCedulaKeyTyped

    private void botonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarActionPerformed
        // TODO add your handling code here:
        if(validarCampo(campoCedula)== false){
            JOptionPane.showMessageDialog(this,"La cedula es necesaria");
            return;
            
        }
         if(validarCampo(campoNombre)== false){
            JOptionPane.showMessageDialog(this,"El Nombre es necesaria");
            return;
            
        }
          if(validarCampo(campoEmail)== false){
            JOptionPane.showMessageDialog(this,"El Email es necesaria");
            return;
            
        }
          if(validarEmail(campoEmail.getText()) == false){
             JOptionPane.showMessageDialog(this,"Corrija el Email");
             return;
              
          }
          guardarUsuario();
    }//GEN-LAST:event_botonAgregarActionPerformed

    public void guardarUsuario(){
        
        //paso 1: recuperar los´datos del formulario
        String cc = campoCedula.getText();
        char[] pass = campoClave.getPassword();
        String clave = String.valueOf(pass);
        String nombre = campoNombre.getText();
        String email = campoEmail.getText();
        //paso 2: crear un objeto o instancia de la clase
        Usuario u = new Usuario();
        //Paso3: setear configurar o cambiar los valores 
        u.setCedula(cc);
        u.setNombre(nombre);
        u.setEmail(email);
        clave = (clave.isEmpty())? null : clave;
        u.setClave(clave);
        u.setEmail(email);
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
    
    private void campoCedulaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCedulaKeyPressed
        // TODO add your handling code here:
        campoCedula.setBackground(Color.white);
        
    }//GEN-LAST:event_campoCedulaKeyPressed

    private void campoCedulaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoCedulaMouseClicked
        // TODO add your handling code here:
        campoCedula.setBackground(Color.white);
    }//GEN-LAST:event_campoCedulaMouseClicked

    private void campoNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoNombreKeyPressed
        // TODO add your handling code here:
        campoNombre.setBackground(Color.white);
    }//GEN-LAST:event_campoNombreKeyPressed

    private void campoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNombreActionPerformed

    private void campoNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoNombreMouseClicked
        // TODO add your handling code here:
        campoNombre.setBackground(Color.white);
    }//GEN-LAST:event_campoNombreMouseClicked

    private void campoEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoEmailKeyPressed
        // TODO add your handling code here:
        campoEmail.setBackground(Color.white);
    }//GEN-LAST:event_campoEmailKeyPressed

    private void campoEmailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_campoEmailMouseClicked
        // TODO add your handling code here:
        campoNombre.setBackground(Color.white);
    }//GEN-LAST:event_campoEmailMouseClicked

    private void botonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEliminarActionPerformed
        
            String cedula = campoCedula.getText();
            if(validarCampo(campoCedula) == false){
                JOptionPane.showMessageDialog(this, "La cedula es necesaria");
                return;
            }
            if(u.getCedula().equals(cedula) == false){
                JOptionPane.showMessageDialog(this, "No puedo cambiar la cedula");
                campoCedula.setText(u.getCedula());
                return;
            }
            int res = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar este Usuario?","OJO - PILAS",JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.NO_OPTION){
                return;   
            }
            //Paso 3 conecte BD
            EntityManagerFactory conexion = Persistence.createEntityManagerFactory("conexion_bd");
            // paso 4 crear un obj de la clase usuarioJpaController
            UsuarioJpaController crudUser = new UsuarioJpaController(conexion);
            try{
            crudUser.destroy(cedula);
            int total = crudUser.getUsuarioCount();
            String m = "Usuario ELIMINADO con Exito\nTOTAL: "+total;
            JOptionPane.showMessageDialog(this,m);
             botonLimpiarActionPerformed(null);
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(this, "Usuario con cedula:" + cedula + "No existe");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,"Error no fue posible eliminar el usuario");
        } 
            
            
    }//GEN-LAST:event_botonEliminarActionPerformed

    private void botonReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteActionPerformed
        // TODO add your handling code here:
        VentanaReporte v = new VentanaReporte(ventanaPpal,true);
        this.dispose();
        v.setLocationRelativeTo(ventanaPpal);
        v.setVisible(true);
    }//GEN-LAST:event_botonReporteActionPerformed

    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarActionPerformed
        
        campoCedula.setText("");
        campoClave.setText("");
        campoNombre.setText("");
        campoEmail.setText("");
    }//GEN-LAST:event_botonLimpiarActionPerformed

    private void botonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonEditarActionPerformed
        try {
            if(validarCampo(campoCedula)== false){
                JOptionPane.showMessageDialog(this,"La cedula es necesaria");
                return;
                
            }
            if(validarCampo(campoNombre)== false){
                JOptionPane.showMessageDialog(this,"El Nombre es necesaria");
                return;
                
            }
            if(validarCampo(campoEmail)== false){
                JOptionPane.showMessageDialog(this,"El Email es necesaria");
                return;
                
            }
            if(validarEmail(campoEmail.getText()) == false){
                JOptionPane.showMessageDialog(this,"Corrija el Email");
                return;
                
            }
            String cc = campoCedula.getText();
            if (u.getCedula ().equals(cc) == false){
                JOptionPane.showMessageDialog(this, "No puede cambiar la cedula");
                campoCedula.setText(u.getCedula());
                return;
            }
            int res = JOptionPane.showConfirmDialog(this, "¿Desea Editar este Usuario?","OJO - PILAS",JOptionPane.YES_NO_OPTION);
            if(res == JOptionPane.NO_OPTION){
                return;   
            }
            char[] pass = campoClave.getPassword();
            String clave = String.valueOf(pass);
            String nombre = campoNombre.getText();
            String email = campoEmail.getText();
            //setear el obj encontrado
            u.setNombre(nombre);
            u.setEmail(email);
            clave = (clave.isEmpty())? null : clave;
            u.setClave(clave);
            
            //Paso 3 conecte BD
            EntityManagerFactory conexion = Persistence.createEntityManagerFactory("conexion_bd");
            // paso 4 crear un obj de la clase usuarioJpaController
            UsuarioJpaController crudUser = new UsuarioJpaController(conexion);
            //paso EDITAR O MODIFICAR EL USUARIO EN LA BD
            //UPDATE USUARIO
            //SET nombre '',''...
            //where condicion
            crudUser.edit(u);
             JOptionPane.showMessageDialog(this,"Usuario editado con exito");
        } catch (NonexistentEntityException ex) {
            JOptionPane.showMessageDialog(this,"Usuario con cedula no existe");
            
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(this,"ERROR: No fue posible EDITAR el usuario ");
        }
    }//GEN-LAST:event_botonEditarActionPerformed
       
    
    
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
            java.util.logging.Logger.getLogger(VentanaCrudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCrudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCrudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCrudUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaCrudUsuario dialog = new VentanaCrudUsuario(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonEditar;
    private javax.swing.JButton botonEliminar;
    private javax.swing.JButton botonLimpiar;
    private javax.swing.JButton botonReporte;
    private javax.swing.JTextField campoCedula;
    private javax.swing.JPasswordField campoClave;
    private javax.swing.JTextField campoEmail;
    private javax.swing.JTextField campoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
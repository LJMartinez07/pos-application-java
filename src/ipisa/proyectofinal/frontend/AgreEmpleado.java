
package ipisa.proyectofinal.frontend;

import ipisa.proyectofinal.clases.Conexion;
import ipisa.proyectofinal.clases.Empleado;
import ipisa.proyectofinal.combo.Genero;
import ipisa.proyectofinal.models.Fempleado;
import ipisa.proyectofinal.utilidades.IObserver;
import ipisa.proyectofinal.utilidades.ISubject;
import ipisa.proyectofinal.utilidades.iVerificar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class AgreEmpleado extends javax.swing.JDialog  implements ISubject, iVerificar{

   Empleado nuevoEmpleado = new Empleado();
    public AgreEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initComboGenero();
        this.btnModificar.setVisible(false);
        this.txtIdEmple.setVisible(false);  this.lbEmpleado.setVisible(false);
       
    }
    
    
    public AgreEmpleado(){
        initComponents();
        initLlenarDatos();
        initComponentsOff();
        this.btnAgregar.setVisible(false);
    }
    

    private void initLlenarDatos(){
      
       this.txtSueldo.setText(""+nuevoEmpleado.getSueldo());
       this.txtPuesto.setText(nuevoEmpleado.getPuesto());
      
   
    }
    
    private void initComponentsOff(){
        this.cbxGenero.setVisible(false); this.lbGenero.setVisible(false);
        this.jDateChooser1.setVisible(false); this.lbFecha.setVisible(false);
        this.txtNombre.setVisible(false); this.lbNom.setVisible(false);
        this.txtApellido.setVisible(false); this.lbApe.setVisible(false);
        this.txtDireccion.setVisible(false); this.lbDire.setVisible(false);
        this.txtCedula.setVisible(false); this.lbCedula.setVisible(false);
        this.txtCelular.setVisible(false); this.lbCelular.setVisible(false);
        this.txtTelefono.setVisible(false); this.lbTel.setVisible(false);
        
        
        
    }
    
    
    private void initComboGenero() {

        DefaultComboBoxModel<String> dmodel = new DefaultComboBoxModel<>();

        for (Genero c : Genero.values()) {
            dmodel.addElement(c.name());
        }

        this.cbxGenero.setModel(dmodel);

    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbNom = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbApe = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lbEmpleado = new javax.swing.JLabel();
        txtIdEmple = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lbGenero = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        lbDire = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtPuesto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtSueldo = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        lbTel = new javax.swing.JLabel();
        lbCelular = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lbCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel2ComponentResized(evt);
            }
        });
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 1));

        jLabel1.setText("Registrar Empleados");
        jPanel2.add(jLabel1);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setLayout(new java.awt.GridBagLayout());

        lbNom.setText("Nombre ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 119, 0, 0);
        jPanel5.add(lbNom, gridBagConstraints);

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 4, 2, 0);
        jPanel5.add(txtNombre, gridBagConstraints);

        lbApe.setText("Apellido ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 18, 0, 0);
        jPanel5.add(lbApe, gridBagConstraints);

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 4, 2, 115);
        jPanel5.add(txtApellido, gridBagConstraints);

        lbFecha.setText("Fecha de Registro");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 72, 0, 0);
        jPanel5.add(lbFecha, gridBagConstraints);

        jDateChooser1.setDate(Calendar.getInstance().getTime());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 116;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 4, 0, 0);
        jPanel5.add(jDateChooser1, gridBagConstraints);

        lbEmpleado.setText("Num Empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 33, 0, 0);
        jPanel5.add(lbEmpleado, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 19;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 4, 0, 0);
        jPanel5.add(txtIdEmple, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbGenero.setText("Genero");

        lbDire.setText("Direccion");

        jLabel11.setText("Puesto");

        jLabel12.setText("Sueldo");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(94, 94, 94)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbGenero)
                            .addComponent(jLabel11))
                        .addGap(167, 167, 167)
                        .addComponent(lbDire))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbGenero)
                            .addComponent(lbDire))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel7.setLayout(new java.awt.GridBagLayout());

        lbTel.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 12, 0, 0);
        jPanel7.add(lbTel, gridBagConstraints);

        lbCelular.setText("Celular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        jPanel7.add(lbCelular, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 10, 26, 0);
        jPanel7.add(txtTelefono, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 4, 26, 0);
        jPanel7.add(txtCelular, gridBagConstraints);

        lbCedula.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        jPanel7.add(lbCedula, gridBagConstraints);

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 4, 26, 36);
        jPanel7.add(txtCedula, gridBagConstraints);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel4.add(btnAgregar);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel4.add(btnModificar);

        btnCancelar.setText("Cancelar ");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel4.add(btnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 699, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel2ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel2ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentResized

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        if (this.txtPuesto.getText().isEmpty()
                || this.txtSueldo.getText().isEmpty() || this.txtNombre.getText().isEmpty() || this.txtApellido.getText().isEmpty() || this.txtCedula.getText().isEmpty()) {
            
            JOptionPane.showMessageDialog(this, "Campos en Blanco", "Mensaje", JOptionPane.ERROR_MESSAGE);
            
        }else if(isNumeric(this.txtCedula.getText()) || isNumeric(this.txtCelular.getText()) || isNumeric(this.txtTelefono.getText()) || isNumeric(this.txtSueldo.getText())){
            JOptionPane.showMessageDialog(this, "Lo siento no puedes ingresar caracter en el campo de la cedula, telefono, celular y sueldo", "Mensaje", JOptionPane.ERROR_MESSAGE);
            
        }else{
            
        
        nuevoEmpleado.setNombre(this.txtNombre.getText());
        nuevoEmpleado.setApellido(this.txtApellido.getText());
        nuevoEmpleado.setGenero((this.cbxGenero.getSelectedItem().toString()));
        nuevoEmpleado.setDireccion(this.txtDireccion.getText());
        
        nuevoEmpleado.setTelefono(this.txtTelefono.getText());
        nuevoEmpleado.setCelular(this.txtCelular.getText());
        nuevoEmpleado.setCedula(this.txtCedula.getText());
        nuevoEmpleado.setSueldo(Double.parseDouble(this.txtSueldo.getText()));
       
        
        nuevoEmpleado.setPuesto(this.txtPuesto.getText());
        nuevoEmpleado.setFechaReg(this.jDateChooser1.getDate());

        Fempleado func = new Fempleado();
        ResultSet rs= Conexion.getRegistros("SELECT * FROM personas where Cedula = "+ Integer.parseInt(this.txtCedula.getText()));//Aqui hace un select donde buscar sea igual que cedula
        try {
             if (rs.next()) {
                 JOptionPane.showConfirmDialog(this, "Este empleado ya existe");
             }
             else{
        if (func.insertar(nuevoEmpleado)) {
            JOptionPane.showMessageDialog(this, "Empleado ingresado correctamente");
            notify(getClass(), nuevoEmpleado , "prueba");
            dispose();

        }else{
            JOptionPane.showConfirmDialog(this, "Empleado no se pudo ingresar", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
             }
        }   catch (SQLException ex) {
                Logger.getLogger(AgreEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
        }

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
        if(this.txtPuesto.getText().isEmpty() || this.txtSueldo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Campos en Blanco", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }else{
            nuevoEmpleado.setSueldo(Double.parseDouble(this.txtSueldo.getText()));
            nuevoEmpleado.setPuesto(this.txtPuesto.getText());
            nuevoEmpleado.setIdEmpleado(Integer.parseInt(this.txtIdEmple.getText()));
            
            Fempleado func = new Fempleado();
            
            if (func.actualizarC(nuevoEmpleado) !=0) {
                JOptionPane.showMessageDialog(this, "Empleado actualizado correctamente");
                notify(getClass(), nuevoEmpleado , "prueba");
                dispose();
            }else{
            JOptionPane.showMessageDialog(this, "Empleado no se pudo Actualizar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }   
        }
       
       
       
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxGenero;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbApe;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbDire;
    private javax.swing.JLabel lbEmpleado;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbNom;
    private javax.swing.JLabel lbTel;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdEmple;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPuesto;
    private javax.swing.JTextField txtSueldo;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables

    @Override
    public void addObserver(IObserver observador) {
        observers.add(observador);
    }

    @Override
    public void removeObserver(IObserver observador) {
         observers.remove(observador);
    }

    @Override
    public void notify(Class clase, Object argumento, String mensaje) {
    
         for (IObserver observer : observers) {
            observer.update(clase, argumento, mensaje);
        }
    }

    @Override
    public boolean isNumeric(String cadena) {
         try {
		Integer.parseInt(cadena);
		return false;
	} catch (NumberFormatException nfe){
		return true;
        }
    }
}

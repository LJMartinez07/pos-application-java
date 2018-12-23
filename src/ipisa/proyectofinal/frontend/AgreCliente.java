/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.frontend;

import ipisa.proyectofinal.clases.Cliente;
import ipisa.proyectofinal.clases.Conexion;
import ipisa.proyectofinal.combo.Genero;
import ipisa.proyectofinal.models.Fcliente;
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


public class AgreCliente extends javax.swing.JDialog implements ISubject, iVerificar {

    /**
     * Creates new form AgreCliente
     */
    public AgreCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        initComboGenero();
        this.btnRecargar.setVisible(false);
        this.lbClientes.setVisible(false); this.txtIdCliente.setVisible(false);
        
    }
    
    public AgreCliente(){
        initComponents();
        initComponentsOff();
        
    }
    
    private void initLlenarComponents(){
        Cliente cl = new Cliente();
        this.txtCreditos.setText(""+cl.getCreditos());
        this.txtIdCliente.setText(""+cl.getIdCliente());
    }
    
    private void initComponentsOff(){
        this.btnAgregar.setVisible(false);
         this.cbxGenero.setVisible(false); this.lbGenero.setVisible(false);
        this.jDateChooser1.setVisible(false); this.lbFecha.setVisible(false);
        this.txtNombre.setVisible(false); this.lbNombre.setVisible(false);
        this.txtApellido.setVisible(false); this.lbApellido.setVisible(false);
        this.txtDireccion.setVisible(false); this.lbDireccion.setVisible(false);
        this.txtCedula.setVisible(false); this.lbCedula.setVisible(false);
        this.txtCelular.setVisible(false); this.lbCelular.setVisible(false);
        this.txtTelefono.setVisible(false); this.lbTelefono.setVisible(false);
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

        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        lbFecha = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lbClientes = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        lbGenero = new javax.swing.JLabel();
        cbxGenero = new javax.swing.JComboBox<>();
        lbDireccion = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCreditos = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        lbTelefono = new javax.swing.JLabel();
        lbCelular = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        txtCelular = new javax.swing.JTextField();
        lbCedula = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                jPanel7ComponentResized(evt);
            }
        });
        jPanel7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 1));

        jLabel3.setText("Registrar Clientes");
        jPanel7.add(jLabel3);

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbNombre.setText("Nombre ");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        lbApellido.setText("Apellido ");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        lbFecha.setText("Fecha de Registro");

        jDateChooser1.setDate(Calendar.getInstance().getTime());

        lbClientes.setText("Num Clientes");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(lbNombre)
                        .addGap(4, 4, 4)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbApellido))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(lbFecha)
                        .addGap(4, 4, 4)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(lbClientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbFecha)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbClientes)
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNombre)
                            .addComponent(lbApellido)))))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbGenero.setText("Genero");

        lbDireccion.setText("Direccion");

        jLabel9.setText("Creditos");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lbGenero)
                .addGap(167, 167, 167)
                .addComponent(lbDireccion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(103, 103, 103))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbGenero)
                    .addComponent(lbDireccion)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCreditos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 86, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new java.awt.GridBagLayout());

        lbTelefono.setText("Telefono");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 12, 0, 0);
        jPanel11.add(lbTelefono, gridBagConstraints);

        lbCelular.setText("Celular");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        jPanel11.add(lbCelular, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 156;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 10, 26, 0);
        jPanel11.add(txtTelefono, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 114;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 4, 26, 0);
        jPanel11.add(txtCelular, gridBagConstraints);

        lbCedula.setText("Cedula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(16, 10, 0, 0);
        jPanel11.add(lbCedula, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 138;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 4, 26, 36);
        jPanel11.add(txtCedula, gridBagConstraints);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel12.add(btnAgregar);

        btnRecargar.setText("Recargar");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });
        jPanel12.add(btnRecargar);

        btnCancelar.setText("Cancelar ");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel12.add(btnCancelar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel7ComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel7ComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel7ComponentResized

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        
        
        if (this.txtNombre.getText().isEmpty() || this.txtApellido.getText().isEmpty() || this.txtCedula.getText().isEmpty()
                || this.txtCreditos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Campos en Blanco", "Mensaje", JOptionPane.ERROR_MESSAGE);
            
        }else if(isNumeric(this.txtCedula.getText()) || isNumeric(this.txtCelular.getText()) || isNumeric(this.txtTelefono.getText()) || isNumeric(this.txtCreditos.getText())){
            JOptionPane.showMessageDialog(this, "Lo siento no puedes ingresar caracter en el campo de la cedula, telefono, celular y creditos", "Mensaje", JOptionPane.ERROR_MESSAGE);
            
        }else{
            Cliente nuevoCliente = new Cliente();
            
            nuevoCliente.setNombre(this.txtNombre.getText());
            nuevoCliente.setApellido(this.txtApellido.getText());
            nuevoCliente.setGenero((this.cbxGenero.getSelectedItem().toString()));
            nuevoCliente.setDireccion(this.txtDireccion.getText());
    
            nuevoCliente.setTelefono(this.txtTelefono.getText());
            nuevoCliente.setCelular(this.txtCelular.getText());
            nuevoCliente.setCedula(this.txtCedula.getText());
            nuevoCliente.setCreditos(Integer.parseInt(this.txtCreditos.getText()));
            if(nuevoCliente.getCreditos() > 5000){
            JOptionPane.showMessageDialog(this, "Lo siento pero no puede ser mas de 5000 de creditos");
            }else{
            nuevoCliente.setFechaReg(this.jDateChooser1.getDate());
            Fcliente func = new Fcliente();
            ResultSet rs= Conexion.getRegistros("SELECT * FROM personas where Cedula = "+ Integer.parseInt(this.txtCedula.getText()));//Aqui hace un select donde buscar sea igual que cedula
                try {
                    if (rs.next()) {
                        JOptionPane.showConfirmDialog(this, "Este cliente ya existe");
                    }else{
                        if (func.insertar(nuevoCliente)) {
                            JOptionPane.showMessageDialog(this, "Cliente agregado correctamente");
                            notify(getClass(), nuevoCliente , "prueba");
                            dispose();
                            
                        }else{
                            JOptionPane.showMessageDialog(this, "No se pudo agregar el cliente" ,"Mensaje", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }       } catch (SQLException ex) {
                    Logger.getLogger(AgreCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
        }   
        }
        
        

    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
       
        Cliente nuevoCliente = new Cliente();
        nuevoCliente.setIdCliente(Integer.parseInt(this.txtIdCliente.getText()));
        nuevoCliente.setCreditos(Double.parseDouble(this.txtCreditos.getText()));
        Fcliente func = new Fcliente();
        
        if (func.actualizarC(nuevoCliente)!=0) {
            JOptionPane.showMessageDialog(this, "Cliente recargado");
            notify(getClass(), nuevoCliente , "prueba");
            dispose();
            
        }else{
            JOptionPane.showMessageDialog(this, "El cliente no se pudo recargar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            
        }
        
        
    }//GEN-LAST:event_btnRecargarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox<String> cbxGenero;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbCedula;
    private javax.swing.JLabel lbCelular;
    private javax.swing.JLabel lbClientes;
    private javax.swing.JLabel lbDireccion;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbGenero;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbTelefono;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCreditos;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNombre;
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

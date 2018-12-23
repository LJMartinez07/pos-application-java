
package ipisa.proyectofinal.frontend;



import ipisa.proyectofinal.clases.Empleado;
import ipisa.proyectofinal.models.Fempleado;
import ipisa.proyectofinal.tablemodels.TableModelsEmpleado;
import ipisa.proyectofinal.utilidades.IObserver;
import java.awt.Frame;
import javax.swing.JOptionPane;


public class RegEmpleado extends javax.swing.JInternalFrame implements IObserver{

   
    TableModelsEmpleado tme = new TableModelsEmpleado();
    public RegEmpleado() {
        initComponents();
        tme.initTable(tblEmpleado);
    }
    
    public void CargarTable(){
      
        if(this.txtBuscar.getText().isEmpty() && this.txtApellido.getText().isEmpty()){
            tme.initTable(tblEmpleado);
            
        }else
            tme.mostrarEmp(this.tblEmpleado, this.txtBuscar.getText(), this.txtApellido.getText());
        
    }

   
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Botones = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        BuscarReg = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        lbError = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Registro = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEmpleado = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Registro Empleados");
        setToolTipText("");

        Botones.setLayout(new java.awt.GridLayout(1, 0));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        Botones.add(btnAgregar);

        jButton1.setText("Reactivar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        Botones.add(jButton1);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        Botones.add(btnModificar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        Botones.add(btnEliminar);

        BuscarReg.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        BuscarReg.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Buscar empleado");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 83, 0, 1);
        BuscarReg.add(jLabel1, gridBagConstraints);

        txtBuscar.setToolTipText("Nombre o Cedula");
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 84;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 0, 0);
        BuscarReg.add(txtBuscar, gridBagConstraints);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 7, 4);
        BuscarReg.add(btnBuscar, gridBagConstraints);
        BuscarReg.add(lbError, new java.awt.GridBagConstraints());

        txtApellido.setToolTipText("Apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 10, 0, 0);
        BuscarReg.add(txtApellido, gridBagConstraints);

        jButton2.setText("Ver Novedades de empleados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        BuscarReg.add(jButton2, gridBagConstraints);

        jButton3.setText("Ver Novedades de empleados");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        BuscarReg.add(jButton3, gridBagConstraints);

        Registro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblEmpleado);

        javax.swing.GroupLayout RegistroLayout = new javax.swing.GroupLayout(Registro);
        Registro.setLayout(RegistroLayout);
        RegistroLayout.setHorizontalGroup(
            RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
        );
        RegistroLayout.setVerticalGroup(
            RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
            .addGroup(RegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Botones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(BuscarReg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Registro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BuscarReg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       AgreEmpleado add  = new AgreEmpleado(new Frame(), true);
         add.addObserver(this);
         add.setLocationRelativeTo(null);
         add.setVisible(true);
        
         
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
 
        CargarTable();
      
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
    Empleado em  = new Empleado();
    int ind = this.tblEmpleado.getSelectedRow();
    if (ind !=-1) {
        em.setIdEmpleado(Integer.parseInt( this.tblEmpleado.getValueAt(this.tblEmpleado.getSelectedRow(), 0).toString()));
        em.setTelefono(this.tblEmpleado.getValueAt(this.tblEmpleado.getSelectedRow(), 5).toString());
        em.setCelular(this.tblEmpleado.getValueAt(this.tblEmpleado.getSelectedRow(), 6).toString());
        em.setCedula(this.tblEmpleado.getValueAt(this.tblEmpleado.getSelectedRow(), 7).toString());
        em.setPuesto(this.tblEmpleado.getValueAt(this.tblEmpleado.getSelectedRow(), 8).toString());
        AgreEmpleado ap = new AgreEmpleado();
        ap.addObserver(this);
        ap.setLocationRelativeTo(null);
        ap.setVisible(true);
    }else{
        JOptionPane.showMessageDialog(this, "Por favor! Seleccione un empleado", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        int ind = this.tblEmpleado.getSelectedRow();
        if(ind != -1){
            int a =(Integer.parseInt( this.tblEmpleado.getValueAt(this.tblEmpleado.getSelectedRow(), 0).toString()));
          
            Fempleado fe = new Fempleado();
            
            if (fe.BorrarEmpl(a)!=0) {
                JOptionPane.showMessageDialog(this, "Empleado Correctamente eliminado");
                tme.initTable(tblEmpleado);
                
            }else{
                JOptionPane.showMessageDialog(this, "El empleado no se pudo eliminar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
            
        }else{
        JOptionPane.showMessageDialog(this, "Por favor! Seleccione un empleado", "Mensaje de error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        VerEmpleados add  = new VerEmpleados(new Frame(), true);
         add.setLocationRelativeTo(null);
         add.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ReaEmpleado add  = new ReaEmpleado();
         add.setLocationRelativeTo(null);
         add.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Botones;
    private javax.swing.JPanel BuscarReg;
    private javax.swing.JPanel Registro;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbError;
    private javax.swing.JTable tblEmpleado;
    private javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Class clase, Object argumento, String mensaje) {
      if("prueba".equals(mensaje)){
            
            tme.initTable(tblEmpleado);
            JOptionPane.showMessageDialog(this,"Registro Agregado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    
    }
}

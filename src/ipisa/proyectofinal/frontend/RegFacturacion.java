/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipisa.proyectofinal.frontend;

import ipisa.proyectofinal.clases.Conexion;
import ipisa.proyectofinal.clases.DetalleFac;
import ipisa.proyectofinal.models.Ffactura;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis Martinez
 */
public class RegFacturacion extends javax.swing.JInternalFrame {

    //intanciamos
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();

    //metodo para calcular el total
    public Double total(double subtotal, double descuento, double itbis) {
        if(descuento == 0){
        double total_pago = subtotal + itbis;
        return total_pago;
        }else{
        double total_pago = (subtotal*descuento) + itbis;
        return total_pago;
        }
    }

    //metodo para el descuento
    public Double descount(double d) {
        double fd = d / 100;
        return fd;
    }

    

    //metodo para sumar los importes
    public Double sumaImporte(JTable tab, int columna) {
        Double suma = 0.00;
        for (int i = 0; i < tab.getRowCount(); i++) {
            Double suma1 = Double.parseDouble(String.valueOf(tab.getValueAt(i, columna)));
            suma += suma1;
        }
        return suma;
    }

    //metodo para calcular el impuesto returnara valor double
    public Double Impuestos(Double subtotal) {
        Double itbis = subtotal * 0.18;
        return itbis;
    }

    //metodo para calcular todo
    public void calcular_total() {
        int mm = Integer.parseInt(txtDesc1.getText());
        String sub_total = String.valueOf(sumaImporte(tblFac, 4));
        Double st = Double.parseDouble(sub_total);
        this.txtSubtotal.setText(sub_total);
        this.txtImpuestos.setText(String.valueOf(Impuestos(st)));
        this.txtDesc.setText(String.valueOf(descount(mm)));
        double total1 = sumaImporte(tblFac, 4);
        double itbis = Double.valueOf(txtImpuestos.getText());
        double des = Double.valueOf(txtDesc.getText());
        this.txtTotal.setText(String.valueOf(total(total1, des, itbis)));
    }

    /**
     * Creates new form RegEmpleado
     */
    public RegFacturacion() {
        initComponents();
        //iniciamos la tabla
        tabla(0);
        //ponemos enbale off para que el campo no se pueda modificar
        this.txtCambio.enable(false);
        if(this.txtDesc1.getText().isEmpty()){
            this.txtDesc1.setText(""+0);
        }
    }
    
    //petodo con un condicon
    void combo(){
    if(jComboBox1.getSelectedItem()=="Pago"){ //si es pago dara una devuelta sino no la dara
    double e = Double.parseDouble(this.txtMonRe.getText());
    double t = Double.parseDouble(this.txtTotal.getText());
    double u =  e - t;
    this.txtCambio.setText(""+u);
    }
    }

    //metodo para buscar valor
    void tabla(int valor) {
        String sql = "SELECT * FROM productos WHERE IdProducto = " + valor;//sentencia sql
        DefaultTableModel p = (DefaultTableModel) tblFac.getModel();
        try {
            Statement t = cn.createStatement();
            ResultSet rs = t.executeQuery(sql);//ejecutamos la sentencia
            while (rs.next()) {
                double pe=Double.parseDouble(txtBuscar1.getText());
                double ca=Double.parseDouble(txtCantidad.getText());
                double im=pe*ca;
                
                Object[] row = {rs.getString("IdProducto"), rs.getString("NombrePro"), rs.getString("PrecioVenta"), txtCantidad.getText(), im};
                p.addRow(row);//agregamos la fila que seran los titulos
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //metodo para llenar
    void Llenar(int u) {
        String Query = "SELECT * FROM productos where IdProducto = " + u;//sentencia sql
        try {
            PreparedStatement pst = cn.prepareStatement(Query);
            ResultSet rs = pst.executeQuery(Query);//ejecutamos 
            if (rs.next()) {
                txtBuscar.setText(rs.getString("NombrePro"));
                txtBuscar1.setText(rs.getString("PrecioVenta"));
                txtBuscar2.setText(rs.getString("CantidadProdu"));
            } else {
                txtBuscar.setText("");
                txtBuscar1.setText("");
                txtBuscar2.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegFacturacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFac = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtImpuestos = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtDesc = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtSubtotal = new javax.swing.JTextField();
        jPanel16 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtDesc1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtCambio = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtCoPro = new javax.swing.JTextField();
        txtIdCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtBuscar2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIdEm = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtMonRe = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Facturacion");
        setToolTipText("");

        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel2.add(btnAgregar);

        btnModificar.setText("Modificar");
        jPanel2.add(btnModificar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel2.add(btnEliminar);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblFac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id del Producto", "Nombre del Producto", "Precio del Producto", "Cantidad del Producto", "Importe"
            }
        ));
        jScrollPane1.setViewportView(tblFac);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 207, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Total: ");
        jPanel9.add(jLabel6, new java.awt.GridBagConstraints());

        txtTotal.setEditable(false);
        txtTotal.setToolTipText("Nombre o Cedula");
        txtTotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 57;
        jPanel9.add(txtTotal, gridBagConstraints);

        jPanel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel7.setText("ITBIS: ");
        jPanel10.add(jLabel7, new java.awt.GridBagConstraints());

        txtImpuestos.setEditable(false);
        txtImpuestos.setToolTipText("Nombre o Cedula");
        txtImpuestos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtImpuestos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtImpuestosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 57;
        jPanel10.add(txtImpuestos, gridBagConstraints);

        jPanel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel12.setLayout(new java.awt.GridBagLayout());

        jLabel9.setText("Descuento: ");
        jPanel12.add(jLabel9, new java.awt.GridBagConstraints());

        txtDesc.setEditable(false);
        txtDesc.setToolTipText("Nombre o Cedula");
        txtDesc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 57;
        jPanel12.add(txtDesc, gridBagConstraints);

        jPanel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel10.setText("Subtotal: ");
        jPanel13.add(jLabel10, new java.awt.GridBagConstraints());

        txtSubtotal.setEditable(false);
        txtSubtotal.setToolTipText("Nombre o Cedula");
        txtSubtotal.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSubtotalActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 57;
        jPanel13.add(txtSubtotal, gridBagConstraints);

        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel16.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.setLayout(new java.awt.GridBagLayout());

        jLabel14.setText("Descuento: ");
        jPanel17.add(jLabel14, new java.awt.GridBagConstraints());

        txtDesc1.setToolTipText("Nombre o Cedula");
        txtDesc1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtDesc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDesc1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 57;
        jPanel17.add(txtDesc1, gridBagConstraints);

        jButton3.setText("Calcular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A Credito", "A Contado" }));

        jButton2.setText("Ver Clientes");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Ver Productos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("Cambio");
        jPanel1.add(jLabel8, new java.awt.GridBagConstraints());

        txtCambio.setBackground(new java.awt.Color(255, 255, 255));
        txtCambio.setForeground(new java.awt.Color(255, 0, 0));
        txtCambio.setCaretColor(new java.awt.Color(255, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 51;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 12, 0, 10);
        jPanel1.add(txtCambio, gridBagConstraints);

        jButton5.setText("Obtener Cambio");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.setLayout(new java.awt.GridBagLayout());

        jLabel3.setText("Codigo del Producto:  ");

        txtCoPro.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtCoProInputMethodTextChanged(evt);
            }
        });
        txtCoPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCoProActionPerformed(evt);
            }
        });
        txtCoPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCoProKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCoProKeyTyped(evt);
            }
        });

        txtIdCli.setToolTipText("Nombre o Cedula");
        txtIdCli.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtIdCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdCliActionPerformed(evt);
            }
        });

        jLabel4.setText("ID del Cliente:  ");

        jLabel1.setText("Nombre del Producto: ");

        txtBuscar.setEditable(false);
        txtBuscar.setToolTipText("Nombre o Cedula");
        txtBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Precio del Producto:  ");

        txtBuscar1.setEditable(false);
        txtBuscar1.setToolTipText("Nombre o Cedula");
        txtBuscar1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Cantidad disponible:  ");

        txtBuscar2.setEditable(false);
        txtBuscar2.setToolTipText("Nombre o Cedula");
        txtBuscar2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBuscar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscar2ActionPerformed(evt);
            }
        });

        jLabel5.setText("ID del Usuario:  ");

        txtIdEm.setToolTipText("Nombre o Cedula");
        txtIdEm.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtIdEm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmActionPerformed(evt);
            }
        });

        jLabel12.setText("Monto Recibido: ");

        txtMonRe.setToolTipText("Nombre o Cedula");
        txtMonRe.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtMonRe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMonReActionPerformed(evt);
            }
        });

        jLabel13.setText("Cantidad:  ");

        txtCantidad.setToolTipText("Nombre o Cedula");
        txtCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMonRe, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(207, 207, 207)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdEm, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(460, 460, 460)
                                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtCoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(6, 6, 6)
                                .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addGap(6, 6, 6)
                                .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)))))
                .addGap(0, 131, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(txtBuscar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(txtBuscar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtIdEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)))
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton2)
                        .addComponent(jLabel12)
                        .addComponent(txtMonRe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton3))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        if(this.txtCoPro.getText().isEmpty() || this.txtCantidad.getText().isEmpty() || this.txtIdCli.getText().isEmpty() || this.txtIdEm.getText().isEmpty() || this.txtMonRe.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Llene todos los campos porfavor");
        }else{
            //intaciamos clases
            DetalleFac n = new DetalleFac();
            Ffactura func = new Ffactura();
            double mm = Double.parseDouble(txtSubtotal.getText());
            double mn = Double.parseDouble(txtImpuestos.getText());
            double mi = Double.parseDouble(txtTotal.getText());
            double mii = Double.parseDouble(txtDesc.getText());
            int m = Integer.parseInt(txtCantidad.getText());
            int b = Integer.parseInt(txtIdCli.getText());
            double bb = Double.parseDouble(txtMonRe.getText());
            Date q = new Date();
            int v = Integer.parseInt(txtIdEm.getText());
            n.setFechaFac(q);
            n.setPagoRecivido(bb);
            n.setSubTotal(mm);
            n.setItbis(mn);
            n.setNomCliente(b);
            n.setNomUsuario(v);
            n.setTotal(mi);
            if(func.insertarFac(n)){
                JOptionPane.showMessageDialog(this, "Ingresado Correct");
            }else{
                JOptionPane.showMessageDialog(this, "No se pudo ingresar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
        if(jComboBox1.getSelectedItem()=="A Credito"){
        int ww = Integer.parseInt(this.txtIdCli.getText());
        ResultSet rs = Conexion.getRegistros("Select * from clientes where Creditos < "+ Double.parseDouble(this.txtMonRe.getText()) +" and IdCliente = "+ww);
            try {
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Insufieciente creditos");
                return;
            }
        }catch(SQLException e){
        }
           n.setEstado("Pendiente");
           n.setMontoDeuda(mi);
           func.insertarFac(n);
           String sql2 = "UPDATE Clientes Set Creditos = Creditos - ? where IdCliente = ?";
            try {
           
            PreparedStatement pst = cn.prepareStatement(sql2);
            pst.setDouble(1, bb);
            pst.setInt(2, b);
            pst.executeUpdate();
            }catch(SQLException e){
        }
            
        
        }
        if(jComboBox1.getSelectedItem()=="A Contado"){
            n.setEstado("Pago");
            n.setMontoDeuda(0);
            func.insertarFac(n);
            
        
        }
        for (int i = 0; i<tblFac.getRowCount(); i++){
            n.setCantidadProdu(m);
            double r = Double.parseDouble(String.valueOf(tblFac.getValueAt(i, 4)));
            int rr = Integer.parseInt(String.valueOf(tblFac.getValueAt(i, 0)));
            int tt = Integer.parseInt(String.valueOf(tblFac.getValueAt(i, 3)));
            n.setImporte(r);
            n.setIdProducto(rr);
            
            n.setDescuento(mii);
            if (func.InsertarDe(n)) {
            JOptionPane.showMessageDialog(this, "Ingresado correctamente");

            }else{
            JOptionPane.showMessageDialog(this, "No se pudo ingresar", "Mensaje", JOptionPane.ERROR_MESSAGE);
            }
            
            String sql = "UPDATE Productos Set CantidadProdu = CantidadProdu - ? where IdProducto = ?";
            try {
           
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setInt(1, tt);
            pst.setInt(2, rr);
            pst.executeUpdate();
        }catch(SQLException e){
        }
        }
            
        }
       
           
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar1ActionPerformed

    private void txtIdCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdCliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdCliActionPerformed

    private void txtCoProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCoProActionPerformed
        // TODO add your handling code here:
        int m = Integer.parseInt(this.txtCoPro.getText());
        Llenar(m);
    }//GEN-LAST:event_txtCoProActionPerformed

    private void txtIdEmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmActionPerformed

    private void txtMonReActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMonReActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMonReActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
         DefaultTableModel p = (DefaultTableModel) tblFac.getModel();
        int fila = this.tblFac.getSelectedRow();
       p.removeRow(fila);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txtCoProInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtCoProInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoProInputMethodTextChanged

    private void txtCoProKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoProKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoProKeyTyped

    private void txtCoProKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCoProKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCoProKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int m = Integer.parseInt(this.txtCoPro.getText());
        ResultSet rs = Conexion.getRegistros("Select * from productos where CantidadProdu = 0 and IdProducto = "+m);
            try {
            if(rs.next()){
                JOptionPane.showMessageDialog(this, "Lo siento este producto se acabo");
            }else{
            tabla(m);
            }
        }catch(SQLException e){
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(this.txtDesc1.getText().isEmpty()){
            this.txtDesc1.setText(""+0);
           }
        calcular_total();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        VerCliente add = new VerCliente(new Frame(), true);
        
         add.setLocationRelativeTo(null);
         add.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        VerProductos add = new VerProductos(new Frame(), true);
        
         add.setLocationRelativeTo(null);
         add.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        combo();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtBuscar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscar2ActionPerformed

    private void txtDesc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDesc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDesc1ActionPerformed

    private void txtSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSubtotalActionPerformed

    private void txtDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescActionPerformed

    private void txtImpuestosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtImpuestosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtImpuestosActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFac;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextField txtBuscar1;
    public javax.swing.JTextField txtBuscar2;
    private javax.swing.JTextField txtCambio;
    public javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCoPro;
    public javax.swing.JTextField txtDesc;
    public javax.swing.JTextField txtDesc1;
    public javax.swing.JTextField txtIdCli;
    public javax.swing.JTextField txtIdEm;
    public javax.swing.JTextField txtImpuestos;
    public javax.swing.JTextField txtMonRe;
    public javax.swing.JTextField txtSubtotal;
    public javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

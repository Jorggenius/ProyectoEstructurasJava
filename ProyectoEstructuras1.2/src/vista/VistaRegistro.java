/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlVistaRegistro;
import excepcion.IdExiste;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Cliente;

/**
 *
 * @author JORGE
 */
public class VistaRegistro extends javax.swing.JFrame {

    ControlVistaRegistro controlVR;

    /**
     * Creates new form VistaRegistro
     */
    public VistaRegistro() {
        initComponents();
        setLocationRelativeTo(this);
        controlVR = new ControlVistaRegistro();
        llenarTabla();
        listenerTabla();
        txtId.setText(String.valueOf(numeroId()));
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "regresar");
        getRootPane().getActionMap().put("regresar", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegresar.doClick(); // Simula un clic en el botón "Regresar"
            }
        });
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(javax.swing.KeyStroke.getKeyStroke("ENTER"), "ingresar");
        getRootPane().getActionMap().put("ingresar", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresar.doClick(); // Simula un clic en el botón "Regresar"
            }
        });
    }

    private void llenarTabla() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nombre",
            "Id", "Contraseña", "Edad", "Correo", "Telefono",
            "Direccion"}, controlVR.conseguirClientes().size());
        tablaClientes.setModel(model);
        TableModel modeloCliente = tablaClientes.getModel();
        for (int i = 0; i < controlVR.conseguirClientes().size(); i++) {
            Cliente cliente = (Cliente) controlVR.conseguirClientes().get(i);
            modeloCliente.setValueAt(cliente.getNombre(), i, 0);
            modeloCliente.setValueAt(cliente.getId(), i, 1);
            modeloCliente.setValueAt(cliente.getContraseña(), i, 2);
            modeloCliente.setValueAt(cliente.getEdad(), i, 3);
            modeloCliente.setValueAt(cliente.getCorreo(), i, 4);
            modeloCliente.setValueAt(cliente.getTelefono(), i, 5);
            modeloCliente.setValueAt(cliente.getDireccion(), i, 6);
        }
    }

    private void listenerTabla() {
        ListSelectionModel model = tablaClientes.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaClientes.getSelectedRow() != -1) {
                    txtId.setText(String.valueOf(tablaClientes.getValueAt(tablaClientes.getSelectedRow(), 1)));
                }
            }

        });
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtId.setText(String.valueOf(numeroId()));
        txtContraseña.setText("");
        txtEdad.setText("");
        txtCorreo.setText("");
        txtTelefono.setText("");
        txtDireccion.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Registro clientes");

        lblNombre.setText("Nombre:");

        lblId.setText("Id:");

        lblContraseña.setText("Contraseña:");

        lblEdad.setText("Edad:");

        lblCorreo.setText("Correo:");

        lblTelefono.setText("Telefono:");

        lblDireccion.setText("Dereccion:");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Id", "Contraseña", "Edad", "Correo", "Telefono", "Direccion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaClientes);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(btnIngresar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblId)
                            .addComponent(lblNombre)
                            .addComponent(lblContraseña)
                            .addComponent(lblEdad)
                            .addComponent(lblCorreo)
                            .addComponent(lblTelefono)
                            .addComponent(lblDireccion)
                            .addComponent(btnRegresar))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(lblTitulo)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 704, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblId)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblContraseña)
                            .addComponent(txtContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblEdad)
                            .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCorreo)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTelefono)
                            .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDireccion)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnEliminar))
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VistaLogin vistaL = new VistaLogin();
        vistaL.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        // Verificar si algún campo está vacío
        if (txtNombre.getText().isEmpty() || txtId.getText().isEmpty() || txtContraseña.getText().isEmpty()
                || txtEdad.getText().isEmpty() || txtCorreo.getText().isEmpty() || txtTelefono.getText().isEmpty()
                || txtDireccion.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Hay campos incompletos. Por favor, llene todos los campos.");
            return; // Salir del método si hay campos vacíos
        }
        try {
            // Intentar convertir los campos que deben ser números
            String nombre = txtNombre.getText();
            int id = Integer.parseInt(txtId.getText());
            String contraseña = txtContraseña.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String correo = txtCorreo.getText();
            String telefono = txtTelefono.getText();
            String direccion = txtDireccion.getText();

            // Crear el objeto Cliente y guardar
            Cliente cliente = new Cliente(nombre, id, contraseña, edad, correo, telefono, direccion);
            controlVR.guardarCliente(cliente);
            JOptionPane.showMessageDialog(null, "El usuario fue registrado exitosamente");

            // Llenar la tabla y limpiar los campos
            llenarTabla();
            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo de ID y Edad deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IdExiste e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int id = Integer.parseInt(txtId.getText());
            controlVR.eliminarElemento(id);
            JOptionPane.showMessageDialog(null, "El usuario se elimino exitosamente");
            llenarTabla();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public int numeroId() {
        return (int) (Math.random() * 899999999) + 1;
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaClientes;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlGestionBuses;
import excepcion.IdExiste;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.AdmiFlota;
import modelo.Bus;
import modelo.Caseta;

/**
 *
 * @author JORGE
 */
public class VistaGestionBuses extends javax.swing.JFrame {

    AdmiFlota admiFlota;
    Caseta caseta;
    ControlGestionBuses controlGB;

    /**
     * Creates new form VistaGestionBuses
     */
    public VistaGestionBuses(Caseta caseta, AdmiFlota admiFlota) {
        initComponents();
        setLocationRelativeTo(this);
        this.admiFlota = admiFlota;
        this.caseta = caseta;
        this.controlGB = new ControlGestionBuses(caseta);
        setTitle("Gestion de buses");
        lblPlazas.setText("Plazas: " + caseta.getPlazas());
        llenarTabla();
        listenerTabla();
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
        DefaultTableModel model = new DefaultTableModel(new String[]{"Placa",
            "Puestos", "Marca", "Color", "Ruedas"},
                controlGB.getCaseta().getEmpresa().getBuses().size());
        tablaBuses.setModel(model);
        TableModel modelBus = tablaBuses.getModel();
        for (int i = 0; i < controlGB.getCaseta().getEmpresa().getBuses().size(); i++) {
            Bus bus = controlGB.getCaseta().getEmpresa().getBuses().get(i);
            modelBus.setValueAt(bus.getPlaca(), i, 0);
            modelBus.setValueAt(bus.getPuesto(), i, 1);
            modelBus.setValueAt(bus.getMarca(), i, 2);
            modelBus.setValueAt(bus.getColor(), i, 3);
            modelBus.setValueAt(bus.getRuedas(), i, 4);
        }
    }

    private void listenerTabla() {
        ListSelectionModel model = tablaBuses.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaBuses.getSelectedRow() != -1) {
                    txtPlaca.setText((String) tablaBuses.getValueAt(
                            tablaBuses.getSelectedRow(), 0));
                }
            }
        });

    }

    private void limpiarCampos() {
        txtPlaca.setText("");
        txtPuestos.setText("");
        txtMarca.setText("");
        txtColor.setText("");
        txtRuedas.setText("");
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
        lblPlaca = new javax.swing.JLabel();
        lblPuestos = new javax.swing.JLabel();
        txtPlaca = new javax.swing.JTextField();
        txtPuestos = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaBuses = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();
        lblPlazas = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblColor = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        txtColor = new javax.swing.JTextField();
        lblRuedas = new javax.swing.JLabel();
        txtRuedas = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Registro de buses");

        lblPlaca.setText("Placa:");

        lblPuestos.setText("Puesto:");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tablaBuses.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Placa", "Puestos", "Marca", "Color", "Ruedas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaBuses);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblPlazas.setText("jLabel3");

        lblMarca.setText("Marca:");

        lblColor.setText("Color:");

        lblRuedas.setText("Ruedas:");

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPuestos)
                                    .addComponent(lblPlaca))
                                .addGap(74, 74, 74)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblColor)
                                    .addComponent(lblMarca)
                                    .addComponent(lblRuedas))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtRuedas, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(lblPlazas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(btnRegresar)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnIngresar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(lblTitulo)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPlaca))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtPuestos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblPuestos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblMarca))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblColor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtRuedas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblRuedas))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnIngresar)
                                    .addComponent(btnEliminar)
                                    .addComponent(btnBuscar)
                                    .addComponent(btnEditar))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPlazas)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(btnRegresar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VistaFlota vistaF = new VistaFlota(admiFlota);
        vistaF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtPlaca.getText().isEmpty() || txtColor.getText().isEmpty()
                    || txtMarca.getText().isEmpty() || txtPuestos.getText()
                    .isEmpty()
                    || txtRuedas.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Hay "
                        + "campos incompletos. Por favor, llene todos "
                        + "los campos.");
                return; // Salir del método si hay campos vacíos  
            }

            if (controlGB.validarPlazas()) {
                String placa = txtPlaca.getText();
                int puestos = Integer.parseInt(txtPuestos.getText());
                String marca = txtMarca.getText();
                String color = txtColor.getText();
                int ruedas = Integer.parseInt(txtRuedas.getText());
                if (!controlGB.validarPlaca(placa)) {
                    Bus bus = new Bus(placa, puestos, marca, color, ruedas);
                    controlGB.guardarBus(bus);
                    JOptionPane.showMessageDialog(null, "El "
                            + "bus se ha agregado");
                    llenarTabla();
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "El"
                            + " bus ya esta registrado en alguna empresa");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No hay "
                        + "mas plazas");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El "
                    + "campo de ID y Edad deben ser numéricos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IdExiste e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            String placa = txtPlaca.getText();
            controlGB.eliminarBus(placa);
            JOptionPane.showMessageDialog(null, "El bus ha "
                    + "sido eliminado");
            llenarTabla();
            limpiarCampos();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        String placa = txtPlaca.getText();
        Bus aux = controlGB.buscarBus(placa);
        if (aux != null) {
            txtColor.setText(aux.getColor());
            txtMarca.setText(aux.getMarca());
            txtPuestos.setText(String.valueOf(aux.getPuesto()));
            txtRuedas.setText(String.valueOf(aux.getPuesto()));
        } else {
            JOptionPane.showMessageDialog(null, "El bus no existe");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        try {
            String placa = txtPlaca.getText();
            int puestos = Integer.parseInt(txtPuestos.getText());
            String marca = txtMarca.getText();
            String color = txtColor.getText();
            int ruedas = Integer.parseInt(txtRuedas.getText());
            Bus bus = new Bus(placa, puestos, marca, color, ruedas);
            controlGB.editarElemento(bus);
            JOptionPane.showMessageDialog(null, "El bus ha sido editado");
            llenarTabla();
            limpiarCampos();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblColor;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblPlaca;
    private javax.swing.JLabel lblPlazas;
    private javax.swing.JLabel lblPuestos;
    private javax.swing.JLabel lblRuedas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaBuses;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtPlaca;
    private javax.swing.JTextField txtPuestos;
    private javax.swing.JTextField txtRuedas;
    // End of variables declaration//GEN-END:variables
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlVistaReservarTiquete;
import excepcion.IdExiste;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Notificacion;
import modelo.Reserva;
import modelo.Viaje;
import util.IList;
import util.Lista;

/**
 *
 * @author JORGE
 */
public class VistaReservarTiquete extends javax.swing.JFrame {

    ControlVistaReservarTiquete controlVRT;
    Cliente cliente;
    IList<Viaje> viajes;

    /**
     * Creates new form VistaReservarTiquete
     */
    public VistaReservarTiquete(Cliente cliente) {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Reservar Tiquetes " + cliente.getNombre());
        this.cliente = cliente;
        controlVRT = new ControlVistaReservarTiquete();
        this.viajes = new Lista<>();
        lblCliente.setText("Cliente: " + cliente.getNombre());
        lblId.setText("Id: " + cliente.getId());
        lblPuntos.setText("Puntos: " + cliente.getPuntos());
        lblNotificaciones.setText("Notificaciones: " + cliente.getNotificaciones().size());
        txtCliente.setText(cliente.getNombre());
        llenarTablaViajes();
        listenerTablaViajes();
        llenarTablaReservas();
        listenerTablaReservas();
        txtCliente.setText(cliente.getNombre());
        dateCompra.setDate(java.sql.Date.valueOf(LocalDate.now()));
        txtIdReserva.setText(String.valueOf(numeroId()));
        checkFecha.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkFecha.isSelected()) {
                    llenarTablaViajes();
                    checkDestino.setEnabled(false);
                } else {
                    llenarTablaViajes();
                    checkDestino.setEnabled(true);
                }
            }
        });
        checkDestino.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (checkDestino.isSelected()) {
                    llenarTablaViajes();
                    checkFecha.setEnabled(false);
                } else {
                    llenarTablaViajes();
                    checkFecha.setEnabled(true);
                }
            }
        });
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "regresar");
        getRootPane().getActionMap().put("regresar", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegresar.doClick(); // Simula un clic en el botón "Regresar"
            }
        });
    }

    private void llenarTablaReservas() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Viaje",
            "FechaReserva", "Cliente"},
                controlVRT.reservasCliente(cliente).size());
        tablaReservas.setModel(model);
        TableModel modelReserva = tablaReservas.getModel();
        for (int i = 0; i < controlVRT.reservasCliente(cliente).size(); i++) {
            Reserva reserva = controlVRT.reservasCliente(cliente).get(i);
            modelReserva.setValueAt(reserva.getId(), i, 0);
            modelReserva.setValueAt(reserva.getViaje(), i, 1);
            modelReserva.setValueAt(reserva.getFechaCompra(), i, 2);
            modelReserva.setValueAt(reserva.getCliente(), i, 3);
        }
    }

    public void listenerTablaReservas() {
        ListSelectionModel model = tablaReservas.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaReservas.getSelectedRow() != -1) {
                    txtIdReserva.setText(String.valueOf(tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 0)));
                }
            }
        });
    }

    private void llenarTablaViajes() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Fecha", "Destino"},
                controlVRT.obtenerViajes().size());
        tablaViajes.setModel(model);
        TableModel modelViaje = tablaViajes.getModel();
        for (int i = 0; i < controlVRT.obtenerViajes().size(); i++) {
            Viaje viaje = controlVRT.obtenerViajes().get(i);
            if (checkFecha.isSelected()) {
                modelViaje.setValueAt(viaje.getId(), i, 0);
                modelViaje.setValueAt(viaje.getFechaSalida(), i, 1);
            } else if (checkDestino.isSelected()) {
                modelViaje.setValueAt(viaje.getId(), i, 0);
                modelViaje.setValueAt(viaje.getDestino(), i, 2);
            } else {
                modelViaje.setValueAt(viaje.getId(), i, 0);
                modelViaje.setValueAt(viaje.getFechaSalida(), i, 1);
                modelViaje.setValueAt(viaje.getDestino(), i, 2);
            }
        }
    }

    private void listenerTablaViajes() {
        ListSelectionModel model = tablaViajes.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaViajes.getSelectedRow() != -1) {
                    txtViaje.setText(String.valueOf(tablaViajes.
                            getValueAt(tablaViajes.getSelectedRow(), 0)));
                }
            }
        });
    }

    public int numeroIdNotif() {
        return (int) (Math.random() * 899999999) + 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnCaselar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblCliente = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblNotificaciones = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaViajes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        checkDestino = new javax.swing.JCheckBox();
        checkFecha = new javax.swing.JCheckBox();
        lblViaje = new javax.swing.JLabel();
        txtViaje = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        lblFecha = new javax.swing.JLabel();
        dateCompra = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        txtIdReserva = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Viaje", "Fecha reserva", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaReservas);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Reservas");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnCaselar.setText("Cancelar Reserva");
        btnCaselar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCaselarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblCliente.setText("jLabel1");

        lblId.setText("jLabel2");

        lblPuntos.setText("jLabel3");

        lblNotificaciones.setText("jLabel1");

        tablaViajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Fecha", "Destino"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaViajes);

        jLabel1.setText("Reservas");

        jLabel2.setText("Viajes");

        checkDestino.setText("Por Destino");

        checkFecha.setText("Por Fecha");

        lblViaje.setText("Viaje:");

        lblCantidad.setText("Cantidad:");

        jLabel3.setText("Cliente:");

        lblFecha.setText("Fecha:");

        jLabel4.setText("Id:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(148, 148, 148)
                                        .addComponent(btnIngresar)
                                        .addGap(42, 42, 42)
                                        .addComponent(btnCaselar))
                                    .addComponent(btnRegresar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblViaje)
                                            .addComponent(lblCantidad)
                                            .addComponent(jLabel3))
                                        .addGap(26, 26, 26)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtViaje)
                                            .addComponent(txtCantidad)
                                            .addComponent(txtCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                                        .addGap(66, 66, 66)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFecha)
                                            .addComponent(jLabel4))
                                        .addGap(41, 41, 41)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(dateCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                            .addComponent(txtIdReserva))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(504, 504, 504)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(checkFecha)
                                .addGap(18, 18, 18)
                                .addComponent(checkDestino)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCliente)
                        .addGap(105, 105, 105)
                        .addComponent(lblId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(201, 201, 201)
                        .addComponent(lblPuntos)
                        .addGap(102, 102, 102)
                        .addComponent(lblNotificaciones)
                        .addGap(130, 130, 130))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulo)
                    .addComponent(lblCliente)
                    .addComponent(lblId)
                    .addComponent(lblPuntos)
                    .addComponent(lblNotificaciones))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(checkDestino)
                    .addComponent(checkFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblViaje)
                                    .addComponent(txtViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFecha))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCantidad)
                                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresar)
                            .addComponent(btnCaselar))
                        .addGap(27, 27, 27)
                        .addComponent(btnRegresar)
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VistaCliente vistaC = new VistaCliente(cliente);
        vistaC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        try {
            Viaje viaje = controlVRT.conseguirViaje(Integer.parseInt(txtViaje.getText()));
            int cantidad = Integer.parseInt(txtCantidad.getText());
            if (controlVRT.validarCantidad(viaje, cantidad)) {
                for (int i = 0; i < cantidad; i++) {
                    Cliente cliente = this.cliente;
                    Date fecha = dateCompra.getDate();
                    LocalDate fechaCompra = fecha.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int id = Integer.parseInt(txtIdReserva.getText());
                    Reserva reserva = new Reserva(viaje, cantidad, cliente, fechaCompra, id);
                    controlVRT.guardarReserva(reserva);
                    Empresa empresa = controlVRT.conseguirEmpresaViaje(viaje);
                    String mensaje = cliente.getNombre() + " usted ha reservado un tiquete\ncon id: " + reserva.getId() + "\nFecha de reserva: " + reserva.getFechaCompra()
                            + "\ny destino: " + viaje.getDestino() + "\nMuchas Gracias por su Reserva\nEspere su pronta validacion\npara poder hacer uso de su tiquet";
                    Notificacion notif = new Notificacion(numeroIdNotif(),
                             fechaCompra, mensaje, cliente,
                            empresa, "Reserva");
                    controlVRT.guardarNotifs(notif);
                    llenarTablaReservas();
                    txtIdReserva.setText(String.valueOf(numeroId()));
                }
                JOptionPane.showMessageDialog(null, "La reserva ha sido hecha");
            } else {
                JOptionPane.showMessageDialog(null, "No hay cupo pa tanta gente solo hay: "
                        + controlVRT.cuposDisponibles(viaje)
                        + "\nCupos disponibles");
            }

        } catch (IdExiste e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnCaselarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCaselarActionPerformed
        // TODO add your handling code here:
        try {
            int id = Integer.parseInt(txtIdReserva.getText());
            controlVRT.eliminarReserva(id);
            JOptionPane.showMessageDialog(null, "La reserva ha sido eliminada");
            llenarTablaReservas();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }
    }//GEN-LAST:event_btnCaselarActionPerformed

    public int numeroId() {
        return (int) (Math.random() * 899999999) + 1;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCaselar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JCheckBox checkDestino;
    private javax.swing.JCheckBox checkFecha;
    private com.toedter.calendar.JDateChooser dateCompra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNotificaciones;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblViaje;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTable tablaViajes;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtIdReserva;
    private javax.swing.JTextField txtViaje;
    // End of variables declaration//GEN-END:variables
}

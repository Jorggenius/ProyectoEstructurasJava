/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlVentaTiquetes;
import excepcion.IdExiste;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.AdmiFlota;
import modelo.Caseta;
import modelo.Cliente;
import modelo.Notificacion;
import modelo.Tiquete;
import modelo.Viaje;

/**
 *
 * @author JORGE
 */
public class VistaVentaTiquetes extends javax.swing.JFrame {

    ControlVentaTiquetes controlVT;
    Caseta caseta;
    AdmiFlota admiFlota;

    /**
     * Creates new form VistaVentaTiquetes
     */
    public VistaVentaTiquetes(Caseta caseta, AdmiFlota admiFlota) {
        initComponents();
        setLocationRelativeTo(this);
        this.setTitle("Venta Tiquetes");
        this.caseta = caseta;
        this.admiFlota = admiFlota;
        controlVT = new ControlVentaTiquetes(caseta);
        lblAdmiFlota.setText("AdminFlota: " + admiFlota.getNombre());
        lblId.setText("Id: " + admiFlota.getId());
        lblEmpresa.setText("Empresa: " + caseta.getEmpresa().getNombre());
        llenarTabla();
        listenerTabla();
        comboViajes();
        comboClientes();
        txtIdTiquete.setText(String.valueOf(numeroId()));
        cbViajes.setSelectedItem(null);
        cbCLientes.setSelectedItem(null);
        cbViajes.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (cbViajes.getSelectedItem() != null) {
                        Viaje viaje = (Viaje) cbViajes.getSelectedItem();
                        lblFechaViaje.setText("Fecha Viaje: " + viaje.getFechaSalida());
                        txtValorViaje.setText("$: " + viaje.getValorUnidad());
                    }
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

    private void llenarTabla() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Viaje", "FechaCompra", "Cliente"},
                controlVT.getCaseta().getEmpresa().getTiquetes().size());
        tablaTiquetes.setModel(model);
        TableModel modelTiquete = tablaTiquetes.getModel();
        for (int i = 0; i < controlVT.getCaseta().getEmpresa().getTiquetes().size(); i++) {
            Tiquete tiquete = controlVT.getCaseta().getEmpresa().getTiquetes().get(i);
            modelTiquete.setValueAt(tiquete.getId(), i, 0);
            modelTiquete.setValueAt(tiquete.getViaje(), i, 1);
            modelTiquete.setValueAt(tiquete.getFechaCompra(), i, 2);
            modelTiquete.setValueAt(tiquete.getCliente(), i, 3);
        }
    }

    private void listenerTabla() {
        ListSelectionModel model = tablaTiquetes.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaTiquetes.getSelectedRow() != -1) {
                    txtIdTiquete.setText(String.valueOf(tablaTiquetes.
                            getValueAt(tablaTiquetes.getSelectedRow(), 0)));
                }
            }

        });
    }

    /////solo los viajes que inicien despues de la fecha actual pueden ser visualizados
    private void comboViajes() {
        cbViajes.removeAllItems();
        for (int i = 0; i < controlVT.getCaseta().getEmpresa().getViajes().size(); i++) {
            if (controlVT.getCaseta().getEmpresa().getViajes().get(i).getFechaSalida().isAfter(LocalDate.now())) {
                cbViajes.addItem(controlVT.getCaseta().getEmpresa().getViajes().get(i));
            }
        }
    }

    private void comboClientes() {
        cbCLientes.removeAllItems();
        for (int i = 0; i < controlVT.obtenerClientes().size(); i++) {
            cbCLientes.addItem(controlVT.obtenerClientes().get(i));
        }
    }

    public void limpiarCampos() {
        cbViajes.setSelectedItem(null);
        txtCantidad.setText("");
        cbCLientes.setSelectedItem(null);
        dateFecha.setDate(null);
        txtIdTiquete.setText(String.valueOf(numeroId()));
        lblFechaViaje.setText("     ");
        txtValorViaje.setText("      ");

    }

    public int numeroId() {
        return (int) (Math.random() * 899999999) + 1;
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

        lblTitulo = new javax.swing.JLabel();
        lblAdmiFlota = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTiquetes = new javax.swing.JTable();
        lblViaje = new javax.swing.JLabel();
        cbViajes = new javax.swing.JComboBox();
        lblCantidad = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblCliente = new javax.swing.JLabel();
        cbCLientes = new javax.swing.JComboBox();
        lblFecha = new javax.swing.JLabel();
        dateFecha = new com.toedter.calendar.JDateChooser();
        lblIdTiquete = new javax.swing.JLabel();
        txtIdTiquete = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        btnRedimir = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblFechaViaje = new javax.swing.JLabel();
        lblValorViajes = new javax.swing.JLabel();
        txtValorViaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Venta de tiquetes");

        lblAdmiFlota.setText("jLabel1");

        lblId.setText("jLabel1");

        lblEmpresa.setText("jLabel1");

        tablaTiquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Viaje", "Fecha compra", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTiquetes);

        lblViaje.setText("Viaje:");

        lblCantidad.setText("Cantidad:");

        lblCliente.setText("Cliente:");

        lblFecha.setText("Fecha de la compra:");

        lblIdTiquete.setText("Id tiquete:");

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

        btnRedimir.setText("Redimir");
        btnRedimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedimirActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblFechaViaje.setText("                ");

        lblValorViajes.setText("Valor viaje:");

        txtValorViaje.setText("                                  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAdmiFlota)
                        .addGap(92, 92, 92)
                        .addComponent(lblId)
                        .addGap(79, 79, 79)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(lblEmpresa)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(lblViaje)
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblFechaViaje)
                                    .addComponent(cbViajes, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 26, Short.MAX_VALUE)
                                        .addComponent(btnIngresar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnRedimir)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnEliminar)
                                        .addGap(23, 23, 23))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnRegresar)
                                .addGap(18, 18, 18)))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha)
                            .addComponent(lblIdTiquete)
                            .addComponent(lblValorViajes))
                        .addGap(42, 42, 42))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbCLientes, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblCantidad)
                                .addGap(115, 115, 115)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dateFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtIdTiquete, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(txtValorViaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(69, 69, 69))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblAdmiFlota)
                        .addComponent(lblId))
                    .addComponent(lblEmpresa)
                    .addComponent(lblTitulo))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFecha)
                            .addComponent(dateFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegresar)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblViaje)
                            .addComponent(cbViajes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaViaje)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCantidad)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIdTiquete)
                            .addComponent(txtIdTiquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCliente)
                            .addComponent(cbCLientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblValorViajes)
                            .addComponent(txtValorViaje))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresar)
                            .addComponent(btnRedimir)
                            .addComponent(btnEliminar))
                        .addGap(56, 56, 56))))
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
            if (cbViajes.getSelectedItem() == null || cbViajes
                    .getSelectedItem() == null
                    || cbCLientes.getSelectedItem() == null || txtCantidad
                    .getText().isEmpty()
                    || txtIdTiquete.getText().isEmpty() || txtValorViaje
                    .getText().isEmpty()
                    || dateFecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Hay campos "
                        + "incompletos. Por favor, llene todos los campos.");
                return; // Salir del método si hay campos vacíos
            }

            Viaje viaje = (Viaje) cbViajes.getSelectedItem();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            Cliente cliente = (Cliente) cbCLientes.getSelectedItem();
            Date fecha2 = dateFecha.getDate();
            LocalDate fechaCompra = fecha2.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (controlVT.validarCantidad(viaje, cantidad)) {
                if (controlVT.validarFecha(viaje, fechaCompra)) {
                    for (int i = 0; i < cantidad; i++) {
                        int idTiquete = Integer.parseInt(txtIdTiquete.getText());
                        Tiquete tiquete = new Tiquete(viaje, cantidad,
                                cliente, fechaCompra, idTiquete);
                        controlVT.guardarTiquete(tiquete);
                        String mensaje = cliente.getNombre()
                                + " usted ha comprado un tiquete\ncon id: "
                                + tiquete.getId() + "\nFecha de compra: "
                                + tiquete.getFechaCompra()
                                + "\ny destino: " + viaje.getDestino()
                                + "\nMuchas Gracias por su compra 🤗";
                        Notificacion notif = new Notificacion(numeroIdNotif(),
                                fechaCompra, mensaje, cliente,
                                caseta.getEmpresa(), "Compra");
                        controlVT.guardarNotifs(notif);
                        llenarTabla();
                        txtIdTiquete.setText(String.valueOf(numeroId()));
                    }
                    int puntos = (int) (((cantidad * viaje.getValorUnidad()) / 10000) * 3);
                    controlVT.asignarPuntos(puntos, cliente);
                    JOptionPane.showMessageDialog(null,
                            "EL tiquete se a guardado "
                            + "\ntotal: " + cantidad * viaje.getValorUnidad()
                            + "\nPuntos acumulados: " + puntos);
                    limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null,
                            "La fecha esta pasada de la del viaje");
                }
            } else {
                JOptionPane.showMessageDialog(null,
                         "No hay cupo pa tanta gente solo hay: "
                        + controlVT.cuposDisponibles(viaje)
                        + "\nPero puede reservar");
                int aux = JOptionPane.showOptionDialog(null,
                        "Desea quedar en cola",
                        "Confirmacion",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null,
                        new Object[]{"Sí", "No"}, "si");
                //////////////////////Aqui se esta desarrollando el tema de las colas////////////////////////////////
                //////////////////////Aqui se esta desarrollando el tema de las colas///////////////////////////////
                if (aux == 0) {  ///Aqui se esta desarrollando el tema de las colas///////////////////////////////
                    for (int i = 0; i < cantidad; i++) {
                        int idTiquete = Integer.parseInt(txtIdTiquete.getText());
                        Tiquete tiquete = new Tiquete(viaje, cantidad, cliente,
                                 fechaCompra, idTiquete);
                        String mensaje = cliente.getNombre()
                                + " usted ha ingresado a la cola de espera\ncon id: "
                                + tiquete.getId() + "\nFecha de ingreso: "
                                + tiquete.getFechaCompra()
                                + "\ny destino: " + viaje.getDestino()
                                + "\nMuchas Gracias por su compra 🤗";
                        Notificacion notif = new Notificacion(numeroIdNotif(),
                                fechaCompra, mensaje, cliente,
                                caseta.getEmpresa(), "Cola");
                        viaje.getColaTiquetes().enQueve(tiquete);
                        controlVT.guardarNotifs(notif);
 //////////////////////////// Aqui estoy trabajando con las colas///////////////////////////////////////////
                        controlVT.interaccionCola(tiquete, controlVT.cuposDisponibles(viaje));
                        
                        
                        txtIdTiquete.setText(String.valueOf(numeroId()));
                    }
                    JOptionPane.showMessageDialog(null,
                            "La solicitud esta en cola");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Usted ha decidido no estar en la cola");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El campo de ID y Edad deben ser numéricos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IdExiste e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnRedimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedimirActionPerformed
        // TODO add your handling code here:
        try {
           if (cbViajes.getSelectedItem() == null || cbViajes
                    .getSelectedItem() == null
                    || cbCLientes.getSelectedItem() == null || txtCantidad
                    .getText().isEmpty()
                    || txtIdTiquete.getText().isEmpty() || txtValorViaje
                    .getText().isEmpty()
                    || dateFecha.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Hay campos "
                        + "incompletos. Por favor, llene todos los campos.");
                return; // Salir del método si hay campos vacíos
            }
            Viaje viaje = (Viaje) cbViajes.getSelectedItem();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            Cliente cliente = (Cliente) cbCLientes.getSelectedItem();
            Date fecha2 = dateFecha.getDate();
            LocalDate fechaCompra = fecha2.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            if (viaje.getValorUnidad() <= 30000 && cantidad
                    * 90 <= cliente.getPuntos()) {
                if (controlVT.validarCantidad(viaje, cantidad)) {
                    if (controlVT.validarFecha(viaje, fechaCompra)) {
                        for (int i = 0; i < cantidad; i++) {
                            int idTiquete = Integer.parseInt(
                                    txtIdTiquete.getText());
                            Tiquete tiquete = new Tiquete(viaje, cantidad,
                                    cliente, fechaCompra, idTiquete);
                            controlVT.guardarTiquete(tiquete);
                            controlVT.guardarRedencion(tiquete);
                            String mensaje = cliente.getNombre()
                                    + " usted ha Redimido un tiquete\ncon id: "
                                    + tiquete.getId() + "\nFecha de compra: "
                                    + tiquete.getFechaCompra()
                                    + "\ny destino: " + viaje.getDestino()
                                    + "\nMuchas Gracias por preferirnos 🤗";
                            Notificacion notif = new Notificacion(numeroIdNotif(),
                                    fechaCompra, mensaje, cliente,
                                    caseta.getEmpresa(), "Redencion");
                            controlVT.guardarNotifs(notif);
                            llenarTabla();
                            txtIdTiquete.setText(String.valueOf(numeroId()));
                        }
                        controlVT.descontarPuntos(cliente, cantidad);
                        JOptionPane.showMessageDialog(null,
                                "EL tiquete se a guardado "
                                + "\ntotal: " + cantidad * viaje.getValorUnidad()
                                + "\nPuntos acumulados: ");
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "La fecha esta pasada de la del viaje");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No "
                            + "hay cupo pa tanta gente solo hay: "
                            + controlVT.cuposDisponibles(viaje)
                            + "\nPero puede reservar");
                }
            } else {
                JOptionPane.showMessageDialog(null, """
                                                    El tiquete(s) no puede ser redimido
                                                     """);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "El campo de "
                    + "ID y Edad deben ser numéricos.", "Error",
                     JOptionPane.ERROR_MESSAGE);
        } catch (IdExiste e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnRedimirActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int idTiquete = Integer.parseInt(txtIdTiquete.getText());
            controlVT.eliminarPuntos(idTiquete);
            controlVT.eliminarTiquete(idTiquete);
            JOptionPane.showMessageDialog(null,
                    "El tiquete se ha eliminado");
            llenarTabla();
            limpiarCampos();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRedimir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox cbCLientes;
    private javax.swing.JComboBox cbViajes;
    private com.toedter.calendar.JDateChooser dateFecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdmiFlota;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblFechaViaje;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdTiquete;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblValorViajes;
    private javax.swing.JLabel lblViaje;
    private javax.swing.JTable tablaTiquetes;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtIdTiquete;
    private javax.swing.JLabel txtValorViaje;
    // End of variables declaration//GEN-END:variables
}

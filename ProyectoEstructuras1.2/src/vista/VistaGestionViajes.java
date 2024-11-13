/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlGestionViajes;
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
import modelo.AdmiFlota;
import modelo.Bus;
import modelo.Caseta;
import modelo.Viaje;

/**
 *
 * @author JORGE
 */
public class VistaGestionViajes extends javax.swing.JFrame {

    Caseta caseta;
    AdmiFlota admiFlota;
    ControlGestionViajes controlGV;

    /**
     * Creates new form VistaGestionViajes
     */
    public VistaGestionViajes(Caseta caseta, AdmiFlota admiFlota) {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Gestion de viajes");
        this.caseta = caseta;
        this.admiFlota = admiFlota;
        this.controlGV = new ControlGestionViajes(caseta);
        txtOrigen.setEditable(false);
        llenarTabla();
        comboBox();
        listenerTabla();
        lblAdminFlota.setText("AdminFlota: " + admiFlota.getNombre());
        lblId.setText("Id: " + admiFlota.getId());
        lblCaseta.setText("Caseta: " + caseta.getEmpresa().getNombre());
        lblPlazas.setText("Plazas: " + caseta.getPlazas());
        dateCreacion.setEnabled(false);
        cbBuses.setSelectedItem(null);
        txtIdViaje.setText(String.valueOf(numeroIdViajes()));
        getRootPane().getInputMap(javax.swing.JComponent
                .WHEN_IN_FOCUSED_WINDOW)
                .put(javax.swing.KeyStroke.getKeyStroke("ESCAPE")
                        , "regresar");
        getRootPane().getActionMap().put("regresar"
                , new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegresar.doClick(); // Simula un clic en el botón "Regresar"
            }
        });
        getRootPane().getInputMap(javax.swing.JComponent
                .WHEN_IN_FOCUSED_WINDOW)
                .put(javax.swing.KeyStroke.getKeyStroke("ENTER")
                        , "ingresar");
        getRootPane().getActionMap().put("ingresar"
                , new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnIngresar.doClick(); // Simula un clic en el botón "Regresar"
            }
        });
    }

    private void llenarTabla() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Origen",
            "Destino", "FechaCreacion", "FechaSalida", "HoraSalida"
                , "FechaLlegada", "HoraLlegada",
            "Bus", "ValorUnidad", "id"}, controlGV.getCaseta()
                    .getEmpresa().getViajes()
                .size());
        tablaViajes.setModel(model);
        TableModel modelViaje = tablaViajes.getModel();
        for (int i = 0; i < controlGV.getCaseta().getEmpresa().getViajes()
                .size(); i++) {
            Viaje viaje = controlGV.getCaseta().getEmpresa().getViajes()
                    .get(i);
            modelViaje.setValueAt(viaje.getOrigen(), i
                    , 0);
            modelViaje.setValueAt(viaje.getDestino(), i
                    , 1);
            modelViaje.setValueAt(viaje.getFechaCreacion(), i
                    , 2);
            modelViaje.setValueAt(viaje.getFechaSalida(), i
                    , 3);
            modelViaje.setValueAt(viaje.getHoraSalida(), i
                    , 4);
            modelViaje.setValueAt(viaje.getFechaLLegada(), i
                    , 5);
            modelViaje.setValueAt(viaje.getHoraLlegada(), i
                    , 6);
            modelViaje.setValueAt(viaje.getBus(), i, 7);
            modelViaje.setValueAt(viaje.getValorUnidad(), i
                    , 8);
            modelViaje.setValueAt(viaje.getId(), i, 9);
        }
    }

    private void listenerTabla() {
        ListSelectionModel model = tablaViajes.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaViajes.getSelectedRow() != -1) {
                    txtIdViaje.setText(String.valueOf(tablaViajes
                            .getValueAt(tablaViajes.getSelectedRow()
                                    , 9)));
                }
            }

        });
    }

    private void comboBox() {
        cbBuses.removeAllItems();
        for (int i = 0; i < caseta.getEmpresa().getBuses().size(); i++) {
            cbBuses.addItem(caseta.getEmpresa().getBuses().get(i));
        }
    }

    private void limpiarCampos() {
        txtDestino.setText("");
        dateCreacion.setDate(null);
        txtHoraSalida.setText("");
        dateLLegada.setDate(null);
        txtHoraLLegada.setText("");
        cbBuses.setSelectedItem(null);
        txtValorUnidad.setText("");
        txtIdViaje.setText(String.valueOf(numeroIdViajes()));
        dateSalida.setDate(null);

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
        tablaViajes = new javax.swing.JTable();
        lblAdminFlota = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblCaseta = new javax.swing.JLabel();
        lblPlazas = new javax.swing.JLabel();
        lblOrigen = new javax.swing.JLabel();
        txtOrigen = new javax.swing.JTextField();
        Destino = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        dateCreacion = new com.toedter.calendar.JDateChooser();
        lblHoraSalida = new javax.swing.JLabel();
        txtHoraSalida = new javax.swing.JTextField();
        lblFechaLLegada = new javax.swing.JLabel();
        dateLLegada = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        txtHoraLLegada = new javax.swing.JTextField();
        lblBus = new javax.swing.JLabel();
        cbBuses = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtValorUnidad = new javax.swing.JTextField();
        btnRegresar = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblIdViaje = new javax.swing.JLabel();
        txtIdViaje = new javax.swing.JTextField();
        lblFechaSalida = new javax.swing.JLabel();
        dateSalida = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaViajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Origen", "Destino", "FechaCreacion", "FechaSalida", "HoraSalida", "FechaLLegada", "HoraLLegada", "Bus", "ValorUnidad", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaViajes);

        lblAdminFlota.setText("jLabel1");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitulo.setText("Gestion de viajes");

        lblId.setText("jLabel2");

        lblCaseta.setText("jLabel3");

        lblPlazas.setText("jLabel4");

        lblOrigen.setText("Origen:");

        txtOrigen.setText("Armenia");

        Destino.setText("Destino:");

        jLabel1.setText("Fecha Creacion:");

        lblHoraSalida.setText("HoraSalida:");

        lblFechaLLegada.setText("Fecha llegada:");

        jLabel2.setText("Hora llegada:");

        lblBus.setText("Bus:");

        jLabel3.setText("Valor unidad:");

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

        lblIdViaje.setText("Id viaje");

        lblFechaSalida.setText("Fecha salida:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAdminFlota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblId)
                .addGap(206, 206, 206)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(104, 104, 104)
                .addComponent(lblCaseta)
                .addGap(168, 168, 168)
                .addComponent(lblPlazas)
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Destino)
                                    .addComponent(lblOrigen))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtDestino, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                    .addComponent(txtOrigen)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(dateCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblHoraSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFechaLLegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblFechaSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(btnIngresar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoraSalida)
                            .addComponent(dateLLegada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtHoraLLegada)
                            .addComponent(dateSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 159, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBus)
                            .addComponent(jLabel3)
                            .addComponent(lblIdViaje))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbBuses, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtValorUnidad)
                            .addComponent(txtIdViaje, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(79, 79, 79))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdminFlota)
                            .addComponent(lblId)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCaseta)
                            .addComponent(lblPlazas)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTitulo)))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrigen)
                            .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Destino)
                                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(dateCreacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtIdViaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblIdViaje)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBus)
                            .addComponent(cbBuses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtValorUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(lblHoraSalida))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(dateSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblFechaSalida))
                            .addGap(12, 12, 12)
                            .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lblFechaLLegada)
                                .addComponent(dateLLegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(15, 15, 15)
                                    .addComponent(txtHoraLLegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(jLabel2))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIngresar)
                    .addComponent(btnEliminar))
                .addGap(16, 16, 16)
                .addComponent(btnRegresar)
                .addContainerGap(26, Short.MAX_VALUE))
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
            if (dateSalida.getDate() == null || dateLLegada.getDate() == null
                    || txtDestino.getText().isEmpty() || txtHoraLLegada
                    .getText().isEmpty()
                    || txtHoraSalida.getText().isEmpty()
                    || txtIdViaje.getText().isEmpty()
                    || txtOrigen.getText().isEmpty()
                    || txtValorUnidad.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Hay campos incompletos. Por favor, llene "
                        + "todos los campos.");
                return; // Salir del método si hay campos vacíos
            }
            String origen = txtOrigen.getText();
            String destino = txtDestino.getText();
            LocalDate fechaCreacion = LocalDate.now();
            Date fecha3 = dateSalida.getDate();
            LocalDate fechaSalida = fecha3.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime horaSalida = LocalTime.parse(txtHoraSalida.getText());
            Date fecha2 = dateLLegada.getDate();
            LocalDate fechaLlegada = fecha2.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDate();
            LocalTime horaLlegada = LocalTime.parse(txtHoraLLegada
                    .getText());
            Bus bus = (Bus) cbBuses.getSelectedItem();
            int valorUnidad = Integer.parseInt(txtValorUnidad.getText());
            int idViaje = Integer.parseInt(txtIdViaje.getText());
            if (fechaCreacion.isBefore(fechaSalida)) {
                if (fechaSalida.isBefore(fechaLlegada) ||
                        fechaSalida.equals(fechaLlegada)&&
                        horaLlegada.isAfter(horaSalida)) {
                    if (controlGV.disponibilidadBus(fechaSalida
                            ,fechaLlegada
                            ,horaSalida, bus)) {
                        Viaje viaje = new Viaje(origen, destino, fechaCreacion,
                                fechaSalida, horaSalida,
                                fechaLlegada, horaLlegada, bus
                                , valorUnidad,
                                idViaje);
                        controlGV.guardarViaje(viaje);
                        JOptionPane.showMessageDialog(null,
                                "El viaje se registro exitosamente");
                        llenarTabla();
                        limpiarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "El bus No esta disponible "
                                        + "para la fecha");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La Fecha "
                            + "de llegada debe de ser despues "
                            + "de la Fecha de salida"
                            + "\nY la hora de llegada debe ser despues la salida");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La"
                        + " fecha de salida debe de ser superior"
                        + " a la fecha actual");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "El campo de ID y Edad deben ser numéricos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IdExiste e) {
            JOptionPane.showMessageDialog(null, 
                    e.getMessage());
        }
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        try {
            int idViaje = Integer.parseInt(txtIdViaje.getText());
            controlGV.eliminarViaje(idViaje);
            JOptionPane.showMessageDialog(null, "El "
                    + "viaje se ha eliminado");
            llenarTabla();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(null,
                    e.getMessage());
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public int numeroIdViajes() {
        return (int) (Math.random() * 899999999) + 1;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Destino;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox cbBuses;
    private com.toedter.calendar.JDateChooser dateCreacion;
    private com.toedter.calendar.JDateChooser dateLLegada;
    private com.toedter.calendar.JDateChooser dateSalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAdminFlota;
    private javax.swing.JLabel lblBus;
    private javax.swing.JLabel lblCaseta;
    private javax.swing.JLabel lblFechaLLegada;
    private javax.swing.JLabel lblFechaSalida;
    private javax.swing.JLabel lblHoraSalida;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblIdViaje;
    private javax.swing.JLabel lblOrigen;
    private javax.swing.JLabel lblPlazas;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTable tablaViajes;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtHoraLLegada;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtIdViaje;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtValorUnidad;
    // End of variables declaration//GEN-END:variables
}

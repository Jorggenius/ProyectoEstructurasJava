/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlResumenInfoCliente;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.Cliente;
import modelo.Reserva;
import modelo.Tiquete;
import modelo.Viaje;

/**
 *
 * @author JORGE
 */
public class VistaResumenInfoCliente extends javax.swing.JFrame {

    Cliente cliente;
    ControlResumenInfoCliente controlRIC;

    /**
     * Creates new form VistaResumenInfoCliente
     */
    public VistaResumenInfoCliente(Cliente cliente) {
        initComponents();
        setLocationRelativeTo(this);
        this.cliente = cliente;
        controlRIC = new ControlResumenInfoCliente(cliente);
        lblNombre.setText("Nombre: " + cliente.getNombre());
        lblID.setText("Id: " + cliente.getId());
        lblContraseña.setText("Contraseña: " + cliente.getContraseña());
        lblPuntos.setText("Puntos: " + cliente.getPuntos());
        lblNotificasiones.setText("Notifs: " + cliente.getNotificaciones().size());
        lblEdad.setText("Edad: " + cliente.getEdad());
        lblCorreo.setText("Correo: " + cliente.getCorreo());
        lblTelefono.setText("Tel: " + cliente.getTelefono());
        lblDireccion.setText("Dir: " + cliente.getDireccion());
        llenarTablaTiquete();
        llenarTablaViajes();
        llenarTablaReservas();
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
            "Cantidad", "FechaReserva", "Cliente"},
                controlRIC.obtenerReservas(cliente).size());
        tablaReservas.setModel(model);
        TableModel modelReserva = tablaReservas.getModel();
        for (int i = 0; i < controlRIC.obtenerReservas(cliente).size(); i++) {
            Reserva reserva = controlRIC.obtenerReservas(cliente).get(i);
            modelReserva.setValueAt(reserva.getId(), i, 0);
            modelReserva.setValueAt(reserva.getViaje(), i, 1);
            modelReserva.setValueAt(reserva.getCantidad(), i, 2);
            modelReserva.setValueAt(reserva.getFechaCompra(), i, 3);
            modelReserva.setValueAt(reserva.getCliente(), i, 4);
        }
    }
    
    private void llenarTablaViajes() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Origen",
            "Destino", "FechaCreacion", "HoraSalida", "FechaLlegada", "HoraLlegada",
            "Bus", "ValorUnidad", "id"}, controlRIC.obtenerViajes().size());
        tablaViajes.setModel(model);
        TableModel modelViaje = tablaViajes.getModel();
        for (int i = 0; i < controlRIC.obtenerViajes().size(); i++) {
            Viaje viaje = controlRIC.obtenerViajes().get(i);
            modelViaje.setValueAt(viaje.getOrigen(), i, 0);
            modelViaje.setValueAt(viaje.getDestino(), i, 1);
            modelViaje.setValueAt(viaje.getFechaCreacion(), i, 2);
            modelViaje.setValueAt(viaje.getHoraSalida(), i, 3);
            modelViaje.setValueAt(viaje.getFechaLLegada(), i, 4);
            modelViaje.setValueAt(viaje.getHoraLlegada(), i, 5);
            modelViaje.setValueAt(viaje.getBus(), i, 6);
            modelViaje.setValueAt(viaje.getValorUnidad(), i, 7);
            modelViaje.setValueAt(viaje.getId(), i, 8);
        }
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
        tablaTiquetes = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaViajes = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        lblSubtitulo = new javax.swing.JLabel();
        lblSubtitulo1 = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        lblContraseña = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        lblNotificasiones = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        lblDireccion = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaTiquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Viaje", "Cantidad", "Fecha compra", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTiquetes);

        tablaViajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Origen", "Destino", "FechaCreacion", "HoraSalida", "FechaLLegada", "HoraLLegada", "Bus", "ValorUnidad", "Id"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablaViajes);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lblSubtitulo.setText("Viajes");

        lblSubtitulo1.setText("Tiquetes");

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNombre.setText("jLabel1");

        lblID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblID.setText("jLabel1");

        lblContraseña.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblContraseña.setText("jLabel1");

        lblPuntos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPuntos.setText("jLabel1");

        lblNotificasiones.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNotificasiones.setText("jLabel1");

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTitle.setText("Resumen info cliente");

        lblEdad.setText("jLabel1");

        lblCorreo.setText("jLabel1");

        lblTelefono.setText("jLabel1");

        lblDireccion.setText("jLabel1");

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Viaje", "Cantidad", "Fecha reserva", "Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaReservas);

        jLabel1.setText("Reservas");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSubtitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblSubtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addContainerGap(883, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(361, 361, 361)
                        .addComponent(lblTitle))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombre)
                            .addComponent(lblEdad))
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblID)
                            .addComponent(lblCorreo))
                        .addGap(140, 140, 140)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblContraseña)
                            .addComponent(lblTelefono))
                        .addGap(135, 135, 135)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPuntos)
                                .addGap(84, 84, 84)
                                .addComponent(lblNotificasiones))
                            .addComponent(lblDireccion))))
                .addContainerGap(239, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane3)
                .addGap(6, 6, 6))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblID)
                    .addComponent(lblContraseña)
                    .addComponent(lblPuntos)
                    .addComponent(lblNotificasiones))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(lblCorreo)
                    .addComponent(lblTelefono)
                    .addComponent(lblDireccion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulo1)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblSubtitulo)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VistaCliente vistaC = new VistaCliente(cliente);
        vistaC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void llenarTablaTiquete() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Viaje", "Cantida", "FechaCompra", "Cliente"},
                controlRIC.obtenerTiquetes(cliente).size());
        tablaTiquetes.setModel(model);
        TableModel modelTiquete = tablaTiquetes.getModel();
        for (int i = 0; i < controlRIC.obtenerTiquetes(cliente).size(); i++) {
            Tiquete tiquete = controlRIC.obtenerTiquetes(cliente).get(i);
            modelTiquete.setValueAt(tiquete.getId(), i, 0);
            modelTiquete.setValueAt(tiquete.getViaje(), i, 1);
            modelTiquete.setValueAt(tiquete.getCantidad(), i, 2);
            modelTiquete.setValueAt(tiquete.getFechaCompra(), i, 3);
            modelTiquete.setValueAt(tiquete.getCliente(), i, 4);
        }
    }
    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblContraseña;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblDireccion;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNotificasiones;
    private javax.swing.JLabel lblPuntos;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblSubtitulo1;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTable tablaTiquetes;
    private javax.swing.JTable tablaViajes;
    // End of variables declaration//GEN-END:variables
}

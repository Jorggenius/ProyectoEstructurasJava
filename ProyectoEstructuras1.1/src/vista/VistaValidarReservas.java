/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import control.ControlValidarReservas;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import modelo.AdmiFlota;
import modelo.Caseta;
import modelo.Reserva;
import modelo.Tiquete;

/**
 *
 * @author JORGE
 */
public class VistaValidarReservas extends javax.swing.JFrame {

    ControlValidarReservas controlVR;
    Caseta caseta;
    AdmiFlota admiFlota;

    /**
     * Creates new form VistaValidarReservas
     */
    public VistaValidarReservas(Caseta caseta, AdmiFlota admiFlota) {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Validacion de RESERVAS");
        controlVR = new ControlValidarReservas(caseta);
        this.caseta = caseta;
        this.admiFlota = admiFlota;
        lblAdmiFlota.setText("AdmiFlota: " + admiFlota.getNombre());
        lblId.setText("Id: " + admiFlota.getId());
        lblEmpresa.setText("Empresa: " + caseta.getEmpresa());
        llenarTablaReservas();
        listenerTablaReservas();
        llenarTablaTiquetes();
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "regresar");
        getRootPane().getActionMap().put("regresar", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegresar.doClick(); // Simula un clic en el botón "Regresar"
            }
        });
    }

    private void llenarTablaTiquetes() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Viaje",
            "FechaReserva", "Cliente"},
                controlVR.getCaseta().getEmpresa().getTiquetes().size());
        tablaTiquetes.setModel(model);
        TableModel modelTiquete = tablaTiquetes.getModel();
        for (int i = 0; i < controlVR.getCaseta().getEmpresa().getTiquetes().size(); i++) {
            Tiquete tiquete = controlVR.getCaseta().getEmpresa().getTiquetes().get(i);
            modelTiquete.setValueAt(tiquete.getId(), i, 0);
            modelTiquete.setValueAt(tiquete.getViaje(), i, 1);
            modelTiquete.setValueAt(tiquete.getFechaCompra(), i, 2);
            modelTiquete.setValueAt(tiquete.getCliente(), i, 3);
        }
    }


    private void llenarTablaReservas() {
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id", "Viaje",
             "FechaReserva", "Cliente"},
                controlVR.getCaseta().getEmpresa().getReservas().size());
        tablaReservas.setModel(model);
        TableModel modelReserva = tablaReservas.getModel();
        for (int i = 0; i < controlVR.getCaseta().getEmpresa().getReservas().size(); i++) {
            Reserva reserva = controlVR.getCaseta().getEmpresa().getReservas().get(i);
            modelReserva.setValueAt(reserva.getId(), i, 0);
            modelReserva.setValueAt(reserva.getViaje(), i, 1);
            modelReserva.setValueAt(reserva.getFechaCompra(), i, 2);
            modelReserva.setValueAt(reserva.getCliente(), i, 3);
        }
    }

    private void listenerTablaReservas() {
        ListSelectionModel model = tablaReservas.getSelectionModel();
        model.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (tablaReservas.getSelectedRow() != -1) {
                    int id = (int) tablaReservas.getValueAt(tablaReservas.getSelectedRow(), 0);
                    crearGuardarTiquete(id);
                    eliminarReserva(id);
                    llenarTablaReservas();
                    llenarTablaTiquetes();
                }
            }

        });
    }
    
    public void crearGuardarTiquete(int id){
        Reserva reserva = controlVR.obtenerReserva(id); 
        int idT = (int) (Math.random() * 899999999) + 1;
        Tiquete tiquete = new Tiquete(reserva.getViaje(), 
                reserva.getCantidad(), reserva.getCliente(),
                reserva.getFechaCompra(), idT);
        controlVR.guardarTiquete(tiquete);
        int puntos = (int) (((tiquete.getViaje().getValorUnidad()) / 10000) * 3);
        controlVR.asignarPuntos(puntos, tiquete.getCliente());
    }
    
    public void eliminarReserva(int id){
        controlVR.EliminarReserva(id);
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaTiquetes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblAdmiFlota = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblEmpresa = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

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

        jLabel1.setText("Reservas");

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
        jScrollPane2.setViewportView(tablaTiquetes);

        jLabel2.setText("Tiquetes");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Validar reservas");

        lblAdmiFlota.setText("jLabel4");

        lblId.setText("jLabel4");

        lblEmpresa.setText("jLabel4");

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 536, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(498, 498, 498)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAdmiFlota)
                        .addGap(159, 159, 159)
                        .addComponent(lblId)
                        .addGap(187, 187, 187)
                        .addComponent(jLabel3)
                        .addGap(201, 201, 201)
                        .addComponent(lblEmpresa))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnRegresar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblAdmiFlota)
                                    .addComponent(lblId))
                                .addGap(22, 22, 22)))
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblEmpresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnRegresar)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VistaFlota vistaF = new VistaFlota(admiFlota);
        vistaF.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAdmiFlota;
    private javax.swing.JLabel lblEmpresa;
    private javax.swing.JLabel lblId;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTable tablaTiquetes;
    // End of variables declaration//GEN-END:variables
}

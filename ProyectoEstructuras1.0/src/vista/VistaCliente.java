/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import java.awt.event.ActionEvent;
import modelo.Cliente;

/**
 *
 * @author JORGE
 */
public class VistaCliente extends javax.swing.JFrame {
    Cliente cliente;
    /**
     * Creates new form VistaCliente
     */
    public VistaCliente(Cliente cliente) {
        initComponents();
        setLocationRelativeTo(this);
        setTitle("Ventana Cliente; " + cliente.getNombre());
        this.cliente = cliente;
        lblNombre.setText("Cliente: " + cliente.getNombre());
        lblId.setText("Id: " + cliente.getId());
        lblPuntos.setText("Puntos: " + cliente.getPuntos());
        getRootPane().getInputMap(javax.swing.JComponent.WHEN_IN_FOCUSED_WINDOW)
                .put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "regresar");
        getRootPane().getActionMap().put("regresar", new javax.swing.AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnRegresar.doClick(); // Simula un clic en el botón "Regresar"
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblPuntos = new javax.swing.JLabel();
        btnResumonInfo = new javax.swing.JButton();
        btnRedencion = new javax.swing.JButton();
        btnPuntosAcumulados = new javax.swing.JButton();
        btnDevoluciones = new javax.swing.JButton();
        btnReservas = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnNotificasiones = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombre.setText("jLabel1");

        lblId.setText("jLabel1");

        lblPuntos.setText("jLabel1");

        btnResumonInfo.setText("Resumen de informacion");
        btnResumonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResumonInfoActionPerformed(evt);
            }
        });

        btnRedencion.setText("Historial de redencion");
        btnRedencion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRedencionActionPerformed(evt);
            }
        });

        btnPuntosAcumulados.setText("Puntos acumulados");
        btnPuntosAcumulados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPuntosAcumuladosActionPerformed(evt);
            }
        });

        btnDevoluciones.setText("Devoluciones");
        btnDevoluciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolucionesActionPerformed(evt);
            }
        });

        btnReservas.setText("Reservar tiquete");
        btnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnNotificasiones.setText("Notificaciones");
        btnNotificasiones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotificasionesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombre)
                        .addGap(67, 67, 67)
                        .addComponent(lblId)
                        .addGap(67, 67, 67)
                        .addComponent(lblPuntos))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRedencion, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnResumonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPuntosAcumulados, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDevoluciones, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNotificasiones, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnRegresar)))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(lblId)
                    .addComponent(lblPuntos))
                .addGap(121, 121, 121)
                .addComponent(btnResumonInfo)
                .addGap(18, 18, 18)
                .addComponent(btnPuntosAcumulados)
                .addGap(18, 18, 18)
                .addComponent(btnRedencion)
                .addGap(18, 18, 18)
                .addComponent(btnDevoluciones)
                .addGap(18, 18, 18)
                .addComponent(btnReservas)
                .addGap(18, 18, 18)
                .addComponent(btnNotificasiones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                .addComponent(btnRegresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        VistaLogin vistaL = new VistaLogin();
        vistaL.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnResumonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResumonInfoActionPerformed
        // TODO add your handling code here:
        VistaResumenInfoCliente vistaRIC = new VistaResumenInfoCliente(cliente);
        vistaRIC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnResumonInfoActionPerformed

    private void btnPuntosAcumuladosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPuntosAcumuladosActionPerformed
        // TODO add your handling code here:
        VistaPuntosClientes vistaPC = new VistaPuntosClientes(cliente);
        vistaPC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPuntosAcumuladosActionPerformed

    private void btnRedencionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRedencionActionPerformed
        // TODO add your handling code here:
        VistaHistorialRedenciones vistaHR = new VistaHistorialRedenciones(cliente);
        vistaHR.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRedencionActionPerformed

    private void btnDevolucionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolucionesActionPerformed
        // TODO add your handling code here:
        VistaHistorialDevoluciones vistaHD = new VistaHistorialDevoluciones(cliente);
        vistaHD.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDevolucionesActionPerformed

    private void btnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasActionPerformed
        // TODO add your handling code here:
        VistaReservarTiquete vistaRT = new VistaReservarTiquete(cliente);
        vistaRT.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnReservasActionPerformed

    private void btnNotificasionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotificasionesActionPerformed
        // TODO add your handling code here:
        VistaNotificaciones vistaN = new VistaNotificaciones(cliente);
        vistaN.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNotificasionesActionPerformed

    /**
     * @param args the command line arguments
     */
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDevoluciones;
    private javax.swing.JButton btnNotificasiones;
    private javax.swing.JButton btnPuntosAcumulados;
    private javax.swing.JButton btnRedencion;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnReservas;
    private javax.swing.JButton btnResumonInfo;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPuntos;
    // End of variables declaration//GEN-END:variables
}

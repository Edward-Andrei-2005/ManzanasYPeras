/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package apoocalipsis;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Edward
 */
public class J_PartidaFinalizada extends javax.swing.JFrame {

    /**
     * Creates new form J_PartidaFinalizada
     */
    public J_PartidaFinalizada(boolean estado) {
        initComponents();
        // true = Ganan Supervivientes, false = Pierden Supervivientes
        String rutaImagen = estado ? "/apoocalipsis/images/Victoria.jpg" : "/apoocalipsis/images/Derrota.jpg";
            L_PartidaFinalizada.setIcon(new ImageIcon(getClass().getResource(rutaImagen)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        L_PartidaFinalizada = new javax.swing.JLabel();
        B_Inicio = new javax.swing.JButton();
        B_Salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        L_PartidaFinalizada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        B_Inicio.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        B_Inicio.setForeground(new java.awt.Color(7, 33, 68));
        B_Inicio.setText("INICIO");
        B_Inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_InicioActionPerformed(evt);
            }
        });

        B_Salir.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        B_Salir.setForeground(new java.awt.Color(255, 51, 0));
        B_Salir.setText("SALIR");
        B_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(L_PartidaFinalizada, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(B_Inicio)
                    .addComponent(B_Salir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(B_Salir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 870, Short.MAX_VALUE)
                .addComponent(B_Inicio)
                .addContainerGap())
            .addComponent(L_PartidaFinalizada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_InicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_InicioActionPerformed
        J_InterfazGrafica ventanaInterfazGrafica = new J_InterfazGrafica();
        ventanaInterfazGrafica.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_B_InicioActionPerformed

    private void B_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_SalirActionPerformed
        // Mostrar un cuadro de confirmación
        int opcion = JOptionPane.showConfirmDialog(this,
            "¿Estás seguro de que quieres salir?",
            "Confirmar salida",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);

        // Si el usuario elige "Sí", cerrar el programa
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_B_SalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(J_PartidaFinalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(J_PartidaFinalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(J_PartidaFinalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(J_PartidaFinalizada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new J_PartidaFinalizada(false).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Inicio;
    private javax.swing.JButton B_Salir;
    private javax.swing.JLabel L_PartidaFinalizada;
    // End of variables declaration//GEN-END:variables
}

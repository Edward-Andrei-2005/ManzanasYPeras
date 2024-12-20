/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package apoocalipsis;

import javax.swing.JOptionPane;

/**
 *
 * @author Edward
 */
public class J_SeleccionAcciones extends javax.swing.JPanel {

    /**
     * Creates new form J_ConfirmacionAcciones
     */
    public J_SeleccionAcciones() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        G_Acciones = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        L_LogoURJC = new javax.swing.JLabel();
        L_SeleccionAcciones = new javax.swing.JLabel();
        O_BuscarEquipo = new javax.swing.JRadioButton();
        O_ActivacionZombi = new javax.swing.JRadioButton();
        O_AtaqueSupervivienteAZombi = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));

        L_LogoURJC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apoocalipsis/image/URJ_simbolo_POS_1.png"))); // NOI18N

        L_SeleccionAcciones.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        L_SeleccionAcciones.setForeground(new java.awt.Color(7, 33, 68));
        L_SeleccionAcciones.setText("SELECCIÓN DE ACCIONES");

        G_Acciones.add(O_BuscarEquipo);
        O_BuscarEquipo.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        O_BuscarEquipo.setForeground(new java.awt.Color(7, 33, 68));
        O_BuscarEquipo.setText("Búsqueda de Equipo por parte de un superviviente");
        O_BuscarEquipo.setPreferredSize(new java.awt.Dimension(334, 53));
        O_BuscarEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O_BuscarEquipoActionPerformed(evt);
            }
        });

        G_Acciones.add(O_ActivacionZombi);
        O_ActivacionZombi.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        O_ActivacionZombi.setForeground(new java.awt.Color(7, 33, 68));
        O_ActivacionZombi.setText("Activación de un zombi");
        O_ActivacionZombi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O_ActivacionZombiActionPerformed(evt);
            }
        });

        G_Acciones.add(O_AtaqueSupervivienteAZombi);
        O_AtaqueSupervivienteAZombi.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        O_AtaqueSupervivienteAZombi.setForeground(new java.awt.Color(7, 33, 68));
        O_AtaqueSupervivienteAZombi.setText("Ataque de un superviviente a un zombi");
        O_AtaqueSupervivienteAZombi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O_AtaqueSupervivienteAZombiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(385, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(L_LogoURJC)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(L_SeleccionAcciones)
                        .addGap(436, 436, 436))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(O_AtaqueSupervivienteAZombi)
                                    .addComponent(O_ActivacionZombi))
                                .addGap(196, 196, 196))
                            .addComponent(O_BuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 838, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(236, 236, 236))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(L_SeleccionAcciones)
                .addGap(133, 133, 133)
                .addComponent(O_AtaqueSupervivienteAZombi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(O_ActivacionZombi)
                .addGap(24, 24, 24)
                .addComponent(O_BuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                .addComponent(L_LogoURJC)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void O_AtaqueSupervivienteAZombiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O_AtaqueSupervivienteAZombiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_O_AtaqueSupervivienteAZombiActionPerformed

    private void O_ActivacionZombiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O_ActivacionZombiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_O_ActivacionZombiActionPerformed

    private void O_BuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O_BuscarEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_O_BuscarEquipoActionPerformed
    public String obtenerSeleccionado() {
    if (O_BuscarEquipo.isSelected()) {
        return "Buscar Equipo";
    } else if (O_ActivacionZombi.isSelected()) {
        return "Activación Zombi";
    } else if (O_AtaqueSupervivienteAZombi.isSelected()) {
        return "Ataque Superviviente a Zombi";
    } else {
        return "Nada";
    }
}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup G_Acciones;
    private javax.swing.JLabel L_LogoURJC;
    private javax.swing.JLabel L_SeleccionAcciones;
    private javax.swing.JRadioButton O_ActivacionZombi;
    private javax.swing.JRadioButton O_AtaqueSupervivienteAZombi;
    private javax.swing.JRadioButton O_BuscarEquipo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

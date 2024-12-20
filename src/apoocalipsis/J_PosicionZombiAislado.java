/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package apoocalipsis;

/**
 *
 * @author manue
 */
public class J_PosicionZombiAislado extends javax.swing.JPanel {

    /**
     * Creates new form J_PosicionZombiAislado
     */
    public J_PosicionZombiAislado() {
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

        L_NombreSuperviviente1 = new javax.swing.JLabel();
        L_NombreSuperviviente2 = new javax.swing.JLabel();
        tfX = new javax.swing.JTextField();
        tfY = new javax.swing.JTextField();
        L_NombreSuperviviente3 = new javax.swing.JLabel();
        L_NombreSuperviviente4 = new javax.swing.JLabel();
        L_NombreSuperviviente5 = new javax.swing.JLabel();
        cbTipoZombi = new javax.swing.JComboBox<>();
        L_LogoURJC = new javax.swing.JLabel();

        setBackground(new java.awt.Color(253, 253, 253));

        L_NombreSuperviviente1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        L_NombreSuperviviente1.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente1.setText("Coordenada X:");

        L_NombreSuperviviente2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        L_NombreSuperviviente2.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente2.setText("Coordenada Y:");

        tfX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfXActionPerformed(evt);
            }
        });

        tfY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfYActionPerformed(evt);
            }
        });

        L_NombreSuperviviente3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        L_NombreSuperviviente3.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente3.setText("Elige la coordenada donde colocar el zombi de pruebas");

        L_NombreSuperviviente4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        L_NombreSuperviviente4.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente4.setText("Se generará un superviviente en la coordenada (5, 5)");

        L_NombreSuperviviente5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        L_NombreSuperviviente5.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente5.setText("Elige el tipo de zombi: ");

        L_LogoURJC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apoocalipsis/image/URJ_simbolo_POS_1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_NombreSuperviviente3)
                    .addComponent(L_NombreSuperviviente4))
                .addGap(28, 28, 28))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_NombreSuperviviente1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(L_NombreSuperviviente2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(tfY, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(L_NombreSuperviviente5)
                .addGap(36, 36, 36)
                .addComponent(cbTipoZombi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L_LogoURJC)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_NombreSuperviviente4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(L_NombreSuperviviente3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_NombreSuperviviente1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfX, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(L_NombreSuperviviente2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfY, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_NombreSuperviviente5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoZombi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(L_LogoURJC)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tfYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfYActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfYActionPerformed

    private void tfXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfXActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfXActionPerformed

    public int getCoordX() {
        try {
            return Integer.parseInt(tfX.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public int getCoordY() {
        try {
            return Integer.parseInt(tfY.getText());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    public void setTiposZombi(String [] tipos) {
        for (String s : tipos) {
            cbTipoZombi.addItem(s);
        }
    }
    
    public String getTipoZombi() {
        return (String) cbTipoZombi.getSelectedItem();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_LogoURJC;
    private javax.swing.JLabel L_NombreSuperviviente1;
    private javax.swing.JLabel L_NombreSuperviviente2;
    private javax.swing.JLabel L_NombreSuperviviente3;
    private javax.swing.JLabel L_NombreSuperviviente4;
    private javax.swing.JLabel L_NombreSuperviviente5;
    private javax.swing.JComboBox<String> cbTipoZombi;
    private javax.swing.JTextField tfX;
    private javax.swing.JTextField tfY;
    // End of variables declaration//GEN-END:variables
}
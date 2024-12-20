package apoocalipsis;
import javax.swing.JOptionPane;
/**
 *
 * @author Anass Chikou El Mahraoui, Edward Andrei, Manuel Alos de la Vega
 */
public class J_NombrarSupervivientes extends javax.swing.JPanel {

    /**
     * Creates new form J_NombrarSupervivientes
     */
    public J_NombrarSupervivientes() {
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

        L_NombresSupervivientes = new javax.swing.JLabel();
        L_LogoURJC = new javax.swing.JLabel();
        L_NombreSuperviviente2 = new javax.swing.JLabel();
        L_NombreSuperviviente1 = new javax.swing.JLabel();
        L_NombreSuperviviente4 = new javax.swing.JLabel();
        L_NombreSuperviviente3 = new javax.swing.JLabel();
        TF_NombreSuperviviente2 = new javax.swing.JTextField();
        TF_NombreSuperviviente3 = new javax.swing.JTextField();
        TF_NombreSuperviviente4 = new javax.swing.JTextField();
        TF_NombreSuperviviente1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(253, 253, 253));

        L_NombresSupervivientes.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        L_NombresSupervivientes.setForeground(new java.awt.Color(7, 33, 68));
        L_NombresSupervivientes.setText("NOMBRES SUPERVIVIENTES");

        L_LogoURJC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apoocalipsis/image/URJ_simbolo_POS_1.png"))); // NOI18N

        L_NombreSuperviviente2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        L_NombreSuperviviente2.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente2.setText("Nombre Superviviente 2:");

        L_NombreSuperviviente1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        L_NombreSuperviviente1.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente1.setText("Nombre Superviviente 1:");

        L_NombreSuperviviente4.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        L_NombreSuperviviente4.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente4.setText("Nombre Superviviente 4:");

        L_NombreSuperviviente3.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        L_NombreSuperviviente3.setForeground(new java.awt.Color(7, 33, 68));
        L_NombreSuperviviente3.setText("Nombre Superviviente 3:");

        TF_NombreSuperviviente2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        TF_NombreSuperviviente3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        TF_NombreSuperviviente4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N

        TF_NombreSuperviviente1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        TF_NombreSuperviviente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NombreSuperviviente1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(L_LogoURJC)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L_NombreSuperviviente4)
                                .addGap(18, 18, 18)
                                .addComponent(TF_NombreSuperviviente4, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L_NombreSuperviviente3)
                                .addGap(18, 18, 18)
                                .addComponent(TF_NombreSuperviviente3))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L_NombreSuperviviente2)
                                .addGap(18, 18, 18)
                                .addComponent(TF_NombreSuperviviente2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(L_NombreSuperviviente1)
                                .addGap(18, 18, 18)
                                .addComponent(TF_NombreSuperviviente1)))
                        .addGap(372, 372, 372))))
            .addGroup(layout.createSequentialGroup()
                .addGap(387, 387, 387)
                .addComponent(L_NombresSupervivientes, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 399, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(L_NombresSupervivientes)
                .addGap(138, 138, 138)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(L_NombreSuperviviente1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_NombreSuperviviente1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(L_NombreSuperviviente2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TF_NombreSuperviviente2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(L_NombreSuperviviente3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TF_NombreSuperviviente3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TF_NombreSuperviviente4)
                    .addComponent(L_NombreSuperviviente4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(166, 166, 166)
                .addComponent(L_LogoURJC)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void TF_NombreSuperviviente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_NombreSuperviviente1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_NombreSuperviviente1ActionPerformed

    public String getNombreSuperviviente1() {
        return TF_NombreSuperviviente1.getText();
    }
    
    public String getNombreSuperviviente2() {
        return TF_NombreSuperviviente2.getText();
    }
    
    public String getNombreSuperviviente3() {
        return TF_NombreSuperviviente3.getText();
    }
    
    public String getNombreSuperviviente4() {
        return TF_NombreSuperviviente4.getText();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel L_LogoURJC;
    private javax.swing.JLabel L_NombreSuperviviente1;
    private javax.swing.JLabel L_NombreSuperviviente2;
    private javax.swing.JLabel L_NombreSuperviviente3;
    private javax.swing.JLabel L_NombreSuperviviente4;
    private javax.swing.JLabel L_NombresSupervivientes;
    private javax.swing.JTextField TF_NombreSuperviviente1;
    private javax.swing.JTextField TF_NombreSuperviviente2;
    private javax.swing.JTextField TF_NombreSuperviviente3;
    private javax.swing.JTextField TF_NombreSuperviviente4;
    // End of variables declaration//GEN-END:variables
}

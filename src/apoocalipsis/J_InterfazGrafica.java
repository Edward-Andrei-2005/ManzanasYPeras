package apoocalipsis;
import java.util.Arrays;
import javax.swing.JOptionPane;
/*import java.util.Timer;
import java.util.TimerTask;*/


public class J_InterfazGrafica extends javax.swing.JFrame {

    /**
     * Creates new form InterfazGrafica
     */
    private static final int TAM = 4;
    public J_InterfazGrafica() {
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

        javax.swing.ButtonGroup G_Inicio = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        L_APOOCALIPSIS = new javax.swing.JLabel();
        L_Inicio = new javax.swing.JLabel();
        O_Retomar_Partida_Empezada = new javax.swing.JRadioButton();
        O_Crear_Nueva_Partida = new javax.swing.JRadioButton();
        B_Jugar = new javax.swing.JButton();
        L_LogoETSII = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));

        L_APOOCALIPSIS.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        L_APOOCALIPSIS.setForeground(new java.awt.Color(7, 33, 68));
        L_APOOCALIPSIS.setText("APOOCALIPSIS ZOMBIE");
        L_APOOCALIPSIS.setToolTipText("");

        L_Inicio.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        L_Inicio.setForeground(new java.awt.Color(7, 33, 68));
        L_Inicio.setText("Selecciona cómo quieres empezar la partida:");

        G_Inicio.add(O_Retomar_Partida_Empezada);
        O_Retomar_Partida_Empezada.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        O_Retomar_Partida_Empezada.setForeground(new java.awt.Color(7, 33, 68));
        O_Retomar_Partida_Empezada.setText("Retomar partida empezada");
        O_Retomar_Partida_Empezada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O_Retomar_Partida_EmpezadaActionPerformed(evt);
            }
        });

        G_Inicio.add(O_Crear_Nueva_Partida);
        O_Crear_Nueva_Partida.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        O_Crear_Nueva_Partida.setForeground(new java.awt.Color(7, 33, 68));
        O_Crear_Nueva_Partida.setText("Crear nueva partida");
        O_Crear_Nueva_Partida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                O_Crear_Nueva_PartidaActionPerformed(evt);
            }
        });

        B_Jugar.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        B_Jugar.setForeground(new java.awt.Color(7, 33, 68));
        B_Jugar.setText("¡JUGAR!");
        B_Jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_JugarActionPerformed(evt);
            }
        });

        L_LogoETSII.setIcon(new javax.swing.ImageIcon(getClass().getResource("/apoocalipsis/images/siglas_ETSII_negro_negro.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 317, Short.MAX_VALUE)
                .addComponent(L_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(288, 288, 288))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(576, 576, 576)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(O_Crear_Nueva_Partida)
                            .addComponent(O_Retomar_Partida_Empezada)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(L_LogoETSII))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(620, 620, 620)
                        .addComponent(B_Jugar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(483, 483, 483)
                        .addComponent(L_APOOCALIPSIS, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(L_LogoETSII)
                .addGap(25, 25, 25)
                .addComponent(L_APOOCALIPSIS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(L_Inicio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(O_Retomar_Partida_Empezada)
                .addGap(18, 18, 18)
                .addComponent(O_Crear_Nueva_Partida)
                .addGap(43, 43, 43)
                .addComponent(B_Jugar)
                .addGap(61, 61, 61))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void O_Retomar_Partida_EmpezadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O_Retomar_Partida_EmpezadaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_O_Retomar_Partida_EmpezadaActionPerformed

    private void O_Crear_Nueva_PartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_O_Crear_Nueva_PartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_O_Crear_Nueva_PartidaActionPerformed

    private void B_JugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_JugarActionPerformed
        if (O_Retomar_Partida_Empezada.isSelected()) {
            // Lógica para retomar partida empezada
            JOptionPane.showMessageDialog(this, "Retomando partida empezada...");
        } else if (O_Crear_Nueva_Partida.isSelected()) { // Crear nueva partida
           /* J_FotoJuego ventanaFotoJuego = new J_FotoJuego();
            ventanaFotoJuego.setVisible(true);
            
           Timer timer = new Timer();
            TimerTask tarea = new TimerTask() {
                @Override
                public void run() {
                    ventanaFotoJuego.setVisible(false);
                }
            };
            timer.schedule(tarea, 3000);
                    // Bloquea la ejecución hasta que la ventana se oculte
            try {
                // Hacer que el hilo actual espere 3000 milisegundos (3 segundos)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace(); // Manejo de excepciones si la espera es interrumpida
            }*/

            J_NombrarSupervivientes ventanaNombrarSupervivientes = new J_NombrarSupervivientes(); // Creamos la ventana para nombrar

            String arrayNombres[] = new String[TAM]; // Creamos un array para guardar los nombres
            boolean repetidos; // Creamos en booleano para volver a pedir los nombres si hay repetidos/nulos

            do {
                repetidos = false; // Reiniciar el estado en cada iteración
                
                // Mostrar el panel de nombrar supervivientes dentro del JOptionPane
                int opcion = JOptionPane.showConfirmDialog(this, ventanaNombrarSupervivientes, 
                                                           "Fase de Nombramiento de Supervivientes",
                                                           JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                if (opcion == JOptionPane.OK_OPTION) {
                    // Recogida de datos
                    arrayNombres[0] = ventanaNombrarSupervivientes.getNombreSuperviviente1();
                    arrayNombres[1] = ventanaNombrarSupervivientes.getNombreSuperviviente2();
                    arrayNombres[2] = ventanaNombrarSupervivientes.getNombreSuperviviente3();
                    arrayNombres[3] = ventanaNombrarSupervivientes.getNombreSuperviviente4();

                    // Validar si hay repetidos o vacíos
                    for (int i = 0; i < TAM; i++) {
                        if (arrayNombres[i] == null || arrayNombres[i].isEmpty()) {
                            repetidos = true;
                            break;
                        }
                        for (int j = i + 1; j < TAM; j++) {
                            if (arrayNombres[i].equals(arrayNombres[j])) {
                                repetidos = true;
                                break;
                            }
                        }
                        if (repetidos) break;
                    }

                    if (repetidos) {
                        JOptionPane.showMessageDialog(this, 
                                                      "Los nombres no deben estar vacíos ni repetirse. Inténtalo de nuevo.",
                                                      "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Mostrar ventana de confirmación
                        J_ConfirmacionSupervivientes ventanaConfirmacion = new J_ConfirmacionSupervivientes();
                        ventanaConfirmacion.escribirConfirmacion(arrayNombres); // Escribimos los nombres del array que hemos creado antes

                        int opcion2 = JOptionPane.showConfirmDialog(this, ventanaConfirmacion, 
                                                                    "Fase de Confirmación de Supervivientes",
                                                                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

                        if (opcion2 == JOptionPane.OK_OPTION) {
                            // Si confirma, pasa al tablero
                            J_Tablero ventanaTablero = new J_Tablero();
                            ventanaTablero.setVisible(true); // Mostrar ventana de tablero
                            this.setVisible(false);
                            return; // Salir del ciclo y finalizar
                        } else {
                            // Si cancela en la confirmación, volver al nombramiento
                            JOptionPane.showMessageDialog(this, 
                                                          "Por favor, vuelve a introducir los nombres.",
                                                          "Información", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                } else {
                    // Si cancela en la ventana de nombrar supervivientes, salir del bucle
                    JOptionPane.showMessageDialog(this, 
                                                  "Creación de nueva partida cancelada.", 
                                                  "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            } while (repetidos || true); // Repetir si hay nombres inválidos o el usuario cancela en la confirmación

        //Llamada a main

    } else {
        // Si no hay opción seleccionada, muestra un mensaje
        JOptionPane.showMessageDialog(this, "Por favor, selecciona una opción antes de jugar.");
    }
    }//GEN-LAST:event_B_JugarActionPerformed

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
            java.util.logging.Logger.getLogger(J_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(J_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(J_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(J_InterfazGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new J_InterfazGrafica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Jugar;
    private javax.swing.JLabel L_APOOCALIPSIS;
    private javax.swing.JLabel L_Inicio;
    private javax.swing.JLabel L_LogoETSII;
    private javax.swing.JRadioButton O_Crear_Nueva_Partida;
    private javax.swing.JRadioButton O_Retomar_Partida_Empezada;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

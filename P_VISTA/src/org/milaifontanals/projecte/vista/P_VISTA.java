package org.milaifontanals.projecte.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.milaifontanals.projecte.model.Client;
import org.milaifontanals.projecte.jdbc.Persistencia;
import org.milaifontanals.projecte.jdbc.PersistenciaException;

/**
 *
 * @author Usuari
 */
public class P_VISTA extends javax.swing.JFrame {
    
    Persistencia pers = null;
    JLabel informaCon = new JLabel();
    
    public P_VISTA() {
        initComponents();
        initManualComponents();
        setTitle("Milà-Spotify");
        setLocationRelativeTo(null);
        setResizable(false);
    }
    
    public void setConnexio(Persistencia cbd){
        pers = cbd;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuCataleg = new javax.swing.JMenu();
        CatalegEstils = new javax.swing.JMenuItem();
        CatalegProductes = new javax.swing.JMenuItem();
        menuReproduccions = new javax.swing.JMenu();
        menuArtistes = new javax.swing.JMenu();
        ArtistesPaisos = new javax.swing.JMenuItem();
        ArtistesArtistes = new javax.swing.JMenuItem();
        menuClients = new javax.swing.JMenu();
        ClientsPaisos = new javax.swing.JMenuItem();
        ClientsClients = new javax.swing.JMenuItem();
        ClientsEliminacio = new javax.swing.JMenuItem();
        menuAjuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setPreferredSize(new java.awt.Dimension(700, 480));

        jButton1.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jButton1.setText("CONNECT");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(256, 256, 256)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(256, Short.MAX_VALUE))
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(239, Short.MAX_VALUE))
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        menuCataleg.setText("Catàleg");
        menuCataleg.setEnabled(false);
        menuCataleg.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        menuCataleg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuCatalegMouseEntered(evt);
            }
        });

        CatalegEstils.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        CatalegEstils.setText("Estils");
        CatalegEstils.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatalegEstilsActionPerformed(evt);
            }
        });
        menuCataleg.add(CatalegEstils);

        CatalegProductes.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        CatalegProductes.setText("Productes");
        CatalegProductes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CatalegProductesActionPerformed(evt);
            }
        });
        menuCataleg.add(CatalegProductes);

        jMenuBar1.add(menuCataleg);

        menuReproduccions.setText("Reproduccions");
        menuReproduccions.setEnabled(false);
        menuReproduccions.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        menuReproduccions.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReproduccionsMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuReproduccions);

        menuArtistes.setText("Artistes");
        menuArtistes.setEnabled(false);
        menuArtistes.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        menuArtistes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuArtistesMouseEntered(evt);
            }
        });

        ArtistesPaisos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        ArtistesPaisos.setText("Països");
        ArtistesPaisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistesPaisosActionPerformed(evt);
            }
        });
        menuArtistes.add(ArtistesPaisos);

        ArtistesArtistes.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        ArtistesArtistes.setText("Artistes");
        ArtistesArtistes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ArtistesArtistesActionPerformed(evt);
            }
        });
        menuArtistes.add(ArtistesArtistes);

        jMenuBar1.add(menuArtistes);

        menuClients.setText("Clients");
        menuClients.setEnabled(false);
        menuClients.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        menuClients.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                menuClientsMouseEntered(evt);
            }
        });

        ClientsPaisos.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        ClientsPaisos.setText("Països");
        ClientsPaisos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsPaisosActionPerformed(evt);
            }
        });
        menuClients.add(ClientsPaisos);

        ClientsClients.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        ClientsClients.setText("Clients");
        ClientsClients.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsClientsActionPerformed(evt);
            }
        });
        menuClients.add(ClientsClients);

        ClientsEliminacio.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        ClientsEliminacio.setText("Eliminació");
        ClientsEliminacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientsEliminacioActionPerformed(evt);
            }
        });
        menuClients.add(ClientsEliminacio);

        jMenuBar1.add(menuClients);

        menuAjuda.setText("Ajuda");
        menuAjuda.setEnabled(false);
        menuAjuda.setFont(new java.awt.Font("Consolas", 0, 18)); // NOI18N
        jMenuBar1.add(menuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ClientsEliminacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsEliminacioActionPerformed
        toDo();
    }//GEN-LAST:event_ClientsEliminacioActionPerformed

    private void ClientsClientsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsClientsActionPerformed
        toDo();
    }//GEN-LAST:event_ClientsClientsActionPerformed

    private void ArtistesArtistesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistesArtistesActionPerformed
        toDo();
    }//GEN-LAST:event_ArtistesArtistesActionPerformed

    private void CatalegProductesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalegProductesActionPerformed
        toDo();
    }//GEN-LAST:event_CatalegProductesActionPerformed

    private void ClientsPaisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientsPaisosActionPerformed
        toDo();
    }//GEN-LAST:event_ClientsPaisosActionPerformed

    private void ArtistesPaisosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ArtistesPaisosActionPerformed
        toDo();
    }//GEN-LAST:event_ArtistesPaisosActionPerformed

    private void CatalegEstilsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CatalegEstilsActionPerformed
        toDo();
    }//GEN-LAST:event_CatalegEstilsActionPerformed

    private void menuCatalegMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCatalegMouseEntered
        menuCataleg.doClick();
    }//GEN-LAST:event_menuCatalegMouseEntered

    private void menuArtistesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuArtistesMouseEntered
        menuArtistes.doClick();
    }//GEN-LAST:event_menuArtistesMouseEntered

    private void menuClientsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuClientsMouseEntered
        menuClients.doClick();
    }//GEN-LAST:event_menuClientsMouseEntered

    private void menuReproduccionsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuReproduccionsMouseClicked
        Reproduccions();
    }//GEN-LAST:event_menuReproduccionsMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean conEst = false;
        conEst = establirConexio();
        jButton1.setVisible(false);
        if (conEst){
            informaCon.setFont(new java.awt.Font("Consolas", 2, 30));
            informaCon.setBounds(180, 200, 400, 50);
            informaCon.setForeground(Color.GREEN);
            informaCon.setText("Connexió establerta!");
            menuCataleg.setVisible(true);
            menuReproduccions.setVisible(true);
            menuReproduccions.setEnabled(true);
            menuArtistes.setVisible(true);
            menuClients.setVisible(true);
            menuAjuda.setVisible(true);
        }else{
            informaCon.setForeground(Color.RED);
            informaCon.setText("No s'ha pogut establir connexió... \n");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        jPanelPrincipal.add(informaCon);
        informaCon.setBounds(190, 300, 400, 50);
        informaCon.setFont(new java.awt.Font("Consolas", 2, 20));
        informaCon.setText("Establint connexió amb la BD...");
    }//GEN-LAST:event_jButton1MousePressed
    
    public void initManualComponents(){
        menuCataleg.setVisible(false);
        menuAjuda.setVisible(false);
        menuArtistes.setVisible(false);
        menuClients.setVisible(false);
        menuReproduccions.setVisible(false);
    }
    
    //-------------------------CARREGAR DIFERENTS OPCIONS DEL MENU
    private void toDo(){
        ToDo p = new ToDo();
        
        p.setSize(700, 472);
        p.setLocation(0, 0);
        
        jPanelPrincipal.removeAll();
        jPanelPrincipal.add(p, BorderLayout.CENTER);
        jPanelPrincipal.revalidate();
        jPanelPrincipal.repaint();
    }
    
    private void Reproduccions(){
        List<Client> clients = new ArrayList<Client>();
        PantallaReproduccions p = new PantallaReproduccions();
        
        p.setSize(700, 472);
        p.setLocation(0, 0);
        
        jPanelPrincipal.removeAll();
        jPanelPrincipal.add(p, BorderLayout.CENTER);
        jPanelPrincipal.revalidate();
        jPanelPrincipal.repaint();
    }
    
    //-----------------------------------
    private boolean establirConexio(){
        boolean establerta = true;
        try {
            pers = new Persistencia("conexioOracle.properties");
        } catch (PersistenciaException ex) {
            establerta = false;
        }
        return establerta;
    }
    
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
            java.util.logging.Logger.getLogger(P_VISTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P_VISTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P_VISTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P_VISTA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P_VISTA().setVisible(true);
            }
        });
    }
    //Variables manuals

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ArtistesArtistes;
    private javax.swing.JMenuItem ArtistesPaisos;
    private javax.swing.JMenuItem CatalegEstils;
    private javax.swing.JMenuItem CatalegProductes;
    private javax.swing.JMenuItem ClientsClients;
    private javax.swing.JMenuItem ClientsEliminacio;
    private javax.swing.JMenuItem ClientsPaisos;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JMenu menuAjuda;
    private javax.swing.JMenu menuArtistes;
    private javax.swing.JMenu menuCataleg;
    private javax.swing.JMenu menuClients;
    private javax.swing.JMenu menuReproduccions;
    // End of variables declaration//GEN-END:variables
}

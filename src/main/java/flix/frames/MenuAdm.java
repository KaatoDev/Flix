/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flix.frames;

import flix.Main;

import javax.swing.*;

import static flix.Main.usuario;
import static flix.util.Manager.icon;

/**
 *
 * @author 823115101
 */
public class MenuAdm extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public MenuAdm() {
        super("(Usuário: " + usuario.getNome() + ") MyImagePro - Menu Admin");
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

        sair5 = new javax.swing.JButton();
        menuP = new javax.swing.JPanel();
        catalogoB = new javax.swing.JButton();
        cadUserB = new javax.swing.JButton();
        managerUserB = new javax.swing.JButton();
        managerFilmeB = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(icon(this.getClass()));
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sair5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.png"))); // NOI18N
        sair5.setBorder(null);
        sair5.setBorderPainted(false);
        sair5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sair5ActionPerformed(evt);
            }
        });
        getContentPane().add(sair5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 580, -1, -1));

        menuP.setOpaque(false);
        menuP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        catalogoB.setText("catalogo");
        catalogoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoBActionPerformed(evt);
            }
        });
        menuP.add(catalogoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        cadUserB.setText("Cadastrar usuário");
        cadUserB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadUserBActionPerformed(evt);
            }
        });
        menuP.add(cadUserB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        managerUserB.setText("Gerenciar usuários");
        managerUserB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerUserBActionPerformed(evt);
            }
        });
        menuP.add(managerUserB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        managerFilmeB.setText("Gerenciar filmes");
        managerFilmeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerFilmeBActionPerformed(evt);
            }
        });
        menuP.add(managerFilmeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        getContentPane().add(menuP, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 150, 420, 340));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bbb2.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void catalogoBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoBActionPerformed
        this.dispose();
        new Catalogo().setVisible(true);
    }//GEN-LAST:event_catalogoBActionPerformed

    private void cadUserBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadUserBActionPerformed
        this.dispose();
        new CadUser().setVisible(true);
    }//GEN-LAST:event_cadUserBActionPerformed

    private void managerUserBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerUserBActionPerformed
        this.dispose();
        new Usuarios().setVisible(true);
    }//GEN-LAST:event_managerUserBActionPerformed

    private void managerFilmeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerFilmeBActionPerformed
        this.dispose();
        new Filmes().setVisible(true);
    }//GEN-LAST:event_managerFilmeBActionPerformed

    private void sair5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sair5ActionPerformed
        this.dispose();
        Main.usuario = null;
        new Login().setVisible(true);
    }//GEN-LAST:event_sair5ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MenuAdm().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton cadUserB;
    private javax.swing.JButton catalogoB;
    private javax.swing.JButton managerFilmeB;
    private javax.swing.JButton managerUserB;
    private javax.swing.JPanel menuP;
    private javax.swing.JButton sair5;
    // End of variables declaration//GEN-END:variables
}

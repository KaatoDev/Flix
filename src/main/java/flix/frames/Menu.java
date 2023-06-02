/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flix.frames;

/**
 *
 * @author 823115101
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
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

        menuP = new javax.swing.JPanel();
        catalogoB = new javax.swing.JButton();
        cadFilmeB = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuP.setOpaque(false);
        menuP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        catalogoB.setText("catalogo");
        catalogoB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoBActionPerformed(evt);
            }
        });
        menuP.add(catalogoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        cadFilmeB.setText("Cadastrar filme");
        cadFilmeB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadFilmeBActionPerformed(evt);
            }
        });
        menuP.add(cadFilmeB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

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

    private void cadFilmeBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadFilmeBActionPerformed
        this.dispose();
        new CadFilme().setVisible(true);
    }//GEN-LAST:event_cadFilmeBActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton cadFilmeB;
    private javax.swing.JButton catalogoB;
    private javax.swing.JPanel menuP;
    // End of variables declaration//GEN-END:variables
}
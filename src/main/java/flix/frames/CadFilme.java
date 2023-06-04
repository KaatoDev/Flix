/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package flix.frames;

import flix.enums.GeneroFilme;

import javax.swing.*;

import static flix.Main.usuario;
import static flix.util.DbManager.registrarFilme;
import static flix.util.Manager.icon;

/**
 *
 * @author Gago3
 */
public class CadFilme extends javax.swing.JFrame {

    /**
     * Creates new form CadFilme
     */
    public CadFilme() {
        super("(Usuário: " + usuario.getNome() + ") MyImagePro - Cadastro de filmes");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nomeF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        sinopseF = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        capaF = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        iconF = new javax.swing.JTextArea();
        anoF = new javax.swing.JFormattedTextField();
        kidB = new javax.swing.JCheckBox();
        notaF = new javax.swing.JFormattedTextField();
        classCB = new javax.swing.JComboBox<>();
        genCB2 = new javax.swing.JComboBox<>();
        genCB1 = new javax.swing.JComboBox<>();
        cadastrarB = new javax.swing.JButton();
        menu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusTraversalPolicyProvider(true);
        setIconImage(icon(this.getClass()));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1920, 1080));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nomeF.setText("Velozes e furiosos");
        nomeF.setBorder(javax.swing.BorderFactory.createTitledBorder("Nome do filme"));
        nomeF.setMaximumSize(new java.awt.Dimension(220, 50));
        nomeF.setMinimumSize(new java.awt.Dimension(220, 50));
        nomeF.setPreferredSize(new java.awt.Dimension(220, 50));

        jScrollPane1.setMaximumSize(new java.awt.Dimension(300, 150));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(300, 150));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(300, 150));

        sinopseF.setColumns(20);
        sinopseF.setLineWrap(true);
        sinopseF.setRows(5);
        sinopseF.setText("Um policial de Los Angeles, deverá decidir onde fica sua lealdade quando se apaixona pelo mundo que teve que destruir.");
        sinopseF.setWrapStyleWord(true);
        sinopseF.setBorder(javax.swing.BorderFactory.createTitledBorder("Sinopse do filme"));
        sinopseF.setMaximumSize(new java.awt.Dimension(250, 100));
        sinopseF.setMinimumSize(new java.awt.Dimension(250, 100));
        sinopseF.setPreferredSize(new java.awt.Dimension(250, 100));
        jScrollPane1.setViewportView(sinopseF);

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMaximumSize(new java.awt.Dimension(440, 60));
        jScrollPane2.setMinimumSize(new java.awt.Dimension(440, 60));
        jScrollPane2.setPreferredSize(new java.awt.Dimension(440, 60));

        capaF.setColumns(20);
        capaF.setLineWrap(true);
        capaF.setRows(5);
        capaF.setBorder(javax.swing.BorderFactory.createTitledBorder("Link da capa"));
        capaF.setMaximumSize(new java.awt.Dimension(440, 60));
        capaF.setMinimumSize(new java.awt.Dimension(440, 60));
        capaF.setPreferredSize(new java.awt.Dimension(440, 60));
        jScrollPane2.setViewportView(capaF);

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane3.setMaximumSize(new java.awt.Dimension(440, 60));
        jScrollPane3.setMinimumSize(new java.awt.Dimension(440, 60));
        jScrollPane3.setPreferredSize(new java.awt.Dimension(440, 60));

        iconF.setColumns(20);
        iconF.setLineWrap(true);
        iconF.setRows(5);
        iconF.setBorder(javax.swing.BorderFactory.createTitledBorder("Link do icon"));
        jScrollPane3.setViewportView(iconF);

        anoF.setBorder(javax.swing.BorderFactory.createTitledBorder("Ano de lançamento"));
        anoF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("YYYY"))));
        anoF.setToolTipText("");
        anoF.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        anoF.setMaximumSize(new java.awt.Dimension(130, 40));
        anoF.setMinimumSize(new java.awt.Dimension(130, 40));
        anoF.setPreferredSize(new java.awt.Dimension(130, 40));
        anoF.setVerifyInputWhenFocusTarget(false);

        kidB.setText("Filme infantil");

        notaF.setBorder(javax.swing.BorderFactory.createTitledBorder("Nota IMDB"));
        notaF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("0.0"))));
        notaF.setMinimumSize(new java.awt.Dimension(105, 40));
        notaF.setPreferredSize(new java.awt.Dimension(150, 50));

        classCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Livre", "10+", "12+", "14+", "16+", "18+" }));
        classCB.setBorder(javax.swing.BorderFactory.createTitledBorder("Classsificação etária"));
        classCB.setMaximumSize(new java.awt.Dimension(125, 50));
        classCB.setMinimumSize(new java.awt.Dimension(125, 50));
        classCB.setPreferredSize(new java.awt.Dimension(125, 50));

        genCB2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ação", "Comédia", "Romance", "Suspense", "Terror" }));
        genCB2.setBorder(javax.swing.BorderFactory.createTitledBorder("Gênero 2"));

        genCB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ação", "Comédia", "Romance", "Suspense", "Terror" }));
        genCB1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gênero 1"));
        genCB1.setMaximumSize(new java.awt.Dimension(92, 43));

        cadastrarB.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cadastrarB.setText("Cadastrar");
        cadastrarB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(nomeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(anoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(classCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(notaF, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(kidB))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(genCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(genCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(cadastrarB, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(classCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(notaF, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(kidB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genCB2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(genCB1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cadastrarB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 79, -1, -1));

        menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon2.png"))); // NOI18N
        menu.setBorder(null);
        menu.setBorderPainted(false);
        menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuActionPerformed(evt);
            }
        });
        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarBActionPerformed
        GeneroFilme a1 = GeneroFilme.valueOf(genCB1.get.getSelectedItem().toString().toUpperCase()), a2 = GeneroFilme.valueOf(genCB2.getSelectedItem().toString().toUpperCase());
        if (registrarFilme(usuario, nomeF.getText(), sinopseF.getText(), capaF.getText(), iconF.getText(), Integer.parseInt(anoF.getText()), Double.parseDouble(notaF.getText().replace(",", ".")), classCB.getSelectedItem().toString(), kidB.isSelected(), a1, a2)) {
            JOptionPane.showMessageDialog(null, "Filme <" + nomeF.getText() +  "> cadastrado com sucesso!");
            this.dispose();
            new Catalogo().setVisible(true);
        }
    }//GEN-LAST:event_cadastrarBActionPerformed

    private void menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_menuActionPerformed

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
            java.util.logging.Logger.getLogger(CadFilme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new CadFilme().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField anoF;
    private javax.swing.JButton cadastrarB;
    private javax.swing.JTextArea capaF;
    private javax.swing.JComboBox<String> classCB;
    private javax.swing.JComboBox<String> genCB1;
    private javax.swing.JComboBox<String> genCB2;
    private javax.swing.JTextArea iconF;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox kidB;
    private javax.swing.JButton menu;
    private javax.swing.JTextField nomeF;
    private javax.swing.JFormattedTextField notaF;
    private javax.swing.JTextArea sinopseF;
    // End of variables declaration//GEN-END:variables
}
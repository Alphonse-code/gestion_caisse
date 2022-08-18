package com.ralph.application;

import com.ralph.classe.DataBase;
import com.ralph.classe.Url;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.swing.JOptionPane;

/**
 *
 * @author geek
 */
public class CreCompte extends javax.swing.JDialog {
    
    DataBase db;
    private static final int FF_HEX_VALUE = 0xFF;

    /**
     * Creates new form CreCompte
     */
    public CreCompte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        
        db = new DataBase(Url.HOST, Url.USER, Url.PASSWORD);
        initComponents();
    }

    public void chiffreHiany(KeyEvent k) {
        if (!Character.isDigit(k.getKeyChar())) {
            getToolkit().beep();
            k.consume();
        }
    }

    public static String md5(String src) {
        try {
            // Create MD5 Hash
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(src.getBytes());
            byte[] messageDigest = digest.digest();
            // Create Hex String
            StringBuilder hexString = new StringBuilder(); 
            for (int i = 0; i < messageDigest.length; i++) {
                hexString.append(Integer.toHexString(FF_HEX_VALUE & messageDigest[i]));
            }
            String md5 = hexString.toString();
            return md5;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public boolean accepterEmail() {
        boolean ok = false;
        String message = "", tex = txt_email.getText().trim();
        int posiArrobase = 0, posiPoint = 0, posi2 = 0;

        // signaler l'espace
        if (tex.contains(" ")) {
            message = " Il y a un blanc dans l''adresse email ";
        }
        if (message.length() == 0) {
            posiArrobase = tex.indexOf("@");
            if (posiArrobase < 0) {
                message = " L'arrobase est (@) manque dans l'adresse email ";
            }
            if ((posiArrobase == 0) || (tex.endsWith("@"))) {
                message = " L'arrobase (@) est mal placé dans l'adresse email ";
            }
            if ((posiArrobase > 0) && (posiArrobase < tex.length())) {
                posi2 = tex.indexOf("@", posiArrobase + 1);
                if (posi2 > posiArrobase) {
                    message = " Double arrobase (@) dans l'adresse email ";
                }
            }
            if (message.length() == 0) {
                posiPoint = tex.indexOf(".");
                if (posiPoint == -1) {
                    message = " On doit trouver au moins un point dans l'adresse email ";
                }
                if ((posiPoint == 0) || (tex.endsWith("."))) {
                    message = " Point mal placé dans l'adresse email ";
                }
            }
            if (message.length() == 0) {
                if (tex.length() == 0) {
                    message = " L'adresse email est vide ";
                }
            }
        }
        if (message.length() == 0) {
            ok = true;
        } else {
            JOptionPane.showMessageDialog(null, message);
            txt_email.requestFocusInWindow();
        }
        return (ok);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nom = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        txt_cin = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txt_confPass = new javax.swing.JPasswordField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(245, 187, 148));
        jLabel1.setText("Créer compte");

        jLabel2.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel2.setText("Nom");

        jLabel3.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel3.setText("Mot de passe");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel4.setText("Role");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Caissier" }));

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("E-mail");

        txt_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_emailFocusLost(evt);
            }
        });
        txt_email.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_emailMouseReleased(evt);
            }
        });
        txt_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_emailKeyReleased(evt);
            }
        });

        txt_tel.setText("+261");
        txt_tel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_telFocusLost(evt);
            }
        });
        txt_tel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setText("Téléphone");

        jLabel7.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel7.setText("CIN");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/002-sign.png"))); // NOI18N
        btnAdd.setText("Créer");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txt_cin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_cinFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_cinFocusLost(evt);
            }
        });
        txt_cin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cinKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cinKeyTyped(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Knob-Loop-On-icon.png"))); // NOI18N
        jButton2.setText("Retour");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel8.setText("Confirmer");

        txt_confPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_confPassKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mac book.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_tel)
                                    .addComponent(txt_email, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_cin)
                                    .addComponent(txt_nom)
                                    .addComponent(txt_password)
                                    .addComponent(jComboBox1, 0, 217, Short.MAX_VALUE)
                                    .addComponent(txt_confPass)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(137, 137, 137)
                                .addComponent(jButton2)))
                        .addGap(42, 42, 42)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_confPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(135, 135, 135))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Login l = new Login(null, rootPaneCheckingEnabled);
        l.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:

        String pass = String.valueOf(txt_password.getPassword());
        String conf = String.valueOf(txt_confPass.getPassword());
        
        if (txt_cin.getText().equals("") || pass.equals("") || conf.equals("") || txt_email.getText().equals("") || txt_tel.equals("")) {
            JOptionPane.showMessageDialog(null, "Veuillez remplire tout les champ");
        } else {
            String[] col = {"nom", "password", "role", "email", "tel", "CIN"};
            String[] data = {txt_nom.getText(), md5(conf), jComboBox1.getSelectedItem().toString(), txt_email.getText(), txt_tel.getText(), txt_cin.getText()};
            
            if (!(pass.equals(conf))) {
                
                JOptionPane.showMessageDialog(null, "Ce mot de passe est different de celle que vous avez saisi au dessus !\n Veillez les retapés ");
            }
            
            System.out.println(db.queryInsert("responsable", col, data));
            JOptionPane.showMessageDialog(null, "Creation de Compte succes ");
            
        }

    }//GEN-LAST:event_btnAddActionPerformed

    private void txt_confPassKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_confPassKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_confPassKeyReleased

    private void txt_emailMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_emailMouseReleased
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_emailMouseReleased

    private void txt_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_emailKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_emailKeyReleased

    private void txt_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_emailFocusLost
        // TODO add your handling code here:
        accepterEmail();
    }//GEN-LAST:event_txt_emailFocusLost

    private void txt_telFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_telFocusLost
        // TODO add your handling code here:


    }//GEN-LAST:event_txt_telFocusLost

    private void txt_telKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telKeyTyped
        // TODO add your handling code here:
        chiffreHiany(evt);
    }//GEN-LAST:event_txt_telKeyTyped

    private void txt_cinKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cinKeyTyped
        // TODO add your handling code here:
        chiffreHiany(evt);
        
    }//GEN-LAST:event_txt_cinKeyTyped

    private void txt_cinFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cinFocusLost
        // TODO add your handling code here:
       
        System.out.println(txt_cin.getText().length());
    }//GEN-LAST:event_txt_cinFocusLost

    private void txt_cinKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cinKeyReleased
        // TODO add your handling code here:
         
    }//GEN-LAST:event_txt_cinKeyReleased

    private void txt_cinFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_cinFocusGained
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txt_cinFocusGained

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
            java.util.logging.Logger.getLogger(CreCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreCompte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreCompte dialog = new CreCompte(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_cin;
    private javax.swing.JPasswordField txt_confPass;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}

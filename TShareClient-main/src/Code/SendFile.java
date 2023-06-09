/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Code;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Hp
 */
public class SendFile extends javax.swing.JFrame {

    /**
     * Creates new form SendFile
     */
    SocketClient socket;
    IconImage image = new IconImage();
    InfomationUser info = new InfomationUser();
    public File file;
    public RC4Encryption rc4 = new RC4Encryption();

    public SendFile() {
        initComponents();
        initIcon();
    }
    String publicKey;
    String username;

    public SendFile(String publicKey, String username, SocketClient sk) {
        initComponents();
        initIcon();
        socket = sk;
        this.publicKey = publicKey;
        this.setTitle("Send File User " + username + " - TShare");
        lbUsr.setText(username);
        this.username = username;
    }

    public void initIcon() {
        Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Resources/iconTShare.png"));
        this.setIconImage(image);
        setLocationRelativeTo(null);
    }

    public String getPublicKey() {
        return publicKey;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbUsr = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/public-key.png"))); // NOI18N
        jButton1.setText("Show Public Key Receiver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("To send a file, click on the file select button and select the file you want to send");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/choose.png"))); // NOI18N
        jButton2.setText("Send File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setText("Tip: TShare encrypts the file before sending");

        jLabel3.setText("Tip: You can view the recipient's key with the public key view button");

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 143, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/favRemoveBackgroud.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Send File to Users:");

        lbUsr.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbUsr.setText("jLabel6");

        jLabel6.setText("Max File Size: 1GB");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbUsr)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbUsr))
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showDialog(this, "Select File");
        file = fileChooser.getSelectedFile();

        if (file != null) {
            if (!file.getName().isEmpty()) {

                long size = file.length();
                if (size < 1024 * 1024 * 1024) {
                    Vector<String> vt = new Vector<String>();
                    vt.add(rc4.encryptKeyRSA(publicKey));
                    socket.send(new Message("upload_req", info.Username, file.getName(), username,vt));
                } else {
                    JOptionPane.showMessageDialog(null, "File is Large, TShare support max file size 1GB", "File Large", JOptionPane.ERROR_MESSAGE, image.FileLarge());
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ViewPublicKey pk = new ViewPublicKey(publicKey, username);
        pk.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SendFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbUsr;
    // End of variables declaration//GEN-END:variables
}


import com.parker.CreateFacebookStream;
import com.parker.CreateYoutubeStream;
import com.parker.GetFacebookData;
import com.parker.youtube.ManageYoutubeData;

public class MainWindow extends javax.swing.JFrame {
    
    public static boolean opened = false;

    public MainWindow() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainWindowtitle = new javax.swing.JLabel();
        streamTitleLabel = new javax.swing.JLabel();
        streamTitleField = new javax.swing.JTextField();
        streamDescLabel = new javax.swing.JLabel();
        createStreamButton = new javax.swing.JButton();
        livestreamSettingsLabel = new javax.swing.JLabel();
        streamFBIDField = new javax.swing.JTextField();
        streamFBID = new javax.swing.JLabel();
        streamFBKey = new javax.swing.JLabel();
        streamYTKeyField = new javax.swing.JTextField();
        streamYTDataLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        streamDescField = new javax.swing.JTextArea();
        copyFBKeyButton = new javax.swing.JButton();
        copyFBIDButton = new javax.swing.JButton();
        streamFBDataLabel = new javax.swing.JLabel();
        streamYTKey = new javax.swing.JLabel();
        streamYTID = new javax.swing.JLabel();
        streamYTIDField = new javax.swing.JTextField();
        streamFBKeyField = new javax.swing.JTextField();
        copyYTKeyButton = new javax.swing.JButton();
        copyYTURLButton = new javax.swing.JButton();
        streamYTURLField = new javax.swing.JTextField();
        streamYTURL = new javax.swing.JLabel();
        copyYTIDButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        mainWindowtitle.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        mainWindowtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainWindowtitle.setText("CHBC Livestream Creator");

        streamTitleLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamTitleLabel.setText("Title:");

        streamTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamTitleFieldActionPerformed(evt);
            }
        });

        streamDescLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamDescLabel.setText("Description:");

        createStreamButton.setText("Create Livestream");
        createStreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStreamButtonActionPerformed(evt);
            }
        });

        livestreamSettingsLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        livestreamSettingsLabel.setText("Stream Settings:");

        streamFBIDField.setEditable(false);
        streamFBIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamFBIDFieldActionPerformed(evt);
            }
        });

        streamFBID.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBID.setText("FB ID:");

        streamFBKey.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBKey.setText("FB Stream Key:");

        streamYTKeyField.setEditable(false);
        streamYTKeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamYTKeyFieldActionPerformed(evt);
            }
        });

        streamYTDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamYTDataLabel.setText("YT Stream Data:");

        streamDescField.setColumns(20);
        streamDescField.setLineWrap(true);
        streamDescField.setRows(5);
        jScrollPane1.setViewportView(streamDescField);

        copyFBKeyButton.setText("Copy FB Key");
        copyFBKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBKeyButtonActionPerformed(evt);
            }
        });

        copyFBIDButton.setText("Copy FB ID");
        copyFBIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBIDButtonActionPerformed(evt);
            }
        });

        streamFBDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamFBDataLabel.setText("FB Stream Data:");

        streamYTKey.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTKey.setText("YT Stream Key:");

        streamYTID.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTID.setText("YT ID:");

        streamYTIDField.setEditable(false);
        streamYTIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamYTIDFieldActionPerformed(evt);
            }
        });

        streamFBKeyField.setEditable(false);
        streamFBKeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamFBKeyFieldActionPerformed(evt);
            }
        });

        copyYTKeyButton.setText("Copy YT Key");
        copyYTKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTKeyButtonActionPerformed(evt);
            }
        });

        copyYTURLButton.setText("Copy YT URL");
        copyYTURLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTURLButtonActionPerformed(evt);
            }
        });

        streamYTURLField.setEditable(false);
        streamYTURLField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamYTURLFieldActionPerformed(evt);
            }
        });

        streamYTURL.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTURL.setText("YT Stream URL:");

        copyYTIDButton1.setText("Copy YT ID");
        copyYTIDButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTIDButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(createStreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(streamTitleLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(streamTitleField))
                                    .addComponent(livestreamSettingsLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(streamDescLabel)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streamFBDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(streamYTID)
                                            .addComponent(streamYTKey)
                                            .addComponent(streamYTURL))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(streamYTIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(copyYTIDButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(streamYTKeyField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                                                    .addComponent(streamYTURLField, javax.swing.GroupLayout.Alignment.LEADING))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(copyYTKeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(copyYTURLButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                    .addComponent(streamYTDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(streamFBKey)
                                            .addComponent(streamFBID))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(streamFBIDField)
                                            .addComponent(streamFBKeyField))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(copyFBKeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                            .addComponent(copyFBIDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))))
                    .addComponent(mainWindowtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainWindowtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livestreamSettingsLabel)
                    .addComponent(streamFBDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streamTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamFBID)
                    .addComponent(streamFBIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyFBIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streamFBKey)
                    .addComponent(streamFBKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(copyFBKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(streamYTDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streamYTID)
                            .addComponent(streamYTIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyYTIDButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streamYTURL)
                            .addComponent(streamYTURLField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyYTURLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streamYTKey)
                            .addComponent(copyYTKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streamYTKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(createStreamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void streamTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamTitleFieldActionPerformed

    }//GEN-LAST:event_streamTitleFieldActionPerformed

    private void createStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStreamButtonActionPerformed
        try {
            new CreateYoutubeStream().createYoutubeStream(streamTitleField.getText(), streamDescField.getText());
            CreateFacebookStream fbStreamCreator = new CreateFacebookStream();

            fbStreamCreator.createStream(streamTitleField.getText(), streamDescField.getText(), "Capitol Hill Baptist");

            if (fbStreamCreator.getStreamID() != null && fbStreamCreator.getStreamURL() != null) {
                streamFBIDField.setText(fbStreamCreator.getStreamID());
                streamFBKeyField.setText(fbStreamCreator.getStreamURL());
            }

            GetFacebookData facebookData = new GetFacebookData();

            facebookData.saveTitleAndDesc(streamTitleField.getText(), streamDescField.getText());

            System.out.println(new ManageYoutubeData().getBroadcastID());
            System.out.println(new ManageYoutubeData().getStreamID());
            System.out.println(new ManageYoutubeData().getStreamURL());
            System.out.println(new ManageYoutubeData().getStreamKey());

            streamYTIDField.setText(new ManageYoutubeData().getStreamID());
            streamYTURLField.setText(new ManageYoutubeData().getStreamURL());
            streamYTKeyField.setText(new ManageYoutubeData().getStreamKey());

            createStreamButton.setEnabled(false);
            streamTitleField.setEnabled(false);
            streamDescField.setEnabled(false);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_createStreamButtonActionPerformed

    private void streamYTKeyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamYTKeyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamYTKeyFieldActionPerformed

    private void streamFBIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamFBIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamFBIDFieldActionPerformed

    private void copyFBKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyFBKeyButtonActionPerformed
        new GetFacebookData().copy(streamYTKeyField.getText());
    }//GEN-LAST:event_copyFBKeyButtonActionPerformed

    private void copyFBIDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyFBIDButtonActionPerformed
        new GetFacebookData().copy(streamFBIDField.getText());
    }//GEN-LAST:event_copyFBIDButtonActionPerformed

    private void streamYTIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamYTIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamYTIDFieldActionPerformed

    private void streamFBKeyFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamFBKeyFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamFBKeyFieldActionPerformed

    private void copyYTKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyYTKeyButtonActionPerformed
        new GetFacebookData().copy(streamYTKeyField.getText());
    }//GEN-LAST:event_copyYTKeyButtonActionPerformed

    private void copyYTURLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyYTURLButtonActionPerformed
        new GetFacebookData().copy(streamYTURLField.getText());
    }//GEN-LAST:event_copyYTURLButtonActionPerformed

    private void streamYTURLFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamYTURLFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamYTURLFieldActionPerformed

    private void copyYTIDButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyYTIDButton1ActionPerformed
        new GetFacebookData().copy(streamYTIDField.getText());
    }//GEN-LAST:event_copyYTIDButton1ActionPerformed

    public void openMainWindow() {
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
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainWindow().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        opened = true;

        System.out.println("Opened Main Window");
    }
    
    public static void main(String args[]) {
        new MainWindow().openMainWindow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton copyFBIDButton;
    private javax.swing.JButton copyFBKeyButton;
    private javax.swing.JButton copyYTIDButton1;
    private javax.swing.JButton copyYTKeyButton;
    private javax.swing.JButton copyYTURLButton;
    private javax.swing.JButton createStreamButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel livestreamSettingsLabel;
    private javax.swing.JLabel mainWindowtitle;
    private javax.swing.JTextArea streamDescField;
    private javax.swing.JLabel streamDescLabel;
    private javax.swing.JLabel streamFBDataLabel;
    private javax.swing.JLabel streamFBID;
    private javax.swing.JTextField streamFBIDField;
    private javax.swing.JLabel streamFBKey;
    private javax.swing.JTextField streamFBKeyField;
    private javax.swing.JTextField streamTitleField;
    private javax.swing.JLabel streamTitleLabel;
    private javax.swing.JLabel streamYTDataLabel;
    private javax.swing.JLabel streamYTID;
    private javax.swing.JTextField streamYTIDField;
    private javax.swing.JLabel streamYTKey;
    private javax.swing.JTextField streamYTKeyField;
    private javax.swing.JLabel streamYTURL;
    private javax.swing.JTextField streamYTURLField;
    // End of variables declaration//GEN-END:variables
      
    public boolean getOpened() {
        return opened;
    }

    public void setData() {
        streamYTIDField.setText(new CreateYoutubeStream().getStreamID());
        streamYTURLField.setText(new CreateYoutubeStream().getStreamURL());
        streamYTKeyField.setText(new CreateYoutubeStream().getStreamKey());
    }

}

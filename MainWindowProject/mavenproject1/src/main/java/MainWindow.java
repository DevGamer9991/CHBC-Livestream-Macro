
import com.parker.CreateFacebookStream;
import com.parker.GetFacebookData;

public class MainWindow extends javax.swing.JFrame {
    
    public static boolean opened = false;

    /**
     * Creates new form TestFrame
     */
    public MainWindow() {
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

        mainWindowtitle = new javax.swing.JLabel();
        streamTitleLabel = new javax.swing.JLabel();
        streamTitleField = new javax.swing.JTextField();
        streamDescLabel = new javax.swing.JLabel();
        createStreamButton = new javax.swing.JButton();
        livestreamSettingsLabel = new javax.swing.JLabel();
        streamIDField = new javax.swing.JTextField();
        streamID = new javax.swing.JLabel();
        streamURL = new javax.swing.JLabel();
        streamURLField = new javax.swing.JTextField();
        streamDataLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        streamDescField = new javax.swing.JTextArea();
        welcomeLabel = new javax.swing.JLabel();
        copyURLButton = new javax.swing.JButton();
        copyIDButton = new javax.swing.JButton();

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
        livestreamSettingsLabel.setText("FB Stream Settings:");

        streamIDField.setEditable(false);
        streamIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamIDFieldActionPerformed(evt);
            }
        });

        streamID.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamID.setText("ID:");

        streamURL.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamURL.setText("RTMP URL:");

        streamURLField.setEditable(false);
        streamURLField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamURLFieldActionPerformed(evt);
            }
        });

        streamDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamDataLabel.setText("FB Stream Data:");

        streamDescField.setColumns(20);
        streamDescField.setLineWrap(true);
        streamDescField.setRows(5);
        jScrollPane1.setViewportView(streamDescField);

        welcomeLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome: Matt Crews");

        copyURLButton.setText("Copy URL");
        copyURLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyURLButtonActionPerformed(evt);
            }
        });

        copyIDButton.setText("Copy ID");
        copyIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyIDButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(streamDescLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(streamTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(livestreamSettingsLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(streamDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addComponent(copyIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(copyURLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streamURL)
                                    .addComponent(streamID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streamURLField)
                                    .addComponent(streamIDField)))
                            .addComponent(createStreamButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addComponent(welcomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(mainWindowtitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainWindowtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(livestreamSettingsLabel)
                        .addComponent(streamDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(copyURLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(copyIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(streamTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(streamID)
                        .addComponent(streamIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(streamURLField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(streamDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(streamURL)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createStreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void streamTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamTitleFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamTitleFieldActionPerformed

    private void createStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStreamButtonActionPerformed
        try {
            CreateFacebookStream streamCreator = new CreateFacebookStream();

            streamCreator.createStream(streamTitleField.getText(), streamDescField.getText(), "Capitol Hill Baptist");

            if (streamCreator.getStreamID() != null && streamCreator.getStreamURL() != null) {
                streamIDField.setText(streamCreator.getStreamID());
                streamURLField.setText(streamCreator.getStreamURL());
            }

            GetFacebookData facebookData = new GetFacebookData();

            facebookData.saveTitleAndDesc(streamTitleField.getText(), streamDescField.getText());

            createStreamButton.setEnabled(false);
            streamTitleField.setEnabled(false);
            streamDescField.setEnabled(false);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }//GEN-LAST:event_createStreamButtonActionPerformed

    private void streamURLFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamURLFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamURLFieldActionPerformed

    private void streamIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamIDFieldActionPerformed

    private void copyURLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyURLButtonActionPerformed
        new GetFacebookData().copy(streamURLField.getText());
    }//GEN-LAST:event_copyURLButtonActionPerformed

    private void copyIDButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyIDButtonActionPerformed
        new GetFacebookData().copy(streamIDField.getText());
    }//GEN-LAST:event_copyIDButtonActionPerformed

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
    private javax.swing.JButton copyIDButton;
    private javax.swing.JButton copyURLButton;
    private javax.swing.JButton createStreamButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel livestreamSettingsLabel;
    private javax.swing.JLabel mainWindowtitle;
    private javax.swing.JLabel streamDataLabel;
    private javax.swing.JTextArea streamDescField;
    private javax.swing.JLabel streamDescLabel;
    private javax.swing.JLabel streamID;
    private javax.swing.JTextField streamIDField;
    private javax.swing.JTextField streamTitleField;
    private javax.swing.JLabel streamTitleLabel;
    private javax.swing.JLabel streamURL;
    private javax.swing.JTextField streamURLField;
    private javax.swing.JLabel welcomeLabel;
    // End of variables declaration//GEN-END:variables
      
    public boolean getOpened() {
        return opened;
    }

    public String getStreamTitle() {
        return streamTitleField.getText();
    }

    public String getStreamDesc() {
        return streamDescField.getText();
    }

}

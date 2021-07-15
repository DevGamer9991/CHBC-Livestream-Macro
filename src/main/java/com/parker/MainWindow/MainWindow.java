package com.parker.MainWindow;

import com.parker.CreateFacebookStream;
import com.parker.GetFacebookData;

public class MainWindow extends javax.swing.JFrame {

    public javax.swing.JButton createStreamButton;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel livestreamSettingsLabel;
    public javax.swing.JLabel mainWindowtitle;
    public javax.swing.JLabel streamDataLabel;
    public javax.swing.JTextArea streamDescField;
    public javax.swing.JLabel streamDescLabel;
    public javax.swing.JLabel streamID;
    public javax.swing.JTextField streamIDField;
    public javax.swing.JTextField streamTitleField;
    public javax.swing.JLabel streamTitleLabel;
    public javax.swing.JLabel streamURL;
    public javax.swing.JTextField streamURLField;
    public javax.swing.JLabel welcomeLabel;

    /**
     * Creates new form TestFrame
     */
    public MainWindow() throws Exception {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() throws Exception {

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
        streamDataLabel.setText("Stream Data:");

        streamDescField.setColumns(20);
        streamDescField.setLineWrap(true);
        streamDescField.setRows(5);
        jScrollPane1.setViewportView(streamDescField);

        welcomeLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        welcomeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcomeLabel.setText("Welcome: " + new GetFacebookData().getName());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streamDescLabel)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(createStreamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(streamURL)
                                            .addComponent(streamID))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(streamIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                            .addComponent(streamURLField)))))
                            .addComponent(mainWindowtitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(welcomeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(streamTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(livestreamSettingsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(streamDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainWindowtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(welcomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(livestreamSettingsLabel)
                    .addComponent(streamDataLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(streamIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(streamID))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(streamTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streamURLField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamURL)
                    .addComponent(streamDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                    .addComponent(createStreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void streamTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void createStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        try {
            CreateFacebookStream streamCreator = new CreateFacebookStream();

            streamCreator.createStream(streamTitleField.getText(), streamDescField.getText(), "Capital Hill Baptist");

            if (streamCreator.getStreamID() != null && streamCreator.getStreamURL() != null) {
                streamIDField.setText(streamCreator.getStreamID());
                streamURLField.setText(streamCreator.getStreamURL());
            }

            createStreamButton.setEnabled(false);
            streamTitleField.setEnabled(false);
            streamDescField.setEnabled(false);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }                                                  

    private void streamURLFieldActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void streamIDFieldActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }

    public void openMainWindow() throws Exception{
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
                GetFacebookData facebookData = new GetFacebookData();
                try {
                    if (facebookData.getName() != null) {
                        welcomeLabel.setText(facebookData.getName());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    // Variables declaration - do not modify                     

    // End of variables declaration                   
}

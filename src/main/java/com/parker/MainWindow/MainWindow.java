package com.parker.MainWindow;

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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        mainWindowtitle = new javax.swing.JLabel();
        streamTitleLabel = new javax.swing.JLabel();
        streamTitleField = new javax.swing.JTextField();
        streamDescLabel = new javax.swing.JLabel();
        createStreamButton = new javax.swing.JButton();
        livestreamSettingsLabel = new javax.swing.JLabel();
        streamFBIDField = new javax.swing.JTextField();
        streamFBIDLabel = new javax.swing.JLabel();
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

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHBC Livestream Macro");
        setBackground(java.awt.Color.darkGray);
        setForeground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(58, 57, 58));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mainWindowtitle.setBackground(java.awt.Color.darkGray);
        mainWindowtitle.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        mainWindowtitle.setForeground(new java.awt.Color(255, 255, 255));
        mainWindowtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainWindowtitle.setText("CHBC Livestream Creator");

        streamTitleLabel.setBackground(java.awt.Color.darkGray);
        streamTitleLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamTitleLabel.setForeground(new java.awt.Color(255, 255, 255));
        streamTitleLabel.setText("Title:");

        streamTitleField.setText(new GetFacebookData().getTitle());
        streamTitleField.setBackground(java.awt.Color.gray);
        streamTitleField.setForeground(new java.awt.Color(255, 255, 255));
        streamTitleField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamTitleField.setSelectionColor(new java.awt.Color(204, 204, 204));
        streamTitleField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamTitleFieldActionPerformed(evt);
            }
        });

        streamDescLabel.setBackground(java.awt.Color.darkGray);
        streamDescLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamDescLabel.setForeground(new java.awt.Color(255, 255, 255));
        streamDescLabel.setText("Description:");

        createStreamButton.setBackground(new java.awt.Color(76, 76, 76));
        createStreamButton.setForeground(new java.awt.Color(255, 255, 255));
        createStreamButton.setText("Create Livestream");
        createStreamButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        createStreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStreamButtonActionPerformed(evt);
            }
        });

        livestreamSettingsLabel.setBackground(java.awt.Color.darkGray);
        livestreamSettingsLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        livestreamSettingsLabel.setForeground(new java.awt.Color(255, 255, 255));
        livestreamSettingsLabel.setText("Stream Settings:");

        streamFBIDField.setEditable(false);
        streamFBIDField.setBackground(java.awt.Color.gray);
        streamFBIDField.setForeground(new java.awt.Color(255, 255, 255));
        streamFBIDField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamFBIDField.setSelectionColor(new java.awt.Color(204, 204, 204));
        streamFBIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamFBIDFieldActionPerformed(evt);
            }
        });

        streamFBIDLabel.setBackground(java.awt.Color.darkGray);
        streamFBIDLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBIDLabel.setForeground(new java.awt.Color(255, 255, 255));
        streamFBIDLabel.setText("FB ID:");

        streamFBKey.setBackground(java.awt.Color.darkGray);
        streamFBKey.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBKey.setForeground(new java.awt.Color(255, 255, 255));
        streamFBKey.setText("FB Stream Key:");

        streamYTKeyField.setEditable(false);
        streamYTKeyField.setBackground(java.awt.Color.gray);
        streamYTKeyField.setForeground(new java.awt.Color(255, 255, 255));
        streamYTKeyField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamYTKeyField.setSelectionColor(new java.awt.Color(204, 204, 204));
        streamYTKeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamYTKeyFieldActionPerformed(evt);
            }
        });

        streamYTDataLabel.setBackground(java.awt.Color.darkGray);
        streamYTDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamYTDataLabel.setForeground(new java.awt.Color(255, 255, 255));
        streamYTDataLabel.setText("YT Stream Data:");

        jScrollPane1.setBackground(java.awt.Color.darkGray);
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));

        streamDescField.setText(new GetFacebookData().getDesc());
        streamDescField.setBackground(java.awt.Color.gray);
        streamDescField.setColumns(20);
        streamDescField.setForeground(new java.awt.Color(255, 255, 255));
        streamDescField.setLineWrap(true);
        streamDescField.setRows(5);
        streamDescField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamDescField.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(streamDescField);

        copyFBKeyButton.setBackground(new java.awt.Color(76, 76, 76));
        copyFBKeyButton.setForeground(new java.awt.Color(255, 255, 255));
        copyFBKeyButton.setText("Copy FB Key");
        copyFBKeyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        copyFBKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBKeyButtonActionPerformed(evt);
            }
        });

        copyFBIDButton.setBackground(new java.awt.Color(76, 76, 76));
        copyFBIDButton.setForeground(new java.awt.Color(255, 255, 255));
        copyFBIDButton.setText("Copy FB ID");
        copyFBIDButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        copyFBIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBIDButtonActionPerformed(evt);
            }
        });

        streamFBDataLabel.setBackground(java.awt.Color.darkGray);
        streamFBDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamFBDataLabel.setForeground(new java.awt.Color(255, 255, 255));
        streamFBDataLabel.setText("FB Stream Data:");

        streamYTKey.setBackground(java.awt.Color.darkGray);
        streamYTKey.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTKey.setForeground(new java.awt.Color(255, 255, 255));
        streamYTKey.setText("YT Stream Key:");

        streamYTID.setBackground(java.awt.Color.darkGray);
        streamYTID.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTID.setForeground(new java.awt.Color(255, 255, 255));
        streamYTID.setText("YT ID:");

        streamYTIDField.setEditable(false);
        streamYTIDField.setBackground(java.awt.Color.gray);
        streamYTIDField.setForeground(new java.awt.Color(255, 255, 255));
        streamYTIDField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamYTIDField.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        streamYTIDField.setSelectionColor(new java.awt.Color(204, 204, 204));
        streamYTIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamYTIDFieldActionPerformed(evt);
            }
        });

        streamFBKeyField.setEditable(false);
        streamFBKeyField.setBackground(java.awt.Color.gray);
        streamFBKeyField.setForeground(new java.awt.Color(255, 255, 255));
        streamFBKeyField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamFBKeyField.setSelectionColor(new java.awt.Color(204, 204, 204));
        streamFBKeyField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamFBKeyFieldActionPerformed(evt);
            }
        });

        copyYTKeyButton.setBackground(new java.awt.Color(76, 76, 76));
        copyYTKeyButton.setForeground(new java.awt.Color(255, 255, 255));
        copyYTKeyButton.setText("Copy YT Key");
        copyYTKeyButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        copyYTKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTKeyButtonActionPerformed(evt);
            }
        });

        copyYTURLButton.setBackground(new java.awt.Color(76, 76, 76));
        copyYTURLButton.setForeground(new java.awt.Color(255, 255, 255));
        copyYTURLButton.setText("Copy YT URL");
        copyYTURLButton.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        copyYTURLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTURLButtonActionPerformed(evt);
            }
        });

        streamYTURLField.setEditable(false);
        streamYTURLField.setBackground(java.awt.Color.gray);
        streamYTURLField.setForeground(new java.awt.Color(255, 255, 255));
        streamYTURLField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamYTURLField.setSelectionColor(new java.awt.Color(204, 204, 204));
        streamYTURLField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamYTURLFieldActionPerformed(evt);
            }
        });

        streamYTURL.setBackground(java.awt.Color.darkGray);
        streamYTURL.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTURL.setForeground(new java.awt.Color(255, 255, 255));
        streamYTURL.setText("YT Stream URL:");

        copyYTIDButton1.setBackground(new java.awt.Color(76, 76, 76));
        copyYTIDButton1.setForeground(new java.awt.Color(255, 255, 255));
        copyYTIDButton1.setText("Copy YT ID");
        copyYTIDButton1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        copyYTIDButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTIDButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(mainWindowtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createStreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamDescLabel)
                                                        .addComponent(livestreamSettingsLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(streamYTKey)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                                                                                                .addComponent(streamYTKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(streamYTURL)
                                                                                                        .addComponent(streamYTID))
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                        .addComponent(streamYTIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                                                                                        .addComponent(streamYTURLField))))
                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(streamFBKey)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(streamFBIDLabel)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)))
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(streamFBIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                        .addComponent(streamFBKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addGap(6, 6, 6)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(copyYTKeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                                                        .addComponent(copyYTIDButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                                                        .addComponent(copyYTURLButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(copyFBKeyButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(copyFBIDButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(streamFBDataLabel)
                                                                        .addComponent(streamYTDataLabel))
                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(streamTitleLabel)
                                                .addGap(12, 12, 12)
                                                .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mainWindowtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(livestreamSettingsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(copyFBIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamFBIDLabel)
                                                        .addComponent(streamFBIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(streamDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(streamFBKey)
                                                                .addComponent(streamFBKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(copyFBKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addComponent(streamFBDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(streamYTDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(streamYTID)
                                                        .addComponent(streamYTIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(copyYTIDButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(streamYTURL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamYTURLField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(copyYTURLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(streamYTKey)
                                                        .addComponent(streamYTKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(copyYTKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createStreamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, 0)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void streamTitleFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void createStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void streamYTKeyFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void streamFBIDFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void copyFBKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamYTKeyField.getText());
    }

    private void copyFBIDButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamFBIDField.getText());
    }

    private void streamYTIDFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void streamFBKeyFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void copyYTKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamYTKeyField.getText());
    }

    private void copyYTURLButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamYTURLField.getText());
    }

    private void streamYTURLFieldActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void copyYTIDButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamYTIDField.getText());
    }

    public void openMainWindow() {
//       /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>

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

    // Variables declaration - do not modify
    public javax.swing.JButton copyFBIDButton;
    public javax.swing.JButton copyFBKeyButton;
    public javax.swing.JButton copyYTIDButton1;
    public javax.swing.JButton copyYTKeyButton;
    public javax.swing.JButton copyYTURLButton;
    public javax.swing.JButton createStreamButton;
    public javax.swing.JComboBox<String> jComboBox1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel livestreamSettingsLabel;
    public javax.swing.JLabel mainWindowtitle;
    public javax.swing.JTextArea streamDescField;
    public javax.swing.JLabel streamDescLabel;
    public javax.swing.JLabel streamFBDataLabel;
    public javax.swing.JTextField streamFBIDField;
    public javax.swing.JLabel streamFBIDLabel;
    public javax.swing.JLabel streamFBKey;
    public javax.swing.JTextField streamFBKeyField;
    public javax.swing.JTextField streamTitleField;
    public javax.swing.JLabel streamTitleLabel;
    public javax.swing.JLabel streamYTDataLabel;
    public javax.swing.JLabel streamYTID;
    public javax.swing.JTextField streamYTIDField;
    public javax.swing.JLabel streamYTKey;
    public javax.swing.JTextField streamYTKeyField;
    public javax.swing.JLabel streamYTURL;
    public javax.swing.JTextField streamYTURLField;
    // End of variables declaration

    public boolean getOpened() {
        return opened;
    }

    public void setData() {
        streamYTIDField.setText(new CreateYoutubeStream().getStreamID());
        streamYTURLField.setText(new CreateYoutubeStream().getStreamURL());
        streamYTKeyField.setText(new CreateYoutubeStream().getStreamKey());
    }

}

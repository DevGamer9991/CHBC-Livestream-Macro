package com.parker.MainWindow;

import com.parker.CreateFacebookStream;
import com.parker.CreateYoutubeStream;
import com.parker.facebook.GetFacebookData;
import com.parker.youtube.ManageYoutubeData;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class MainWindow extends javax.swing.JFrame {

    public static boolean opened = false;

    public static Thread createStreamsThread;

    public static String pageName;
    public static String channelName;

    public MainWindow() {
        initComponents();

        if (pageName != null){
            setFBConnected(pageName);
        }

        if (channelName != null){
            setYTConnected(channelName);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        loadingDialog = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        loadingBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        errorDialog = new javax.swing.JDialog();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        errorTextArea = new javax.swing.JTextArea();
        errorOKButton = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        mainJPanel = new javax.swing.JPanel();
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
        FBConnected = new javax.swing.JButton();
        YTConnected = new javax.swing.JButton();
        streamFBIDLabel1 = new javax.swing.JLabel();
        streamFBIDLabel2 = new javax.swing.JLabel();

        loadingDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        loadingDialog.setTitle("Creating Livestreams");
        loadingDialog.setResizable(false);
        loadingDialog.setSize(new java.awt.Dimension(395, 152));
        loadingDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                loadingDialogWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(58, 57, 58));

        loadingBar.setBackground(new java.awt.Color(30, 29, 30));
        loadingBar.setForeground(new java.awt.Color(41, 128, 216));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Creating Livestreams");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(loadingBar, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                .addGap(69, 69, 69))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addGap(2, 2, 2)
                                .addComponent(loadingBar, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout loadingDialogLayout = new javax.swing.GroupLayout(loadingDialog.getContentPane());
        loadingDialog.getContentPane().setLayout(loadingDialogLayout);
        loadingDialogLayout.setHorizontalGroup(
                loadingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        loadingDialogLayout.setVerticalGroup(
                loadingDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        errorDialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        errorDialog.setTitle("Error Occurred");
        errorDialog.setName("Error Occurred"); // NOI18N
        errorDialog.setResizable(false);
        errorDialog.setSize(new java.awt.Dimension(474, 345));
        errorDialog.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                errorDialogWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                errorDialogWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(58, 57, 58));
        jPanel2.setForeground(new java.awt.Color(153, 153, 153));

        errorTextArea.setBackground(new java.awt.Color(30, 29, 30));
        errorTextArea.setColumns(20);
        errorTextArea.setForeground(new java.awt.Color(204, 204, 204));
        errorTextArea.setLineWrap(true);
        errorTextArea.setRows(5);
        errorTextArea.setCaretColor(new java.awt.Color(255, 255, 255));
        errorTextArea.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane2.setViewportView(errorTextArea);

        errorOKButton.setBackground(new java.awt.Color(76, 76, 76));
        errorOKButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        errorOKButton.setForeground(new java.awt.Color(204, 204, 204));
        errorOKButton.setText("OK");
        errorOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                errorOKButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(203, 203, 203)
                                                .addComponent(errorOKButton))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(29, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(errorOKButton)
                                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout errorDialogLayout = new javax.swing.GroupLayout(errorDialog.getContentPane());
        errorDialog.getContentPane().setLayout(errorDialogLayout);
        errorDialogLayout.setHorizontalGroup(
                errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        errorDialogLayout.setVerticalGroup(
                errorDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHBC Livestream Macro");
        setBackground(java.awt.Color.darkGray);
        setForeground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        mainJPanel.setBackground(new java.awt.Color(58, 57, 58));
        mainJPanel.setForeground(new java.awt.Color(153, 153, 153));
        mainJPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        mainWindowtitle.setBackground(java.awt.Color.darkGray);
        mainWindowtitle.setFont(new java.awt.Font("Ubuntu", 0, 36)); // NOI18N
        mainWindowtitle.setForeground(new java.awt.Color(204, 204, 204));
        mainWindowtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mainWindowtitle.setText("CHBC Livestream Macro");

        streamTitleLabel.setBackground(java.awt.Color.darkGray);
        streamTitleLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamTitleLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamTitleLabel.setText("Title:");

        //streamTitleField.setText(new GetFacebookData().getTitle());
        streamTitleField.setBackground(new java.awt.Color(30, 29, 30));
        streamTitleField.setForeground(new java.awt.Color(204, 204, 204));
        streamTitleField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamTitleField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamDescLabel.setBackground(java.awt.Color.darkGray);
        streamDescLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamDescLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamDescLabel.setText("Description:");

        createStreamButton.setBackground(new java.awt.Color(76, 76, 76));
        createStreamButton.setFont(createStreamButton.getFont().deriveFont(createStreamButton.getFont().getStyle() & ~java.awt.Font.BOLD, createStreamButton.getFont().getSize()+1));
        createStreamButton.setForeground(new java.awt.Color(204, 204, 204));
        createStreamButton.setText("Create Livestream");
        createStreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStreamButtonActionPerformed(evt);
            }
        });

        livestreamSettingsLabel.setBackground(java.awt.Color.darkGray);
        livestreamSettingsLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        livestreamSettingsLabel.setForeground(new java.awt.Color(204, 204, 204));
        livestreamSettingsLabel.setText("Stream Settings:");

        streamFBIDField.setEditable(false);
        streamFBIDField.setBackground(new java.awt.Color(30, 29, 30));
        streamFBIDField.setForeground(new java.awt.Color(204, 204, 204));
        streamFBIDField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamFBIDField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamFBIDLabel.setBackground(java.awt.Color.darkGray);
        streamFBIDLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBIDLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamFBIDLabel.setText("FB ID:");

        streamFBKey.setBackground(java.awt.Color.darkGray);
        streamFBKey.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBKey.setForeground(new java.awt.Color(204, 204, 204));
        streamFBKey.setText("FB Stream Key:");

        streamYTKeyField.setEditable(false);
        streamYTKeyField.setBackground(new java.awt.Color(30, 29, 30));
        streamYTKeyField.setForeground(new java.awt.Color(204, 204, 204));
        streamYTKeyField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamYTKeyField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamYTDataLabel.setBackground(java.awt.Color.darkGray);
        streamYTDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamYTDataLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamYTDataLabel.setText("YT Stream Data:");

        jScrollPane1.setBackground(java.awt.Color.darkGray);
        jScrollPane1.setForeground(new java.awt.Color(204, 204, 204));

        //streamDescField.setText(new GetFacebookData().getDesc());
        streamDescField.setBackground(new java.awt.Color(30, 29, 30));
        streamDescField.setColumns(20);
        streamDescField.setForeground(new java.awt.Color(204, 204, 204));
        streamDescField.setLineWrap(true);
        streamDescField.setRows(5);
        streamDescField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamDescField.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(streamDescField);

        copyFBKeyButton.setBackground(new java.awt.Color(76, 76, 76));
        copyFBKeyButton.setFont(copyFBKeyButton.getFont().deriveFont(copyFBKeyButton.getFont().getStyle() & ~java.awt.Font.BOLD, copyFBKeyButton.getFont().getSize()+1));
        copyFBKeyButton.setForeground(new java.awt.Color(204, 204, 204));
        copyFBKeyButton.setText("Copy FB Key");
        copyFBKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBKeyButtonActionPerformed(evt);
            }
        });

        copyFBIDButton.setBackground(new java.awt.Color(76, 76, 76));
        copyFBIDButton.setFont(copyFBIDButton.getFont().deriveFont(copyFBIDButton.getFont().getStyle() & ~java.awt.Font.BOLD, copyFBIDButton.getFont().getSize()+1));
        copyFBIDButton.setForeground(new java.awt.Color(204, 204, 204));
        copyFBIDButton.setText("Copy FB ID");
        copyFBIDButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBIDButtonActionPerformed(evt);
            }
        });

        streamFBDataLabel.setBackground(java.awt.Color.darkGray);
        streamFBDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamFBDataLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamFBDataLabel.setText("FB Stream Data:");

        streamYTKey.setBackground(java.awt.Color.darkGray);
        streamYTKey.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTKey.setForeground(new java.awt.Color(204, 204, 204));
        streamYTKey.setText("YT Stream Key:");

        streamYTID.setBackground(java.awt.Color.darkGray);
        streamYTID.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTID.setForeground(new java.awt.Color(204, 204, 204));
        streamYTID.setText("YT ID:");

        streamYTIDField.setEditable(false);
        streamYTIDField.setBackground(new java.awt.Color(30, 29, 30));
        streamYTIDField.setForeground(new java.awt.Color(204, 204, 204));
        streamYTIDField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamYTIDField.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        streamYTIDField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamFBKeyField.setEditable(false);
        streamFBKeyField.setBackground(new java.awt.Color(30, 29, 30));
        streamFBKeyField.setForeground(new java.awt.Color(204, 204, 204));
        streamFBKeyField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamFBKeyField.setSelectionColor(new java.awt.Color(204, 204, 204));

        copyYTKeyButton.setBackground(new java.awt.Color(76, 76, 76));
        copyYTKeyButton.setFont(copyYTKeyButton.getFont().deriveFont(copyYTKeyButton.getFont().getStyle() & ~java.awt.Font.BOLD, copyYTKeyButton.getFont().getSize()+1));
        copyYTKeyButton.setForeground(new java.awt.Color(204, 204, 204));
        copyYTKeyButton.setText("Copy YT Key");
        copyYTKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTKeyButtonActionPerformed(evt);
            }
        });

        copyYTURLButton.setBackground(new java.awt.Color(76, 76, 76));
        copyYTURLButton.setFont(copyYTURLButton.getFont().deriveFont(copyYTURLButton.getFont().getStyle() & ~java.awt.Font.BOLD, copyYTURLButton.getFont().getSize()+1));
        copyYTURLButton.setForeground(new java.awt.Color(204, 204, 204));
        copyYTURLButton.setText("Copy YT URL");
        copyYTURLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTURLButtonActionPerformed(evt);
            }
        });

        streamYTURLField.setEditable(false);
        streamYTURLField.setBackground(new java.awt.Color(30, 29, 30));
        streamYTURLField.setForeground(new java.awt.Color(204, 204, 204));
        streamYTURLField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamYTURLField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamYTURL.setBackground(java.awt.Color.darkGray);
        streamYTURL.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTURL.setForeground(new java.awt.Color(204, 204, 204));
        streamYTURL.setText("YT Stream URL:");

        copyYTIDButton1.setBackground(new java.awt.Color(76, 76, 76));
        copyYTIDButton1.setFont(copyYTIDButton1.getFont().deriveFont(copyYTIDButton1.getFont().getStyle() & ~java.awt.Font.BOLD, copyYTIDButton1.getFont().getSize()+1));
        copyYTIDButton1.setForeground(new java.awt.Color(204, 204, 204));
        copyYTIDButton1.setText("Copy YT ID");
        copyYTIDButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTIDButton1ActionPerformed(evt);
            }
        });

        FBConnected.setBackground(new java.awt.Color(76, 76, 76));
        FBConnected.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        FBConnected.setForeground(new java.awt.Color(204, 204, 204));
        FBConnected.setText("FB Not Connected");

        YTConnected.setBackground(new java.awt.Color(76, 76, 76));
        YTConnected.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        YTConnected.setForeground(new java.awt.Color(204, 204, 204));
        YTConnected.setText("YT Not Connected");
        YTConnected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YTConnectedActionPerformed(evt);
            }
        });

        streamFBIDLabel1.setBackground(java.awt.Color.darkGray);
        streamFBIDLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBIDLabel1.setForeground(new java.awt.Color(204, 204, 204));
        streamFBIDLabel1.setText("FB:");

        streamFBIDLabel2.setBackground(java.awt.Color.darkGray);
        streamFBIDLabel2.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBIDLabel2.setForeground(new java.awt.Color(204, 204, 204));
        streamFBIDLabel2.setText("YT:");

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
                mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createStreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamDescLabel)
                                                        .addComponent(livestreamSettingsLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                                                .addComponent(streamFBKey)
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(streamFBKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addComponent(streamFBIDField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(copyFBKeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(copyFBIDButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(streamYTDataLabel)
                                                                        .addComponent(streamFBDataLabel)
                                                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                                                .addGap(185, 185, 185)
                                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(streamFBIDLabel1)
                                                                                        .addComponent(streamFBIDLabel2)))
                                                                        .addComponent(streamYTURL))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(FBConnected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(YTConnected, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(streamYTKey)
                                                                        .addComponent(streamYTID))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(streamYTIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(streamYTURLField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(streamYTKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(copyYTKeyButton, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                                                        .addComponent(copyYTURLButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(copyYTIDButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                                .addComponent(streamTitleLabel)
                                                                .addGap(12, 12, 12)
                                                                .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(streamFBIDLabel))
                                                        .addComponent(mainWindowtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        mainJPanelLayout.setVerticalGroup(
                mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addContainerGap(15, Short.MAX_VALUE)
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(FBConnected)
                                                        .addComponent(streamFBIDLabel1))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(YTConnected)
                                                        .addComponent(streamFBIDLabel2)))
                                        .addComponent(mainWindowtitle, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addComponent(livestreamSettingsLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(streamFBIDField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamFBIDLabel)
                                                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(streamTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(copyFBIDButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addComponent(streamFBDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(43, 43, 43)))
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(streamDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(streamFBKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(copyFBKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamFBKey))))
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(mainJPanelLayout.createSequentialGroup()
                                                .addComponent(streamYTDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(streamYTID)
                                                        .addComponent(streamYTIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(copyYTIDButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(streamYTURL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(streamYTURLField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(copyYTURLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
                                .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void createStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {
        loadingBar.setValue(0);
        pack();

        setDialogData(loadingDialog, true);

        set(false);

        createStreamsThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    new CreateYoutubeStream().createYoutubeStream(streamTitleField.getText(), streamDescField.getText());

                    setLoadingBar(16);

                    CreateFacebookStream fbStreamCreator = new CreateFacebookStream();

                    fbStreamCreator.createStream(streamTitleField.getText(), streamDescField.getText(), "Capitol Hill Baptist");

                    setLoadingBar(32);

                    if (fbStreamCreator.getStreamID() != null && fbStreamCreator.getStreamURL() != null) {
                        streamFBIDField.setText(fbStreamCreator.getStreamID());
                        streamFBKeyField.setText(fbStreamCreator.getStreamURL());
                    }

                    setLoadingBar(48);

                    GetFacebookData facebookData = new GetFacebookData();

                    facebookData.saveTitleAndDesc(streamTitleField.getText(), streamDescField.getText());

                    setLoadingBar(64);

                    System.out.println(new ManageYoutubeData().getBroadcastID());
                    System.out.println(new ManageYoutubeData().getStreamID());
                    System.out.println(new ManageYoutubeData().getStreamURL());
                    System.out.println(new ManageYoutubeData().getStreamKey());

                    setLoadingBar(80);

                    streamYTIDField.setText(new ManageYoutubeData().getStreamID());
                    streamYTURLField.setText(new ManageYoutubeData().getStreamURL());
                    streamYTKeyField.setText(new ManageYoutubeData().getStreamKey());

                    setLoadingBar(96);

                    createStreamButton.setEnabled(false);
                    streamTitleField.setEnabled(false);
                    streamDescField.setEnabled(false);

                    setLoadingBar(100);

                    loadingDialog.setVisible(false);

                    set(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        createStreamsThread.start();
    }

    private void copyFBKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamFBKeyField.getText());
    }

    private void copyFBIDButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamFBIDField.getText());
    }

    private void copyYTKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamYTKeyField.getText());
    }

    private void copyYTURLButtonActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamYTURLField.getText());
    }

    private void copyYTIDButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        new GetFacebookData().copy(streamYTIDField.getText());
    }

    private void errorOKButtonActionPerformed(java.awt.event.ActionEvent evt) {
        errorDialog.setVisible(false);
    }

    private void loadingDialogWindowClosed(java.awt.event.WindowEvent evt) {
        createStreamsThread.stop();

        set(true);
    }

    private void errorDialogWindowClosed(java.awt.event.WindowEvent evt) {
        set(true);
        loadingDialog.dispose();
    }

    private void errorDialogWindowOpened(java.awt.event.WindowEvent evt) {

    }

    private void YTConnectedActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void openMainWindow() {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

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
    public javax.swing.JButton FBConnected;
    public javax.swing.JButton YTConnected;
    public javax.swing.JButton copyFBIDButton;
    public javax.swing.JButton copyFBKeyButton;
    public javax.swing.JButton copyYTIDButton1;
    public javax.swing.JButton copyYTKeyButton;
    public javax.swing.JButton copyYTURLButton;
    public javax.swing.JButton createStreamButton;
    public javax.swing.JDialog errorDialog;
    public javax.swing.JButton errorOKButton;
    public javax.swing.JTextArea errorTextArea;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    public javax.swing.JRadioButton jRadioButton1;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel livestreamSettingsLabel;
    public javax.swing.JProgressBar loadingBar;
    public javax.swing.JDialog loadingDialog;
    public javax.swing.JPanel mainJPanel;
    public javax.swing.JLabel mainWindowtitle;
    public javax.swing.JTextArea streamDescField;
    public javax.swing.JLabel streamDescLabel;
    public javax.swing.JLabel streamFBDataLabel;
    public javax.swing.JTextField streamFBIDField;
    public javax.swing.JLabel streamFBIDLabel;
    public javax.swing.JLabel streamFBIDLabel1;
    public javax.swing.JLabel streamFBIDLabel2;
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

    public void set(boolean bool) {
        this.setEnabled(bool);
        this.setFocusable(bool);
        this.setFocusableWindowState(bool);
    }

    public void setLoadingBar(int i) {
        loadingBar.setValue(i);
    }

    public void setDialogData(JDialog jdialog, boolean bool) {
        jdialog.setLocationRelativeTo(mainJPanel);
        jdialog.setAlwaysOnTop(bool);
        jdialog.setVisible(bool);
    }

    public void setErrorData(String error) {
        loadingDialog.dispose();

        errorTextArea.setText(error);
        pack();
    }

    public void errorCalled(String error) {
        set(false);

        setErrorData(error);

        errorDialog.setLocationRelativeTo(jPanel2);
        errorDialog.setAlwaysOnTop(true);
        errorDialog.setVisible(true);

        createStreamsThread.stop();
    }

    public void setFBConnected(String pageName) {
        FBConnected.setEnabled(false);
        FBConnected.setText("FB Connected With: " + pageName);
        pack();
    }

    public void setYTConnected(String channelName) {
        YTConnected.setEnabled(false);
        YTConnected.setText("YT Connected With: " + channelName);
        pack();
    }

    public void setYTName(String name) {
        channelName = name;
    }

    public void setFBName(String name) {
        pageName = name;
    }
}

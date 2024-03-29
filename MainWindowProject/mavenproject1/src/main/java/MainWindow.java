
import com.parker.CreateFacebookStream;
import com.parker.CreateYoutubeStream;
import com.parker.HTTPSServer;
import com.parker.HTTPSServerThread;
import com.parker.Logger;
import com.parker.facebook.GetFacebookData;
import com.parker.youtube.ManageYoutubeData;
import java.awt.Color;
import java.util.logging.Level;
import javax.swing.JDialog;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;

public class MainWindow extends javax.swing.JFrame {

    public static boolean opened = false;

    public static Thread createStreamsThread = new Thread();

    public static String pageName;
    public static String channelName;

    public static boolean streamFBBoxbool;
    public static boolean streamYTBoxbool;

    public static MainWindow INSTANCE;

    public MainWindow() throws Exception {

        INSTANCE = this;

        initComponents();

        setStreamTitleField();
        setStreamDescField();

        streamToFBBox.setSelected(new GetFacebookData().checkStreamFBBox());
        streamToYTBox.setSelected(new GetFacebookData().checkStreamYTBox());

        setFBConnected();
        setYTConnected();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        mainJPanel = new javax.swing.JPanel();
        mainWindowtitle = new javax.swing.JLabel();
        streamTitleLabel = new javax.swing.JLabel();
        streamTitleField = new javax.swing.JTextField();
        streamDescLabel = new javax.swing.JLabel();
        createStreamButton = new javax.swing.JButton();
        livestreamSettingsLabel = new javax.swing.JLabel();
        streamFBUrlField = new javax.swing.JTextField();
        streamFBIDLabel = new javax.swing.JLabel();
        streamFBKey = new javax.swing.JLabel();
        streamYTKeyField = new javax.swing.JTextField();
        streamYTDataLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        streamDescField = new javax.swing.JTextArea();
        copyFBKeyButton = new javax.swing.JButton();
        copyFBUrlButton = new javax.swing.JButton();
        streamFBDataLabel = new javax.swing.JLabel();
        streamYTKey = new javax.swing.JLabel();
        streamYTID = new javax.swing.JLabel();
        streamYTIDField = new javax.swing.JTextField();
        streamFBKeyField = new javax.swing.JTextField();
        copyYTKeyButton = new javax.swing.JButton();
        copyYTURLButton = new javax.swing.JButton();
        streamYTURLField = new javax.swing.JTextField();
        copyYTIDButton1 = new javax.swing.JButton();
        FBConnected = new javax.swing.JButton();
        YTConnected = new javax.swing.JButton();
        streamFBIDLabel1 = new javax.swing.JLabel();
        YTConnectedLabel = new javax.swing.JLabel();
        streamToFBBox = new javax.swing.JCheckBox();
        streamToYTBox = new javax.swing.JCheckBox();
        streamYTURL = new javax.swing.JLabel();

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
        errorOKButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        errorOKButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                errorOKButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                errorOKButtonMouseExited(evt);
            }
        });
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
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(errorOKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(205, 205, 205))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorOKButton)
                .addContainerGap())
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHBC Livestream Macro");
        setBackground(java.awt.Color.darkGray);
        setForeground(new java.awt.Color(153, 153, 153));
        setResizable(false);

        mainJPanel.setBackground(new java.awt.Color(76, 76, 76));
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

        streamTitleField.setBackground(new java.awt.Color(30, 29, 30));
        streamTitleField.setForeground(new java.awt.Color(204, 204, 204));
        streamTitleField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        streamTitleField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamTitleField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamDescLabel.setBackground(java.awt.Color.darkGray);
        streamDescLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamDescLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamDescLabel.setText("Description:");

        createStreamButton.setBackground(new java.awt.Color(58, 57, 58));
        createStreamButton.setFont(createStreamButton.getFont().deriveFont(createStreamButton.getFont().getStyle() & ~java.awt.Font.BOLD));
        createStreamButton.setForeground(new java.awt.Color(204, 204, 204));
        createStreamButton.setText("Create Livestream");
        createStreamButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        createStreamButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                createStreamButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                createStreamButtonMouseExited(evt);
            }
        });
        createStreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createStreamButtonActionPerformed(evt);
            }
        });

        livestreamSettingsLabel.setBackground(java.awt.Color.darkGray);
        livestreamSettingsLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        livestreamSettingsLabel.setForeground(new java.awt.Color(204, 204, 204));
        livestreamSettingsLabel.setText("Stream Settings:");

        streamFBUrlField.setEditable(false);
        streamFBUrlField.setBackground(new java.awt.Color(30, 29, 30));
        streamFBUrlField.setForeground(new java.awt.Color(204, 204, 204));
        streamFBUrlField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        streamFBUrlField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamFBUrlField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        streamFBUrlField.setSelectionColor(new java.awt.Color(204, 204, 204));
        streamFBUrlField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                streamFBUrlFieldActionPerformed(evt);
            }
        });

        streamFBIDLabel.setBackground(java.awt.Color.darkGray);
        streamFBIDLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBIDLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamFBIDLabel.setText("FB Url:");

        streamFBKey.setBackground(java.awt.Color.darkGray);
        streamFBKey.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBKey.setForeground(new java.awt.Color(204, 204, 204));
        streamFBKey.setText("FB Stream Key:");

        streamYTKeyField.setEditable(false);
        streamYTKeyField.setBackground(new java.awt.Color(30, 29, 30));
        streamYTKeyField.setForeground(new java.awt.Color(204, 204, 204));
        streamYTKeyField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        streamYTKeyField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamYTKeyField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        streamYTKeyField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamYTDataLabel.setBackground(java.awt.Color.darkGray);
        streamYTDataLabel.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        streamYTDataLabel.setForeground(new java.awt.Color(204, 204, 204));
        streamYTDataLabel.setText("YT Stream Data:");

        jScrollPane1.setBackground(java.awt.Color.darkGray);
        jScrollPane1.setForeground(new java.awt.Color(204, 204, 204));

        streamDescField.setBackground(new java.awt.Color(30, 29, 30));
        streamDescField.setColumns(20);
        streamDescField.setForeground(new java.awt.Color(204, 204, 204));
        streamDescField.setLineWrap(true);
        streamDescField.setRows(5);
        streamDescField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        streamDescField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamDescField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        streamDescField.setSelectionColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(streamDescField);

        copyFBKeyButton.setBackground(new java.awt.Color(58, 57, 58));
        copyFBKeyButton.setFont(copyFBKeyButton.getFont().deriveFont(copyFBKeyButton.getFont().getStyle() & ~java.awt.Font.BOLD));
        copyFBKeyButton.setForeground(new java.awt.Color(204, 204, 204));
        copyFBKeyButton.setText("Copy FB Key");
        copyFBKeyButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        copyFBKeyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyFBKeyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyFBKeyButtonMouseExited(evt);
            }
        });
        copyFBKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBKeyButtonActionPerformed(evt);
            }
        });

        copyFBUrlButton.setBackground(new java.awt.Color(58, 57, 58));
        copyFBUrlButton.setFont(copyFBUrlButton.getFont().deriveFont(copyFBUrlButton.getFont().getStyle() & ~java.awt.Font.BOLD));
        copyFBUrlButton.setForeground(new java.awt.Color(204, 204, 204));
        copyFBUrlButton.setText("Copy FB Url");
        copyFBUrlButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        copyFBUrlButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyFBUrlButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyFBUrlButtonMouseExited(evt);
            }
        });
        copyFBUrlButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyFBUrlButtonActionPerformed(evt);
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
        streamYTIDField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        streamYTIDField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamYTIDField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        streamYTIDField.setSelectedTextColor(new java.awt.Color(204, 204, 204));
        streamYTIDField.setSelectionColor(new java.awt.Color(204, 204, 204));

        streamFBKeyField.setEditable(false);
        streamFBKeyField.setBackground(new java.awt.Color(30, 29, 30));
        streamFBKeyField.setForeground(new java.awt.Color(204, 204, 204));
        streamFBKeyField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        streamFBKeyField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamFBKeyField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        streamFBKeyField.setSelectionColor(new java.awt.Color(204, 204, 204));

        copyYTKeyButton.setBackground(new java.awt.Color(58, 57, 58));
        copyYTKeyButton.setFont(copyYTKeyButton.getFont().deriveFont(copyYTKeyButton.getFont().getStyle() & ~java.awt.Font.BOLD));
        copyYTKeyButton.setForeground(new java.awt.Color(204, 204, 204));
        copyYTKeyButton.setText("Copy YT Key");
        copyYTKeyButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        copyYTKeyButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyYTKeyButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyYTKeyButtonMouseExited(evt);
            }
        });
        copyYTKeyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTKeyButtonActionPerformed(evt);
            }
        });

        copyYTURLButton.setBackground(new java.awt.Color(58, 57, 58));
        copyYTURLButton.setFont(copyYTURLButton.getFont().deriveFont(copyYTURLButton.getFont().getStyle() & ~java.awt.Font.BOLD));
        copyYTURLButton.setForeground(new java.awt.Color(204, 204, 204));
        copyYTURLButton.setText("Copy YT URL");
        copyYTURLButton.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        copyYTURLButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyYTURLButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyYTURLButtonMouseExited(evt);
            }
        });
        copyYTURLButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTURLButtonActionPerformed(evt);
            }
        });

        streamYTURLField.setEditable(false);
        streamYTURLField.setBackground(new java.awt.Color(30, 29, 30));
        streamYTURLField.setForeground(new java.awt.Color(204, 204, 204));
        streamYTURLField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        streamYTURLField.setCaretColor(new java.awt.Color(255, 255, 255));
        streamYTURLField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        streamYTURLField.setSelectionColor(new java.awt.Color(204, 204, 204));

        copyYTIDButton1.setBackground(new java.awt.Color(58, 57, 58));
        copyYTIDButton1.setFont(copyYTIDButton1.getFont().deriveFont(copyYTIDButton1.getFont().getStyle() & ~java.awt.Font.BOLD));
        copyYTIDButton1.setForeground(new java.awt.Color(204, 204, 204));
        copyYTIDButton1.setText("Copy YT ID");
        copyYTIDButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        copyYTIDButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                copyYTIDButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                copyYTIDButton1MouseExited(evt);
            }
        });
        copyYTIDButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyYTIDButton1ActionPerformed(evt);
            }
        });

        FBConnected.setBackground(new java.awt.Color(58, 57, 58));
        FBConnected.setFont(FBConnected.getFont().deriveFont(FBConnected.getFont().getStyle() & ~java.awt.Font.BOLD));
        FBConnected.setForeground(new java.awt.Color(204, 204, 204));
        FBConnected.setText("FB Not Connected");
        FBConnected.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        FBConnected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                FBConnectedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                FBConnectedMouseExited(evt);
            }
        });
        FBConnected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FBConnectedActionPerformed(evt);
            }
        });

        YTConnected.setBackground(new java.awt.Color(58, 57, 58));
        YTConnected.setFont(YTConnected.getFont().deriveFont(YTConnected.getFont().getStyle() & ~java.awt.Font.BOLD));
        YTConnected.setForeground(new java.awt.Color(204, 204, 204));
        YTConnected.setText("YT Not Connected");
        YTConnected.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        YTConnected.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                YTConnectedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                YTConnectedMouseExited(evt);
            }
        });
        YTConnected.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                YTConnectedActionPerformed(evt);
            }
        });

        streamFBIDLabel1.setBackground(java.awt.Color.darkGray);
        streamFBIDLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamFBIDLabel1.setForeground(new java.awt.Color(204, 204, 204));
        streamFBIDLabel1.setText("FB:");

        YTConnectedLabel.setBackground(java.awt.Color.darkGray);
        YTConnectedLabel.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        YTConnectedLabel.setForeground(new java.awt.Color(204, 204, 204));
        YTConnectedLabel.setText("YT:");

        streamToFBBox.setBackground(new java.awt.Color(76, 76, 76));
        streamToFBBox.setFont(streamToFBBox.getFont());
        streamToFBBox.setForeground(new java.awt.Color(204, 204, 204));
        streamToFBBox.setText("Stream to FB");

        streamToYTBox.setBackground(new java.awt.Color(76, 76, 76));
        streamToYTBox.setFont(streamToYTBox.getFont());
        streamToYTBox.setForeground(new java.awt.Color(204, 204, 204));
        streamToYTBox.setText("Stream to YT");

        streamYTURL.setBackground(java.awt.Color.darkGray);
        streamYTURL.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        streamYTURL.setForeground(new java.awt.Color(204, 204, 204));
        streamYTURL.setText("YT Stream URL:");

        javax.swing.GroupLayout mainJPanelLayout = new javax.swing.GroupLayout(mainJPanel);
        mainJPanel.setLayout(mainJPanelLayout);
        mainJPanelLayout.setHorizontalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(createStreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(streamFBIDLabel1)
                                    .addComponent(YTConnectedLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(YTConnected, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(FBConnected, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainJPanelLayout.createSequentialGroup()
                                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(streamYTID)
                                            .addComponent(streamYTKey))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainJPanelLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(streamYTURL)
                                        .addGap(226, 226, 226)))
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(copyYTKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(copyYTURLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(streamYTDataLabel)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(mainJPanelLayout.createSequentialGroup()
                                        .addComponent(streamTitleLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(streamDescLabel))
                                .addGap(18, 18, 18)
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streamFBIDLabel)
                                    .addComponent(streamFBKey))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainJPanelLayout.createSequentialGroup()
                                        .addComponent(streamFBUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(copyFBUrlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainJPanelLayout.createSequentialGroup()
                                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(streamYTIDField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                            .addComponent(streamYTURLField, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                            .addComponent(streamYTKeyField))
                                        .addGap(18, 18, 18)
                                        .addComponent(copyYTIDButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(mainJPanelLayout.createSequentialGroup()
                                        .addComponent(streamFBKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(copyFBKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(livestreamSettingsLabel)
                                .addGap(86, 86, 86)
                                .addComponent(streamFBDataLabel))
                            .addGroup(mainJPanelLayout.createSequentialGroup()
                                .addComponent(mainWindowtitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(streamToYTBox)
                                    .addComponent(streamToFBBox))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        mainJPanelLayout.setVerticalGroup(
            mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(FBConnected, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streamFBIDLabel1)
                            .addComponent(streamToFBBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(YTConnected, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(YTConnectedLabel)
                            .addComponent(streamToYTBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(mainWindowtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streamFBDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(livestreamSettingsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streamTitleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamFBIDLabel)
                    .addComponent(copyFBUrlButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streamFBUrlField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(copyFBKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streamDescLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streamFBKey)
                            .addComponent(streamFBKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainJPanelLayout.createSequentialGroup()
                        .addComponent(streamYTDataLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streamYTID)
                            .addComponent(streamYTIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyYTIDButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streamYTURLField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyYTURLButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(streamYTURL, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(streamYTKey)
                            .addComponent(streamYTKeyField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(copyYTKeyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(createStreamButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
    }// </editor-fold>//GEN-END:initComponents

    private void errorOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_errorOKButtonActionPerformed
        errorDialog.setVisible(false);
    }//GEN-LAST:event_errorOKButtonActionPerformed

    private void loadingDialogWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_loadingDialogWindowClosed
        createStreamsThread.stop();

        set(true);
    }//GEN-LAST:event_loadingDialogWindowClosed

    private void errorDialogWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_errorDialogWindowClosed
        set(true);
        loadingDialog.dispose();
    }//GEN-LAST:event_errorDialogWindowClosed

    private void errorDialogWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_errorDialogWindowOpened

    }//GEN-LAST:event_errorDialogWindowOpened

    private void errorOKButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorOKButtonMouseEntered
        buttonHover(errorOKButton);
    }//GEN-LAST:event_errorOKButtonMouseEntered

    private void errorOKButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_errorOKButtonMouseExited
        buttonUnHover(errorOKButton);
    }//GEN-LAST:event_errorOKButtonMouseExited

    private void copyFBUrlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyFBUrlButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_copyFBUrlButtonActionPerformed

    private void copyFBUrlButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyFBUrlButtonMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_copyFBUrlButtonMouseExited

    private void copyFBUrlButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyFBUrlButtonMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_copyFBUrlButtonMouseEntered

    private void YTConnectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_YTConnectedActionPerformed
        HTTPSServerThread.loginOpened = false;
        new HTTPSServer().startServer();
    }//GEN-LAST:event_YTConnectedActionPerformed

    private void YTConnectedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTConnectedMouseExited
        buttonUnHover(YTConnected);
    }//GEN-LAST:event_YTConnectedMouseExited

    private void YTConnectedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_YTConnectedMouseEntered
        buttonHover(YTConnected);
    }//GEN-LAST:event_YTConnectedMouseEntered

    private void FBConnectedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FBConnectedActionPerformed
        HTTPSServerThread.loginOpened = false;
        new HTTPSServer().startServer();
    }//GEN-LAST:event_FBConnectedActionPerformed

    private void FBConnectedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FBConnectedMouseExited
        buttonUnHover(FBConnected);
    }//GEN-LAST:event_FBConnectedMouseExited

    private void FBConnectedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FBConnectedMouseEntered
        buttonHover(FBConnected);
    }//GEN-LAST:event_FBConnectedMouseEntered

    private void copyYTIDButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyYTIDButton1ActionPerformed
        new GetFacebookData().copy(streamYTIDField.getText());
    }//GEN-LAST:event_copyYTIDButton1ActionPerformed

    private void copyYTIDButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyYTIDButton1MouseExited
        buttonUnHover(copyYTIDButton1);
    }//GEN-LAST:event_copyYTIDButton1MouseExited

    private void copyYTIDButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyYTIDButton1MouseEntered
        buttonHover(copyYTIDButton1);
    }//GEN-LAST:event_copyYTIDButton1MouseEntered

    private void copyYTURLButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyYTURLButtonActionPerformed
        new GetFacebookData().copy(streamYTURLField.getText());
    }//GEN-LAST:event_copyYTURLButtonActionPerformed

    private void copyYTURLButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyYTURLButtonMouseExited
        buttonUnHover(copyYTURLButton);
    }//GEN-LAST:event_copyYTURLButtonMouseExited

    private void copyYTURLButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyYTURLButtonMouseEntered
        buttonHover(copyYTURLButton);
    }//GEN-LAST:event_copyYTURLButtonMouseEntered

    private void copyYTKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyYTKeyButtonActionPerformed
        new GetFacebookData().copy(streamYTKeyField.getText());
    }//GEN-LAST:event_copyYTKeyButtonActionPerformed

    private void copyYTKeyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyYTKeyButtonMouseExited
        buttonUnHover(copyYTKeyButton);
    }//GEN-LAST:event_copyYTKeyButtonMouseExited

    private void copyYTKeyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyYTKeyButtonMouseEntered
        buttonHover(copyYTKeyButton);
    }//GEN-LAST:event_copyYTKeyButtonMouseEntered

    private void copyFBUrlButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyFBIDButtonActionPerformed
        new GetFacebookData().copy(streamFBIDField.getText());
    }//GEN-LAST:event_copyFBIDButtonActionPerformed

    private void copyFBUrlButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyFBIDButtonMouseExited
        buttonUnHover(copyFBUrlButton);
    }//GEN-LAST:event_copyFBIDButtonMouseExited

    private void copyFBUrlButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyFBIDButtonMouseEntered
        buttonHover(copyFBUrlButton);
    }//GEN-LAST:event_copyFBIDButtonMouseEntered

    private void copyFBKeyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyFBKeyButtonActionPerformed
        new GetFacebookData().copy(streamFBKeyField.getText());
    }//GEN-LAST:event_copyFBKeyButtonActionPerformed

    private void copyFBKeyButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyFBKeyButtonMouseExited
        buttonUnHover(copyFBKeyButton);
    }//GEN-LAST:event_copyFBKeyButtonMouseExited

    private void copyFBKeyButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_copyFBKeyButtonMouseEntered
        buttonHover(copyFBKeyButton);
    }//GEN-LAST:event_copyFBKeyButtonMouseEntered

    private void createStreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createStreamButtonActionPerformed
        loadingBar.setValue(0);
        pack();

        setDialogData(loadingDialog, true);

        set(false);

        createStreamsThread = new Thread(new Runnable() {
            int loadingProgress = 0;

            @Override
            public void run() {
                Logger.println("FB: " + streamToFBBox.isSelected());
                Logger.println("YT: " + streamToYTBox.isSelected());
                new GetFacebookData().saveStreamBoxes(streamToFBBox.isSelected(), streamToYTBox.isSelected());
                try {
                    if (streamToYTBox.isSelected()) {
                        new CreateYoutubeStream().createYoutubeStream(streamTitleField.getText(), streamDescField.getText());

                        streamYTIDField.setText(new ManageYoutubeData().getStreamID());
                        streamYTURLField.setText(new ManageYoutubeData().getStreamURL());
                        streamYTKeyField.setText(new ManageYoutubeData().getStreamKey());
                    }

                    setLoadingBar(25);

                    if(streamToFBBox.isSelected()) {
                        CreateFacebookStream fbStreamCreator = new CreateFacebookStream();

                        fbStreamCreator.createStream(streamTitleField.getText(), streamDescField.getText(), new GetFacebookData().getPageNameFromFile());

                        if (fbStreamCreator.getStreamID() != null && fbStreamCreator.getStreamURL() != null) {
                            streamFBIDField.setText(fbStreamCreator.getStreamID());
                            streamFBKeyField.setText(fbStreamCreator.getStreamURL());
                        }
                    }

                    GetFacebookData facebookData = new GetFacebookData();

                    facebookData.saveTitleAndDesc(streamTitleField.getText(), streamDescField.getText());

                    setLoadingBar(50);

                    Logger.println(new ManageYoutubeData().getBroadcastID());
                    Logger.println(new ManageYoutubeData().getStreamID());
                    Logger.println(new ManageYoutubeData().getStreamURL());
                    Logger.println(new ManageYoutubeData().getStreamKey());

                    setLoadingBar(75);

                    createStreamButton.setEnabled(false);
                    streamTitleField.setEnabled(false);
                    streamDescField.setEnabled(false);

                    loadingDialog.setVisible(false);

                    setLoadingBar(100);

                    set(true);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

        createStreamsThread.start();
    }//GEN-LAST:event_createStreamButtonActionPerformed

    private void createStreamButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createStreamButtonMouseExited
        buttonUnHover(createStreamButton);
    }//GEN-LAST:event_createStreamButtonMouseExited

    private void createStreamButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createStreamButtonMouseEntered
        buttonHover(createStreamButton);
    }//GEN-LAST:event_createStreamButtonMouseEntered

    private void streamFBUrlFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamFBUrlFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamFBUrlFieldActionPerformed

    private void streamFBUrlFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_streamFBIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_streamFBIDFieldActionPerformed

    private void buttonHover(javax.swing.JButton button) {
        if (button.isEnabled()){
            button.setBackground(new Color(114, 114, 114));
        }
    }

    private void buttonUnHover(javax.swing.JButton button) {
        if (button.isEnabled()){
            button.setBackground(new Color(58, 57, 58));
        }
    }


public void openMainWindow() {
        try {
            UIManager.setLookAndFeel(new MetalLookAndFeel());
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
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

        Logger.println("Opened Main Window");
    }

    public static void main(String args[]) throws Exception {
        new MainWindow().openMainWindow();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton FBConnected;
    public javax.swing.JButton YTConnected;
    public javax.swing.JLabel YTConnectedLabel;
    public javax.swing.JButton copyFBKeyButton;
    public javax.swing.JButton copyFBUrlButton;
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
    public javax.swing.JLabel streamFBIDLabel;
    public javax.swing.JLabel streamFBIDLabel1;
    public javax.swing.JLabel streamFBKey;
    public javax.swing.JTextField streamFBKeyField;
    public javax.swing.JTextField streamFBUrlField;
    public javax.swing.JTextField streamTitleField;
    public javax.swing.JLabel streamTitleLabel;
    public javax.swing.JCheckBox streamToFBBox;
    public javax.swing.JCheckBox streamToYTBox;
    public javax.swing.JLabel streamYTDataLabel;
    public javax.swing.JLabel streamYTID;
    public javax.swing.JTextField streamYTIDField;
    public javax.swing.JLabel streamYTKey;
    public javax.swing.JTextField streamYTKeyField;
    public javax.swing.JLabel streamYTURL;
    public javax.swing.JTextField streamYTURLField;
    // End of variables declaration//GEN-END:variables

    public boolean getOpened() {
        return opened;
    }

    public void setStreamDescField() {
        streamDescField.setText(new GetFacebookData().getDesc());
    }

    public void setStreamTitleField() {
        streamTitleField.setText(new GetFacebookData().getTitle());
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
        setYTConnected();
    }

    public void setFBName(String name) {
        pageName = name;
        setFBConnected();
    }

    public void setFBConnected() {
        if (pageName != null){
            setFBConnected(pageName);
        }
    }

    public void setYTConnected() {
        if (channelName != null){
            setYTConnected(channelName);
        }
    }
}

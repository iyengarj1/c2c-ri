/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestLogReportPane.java
 *
 * Created on Feb 12, 2010, 7:47:09 PM
 */
package org.fhwa.c2cri.gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import org.fhwa.c2cri.utilities.Parameter;
import org.fhwa.c2cri.utilities.ProgressMonitor;
import org.fhwa.c2cri.utilities.RIParameters;


/**
 * The Class TestLogReportPane.
 *
 * @author TransCore ITS, LLC
 * Last Updated:  1/8/2014
 */
public class TestLogReportPane extends javax.swing.JPanel implements javax.swing.event.ListSelectionListener {

    /** The log path. */
    private String logPath;
    
    /** The report path. */
    private String reportPath;
    
    /** The report name. */
    private String reportName;
    
    /** The log name. */
    private String logName;

    /**
     * Creates new form TestLogReportPane.
     */
    public TestLogReportPane() {
        initComponents();
        
        // Add all of the radio buttons to the button group.
        this.reportButtonGroup.add(this.conformanceRadioButton);
        this.reportButtonGroup.add(this.scriptLogRadioButton);
        this.reportButtonGroup.add(this.testCaseSummaryRadioButton);
        this.reportButtonGroup.add(this.testCaseDetailRadioButton);
        this.reportButtonGroup.add(this.msgDetailRadioButton);
        this.reportButtonGroup.add(this.msgSummaryRadioButton);
        this.reportButtonGroup.add(this.section1201RadioButton);

        String default_Path = RIParameters.getInstance().getParameterValue(Parameter.report_file_Path);
        if (default_Path.equals("")) {
            default_Path = Parameter.default_report_file_Path;
        }

        this.reportPathTextField.setText(default_Path);
        this.reportPath = this.reportPathTextField.getText();

        File dir = new File(RIParameters.getInstance().getParameterValue(Parameter.log_file_path));
        FileTableModel model = new FileTableModel(dir);
//        model.setLogFilter();
        this.logFileSelectionTable.setModel(model);
        this.logFilePathTextField.setText(dir.getAbsolutePath());

        javax.swing.ListSelectionModel listSelectionModel = this.logFileSelectionTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
        this.logFileSelectionTable.setSelectionModel(listSelectionModel);
        this.logFileSelectionTable.getColumn(FileTableModel.DATE_COLUMN_NAME).setCellRenderer(new DateRenderer());

//Removed for Release 2        FilenameInputVerifier theVerifier = new FilenameInputVerifier();
//Removed for Release 2        this.reportNameTextField.setInputVerifier(theVerifier);

        // Store the path for restoring in case the user types in an invalid path
        this.logPath = this.logFilePathTextField.getText();

        this.logNameTextField.setText("");
        this.conformanceRadioButton.setSelected(true);
        this.reportNameTextField.setText("");

    }

    /* (non-Javadoc)
     * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
     */
    public void valueChanged(javax.swing.event.ListSelectionEvent e) {
        javax.swing.ListSelectionModel lsm = (javax.swing.ListSelectionModel) e.getSource();

        if (!lsm.isSelectionEmpty()) {
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    logNameTextField.setText((String) this.logFileSelectionTable.getValueAt(i, 0));
                }
            }
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportButtonGroup = new javax.swing.ButtonGroup();
        createButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        exportButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        testLogPanel = new javax.swing.JPanel();
        logFileScrollPane = new javax.swing.JScrollPane();
        logFileSelectionTable = new javax.swing.JTable();
        logPathButton = new javax.swing.JButton();
        logFilePathTextField = new javax.swing.JTextField();
        reportNameLabel1 = new javax.swing.JLabel();
        logNameTextField = new javax.swing.JTextField();
        reportNameLabel3 = new javax.swing.JLabel();
        reportDetailsPanel = new javax.swing.JPanel();
        scriptLogRadioButton = new javax.swing.JRadioButton();
        testCaseSummaryRadioButton = new javax.swing.JRadioButton();
        testCaseDetailRadioButton = new javax.swing.JRadioButton();
        msgSummaryRadioButton = new javax.swing.JRadioButton();
        msgDetailRadioButton = new javax.swing.JRadioButton();
        conformanceRadioButton = new javax.swing.JRadioButton();
        section1201RadioButton = new javax.swing.JRadioButton();
        reportPanel = new javax.swing.JPanel();
        reportNameLabel = new javax.swing.JLabel();
        reportNameTextField = new javax.swing.JTextField();
        reportPathButton = new javax.swing.JButton();
        reportPathTextField = new javax.swing.JTextField();
        reportNameLabel2 = new javax.swing.JLabel();
        reportBrowseButton = new javax.swing.JButton();

        createButton.setText("Create PDF");
        createButton.setToolTipText("Create the selected log report.");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        viewButton.setText("View PDF");
        viewButton.setToolTipText("View the test log report.");
        viewButton.setEnabled(false);
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        exportButton.setText("Export to CSV");
        exportButton.setToolTipText("Export the log file to a CSV file.");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Cancel report creation.");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        testLogPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Test Log File Selection"));

        logFileSelectionTable.setAutoCreateRowSorter(true);
        logFileSelectionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        logFileSelectionTable.setToolTipText("The list of available valid test logs.");
        logFileSelectionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        logFileSelectionTable.getTableHeader().setReorderingAllowed(false);
        logFileScrollPane.setViewportView(logFileSelectionTable);
        logFileSelectionTable.getAccessibleContext().setAccessibleName("Test Log Table");

        logPathButton.setText("Path...");
        logPathButton.setToolTipText("Select the path to find Test Logs.");
        logPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logPathButtonActionPerformed(evt);
            }
        });

        logFilePathTextField.setText("jTextField2");
        logFilePathTextField.setToolTipText("The path where the test log is stored.");

        reportNameLabel1.setText("Name");

        logNameTextField.setText("Jan-22-C2CRI");
        logNameTextField.setToolTipText("The log file to be used for this log report.");

        reportNameLabel3.setText("Path");

        reportDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Report Details"));

        scriptLogRadioButton.setText("Script Log");
        scriptLogRadioButton.setToolTipText("Report all test script action details of the test log.");

        testCaseSummaryRadioButton.setText("Test Case Summary");
        testCaseSummaryRadioButton.setToolTipText("Report the high level results of test cases executed during a test.");

        testCaseDetailRadioButton.setText("Test Case Details");
        testCaseDetailRadioButton.setToolTipText("Report test step details for the test cases contained in the log file.");

        msgSummaryRadioButton.setText("Message Summary");
        msgSummaryRadioButton.setToolTipText("Report on messages that were exchanged during the test.");

        msgDetailRadioButton.setText("Message Detail");
        msgDetailRadioButton.setToolTipText("Detailed report of messages exchanged during the test.");

        conformanceRadioButton.setSelected(true);
        conformanceRadioButton.setText("Conformance/Compliance Report");
        conformanceRadioButton.setToolTipText("Conformance/Compliance testing result of the selected Test Log.");

        section1201RadioButton.setText("Section 1201 Conformance/Compliance Report");
        section1201RadioButton.setToolTipText("Section 1201 Conformance/Compliance Report");

        javax.swing.GroupLayout reportDetailsPanelLayout = new javax.swing.GroupLayout(reportDetailsPanel);
        reportDetailsPanel.setLayout(reportDetailsPanelLayout);
        reportDetailsPanelLayout.setHorizontalGroup(
            reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(testCaseSummaryRadioButton)
                    .addComponent(conformanceRadioButton)
                    .addComponent(section1201RadioButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(msgSummaryRadioButton)
                    .addGroup(reportDetailsPanelLayout.createSequentialGroup()
                        .addGroup(reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(testCaseDetailRadioButton)
                            .addComponent(msgDetailRadioButton))
                        .addGap(38, 38, 38)
                        .addComponent(scriptLogRadioButton)))
                .addGap(133, 133, 133))
        );
        reportDetailsPanelLayout.setVerticalGroup(
            reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportDetailsPanelLayout.createSequentialGroup()
                .addGroup(reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportDetailsPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(section1201RadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(msgDetailRadioButton)
                            .addComponent(testCaseSummaryRadioButton)))
                    .addGroup(reportDetailsPanelLayout.createSequentialGroup()
                        .addGroup(reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(conformanceRadioButton)
                            .addComponent(scriptLogRadioButton)
                            .addComponent(testCaseDetailRadioButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(msgSummaryRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout testLogPanelLayout = new javax.swing.GroupLayout(testLogPanel);
        testLogPanel.setLayout(testLogPanelLayout);
        testLogPanelLayout.setHorizontalGroup(
            testLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testLogPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(testLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportNameLabel3)
                    .addComponent(reportNameLabel1))
                .addGap(23, 23, 23)
                .addGroup(testLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logNameTextField)
                    .addComponent(logFilePathTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logPathButton)
                .addContainerGap())
            .addGroup(testLogPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logFileScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addGap(12, 12, 12))
            .addGroup(testLogPanelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(reportDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(76, 76, 76))
        );
        testLogPanelLayout.setVerticalGroup(
            testLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testLogPanelLayout.createSequentialGroup()
                .addGroup(testLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportNameLabel1))
                .addGap(12, 12, 12)
                .addGroup(testLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reportNameLabel3)
                    .addGroup(testLogPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logFilePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(logPathButton)))
                .addGap(18, 18, 18)
                .addComponent(logFileScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(reportDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        logFilePathTextField.getAccessibleContext().setAccessibleName("Test Log Path");
        logNameTextField.getAccessibleContext().setAccessibleName("Test Log Name");

        reportPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Report File Selection"));

        reportNameLabel.setText("Name");

        reportNameTextField.setText("Jan-22-C2CRI");
        reportNameTextField.setToolTipText("The report name for this log report.");

        reportPathButton.setText("Path...");
        reportPathButton.setToolTipText("Select the path to store the report.");
        reportPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportPathButtonActionPerformed(evt);
            }
        });

        reportPathTextField.setText("jTextField1");
        reportPathTextField.setToolTipText("The path for the new log report file");

        reportNameLabel2.setText("Path");

        reportBrowseButton.setText("Browse...");
        reportBrowseButton.setToolTipText("Select an existing file name for the report.");
        reportBrowseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportBrowseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, reportPanelLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reportNameLabel2)
                    .addComponent(reportNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportNameTextField)
                    .addComponent(reportPathTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportPathButton)
                    .addComponent(reportBrowseButton))
                .addContainerGap())
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reportNameLabel)
                    .addComponent(reportBrowseButton))
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(reportPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(reportPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reportPathButton)))
                    .addGroup(reportPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(reportNameLabel2)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        reportNameTextField.getAccessibleContext().setAccessibleName("Test Report Name");
        reportPathTextField.getAccessibleContext().setAccessibleName("Test Report Path");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(viewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(exportButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reportPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(testLogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(reportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(testLogPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createButton)
                    .addComponent(exportButton)
                    .addComponent(cancelButton)
                    .addComponent(viewButton))
                .addGap(11, 11, 11))
        );

        exportButton.getAccessibleContext().setAccessibleDescription("Export the log file report to a CSV file.");
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method called when the user presses the create button.  The RIReporter is notified of the user settings so that a report can be generated. At the conclusion of this method the View button is enabled.
     *
     * @param evt the evt
     */
	private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
            
    }//GEN-LAST:event_createButtonActionPerformed

    /**
     * Method called when the user presses the View button.  The report that was created is displayed using the JasperReport Viewer.
     *
     * @param evt the evt
     */
	private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
           
    }//GEN-LAST:event_viewButtonActionPerformed

    /**
     * Method called when the user presses the export button.  The RIReporter is notified of the user settings so that a report can be exported.
     *
     * @param evt the evt
     */
	private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
          
    }//GEN-LAST:event_exportButtonActionPerformed

    /**
     * Method called when the user presses the cancel button.  The TestReportsPanel is notified so that this panel can be removed from the users view.
     *
     * @param evt the evt
     */
	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
          
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Report path button action performed.
     * 
     * Pre-Conditions: N/A
     * Post-Conditions: N/A
     *
     * @param evt the evt
     */
    private void reportPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportPathButtonActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        String default_Path = this.reportPath;
        File current_dir = new File(default_Path);
        System.out.println(" Path = " + default_Path + " is valid? " + current_dir.exists());
        fc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(current_dir);

        boolean normalExit = false;
        int returnVal = 0;
        while (!normalExit) {

            returnVal = fc.showOpenDialog(this);

            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                if (file == null || file.getName().equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid File Name", "File Name Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                } else {
                    normalExit = true;
//                      this.reportNameTextField.setText("");
//                      this.configName = "";
                    this.reportPathTextField.setText(file.getAbsolutePath());
                    this.reportPath = file.getAbsolutePath();


                }
            } else {
                normalExit = true;
            }
        }

    }//GEN-LAST:event_reportPathButtonActionPerformed

    /**
     * Report browse button action performed.
     * 
     * Pre-Conditions: N/A
     * Post-Conditions: N/A
     *
     * @param evt the evt
     */
    private void reportBrowseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportBrowseButtonActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        String default_Path = this.reportPath;
        File current_dir = new File(default_Path);
        System.out.println(" Path = " + default_Path + " is valid? " + current_dir.exists());
        fc.setCurrentDirectory(current_dir);
        FileFilter riPDFFilter = new FileFilter() {

            public boolean accept(File f) {
                return f.isDirectory() || f.getName().endsWith(".pdf");
            }

            public String getDescription() {
                return "Filter for RI Report Files";
            }
        };
        fc.setFileFilter(riPDFFilter);

        boolean normalExit = false;
        int returnVal = 0;
        while (!normalExit) {

            returnVal = fc.showOpenDialog(this);

            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                if (file == null || file.getName().equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid File Name", "File Name Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                } else {
                    this.reportNameTextField.setText(file.getName());
                    this.reportName = file.getName();
                    this.reportPathTextField.setText(file.getParent());
                    this.reportPath = file.getParent();
                    normalExit = true;
                }
            } else {
                normalExit = true;
            }
        }

    }//GEN-LAST:event_reportBrowseButtonActionPerformed

    /**
     * Log path button action performed.
     * 
     * Pre-Conditions: N/A
     * Post-Conditions: N/A
     *
     * @param evt the evt
     */
    private void logPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logPathButtonActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        String default_Path = this.logPath;
        if (default_Path.equals("")) {
            default_Path = Parameter.default_config_file_path;
        }
        File current_dir = new File(default_Path);
        System.out.println(" Path = " + default_Path + " is valid? " + current_dir.exists());
        fc.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);
        fc.setCurrentDirectory(current_dir);

        boolean normalExit = false;
        int returnVal = 0;
        while (!normalExit) {

            returnVal = fc.showOpenDialog(this);

            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                if (file == null || file.getName().equals("")) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Invalid File Name", "File Name Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                } else {
                    normalExit = true;
                    this.logNameTextField.setText("");
                    this.logName = "";
                    this.logFilePathTextField.setText(file.getAbsolutePath());
                    this.logPath = file.getAbsolutePath();

                    updateFileTable();
                }
            } else {
                normalExit = true;
            }
        }
    }

    /**
     * Update file table.
     * 
     * Pre-Conditions: N/A
     * Post-Conditions: N/A
     */
    public void updateFileTable(){
                    File dir = new File(logPath);
                    FileTableModel model = new FileTableModel(dir);
                    model.setLogFilter();
                    this.logFileSelectionTable.setModel(model);
                    this.logFileSelectionTable.getColumn(FileTableModel.DATE_COLUMN_NAME).setCellRenderer(new DateRenderer());
                    model.fireTableDataChanged();

    }//GEN-LAST:event_logPathButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JRadioButton conformanceRadioButton;
    protected javax.swing.JButton createButton;
    protected javax.swing.JButton exportButton;
    protected javax.swing.JTextField logFilePathTextField;
    private javax.swing.JScrollPane logFileScrollPane;
    private javax.swing.JTable logFileSelectionTable;
    protected javax.swing.JTextField logNameTextField;
    private javax.swing.JButton logPathButton;
    protected javax.swing.JRadioButton msgDetailRadioButton;
    protected javax.swing.JRadioButton msgSummaryRadioButton;
    private javax.swing.JButton reportBrowseButton;
    protected javax.swing.ButtonGroup reportButtonGroup;
    private javax.swing.JPanel reportDetailsPanel;
    private javax.swing.JLabel reportNameLabel;
    private javax.swing.JLabel reportNameLabel1;
    private javax.swing.JLabel reportNameLabel2;
    private javax.swing.JLabel reportNameLabel3;
    protected javax.swing.JTextField reportNameTextField;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JButton reportPathButton;
    protected javax.swing.JTextField reportPathTextField;
    protected javax.swing.JRadioButton scriptLogRadioButton;
    protected javax.swing.JRadioButton section1201RadioButton;
    protected javax.swing.JRadioButton testCaseDetailRadioButton;
    protected javax.swing.JRadioButton testCaseSummaryRadioButton;
    private javax.swing.JPanel testLogPanel;
    protected javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
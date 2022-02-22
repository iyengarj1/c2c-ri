/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestConfigurationReportPane.java
 *
 * Created on Feb 12, 2010, 7:47:35 PM
 */
package org.fhwa.c2cri.gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;
import org.fhwa.c2cri.utilities.Parameter;
import org.fhwa.c2cri.utilities.RIParameters;

/**
 * Panel for specifying and initiatiating a test configuration file report.
 *
 * @author TransCore ITS, LLC
 * Last Updated:  1/8/2014
 */
public class TestConfigurationReportPane extends javax.swing.JPanel implements javax.swing.event.ListSelectionListener {

    /** The config path. */
    private String configPath;
    
    /** The report path. */
    private String reportPath;
    
    /** The report name. */
    private String reportName;
    
    /** The config name. */
    private String configName;

    /**
     * Creates new form TestConfigurationReportPane.
     */
    public TestConfigurationReportPane() {
        initComponents();
        this.reportButtonGroup.add(this.allRadioButton);
        this.reportButtonGroup.add(this.scriptsRadioButton);
        this.reportButtonGroup.add(this.casesRadioButton);
        this.reportButtonGroup.add(this.proceduresRadioButton);

        String default_Path = RIParameters.getInstance().getParameterValue((Parameter.report_file_Path));
        if (default_Path.equals("")) {
            default_Path = Parameter.default_report_file_Path;
        }
        this.reportPathTextField.setText(default_Path);
        this.reportPath = this.reportPathTextField.getText();

        File dir = new File(RIParameters.getInstance().getParameterValue(Parameter.config_file_path));
        FileTableModel model = new FileTableModel(dir);
        model.setConfigFilter();
        this.configFileSelectionTable.setModel(model);
        this.configFilePathTextField.setText(dir.getAbsolutePath());


        javax.swing.ListSelectionModel listSelectionModel = this.configFileSelectionTable.getSelectionModel();
        listSelectionModel.addListSelectionListener(this);
        this.configFileSelectionTable.setSelectionModel(listSelectionModel);
        this.configFileSelectionTable.getColumn(FileTableModel.DATE_COLUMN_NAME).setCellRenderer(new DateRenderer());

//Removed for Release 2        FilenameInputVerifier theVerifier = new FilenameInputVerifier();
//Removed for Release 2        this.reportNameTextField.setInputVerifier(theVerifier);

        // Store the path for restoring in case the user types in an invalid path
        this.configPath = this.configFilePathTextField.getText();

        this.configNameTextField.setText("");
        this.reportNameTextField.setText("");
        this.allRadioButton.setSelected(true);


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
                    configNameTextField.setText((String) this.configFileSelectionTable.getValueAt(i, 0));
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
        cancelButton = new javax.swing.JButton();
        testConfigPanel = new javax.swing.JPanel();
        configFileScrollPane = new javax.swing.JScrollPane();
        configFileSelectionTable = new javax.swing.JTable();
        configPathButton = new javax.swing.JButton();
        configFilePathTextField = new javax.swing.JTextField();
        reportNameLabel1 = new javax.swing.JLabel();
        reportDetailsPanel = new javax.swing.JPanel();
        allRadioButton = new javax.swing.JRadioButton();
        casesRadioButton = new javax.swing.JRadioButton();
        scriptsRadioButton = new javax.swing.JRadioButton();
        proceduresRadioButton = new javax.swing.JRadioButton();
        configNameTextField = new javax.swing.JTextField();
        reportNameLabel3 = new javax.swing.JLabel();
        reportPanel = new javax.swing.JPanel();
        reportNameLabel2 = new javax.swing.JLabel();
        reportNameTextField = new javax.swing.JTextField();
        reportPathButton = new javax.swing.JButton();
        reportPathTextField = new javax.swing.JTextField();
        reportNameLabel4 = new javax.swing.JLabel();
        reportBrowseButton = new javax.swing.JButton();

        createButton.setText("Create");
        createButton.setToolTipText("Create a new report using the settings selected.");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        viewButton.setText("View");
        viewButton.setToolTipText("View the selected report.");
        viewButton.setEnabled(false);
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.setToolTipText("Cancel without creating a new report.");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        testConfigPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Test Configuration File Selection"));

        configFileSelectionTable.setAutoCreateRowSorter(true);
        configFileSelectionTable.setModel(new javax.swing.table.DefaultTableModel(
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
        configFileSelectionTable.setToolTipText("Select the Test Configuration File for the report.");
        configFileSelectionTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        configFileSelectionTable.getTableHeader().setReorderingAllowed(false);
        configFileScrollPane.setViewportView(configFileSelectionTable);
        configFileSelectionTable.getAccessibleContext().setAccessibleName("Available Log Files Table");

        configPathButton.setText("Path...");
        configPathButton.setToolTipText("Select the path to find Test Logs.");
        configPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configPathButtonActionPerformed(evt);
            }
        });

        configFilePathTextField.setText("jTextField2");
        configFilePathTextField.setToolTipText("Set the path for the Test Configuration file list.");

        reportNameLabel1.setText("Name");

        reportDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Report Details"));

        allRadioButton.setSelected(true);
        allRadioButton.setText("Configuration File Details");
        allRadioButton.setToolTipText("Report all Test Configuration File Parameters");

        casesRadioButton.setText("Test Cases");
        casesRadioButton.setToolTipText("Report all Applicable Test Cases");

        scriptsRadioButton.setText("Test Scripts");
        scriptsRadioButton.setToolTipText("Report containing the test scripts associated with the configuration file.");

        proceduresRadioButton.setText("Test Procedures");
        proceduresRadioButton.setToolTipText("Report all Applicable Test Procedures");

        javax.swing.GroupLayout reportDetailsPanelLayout = new javax.swing.GroupLayout(reportDetailsPanel);
        reportDetailsPanel.setLayout(reportDetailsPanelLayout);
        reportDetailsPanelLayout.setHorizontalGroup(
            reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scriptsRadioButton)
                    .addComponent(allRadioButton)
                    .addComponent(casesRadioButton)
                    .addComponent(proceduresRadioButton))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        reportDetailsPanelLayout.setVerticalGroup(
            reportDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportDetailsPanelLayout.createSequentialGroup()
                .addComponent(allRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(casesRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proceduresRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scriptsRadioButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        configNameTextField.setText("Jan-22-C2CRI");
        configNameTextField.setToolTipText("The name of the configuration file to be used for this report.");

        reportNameLabel3.setText("Path");

        javax.swing.GroupLayout testConfigPanelLayout = new javax.swing.GroupLayout(testConfigPanel);
        testConfigPanel.setLayout(testConfigPanelLayout);
        testConfigPanelLayout.setHorizontalGroup(
            testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testConfigPanelLayout.createSequentialGroup()
                .addGroup(testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(testConfigPanelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(configFileScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testConfigPanelLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reportNameLabel1)
                            .addComponent(reportNameLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(configNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                            .addComponent(configFilePathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(configPathButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, testConfigPanelLayout.createSequentialGroup()
                        .addContainerGap(195, Short.MAX_VALUE)
                        .addComponent(reportDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 193, Short.MAX_VALUE)))
                .addContainerGap())
        );
        testConfigPanelLayout.setVerticalGroup(
            testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(testConfigPanelLayout.createSequentialGroup()
                .addGroup(testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportNameLabel1)
                    .addComponent(configNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(testConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(configFilePathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reportNameLabel3))
                    .addComponent(configPathButton))
                .addGap(18, 18, 18)
                .addComponent(configFileScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reportDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        configFilePathTextField.getAccessibleContext().setAccessibleName("Configuration File Path");
        configNameTextField.getAccessibleContext().setAccessibleName("Configuration File Name");

        reportPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Report File Selection"));

        reportNameLabel2.setText("Name");

        reportNameTextField.setText("Jan-22-C2CRI");
        reportNameTextField.setToolTipText("The report name for this configuration report.");

        reportPathButton.setText("Path...");
        reportPathButton.setToolTipText("Select the path to store the report.");
        reportPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportPathButtonActionPerformed(evt);
            }
        });

        reportPathTextField.setText("jTextField1");
        reportPathTextField.setToolTipText("Select the path for the Test Report");

        reportNameLabel4.setText("Path");

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
                .addGap(37, 37, 37)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reportNameLabel2)
                    .addComponent(reportNameLabel4))
                .addGap(18, 18, 18)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportPathTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                    .addComponent(reportNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reportPathButton)
                    .addComponent(reportBrowseButton))
                .addContainerGap())
        );
        reportPanelLayout.setVerticalGroup(
            reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(reportPanelLayout.createSequentialGroup()
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportBrowseButton)
                    .addComponent(reportNameLabel2)
                    .addComponent(reportNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportPathButton)
                    .addComponent(reportNameLabel4)
                    .addComponent(reportPathTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        reportNameTextField.getAccessibleContext().setAccessibleName("Configuration Report Name");
        reportPathTextField.getAccessibleContext().setAccessibleName("Report File Path");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(createButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(viewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(cancelButton)
                .addContainerGap(208, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(testConfigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(reportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(461, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(viewButton)
                    .addComponent(createButton))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(14, 14, 14)
                    .addComponent(reportPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(testConfigPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(41, 41, 41)))
        );

        viewButton.getAccessibleContext().setAccessibleDescription("View the created report.");
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
            if (default_Path.equals("")) {
                default_Path = Parameter.default_report_file_Path;
            }
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
             * Config path button action performed.
             * 
             * Pre-Conditions: N/A
             * Post-Conditions: N/A
             *
             * @param evt the evt
             */
            private void configPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configPathButtonActionPerformed
        javax.swing.JFileChooser fc = new javax.swing.JFileChooser();
        String default_Path = this.configPath;
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
                    this.configNameTextField.setText("");
                    this.configName = "";
                    this.configFilePathTextField.setText(file.getAbsolutePath());
                    this.configPath = file.getAbsolutePath();
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
    public void updateFileTable() {
        File dir = new File(configPath);
        FileTableModel model = new FileTableModel(dir);
        model.setConfigFilter();
        this.configFileSelectionTable.setModel(model);
        this.configFileSelectionTable.getColumn(FileTableModel.DATE_COLUMN_NAME).setCellRenderer(new DateRenderer());
       
            }//GEN-LAST:event_configPathButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JRadioButton allRadioButton;
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JRadioButton casesRadioButton;
    protected javax.swing.JTextField configFilePathTextField;
    private javax.swing.JScrollPane configFileScrollPane;
    private javax.swing.JTable configFileSelectionTable;
    protected javax.swing.JTextField configNameTextField;
    private javax.swing.JButton configPathButton;
    protected javax.swing.JButton createButton;
    protected javax.swing.JRadioButton proceduresRadioButton;
    private javax.swing.JButton reportBrowseButton;
    protected javax.swing.ButtonGroup reportButtonGroup;
    private javax.swing.JPanel reportDetailsPanel;
    private javax.swing.JLabel reportNameLabel1;
    private javax.swing.JLabel reportNameLabel2;
    private javax.swing.JLabel reportNameLabel3;
    private javax.swing.JLabel reportNameLabel4;
    protected javax.swing.JTextField reportNameTextField;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JButton reportPathButton;
    protected javax.swing.JTextField reportPathTextField;
    protected javax.swing.JRadioButton scriptsRadioButton;
    private javax.swing.JPanel testConfigPanel;
    protected javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables
}
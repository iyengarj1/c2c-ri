/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TestReportsPanel.java
 *
 * Created on Feb 12, 2010, 7:46:50 PM
 */

package org.fhwa.c2cri.gui;


/**
 * The Class TestReportsPanel.
 *
 * @author TransCore ITS, LLC
 * Last Updated:  1/8/2014
 */
public class TestReportsPanel extends javax.swing.JPanel {
	
	/** reference to the Configuration Report Pane. */
	protected TestConfigurationReportPane configurationReport;
	
	/** reference to the Test Log Report Pane. */
	protected TestLogReportPane logReport;

    /**
     * Creates new form TestReportsPanel.
     */
    public TestReportsPanel() {
        initComponents();

        configurationReport = new TestConfigurationReportPane();
        logReport = new TestLogReportPane();
        this.reportsSubPanel.addTab("Configuration", null, configurationReport, "Create reports from configuration files.");
        this.reportsSubPanel.addTab("Log", null, logReport,"Create reports from log files.");
        this.reportsSubPanel.setVisible(true);
        this.setVisible(false);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reportsSubPanel = new javax.swing.JTabbedPane();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reportsSubPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(reportsSubPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        reportsSubPanel.getAccessibleContext().setAccessibleName("Reports Panel");
        reportsSubPanel.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane reportsSubPanel;
    // End of variables declaration//GEN-END:variables

}
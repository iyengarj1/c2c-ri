/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fhwa.c2cri.reports.dao;

import java.io.File;
import java.sql.DriverManager;
import java.util.ArrayList;
import org.fhwa.c2cri.reports.C2CRIInfoLayerTestProcedureStep;

/**
 * Provides support for the C2CRI_InfoLayerTestProcedureSteps Table. 
 *
 * @author TransCore ITS
 */
public class C2CRIInfoLayerTestProcedureStepsDAO extends ReportsDAO {

    // Keep a cache of C2CRInfoLayerTestProcedureStep objects.  To speed up processing they will all be written out in batches.
    private ArrayList<C2CRIInfoLayerTestProcedureStep> storedTestStepList = new ArrayList<>();
    // The maximum number of objects to hold before writing them out.
    private int maxHold = 100;
    
    public C2CRIInfoLayerTestProcedureStepsDAO(File outdb) throws Exception {
        // Create a SQLite connection
        Class.forName("org.sqlite.JDBC");
        super.conn = DriverManager.getConnection("jdbc:sqlite:" + outdb.getAbsolutePath());
    }

    /**
     * Write a list of Test Procedure Step objects in a batch operation.
     * 
     * @param testProcedureStepList the list of test procedure step objects.
     */
    public void insert(ArrayList<C2CRIInfoLayerTestProcedureStep> testProcedureStepList) {
        try {

            // Disable auto-commit
            conn.setAutoCommit(false);

            pstmt = super.conn.prepareStatement("INSERT INTO " + ReportsDAOInterface.INFOLAYERTESTPROCEDURESTEPS_TABLE + "("
                    + "keyid, Id, Procedure, Step, Action, PassFail) "
                    + " VALUES (?,?,?,?,?,?)");


            for (C2CRIInfoLayerTestProcedureStep thisEventSet : testProcedureStepList) {
                int col = 1;
                pstmt.setInt(col++, thisEventSet.getKeyid());
                pstmt.setInt(col++, thisEventSet.getId());
                pstmt.setString(col++, thisEventSet.getProcedure());
                pstmt.setString(col++, thisEventSet.getStep());
                pstmt.setString(col++, thisEventSet.getAction());
                pstmt.setString(col++, thisEventSet.getPassFail());
                pstmt.addBatch();
            }
            executeBatch(pstmt);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Store the provided test procedure step data object.  If we've reached the maxHold value, write out the current records.
     * 
     * @param eventSet the current test procedure step data object.
     */
    public void insert(C2CRIInfoLayerTestProcedureStep eventSet) {
        storedTestStepList.add(eventSet);
        if (storedTestStepList.size() == maxHold){
            insert(storedTestStepList);
            storedTestStepList.clear();
            System.out.println("Wrote out "+maxHold+" test Steps.");
        }
        
    }
    
    /**
     * Write out all remaining data objects in the stored test procedure steps list.
     */
    public void flush() {
        if (storedTestStepList.size() > 0){
            insert(storedTestStepList);
            System.out.println("Wrote out the remaining "+storedTestStepList.size()+" Test Steps.");
            storedTestStepList.clear();
        }
    }
}

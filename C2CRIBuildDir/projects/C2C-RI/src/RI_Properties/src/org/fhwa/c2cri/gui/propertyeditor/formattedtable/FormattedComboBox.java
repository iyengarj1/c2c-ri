package org.fhwa.c2cri.gui.propertyeditor.formattedtable;


import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;

/**
 * The Class FormattedComboBox.
 *
 * @author open source community
 * Last Updated:  1/8/2014
 */
public abstract class FormattedComboBox extends JComboBox implements ItemListener {
    
    /** The o. */
    protected transient Object o;
    
    /**
     * Instantiates a new formatted combo box.
     * 
     * Pre-Conditions: N/A
     * Post-Conditions: N/A
     *
     * @param o the o
     * @param data the data
     * @param selection the selection
     */
    public FormattedComboBox(Object o, Object[] data, Object selection) {
        super(data);
        this.o = o;
        setFont(javax.swing.UIManager.getFont("Table.font"));
        setBorder(BorderFactory.createEmptyBorder());
        
        setSelectedItem(selection);
        
        addItemListener(this);
    }
    
    /**
     * Gets the object.
     *
     * @return the object
     */
    public Object getObject() {
    	return o;
    }
    
}
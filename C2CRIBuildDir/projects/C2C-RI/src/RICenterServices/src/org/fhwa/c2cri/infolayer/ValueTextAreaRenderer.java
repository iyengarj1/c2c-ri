/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.fhwa.c2cri.infolayer;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.*;

/**
 * The Class ValueTextAreaRenderer.
 *
 * @author Dr. Heinz M. Kabutz
 */
public class ValueTextAreaRenderer extends JTextArea
    implements TableCellRenderer {
  
  /** The adaptee. */
  private final DefaultTableCellRenderer adaptee =
      new DefaultTableCellRenderer();
  
  /** map from table to map of rows to map of column heights. */
  private final Map cellSizes = new HashMap();
  
  /** The input spec. */
  private transient  MessageSpecification inputSpec;

  /**
   * Instantiates a new value text area renderer.
   * 
   * Pre-Conditions: N/A
   * Post-Conditions: N/A
   *
   * @param specification the specification
   */
  public ValueTextAreaRenderer(MessageSpecification specification) {
    setLineWrap(true);
    setWrapStyleWord(true);
    inputSpec = specification;
  }

  /* (non-Javadoc)
   * @see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
   */
  public Component getTableCellRendererComponent(//
      JTable table, Object obj, boolean isSelected,
      boolean hasFocus, int row, int column) {
    // set the colours, etc. using the standard for that platform
    adaptee.getTableCellRendererComponent(table, obj,
        isSelected, hasFocus, row, column);
    if (inputSpec.getMessageSpecItems().get(row).isProjectOptional()){
        setForeground(adaptee.getForeground());
        setBackground(Color.YELLOW);
    } else {
        setForeground(adaptee.getForeground());
        setBackground(adaptee.getBackground());
    }
    setBorder(adaptee.getBorder());
    setFont(adaptee.getFont());
    setText(adaptee.getText());

    // This line was very important to get it working with JDK1.4
    TableColumnModel columnModel = table.getColumnModel();
    setSize(columnModel.getColumn(column).getWidth(), 100000);
    int height_wanted = (int) getPreferredSize().getHeight();
    addSize(table, row, column, height_wanted);
    height_wanted = findTotalMaximumRowSize(table, row);
    if (height_wanted != table.getRowHeight(row)) {
      table.setRowHeight(row, height_wanted);
    }
    return this;
  }

  /**
   * Adds the size.
   * 
   * Pre-Conditions: N/A
   * Post-Conditions: N/A
   *
   * @param table the table
   * @param row the row
   * @param column the column
   * @param height the height
   */
  private void addSize(JTable table, int row, int column,
                       int height) {
    Map rows = (Map) cellSizes.get(table);
    if (rows == null) {
      cellSizes.put(table, rows = new HashMap());
    }
    Map rowheights = (Map) rows.get(new Integer(row));
    if (rowheights == null) {
      rows.put(new Integer(row), rowheights = new HashMap());
    }
    rowheights.put(new Integer(column), new Integer(height));
  }

  /**
   * Look through all columns and get the renderer.  If it is
   * also a ValueTextAreaRenderer, we look at the maximum height in
   * its hash table for this row.
   *
   * @param table the table
   * @param row the row
   * @return the int
   */
  private int findTotalMaximumRowSize(JTable table, int row) {
    int maximum_height = 0;
    Enumeration columns = table.getColumnModel().getColumns();
    while (columns.hasMoreElements()) {
      TableColumn tc = (TableColumn) columns.nextElement();
      TableCellRenderer cellRenderer = tc.getCellRenderer();
      if (cellRenderer instanceof ValueTextAreaRenderer) {
        ValueTextAreaRenderer tar = (ValueTextAreaRenderer) cellRenderer;
        maximum_height = Math.max(maximum_height,
            tar.findMaximumRowSize(table, row));
      }
    }
    return maximum_height;
  }

  /**
   * Find maximum row size.
   * 
   * Pre-Conditions: N/A
   * Post-Conditions: N/A
   *
   * @param table the table
   * @param row the row
   * @return the int
   */
  private int findMaximumRowSize(JTable table, int row) {
    Map rows = (Map) cellSizes.get(table);
    if (rows == null) return 0;
    Map rowheights = (Map) rows.get(new Integer(row));
    if (rowheights == null) return 0;
    int maximum_height = 0;
    for (Iterator it = rowheights.entrySet().iterator();
         it.hasNext();) {
      Map.Entry entry = (Map.Entry) it.next();
      int cellHeight = ((Integer) entry.getValue()).intValue();
      maximum_height = Math.max(maximum_height, cellHeight);
    }
    return maximum_height;
  }
}

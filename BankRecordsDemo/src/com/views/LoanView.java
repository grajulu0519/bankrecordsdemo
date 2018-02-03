/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: LoanView.java
 * LAB WORK 04
 */
package com.views;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.models.daoModelGR;

public class LoanView {

	private static final long serialVersionUID = 55555555555L;
	daoModelGR daoModel = new daoModelGR();

	/**
	 * This method is used for creating JTable and display the record into the table.
	 * Sort the PEP value in descending table.
	 */
	public LoanView() {
		//Declare the Vector Object for fetching the columns and row values
		Vector<Vector<Object>> vectorDataGR = new Vector<Vector<Object>>();
		Vector<String> vectorColumnGR = new Vector<String>();
		try {
			//Declare result set and result metadata
			ResultSet resultGR = daoModel.getResultSetGR();
			ResultSetMetaData resutMetaDatagr = resultGR.getMetaData();
			int columnCountgr = resutMetaDatagr.getColumnCount();
			String columnsgr = "";
			//Iterate to store the column name
			for (int i = 1; i <= columnCountgr; i++) {
				columnsgr = resutMetaDatagr.getColumnName(i);
				vectorColumnGR.add(columnsgr);
			}
			int count = 0;
			while (resultGR.next()) {
				Vector<Object> vectorRowGR = new Vector<Object>(columnCountgr);
				for (int j = 1; j <= columnCountgr; j++) {
					
					vectorRowGR.addElement(resultGR.getObject(j));
				}
				vectorDataGR.addElement(vectorRowGR);
				count++;
			}
			System.out.println(count);
			resultGR.close();
			//Create a JTable and display the details in teh table
			DefaultTableModel defTableModelGR = new DefaultTableModel(vectorDataGR, vectorColumnGR);

			JTable jTableGR = new JTable(defTableModelGR);
			jTableGR.setName("Bank Records");
			//Set the name of the frame
			JFrame jFrameGR = new JFrame("Bank of IIT - Loan Eligibility");
			jFrameGR.setSize(3550, 950); 
			jFrameGR.add(new JScrollPane(jTableGR));
			jFrameGR.setDefaultCloseOperation(2);
			jFrameGR.pack();
			jFrameGR.setVisible(true);

		} catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName	
			e.printStackTrace();
		}
	}
}



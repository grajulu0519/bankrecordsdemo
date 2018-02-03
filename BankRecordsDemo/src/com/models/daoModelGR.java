/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: daoModelGR.java
 * LAB WORK 04
 */
package com.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.records.BankRecords;

public class daoModelGR {
	Connection conngr = null;
	Statement stmtgr = null;
	ConnectorGR connectorGR = new ConnectorGR();
	/**
	 * This method is used for creating table in the database.
	 */
	public void createTableGR(){
		try{
			//Get connection for database
			conngr = connectorGR.connectgr();
			//Call create Statement method
			stmtgr = conngr.createStatement();
			/*String sql ="CREATE TABLE g_raju_tab_01" + "(BankRecordID INTEGER NOT NULL AUTO_INCREMENT, "
			+ "ID_GR VARCHAR(7), " + "Income_GR NUMERIC, " + "PEP_GR VARCHAR(3), " + "PRIMARY KEY ( BankRecordID ))";*/
			String sql ="CREATE TABLE g_raju_tab_02" + "( "
					+ "ID_GR VARCHAR(7), " + "Income_GR NUMERIC, " + "PEP_GR VARCHAR(3) );";
			System.out.println("SQL Query " + sql);
			//Execute the above query
			stmtgr.executeUpdate(sql);
			System.out.println("Created table in given database...");
		}catch(SQLException se){
			//Handle errors for JDBC
			System.out.println("Table \"g_raju_tab_01 \"already exists");
			//se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			System.err.println("Error occured while creating the table");
			//e.printStackTrace();
		}
		System.out.println("Table created successfully!");
	}
	
	/**
	 * This method will insert data into the table.
	 * @param robjsGr Bank Records
	 */
	public void insertDataIntoTableGR(ArrayList<BankRecords> robjsGr){

		try{
			conngr = connectorGR.connectgr();
			stmtgr = conngr.createStatement();
			String sqlQueryCommand; 
			//Iterate the bank records to insert into table
			for (int i = 0; i < robjsGr.size(); i++) {
				sqlQueryCommand = "INSERT INTO g_raju_tab_01(ID_GR,Income_GR,PEP_GR) " + "VALUES(?,?,?)";
				PreparedStatement preparedStatement = conngr.prepareStatement(sqlQueryCommand);
				//Get the ID, Income and PEP from the Bank record Array List
				preparedStatement.setString(1, robjsGr.get(i).getId());
				preparedStatement.setDouble(2, robjsGr.get(i).getIncome());
				preparedStatement.setString(3, robjsGr.get(i).getPep());
				//Execute the query
				preparedStatement.executeUpdate(); 
			}


			System.out.println("Inserted records into the table...");

		}catch(SQLException se){
			//Handle errors for JDBC
			System.err.println("Error occured while inserting data into the table");
			//se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			System.err.println("Error occured in insertDataIntoTableGR method");
			//e.printStackTrace();
		}
		System.out.println("Records have been inserted into the tables successfully");
	}
		
	/**
	 * This method will fetch ID, Income and PEP from the table
	 * @return Result Set
	 * @throws Exception SQL Exception
	 */
	public ResultSet getResultSetGR() throws Exception {
		ResultSet resultgr = null;
		try {
			//Connect to the database
			conngr = connectorGR.connectgr();
			stmtgr = conngr.createStatement();
			String sqlQueryGR = "select ID_GR, Income_GR, PEP_GR from g_raju_tab_01 order by PEP_GR desc";
			//Execute the query
			resultgr = stmtgr.executeQuery(sqlQueryGR);
			System.out.println(resultgr);
		}catch(SQLException se){
			//Handle errors for JDBC
			System.err.println("Error occured fetching the data from the table");
			//se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			System.err.println("Error occured in getResultSetGR");
			//e.printStackTrace();
		}
		return resultgr;
	}

public static void main(String[] args){
	daoModelGR daoModelGR = new daoModelGR();
	daoModelGR.createTableGR();
}
}

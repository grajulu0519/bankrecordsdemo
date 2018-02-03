/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: ConnectorGR.java
 * LAB WORK 04
 */
package com.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectorGR {
	 private Connection congr;
	 	/**
	 	 * This method connect to SQL and return connection Object
	 	 * @return Connection Object
	 	 * @throws Exception SQL Exception
	 	 */
	    public Connection connectgr() throws Exception{

	        if(congr != null) return congr;

	        try {
	        	//Invoke the JDBC Driver class
	            Class.forName("com.mysql.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new Exception("No database");
	        }
	        //Connect to Papa server
	        String connectionURL = "jdbc:mysql://www.papademas.net:3306/510labs?autoReconnect=true&useSSL=false";
	        //Get the connection
	        congr = DriverManager.getConnection(connectionURL, "db510", "510");   
			return congr;
	    }
	    /**
	     * This method is used for closing the connection
	     */
	    public void closegr(){
	        if(congr != null){
	            try {
	                congr.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
}

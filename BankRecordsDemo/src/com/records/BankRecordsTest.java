/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: BankRecordsTest.java
 * LAB WORK 04
 */
package com.records;


public class BankRecordsTest {
	public static BankRecords objBankRecord = new BankRecords();
	public static Records objRecord = new Records();
	/**
	 * This is main method that is used to drive the execution.
	 * @param args Main method array
	 * @author Gauri
	 */
	public static void main(String[] args) {
	try{
		// TODO Auto-generated method stub
		objBankRecord.readData();
		objRecord.averageCalculation();
		objRecord.MinimumMaximum();
		objRecord.femaleComparator();
		objRecord.maleComparators();
		objBankRecord.printTimeStamp();
	
	}catch(Exception e){
		System.err.println("Termination of the main method");
	}
	}
}

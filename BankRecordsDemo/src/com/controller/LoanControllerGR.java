/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: LoanControllerGR.java
 * LAB WORK 04
 */
package com.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.models.daoModelGR;
import com.records.BankRecords;
import com.views.LoanView;

@SuppressWarnings("serial")
public class LoanControllerGR extends BankRecords{
	//Declare class variables,class objects and maps
	static long startTimeGR,endTimeGR;
	static Map<Long, BankRecords> bankRecordsGR= new HashMap<Long, BankRecords>();
	static Map<Long, BankRecords> newbankRecordsGR= new HashMap<Long, BankRecords>();	
	static PersistentObjectGR persObjGR;
	static Date dateGR = new Date();
	static daoModelGR daoModelGR = new daoModelGR();
	/**
	 * Non-parameterized constructor is used for calling the readData() method and persistObj() method.
	 */
	@SuppressWarnings("unchecked")
	public LoanControllerGR(){
		readData();
		persistObjGR();
	}
	
	/**
	 * This is the main driver method to call create table, insert into table, LoanView constructor and
	 * print the time stamp.
	 * @param args Arguments
	 */
	public static void main(String[] args) {
			try {
			//call the constructor for reading data and processing the data and persistObject method.
			new LoanControllerGR();
			//Call the Create Table Method
			daoModelGR.createTableGR();
			//Call the insert into table method
			daoModelGR.insertDataIntoTableGR(BankRecords.bankRecordObjs);
			//Call the loan view constructor for displaying the JTable
			new LoanView();
			//Call the print Stamp method
			printTimeStamp();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
/**
 * This method is used for serializing and deserializing the bank records, and writing into the bankrecords.ser file. 
 */
	public static void persistObjGR(){
		long l=0;
		//Iterate the bankRecords 
		for(BankRecords val: bankRecordObjs)
		bankRecordsGR.put(++l,val);
		persObjGR= new PersistentObjectGR(dateGR, bankRecordsGR);
		
		//serializing objects
		try{
			//Create a bankRecords.ser file
			FileOutputStream fileOutputStream = new FileOutputStream("bankrecords.ser");
			ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
			//Get the start time
			startTimeGR = System.currentTimeMillis();
			//Write into the .ser file 
			objectOutputStream.writeObject(persObjGR.dateGr);
			objectOutputStream.writeObject(persObjGR.bankRecordsGR);
			//Close the .ser file
			objectOutputStream.flush();
			objectOutputStream.close();
			fileOutputStream.flush();
			fileOutputStream.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		System.out.println("Serialization complete");
		System.out.println("Application going to sleep for 5 seconds!");
		try{
			System.out.println("Thread running...");
			new Thread();
			Thread.sleep(5000);
		}
		catch(InterruptedException ie){
			ie.printStackTrace();
		}
		finally{
			System.out.println("Thread running completed");
		}
		//deserialize objects
		FileInputStream fileInputStream;
		ObjectInputStream objectInputStream;
		try
		{
			fileInputStream = new FileInputStream("bankrecords.ser");
			objectInputStream= new ObjectInputStream(fileInputStream);
			 dateGR= (Date) objectInputStream.readObject();
			 newbankRecordsGR =(Map<Long, BankRecords>)objectInputStream.readObject();
			 endTimeGR= System.currentTimeMillis();
			 
			 System.out.println("Time difference between serializing and deserialzing"+(endTimeGR-startTimeGR));
			 System.out.println("Deserialized data fragments\n"+dateGR+newbankRecordsGR);
			 Long[] keys = new Long [bankRecordsGR.size()];
			 BankRecords[] values = new BankRecords[bankRecordsGR.size()];
			 int index=0;
			 for(Entry<Long, BankRecords> mapEntry:bankRecordsGR.entrySet()){
				 keys[index] = (Long) mapEntry.getKey();
				 values[index] = (BankRecords) mapEntry.getValue();
				 System.out.println("Data=>"+"Key val:"+keys[index]+"ID value:"+ values[index].getId());
				 index++;
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
}
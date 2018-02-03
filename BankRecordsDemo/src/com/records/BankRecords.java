/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: BankRecords.java
 * LAB WORK 04
 */
package com.records;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class BankRecords extends Client {

	//declare the fields
	String id, sex, region, married, saving_account, current_account, mortgage, pep, car;
	int age, children;
	double income;
	protected static ArrayList<BankRecords> bankRecordObjs = new ArrayList<BankRecords>() ;
	//public static BankRecords[] bankRecordObjs = new BankRecords[600];
	//Create the object of bank record class.
	ArrayList<List<String>> array = new ArrayList<>();
	//Generate setters ad getters for the fields.

	/**
	 * This method is used for returning the ID of the customer
	 * @return id
	 * @author Gauri
	 */
	public String getId() {
		return id; //get the detail of ID of the customer
	}

	/**
	 *  This method is used for setting the ID of the customer
	 * @param id ID of the customer.
	 * @author Gauri
	 */
	public void setId(String id) {
		this.id = id; //set the ID detail of the customer
	}

	/**
	 * This method is used for returning the customer has "CAR" or not (YES or NO)
	 * @return YES/NO
	 * @author Gauri
	 */
	public String getCar() {
		return car; //get the detail of car
	}

	/**
	 * This method is used for setting the value CAR field as YES or NO.
	 * @param car CAR Value of the customer(YES/NO).
	 * @author Gauri
	 */
	public void setCar(String car) {
		this.car = car; //set the car detail
	}

	/**
	 * This method is used for returning the GENDER of the customer.
	 * @return FEMALE/MALE
	 * @author Gauri
	 */
	public String getSex() {
		return sex; //get the detail of 
	}

	/**
	 * This method is used for setting the GENDER of the customer
	 * @param sex Gender of the customer(FEMALE/MALE)
	 * @author Gauri
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
	 * This method is used for returning the REGION of the customer
	 * @return TOWN/INNER_CITY
	 * @author Gauri
	 */
	public String getRegion() {
		return region; //get the detail of the region 
	}

	/**
	 * This method is used for setting the REGION of the customer
	 * @param region Region (TOWN or INNER_CITY)
	 * @author Gauri
	 */
	public void setRegion(String region) {
		this.region = region; //
	}

	/**
	 * This method is used for returning the customer is married or not
	 * @return YES/NO
	 * @author Gauri
	 */
	public String getMarried() {
		return married; //get the detail whether the customer is married or not. 
	}

	/**
	 * This method is used for setting whether the customer is married or not.
	 * @param married Martial Status(YES or NO)
	 * @author Gauri
	 */
	public void setMarried(String married) {
		this.married = married;
	}

	/**
	 * This method is used for returning whether the customer has saving account or not.
	 * @return YES/NO
	 * @author Gauri
	 */
	public String getSaving_account() {
		return saving_account; //get the detail of customers saving account.
	}

	/**
	 * This method is used for setting whether the customer has saving account or not.
	 * @param saving_account Saving Account (YES/NO)
	 * @author Gauri
	 */
	public void setSaving_account(String saving_account) {
		this.saving_account = saving_account;
	}

	/**
	 * This method is used for returning whether the customer has current account balance or not.
	 * @return YES/NO
	 * @author Gauri
	 */
	public String getCurrent_account() {
		return current_account; //get the detail of the customers current account.
	}

	/**
	 * This method is used for setting whether customer has current account or not.
	 * @param current_account Current Account(YES/NO)
	 * @author Gauri
	 */
	public void setCurrent_account(String current_account) {
		this.current_account = current_account; 
	}

	/**
	 * This method is used for returning whether the customer has mortgage or not.
	 * @return YES/NO
	 * @author Gauri
	 */
	public String getMortgage() {
		return mortgage; //get the detail of customers mortgage.
	}

	/**
	 * This method is used for setting whether the customer has mortgage or not.
	 * @param mortgage Mortgage(YES/NO)
	 * @author Gauri
	 */
	public void setMortgage(String mortgage) {
		this.mortgage = mortgage;
	}

	/**
	 * This method is used for returning whether the customer has PEP or not.
	 * @return YES/NO
	 * @author Gauri
	 */
	public String getPep() {
		return pep; //get the detail of PEP.
	}

	/**
	 * This method is used for setting whether the customer has mortgage or not.
	 * @param pep PEP(YES/NO)
	 */
	public void setPep(String pep) {
		this.pep = pep;
	}

	/**
	 * This method is used for returning the age of the customer.
	 * @return AGE 
	 * @author Gauri
	 */
	public int getAge() {
		return age; //get the detail of customers age.
	}

	/**
	 * This method is used for setting the customer's age.
	 * @param age AGE of teh customer.
	 * @author Gauri
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * This method is used for returning whether the customer has children or not.
	 * @return YES/NO.
	 * @author Gauri
	 */
	public int getChildren() {
		return children; //get the detail of how many childs the customer has.
	}

	/**
	 * This method is used for setting whether the customer has children or not.
	 * @param children Children(YES/NO)
	 * @author Gauri
	 */
	public void setChildren(int children) {
		this.children = children;
	}

	/**
	 * This method is used for returning the customer's income.
	 * @return Income
	 * @author Gauri
	 */
	public double getIncome() {
		return income; //get the detail of income of the customer
	}

	/**
	 * This method is used for setting the customer's income.
	 * @param income INCOME of the customer.
	 * @author Gauri
	 */
	public void setIncome(double income) {
		this.income = income;
	}

	/**
	 * <b> This method is used for reading the data inn CSV file and store the data in the array of objects. </b>
	 * This method handles File Not Found Exception, IO Exception.
	 * This method calls Process Data Funation.
	 * @author Gauri 
	 */
	@Override
	public void readData() {
		// TODO Auto-generated method stub
		BufferedReader br = null;

		//initialize reader object and set file path to root of project
		try {
			br = new BufferedReader(new FileReader
					(new File("./bank-Detail.csv")));

			String line;

			//read each record in csv file
			while ((line = br.readLine()) != null) {

				//parse each record in csv file by a comma ( , )
				//into a list stored in the arraylist-> Arrays
				array.add(Arrays.asList(line.split(",")));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("No File Found.");
			System.err.println("java.io.FileNotFoundException: bank-Detail.csv (The system cannot find the file specified");
			//e.printStackTrace();
		}
		catch (IOException e) {
			System.err.println("Error while reading the data");
			// TODO Auto-generated catch block
			//e.printStackTrace();

		}
		finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.err.println("Something went wrong while closing the file.");
				}
			}
		}
		processData();  //call function for processing record data

	}
	/**
	 * <b> This method is used for processing the data i.e Parse the string value to either int or double where it is required.</b>
	 * 	This method handles Number Format Exception.
	 * 	This method calls Print Data Method to display the result.
	 * @author Gauri
	 */
	@Override
	public void processData() {
		// TODO Auto-generated method stub
		//create index for array while iterating thru arraylist
		int idx=0;


		//create for each loop to cycle through arraylist of values 
		//and PASS that data into your record objects' setters 

		for (List<String> rowData: array){
			//initialize array of objects
			
			
			BankRecords robj =  new BankRecords();
			/*br.setAge(10);
			bankRecordObjs.add(br);
			*/
			//bankRecordObjs.add(new BankRecords());
			//robj = new BankRecords();
			//call setters below and populate them, item by item
			//parse the data where ever it is needed.
			try{
				
				robj.setId(rowData.get(0)); //get 1st column //Set ID
				//Check if there are any null values in the bank-details.csv
				checkIfNull(robj.getId()); 
				robj.setAge(Integer.parseInt(rowData.get(1))); //get 2nd column 	//Set Age
				robj.setSex(rowData.get(2)); //get 3rd column 	//Set Sex
				checkIfNull(robj.getSex()); //Check whether the value is set to Null.
				robj.setRegion(rowData.get(3)); //get 4th column	//Set Region
				checkIfNull(robj.getRegion()); //Check whether the value is set to Null.
				robj.setIncome(Double.parseDouble(rowData.get(4))); //get 5th column	//Set Income
				robj.setMarried(rowData.get(5)); //get 6th column	//Set Married Status
				checkIfNull(robj.getMarried()); //Check whether the value is set to Null.
				robj.setChildren(Integer.parseInt(rowData.get(6))); //get 7th column	//Set the number of children
				robj.setCar(rowData.get(7)); //get 8th column	//Set whether the customer has car or not
				checkIfNull(robj.getCar()); //Check whether the value is set to Null.
				robj.setSaving_account(rowData.get(8)); //get 9th column	//Set whether the customer saving account or not 
				checkIfNull(robj.getSaving_account()); //Check whether the value is set to Null.
				robj.setCurrent_account(rowData.get(9)); //get 10th column	//Set whether the customer has current saving account or not
				checkIfNull(robj.getCurrent_account()); //Check whether the value is set to Null.
				robj.setMortgage(rowData.get(10)); //get 11th column	//Set whether the customer has mortgage account or not
				checkIfNull(robj.getMortgage()); //Check whether the value is set to Null.
				robj.setPep(rowData.get(11)); //get 12th column	//Set whether the customer has PEP or not.
				checkIfNull(robj.getPep()); //Check whether the value is set to Null.
				bankRecordObjs.add(robj);
			}
			catch (NumberFormatException  e) {
				//Handling exception while parsing from String to int, String to double
				System.err.println("Error while parsing the string");
				//e.printStackTrace();
				break;
			}
		}    

	//	printData();  //call function to print objects held in memory


	}
	/**
	 * <b> This method is used for formatting the data that was processed and stored in the array of the objects. </b>
	 *  This method handles Null Pointer Exception.
	 *  @author Gauri
	 */
	@Override
	public void printData() {
		// TODO Auto-generated method stub
		//Print the headers.
		System.out.println("Welcome Bank of IIT. The below are the records of first 25 customer in the system");
		System.out.println("ID \t\t AGE \t\t SEX \t\t REGION \t\t INCOME \t\t MORTGAGE \t\t");
		System.out.println("------------------------------------------------------------------------------------------------------------------");
		try{
			//For loop for printing the first 25 records.
			for(int icount = 0 ; icount < 25 ; icount++){
				//Print the values of ID,AGE,REGION,INCOME,MORTGAGE using the object of bank record.
				System.out.printf("%s\t\t %d\t\t %s\t\t %-10s\t\t %-10.2f\t\t %s\t\t | \n",bankRecordObjs.get(icount).getId(), bankRecordObjs.get(icount).getAge(), bankRecordObjs.get(icount).getSex(),
						bankRecordObjs.get(icount).getRegion(), bankRecordObjs.get(icount).getIncome(), bankRecordObjs.get(icount).getMortgage());

				System.out.println("------------------------------------------------------------------------------------------------------------------");

			}
		}catch(NullPointerException e){
			//throw error is the object contents are null.
			System.err.println("Sorry the contents in the file are empty. Please check file again.");
		}
		System.out.println("Thank you.");
		printTimeStamp(); //Print the time stamp.
	}
	/**
	 * This method is used for checking whether a string value is null or not. It throws Null Pointer Exception.
	 * @param stringValue String Value that needs to checked whether NULL or NOT.
	 * @author Gauri
	 */
	public void checkIfNull(String stringValue){
		if(stringValue.equals(""))
			throw new NullPointerException("Null Pointer Exception");

	}
	/**
	 * This method is used for printing the time stamp.
	 * @author Gauri
	 */
	public static void printTimeStamp(){
		String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
		System.out.println("\n"
				+ "-------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Current date and time" + timeStamp + "\nProgrammed And Executed by Gauri Govind Rajulu (A20404821) \n");

	}

}

/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 10/19/2017
 * SOURCE FILE NAME: Records.java
 * LAB WORK 03
 */
package com.records;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Records extends BankRecords{
	 static FileWriter fileWriter = null;

	/**
	 * This is a non-parameterized constructor of Records file which is used to instantiate the FileWriters object. 
	 * And create bankrecords.txt file.
	 * Throws IOException.
	 * @author Gauri
	 */
	public Records() {
		try {
			//Create bankrecords.txt file.
			fileWriter = new FileWriter("bankrecords.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

/**
 * This method is used to call Average Comparator and sort the fields based on the Region and Income.
 * This method further sorts the data according to INNER_CITY,TOWN,SUBURBAN and RURAL, sums up the income and takes an average based on the region.
 * This method writes the calculated average into bankrecords.txt File.
 * @author Gauri
 */
	public static void averageCalculation(){
		try{
		//Converts ArrayList of BankRecords Object into array.
		BankRecords br[]= new BankRecords[bankRecordObjs.size()];
		br = bankRecordObjs.toArray(br);
		//This calls Average Comparator File to sort the data based on the Region and Income.
		Arrays.sort(br, new AverageComparator());
		double sumInnerCityggr = 0, sumTownggr = 0, sumRuralggr = 0, sumSuburbanggr = 0;
		double avgInnerCityggr = 0, avgTownggr = 0, avgRuralggr = 0, avgSuburbanggr = 0;
		int ctSumInnerCityggr = 0, ctSumTownggr = 0, ctSumRuralggr = 0, ctSumSuburbanggr = 0;
		
		for(int i = 0; i < br.length; i++){
			//Check whether the Region is "TOWN" and sum up the Income
			if(br[i].getRegion().equalsIgnoreCase("TOWN")){
				sumTownggr += br[i].getIncome();
				ctSumTownggr++;
			}//Check whether the Region is "RURAL" and sum up the Income
			else if(br[i].getRegion().equalsIgnoreCase("RURAL")){
				sumRuralggr += br[i].getIncome();
				ctSumRuralggr++;
			}//Check whether the Region is "SUBURBAN" and sum up the Income
			else if(br[i].getRegion().equalsIgnoreCase("SUBURBAN")){
				sumSuburbanggr += br[i].getIncome();
				ctSumSuburbanggr++;
			}//Check whether the Region is "INNER_CITY" and sum up the Income
			else if(br[i].getRegion().equalsIgnoreCase("INNER_CITY")){
				sumInnerCityggr += br[i].getIncome();
				ctSumInnerCityggr++;
			}
			
		}
		
	//Calculate the average income of the TOWN,RURAL,SUBURBAN,INNER CITY and display on the console
	avgTownggr = sumTownggr/ctSumTownggr;
	System.out.println("Start of the Program \nWelcome to Bank of IIT");
	System.out.println("********************************************************************************************************************");
	System.out.println("Average Income Per Location");
	System.out.printf(String.format("Town Average: $%.2f \n",avgTownggr));
	avgRuralggr = sumRuralggr/ctSumRuralggr;
	System.out.printf(String.format("\nRural Average: %.2f \n",avgRuralggr));
	avgSuburbanggr = sumSuburbanggr/ctSumSuburbanggr;
	System.out.printf(String.format("\nSuburban Average: $%.2f \n",avgSuburbanggr));
	avgInnerCityggr = sumInnerCityggr/ctSumInnerCityggr;
	System.out.printf(String.format("\nInner City Average: $%.2f \n",avgInnerCityggr));		
	//Write the data in the file bankrecord.txt
	try {
		fileWriter.write((String.format("Town Average: $%.2f",avgTownggr)) + "\n"
				+ (String.format("Rural Average: $ %.2f",avgRuralggr)) + "\n"
				+ (String.format("Suburban Average: $ %.2f",avgSuburbanggr)) + "\n"
				+ (String.format("Inner City Average: $ %.2f",avgInnerCityggr)) + "\n\n");
		
	} catch (IOException e) {
		e.printStackTrace();
	}
	}catch(Exception e){
		System.err.println("Error Occured. Termination of the Program");
	}

	}
	/**
	 * This method is used to call Region Comparator and sort the fields based on the Income.
	 * This method is used to filter the data based on the Region, Minimum and Maximum Income Value.
	 * This method writes the minimum and maximum value into bankrecords.txt File.
	 * @author Gauri
	 */
	public static void MinimumMaximum(){
		try{
		//Converts ArrayList of BankRecords Object into array.
		BankRecords br[]= new BankRecords[bankRecordObjs.size()];
		br = bankRecordObjs.toArray(br);
		//This calls Region Comparator File to sort the data based on the  Income.
		Arrays.sort(br, new MaximumMinimumComparator());
		double InnerCityMaxggr = 0, TownMaxggr = 0, RuralMaxggr = 0, SuburbanMaxggr = 0;
		

		for (int i = 0; i < br.length; i++) {
			//To filter out the data based "TOWN" and check the maximum income of the Town.
			if (br[i].getRegion().equalsIgnoreCase("TOWN")&& (br[i].getIncome() > TownMaxggr)) {
					TownMaxggr = br[i].getIncome();
				}
			//To filter out the data based "RURAL" and check the maximum income of the RURAL.
			 else if (br[i].getRegion().equalsIgnoreCase("RURAL") && (br[i].getIncome() > RuralMaxggr)) {
					RuralMaxggr = br[i].getIncome();
				}
			//To filter out the data based "SUBURBAN" and check the maximum income of the SUBURBAN.
			 else if (br[i].getRegion().equalsIgnoreCase("SUBURBAN") && br[i].getIncome() > SuburbanMaxggr) {
					SuburbanMaxggr = bankRecordObjs.get(i).getIncome();
			
			}//To filter out the data based "INNER_CITY" and check the maximum income of the INNER_CITY. 
			 else if (br[i].getRegion().equalsIgnoreCase("INNER_CITY") && br[i].getIncome() > InnerCityMaxggr) {
					InnerCityMaxggr = bankRecordObjs.get(i).getIncome();
				
			}
		}
		//Display the Maximum value of TOWN,RURAL,SUBURBAN and INNERCITY
		
		System.out.println("********************************************************************************************************************");
		System.out.println("Maximum Income per location");
		System.out.println("Town region maximum income : $" + TownMaxggr + "\n");
		System.out.println("Rural region maximum income : $" + RuralMaxggr + "\n");
		System.out.println("Suburban region maximum income : $" + SuburbanMaxggr + "\n");
		System.out.println("Inner City region maximum income : $" + InnerCityMaxggr + "\n");
		System.out.println("********************************************************************************************************************");
		
		double innerCityMin = br[0].getIncome();
		double ruralMin = br[0].getIncome();
		double suburbanMin = br[0].getIncome();
		double townMin = br[0].getIncome();
		for (int imin = 0; imin < br.length; imin++) {
			//To filter out the data based "INNER_CITY" and check the minimum income of the INNER_CITY.
			if (br[imin].getRegion().equals("INNER_CITY") && br[imin].getIncome() < innerCityMin) {
					innerCityMin = br[imin].getIncome();
			
			}//To filter out the data based "RURAL" and check the minimum income of the RURAL.
			else if (br[imin].getRegion().equals("RURAL") && br[imin].getIncome() < ruralMin) {
					ruralMin = br[imin].getIncome();
				}
			//To filter out the data based "SUBURBAN" and check the minimum income of the SUBURBAN.
			 else if (br[imin].getRegion().equals("SUBURBAN") && br[imin].getIncome() < suburbanMin) {
					suburbanMin = br[imin].getIncome();
				
			}//To filter out the data based "TOWN" and check the minimum income of the TOWN. 
			 else if (br[imin].getRegion().equals("TOWN") && br[imin].getIncome() < townMin) {
					townMin = br[imin].getIncome();
				}
			}
	
		
		//Display the Minimum value of TOWN,RURAL,SUBURBAN and INNERCITY
		System.out.println("Minimum Income Per Location");
		System.out.println("Town region minimum income : $" + townMin + "\n");
		System.out.println("Rural region minimum income : $" + ruralMin + "\n");
		System.out.println("Suburban region minimum income : $" + suburbanMin + "\n");
		System.out.println("Innercity region minimum income : $" + innerCityMin + "\n");
		System.out.println("********************************************************************************************************************");
		//Write the data in the file bankrecord.txt
		try {
			fileWriter.write(
					"Town region maximum income : $" + TownMaxggr + "\n" + "Rural region maximum income : $" + RuralMaxggr + "\n"
					+ "Suburban region maximum income : $" + SuburbanMaxggr + "\n"
					+ "Inner City region maximum income : $" + InnerCityMaxggr + "\n" + 
					"Town region minimum income : $" + townMin+ 
					"Rural region minimum income : $"+ ruralMin + "\n" +
					"Suburban region minimum income : $" + suburbanMin + "\n"+
					 "Innercity region minimum income : $" + innerCityMin + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}catch(Exception e){
		System.err.println("Error Occured. Termination of the Program");
	}

	}
	/**
	 * This method is used to call Female Comparator and sort the fields based on their Sex and Mortgage.
	 * This method is used to filter the data based on the Sex, Mortgage and whether they Saving Account.
	 * This method writes the count of females in bankrecords.txt File.
	 * @author Gauri
	 */

	public void femaleComparator(){
		try{
		//Converts ArrayList of BankRecords Object into array.
		BankRecords br[]= new BankRecords[bankRecordObjs.size()];
		br = bankRecordObjs.toArray(br);
		//This calls Female Comparator File to sort the data based on the  Sex and Mortgage.
		Arrays.sort(br, new FemaleComparator());
		int innerCityFemaleCountggr = 0, ruralFemaleCountggr = 0, suburbanFemaleCountggr = 0, townFemaleCountggr = 0;

		for (int i = 0; i < br.length; i++) {
			//Filter the data based on the Sex, Mortgage and whether they have saving account.
			if (br[i].getSex().equals("FEMALE") && br[i].getMortgage().equals("YES") && br[i].getSaving_account().equals("YES")) {
				//Filter out based on Inner City
					if (br[i].getRegion().equals("INNER_CITY")) {
						innerCityFemaleCountggr++;
					}//Filter out based on Rural
					else if (br[i].getRegion().equals("RURAL")) {
						ruralFemaleCountggr++;
					}//Filter out based on Suburban
					else if (br[i].getRegion().equals("SUBURBAN")) {
						suburbanFemaleCountggr++;
					}//Filter out based on Town 
					else if (br[i].getRegion().equals("TOWN")) {
						townFemaleCountggr++;
					}
				}
			}
		//Write data in the file bankrecord.txt
		try {
			fileWriter.write( "Town region females with a mortgage and savings account : " + townFemaleCountggr + 
					"Rural region females with a mortgage and savings account : " + ruralFemaleCountggr + "\n"
					+ "Suburban region females with a mortgage and savings account : " + suburbanFemaleCountggr + "\n"+ 
					"Innercity region females with a mortgage and savings account : " + innerCityFemaleCountggr
					+ "\n\n");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Display the count of females based on Mortgage and having saving account 
		System.out.println("Number of females having both a mortgage and savings account per location");
		System.out.println("Town region females with a mortgage and savings account : " + townFemaleCountggr + "\n");
		System.out.println("Rural region females with a mortgage and savings account : " + ruralFemaleCountggr + "\n");
		System.out.println("Suburban region females with a mortgage and savings account : " + suburbanFemaleCountggr + "\n");
		System.out.println("Innercity region females with a mortgage and savings account : " + innerCityFemaleCountggr + "\n");
		System.out.println("********************************************************************************************************************");
	}catch(Exception e){
		System.err.println("Error Occured. Termination of the Program");
	}
		}
	
	/**
	 * This method is used to call Male Comparator and sort the fields based on the Sex and car.
	 * This method is used to filter the data based on the Number on childern they have (i.e 1). 
	 * This method writes the count of Male into bankrecords.txt File.
	 * @author Gauri
	 */

	public static void maleComparators() {
		try{
		//Converts ArrayList of BankRecords Object into array.
		BankRecords br[]= new BankRecords[bankRecordObjs.size()];
		br = bankRecordObjs.toArray(br);
		//
		Arrays.sort(br, new MaleComparator());
		int innerCityCountggr = 0, ruralMaleCountggr = 0, suburbMaleCountggr = 0, townMaleCountggr = 0;

		for (int i = 0; i < br.length; i++) {
			//Filter out data based on number of males with both a car and 1 child per location
			if (br[i].getSex().equals("MALE") && br[i].getCar().equals("YES") && br[i].getChildren() == 1){
				//Filter out data base on "INNER_CITY"
					if (br[i].getRegion().equals("INNER_CITY")) {
						innerCityCountggr++;
					}//Filter out data base on "RURAL" 
					else if (br[i].getRegion().equals("RURAL")) {
						ruralMaleCountggr++;
					}//Filter out data base on "SUBURBAN" 
					else if (br[i].getRegion().equals("SUBURBAN")) {
						suburbMaleCountggr++;
					}//Filter out data base on "TOWN"
					else if (br[i].getRegion().equals("TOWN")) {
						townMaleCountggr++;
					}
				}

			}
		//Write the data in the file bankrecord.txt

		try {
			fileWriter.write("Town region males with a car and 1 Child in Town : " + townMaleCountggr +
					 "Rural region males with a car and 1 Child in Rural : " + ruralMaleCountggr + "\n"
					+ "Suburban region males with a car and 1 Child in SubUrb : " + suburbMaleCountggr + "\n"
					+ "Innercity region males with a car and 1 Child in Inner City : " + innerCityCountggr + "\n\n");
			closeFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Number of Males having both a car and one child per location");
		System.out.println("Town region males with a car and one Child in Town : " + townMaleCountggr + "\n");
		System.out.println("Rural region males with a car and one Child in Rural : " + ruralMaleCountggr + "\n");
		System.out.println("Suburban region males with a car and one Child in SubUrb : " + suburbMaleCountggr + "\n");
		System.out.println("Innercity region males with a car and one Child in Inner City : " + innerCityCountggr + "\n");
		System.out.println("********************************************************************************************************************");
		System.out.println("Program Ended");
		}catch(Exception e){
			System.err.println("Error Occured. Termination of the Program");
		}
	}
	
	/**
	 * This method is used to close the filewriter.
	 * @author Gauri
	 */
	public static void closeFile(){
		try{
		fileWriter.flush();
		fileWriter.close();
		}catch (Exception e) {
			System.err.println("Not Able to close the file");
			// TODO: handle exception
		}
	}

}


		
		

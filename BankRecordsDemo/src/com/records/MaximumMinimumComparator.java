/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 10/19/2017
 * SOURCE FILE NAME: MaximumMinimumComparator.java
 * LAB WORK 03
 */
package com.records;

import java.util.Comparator;

public class MaximumMinimumComparator implements Comparator<BankRecords>{
/**
 * To compare the income value of the various objects and sort the object.
 * @author Gauri
 */
	@Override
	public int compare(BankRecords obj1, BankRecords obj2) {
		 //Compare Income of various objects.
		if(obj1.getIncome() < obj1.getIncome()) return -1;
	        else if(obj1.getIncome() > obj2.getIncome()) return 1;
	        else return 0;
	}
}

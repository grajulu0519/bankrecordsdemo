/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 10/19/2017
 * SOURCE FILE NAME: MaleComparator.java
 * LAB WORK 03
 */
package com.records;

import java.util.Comparator;

public class MaleComparator implements Comparator<BankRecords>{
	/**
	 * To compare and sort the object based on their sex and based on whether they have car.
	 * @author Gauri
	 */
	@Override
	public int compare(BankRecords obj1, BankRecords obj2) {
		// TODO Auto-generated method stub
			//Filter out based on the Sex
			int result1 = obj1.getSex().compareTo(obj2.getSex());
			if (result1 != 0) {
				return result1;
			}
			//Filter out based on Car.
			return obj1.getCar().compareTo(obj2.getCar());
		}

	}



/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: AverageComparator.java
 * LAB WORK 04
 */

package com.records;

import java.util.Comparator;

public class AverageComparator implements Comparator<BankRecords>{

	@Override
	public int compare(BankRecords obj1, BankRecords obj2) {
		// TODO Auto-generated method stub
		int result = obj1.getRegion().compareTo(obj2.getRegion());
		if(result != 0){
			return result;
		}
		return (int) (obj1.getIncome()-obj2.getIncome());
	}

}

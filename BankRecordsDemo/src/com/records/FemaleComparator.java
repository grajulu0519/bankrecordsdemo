/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 10/19/2017
 * SOURCE FILE NAME: FemaleComparator.java
 * LAB WORK 03
 */
package com.records;

import java.util.Comparator;

public class FemaleComparator implements Comparator<BankRecords> {
	/**
	 * To compare and sort the object based on their sex.
	 * @author Gauri
	 */
	@Override
	public int compare(BankRecords o1, BankRecords o2) {
		//Filter out on based Sex.
		int result = o1.getSex().compareTo(o2.getSex());
		if (result != 0) {
			return result;
		}
		//Filter out on based on Mortgage.
		return o1.getMortgage().compareTo(o2.getMortgage());

	}


}

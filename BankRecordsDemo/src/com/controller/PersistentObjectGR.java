/**
 * NAME: GAURI GOVIND RAJULU
 * ID: A20404821
 * DATE: 11/12/2017
 * SOURCE FILE NAME: PersistentObjectGR.java
 * LAB WORK 04
 */
package com.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.records.BankRecords;

public class PersistentObjectGR implements Serializable
{
 
/**
 * Declare the fields
 */
Map<Long, BankRecords> bankRecordsGR = new HashMap<Long, BankRecords>();
Date dateGr = new Date();
private static final long serialVersionUID =505050505L;
/**
 * Constructor for initialization of the bank records and date fields.
 * @param dateGr Date
 * @param bankRecordsGr Bank Record
 */
public PersistentObjectGR(Date dateGr, Map<Long, BankRecords> bankRecordsGr){
	this.bankRecordsGR = bankRecordsGR;
	this.dateGr = dateGr;
}
}

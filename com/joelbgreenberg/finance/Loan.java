package com.joelbgreenberg.finance;
import java.util.Date;


public class Loan {
	
	public Loan(double principle, double interestRate, double months){
		this.principal = principle;
		this.interestRate = interestRate;
		this.months = months;
		this.initialDeposit = 0;
		this.balloonPayment = 0;
		this.startDate = null;
	}
	
	Date startDate;
	double months;
	double principal;
	double interestRate;
	double initialDeposit;
	double balloonPayment;
	
	@Override
	public String toString(){
		return "{Loan Payment on " + startDate + ": [p="+principal + ", i=" + interestRate + ", mo=" + months + "]}";
	}	
}

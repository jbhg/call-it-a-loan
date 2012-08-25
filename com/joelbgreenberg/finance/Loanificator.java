package com.joelbgreenberg.finance;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loanificator {
	
	public void start(){
		Loan l = new Loan(10000, 6.8, 48);
		
		System.out.println("Rate for Loan " + l + " is " + monthlyPayment(l));
		double interestPaid = 0;
		for(Payment p : payOffLoan(l)){
			interestPaid += p.interestPayment;
		}
		System.out.println("Total interest paid: " + interestPaid);
	}
	
	public List<Payment> payOffLoan(Loan l){
		double remainingPrincipal = l.principal;
		double monthlyPayment = monthlyPayment(l.interestRate, l.months, remainingPrincipal);
		List<Payment> payments = new ArrayList<Payment>(); 
		int months = 0;
		while(remainingPrincipal > 0.009 && months < 12 * 80) // 80 years indicates something went wrong...
		{
			Payment p = new Payment( monthlyPayment - remainingPrincipal * mRate(l.interestRate) , remainingPrincipal * mRate(l.interestRate));
			remainingPrincipal -= (monthlyPayment - remainingPrincipal * mRate(l.interestRate));
			payments.add(p);
		}
		System.out.println(payments.size() + " months.");
		return payments;
	}

	public double monthlyPayment(Loan l){
		return monthlyPayment(l.interestRate, l.months, l.principal);
	}
	
	public double monthlyPayment(double rate, double months, double principal){
		return (mRate(rate) + mRate(rate)/(Math.pow((1+mRate(rate)), months) -1) ) * principal;
	}
	
	public double mRate(double annualRate){
		return annualRate / (100 * 12);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Loanificator l = new Loanificator();
		l.start();
	}

}

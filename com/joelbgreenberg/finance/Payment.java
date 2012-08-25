package com.joelbgreenberg.finance;
import java.util.Date;

public class Payment {
	public Payment(double principalPayment, double interestPayment) {
		this.principalPayment = principalPayment;
		this.interestPayment = interestPayment;
	}

	public Payment(double principalPayment, double interestPayment, Date date) {
		this(principalPayment, interestPayment);
		this.date = date;
	}

	Date date;
	double principalPayment;
	double interestPayment;

	@Override
	public String toString() {
		return "{Payment [p=" + principalPayment + ", i=" + interestPayment
				+ ", t=" + (principalPayment + interestPayment) + "]}";
	}
}

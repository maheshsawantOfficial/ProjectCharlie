package com.jbk;

public class KOTAK extends RBI{
	public double getLoanEMI(double loanAmt,float interestRate) {
		System.out.println("In KOTAK");
		return(loanAmt*interestRate/100)/12;
	}
}

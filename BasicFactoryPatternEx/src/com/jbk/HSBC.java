package com.jbk;

public class HSBC extends RBI{
	public double getLoanEMI(double loanAmt,float interestRate) {
		System.out.println("In HSBC");
		return(loanAmt*interestRate/100)/12;
	}
}

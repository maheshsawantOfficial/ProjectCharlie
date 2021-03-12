package com.jbk;

public class ICICI extends RBI{
	public double getLoanEMI(double loanAmt,float interestRate) {
		System.out.println("In ICICI");
		
		return(loanAmt*interestRate/100)/12;
	}
}

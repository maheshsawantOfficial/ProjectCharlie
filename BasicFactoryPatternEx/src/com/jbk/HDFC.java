package com.jbk;

public class HDFC extends RBI{
	public double getLoanEMI(double loanAmt,float interestRate) {
		System.out.println("In HDFC");
		return(loanAmt*interestRate/100)/12;
	}
}

package com.jbk;

public class RBI {
		float interestRate = 8.5f;
		public double getLoanEMI(double loanAmt,float interestRate) {
			 return(loanAmt*interestRate/100)/12;

		}
}

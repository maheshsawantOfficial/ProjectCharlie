package com.jbk;

public class ObjectFactory {
	
	public static RBI getObject(String bankName) {
		
		if("HDFC".equalsIgnoreCase(bankName)){
			return new HDFC();
			
		}
		if("ICICI".equalsIgnoreCase(bankName)){
			return new ICICI();
			
		}
		if("HSBC".equalsIgnoreCase(bankName)){
			return new HSBC();
			
		}
		if("KOTAK".equalsIgnoreCase(bankName)){
			return new KOTAK();
			
		}
		return null;
		
	}

}

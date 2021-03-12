package com.jbk;

public class Client {
		public static void main(String[] args) {
			
			try{
				RBI rbi=ObjectFactory.getObject("bc");
				System.out.println(rbi.getLoanEMI(400000, 8.5f));
			}catch(Exception e) {
				System.out.println("Invalid Bank Name");
			}
		}
}
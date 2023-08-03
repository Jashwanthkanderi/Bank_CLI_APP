package com.wipro.bank.util;

public class InsufficientFundsException extends Exception {

		// TODO Auto-generated method stub
		    // Default constructor
		    public InsufficientFundsException() {
		        super();
		    }

		    // Constructor with a custom error message
		    public InsufficientFundsException(String message) {
		        super(message);
		    }

		    @Override
		    public String toString() {
		        return "INSUFFICIENT FUNDS";
		    }


	}
	


package com.wipro.bank.bean;

	import java.util.Date;

	public class TransferBean {
	    private int transactionID;
	    private int fromAccountNumber;
	    private int toAccountNumber;
	    private Date dateOfTransaction;
	    private float amount;

	    // Getter and Setter for transactionID
	    public int getTransactionID() {
	        return transactionID;
	    }

	    public void setTransactionID(int transactionID) {
	        this.transactionID = transactionID;
	    }

	    // Getter and Setter for fromAccountNumber
	    public int getFromAccountNumber() {
	        return fromAccountNumber;
	    }

	    public void setFromAccountNumber(int fromAccountNumber) {
	        this.fromAccountNumber = fromAccountNumber;
	    }

	    // Getter and Setter for toAccountNumber
	    public int getToAccountNumber() {
	        return toAccountNumber;
	    }

	    public void setToAccountNumber(int toAccountNumber) {
	        this.toAccountNumber = toAccountNumber;
	    }

	    // Getter and Setter for dateOfTransaction
	    public Date getDateOfTransaction() {
	        return dateOfTransaction;
	    }

	    public void setDateOfTransaction(Date dateOfTransaction) {
	        this.dateOfTransaction = dateOfTransaction;
	    }

	    // Getter and Setter for amount
	    public float getAmount() {
	        return amount;
	    }

	    public void setAmount(float amount) {
	        this.amount = amount;
	    }

		public void setFromAccountNumber(String string) {
			// TODO Auto-generated method stub
			
		}

		public void setToAccountNumber(String string) {
			// TODO Auto-generated method stub
			
		}
	}


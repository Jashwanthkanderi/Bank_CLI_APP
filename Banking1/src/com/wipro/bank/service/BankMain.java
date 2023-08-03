package com.wipro.bank.service;
import java.util.Optional;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.InsufficientFundsException;

public class BankMain {

		// TODO Auto-generated method stub
		

		public class BankDAO {
		    // Assume you have a method in the BankDAO to validate the account number
		    public boolean isValidAccount(int accountNumber) {
		        // Implementation to check if the account number is valid in the database
		        // Returns true if the account number exists; otherwise, returns false
		        // You may use your database query here to check account existence
		        return false; // Replace this with your actual validation logic
		    }

		    // Assume you have a method in the BankDAO to find the balance for a given account number
		    public Optional<Double> findBalance(int accountNumber) {
		        // Implementation to retrieve the account balance from the database
		        // Returns the balance if the account number is valid; otherwise, returns Optional.empty()
		        // You may use your database query here to fetch the balance
		        return Optional.empty(); // Replace this with your actual balance retrieval logic
		    }

			public void updateBalance(int fromAccountNumber, double d) {
				// TODO Auto-generated method stub
				
			}

			public void transferMoney(TransferBean transferBean) {
				// TODO Auto-generated method stub
				
			}
		}

		public class BankApp {
		    public void main(String[] args) {
		        int accountNumber = 123456; // Replace with the account number to validate and find balance

		        BankDAO bankDAO = new BankDAO();

		        // Task 1: Validate the account number
		        if (!bankDAO.isValidAccount(accountNumber)) {
		            System.out.println("ACCOUNT NUMBER INVALID");
		            return;
		        }

		        // Task 2: Find the balance for the given account number
		        Optional<Double> balanceOpt = bankDAO.findBalance(accountNumber);
		        if (balanceOpt.isPresent()) {
		            double balance = balanceOpt.get();

		            // Task 3: Return the message in the given format
		            System.out.println("BALANCE IS: " + balance);
		        } else {
		            System.out.println("Unable to fetch balance for the account.");
		        }
		    }
		}
		public class BankService {
		    private BankDAO bankDAO; // Assuming you have a BankDAO class to interact with the database

		    public BankService() {
		        // Initialize the BankDAO instance
		        bankDAO = new BankDAO();
		    }

		    public String transfer(TransferBean transferBean) {
		        // Step 1: If transferBean is null, return "INVALID"
		        if (transferBean == null) {
		            return "INVALID";
		        }

		        // Step 2: Validate both the account numbers in the transferBean
		        int fromAccountNumber = transferBean.getFromAccountNumber();
		        int toAccountNumber = transferBean.getToAccountNumber();

		        if (!bankDAO.isValidAccount(fromAccountNumber) || !bankDAO.isValidAccount(toAccountNumber)) {
		            return "INVALID ACCOUNT";
		        }

		        // Step 3: Check if the fromAccountNumber has sufficient funds to transfer
		        double transferAmount = transferBean.getAmount();
		        Optional<Double> fromAccountBalanceOpt = bankDAO.findBalance(fromAccountNumber);
		        if (fromAccountBalanceOpt.isEmpty()) {
		            return "Unable to fetch balance for the fromAccountNumber.";
		        }

		        double fromAccountBalance = fromAccountBalanceOpt.get();
		        if (fromAccountBalance < transferAmount) {
		            // Step 4: Throw InsufficientFundsException if the payer does not have sufficient money
		            try {
		                throw new InsufficientFundsException();
		            } catch (InsufficientFundsException e) {
		                // Exception is caught, return "INSUFFICIENT FUNDS"
		                return "INSUFFICIENT FUNDS";
		            }
		        }

		        // Step 5: Perform the transfer operation
		        try {
		            // Update account_tbl to reduce the amount from fromAccountNumber and add it to toAccountNumber
		            bankDAO.updateBalance(fromAccountNumber, -transferAmount);
		            bankDAO.updateBalance(toAccountNumber, transferAmount);

		            // Include the transaction detail in the transfer_tbl using the transferMoney function
		            bankDAO.transferMoney(transferBean);

		            // Step 6: If step 5 was successful, return "SUCCESS"
		            return "SUCCESS";
		        } catch (Exception e) {
		            // Exception occurred during the transfer, return an appropriate message
		            return "TRANSFER FAILED";
		        }
		    }

			public char[] checkBalance(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		}
		@SuppressWarnings("null")
		public static void main(String[] args) {
			Object bankMain = null;
			//Object bankMain;
			// View Balance
			System.out.println(( (BankService) bankMain).checkBalance("1234567890"));
			 
			// TransferMoney
			TransferBean transferBean = new TransferBean();
			 
			transferBean.setFromAccountNumber("1234567890");
			transferBean.setAmount(500);
			transferBean.setToAccountNumber("1234567891");
			transferBean.setDateOfTransaction(new java.util.Date());
			 
			System.out.println(((BankService) bankMain).transfer(transferBean));
			}




	}

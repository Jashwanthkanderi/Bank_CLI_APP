package com.wipro.bank.dao;

	import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wipro.bank.bean.TransferBean;

	public class BankDAO {
	    // Assuming you have a connection to the database named 'connection'

	    // Method to generate a 4-digit auto-generated number using the transactionId_seq sequence
	    public int generateSequenceNumber() throws SQLException {
	        String sql = "SELECT transactionId_seq.NEXTVAL FROM DUAL";
	        try (Statement stmt = connection.createStatement();
	             ResultSet resultSet = stmt.executeQuery(sql)) {
	            if (resultSet.next()) {
	                return resultSet.getInt(1);
	            }
	        }
	        throw new SQLException("Failed to generate the sequence number.");
	    }

	    // Method to check if the account number is valid in the account_tbl
	    public boolean validateAccount(String accountNumber) throws SQLException {
	        String sql = "SELECT COUNT(*) FROM account_tbl WHERE Account_Number = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, accountNumber);
	            try (ResultSet resultSet = pstmt.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count > 0;
	                }
	            }
	        }
	        throw new SQLException("Failed to validate the account number.");
	    }

	    // Method to find the balance of an account in the account_tbl
	    public float findBalance(String accountNumber) throws SQLException {
	        String sql = "SELECT Balance FROM account_tbl WHERE Account_Number = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setString(1, accountNumber);
	            try (ResultSet resultSet = pstmt.executeQuery()) {
	                if (resultSet.next()) {
	                    return resultSet.getFloat("Balance");
	                }
	            }
	        }
	        return -1; // Account number not found, return -1
	    }

	    // Method to insert the transferBean values into the transfer_tbl
	    public boolean transferMoney(TransferBean transferBean) throws SQLException {
	        String sql = "INSERT INTO transfer_tbl (Transaction_ID, Account_Number, Beneficiary_Account_Number, Date_Of_Transaction, Amount) VALUES (?, ?, ?, ?, ?)";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            int transactionID = generateSequenceNumber();
	            pstmt.setInt(1, transactionID);
	            pstmt.setLong(2, transferBean.getFromAccountNumber());
	            pstmt.setLong(3, transferBean.getToAccountNumber());
	            pstmt.setDate(4, new java.sql.Date(transferBean.getDateOfTransaction().getTime()));
	            pstmt.setFloat(5, transferBean.getAmount());

	            int rowsInserted = pstmt.executeUpdate();
	            return rowsInserted > 0;
	        }
	    }

	    // Method to update the balance for an account in the account_tbl
	    public boolean updateBalance(String accountNumber, float newBalance) throws SQLException {
	        String sql = "UPDATE account_tbl SET Balance = ? WHERE Account_Number = ?";
	        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	            pstmt.setFloat(1, newBalance);
	            pstmt.setString(2, accountNumber);

	            int rowsUpdated = pstmt.executeUpdate();
	            return rowsUpdated > 0;
	        }
	    }
	}



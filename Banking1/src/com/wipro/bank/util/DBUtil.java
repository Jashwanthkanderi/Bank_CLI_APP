package com.wipro.bank.util;

public class DBUtil {
		    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
		    private static final String DB_USERNAME = "B202304";
		    private static final String DB_PASSWORD = "B202304";

		    // Method to get the database connection
		    public static Connection getDBConnection() throws SQLException {
		        Connection connection = null;
		        try {
		            // Load the MySQL JDBC driver (replace with the appropriate driver for your database)
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            
		            // Establish the connection using the connection details
		            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		        } catch (ClassNotFoundException e) {
		            e.printStackTrace();
		        }
		        return connection;
		    }

		
	}


package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * This class carries on multiple methods.
 * It carries database connection.
 * A method to insert update delete SQL Query.
 * A method for retrieving data from database.
 */

public class DB {

	// Singleton Design Pattern
	public static DB db = new DB();
	public Connection connection;

	//Connecting to the MS SQL driver
	public DB() {

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			createConnection();
		} catch (Exception e) {
			System.err.println("Something went wrong! Please try again...");
		}

	}

	//returns a single objects
	public static DB getDB() {
		return db;
	}
	
	

	//connecting to database
	public void createConnection() {
		try {

			String url = "jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true";
			connection = DriverManager.getConnection(url);
			//System.out.println("Connection created");

		} catch (Exception e) {
			System.err.println("Something went wrong! Please try again...");
		}
	}

	// WRITE OPERATION (Insert/Update/Delete)
	public int executeSQL(String sql) {

		int result = 0;

		try {
			Statement stmt = connection.createStatement();
			result = stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.err.println("Something went wrong! Please try again...");
		}

		return result;
	}

	// READ OPERATION (SELECT)
	public ResultSet executeRetrieveQuery(String sql) {

	    // ResultSet holds Table Data
		ResultSet set = null;

		try {

			Statement stmt = connection.createStatement();
            // It displays all the rows of table
		 	set = stmt.executeQuery(sql);

		} catch (Exception e) {
			System.err.println("Something went wrong! Please try again...");
		}

		return set;

	}

//	public void closeConnection() {
//		try {
//			connection.close();
//			System.out.println("[DB] Connection Closed..");
//		} catch (Exception e) {
//			System.err.println("[DB] [Connection] Something Went Wrong: " + e);
//		}
//	}
	
}

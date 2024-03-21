package Controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;


/*
 * This class contains method to view transacted reports as per share name and date&time for users.
 */


public class TransactionReport {
      
	Scanner sc = new Scanner(System.in);
	
	 public void report() throws Exception {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");

		    Statement smt = con.createStatement();
		  
			System.out.println("Enter your name: ");
			String name = sc.nextLine();
			System.out.println("1: To view report by share name\n2: To view report by date range: ");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1: 
				System.out.println("Enter share name: ");
				String sharename = sc.nextLine();
	    		ResultSet set = smt.executeQuery("select Share_name,Number_of_share,Transacted_price,Transaction_type,date_time from Transactions where User_name =  '"+name+"' and Share_name = '"+sharename+"' ");
	    		
	    		while (set.next()) {
	    		 sharename = set.getString("Share_name");
	 			 int numberofshare = set.getInt("Number_of_share");
	 			 float transactedprice = set.getFloat("Transacted_price");
	 			 String transactiontype = set.getString("Transaction_type");
	 			 String datetime = set.getString("date_time");
	 			 
	 			 System.out.println("Share name: "+ sharename +"\n"+"Number of Shares: "+ numberofshare +"\n"+"Transacted price + Taxes: "+ transactedprice +"\n"+"Transaction type: "+transactiontype+"\nDate and Time: "+datetime);
	 			 System.out.println("\n");
	    		}	
	    		break;
	    		
			case 2: 
				System.out.println("Enter start date (yyyy-mm-dd): ");
				String startdate = sc.nextLine();
				System.out.println("Enter end date (yyyy-mm-dd): ");
				String enddate = sc.nextLine();
	    		ResultSet set1 = smt.executeQuery("select Share_name,Number_of_share,Transacted_price,Transaction_type,date_time from Transactions where date_time >=  '"+startdate+" 00:00:00' and date_time < '"+enddate+" 23:59:59' ");
	    		while (set1.next()) {
		    		 sharename = set1.getString("Share_name");
		 			 int numberofshare = set1.getInt("Number_of_share");
		 			 float transactedprice = set1.getFloat("Transacted_price");
		 			 String transactiontype = set1.getString("Transaction_type");
		 			 String datetime = set1.getString("date_time");
		 			 
		 			 System.out.println("Share name: "+ sharename +"\n"+"Number of Shares: "+ numberofshare +"\n"+"Transacted price + Taxes: "+ transactedprice +"\n"+"Transaction type: "+transactiontype+"\nDate and Time: "+datetime);
		 			 System.out.println("\n");
		    		}
	    		
				break;
				
			default:
				System.out.println("Invalid input");
			}
}
}

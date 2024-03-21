package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import DAO.DB;

/*
 * This class is for transaction table which shows all the attributes of buying selling stocks
 * This class carries two methods:
 * charge method is to display whenever a transaction happens it will display all the details
 * second method is to display dmat account details
 * CREATE TABLE Transactions (
Transaction_id int PRIMARY KEY IDENTITY (1,1) NOT NULL,
Number_of_share int NOT NULL	,
User_name nvarchar(50) FOREIGN KEY REFERENCES User_detail(User_name)NOT NULL,
Share_name nvarchar(30) FOREIGN KEY REFERENCES Shares(Share_name) NOT NULL,
Transacted_price float NOT NULL,
Transaction_type nvarchar(15) NOT NULL,
date_time datetime DEFAULT(getdate())
);
 */

public class Transaction {
	    int datetime;
	    int Transactionid;
	    String sharename;
	    String username;
	    double numberofshare;
	    long amount;
	    int transcharge;
	    int stt;
	    
	    DB db = new DB();
	  public void charge(String username , double finalprice ,double numberofshare, String sharename, String transtype) throws Exception {
		    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");
			
			Statement smt = con.createStatement();
			
			int result = smt.executeUpdate("insert into Transactions (Number_of_share, User_name, Share_name,Transacted_price,Transaction_type)values("+numberofshare+" ,'"+username+"','"+sharename+"',"+finalprice+",'"+transtype+"' ); ");
			   
			if (result>0) {
				System.out.println("Transaction completed");
			}
			else {
				System.out.println("Transaction not completed");
			}
			
	  }
	  
	 public void method() throws Exception { 
		 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=divyam@123;trustServerCertificate=true");
	  
	   Statement smt = con.createStatement();
   	   Scanner sc = new Scanner(System.in);
   	   
       System.out.println("Enter your name: ");
       String name = sc.nextLine();
       
       int size = 0;
       ResultSet set = smt.executeQuery("SELECT User_detail.User_name,Transactions.Number_of_share,Transactions.date_time,Transactions.Share_name,Transaction_type FROM Transactions, User_detail where User_detail.User_name = Transactions.User_name AND User_detail.User_name = '"+name+"';");
       
       while (set.next()) {
       	size = 1;
       	System.out.println("User Name: "+set.getString("User_name"));
       	System.out.println("Number of shares: "+set.getInt("Number_of_share"));
       	System.out.println("Date&Time: "+set.getString("date_time"));
       	System.out.println("Share Name: "+set.getString("Share_name"));
       	System.out.println("Transaction Type: "+set.getString("Transaction_type"));
       	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
       }
       if(size==0) {
         	System.out.println("Unable to fetch details\nAccount is not present");
         }
         else {
        	 
         	System.out.println("Details Displayed");
         }

		
      }

	  }
	       

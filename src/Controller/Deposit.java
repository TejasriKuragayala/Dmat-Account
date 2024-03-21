package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/*
 * This class carries one method called dep it handles all operations.
 * It deposits money make changes in users's account balance.
 * Deducts taxes on transacted price and adds whole amount in account balance of user.
 */


public class Deposit {
   String username;
   float amount;
   
	public void dep() throws SQLException, Exception {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");
		
     	Statement smt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		 float charge = (float) 0.001;
		 System.out.println("Enter your name: ");
		 username = sc.nextLine();
		 System.out.println("Enter amount you want to deposit in your account: ");
		 amount = sc.nextLong();
		 
		 float trans_charge = amount * charge;
		 float ans = amount - trans_charge;
		
		 int result = smt.executeUpdate("update User_detail set Account_bal = Account_bal +"+ans+" where User_name = '"+username+"';");
		 if (result>0) {
			 System.out.println("Total amount including transaction charges: " + ans);
	 		   System.out.println("Amount deposited in your account succssesfully");
	 	   }
	 	   else {
	 		   System.out.println("Amount didn't deposited in your account Try again later");
	 	   }
	}
}

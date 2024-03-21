package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * This class carries one method called withdraw it handles all operations.
 * It withdraw money make changes in users's account balance.
 * Deducts taxes on transacted price and deducts whole amount from account balance of user.
 */

public class Withdraw {
	String username;
	   long amount;
	   
	   public void withdraw() throws SQLException, Exception {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");
			
			Statement smt = con.createStatement();
			
			Scanner sc = new Scanner(System.in);
			float charge = (float) 0.001;
			
			 System.out.println("Enter your name: ");
			 username = sc.nextLine();
			 System.out.println("Enter amount you want to withdraw from your account: ");
			 amount = sc.nextLong();
			 
			 float trans_charge = amount * charge;
			 float ans = amount + trans_charge;
			 
			 int result = smt.executeUpdate("update User_detail set Account_bal = Account_bal - "+ans+" where User_name = '"+username+"';");
			 if (result>0) {
		 		   System.out.println(result + " record updated");
		 	   }
		 	   else {
		 		   System.out.println("no record updated");
		 	   }
		}
}

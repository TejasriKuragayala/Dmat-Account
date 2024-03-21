package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import DAO.UserDAO;
import Model.FrontApp;

/*
 * It carries two methods.
 * one to create user account in application with help of DAO interface.
 * One to login in application by checking account number from database.
 */


public class TakingUserDetail {

      public TakingUserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void createaccount() throws Exception {
    	  UserDAO dao = new UserDAO();
    	  
    	  Scanner sc = new Scanner(System.in);
    	  
    	  User user = new User();
    	  System.out.println("Enter your name: ");
    	  user.username = sc.nextLine();
    	  
    	  System.out.println("Enter your account number: ");
    	  user.accountnumber = sc.nextLong();
    	  sc.nextLine();
    	  
    	  System.out.println("Enter your email id: ");
    	  user.email = sc.nextLine();
    	  
    	  System.out.println("Enter your country: ");
    	  user.country = sc.nextLine();
    	  
    	 
    	  int result = dao.insert(user);
    	  if(result>0) {
    		  System.out.println(user.username +" Account created"); 
    		  FrontApp front = new FrontApp();
    	      front.frontpage();
    	  }
    	  else {
    		  System.out.println(user.username +" Something went wrong please try again..");
    	  }
      }
      
      public static void login() throws Exception {
    	  
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");
  		
  		
  		  Statement smt = con.createStatement();
    	  Scanner sc = new Scanner(System.in);
    	  System.out.println("Enter your details to login account");
    	  
    	  System.out.println("Enter your account number : ");
          long accountnumber = sc.nextLong();
          sc.nextLine();
          
          System.out.println("Enter your name");
          String username = sc.nextLine();
          
          int result = 0;
          ResultSet set = smt.executeQuery("select count(*) from User_detail where Account_number = "+accountnumber+" and User_name = '"+username+"';");
          
          while (set.next()) {
          	result = set.getInt(1);
          	
          }
          if(result==0) {
          	System.out.println("User doesn't exist (create account)/ Invalid credentials Please re-enter your account details\nPlease close the tab: (");
          }
          else {
          	System.out.println("Succesfully Login");
          	FrontApp front = new FrontApp();
  	        front.frontpage();
          }
      }
      
      
}

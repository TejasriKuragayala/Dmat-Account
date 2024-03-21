package Model;

import java.util.Scanner;

import Controller.Shares;
import DAO.ShareDAO;

/*
This class carries hard coded admin details and will do all the operations in share table
 */
public class ShareAdmin {
	
	public void admin() {
		final String admin = "Learnoa@mail.com";
		final String password = "learnoa@123";
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter admin id: ");
		String name = sc.nextLine();
		System.out.println("Enter password: ");
		String pwd = sc.nextLine();
		
		if(name.equals(admin)&&pwd.equals(password)) {
			System.out.println("Succesfully Logged In continue with operations");
			while(true) {
			System.out.println("1:Insert shares\n2:Update shares\n3: Delete shares\n4: Exit");
			int operations = sc.nextInt();
			switch(operations) {
			case 1: 
				ShareAdmin insert = new ShareAdmin();
				insert.stockinsert();
				break;
			case 2: 
				ShareAdmin update = new ShareAdmin();
				update.stockinsert();
				break;
			case 3: 
				ShareAdmin delete = new ShareAdmin();
				delete.stockinsert();
				break;
			case 4: 
				System.out.println("Thank you");
				break;
			default :
				System.out.println("Wrong input");
			}
		}
			}
		else {
			System.out.println("Try again");
		}
		
	}
    
	public void stockinsert() {
		
	ShareDAO dao = new ShareDAO();
	  
	Scanner sc = new Scanner(System.in);
	Shares admin = new Shares();
	
	System.out.println("Enter Share name: ");
    admin.stockname  = sc.nextLine();
    
    System.out.println("Enter your Share Id: ");
    admin.stockid = sc.nextInt();
    
    System.out.println("Enter your per stock price: ");
    admin.stockprice = sc.nextFloat();
    
     int result = dao.insert(admin);
	  if(result>0) {
		  System.out.println("Stocks succesfully inserted");
	  }
	  else {
		  System.out.println(" Something went wrong please try again..");
	  } 
}
	public void stockdelete() {
		
		ShareDAO dao = new ShareDAO();
		  
		Scanner sc = new Scanner(System.in);
		Shares admin = new Shares();
		
		System.out.println("Enter Share name: ");
	    admin.stockname  = sc.nextLine();
	    
	    int result = dao.delete(admin);
		  if(result>0) {
			  System.out.println("Stocks succesfully Deleted"); 
		  }
		  else {
			  System.out.println(" Something went wrong please try again..");
		  }
	}
	
	public void stockupdate() {
		ShareDAO dao = new ShareDAO();
		  
		Scanner sc = new Scanner(System.in);
		Shares admin = new Shares();
		
		System.out.println("Enter Share name: ");
	    admin.stockname  = sc.nextLine();
	    
	    System.out.println("Enter your Share Id: ");
	    admin.stockid = sc.nextInt();
	    
	    System.out.println("Enter your per stock price: ");
	    admin.stockprice = sc.nextFloat();
	    
	    int result = dao.insert(admin);
		  if(result>0) {
			  System.out.println("Stocks succesfully updated"); 
		  }
		  else {
			  System.out.println(" Something went wrong please try again..");
		  } 
	}
}

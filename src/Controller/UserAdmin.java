package Controller;

import java.util.Scanner;

import DAO.ShareDAO;
import DAO.UserDAO;

public class UserAdmin {
    
	public void userdelete() {
		Scanner sc = new Scanner(System.in);
	
    		UserDAO dao = new UserDAO();
    		User user = new User();
    		
    		System.out.println("Enter your name : ");
            user.username = sc.nextLine();
    	    
    	    int result = dao.delete(user);
    		  if(result>0) {
    			  System.out.println("Your profile deleted successfully"); 
    		  }
    		  else {
    			  System.out.println(" Something went wrong please try again..");
    		  }
    	}
	public void userupdate() {
		Scanner sc = new Scanner(System.in);
		
		UserDAO dao = new UserDAO();
		User user = new User();
		
		System.out.println("Enter user name: ");
	    user.username  = sc.nextLine();
	    
	    System.out.println("Enter your account balance: ");
	    user.accountbal = sc.nextInt();
	    
	    System.out.println("Enter your account number: ");
	    user.accountnumber = sc.nextInt();
	    sc.nextLine();
	    
	    System.out.println("Enter your email: ");
	    user.email  = sc.nextLine();
	    
	    System.out.println("Enter your country: ");
	    user.country  = sc.nextLine();
	    
	    int result = dao.update(user);
		  if(result>0) {
			  System.out.println("Profile succesfully updated"); 
		  }
		  else {
			  System.out.println(" Something went wrong please try again..");
		  } 
	}
	
	}


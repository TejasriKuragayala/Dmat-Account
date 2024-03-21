package Model;

import java.util.Scanner;
import Controller.TakingUserDetail;

/*
 * It carries a method named register.
 * Which carries menu to create or login account.
 * Then after above operation it will run main menu of frontapp class.
 */

public class RegisterPage {
         
	public void register() throws Exception {
	 Scanner sc = new Scanner(System.in);
	
	 System.out.println("1: To create D-Mat account\n2: To login the user/admin account\n3: To exit the account");
     int choice = sc.nextInt();
     
     if(choice ==1) {
     	TakingUserDetail create = new TakingUserDetail();
     	create.createaccount();
     	
     }
     else if(choice ==2) {
    	System.out.println("1: User Account\n2: Admin Account");
    	int acc = sc.nextInt();
    	if(acc==1) {
    		TakingUserDetail detail = new TakingUserDetail();
            detail.login();
            
    	}
    	if(acc==2) {
    		ShareAdmin detail = new ShareAdmin();
    		detail.admin();
    	}
     	
     }
     else if(choice ==3) {
    	 System.out.println("Thank you for visiting");
     }
     else {
     	System.out.println("You have entered invalid input");
     }

}
}
package Model;

import java.util.List;
import java.util.Scanner;
import Controller.BuyShare;
import Controller.Deposit;
import Controller.SellShare;
import Controller.Shares;
import Controller.Transaction;
import Controller.TransactionReport;
import Controller.UserAdmin;
import Controller.Withdraw;
import DAO.ShareDAO;

/*
 * It carries a method frontpage.
 * Which carries main menu of switch.
 */

public class FrontApp {
	
	
	    public void frontpage() throws Exception {

	        Scanner sc = new Scanner(System.in);
	        int menu;
	        

	        do {
	            System.out.println(
	                    "0: To Exit the application\n1: To Display your Dmat account details\n2: To Deposit Money\n3: To Withdraw Money\n4: To Buy stocks\n5: To Sell stocks\n6: To View shares report\n7: To view transaction report\n8: To Delete/update my profile");
	            menu = sc.nextInt();

	            switch (menu) {
	                case 1:
	                	Transaction dmatdetails = new Transaction();
	                	dmatdetails.method();
	                    System.out.println("Thankyou For Checking details");
	                    break;
	                case 2:
	                	Deposit depo = new Deposit();
	            		depo.dep();
	                    break;
	                case 3:
	                	Withdraw with = new Withdraw();
	            		with.withdraw();
	                    System.out.println("You have Withdrawn money from your D-Mat account");
	                    break;
	                case 4:
	                	BuyShare buy = new BuyShare();
	            		buy.buy();
	                    break;
	                case 5:
	                	SellShare selling = new SellShare();
	                	selling.sell();
	                    break;
	                case 6:
	                	ShareDAO list = new ShareDAO();
	        			List<Shares> share = list.query();
	        			for(Shares shares : share) {
	        				System.out.println();
	        				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        				System.out.println(shares);
	        				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	        			}
	                    break;
	                case 7:
	                	TransactionReport transreport = new TransactionReport();
	                	transreport.report();
	                    break;
	                case 8:
	                	System.out.println("Enter\n1: Update profile\n2:Delete profile");
	                	int choice = sc.nextInt();
	                	if(choice ==1) {
	                		UserAdmin profile = new UserAdmin();
	                		profile.userupdate();
	                	}
	                	else if(choice ==2) {
	                		UserAdmin profile = new UserAdmin();
	                		profile.userdelete();
	                	}
	                	else {
	                		System.out.println("Wrong input");
	                	}
	                    break;
	                case 0:
	                    System.out.println("Thankyou For using Application");
	                    break;
	                default:
	                    System.out.println("You have entered wrong data\nPlease Re-enter");

	            }
	        } while (menu != 0);
	        sc.close();

	    }

}

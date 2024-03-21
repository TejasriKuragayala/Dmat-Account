package Controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Scanner;


/*
 * This class carries one method called buying which does all operation.
 * It checks for weather the share is present in application or not if it is present then it does below operations.
 * It buys share and make changes in user's account balance  
 * Deducts taxes on transacted price and deducts whole amount from account balance of user
 * Increases the number of shares from user account.
 */


public class BuyShare extends Shares {
	String username;
	double numberofshare;
	String sharename;

        public void buy() throws Exception {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");
    		
    		Statement smt = con.createStatement();
    		
    		Scanner sc = new Scanner(System.in);
    		Shares sharedetail = new Shares();
    		
    		 float charge = (float) 0.001;
    		 System.out.println("Enter your name: ");
    		 username = sc.nextLine();
    		 System.out.println("Enter share name you want to buy: ");
    		 sharename = sc.nextLine();

    		 double price = 0;
    		 ResultSet set = smt.executeQuery("select Share_price from Shares where Share_name =  '"+ sharename+"' ");
    		 double finalprice = 0;
    		 
             boolean  exists = set.next(); 
             price = set.getDouble(1);
                
             	
             	if(exists) {
             
             	  if(price==0) {
                   	System.out.println("share doesn't exist please check the list of shares");
                   }
                   else {
                   	System.out.println(" share exists ");
                   	System.out.println("Enter number of share you want to buy: ");
               		numberofshare = sc.nextDouble();
               		double priceofshares = numberofshare*price;
               		System.out.println("Total price of stock: "+priceofshares);
               		
               		double stt = 0.001*priceofshares;
               		double trans_charge = 0.005*priceofshares;
               		double transcharge = 100;
               		
               		if(trans_charge> transcharge) {
               			finalprice = priceofshares + trans_charge;
               		}
               		else {
               			finalprice = priceofshares + transcharge;
               		}
               		finalprice = finalprice + stt;
               		System.out.println("Stock price + Taxes : "+finalprice);
                    }
             	
               		int result = smt.executeUpdate("update User_detail set Account_bal = Account_bal - "+finalprice+" where User_name = '"+username+"' ");
           	 		System.out.println(result>0 ? "Account updated": "Account not updated" );
           	 		
           	 		String transtype = "Bought";
           	 
           	 	 Transaction trans = new Transaction();
           	 	 trans.charge(username,finalprice,numberofshare,sharename,transtype);
               		       
             }
             	else {
             		System.out.println("Share doesnt exists please check the list of shares");
             	}
           
    		 
       }
}

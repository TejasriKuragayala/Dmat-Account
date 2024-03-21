package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


/*
 * This class carries one method called selling which does all operation.
 * It checks for weather the share is present in user account balance or not if it is present then it does below operations.
 * It sells share and make changes in user's account balance. 
 * Deducts taxes on transacted price and adds whole amount from account balance of user.
 * Decreases the number of shares from user account.
 */


public class SellShare extends Shares {
	String username;
	double share;
	String sharename;
	
	public void sell() throws Exception {
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");
		
		Statement smt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		Shares sharedetail = new Shares();
		User temp = new User();
		
		 float charge = (float) 0.001;
		 System.out.println("Enter your name: ");
		 username = sc.nextLine();
		 System.out.println("Enter share name you want to sell: ");
		 sharename = sc.nextLine();
		 
		 double price = 0;
		 ResultSet set = smt.executeQuery("select Share_price from Shares where Share_name =  '"+ sharename+"' ");
         boolean exists = set.next(); 
         	price = set.getDouble(1);
         	
         	double finalprice = 0;
         	
         	if(exists) {
         	        
         	  if(price==0) {
               	System.out.println("Share doesn't exists");
               }
         	  
         	  
               else {
            	   
            	ResultSet set1 = smt.executeQuery("select User_name, sum(CASE WHEN Transaction_type = 'Bought' THEN Number_of_share ELSE -Number_of_share END) AS Total_shares from Transactions where User_name = '"+username+"' And Share_name = '"+sharename+"' Group BY User_name;");
            	int totalshares = 0;  
            	while(set1.next()) {
            		   totalshares = set1.getInt("Total_shares");
            	   }
            	
               	System.out.println("Enter number of share you want to sell: ");
           		share = sc.nextDouble();
           		
                if(totalshares == 0 || totalshares < share ) {
                	System.out.println("Not enough shares please buy");
                	return;
            	}
           		
           		double priceofshares = share*price;
           		System.out.println("Total share price: "+priceofshares);
           		
           		double stt = 0.001*priceofshares;
           		double trans_charge = 0.005*priceofshares;
           		double transcharge = 100;
           		
           		
           		if(trans_charge> transcharge) {
           			finalprice = priceofshares - trans_charge;
           		}
           		
           		else {
           			finalprice = priceofshares - transcharge;
           		}
           		
           		finalprice = finalprice - stt;
           		System.out.println("Transacted Price : "+finalprice);
           		int result = smt.executeUpdate("update User_detail set Account_bal = Account_bal + "+finalprice+" where User_name = '"+username+"' ");
           	    
       	        System.out.println(result>0 ? "Account updated": "Account not updated" );
       	        String transtype = "Sold";
       	        
       	 	    Transaction trans = new Transaction();
       	 	    trans.charge(username,finalprice,share,sharename,transtype);
               }	       
         }
         }
         }

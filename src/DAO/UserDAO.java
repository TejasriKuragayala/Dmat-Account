package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.User;


/*
 * This class implements DAO interface to use its functionalities.
 * It carries 4 methods.
 * Insert, update , delete data from database which can be done by users only.
 * It also carries a method to list down the data of users from database.
 */


public class UserDAO implements DAO<User> {
	
	DB db = DB.getDB();
	
	@Override
	public int insert(User object) {
		String sql = "INSERT INTO User_detail (User_name, Account_number, Account_bal, Email_Id,Country_name) Values ('"+object.getUsername()+"',"+object.getAccountnumber()+","+object.getAccountbal()+", '"+object.getEmail()+"','"+object.getCountry()+"')";
		System.out.println(sql);
		
		int result = db.executeSQL(sql);
		return result;
	}

	@Override
	public int update(User object) {
		String sql = "update User_detail set username = '"+object.getUsername()+"', accountbal = "+object.getAccountbal()+",email = '"+object.getEmail()+"', phone ='"+object.getCountry()+"' where accountnumber = "+object.getAccountnumber()+"";
		System.out.println(sql);
		
		int result = db.executeSQL(sql);
		return result;
	}

	@Override
	public int delete(User object) {
		String sql = "delete from User_detail where username = "+object.getUsername(); 
		System.out.println(sql);
		
		int result = db.executeSQL(sql);
		return result;
	}

	@Override
	public List<User> query() {
		List<User> user = new ArrayList<User>();
		String sql ="select * from User_detail";
		ResultSet set = db.executeRetrieveQuery(sql);
		
		try {
			while (set.next()) {
				User users = new User();
				users.username = set.getString(1);
				users.accountnumber = set.getLong(2);
				users.accountbal = set.getFloat(3);
				users.email = set.getString(4);
				users.country = set.getString(5);
				
				user.add(users);
				
			}
		} catch (SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
		return user;
	}

}

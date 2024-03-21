package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Controller.Shares;


/*
 * This class implements DAO interface to use its functionalities.
 * It carries 4 methods.
 * Insert, update , delete data from database which can be done by admin only.
 * It also carries a method to list down the data of shares from database.
 */


public class ShareDAO implements DAO<Shares> {
	DB db = DB.getDB();
	@Override
	public int insert(Shares object) {
		String sql = "INSERT INTO Shares (Share_name, Share_ID, Share_price) Values ('"+object.getStockname()+"',"+object.getStockid()+","+object.getStockprice()+")";
		System.out.println(sql);
		
		int result = db.executeSQL(sql);
		return result;
	}

	@Override
	public int update(Shares object) {
		String sql = "update Shares set Share_name = '"+object.getStockname()+"', Share_id = "+object.getStockid()+", Share_price = "+object.getStockprice()+"'";
		System.out.println(sql);
		
		int result = db.executeSQL(sql);
		return result;
		
	}

	@Override
	public int delete(Shares object) {
		String sql = "delete from Shares where Share_name = "+object.getStockname(); 
		System.out.println(sql);
		
		int result = db.executeSQL(sql);
		return result;
	}

	@Override
	    public List<Shares> query() {
		List<Shares> share = new ArrayList<Shares>();
		String sql ="select * from Shares";
		ResultSet set = db.executeRetrieveQuery(sql);
		
		try {
			while (set.next()) {
				Shares shareobj = new Shares();
				
					shareobj.stockname = set.getString(1);
					shareobj.stockid = set.getInt(2);
					shareobj.stockprice = set.getFloat(3);
					
					share.add(shareobj);
			}	
				} 
		  catch (Exception e) {
					System.out.println("Something went wrong");
					e.printStackTrace();
				}
		
		          return share;
		
	}

	
	
}

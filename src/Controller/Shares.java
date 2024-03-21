package Controller;



/*
This class carries one constructor and getter setter for all the fields.

CREATE TABLE Shares (
Share_name nvarchar(30) PRIMARY KEY NOT NULL,
Share_Id int NOT NULL	,
Share_price float NOT NULL
);

 */

public class Shares {
	public String stockname;
    public int stockid;
    public float stockprice;
    

     public Shares(String name, int Id, float price) {
            this.stockname = name;
            this.stockid = Id;
            this.stockprice = price;
     }
     
     
     public String getStockname() {
 		return stockname;
 	}


 	public void setStockname(String stockname) {
 		this.stockname = stockname;
 	}


 	public int getStockid() {
 		return stockid;
 	}


 	public void setStockid(int stockid) {
 		this.stockid = stockid;
 	}


 	public float getStockprice() {
 		return stockprice;
 	}


 	public void setStockprice(float stockprice) {
 		this.stockprice = stockprice;
 	}
     
     public Shares() {
    	 
     }
     
     
     @Override
 	public String toString() {
 		return "Shares [stockname=" + stockname + ", stockid=" + stockid + ", stockprice=" + stockprice + "]";
 	}


}

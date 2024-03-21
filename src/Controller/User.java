package Controller;



/*
 * It carries constructor and getter setter for some of the fields to set user details in DB.
 * We have used hashmap to store username and no. of shares carried by user.
 * Which helps in buying and selling of shares when it confirms for whether shares exists in user account or not.
 * 
 CREATE TABLE User_details (
User_name nvarchar(30) PRIMARY KEY NOT NULL,
Account_number int NOT NULL	,
Account_bal float NOT NULL,
Email_ID nvarchar(50),
Country_name nvarchar(30)
);
 */


	public class User {


		public User() {
			super();
		}


		public String username;
	    public long accountnumber;
	    public float accountbal;
	    public String email;
	    public String country;
	    String sharename;
	    int totalshares;
	    
	    

	    public User(String username, long accountnumber, float accountbal, String email, String country) {
	        this.username = username;
	        this.accountnumber = accountnumber;
	        this.accountbal = accountbal;
	        this.email = email;
	        this.country = country;
	        

	    }
	   
	    

	    public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public long getAccountnumber() {
			return accountnumber;
		}

		public void setAccountnumber(long accountnumber) {
			this.accountnumber = accountnumber;
		}

		public float getAccountbal() {
			return accountbal;
		}

		public void setAccountbal(float accountbal) {
			this.accountbal = accountbal;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCountry() {
			return country;
		}

		public void setCountry(String country) {
			this.country = country;
		}

	
		@Override
		public String toString() {
			return "User [user name=" + username + ", account number=" + accountnumber + ", account balance=" + accountbal
					+ ", Email=" + email + ", Country=" + country + "]";
		}
	
	}


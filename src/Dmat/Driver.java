package Dmat;

import java.sql.Connection;
import java.sql.DriverManager;

import Model.RegisterPage;

public class Driver {
public static void main(String[] args) throws Exception {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con= DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Dmat;user=amazon;password=teja@123;trustServerCertificate=true");
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Welcome to D-Mat Application");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
        RegisterPage register = new RegisterPage();
        register.register();	
		

	}
}

package application;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class SqliteConnection {
	public static Connection connector() {
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:D:\\eclipse\\Databases\\EmployeeDb.sqlite");
			return conn;
		}
		catch(Exception e){
			System.out.println(e);
			return null;
		}
	}



}

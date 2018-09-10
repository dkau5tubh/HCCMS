package com.hccms.db;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBManager {
	public static Connection getDBConnectivity() throws Exception
	{
		InputStream ins=new FileInputStream("dbprop.properties");
		Properties prop=new Properties();
		prop.load(ins);
		
		String driver=prop.getProperty("driver");
		String url=prop.getProperty("url");
		String username=prop.getProperty("dbuser");
		String password=prop.getProperty("dbpassword");
		Class.forName(driver);
		System.out.println("Driver is loaded");
		Connection con=DriverManager.getConnection(url,username,password);
		System.out.println("Connection established");
		return con;
		
	}

}

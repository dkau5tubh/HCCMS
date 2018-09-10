package com.hccms.db;

import java.sql.Connection;

public class DBConnectionDemo {
	public static void main(String[] args) {
		Connection con=null;
		try
		{
			con=DBManager.getDBConnectivity();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

}

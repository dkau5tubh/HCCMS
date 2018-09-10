package com.hccms.gui.adminNew;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.hccms.db.DBManager;

public class demo {
	public static void main(String[] args) {
		try {
			Connection connection=DBManager.getDBConnectivity();
			Statement statement=connection.createStatement();
			String sql= "select roomno from ward";
			ResultSet resultSet= statement.executeQuery(sql);
			while(resultSet.next())
			{
				int id= resultSet.getInt(1);
				System.out.println(id);
			}
			
 
 		}
 		catch (Exception e) {
			// TODO: handle exception
		}
	}

}

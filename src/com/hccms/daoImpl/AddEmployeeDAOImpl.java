package com.hccms.daoImpl;

import java.sql.Connection;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.hccms.beans.Address;
import com.hccms.beans.Employees;
import com.hccms.beans.Name;
import com.hccms.daos.AddEmployeeDAO;
import com.hccms.db.DBManager;

public class AddEmployeeDAOImpl implements AddEmployeeDAO {

	@Override
	public void addEmployeee( Employees employee) {
		
		try {

			Connection con = DBManager.getDBConnectivity();
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
				
			//inserting the date into employee table wtih id as a primary key
			String sql = "insert into employees (id,role,username,password,gender,dob,qualification,salary,email,mobno,hiredate,department,bloodgrp,shift)values('"
					+ employee.getId() + "','" + employee.getRole() + "','" + employee.getUsername() + "','" + employee.getPassword()
					+ "','" + employee.getGender() + "','" + employee.getDob() + "','" + employee.getQualification() + "',0.00,'"
					+ employee.getEmail() + "','" + employee.getMobno() + "','" + employee.getHiredate() + "','"
					+ employee.getDepartment() + "','" + employee.getBloodgp() + "','" + employee.getShift() + "')";

			// String sql="insert into
			// testdb(hiredate,dob,salary)values(TO_DATE('1989-12-09','YYYY-MM-DD'),TO_DATE('1989-12-09','YYYY-MM-DD'),45600.00)";
			
			//inserting data into the table names referencing the id as foregin key
			String sql1 = "insert into enames(firstname,middlename,lastname,id) values('" + employee.getFml().getFirstname()
					+ "','" + employee.getFml().getMiddlename()
					+ "','" + employee.getFml().getLastname() + "','" + employee.getId() + "')";
			
			//inserting data into the address table referencing the employee ch id as primary key 

			String sql2 = "insert into eaddress(street,town,state,country,pin,id)values('" + employee.getAd().getStreet()
					+ "','" + employee.getAd().getTown() + "','" + employee.getAd().getState() + "','" + employee.getAd().getCountry() + "','"
					+ employee.getAd().getPin()+ "','" + employee.getId() + "')";
			
			//creating the users credentials
			String sql3 = "insert into users(id,email,mobno,password,role)values('" + employee.getId() + "','"
					+ employee.getEmail() + "','" + employee.getMobno() + "','" + employee.getPassword() + "','" + employee.getRole()
					+ "')";

			stmt.addBatch(sql);
			stmt.addBatch(sql1);
			stmt.addBatch(sql2);
			stmt.addBatch(sql3);
			int flag = 0;
			int[] ba = stmt.executeBatch();
			for (int i = 0; i < ba.length; i++) {
				if (ba[i] > 0) {
					flag++;
				}
			}
			if (flag == 4) {
				con.commit();
			
				con.close();

			} else {

				con.rollback();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	
		
	}

	@Override
	public void clearEmployee() {
		// TODO Auto-generated method stub
		
	}

}

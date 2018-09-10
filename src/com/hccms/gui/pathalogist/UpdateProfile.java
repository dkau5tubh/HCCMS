package com.hccms.gui.pathalogist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.beans.Address;
import com.hccms.beans.Name;
import com.hccms.db.DBManager;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class UpdateProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateProfile frame = new UpdateProfile();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UpdateProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 894, 159);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_9 = new JLabel((String) null);
		label_9.setFont(new Font("Candara", Font.BOLD, 17));
		label_9.setBounds(198, 47, 146, 28);
		label_9.setText(Pathology.username);
		panel.add(label_9);
		
		JLabel label_13 = new JLabel("Welcome,");
		label_13.setForeground(Color.WHITE);
		label_13.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		label_13.setBounds(198, 23, 89, 23);
		panel.add(label_13);
		
		JButton btnBack = new JButton("");
		btnBack.setBackground(SystemColor.textHighlight);
		btnBack.setIcon(new ImageIcon(UpdateProfile.class.getResource("/com/hms/images/icons8-left-64.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Pathology homeScreen= new Pathology();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		btnBack.setBounds(744, 47, 89, 84);
		panel.add(btnBack);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 718, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel(" Staff ID :");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(163, 195, 112, 16);
		panel_2.add(label);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(258, 190, 175, 26);
		panel_2.add(textField);
		
		JLabel label_1 = new JLabel(" Staff Name :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(163, 227, 94, 16);
		panel_2.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(258, 222, 175, 26);
		panel_2.add(textField_1);
		
		JLabel label_2 = new JLabel(" Gender :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(163, 258, 76, 16);
		panel_2.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(258, 254, 175, 26);
		panel_2.add(textField_2);
		
		JLabel label_3 = new JLabel("Qualification:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(163, 298, 112, 16);
		panel_2.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(258, 291, 175, 26);
		panel_2.add(textField_3);
		
		JLabel label_4 = new JLabel(" Position :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(163, 328, 94, 17);
		panel_2.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(258, 325, 175, 26);
		panel_2.add(textField_4);
		
		JLabel label_5 = new JLabel(" Salary :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(163, 362, 76, 17);
		panel_2.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(258, 359, 175, 26);
		panel_2.add(textField_5);
		
		JLabel label_6 = new JLabel(" Mobile No. :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(163, 396, 112, 16);
		panel_2.add(label_6);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(258, 393, 175, 26);
		panel_2.add(textField_6);
		
		JLabel label_7 = new JLabel(" E mail :");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(163, 433, 112, 16);
		panel_2.add(label_7);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(258, 430, 175, 26);
		panel_2.add(textField_7);
		
		JLabel label_8 = new JLabel(" Department :");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(163, 470, 112, 16);
		panel_2.add(label_8);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(258, 467, 175, 26);
		panel_2.add(textField_8);
		
		JLabel lblStreet = new JLabel("Street  :");
		lblStreet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreet.setBounds(445, 289, 112, 16);
		panel_2.add(lblStreet);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(525, 286, 181, 26);
		panel_2.add(textField_9);
		
		JLabel label_10 = new JLabel(" Shift :");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(173, 507, 112, 16);
		panel_2.add(label_10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(258, 504, 180, 26);
		panel_2.add(textField_10);
		
		JLabel label_11 = new JLabel("Blood Grp:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(445, 189, 112, 16);
		panel_2.add(label_11);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(526, 186, 180, 26);
		panel_2.add(textField_11);
		
		JLabel label_12 = new JLabel(" birth  Date :");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(443, 218, 76, 20);
		panel_2.add(label_12);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(526, 217, 180, 26);
		panel_2.add(textField_12);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getUpdate();
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 12));
		button.setBounds(532, 504, 221, 37);
		panel_2.add(button);
		
		JLabel lblTown = new JLabel("Town :");
		lblTown.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTown.setBounds(443, 328, 112, 16);
		panel_2.add(lblTown);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(523, 325, 181, 26);
		panel_2.add(textField_13);
		
		JLabel lblState = new JLabel("State :");
		lblState.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblState.setBounds(445, 368, 112, 16);
		panel_2.add(lblState);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(525, 365, 181, 26);
		panel_2.add(textField_14);
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountry.setBounds(445, 402, 112, 16);
		panel_2.add(lblCountry);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(525, 399, 181, 26);
		panel_2.add(textField_15);
		
		JLabel lblPin = new JLabel("Pin :");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPin.setBounds(445, 433, 112, 16);
		panel_2.add(lblPin);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(525, 430, 181, 26);
		panel_2.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setColumns(10);
		textField_17.setBounds(526, 254, 180, 26);
		panel_2.add(textField_17);
		
		JLabel lblHireDate = new JLabel(" Hire  Date :");
		lblHireDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHireDate.setBounds(443, 255, 76, 20);
		panel_2.add(lblHireDate);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(445, 463, 112, 16);
		panel_2.add(lblPassword);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(525, 460, 181, 26);
		panel_2.add(textField_18);
		
		try {
			Connection connection=DBManager.getDBConnectivity();
			Statement statement=connection.createStatement();
			String id= Pathology.username;
			String sql = "select * from EMPLOYEES where ID='" + id + "'";
			//	String id1 = "select id from employees";
				ResultSet resultSet = statement.executeQuery(sql);
		
				//resultSet = statement.executeQuery(sql);
				while (resultSet.next()) {
					String eid = resultSet.getString("ID");
					// String name= resultSet.getString("employee_name");
					String gender = resultSet.getString("gender");
					String qulification = resultSet.getString("qualification");
					String position = resultSet.getString("role");
					String salary = resultSet.getString("salary");
					String mob = resultSet.getString("mobno");
					String email = resultSet.getString("email");
					String department = resultSet.getString("department");
					// String address= resultSet.getString("employees.department");
					String shift = resultSet.getString("shift");
					String bldgp = resultSet.getString("bloodgrp");
					String dob = resultSet.getString("dob");
					String hireDate=resultSet.getString("hiredate");
					String pass=resultSet.getString("PASSWORD");
					
					/*
					 * System.out.println(id+"\t"+gender+"\t"+qulification+"\t"+position+"\t"+
					 * salary+"\t"+mob+"\t"+email+"\t"+department+"\t"+shift+"\t"+bldgp+"\t"+dob);
					 */
					textField.setText(eid);
					// textField_8.setText(name);/
					textField_2.setText(gender);
					textField_3.setText(qulification);
					textField_4.setText(position);
					textField_5.setText(salary);
					textField_6.setText(mob);
					textField_7.setText(email);
					textField_8.setText(department);
					textField_10.setText(shift);
					textField_11.setText(bldgp);
					textField_12.setText(dob);
					textField_17.setText(hireDate);
					textField_18.setText(pass);

				}
				String name = "select * from enames where id='" + id  + "'";
				resultSet = statement.executeQuery(name);
				while (resultSet.next()) {
					String fnm = resultSet.getString("firstname");
					String mnm = resultSet.getString("middlename");
					String lnm = resultSet.getString("lastname");
					System.out.println(fnm + mnm + lnm);
					textField_1.setText(fnm + " " + mnm + " " + lnm);
				}

				String address = "select * from eaddress where id='" + id  + "'";
				resultSet = statement.executeQuery(address);
				while (resultSet.next()) {
					String street = resultSet.getString("street");
					String town = resultSet.getString("town");
					String state = resultSet.getString("state");
					String country = resultSet.getString("country");
					String pin = resultSet.getString("pin");
					// System.out.println(street+" "+town+" "+state+"\n "+country+" "+ pin);
					textField_9.setText(street);
					textField_13.setText(town);
					textField_14.setText(state);
					textField_15.setText(country);
					textField_16.setText(pin);
					

				}
				
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getUpdate() {
		String id= Pathology.username;
		try {
			Connection connection = DBManager.getDBConnectivity();
			String sql = "update employees set  role=?,gender=?,dob=?,qualification=?,salary=?,"
					+ "email=?,mobno=?,department=?,bloodgrp=?,shift=?where id='" + id+ "'";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, textField_4.getText());
			statement.setString(2, textField_2.getText());
			statement.setString(3, textField_12.getText());
			statement.setString(4, textField_3.getText());
			statement.setString(5, textField_5.getText());
			statement.setString(6, textField_7.getText());
			statement.setString(7, textField_6.getText());
			// statement.setString(11,textField_.getText());
			statement.setString(8, textField_8.getText());
			statement.setString(9, textField_11.getText());
			statement.setString(10, textField_10.getText());
			statement.executeUpdate();
			//System.out.println("data updated sucssesfully");

			// Getting value after sapce in name textfield_8 and update in ENAMES table;
			String name = textField_1.getText();
			System.out.println(name);

			String[] value = name.split(" ");
			String updateName = "update enames set firstname=?,middlename=?,lastname=? where id='"
					+ id + "'";
			statement = connection.prepareStatement(updateName);
			String fnm = value[0];
			String mnm = value[1];
			String lnm = value[2];
			Name name2 = new Name();
			name2.setFirstname(fnm);
			name2.setMiddlename(mnm);
			name2.setLastname(lnm);
			statement.setString(1, name2.getFirstname());
			statement.setString(2, name2.getMiddlename());
			statement.setString(3, name2.getLastname());
			statement.executeUpdate();

			//Getting value after sapce in Address textfield_6 and update in EADDRESS table;
		/*	String eaddress = textField_6.getText();
			String[] add = eaddress.split(" ");*/

			// Update Query --------------------
			String updateAddress = "update eaddress set street=?,town=?,state=?,country=?,pin=? where id='"
					+ id + "'";
			statement = connection.prepareStatement(updateAddress);
			// ------Set values to Address Bean -----------
			Address address= new Address();
			address.setStreet(textField_9.getText());
			address.setTown(textField_13.getText());
			address.setState(textField_14.getText());
			address.setCountry(textField_15.getText());
			address.setPin(textField_16.getText());
			// --------*** End *** ------------------------
			// System.out.println(address.getPin());
			System.out.println(address.getStreet() + "\n" + address.getTown() + "\n" + address.getState() + "\n"
					+ address.getCountry() + "\n" + address.getPin());
			statement.setString(1, address.getStreet());
			statement.setString(2, address.getTown());
			statement.setString(3, address.getState());
			statement.setString(4, address.getCountry());
			statement.setString(5, address.getPin());
			statement.executeUpdate();
			// ----------------*** End ***-----------------
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	
	}
}

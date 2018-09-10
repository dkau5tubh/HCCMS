package com.hccms.gui.adminNew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.print.attribute.TextSyntax;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import com.hccms.beans.Address;
import com.hccms.beans.Employees;
import com.hccms.beans.Name;
import com.hccms.db.DBManager;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StaffInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField, textField_1, textField_7, textField_8, textField_10, textField_11, textField_12;
	private JLabel lblpalceholder;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_9;
	private JTextField textField_13;
	JList list ;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffInformation frame = new StaffInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StaffInformation() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 200, 947, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(0, 0, 931, 511);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Staff Name/Id :");
		lblNewLabel.setBounds(68, 115, 101, 16);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));

		textField_1 = new JTextField();
		textField_1.setBounds(93, 142, 152, 26);
		lblpalceholder = new JLabel("Enter UserID/Name");
		lblpalceholder.setForeground(Color.LIGHT_GRAY);
		textField_1.setLayout(new FlowLayout());
		textField_1.add(lblpalceholder);  /////>>>>>>Add placeholder to textfield
		textField_1.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					lblpalceholder.setVisible(false);
				} else {
					if (textField_1.getText().equals(" ")) {
						lblpalceholder.setVisible(true);
					}
				}
			}

		});
		panel_2.add(textField_1);

		// lblEnterUserName.setBounds(150, 150, 46, 14);

		textField_1.setColumns(10);

		JLabel lblStatusOfDesease = new JLabel(" Staff ID :");
		lblStatusOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatusOfDesease.setBounds(282, 115, 112, 16);
		panel_2.add(lblStatusOfDesease);

		JLabel lblCheckInDate = new JLabel(" Staff Name :");
		lblCheckInDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckInDate.setBounds(282, 147, 94, 16);
		panel_2.add(lblCheckInDate);

		JLabel lblRoomNo = new JLabel(" Gender :");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomNo.setBounds(282, 178, 76, 16);
		panel_2.add(lblRoomNo);

		JLabel lblRoomType = new JLabel(" Position :");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomType.setBounds(282, 248, 94, 17);
		panel_2.add(lblRoomType);

		JLabel lblBuilding = new JLabel(" Salary :");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuilding.setBounds(282, 282, 76, 17);
		panel_2.add(lblBuilding);

		JLabel lblStatOfDesease = new JLabel(" Mobile No. :");
		lblStatOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatOfDesease.setBounds(282, 316, 112, 16);
		panel_2.add(lblStatOfDesease);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(377, 110, 175, 26);
		panel_2.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(377, 142, 175, 26);
		panel_2.add(textField_8);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(377, 245, 175, 26);
		panel_2.add(textField_10);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(377, 279, 175, 26);
		panel_2.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(377, 313, 175, 26);
		panel_2.add(textField_12);

		// ------------*** Adding names of Employees to JList ***-----------

		DefaultListModel<String> listModel = new DefaultListModel<>();
		try {
			Connection connection = DBManager.getDBConnectivity();
			Statement statement = connection.createStatement();
			String sql = "select firstname,middlename,lastname from enames";
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String fnm = resultSet.getString("FIRSTNAME");
				String mnm = resultSet.getString("MIDDLENAME");
				String lnm = resultSet.getString("LASTNAME");
				// System.out.println(fnm+"\t"+mnm+"\t"+lnm);
				listModel.addElement(fnm + " " + mnm + " " + lnm);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		 list = new JList(listModel); ///>>>>>>>>*** Values added to Jlist
		
		//---*** Getting Value from database on click of Jlist selected Value ***-----------
		
		String fname, mname, lname;
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
			 list = (JList) evt.getSource();
				if (evt.getClickCount() == 2) {
					String fullname = (String) list.getSelectedValue();
					// System.out.println(fullname);

					// Double-click detected
					int index = list.locationToIndex(evt.getPoint());

					getvalue(fullname);//>>> provide data to getvalue() and call them
					 

				}
			}
		});

		// ------------------------*** End ***--------------

		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		list.setBounds(93, 179, 152, 271);
		panel_2.add(list);

		JLabel lblNewLabel_1 = new JLabel(" birth  Date :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(568, 177, 76, 20);
		panel_2.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(651, 176, 180, 26);
		panel_2.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlightText);
		panel.setBounds(670, 251, 135, 190);
		panel_2.add(panel);
		panel.setLayout(null);

		JButton btnClose = new JButton("Clear");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnClose.setBounds(30, 115, 76, 37);
		panel.add(btnClose);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpdate.setBounds(30, 47, 76, 37);
		panel.add(btnUpdate);
		panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Buttons"));

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\1.jpg"));
		label.setBounds(10, 19, 115, 160);
		panel.add(label);

		JLabel lblWardInformation = new JLabel("Staff  Information");
		lblWardInformation.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblWardInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblWardInformation.setBounds(282, 63, 277, 36);
		panel_2.add(lblWardInformation);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(377, 174, 175, 26);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(377, 350, 175, 26);
		panel_2.add(textField_3);

		JLabel lblEMail = new JLabel(" E mail :");
		lblEMail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEMail.setBounds(282, 353, 112, 16);
		panel_2.add(lblEMail);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(377, 387, 175, 26);
		panel_2.add(textField_4);

		JLabel lblDepartment = new JLabel(" Department :");
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDepartment.setBounds(282, 390, 112, 16);
		panel_2.add(lblDepartment);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(377, 211, 175, 26);
		panel_2.add(textField_5);

		JLabel lblHireDate = new JLabel("Qualification:");
		lblHireDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHireDate.setBounds(282, 218, 112, 16);
		panel_2.add(lblHireDate);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(377, 424, 267, 38);
		panel_2.add(textField_6);

		JLabel lblShift = new JLabel(" Address :");
		lblShift.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblShift.setBounds(282, 427, 112, 16);
		panel_2.add(lblShift);

		JLabel label_1 = new JLabel(" Shift :");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(570, 115, 112, 16);
		panel_2.add(label_1);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(651, 112, 180, 26);
		panel_2.add(textField_9);

		JLabel lblBloodGrp = new JLabel("Blood Grp:");
		lblBloodGrp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBloodGrp.setBounds(570, 145, 112, 16);
		panel_2.add(lblBloodGrp);

		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(651, 142, 180, 26);
		panel_2.add(textField_13);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				getSearch();  ////>>>>>>>*** Call getSearch()

			}
		});
		btnSearch.setBounds(179, 110, 81, 27);
		panel_2.add(btnSearch);
		
		JButton btnNewButton = new JButton("");
		// Code for remove border
				btnNewButton.setOpaque(false);
				btnNewButton.setContentAreaFilled(false);
				btnNewButton.setBorderPainted(false);
				// ---------- End----------
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-close-window-48.png"));
		btnNewButton.setBounds(778, 25, 89, 50);
		panel_2.add(btnNewButton);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(651, 214, 180, 26);
		panel_2.add(textField_14);
		
		JLabel lblHireDate_1 = new JLabel("Hire Date :");
		lblHireDate_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHireDate_1.setBounds(568, 215, 76, 20);
		panel_2.add(lblHireDate_1);

		// panel_2.add(lblEnterUserName);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getUpdate(); ////>>>>>>>*** Call getUpdate()
			}
		});
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getClear();  ////>>>>>>>*** Call getClear()
			}
		});

	}

	// ---------------------*** Method for clearing textboxes ***-------------------

	public void getClear() {
		textField.setText(null);
		textField_1.setText(null);
		lblpalceholder.setVisible(true);
		textField_2.setText(null);
		textField_3.setText(null);
		textField_4.setText(null);
		textField_5.setText(null);
		textField_6.setText(null);
		textField_7.setText(null);
		textField_8.setText(null);
		textField_9.setText(null);
		textField_10.setText(null);
		textField_11.setText(null);
		textField_12.setText(null);
		textField_13.setText(null);
		textField_14.setText(null);

	}

	// ----------------*** End of getClear() method ***---------

	// ---------*** Provide value to Jlist Anonymous Innner Class *** ----------
	String name;
	private JTextField textField_14;

	public void getvalue(String name) {

		this.name = name;
		String[] names = name.split(" ");
		String fname = names[0];
		String mname = names[1];
		String lname = names[2];
		try {
			Connection connection = DBManager.getDBConnectivity();
			Statement statement = connection.createStatement();
			String sql = "select id from enames where firstname='" + fname + "' AND middlename='" + mname
					+ "' AND lastname='" + lname + "'";
			ResultSet resultSet = statement.executeQuery(sql);

			Employees employees = new Employees();// ------*** Object of Employees Class ***--------
			while (resultSet.next()) {
				String id = resultSet.getString(1);

				employees.setId(id);

				// System.out.println(id);
			}

			String eid = employees.getId();
			String selectfromEmployees = "select * from EMPLOYEES where ID='" + eid + "'";
			resultSet = statement.executeQuery(selectfromEmployees);
			while (resultSet.next()) {
				String id = resultSet.getString("ID");
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
				String hireDate=resultSet.getString("HIREDATE");
				/*
				 * System.out.println(id+"\t"+gender+"\t"+qulification+"\t"+position+"\t"+
				 * salary+"\t"+mob+"\t"+email+"\t"+department+"\t"+shift+"\t"+bldgp+"\t"+dob);
				 */
				textField_1.setText(eid);
				lblpalceholder.setVisible(false);
				textField_7.setText(id);
				// textField_8.setText(name);/
				textField_2.setText(gender);
				textField_5.setText(qulification);
				textField_10.setText(position);
				textField_11.setText(salary);
				textField_12.setText(mob);
				textField_3.setText(email);
				textField_4.setText(department);
				textField_9.setText(shift);
				textField_13.setText(bldgp);
				textField.setText(dob);
				textField_14.setText(hireDate);
			}

			String enames = "select * from enames where id='" + eid + "'";
			resultSet = statement.executeQuery(enames);
			while (resultSet.next()) {
				String fnm = resultSet.getString("firstname");
				String mnm = resultSet.getString("middlename");
				String lnm = resultSet.getString("lastname");
				System.out.println(fnm + mnm + lnm);
				textField_8.setText(fnm + " " + mnm + " " + lnm);
			}

			String address = "select * from eaddress where id='" + eid + "'";
			resultSet = statement.executeQuery(address);
			while (resultSet.next()) {
				String street = resultSet.getString("street");
				String town = resultSet.getString("town");
				String state = resultSet.getString("state");
				String country = resultSet.getString("country");
				String pin = resultSet.getString("pin");
				// System.out.println(street+" "+town+" "+state+"\n "+country+" "+ pin);
				textField_6.setText(street + " " + town + " " + state + "\n " + country + " " + pin);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(name);
	}

	// ----------*** End of Provide value to Jlist Anonymous Innner Class***---------------

	// -------------*** Method for Update***-----------------

	public void getUpdate() {
		try {
			Connection connection = DBManager.getDBConnectivity();
			String sql = "update employees set  role=?,gender=?,dob=?,qualification=?,salary=?,"
					+ "email=?,mobno=?,department=?,bloodgrp=?,shift=?,HIREDATE=? where id='" + textField_1.getText() + "'";

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, textField_10.getText());
			statement.setString(2, textField_2.getText());
			statement.setString(3, textField.getText());
			statement.setString(4, textField_5.getText());
			statement.setString(5, textField_11.getText());
			statement.setString(6, textField_3.getText());
			statement.setString(7, textField_12.getText());
			// statement.setString(11,textField_.getText());
			statement.setString(8, textField_4.getText());
			statement.setString(9, textField_13.getText());
			statement.setString(10, textField_9.getText());
			statement.setString(11, textField_14.getText());
			statement.executeUpdate();
			System.out.println("data updated sucssesfully");

			// Getting value after sapce in name textfield_8 and update in ENAMES table;
			String name = textField_8.getText();
			System.out.println(name);

			String[] value = name.split(" ");
			String updateName = "update enames set firstname=?,middlename=?,lastname=? where id='"
					+ textField_1.getText() + "'";
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
			String eaddress = textField_6.getText();
			String[] add = eaddress.split(" ");

			// Update Query --------------------
			String updateAddress = "update eaddress set street=?,town=?,state=?,country=?,pin=? where id='"
					+ textField_1.getText() + "'";
			statement = connection.prepareStatement(updateAddress);
			// ------Set values to Address Bean -----------
			Address address = new Address();
			String street = add[1];
			String town = add[2];
			String state = add[3];
			String country = add[4];
			String pin = add[5];
			address.setStreet(street);
			address.setTown(town);
			address.setState(state);
			address.setCountry(country);
			address.setPin(pin);
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

		// ------------*** End Update Method ***---------------------------------

	}
	// -------------*** Method for Search ***------------------------------------

	public void getSearch() {

		try {
			Connection connection = DBManager.getDBConnectivity();
			Statement statement = connection.createStatement();
			String sql = "select * from EMPLOYEES where ID='" + textField_1.getText() + "'";
		//	String id1 = "select id from employees";
			ResultSet resultSet = statement.executeQuery(sql);
	
			//resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				String id = resultSet.getString("ID");
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
				String hireDate=resultSet.getString("HIREDATE");
				/*
				 * System.out.println(id+"\t"+gender+"\t"+qulification+"\t"+position+"\t"+
				 * salary+"\t"+mob+"\t"+email+"\t"+department+"\t"+shift+"\t"+bldgp+"\t"+dob);
				 */
				textField_7.setText(id);
				// textField_8.setText(name);/
				textField_2.setText(gender);
				textField_5.setText(qulification);
				textField_10.setText(position);
				textField_11.setText(salary);
				textField_12.setText(mob);
				textField_3.setText(email);
				textField_4.setText(department);
				textField_9.setText(shift);
				textField_13.setText(bldgp);
				textField.setText(dob);
				textField_14.setText(hireDate);

			}
			String name = "select * from enames where id='" + textField_1.getText() + "'";
			resultSet = statement.executeQuery(name);
			while (resultSet.next()) {
				String fnm = resultSet.getString("firstname");
				String mnm = resultSet.getString("middlename");
				String lnm = resultSet.getString("lastname");
				System.out.println(fnm + mnm + lnm);
				textField_8.setText(fnm + " " + mnm + " " + lnm);
			}

			String address = "select * from eaddress where id='" + textField_1.getText() + "'";
			resultSet = statement.executeQuery(address);
			while (resultSet.next()) {
				String street = resultSet.getString("street");
				String town = resultSet.getString("town");
				String state = resultSet.getString("state");
				String country = resultSet.getString("country");
				String pin = resultSet.getString("pin");
				// System.out.println(street+" "+town+" "+state+"\n "+country+" "+ pin);
				textField_6.setText(street + " " + town + " " + state + "\n " + country + " " + pin);

			}
			
			//----------##* Search By Name *##--------------
			
			String fullName= textField_1.getText();
			//System.out.println(fullName);
			String nm[]= fullName.split(" ");
			String first=nm[0];
			String middle=nm[1];
			String last=nm[2];
			String byname = "select id from enames where firstname='" + first + "' AND middlename='" + middle
					+ "' AND lastname='" + last + "'";
			resultSet=statement.executeQuery(byname);
			Employees employees = new Employees();
			while(resultSet.next())
			{
				employees.setId(resultSet.getString(1));
			}
			String eid = employees.getId();
			System.out.println(eid);
			String selectfromEmployees = "select * from EMPLOYEES where ID='" + eid + "'";
			resultSet = statement.executeQuery(selectfromEmployees);
			while (resultSet.next()) {
				String id = resultSet.getString("ID");
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
				/*
				 * System.out.println(id+"\t"+gender+"\t"+qulification+"\t"+position+"\t"+
				 * salary+"\t"+mob+"\t"+email+"\t"+department+"\t"+shift+"\t"+bldgp+"\t"+dob);
				 */
				textField_1.setText(eid);
				lblpalceholder.setVisible(false);
				textField_7.setText(id);
				// textField_8.setText(name);/
				textField_2.setText(gender);
				textField_5.setText(qulification);
				textField_10.setText(position);
				textField_11.setText(salary);
				textField_12.setText(mob);
				textField_3.setText(email);
				textField_4.setText(department);
				textField_9.setText(shift);
				textField_13.setText(bldgp);
				textField.setText(dob);
			}

			String enames = "select * from enames where id='" + eid + "'";
			resultSet = statement.executeQuery(enames);
			while (resultSet.next()) {
				String fnm = resultSet.getString("firstname");
				String mnm = resultSet.getString("middlename");
				String lnm = resultSet.getString("lastname");
				System.out.println(fnm + mnm + lnm);
				textField_8.setText(fnm + " " + mnm + " " + lnm);
			}

			String address1 = "select * from eaddress where id='" + eid + "'";
			resultSet = statement.executeQuery(address1);
			while (resultSet.next()) {
				String street = resultSet.getString("street");
				String town = resultSet.getString("town");
				String state = resultSet.getString("state");
				String country = resultSet.getString("country");
				String pin = resultSet.getString("pin");
				// System.out.println(street+" "+town+" "+state+"\n "+country+" "+ pin);
				textField_6.setText(street + " " + town + " " + state + "\n " + country + " " + pin);

			}
			
			
			
			
			//-----------## End ##----------------

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

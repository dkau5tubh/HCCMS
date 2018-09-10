package com.hccms.gui.adminNew;

import java.awt.BorderLayout;
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
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.hccms.beans.Employees;
import com.hccms.beans.Name;
import com.hccms.beans.Patient;
import com.hccms.db.DBManager;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.TextArea;
import java.awt.Label;

public class PatientInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1,textField_2,textField_3,textField_4,textField_5,
	textField_6,textField_7,textField_8,textField_9,textField_10,textField_11,textField_12;
	private JLabel label;
	private TextArea textArea;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientInformation frame = new PatientInformation();
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
	public PatientInformation() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField_4 = new JTextField();
		textField_4.setBounds(249, 339, 173, 25);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				getSearch();
			}

			
		});
		btnSearch.setBounds(721, 145, 76, 23);
		panel_2.add(btnSearch);
		textField_2 = new JTextField();

		textField_2.setBounds(500, 143, 199, 26);
		textField_2.setLayout(new FlowLayout());
		label =new JLabel("Enter Patient Name");
		label.setForeground(Color.LIGHT_GRAY);
		textField_2.add(label);
		textField_2.addKeyListener(new KeyAdapter() {
		
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				{
					label.setVisible(false);
				}
				else
				if(textField_2.getText().equals(" "))
				{
					label.setVisible(true);
				}
				
			}
			
		
		});
	
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel1 = new JLabel("Patient  Id :");
		lblNewLabel1.setBounds(145, 194, 76, 16);
		panel_2.add(lblNewLabel1);
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPatientName = new JLabel("Patient  Name :");
		lblPatientName.setBounds(145, 231, 94, 16);
		panel_2.add(lblPatientName);
		lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(145, 268, 76, 16);
		panel_2.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(145, 304, 76, 23);
		panel_2.add(lblAge);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMobileNo = new JLabel("Mobile No :");
		lblMobileNo.setBounds(145, 338, 76, 23);
		panel_2.add(lblMobileNo);
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address  :");
		lblAddress.setBounds(145, 374, 76, 23);
		panel_2.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setBounds(249, 228, 173, 26);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(249, 265, 173, 26);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(249, 191, 86, 26);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(249, 302, 173, 26);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblStatusOfDesease = new JLabel("Disease :");
		lblStatusOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatusOfDesease.setBounds(500, 195, 112, 16);
		panel_2.add(lblStatusOfDesease);
		
		JLabel lblCheckInDate = new JLabel("Check in Date :");
		lblCheckInDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckInDate.setBounds(500, 232, 94, 16);
		panel_2.add(lblCheckInDate);
		
		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomNo.setBounds(500, 269, 76, 16);
		panel_2.add(lblRoomNo);
		
		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomType.setBounds(500, 306, 94, 17);
		panel_2.add(lblRoomType);
		
		JLabel lblBuilding = new JLabel("Building :");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuilding.setBounds(500, 342, 76, 17);
		panel_2.add(lblBuilding);
		
		JLabel lblStatOfDesease = new JLabel("Stat. of disease :");
		lblStatOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatOfDesease.setBounds(500, 378, 112, 16);
		panel_2.add(lblStatOfDesease);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(622, 192, 175, 26);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(622, 229, 175, 26);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(622, 266, 175, 26);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(622, 303, 175, 26);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(622, 339, 175, 26);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(622, 375, 175, 26);
		panel_2.add(textField_12);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_10.setText("");
				textField_11.setText("");
				textField_12.setText("");
				
			}
		});
		btnClear.setBounds(691, 432, 94, 36);
		panel_2.add(btnClear);
		
		JLabel lblPatientInformation = new JLabel("Patient Information");
		lblPatientInformation.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientInformation.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblPatientInformation.setBounds(346, 62, 271, 52);
		panel_2.add(lblPatientInformation);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(249, 377, 241, 25);
		panel_2.add(textField);
		
		JButton closeButton = new JButton("");
		// Code for remove border
				closeButton.setOpaque(false);
				closeButton.setContentAreaFilled(false);
				closeButton.setBorderPainted(false);
				// ---------- End----------
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setBackground(Color.WHITE);
		closeButton.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-close-window-48.png"));
		closeButton.setBounds(818, 27, 89, 44);
		panel_2.add(closeButton);
	
	}
	private void getSearch() {
		try {
			Connection connection = DBManager.getDBConnectivity();
			Statement statement= connection.createStatement();

		String fullName= textField_2.getText();
		//System.out.println(fullName);
		String nm[]= fullName.split(" ");
		String first=nm[0];
		String middle=nm[1];
		String last=nm[2];
		String byname = "select pid from pname where firstname='" + first + "' AND middlename='" + middle
				+ "' AND lastname='" + last + "'";
		 ResultSet resultSet=statement.executeQuery(byname);
		//Employees employees = new Employees();
		 Patient patient= new Patient();
		while(resultSet.next())
		{
			patient.setPatientid(resultSet.getString(1));
		}
		String pid = patient.getPatientid();
		System.out.println(pid);
		//String selectfromPatients = "select * from EMPLOYEES where ID='" + eid + "'";
		String selectFromPatients =" Select * from patients where patid='"+pid+"'";
		resultSet=statement.executeQuery(selectFromPatients);
		while(resultSet.next()) {
			
		/*	patient.setGender(resultSet.getString(2));
			patient.setDateOfBirth(resultSet.getString(3));
			patient.setCheckinDate(resultSet.getString(5));
			
			String gender= patient.getGender();
			String dob=patient.getDateOfBirth();
			String chkdate= patient.getCheckinDate();
			System.out.println(gender+"\t"+dob+"\t"+chkdate);*/
			
			textField_1.setText(resultSet.getString(1));
			textField_5.setText(resultSet.getString(2));
			textField_6.setText(resultSet.getString(3));
			textField_4.setText(resultSet.getString(4));
			textField_8.setText(resultSet.getString(5));
			textField_12.setText(resultSet.getString(6));
			textField_9.setText(resultSet.getString(7));
			textField_10.setText(resultSet.getString(8));
			textField_11.setText(resultSet.getString(9));
			
			
			
		}
		String selectFromPname="select * from pname where pid='"+pid+"'";
		resultSet=statement.executeQuery(selectFromPname);
		while(resultSet.next())
			
		{
			Name name= new Name();
			name.setFirstname(resultSet.getString(1));
			name.setMiddlename(resultSet.getString(2));
			name.setLastname(resultSet.getString(3));
			String fnm=name.getFirstname();
			String mnm= name.getMiddlename();
			String lnm=name.getLastname();   
			String fullName1= fnm+" "+mnm+" "+lnm;
			
			textField_3.setText(fullName1);
		}
		
		String selectFromPaddress ="select * from PADDRESS where pid='"+pid+"'";
		resultSet=statement.executeQuery(selectFromPaddress);
		while(resultSet.next())
		{
			String street = resultSet.getString("street");
			String town = resultSet.getString("town");
			String state = resultSet.getString("state");
			String country = resultSet.getString("country");
			String pin = resultSet.getString("pin");
			// System.out.println(street+" "+town+" "+state+"\n "+country+" "+ pin);
			textField.setText(street + " " + town + " " + state + "\n " + country + " " + pin);
			//textArea.setText(street + " " + town + " " + state + "\n " + country + " " + pin);

		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}

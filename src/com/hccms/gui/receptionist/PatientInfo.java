package com.hccms.gui.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.beans.Address;
import com.hccms.beans.Name;
import com.hccms.beans.Patient;
import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;
import com.hccms.gui.pathalogist.Pathology;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class PatientInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField_id;
	private JTextField textField_firstname;
	private JTextField textField_mobno;
	private JTextField textField_search;
	private JTextField textField_statusOfDisease;
	private JTextField textField_roomNo;
	private JTextField textField_roomType;
	private JTextField textField_building;
	private JTextField textField_street;
	private JTextField textField_town;
	private JTextField textField_state;
	private JTextField textField_country;
	private JTextField textField_pin;
	JLabel town,state,country,pin,street;
	JRadioButton rdbtnMale, rdbtnFemale;
	JDateChooser dateChooser,dateChooser_1;
	JComboBox comboBox;
	private JTextField textField_middleName;
	private JTextField textField_lastName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientInfo frame = new PatientInfo();
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
	public PatientInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(-42, 11, 936, 159);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Welcome,");
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel.setBounds(240, 52, 89, 23);
		panel.add(lblNewLabel);

		final JLabel lblNewLabel_1 = new JLabel("Rec.Name");
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_1.setBounds(240, 86, 137, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(ReceptionistHomeScreen.username);
		
		JButton button = new JButton("");
		button.setBackground(SystemColor.textHighlight);
		button.setIcon(new ImageIcon(PatientInfo.class.getResource("/com/hms/images/icons8-left-64.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReceptionistHomeScreen homeScreen= new ReceptionistHomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button.setBounds(814, 39, 89, 86);
		panel.add(button);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnNewButton_1 = new JButton("Appointments");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// lblNewLabel_1.setText("Dr.Bandra");
				dispose();
				AddAppoitment frame = new AddAppoitment();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setForeground(SystemColor.textHighlightText);
		btnNewButton_1.setBounds(33, 68, 118, 46);
		panel_1.add(btnNewButton_1);

		JButton btnPatientRecord = new JButton("Patient Record");
		btnPatientRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PatientInfo frame = new PatientInfo();
				setVisible(true);
			}
		});
		btnPatientRecord.setForeground(Color.WHITE);
		btnPatientRecord.setBackground(new Color(255, 69, 0));
		btnPatientRecord.setBounds(33, 151, 118, 46);
		panel_1.add(btnPatientRecord);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(185, 169, 709, 403);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		textField_id = new JTextField();
		textField_id.setEditable(false);
		textField_id.setBounds(187, 46, 86, 25);
		panel_2.add(textField_id);
		textField_id.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Patient Id : ");
		lblNewLabel_2.setBounds(72, 49, 80, 14);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNewLabel_2);

		JLabel lblPatientName = new JLabel("First Name : ");
		lblPatientName.setBounds(72, 82, 94, 14);
		lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblPatientName);

		JLabel lblAge = new JLabel("Date Of Birth :");
		lblAge.setBounds(71, 222, 94, 20);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblAge);

		JLabel label = new JLabel("Gender : ");
		label.setBounds(71, 187, 86, 24);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(label);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(186, 190, 66, 23);
		rdbtnMale.setBackground(Color.WHITE);
		panel_2.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(253, 190, 66, 23);
		rdbtnFemale.setBackground(Color.WHITE);
		panel_2.add(rdbtnFemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);

		JLabel lblMobileNo = new JLabel("Mobile No. : ");
		lblMobileNo.setBounds(71, 260, 94, 14);
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblMobileNo);

		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setBounds(408, 82, 94, 14);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblAddress);

		textField_firstname = new JTextField();
		textField_firstname.setBounds(187, 82, 153, 25);
		textField_firstname.setColumns(10);
		panel_2.add(textField_firstname);

		textField_mobno = new JTextField();
		textField_mobno.setBounds(186, 256, 153, 25);
		textField_mobno.setColumns(10);
		panel_2.add(textField_mobno);

		textField_search = new JTextField();
		textField_search.setBounds(408, 46, 161, 25);
		textField_search.setToolTipText("Enter Patient Id");
		panel_2.add(textField_search);
		textField_search.setColumns(10);

		JLabel lblCheckIn = new JLabel("Check in Date: ");
		lblCheckIn.setBounds(71, 292, 94, 14);
		lblCheckIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblCheckIn);

		JLabel lblStatusOfDeaces = new JLabel("Status Of Disease:");
		lblStatusOfDeaces.setBounds(71, 328, 116, 14);
		lblStatusOfDeaces.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblStatusOfDeaces);

		JLabel lblRoomNo = new JLabel("Room No.: ");
		lblRoomNo.setBounds(71, 361, 94, 14);
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblRoomNo);

		JLabel lblRoomType = new JLabel("Room Type: ");
		lblRoomType.setBounds(398, 250, 94, 22);
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblRoomType);

		JLabel lblBuilding = new JLabel("Building :");
		lblBuilding.setBounds(398, 283, 94, 22);
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblBuilding);

		textField_statusOfDisease = new JTextField();
		textField_statusOfDisease.setBounds(187, 325, 153, 25);
		textField_statusOfDisease.setColumns(10);
		panel_2.add(textField_statusOfDisease);

		textField_roomNo = new JTextField();
		textField_roomNo.setBounds(187, 358, 153, 25);
		textField_roomNo.setColumns(10);
		panel_2.add(textField_roomNo);

		textField_roomType = new JTextField();
		textField_roomType.setBounds(514, 247, 153, 25);
		textField_roomType.setColumns(10);
		panel_2.add(textField_roomType);

		textField_building = new JTextField();
		textField_building.setBounds(514, 280, 153, 25);
		textField_building.setColumns(10);
		panel_2.add(textField_building);

		JLabel lblPatientInformation = new JLabel("Patient Information");
		lblPatientInformation.setBounds(281, 13, 205, 33);
		lblPatientInformation.setForeground(new Color(0, 0, 139));
		lblPatientInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblPatientInformation);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try
				{
					Connection connection= DBManager.getDBConnectivity();
					Statement statement=connection.createStatement();
					String patientInfo ="select * from patients where patid='"+textField_search.getText()+"'";
					ResultSet resultSet= statement.executeQuery(patientInfo);
					while(resultSet.next())
					{
						String id= resultSet.getString("patid");
						String gender=resultSet.getString("gender");
						String dob = resultSet.getString("dob");
						String mobno= resultSet.getString("mobno");
						String chkindate= resultSet.getString("chkindate");
						String statusofdisease=resultSet.getString("statusofdisease");
						String roomno= resultSet.getString("roomno");
						String roomtype= resultSet.getString("roomtype");
						String building= resultSet.getString("building");
						String bldgrp= resultSet.getString("bldgrp");
						
						textField_id.setText(id);
						textField_mobno.setText(mobno);
						textField_statusOfDisease.setText(statusofdisease);
						textField_roomNo.setText(roomno);
						textField_roomType.setText(roomtype);
						textField_building.setText(building);
						comboBox.setToolTipText(bldgrp);
						/*Date date=new Date(dob);
						
						dateChooser.setDate(dob);
						dateChooser_1.setToolTipText(chkindate);*/
					}
					String name= "select * from pname where pid='"+textField_search.getText()+"'";
					resultSet=statement.executeQuery(name);
					while(resultSet.next())
					{
						String fnm=resultSet.getString("firstname");
						String mnm=resultSet.getString("middlename");
						String lnm=resultSet.getString("lastname");
				
						textField_firstname.setText(fnm);
						textField_middleName.setText(mnm);
						textField_lastName.setText(lnm);
					}

					String address="select * from paddress where pid='"+textField_search.getText()+"'";
					resultSet=statement.executeQuery(address);
					while(resultSet.next())
					{
						String street= resultSet.getString("street");
						String town= resultSet.getString("town");
						String state= resultSet.getString("state");
						String country= resultSet.getString("country");
						String pin= resultSet.getString("pin");
						textField_street.setText(street);
						textField_town.setText(town);
						textField_state.setText(state);
						textField_country.setText(country);
						textField_pin.setText(pin);
						
					}

				}
				catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		});
		btnSearch.setBounds(579, 44, 89, 26);
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(btnSearch);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String pid=textField_id.getText();
				String firstName=textField_firstname.getText();
				String middleName=textField_middleName.getText();
				String lastName=textField_lastName.getText();
				String gen=getgender();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				String dob=sdf.format(dateChooser.getDate());
				String mobno=textField_mobno.getText();

				String street=textField_street.getText();
				String town=textField_town.getText();
				String state=textField_state.getText();
				String country=textField_country.getText();
				String pinno=textField_pin.getText();

				SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
				String checkinDate=sdf1.format(dateChooser_1.getDate());
				String statusOfDisease=textField_statusOfDisease.getText();
				String roomNo=textField_roomNo.getText();
				String roomType=textField_roomType.getText();
				String building=textField_building.getText();
				String bloodgp=(String) comboBox.getSelectedItem();

				Patient patient=new Patient();
				patient.setBloodgroup(bloodgp);
				patient.setGender(gen);
				patient.setPatientMobileNumber(mobno);
				patient.setCheckinDate(checkinDate);
				patient.setDateOfBirth(dob);

				Address ad=new Address();
				ad.setStreet(street);
				ad.setTown(town);
				ad.setState(state);
				ad.setCountry(country);
				ad.setPin(pinno);

				Name nm = new Name();
				nm.setFirstname(firstName);
				nm.setMiddlename(middleName);
				nm.setLastname(lastName);

				try
				{

					Connection con=DBManager.getDBConnectivity();

					String UpdatePatient="update patients set gender=?,dob=?,chkindate=?,mobno=?,bldgrp=?,roomno=?,roomtype=?,building=?,statusofdisease=? where patid='"+textField_search.getText()+"'"; 
					PreparedStatement statement=con.prepareStatement(UpdatePatient);
					statement.setString(1,gen);
					statement.setString(2,dob);
					statement.setString(3,checkinDate);
					statement.setString(4,mobno);
					statement.setString(5,bloodgp);
					statement.setString(6,roomNo);
					statement.setString(7,roomType);
					statement.setString(8,building);
					statement.setString(9,statusOfDisease);
					statement.executeUpdate();
					System.out.println("patient data updated sucssesfully");

					String updatePname="update pname set firstname=?,middlename=?,lastname=? where pid='"+textField_search.getText()+"'"; 
					statement=con.prepareStatement(updatePname);
					statement.setString(1,nm.getFirstname());
					statement.setString(2,nm.getMiddlename());
					statement.setString(3,nm.getLastname());
					statement.executeUpdate();
					System.out.println("patient name data updated sucssesfully");

					String updatePaddress="update paddress set street=?,town=?,state=?,country=?,pin=? where pid='"+textField_search.getText()+"'";
					statement=con.prepareStatement(updatePaddress);
					statement.setString(1,ad.getStreet());
					statement.setString(2,ad.getTown());
					statement.setString(3,ad.getState());
					statement.setString(4,ad.getCountry());
					statement.setString(5,ad.getPin());
					statement.executeUpdate();
					System.out.println("patient name data updated sucssesfully");

				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
		btnUpdate.setBounds(425, 359, 89, 33);
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(btnUpdate);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(539, 359, 89, 33);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_id.setText("");
				textField_firstname.setText("");
				textField_middleName.setText("");
				textField_lastName.setText("");
				
				textField_mobno.setText("");
				//textField_3.setText("");
				textField_search.setText("");
				// textField_5.setText("");
				textField_statusOfDisease.setText("");
				textField_roomNo.setText("");
				textField_roomType.setText("");
				textField_building.setText("");
				textField_street.setText("");
				textField_state.setText("");
				textField_pin.setText("");
				textField_country.setText("");
				textField_town.setText("");
				// textArea.setText(null);
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(btnClear);

		JLabel lblBloodGrp = new JLabel("Blood Grp:");
		lblBloodGrp.setBounds(398, 312, 94, 22);
		lblBloodGrp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblBloodGrp);

		comboBox = new JComboBox();
		comboBox.setBounds(514, 316, 153, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"SELECT BLOOD GRP", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"}));
		panel_2.add(comboBox);

		textField_street = new JTextField();
		textField_street.setBounds(514, 78, 153, 25);
		textField_street.setColumns(10);
		textField_street.setLayout(new FlowLayout());
		street = new JLabel("Enter Street/Landmark");
		street.setForeground(Color.LIGHT_GRAY);
		textField_street.add(street);
		textField_street.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				{
					street.setVisible(false);
				}
				else
					if(textField_street.getText().equals(" "))
					{
						street.setVisible(true);
					}

			}

		});


		panel_2.add(textField_street);

		textField_town = new JTextField();
		textField_town.setBounds(514, 108, 153, 25);
		textField_town.setColumns(10);
		town= new JLabel("Enter Town");
		town.setForeground(Color.LIGHT_GRAY);
		textField_town.setLayout( new FlowLayout());
		textField_town.add(town);
		textField_town.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				{
					town.setVisible(false);
				}
				else
					if(textField_town.getText().equals(" "))
					{
						town.setVisible(true);
					}

			}

		});
		panel_2.add(textField_town);

		textField_state = new JTextField();
		textField_state.setBounds(514, 143, 153, 25);
		textField_state.setColumns(10);
		state= new JLabel("Enter State ");
		state.setForeground(Color.LIGHT_GRAY);
		textField_state.setLayout( new FlowLayout());
		textField_state.add(state);
		textField_state.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				{
					state.setVisible(false);
				}
				else
					if(textField_state.getText().equals(" "))
					{
						state.setVisible(true);
					}

			}

		});
		panel_2.add(textField_state);

		textField_country = new JTextField();
		textField_country.setBounds(514, 175, 153, 25);
		textField_country.setColumns(10);
		country= new JLabel("Enter Country");
		country.setForeground(Color.LIGHT_GRAY);
		textField_country.setLayout( new FlowLayout());
		textField_country.add(country);
		textField_country.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				{
					country.setVisible(false);
				}
				else
					if(textField_country.getText().equals(" "))
					{
						country.setVisible(true);
					}

			}

		});
		panel_2.add(textField_country);

		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCalendar cal = new JCalendar();
			}
		});
		dateChooser.setBounds(186, 292, 153, 25);
		panel_2.add(dateChooser);

		textField_pin = new JTextField();
		textField_pin.setColumns(10);
		textField_pin.setBounds(514, 211, 153, 25);
		pin= new JLabel("Enter pin Code");
		pin.setForeground(Color.LIGHT_GRAY);
		textField_pin.setLayout( new FlowLayout());
		textField_pin.add(pin);
		textField_pin.addKeyListener(new KeyAdapter() {


			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE)
				{
					pin.setVisible(false);
				}
				else
					if(textField_pin.getText().equals(" "))
					{
						pin.setVisible(true);
					}

			}

		});
		panel_2.add(textField_pin);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(186, 222, 153, 20);
		panel_2.add(dateChooser_1);

		JLabel lblMiddleName = new JLabel("Middle Name : ");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMiddleName.setBounds(72, 121, 94, 14);
		panel_2.add(lblMiddleName);

		JLabel lblLastName = new JLabel("Last Name : ");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(72, 154, 94, 14);
		panel_2.add(lblLastName);

		textField_middleName = new JTextField();
		textField_middleName.setColumns(10);
		textField_middleName.setBounds(187, 118, 153, 25);
		panel_2.add(textField_middleName);

		textField_lastName = new JTextField();
		textField_lastName.setColumns(10);
		textField_lastName.setBounds(187, 151, 153, 25);
		panel_2.add(textField_lastName);
	}
	public String  getgender() {
		if(rdbtnMale.isSelected())
		{
			return "Male";
		}
		else if(rdbtnFemale.isSelected())
		{
			return "female";
		}
		else
			return null;
	}
}

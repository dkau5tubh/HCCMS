package com.hccms.gui.receptionist;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.beans.Address;
import com.hccms.beans.Appointment;
import com.hccms.beans.Name;
import com.hccms.beans.Patient;
import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.TextArea;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;

import sun.security.krb5.internal.APOptions;

import com.toedter.calendar.JDayChooser;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddAppoitment extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtFName;
	private JTextField txtLastname;
	private JTextField textField_mobno;
	private JTextField txtStreet;
	private JTextField txtTown;
	private JTextField txtCountry;
	private JTextField textField_pin;
	private JTextField txtMidname;
	private JTextField txtEmail;
	JComboBox comboBox_doc, comboBox_blood,comboBox_state;
	JRadioButton rdbtnMale, rdbtnFemale;
	JDateChooser dateChooser_dob, dateChooser_today;
	TextArea TextAreaSymptoms;
	private static int patirntId = 100;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAppoitment frame = new AddAppoitment();
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
	public AddAppoitment() {
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
		panel.setBounds(0, 0, 894, 159);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel label = new JLabel("Welcome,");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		label.setBounds(223, 43, 89, 23);
		panel.add(label);

		JLabel label_1 = new JLabel("Rec.Name");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				UpdateProfile profile= new UpdateProfile();
				profile.setVisible(true);
			}
		});
		label_1.setFont(new Font("Candara", Font.BOLD, 17));
		label_1.setBounds(223, 77, 184, 28);
		panel.add(label_1);
		label_1.setText(ReceptionistHomeScreen.username);
		
		JButton button_1 = new JButton("");
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setIcon(new ImageIcon(AddAppoitment.class.getResource("/com/hms/images/icons8-left-64.png")));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReceptionistHomeScreen homeScreen= new ReceptionistHomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button_1.setBounds(747, 31, 89, 85);
		panel.add(button_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JButton btnPatienfInfo = new JButton("Patient Record");
		btnPatienfInfo.setForeground(SystemColor.textHighlightText);
		btnPatienfInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PatientInfo frame = new PatientInfo();
				frame.setVisible(true);
			}
		});
		btnPatienfInfo.setBackground(new Color(255, 69, 0));
		btnPatienfInfo.setBounds(36, 142, 119, 45);
		panel_1.add(btnPatienfInfo);

		JButton btnAppoitment = new JButton("Appointments");
		btnAppoitment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddAppoitment frame = new AddAppoitment();
				frame.setVisible(true);
			}
		});
		btnAppoitment.setForeground(SystemColor.textHighlightText);
		btnAppoitment.setBackground(new Color(255, 69, 0));
		btnAppoitment.setBounds(36, 63, 119, 45);
		panel_1.add(btnAppoitment);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(186, 159, 708, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblAnme = new JLabel("First Name : ");
		lblAnme.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAnme.setBounds(66, 122, 86, 24);
		panel_2.add(lblAnme);

		txtFName = new JTextField();
		txtFName.setToolTipText("Enter full Name");
		txtFName.setColumns(10);
		txtFName.setBounds(206, 124, 136, 25);
		panel_2.add(txtFName);

		JLabel lblGender = new JLabel("Gender : ");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(66, 229, 86, 24);
		panel_2.add(lblGender);

		JLabel lblGender_1 = new JLabel("Appointment To : ");
		lblGender_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender_1.setBounds(66, 87, 112, 24);
		panel_2.add(lblGender_1);

		txtLastname = new JTextField();
		txtLastname.setToolTipText("Enter Last Name");
		txtLastname.setColumns(10);
		txtLastname.setBounds(206, 194, 136, 25);
		panel_2.add(txtLastname);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(Color.WHITE);
		rdbtnMale.setBounds(206, 230, 66, 23);
		panel_2.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.WHITE);
		rdbtnFemale.setBounds(274, 229, 86, 23);
		panel_2.add(rdbtnFemale);

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);

		comboBox_doc = new JComboBox();
		comboBox_doc.setBackground(Color.WHITE);
		comboBox_doc.setBounds(229, 89, 113, 25);
		try {
		Connection con = DBManager.getDBConnectivity();
		String sql="select ID from ACTIVEUSERS where id like 'doc%'";
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		String id=" ";
		while(rs.next())
		{
			 id=rs.getString("id");
			comboBox_doc.addItem(id);
		}
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		/*String select="select firstname,middlename,lastname from ENAMES where id like 'doc%'";
		Statement smt=con.createStatement();
		ResultSet resultSet= smt.executeQuery(select);
		while(resultSet.next())
		{
			String fnm=resultSet.getString("FIRSTNAME");
			String mnm=resultSet.getString("MIDDLENAME");
			String lnm=resultSet.getString("LASTNAME");
			System.out.println(fnm+"\t"+mnm+"\t"+lnm);
			comboBox.addItem(fnm+" "+lnm);
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}*/
		panel_2.add(comboBox_doc);

		JLabel lblOf = new JLabel("Date Of Birth : ");
		lblOf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOf.setBounds(66, 293, 100, 24);
		panel_2.add(lblOf);

		JButton btnConfirmAppoitment = new JButton("Confirm Appointment");
		btnConfirmAppoitment.addActionListener(this);

		btnConfirmAppoitment.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConfirmAppoitment.setForeground(SystemColor.textHighlightText);
		btnConfirmAppoitment.setBackground(new Color(255, 69, 0));
		btnConfirmAppoitment.setBounds(470, 360, 204, 42);
		panel_2.add(btnConfirmAppoitment);

		JLabel lblNewLabel = new JLabel("Add Appointment");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(277, 22, 187, 33);
		panel_2.add(lblNewLabel);

		JLabel lblSymptoms = new JLabel("Symptoms : ");
		lblSymptoms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSymptoms.setBounds(384, 267, 86, 24);
		panel_2.add(lblSymptoms);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1
				.setIcon(new ImageIcon(AddAppoitment.class.getResource("/com/hms/images/Calendar Plus_48px.png")));
		lblNewLabel_1.setBounds(213, 11, 53, 65);
		panel_2.add(lblNewLabel_1);

		JLabel lblFlastName = new JLabel("Last Name : ");
		lblFlastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFlastName.setBounds(66, 191, 86, 24);
		panel_2.add(lblFlastName);

		JLabel lblMobileNo = new JLabel("Mobile No. ");
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileNo.setBounds(66, 327, 86, 24);
		panel_2.add(lblMobileNo);

		textField_mobno = new JTextField();
		textField_mobno.setBounds(206, 329, 136, 25);
		panel_2.add(textField_mobno);
		textField_mobno.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Dr.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(206, 89, 20, 25);
		panel_2.add(lblNewLabel_2);

		JLabel lblAddress = new JLabel("Address : ");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAddress.setBounds(365, 90, 66, 24);
		panel_2.add(lblAddress);

		dateChooser_today = new JDateChooser();
		dateChooser_today.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCalendar ob = new JCalendar();
			}
		});
		dateChooser_today.setBounds(546, 22, 122, 25);
		panel_2.add(dateChooser_today);

		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(483, 89, 162, 25);
		txtStreet.setLayout(new FlowLayout());
		panel_2.add(txtStreet);
		txtTown = new JTextField();
		txtTown.setColumns(10);
		txtTown.setBounds(483, 125, 162, 25);
		txtTown.setLayout(new FlowLayout());
		panel_2.add(txtTown);

		txtCountry = new JTextField();
		txtCountry.setColumns(10);
		txtCountry.setBounds(483, 193, 162, 25);
		txtCountry.setLayout(new FlowLayout());
		panel_2.add(txtCountry);

		textField_pin = new JTextField();
		textField_pin.setColumns(10);
		textField_pin.setBounds(483, 223, 162, 25);
		textField_pin.setLayout(new FlowLayout());
		panel_2.add(textField_pin);

		TextAreaSymptoms = new TextArea();
		TextAreaSymptoms.setBounds(482, 260, 163, 82);
		panel_2.add(TextAreaSymptoms);

		JLabel lblBloodGrp = new JLabel("Blood Grp:");
		lblBloodGrp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBloodGrp.setBounds(66, 362, 86, 24);
		panel_2.add(lblBloodGrp);

		comboBox_blood = new JComboBox();
		comboBox_blood.setModel(new DefaultComboBoxModel(
				new String[] { "SELECT BLOOD GRP", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-" }));
		comboBox_blood.setBounds(206, 365, 136, 25);
		panel_2.add(comboBox_blood);
		
		
		comboBox_state = new JComboBox();
		comboBox_state.setModel(new DefaultComboBoxModel(new String[] {"Andra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh", "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jammu and Kashmir", "Jharkhand", "Karnataka", "Kerala", "Madya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Orissa", "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telagana", "Tripura", "Uttaranchal", "Uttar Pradesh", "West Bengal"}));
		comboBox_state.setBounds(483, 158, 162, 24);
		panel_2.add(comboBox_state);
		

		dateChooser_dob = new JDateChooser();
		dateChooser_dob.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCalendar ob = new JCalendar();
				/*
				 * SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd"); JDateChooser.setd
				 */

			}
		});
		dateChooser_dob.setBounds(206, 293, 136, 20);
		panel_2.add(dateChooser_dob);

		JLabel lblMiddleName = new JLabel("Middle Name : ");
		lblMiddleName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMiddleName.setBounds(66, 157, 100, 24);
		panel_2.add(lblMiddleName);

		txtMidname = new JTextField();
		txtMidname.setToolTipText("Enter full Name");
		txtMidname.setColumns(10);
		txtMidname.setBounds(206, 158, 136, 25);
		panel_2.add(txtMidname);

		JLabel lblEmailId = new JLabel("E-mail id:");
		lblEmailId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailId.setBounds(66, 260, 86, 24);
		panel_2.add(lblEmailId);

		txtEmail = new JTextField();
		
		txtEmail.setToolTipText("Enter Last Name");
		txtEmail.setColumns(10);
		txtEmail.setBounds(206, 256, 136, 25);
		panel_2.add(txtEmail);
		
		JLabel lblNewLabel_3 = new JLabel("Street ");
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setBounds(433, 94, 38, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblTown = new JLabel("Town");
		lblTown.setForeground(Color.LIGHT_GRAY);
		lblTown.setBackground(Color.WHITE);
		lblTown.setBounds(433, 129, 31, 14);
		panel_2.add(lblTown);
		
		JLabel lblState = new JLabel("State");
		lblState.setForeground(Color.LIGHT_GRAY);
		lblState.setBackground(Color.WHITE);
		lblState.setBounds(432, 163, 38, 14);
		panel_2.add(lblState);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(Color.LIGHT_GRAY);
		lblCountry.setBackground(Color.WHITE);
		lblCountry.setBounds(432, 199, 45, 14);
		panel_2.add(lblCountry);
		
		JLabel lblPinNo = new JLabel("Pin No");
		lblPinNo.setForeground(Color.LIGHT_GRAY);
		lblPinNo.setBackground(Color.WHITE);
		lblPinNo.setBounds(433, 229, 38, 14);
		panel_2.add(lblPinNo);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// private static int patirntId=100;
		// String id = "P" + patirntId++;
		Random rnumber = new Random();
		int spclnumber = rnumber.nextInt(2000);
		String id = "PAT" + spclnumber;
		int appointmentNumber=rnumber.nextInt(1000);
		String appointmentid="appo"+ appointmentNumber;
		
		Appointment appointment = new Appointment();
		appointment.setPatientId(id);
		appointment.setAppointmentid(appointmentid);
		appointment.setAppointTo((String) comboBox_doc.getSelectedItem());
		appointment.setGender(getgender());
		appointment.setEmail(txtEmail.getText());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dob = sdf.format(dateChooser_dob.getDate());
		String appointmentDate = sdf.format(dateChooser_today.getDate());
		appointment.setDateOfBirth(dob);
		appointment.setpMobilenNo(textField_mobno.getText());
		appointment.setBloodGrp((String) comboBox_blood.getSelectedItem());
		appointment.setSymptom(TextAreaSymptoms.getText());
		appointment.setAppointmentDate(appointmentDate);
	/*	System.out.println(appointment.getPatientId() + "," + appointment.getBloodGrp() + "," + appointment.getGender()
				+ "," + appointment.getpMobilenNo() + "," + appointment.getSymptom() + ","
				+ appointment.getDateOfBirth() + "," + appointment.getAppointmentDate()+","+appointment.getAppointmentid());*/
System.out.println(appointment.getPatientId());
		Address address = new Address();
		address.setStreet(txtStreet.getText());
		address.setTown(txtTown.getText());
		address.setState((String)(comboBox_state.getSelectedItem()));
		address.setCountry(txtCountry.getText());
		address.setPin(textField_pin.getText());
	/*	System.out.println(address.getStreet() + "\n" + address.getState() + "\n" + address.getTown() + "\n"
				+ address.getStreet() + "\n" + address.getPin());*/
		Name name = new Name();
		name.setFirstname(txtFName.getText());
		name.setMiddlename(txtMidname.getText());
		name.setLastname(txtLastname.getText());
		System.out.println(name.getFirstname() + "\n" + name.getMiddlename() + "\n" + name.getLastname());
		//-----------set values to patient---------------------
		
		Patient patient= new Patient();
		patient.setPatientid(appointment.getPatientId());
		patient.setGender(getgender());
		patient.setDateOfBirth(dob);
		patient.setPatientMobileNumber(textField_mobno.getText());
		patient.setCheckinDate(appointmentDate);
		patient.setBloodgroup((String) comboBox_blood.getSelectedItem());
		patient.setSymptons(TextAreaSymptoms.getText());
		//System.out.println(patient.getPatientid()+","+patient.getGender()+","+patient.getDateOfBirth()+","+
		//patient.getPatientMobileNumber()+","+patient.getCheckinDate()+","+patient.getBloodgroup()+","+patient.getSymptons());
		
		//------------------------------------------------------
		// ---------------------Connectivity Code-------------------//
		try {
			Connection connection = DBManager.getDBConnectivity();
			Statement statement = connection.createStatement();
			connection.setAutoCommit(false);
			// -----Inset into Appointment Table------
			String insetIntoAppointments = "insert into appointments values('"+appointment.getAppointmentid()+"','" + appointment.getPatientId() + "','"
					+ appointment.getGender() + "','" + appointment.getEmail()
					+ "','" + appointment.getDateOfBirth() + "','" + appointment.getpMobilenNo() + "','"+appointment.getBloodGrp()+"','"
					+ appointment.getSymptom() + "','"+ appointment.getAppointTo() + "','" + appointment.getAppointmentDate() + "')";

			// -----Inset into Names Table------
			String insetIntoNames = "insert into pname(firstname,middlename,lastname,pid) values('"
					+ name.getFirstname() + "','" + name.getMiddlename() + "','" + name.getLastname() + 
					"','"+appointment.getPatientId()+"')";

			// -----Inset into Address Table------
			String insertIntoAddress = "insert into paddress(street,town,state,country,pin,pid) values('"
					+ address.getStreet() + "','" + address.getTown() + "','" + address.getState() + "','"
					+ address.getCountry() + "','" + address.getPin() + "','" + appointment.getPatientId() + "')";
			//------Insert  into patient table ----------
			String insertintoPatient ="insert into patients values('"+patient.getPatientid()+"','"+patient.getGender()
			+"','"+patient.getDateOfBirth()+"','"+patient.getPatientMobileNumber()+"','"+patient.getCheckinDate()+"','"
					+null+"','"+null+"','"+null+"','"+null
			+"','"+patient.getBloodgroup()+"','"+patient.getSymptons()+"')";

			// ----Adding stement to Batch ------
			statement.addBatch(insetIntoAppointments);
			statement.addBatch(insetIntoNames);
			statement.addBatch(insertIntoAddress);
			statement.addBatch(insertintoPatient);
			int flag = 0;
			int[] ba = statement.executeBatch();
			for (int i = 0; i < ba.length; i++) {
				if (ba[i] > 0) {
					flag++;
				}
			}
			if (flag == 4) {
				connection.commit();
				txtFName.setText("");
				txtMidname.setText("");
				txtLastname.setText("");
				txtEmail.setText("");
				textField_mobno.setText("");
				dateChooser_dob.setDate(null);
				dateChooser_today.setDate(null);
				textField_pin.setText("");
				txtStreet.setText("");
				txtCountry.setText("");
				txtTown.setText("");
				TextAreaSymptoms.setText(null);
				textField_mobno.setText("");
				rdbtnMale.setSelected(false);
				rdbtnFemale.setSelected(false);
				comboBox_state.setSelectedIndex(0);
				comboBox_blood.setSelectedIndex(0);
				JOptionPane.showMessageDialog(null, "Your Appointment to the Dr. "+comboBox_doc.getSelectedItem()+"\n"+"Has been Confirmed!!");
	
				
			} else {

				connection.rollback();
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// ----------***End***----------------------
	}

	public String getgender() {
		if (rdbtnMale.isSelected()) {
			return "Male";
		} else if (rdbtnFemale.isSelected()) {
			return "female";
		} else
			return null;
	}
}

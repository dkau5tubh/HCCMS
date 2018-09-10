package com.hccms.gui.adminNew;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.TextArea;

import com.hccms.beans.Address;
import com.hccms.beans.Employees;
import com.hccms.beans.Name;
import com.hccms.daoImpl.AddEmployeeDAOImpl;
import com.hccms.db.DBManager;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class AddEmployee extends JFrame {

	// private static int roleid=12110;
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JPasswordField passwordField;
	private JTextField textField;
	private JTextField textField_4;
	JComboBox comboBox, comboBox_1;
	JRadioButton rdbtnMale, rdbtnFemale;
	ButtonGroup group;
	JDateChooser dateChooser;
	private JTextField textField_3;
	private JTextField textField_5;
	private JTextField textField_8;
	private JTextField textField_9;
	JLabel street, country, state, dist, pin;
	private JTextField textField_11;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployee frame = new AddEmployee();
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
	public AddEmployee() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 200, 947, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		contentPane.setLayout(null);

		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setBounds(365, 21, 234, 44);
		lblAddEmployee.setFont(new Font("Times New Roman", Font.BOLD, 30));
		contentPane.add(lblAddEmployee);

		JLabel lblEmployeeId = new JLabel("Select Role :");
		lblEmployeeId.setBounds(166, 76, 101, 23);
		lblEmployeeId.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEmployeeId);

		JLabel lblEmployeeName = new JLabel("First Name :");
		lblEmployeeName.setBounds(166, 110, 117, 23);
		lblEmployeeName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEmployeeName);

		JLabel lblGender = new JLabel("Last Name");
		lblGender.setBounds(166, 175, 101, 23);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblGender);

		JLabel lblDateOfBirth = new JLabel("Gender :");
		lblDateOfBirth.setBounds(166, 209, 101, 23);
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDateOfBirth);

		JLabel lblQualiication = new JLabel("Date of Birth :");
		lblQualiication.setBounds(166, 243, 101, 23);
		lblQualiication.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblQualiication);

		JLabel lblDesignation = new JLabel("Qualification :");
		lblDesignation.setBounds(166, 277, 101, 23);
		lblDesignation.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDesignation);

		JLabel lblSalary = new JLabel("Salary :");
		lblSalary.setBounds(166, 311, 101, 23);
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblSalary);

		JLabel lblMobileNumber = new JLabel("Mobile Number :");
		lblMobileNumber.setBounds(166, 384, 101, 23);
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblMobileNumber);

		final JLabel lblJoinDate = new JLabel("Hire Date :");
		lblJoinDate.setBounds(166, 420, 101, 23);
		lblJoinDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblJoinDate);

		textField_1 = new JTextField();
		textField_1.setBounds(309, 108, 171, 25);
		textField_1.setColumns(10);
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(309, 175, 171, 25);
		textField_2.setColumns(10);
		contentPane.add(textField_2);

		textField_6 = new JTextField();
		textField_6.setBounds(309, 313, 171, 25);
		textField_6.setText(" ");
		textField_6.setColumns(10);
		contentPane.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBounds(309, 384, 171, 25);
		textField_7.setColumns(10);
		contentPane.add(textField_7);

		JPanel panel = new JPanel();
		panel.setBounds(526, 364, 259, 117);
		panel.setBackground(SystemColor.textHighlightText);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Buttons"));

		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(594, 292, 171, 25);
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] { "Select Shift", "Morning", "Evening", "Night" }));
		contentPane.add(comboBox_3);

		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(594, 260, 171, 25);
		comboBox_4.setModel(new DefaultComboBoxModel(
				new String[] { "Select Blood Group", "A+", "O+", "B+", "AB+", "A-", "O-", "B-", "AB-" }));
		comboBox_4.setEditable(true);
		contentPane.add(comboBox_4);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(309, 456, 171, 25);
		comboBox_2.setModel(new DefaultComboBoxModel(
				new String[] { "Select Department", "Pharmacy", "Morque", "Maternity", "ICU", "Other" }));
		contentPane.add(comboBox_2);

		final JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(309, 243, 171, 25);
		dateChooser_1.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCalendar jd = new JCalendar();
				jd.setDate(new java.util.Date());
			}
		});
		contentPane.add(dateChooser_1);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String role = ((String) comboBox.getSelectedItem()).toLowerCase();
				String fname = textField_1.getText();
				String mname = textField.getText();
				String lname = textField_2.getText();
				String gen = getgender();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String dob = sdf.format(dateChooser_1.getDate());

				String qual = (String) comboBox_1.getSelectedItem();
				double sal = Double.parseDouble(textField_6.getText());
				
				String email = textField_4.getText();
				String mobno = textField_7.getText();
				String hiredate = sdf.format(dateChooser.getDate());

				String department = (String) comboBox_2.getSelectedItem();
				
				String street = textField_3.getText();
				String town = textField_5.getText();
				String state = textField_8.getText();
				String country = textField_9.getText();
				String pinno = textField_11.getText();
			
				String bloodgp = (String) comboBox_4.getSelectedItem();
				String shift = (String) comboBox_3.getSelectedItem();
				String password = passwordField.getText();

				Name name = new Name();
				name.setFirstname(fname);
				name.setMiddlename(mname);
				name.setLastname(lname);

				Address address = new Address();
				address.setStreet(street);
				address.setTown(town);
				address.setState(state);
				address.setCountry(country);
				address.setPin(pinno);

				

				Random rnumber = new Random();
				int spclnumber = rnumber.nextInt(2000);
				String spclchar=fname.toLowerCase();

				Employees employee = new Employees();

				if (role.equals("doctor")) {
					String id = "doc"+spclchar+spclnumber;
					employee.setId(id);

				} else if (role.equals("nurse")) {
					String id = "nurs"+spclchar+spclnumber;
					employee.setId(id);
				} else if (role.equals("receptionist")) {
					String id = "recp"+spclchar+spclnumber;
					employee.setId(id);
				} else if (role.equals("pharmacist")) {
					String id = "phar"+spclchar+spclnumber;
					employee.setId(id);
				} else if (role.equals("pathologist")) {
					String id = "path"+spclchar+spclnumber;
					employee.setId(id);
				} else if (role.equals("clerk")) {
					String id = "cler"+spclchar+spclnumber;
					employee.setId(id);
				}else if(role.equals("accountant")){
					String id="acct"+spclchar+spclnumber;
					employee.setId(id);
				}else {
					String id = "staff"+spclchar+spclnumber;
					employee.setId(id);
				}
				employee.setRole(role);
				employee.setFml(name);
				employee.setGender(gen);
				employee.setDob(dob);
				employee.setQualification(qual);
				employee.setSalary(sal);
				employee.setEmail(email);
				employee.setMobno(mobno);
				employee.setHiredate(hiredate);
				employee.setDepartment(department);
				employee.setAd(address);
				employee.setBloodgp(bloodgp);
				employee.setShift(shift);
				employee.setUsername(email);
				employee.setPassword(password);
				AddEmployeeDAOImpl daoImpl= new AddEmployeeDAOImpl();
				daoImpl.addEmployeee(employee);
				System.out.println(employee);

							
			}
		});
		btnAdd.setBounds(36, 46, 89, 33);
		panel.add(btnAdd);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(140, 46, 89, 33);
		panel.add(btnClear);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_6.setText("");
				textField_7.setText("");
				textField_5.setText("");
				textField_8.setText("");
				textField_9.setText("");
				textField_11.setText("");
				dateChooser_1.setDate(null);
				dateChooser.setDate(null);
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
				comboBox_3.setSelectedIndex(0);
				comboBox_4.setSelectedIndex(0);
				

			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 14));

		comboBox = new JComboBox();
		comboBox.setBounds(309, 76, 171, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Select Role", "Doctor", "Nurse", "Receptionist",
				"Pharmacist", "Pathologist","Accountant", "Clerk" }));
		contentPane.add(comboBox);

		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(308, 210, 66, 23);
		rdbtnMale.setBackground(new Color(240, 248, 255));
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbtnMale);

		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(387, 210, 93, 23);
		rdbtnFemale.setBackground(new Color(240, 248, 255));
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(rdbtnFemale);
		group = new ButtonGroup();
		group.add(rdbtnMale);
		group.add(rdbtnFemale);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(309, 279, 171, 25);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "Select Qualification", "MBBS", "BMBS", "MBCHB",
				"MBBCH", "MD", "MCM", "MMSc", "MM", "MMed", "MPHIL", "MS", "MSurg", "MChir", "MCh", "CHM", "CM", "MSC",
				"DCM", "DClinSurg", "DMSc" }));
		contentPane.add(comboBox_1);

		JLabel lblDepartment = new JLabel("Department :");
		lblDepartment.setBounds(166, 454, 101, 23);
		lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblDepartment);

		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(506, 72, 57, 23);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblAddress);

		textField = new JTextField();
		textField.setBounds(309, 139, 171, 25);
		textField.setColumns(10);
		contentPane.add(textField);

		JLabel lblMiddleName = new JLabel("Middle Name :");
		lblMiddleName.setBounds(166, 141, 117, 23);
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblMiddleName);

		JLabel lblShift = new JLabel("Shift :");
		lblShift.setBounds(506, 288, 78, 23);
		lblShift.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblShift);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(309, 418, 171, 25);
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JCalendar jd = new JCalendar();
				// lblJoinDate.add(jd);

			}
		});
		contentPane.add(dateChooser);

		textField_4 = new JTextField();
		textField_4.setBounds(309, 348, 171, 25);
		textField_4.setColumns(10);
		contentPane.add(textField_4);

		JLabel lblEmail = new JLabel("E-Mail :");
		lblEmail.setBounds(166, 350, 78, 23);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblEmail);

		passwordField = new JPasswordField("HCCMS@123");
		passwordField.setBounds(594, 328, 171, 25);
		contentPane.add(passwordField);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(506, 328, 78, 23);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblPassword);

		textField_3 = new JTextField();
		textField_3.setBounds(594, 76, 171, 25);
		contentPane.add(textField_3);
		textField_3.setLayout(new FlowLayout());
		street = new JLabel("Enter Street/Landmark");
		street.setForeground(Color.LIGHT_GRAY);
		textField_3.add(street);
		textField_3.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					street.setVisible(false);
				} else if (textField_3.getText().equals(" ")) {
					street.setVisible(true);
				}

			}

		});
		textField_3.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBounds(594, 112, 171, 25);
		textField_5.setColumns(10);
		country = new JLabel("Enter Town");
		country.setForeground(Color.LIGHT_GRAY);
		textField_5.setLayout(new FlowLayout());
		textField_5.add(country);
		textField_5.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					country.setVisible(false);
				} else if (textField_5.getText().equals(" ")) {
					country.setVisible(true);
				}

			}

		});
		contentPane.add(textField_5);

		textField_8 = new JTextField();
		textField_8.setBounds(594, 148, 171, 25);
		textField_8.setColumns(10);
		state = new JLabel("Enter State ");
		state.setForeground(Color.LIGHT_GRAY);
		textField_8.setLayout(new FlowLayout());
		textField_8.add(state);
		textField_8.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					state.setVisible(false);
				} else if (textField_8.getText().equals(" ")) {
					state.setVisible(true);
				}

			}

		});
		contentPane.add(textField_8);

		textField_9 = new JTextField();
		textField_9.setBounds(594, 184, 171, 25);
		textField_9.setColumns(10);
		dist = new JLabel("Enter Country");
		dist.setForeground(Color.LIGHT_GRAY);
		textField_9.setLayout(new FlowLayout());
		textField_9.add(dist);
		textField_9.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					dist.setVisible(false);
				} else if (textField_9.getText().equals(" ")) {
					dist.setVisible(true);
				}

			}

		});
		contentPane.add(textField_9);

		JLabel lblBloodGrp = new JLabel("Blood grp :");
		lblBloodGrp.setBounds(506, 258, 78, 23);
		lblBloodGrp.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblBloodGrp);

		textField_11 = new JTextField();
		textField_11.setBounds(594, 220, 171, 25);
		textField_11.setColumns(10);
		pin = new JLabel("Enter pin Code");
		pin.setForeground(Color.LIGHT_GRAY);
		textField_11.setLayout(new FlowLayout());
		textField_11.add(pin);
		textField_11.addKeyListener(new KeyAdapter() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				if (e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
					pin.setVisible(false);
				} else if (textField_1.getText().equals(" ")) {
					pin.setVisible(true);
				}

			}

		});
		contentPane.add(textField_11);
		
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
		closeButton.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-close-window-48.png"));
		closeButton.setBackground(Color.WHITE);
		closeButton.setBounds(848, 21, 89, 44);
		contentPane.add(closeButton);

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

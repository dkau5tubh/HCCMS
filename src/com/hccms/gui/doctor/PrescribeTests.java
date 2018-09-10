package com.hccms.gui.doctor;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import oracle.net.aso.f;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;

import org.joda.time.Years;

import javax.swing.border.BevelBorder;

public class PrescribeTests extends JFrame {

	private JPanel contentPane;
	private JTextField textField_pid;
	private JTextField textField_patname;
	private JTextField textField_age;
	private static String patid;
	private static String appid;
	private JTextField textField_appid;
	private JTextField textField_remarks;
	private JTextField textField_bloodgrp;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		patid=args[0];
		appid=args[1];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrescribeTests frame = new PrescribeTests();
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
	public PrescribeTests() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,900, 600);
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
		
		JLabel lblNewLabel = new JLabel("Welcome,");
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel.setBounds(224, 26, 89, 23);
		panel.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("Dr.Name");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UpdateProfile profile= new UpdateProfile();
				profile.setVisible(true);
				profile.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_1.setBounds(224, 60, 89, 28);
		panel.add(lblNewLabel_1);
		String username="Dr. "+Doctor.username;
		lblNewLabel_1.setText(username);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Doctor homeScreen= new Doctor();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button.setIcon(new ImageIcon(PrescribeTests.class.getResource("/com/hms/images/icons8-left-64.png")));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(769, 28, 89, 84);
		panel.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("Prescribe Tests");
		lblNewLabel_2.setBounds(463, 53, 150, 36);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(401, 49, 46, 51);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(PrescribeTests.class.getResource("/com/hms/images/Report Card_48px.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Appointments");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DoctorAppointments frame = new DoctorAppointments();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				
			}
		});
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setForeground(SystemColor.textHighlightText);
		btnNewButton_1.setBounds(33, 108, 118, 45);
		panel_1.add(btnNewButton_1);
		
		JButton btnPatientRecord = new JButton("Patient Record");
		btnPatientRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DoctorPatientHistory frame = new DoctorPatientHistory();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnPatientRecord.setForeground(Color.WHITE);
		btnPatientRecord.setBackground(new Color(255, 69, 0));
		btnPatientRecord.setBounds(33, 197, 118, 43);
		panel_1.add(btnPatientRecord);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(188, 159, 706, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Patient id");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(38, 12, 65, 22);
		panel_2.add(lblNewLabel_3);
		
		textField_pid = new JTextField();
		textField_pid.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_pid.setBounds(117, 11, 131, 28);
		panel_2.add(textField_pid);
		textField_pid.setColumns(10);
		
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPatientName.setBounds(10, 51, 93, 22);
		panel_2.add(lblPatientName);
		
		textField_patname = new JTextField();
		textField_patname.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_patname.setColumns(10);
		textField_patname.setBounds(117, 50, 131, 28);
		panel_2.add(textField_patname);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(528, 12, 34, 22);
		panel_2.add(lblAge);
		
		textField_age = new JTextField();
		textField_age.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_age.setColumns(10);
		textField_age.setBounds(573, 11, 121, 28);
		panel_2.add(textField_age);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("X-Ray");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxNewCheckBox.setBackground(SystemColor.text);
		chckbxNewCheckBox.setBounds(98, 97, 65, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JCheckBox chckbxMriscan = new JCheckBox("MRI-Scan");
		chckbxMriscan.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxMriscan.setBackground(Color.WHITE);
		chckbxMriscan.setBounds(211, 97, 85, 23);
		panel_2.add(chckbxMriscan);
		
		JCheckBox chckbxCtScane = new JCheckBox("CT Scan");
		chckbxCtScane.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxCtScane.setBackground(Color.WHITE);
		chckbxCtScane.setBounds(336, 97, 78, 23);
		panel_2.add(chckbxCtScane);
		
		JCheckBox chckbxMii = new JCheckBox("MII");
		chckbxMii.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxMii.setBackground(Color.WHITE);
		chckbxMii.setBounds(470, 97, 53, 23);
		panel_2.add(chckbxMii);
		
		JCheckBox chckbxUltraSound = new JCheckBox("Ultra Sound");
		chckbxUltraSound.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxUltraSound.setBackground(Color.WHITE);
		chckbxUltraSound.setBounds(564, 97, 103, 23);
		panel_2.add(chckbxUltraSound);
		
		JCheckBox chckbxSugar = new JCheckBox("Sugar Test");
		chckbxSugar.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxSugar.setBackground(Color.WHITE);
		chckbxSugar.setBounds(97, 136, 97, 23);
		panel_2.add(chckbxSugar);
		
		JCheckBox chckbxBloodTest = new JCheckBox("Blood Test");
		chckbxBloodTest.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxBloodTest.setBackground(Color.WHITE);
		chckbxBloodTest.setBounds(210, 137, 93, 23);
		panel_2.add(chckbxBloodTest);
		
		JCheckBox chckbxCbc = new JCheckBox("Sonography");
		chckbxCbc.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxCbc.setBackground(Color.WHITE);
		chckbxCbc.setBounds(335, 137, 103, 23);
		panel_2.add(chckbxCbc);
		
		JCheckBox chckbxUrineTest = new JCheckBox("Urine Test");
		chckbxUrineTest.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxUrineTest.setBackground(Color.WHITE);
		chckbxUrineTest.setBounds(471, 136, 91, 23);
		panel_2.add(chckbxUrineTest);
		
		JCheckBox chckbxEcg = new JCheckBox("ECG");
		chckbxEcg.setFont(new Font("Tahoma", Font.BOLD, 12));
		chckbxEcg.setBackground(Color.WHITE);
		chckbxEcg.setBounds(566, 136, 53, 23);
		panel_2.add(chckbxEcg);
		
		JButton btnNewButton_2 = new JButton("SUBMIT");
		btnNewButton_2.setBackground(Color.PINK);
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBounds(459, 232, 103, 28);
		panel_2.add(btnNewButton_2);
		
		JLabel lblAppId = new JLabel("App Id");
		lblAppId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAppId.setBounds(283, 12, 53, 22);
		panel_2.add(lblAppId);
		
		textField_appid = new JTextField();
		textField_appid.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_appid.setText((String) null);
		textField_appid.setColumns(10);
		textField_appid.setBounds(346, 11, 131, 28);
		panel_2.add(textField_appid);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRemark.setBounds(502, 51, 53, 22);
		panel_2.add(lblRemark);
		
		textField_remarks = new JTextField();
		textField_remarks.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_remarks.setText((String) null);
		textField_remarks.setColumns(10);
		textField_remarks.setBounds(573, 50, 121, 28);
		panel_2.add(textField_remarks);
		
		textField_bloodgrp = new JTextField();
		textField_bloodgrp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_bloodgrp.setText((String) null);
		textField_bloodgrp.setColumns(10);
		textField_bloodgrp.setBounds(346, 54, 131, 28);
		panel_2.add(textField_bloodgrp);
		
		JLabel lblBloodGrp = new JLabel("Blood Grp");
		lblBloodGrp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBloodGrp.setBounds(258, 57, 78, 22);
		panel_2.add(lblBloodGrp);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(98, 271, 533, 109);
		panel_2.add(scrollPane_1);
		
		table = new JTable();
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane_1.setViewportView(table);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setBackground(Color.PINK);
		btnAdd.setBounds(193, 232, 103, 28);
		panel_2.add(btnAdd);
		
		
		
		//code for Getting the names from the database and setting to the textfield;
		try
		{
			Connection con=DBManager.getDBConnectivity();
			String sql="select p.FIRSTNAME,p.MIDDLENAME,p.LASTNAME ,a.DOB,a.BLDGRP from PNAME p join Appointments A on(p.PID=a.PATID) where p.pid='"+patid+"'";
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			textField_pid.setText(patid);
			textField_appid.setText(appid);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(99, 166, 533, 44);
			panel_2.add(scrollPane);
			
			JTextArea textArea = new JTextArea();
			scrollPane.setViewportView(textArea);
			while(rs.next())
			{
				String fname=rs.getString(1);
				String mname=rs.getString(2);
				String lname=rs.getString(3);
				String dob=rs.getString(4);
				System.out.println(fname+" "+mname+" "+lname);
				textField_bloodgrp.setText(rs.getString(5));
				textField_patname.setText(fname+" "+mname+" "+lname);
				//calculating the Age
				String birthdate[]=dob.split("-");
				int year=Integer.parseInt(birthdate[0]);
				int month=Integer.parseInt(birthdate[1]);
				int day=Integer.parseInt(birthdate[2]);
				System.out.println(year+" "+month+" "+day);
				org.joda.time.LocalDate dte=new org.joda.time.LocalDate(year,month,day);
				org.joda.time.LocalDate now= new org.joda.time.LocalDate();
				Years age=Years.yearsBetween(dte, now);
				System.out.println("Age is "+age);
				String str=age.toString();
				String st1=str.replaceAll("[A-Z]", "");
				textField_age.setText(st1);
				
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

package com.hccms.gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;

public class Patient_Information extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	JLabel lblEnterUserName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Information frame = new Patient_Information();
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
	public Patient_Information() {
		setTitle("Patient Information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setResizable(false);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//pannel 1 coding
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0,0,894	,159);
		contentPane.add(panel);
		panel.setLayout(null);
		JLabel lblWelcom = new JLabel("Welcome");
		lblWelcom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcom.setBounds(217, 55, 84, 22);
		panel.add(lblWelcom);
		
		JLabel lblNewLabel = new JLabel("Admin Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(217, 88, 116, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("J:\\Hospital Management Swing\\Wire_IMG\\Shutdown_48px.png"));
		lblNewLabel_1.setBounds(802, 30, 46, 47);
		panel.add(lblNewLabel_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setBackground(new Color(169, 169, 169));
		btnLogout.setBounds(783, 83, 89, 29);
		panel.add(btnLogout);
		//------------------------------------------------
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionText);
		panel_1.setBounds(0, 159, 188, 413);
		//buttons
		JButton btnNewButton = new JButton("Paitent Info");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(23, 11, 124, 30);
		panel_1.add(btnNewButton);

		JButton btnRoomInfo = new JButton("Room Info");
		btnRoomInfo.setForeground(Color.WHITE);
		btnRoomInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRoomInfo.setBackground(new Color(255, 69, 0));
		btnRoomInfo.setBounds(23, 61, 124, 30);
		panel_1.add(btnRoomInfo);

		JButton btnStaffInfo = new JButton("Staff  Info");
		btnStaffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStaffInfo.setForeground(Color.WHITE);
		btnStaffInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffInfo.setBackground(new Color(255, 69, 0));
		btnStaffInfo.setBounds(23, 113, 124, 30);
		panel_1.add(btnStaffInfo);

		JButton btnUserInfo = new JButton("User  Info");
		btnUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUserInfo.setBackground(new Color(255, 69, 0));
		btnUserInfo.setBounds(23, 165, 124, 30);
		panel_1.add(btnUserInfo);

		JButton btnAddWard = new JButton("Add Ward");
		btnAddWard.setForeground(Color.WHITE);
		btnAddWard.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddWard.setBackground(new Color(255, 69, 0));
		btnAddWard.setBounds(23, 216, 124, 30);
		panel_1.add(btnAddWard);

		JButton btnStaffUser = new JButton("Staff  User");
		btnStaffUser.setForeground(Color.WHITE);
		btnStaffUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffUser.setBackground(new Color(255, 69, 0));
		btnStaffUser.setBounds(23, 268, 124, 30);
		panel_1.add(btnStaffUser);
		
		
		JButton btnAddUser = new JButton("Add  User");
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddUser.setBackground(new Color(255, 69, 0));
		btnAddUser.setBounds(23, 316, 124, 30);
		panel_1.add(btnAddUser);
		
		JButton btnViewAppointment = new JButton("View Appointment");
		btnViewAppointment.setForeground(Color.WHITE);
		btnViewAppointment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewAppointment.setBackground(new Color(255, 69, 0));
		btnViewAppointment.setBounds(23, 364, 124, 30);
		panel_1.add(btnViewAppointment);
		//---------------
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 707, 428);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField_4 = new JTextField();
		textField_4.setBounds(139, 239, 173, 25);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(578, 44, 76, 23);
		panel_2.add(btnSearch);
		textField_2 = new JTextField();

		textField_2.setBounds(397, 42, 159, 26);
	
		panel_2.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel1 = new JLabel("Patient  Id :");
		lblNewLabel1.setBounds(35, 94, 76, 16);
		panel_2.add(lblNewLabel1);
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblPatientName = new JLabel("Patient  Name :");
		lblPatientName.setBounds(35, 131, 94, 16);
		panel_2.add(lblPatientName);
		lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setBounds(35, 168, 76, 16);
		panel_2.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(35, 204, 76, 23);
		panel_2.add(lblAge);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblMobileNo = new JLabel("Mobile No :");
		lblMobileNo.setBounds(35, 238, 76, 23);
		panel_2.add(lblMobileNo);
		lblMobileNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAddress = new JLabel("Address  :");
		lblAddress.setBounds(35, 274, 76, 23);
		panel_2.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_3 = new JTextField();
		textField_3.setBounds(139, 128, 173, 26);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(139, 165, 173, 26);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(139, 91, 86, 26);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(139, 202, 173, 26);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 275, 173, 53);
		panel_2.add(textField);
		
		JLabel lblStatusOfDesease = new JLabel("Desease :");
		lblStatusOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatusOfDesease.setBounds(357, 94, 112, 16);
		panel_2.add(lblStatusOfDesease);
		
		JLabel lblCheckInDate = new JLabel("Check in Date :");
		lblCheckInDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckInDate.setBounds(357, 131, 94, 16);
		panel_2.add(lblCheckInDate);
		
		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomNo.setBounds(357, 168, 76, 16);
		panel_2.add(lblRoomNo);
		
		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomType.setBounds(357, 205, 94, 17);
		panel_2.add(lblRoomType);
		
		JLabel lblBuilding = new JLabel("Building :");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuilding.setBounds(357, 241, 76, 17);
		panel_2.add(lblBuilding);
		
		JLabel lblStatOfDesease = new JLabel("Stat. of desease :");
		lblStatOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatOfDesease.setBounds(357, 277, 112, 16);
		panel_2.add(lblStatOfDesease);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(479, 91, 175, 26);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(479, 128, 175, 26);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(479, 165, 175, 26);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(479, 202, 175, 26);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(479, 238, 175, 26);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(479, 274, 175, 26);
		panel_2.add(textField_12);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(549, 322, 94, 36);
		panel_2.add(btnClose);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdate.setBounds(436, 323, 89, 35);
		panel_2.add(btnUpdate);
	
	
	}
}

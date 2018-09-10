package com.hccms.gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Color;
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
import javax.swing.JList;
import javax.swing.border.MatteBorder;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;

public class StaffInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	JLabel lblEnterUserName;
	private JTextField textField;

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
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0,0,894	,159);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(807, 114, 77, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\project_95\\Downloads\\hms\\Shutdown_48px.png"));
		lblNewLabel_2.setBounds(822, 56, 46, 48);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaptionText);
		panel_1.setBounds(0, 159, 188, 413);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.inactiveCaptionText);
		panel_11.setBounds(0, 159, 188, 413);
		//buttons
		JButton btnNewButton = new JButton("Paitent Info");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(23, 39, 124, 30);
		panel_11.add(btnNewButton);
		
		JButton btnRoomInfo = new JButton("Room Info");
		btnRoomInfo.setForeground(Color.WHITE);
		btnRoomInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRoomInfo.setBackground(new Color(255, 69, 0));
		btnRoomInfo.setBounds(23, 91, 124, 30);
		panel_11.add(btnRoomInfo);
		
		JButton btnStaffInfo = new JButton("Staff  Info");
		btnStaffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStaffInfo.setForeground(Color.WHITE);
		btnStaffInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffInfo.setBackground(new Color(255, 69, 0));
		btnStaffInfo.setBounds(23, 150, 124, 30);
		panel_11.add(btnStaffInfo);
		
		JButton btnUserInfo = new JButton("User  Info");
		btnUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUserInfo.setBackground(new Color(255, 69, 0));
		btnUserInfo.setBounds(23, 206, 124, 30);
		panel_11.add(btnUserInfo);
		
		JButton btnAddWard = new JButton("Add Ward");
		btnAddWard.setForeground(Color.WHITE);
		btnAddWard.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddWard.setBackground(new Color(255, 69, 0));
		btnAddWard.setBounds(23, 263, 124, 30);
		panel_11.add(btnAddWard);
		
		JButton btnStaffUser = new JButton("Staff  User");
		btnStaffUser.setForeground(Color.WHITE);
		btnStaffUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffUser.setBackground(new Color(255, 69, 0));
		btnStaffUser.setBounds(23, 317, 124, 30);
		panel_11.add(btnStaffUser);
	
		//---------------
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 707, 437);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Staff Name :");
		lblNewLabel.setBounds(76, 64, 76, 16);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setBounds(64, 91, 112, 26);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblStatusOfDesease = new JLabel(" Staff ID :");
		lblStatusOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatusOfDesease.setBounds(234, 94, 112, 16);
		panel_2.add(lblStatusOfDesease);
		
		JLabel lblCheckInDate = new JLabel(" Staff Name :");
		lblCheckInDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCheckInDate.setBounds(234, 138, 94, 16);
		panel_2.add(lblCheckInDate);
		
		JLabel lblRoomNo = new JLabel(" Gender :");
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomNo.setBounds(234, 175, 76, 16);
		panel_2.add(lblRoomNo);
		
		JLabel lblRoomType = new JLabel(" Position :");
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRoomType.setBounds(234, 215, 94, 17);
		panel_2.add(lblRoomType);
		
		JLabel lblBuilding = new JLabel(" Salary :");
		lblBuilding.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBuilding.setBounds(234, 257, 76, 17);
		panel_2.add(lblBuilding);
		
		JLabel lblStatOfDesease = new JLabel(" Mobile No. :");
		lblStatOfDesease.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStatOfDesease.setBounds(234, 297, 112, 16);
		panel_2.add(lblStatOfDesease);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(329, 91, 175, 26);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(329, 135, 175, 26);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(329, 172, 175, 26);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(329, 212, 175, 26);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(329, 254, 175, 26);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(329, 294, 175, 26);
		panel_2.add(textField_12);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnClose.setBounds(603, 294, 76, 26);
		panel_2.add(btnClose);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnUpdate.setBounds(603, 259, 76, 26);
		panel_2.add(btnUpdate);
		
		JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.GRAY));
		list.setBounds(64, 168, 112, 190);
		panel_2.add(list);
		
		JLabel lblNewLabel_1 = new JLabel(" Join Date :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(528, 92, 76, 20);
		panel_2.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(611, 91, 86, 23);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(603, 222, 76, 26);
		panel_2.add(btnAdd);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(603, 185, 76, 26);
		panel_2.add(btnNew);
	
	
	}
}



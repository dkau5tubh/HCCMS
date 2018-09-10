package com.hccms.gui.admin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\project_15\\Downloads\\hospital\\add User.png"));
		label.setBounds(45, 29, 106, 108);
		panel.add(label);
		
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
		lblNewLabel_1.setBounds(811, 30, 46, 47);
		panel.add(lblNewLabel_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setBackground(new Color(169, 169, 169));
		btnLogout.setBounds(795, 83, 89, 29);
		panel.add(btnLogout);
/// Panel 1
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		// buttons
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
		// ------------------
				contentPane.add(panel_1);
				panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 718, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUserId = new JLabel("User Id:");
		lblUserId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserId.setBounds(183, 75, 85, 14);
		panel_2.add(lblUserId);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(183, 119, 85, 14);
		panel_2.add(lblUserName);
		
		JLabel lblUserpassword = new JLabel("User PassWord:");
		lblUserpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserpassword.setBounds(183, 163, 108, 14);
		panel_2.add(lblUserpassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(183, 209, 122, 14);
		panel_2.add(lblConfirmPassword);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPosition.setBounds(183, 254, 85, 14);
		panel_2.add(lblPosition);
		
		textField = new JTextField();
		textField.setBounds(319, 72, 98, 25);
		panel_2.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(319, 206, 183, 25);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(319, 162, 183, 25);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(319, 118, 183, 25);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(319, 251, 183, 25);
		panel_2.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(314, 312, 89, 34);
		panel_2.add(btnNewButton_1);
		
		JButton btnCancle = new JButton("Cancel");
		btnCancle.setBounds(413, 312, 89, 34);
		panel_2.add(btnCancle);
		
		JLabel lblAddUser = new JLabel("Add User ");
		lblAddUser.setBounds(191, 11, 261, 47);
		panel_2.add(lblAddUser);
		lblAddUser.setForeground(new Color(0, 0, 0));
		lblAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUser.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\project_15\\Downloads\\1.jpg"));
		label_1.setBounds(0, 0, 708, 428);
		panel_2.add(label_1);
	
	}
}

package com.hccms.gui.adminNew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AddUser extends JFrame {

	private JPanel contentPane;
	JTextField textField_1,textField_2,textField_3,textField_5;

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
		
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserName.setBounds(330, 206, 85, 14);
		panel_2.add(lblUserName);
		
		JLabel lblUserpassword = new JLabel("UserPassWord :");
		lblUserpassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUserpassword.setBounds(330, 250, 98, 14);
		panel_2.add(lblUserpassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConfirmPassword.setBounds(330, 296, 122, 14);
		panel_2.add(lblConfirmPassword);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPosition.setBounds(330, 157, 85, 14);
		panel_2.add(lblPosition);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(466, 293, 183, 25);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(466, 249, 183, 25);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(466, 205, 183, 25);
		panel_2.add(textField_3);
		
		JButton btnNewButton_1 = new JButton("Add");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(457, 395, 89, 34);
		panel_2.add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				//textField_4.setText("");
			}
		});
		btnClear.setBounds(556, 395, 89, 34);
		panel_2.add(btnClear);
		
		JLabel lblAddUser = new JLabel("Add User ");
		lblAddUser.setBounds(358, 78, 261, 47);
		panel_2.add(lblAddUser);
		lblAddUser.setForeground(new Color(0, 0, 0));
		lblAddUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddUser.setFont(new Font("Times New Roman", Font.BOLD, 30));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {" select Role", "Doctor", "Receptionist", "Nurse", "WardBoy", "Pharmasist", "Pathologist"}));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(467, 156, 182, 25);
		panel_2.add(comboBox);
		
		JButton closeButton = new JButton("");
		closeButton.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-close-window-48.png"));
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
		closeButton.setBounds(810, 26, 89, 47);
		panel_2.add(closeButton);
	
	}
}

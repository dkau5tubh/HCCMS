package com.hccms.gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewAppointment extends JFrame {

	private JPanel contentPane;
	JLabel lblEnterUserName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointment frame = new ViewAppointment();
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
	public ViewAppointment() {
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
		
		table = new JTable();
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
			
		));
		
		table.setBounds(152, 95, 462, 192);
		panel_2.add(table);
	
	
	}
}



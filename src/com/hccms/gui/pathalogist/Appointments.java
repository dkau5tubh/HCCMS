package com.hccms.gui.pathalogist;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;
import com.hccms.gui.doctor.Doctor;
import com.hccms.gui.pharmacist.MedicinesRequest;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class Appointments extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointments frame = new Appointments();
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
	public Appointments() {
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
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Survey_96px.png"));
		label.setBounds(48, 35, 96, 91);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome,");
		lblNewLabel_1.setFont(new Font("Lao UI", Font.BOLD, 13));
		lblNewLabel_1.setBounds(224, 45, 81, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dr.Pathalogy");
		lblNewLabel_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_2.setBounds(224, 70, 109, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setText(Pathology.username);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Logout functionality 
				try
				{
					Connection con=DBManager.getDBConnectivity();
					String id=Pathology.username;
					Statement stmt=con.createStatement();
					String sql="delete from ACTIVEUSERS where ID='"+id+"'";
					int status=stmt.executeUpdate(sql);
					if(status>0)
					{
						//System.out.println("Removed the users");
					}
					con.close();
					
				}
				catch(Exception se)
				{
					se.printStackTrace();
				}
				
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(783, 101, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Appointments.class.getResource("/com/hms/images/Shutdown_48px.png")));
		lblNewLabel_3.setBounds(803, 35, 48, 49);
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("Appointments");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Appointments frame=new Appointments();
				frame.setVisible(true);
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.PLAIN, 13));
		button.setBackground(Color.RED);
		button.setBounds(25, 85, 129, 35);
		panel_1.add(button);
		
		JButton btnPatientsRecords = new JButton("Patients Records");
		btnPatientsRecords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			PaitentRecord frame=new PaitentRecord();
			frame.setVisible(true);
			
			}
		});
		btnPatientsRecords.setForeground(Color.WHITE);
		btnPatientsRecords.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPatientsRecords.setBackground(Color.RED);
		btnPatientsRecords.setBounds(25, 148, 129, 35);
		panel_1.add(btnPatientsRecords);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Report frame=new Report();
				frame.setVisible(true);
				
			}
		});
		btnReport.setForeground(Color.WHITE);
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReport.setBackground(Color.RED);
		btnReport.setBounds(25, 212, 129, 35);
		panel_1.add(btnReport);
		
		JButton btnBill = new JButton("Bill");
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Bill frame=new Bill();
				frame.setVisible(true);
				
			}
		});
		btnBill.setForeground(Color.WHITE);
		btnBill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBill.setBackground(Color.RED);
		btnBill.setBounds(25, 289, 129, 35);
		panel_1.add(btnBill);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 718, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(93, 231, 34, -30);
		panel_2.add(table);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		table_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_1.setBounds(80, 166, 511, 80);
		panel_2.add(table_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("J:\\Hospital Management Swing\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 708, 413);
		panel_2.add(lblNewLabel);
	}
}


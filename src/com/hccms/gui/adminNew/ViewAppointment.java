package com.hccms.gui.adminNew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewAppointment extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton closeButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAppointment frame = new ViewAppointment();
					frame.setVisible(true);
					//frame.setLocationRelativeTo(null);
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 200, 947, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		
		JLabel lblViewAppointment = new JLabel("View Appointments");
		lblViewAppointment.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblViewAppointment.setBounds(332, 52, 277, 45);
		contentPane.add(lblViewAppointment);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 916, 247);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		//code for displaying the  No. of Appointments 
		
		try
		{
			Connection con=DBManager.getDBConnectivity();
			PreparedStatement pst=con.prepareStatement("select * from APPOINTMENTS");
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
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
			closeButton.setBounds(829, 11, 89, 45);
			contentPane.add(closeButton);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

package com.hccms.gui.pharmacist;




import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;
import com.hccms.gui.pathalogist.Pathology;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMedicalPage extends JFrame {

	private JPanel contentPane;
	public static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		username=args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMedicalPage frame = new MainMedicalPage();
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
	public MainMedicalPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,900, 600);
		setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlightText);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 894, 159);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
					Connection con=DBManager.getDBConnectivity();
					String id=username;
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
		btnLogout.setForeground(Color.WHITE);
		btnLogout.setBackground(new Color(0, 0, 0));
		btnLogout.setBounds(794, 102, 90, 23);
		panel.add(btnLogout);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainMedicalPage.class.getResource("/com/hms/images/Shutdown_48px.png")));
		label.setBounds(811, 41, 46, 48);
		panel.add(label);
		
		JLabel lblDrname = new JLabel("Dr.Name");
		lblDrname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UpdateProfile profile= new UpdateProfile();
				profile.setVisible(true);
				profile.setLocationRelativeTo(null);
			}
		});
		lblDrname.setFont(new Font("Candara", Font.BOLD, 17));
		lblDrname.setBounds(202, 83, 144, 14);
		panel.add(lblDrname);
		lblDrname.setText(username);
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWelcome.setBounds(202, 58, 72, 14);
		panel.add(lblWelcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("Medicine Request");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MedicinesRequest frame = new MedicinesRequest();
				frame.setVisible(true);
			}
		});
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setBounds(21, 107, 137, 35);
		panel_1.add(btnNewButton);
		
		JButton btnBillingHistory = new JButton("Billing History");
		btnBillingHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				BillingHistory frame = new BillingHistory();
				frame.setVisible(true);
			}
		});
		btnBillingHistory.setForeground(Color.WHITE);
		btnBillingHistory.setBackground(new Color(255, 69, 0));
		btnBillingHistory.setBounds(21, 180, 137, 35);
		panel_1.add(btnBillingHistory);
		
		JButton btnMedicines = new JButton("Medicines");
		btnMedicines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MedicinesTests frame = new MedicinesTests();
				frame.setVisible(true);
			}
		});
		btnMedicines.setForeground(Color.WHITE);
		btnMedicines.setBackground(new Color(255, 69, 0));
		btnMedicines.setBounds(21, 255, 137, 35);
		panel_1.add(btnMedicines);
	}
}

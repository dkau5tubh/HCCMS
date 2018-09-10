package com.hccms.gui.accountant;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;
import com.hccms.gui.doctor.UpdateProfile;
import com.hccms.gui.pathalogist.Pathology;

import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AccountantHomeScreen extends JFrame {

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
					AccountantHomeScreen frame = new AccountantHomeScreen();
					frame.setVisible(true);
					frame.setResizable(false);
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
	public AccountantHomeScreen() {
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
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Logout functionality 
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
				frame.setLocationRelativeTo(null);
				
			}
		});
		btnNewButton.setBackground(SystemColor.windowText);
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBounds(795, 109, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome,");
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel.setBounds(187, 32, 89, 23);
		panel.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("Acc.Name");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			com.hccms.gui.accountant.UpdateProfile profile= new com.hccms.gui.accountant.UpdateProfile();
			profile.setVisible(true);
			profile.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_1.setBounds(187, 66, 142, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(username);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\project_95\\Downloads\\hms\\Shutdown_48px.png"));
		label.setBounds(816, 54, 46, 48);
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\Shutdown_48px.png"));
		lblNewLabel_2.setBounds(816, 50, 46, 48);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lblNewLabel_1.setText("Dr.Bandra");
				dispose();
				Bill frame=new Bill();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setForeground(SystemColor.textHighlightText);
		btnNewButton_1.setBounds(33, 103, 119, 45);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(186, 159, 834, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
	}
}
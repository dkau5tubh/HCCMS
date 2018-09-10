package com.hccms.gui.adminNew;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInformation extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton closebutton;
	private JButton closeButton;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInformation frame = new UserInformation();
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
	public UserInformation() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 200, 947, 511);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		
		JLabel lblUserInformation = new JLabel("Active Users Information");
		lblUserInformation.setBounds(312, 22, 324, 49);
		lblUserInformation.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblUserInformation.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblUserInformation);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 151, 865, 250);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		//setting the data from the database to the table of the list of active users
		try
		{
			Connection connection=DBManager.getDBConnectivity();
			String sql="select au.id,au.role,au.email,en.firstname,en.middlename,en.lastname,em.gender,em.qualification,em.mobno,em.hiredate,em.department from ACTIVEUSERS au join ENAMES en on(au.ID=en.ID)join EMPLOYEES em on(au.id=em.id)";
			PreparedStatement pst=connection.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			/*JButton closeButton = new JButton("");
			// Code for remove border
					closeButton.setOpaque(false);
					closeButton.setContentAreaFilled(false);
					closeButton.setBorderPainted(false);
					// ---------- End----------
			closebutton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			closebutton.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-close-window-48.png"));
			closebutton.setBackground(Color.WHITE);
			closebutton.setBounds(848, 11, 89, 49);
			contentPane.add(closebutton);*/
			
			closeButton = new JButton("");
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
			closeButton.setBounds(848, 0, 89, 42);
			contentPane.add(closeButton);
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}
}

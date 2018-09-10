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
import com.hccms.gui.doctor.Doctor;
import com.hccms.gui.pathalogist.Pathology;

import net.proteanit.sql.DbUtils;

import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

public class MedicinesRequest extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;
	private JTable table_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicinesRequest frame = new MedicinesRequest();
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
	public MedicinesRequest() {
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
		
		JLabel lblNewLabel_1 = new JLabel("  Dr.Name");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UpdateProfile profile= new UpdateProfile();
				profile.setVisible(true);
				profile.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_1.setBounds(184, 71, 174, 27);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(MainMedicalPage.username);
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setBounds(190, 43, 78, 27);
		panel.add(lblWelcome);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMedicalPage homeScreen= new MainMedicalPage();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button.setIcon(new ImageIcon(MedicinesRequest.class.getResource("/com/hms/images/icons8-left-64.png")));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(766, 32, 89, 84);
		panel.add(button);
		
		JLabel lblNewLabel = new JLabel("  Medicines  Request");
		lblNewLabel.setBounds(400, 80, 221, 36);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		
		JLabel label = new JLabel("");
		label.setBounds(359, 71, 46, 50);
		panel.add(label);
		label.setIcon(new ImageIcon(MedicinesRequest.class.getResource("/com/hms/images/Pill_48px.png")));
		
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Connection con=DBManager.getDBConnectivity();
					PreparedStatement past1=con.prepareStatement("select m.pid,m.apid,m.medicinename,m.quantity,p.firstname,p.lastname from MEDICINES m join PNAME p on(m.pid=p.pid)");
					ResultSet rs1=past1.executeQuery();
					table_3.setModel(DbUtils.resultSetToTableModel(rs1));
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}

				
				
				
			}
		});
		scrollPane.setBounds(271, 191, 544, 130);
		contentPane.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		
		try {
			
			Connection con=DBManager.getDBConnectivity();
			PreparedStatement past1=con.prepareStatement("select m.pid,m.apid,p.firstname,p.lastname from MEDICINES m join PNAME p on(m.pid=p.pid)");
			ResultSet rs1=past1.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs1));
			
			JLabel lblNewLabel_2 = new JLabel("Total Amount : ");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			lblNewLabel_2.setBounds(591, 497, 113, 34);
			contentPane.add(lblNewLabel_2);
			
			textField = new JTextField();
			textField.setBounds(702, 497, 113, 29);
			contentPane.add(textField);
			textField.setColumns(10);
			
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(271, 346, 544, 130);
		contentPane.add(scrollPane_1);
		
		table_3 = new JTable();
		scrollPane_1.setViewportView(table_3);
		
		
	}
}




	
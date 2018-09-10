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

import javax.swing.ListSelectionModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BillingHistory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillingHistory frame = new BillingHistory();
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
	public BillingHistory() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Welcome,");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2.setBounds(202, 51, 64, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dr.Name");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UpdateProfile profile= new UpdateProfile();
				profile.setVisible(true);
				profile.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_3.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_3.setBounds(202, 77, 130, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setText(MainMedicalPage.username);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(BillingHistory.class.getResource("/com/hms/images/icons8-left-64.png")));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainMedicalPage homeScreen= new MainMedicalPage();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(755, 32, 89, 84);
		panel.add(button);
		
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
		
		JLabel lblNewLabel = new JLabel("Billing History");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(434, 184, 199, 36);
		contentPane.add(lblNewLabel);
		
		table_2 = new JTable();
		table_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_2.setBounds(266, 273, 516, 176);
		contentPane.add(table_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(BillingHistory.class.getResource("/com/hms/images/Bill_48px.png")));
		label.setBounds(378, 180, 46, 50);
		contentPane.add(label);
		
		
	}
}




	
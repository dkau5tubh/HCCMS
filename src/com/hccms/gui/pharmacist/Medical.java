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

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Medical extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Medical frame = new Medical();
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
	public Medical() {
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
		
		JLabel lblNewLabel_1 = new JLabel("Dr.Name");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				UpdateProfile profile= new UpdateProfile();
				profile.setVisible(true);
				profile.setLocationRelativeTo(null);
			}
		});
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(192, 65, 84, 25);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(MainMedicalPage.username);
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWelcome.setBounds(192, 40, 84, 14);
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
		button.setIcon(new ImageIcon(Medical.class.getResource("/com/hms/images/icons8-left-64.png")));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(766, 37, 89, 84);
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
		
		JLabel lblNewLabel = new JLabel("  Medicines Report");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setBounds(434, 184, 199, 36);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("PID/PName/DID");
		textField.setBounds(252, 268, 216, 36);
		contentPane.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, ""},
			},
			new String[] {
				"Sr.No.", "Medicines", "Quantity", "Dosage"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(67);
		table.getColumnModel().getColumn(0).setMinWidth(11);
		table.getColumnModel().getColumn(0).setMaxWidth(85);
		table.getColumnModel().getColumn(3).setMinWidth(18);
		table.setCellSelectionEnabled(true);
		table.setBounds(254, 351, 457, 128);
		contentPane.add(table);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Medical.class.getResource("/com/hms/images/Report Card_48px.png")));
		label_1.setBounds(391, 170, 46, 56);
		contentPane.add(label_1);
	}
}

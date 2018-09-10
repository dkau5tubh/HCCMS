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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;
import com.hccms.gui.pathalogist.Pathology;

import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MedicinesTests extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MedicinesTests frame = new MedicinesTests();
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
	public MedicinesTests() {
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
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(197, 73, 145, 27);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(MainMedicalPage.username);
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblWelcome.setBounds(205, 48, 69, 14);
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
		button.setIcon(new ImageIcon(MedicinesTests.class.getResource("/com/hms/images/icons8-left-64.png")));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(759, 30, 89, 84);
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
		btnMedicines.setBounds(21, 253, 137, 35);
		panel_1.add(btnMedicines);
		
		table_2 = new JTable();
		table_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table_2.setModel(new DefaultTableModel(
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
			},
			new String[] {
				"Sr.No.", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table_2.setBounds(266, 273, 516, 176);
		contentPane.add(table_2);
		
		textField = new JTextField();
		textField.setToolTipText("Search Medicine by Patient ID,Name");
		textField.setBounds(742, 179, 142, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\project_95\\Downloads\\hms\\Search_48px.png"));
		lblNewLabel.setBounds(682, 170, 43, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblAvailableMedicines = new JLabel("Available Medicines");
		lblAvailableMedicines.setForeground(new Color(0, 0, 205));
		lblAvailableMedicines.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAvailableMedicines.setBounds(433, 179, 188, 47);
		contentPane.add(lblAvailableMedicines);
		
		
	}
}




	
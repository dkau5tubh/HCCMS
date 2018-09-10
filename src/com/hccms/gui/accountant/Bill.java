package com.hccms.gui.accountant;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JSeparator;
import java.awt.Canvas;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;
import com.hccms.gui.doctor.UpdateProfile;
import com.hccms.gui.pathalogist.Pathology;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
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
	public Bill() {
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
		
		JLabel lblNewLabel = new JLabel("Welcome,");
		lblNewLabel.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		lblNewLabel.setBounds(186, 48, 89, 23);
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
		lblNewLabel_1.setBounds(186, 82, 89, 28);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(AccountantHomeScreen.username);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AccountantHomeScreen homeScreen = new AccountantHomeScreen();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-left-64.png"));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(775, 35, 89, 84);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Bill");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bill frame=new Bill();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
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
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		table.setFont(new Font("Tahoma", Font.PLAIN, 11));
		table.setEnabled(false);
		table.setSurrendersFocusOnKeystroke(true);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, "", ""},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Sr. No", "Patient Id", "Patient Name", "Status", "Bill"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(4).setResizable(false);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(44, 74, 632, 108);
		panel_2.add(table);
		
		JLabel lblBillingHistory = new JLabel("Billing History");
		lblBillingHistory.setForeground(new Color(255, 69, 0));
		lblBillingHistory.setFont(new Font("Sylfaen", Font.BOLD, 18));
		lblBillingHistory.setBounds(306, 0, 150, 45);
		panel_2.add(lblBillingHistory);
		
		textField = new JTextField();
		textField.setToolTipText("Search by Id or Name");
		textField.setBounds(531, 25, 144, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\Paper Money_48px.png"));
		lblNewLabel_2.setBounds(248, 0, 48, 45);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblPatientId = new JLabel("Patient Id:");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPatientId.setBounds(44, 203, 66, 14);
		panel_2.add(lblPatientId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(152, 201, 86, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPatientName.setBounds(248, 203, 98, 14);
		panel_2.add(lblPatientName);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDate.setBounds(492, 203, 66, 14);
		panel_2.add(lblDate);
		
		JLabel lblDoctorId = new JLabel("Doctor Id:");
		lblDoctorId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoctorId.setBounds(44, 238, 66, 14);
		panel_2.add(lblDoctorId);
		
		JLabel lblDoctorName = new JLabel("Doctor Name:");
		lblDoctorName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDoctorName.setBounds(248, 239, 86, 14);
		panel_2.add(lblDoctorName);
		
		JLabel lblAmount = new JLabel("Doc.amt :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmount.setBounds(492, 239, 66, 14);
		panel_2.add(lblAmount);
		
		JLabel lblPathalogiestId = new JLabel("Pathalogiest Id :");
		lblPathalogiestId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPathalogiestId.setBounds(44, 272, 102, 14);
		panel_2.add(lblPathalogiestId);
		
		JLabel lblName = new JLabel("Patho. Name:");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblName.setBounds(248, 272, 86, 14);
		panel_2.add(lblName);
		
		JLabel lblAmount_1 = new JLabel("Path.amt :");
		lblAmount_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAmount_1.setBounds(480, 272, 66, 14);
		panel_2.add(lblAmount_1);
		
		JLabel lblPharmacistId = new JLabel("Pharmacist Id: ");
		lblPharmacistId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPharmacistId.setBounds(44, 307, 102, 14);
		panel_2.add(lblPharmacistId);
		
		JLabel lblPharmacistName = new JLabel("Pharma. Name: ");
		lblPharmacistName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPharmacistName.setBounds(248, 307, 112, 14);
		panel_2.add(lblPharmacistName);
		
		JLabel lblPhramt = new JLabel("Phr.amt :");
		lblPhramt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPhramt.setBounds(492, 308, 66, 14);
		panel_2.add(lblPhramt);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 236, 86, 20);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(152, 270, 86, 20);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(152, 305, 86, 20);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(347, 201, 109, 20);
		panel_2.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(347, 236, 109, 20);
		panel_2.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(347, 270, 109, 20);
		panel_2.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(347, 305, 109, 20);
		panel_2.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(555, 201, 109, 20);
		panel_2.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(555, 236, 109, 20);
		panel_2.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(555, 270, 109, 20);
		panel_2.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(555, 305, 109, 20);
		panel_2.add(textField_12);
		
		JLabel lblNewLabel_3 = new JLabel("TOTAL : ");
		lblNewLabel_3.setForeground(new Color(0, 0, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_3.setBounds(462, 333, 75, 34);
		panel_2.add(lblNewLabel_3);
		
		textField_13 = new JTextField();
		textField_13.setBounds(540, 342, 124, 20);
		panel_2.add(textField_13);
		textField_13.setColumns(10);
		
		JButton btnPay = new JButton("Pay");
		btnPay.setBackground(new Color(255, 182, 193));
		btnPay.setForeground(new Color(0, 0, 0));
		btnPay.setBounds(492, 379, 89, 25);
		panel_2.add(btnPay);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			textField_8.setText("");
			textField_9.setText("");
			textField_10.setText("");
			textField_11.setText("");
			textField_12.setText("");
			textField_13.setText("");
			}
		});
		btnClear.setBackground(new Color(255, 182, 193));
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setBounds(587, 379, 89, 25);
		panel_2.add(btnClear);
	}
}
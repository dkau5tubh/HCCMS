package com.hccms.gui.doctor;


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
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorPatientHistory extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorPatientHistory frame = new DoctorPatientHistory();
					frame.setVisible(true);
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
	public DoctorPatientHistory() {
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
		lblNewLabel.setBounds(200, 23, 89, 23);
		panel.add(lblNewLabel);
		
		final JLabel lblNewLabel_1 = new JLabel("Dr.Name");
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
		lblNewLabel_1.setBounds(200, 57, 153, 28);
		panel.add(lblNewLabel_1);
		String username="Dr. "+Doctor.username;
		lblNewLabel_1.setText(username);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Doctor homeScreen= new Doctor();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-left-64.png"));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(776, 37, 89, 84);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Appointments");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//lblNewLabel_1.setText("Dr.Bandra");
				dispose();
				DoctorAppointments frame = new DoctorAppointments();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBackground(new Color(255, 69, 0));
		btnNewButton_1.setForeground(SystemColor.textHighlightText);
		btnNewButton_1.setBounds(33, 108, 118, 45);
		panel_1.add(btnNewButton_1);
		
		JButton btnPatientRecord = new JButton("Patient Record");
		btnPatientRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPatientRecord.setForeground(Color.WHITE);
		btnPatientRecord.setBackground(new Color(255, 69, 0));
		btnPatientRecord.setBounds(33, 197, 118, 43);
		panel_1.add(btnPatientRecord);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(186, 159, 708, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(548, 39, 131, 34);
		panel_2.add(textField);
		textField.setColumns(10);
		
		table = new JTable();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Sr.no", "Name", "Date of Appointment", "Date of Birth", "Age", "Gender", "Medical Reason", "Test", "Medicines"
			}
		));
		table.setBounds(52, 108, 627, 96);
		panel_2.add(table);
		
		JLabel lblNewLabel_2 = new JLabel("Patient Medical History");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(250, 26, 245, 31);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblPatientId = new JLabel("Patient Id");
		lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPatientId.setForeground(new Color(0, 0, 0));
		lblPatientId.setBounds(51, 215, 65, 23);
		panel_2.add(lblPatientId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 215, 103, 23);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setForeground(Color.BLACK);
		lblPatientName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPatientName.setBounds(251, 215, 82, 23);
		panel_2.add(lblPatientName);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(343, 216, 103, 23);
		panel_2.add(textField_2);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.BLACK);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblGender.setBounds(460, 215, 82, 23);
		panel_2.add(lblGender);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(529, 217, 103, 23);
		panel_2.add(textField_3);
		
		JLabel lblAppointDate = new JLabel("Appointment");
		lblAppointDate.setForeground(Color.BLACK);
		lblAppointDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAppointDate.setBounds(29, 264, 87, 23);
		panel_2.add(lblAppointDate);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(126, 266, 103, 23);
		panel_2.add(textField_4);
		
		JLabel lblMedicines = new JLabel("Medicines");
		lblMedicines.setForeground(Color.BLACK);
		lblMedicines.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMedicines.setBounds(235, 266, 63, 23);
		panel_2.add(lblMedicines);
		
		JLabel lblTest = new JLabel("Test");
		lblTest.setForeground(Color.BLACK);
		lblTest.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTest.setBounds(491, 264, 32, 23);
		panel_2.add(lblTest);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(Color.BLACK);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAge.setBounds(51, 310, 70, 23);
		panel_2.add(lblAge);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(126, 312, 103, 23);
		panel_2.add(textField_5);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(DoctorPatientHistory.class.getResource("/com/hms/images/Paste Special_48px.png")));
		lblNewLabel_3.setBounds(171, 14, 48, 62);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Search");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(548, 14, 46, 14);
		panel_2.add(lblNewLabel_4);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(304, 251, 169, 102);
		panel_2.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(529, 251, 169, 102);
		panel_2.add(textArea_1);
	}
}

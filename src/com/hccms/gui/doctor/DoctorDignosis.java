package com.hccms.gui.doctor;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

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
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorDignosis extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorDignosis frame = new DoctorDignosis();
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
	public DoctorDignosis() {
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
		lblNewLabel.setBounds(172, 32, 89, 23);
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
		lblNewLabel_1.setBounds(172, 70, 137, 28);
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
		button.setBounds(774, 34, 89, 84);
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
				dispose();
				DoctorPatientHistory frame = new DoctorPatientHistory();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
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
		
		JLabel lblDignosisScreen = new JLabel("Diagnosis Screen");
		lblDignosisScreen.setForeground(Color.RED);
		lblDignosisScreen.setBackground(Color.WHITE);
		lblDignosisScreen.setFont(new Font("Microsoft PhagsPa", Font.BOLD, 22));
		lblDignosisScreen.setBounds(284, 29, 275, 40);
		panel_2.add(lblDignosisScreen);
		
		JButton btnNewButton_2 = new JButton("Prescribe Test");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				PrescribeTests frame = new PrescribeTests();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(null);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(138, 43, 226));
		btnNewButton_2.setFont(new Font("Gisha", Font.BOLD, 11));
		btnNewButton_2.setBounds(176, 297, 150, 40);
		panel_2.add(btnNewButton_2);
		
		JButton btnPrescribeMedicines = new JButton("Prescribe Medicines");
		btnPrescribeMedicines.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PrescribeMedicines frame = new PrescribeMedicines();
				frame.setVisible(true);
			}
		});
		btnPrescribeMedicines.setForeground(SystemColor.textHighlightText);
		btnPrescribeMedicines.setFont(new Font("Gisha", Font.BOLD, 11));
		btnPrescribeMedicines.setBackground(new Color(138, 43, 226));
		btnPrescribeMedicines.setBounds(423, 297, 150, 40);
		panel_2.add(btnPrescribeMedicines);
		
		JLabel lblTest = new JLabel("test");
		lblTest.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Paste Special_48px.png"));
		lblTest.setBounds(205, 171, 91, 115);
		panel_2.add(lblTest);
		
		JLabel lblMedicin = new JLabel("medicine");
		lblMedicin.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Pill_48px.png"));
		lblMedicin.setBounds(450, 171, 99, 115);
		panel_2.add(lblMedicin);
	}
}

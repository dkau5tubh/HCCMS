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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import net.proteanit.sql.DbUtils;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoctorAppointments extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textFieldAppid;
	private JTextField textField_Patid;
	private JTextField textField_Gender;
	private JTextField textField_Fname;
	private JTextField textField_Mname;
	private JTextField textField_Lname;
	private JTextField textField_Dob;
	private JTextField textField_Bgrp;
	private JTextField textField_status;
	private JTextField textField_mobno;
	private JTextArea textArea_Symptoms;
	Border emptyBorder = BorderFactory.createEmptyBorder();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorAppointments frame = new DoctorAppointments();
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
	public DoctorAppointments() {
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
		lblNewLabel.setBounds(194, 36, 89, 23);
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
		lblNewLabel_1.setBounds(194, 70, 158, 28);
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
		button.setIcon(new ImageIcon(DoctorAppointments.class.getResource("/com/hms/images/icons8-left-64.png")));
		button.setBackground(SystemColor.textHighlight);
		button.setBounds(777, 38, 89, 84);
		panel.add(button);
		
		JLabel lblPatientAppointments = new JLabel("Patient Appointments");
		lblPatientAppointments.setBounds(463, 56, 223, 27);
		panel.add(lblPatientAppointments);
		lblPatientAppointments.setForeground(Color.WHITE);
		lblPatientAppointments.setHorizontalAlignment(SwingConstants.CENTER);
		lblPatientAppointments.setFont(new Font("Sylfaen", Font.BOLD, 20));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(383, 38, 46, 49);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setBackground(Color.WHITE);
		lblNewLabel_3.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Google Calendar_48px.png"));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Appointments");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(186, 159, 708, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 50, 662, 86);
		panel_2.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DefaultTableModel model=(DefaultTableModel) table.getModel();
				int selectedRowIndex=table.getSelectedRow();
				
				textFieldAppid.setText(model.getValueAt(selectedRowIndex, 0).toString());
				textField_Patid.setText(model.getValueAt(selectedRowIndex, 1).toString());
				textField_Gender.setText(model.getValueAt(selectedRowIndex, 2).toString());
				textField_Fname.setText(model.getValueAt(selectedRowIndex, 3).toString());
				textField_Mname.setText(model.getValueAt(selectedRowIndex, 4).toString());
				textField_Lname.setText(model.getValueAt(selectedRowIndex, 5).toString());
				textField_Dob.setText(model.getValueAt(selectedRowIndex, 6).toString());
				textField_Bgrp.setText(model.getValueAt(selectedRowIndex, 7).toString());
				textArea_Symptoms.setText(model.getValueAt(selectedRowIndex, 8).toString());
				textField_status.setText(model.getValueAt(selectedRowIndex, 9).toString());
				textField_mobno.setText(model.getValueAt(selectedRowIndex, 10).toString());
				
				
				
				
				
			}
		});
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		scrollPane.setViewportView(table);
		
		/*---------------------code for the loading the appointments data from the databae-------------*/
		
		try
		{
			Connection con=DBManager.getDBConnectivity();
			PreparedStatement pst=con.prepareStatement("select a.appid,a.patid,a.gender,p.firstname,p.middlename,p.lastname,a.dob,a.bldgrp,a.symptoms,a.status,a.mobno from APPOINTMENTS a join PNAME p on(a.patid=p.pid) where aptto='"+Doctor.username+"'");
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JLabel lblNewLabel_4 = new JLabel("Appoint Id");
			lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNewLabel_4.setForeground(Color.BLACK);
			lblNewLabel_4.setBounds(44, 169, 76, 14);
			panel_2.add(lblNewLabel_4);
			
			textFieldAppid = new JTextField();
			textFieldAppid.setBounds(130, 167, 130, 27);
			panel_2.add(textFieldAppid);
			textFieldAppid.setColumns(10);
			
			JLabel lblPatientId = new JLabel("Patient Id");
			lblPatientId.setForeground(Color.BLACK);
			lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPatientId.setBounds(270, 169, 76, 14);
			panel_2.add(lblPatientId);
			
			JLabel lblGender_1 = new JLabel("Gender");
			lblGender_1.setForeground(Color.BLACK);
			lblGender_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblGender_1.setBounds(493, 169, 59, 14);
			panel_2.add(lblGender_1);
			
			JLabel lblGender = new JLabel("First Name");
			lblGender.setForeground(Color.BLACK);
			lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblGender.setBounds(44, 207, 76, 14);
			panel_2.add(lblGender);
			
			JLabel lblEmail = new JLabel("Middle Name");
			lblEmail.setForeground(Color.BLACK);
			lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblEmail.setBounds(270, 207, 86, 14);
			panel_2.add(lblEmail);
			
			JLabel lblMobNo = new JLabel("Last Name");
			lblMobNo.setForeground(Color.BLACK);
			lblMobNo.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblMobNo.setBounds(493, 210, 76, 14);
			panel_2.add(lblMobNo);
			
			JLabel lblBloodGroup = new JLabel("Blood Group");
			lblBloodGroup.setForeground(Color.BLACK);
			lblBloodGroup.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblBloodGroup.setBounds(272, 252, 87, 14);
			panel_2.add(lblBloodGroup);
			
			JLabel lblDateOfBirth = new JLabel("DOB");
			lblDateOfBirth.setForeground(Color.BLACK);
			lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDateOfBirth.setBounds(44, 252, 51, 14);
			panel_2.add(lblDateOfBirth);
			
			JLabel lblSymptoms = new JLabel("Symptoms");
			lblSymptoms.setForeground(Color.BLACK);
			lblSymptoms.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSymptoms.setBounds(496, 261, 67, 14);
			panel_2.add(lblSymptoms);
			
			textField_Patid = new JTextField();
			textField_Patid.setColumns(10);
			textField_Patid.setBounds(356, 167, 130, 27);
			panel_2.add(textField_Patid);
			
			textField_Gender = new JTextField();
			textField_Gender.setColumns(10);
			textField_Gender.setBounds(565, 167, 130, 27);
			panel_2.add(textField_Gender);
			
			textField_Fname = new JTextField();
			textField_Fname.setColumns(10);
			textField_Fname.setBounds(130, 205, 130, 27);
			panel_2.add(textField_Fname);
			
			textField_Mname = new JTextField();
			textField_Mname.setColumns(10);
			textField_Mname.setBounds(356, 205, 130, 27);
			panel_2.add(textField_Mname);
			
			textField_Lname = new JTextField();
			textField_Lname.setColumns(10);
			textField_Lname.setBounds(565, 205, 130, 27);
			panel_2.add(textField_Lname);
			
			textField_Dob = new JTextField();
			textField_Dob.setColumns(10);
			textField_Dob.setBounds(130, 247, 130, 27);
			panel_2.add(textField_Dob);
			
			textField_Bgrp = new JTextField();
			textField_Bgrp.setColumns(10);
			textField_Bgrp.setBounds(356, 247, 130, 27);
			panel_2.add(textField_Bgrp);
			
			JLabel lblStatus = new JLabel("Status");
			lblStatus.setForeground(Color.BLACK);
			lblStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblStatus.setBounds(44, 290, 51, 14);
			panel_2.add(lblStatus);
			
			textField_status = new JTextField();
			textField_status.setColumns(10);
			textField_status.setBounds(130, 288, 130, 27);
			panel_2.add(textField_status);
			
			textField_mobno = new JTextField();
			textField_mobno.setColumns(10);
			textField_mobno.setBounds(356, 285, 130, 27);
			panel_2.add(textField_mobno);
			
			JLabel lblMobNo_1 = new JLabel("Mob No");
			lblMobNo_1.setForeground(Color.BLACK);
			lblMobNo_1.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblMobNo_1.setBounds(270, 291, 76, 14);
			panel_2.add(lblMobNo_1);
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(573, 257, 125, 56);
			panel_2.add(scrollPane_1);
			
			textArea_Symptoms = new JTextArea();
			textArea_Symptoms.setBackground(Color.WHITE);
			scrollPane_1.setViewportView(textArea_Symptoms);
			
			JButton button_preTest = new JButton("");
			Border emptyBorder = BorderFactory.createEmptyBorder();
			button_preTest.setBorder(emptyBorder);	
			button_preTest.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					String patientid=textField_Patid.getText();
					String appointid=textFieldAppid.getText();
					String data[]=new String[2];
					data[0]=patientid;
					data[1]=appointid;
					System.out.println(data[0]+"-->"+data[1]);
					dispose();
					PrescribeTests pt=new PrescribeTests();
					pt.main(data);
					pt.setVisible(true);
					
					
				}
			});
			button_preTest.setBackground(Color.WHITE);
			button_preTest.setIcon(new ImageIcon(DoctorAppointments.class.getResource("/com/hms/images/Paste Special_48px.png")));
			button_preTest.setBounds(231, 334, 89, 56);
			panel_2.add(button_preTest);
			
			JButton button_preMedicines = new JButton("");
			button_preMedicines.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String patientid=textField_Patid.getText();
					String appointid=textFieldAppid.getText();
					String data[]=new String[2];
					data[0]=patientid;
					data[1]=appointid;
					System.out.println(data[0]+"-->"+data[1]);
					dispose();
					PrescribeMedicines prme=new PrescribeMedicines();
					prme.main(data);
					//prme.setVisible(true);
				}
			});
			button_preMedicines.setBackground(Color.WHITE);
			Border emptyBorder1 = BorderFactory.createEmptyBorder();
			button_preMedicines.setBorder(emptyBorder1);
			button_preMedicines.setIcon(new ImageIcon(DoctorAppointments.class.getResource("/com/hms/images/Pill_48px.png")));
			button_preMedicines.setBounds(382, 334, 89, 56);
			panel_2.add(button_preMedicines);
			
			JLabel lblNewLabel_5 = new JLabel("<html>Prescribe<br/> Test</html>",SwingConstants.CENTER);
			lblNewLabel_5.setForeground(new Color(0, 0, 128));
			lblNewLabel_5.setFont(new Font("Verdana", Font.BOLD, 14));
			lblNewLabel_5.setBounds(140, 334, 81, 56);
			panel_2.add(lblNewLabel_5);
			
			JLabel label = new JLabel("<html>Prescribe<br/>Medicines</html>", SwingConstants.CENTER);
			label.setForeground(new Color(0, 0, 128));
			label.setFont(new Font("Verdana", Font.BOLD, 14));
			label.setBounds(496, 334, 81, 56);
			panel_2.add(label);
			
		}
		catch(Exception e)

		{
			e.printStackTrace();
		}
		
		
		
	}
}

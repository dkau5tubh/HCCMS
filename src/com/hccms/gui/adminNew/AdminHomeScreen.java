package com.hccms.gui.adminNew;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import com.hccms.db.DBManager;
//login package
import com.hccms.gui.commonlogin.Login;
import java.awt.Color;

public class AdminHomeScreen extends JFrame {

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
					AdminHomeScreen frame = new AdminHomeScreen();
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
	public AdminHomeScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.menuText);
		panel.setBounds(0, 0, 936, 165);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnAddWard = new JButton("Add Ward");
		btnAddWard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				AddWard frame = new AddWard();
				frame.setVisible(true);
				frame.setLocation(160, 220);
				frame.setBounds(45, 210, 936, 500);
			}
		});
		btnAddWard.setBackground(SystemColor.menuText);
		btnAddWard.setForeground(SystemColor.textHighlightText);
		btnAddWard.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddWard.setBounds(147, 115, 89, 23);
		panel.add(btnAddWard);
		
		JButton btnAddStaff = new JButton("Add Staff");
		btnAddStaff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
              AddEmployee employee = new AddEmployee();
              employee.setVisible(true);
              employee.setLocation(150, 180);
              employee.setBounds(45, 210, 936, 500);
			
			}
		});
		btnAddStaff.setBackground(SystemColor.menuText);
		btnAddStaff.setForeground(SystemColor.textHighlightText);
		btnAddStaff.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddStaff.setBounds(24, 115, 89, 23);
		panel.add(btnAddStaff);
		
		JButton btnPatientInfo = new JButton("Patient Info");
		btnPatientInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PatientInformation patientInformation =new PatientInformation();
				patientInformation.setVisible(true);
				patientInformation.setBounds(45, 210, 936, 500);
			}
		});
		btnPatientInfo.setBackground(SystemColor.menuText);
		btnPatientInfo.setForeground(SystemColor.textHighlightText);
		btnPatientInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnPatientInfo.setBounds(258, 115, 107, 23);
		panel.add(btnPatientInfo);
		
		JButton btnWardInfo = new JButton("Ward Info");
		btnWardInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				WardInformation wardInformation = new WardInformation();
				wardInformation.setVisible(true);
				wardInformation.setBounds(45, 210, 936, 500);
			}
		});
		btnWardInfo.setBackground(SystemColor.menuText);
		btnWardInfo.setForeground(SystemColor.textHighlightText);
		btnWardInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnWardInfo.setBounds(388, 115, 89, 23);
		panel.add(btnWardInfo);
		
		JButton btnStaffInfo = new JButton("Staff Info");
		btnStaffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StaffInformation staffInformation = new StaffInformation();
				staffInformation.setVisible(true);
				staffInformation.setBounds(45, 210, 936, 500);
			}
		});
		btnStaffInfo.setBackground(SystemColor.menuText);
		btnStaffInfo.setForeground(SystemColor.textHighlightText);
		btnStaffInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffInfo.setBounds(500, 115, 89, 23);
		panel.add(btnStaffInfo);
		
		JButton btnUserInfo = new JButton("user Info");
		btnUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInformation userInformation= new UserInformation();
				userInformation.setVisible(true);
				userInformation.setBounds(45, 210, 936, 500);
			}
		});
		btnUserInfo.setBackground(SystemColor.menuText);
		btnUserInfo.setForeground(SystemColor.textHighlightText);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUserInfo.setBounds(613, 115, 89, 23);
		panel.add(btnUserInfo);
		
		JButton btnViewAppointment = new JButton("view Appoint");
		btnViewAppointment.setBackground(SystemColor.menuText);
		btnViewAppointment.setForeground(SystemColor.textHighlightText);
		btnViewAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ViewAppointment appointment= new ViewAppointment();
				appointment.setVisible(true);
				appointment.setLocation(240, 195);
				appointment.setBounds(45, 210, 936, 500);
			}
		});
		btnViewAppointment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewAppointment.setBounds(723, 115, 104, 23);
		panel.add(btnViewAppointment);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
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
						System.out.println("Removed the users");
					}
					con.close();
					
				}
				catch(Exception se)
				{
					se.printStackTrace();
				}
				
				
				Window.getWindows();
				
				//disposing the activated frames 
				AddEmployee addEmployee=new AddEmployee();
				addEmployee.dispose();
				
				AddUser addUser= new AddUser();
				addUser.dispose();
				
				PatientInformation patientInformation =new PatientInformation();
				patientInformation.dispose();
				
				WardInformation wardInformation =new WardInformation();
				wardInformation.dispose();
				
				StaffInformation staffInformation =new StaffInformation();
				staffInformation.dispose();
				
				UserInformation userInformation =new UserInformation();
				userInformation.dispose();
				
				ViewAppointment viewAppointment= new ViewAppointment();
				viewAppointment.dispose();
				
				dispose();
				
				Login login= new Login();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
			}
		});
		btnLogout.setBackground(SystemColor.menuText);
		btnLogout.setForeground(SystemColor.textHighlightText);
		btnLogout.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogout.setBounds(837, 115, 89, 23);
		panel.add(btnLogout);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/Room_48px.png")));
		label_1.setBounds(163, 34, 48, 70);
		panel.add(label_1);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/Cast_48px.png")));
		label_3.setBounds(284, 34, 48, 70);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/Hospital 3_48px.png")));
		label_4.setBounds(409, 34, 48, 70);
		panel.add(label_4);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/Add User Group Man Man_48px.png")));
		label_2.setBounds(41, 34, 48, 70);
		panel.add(label_2);
		
		JLabel label_5 = new JLabel("");
		label_5.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/Name Tag_48px.png")));
		label_5.setBounds(518, 34, 48, 70);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/More Info_48px.png")));
		label_6.setBounds(630, 34, 48, 70);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/Calendar Plus_48px.png")));
		label_7.setBounds(745, 34, 48, 70);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setIcon(new ImageIcon(AdminHomeScreen.class.getResource("/com/hms/images/Shutdown_48px.png")));
		label_8.setBounds(860, 34, 48, 70);
		panel.add(label_8);
		
		JLabel lblNewLabel = new JLabel("Welcome,");
		lblNewLabel.setFont(new Font("Candara", Font.BOLD, 12));
		lblNewLabel.setForeground(SystemColor.textHighlightText);
		lblNewLabel.setBounds(43, 11, 70, 23);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD, 13));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(110, 5, 126, 34);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setText(username);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 162, 936, 500);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
	}
}

package com.hccms.gui.pathalogist;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;
import com.hccms.gui.doctor.Doctor;

import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Pathology extends JFrame {

	private JPanel contentPane;
	private JTextField txtEnterPatientsId;
	private JTextField txtEnterPatientsName;
	public static String username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		username=args[0];
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pathology frame = new Pathology();
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
	public Pathology() {
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
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.addActionListener(new ActionListener() {
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
				
				dispose();
				Login frame = new Login();
				frame.setVisible(true);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnLogOut.setBounds(760, 100, 89, 23);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Pathology.class.getResource("/com/hms/images/Shutdown_48px.png")));
		lblNewLabel_1.setBounds(781, 38, 46, 48);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Survey_96px.png"));
		lblNewLabel_3.setBounds(25, 25, 89, 96);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Welcome,");
		lblNewLabel_4.setFont(new Font("Lao UI", Font.BOLD, 13));
		lblNewLabel_4.setBounds(239, 50, 74, 23);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Dr.Pathalogy");
		lblNewLabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				UpdateProfile profile=new UpdateProfile();
				profile.setVisible(true);
				profile.setLocationRelativeTo(null);
				
			}
		});
		lblNewLabel_5.setForeground(SystemColor.textHighlightText);
		lblNewLabel_5.setBackground(SystemColor.textHighlight);
		lblNewLabel_5.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_5.setBounds(239, 84, 148, 23);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setText(username);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JList list = new JList();
		list.setBounds(90, 270, 17, -53);
		panel_1.add(list);
		
		JButton btnPatitentsRecord = new JButton("Paitent's Record");
		btnPatitentsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PaitentRecord  frame = new PaitentRecord ();
				frame.setVisible(true);
			}
		});
		btnPatitentsRecord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPatitentsRecord.setBackground(Color.RED);
		btnPatitentsRecord.setForeground(SystemColor.textHighlightText);
		btnPatitentsRecord.setBounds(21, 163, 146, 35);
		panel_1.add(btnPatitentsRecord);
		
		JButton btnAppointments = new JButton("Appointments");
		btnAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				Appointments frame=new Appointments();
				frame.setVisible(true);
				
			}
		});
		btnAppointments.setForeground(SystemColor.textHighlightText);
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAppointments.setBackground(Color.RED);
		btnAppointments.setBounds(21, 84, 146, 35);
		panel_1.add(btnAppointments);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Report frame=new Report();
				frame.setVisible(true);
			}
		});
		btnReport.setForeground(Color.WHITE);
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReport.setBackground(Color.RED);
		btnReport.setBounds(21, 237, 146, 35);
		panel_1.add(btnReport);
		
		JButton btnBill = new JButton("Bill");
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Bill frame=new Bill();
				frame.setVisible(true);
			}
		});
		btnBill.setForeground(Color.WHITE);
		btnBill.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnBill.setBackground(Color.RED);
		btnBill.setBounds(21, 303, 146, 35);
		panel_1.add(btnBill);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 718, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtEnterPatientsId = new JTextField();
		txtEnterPatientsId.setToolTipText(" Enter Patient's Id");
		txtEnterPatientsId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnterPatientsId.setBounds(309, 112, 131, 20);
		panel_2.add(txtEnterPatientsId);
		txtEnterPatientsId.setColumns(10);
		
		txtEnterPatientsName = new JTextField();
		txtEnterPatientsName.setToolTipText("Enter Patient's Name");
		txtEnterPatientsName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtEnterPatientsName.setBounds(309, 165, 131, 20);
		panel_2.add(txtEnterPatientsName);
		txtEnterPatientsName.setColumns(10);	
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSubmit.setBounds(212, 252, 89, 23);
		panel_2.add(btnSubmit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtEnterPatientsId.setText("");
				txtEnterPatientsName.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnClear.setBounds(351, 252, 89, 23);
		panel_2.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("Patient Id");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNewLabel.setBounds(190, 114, 67, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblPatientName.setBounds(178, 167, 94, 14);
		panel_2.add(lblPatientName);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("J:\\Hospital Management Swing\\1.jpg"));
		lblNewLabel_2.setBounds(0, 0, 708, 413);
		panel_2.add(lblNewLabel_2);
	}
}



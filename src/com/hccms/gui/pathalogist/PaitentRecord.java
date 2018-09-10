package com.hccms.gui.pathalogist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.TextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import javax.swing.border.LineBorder;

public class PaitentRecord extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaitentRecord  frame = new PaitentRecord ();
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
	public PaitentRecord () {
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
				
				try
				{
					Connection con=DBManager.getDBConnectivity();
					String id=Pathology.username;
					Statement stmt=con.createStatement();
					String sql="delete from ACTIVEUSERS where ID='"+id+"'";
					int status=stmt.executeUpdate(sql);
					if(status>0)
					{
						//System.out.println("Removed the users");
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
		btnLogOut.setBackground(Color.LIGHT_GRAY);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogOut.setBounds(763, 105, 89, 23);
		panel.add(btnLogOut);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(PaitentRecord.class.getResource("/com/hms/images/Shutdown_48px.png")));
		lblNewLabel_2.setBounds(786, 51, 46, 43);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Survey_96px.png"));
		lblNewLabel_1.setBounds(41, 37, 96, 91);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Welcome,");
		lblNewLabel_3.setFont(new Font("Lao UI", Font.BOLD, 13));
		lblNewLabel_3.setBounds(226, 51, 89, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Dr.Patho");
		lblNewLabel_4.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_4.setForeground(SystemColor.textHighlightText);
		lblNewLabel_4.setBounds(226, 75, 133, 19);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setText(Pathology.username);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAppointments = new JButton("Appointments");
		btnAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Appointments frame=new Appointments();
				frame.setVisible(true);
			}
		});
		btnAppointments.setForeground(SystemColor.textHighlightText);
		btnAppointments.setBackground(Color.RED);
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAppointments.setBounds(22, 95, 135, 35);
		panel_1.add(btnAppointments);
		
		JButton btnPatientRecord = new JButton("Patient Record");
		btnPatientRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PaitentRecord  frame = new PaitentRecord ();
				frame.setVisible(true);
			}
		});
		btnPatientRecord.setForeground(SystemColor.textHighlightText);
		btnPatientRecord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPatientRecord.setBackground(Color.RED);
		btnPatientRecord.setBounds(22, 191, 135, 35);
		panel_1.add(btnPatientRecord);
		
		JButton btnReport = new JButton("Report");
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Report frame=new Report();
				frame.setVisible(true);
			}
		});
		btnReport.setForeground(Color.WHITE);
		btnReport.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnReport.setBackground(Color.RED);
		btnReport.setBounds(22, 265, 135, 35);
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
		btnBill.setBounds(22, 341, 135, 35);
		panel_1.add(btnBill);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(186, 159, 718, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPaitentInformation = new JLabel("Patient Record");
		lblPaitentInformation.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPaitentInformation.setBounds(294, 11, 124, 24);
		panel_2.add(lblPaitentInformation);
		
		JLabel lblPaitentId = new JLabel("Patient Id:");
		lblPaitentId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPaitentId.setBounds(35, 198, 67, 24);
		panel_2.add(lblPaitentId);
		
		textField = new JTextField();
		textField.setBounds(338, 201, 118, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblPati = new JLabel("Patient Name:");
		lblPati.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPati.setBounds(251, 203, 88, 14);
		panel_2.add(lblPati);
		
		textField_1 = new JTextField();
		textField_1.setBounds(112, 201, 118, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAge.setBounds(494, 195, 46, 30);
		panel_2.add(lblAge);
		
		textField_3 = new JTextField();
		textField_3.setBounds(550, 201, 118, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDrName = new JLabel("Dr Name:");
		lblDrName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDrName.setBounds(36, 281, 67, 14);
		panel_2.add(lblDrName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(113, 279, 118, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTest = new JLabel("Test:");
		lblTest.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTest.setBounds(494, 281, 46, 14);
		panel_2.add(lblTest);
		
		JLabel lblSymtomps = new JLabel("Symtomps:");
		lblSymtomps.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSymtomps.setBounds(252, 281, 76, 14);
		panel_2.add(lblSymtomps);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
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
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table_1.setBounds(35, 46, 633, 124);
		panel_2.add(table_1);
		
		TextArea textArea = new TextArea();
		textArea.setBounds(338, 239, 99, 110);
		panel_2.add(textArea);
		
		TextArea textArea_1 = new TextArea();
		textArea_1.setBounds(550, 236, 118, 124);
		panel_2.add(textArea_1);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(SystemColor.textHighlightText);
		btnSubmit.setBackground(Color.RED);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSubmit.setBounds(579, 374, 89, 28);
		panel_2.add(btnSubmit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("J:\\Hospital Management Swing\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 708, 428);
		panel_2.add(lblNewLabel);
	}
}

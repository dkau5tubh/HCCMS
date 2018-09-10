package com.hccms.gui.pathalogist;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.print.Doc;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Report extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtEnterDoctorId;
	JLabel DocId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Report frame = new Report();
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
	public Report() {
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(794, 38, 46, 48);
		lblNewLabel_1.setIcon(new ImageIcon(Report.class.getResource("/com/hms/images/Shutdown_48px.png")));
		panel.add(lblNewLabel_1);
		
		JButton btnLogOut = new JButton("Logout");
		btnLogOut.setBounds(773, 97, 89, 23);
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
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel.add(btnLogOut);
		
		JLabel label = new JLabel("New label");
		label.setBounds(10, 38, 96, 91);
		label.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Survey_96px.png"));
		panel.add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome,");
		lblNewLabel_2.setBounds(202, 55, 96, 14);
		lblNewLabel_2.setFont(new Font("Lao UI", Font.BOLD, 13));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dr.Patho");
		lblNewLabel_3.setForeground(SystemColor.controlLtHighlight);
		lblNewLabel_3.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_3.setBounds(202, 76, 157, 23);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setText(Pathology.username);
		
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
		btnAppointments.setBackground(Color.RED);
		btnAppointments.setForeground(SystemColor.textHighlightText);
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAppointments.setBounds(32, 71, 129, 35);
		panel_1.add(btnAppointments);
		
		JButton btnNewButton = new JButton("Paitent's Record");
		btnNewButton.setForeground(SystemColor.textHighlightText);
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				PaitentRecord frame=new PaitentRecord();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(32, 141, 129, 35);
		panel_1.add(btnNewButton);
		
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
		btnReport.setBounds(32, 209, 129, 35);
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
		btnBill.setBounds(32, 286, 129, 35);
		panel_1.add(btnBill);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(186, 159, 708, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setBounds(173, 175, 18, -23);
		panel_2.add(table);
		
		table_1 = new JTable();
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Result", "Scan Type", "Sr No"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Integer.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.setBounds(119, 212, 515, 64);
		panel_2.add(table_1);
		
		JLabel lblName = new JLabel("  Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblName.setBounds(86, 97, 53, 14);
		panel_2.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(158, 95, 103, 20);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblPatientId = new JLabel("Patient Id:");
		lblPatientId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPatientId.setBounds(86, 150, 74, 14);
		panel_2.add(lblPatientId);
		
		textField_1 = new JTextField();
		textField_1.setBounds(158, 148, 103, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHeight.setBounds(283, 101, 63, 18);
		panel_2.add(lblHeight);
		
		textField_2 = new JTextField();
		textField_2.setBounds(342, 99, 103, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblWight = new JLabel("Weight:");
		lblWight.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblWight.setBounds(283, 150, 46, 15);
		panel_2.add(lblWight);
		
		textField_3 = new JTextField();
		textField_3.setBounds(342, 148, 103, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblAge = new JLabel("DOB:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAge.setBounds(495, 100, 46, 17);
		panel_2.add(lblAge);
		
		textField_4 = new JTextField();
		textField_4.setBounds(561, 101, 86, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblDob = new JLabel("Blood grp:");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDob.setBounds(495, 150, 63, 20);
		panel_2.add(lblDob);
		
		textField_5 = new JTextField();
		textField_5.setBounds(561, 148, 86, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		txtEnterDoctorId = new JTextField();
		txtEnterDoctorId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//txtEnterDoctorId.setText();
		txtEnterDoctorId.setBounds(389, 336, 110, 25);
		DocId= new JLabel("Enter Doctor Id");
		DocId.setForeground(Color.LIGHT_GRAY);
		txtEnterDoctorId.setLayout(new FlowLayout());
	     txtEnterDoctorId.add(DocId);
		panel_2.add(txtEnterDoctorId);
	   txtEnterDoctorId.addKeyListener(new KeyAdapter() {
	
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyChar() != KeyEvent.VK_BACK_SPACE)

			{
				DocId.setVisible(false);
			}
			else
				if(txtEnterDoctorId.getText().equals(" "))
				{
					DocId.setVisible(true);
				}
		}
		
		
	});
		
		txtEnterDoctorId.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSend.setBounds(526, 335, 89, 23);
		panel_2.add(btnSend);
		
		JLabel lblPatientRecords = new JLabel("Patient Reports");
		lblPatientRecords.setForeground(Color.BLUE);
		lblPatientRecords.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatientRecords.setBounds(267, 11, 119, 28);
		panel_2.add(lblPatientRecords);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("J:\\Hospital Management Swing\\1.jpg"));
		lblNewLabel.setBounds(0, 0, 708, 413);
		panel_2.add(lblNewLabel);
	}
}

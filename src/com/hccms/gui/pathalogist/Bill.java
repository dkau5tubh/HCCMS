package com.hccms.gui.pathalogist;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class Bill extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

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
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Bill.class.getResource("/com/hms/images/Shutdown_48px.png")));
		lblNewLabel_2.setBounds(786, 35, 46, 48);
		panel.add(lblNewLabel_2);
		
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
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogOut.setBounds(769, 107, 89, 23);
		panel.add(btnLogOut);
		
		JLabel label = new JLabel("New label");
		label.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Survey_96px.png"));
		label.setBounds(10, 46, 96, 91);
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("Welcome,");
		lblNewLabel.setFont(new Font("Lao UI", Font.BOLD, 13));
		lblNewLabel.setBounds(227, 49, 78, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Dr.Patho");
		lblNewLabel_5.setForeground(SystemColor.textHighlightText);
		lblNewLabel_5.setFont(new Font("Candara", Font.BOLD, 17));
		lblNewLabel_5.setBounds(226, 80, 154, 23);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setText(Pathology.username);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnAppointments = new JButton("Appointments");
		btnAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				Appointments frame=new Appointments();
				frame.setVisible(true);
			}
		});
		btnAppointments.setForeground(SystemColor.textHighlightText);
		btnAppointments.setBackground(Color.RED);
		btnAppointments.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAppointments.setBounds(30, 87, 125, 46);
		panel_1.add(btnAppointments);
		
		JButton btnPatientsRecord = new JButton("Patient's Record");
		btnPatientsRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				PaitentRecord frame=new PaitentRecord();
				frame.setVisible(true);
			}
		});
		btnPatientsRecord.setForeground(SystemColor.textHighlightText);
		btnPatientsRecord.setBackground(Color.RED);
		btnPatientsRecord.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnPatientsRecord.setBounds(28, 168, 127, 46);
		panel_1.add(btnPatientsRecord);
		
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
		btnBill.setBounds(30, 245, 125, 46);
		panel_1.add(btnBill);
		
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
		btnReport.setBounds(30, 324, 125, 46);
		panel_1.add(btnReport);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 718, 413);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblMoneyRecipit = new JLabel("Money Receipt");
		lblMoneyRecipit.setBounds(317, 25, 122, 33);
		lblMoneyRecipit.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_2.add(lblMoneyRecipit);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(473, 51, 68, 22);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblDate);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(48, 133, 57, 14);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 131, 122, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(278, 133, 46, 14);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblId);
		
		textField_2 = new JTextField();
		textField_2.setBounds(352, 131, 119, 20);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(510, 132, 46, 17);
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblAge);
		
		textField_3 = new JTextField();
		textField_3.setBounds(554, 131, 86, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblDrName = new JLabel("Dr Name:");
		lblDrName.setBounds(278, 181, 64, 14);
		lblDrName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblDrName);
		
		textField_4 = new JTextField();
		textField_4.setBounds(352, 179, 122, 20);
		panel_2.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblTests = new JLabel("Tests:");
		lblTests.setBounds(350, 225, 46, 14);
		lblTests.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(lblTests);
		
		table = new JTable();
		table.setBounds(355, 325, 1, 1);
		panel_2.add(table);
		
		table_1 = new JTable();
		table_1.setBounds(163, 250, 423, 64);
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setFillsViewportHeight(true);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Cost", "Date", "Test Name"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table_1.getColumnModel().getColumn(0).setPreferredWidth(79);
		table_1.getColumnModel().getColumn(0).setMinWidth(17);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(79);
		table_1.getColumnModel().getColumn(1).setMinWidth(17);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(78);
		table_1.getColumnModel().getColumn(2).setMinWidth(17);
		panel_2.add(table_1);
		
		JLabel lblTotalCharges = new JLabel("Total Charges:");
		lblTotalCharges.setBounds(355, 337, 103, 22);
		lblTotalCharges.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblTotalCharges);
		
		textField_5 = new JTextField();
		textField_5.setBounds(454, 339, 101, 20);
		panel_2.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblToAccountSection = new JLabel("To Account Section");
		lblToAccountSection.setBounds(317, 388, 137, 14);
		lblToAccountSection.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblToAccountSection);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(454, 385, 89, 23);
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_2.add(btnSend);
		
		JLabel lblNewLabel_1 = new JLabel("Doctor Id:");
		lblNewLabel_1.setBounds(37, 191, 68, 14);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		panel_2.add(lblNewLabel_1);
		
		textField_6 = new JTextField();
		textField_6.setBounds(102, 189, 122, 20);
		panel_2.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Bill.class.getResource("/com/hms/images/Paper Money_48px.png")));
		lblNewLabel_3.setBounds(247, 11, 57, 47);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblReportId = new JLabel("Report Id:");
		lblReportId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReportId.setBounds(503, 182, 68, 14);
		panel_2.add(lblReportId);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(568, 179, 86, 20);
		panel_2.add(textField_7);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(528, 53, 91, 20);
		panel_2.add(dateChooser);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("J:\\Hospital Management Swing\\1.jpg"));
		lblNewLabel_4.setBounds(0, 0, 708, 429);
		panel_2.add(lblNewLabel_4);
	}
}


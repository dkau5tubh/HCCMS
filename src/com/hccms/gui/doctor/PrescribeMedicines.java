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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.hccms.beans.Prescription;
import com.hccms.db.DBManager;
import com.hccms.gui.commonlogin.Login;

import javax.swing.JComboBox;
import javax.print.DocFlavor.STRING;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class PrescribeMedicines extends JFrame {

	private JPanel contentPane;
	private JTextField textField_medicinename;
	private JTextField textField_quantity;
	private JComboBox comboBox_dosage;
	private JTextField textField_appid;
	private JTextField textField_patid;
	private JTextField textField_remark;
	private JTextField textField_fname;
	private JTextField textField_mname;
	private JTextField textField_lname;
	private JTextField textField_date;
	private static String patientid;
	private static String appointmenid;
	private JTable table_medcine;
	private DefaultTableModel model;
	private static int index=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		patientid=args[0];
		appointmenid=args[1];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrescribeMedicines frame = new PrescribeMedicines();
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
	public PrescribeMedicines() {
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
		lblNewLabel.setBounds(174, 26, 89, 23);
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
		lblNewLabel_1.setBounds(174, 60, 144, 28);
		panel.add(lblNewLabel_1);
		String username="Dr. "+Doctor.username;
		lblNewLabel_1.setText(username);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Doctor homeScreen= new Doctor();
				homeScreen.setVisible(true);
				homeScreen.setLocationRelativeTo(null);
			}
		});
		button_1.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-left-64.png"));
		button_1.setBackground(SystemColor.textHighlight);
		button_1.setBounds(770, 43, 89, 84);
		panel.add(button_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prescribe Medicines");
		lblNewLabel_2.setBounds(465, 56, 201, 28);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(401, 45, 46, 59);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\UI images\\Pill_48px.png"));
		
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
		
		JLabel lblMedicineName = new JLabel("<html>Medicine<br/>Name</html>");
		lblMedicineName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMedicineName.setBounds(28, 95, 67, 34);
		panel_2.add(lblMedicineName);
		
		textField_medicinename = new JTextField();
		textField_medicinename.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_medicinename.setBounds(128, 90, 108, 28);
		panel_2.add(textField_medicinename);
		textField_medicinename.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setBounds(258, 92, 82, 21);
		panel_2.add(lblQuantity);
		
		textField_quantity = new JTextField();
		textField_quantity.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_quantity.setColumns(10);
		textField_quantity.setBounds(350, 90, 108, 28);
		panel_2.add(textField_quantity);
		
		JLabel lblDosage = new JLabel("Dosage");
		lblDosage.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDosage.setBounds(28, 140, 90, 21);
		panel_2.add(lblDosage);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRemark.setBounds(481, 14, 90, 21);
		panel_2.add(lblRemark);
		
		JButton btnNewButton_2 = new JButton("ADD");
		//TableStructure();
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data[]=new String[4];
				data[0]=String.valueOf(index++);
				data[1]=textField_medicinename.getText();
				data[2]=textField_quantity.getText();
				data[3]=(String) comboBox_dosage.getSelectedItem();
				model.addRow(data);
				textField_medicinename.setText("");
				textField_quantity.setText("");
				textField_remark.setText("");
				comboBox_dosage.setSelectedIndex(0);
				
			}
			
		});
		btnNewButton_2.setBackground(new Color(138, 43, 226));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(175, 186, 122, 34);
		panel_2.add(btnNewButton_2);
		System.out.println();
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel dbtable=(DefaultTableModel) table_medcine.getModel();
				int rows=dbtable.getRowCount();
				try
				{
					Connection con=DBManager.getDBConnectivity();
					con.setAutoCommit(false);
					String sql="insert into MEDICINES(pid,apid,medicinename,quantity,dosage,remarks)values(?,?,?,?,?,?)";
					PreparedStatement pst=con.prepareStatement(sql);
					for(int row=0;row<rows;row++)
					{
						String pid=textField_patid.getText();
						String apid=textField_appid.getText();
						String medname=(String) table_medcine.getValueAt(row, 1);
						String quant=(String) table_medcine.getValueAt(row, 2);
						String dosage=(String) table_medcine.getValueAt(row, 3);
						String remark=textField_remark.getText();
						pst.setString(1, pid);
						pst.setString(2, apid);
						pst.setString(3, medname);
						pst.setString(4, quant);
						pst.setString(5, dosage);
						pst.setString(6, remark);
						pst.addBatch();
						
					}
					pst.executeBatch();
					con.commit();
					model.setRowCount(0);
					JOptionPane.showMessageDialog(null, "Medicine Request Has Been sent to Has Been Sent to the Store");
					
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
			}
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(138, 43, 226));
		btnSubmit.setBounds(422, 186, 122, 34);
		panel_2.add(btnSubmit);
		
		comboBox_dosage = new JComboBox();
		comboBox_dosage.setFont(new Font("Tahoma", Font.BOLD, 10));
		comboBox_dosage.setModel(new DefaultComboBoxModel(new String[] {"Morning Before Breakfast Once", "Morning After Breakfast Once", "Afternoon Before Lunch Once", "Afternoon After Lunch Once", "Night Before Dinner Once", "Night After Dinner Once", "Morning  Afternoon Before  Meal Twice", "Morning  Afternoon After Meal Twice", "Morning Evening Twice Before  Meal", "Morning Evening Twice After Meal", "Afternoon Evening After Meal Twice", "Afternoon Evening Twice After Meal", "Morning Afternoon Night Thrice After Meal", "Morning Afternoon Night Thrice Before Meal"}));
		comboBox_dosage.setBounds(128, 133, 200, 28);
		panel_2.add(comboBox_dosage);
		
		JLabel lblAppointId = new JLabel("Appoint Id");
		lblAppointId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAppointId.setBounds(28, 11, 90, 27);
		panel_2.add(lblAppointId);
		
		textField_appid = new JTextField();
		textField_appid.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_appid.setColumns(10);
		textField_appid.setBounds(128, 12, 108, 28);
		panel_2.add(textField_appid);
		
		JLabel lblPatiendId = new JLabel("Patient Id");
		lblPatiendId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPatiendId.setBounds(258, 11, 82, 27);
		panel_2.add(lblPatiendId);
		
		textField_patid = new JTextField();
		textField_patid.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_patid.setColumns(10);
		textField_patid.setBounds(350, 12, 108, 28);
		panel_2.add(textField_patid);
		
		textField_remark = new JTextField();
		textField_remark.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_remark.setColumns(10);
		textField_remark.setBounds(565, 7, 108, 28);
		panel_2.add(textField_remark);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(28, 49, 90, 27);
		panel_2.add(lblFirstName);
		
		textField_fname = new JTextField();
		textField_fname.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_fname.setColumns(10);
		textField_fname.setBounds(128, 51, 108, 28);
		panel_2.add(textField_fname);
		
		JLabel lblMiddleName = new JLabel("Mid Name");
		lblMiddleName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMiddleName.setBounds(258, 54, 90, 27);
		panel_2.add(lblMiddleName);
		
		textField_mname = new JTextField();
		textField_mname.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_mname.setColumns(10);
		textField_mname.setBounds(350, 51, 108, 28);
		panel_2.add(textField_mname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(481, 52, 90, 27);
		panel_2.add(lblLastName);
		
		textField_lname = new JTextField();
		textField_lname.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_lname.setColumns(10);
		textField_lname.setBounds(565, 54, 108, 28);
		panel_2.add(textField_lname);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDate.setBounds(481, 97, 90, 27);
		panel_2.add(lblDate);
		
		Calendar cal = Calendar.getInstance();
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-YYYY");
		textField_date = new JTextField();
		textField_date.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_date.setColumns(10);
		textField_date.setBounds(565, 101, 108, 28);
		textField_date.setText(dateFormat.format(cal.getTime()));
		panel_2.add(textField_date);
		
		
		/*------------------code for Medicines Prescribe----------------*/
		
		textField_appid.setText(appointmenid);
		textField_patid.setText(patientid);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 260, 658, 113);
		panel_2.add(scrollPane);
		
		table_medcine = new JTable();
		String column[]= {"Sr.No","name","Quantity","Dosage"};
		model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table_medcine.setModel(model);
		
		scrollPane.setViewportView(table_medcine);
		try
		{
			Connection con=DBManager.getDBConnectivity();
			Statement stmt=con.createStatement();
			String sql="select * from PNAME where PID='"+patientid+"' ";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				textField_fname.setText(rs.getString("FIRSTNAME"));
				textField_mname.setText(rs.getString("MIDDLENAME"));
				textField_lname.setText(rs.getString("LASTNAME"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public void TableStructure()
	{
		Object column[]= {"Sr.No","Medicine Name","Quantity","Dosage"};
		model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table_medcine.setModel(model);
	}
}

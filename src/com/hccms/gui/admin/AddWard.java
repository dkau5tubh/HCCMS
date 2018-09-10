package com.hccms.gui.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.hccms.beans.Ward;

public class AddWard extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton add;
	protected Object String;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddWard frame = new AddWard();
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
	public AddWard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(10, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//panel_1 Coding
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0, 0, 894, 159);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminicon = new JLabel("");
		lblAdminicon.setIcon(new ImageIcon("C:\\Users\\project_15\\Downloads\\hospital\\Businessman_96px.png"));
		lblAdminicon.setBounds(38, 0, 155, 159);
		panel.add(lblAdminicon);
		JLabel lblWelcom = new JLabel("Welcome");
		lblWelcom.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWelcom.setBounds(217, 55, 84, 22);
		panel.add(lblWelcom);
		
		JLabel lblNewLabel = new JLabel("Admin Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(217, 88, 116, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("J:\\Hospital Management Swing\\Wire_IMG\\Shutdown_48px.png"));
		lblNewLabel_1.setBounds(802, 30, 46, 47);
		panel.add(lblNewLabel_1);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setForeground(new Color(255, 0, 0));
		btnLogout.setBackground(new Color(169, 169, 169));
		btnLogout.setBounds(784, 88, 89, 29);
		panel.add(btnLogout);
		//-------------------------------------------------------
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		///button
		JButton btnNewButton = new JButton("Paitent Info");
		btnNewButton.setBackground(new Color(255, 69, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(23, 11, 124, 30);
		panel_1.add(btnNewButton);

		JButton btnRoomInfo = new JButton("Room Info");
		btnRoomInfo.setForeground(Color.WHITE);
		btnRoomInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRoomInfo.setBackground(new Color(255, 69, 0));
		btnRoomInfo.setBounds(23, 61, 124, 30);
		panel_1.add(btnRoomInfo);

		JButton btnStaffInfo = new JButton("Staff  Info");
		btnStaffInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStaffInfo.setForeground(Color.WHITE);
		btnStaffInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffInfo.setBackground(new Color(255, 69, 0));
		btnStaffInfo.setBounds(23, 113, 124, 30);
		panel_1.add(btnStaffInfo);

		JButton btnUserInfo = new JButton("User  Info");
		btnUserInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUserInfo.setForeground(Color.WHITE);
		btnUserInfo.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUserInfo.setBackground(new Color(255, 69, 0));
		btnUserInfo.setBounds(23, 165, 124, 30);
		panel_1.add(btnUserInfo);

		JButton btnAddWard = new JButton("Add Ward");
		btnAddWard.setForeground(Color.WHITE);
		btnAddWard.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddWard.setBackground(new Color(255, 69, 0));
		btnAddWard.setBounds(23, 216, 124, 30);
		panel_1.add(btnAddWard);

		JButton btnStaffUser = new JButton("Staff  User");
		btnStaffUser.setForeground(Color.WHITE);
		btnStaffUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnStaffUser.setBackground(new Color(255, 69, 0));
		btnStaffUser.setBounds(23, 268, 124, 30);
		panel_1.add(btnStaffUser);
		
		
		JButton btnAddUser = new JButton("Add  User");
		btnAddUser.setForeground(Color.WHITE);
		btnAddUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddUser.setBackground(new Color(255, 69, 0));
		btnAddUser.setBounds(23, 316, 124, 30);
		panel_1.add(btnAddUser);
		
		JButton btnViewAppointment = new JButton("View Appointment");
		btnViewAppointment.setForeground(Color.WHITE);
		btnViewAppointment.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnViewAppointment.setBackground(new Color(255, 69, 0));
		btnViewAppointment.setBounds(23, 364, 124, 30);
		panel_1.add(btnViewAppointment);
		//----------------------
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(187, 159, 697, 413);
		JLabel lblAddWard = new JLabel("Add Ward");
		lblAddWard.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddWard.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblAddWard.setBounds(271, 26, 127, 41);
		panel_2.add(lblAddWard);

		JLabel building = new JLabel("Building :");
		building.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		building.setBounds(209, 92, 64, 26);
		panel_2.add(building);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Select Building", "Building A", "Building B", "Building C" }));
		comboBox.setBounds(360, 90, 139, 25);
		panel_2.add(comboBox);

		JLabel lblFloor = new JLabel("Floor :");
		lblFloor.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblFloor.setBounds(209, 129, 46, 14);
		panel_2.add(lblFloor);

		JLabel lblRoomNo = new JLabel("Room No:");
		lblRoomNo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRoomNo.setBounds(209, 166, 64, 14);
		panel_2.add(lblRoomNo);

		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblRoomType.setBounds(209, 199, 86, 20);
		panel_2.add(lblRoomType);

		JLabel lblNoOfBeds = new JLabel("Number Of Beds :");
		lblNoOfBeds.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNoOfBeds.setBounds(209, 235, 109, 20);
		panel_2.add(lblNoOfBeds);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "Select Floor", "Ground Floor", "Frst Floor", "Second Floor" }));
		comboBox_1.setToolTipText("Select Building");
		comboBox_1.setBounds(360, 126, 139, 25);
		panel_2.add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Select Room Type", "General", "SemiPrivate", "Private"}));
		comboBox_2.setToolTipText("Select Building");
		comboBox_2.setBounds(360, 198, 139, 25);
		panel_2.add(comboBox_2);

		JLabel lblUnitPrice = new JLabel("Unit Price :");
		lblUnitPrice.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblUnitPrice.setBounds(209, 274, 86, 20);
		panel_2.add(lblUnitPrice);
		
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(360, 273, 139, 25);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
				JButton btnCancle = new JButton("Cancle");
				btnCancle.setBounds(432, 325, 86, 32);
				panel_2.add(btnCancle);
				
						JButton add;
						add = new JButton("Add");
						add.setBounds(344, 325, 78, 32);
						panel_2.add(add);
						add.setForeground(Color.BLACK);
						
						textField = new JTextField();
						textField.setBounds(360, 162, 139, 25);
						panel_2.add(textField);
						textField.setColumns(10);
						
						textField_1 = new JTextField();
						textField_1.setBounds(360, 234, 139, 25);
						panel_2.add(textField_1);
						textField_1.setColumns(10);
						add.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								Ward ward=new Ward();
								ward.setBuilding((String)comboBox.getSelectedItem());
								ward.setFloor((String)comboBox_1.getSelectedItem());
								int rn=Integer.parseInt(textField.getText());
								ward.setRoomNo(rn);
								ward.setRoomType((String)comboBox_2.getSelectedItem());
								int bn=Integer.parseInt(textField_1.getText());
								ward.setNoOfBeds(bn);
								int p=Integer.parseInt(textField_2.getText());
								ward.setPrice(p);
								
								
								System.out.println(ward);
							}
						});
				btnCancle.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});

		
	}
}

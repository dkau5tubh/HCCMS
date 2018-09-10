package com.hccms.gui.adminNew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.hccms.beans.Ward;
import com.hccms.db.DBManager;

public class AddWard extends JFrame {

	private JPanel contentPane;
	JTextField textField, textField_1, textField_2, textField_3;

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
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 200, 947, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 947, 511);
		panel.setBackground(SystemColor.textHighlightText);
		JLabel lblAddWard = new JLabel("Add Ward");
		lblAddWard.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddWard.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblAddWard.setBounds(376, 73, 185, 41);
		panel.add(lblAddWard);

		JLabel lblNewLabel1 = new JLabel("Building :");
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel1.setBounds(333, 139, 64, 26);
		panel.add(lblNewLabel1);

		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "Select Building", "Building A", "Building B", "Building C" }));
		comboBox.setBounds(484, 137, 139, 25);
		panel.add(comboBox);

		JLabel lblFloor = new JLabel("Floor :");
		lblFloor.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblFloor.setBounds(333, 176, 46, 14);
		panel.add(lblFloor);

		JLabel lblRoomNo = new JLabel("Room No:");
		lblRoomNo.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomNo.setBounds(333, 213, 64, 14);
		panel.add(lblRoomNo);

		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblRoomType.setBounds(333, 246, 86, 20);
		panel.add(lblRoomType);

		JLabel lblNoOfBeds = new JLabel("Number Of Beds :");
		lblNoOfBeds.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNoOfBeds.setBounds(333, 282, 109, 20);
		panel.add(lblNoOfBeds);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(
				new String[] { "Select Floor", "Ground Floor", "First Floor", "Second Floor" }));
		comboBox_1.setToolTipText("Select Building");
		comboBox_1.setBounds(484, 173, 139, 25);
		panel.add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(
				new DefaultComboBoxModel(new String[] { "Select Room Type", "General", "Semi Private ", "Private" }));
		comboBox_2.setToolTipText("Select Building");
		comboBox_2.setBounds(484, 245, 139, 25);
		panel.add(comboBox_2);

		JLabel lblUnitPrice = new JLabel("Unit Price :");
		lblUnitPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblUnitPrice.setBounds(333, 321, 86, 20);
		panel.add(lblUnitPrice);

		contentPane.add(panel);
		panel.setLayout(null);

		textField_2 = new JTextField();
		textField_2.setBounds(484, 320, 139, 25);
		panel.add(textField_2);
		textField_2.setColumns(10);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(538, 369, 86, 32);
		panel.add(btnClear);

		JButton add;
		add = new JButton("Add");
		add.setBounds(450, 369, 78, 32);
		panel.add(add);
		add.setForeground(Color.BLACK);

		textField = new JTextField();
		textField.setBounds(484, 209, 139, 25);
		panel.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(484, 281, 139, 25);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton closeButton = new JButton("");
		// Code for remove border
				closeButton.setOpaque(false);
				closeButton.setContentAreaFilled(false);
				closeButton.setBorderPainted(false);
				// ---------- End----------
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-close-window-48.png"));
		closeButton.setBackground(Color.WHITE);
		closeButton.setBounds(821, 25, 89, 51);
		panel.add(closeButton);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Ward ward = new Ward();
				ward.setBuilding((String) comboBox.getSelectedItem());
				ward.setFloor((String) comboBox_1.getSelectedItem());
				int rn = Integer.parseInt(textField.getText());
				ward.setRoomNo(rn);
				System.out.println(rn);
				ward.setRoomType((String) comboBox_2.getSelectedItem());
				int bn = Integer.parseInt(textField_1.getText());
				ward.setNoOfBeds(bn);

				Double double1 = Double.parseDouble(textField_2.getText());
				ward.setPrice(double1);

				System.out.println(ward.getBuilding() + "\n" + ward.getFloor() + "\n" + ward.getRoomNo() + "\n"
						+ ward.getRoomType() + "\n" + ward.getNoOfBeds() + "\n" + ward.getPrice());

				System.out.println(ward);

				try {
					Connection connection = DBManager.getDBConnectivity();
					Statement statement = connection.createStatement();
					// connection.setAutoCommit(false);

					// -----Inset into Appointment Table------
					String insetIntoWard = "insert into ward values('" + ward.getBuilding() + "','" + ward.getFloor()
							+ "','" + ward.getRoomNo() + "','" + ward.getRoomType() + "','" + ward.getNoOfBeds() + "','"
							+ ward.getPrice() + "')";
					statement.executeUpdate(insetIntoWard);
					System.out.println("data insertedsuccessfully");

				} catch (Exception e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
			}
		});
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_1.setText("");
				textField.setText("");
				textField_2.setText("");

			}

		});

	}

}

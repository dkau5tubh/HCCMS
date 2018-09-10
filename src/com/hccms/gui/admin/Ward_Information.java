package com.hccms.gui.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Ward_Information extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ward_Information frame = new Ward_Information();
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
	public Ward_Information() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setResizable(false);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBounds(0,0,894	,159);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menuText);
		panel_1.setBounds(0, 159, 188, 413);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//----------
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
	
		//----
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.text);
		panel_2.setBounds(187, 159, 696, 403);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSelectWing = new JLabel("Select Building:");
		lblSelectWing.setBounds(250, 206, 96, 20);
		lblSelectWing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblSelectWing);
		
		textField = new JTextField();
		textField.setBounds(678, 249, 157, 26);
		textField.setColumns(10);
		panel_2.add(textField);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(250, 237, 111, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Building Wing", "A Wing", "B Wing", "C Wing"}));
		panel_2.add(comboBox);
		
		JRadioButton rdbtnGenrel = new JRadioButton("General");
	
		rdbtnGenrel.setBackground(SystemColor.text);
		rdbtnGenrel.setBounds(6, 39, 81, 23);
		//panel_2.add(rdbtnGenrel);
		
		JRadioButton rdbtnSemiprivate = new JRadioButton("SemiPrivate");
		rdbtnSemiprivate.setBackground(Color.WHITE);
		rdbtnSemiprivate.setBounds(6, 84, 92, 23);
		//panel_2.add(rdbtnSemiprivate);
		
		JRadioButton rdbtnPrivate = new JRadioButton("Private");
		rdbtnPrivate.setBackground(Color.WHITE);
		rdbtnPrivate.setBounds(6, 126, 81, 23);
		//panel_2.add(rdbtnPrivate);
		ButtonGroup wardbg = new ButtonGroup();
		wardbg.add(rdbtnGenrel);
		wardbg.add(rdbtnSemiprivate);
		wardbg.add(rdbtnPrivate);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(251, 286, 118, 179);
		panel_3.setBackground(SystemColor.text);
		panel_3.setLayout(null);
		panel_3.add(rdbtnGenrel);
		panel_3.add(rdbtnSemiprivate);
		panel_3.add(rdbtnPrivate);
		panel_3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel_3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Room Type"));
		panel_2.add(panel_3);
		
		JLabel label = new JLabel("Select Building:");
		label.setBounds(406, 206, 96, 20);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(label);
		
		JList list = new JList();
		list.setBounds(398, 237, 104, 225);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.add(list);
		
		JLabel label_1 = new JLabel("Select Building:");
		label_1.setBounds(541, 250, 96, 20);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(label_1);
		
		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setBounds(541, 287, 96, 20);
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblRoomNo);
		
		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setBounds(541, 324, 96, 20);
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblRoomType);
		
		JLabel lblNoOfBeds = new JLabel("No of Beds :");
		lblNoOfBeds.setBounds(541, 363, 96, 20);
		lblNoOfBeds.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNoOfBeds);
		
		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(541, 399, 96, 20);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblPrice);
		
		JLabel label_2 = new JLabel("Price :");
		label_2.setBounds(541, 436, 96, 20);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(678, 286, 157, 26);
		textField_1.setColumns(10);
		panel_2.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(678, 323, 157, 26);
		textField_2.setColumns(10);
		panel_2.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(678, 362, 157, 26);
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(678, 398, 157, 26);
		textField_4.setColumns(10);
		panel_2.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(678, 435, 157, 26);
		textField_5.setColumns(10);
		panel_2.add(textField_5);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(332, 495, 89, 35);
		panel_2.add(btnNew);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(431, 495, 89, 35);
		panel_2.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(530, 495, 89, 35);
		panel_2.add(btnDelete);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(629, 495, 89, 35);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panel_2.add(btnClose);
	   
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

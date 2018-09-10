package com.hccms.gui.adminNew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.hccms.beans.Ward;
import com.hccms.db.DBManager;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JScrollBar;

public class WardInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textField, textField_1, textField_2, textField_3, textField_4;
	private static JComboBox comboBox;
	private static JRadioButton rdbtnGenrel;
	private static JRadioButton rdbtnSemiprivate;
	private static JRadioButton rdbtnPrivate;
	private ButtonGroup group;
	private JList list;
	static DefaultListModel<Integer> listModel = new DefaultListModel<>();
	private JTextField textField_5;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WardInformation frame = new WardInformation();
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
	public WardInformation() {
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 200, 947, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 931, 511);
		panel_2.setBackground(SystemColor.text);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblSelectWing = new JLabel("Select Building:");
		lblSelectWing.setBounds(180, 109, 96, 20);
		lblSelectWing.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblSelectWing);

		textField = new JTextField();
		textField.setBounds(608, 152, 157, 26);
		textField.setColumns(10);
		panel_2.add(textField);

		comboBox = new JComboBox();
		comboBox.setBounds(180, 140, 111, 25);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Building A", "Building B", "Building C" }));
		panel_2.add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(328, 140, 104, 225);
		panel_2.add(scrollPane);

		list = new JList(listModel);
		scrollPane.setViewportView(list);

		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				// TODO Auto-generated method stub
				list = (JList) me.getSource();
				if (me.getClickCount() == 2) {
					int rno = (int) list.getSelectedValue();
					System.out.println(rno);
					// System.out.println(fullname);

					// Double-click detected
					int index = list.locationToIndex(me.getPoint());

					getvalue(rno);// >>> provide data to getvalue() and call them

				}

			}

		});
		list.setBackground(new Color(255, 255, 255));
		list.setBorder(new LineBorder(new Color(0, 0, 0)));

		rdbtnGenrel = new JRadioButton("General");
		rdbtnGenrel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				try {
					listModel.removeAllElements();
					Connection connection = DBManager.getDBConnectivity();
				PreparedStatement statement = connection.prepareStatement("select roomno from ward where building=? and ROOMTYPE=?");
					String combo=(String) comboBox.getSelectedItem();
					String rtype=getRoomType();
					//String select = " select BUILDING,ROOMTYPE from WARD";
					// String sql= "select roomno from ward ";
					statement.setString(1, combo);
					statement.setString(2, rtype);
					
					ResultSet resultSet = statement.executeQuery();
				
					Ward ward = new Ward();
					while (resultSet.next()) {
						int rno= resultSet.getInt("roomno");
					
						listModel.addElement(rno);
						
						
					}
					/*String bild = ward.getBuilding();
					String rtype = ward.getRoomType();
					System.out.println(bild);
					System.out.println(rtype);
					getMatched(bild, rtype);
					connection.close();*/
				} 
				
				catch (Exception e) {
					e.printStackTrace();
				
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}
		});

		rdbtnGenrel.setActionCommand("General");

		rdbtnGenrel.setBackground(new Color(176, 224, 230));
		rdbtnGenrel.setBounds(17, 39, 81, 23);

		// panel_2.add(rdbtnGenrel);

		rdbtnSemiprivate = new JRadioButton("Semi Private");
		rdbtnSemiprivate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					listModel.removeAllElements();
					Connection connection = DBManager.getDBConnectivity();
				PreparedStatement statement = connection.prepareStatement("select roomno from ward where building=? and ROOMTYPE=?");
					String combo=(String) comboBox.getSelectedItem();
					String rtype=getRoomType();
					//String select = " select BUILDING,ROOMTYPE from WARD";
					// String sql= "select roomno from ward ";
					statement.setString(1, combo);
					statement.setString(2, rtype);
					
					ResultSet resultSet = statement.executeQuery();
				
					Ward ward = new Ward();
					while (resultSet.next()) {
						int rno= resultSet.getInt("roomno");
					
						listModel.addElement(rno);
						
						
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				
				}
			}
		});
		
		rdbtnSemiprivate.setBackground(new Color(176, 224, 230));
		rdbtnSemiprivate.setBounds(17, 84, 109, 23);
		rdbtnSemiprivate.setActionCommand("Semi Private");
		// panel_2.add(rdbtnSemiprivate);

		rdbtnPrivate = new JRadioButton("Private");
		rdbtnPrivate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					listModel.removeAllElements();
					Connection connection = DBManager.getDBConnectivity();
				PreparedStatement statement = connection.prepareStatement("select roomno from ward where building=? and ROOMTYPE=?");
					String combo=(String) comboBox.getSelectedItem();
					String rtype=getRoomType();
					//String select = " select BUILDING,ROOMTYPE from WARD";
					// String sql= "select roomno from ward ";
					statement.setString(1, combo);
					statement.setString(2, rtype);
					
					ResultSet resultSet = statement.executeQuery();
				
					Ward ward = new Ward();
					while (resultSet.next()) {
						int rno= resultSet.getInt("roomno");
					
						listModel.addElement(rno);
						
						
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				
				}

			}
		});
		rdbtnPrivate.setBackground(new Color(176, 224, 230));
		rdbtnPrivate.setBounds(17, 126, 81, 23);
		rdbtnPrivate.setActionCommand("Private");
		// panel_2.add(rdbtnPrivate);
		group = new ButtonGroup();
		group.add(rdbtnGenrel);
		group.add(rdbtnSemiprivate);
		group.add(rdbtnPrivate);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(163, 189, 136, 179);
		panel_3.setBackground(SystemColor.text);
		panel_3.setLayout(null);
		panel_3.add(rdbtnGenrel);
		panel_3.add(rdbtnSemiprivate);
		panel_3.add(rdbtnPrivate);
		panel_3.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		panel_3.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Room Type"));
		panel_2.add(panel_3);

		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\1.jpg"));
		label_3.setBounds(10, 21, 116, 147);
		panel_3.add(label_3);

		JLabel lblRoomNumber = new JLabel("Room number :");
		lblRoomNumber.setBounds(328, 109, 104, 20);
		lblRoomNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblRoomNumber);

		

		JLabel label_1 = new JLabel("Select Building:");
		label_1.setBounds(471, 153, 96, 20);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(label_1);

		JLabel lblRoomNo = new JLabel("Room No :");
		lblRoomNo.setBounds(471, 231, 96, 20);
		lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblRoomNo);

		JLabel lblRoomType = new JLabel("Room Type :");
		lblRoomType.setBounds(471, 268, 96, 20);
		lblRoomType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblRoomType);

		JLabel lblNoOfBeds = new JLabel("No of Beds :");
		lblNoOfBeds.setBounds(471, 307, 96, 20);
		lblNoOfBeds.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblNoOfBeds);

		JLabel lblPrice = new JLabel("Price :");
		lblPrice.setBounds(471, 343, 96, 20);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblPrice);

		textField_1 = new JTextField();
		textField_1.setBounds(608, 230, 157, 26);
		textField_1.setColumns(10);
		panel_2.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setBounds(608, 267, 157, 26);
		textField_2.setColumns(10);
		panel_2.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(608, 306, 157, 26);
		textField_3.setColumns(10);
		panel_2.add(textField_3);

		textField_4 = new JTextField();
		textField_4.setBounds(608, 342, 157, 26);
		textField_4.setColumns(10);
		panel_2.add(textField_4);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					Connection connection=DBManager.getDBConnectivity();
					String sql="update ward set BUILDING=?,FLOOR=?,ROOMNO=?,ROOMTYPE=?,NOOFBEDS=?,PRICE=? ";
					
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		});
		btnUpdate.setBounds(414, 388, 89, 35);
		panel_2.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(513, 388, 89, 35);
		panel_2.add(btnDelete);

		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(612, 388, 89, 35);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				textField_5.setText("");
				listModel.removeAllElements();
			}
		});
		panel_2.add(btnClear);

		JLabel lblWardInformation = new JLabel("Ward Information");
		lblWardInformation.setBounds(330, 28, 254, 54);
		lblWardInformation.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblWardInformation.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblWardInformation);

		JButton Closebutton = new JButton("");
		Closebutton.setBounds(828, 28, 75, 54);
		// Code for remove border
		Closebutton.setOpaque(false);
		Closebutton.setContentAreaFilled(false);
		Closebutton.setBorderPainted(false);
		// ---------- End----------
		Closebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			dispose();
			}
		});
		Closebutton.setBackground(Color.WHITE);
		Closebutton.setIcon(new ImageIcon("J:\\Hospital Management Swing\\hospital\\icons8-close-window-48.png"));
		panel_2.add(Closebutton);

		JLabel lblFloor = new JLabel("Floor :");
		lblFloor.setBounds(471, 195, 96, 20);
		lblFloor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_2.add(lblFloor);

		textField_5 = new JTextField();
		textField_5.setBounds(608, 194, 157, 26);
		textField_5.setColumns(10);
		panel_2.add(textField_5);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(415, 140, 17, 224);
		panel_2.add(scrollBar);

	}

	private void getvalue(int rno) {
		// TODO Auto-generated method stub
		System.out.println(rno + "in getvalue");
		try {
			Connection connection = DBManager.getDBConnectivity();
			Statement statement = connection.createStatement();
			System.out.println("Connection in getvalue");
			String select = "select * from ward where roomno=" + rno;
			ResultSet resultSet = statement.executeQuery(select);

			while (resultSet.next()) {
				textField.setText(resultSet.getString("BUILDING"));
				textField_1.setText(resultSet.getString("ROOMNO"));
				textField_2.setText(resultSet.getString("ROOMTYPE"));
				textField_3.setText(resultSet.getString("NOOFBEDS"));
				textField_4.setText(resultSet.getString("PRICE"));
				textField_5.setText(resultSet.getString("FLOOR"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

		}
	}
	
	

	public static String getRoomType() {
		// rdbtnGenrel,rdbtnSemiprivate, rdbtnPrivate;
		if (rdbtnGenrel.isSelected()) {
			return "General";
		} else if (rdbtnSemiprivate.isSelected()) {
			return "Semi Private ";
		} else if (rdbtnPrivate.isSelected()) {
			return "Private";
		} else
			return null;
	}
}

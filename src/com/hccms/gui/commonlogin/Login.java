package com.hccms.gui.commonlogin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.hccms.beans.ActiveUser;
import com.hccms.db.DBManager;
import com.hccms.gui.accountant.AccountantHomeScreen;
import com.hccms.gui.adminNew.AdminHomeScreen;
import com.hccms.gui.doctor.Doctor;
import com.hccms.gui.doctor.UpdateProfile;
import com.hccms.gui.pathalogist.Pathology;
import com.hccms.gui.pharmacist.MainMedicalPage;
import com.hccms.gui.receptionist.ReceptionistHomeScreen;

import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	static String nrole;
	private boolean flag;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,900, 600);
		setExtendedState(JFrame.MAXIMIZED_HORIZ);
		setResizable(false);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setUndecorated(true);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.textHighlightText);
		panel_2.setBounds(-20, -19, 941, 619);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLoginAs = new JLabel("LOGIN AS");
		lblLoginAs.setForeground(SystemColor.textHighlightText);
		lblLoginAs.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		lblLoginAs.setBounds(299, 253, 112, 43);
		panel_2.add(lblLoginAs);
		
		
		//label for setting the Actor
		final JLabel label_role = new JLabel("");
		label_role.setHorizontalAlignment(SwingConstants.CENTER);
		label_role.setForeground(SystemColor.textHighlightText);
		label_role.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		label_role.setBounds(503, 253, 145, 30);
		panel_2.add(label_role);
		
		
		JLabel lblUsername = new JLabel("EMAIL/MOBILE NO");
		lblUsername.setForeground(SystemColor.textHighlightText);
		lblUsername.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		lblUsername.setBounds(299, 307, 140, 43);
		panel_2.add(lblUsername);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 13));
		textField.setToolTipText("Enter Username");
		textField.setBounds(464, 315, 221, 30);
		Border custext=BorderFactory.createEmptyBorder();
		textField.setBorder(custext);
		panel_2.add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setForeground(SystemColor.textHighlightText);
		lblPassword.setFont(new Font("Meiryo UI", Font.BOLD, 14));
		lblPassword.setBounds(299, 361, 112, 43);
		panel_2.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(custext);
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					try
					{
						String uname=textField.getText();
						String upwd=passwordField.getText();
						String role=label_role.getText();
						nrole=role.toLowerCase();
						System.out.println(nrole);
						Connection con=DBManager.getDBConnectivity();
						Statement stmt=con.createStatement();
						String sql="select email,password,role,id,mobno from users";
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next())
						{
							
							
						/*	Rajas@hccms.com HCCMS@123 doctor
							abhilasha@hccms.com HCCMS@123 receptionist
							rajasingle@hccms.com HCCMS@123 doctor
							varungadre@hccms.com HCCMS@123 pharmacist
							akshay@hccms.com HCCMS@123 pathologist
							admin@hccms.com adminhccms admin */

							
								if(nrole.equals("admin")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
								String username=rs.getString("id");
								
								Statement stm=con.createStatement();
								String idz=rs.getString("id");
								String emails=rs.getString("email");
								String mobnum=rs.getString("mobno");
								String passwordz=rs.getString("password");
								String rolee=rs.getString("role");
								try
								{
								String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
								boolean flag=stm.execute(sql2);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
							
								JOptionPane.showMessageDialog(null, "Your are logged in As Admin!! "+"\n"+"Your id is: "+username);
								flag=true;
								dispose();
								String info[]=new String[1];
								info[0]=username;
								AdminHomeScreen frame = new AdminHomeScreen();
								frame.main(info);
								frame.setVisible(false);
								frame.setLocationRelativeTo(null);
								}
								else if(nrole.equals("doctor")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									
										String username=rs.getString("id");
									
										Statement stm=con.createStatement();
										String idz=rs.getString("id");
										String emails=rs.getString("email");
										String mobnum=rs.getString("mobno");
										String passwordz=rs.getString("password");
										String rolee=rs.getString("role");
										try
										{
										String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
										boolean flag=stm.execute(sql2);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
							
									JOptionPane.showMessageDialog(null, "Your are logged in As Doctor!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String []info=new String[1];
									info[0]=username;
									Doctor frame = new Doctor();
									frame.main(info);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);	
									
								
										
								}
								else if(nrole.equals("pharmacist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									String username=rs.getString("id");
									//code for inserting the list of the active users
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Your are logged in As Pharmacist!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String []info=new String[1];
									info[0]=username;
									MainMedicalPage frame = new MainMedicalPage();
									frame.main(info);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);
									
								}
								else if(nrole.equals("pathologist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									String username=rs.getString("id");
									
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									
									JOptionPane.showMessageDialog(null, "Your are logged in As Pathologist!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String data[]=new String[1];
									data[0]=username;
									Pathology frame = new Pathology();
									frame.main(data);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);
								}
								else if(nrole.equals("receptionist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									String username=rs.getString("id");
									
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									
									JOptionPane.showMessageDialog(null, "Your are logged in As Receptionist!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String data[]=new String[1];
									data[0]=username;
									ReceptionistHomeScreen frame = new ReceptionistHomeScreen();
									frame.main(data);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);
									
								}
								else if(nrole.equals("accountant")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									
										String username=rs.getString("id");
									
										Statement stm=con.createStatement();
										String idz=rs.getString("id");
										String emails=rs.getString("email");
										String mobnum=rs.getString("mobno");
										String passwordz=rs.getString("password");
										String rolee=rs.getString("role");
										try
										{
										String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
										boolean flag=stm.execute(sql2);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
							
									JOptionPane.showMessageDialog(null, "Your are logged in As Accountant!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String []info=new String[1];
									info[0]=username;
									AccountantHomeScreen frame = new AccountantHomeScreen();
									frame.main(info);
									frame.setVisible(false);
									frame.setResizable(false);
									frame.setLocationRelativeTo(null);
										
								}
								
							}
						
						//Check if Username or password or role matches or not
						if(flag==false)
						{
							JOptionPane.showMessageDialog(null, "Role Or Username Or Password"+"\n"+"Invalid");
						}
							con.close();
							
							
						}
						
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				
				
				
			}
		});
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 13));
		passwordField.setToolTipText("Enter password");
		passwordField.setBounds(464, 369, 221, 30);
		panel_2.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode()==KeyEvent.VK_ENTER)
				{
					
					try
					{
						String uname=textField.getText();
						String upwd=passwordField.getText();
						String role=label_role.getText();
						nrole=role.toLowerCase();
						System.out.println(nrole);
						Connection con=DBManager.getDBConnectivity();
						Statement stmt=con.createStatement();
						String sql="select email,password,role,id,mobno from users";
						ResultSet rs=stmt.executeQuery(sql);
						while(rs.next())
						{
							
							
						/*	Rajas@hccms.com HCCMS@123 doctor
							abhilasha@hccms.com HCCMS@123 receptionist
							rajasingle@hccms.com HCCMS@123 doctor
							varungadre@hccms.com HCCMS@123 pharmacist
							akshay@hccms.com HCCMS@123 pathologist
							admin@hccms.com adminhccms admin */

							
								if(nrole.equals("admin")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
								String username=rs.getString("id");
								
								Statement stm=con.createStatement();
								String idz=rs.getString("id");
								String emails=rs.getString("email");
								String mobnum=rs.getString("mobno");
								String passwordz=rs.getString("password");
								String rolee=rs.getString("role");
								try
								{
								String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
								boolean flag=stm.execute(sql2);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
							
								JOptionPane.showMessageDialog(null, "Your are logged in As Admin!! "+"\n"+"Your id is: "+username);
								flag=true;
								dispose();
								String info[]=new String[1];
								info[0]=username;
								AdminHomeScreen frame = new AdminHomeScreen();
								frame.main(info);
								frame.setVisible(false);
								frame.setLocationRelativeTo(null);
								}
								else if(nrole.equals("doctor")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									
										String username=rs.getString("id");
									
										Statement stm=con.createStatement();
										String idz=rs.getString("id");
										String emails=rs.getString("email");
										String mobnum=rs.getString("mobno");
										String passwordz=rs.getString("password");
										String rolee=rs.getString("role");
										try
										{
										String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
										boolean flag=stm.execute(sql2);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
							
									JOptionPane.showMessageDialog(null, "Your are logged in As Doctor!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String []info=new String[1];
									info[0]=username;
									Doctor frame = new Doctor();
									frame.main(info);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);	
									
								
										
								}
								else if(nrole.equals("pharmacist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									String username=rs.getString("id");
									//code for inserting the list of the active users
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									JOptionPane.showMessageDialog(null, "Your are logged in As Pharmacist!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String []info=new String[1];
									info[0]=username;
									MainMedicalPage frame = new MainMedicalPage();
									frame.main(info);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);
									
								}
								else if(nrole.equals("pathologist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									String username=rs.getString("id");
									
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									
									JOptionPane.showMessageDialog(null, "Your are logged in As Pathologist!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String data[]=new String[1];
									data[0]=username;
									Pathology frame = new Pathology();
									frame.main(data);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);
								}
								else if(nrole.equals("receptionist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									String username=rs.getString("id");
									
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
									
									JOptionPane.showMessageDialog(null, "Your are logged in As Receptionist!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String data[]=new String[1];
									data[0]=username;
									ReceptionistHomeScreen frame = new ReceptionistHomeScreen();
									frame.main(data);
									frame.setVisible(false);
									frame.setLocationRelativeTo(null);
									
								}
								else if(nrole.equals("accountant")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
								{
									
										String username=rs.getString("id");
									
										Statement stm=con.createStatement();
										String idz=rs.getString("id");
										String emails=rs.getString("email");
										String mobnum=rs.getString("mobno");
										String passwordz=rs.getString("password");
										String rolee=rs.getString("role");
										try
										{
										String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
										boolean flag=stm.execute(sql2);
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
							
									JOptionPane.showMessageDialog(null, "Your are logged in As Accountant!! "+"\n"+"Your id is: "+username);
									flag=true;
									dispose();
									String []info=new String[1];
									info[0]=username;
									AccountantHomeScreen frame = new AccountantHomeScreen();
									frame.main(info);
									frame.setVisible(false);
									frame.setResizable(false);
									frame.setLocationRelativeTo(null);
										
								}
								
							}
						
						//Check if Username or password or role matches or not
						if(flag==false)
						{
							JOptionPane.showMessageDialog(null, "Role Or Username Or Password"+"\n"+"Invalid");
						}
							con.close();
							
							
						}
						
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
				
				
				
			}
		});
		
		final JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Segoe UI Symbol", Font.BOLD, 12));
		lblNewLabel.setBounds(313, 390, 297, 14);
		panel_2.add(lblNewLabel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					String uname=textField.getText();
					String upwd=passwordField.getText();
					String role=label_role.getText();
					nrole=role.toLowerCase();
					System.out.println(nrole);
					Connection con=DBManager.getDBConnectivity();
					Statement stmt=con.createStatement();
					String sql="select email,password,role,id,mobno from users";
					ResultSet rs=stmt.executeQuery(sql);
					while(rs.next())
					{
						
						
					/*	Rajas@hccms.com HCCMS@123 doctor
						abhilasha@hccms.com HCCMS@123 receptionist
						rajasingle@hccms.com HCCMS@123 doctor
						varungadre@hccms.com HCCMS@123 pharmacist
						akshay@hccms.com HCCMS@123 pathologist
						admin@hccms.com adminhccms admin */

						
							if(nrole.equals("admin")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
							{
							String username=rs.getString("id");
							
							Statement stm=con.createStatement();
							String idz=rs.getString("id");
							String emails=rs.getString("email");
							String mobnum=rs.getString("mobno");
							String passwordz=rs.getString("password");
							String rolee=rs.getString("role");
							try
							{
							String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
							boolean flag=stm.execute(sql2);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						
							JOptionPane.showMessageDialog(null, "Your are logged in As Admin!! "+"\n"+"Your id is: "+username);
							flag=true;
							dispose();
							String info[]=new String[1];
							info[0]=username;
							AdminHomeScreen frame = new AdminHomeScreen();
							frame.main(info);
							frame.setVisible(false);
							frame.setLocationRelativeTo(null);
							}
							else if(nrole.equals("doctor")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
							{
								
									String username=rs.getString("id");
								
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
						
								JOptionPane.showMessageDialog(null, "Your are logged in As Doctor!! "+"\n"+"Your id is: "+username);
								flag=true;
								dispose();
								String []info=new String[1];
								info[0]=username;
								Doctor frame = new Doctor();
								frame.main(info);
								frame.setVisible(false);
								frame.setLocationRelativeTo(null);	
								
							
									
							}
							else if(nrole.equals("pharmacist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
							{
								String username=rs.getString("id");
								//code for inserting the list of the active users
								Statement stm=con.createStatement();
								String idz=rs.getString("id");
								String emails=rs.getString("email");
								String mobnum=rs.getString("mobno");
								String passwordz=rs.getString("password");
								String rolee=rs.getString("role");
								try
								{
								String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
								boolean flag=stm.execute(sql2);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
								JOptionPane.showMessageDialog(null, "Your are logged in As Pharmacist!! "+"\n"+"Your id is: "+username);
								flag=true;
								dispose();
								String []info=new String[1];
								info[0]=username;
								MainMedicalPage frame = new MainMedicalPage();
								frame.main(info);
								frame.setVisible(false);
								frame.setLocationRelativeTo(null);
								
							}
							else if(nrole.equals("pathologist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
							{
								String username=rs.getString("id");
								
								Statement stm=con.createStatement();
								String idz=rs.getString("id");
								String emails=rs.getString("email");
								String mobnum=rs.getString("mobno");
								String passwordz=rs.getString("password");
								String rolee=rs.getString("role");
								try
								{
								String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
								boolean flag=stm.execute(sql2);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
								
								JOptionPane.showMessageDialog(null, "Your are logged in As Pathologist!! "+"\n"+"Your id is: "+username);
								flag=true;
								dispose();
								String data[]=new String[1];
								data[0]=username;
								Pathology frame = new Pathology();
								frame.main(data);
								frame.setVisible(false);
								frame.setLocationRelativeTo(null);
							}
							else if(nrole.equals("receptionist")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
							{
								String username=rs.getString("id");
								
								Statement stm=con.createStatement();
								String idz=rs.getString("id");
								String emails=rs.getString("email");
								String mobnum=rs.getString("mobno");
								String passwordz=rs.getString("password");
								String rolee=rs.getString("role");
								try
								{
								String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
								boolean flag=stm.execute(sql2);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
								
								JOptionPane.showMessageDialog(null, "Your are logged in As Receptionist!! "+"\n"+"Your id is: "+username);
								flag=true;
								dispose();
								String data[]=new String[1];
								data[0]=username;
								ReceptionistHomeScreen frame = new ReceptionistHomeScreen();
								frame.main(data);
								frame.setVisible(false);
								frame.setLocationRelativeTo(null);
								
							}
							else if(nrole.equals("accountant")&&(uname.equals(rs.getString("email"))|uname.equals(rs.getString("mobno")))&&upwd.equals(rs.getString("password")))
							{
								
									String username=rs.getString("id");
								
									Statement stm=con.createStatement();
									String idz=rs.getString("id");
									String emails=rs.getString("email");
									String mobnum=rs.getString("mobno");
									String passwordz=rs.getString("password");
									String rolee=rs.getString("role");
									try
									{
									String sql2="insert into activeusers(id,email,mobno,password,role)values('"+idz+"','"+emails+"','"+mobnum+"','"+passwordz+"','"+rolee+"')";
									boolean flag=stm.execute(sql2);
									}
									catch(Exception e)
									{
										e.printStackTrace();
									}
						
								JOptionPane.showMessageDialog(null, "Your are logged in As Accountant!! "+"\n"+"Your id is: "+username);
								flag=true;
								dispose();
								String []info=new String[1];
								info[0]=username;
								AccountantHomeScreen frame = new AccountantHomeScreen();
								frame.main(info);
								frame.setVisible(false);
								frame.setResizable(false);
								frame.setLocationRelativeTo(null);
									
							}
							
						}
					
					//Check if Username or password or role matches or not
					if(flag==false)
					{
						JOptionPane.showMessageDialog(null, "Role Or Username Or Password"+"\n"+"Invalid");
					}
						con.close();
						
						
					}
					
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBorder(custext);
		btnNewButton.setBounds(251, 437, 104, 43);
		panel_2.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBorder(custext);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("");
				passwordField.setText("");
				lblNewLabel.setText("");
				label_role.setText("");
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setBackground(Color.WHITE);
		btnClear.setBounds(581, 437, 104, 43);
		panel_2.add(btnClear);
		
		Border emptyborders=BorderFactory.createEmptyBorder();
		final JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBorder(emptyborders);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_role.setText("ADMIN");
				btnNewButton_1.setFocusPainted(false);
				
				
				
				
			}
		});
		btnNewButton_1.setForeground(SystemColor.textHighlightText);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/Male User_96px.png")));
		btnNewButton_1.setBounds(42, 78, 125, 96);
		//Code for remove border
		btnNewButton_1.setOpaque(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		//---------- End----------
		panel_2.add(btnNewButton_1);
		
		final JButton button = new JButton("");
		button.setBorder(emptyborders);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_role.setText("RECEPTIONIST");
				button.setFocusPainted(false);
			}
		});
		button.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/Female Profile_96px.png")));
		button.setBackground(Color.WHITE);
		button.setBounds(187, 78, 125, 96);
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		panel_2.add(button);
		
		final JButton button_1 = new JButton("");
		button_1.setBorder(emptyborders);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_role.setText("PHARMACIST");
				button_1.setFocusPainted(false);
			}
		});
		button_1.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/Pill_96px.png")));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(493, 78, 125, 96);
		button_1.setOpaque(false);
		button_1.setContentAreaFilled(false);
		button_1.setBorderPainted(false);
		panel_2.add(button_1);
		
		final JButton button_2 = new JButton("");
		button_2.setBorder(emptyborders);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_role.setText("PATHOLOGIST");
				button_2.setFocusPainted(false);
			}
		});
		button_2.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/Survey_96px.png")));
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(628, 78, 125, 96);
		button_2.setOpaque(false);
		button_2.setContentAreaFilled(false);
		button_2.setBorderPainted(false);
		panel_2.add(button_2);
		
		final JButton button_3 = new JButton("");
		button_3.setBorder(emptyborders);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label_role.setText("DOCTOR");
				button_3.setFocusPainted(false);
				
			}
		});
		button_3.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/Doctors Bag_96px.png")));
		button_3.setBackground(Color.WHITE);
		button_3.setBounds(333, 78, 125, 96);
		button_3.setOpaque(false);
		button_3.setContentAreaFilled(false);
		button_3.setBorderPainted(false);
		panel_2.add(button_3);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("ADMIN");
		lblNewLabel_1.setBackground(SystemColor.textHighlightText);
		lblNewLabel_1.setForeground(SystemColor.textHighlightText);
		lblNewLabel_1.setFont(new Font("Kartika", Font.BOLD, 11));
		lblNewLabel_1.setBounds(85, 185, 40, 29);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblReceiptionist = new JLabel("RECEIPTIONIST");
		lblReceiptionist.setForeground(SystemColor.textHighlightText);
		lblReceiptionist.setFont(new Font("Kartika", Font.BOLD, 11));
		lblReceiptionist.setBackground(Color.WHITE);
		lblReceiptionist.setBounds(207, 185, 92, 29);
		panel_2.add(lblReceiptionist);
		
		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setForeground(SystemColor.textHighlightText);
		lblDoctor.setFont(new Font("Kartika", Font.BOLD, 11));
		lblDoctor.setBackground(Color.WHITE);
		lblDoctor.setBounds(369, 185, 57, 29);
		panel_2.add(lblDoctor);
		
		JLabel lblPharmacist = new JLabel("PHARMACIST");
		lblPharmacist.setForeground(SystemColor.textHighlightText);
		lblPharmacist.setFont(new Font("Kartika", Font.BOLD, 11));
		lblPharmacist.setBackground(Color.WHITE);
		lblPharmacist.setBounds(512, 185, 94, 29);
		panel_2.add(lblPharmacist);
		
		JLabel lblLab = new JLabel("PATHOLOGIST");
		lblLab.setForeground(SystemColor.textHighlightText);
		lblLab.setFont(new Font("Kartika", Font.BOLD, 11));
		lblLab.setBackground(Color.WHITE);
		lblLab.setBounds(649, 185, 104, 29);
		panel_2.add(lblLab);
		
		final JButton button_4 = new JButton("");
		button_4.setBorder(emptyborders);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				label_role.setText("ACCOUNTANT");
				button_4.setFocusPainted(false);
				
				
			}
		});
		button_4.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/icons8-budget-96.png")));
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(763, 78, 125, 96);
		button_4.setOpaque(false);
		button_4.setContentAreaFilled(false);
		button_4.setBorderPainted(false);
		panel_2.add(button_4);
		
		JLabel lblAccountant = new JLabel("ACCOUNTANT");
		lblAccountant.setForeground(SystemColor.textHighlightText);
		lblAccountant.setFont(new Font("Kartika", Font.BOLD, 11));
		lblAccountant.setBackground(Color.WHITE);
		lblAccountant.setBounds(784, 185, 104, 29);
		panel_2.add(lblAccountant);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/icons8-actor-40.png")));
		lblNewLabel_3.setBounds(243, 253, 40, 43);
		panel_2.add(lblNewLabel_3);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/icons8-name-40.png")));
		label_1.setBounds(243, 307, 40, 43);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/icons8-forgot-password-40.png")));
		label_2.setBounds(243, 361, 40, 43);
		panel_2.add(label_2);
		
		JButton button_5 = new JButton("");
		button_5.setBorder(emptyborders);
		button_5.setFocusPainted(false);
		button_5.setOpaque(false);
		button_5.setContentAreaFilled(false);
		
		
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_5.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/icons8-close-window-48.png")));
		button_5.setBounds(856, 30, 58, 37);
		panel_2.add(button_5);
		
		JLabel lblNewLabel_2 = new JLabel("HCCMS Version 1.1.0");
		lblNewLabel_2.setForeground(SystemColor.textHighlightText);
		lblNewLabel_2.setBounds(789, 550, 125, 14);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_Back = new JLabel("");
		lblNewLabel_Back.setIcon(new ImageIcon(Login.class.getResource("/com/hms/images/back.png")));
		lblNewLabel_Back.setBounds(0, 11, 941, 597);
		panel_2.add(lblNewLabel_Back);
		
		
	}
}

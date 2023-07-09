package book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;

public class Loginpage {

	 JFrame Loginpage;
	private JTextField Email;
	private JPasswordField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage window = new Loginpage();
					window.Loginpage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loginpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Loginpage = new JFrame();
		Loginpage.getContentPane().setBackground(new Color(240, 240, 240));
		Loginpage.setBounds(100, 100, 1360, 779);
		Loginpage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		Loginpage.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(390, 228, 74, 32);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(390, 284, 72, 32);
		layeredPane.add(lblNewLabel_1);
		
		Email = new JTextField();
		Email.setBounds(504, 236, 231, 19);
		layeredPane.add(Email);
		Email.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(504, 292, 231, 19);
		layeredPane.add(Password);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			 try
			 {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
				 PreparedStatement pst = con.prepareStatement("select * from Login where Email=? and Password=?");
				 pst.setString(1,Email.getText());
				 pst.setString(2, Password.getText());
				 ResultSet rs = pst.executeQuery();
				 if(rs.next())
				 {
					 JOptionPane.showMessageDialog(null, "user logged in succesfully");
					 Displaypage window = new Displaypage();
					window.Displaypage.setVisible(true);
					 Loginpage.dispose();
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null, "user invalid");
					 Loginpage.dispose();
		
				 }
				 rs.close();
				 pst.close();
			 }
			 catch(Exception ee )
			 {
				 System.out.print(ee);
			 }
			}
		
	});
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(504, 369, 85, 26);
		layeredPane.add(btnNewButton);
		
		JTextArea txtrLoginPage = new JTextArea();
		txtrLoginPage.setBackground(new Color(240, 240, 240));
		txtrLoginPage.setFont(new Font("Monospaced", Font.BOLD, 18));
		txtrLoginPage.setText("LOGIN PAGE");
		txtrLoginPage.setBounds(488, 123, 123, 22);
		layeredPane.add(txtrLoginPage);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\aleen\\Downloads\\2a6ff37f2d7be496117a2e22aeac67fc.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1469, 766);
		layeredPane.add(lblNewLabel_2);
		
		JButton btnNewButton_1 = new JButton("ADMIN");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Adminlogin window = new Adminlogin();
				window.Adminlogin.setVisible(true);
				
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(1139, 43, 85, 21);
		layeredPane.add(btnNewButton_1);
	}

	
		
	}


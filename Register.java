package book;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class Register {

	 JFrame Register;
	private JTextField Name;
	private JTextField Email;
	private JPasswordField Password;
	private JPasswordField Confirmpassword;
	private JTextField Phoneno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.Register.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Register = new JFrame();
		Register.setBounds(100, 100, 1366, 758);
		Register.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		Register.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JTextArea txtrRegister = new JTextArea();
		txtrRegister.setFont(new Font("Monospaced", Font.BOLD, 17));
		txtrRegister.setBackground(new Color(240, 240, 240));
		txtrRegister.setText("REGISTER");
		txtrRegister.setBounds(353, 126, 133, 22);
		layeredPane.add(txtrRegister);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(255, 235, 45, 13);
		layeredPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(255, 281, 45, 13);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_2.setBounds(255, 328, 72, 13);
		layeredPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Confirm Password");
		lblNewLabel_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_3.setBounds(255, 369, 124, 13);
		layeredPane.add(lblNewLabel_3);
		
		Name = new JTextField();
		Name.setBounds(443, 233, 96, 19);
		layeredPane.add(Name);
		Name.setColumns(10);
		
		Email = new JTextField();
		Email.setBounds(443, 279, 96, 19);
		layeredPane.add(Email);
		Email.setColumns(10);
		
		Password = new JPasswordField();
		Password.setBounds(443, 326, 96, 19);
		layeredPane.add(Password);
		
		Confirmpassword = new JPasswordField();
		Confirmpassword.setBounds(443, 367, 96, 19);
		layeredPane.add(Confirmpassword);
		
		JLabel lblNewLabel_4 = new JLabel("Phone no:");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_4.setBounds(255, 412, 72, 13);
		layeredPane.add(lblNewLabel_4);
		
		Phoneno = new JTextField();
		Phoneno.setBounds(443, 410, 96, 19);
		layeredPane.add(Phoneno);
		Phoneno.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			 try
			 {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
				 PreparedStatement pst = con.prepareStatement("insert into Login values(?,?,?,?,?)");
				 pst.setString(1,Name.getText());
				 pst.setString(2, Email.getText());
				 pst.setString(3, Password.getText());
				 pst.setString(4, Confirmpassword.getText());
				 pst.setString(5, Phoneno.getText());
				 
				
				 if(Password.getText().equalsIgnoreCase(Confirmpassword.getText()))
				 {
					 pst.executeUpdate();
;					 JOptionPane.showMessageDialog(null, "user registered succesfully");
					 Displaypage window = new Displaypage();
					window.Displaypage.setVisible(true);
					 Register.dispose();
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(null, "user invalid");
					 Register.dispose();
		
				 }
				 
				 pst.close();
			 }
			 catch(Exception ee )
			 {
				 System.out.print(ee);
			 }
			}
		
	});
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(340, 476, 85, 29);
		layeredPane.add(btnNewButton);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\aleen\\Downloads\\2a6ff37f2d7be496117a2e22aeac67fc.jpg"));
		lblNewLabel_5.setBounds(0, 0, 1385, 765);
		layeredPane.add(lblNewLabel_5);
	}

}

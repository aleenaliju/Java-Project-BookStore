package book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Adminlogin {

	 JFrame Adminlogin;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlogin window = new Adminlogin();
					window.Adminlogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Adminlogin = new JFrame();
		Adminlogin.getContentPane().setBackground(new Color(128, 128, 192));
		Adminlogin.setBounds(100, 100, 1373, 791);
		Adminlogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		Adminlogin.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(475, 293, 69, 13);
		layeredPane.add(lblNewLabel);
		
		username = new JTextField();
		username.setBounds(607, 290, 96, 19);
		layeredPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setBounds(475, 374, 84, 13);
		layeredPane.add(lblNewLabel_1);
		
		password = new JTextField();
		password.setBounds(607, 371, 96, 19);
		layeredPane.add(password);
		password.setColumns(10);
		
		JTextArea txtrAdmin = new JTextArea();
		txtrAdmin.setBackground(new Color(128, 128, 192));
		txtrAdmin.setText("ADMIN");
		txtrAdmin.setBounds(552, 190, 61, 22);
		layeredPane.add(txtrAdmin);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
		Admin window = new Admin();
		window.Admin.setVisible(true);
			}
		});
		btnNewButton.setBounds(536, 430, 85, 21);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOG OUT");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				BookStore window = new BookStore();
				window.frmHomePage.setVisible(true);
				
			 
			}
		});
		btnNewButton_1.setBounds(1126, 10, 96, 21);
		layeredPane.add(btnNewButton_1);
	}
}

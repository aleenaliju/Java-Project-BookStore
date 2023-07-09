package book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Window;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class BookStore {

	 JFrame frmHomePage;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookStore window = new BookStore();
					window.frmHomePage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BookStore() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHomePage = new JFrame();
		frmHomePage.setFont(new Font("Elephant", Font.ITALIC, 12));
		frmHomePage.setForeground(new Color(128, 64, 0));
		frmHomePage.setTitle("Home Page");
		frmHomePage.getContentPane().setBackground(new Color(255, 128, 64));
		frmHomePage.setBounds(100, 100, 1367, 878);
		frmHomePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		frmHomePage.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JTextArea txtrWelcomeToThe = new JTextArea();
		txtrWelcomeToThe.setForeground(new Color(128, 128, 128));
		txtrWelcomeToThe.setBackground(new Color(0, 0, 0));
		txtrWelcomeToThe.setFont(new Font("Dubai", Font.BOLD | Font.ITALIC, 24));
		txtrWelcomeToThe.setText("WELCOME TO THE WORLD  OF  BOOKS ");
		txtrWelcomeToThe.setBounds(571, 177, 422, 34);
		layeredPane.add(txtrWelcomeToThe);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 frmHomePage.setVisible(false);
			 Loginpage window = new Loginpage();
				window.Loginpage.setVisible(true);
			
			 
				
			}
		});
		btnNewButton.setForeground(new Color(64, 0, 64));
		btnNewButton.setBackground(new Color(128, 128, 128));
		btnNewButton.setBounds(723, 246, 93, 27);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SIGN UP");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmHomePage.setVisible(false);
				Register window = new Register();
				window.Register.setVisible(true);
				
			}
		});
		btnNewButton_1.setBackground(new Color(128, 128, 128));
		btnNewButton_1.setBounds(731, 318, 85, 27);
		layeredPane.add(btnNewButton_1);
		lblNewLabel.setBackground(new Color(255, 255, 128));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aleen\\Downloads\\books-01.jpg"));
		lblNewLabel.setBounds(0, 0, 1384, 864);
		layeredPane.add(lblNewLabel);
	}
	
}

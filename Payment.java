package book;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class Payment {

	 JFrame Payment;
	 private JComboBox comboBox;
	 private JButton btnNewButton;
	 private JPanel panel;
	 private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Payment window1 = new Payment();
					window1.Payment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Payment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Payment = new JFrame();
		Payment.getContentPane().setBackground(new Color(64, 128, 128));
		Payment.setBounds(100, 100, 1374, 868);
		Payment.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		Payment.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JTextArea txtrModeOfPayment = new JTextArea();
		txtrModeOfPayment.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 13));
		txtrModeOfPayment.setBackground(new Color(240, 240, 240));
		txtrModeOfPayment.setText("Mode of Payment");
		txtrModeOfPayment.setBounds(429, 227, 156, 22);
		layeredPane.add(txtrModeOfPayment);
		
		 comboBox = new JComboBox();
		 comboBox.setFont(new Font("Tahoma", Font.BOLD, 13));
		 comboBox.addItem("select item");
		 comboBox.addItem("CARD PAYMENT");
		 comboBox.addItem("GPAY");
		 comboBox.addItem("PAYTM");
		comboBox.setBounds(595, 229, 156, 21);
		layeredPane.add(comboBox);
		
		btnNewButton = new JButton("PAY");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			 Payment.setVisible(false);
			}
		});
				 
			 
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(536, 308, 85, 21);
		layeredPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setBounds(359, 164, 458, 214);
		layeredPane.add(panel);
		
		btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Displaypage window = new Displaypage();
				window.Displaypage.setVisible(true);
			 
			}
		});
		btnNewButton_1.setBounds(732, 390, 85, 21);
		layeredPane.add(btnNewButton_1);
	}
}
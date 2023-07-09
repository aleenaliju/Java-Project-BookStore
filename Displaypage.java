package book;

import java.awt.EventQueue;

import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class Displaypage {

	 JFrame Displaypage;
	 private JTextField Bookname;
	 private JTextField Bookid;
	 private JTextField Bookauthor;
	 private JTextField Bookprice;
	 private JTextField Category;
	 private JTextField custname;
	 private JTextField message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Displaypage window = new Displaypage();
					window.Displaypage.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public Displaypage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Displaypage = new JFrame();
		Displaypage.getContentPane().setBackground(new Color(0, 128, 255));
		Displaypage.setBounds(100, 100, 1390, 778);
		Displaypage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBackground(new Color(255, 128, 128));
		Displaypage.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		Bookname = new JTextField();
		Bookname.setBounds(260, 126, 178, 19);
		layeredPane.add(Bookname);
		Bookname.setColumns(10);
		
		JTextArea txtrDetails = new JTextArea();
		txtrDetails.setBackground(new Color(128, 255, 255));
		txtrDetails.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 15));
		txtrDetails.setText("Details");
		txtrDetails.setBounds(136, 223, 52, 22);
		layeredPane.add(txtrDetails);
		
		JLabel lblNewLabel_2 = new JLabel("BOOK ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_2.setBounds(115, 300, 80, 13);
		layeredPane.add(lblNewLabel_2);
		
		Bookid = new JTextField();
		Bookid.setBounds(275, 297, 128, 19);
		layeredPane.add(Bookid);
		Bookid.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("BOOK AUTHOR");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_3.setBounds(115, 368, 128, 13);
		layeredPane.add(lblNewLabel_3);
		
		Bookauthor = new JTextField();
		Bookauthor.setBounds(275, 365, 128, 19);
		layeredPane.add(Bookauthor);
		Bookauthor.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("BOOK PRICE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_4.setBounds(115, 440, 128, 13);
		layeredPane.add(lblNewLabel_4);
		
		Bookprice = new JTextField();
		Bookprice.setBounds(275, 437, 128, 19);
		layeredPane.add(Bookprice);
		Bookprice.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CATEGORY");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_5.setBounds(115, 498, 80, 13);
		layeredPane.add(lblNewLabel_5);
		
		Category = new JTextField();
		Category.setBounds(275, 495, 128, 19);
		layeredPane.add(Category);
		Category.setColumns(10);
		
		JButton btnNewButton = new JButton("BUY NOW");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 Displaypage.setVisible(false);
			 Payment window = new Payment();
				window.Payment.setVisible(true);
			
			 
				
			}
		});
		btnNewButton.setBounds(200, 589, 115, 21);
		layeredPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("SEARCH");
		btnNewButton_1.setBackground(new Color(255, 128, 128));
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			 try
			 {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
				 PreparedStatement pst = con.prepareStatement("select Bookname,Bookid,Bookauthor,Bookprice,Category from Book where lower(Bookname)=?");
		         pst.setString(1, Bookname.getText().toLowerCase());
		         ResultSet rs = pst.executeQuery();
		         if(rs.next()==false)
		         {
		        	 JOptionPane.showMessageDialog(null,"Record not found");
		        	 Bookid.setText("");
		        	 Bookauthor.setText("");
		        	 Bookprice.setText("");
		        	 Category.setText("");
		        	 
		         }
		         else
		         {
		        	 Bookid.setText(rs.getString("Bookid"));
		        	 Bookauthor.setText(rs.getString("Bookauthor"));
		        	 Bookprice.setText(rs.getString("Bookprice"));
		        	 Category.setText(rs.getString("Category"));
		        	 
		         }
		         rs.close();
		         pst.close();
			 }
			 catch(Exception ee)
			 {
				 System.out.print(ee);
			 }
			}
		});
		
			 
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(88, 125, 107, 21);
		layeredPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\aleen\\Downloads\\2a6ff37f2d7be496117a2e22aeac67fc.jpg"));
		lblNewLabel.setBounds(10, 0, 1466, 962);
		layeredPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("LOG OUT");
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				BookStore window = new BookStore();
				window.frmHomePage.setVisible(true);
				Displaypage.dispose();
			 
			}
		});
		btnNewButton_2.setBounds(1214, 20, 115, 21);
		layeredPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("FEEDBACK FORM");
		lblNewLabel_1.setBounds(1283, 252, 83, 13);
		layeredPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_6 = new JLabel("Name");
		lblNewLabel_6.setBounds(1255, 301, 74, 13);
		layeredPane.add(lblNewLabel_6);
		
		custname = new JTextField();
		custname.setBounds(1319, 298, 80, 19);
		layeredPane.add(custname);
		custname.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Message");
		lblNewLabel_7.setBounds(1255, 352, 74, 13);
		layeredPane.add(lblNewLabel_7);
		
		message = new JTextField();
		message.setBounds(1319, 349, 96, 19);
		layeredPane.add(message);
		message.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Submit");
		btnNewButton_3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			 try
			 {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
				 PreparedStatement pst = con.prepareStatement("insert into Feedback values(?,?)");
				 pst.setString(1,custname.getText());
				 pst.setString(2, message.getText());
				 ResultSet rst = pst.executeQuery();
				 if(rst.next())
				 {
					 
				 JOptionPane.showMessageDialog(null, "feedback entered succesfully");
				 }
				 rst.close();
				 pst.close();
			 }
			 catch (Exception ee)
			 {
				 System.out.print(ee);
			 }
			}
		});
		btnNewButton_3.setBounds(1283, 406, 85, 21);
		layeredPane.add(btnNewButton_3);
	}
}

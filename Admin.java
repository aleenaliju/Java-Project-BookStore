package book;

import java.awt.EventQueue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;

public class Admin {

	 JFrame Admin;
	private JTextField Bookname;
	private JTextField Bookid;
	private JTextField Bookauthor;
	private JTextField Bookprice;
	private JTextField Category;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
					window.Admin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Admin() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Admin = new JFrame();
		Admin.getContentPane().setBackground(new Color(128, 128, 192));
		Admin.setBounds(100, 100, 1380, 787);
		Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		Admin.getContentPane().add(layeredPane, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("BookName");
		lblNewLabel.setBounds(223, 215, 71, 13);
		layeredPane.add(lblNewLabel);
		
		Bookname = new JTextField();
		Bookname.setBounds(358, 212, 96, 19);
		layeredPane.add(Bookname);
		Bookname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("BookId");
		lblNewLabel_1.setBounds(223, 289, 71, 13);
		layeredPane.add(lblNewLabel_1);
		
		Bookid = new JTextField();
		Bookid.setBounds(358, 286, 96, 19);
		layeredPane.add(Bookid);
		Bookid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("BookAuthor");
		lblNewLabel_2.setBounds(223, 360, 71, 13);
		layeredPane.add(lblNewLabel_2);
		
		Bookauthor = new JTextField();
		Bookauthor.setBounds(358, 357, 96, 19);
		layeredPane.add(Bookauthor);
		Bookauthor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("BookPrice");
		lblNewLabel_3.setBounds(223, 425, 60, 13);
		layeredPane.add(lblNewLabel_3);
		
		Bookprice = new JTextField();
		Bookprice.setBounds(358, 422, 96, 19);
		layeredPane.add(Bookprice);
		Bookprice.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Bookcategory");
		lblNewLabel_4.setBounds(223, 480, 83, 13);
		layeredPane.add(lblNewLabel_4);
		
		Category = new JTextField();
		Category.setBounds(358, 477, 96, 19);
		layeredPane.add(Category);
		Category.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD BOOK");
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			 try
			 {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
				 PreparedStatement pst = con.prepareStatement("insert into Book values(?,?,?,?,?)");
				 pst.setString(1,Bookname.getText());
				 pst.setString(2, Bookid.getText());
				 pst.setString(3, Bookauthor.getText());
				 pst.setString(4, Bookprice.getText());
				 pst.setString(5, Category.getText());
				 ResultSet rs = pst.executeQuery();
				 
				
				 if(rs.next())
				 {
					 
;					 JOptionPane.showMessageDialog(null, "book added succesfully");
					 
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
		btnNewButton.setBounds(409, 588, 102, 21);
		layeredPane.add(btnNewButton);
		
		JButton delete = new JButton("DELETE BOOK");
		delete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
			 try
			 {
				 Class.forName("oracle.jdbc.driver.OracleDriver");
				 Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","msc","msc");
				 PreparedStatement ps = con.prepareStatement("DELETE FROM BOOK where Bookname=?");
				 ps.setString(1,Bookname.getText());
				 ResultSet rst = ps.executeQuery();
				 
				 
				 JOptionPane.showMessageDialog(null, "DELETED SUCCESFULLY");
				 //ps.setString(2, Bookid.getText());
			
				 
				 rst.close();
				 ps.close();
			 }
			 catch(Exception ee )
			 {
				 System.out.print(ee);
			 }
			}
		
	});
		delete.setBounds(223, 588, 102, 21);
		layeredPane.add(delete);
	}
}

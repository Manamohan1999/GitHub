import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.jdbc.driver.DBConversion;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ReturnBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookid;
	private JTextField sname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook frame = new ReturnBook();
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
	public ReturnBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 386, 223);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Issued Book Details :");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 231, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BookID   :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(32, 59, 66, 20);
		contentPane.add(lblNewLabel_1);
		
		bookid = new JTextField();
		bookid.setBounds(108, 59, 148, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("S. Name :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(32, 90, 66, 20);
		contentPane.add(lblNewLabel_2);
		
		sname = new JTextField();
		sname.setBounds(108, 91, 148, 20);
		contentPane.add(sname);
		sname.setColumns(10);
		
		JButton btnNewButton = new JButton("Return");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					smt.executeUpdate("update librarybooks set \"Status\"='available' where \"BookID\"='"+bookid.getText()+"'");
					smt.executeUpdate("delete from "+sname.getText()+" where \"BookID\"='"+bookid.getText()+"'");
					JOptionPane.showMessageDialog(null, "Book Returned Successfull !!");
					bookid.setText(null);
					sname.setText(null);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(129, 138, 112, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFunction back=new AdminFunction();
				back.setVisible(true);
				back.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(10, 138, 109, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(251, 138, 109, 23);
		contentPane.add(btnNewButton_2);
	}

}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class AddBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookid;
	private JTextField title;
	private JTextField author;
	private JTextField branch;
	private JTextField year;
	private JTextField cost;
	private JTextField date;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setTitle("Add New Book");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 476, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Book Details :");
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 12));
		lblNewLabel.setBounds(21, 25, 135, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BookID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(60, 57, 59, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Title     :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(60, 89, 73, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Author  :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(60, 121, 59, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Branch  :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(60, 153, 59, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Year     :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(60, 178, 59, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Cost     :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(60, 210, 59, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Date    :");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(60, 235, 59, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Status  :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(60, 267, 59, 21);
		contentPane.add(lblNewLabel_8);
		
		bookid = new JTextField();
		bookid.setBounds(121, 58, 176, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		title = new JTextField();
		title.setBounds(121, 90, 176, 20);
		contentPane.add(title);
		title.setColumns(10);
		
		author = new JTextField();
		author.setBounds(121, 122, 176, 20);
		contentPane.add(author);
		author.setColumns(10);
		
		branch = new JTextField();
		branch.setBounds(121, 151, 176, 20);
		contentPane.add(branch);
		branch.setColumns(10);
		
		year = new JTextField();
		year.setBounds(121, 179, 176, 20);
		contentPane.add(year);
		year.setColumns(10);
		
		cost = new JTextField();
		cost.setBounds(121, 208, 176, 20);
		contentPane.add(cost);
		cost.setColumns(10);
		
		date = new JTextField();
		date.setBounds(121, 236, 176, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		status = new JTextField();
		status.setBounds(121, 268, 176, 20);
		contentPane.add(status);
		status.setColumns(10);
		
		JButton addBookButton = new JButton("Add Book");
		addBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					smt.execute("insert into librarybooks values('"+bookid.getText()+"','"+title.getText()+"','"+author.getText()+"','"+branch.getText()+"',"+year.getText()+",'"+cost.getText()+"','"+date.getText()+"','"+status.getText()+"')");
					JOptionPane.showMessageDialog(null, "Book Added!!");
					bookid.setText(null);
					title.setText(null);
					author.setText(null);
					branch.setText(null);
					year.setText(null);
					cost.setText(null);
					date.setText(null);
					status.setText(null);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		addBookButton.setBounds(335, 57, 100, 37);
		contentPane.add(addBookButton);
		
		JButton resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bookid.setText(null);
				title.setText(null);
				author.setText(null);
				branch.setText(null);
				year.setText(null);
				cost.setText(null);
				date.setText(null);
				status.setText(null);
			}
		});
		resetButton.setBounds(335, 121, 100, 36);
		contentPane.add(resetButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFunction back=new AdminFunction();
				back.setVisible(true);
				back.setLocationRelativeTo(null);
			}
		});
		backButton.setBounds(335, 187, 100, 37);
		contentPane.add(backButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setBounds(335, 252, 100, 36);
		contentPane.add(exitButton);
	}
}

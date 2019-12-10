import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminFunction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFunction frame = new AdminFunction();
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
	public AdminFunction() {
		setTitle("Functions");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 569, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton viewBooks = new JButton("View Books");
		viewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LibraryBooks lb=new LibraryBooks();
				lb.setVisible(true);
				lb.setLocationRelativeTo(null);
			}
		});
		viewBooks.setBounds(10, 37, 121, 31);
		contentPane.add(viewBooks);
		
		JButton viewUsers = new JButton("View Users");
		viewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Users user=new Users();
				user.setVisible(true);
				user.setLocationRelativeTo(null);
			}
		});
		viewUsers.setBounds(141, 37, 121, 31);
		contentPane.add(viewUsers);
		
		JButton viewIssuedBooks = new JButton("View Issued Books");
		viewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IssuedBooks issuedbooks=new IssuedBooks();
				issuedbooks.setVisible(true);
				issuedbooks.setLocationRelativeTo(null);
			}
		});
		viewIssuedBooks.setBounds(272, 37, 129, 31);
		contentPane.add(viewIssuedBooks);
		
		JButton issueBook = new JButton("Issue Book");
		issueBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IssueBook bookissue=new IssueBook();
				bookissue.setVisible(true);
				bookissue.setLocationRelativeTo(null);
			}
		});
		issueBook.setBounds(411, 37, 132, 31);
		contentPane.add(issueBook);
		
		JButton addUser = new JButton("Add User");
		addUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddUser user=new AddUser();
				user.setVisible(true);
				user.setLocationRelativeTo(null);
			}
		});
		addUser.setBounds(10, 110, 121, 31);
		contentPane.add(addUser);
		
		JButton addBook = new JButton("Add Book");
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AddBook newbook=new AddBook();
				newbook.setVisible(true);
				newbook.setLocationRelativeTo(null);
			}
		});
		addBook.setBounds(141, 110, 121, 31);
		contentPane.add(addBook);
		
		JButton returnBook = new JButton("Return Book");
		returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ReturnBook returnbook=new ReturnBook();
				returnbook.setVisible(true);
				returnbook.setLocationRelativeTo(null);
			}
		});
		returnBook.setBounds(272, 110, 129, 31);
		contentPane.add(returnBook);
		
		JButton editUser = new JButton("Edit/Update");
		editUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EditUser edituser=new EditUser();
				edituser.setVisible(true);
				edituser.setLocationRelativeTo(null);
			}
		});
		editUser.setBounds(411, 110, 132, 31);
		contentPane.add(editUser);
	}

}

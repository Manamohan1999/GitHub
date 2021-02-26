import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import oracle.sql.INTERVALDS;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class IssueBook extends JFrame {

	private JPanel contentPane;
	private JTextField bookid;
	private JTextField bname;
	private JTextField sname;
	private JTextField date;
	private JTextField interval;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBook frame = new IssueBook();
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
	public IssueBook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Details :");
		lblNewLabel.setFont(new Font("Bodoni MT", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 11, 122, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BookID    :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(34, 53, 68, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("B Name    :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(34, 84, 68, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("S Name   :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(34, 116, 68, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Date       :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(34, 147, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Interval   :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(34, 172, 68, 20);
		contentPane.add(lblNewLabel_5);
		
		bookid = new JTextField();
		bookid.setBounds(107, 54, 163, 20);
		contentPane.add(bookid);
		bookid.setColumns(10);
		
		bname = new JTextField();
		bname.setBounds(107, 85, 163, 20);
		contentPane.add(bname);
		bname.setColumns(10);
		
		sname = new JTextField();
		sname.setBounds(107, 117, 163, 20);
		contentPane.add(sname);
		sname.setColumns(10);
		
		date = new JTextField();
		date.setBounds(107, 145, 163, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		interval = new JTextField();
		interval.setBounds(107, 173, 163, 20);
		contentPane.add(interval);
		interval.setColumns(10);
		
		JButton issueButton = new JButton("Issue");
		issueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					smt.execute("insert into "+sname.getText()+" values('"+bookid.getText()+"','"+bname.getText()+"','"+date.getText()+"',"+interval.getText()+")");
					smt.executeUpdate("update librarybooks set \"Status\"='issued' where \"BookID\"='"+bookid.getText()+"'");
					JOptionPane.showMessageDialog(null, "Book Issued by "+sname.getText()+" for "+interval.getText()+"Days !!");
					bookid.setText(null);
					bname.setText(null);
					sname.setText(null);
					date.setText(null);
					interval.setText(null);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		issueButton.setBounds(304, 49, 103, 31);
		contentPane.add(issueButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFunction back=new AdminFunction();
				back.setVisible(true);
				back.setLocationRelativeTo(null);
			}
		});
		backButton.setBounds(304, 105, 103, 31);
		contentPane.add(backButton);
		
		JButton exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setBounds(304, 159, 103, 33);
		contentPane.add(exitButton);
	}

}

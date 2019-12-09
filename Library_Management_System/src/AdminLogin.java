import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminLogin extends JFrame {

	private JPanel contentPane;
	private JTextField userIDField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLogin frame = new AdminLogin();
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
	public AdminLogin() {
		setTitle("Admin Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADMINISTRATION");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel.setBounds(122, 25, 210, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel_1.setBounds(179, 57, 75, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("User ID    :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(71, 121, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(71, 152, 67, 24);
		contentPane.add(lblNewLabel_3);
		
		userIDField = new JTextField();
		userIDField.setBounds(158, 120, 194, 20);
		contentPane.add(userIDField);
		userIDField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(158, 156, 194, 20);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery("select * from adminlogin");
					while(rs.next()!=false) {
						if(userIDField.getText().equals(rs.getString(2)) && passwordField.getText().equals(rs.getString(3))) {
							JOptionPane.showMessageDialog(null, "Login Sucessful!!");
							dispose();
							AdminFunction adminfunction=new AdminFunction();
							adminfunction.setVisible(true);
							adminfunction.setLocationRelativeTo(null);
						}else {
							JOptionPane.showMessageDialog(null, "Invalid Login Details!!");
							userIDField.setText(null);
							passwordField.setText(null);
						}
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		loginButton.setBounds(179, 218, 89, 30);
		contentPane.add(loginButton);
		
		JButton backButton = new JButton("BACK");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome welcome=new Welcome();
				welcome.setVisible(true);
				welcome.setLocationRelativeTo(null);
			}
		});
		backButton.setBounds(33, 218, 89, 30);
		contentPane.add(backButton);
		
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		exitButton.setBounds(329, 218, 89, 30);
		contentPane.add(exitButton);
	}
}

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
import java.awt.event.ActionEvent;
import java.sql.*;

public class AddUser extends JFrame {

	private JPanel contentPane;
	private JTextField regdField;
	private JPasswordField passwordField;
	private JTextField nameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUser frame = new AddUser();
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
	public AddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add New User :");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 17));
		lblNewLabel.setBounds(10, 11, 131, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Regd. No. :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(37, 63, 71, 18);
		contentPane.add(lblNewLabel_1);
		
		regdField = new JTextField();
		regdField.setBounds(118, 61, 139, 20);
		contentPane.add(regdField);
		regdField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(37, 128, 71, 25);
		contentPane.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(118, 131, 139, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("Name       :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(37, 92, 71, 25);
		contentPane.add(lblNewLabel_3);
		
		nameField = new JTextField();
		nameField.setBounds(118, 92, 139, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=nameField.getText();
				String password=passwordField.getText();
				String regd=regdField.getText();
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					smt.execute("create table "+name+"(\"BookID\" varchar(20) primary key,\"BookName\" varchar(30),\"Issue Date\" varchar(8),\"Days\" number(4))");
					smt.execute("insert into userlogin values("+"'"+regd+"','"+name+"','"+password+"')");
					JOptionPane.showMessageDialog(null, "User Added!!");
					nameField.setText(null);
					passwordField.setText(null);
					regdField.setText(null);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btnNewButton.setBounds(171, 179, 123, 33);
		contentPane.add(btnNewButton);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFunction adminfn=new AdminFunction();
				adminfn.setVisible(true);
				adminfn.setLocationRelativeTo(null);
			}
		});
		backButton.setBounds(10, 179, 123, 33);
		contentPane.add(backButton);
	}
}

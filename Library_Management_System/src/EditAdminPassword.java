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

public class EditAdminPassword extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField oldpass;
	private JPasswordField newpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditAdminPassword frame = new EditAdminPassword();
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
	public EditAdminPassword() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Details :");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 24, 120, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User Name     :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(38, 66, 92, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Old Password  :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(38, 91, 92, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(38, 116, 92, 14);
		contentPane.add(lblNewLabel_3);
		
		username = new JTextField();
		username.setBounds(140, 64, 157, 20);
		contentPane.add(username);
		username.setColumns(10);
		
		oldpass = new JTextField();
		oldpass.setBounds(140, 89, 157, 20);
		contentPane.add(oldpass);
		oldpass.setColumns(10);
		
		newpass = new JPasswordField();
		newpass.setBounds(140, 114, 157, 20);
		contentPane.add(newpass);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(username.getText().equals(null)) {
					JOptionPane.showMessageDialog(null, "Enter username password details !!");
				}else {
					try {
						Connection con=DBConnection.connect();
						Statement smt=con.createStatement();
						smt.executeUpdate("update adminlogin set \"password\"='"+newpass.getText()+"' where \"username\"='"+username.getText()+"'");
						JOptionPane.showMessageDialog(null, "Password Updated !!");

						username.setText(null);
						oldpass.setText(null);
						newpass.setText(null);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton.setBounds(150, 164, 89, 23);
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
		btnNewButton_1.setBounds(41, 164, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnNewButton_2.setBounds(259, 164, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}

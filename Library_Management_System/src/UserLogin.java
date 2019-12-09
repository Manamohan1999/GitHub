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

public class UserLogin extends JFrame {

	private JPanel contentPane;
	private JTextField regdField;
	private JPasswordField userpasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin frame = new UserLogin();
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
	public UserLogin() {
		setTitle("User Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 27));
		lblNewLabel.setBounds(173, 37, 111, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN");
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD, 24));
		lblNewLabel_1.setBounds(190, 73, 84, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Regd. No. :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(67, 120, 84, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(67, 158, 80, 14);
		contentPane.add(lblNewLabel_3);
		
		regdField = new JTextField();
		regdField.setBounds(169, 123, 178, 20);
		contentPane.add(regdField);
		regdField.setColumns(10);
		
		userpasswordField = new JPasswordField();
		userpasswordField.setBounds(169, 157, 178, 20);
		contentPane.add(userpasswordField);
		
		JButton userBackButton = new JButton("BACK");
		userBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Welcome welcome=new Welcome();
				welcome.setVisible(true);
				welcome.setLocationRelativeTo(null);
			}
		});
		userBackButton.setBounds(36, 199, 89, 36);
		contentPane.add(userBackButton);
		
		JButton loginButton = new JButton("LOGIN");
		loginButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery("select * from userlogin");
					Boolean status=false;
					while(rs.next()) {
						if (regdField.getText().equals(rs.getString(1)) && userpasswordField.getText().equals(rs.getString(3))){
							status=true;
							JOptionPane.showMessageDialog(null, "Login Sucessfull!!");
							dispose();
							UserFunction userfunction=new UserFunction();
							userfunction.setVisible(true);
							userfunction.setLocationRelativeTo(null);
							continue;
						}
					}
					if(!status)
						JOptionPane.showMessageDialog(null, "Invalid Login Details!!");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		loginButton.setBounds(172, 200, 89, 35);
		contentPane.add(loginButton);
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "Are You want to Exit")==0)
					dispose();
			}
		});
		btnNewButton.setBounds(312, 200, 89, 35);
		contentPane.add(btnNewButton);
	}

}

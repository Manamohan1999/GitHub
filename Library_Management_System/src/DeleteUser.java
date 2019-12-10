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

public class DeleteUser extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteUser frame = new DeleteUser();
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
	public DeleteUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 328, 221);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter User Details :");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 21, 185, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Regd. No. :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(33, 63, 72, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name       :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(33, 96, 72, 22);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(109, 65, 147, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(109, 98, 147, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFunction back=new AdminFunction();
				back.setVisible(true);
				back.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(10, 144, 95, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					smt.executeUpdate("delete from userlogin where \"Regd\"="+textField.getText());
					smt.execute("drop table "+textField_1.getText());
					JOptionPane.showMessageDialog(null, "User Deleted !!");
					textField.setText(null);
					textField_1.setText(null);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setBounds(115, 144, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_2.setBounds(214, 144, 89, 23);
		contentPane.add(btnNewButton_2);
	}

}

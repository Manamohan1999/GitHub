import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;

public class UserLibraryBooks extends JFrame {

	private JPanel contentPane;
	private JTextField branchField;
	private JTextField yearField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryBooks frame = new LibraryBooks();
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
	public UserLibraryBooks() {
		setTitle("Book Available");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 377);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 255, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Branch");
		mnNewMenu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("CSE");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchField.setText("CSE");
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("EEE");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchField.setText("EEE");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("ECE");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchField.setText("ECE");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JSeparator separator_2 = new JSeparator();
		mnNewMenu.add(separator_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("EE");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchField.setText("EE");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JSeparator separator_3 = new JSeparator();
		mnNewMenu.add(separator_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Civil");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchField.setText("Civil");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_4);
		
		JSeparator separator_4 = new JSeparator();
		mnNewMenu.add(separator_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Mech.");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchField.setText("Mech.");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_5);
		
		JMenu mnNewMenu_1 = new JMenu("Year");
		mnNewMenu_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("1st");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearField.setText("1");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_6);
		
		JSeparator separator_5 = new JSeparator();
		mnNewMenu_1.add(separator_5);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("2nd");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearField.setText("2");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
		JSeparator separator_6 = new JSeparator();
		mnNewMenu_1.add(separator_6);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("3rd");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearField.setText("3");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_8);
		
		JSeparator separator_7 = new JSeparator();
		mnNewMenu_1.add(separator_7);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("4th");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearField.setText("4");
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_9);
		
		branchField = new JTextField();
		branchField.setText("CSE");
		branchField.setEditable(false);
		branchField.setBounds(10, 32, 46, 20);
		contentPane.add(branchField);
		branchField.setColumns(10);
		
		yearField = new JTextField();
		yearField.setText("1");
		yearField.setEditable(false);
		yearField.setBounds(58, 32, 37, 20);
		contentPane.add(yearField);
		yearField.setColumns(10);
		
		JButton searchButton = new JButton("Search");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con=DBConnection.connect();
					Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery("select * from librarybooks where \"Branch\" = '"+branchField.getText()+"' AND \"Year\" = "+yearField.getText());
					table.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		searchButton.setBounds(105, 11, 160, 23);
		contentPane.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 663, 256);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				UserFunction back=new UserFunction();
				back.setVisible(true);
				back.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(342, 11, 120, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(495, 11, 120, 23);
		contentPane.add(btnNewButton_1);
	}
}

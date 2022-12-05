package mysql;

import mysql.*;
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					;
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 282);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setBounds(35, 11, 198, 34);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(19, 56, 78, 24);
		contentPane.add(lblNewLabel_1);

		user = new JTextField();
		user.setBounds(19, 81, 213, 24);
		contentPane.add(user);
		user.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(19, 116, 78, 24);
		contentPane.add(lblNewLabel_1_1);

		JButton login = new JButton("Login");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management",
							"root", "DHIRAJpt");
					Statement st = con.createStatement();
					String sql = "select * from logintable where username = '" + user.getText() + "' and password = '"
							+ pass.getText() + "'";
					ResultSet rs = st.executeQuery(sql);
					if (rs.next()) {
						Admin_operations frame = new Admin_operations();
						frame.setVisible(true);
						dispose();
					} else
						JOptionPane.showMessageDialog(null, "Incorrect Credentials");
					con.close();
				} catch (Exception p) {
					System.out.println(p);
				}
			}
		});
		login.setBounds(144, 189, 89, 23);
		contentPane.add(login);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancel.setBounds(25, 189, 89, 23);
		contentPane.add(cancel);

		pass = new JPasswordField();
		pass.setBounds(19, 147, 214, 24);
		contentPane.add(pass);
	}
}

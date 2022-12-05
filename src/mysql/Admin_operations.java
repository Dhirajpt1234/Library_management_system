package mysql;
import java.sql.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter; 

public class Admin_operations extends JFrame {

	private JPanel contentPane ;
	private JTextField tfaddbookid;
	private JTextField tfaddbookname;
	private JTextField tfaddauther;
	private JTextField tfaddprice;
	private JTextField tfremovebookid;
	private JTextField tfissuebookid;
	private JTextField tfissuestuid;
	private JTextField tfreturnstuid;
	private JTextField tfreturnbookid;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_operations frame = new Admin_operations();
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
	
	public Admin_operations() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Operations = new JPanel();
		Operations.setBounds(5, 5, 222, 357);
		Operations.setBackground(new Color(175, 238, 238));
		contentPane.add(Operations);
		Operations.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Operations");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblNewLabel.setBounds(24, 21, 188, 46);
		Operations.add(lblNewLabel);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(237, 5, 476, 351);
		contentPane.add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		JPanel Opadd = new JPanel();
		layeredPane.add(Opadd, "name_446251298301600");
		Opadd.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Add Book");
		lblNewLabel_1.setBounds(131, 11, 175, 37);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		Opadd.add(lblNewLabel_1);
		
		JLabel lbladdbookid = new JLabel("Book Id");
		lbladdbookid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbladdbookid.setBounds(40, 82, 108, 23);
		Opadd.add(lbladdbookid);
		
		JLabel lbladdbookname = new JLabel("Book Name");
		lbladdbookname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbladdbookname.setBounds(40, 134, 108, 23);
		Opadd.add(lbladdbookname);
		
		JLabel lbladdauther = new JLabel("Auther");
		lbladdauther.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbladdauther.setBounds(40, 185, 108, 23);
		Opadd.add(lbladdauther);
		
		JLabel lbladdprice = new JLabel("Price");
		lbladdprice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lbladdprice.setBounds(40, 231, 108, 23);
		Opadd.add(lbladdprice);
		
		JButton addaddbtn = new JButton("Add");
		addaddbtn.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","DHIRAJpt");
					Statement st = con.createStatement();
					String sqladd = "insert into books values("+Integer.parseInt(tfaddbookid.getText())+",'"+tfaddbookname.getText()+"','"+tfaddauther.getText()+"',"+Integer.parseInt(tfaddprice.getText())+")";
					st.execute(sqladd);
					JOptionPane.showMessageDialog(null,"Book Added");
					tfaddbookid.setText(null);
					tfaddbookname.setText(null);
					tfaddauther.setText(null);
					tfaddprice.setText(null);
					con.close();
				}
				catch(Exception p) 
				{
					System.out.println(p);
				}
			}
		});
		addaddbtn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		addaddbtn.setBounds(310, 292, 108, 33);
		Opadd.add(addaddbtn);
		
		tfaddbookid = new JTextField();
		tfaddbookid.setBounds(183, 85, 220, 23);
		Opadd.add(tfaddbookid);
		tfaddbookid.setColumns(10);
		
		tfaddbookname = new JTextField();
		tfaddbookname.setColumns(10);
		tfaddbookname.setBounds(183, 134, 220, 23);
		Opadd.add(tfaddbookname);
		
		tfaddauther = new JTextField();
		tfaddauther.setColumns(10);
		tfaddauther.setBounds(183, 185, 220, 23);
		Opadd.add(tfaddauther);
		
		tfaddprice = new JTextField();
		tfaddprice.setColumns(10);
		tfaddprice.setBounds(183, 234, 220, 23);
		Opadd.add(tfaddprice);
		
		JPanel Opremove = new JPanel();
		layeredPane.add(Opremove, "name_446255532026800");
		Opremove.setLayout(null);
		
		JLabel labelremove = new JLabel("Remove Book");
		labelremove.setHorizontalAlignment(SwingConstants.CENTER);
		labelremove.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelremove.setBounds(151, 11, 175, 37);
		Opremove.add(labelremove);
		
		JLabel lblremovebookid = new JLabel("Book Id");
		lblremovebookid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblremovebookid.setBounds(45, 86, 108, 23);
		Opremove.add(lblremovebookid);
		
		tfremovebookid = new JTextField();
		tfremovebookid.setColumns(10);
		tfremovebookid.setBounds(166, 88, 220, 23);
		Opremove.add(tfremovebookid);
		
		JButton removeremove = new JButton("Remove");
		removeremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","DHIRAJpt");
					Statement st = con.createStatement();
					String check = "select * from books where Book_id = "+Integer.parseInt(tfremovebookid.getText());
					ResultSet rs= st.executeQuery(check);
					if(rs.next()) 
					{
						String sqlremove = "delete from books where Book_id = "+Integer.parseInt(tfremovebookid.getText());
						st.execute(sqlremove);
						JOptionPane.showMessageDialog(null,"Book Removed");
						tfremovebookid.setText(null);
					}
					else  JOptionPane.showMessageDialog(null,"There is no book with id : "+Integer.parseInt(tfremovebookid.getText()));
					con.close();
				}
				catch(Exception p) 
				{
					System.out.println(p);
				}
			}
		});
		removeremove.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		removeremove.setBounds(318, 287, 127, 37);
		Opremove.add(removeremove);
		
		JPanel Opissue = new JPanel();
		layeredPane.add(Opissue, "name_446258101234200");
		Opissue.setLayout(null);
		
		JLabel labelissue = new JLabel("Issue Book");
		labelissue.setHorizontalAlignment(SwingConstants.CENTER);
		labelissue.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelissue.setBounds(136, 11, 175, 37);
		Opissue.add(labelissue);
		
		JLabel lblissuebookid = new JLabel("Book Id");
		lblissuebookid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblissuebookid.setBounds(43, 76, 108, 23);
		Opissue.add(lblissuebookid);
		
		tfissuebookid = new JTextField();
		tfissuebookid.setColumns(10);
		tfissuebookid.setBounds(186, 79, 220, 23);
		Opissue.add(tfissuebookid);
		
		tfissuestuid = new JTextField();
		tfissuestuid.setColumns(10);
		tfissuestuid.setBounds(186, 130, 220, 23);
		Opissue.add(tfissuestuid);
		
		JLabel lblissuestudentid = new JLabel("Student Id");
		lblissuestudentid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblissuestudentid.setBounds(43, 128, 108, 23);
		Opissue.add(lblissuestudentid);
		
		JButton issueissue = new JButton("Issue");
		issueissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","DHIRAJpt");
					Statement st = con.createStatement();
					String check1 = "select * from books where Book_id = "+Integer.parseInt(tfissuebookid.getText());
					ResultSet rs1= st.executeQuery(check1);
					if(rs1.next()) 
					{
						String check2 = "select * from Students where Student_id = "+Integer.parseInt(tfissuestuid.getText());
						ResultSet rs2= st.executeQuery(check2);
						if(rs2.next())
						{
							
							String exc= "update students set book_id = "+Integer.parseInt(tfissuebookid.getText())+", date_of_issue = (select curdate())  where student_id = "+Integer.parseInt(tfissuestuid.getText());
							st.execute(exc);
							JOptionPane.showMessageDialog(null,"Book Issued");
							
						}
						else JOptionPane.showMessageDialog(null,"There is no student with id : "+Integer.parseInt(tfissuestuid.getText()));
					}
					else  JOptionPane.showMessageDialog(null,"There is no book with id : "+Integer.parseInt(tfremovebookid.getText()));
					con.close();
				}
				catch(Exception p) 
				{
					System.out.println(p);
				}
			}
		});
		issueissue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		issueissue.setBounds(319, 286, 123, 37);
		Opissue.add(issueissue);
		
		JPanel Opreturn = new JPanel();
		layeredPane.add(Opreturn, "name_446260504937900");
		Opreturn.setLayout(null);
		
		JLabel labelreturn = new JLabel("Return Book");
		labelreturn.setHorizontalAlignment(SwingConstants.CENTER);
		labelreturn.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		labelreturn.setBounds(145, 11, 175, 37);
		Opreturn.add(labelreturn);
		
		JLabel lblreturnbookid = new JLabel("Book Id");
		lblreturnbookid.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblreturnbookid.setBounds(44, 75, 108, 23);
		Opreturn.add(lblreturnbookid);
		
		JLabel lblreturnstuId = new JLabel("Student Id");
		lblreturnstuId.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblreturnstuId.setBounds(44, 127, 108, 23);
		Opreturn.add(lblreturnstuId);
		
		tfreturnstuid = new JTextField();
		tfreturnstuid.setColumns(10);
		tfreturnstuid.setBounds(187, 127, 220, 23);
		Opreturn.add(tfreturnstuid);
		
		tfreturnbookid = new JTextField();
		tfreturnbookid.setColumns(10);
		tfreturnbookid.setBounds(187, 78, 220, 23);
		Opreturn.add(tfreturnbookid);
		
		JButton returnreturn = new JButton("Return");
		returnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_management","root","DHIRAJpt");
					Statement st = con.createStatement();
					String check1 = "select * from students where Book_id = "+Integer.parseInt(tfreturnbookid.getText()) + " and student_id = "+Integer.parseInt(tfreturnstuid.getText()) ;
					ResultSet rs1= st.executeQuery(check1);
					if(rs1.next()) 
					{
						String exc= "update students set book_id = NULL , date_of_issue = NULL  where student_id = "+Integer.parseInt(tfreturnstuid.getText());
						st.execute(exc);
						JOptionPane.showMessageDialog(null,"Book Returned");
						tfreturnstuid.setText(null);
						tfreturnbookid.setText(null);
					}
					else  JOptionPane.showMessageDialog(null,"Wrong details");
					con.close();
				}
				catch(Exception p) 
				{
					System.out.println(p);
				}
			}
		});
		returnreturn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		returnreturn.setBounds(276, 303, 131, 37);
		Opreturn.add(returnreturn);
		
		JButton btnadd = new JButton("Add Book");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				layeredPane.removeAll();
				layeredPane.add(Opadd);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnadd.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnadd.setBounds(36, 78, 156, 37);
		Operations.add(btnadd);
		
		JButton btnremove = new JButton("Remove Book");
		btnremove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				layeredPane.removeAll();
				layeredPane.add(Opremove);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnremove.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnremove.setBounds(36, 136, 156, 37);
		Operations.add(btnremove);
		
		JButton btnissue = new JButton("Issue Book");
		btnissue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				layeredPane.removeAll();
				layeredPane.add(Opissue);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnissue.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnissue.setBounds(36, 195, 156, 37);
		Operations.add(btnissue);
		
		JButton btnreturn = new JButton("Return Book");
		btnreturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				layeredPane.removeAll();
				layeredPane.add(Opreturn);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnreturn.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnreturn.setBounds(36, 253, 156, 37);
		Operations.add(btnreturn);
		
		JButton btnlogut = new JButton("Logout");
		btnlogut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnlogut.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnlogut.setBounds(36, 309, 156, 37);
		Operations.add(btnlogut);
		
		
	}
}

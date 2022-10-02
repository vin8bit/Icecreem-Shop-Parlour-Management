import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
public class Login extends JFrame implements ItemListener , ActionListener 
{

	String system="system";
	String systempass="system";
	Choice choice1;	
	JLabel userid,password;
	JTextField useridtf;
	JPasswordField passwordtf;
	JButton login,login2,exit,table;
	Statement stm;
	Connection con;
	ResultSet rs;
	String lib="Login Here";
	JPanel panel;
	public Login()
	{
		
		
		setIconImage(new ImageIcon("image/logo.png").getImage());
		setSize(450,330);
		setTitle("Ice-Cream Parlor");
		setLayout(null);
		setResizable(false);
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(0,0,600,400);
		JLabel label1=new JLabel("Ice-cream Parlour");
		label1.setLayout(null);
		label1.setBounds(60,20,500,60);
		label1.setForeground(Color.blue);
		Font font=new Font("Lucida Handwriting",Font.BOLD,30);
		label1.setFont(font);
		choice1=new Choice();
		choice1.add("Customer Login");
		choice1.add("Admin Login");
		choice1.setBounds(120,100,200,30);
		choice1.addItemListener(this);
		panel.add(choice1);
		userid= new JLabel("User ID :");
		userid.setLayout(null);
		userid.setBounds(80,150,100,20);
		panel.add(userid);
		password= new JLabel("User Password :");
		password.setLayout(null);
		password.setBounds(80,190,100,20);
		panel.add(password);
		useridtf= new JTextField(30);
		useridtf.setLayout(null);
		useridtf.setBounds(230,150,100,20);
		panel.add(useridtf);
		passwordtf= new JPasswordField(30);
		passwordtf.setBounds(230,190,100,20);
		passwordtf.setEchoChar('*');
		panel.add(passwordtf);
		login=new JButton("Login",new ImageIcon("image/login.png"));
		login.setLayout(null);
		login.setBounds(80,230,100,20);
		login.addActionListener(this);
		panel.add(login);
		exit=new JButton("Exit",new ImageIcon("image/exit.png"));
		exit.setLayout(null);
		exit.setBounds(230,230,100,20);
		exit.addActionListener(this);
		panel.add(exit);

		table=new JButton("Create Account");
		table.setBackground(Color.green);
		table.setLayout(null);
		//table.setBackground(new Color(5,194,250));
		table.setForeground(Color.red);
		table.setBounds(0,270,450,20);
		table.addActionListener(this);
		panel.setBackground(Color.pink);
		panel.add(table);
		
		panel.add(label1);
		
		add(panel);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void itemStateChanged(ItemEvent ie)
		{    if(ie.getItemSelectable()==choice1)
			{	lib=((Choice)ie.getItemSelectable()).getSelectedItem();
			    
			}
			
		  }
	
	public void actionPerformed(ActionEvent ea)
		{  
			char []c5=passwordtf.getPassword();
			String p5=String.valueOf(c5);
			
			int i=0,i1=0;
			if(ea.getSource()==exit)
			{  dispose(); }
			if(ea.getSource()==table)
			{ new CreateAccount(); dispose(); }
			
			if(ea.getSource()==login)
			{	String s1,s2;
			s1=useridtf.getText();
			s2=p5;
			if((s1.isEmpty())||(s2.isEmpty()))
			{ 
			      JOptionPane.showMessageDialog(this,"ID or Password is Empty","Details",JOptionPane.ERROR_MESSAGE);
			}
		 	else{ 
				if(ea.getSource()==login)
			{
				try
				{	if("Customer Login".equals(lib))
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",system,systempass);
						stm=con.createStatement();
						rs=stm.executeQuery("Select * from customer2");
							while (rs.next())
							{
								if(useridtf.getText().equals(rs.getString(1))&&p5.equals(rs.getString(3))&&("Customer Login".equals(lib)))
								{
									i=1;
									break;
								}
							}
							if(i==1){
						
							new Customer(s1);
							dispose();
							}
							else
							{             	
							
							JOptionPane.showMessageDialog(this," ID or Password Incorrect ","Details",JOptionPane.ERROR_MESSAGE);
							}
					}
					else
					{
							if("Admin Login".equals(lib))
							{
							Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",system,systempass);
							stm=con.createStatement();
							rs=stm.executeQuery("Select * from admin2");
							while (rs.next())
								{
									if(useridtf.getText().equals(rs.getString(1))&&p5.equals(rs.getString(2))&&("Admin Login".equals(lib)))
									{
									i1=1;
									break;
									}
								}
									if(i1==1)
									{
									new Admin();
									dispose();
									}
									else
									{
									JOptionPane.showMessageDialog(this," ID or Password Incorrect ","Details",JOptionPane.ERROR_MESSAGE);
									}
							}
					
							
							else
							{
							JOptionPane.showMessageDialog(this,"ID or Password Incorrect ","Details",JOptionPane.ERROR_MESSAGE);
							}
					}	
					
				
						
		
					
				}
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(this,"Data Base Conaction Error  "+e,"Details",JOptionPane.ERROR_MESSAGE);
				}
			}

				


			         }
		}
		}
public static void main(String []args)
	{     new Login();   }
}

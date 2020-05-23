import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.sql.*;

public class CreateAccount extends JFrame {

		JLabel bl1,bl2,bl3,bl4,bl5,bl6,bl7;
		JTextField bl1tf,bl2tf,bl3tf,bl4tf,bl5tf,bl6tf,bl7tf;
		JPasswordField ptf;
		CreateAccount obj;
		JTextArea ta;
		JButton submit,clear;
		java.time.LocalDateTime now = java.time.LocalDateTime.now();  
		java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format); 
		Connection con;
		PreparedStatement stm;
		Statement stm2;
		ResultSet rs2 ;
		String user="system";
		String pass="system";
		
		public CreateAccount(){
			Container container= getContentPane();
			JPanel p = new JPanel();
			obj=this;
			setIconImage(new ImageIcon("image/logo.png").getImage());
			setTitle("Ice-Cream Parlor");
			p.setLayout(null);
			setSize(600,600);
			JLabel tl=new JLabel("Create Account");
			Font font= new Font("Lucida Handwriting",Font.BOLD,20);
			tl.setForeground(Color.black);
			tl.setBounds(180,40,250,30);
			tl.setFont(font);
			p.add(tl);
			p.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Wellcome",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	
			
			bl1 = new JLabel("Customer ID :");
			bl1.setBounds(100,80,150,30);
			bl2 = new JLabel("Customer Name :");
			bl2.setBounds(100,120,150,30);
			bl3 = new JLabel("Password :");
			bl3.setBounds(100,160,150,30);
			bl4 = new JLabel("Date :");
			bl4.setBounds(100,200,150,30);
			bl5 = new JLabel("Phone no :");
			bl5.setBounds(100,240,150,30);
			bl6 = new JLabel("Address :");
			bl6.setBounds(100,280,150,30);

			bl1tf = new JTextField(150);
			try{
				Count1 gg= new Count1();
				int au=101+gg.call2();
				bl1tf.setText(String.valueOf(au));
			}catch(Exception c){}
	
			bl1tf.setBounds(250,80,150,25);
			bl2tf = new JTextField(150);
			bl2tf.setBounds(250,120,150,25);
			ptf = new JPasswordField(150);
			ptf.setBounds(250,160,150,25);
			bl4tf = new JTextField(150);
			bl4tf.setText(is);
			bl4tf.setBounds(250,200,150,25);
			JLabel label2 = new JLabel("DD-MM-YYYY");
			label2.setBounds(420,200,150,25);
			bl4tf.setEditable(false);
			bl5tf = new JTextField(150);
			bl5tf.setBounds(250,240,150,25);
			JLabel label = new JLabel("10 Digit only");
			label.setBounds(420,240,150,25);
			ta = new JTextArea();
			JScrollPane jscroll = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
			jscroll.setBounds(250,280,200,80);
			
			SubmitEvent se= new SubmitEvent();
			submit = new JButton("Submit",new ImageIcon("image/smile.png"));
			submit.setBounds(100,380,120,30);
			submit.addActionListener(se);
			clear = new JButton("Clear",new ImageIcon("image/clear.png"));
			clear.setBounds(250,380,120,30);
			clear.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(e.getSource()==clear){
						try{
							Count1 gg= new Count1();
							int au=101+gg.call2();
							bl1tf.setText(String.valueOf(au));
							}catch(Exception c){}	
						bl2tf.setText("");
						ptf.setText("");
						bl5tf.setText("");
						ta.setText("");
					}

				}
			});
			p.add(bl1);
			p.add(bl2);
			p.add(bl3);
			p.add(bl4);
			p.add(bl5);
			p.add(bl6);
		
			p.add(bl1tf);
			p.add(bl2tf);
			p.add(ptf);
			p.add(bl4tf);
			p.add(bl5tf);
			p.add(jscroll);
			p.add(submit);
			p.add(clear);
			p.add(label);
			p.add(label2);		
			container.add(p);
			setLocationRelativeTo(null);			
			setVisible(true);


		}

	private class SubmitEvent implements ActionListener {
				public void actionPerformed(ActionEvent e){
					if(e.getSource()==submit){
						int ch1=0;
						int ph1=0; int ph2=0;
						int pass1=0;
						String s1,s2,s3,s4,s5,s6;
						s1=bl1tf.getText(); 
				 		s2=bl2tf.getText();
				 		char []c5=ptf.getPassword();
						s3=String.valueOf(c5);
				 		s4=bl4tf.getText();
				 		s5=bl5tf.getText();
				 		s6=ta.getText();
						if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty())
						{    JOptionPane.showMessageDialog(obj,"Text Fields is empty","Error",JOptionPane.ERROR_MESSAGE); }
						else{
							try{
								Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm2=con.createStatement();
								rs2=stm2.executeQuery("Select * from customer2");
								while (rs2.next())
								{
									if(s1.equals(rs2.getString(1)))
									{
									ch1=1; 
									break;
									}
								} 
						   	    }catch(Exception eq){}

							for(int y2=0;y2<s1.length(); ++y2)
							{
								if(!Character.isDigit(s1.charAt(y2)))
									{ pass1=4; ph1=1;  }
							
							}
							for(int y1=0;y1<s5.length(); ++y1)
							{
						 		if(s5.length()<=9){ pass1=7; ph2=1; }
								if(!Character.isDigit(s5.charAt(y1)))
								{  pass1=7;  ph2=1;}
									if(s5.length()>10)
								{ pass1=7; ph2=1;  }
							}
						if(ch1==0){

						if(pass1==0){

							try { Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
							stm =  con.prepareStatement("insert into customer2 values(?,?,?,?,?,?)");
			                		stm.setString(1,s1);
							stm.setString(2,s2);
							stm.setString(3,s3);	
							stm.setString(4,s4);
							stm.setString(5,s5);
							stm.setString(6,s6);
							stm.executeUpdate();
							JOptionPane.showMessageDialog(obj,"Create acount Successful","Success",JOptionPane.INFORMATION_MESSAGE);
								new Login(); dispose();	
				 			try{
								Count1 gg= new Count1();
								int au=101+gg.call2();
								bl1tf.setText(String.valueOf(au));
								}catch(Exception ca){}	
							
							bl2tf.setText("");
							ptf.setText("");
							bl5tf.setText("");
							ta.setText("");
							con.close();

							}
						catch(Exception ek){ }

						}
						else{
							if(ph1==1){JOptionPane.showMessageDialog(obj,"Product ID or only Number accepted","Error",JOptionPane.ERROR_MESSAGE);}
								if(ph2==1){JOptionPane.showMessageDialog(obj,"Incorrect phone no","Error",JOptionPane.ERROR_MESSAGE);}
								

						}} 
						else{ JOptionPane.showMessageDialog(obj,"Customer ID already added","Error",JOptionPane.ERROR_MESSAGE); }

							
							
						}
						
											
	
					}
				}

		}

		public static void main(String []args){
			new CreateAccount();
		}
		
}
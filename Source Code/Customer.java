import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.regex.*;
import java.util.*;
import java.text.*;

public class Customer extends JFrame {
		JTabbedPane  tabbed;
		JPanel tabbedm1,tabbedm2,tabbedm3,tabbedm4,tabbedm5,tabbedm6;
		JTabbedPane tabbed2;
		JPanel a1,c1,log1,a4,a5;
		JTabbedPane tabbed3;
		JTabbedPane tabbed5;
		JTabbedPane tabbed6;
		JPanel b1,b2,b3,b4,b5;
		JLabel f1,f2,f3,f4,f5;
		JLabel bl1,bl2,bl3,bl4,bl5,bl6,bl8;
		JTextField bl1tf,bl2tf,bl3tf,bl4tf,bl5tf,bl6tf,bl8tf;
		JTextField bl1tf3,bl2tf3,bl3tf3,bl4tf3,bl5tf3,bl6tf3,bl7tf3,plus;
		JTextField bl1tf4,bl2tf4,bl3tf4,bl4tf4,bl5tf4,bl6tf4,bl7tf4;
		JTextField f1tf,f2tf,f3tf,f4tf;
		
		JButton p1,p2,image,image2;
		Customer obj;
		JTextArea ta;
		JTextArea ta5;
		Connection con;
		PreparedStatement stm;
		Statement stm2;
		ResultSet rs2 ;
		String user="system";
		String pass="system";
		String columns[]={"Product ID","Product Name","Image","Category","Quantity","price only 1","Description"};
		TableModel tmodel;
		JTable jtable;
		TableRowSorter<TableModel> rsorter;
		int i=0,k=0,l=0,p=0,y=0,j=0,y2=0,j2=0;
		Count1 count=new Count1();
		int g=10+count.call();
		Object array[][] = new Object[g][10];
		JButton search1;
		JTextField searchtf1;
		JButton order,clear;
		JButton get;
		String get1="0",get2,get3,get4,get5,get6,get7,imp;
		String dl2="";
		java.time.LocalDateTime now = java.time.LocalDateTime.now();  
		java.time.format.DateTimeFormatter format = java.time.format.DateTimeFormatter.ofPattern("dd-MM-yyyy");  
        	String is = now.format(format);  
		DateFormat time1 = new SimpleDateFormat("HH:mm:ss");
		Calendar cal = Calendar.getInstance();
		String tim=time1.format(cal.getTime());
		String total;
		JButton fsend,fclear;
		public Customer(String id) throws Exception{
			Container con= getContentPane();
			obj=this;
			setIconImage(new ImageIcon("image/logo.png").getImage());
			setTitle("Ice-Cream Parlor");
			setSize(830,630);
			tabbed = new JTabbedPane();
			tabbed.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed.setTabPlacement(JTabbedPane.TOP);
			tabbedm1= new JPanel();
			tabbedm2= new JPanel(); tabbedm2.setLayout(new BorderLayout());
			tabbedm3= new JPanel(); tabbedm3.setLayout(new BorderLayout());
			tabbedm4= new JPanel();
			tabbedm5= new JPanel(); tabbedm5.setLayout(new BorderLayout());
			tabbedm6= new JPanel(); tabbedm6.setLayout(new BorderLayout());
			tabbed.addTab("Home",new ImageIcon("image/home.png"),tabbedm1,"Home");
			tabbed.addTab("Order",new ImageIcon("image/order.png"),tabbedm2,"Order");
			tabbed.addTab("Ice Creem",new ImageIcon("image/ice.png"),tabbedm3,"Ice Creem");
			tabbed.addTab("Feedback",new ImageIcon("image/feed.png"),tabbedm5,"Feedback");
			tabbed.addTab("Logout",new ImageIcon("image/logout.png"),tabbedm6,"Log out");

			/////******Order Menu******/////
			tabbed2 = new JTabbedPane();
			tabbed2.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed2.setTabPlacement(JTabbedPane.LEFT);
			a1= new JPanel(); a1.setLayout(null);
			//a1.setBackground(new Color(255,0,255));
			tabbed2.addTab("Order Now",new ImageIcon("image/admin.gif"),a1,"Order Now");
			tabbedm2.add(tabbed2);
			
			/////******Product Menu******/////
			tabbed3 = new JTabbedPane();
			tabbed3.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed3.setTabPlacement(JTabbedPane.LEFT);
			b2= new JPanel(); b2.setLayout(new BorderLayout());
			
			tabbed3.addTab("View Product",new ImageIcon("image/admin.gif"),b2,"View Product");
			tabbedm3.add(tabbed3);
			
			/////******Feedback Menu******/////
			tabbed5 = new JTabbedPane();
			tabbed5.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed5.setTabPlacement(JTabbedPane.LEFT);
			c1= new JPanel(); c1.setLayout(null);
			tabbed5.addTab("Feedback",new ImageIcon("image/admin.gif"),c1,"Feedback");
			tabbedm5.add(tabbed5);


			/////******Logout Menu******/////
			tabbed6 = new JTabbedPane();
			tabbed6.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed6.setTabPlacement(JTabbedPane.LEFT);
			log1= new JPanel(); log1.setLayout(null);
			tabbed6.addTab("Logout",new ImageIcon("image/admin.gif"),log1,"Logout");
			tabbedm6.add(tabbed6);
			/////******Home Menu******/////
			JLabel main = new JLabel(new ImageIcon("image/main.gif"));
			tabbedm1.add(main);
			tabbedm1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	


			/////////////****************Order a1**********************/////////////////////


			JLabel tl=new JLabel("Order Now");
			Font font= new Font("Lucida Handwriting",Font.BOLD,20);
			tl.setForeground(Color.black);
			tl.setBounds(180,40,250,30);
			tl.setFont(font);
			a1.add(tl);
			a1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	
			bl1 = new JLabel("Customer ID :");
			bl1.setBounds(100,80,150,30);
			bl2 = new JLabel("Product ID :");
			bl2.setBounds(100,120,150,30);
			bl3 = new JLabel("Quantity :");
			bl3.setBounds(100,160,150,30);
			bl4 = new JLabel("Phone no :");
			bl4.setBounds(100,200,150,30);
			bl5 = new JLabel("Date :");
			bl5.setBounds(100,240,150,30);
			bl6 = new JLabel("Time :");
			bl6.setBounds(100,280,150,30);
			//bl7 = new JLabel("Total price :");
			//bl7.setBounds(100,320,150,30);
			bl8 = new JLabel("Address :");
			bl8.setBounds(100,320,150,30);

			JLabel label2 = new JLabel("DD-MM-YYYY");
			label2.setBounds(420,240,150,25);
			JLabel label5 = new JLabel("10 Digit only");
			label5.setBounds(420,200,150,25);
			JLabel label3 = new JLabel("24 Hour");
			label3.setBounds(420,280,150,25);
			JLabel label4 = new JLabel("==>");
			label4.setBounds(420,120,150,25);
			a1.add(label5);
			a1.add(label2);
			a1.add(label3);
			a1.add(label4);


			ta = new JTextArea();
			JScrollPane jscroll = new JScrollPane(ta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
			jscroll.setBounds(250,320,200,80);
			
			bl1tf = new JTextField(150);
			bl1tf.setText(id);
			bl1tf.setBounds(250,80,150,25);
			bl2tf = new JTextField(150);
			bl2tf.setBounds(250,120,150,25);
			bl3tf = new JTextField(150);
			bl3tf.setBounds(250,160,150,25);
			bl4tf = new JTextField(150);
			bl4tf.setBounds(250,200,150,25);
			bl5tf = new JTextField(150);
			bl5tf.setBounds(250,240,150,25);
			bl6tf = new JTextField(150);
			bl6tf.setBounds(250,280,150,25);
			
			//bl7tf = new JTextField(150);
			//bl7tf.setBounds(250,320,150,25);
			CheckEvent ck= new CheckEvent();
			get = new JButton("Get ID");
			get.setBounds(450,120,100,25);
			get.addActionListener(ck);
			a1.add(get);				
					

			CustomerEvent cv = new CustomerEvent();
			order = new JButton("Order",new ImageIcon("image/smile.png"));
			order.setBounds(100,440,120,30);
			order.addActionListener(cv);
			clear = new JButton("Clear",new ImageIcon("image/clear.png"));
			clear.setBounds(270,440,100,30);
			clear.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent re){
						if(re.getSource()==clear){
							bl2tf.setText("");
								bl3tf.setText("");
								bl4tf.setText("");
								ta.setText("");
								Calendar cal = Calendar.getInstance();
								tim=time1.format(cal.getTime());
								bl6tf.setText(tim);
						}
					}
			});			

			bl5tf.setText(is);
			bl6tf.setText(tim);
		
			a1.add(bl1);
			a1.add(bl2);
			a1.add(bl3);
			a1.add(bl4);
			a1.add(bl5);
			a1.add(bl6);
			a1.add(bl8);
			a1.add(bl1tf);
			a1.add(bl2tf);
			a1.add(bl3tf);
			a1.add(bl4tf);
			a1.add(bl5tf);
			a1.add(bl6tf);
			a1.add(jscroll);
			a1.add(order);
			a1.add(clear);
			
			bl1tf.setEditable(false);
			bl2tf.setEditable(false);
			bl5tf.setEditable(false);
			bl6tf.setEditable(false);




	
			///////************Feedback c1******************//////

			JLabel tl5=new JLabel("Feedback here");
			Font font5= new Font("Lucida Handwriting",Font.BOLD,20);
			tl5.setForeground(Color.black);
			tl5.setBounds(180,40,250,30);
			tl5.setFont(font5);
			c1.add(tl5);
			c1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Feedback",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	
			

			f1 = new JLabel("Customer ID :");
			f1.setBounds(100,80,150,30);
			f2 = new JLabel("Feedback Date :");
			f2.setBounds(100,120,150,30);
			f3 = new JLabel("Comment :");
			f3.setBounds(100,160,150,30);

			f1tf = new JTextField(150);
			f1tf.setText(id);
			f1tf.setEditable(false);
			f1tf.setBounds(250,80,150,25);
			f2tf = new JTextField(150);
			f2tf.setText(is);
			f2tf.setEditable(false);
			f2tf.setBounds(250,120,150,25);
			ta5 = new JTextArea();
			JScrollPane jscroll5 = new JScrollPane(ta5,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
			jscroll5.setBounds(250,160,200,80);
			SendEvent ss= new SendEvent();
			fsend = new JButton("Send",new ImageIcon("image/send.png"));
			fsend.addActionListener(ss);
			fclear = new JButton("clear",new ImageIcon("image/clear.png"));
			fsend.setBounds(100,270,100,30);
			fclear.setBounds(250,270,100,30);
			fclear.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ee){
					if(ee.getSource()==fclear){
						ta5.setText("");
					}
				}
			});
			c1.add(fsend);
			c1.add(fclear);
		
			c1.add(f1);
			c1.add(f2);
			c1.add(f3);
			c1.add(f1tf);
			c1.add(f2tf);
			c1.add(jscroll5);



			///////************Logout log1******************//////

			JLabel tl6=new JLabel("");
			Font font6= new Font("Lucida Handwriting",Font.BOLD,20);
			tl6.setForeground(Color.black);
			tl6.setBounds(180,40,250,30);
			tl6.setFont(font6);
			log1.add(tl6);
			log1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Logout",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	

			JButton logb= new JButton("Logout",new ImageIcon("image/sad.png"));
			logb.setRolloverIcon(new ImageIcon("image/sad2.png"));
			logb.setBounds(300,200,130,30);
			log1.add(logb);
			logb.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent g){
						if(g.getSource()==logb){
							new Login(); dispose();
						}
					}
			});


			
			
			/////****Product b2****/////
			
			JPanel b2p= new JPanel();
			searchtf1 = new JTextField(20);
			search1 = new JButton("Search",new ImageIcon("image/se.png"));
			b2.add(b2p,BorderLayout.NORTH);
			JLabel tl2=new JLabel("View Ice Creem");
			Font font2= new Font("Lucida Handwriting",Font.BOLD,20);
			tl2.setForeground(Color.black);
			tl2.setFont(font2);
			b2p.add(tl2);
			b2p.add(searchtf1);
			b2p.add(search1);
			JButton refresh= new JButton("Refresh",new ImageIcon("image/refresh.png"));
			refresh.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent rf){
						if(rf.getSource()==refresh){
							try{
							new Customer(id);dispose(); }catch(Exception t){}
						}
				}
			});
			b2.add(refresh,BorderLayout.SOUTH);
			b2.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));
			search1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent sb){
					if(sb.getSource()==search1){ 
					String text=searchtf1.getText();
						if(text.length()==0){
						     rsorter.setRowFilter(null);
						  }
						rsorter.setRowFilter(RowFilter.regexFilter(text));
					}
				}
			});

			try
			{
			
	
			 	Class.forName("oracle.jdbc.driver.OracleDriver");
		            	Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			 	Statement stm3= con1.createStatement(); 
			 	ResultSet rs3= stm3.executeQuery("SELECT *  FROM product");	
				
			 	while(rs3.next())
			 	{   JLabel label = new JLabel();
					label.setIcon(new ImageIcon((String)rs3.getObject("N3")));
				array[i++][0]=rs3.getObject("N1");
				array[k++][1]=rs3.getObject("N2");
				array[l++][2]=label;
				array[p++][3]=rs3.getObject("N4");
				array[y++][4]=rs3.getObject("N5");
				array[j++][5]=rs3.getObject("N6");
				array[y2++][6]=rs3.getObject("N7");
				} 	
				con1.close();
			}catch(SQLException e){
			   	JOptionPane.showMessageDialog(this,e,"Success",JOptionPane.INFORMATION_MESSAGE);
			 } 
			tmodel= new DefaultTableModel(array,columns);
			jtable=new JTable(tmodel);
			jtable.getColumn("Image").setCellRenderer(new LabelRenderer());
			jtable.setCellSelectionEnabled(true);
			jtable.setColumnSelectionAllowed(false);
			rsorter = new TableRowSorter<TableModel>(tmodel);
			JScrollPane jspane=new JScrollPane(jtable);
			jtable.setRowSorter(rsorter);
			b2.add(jspane,BorderLayout.CENTER);

			
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			con.add(tabbed);
			setLocationRelativeTo(null);
			setVisible(true);
			
		}
	class LabelRenderer implements TableCellRenderer{
		public Component getTableCellRendererComponent(JTable jtable,Object value,boolean isSelected,boolean hasFocus,int row,int column){
			TableColumn tc = jtable.getColumn("Image");
			tc.setMinWidth(100);
			tc.setMaxWidth(100);
			jtable.setRowHeight(100);
			return (Component) value;
		}

	}

	//////////////*************Send event****************/////////////////

		private class SendEvent implements ActionListener{
				public void actionPerformed(ActionEvent se){
					if(se.getSource()==fsend){

						String s1,s2,s3;
					s1=f1tf.getText();
					s2=f2tf.getText();
					s3=ta5.getText();						
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()){
					JOptionPane.showMessageDialog(obj,"Text fields is empty","Error",JOptionPane.ERROR_MESSAGE);
					}
					else{
						try{ Class.forName("oracle.jdbc.driver.OracleDriver");
								con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm =  con.prepareStatement("insert into feedback values(?,?,?)");
			                			stm.setString(1,s1);
								stm.setString(2,s2);
								stm.setString(3,s3);
								stm.executeUpdate();
								JOptionPane.showMessageDialog(obj,"Send successful","Success",JOptionPane.INFORMATION_MESSAGE);
																
								ta5.setText("");
								
								con.close();

							   }catch(Exception ek1){ }


					}

					}
				}
			

		}


	/////*****Check Product****//////
	

	private class CheckEvent implements ActionListener {
			public void actionPerformed(ActionEvent eg){
					if(eg.getSource()==get){
						int de=0;
						dl2=JOptionPane.showInputDialog(obj,"Enter Product ID");
						if(!dl2.isEmpty()){
								try{ Class.forName("oracle.jdbc.driver.OracleDriver");
			                               			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
									stm2=con.createStatement();
									rs2=stm2.executeQuery("Select N1 from product");
									while (rs2.next())
									{
										if(dl2.equals(rs2.getString(1)))
										{
											de=1; 
											break;
										}
									} 
									con.close();
								}catch(Exception ep){}
							if(de==1){ 

								try{	
					
									Class.forName("oracle.jdbc.driver.OracleDriver");
									con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
									stm2=con.createStatement();
									rs2= stm2.executeQuery("SELECT  *  FROM product WHERE N1="+dl2+" ");
						
									while(rs2.next())
									{
					
									bl2tf.setText(rs2.getString(1));
									get1=rs2.getString(1);
									get4=rs2.getString(2);
									get5=rs2.getString(3);
									get6=rs2.getString(4);
									get2=rs2.getString(5);
									get3=rs2.getString(6);
									get7=rs2.getString(7);
									
									
									}
									System.out.println(get1);
									System.out.println(get4);
									System.out.println(get5);
									System.out.println(get6);
									System.out.println(get2);
									System.out.println(get3);
									System.out.println(get7);
									con.close();
					
				          			    }catch(Exception p){JOptionPane.showMessageDialog(obj,p,"Error",JOptionPane.ERROR_MESSAGE);}


							}else{  JOptionPane.showMessageDialog(obj,"Product not found","Error",JOptionPane.ERROR_MESSAGE);}


						}else{ JOptionPane.showMessageDialog(obj,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
					
					}
			}
			
	
	}
	








	//////////////*************Customer Event*********************///////////////

	private class CustomerEvent implements ActionListener{
		
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==order){
					int error1=0; int error2=0; int error3=0;
					String s1,s2,s3,s4,s5,s6,s7,s8;
					s1=bl1tf.getText();
					s2=bl2tf.getText();
					s3=bl3tf.getText();
					s4=bl4tf.getText();
					s5=bl5tf.getText();
					s6=bl6tf.getText();
					//s7=bl7tf.getText();
					s8=ta.getText();						
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s8.isEmpty()){
					JOptionPane.showMessageDialog(obj,"Text fields is empty","Error",JOptionPane.ERROR_MESSAGE);
					
					}
					else{
						int pass1=0;
						int pass2=0;

												
						for(int y=0;y<s3.length(); ++y){
							if(!Character.isDigit(s3.charAt(y))){
						  		pass1=4;   error1=1;
							 }
						}
						for(int y1=0;y1<s4.length(); ++y1)
							{
						 		if(s4.length()<=9){ pass1=7; error2=1; }
								if(!Character.isDigit(s4.charAt(y1)))
								{  pass1=7;  error2=1;}
									if(s4.length()>10)
								{ pass1=7; error2=1;  }
							}
						
						int k=Integer.parseInt(get2);
						int k4=Integer.parseInt(get3);
						int k1=Integer.parseInt(s3);
						if(k1<=k){ pass2=1; }
						int k3=k-k1;
						int to=k1*k4;
						imp=String.valueOf(k3);
						total=String.valueOf(to);
						System.out.println(imp);
			
						if(pass1==0){
							if(pass2==1){
									try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      							String query = "delete from product where N1 = ?";
      							PreparedStatement preparedStmt = conn.prepareStatement(query);
      							preparedStmt.setString(1, s2);
      							preparedStmt.execute();
      							conn.close();
				   			} catch(Exception r){}

							try{ Class.forName("oracle.jdbc.driver.OracleDriver");
								con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm =  con.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
			                			stm.setString(1,get1);
								stm.setString(2,get4);
								stm.setString(3,get5);
								stm.setString(4,get6);
								stm.setString(5,imp);
								stm.setString(6,get3);
								stm.setString(7,get7);	
								stm.executeUpdate();
								con.close();

							   }catch(Exception ek){ }

							try{ Class.forName("oracle.jdbc.driver.OracleDriver");
								con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm =  con.prepareStatement("insert into order1 values(?,?,?,?,?,?,?)");
			                			stm.setString(1,s1);
								stm.setString(2,s2);
								stm.setString(3,s3);
								stm.setString(4,s4);
								stm.setString(5,s5);
								stm.setString(6,s6);
								stm.setString(7,s8);	
								stm.executeUpdate();
								JOptionPane.showMessageDialog(obj,"Order successful","Success",JOptionPane.INFORMATION_MESSAGE);
								new OrderReceipt(get4,s1,s2,s3,s4,s5,s6,total,s8,get5);
								
								bl2tf.setText("");
								bl3tf.setText("");
								bl4tf.setText("");
								ta.setText("");
								Calendar cal = Calendar.getInstance();
								tim=time1.format(cal.getTime());
								bl6tf.setText(tim);								

								con.close();

							   }catch(Exception ek1){ }


							
							
						
									
								}else{ JOptionPane.showMessageDialog(obj,"Quantity out of stock only "+get2,"Error",JOptionPane.ERROR_MESSAGE);}


						}else{
							if(error1==1){ JOptionPane.showMessageDialog(obj,"Quantity only number","Error",JOptionPane.ERROR_MESSAGE);}
							if(error2==1){ JOptionPane.showMessageDialog(obj,"Incorrect phone no","Error",JOptionPane.ERROR_MESSAGE);}
						}
					
					}
					
		
				}
						
					
			}
	
	
	} 

	






	public static void main(String []args) throws Exception{
		//new Customer(String s="");
	}


}
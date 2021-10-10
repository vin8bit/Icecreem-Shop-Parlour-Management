import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.filechooser.*;
import javax.swing.border.*;
import java.sql.*;
import javax.swing.table.*;
import java.util.regex.*;

public class Admin extends JFrame {
		JTabbedPane  tabbed;
		JPanel tabbedm1,tabbedm2,tabbedm3,tabbedm4,tabbedm5,tabbedm6;
		JTabbedPane tabbed2;
		JPanel a1,a2,a3,a4,a5;
		JTabbedPane tabbed3;
		JTabbedPane tabbed4;
		JTabbedPane tabbed5;
		JTabbedPane tabbed6;
		JPanel b1,b2,b3,b4,b5;
		JPanel ct1,ct2,ct3;
		JPanel fd1,fd2,log1;
		JLabel bl1,bl2,bl3,bl4,bl5,bl6,bl7;
		JTextField bl1tf,bl2tf,bl3tf,bl4tf,bl5tf,bl6tf,bl7tf;
		JTextField bl1tf3,bl2tf3,bl3tf3,bl4tf3,bl5tf3,bl6tf3,bl7tf3,plus;
		JTextField bl1tf4,bl2tf4,bl3tf4,bl4tf4,bl5tf4,bl6tf4,bl7tf4;
		JComboBox box1;
		JComboBox box2;
		JButton p1,p2,image,image2;
		String stringbox="";
		String stringbox2="";
		Admin obj;
		int pass1=0,pass2=0;
		int error1,error2,error3;
		Connection con;
		PreparedStatement stm;
		Statement stm2;
		ResultSet rs2 ;
		String user="system";
		String pass="system";
		String columns[]={"Product ID","Product Name","Image","Category","Quantity","Price Only 1","Description"};
		TableModel tmodel;
		JTable jtable;
		TableRowSorter<TableModel> rsorter;

		String columns2[]={"Customer ID","Product ID","Quantity","Phone no","Date","Time","Address"};
		TableModel tmodel2;
		JTable jtable2;
		TableRowSorter<TableModel> rsorter2;

		String columns3[]={"Customer ID","Customer Name","Password","Date","Phone no","Address"};
		TableModel tmodel3;
		JTable jtable3;
		TableRowSorter<TableModel> rsorter3;

		String columns4[]={"Customer ID","Date","Comment"};
		TableModel tmodel4;
		JTable jtable4;
		TableRowSorter<TableModel> rsorter4;
		

		int i=0,k=0,l=0,p=0,y=0,j=0,y2=0,j2=0;
		int i2=0,k2=0,l2=0,p2a=0,y2a=0,j2a=0,y22=0,j22=0;
		int i3=0,k3=0,l3=0,p3=0,y3=0,j3=0,y23=0,j23=0;
		int i4=0,k4=0,l4=0,p4=0,y4=0,j4=0,y24=0,j24=0;
		Count1 count=new Count1();
		int g=10+count.call();
		Object array[][] = new Object[g][10];
		int g2=10+count.call3();
		Object array2[][] = new Object[g2][10];
		int g3=10+count.call4();
		Object array3[][] = new Object[g3][10];
		int g4=10+count.call5();
		Object array4[][] = new Object[g4][10];
		
		JButton search1;
		JTextField searchtf1;
		JButton search12;
		JTextField searchtf12;
		JButton search13;
		JTextField searchtf13;
		JButton search14;
		JTextField searchtf14;

		JButton updateb3,clearb3,getproduct;
		JButton deleteb4,clearb4,getproduct4;
		String dl;
		String dl2;
		JLabel delete1;
		JTextField delete1tf;
		JButton deleteb1;
		JLabel delete2;
		JTextField delete2tf;
		JButton deleteb2;
		JLabel delete3;
		JTextField delete3tf;
		JButton deleteb3;
	
		
		
		public Admin() throws Exception{


			
	
			Container con= getContentPane();
			obj=this;
			setSize(800,600);
			setTitle("Ice-Cream Parlor");
			setIconImage(new ImageIcon("image/logo.png").getImage());
			
			tabbed = new JTabbedPane();
			tabbed.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed.setTabPlacement(JTabbedPane.TOP);
			tabbedm1= new JPanel();
			tabbedm2= new JPanel(); tabbedm2.setLayout(new BorderLayout());
			tabbedm3= new JPanel(); tabbedm3.setLayout(new BorderLayout());
			tabbedm4= new JPanel(); tabbedm4.setLayout(new BorderLayout());
			tabbedm5= new JPanel(); tabbedm5.setLayout(new BorderLayout());
			tabbedm6= new JPanel();	tabbedm6.setLayout(new BorderLayout());
			tabbed.addTab("Home",new ImageIcon("image/home2.png"),tabbedm1,"Home");
			tabbed.addTab("Product",new ImageIcon("image/product.png"),tabbedm3,"Product");
			tabbed.addTab("Order",new ImageIcon("image/order2.png"),tabbedm2,"Order");
			tabbed.addTab("Customer",new ImageIcon("image/customer.png"),tabbedm4,"Customer");
			tabbed.addTab("Feedback",new ImageIcon("image/feed2.png"),tabbedm5,"Feedback");
			tabbed.addTab("Logout",new ImageIcon("image/logout.png"),tabbedm6,"Log Out");

			/////******Order Menu******/////
			tabbed2 = new JTabbedPane();
			tabbed2.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed2.setTabPlacement(JTabbedPane.LEFT);
			a1= new JPanel(); a1.setLayout(new BorderLayout());
			a2= new JPanel(); a2.setLayout(null);
			a3= new JPanel();
			a4= new JPanel();
			tabbed2.addTab("View Order",new ImageIcon("image/addp.png"),a1,"View Order");
			tabbed2.addTab("Delete Order",new ImageIcon("image/de.png"),a2,"Delete Order");
			
			tabbedm2.add(tabbed2);
			

			/////******Product Menu******/////
			tabbed3 = new JTabbedPane();
			tabbed3.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed3.setTabPlacement(JTabbedPane.LEFT);
			b1= new JPanel(); b1.setLayout(null);
			b2= new JPanel(); b2.setLayout(new BorderLayout());
			b3= new JPanel(); b3.setLayout(null);
			b4= new JPanel(); b4.setLayout(null);
			tabbed3.addTab("Add Product",new ImageIcon("image/addp.png"),b1,"Add Product");
			tabbed3.addTab("View Product",new ImageIcon("image/viewice.png"),b2,"View Product");
			tabbed3.addTab("Update Product",new ImageIcon("image/get.png"),b3,"Update Product");
			tabbed3.addTab("Delete Product",new ImageIcon("image/de.png"),b4,"Delete Product");
			tabbedm3.add(tabbed3);

			/////******Customer Menu******/////
			tabbed4 = new JTabbedPane();
			tabbed4.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed4.setTabPlacement(JTabbedPane.LEFT);
			ct1= new JPanel(); ct1.setLayout(new BorderLayout());
			ct2= new JPanel(); ct2.setLayout(null);
			tabbed4.addTab("View Customer",new ImageIcon("image/smile.png"),ct1,"View Customer");
			tabbed4.addTab("Delete Customer",new ImageIcon("image/de1.png"),ct2,"Delete Customer");
			tabbedm4.add(tabbed4);
			

			/////******Feedback Menu******/////
			tabbed5 = new JTabbedPane();
			tabbed5.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
			tabbed5.setTabPlacement(JTabbedPane.LEFT);
			fd1= new JPanel(); fd1.setLayout(new BorderLayout());
			fd2= new JPanel(); fd2.setLayout(null);
			tabbed5.addTab("View Feedback",new ImageIcon("image/send.png"),fd1,"View Feedback");
			tabbed5.addTab("Delete Feedback",new ImageIcon("image/de.png"),fd2,"Delete Feedback");
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
	
			
		

			
			///***Product b1***///
			JLabel tl=new JLabel("Add New Product");
			Font font= new Font("Lucida Handwriting",Font.BOLD,20);
			tl.setForeground(Color.black);
			tl.setBounds(180,40,250,30);
			tl.setFont(font);
			b1.add(tl);
			b1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	
			bl1 = new JLabel("Product ID :");
			bl1.setBounds(100,80,150,30);
			bl2 = new JLabel("Product Name :");
			bl2.setBounds(100,120,150,30);
			bl3 = new JLabel("Image :");
			bl3.setBounds(100,160,150,30);
			bl4 = new JLabel("Category type :");
			bl4.setBounds(100,200,150,30);
			bl5 = new JLabel("Quantity :");
			bl5.setBounds(100,240,150,30);
			bl6 = new JLabel("Price :");
			bl6.setBounds(100,280,150,30);
			bl7 = new JLabel("Description :");
			bl7.setBounds(100,320,150,30);
			bl1tf = new JTextField(150);
			try{
			Count1 gg= new Count1();
			int au=201+gg.call();
			bl1tf.setText(String.valueOf(au));
			}
			catch(Exception c){}
			bl1tf.setBounds(250,80,150,25);
			bl2tf = new JTextField(150);
			bl2tf.setBounds(250,120,150,25);
			bl3tf = new JTextField(150);
			bl3tf.setEditable(false);
			bl3tf.setBounds(250,160,150,25);
			bl5tf = new JTextField(150);
			bl5tf.setBounds(250,240,150,25);
			bl6tf = new JTextField(150);
			bl6tf.setBounds(250,280,150,25);
			
			bl7tf = new JTextField(150);
			bl7tf.setBounds(250,320,150,25);
			box1 = new JComboBox();
			box1.setBounds(250,200,150,25);
			box1.addItem("");
			box1.addItem("Faludas");
			box1.addItem("Sodas");
			box1.addItem("Classics");
			box1.addItem("Kulfis");
			box1.addItem("Cassatas");
			box1.addItem("Exotic flavours");
			box1.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent i){
					if(i.getStateChange()==ItemEvent.SELECTED){
						stringbox=(String) i.getItem();
						System.out.println(stringbox);
					}
				}
			});
			image = new JButton("File Chooser",new ImageIcon("image/im.png"));
			image.setBounds(420,160,150,30);
			b1.add(image);
			image.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent im){
					if(im.getSource()==image){
						JFileChooser chooser = new JFileChooser();
						int result = chooser.showOpenDialog(obj);
						File file= chooser.getSelectedFile();
						if(result==JFileChooser.APPROVE_OPTION){
							bl3tf.setText(file.getPath());
						}
					}
				
				}
			});

			ProductEvent pe= new ProductEvent();
			p1= new JButton("Add Product",new ImageIcon("image/add.png"));
			p2= new JButton("Clear",new ImageIcon("image/clear.png"));
			p1.setBounds(100,380,140,30);			
			p2.setBounds(280,380,100,30);
			p1.addActionListener(pe);
			p2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent x){
					if(x.getSource()==p2){
						try{
						Count1 gg= new Count1();
						int au=201+gg.call();
						bl1tf.setText(String.valueOf(au));
						}
						catch(Exception c){}
						bl2tf.setText("");
						bl3tf.setText("");
						bl5tf.setText("");
						bl6tf.setText("");
						bl7tf.setText("");
						box1.setSelectedIndex(0);
					}
				}
			});

			b1.add(bl1);
			b1.add(bl2);
			b1.add(bl3);
			b1.add(bl4);
			b1.add(bl5);
			b1.add(bl6);
			b1.add(bl7);
			b1.add(bl1tf);
			b1.add(bl2tf);
			b1.add(bl3tf);
			b1.add(bl5tf);
			b1.add(bl6tf);
			b1.add(bl7tf);
			b1.add(box1);
			b1.add(p1);
			b1.add(p2);


			///////************Logout log1******************//////

			JLabel tl66=new JLabel("");
			Font font9= new Font("Lucida Handwriting",Font.BOLD,20);
			tl66.setForeground(Color.black);
			tl66.setBounds(180,40,250,30);
			tl66.setFont(font9);
			log1.add(tl66);
			log1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Logout",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	

			JButton logb= new JButton("Logout",new ImageIcon("image/sad.png"));
			
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
			JLabel tl2=new JLabel("View Products");
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
							new Admin();dispose(); }catch(Exception t){}
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
			jtable.setColumnSelectionAllowed(true);
			rsorter = new TableRowSorter<TableModel>(tmodel);
			JScrollPane jspane=new JScrollPane(jtable);
			jtable.setRowSorter(rsorter);
			b2.add(jspane,BorderLayout.CENTER);




			/////****Order a1****/////



			try
			{
			
	
			 	Class.forName("oracle.jdbc.driver.OracleDriver");
		            	Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			 	Statement stm3= con1.createStatement(); 
			 	ResultSet rs3= stm3.executeQuery("SELECT *  FROM order1");	
				
			 	while(rs3.next())
			 	{   
				array2[i2++][0]=rs3.getObject("O1");
				array2[k2++][1]=rs3.getObject("O2");
				array2[l2++][2]=rs3.getObject("O3");
				array2[p2a++][3]=rs3.getObject("O4");
				array2[y2a++][4]=rs3.getObject("O5");
				array2[j2a++][5]=rs3.getObject("O6");
				array2[y22++][6]=rs3.getObject("O7");
				} 	
				con1.close();
			}catch(SQLException e){
			   	JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.INFORMATION_MESSAGE);
			 } 




			
			JPanel b2p2= new JPanel();
			searchtf12 = new JTextField(20);
			search12 = new JButton("Search",new ImageIcon("image/se.png"));
			a1.add(b2p2,BorderLayout.NORTH);
			JLabel tl22=new JLabel("View Orders");
			Font font22= new Font("Lucida Handwriting",Font.BOLD,20);
			tl22.setForeground(Color.black);
			tl22.setFont(font22);
			b2p2.add(tl22);
			b2p2.add(searchtf12);
			b2p2.add(search12);
			JButton refresh2= new JButton("Refresh",new ImageIcon("image/refresh.png"));
			refresh2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent rf){
						if(rf.getSource()==refresh2){
							try{
							new Admin();dispose(); }catch(Exception t){}
						}
				}
			});
			a1.add(refresh2,BorderLayout.SOUTH);
			a1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));
			search12.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent sb){
					if(sb.getSource()==search12){ 
					String text2=searchtf12.getText();
						if(text2.length()==0){
						     rsorter2.setRowFilter(null);
						  }
						rsorter2.setRowFilter(RowFilter.regexFilter(text2));
					}
				}
			});

			tmodel2= new DefaultTableModel(array2,columns2);
			jtable2=new JTable(tmodel2);
			rsorter2 = new TableRowSorter<TableModel>(tmodel2);
			JScrollPane jspane2=new JScrollPane(jtable2);
			jtable2.setRowSorter(rsorter2);
			a1.add(jspane2,BorderLayout.CENTER);




			////////***********Order a2**************////////////
			
			JLabel tl6=new JLabel("Delete Order");
			Font font6= new Font("Lucida Handwriting",Font.BOLD,20);
			tl6.setForeground(Color.black);
			tl6.setBounds(180,40,250,30);
			tl6.setFont(font);
			a2.add(tl6);
			a2.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	
			delete1 = new JLabel("Customer ID :");
			delete1.setBounds(100,80,150,30);

			delete1tf = new JTextField();
			delete1tf.setBounds(250,80,150,25);
			DeleteOrder do1= new DeleteOrder();
			deleteb1 = new JButton("Delete",new ImageIcon("image/delete.png"));
			deleteb1.addActionListener(do1);
			deleteb1.setBounds(150,140,120,30);
			a2.add(delete1);
			a2.add(deleteb1);
			a2.add(delete1tf);
		



			/////****Customer ct1****/////



			try
			{
			
	
			 	Class.forName("oracle.jdbc.driver.OracleDriver");
		            	Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			 	Statement stm3= con1.createStatement(); 
			 	ResultSet rs3= stm3.executeQuery("SELECT *  FROM customer2");	
				
			 	while(rs3.next())
			 	{   
				array3[i3++][0]=rs3.getObject("c1");
				array3[k3++][1]=rs3.getObject("c2");
				array3[l3++][2]=rs3.getObject("c3");
				array3[p3++][3]=rs3.getObject("c4");
				array3[y3++][4]=rs3.getObject("c5");
				array3[j3++][5]=rs3.getObject("c6");
				} 	
				con1.close();
			}catch(SQLException e){
			   	JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.INFORMATION_MESSAGE);
			 } 




			
			JPanel b2p3= new JPanel();
			searchtf13 = new JTextField(20);
			search13 = new JButton("Search",new ImageIcon("image/se.png"));
			ct1.add(b2p3,BorderLayout.NORTH);
			JLabel tl23=new JLabel("View Customer");
			Font font23= new Font("Lucida Handwriting",Font.BOLD,20);
			tl23.setForeground(Color.black);
			tl23.setFont(font23);
			b2p3.add(tl23);
			b2p3.add(searchtf13);
			b2p3.add(search13);
			JButton refresh3= new JButton("Refresh",new ImageIcon("image/refresh.png"));
			refresh3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent rf){
						if(rf.getSource()==refresh3){
							try{
							new Admin();dispose(); }catch(Exception t){}
						}
				}
			});
			ct1.add(refresh3,BorderLayout.SOUTH);
			ct1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));
			search13.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent sb){
					if(sb.getSource()==search13){ 
					String text3=searchtf13.getText();
						if(text3.length()==0){
						     rsorter3.setRowFilter(null);
						  }
						rsorter3.setRowFilter(RowFilter.regexFilter(text3));
					}
				}
			});

			tmodel3= new DefaultTableModel(array3,columns3);
			jtable3=new JTable(tmodel3);
			rsorter3 = new TableRowSorter<TableModel>(tmodel3);
			JScrollPane jspane3=new JScrollPane(jtable3);
			jtable3.setRowSorter(rsorter3);
			ct1.add(jspane3,BorderLayout.CENTER);

			
			////////***********Customer ct2**************////////////
			
			JLabel tl7=new JLabel("Delete Customer");
			Font font7= new Font("Lucida Handwriting",Font.BOLD,20);
			tl7.setForeground(Color.black);
			tl7.setBounds(180,40,250,30);
			tl7.setFont(font7);
			ct2.add(tl7);
			ct2.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	
			delete2 = new JLabel("Customer ID :");
			delete2.setBounds(100,80,150,30);

			delete2tf = new JTextField();
			delete2tf.setBounds(250,80,150,25);
			DeleteOrder2 do2= new DeleteOrder2();
			deleteb2 = new JButton("Delete",new ImageIcon("image/delete.png"));
			deleteb2.addActionListener(do2);
			deleteb2.setBounds(150,140,120,30);
			ct2.add(delete2);
			ct2.add(deleteb2);
			ct2.add(delete2tf);




			/////****Feedback fd1****/////

			

			try
			{
			
	
			 	Class.forName("oracle.jdbc.driver.OracleDriver");
		            	Connection con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
			 	Statement stm3= con1.createStatement(); 
			 	ResultSet rs3= stm3.executeQuery("SELECT *  FROM feedback");	
				
			 	while(rs3.next())
			 	{   
				array4[i4++][0]=rs3.getObject("f1");
				array4[k4++][1]=rs3.getObject("f2");
				array4[l4++][2]=rs3.getObject("f3");
				} 	
				con1.close();
			}catch(SQLException e){
			   	JOptionPane.showMessageDialog(this,e,"Error",JOptionPane.INFORMATION_MESSAGE);
			 } 




			
			JPanel b2p4= new JPanel();
			searchtf14 = new JTextField(20);
			search14 = new JButton("Search",new ImageIcon("image/se.png"));
			fd1.add(b2p4,BorderLayout.NORTH);
			JLabel tl24=new JLabel("View Feedback");
			Font font24= new Font("Lucida Handwriting",Font.BOLD,20);
			tl24.setForeground(Color.black);
			tl24.setFont(font24);
			b2p4.add(tl24);
			b2p4.add(searchtf14);
			b2p4.add(search14);
			JButton refresh4= new JButton("Refresh",new ImageIcon("image/refresh.png"));
			refresh4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent rf){
						if(rf.getSource()==refresh4){
							try{
							new Admin();dispose(); }catch(Exception t){}
						}
				}
			});
			fd1.add(refresh4,BorderLayout.SOUTH);
			fd1.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));
			search14.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent sb){
					if(sb.getSource()==search14){ 
					String text4=searchtf14.getText();
						if(text4.length()==0){
						     rsorter4.setRowFilter(null);
						  }
						rsorter4.setRowFilter(RowFilter.regexFilter(text4));
					}
				}
			});

			tmodel4= new DefaultTableModel(array4,columns4);
			jtable4=new JTable(tmodel4);
			rsorter4 = new TableRowSorter<TableModel>(tmodel4);
			JScrollPane jspane4=new JScrollPane(jtable4);
			jtable4.setRowSorter(rsorter4);
			fd1.add(jspane4,BorderLayout.CENTER);



			////////***********Feedback fd2**************////////////
			
			JLabel tl8=new JLabel("Delete Feedback");
			Font font8= new Font("Lucida Handwriting",Font.BOLD,20);
			tl8.setForeground(Color.black);
			tl8.setBounds(180,40,250,30);
			tl8.setFont(font7);
			fd2.add(tl8);
			fd2.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
	
			delete3 = new JLabel("Customer ID :");
			delete3.setBounds(100,80,150,30);

			delete3tf = new JTextField();
			delete3tf.setBounds(250,80,150,25);
			DeleteOrder3 do3= new DeleteOrder3();
			deleteb3 = new JButton("Delete",new ImageIcon("image/delete.png"));
			deleteb3.addActionListener(do3);
			deleteb3.setBounds(150,140,120,30);
			fd2.add(delete3);
			fd2.add(deleteb3);
			fd2.add(delete3tf);










			/////****Product b3****/////
			
			JLabel tl3=new JLabel("Update Product");
			Font font3= new Font("Lucida Handwriting",Font.BOLD,20);
			tl3.setForeground(Color.black);
			tl3.setBounds(180,40,250,30);
			tl3.setFont(font3);
			b3.add(tl3);
			b3.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
				


			bl1 = new JLabel("Product ID :");
			bl1.setBounds(100,80,150,30);
			bl2 = new JLabel("Product Name :");
			bl2.setBounds(100,120,150,30);
			bl3 = new JLabel("Image :");
			bl3.setBounds(100,160,150,30);
			bl4 = new JLabel("Category type :");
			bl4.setBounds(100,200,150,30);
			bl5 = new JLabel("Quantity :");
			bl5.setBounds(100,240,150,30);
			bl6 = new JLabel("Price :");
			bl6.setBounds(100,280,150,30);
			bl7 = new JLabel("Description :");
			bl7.setBounds(100,320,150,30);
			bl1tf3 = new JTextField(150);
			bl1tf3.setBounds(250,80,150,25);
			bl2tf3 = new JTextField(150);
			bl2tf3.setBounds(250,120,150,25);
			bl3tf3 = new JTextField(150);
			bl3tf3.setBounds(250,160,150,25);
			bl4tf3 = new JTextField(150);
			bl4tf3.setBounds(250,200,150,25);
			bl5tf3 = new JTextField(150);
			bl5tf3.setBounds(250,240,150,25);
			bl6tf3 = new JTextField(150);
			bl6tf3.setBounds(250,280,150,25);
			JLabel plusl= new JLabel("+");
			Font fontl= new Font("Cooper",Font.BOLD,20);
			plusl.setFont(fontl);
			plusl.setBounds(420,240,100,25);
			plus = new JTextField(150);
			plus.setText("0");
			plus.setBounds(450,240,100,25);
			bl7tf3 = new JTextField(150);
			bl7tf3.setBounds(250,320,150,25);

			image2 = new JButton("File Chooser",new ImageIcon("image/im.png"));
			image2.setBounds(420,160,150,30);
			b3.add(image2);
			image2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent im){
					if(im.getSource()==image2){
						JFileChooser chooser = new JFileChooser();
						int result = chooser.showOpenDialog(obj);
						File file= chooser.getSelectedFile();
						if(result==JFileChooser.APPROVE_OPTION){
							bl3tf3.setText(file.getPath());
						}
					}
				
				}
			});
			
			box2 = new JComboBox();
			box2.setBounds(420,200,150,25);
			box2.addItem("");
			box2.addItem("Faludas");
			box2.addItem("Sodas");
			box2.addItem("Classics");
			box2.addItem("Kulfis");
			box2.addItem("Cassatas");
			box2.addItem("Exotic flavours");
			box2.addItemListener(new ItemListener(){
				public void itemStateChanged(ItemEvent i){
					if(i.getStateChange()==ItemEvent.SELECTED){
						bl4tf3.setText((String) i.getItem());
					}
				}
			});
		
			UpdateEvent1 up1= new UpdateEvent1();
			updateb3= new JButton("Update",new ImageIcon("image/add.png"));
			clearb3= new JButton("Clear",new ImageIcon("image/clear.png"));
			updateb3.setBounds(100,380,140,30);			
			clearb3.setBounds(280,380,100,30);
			updateb3.addActionListener(up1);
			clearb3.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent x){
					if(x.getSource()==clearb3){
						bl1tf3.setText("");
						bl2tf3.setText("");
						bl3tf3.setText("");
						bl4tf3.setText("");
						plus.setText("0");
						bl5tf3.setText("");
						bl6tf3.setText("");
						bl7tf3.setText("");
						box2.setSelectedIndex(0);
					}
				}
			});
			SearchEvent1 sr= new SearchEvent1();
			getproduct= new JButton("Get Product",new ImageIcon("image/get.png"));			
			getproduct.setBounds(420,380,150,30);
			getproduct.addActionListener(sr);		
			
			bl1tf3.setEditable(false);
			bl3tf3.setEditable(false);
			bl4tf3.setEditable(false);
			bl5tf3.setEditable(false);
			
			b3.add(bl1);
			b3.add(bl2);
			b3.add(bl3);
			b3.add(bl4);
			b3.add(bl5);
			b3.add(bl6);
			b3.add(bl7);
			
			b3.add(bl1tf3);
			b3.add(bl2tf3);
			b3.add(bl3tf3);
			b3.add(bl4tf3);
			b3.add(bl5tf3);
			b3.add(bl6tf3);
			b3.add(plus);
			b3.add(plusl);
			b3.add(bl7tf3);
			b3.add(box2);
			b3.add(updateb3);
			b3.add(clearb3);
			b3.add(getproduct);

			//////****************Product b4****************////////

			JLabel tl4=new JLabel("Delete Product");
			Font font4= new Font("Lucida Handwriting",Font.BOLD,20);
			tl4.setForeground(Color.black);
			tl4.setBounds(180,40,250,30);
			tl4.setFont(font4);
			b4.add(tl4);
			b4.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Sweet Icecreem",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
			

			bl1 = new JLabel("Product ID :");
			bl1.setBounds(100,80,150,30);
			bl2 = new JLabel("Product Name :");
			bl2.setBounds(100,120,150,30);
			bl3 = new JLabel("Image :");
			bl3.setBounds(100,160,150,30);
			bl4 = new JLabel("Category type :");
			bl4.setBounds(100,200,150,30);
			bl5 = new JLabel("Quantity :");
			bl5.setBounds(100,240,150,30);
			bl6 = new JLabel("Price :");
			bl6.setBounds(100,280,150,30);
			bl7 = new JLabel("Description :");
			bl7.setBounds(100,320,150,30);
			bl1tf4 = new JTextField(150);
			bl1tf4.setBounds(250,80,150,25);
			bl2tf4 = new JTextField(150);
			bl2tf4.setBounds(250,120,150,25);
			bl3tf4 = new JTextField(150);
			bl3tf4.setBounds(250,160,150,25);
			bl4tf4 = new JTextField(150);
			bl4tf4.setBounds(250,200,150,25);
			bl5tf4 = new JTextField(150);
			bl5tf4.setBounds(250,240,150,25);
			bl6tf4 = new JTextField(150);
			bl6tf4.setBounds(250,280,150,25);
			bl7tf4 = new JTextField(150);
			bl7tf4.setBounds(250,320,150,25);


			b4.add(bl1);
			b4.add(bl2);
			b4.add(bl3);
			b4.add(bl4);
			b4.add(bl5);
			b4.add(bl6);
			b4.add(bl7);
			b4.add(bl1tf4);
			b4.add(bl2tf4);
			b4.add(bl3tf4);
			b4.add(bl4tf4);
			b4.add(bl5tf4);
			b4.add(bl6tf4);
			b4.add(bl7tf4);
			
			bl1tf4.setEditable(false);
			bl2tf4.setEditable(false);
			bl3tf4.setEditable(false);
			bl4tf4.setEditable(false);
			bl5tf4.setEditable(false);
			bl6tf4.setEditable(false);
			bl7tf4.setEditable(false);

			DeleteEvent1 dv= new DeleteEvent1();
			deleteb4= new JButton("Delete Product",new ImageIcon("image/delete.png"));
			clearb4= new JButton("Clear",new ImageIcon("image/clear.png"));
			deleteb4.setBounds(100,380,160,30);			
			clearb4.setBounds(300,380,100,30);
			deleteb4.addActionListener(dv);
			clearb4.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent x){
					if(x.getSource()==clearb4){
						bl1tf4.setText("");
						bl2tf4.setText("");
						bl3tf4.setText("");
						bl4tf4.setText("");
						bl5tf4.setText("");
						bl6tf4.setText("");
						bl7tf4.setText("");
						
					}
				}
			});
			SearchEvent2 sr2= new SearchEvent2();
			getproduct4= new JButton("Get Product",new ImageIcon("image/get.png"));			
			getproduct4.setBounds(440,380,150,30);
			getproduct4.addActionListener(sr2);
					
			b4.add(deleteb4);
			b4.add(clearb4);
			b4.add(getproduct4);

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

		private class DeleteOrder implements ActionListener{
			public void actionPerformed(ActionEvent u1){
				if(u1.getSource()==deleteb1){
					String s1; int ch1=0; int ch2=0;
					s1=delete1tf.getText();
					
					if(s1.isEmpty()){
						JOptionPane.showMessageDialog(obj,"Text fields is empty","Error",JOptionPane.ERROR_MESSAGE);
					
					}
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
								con.close();
						   	    }catch(Exception eq){}

							if(ch1==1){
								try{
								Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm2=con.createStatement();
								rs2=stm2.executeQuery("Select * from order1");
								while (rs2.next())
								{
									if(s1.equals(rs2.getString(1)))
									{
									ch2=1; 
									break;
									}
								}
								con.close(); 
						   	    }catch(Exception eq){}
								if(ch2==1){

							try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      							String query = "delete from order1 where O1 = ?";
      							PreparedStatement preparedStmt = conn.prepareStatement(query);
      							preparedStmt.setString(1, s1);
      							preparedStmt.execute();
							JOptionPane.showMessageDialog(obj,"Delete Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							delete1tf.setText("");
							
						
      							conn.close();
				   			} catch(Exception r){}
							}else{ JOptionPane.showMessageDialog(obj,"Customer not order icecreem","Erro",JOptionPane.ERROR_MESSAGE);}	
						}else{ JOptionPane.showMessageDialog(obj,"Incorrect Customer ID","Erro",JOptionPane.ERROR_MESSAGE);}
							
																	
					}								

				}
			

			}
	}	



	private class DeleteOrder2 implements ActionListener{
			public void actionPerformed(ActionEvent u1){
				if(u1.getSource()==deleteb2){
					String s1; int ch1=0; int ch2=0;
					s1=delete2tf.getText();
					
					if(s1.isEmpty()){
						JOptionPane.showMessageDialog(obj,"Text Fields is Empty","Error",JOptionPane.ERROR_MESSAGE);
					
					}
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
								con.close();
						   	    }catch(Exception eq){}

							if(ch1==1){

							try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      							String query = "delete from customer2 where c1 = ?";
      							PreparedStatement preparedStmt = conn.prepareStatement(query);
      							preparedStmt.setString(1, s1);
      							preparedStmt.execute();
							JOptionPane.showMessageDialog(obj,"Delete Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							delete2tf.setText("");
							
						
      							conn.close();
				   			} catch(Exception r){}
								
						}else{ JOptionPane.showMessageDialog(obj,"Incorrect Customer ID","Erro",JOptionPane.ERROR_MESSAGE);}
							
																	
					}								

				}
			

			}
	}	



	
	private class DeleteOrder3 implements ActionListener{
			public void actionPerformed(ActionEvent u1){
				if(u1.getSource()==deleteb3){
					String s1; int ch1=0; int ch2=0;
					s1=delete3tf.getText();
					
					if(s1.isEmpty()){
						JOptionPane.showMessageDialog(obj,"Text Fields is Empty","Error",JOptionPane.ERROR_MESSAGE);
					
					}
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
								con.close();
						   	    }catch(Exception eq){}

							if(ch1==1){
								try{
								Class.forName("oracle.jdbc.driver.OracleDriver");
			                               		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm2=con.createStatement();
								rs2=stm2.executeQuery("Select * from feedback");
								while (rs2.next())
								{
									if(s1.equals(rs2.getString(1)))
									{
									ch2=1; 
									break;
									}
								}
								con.close(); 
						   	    }catch(Exception eq){}
								if(ch2==1){

							try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      							String query = "delete from feedback where f1 = ?";
      							PreparedStatement preparedStmt = conn.prepareStatement(query);
      							preparedStmt.setString(1, s1);
      							preparedStmt.execute();
							JOptionPane.showMessageDialog(obj,"Delete Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							delete3tf.setText("");
							
						
      							conn.close();
				   			} catch(Exception r){}
							}else{ JOptionPane.showMessageDialog(obj,"This Customer Not Send Feedback","Error",JOptionPane.ERROR_MESSAGE);}	
						}else{ JOptionPane.showMessageDialog(obj,"Incorrect Customer ID","Erro",JOptionPane.ERROR_MESSAGE);}
							
																	
					}								

				}
			

			}
	}	






		private class DeleteEvent1 implements ActionListener{
			public void actionPerformed(ActionEvent u1){
				if(u1.getSource()==deleteb4){
					String s1,s2,s3,s4,s5,s6,s7;
					s1=bl1tf4.getText();
					s2=bl2tf4.getText();
					s3=bl3tf4.getText();
					s4=bl4tf4.getText();
					s5=bl5tf4.getText();
					s6=bl6tf4.getText();
					s7=bl7tf4.getText();

					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s6.isEmpty()||s7.isEmpty()){
						JOptionPane.showMessageDialog(obj,"Text Fields is Empty","Error",JOptionPane.ERROR_MESSAGE);
					
					}
					else{
							try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      							String query = "delete from product where N1 = ?";
      							PreparedStatement preparedStmt = conn.prepareStatement(query);
      							preparedStmt.setString(1, s1);
      							preparedStmt.execute();
							JOptionPane.showMessageDialog(obj,"Delete Successful","Success",JOptionPane.INFORMATION_MESSAGE);
							bl1tf4.setText("");
							bl2tf4.setText("");
							bl3tf4.setText("");
							bl4tf4.setText("");
							bl5tf4.setText("");
							bl6tf4.setText("");
							bl7tf4.setText("");
						
      							conn.close();
				   			} catch(Exception r){}
							
																	
					}								

				}
			

			}
	}	

		






		/////*****Get Product Search for Delete****//////
	

	private class SearchEvent2 implements ActionListener {
			public void actionPerformed(ActionEvent eg){
					if(eg.getSource()==getproduct4){
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
					
									bl1tf4.setText(rs2.getString(1));
									bl2tf4.setText(rs2.getString(2));
									bl3tf4.setText(rs2.getString(3));
									bl4tf4.setText(rs2.getString(4));
									bl5tf4.setText(rs2.getString(5));
									bl6tf4.setText(rs2.getString(6));
									bl7tf4.setText(rs2.getString(7));
									
									}
									con.close();
					
				          			    }catch(Exception p){JOptionPane.showMessageDialog(obj,p,"Error",JOptionPane.ERROR_MESSAGE);}


							}else{  JOptionPane.showMessageDialog(obj,"Product not found","Error",JOptionPane.ERROR_MESSAGE);}


						}else{ JOptionPane.showMessageDialog(obj,"Textfield is Empty","Error",JOptionPane.ERROR_MESSAGE);}
					
					}
			}
			
	
	}
	

	/////*****Get Product Search for update*****//////

	private class SearchEvent1 implements ActionListener {
			public void actionPerformed(ActionEvent e){
					if(e.getSource()==getproduct){
						int de=0;
						dl=JOptionPane.showInputDialog(obj,"Enter Product ID");
						if(!dl.isEmpty()){
								try{ Class.forName("oracle.jdbc.driver.OracleDriver");
			                               			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
									stm2=con.createStatement();
									rs2=stm2.executeQuery("Select N1 from product");
									while (rs2.next())
									{
										if(dl.equals(rs2.getString(1)))
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
									rs2= stm2.executeQuery("SELECT  *  FROM product WHERE N1="+dl+" ");
						
									while(rs2.next())
									{
					
									bl1tf3.setText(rs2.getString(1));
									bl2tf3.setText(rs2.getString(2));
									bl3tf3.setText(rs2.getString(3));
									bl4tf3.setText(rs2.getString(4));
									bl5tf3.setText(rs2.getString(5));
									bl6tf3.setText(rs2.getString(6));
									bl7tf3.setText(rs2.getString(7));
									
									}
									con.close();
					
				          			    }catch(Exception p){JOptionPane.showMessageDialog(obj,p,"Error",JOptionPane.ERROR_MESSAGE);}


							}else{  JOptionPane.showMessageDialog(obj,"Product not found","Error",JOptionPane.ERROR_MESSAGE);}


						}else{ JOptionPane.showMessageDialog(obj,"Textfield is empty","Error",JOptionPane.ERROR_MESSAGE);}
					
					}
			}
			
	
	}

	///////////***************Product Update******************///////////////

	private class UpdateEvent1 implements ActionListener{
			public void actionPerformed(ActionEvent u1){
				if(u1.getSource()==updateb3){
					int op=0;
					int err1=0;
					int passb1=0;
					String s1,s2,s3,s4,s5,s6,s7,ps,ps2;
					ps2=bl5tf3.getText();
					s1=bl1tf3.getText();
					s2=bl2tf3.getText();
					s3=bl3tf3.getText();
					s4=bl4tf3.getText();
					String ps1=plus.getText();
					ps =ps1.replaceAll(" ","");
					
					if(ps.isEmpty()){ ps="0";}
					if(ps2.isEmpty()){ ps2="0";}
					for(int y=0;y<ps.length(); ++y){
							if(!Character.isDigit(ps.charAt(y))){
								op=1;						  		
							 }
						}
					if(op==1){ JOptionPane.showMessageDialog(obj,"Quantity textfiled 2 only number accepted","Error",JOptionPane.ERROR_MESSAGE); ps="";}

					s6=bl6tf3.getText();
					s7=bl7tf3.getText();
					int i= Integer.parseInt(ps);
					int j= Integer.parseInt(ps2);
					int t=i+j;
					s5=String.valueOf(t);
					System.out.println(s5);	
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s6.isEmpty()||s7.isEmpty()){
					JOptionPane.showMessageDialog(obj,"Text Fields is Empty","Error",JOptionPane.ERROR_MESSAGE);
					
					}
					else{
							for(int y2=0;y2<s6.length(); ++y2){
								if(!Character.isDigit(s6.charAt(y2))){
						  			passb1=4;   err1=1;
							 	}
							}

						if(passb1==0){
							try{
							Class.forName("oracle.jdbc.driver.OracleDriver");
							Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
      							String query = "delete from product where N1 = ?";
      							PreparedStatement preparedStmt = conn.prepareStatement(query);
      							preparedStmt.setString(1, s1);
      							preparedStmt.execute();
      							conn.close();
				   			} catch(Exception r){}
							
							try{ Class.forName("oracle.jdbc.driver.OracleDriver");
								con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm =  con.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
			                			stm.setString(1,s1);
								stm.setString(2,s2);
								stm.setString(3,s3);
								stm.setString(4,s4);
								stm.setString(5,s5);
								stm.setString(6,s6);
								stm.setString(7,s7);	
								stm.executeUpdate();
								JOptionPane.showMessageDialog(obj,"Update Success","Success",JOptionPane.INFORMATION_MESSAGE);
								bl1tf3.setText("");
								bl2tf3.setText("");
								bl3tf3.setText("");
								bl4tf3.setText("");
								plus.setText("0");
								bl5tf3.setText("");
								bl6tf3.setText("");
								bl7tf3.setText("");
								box2.setSelectedIndex(0);
								con.close();

							   }catch(Exception ek){ }
							

						}else{ if(err1==1){ JOptionPane.showMessageDialog(obj,"Incorrect Price","Error",JOptionPane.ERROR_MESSAGE); }}				
					}								

				}
			

			}
	}	

	////////////////******************Add Product********************/////////////////

	private class ProductEvent implements ActionListener{
		
			public void actionPerformed(ActionEvent e){
				if(e.getSource()==p1){
					error1=0; error2=0; error3=0;
					String s1,s2,s3,s4,s5,s6,s7;
					s1=bl1tf.getText();
					s2=bl2tf.getText();
					s3=bl3tf.getText();
					s4=stringbox;
					s5=bl5tf.getText();
					s6=bl6tf.getText();
					s7=bl7tf.getText();						
					if(s1.isEmpty()||s2.isEmpty()||s3.isEmpty()||s4.isEmpty()||s5.isEmpty()||s6.isEmpty()||s6.isEmpty()||s7.isEmpty()){
					JOptionPane.showMessageDialog(obj,"Text fields is empty","Error",JOptionPane.ERROR_MESSAGE);
					
					}
					else{
						pass1=0;
						pass2=0;

						try{
						Class.forName("oracle.jdbc.driver.OracleDriver");
			                        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
						stm2=con.createStatement();
						rs2=stm2.executeQuery("Select n1 from product");
							while (rs2.next())
							{
								if(s1.equals(rs2.getString(1)))
								{
									pass2=1; 
									break;
								}
							} 
						   }catch(Exception e3){}
												
						for(int y=0;y<s1.length(); ++y){
							if(!Character.isDigit(s1.charAt(y))){
						  		pass1=4;   error1=1;
							 }
						}
						for(int y1=0;y1<s5.length(); ++y1){
							if(!Character.isDigit(s5.charAt(y1))){
						  		pass1=4;   error2=1;
							 }
						}
						for(int y2=0;y2<s6.length(); ++y2){
							if(!Character.isDigit(s6.charAt(y2))){
						  		pass1=4;   error3=1;
							 }
						}

				if(pass2==0){
						if(pass1==0){
						
							try{ Class.forName("oracle.jdbc.driver.OracleDriver");
								con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",user,pass);
								stm =  con.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
			                			stm.setString(1,s1);
								stm.setString(2,s2);
								stm.setString(3,s3);	
								stm.setString(4,s4);
								stm.setString(5,s5);
								stm.setString(6,s6);
								stm.setString(7,s7);
	
								stm.executeUpdate();
								JOptionPane.showMessageDialog(obj,"Add Product successful","Success",JOptionPane.INFORMATION_MESSAGE);
								try{
								Count1 gg= new Count1();
								int au=201+gg.call();
								bl1tf.setText(String.valueOf(au));
								}catch(Exception c){}	
				 				bl2tf.setText("");
								bl3tf.setText("");
								box1.setSelectedIndex(0);
								bl5tf.setText("");
								bl6tf.setText("");
								bl7tf.setText("");
								con.close();

							}
						catch(Exception io){ }


						}else{
							if(error1==1){ JOptionPane.showMessageDialog(obj,"Incorrect product id","Error",JOptionPane.ERROR_MESSAGE);}
							if(error2==1){ JOptionPane.showMessageDialog(obj,"Incorrect Quantity","Error",JOptionPane.ERROR_MESSAGE);}
							if(error3==1){ JOptionPane.showMessageDialog(obj,"Incorrect Price","Error",JOptionPane.ERROR_MESSAGE);}
						}
					}else{JOptionPane.showMessageDialog(obj,"Product id already added","Error",JOptionPane.ERROR_MESSAGE);}
					}
					
		
				}
						
					
			}
	
	
	} 
	public static void main(String []args) throws Exception{
		new Admin();
	}


}

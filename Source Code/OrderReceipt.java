import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class OrderReceipt extends JFrame {
			
		JLabel bl1,bl2,bl3,bl4,bl5,bl6,bl7,bl8,bl9;
		JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
		public OrderReceipt(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10){
			
			
			Container con = getContentPane();
			setSize(560,600);
			setIconImage(new ImageIcon("image/logo.png").getImage());
			setTitle("Ice-Cream Parlor");
			JPanel p = new JPanel();
			p.setLayout(null);
			JLabel tl=new JLabel("Order Receipt");
			Font font= new Font("Lucida Handwriting",Font.BOLD,20);
			tl.setForeground(Color.black);
			tl.setBounds(180,40,250,30);
			tl.setFont(font);
			p.add(tl);
			p.setBorder(new TitledBorder(new LineBorder(new Color(0,162,232), 5),"Thank you",0,0,new Font("Segoe Script",Font.BOLD,20),new Color(0,162,232)));		
			
			bl1 = new JLabel("Ice creem name :");
			bl1.setBounds(100,80,150,30);
			bl2 = new JLabel("Customer id :");
			bl2.setBounds(100,120,150,30);
			bl3 = new JLabel("Product id :");
			bl3.setBounds(100,160,150,30);
			bl4 = new JLabel("Quantity :");
			bl4.setBounds(100,200,150,30);
			bl5 = new JLabel("Phone no :");
			bl5.setBounds(100,240,150,30);
			bl6 = new JLabel("Date :");
			bl6.setBounds(100,280,150,30);
			bl7 = new JLabel("Time :");
			bl7.setBounds(100,320,150,30);
			bl8 = new JLabel("Total price :");
			bl8.setBounds(100,360,150,30);
			bl9 = new JLabel("Address :");
			bl9.setBounds(100,400,150,30);
			p.add(bl1);
			p.add(bl2);
			p.add(bl3);
			p.add(bl4);
			p.add(bl5);
			p.add(bl6);
			p.add(bl7);
			p.add(bl8);
			p.add(bl9);

			l1 = new JLabel(s1);
			l1.setBounds(230,80,200,30);
			l2 = new JLabel(s2);
			l2.setBounds(230,120,150,30);
			l3 = new JLabel(s3);
			l3.setBounds(230,160,150,30);
			l4 = new JLabel(s4);
			l4.setBounds(230,200,150,30);
			l5 = new JLabel(s5);
			l5.setBounds(230,240,150,30);
			l6 = new JLabel(s6);
			l6.setBounds(230,280,200,30);
			l7 = new JLabel(s7);
			l7.setBounds(230,320,200,30);
			l8 = new JLabel(s8);
			l8.setBounds(230,360,150,30);
			l9 = new JLabel(s9);
			l9.setBounds(230,400,350,30);
			l10 = new JLabel(new ImageIcon(s10));
			l10.setBounds(350,80,150,150);
			p.add(l1);
			p.add(l2);
			p.add(l3);
			p.add(l4);
			p.add(l5);
			p.add(l6);
			p.add(l7);
			p.add(l8);
			p.add(l9);
			p.add(l10);
			con.add(p);
			setLocationRelativeTo(null);
			setVisible(true);
			
	

		}
	public static void main(String []args){
			//new OrderReceipt();
		}
}
//package src;

import javax.swing.*;
import java.awt.*;  

public class MainFrame {
	
	
		public static void main(String args[]) {
				JFrame frame= new JFrame("Hospital Management");
				
				JTextField t1,t2; 
				JLabel l1;
				l1=new JLabel("Login");
				l1.setBounds(600,50, 100,30);
			    t1=new JTextField("Welcome to Javatpoint.");  
			    t1.setBounds(50,100, 200,30);  
			    t2=new JTextField("AWT Tutorial");  
			    t2.setBounds(50,150, 200,30);  
			    frame.add(t1); frame.add(t2);frame.add(l1);  
			    frame.setLayout(null);
			    
				frame.setSize(1200, 780);
				frame.setVisible(true);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
}

//package src;

import java.awt.EventQueue;
import javax.mail.*;  
import javax.mail.internet.*;  
//import javax.activation.*; 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Patient_registration {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private String mess1;
	private JPasswordField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_registration window = new Patient_registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Patient_registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(1200,780);
		frame.setVisible(true);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {  
				Image img = Toolkit.getDefaultToolkit().getImage(  
				LoginWindow.class.getResource("/images/imgcovid.png"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
				} 
		};
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblPatientRegistration = new JLabel("Patient Registration");
		lblPatientRegistration.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		lblPatientRegistration.setBounds(601, 33, 396, 62);
		frame.getContentPane().add(lblPatientRegistration);
		
		textField = new JTextField();
		textField.setBounds(756, 200, 215, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(756, 269, 215, 26);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblPatientName.setBounds(601, 193, 143, 35);
		frame.getContentPane().add(lblPatientName);
		
		JLabel lblEmailaddress = new JLabel("Email_address");
		lblEmailaddress.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEmailaddress.setBounds(601, 258, 143, 42);
		frame.getContentPane().add(lblEmailaddress);
		
		JLabel lblEmailWillBe = new JLabel("Email will be set as user Id.");
		lblEmailWillBe.setForeground(Color.RED);
		lblEmailWillBe.setBounds(1008, 274, 162, 16);
		frame.getContentPane().add(lblEmailWillBe);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAge.setBounds(601, 361, 85, 41);
		frame.getContentPane().add(lblAge);
		
		textField_2 = new JTextField();
		textField_2.setBounds(756, 361, 215, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblLocationcity = new JLabel("Location/City");
		lblLocationcity.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblLocationcity.setBounds(601, 403, 143, 45);
		frame.getContentPane().add(lblLocationcity);
		
		textField_3 = new JTextField();
		textField_3.setBounds(756, 406, 215, 22);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBounds(758, 581, 97, 26);
		frame.getContentPane().add(btnNewButton);
		//btnNewButton.setEnabled(false);
		btnNewButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				try {
					
						String t1="Patient";
						String u1=textField_1.getText();
						String p1=textField_5.getText();
						Recordlogins r2=Recordlogins.getInstance();
						if(r2.setRecordlogins(t1, u1, p1)) {
							frame.dispose();
							new MessageWindow("Account Created Successfully!!!");
							//new LoginWindow();
						}
						
					
				}
				catch(Exception e1) {
					//
				}
				
				
			}
		});
		
		
		
		JLabel label = new JLabel("");
		label.setBounds(648, 651, 403, 22);
		frame.getContentPane().add(label);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblPassword.setBounds(601, 312, 143, 42);
		frame.getContentPane().add(lblPassword);
		
		textField_5 = new JPasswordField();
		textField_5.setBounds(756, 325, 215, 22);
		frame.getContentPane().add(textField_5);
		
		JButton btnLoginWindow = new JButton("Login Window");
		btnLoginWindow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new LoginWindow();
			}
		});
		btnLoginWindow.setBounds(954, 582, 123, 25);
		frame.getContentPane().add(btnLoginWindow);
		//
		
		//
	}
}

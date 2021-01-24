import java.awt.EventQueue;
import java.awt.event.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.SystemColor;

public class LoginWindow {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Recordlogins r1=Recordlogins.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginWindow() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hospital Management");
		frame.setSize(1200,780);
		//frame.setBounds(100, 100, 450, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblHospitalManagement = new JLabel("Hospital Management");
		lblHospitalManagement.setForeground(Color.BLUE);
		lblHospitalManagement.setFont(new Font("Times New Roman", Font.PLAIN, 48));
		//lblHospitalManagement.setBounds(589, 23, 478, 75);
		
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {  
				Random rand = new Random(); 
				int rand_int1 = rand.nextInt(3);
				if(rand_int1==0) {
					Image img = Toolkit.getDefaultToolkit().getImage(  
							LoginWindow.class.getResource("download.jpg"));  
							g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
							lblHospitalManagement.setBounds(280, 26, 478, 75);
				}
				else if(rand_int1==1) {
					Image img = Toolkit.getDefaultToolkit().getImage(  
							LoginWindow.class.getResource("download.png"));  
							g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
							lblHospitalManagement.setBounds(285, 93, 478, 75);
					
				}
				else {
				Image img = Toolkit.getDefaultToolkit().getImage(  
				LoginWindow.class.getResource("download.png"));  
				g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
				lblHospitalManagement.setBounds(589, 23, 478, 75);
				
			}
				} 
		};
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblLogin.setBounds(1039, 509, 80, 16);
		panel.add(lblLogin);
		
		JLabel lblUserId = new JLabel("User Id");
		lblUserId.setForeground(Color.BLUE);
		lblUserId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblUserId.setBounds(887, 540, 56, 16);
		panel.add(lblUserId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLUE);
		lblPassword.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblPassword.setBounds(887, 582, 86, 16);
		panel.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(1031, 538, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblLoginType = new JLabel("Login Type");
		lblLoginType.setBounds(219, 224, 27, -37);
		panel.add(lblLoginType);
		
		JLabel lblLoginType_1 = new JLabel("Login Type");
		lblLoginType_1.setForeground(Color.BLUE);
		lblLoginType_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblLoginType_1.setBounds(887, 636, 114, 16);
		panel.add(lblLoginType_1);
		
		String login[]={"Admin","Patient","Doctor","Donor"};        
	    JComboBox cb = new JComboBox(login);
		cb.setBounds(1033, 634, 114, 22);
		panel.add(cb);
		
		JLabel label1 = new JLabel("not matched");
		label1.setForeground(Color.RED);
		label1.setBounds(887, 714, 132, 16);
		panel.add(label1);
		
		panel.add(lblHospitalManagement);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.setBounds(1050, 661, 97, 25);
		panel.add(btnSignIn);
		btnSignIn.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				label1.setVisible(false);
				String t1=(String) cb.getSelectedItem();
				String u1=textField.getText();
				String p1=passwordField.getText();
				Recordlogins r2=Recordlogins.getInstance();
				if(r2.getRecordlogins(t1, u1, p1)) {
					//System.out.print("Login works correctly..\n");
					if(t1.equals("Admin")) {
						MaintainUser MU=MaintainUser.getInstance();
						MU.setUserName(u1);
					frame.dispose();
					new AdminWindow(u1);
					//System.out.println("called...");
					//new PatientPanel(u1);
					}
					else if(t1.equals("Patient")) {
						MaintainUser MU=MaintainUser.getInstance();
						MU.setUserName(u1);
						frame.dispose();
						new PatientPanel(u1);
					}
					else if(t1.equals("Donor")) {
						MaintainUser MU=MaintainUser.getInstance();
						MU.setUserName(u1);
						frame.dispose();
						new DonorPanel(); //change it later to DonorPanel window
					}
					else {
						label1.setText("No Match Found..");
						label1.setVisible(true);
					}
					
				}
				else {
					label1.setText("No Match Found..");
					label1.setVisible(true);
				}
				/*
				if(u1.equals("Admin") && p1.equals("123456")  ) {
					frame.dispose();
					new AdminWindow();
					}*/
				
				}  
			    });
		
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(1031, 591, 116, 22);
		panel.add(passwordField);
		
		
		
		JButton btnNewButton = new JButton("Patient_Registration");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setBounds(362, 634, 153, 25);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				frame.dispose();
				new Patient_registration();///
					
				}  
			    });
		
		JButton button = new JButton("Donor_Registration");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new DonorRegistration();
			}
		});
		button.setBackground(SystemColor.activeCaption);
		button.setBounds(527, 634, 153, 25);
		panel.add(button);
		label1.setVisible(false);
	}
}

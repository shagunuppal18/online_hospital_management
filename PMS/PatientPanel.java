//package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JMenuBar;

public class PatientPanel {

	private JFrame frame;
   private String username;
	private static String user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientPanel window = new PatientPanel(user);
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
	public PatientPanel(String u1) {
		username=u1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(1200,780);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPatientPanel = new JLabel("Patient Panel");
		lblPatientPanel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPatientPanel.setForeground(Color.RED);
		lblPatientPanel.setBounds(508, 52, 161, 34);
		frame.getContentPane().add(lblPatientPanel);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(44, 96, 56, 16);
		frame.getContentPane().add(lblWelcome);
		
		JLabel uName = new JLabel("");
		uName.setBounds(144, 96, 148, 16);
		frame.getContentPane().add(uName);
		MaintainUser MU=MaintainUser.getInstance();
		uName.setText(MU.getUserName());
		
		JLabel lblLoginTme = new JLabel("Login Tme");
		lblLoginTme.setBounds(44, 142, 110, 16);
		frame.getContentPane().add(lblLoginTme);
		
		JLabel logTime = new JLabel("");
		logTime.setBounds(144, 142, 182, 16);
		frame.getContentPane().add(logTime);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
		logTime.setText(formatter.format(date));
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBounds(1042, 75, 97, 25);
		frame.getContentPane().add(btnLogout);
		btnLogout.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new LoginWindow();
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(44, 212, 119, 26);
		frame.getContentPane().add(menuBar);
		
		JButton btnBookAAppointment = new JButton("Book An Appointment");
		btnBookAAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new BookAppointment(username);
			}
		});
		btnBookAAppointment.setBounds(57, 683, 195, 25);
		frame.getContentPane().add(btnBookAAppointment);
		
		JButton btnPendingAppointments = new JButton("Upcoming Appointments");
		btnPendingAppointments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new UpcomingAppoints();
			}
		});
		btnPendingAppointments.setBounds(279, 683, 182, 25);
		frame.getContentPane().add(btnPendingAppointments);
		
		JButton btnCompletedAppointments = new JButton("Completed Appointments");
		btnCompletedAppointments.setBounds(499, 683, 195, 25);
		frame.getContentPane().add(btnCompletedAppointments);
		
		JLabel lblPendingAppointments = new JLabel("Upcoming Appointments");
		lblPendingAppointments.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblPendingAppointments.setBounds(44, 294, 223, 25);
		frame.getContentPane().add(lblPendingAppointments);
		
		JLabel lblCompletedAppointments = new JLabel("Completed Appointments");
		lblCompletedAppointments.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblCompletedAppointments.setBounds(44, 400, 267, 25);
		frame.getContentPane().add(lblCompletedAppointments);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(44, 342, 56, 16);
		frame.getContentPane().add(lblStatus);
		
		JLabel label = new JLabel("Status");
		label.setBounds(44, 463, 56, 16);
		frame.getContentPane().add(label);
		
		JLabel lblNoRecordFound = new JLabel("No record Found");
		lblNoRecordFound.setBounds(112, 342, 833, 16);
		frame.getContentPane().add(lblNoRecordFound);
		
		System.out.println(username);
		//getting data from AppointmentDataRecord
		AppointmentDataRecord r1=AppointmentDataRecord.getInstance();
		HashMap<String, HashMap<String, HashMap<String,String>>> Data1=r1.getAppointRecord();
		String status1="";
		for (String i : Data1.keySet()) {
			Doctor d1=Doctor.getInstance();
			lblNoRecordFound.setText("<html>");
			status1=d1.getDoctorName(i.toString())+"/ ";
			  for(String j:Data1.get(i).keySet()) {
				  
					  
				
				  //System.out.println(j);
				  status1=status1+j+"/ "; 
				  for(String k:Data1.get(i).get(j).keySet()) {
					  //System.out.println(Data1.get(i).get(j).get(k));
					  System.out.println(Data1.get(i).get(j).get(k));
					  //MaintainUser MU1=MaintainUser.getInstance();
					  if(Data1.get(i).get(j).get(k).equals(MU.getUserName())) {
						  status1=status1+k;
						  lblNoRecordFound.setText(lblNoRecordFound.getText()+status1+"<br>");
						  //System.out.println((Data1.get(i).get(j).values()));
					  }
					  
					  
				  }
			  }
			  lblNoRecordFound.setText(lblNoRecordFound.getText()+"</html>");
			}
		
		JLabel label_1 = new JLabel("No record Found");
		label_1.setBounds(112, 463, 527, 16);
		frame.getContentPane().add(label_1);
		
		String status2="";
		for (String i : Data1.keySet()) {
			Doctor d1=Doctor.getInstance();
			label_1.setText("<html>");
			status2=d1.getDoctorName(i.toString())+"/ ";
			  for(String j:Data1.get(i).keySet()) {
				  
				  status2=status1+j+"/ "; 
				  for(String k:Data1.get(i).get(j).keySet()) {
					  //System.out.println(Data1.get(i).get(j).get(k));
					  System.out.println(Data1.get(i).get(j).get(k));
					  //MaintainUser MU1=MaintainUser.getInstance();
					  if(Data1.get(i).get(j).get(k).equals(MU.getUserName())) {
						  status1=status1+k;
						  label_1.setText(label_1.getText()+status1+"<br>");
						  //System.out.println((Data1.get(i).get(j).values()));
					  }
					  
					  
				  }
		        	
			  }
			  label_1.setText(label_1.getText()+"</html>");
			}
		RecordDepartment a1=new RecordDepartment();
		ArrayList<String> v1= a1.getDepartment();
		for(String v: v1){
			menuBar.add(new JMenu(v));
		}
		
	}
}

//package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class BookAppointment {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private Vector comboBoxItems;
	private String Uname;
	private static String user;
	private static String[] morningSlot= {"10:00-10:20","10:20-10:40","10:40-11:00","11:00-11:20","11:20-11:40","11:40-12:00","12:00-12:20","12:20-12:40","12:40-13:00","13:00-13:20","13:20-13:40","13:40-14:00"};
	private static String[] eveningSlot= {""};
	private String allotedSlot; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAppointment window = new BookAppointment(user);
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
	public BookAppointment(String u1) {
		comboBoxItems=new Vector();
	    RecordDepartment R=RecordDepartment.getInstance();
	    ArrayList<String> AL=R.getDepartment();
	    for(int i=0;i<AL.size();i++) {
	    	comboBoxItems.add(AL.get(i));
	    }
	    u1=Uname;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(600,800);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookAnAppointment = new JLabel("Book An Appointment");
		lblBookAnAppointment.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblBookAnAppointment.setBounds(237, 61, 201, 37);
		frame.getContentPane().add(lblBookAnAppointment);
		
		JLabel lblPatientName = new JLabel("Patient Name");
		lblPatientName.setBounds(91, 137, 114, 37);
		frame.getContentPane().add(lblPatientName);
		
		JLabel lblPatientEmail = new JLabel("Patient Email");
		lblPatientEmail.setBounds(91, 212, 114, 37);
		frame.getContentPane().add(lblPatientEmail);
		
		
		
		JLabel lblSelectDepartment = new JLabel("Select Department");
		lblSelectDepartment.setBounds(91, 266, 114, 37);
		frame.getContentPane().add(lblSelectDepartment);
		
		final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		
		JComboBox comboBox = new JComboBox(model);
		comboBox.setBounds(272, 273, 120, 22);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(272, 219, 116, 22);
		frame.getContentPane().add(textField);
		MaintainUser MU=MaintainUser.getInstance();
		textField.setText(MU.getUserName());
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(272, 144, 116, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(91, 332, 114, 37);
		frame.getContentPane().add(lblDate);
		
		JLabel lblSelectTimeSlot = new JLabel("Select time slot");
		lblSelectTimeSlot.setBounds(91, 382, 114, 37);
		frame.getContentPane().add(lblSelectTimeSlot);
		
		JLabel lblShowDoctor = new JLabel("Show Doctor");
		lblShowDoctor.setBounds(91, 432, 114, 37);
		frame.getContentPane().add(lblShowDoctor);
		
		
		
		String slot[]= {"10:00-2:00","3:00-7:00"};
		JComboBox comboBox_1 = new JComboBox(slot);
		comboBox_1.setBounds(272, 389, 120, 22);
		frame.getContentPane().add(comboBox_1);
		
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(272, 439, 120, 22);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnSubmit = new JButton("Book");
		
		btnSubmit.setBounds(166, 553, 97, 25);
		frame.getContentPane().add(btnSubmit);
		btnSubmit.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(110, 644, 366, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnBackToMain = new JButton("Back To Main Window");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PatientPanel(Uname);
			}
		});
		btnBackToMain.setBounds(305, 553, 171, 25);
		frame.getContentPane().add(btnBackToMain);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(124, 712, 56, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(272, 339, 120, 22);
		frame.getContentPane().add(comboBox_3);
		
		JButton btnCheckAvailabilty = new JButton("Check Availabilty");
		btnCheckAvailabilty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//record selected department
				//record doctor id
				//record time slot
				//record date
				String DocId=(String) comboBox_2.getSelectedItem();
				String dept=(String) comboBox.getSelectedItem();
				String timeSlot=(String) comboBox_1.getSelectedItem();
				String date1=(String) comboBox_3.getSelectedItem();
				allotedSlot="00";
				AppointmentDataRecord ADR1=AppointmentDataRecord.getInstance();
				try {
				String slot1= ADR1.getAvailableSlot(DocId, dept, timeSlot, date1);
				System.out.println("Alloted slot : "+slot1);
				if(slot1.equals("Not Available")) {
					
					btnSubmit.setVisible(false);
				}
				else {	
					allotedSlot=slot1;
					btnSubmit.setVisible(true);
				}
				}
				catch(Exception e1) {
					System.out.println(DocId+dept+timeSlot+date1);
					System.out.println(e1);
				}
				
			}
		});
		btnCheckAvailabilty.setBounds(272, 491, 166, 25);
		frame.getContentPane().add(btnCheckAvailabilty);
		frame.setVisible(true);
		
		//Date date=java.util.Calendar.getInstance().getTime(); 
		//int date1= date.getDate();
		
		Date date=new Date();
	    Calendar calendar = Calendar.getInstance();
	    date=calendar.getTime(); 
	    SimpleDateFormat s;
	    s=new SimpleDateFormat("MM/dd/yy");
	    
	   int days = 5;
	    for(int i=0;i<days;)
	    {
	        calendar.add(Calendar.DAY_OF_MONTH, 1);
	        //here even sat and sun are added
	        //but at the end it goes to the correct week day.
	        //because i is only increased if it is week day
	        if(calendar.get(Calendar.DAY_OF_WEEK)<=6)
	        {
	        	date=calendar.getTime(); 
	        	SimpleDateFormat  s1=new SimpleDateFormat("MMM dd, yyyy");
	    	    //System.out.println(s1.format(date));
	        	String d3=s1.format(date);
	        	comboBox_3.addItem(d3);
	        	i++;
	        }
	        
	    }
	    
		Doctor d1=Doctor.getInstance();
		ArrayList<DoctorFields> DF=d1.getDoctorrecord();
		for(int j=0;j<DF.size();j++) {
			System.out.println("Doctor Name: "+DF.get(j).name);
			if(comboBox.getSelectedItem().toString().equals(DF.get(j).dept)) {
				comboBox_2.addItem(DF.get(j).name.toString());
			}
			
		}
		comboBox.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	comboBox_2.removeAllItems();
		    	btnSubmit.setVisible(false);
		    	Doctor d1=Doctor.getInstance();
				ArrayList<DoctorFields> DF=d1.getDoctorrecord();
				for(int j=0;j<DF.size();j++) {
					//System.out.println("Doctor Name: "+DF.get(j).name);
					if(comboBox.getSelectedItem().toString().equals(DF.get(j).dept) && comboBox_1.getSelectedItem().toString().equals(DF.get(j).slot)) {
						comboBox_2.addItem(DF.get(j).name.toString());
					}
					
				}
		    	
		    }
		});
		comboBox_2.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	btnSubmit.setVisible(false);
		    }
		});
		comboBox_3.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	btnSubmit.setVisible(false);
		    }
		});
		
		comboBox_1.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	comboBox_2.removeAllItems();
		    	btnSubmit.setVisible(false);
		    	Doctor d1=Doctor.getInstance();
				ArrayList<DoctorFields> DF=d1.getDoctorrecord();
				for(int j=0;j<DF.size();j++) {
					//System.out.println("Doctor Name: "+DF.get(j).name);
					if(comboBox.getSelectedItem().toString().equals(DF.get(j).dept) && comboBox_1.getSelectedItem().toString().equals(DF.get(j).slot)) {
						comboBox_2.addItem(DF.get(j).name.toString());
					}
					
				}
		    	
		    }
		});
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String DocId=(String) comboBox_2.getSelectedItem();
				String dept=(String) comboBox.getSelectedItem();
				String timeSlot=(String) comboBox_1.getSelectedItem();
				String date1=(String) comboBox_3.getSelectedItem();
				//allotedSlot="00";
				AppointmentDataRecord ADR1=AppointmentDataRecord.getInstance();
				
				if(ADR1.bookAppoint(DocId,date1,allotedSlot,textField.getText())) {
					frame.dispose();
					new PatientPanel(textField.getText());
				}
			}
		});
	}
}

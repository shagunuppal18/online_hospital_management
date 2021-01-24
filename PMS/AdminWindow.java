//package src;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class AdminWindow {

	private JFrame frame;
	DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table;
	private static String user;
	private String uName;
	private JTable table_1;
	private Vector comboBoxItems;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminWindow window = new AdminWindow(user);
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
	public AdminWindow(String u1) {
		uName=u1;
		comboBoxItems=new Vector();
	    RecordDepartment R=new RecordDepartment();
	    ArrayList<String> AL=R.getDepartment();
	    for(int i=0;i<AL.size();i++) {
	    	comboBoxItems.add(AL.get(i));
	    }
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
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1182, 1182);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblAdminPanel = new JLabel("Admin Panel");
		lblAdminPanel.setBounds(509, 5, 163, 38);
		lblAdminPanel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		panel.add(lblAdminPanel);
		
		JLabel lblWelcomeAdmin = new JLabel("Welcome");
		lblWelcomeAdmin.setBounds(952, 62, 63, 16);
		panel.add(lblWelcomeAdmin);
		
		JLabel lblLoginTime = new JLabel("Login time");
		lblLoginTime.setBounds(952, 111, 97, 16);
		panel.add(lblLoginTime);
		
		JLabel label = new JLabel("");
		label.setBounds(1020, 111, 150, 16);
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date date = new Date();
		label.setText(formatter.format(date));
		panel.add(label);
		
		JButton btnCreateLogins = new JButton("Create Logins");
		btnCreateLogins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new DoctorLogin();
			}
		});
		btnCreateLogins.setBounds(40, 589, 157, 25);
		panel.add(btnCreateLogins);
		
		JButton btnAddDepartment = new JButton("Add Department");
		btnAddDepartment.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AddDepartment(uName);
			}
		});
		btnAddDepartment.setBounds(250, 589, 140, 25);
		panel.add(btnAddDepartment);
		
		JButton btnAddDoctor = new JButton("Add Doctor");
		btnAddDoctor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AddDoctor();
			}
		});
		btnAddDoctor.setBounds(422, 589, 97, 25);
		panel.add(btnAddDoctor);
		
		JLabel lblDepartmentsList = new JLabel("Departments List");
		lblDepartmentsList.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblDepartmentsList.setBounds(952, 205, 218, 45);
		panel.add(lblDepartmentsList);
		
		final DefaultListModel<String> l1 = new DefaultListModel<>();  
        RecordDepartment r2=RecordDepartment.getInstance();
        ArrayList<String> ars=r2.getDepartment();
        Collections.sort(ars); 
        for (int i = 0; i < ars.size(); i++) {
        	l1.addElement(ars.get(i));
          }
		  
        
		JList<String> list = new JList<>(l1);
		list.setBounds(981, 292, 1, 1);
		panel.add(list);
		
		JLabel labelUser = new JLabel("");
		labelUser.setBounds(1042, 62, 56, 16);
		panel.add(labelUser);
		labelUser.setText(uName);
		
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBounds(1060, 152, 97, 25);
		panel.add(btnLogout);
		
		//String login[]={"Admin","Patient","Doctor","Donor"};        
		
		//comboBoxItems.add("A");
	    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
	    
		JComboBox cb = new JComboBox(model);
		cb.setBounds(952, 257, 114, 22);
		panel.add(cb);
		
		JButton btnShow = new JButton("Show Added Departments");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new addedDepartments();
			}
		});
		btnShow.setBounds(966, 699, 204, 25);
		panel.add(btnShow);
		
		JLabel lblBookedAppointments = new JLabel("Booked Appointments");
		lblBookedAppointments.setFont(new Font("Times New Roman", Font.ITALIC, 18));
		lblBookedAppointments.setBounds(952, 311, 218, 45);
		panel.add(lblBookedAppointments);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(768, 365, 402, 22);
		panel.add(comboBox);
		
		AppointmentDataRecord ADR=AppointmentDataRecord.getInstance();
		HashMap<String, HashMap<String, HashMap<String,String>>> appDat11=ADR.getAppointRecord();
		String status1;
		for (String i : appDat11.keySet()) {
			Doctor d1=Doctor.getInstance();
			status1=d1.getDoctorName(i.toString())+"/ ";
			  for(String j:appDat11.get(i).keySet()) {
				  status1=status1+j+"/ "; 
				  for(String k:appDat11.get(i).get(j).keySet()) {
					  comboBox.addItem(i+"/"+j+"/"+k+"/"+appDat11.get(i).get(j).get(k));
				  }
			  }
			  }
		
		
				
		
		btnLogout.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new LoginWindow();
			}
		});
		
		
		
		
		
	}
}

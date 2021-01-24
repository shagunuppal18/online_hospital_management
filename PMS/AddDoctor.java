//package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class AddDoctor {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Vector comboBoxItems;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDoctor window = new AddDoctor();
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
	public AddDoctor() {
		comboBoxItems=new Vector();
	    RecordDepartment R=RecordDepartment.getInstance();
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
		frame.setSize(600,768);
		//frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddDoctorPanel = new JLabel("Add Doctor Panel");
		lblAddDoctorPanel.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAddDoctorPanel.setBounds(215, 13, 270, 48);
		frame.getContentPane().add(lblAddDoctorPanel);
		
		JLabel lblDoctorName = new JLabel("Doctor Name");
		lblDoctorName.setBounds(102, 113, 118, 28);
		frame.getContentPane().add(lblDoctorName);
		
		JLabel lblDoctorEmailAddress = new JLabel("Doctor Email Address");
		lblDoctorEmailAddress.setBounds(102, 167, 156, 28);
		frame.getContentPane().add(lblDoctorEmailAddress);
		
		JLabel lblDoctorContactNo = new JLabel("Doctor Contact No.");
		lblDoctorContactNo.setBounds(102, 230, 118, 28);
		frame.getContentPane().add(lblDoctorContactNo);
		
		textField = new JTextField();
		textField.setBounds(291, 116, 165, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(289, 170, 167, 22);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(291, 233, 165, 22);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setBounds(102, 285, 118, 28);
		frame.getContentPane().add(lblDepartment);
		
		final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		
		JComboBox comboBox = new JComboBox(model);
		comboBox.setBounds(291, 288, 165, 22);
		frame.getContentPane().add(comboBox);
		
		
		String times[]={"10:00-2:00","3:00-7:00"};
		JComboBox comboBox_1 = new JComboBox(times);
		comboBox_1.setBounds(291, 355, 165, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblTimeSlot = new JLabel("Time slot");
		lblTimeSlot.setBounds(102, 361, 56, 16);
		frame.getContentPane().add(lblTimeSlot);
		
		JLabel lblEmpId = new JLabel("Emp Id");
		lblEmpId.setBounds(102, 435, 56, 16);
		frame.getContentPane().add(lblEmpId);
		
		textField_3 = new JTextField("Alloted after registration");
		textField_3.setBounds(291, 432, 165, 22);
		textField_3.setEditable(false);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(148, 593, 337, 16);
		frame.getContentPane().add(lblNewLabel);
		frame.setVisible(true);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(148, 527, 97, 25);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnBackToMain = new JButton("Back to Main Window");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				new AdminWindow("Admin");
			}
		});
		btnBackToMain.setBounds(310, 527, 175, 25);
		btnBackToMain.setVisible(false);
		frame.getContentPane().add(btnBackToMain);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//record doctor data into doctor class
				Doctor d1=Doctor.getInstance();
				if(d1.setDoctorList("Dcotor","123456", textField.getText(), (String)comboBox_1.getSelectedItem(), (String)comboBox.getSelectedItem(), textField_2.getText(), textField_1.getText())) {
				lblNewLabel.setText("Added Successfully");
				btnBackToMain.setVisible(true);
				}
			}
		});
	}
}

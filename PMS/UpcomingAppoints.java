//package src;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UpcomingAppoints {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpcomingAppoints window = new UpcomingAppoints();
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
	public UpcomingAppoints() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 420, 253);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblAddedDepartments = new JLabel("Upcoming Appointments");
		lblAddedDepartments.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAddedDepartments.setBounds(109, 24, 268, 28);
		panel.add(lblAddedDepartments);
		Vector comboBoxItems=new Vector();
		final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		
		AppointmentDataRecord ADR=AppointmentDataRecord.getInstance();
		HashMap<String, HashMap<String, HashMap<String,String>>> appDat11=ADR.getAppointRecord();
		String status1;
		for (String i : appDat11.keySet()) {
			Doctor d1=Doctor.getInstance();
			status1=d1.getDoctorName(i.toString())+"/ ";
			  for(String j:appDat11.get(i).keySet()) {
				  status1=status1+j+"/ "; 
				  for(String k:appDat11.get(i).get(j).keySet()) {
					  MaintainUser MU1=MaintainUser.getInstance();
					  String u1=MU1.getUserName();
					  if(u1.equals(appDat11.get(i).get(j).get(k))) {
						  comboBoxItems.add(i+"/"+j+"/"+k+"/"+appDat11.get(i).get(j).get(k));  
					  }
					  
				  }
			  }
			  }
		
		JComboBox cb = new JComboBox(model);
		cb.setBounds(12, 86, 378, 22);
		panel.add(cb);
		cb.setVisible(true);
		
		JButton btnBackToMain = new JButton("Back to Main Window");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new PatientPanel("");
			}
		});
		btnBackToMain.setBounds(128, 215, 155, 25);
		panel.add(btnBackToMain);}

}

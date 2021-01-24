//package src;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DoctorLogin {

	private JFrame frame;
	private JTextField textField;
	private Vector comboBoxItems;//=new Vector();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorLogin window = new DoctorLogin();
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
	public DoctorLogin() {
		try {
		    Doctor D1=new Doctor();
		    ArrayList<DoctorFields> DL=D1.getDoctorrecord();
		    System.out.println("length of Doctor list is"+DL.size());
		    for(int i=0;i<DL.size();i++) {
		    	System.out.println(DL.get(i).name);
		    	comboBoxItems.add(DL.get(i).name);
		    }
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
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
		
		System.out.println("Doctor login running");
		JLabel lblAddedDepartments = new JLabel("Create Doctor Logins");
		lblAddedDepartments.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAddedDepartments.setBounds(75, 24, 254, 28);
		panel.add(lblAddedDepartments);
		
		final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		
		JComboBox cb = new JComboBox(model);
		cb.setBounds(155, 95, 174, 22);
		panel.add(cb);
		cb.setVisible(true);
		
		JButton btnBackToMain = new JButton("Back to Main Window");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdminWindow("Admin");
			}
		});
		btnBackToMain.setBounds(253, 215, 155, 25);
		panel.add(btnBackToMain);
		
		JLabel lblSelectAddedDoctors = new JLabel("Select Added Doctors");
		lblSelectAddedDoctors.setBounds(12, 87, 139, 38);
		panel.add(lblSelectAddedDoctors);
		
		textField = new JTextField();
		textField.setBounds(155, 152, 174, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblSetPassword = new JLabel("Set Password");
		lblSetPassword.setBounds(22, 144, 139, 38);
		panel.add(lblSetPassword);
		
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCreate.setBounds(12, 215, 97, 25);
		panel.add(btnCreate);
		btnCreate.setVisible(false);
		
		JButton btnResetPassword = new JButton("Reset Password");
		btnResetPassword.setBounds(121, 215, 130, 25);
		panel.add(btnResetPassword);
		btnResetPassword.setVisible(false);
	}
}

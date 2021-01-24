//package src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddDepartment {

	private JFrame frame;
	private JTextField textField;
	private static String user;
	private String uName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDepartment window = new AddDepartment(user);
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
	public AddDepartment(String u1) {
		uName=u1;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 554, 246);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddDepartment = new JLabel("Add Department");
		lblAddDepartment.setBounds(217, 26, 125, 24);
		frame.getContentPane().add(lblAddDepartment);
		
		textField = new JTextField();
		textField.setBounds(217, 82, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblDepartmentName = new JLabel("Department Name");
		lblDepartmentName.setBounds(94, 85, 111, 19);
		frame.getContentPane().add(lblDepartmentName);
		
		JLabel label = new JLabel("");
		label.setBounds(35, 170, 164, 16);
		frame.getContentPane().add(label);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(217, 147, 97, 25);
		frame.getContentPane().add(btnAdd);
		
		JButton btnBackToMain = new JButton("Back to Main Window");
		btnBackToMain.setBounds(341, 147, 164, 25);
		frame.getContentPane().add(btnBackToMain);
		btnBackToMain.setVisible(false);
		btnBackToMain.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new AdminWindow(uName);
			}
		});
		
		btnAdd.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				if(!textField.getText().isEmpty()) {
					RecordDepartment r2=RecordDepartment.getInstance();
					if(r2.setDepartment(textField.getText())) {
						label.setText("Department Added Successfully");
						btnBackToMain.setVisible(true);
						btnAdd.setVisible(false);
						//ArrayList<String> v2= r2.getDepartment();
						/*for (int i = 0; i < v2.size(); i++) {
						      System.out.println("at add time: "+v2.get(i));
						    }*/
					}
					else {
						label.setText("Error");
					}
					
				}
			}
		});
		
		
	}
}

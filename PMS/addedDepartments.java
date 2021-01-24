//package src;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class addedDepartments {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addedDepartments window = new addedDepartments();
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
	public addedDepartments() {
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
		
		
		JLabel lblAddedDepartments = new JLabel("Added Departments");
		lblAddedDepartments.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblAddedDepartments.setBounds(109, 24, 193, 28);
		panel.add(lblAddedDepartments);
		Vector comboBoxItems=new Vector();
		final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		
	    RecordDepartment R=new RecordDepartment();
	    ArrayList<String> AL=R.getDepartment();
	    for(int i=0;i<AL.size();i++) {
	    	comboBoxItems.add(AL.get(i));
	    }
		JComboBox cb = new JComboBox(model);
		cb.setBounds(128, 84, 174, 22);
		panel.add(cb);
		cb.setVisible(true);
		
		JButton btnBackToMain = new JButton("Back to Main Window");
		btnBackToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new AdminWindow("Admin");
			}
		});
		btnBackToMain.setBounds(128, 215, 155, 25);
		panel.add(btnBackToMain);
		
		
	}
}

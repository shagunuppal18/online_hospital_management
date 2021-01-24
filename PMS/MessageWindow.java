//package src;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

public class MessageWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MessageWindow window = new MessageWindow("");
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
	public MessageWindow(String m1) {
		initialize(m1);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String m2) {
		frame = new JFrame();
		frame.setBounds(100, 100, 477, 132);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblThankYou = new JLabel("THANK YOU");
		lblThankYou.setBounds(117, 13, 195, 39);
		frame.getContentPane().add(lblThankYou);
		lblThankYou.setText(m2);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(104, 47, 97, 25);
		frame.getContentPane().add(btnOk);
		btnOk.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				new LoginWindow();
			}  
	    });
	}
}

package frame;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;

public class Fenetre2 extends JFrame {
	public Fenetre2() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(41, 63, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(105, 134, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(165, 59, 89, 23);
		getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(61, 105, 4, 22);
		getContentPane().add(textArea);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("New toggle button");
		tglbtnNewToggleButton.setBounds(10, 181, 121, 23);
		getContentPane().add(tglbtnNewToggleButton);
	}
}

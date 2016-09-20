package main.java.br.com.mesquitagomes.view;

import javax.swing.JFrame;

public class MainJFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6569201475698377986L;

	/**
	 * Create the application.
	 */
	public MainJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

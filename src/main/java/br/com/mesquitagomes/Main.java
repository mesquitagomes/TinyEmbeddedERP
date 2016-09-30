package main.java.br.com.mesquitagomes;

import java.awt.EventQueue;

import main.java.br.com.mesquitagomes.view.MainJFrame;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					MainJFrame window = new MainJFrame();
					window.setLocationRelativeTo(null);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}

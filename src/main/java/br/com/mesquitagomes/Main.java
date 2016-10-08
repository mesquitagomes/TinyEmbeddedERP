package main.java.br.com.mesquitagomes;

import java.awt.EventQueue;

import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;
import main.java.br.com.mesquitagomes.view.MainJFrame;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				PersistenceFactory persistenceFactory = PersistenceFactory.getInstance();

				try {

					MainJFrame window = MainJFrame.getInstance(persistenceFactory);
					window.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}

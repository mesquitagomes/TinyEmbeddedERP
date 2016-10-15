package main.java.br.com.mesquitagomes.view;

import javax.swing.table.DefaultTableModel;

public class CustomDefaultTableModel extends DefaultTableModel {

	private static final long serialVersionUID = 1L;

	@Override
	public boolean isCellEditable(int row, int column) {

		return false;
	}

}

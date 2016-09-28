package main.java.br.com.mesquitagomes.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PersonTableJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField textField;
	private JTable personsTable;
	private JButton btnNewOrder;

	/**
	 * Create the panel.
	 */
	public PersonTableJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 10, 10, 10, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 0;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JButton btnFind = new JButton("Find");
		GridBagConstraints gbc_btnFind = new GridBagConstraints();
		gbc_btnFind.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnFind.insets = new Insets(0, 0, 5, 5);
		gbc_btnFind.gridx = 1;
		gbc_btnFind.gridy = 0;
		add(btnFind, gbc_btnFind);

		btnNewOrder = new JButton("New Order");
		GridBagConstraints gbc_btnNewOrder = new GridBagConstraints();
		gbc_btnNewOrder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewOrder.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewOrder.gridx = 2;
		gbc_btnNewOrder.gridy = 0;
		add(btnNewOrder, gbc_btnNewOrder);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		add(scrollPane, gbc_scrollPane);
		{
			personsTable = new JTable();
			scrollPane.setViewportView(personsTable);
		}
	}

}

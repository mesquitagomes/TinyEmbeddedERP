package main.java.br.com.mesquitagomes.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import main.java.br.com.mesquitagomes.model.Product;

public class OrderJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private List<Product> products;
	private JTextField clientTextField;
	private JTextField docsTextField;
	private JTable productsTable;

	public OrderJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel clientPanel = new JPanel();
		clientPanel.setBorder(new TitledBorder(null, "Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_clientPanel = new GridBagConstraints();
		gbc_clientPanel.insets = new Insets(0, 0, 5, 0);
		gbc_clientPanel.fill = GridBagConstraints.BOTH;
		gbc_clientPanel.gridx = 0;
		gbc_clientPanel.gridy = 0;
		add(clientPanel, gbc_clientPanel);
		{
			GridBagLayout gbl_clientPanel = new GridBagLayout();
			gbl_clientPanel.columnWidths = new int[] { 37, 396, 0 };
			gbl_clientPanel.rowHeights = new int[] { 22, 0, 0 };
			gbl_clientPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_clientPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			clientPanel.setLayout(gbl_clientPanel);

			JLabel lblClient = new JLabel("Client:");
			GridBagConstraints gbc_lblClient = new GridBagConstraints();
			gbc_lblClient.anchor = GridBagConstraints.EAST;
			gbc_lblClient.insets = new Insets(0, 0, 5, 5);
			gbc_lblClient.gridx = 0;
			gbc_lblClient.gridy = 0;
			clientPanel.add(lblClient, gbc_lblClient);

			clientTextField = new JTextField();
			clientTextField.setEditable(false);
			GridBagConstraints gbc_clientTextField = new GridBagConstraints();
			gbc_clientTextField.insets = new Insets(0, 0, 5, 0);
			gbc_clientTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_clientTextField.gridx = 1;
			gbc_clientTextField.gridy = 0;
			clientPanel.add(clientTextField, gbc_clientTextField);
			clientTextField.setColumns(10);

			JLabel lblDocs = new JLabel("Docs.:");
			GridBagConstraints gbc_lblDocs = new GridBagConstraints();
			gbc_lblDocs.anchor = GridBagConstraints.EAST;
			gbc_lblDocs.insets = new Insets(0, 0, 0, 5);
			gbc_lblDocs.gridx = 0;
			gbc_lblDocs.gridy = 1;
			clientPanel.add(lblDocs, gbc_lblDocs);

			docsTextField = new JTextField();
			docsTextField.setEditable(false);
			GridBagConstraints gbc_docsTextField = new GridBagConstraints();
			gbc_docsTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_docsTextField.gridx = 1;
			gbc_docsTextField.gridy = 1;
			clientPanel.add(docsTextField, gbc_docsTextField);
			docsTextField.setColumns(10);
		}
		JPanel productsPanel = new JPanel();
		productsPanel.setBorder(new TitledBorder(null, "Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_productsPanel = new GridBagConstraints();
		gbc_productsPanel.fill = GridBagConstraints.BOTH;
		gbc_productsPanel.gridx = 0;
		gbc_productsPanel.gridy = 1;
		add(productsPanel, gbc_productsPanel);
		GridBagLayout gbl_productsPanel = new GridBagLayout();
		gbl_productsPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_productsPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_productsPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_productsPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		productsPanel.setLayout(gbl_productsPanel);
		{
			JButton btnNew = new JButton("New");
			GridBagConstraints gbc_btnNew = new GridBagConstraints();
			gbc_btnNew.insets = new Insets(0, 0, 5, 5);
			gbc_btnNew.gridx = 0;
			gbc_btnNew.gridy = 0;
			productsPanel.add(btnNew, gbc_btnNew);

			JButton btnDelete = new JButton("Delete");
			GridBagConstraints gbc_btnDelete = new GridBagConstraints();
			gbc_btnDelete.insets = new Insets(0, 0, 5, 5);
			gbc_btnDelete.gridx = 1;
			gbc_btnDelete.gridy = 0;
			productsPanel.add(btnDelete, gbc_btnDelete);

			JScrollPane productsScrollPane = new JScrollPane();
			GridBagConstraints gbc_productsScrollPane = new GridBagConstraints();
			gbc_productsScrollPane.gridwidth = 3;
			gbc_productsScrollPane.insets = new Insets(0, 0, 0, 5);
			gbc_productsScrollPane.fill = GridBagConstraints.BOTH;
			gbc_productsScrollPane.gridx = 0;
			gbc_productsScrollPane.gridy = 1;
			productsPanel.add(productsScrollPane, gbc_productsScrollPane);

			productsTable = new JTable();
			productsScrollPane.setViewportView(productsTable);
		}

		initDataBindings();

	}

	protected void initDataBindings() {}
}

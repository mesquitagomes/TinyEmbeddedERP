package test.java.br.com.mesquitagomes.view;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import main.java.br.com.mesquitagomes.model.Order;
import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Product;
import main.java.br.com.mesquitagomes.model.Products;

public class OrderTest extends JFrame {

	private static final long serialVersionUID = 1L;

	private Order order = new Order();
	private Products products = order.getProducts();
	private JPanel contentPane;
	private JTable productsTable;
	private JTextField ownerNameTextField;
	private JTextField ownerCNPJTextField;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					OrderTest frame = new OrderTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		JPanel ownerPanel = new JPanel();
		ownerPanel.setBorder(new TitledBorder(null, "Owner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_ownerPanel = new GridBagConstraints();
		gbc_ownerPanel.insets = new Insets(0, 0, 5, 0);
		gbc_ownerPanel.fill = GridBagConstraints.BOTH;
		gbc_ownerPanel.gridx = 0;
		gbc_ownerPanel.gridy = 0;
		contentPane.add(ownerPanel, gbc_ownerPanel);
		GridBagLayout gbl_ownerPanel = new GridBagLayout();
		gbl_ownerPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_ownerPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_ownerPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_ownerPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		ownerPanel.setLayout(gbl_ownerPanel);

		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		ownerPanel.add(lblName, gbc_lblName);

		ownerNameTextField = new JTextField();
		GridBagConstraints gbc_ownerNameTextField = new GridBagConstraints();
		gbc_ownerNameTextField.insets = new Insets(0, 0, 5, 0);
		gbc_ownerNameTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ownerNameTextField.gridx = 1;
		gbc_ownerNameTextField.gridy = 0;
		ownerPanel.add(ownerNameTextField, gbc_ownerNameTextField);
		ownerNameTextField.setColumns(10);

		JLabel lblCNPJ = new JLabel("CNPJ:");
		GridBagConstraints gbc_lblCNPJ = new GridBagConstraints();
		gbc_lblCNPJ.anchor = GridBagConstraints.EAST;
		gbc_lblCNPJ.insets = new Insets(0, 0, 5, 5);
		gbc_lblCNPJ.gridx = 0;
		gbc_lblCNPJ.gridy = 1;
		ownerPanel.add(lblCNPJ, gbc_lblCNPJ);

		ownerCNPJTextField = new JTextField();
		GridBagConstraints gbc_ownerCNPJTextField = new GridBagConstraints();
		gbc_ownerCNPJTextField.insets = new Insets(0, 0, 5, 0);
		gbc_ownerCNPJTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_ownerCNPJTextField.gridx = 1;
		gbc_ownerCNPJTextField.gridy = 1;
		ownerPanel.add(ownerCNPJTextField, gbc_ownerCNPJTextField);
		ownerCNPJTextField.setColumns(10);

		JPanel buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.anchor = GridBagConstraints.EAST;
		gbc_buttonPanel.fill = GridBagConstraints.VERTICAL;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 2;
		ownerPanel.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 0, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(ownerPanel.getParent(), order.toString());
			}
		});
		GridBagConstraints gbc_btnShow = new GridBagConstraints();
		gbc_btnShow.insets = new Insets(0, 0, 0, 5);
		gbc_btnShow.gridx = 0;
		gbc_btnShow.gridy = 0;
		buttonPanel.add(btnShow, gbc_btnShow);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Person person = new Person();
				person.setName("Ferramentaria MG");
				person.setCnpj("123456789");
				order.setOwner(person);
				initDataBindings();
			}
		});
		GridBagConstraints gbc_btnNew = new GridBagConstraints();
		gbc_btnNew.insets = new Insets(0, 0, 0, 5);
		gbc_btnNew.gridx = 1;
		gbc_btnNew.gridy = 0;
		buttonPanel.add(btnNew, gbc_btnNew);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				Person person = new Person();
				order.setOwner(person);
				initDataBindings();
			}
		});
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.gridx = 2;
		gbc_btnDelete.gridy = 0;
		buttonPanel.add(btnDelete, gbc_btnDelete);

		JPanel productsPanel = new JPanel();
		productsPanel.setBorder(new TitledBorder(null, "Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_productsPanel = new GridBagConstraints();
		gbc_productsPanel.fill = GridBagConstraints.BOTH;
		gbc_productsPanel.gridx = 0;
		gbc_productsPanel.gridy = 1;
		contentPane.add(productsPanel, gbc_productsPanel);
		GridBagLayout gbl_productsPanel = new GridBagLayout();
		gbl_productsPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_productsPanel.rowHeights = new int[] { 0, 0, 0, 126, 0 };
		gbl_productsPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_productsPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		productsPanel.setLayout(gbl_productsPanel);

		JLabel lblDescription = new JLabel("Description:");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.EAST;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 0;
		productsPanel.add(lblDescription, gbc_lblDescription);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 3;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		productsPanel.add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblQuantity = new JLabel("Quantity:");
		GridBagConstraints gbc_lblQuantity = new GridBagConstraints();
		gbc_lblQuantity.anchor = GridBagConstraints.EAST;
		gbc_lblQuantity.insets = new Insets(0, 0, 5, 5);
		gbc_lblQuantity.gridx = 0;
		gbc_lblQuantity.gridy = 1;
		productsPanel.add(lblQuantity, gbc_lblQuantity);

		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 1;
		productsPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);

		JLabel lblUnitPrice = new JLabel("Unit Price:");
		GridBagConstraints gbc_lblUnitPrice = new GridBagConstraints();
		gbc_lblUnitPrice.anchor = GridBagConstraints.EAST;
		gbc_lblUnitPrice.insets = new Insets(0, 0, 5, 5);
		gbc_lblUnitPrice.gridx = 2;
		gbc_lblUnitPrice.gridy = 1;
		productsPanel.add(lblUnitPrice, gbc_lblUnitPrice);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 3;
		gbc_textField_2.gridy = 1;
		productsPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.EAST;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 2;
		productsPanel.add(panel, gbc_panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNew_1 = new JButton("New");
		btnNew_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				products = order.getProducts();
				Product product = new Product();
				products.addProduct(product);
				int index = products.getProducts().indexOf(product);
				productsTable.repaint();
				productsTable.setRowSelectionInterval(index, index);
				textField.requestFocus();
			}
		});
		panel.add(btnNew_1);

		JButton btnDelete_1 = new JButton("Delete");
		btnDelete_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				products = order.getProducts();
				products.getProducts().remove(productsTable.getSelectedRow());
				productsTable.repaint();
			}
		});
		panel.add(btnDelete_1);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 3;
		productsPanel.add(scrollPane, gbc_scrollPane);

		productsTable = new JTable();
		scrollPane.setViewportView(productsTable);
		initDataBindings();
	}

	protected void initDataBindings() {

		BeanProperty<Products, List<Product>> productsBeanProperty = BeanProperty.create("products");
		JTableBinding<Product, Products, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, products,
				productsBeanProperty, productsTable);
		//
		BeanProperty<Product, Integer> productBeanProperty = BeanProperty.create("quantity");
		jTableBinding.addColumnBinding(productBeanProperty).setColumnName("Quantity");
		//
		BeanProperty<Product, String> productBeanProperty_1 = BeanProperty.create("description");
		jTableBinding.addColumnBinding(productBeanProperty_1).setColumnName("Description");
		//
		BeanProperty<Product, Double> productBeanProperty_2 = BeanProperty.create("unitPrice");
		jTableBinding.addColumnBinding(productBeanProperty_2).setColumnName("Unit Price");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, Object> jTableBeanProperty = BeanProperty.create("selectedElement.description");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<JTable, Object, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productsTable,
				jTableBeanProperty, textField, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_1 = BeanProperty.create("selectedElement.quantity");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<JTable, Integer, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				productsTable, jTableBeanProperty_1, textField_1, jTextFieldBeanProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_2 = BeanProperty.create("selectedElement.unitPrice");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<JTable, Double, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productsTable,
				jTableBeanProperty_2, textField_2, jTextFieldBeanProperty_2);
		autoBinding_2.bind();
	}
}

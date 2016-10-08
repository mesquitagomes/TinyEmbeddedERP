package main.java.br.com.mesquitagomes.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import main.java.br.com.mesquitagomes.model.Order;
import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Product;
import main.java.br.com.mesquitagomes.model.Products;
import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;
import main.java.br.com.mesquitagomes.persistence.PersonPersistence;

/**
 * Always has a change to the private variables owner, client and products set then with order.get methods. That is a workaround to fix the
 * Window Builder Swing Databinding limitation.
 * 
 * @author mesquitagomes
 *
 */
public class OrderJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private PersistenceFactory persistenceFactory;
	private PersonPersistence personPersistence;
	private Order order = new Order();
	private Person owner = order.getOwner(); // workaround to fix eclipse databinding wizard
	private Person client = order.getClient(); // workaround to fix eclipse databinding wizard
	private Products products = order.getProducts(); // workaround to fix eclipse databinding wizard
	private JTextField clientNameTextField;
	private JTextField clientDocsTextField;
	private JTable productsTable;
	private JTextField ownerNameTextField;
	private JTextField ownerCNPJTextField;
	private JTextField ownerIETextField;
	private JTextField productDescriptionTextField;
	private JTextField productsTotalTextField;
	private JFormattedTextField productQuantityFormattedTextField;
	private JFormattedTextField productUnitPriceFormattedTextField;

	public OrderJPanel(PersistenceFactory persistenceFactory, Person client) {

		this(persistenceFactory);
		setClient(client);
	}

	public OrderJPanel(PersistenceFactory persistenceFactory) {

		this();
		this.persistenceFactory = persistenceFactory;
		personPersistence = this.persistenceFactory.getPersonPersistence();
		setOwner();
	}

	public OrderJPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel ownerPanel = new JPanel();
		ownerPanel.setBorder(new TitledBorder(null, "Owner", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_ownerPanel = new GridBagConstraints();
		gbc_ownerPanel.insets = new Insets(0, 0, 5, 0);
		gbc_ownerPanel.fill = GridBagConstraints.BOTH;
		gbc_ownerPanel.gridx = 0;
		gbc_ownerPanel.gridy = 0;
		add(ownerPanel, gbc_ownerPanel);
		GridBagLayout gbl_ownerPanel = new GridBagLayout();
		gbl_ownerPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_ownerPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_ownerPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_ownerPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		ownerPanel.setLayout(gbl_ownerPanel);
		{
			JLabel ownerNameLabel = new JLabel("Name:");
			GridBagConstraints gbc_ownerNameLabel = new GridBagConstraints();
			gbc_ownerNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_ownerNameLabel.anchor = GridBagConstraints.EAST;
			gbc_ownerNameLabel.gridx = 0;
			gbc_ownerNameLabel.gridy = 0;
			ownerPanel.add(ownerNameLabel, gbc_ownerNameLabel);

			ownerNameTextField = new JTextField();
			ownerNameTextField.setEditable(false);
			GridBagConstraints gbc_ownerNameTextField = new GridBagConstraints();
			gbc_ownerNameTextField.gridwidth = 3;
			gbc_ownerNameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_ownerNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_ownerNameTextField.gridx = 1;
			gbc_ownerNameTextField.gridy = 0;
			ownerPanel.add(ownerNameTextField, gbc_ownerNameTextField);
			ownerNameTextField.setColumns(10);

			JLabel ownerCNPJLabel = new JLabel("CNPJ:");
			GridBagConstraints gbc_ownerCNPJLabel = new GridBagConstraints();
			gbc_ownerCNPJLabel.anchor = GridBagConstraints.EAST;
			gbc_ownerCNPJLabel.insets = new Insets(0, 0, 0, 5);
			gbc_ownerCNPJLabel.gridx = 0;
			gbc_ownerCNPJLabel.gridy = 1;
			ownerPanel.add(ownerCNPJLabel, gbc_ownerCNPJLabel);

			ownerCNPJTextField = new JTextField();
			ownerCNPJTextField.setEditable(false);
			GridBagConstraints gbc_ownerCNPJTextField = new GridBagConstraints();
			gbc_ownerCNPJTextField.insets = new Insets(0, 0, 0, 5);
			gbc_ownerCNPJTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_ownerCNPJTextField.gridx = 1;
			gbc_ownerCNPJTextField.gridy = 1;
			ownerPanel.add(ownerCNPJTextField, gbc_ownerCNPJTextField);
			ownerCNPJTextField.setColumns(10);

			JLabel ownerIELabel = new JLabel("IE:");
			GridBagConstraints gbc_ownerIELabel = new GridBagConstraints();
			gbc_ownerIELabel.anchor = GridBagConstraints.EAST;
			gbc_ownerIELabel.insets = new Insets(0, 0, 0, 5);
			gbc_ownerIELabel.gridx = 2;
			gbc_ownerIELabel.gridy = 1;
			ownerPanel.add(ownerIELabel, gbc_ownerIELabel);

			ownerIETextField = new JTextField();
			ownerIETextField.setEditable(false);
			GridBagConstraints gbc_ownerIETextField = new GridBagConstraints();
			gbc_ownerIETextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_ownerIETextField.gridx = 3;
			gbc_ownerIETextField.gridy = 1;
			ownerPanel.add(ownerIETextField, gbc_ownerIETextField);
			ownerIETextField.setColumns(10);
		}
		JPanel clientPanel = new JPanel();
		clientPanel.setBorder(new TitledBorder(null, "Client", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_clientPanel = new GridBagConstraints();
		gbc_clientPanel.insets = new Insets(0, 0, 5, 0);
		gbc_clientPanel.fill = GridBagConstraints.BOTH;
		gbc_clientPanel.gridx = 0;
		gbc_clientPanel.gridy = 1;
		add(clientPanel, gbc_clientPanel);
		{
			GridBagLayout gbl_clientPanel = new GridBagLayout();
			gbl_clientPanel.columnWidths = new int[] { 37, 396, 0 };
			gbl_clientPanel.rowHeights = new int[] { 22, 0, 0 };
			gbl_clientPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_clientPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
			clientPanel.setLayout(gbl_clientPanel);

			JLabel clientNameLabel = new JLabel("Name:");
			GridBagConstraints gbc_clientNameLabel = new GridBagConstraints();
			gbc_clientNameLabel.anchor = GridBagConstraints.EAST;
			gbc_clientNameLabel.insets = new Insets(0, 0, 5, 5);
			gbc_clientNameLabel.gridx = 0;
			gbc_clientNameLabel.gridy = 0;
			clientPanel.add(clientNameLabel, gbc_clientNameLabel);

			clientNameTextField = new JTextField();
			clientNameTextField.setEditable(false);
			GridBagConstraints gbc_clientNameTextField = new GridBagConstraints();
			gbc_clientNameTextField.insets = new Insets(0, 0, 5, 0);
			gbc_clientNameTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_clientNameTextField.gridx = 1;
			gbc_clientNameTextField.gridy = 0;
			clientPanel.add(clientNameTextField, gbc_clientNameTextField);
			clientNameTextField.setColumns(10);

			JLabel clientDocsLabel = new JLabel("Docs.:");
			GridBagConstraints gbc_clientDocsLabel = new GridBagConstraints();
			gbc_clientDocsLabel.anchor = GridBagConstraints.EAST;
			gbc_clientDocsLabel.insets = new Insets(0, 0, 0, 5);
			gbc_clientDocsLabel.gridx = 0;
			gbc_clientDocsLabel.gridy = 1;
			clientPanel.add(clientDocsLabel, gbc_clientDocsLabel);

			clientDocsTextField = new JTextField();
			clientDocsTextField.setEditable(false);
			GridBagConstraints gbc_clientDocsTextField = new GridBagConstraints();
			gbc_clientDocsTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_clientDocsTextField.gridx = 1;
			gbc_clientDocsTextField.gridy = 1;
			clientPanel.add(clientDocsTextField, gbc_clientDocsTextField);
			clientDocsTextField.setColumns(10);
		}
		JPanel productsPanel = new JPanel();
		productsPanel.setBorder(new TitledBorder(null, "Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_productsPanel = new GridBagConstraints();
		gbc_productsPanel.fill = GridBagConstraints.BOTH;
		gbc_productsPanel.gridx = 0;
		gbc_productsPanel.gridy = 2;
		add(productsPanel, gbc_productsPanel);
		GridBagLayout gbl_productsPanel = new GridBagLayout();
		gbl_productsPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_productsPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_productsPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_productsPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		productsPanel.setLayout(gbl_productsPanel);
		{
			JLabel productDescription = new JLabel("Description:");
			GridBagConstraints gbc_productDescription = new GridBagConstraints();
			gbc_productDescription.anchor = GridBagConstraints.EAST;
			gbc_productDescription.insets = new Insets(0, 0, 5, 5);
			gbc_productDescription.gridx = 0;
			gbc_productDescription.gridy = 0;
			productsPanel.add(productDescription, gbc_productDescription);

			productDescriptionTextField = new JTextField();
			GridBagConstraints gbc_productDescriptionTextField = new GridBagConstraints();
			gbc_productDescriptionTextField.gridwidth = 3;
			gbc_productDescriptionTextField.insets = new Insets(0, 0, 5, 0);
			gbc_productDescriptionTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_productDescriptionTextField.gridx = 1;
			gbc_productDescriptionTextField.gridy = 0;
			productsPanel.add(productDescriptionTextField, gbc_productDescriptionTextField);
			productDescriptionTextField.setColumns(10);

			JLabel productQuantityLable = new JLabel("Quantity:");
			GridBagConstraints gbc_productQuantityLable = new GridBagConstraints();
			gbc_productQuantityLable.anchor = GridBagConstraints.EAST;
			gbc_productQuantityLable.insets = new Insets(0, 0, 5, 5);
			gbc_productQuantityLable.gridx = 0;
			gbc_productQuantityLable.gridy = 1;
			productsPanel.add(productQuantityLable, gbc_productQuantityLable);

			productQuantityFormattedTextField = new JFormattedTextField(new NumberFormatter());
			GridBagConstraints gbc_productQuantityFormattedTextField = new GridBagConstraints();
			gbc_productQuantityFormattedTextField.insets = new Insets(0, 0, 5, 5);
			gbc_productQuantityFormattedTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_productQuantityFormattedTextField.gridx = 1;
			gbc_productQuantityFormattedTextField.gridy = 1;
			productsPanel.add(productQuantityFormattedTextField, gbc_productQuantityFormattedTextField);

			JLabel productUnitPriceLabel = new JLabel("Unit Price:");
			GridBagConstraints gbc_productUnitPriceLabel = new GridBagConstraints();
			gbc_productUnitPriceLabel.anchor = GridBagConstraints.EAST;
			gbc_productUnitPriceLabel.insets = new Insets(0, 0, 5, 5);
			gbc_productUnitPriceLabel.gridx = 2;
			gbc_productUnitPriceLabel.gridy = 1;
			productsPanel.add(productUnitPriceLabel, gbc_productUnitPriceLabel);

			productUnitPriceFormattedTextField = new JFormattedTextField(new NumberFormatter());
			GridBagConstraints gbc_productUnitPriceFormattedTextField = new GridBagConstraints();
			gbc_productUnitPriceFormattedTextField.insets = new Insets(0, 0, 5, 0);
			gbc_productUnitPriceFormattedTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_productUnitPriceFormattedTextField.gridx = 3;
			gbc_productUnitPriceFormattedTextField.gridy = 1;
			productsPanel.add(productUnitPriceFormattedTextField, gbc_productUnitPriceFormattedTextField);
			{

				JPanel productsButtonPanel = new JPanel();
				GridBagConstraints gbc_productsButtonPanel = new GridBagConstraints();
				gbc_productsButtonPanel.anchor = GridBagConstraints.EAST;
				gbc_productsButtonPanel.gridwidth = 4;
				gbc_productsButtonPanel.insets = new Insets(0, 0, 5, 0);
				gbc_productsButtonPanel.fill = GridBagConstraints.VERTICAL;
				gbc_productsButtonPanel.gridx = 0;
				gbc_productsButtonPanel.gridy = 2;
				productsPanel.add(productsButtonPanel, gbc_productsButtonPanel);
				productsButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				{
					JButton btnShow = new JButton("Show");
					btnShow.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							JOptionPane.showMessageDialog(getParent(),
									"Owner: " + order.getOwner() + "\nClient: " + order.getClient() + "\n"
											+ Arrays.toString(order.getProducts().getProducts().toArray()),
									"", JOptionPane.WARNING_MESSAGE);
						}
					});
					productsButtonPanel.add(btnShow);

					JButton btnNewProduct = new JButton("New");
					btnNewProduct.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							products = order.getProducts();
							Product product = new Product();
							products.addProduct(product);
							int index = products.getProducts().indexOf(product);
							productsTable.repaint();
							productsTable.setRowSelectionInterval(index, index);
							productDescriptionTextField.requestFocus();
						}
					});
					productsButtonPanel.add(btnNewProduct);

					JButton btnDeleteProduct = new JButton("Delete");
					btnDeleteProduct.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							products = order.getProducts();
							products.getProducts().remove(productsTable.getSelectedRow());
							productsTable.repaint();
						}
					});
					productsButtonPanel.add(btnDeleteProduct);
				}
				JScrollPane productsScrollPane = new JScrollPane();
				GridBagConstraints gbc_productsScrollPane = new GridBagConstraints();
				gbc_productsScrollPane.insets = new Insets(0, 0, 5, 0);
				gbc_productsScrollPane.gridwidth = 4;
				gbc_productsScrollPane.fill = GridBagConstraints.BOTH;
				gbc_productsScrollPane.gridx = 0;
				gbc_productsScrollPane.gridy = 3;
				productsPanel.add(productsScrollPane, gbc_productsScrollPane);
				{
					productsTable = new JTable();
					productsScrollPane.setViewportView(productsTable);
				}
			}
		}

		JLabel productsTotalLabel = new JLabel("Total:");
		GridBagConstraints gbc_productsTotalLabel = new GridBagConstraints();
		gbc_productsTotalLabel.anchor = GridBagConstraints.EAST;
		gbc_productsTotalLabel.insets = new Insets(0, 0, 0, 5);
		gbc_productsTotalLabel.gridx = 2;
		gbc_productsTotalLabel.gridy = 4;
		productsPanel.add(productsTotalLabel, gbc_productsTotalLabel);

		productsTotalTextField = new JTextField();
		productsTotalTextField.setEditable(false);
		GridBagConstraints gbc_productsTotalTextField = new GridBagConstraints();
		gbc_productsTotalTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_productsTotalTextField.gridx = 3;
		gbc_productsTotalTextField.gridy = 4;
		productsPanel.add(productsTotalTextField, gbc_productsTotalTextField);
		productsTotalTextField.setColumns(10);

		initDataBindings();

	}

	public void setOwner() {

		Person newOwner = personPersistence.getById(Order.OWNER_DEFAULT_ID);
		if (newOwner != null) {
			System.out.println("Seting owner: " + newOwner);
			order.setOwner(newOwner);
			owner = order.getOwner();
			initDataBindings();
		}
	}

	public void setClient(Person client) {

		if (client != null) {
			System.out.println("Seting client: " + client);
			order.setClient(client);
			client = order.getClient();
			initDataBindings();
		}
	}

	public Order getOrder() {

		return order;
	}

	public void createOrderPDF() {

		// TODO
	}

	protected BindingGroup initDataBindings() {

		BeanProperty<Person, String> personBeanProperty = BeanProperty.create("name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, owner,
				personBeanProperty, ownerNameTextField, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<Person, String> personBeanProperty_1 = BeanProperty.create("cnpj");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, owner,
				personBeanProperty_1, ownerCNPJTextField, jTextFieldBeanProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<Person, String> personBeanProperty_2 = BeanProperty.create("ie");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ, owner,
				personBeanProperty_2, ownerIETextField, jTextFieldBeanProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<Person, String> personBeanProperty_3 = BeanProperty.create("name");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, client,
				personBeanProperty_3, clientNameTextField, jTextFieldBeanProperty_3);
		autoBinding_3.bind();
		//
		ELProperty<Person, Object> personEvalutionProperty = ELProperty.create("CNPJ: ${cnpj} IE: ${ie} CPF: ${cpf} RG: ${rg}");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<Person, Object, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ, client,
				personEvalutionProperty, clientDocsTextField, jTextFieldBeanProperty_4);
		autoBinding_4.bind();
		//
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
		BeanProperty<Product, Double> productBeanProperty_3 = BeanProperty.create("totalPrice");
		jTableBinding.addColumnBinding(productBeanProperty_3).setColumnName("Price");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTable, String> jTableBeanProperty = BeanProperty.create("selectedElement.description");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty.create("text");
		AutoBinding<JTable, String, JTextField, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, productsTable,
				jTableBeanProperty, productDescriptionTextField, jTextFieldBeanProperty_5);
		autoBinding_5.bind();
		//
		BeanProperty<JTable, Integer> jTableBeanProperty_1 = BeanProperty.create("selectedElement.quantity");
		BeanProperty<JFormattedTextField, String> jFormattedTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<JTable, Integer, JFormattedTextField, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				productsTable, jTableBeanProperty_1, productQuantityFormattedTextField, jFormattedTextFieldBeanProperty);
		autoBinding_6.bind();
		//
		BeanProperty<JTable, Double> jTableBeanProperty_2 = BeanProperty.create("selectedElement.unitPrice");
		BeanProperty<JFormattedTextField, String> jFormattedTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<JTable, Double, JFormattedTextField, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				productsTable, jTableBeanProperty_2, productUnitPriceFormattedTextField, jFormattedTextFieldBeanProperty_1);
		autoBinding_7.bind();
		//
		BeanProperty<Products, Double> productsBeanProperty_1 = BeanProperty.create("totalPrice");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_6 = BeanProperty.create("text");
		AutoBinding<Products, Double, JTextField, String> autoBinding_8 = Bindings.createAutoBinding(UpdateStrategy.READ, products,
				productsBeanProperty_1, productsTotalTextField, jTextFieldBeanProperty_6);
		autoBinding_8.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		bindingGroup.addBinding(autoBinding_4);
		bindingGroup.addBinding(jTableBinding);
		bindingGroup.addBinding(autoBinding_5);
		bindingGroup.addBinding(autoBinding_6);
		bindingGroup.addBinding(autoBinding_7);
		bindingGroup.addBinding(autoBinding_8);
		return bindingGroup;
	}
}

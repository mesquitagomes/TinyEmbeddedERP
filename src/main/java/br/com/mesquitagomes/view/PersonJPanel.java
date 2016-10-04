package main.java.br.com.mesquitagomes.view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import main.java.br.com.mesquitagomes.model.Adress;
import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Person.PersonColumns;
import main.java.br.com.mesquitagomes.model.Persons;
import main.java.br.com.mesquitagomes.model.Phone;
import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;
import main.java.br.com.mesquitagomes.persistence.PersonPersistence;

public class PersonJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private PersistenceFactory persistenceFactory;
	private PersonPersistence personPersistence;
	private BindingGroup m_bindingGroup;
	private Person person = new Person();
	private Persons persons = new Persons();
	private JTextField idJTextField;
	private JTextField nameJTextField;
	private JFormattedTextField CNPJJFormattedTextField;
	private JFormattedTextField IEJFormattedTextField;
	private JFormattedTextField CPFJFormattedTextField;
	private JFormattedTextField RGJFormattedTextField;
	private JButton btnSavePerson;
	private JPanel personButtonPanel;
	private JButton btnDeletePerson;
	private JTable phonesTable;
	private JPanel phonesButtonPanel;
	private JButton btnNewPhone;
	private JButton btnEditPhone;
	private JButton btnDeletePhone;
	private JTable adressesTable;
	private JPanel adressesButtonPanel;
	private JButton btnNewAdress;
	private JButton btnEditAdress;
	private JButton btnDeleteAdress;
	private JPanel phonesPanel;
	private JPanel adressesPanel;
	private JButton btnNewPerson;
	private JLabel emailLable;
	private JFormattedTextField emailJFormattedTextField;
	private JPanel personPanel;
	private JSplitPane splitPane;
	private JPanel personsPanel;
	private JTextField findTextField;
	private JButton btnFind;
	private JButton btnNewOrder;
	private JScrollPane personsScrollPane;
	private JTable personsTable;
	private JScrollPane adressesScrollPane;
	private JScrollPane phonesScrollPane;
	private JButton btnEdit;

	public PersonJPanel(PersistenceFactory persistenceFactory, Person newPerson) {

		this(persistenceFactory);
		setPerson(newPerson);
	}

	public PersonJPanel(PersistenceFactory persistenceFactory) {

		this();
		this.persistenceFactory = persistenceFactory;
		personPersistence = this.persistenceFactory.getPersonPersistence();
	}

	public PersonJPanel() {

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 50, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 1.0, 1.0E-4 };
		setLayout(gridBagLayout);

		splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		add(splitPane, gbc_splitPane);
		{
			personPanel = new JPanel();
			personPanel.setBorder(new TitledBorder(null, "Person", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			splitPane.setLeftComponent(personPanel);
			GridBagLayout gbl_personPanel = new GridBagLayout();
			gbl_personPanel.columnWidths = new int[] { 50, 0, 50, 0, 0 };
			gbl_personPanel.rowHeights = new int[] { 0, 0, 0, 0, 160, 0, 0 };
			gbl_personPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
			gbl_personPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
			personPanel.setLayout(gbl_personPanel);
			{
				JLabel idLabel = new JLabel("Id:");
				GridBagConstraints gbc_idLabel = new GridBagConstraints();
				gbc_idLabel.anchor = GridBagConstraints.EAST;
				gbc_idLabel.fill = GridBagConstraints.VERTICAL;
				gbc_idLabel.insets = new Insets(0, 0, 5, 5);
				gbc_idLabel.gridx = 0;
				gbc_idLabel.gridy = 0;
				personPanel.add(idLabel, gbc_idLabel);

				idJTextField = new JTextField();
				GridBagConstraints gbc_idJTextField = new GridBagConstraints();
				gbc_idJTextField.fill = GridBagConstraints.BOTH;
				gbc_idJTextField.insets = new Insets(0, 0, 5, 5);
				gbc_idJTextField.gridx = 1;
				gbc_idJTextField.gridy = 0;
				personPanel.add(idJTextField, gbc_idJTextField);
				idJTextField.setEditable(false);

				JLabel nameLabel = new JLabel("Name:");
				GridBagConstraints gbc_nameLabel = new GridBagConstraints();
				gbc_nameLabel.anchor = GridBagConstraints.EAST;
				gbc_nameLabel.fill = GridBagConstraints.VERTICAL;
				gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
				gbc_nameLabel.gridx = 0;
				gbc_nameLabel.gridy = 1;
				personPanel.add(nameLabel, gbc_nameLabel);

				nameJTextField = new JTextField();
				GridBagConstraints gbc_nameJTextField = new GridBagConstraints();
				gbc_nameJTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_nameJTextField.insets = new Insets(0, 0, 5, 5);
				gbc_nameJTextField.gridx = 1;
				gbc_nameJTextField.gridy = 1;
				personPanel.add(nameJTextField, gbc_nameJTextField);

				emailLable = new JLabel("Email:");
				GridBagConstraints gbc_emailLable = new GridBagConstraints();
				gbc_emailLable.anchor = GridBagConstraints.EAST;
				gbc_emailLable.insets = new Insets(0, 0, 5, 5);
				gbc_emailLable.gridx = 2;
				gbc_emailLable.gridy = 1;
				personPanel.add(emailLable, gbc_emailLable);

				emailJFormattedTextField = new JFormattedTextField();
				GridBagConstraints gbc_emailJFormattedTextField = new GridBagConstraints();
				gbc_emailJFormattedTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_emailJFormattedTextField.insets = new Insets(0, 0, 5, 0);
				gbc_emailJFormattedTextField.gridx = 3;
				gbc_emailJFormattedTextField.gridy = 1;
				personPanel.add(emailJFormattedTextField, gbc_emailJFormattedTextField);

				JLabel CNPJLabel = new JLabel("CNPJ:");
				GridBagConstraints gbc_CNPJLabel = new GridBagConstraints();
				gbc_CNPJLabel.anchor = GridBagConstraints.EAST;
				gbc_CNPJLabel.fill = GridBagConstraints.VERTICAL;
				gbc_CNPJLabel.insets = new Insets(0, 0, 5, 5);
				gbc_CNPJLabel.gridx = 0;
				gbc_CNPJLabel.gridy = 2;
				personPanel.add(CNPJLabel, gbc_CNPJLabel);

				CNPJJFormattedTextField = new JFormattedTextField();
				GridBagConstraints gbc_CNPJJFormattedTextField = new GridBagConstraints();
				gbc_CNPJJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_CNPJJFormattedTextField.insets = new Insets(0, 0, 5, 5);
				gbc_CNPJJFormattedTextField.gridx = 1;
				gbc_CNPJJFormattedTextField.gridy = 2;
				personPanel.add(CNPJJFormattedTextField, gbc_CNPJJFormattedTextField);

				JLabel IELabel = new JLabel("IE:");
				GridBagConstraints gbc_IELabel = new GridBagConstraints();
				gbc_IELabel.anchor = GridBagConstraints.EAST;
				gbc_IELabel.fill = GridBagConstraints.VERTICAL;
				gbc_IELabel.insets = new Insets(0, 0, 5, 5);
				gbc_IELabel.gridx = 2;
				gbc_IELabel.gridy = 2;
				personPanel.add(IELabel, gbc_IELabel);

				IEJFormattedTextField = new JFormattedTextField();
				GridBagConstraints gbc_IEJFormattedTextField = new GridBagConstraints();
				gbc_IEJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_IEJFormattedTextField.insets = new Insets(0, 0, 5, 0);
				gbc_IEJFormattedTextField.gridx = 3;
				gbc_IEJFormattedTextField.gridy = 2;
				personPanel.add(IEJFormattedTextField, gbc_IEJFormattedTextField);

				JLabel CPFLabel = new JLabel("CPF:");
				GridBagConstraints gbc_CPFLabel = new GridBagConstraints();
				gbc_CPFLabel.anchor = GridBagConstraints.EAST;
				gbc_CPFLabel.fill = GridBagConstraints.VERTICAL;
				gbc_CPFLabel.insets = new Insets(0, 0, 5, 5);
				gbc_CPFLabel.gridx = 0;
				gbc_CPFLabel.gridy = 3;
				personPanel.add(CPFLabel, gbc_CPFLabel);

				CPFJFormattedTextField = new JFormattedTextField();
				GridBagConstraints gbc_CPFJFormattedTextField = new GridBagConstraints();
				gbc_CPFJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_CPFJFormattedTextField.insets = new Insets(0, 0, 5, 5);
				gbc_CPFJFormattedTextField.gridx = 1;
				gbc_CPFJFormattedTextField.gridy = 3;
				personPanel.add(CPFJFormattedTextField, gbc_CPFJFormattedTextField);

				JLabel RGLabel = new JLabel("RG:");
				GridBagConstraints gbc_RGLabel = new GridBagConstraints();
				gbc_RGLabel.anchor = GridBagConstraints.EAST;
				gbc_RGLabel.fill = GridBagConstraints.VERTICAL;
				gbc_RGLabel.insets = new Insets(0, 0, 5, 5);
				gbc_RGLabel.gridx = 2;
				gbc_RGLabel.gridy = 3;
				personPanel.add(RGLabel, gbc_RGLabel);

				RGJFormattedTextField = new JFormattedTextField();
				GridBagConstraints gbc_RGJFormattedTextField = new GridBagConstraints();
				gbc_RGJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_RGJFormattedTextField.insets = new Insets(0, 0, 5, 0);
				gbc_RGJFormattedTextField.gridx = 3;
				gbc_RGJFormattedTextField.gridy = 3;
				personPanel.add(RGJFormattedTextField, gbc_RGJFormattedTextField);

				phonesPanel = new JPanel();
				GridBagConstraints gbc_phonesPanel = new GridBagConstraints();
				gbc_phonesPanel.fill = GridBagConstraints.BOTH;
				gbc_phonesPanel.gridwidth = 2;
				gbc_phonesPanel.insets = new Insets(0, 0, 5, 5);
				gbc_phonesPanel.gridx = 0;
				gbc_phonesPanel.gridy = 4;
				personPanel.add(phonesPanel, gbc_phonesPanel);
				phonesPanel.setBorder(new TitledBorder(null, "Phones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				{
					GridBagLayout gbl_panel_2 = new GridBagLayout();
					gbl_panel_2.columnWidths = new int[] { 0, 0 };
					gbl_panel_2.rowHeights = new int[] { 0, 0, 0 };
					gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
					gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
					phonesPanel.setLayout(gbl_panel_2);

					phonesButtonPanel = new JPanel();
					GridBagConstraints gbc_panel_1 = new GridBagConstraints();
					gbc_panel_1.anchor = GridBagConstraints.WEST;
					gbc_panel_1.fill = GridBagConstraints.VERTICAL;
					gbc_panel_1.insets = new Insets(0, 0, 5, 0);
					gbc_panel_1.gridx = 0;
					gbc_panel_1.gridy = 0;
					phonesPanel.add(phonesButtonPanel, gbc_panel_1);
					{
						btnNewPhone = new JButton("New");
						phonesButtonPanel.add(btnNewPhone);

						btnEditPhone = new JButton("Edit");
						phonesButtonPanel.add(btnEditPhone);

						btnDeletePhone = new JButton("Delete");
						phonesButtonPanel.add(btnDeletePhone);
					}
					phonesScrollPane = new JScrollPane();
					GridBagConstraints gbc_phoneScrollPane = new GridBagConstraints();
					gbc_phoneScrollPane.fill = GridBagConstraints.BOTH;
					gbc_phoneScrollPane.gridx = 0;
					gbc_phoneScrollPane.gridy = 1;
					phonesPanel.add(phonesScrollPane, gbc_phoneScrollPane);
					{
						phonesTable = new JTable();
						phonesScrollPane.setViewportView(phonesTable);
					}
				}
				adressesPanel = new JPanel();
				GridBagConstraints gbc_adressesPanel = new GridBagConstraints();
				gbc_adressesPanel.fill = GridBagConstraints.BOTH;
				gbc_adressesPanel.gridwidth = 2;
				gbc_adressesPanel.insets = new Insets(0, 0, 5, 0);
				gbc_adressesPanel.gridx = 2;
				gbc_adressesPanel.gridy = 4;
				personPanel.add(adressesPanel, gbc_adressesPanel);
				adressesPanel.setBorder(new TitledBorder(null, "Adresses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
				{
					GridBagLayout gbl_adressesPanel = new GridBagLayout();
					gbl_adressesPanel.columnWidths = new int[] { 0, 0 };
					gbl_adressesPanel.rowHeights = new int[] { 0, 0, 0 };
					gbl_adressesPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
					gbl_adressesPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
					adressesPanel.setLayout(gbl_adressesPanel);

					adressesButtonPanel = new JPanel();
					GridBagConstraints gbc_adressesButtonPanel = new GridBagConstraints();
					gbc_adressesButtonPanel.anchor = GridBagConstraints.WEST;
					gbc_adressesButtonPanel.insets = new Insets(0, 0, 5, 0);
					gbc_adressesButtonPanel.fill = GridBagConstraints.VERTICAL;
					gbc_adressesButtonPanel.gridx = 0;
					gbc_adressesButtonPanel.gridy = 0;
					adressesPanel.add(adressesButtonPanel, gbc_adressesButtonPanel);
					{
						btnNewAdress = new JButton("New");
						adressesButtonPanel.add(btnNewAdress);

						btnEditAdress = new JButton("Edit");
						adressesButtonPanel.add(btnEditAdress);

						btnDeleteAdress = new JButton("Delete");
						adressesButtonPanel.add(btnDeleteAdress);
					}

					adressesScrollPane = new JScrollPane();
					GridBagConstraints gbc_adressesScrollPane = new GridBagConstraints();
					gbc_adressesScrollPane.fill = GridBagConstraints.BOTH;
					gbc_adressesScrollPane.gridx = 0;
					gbc_adressesScrollPane.gridy = 1;
					adressesPanel.add(adressesScrollPane, gbc_adressesScrollPane);
					adressesTable = new JTable();
					adressesScrollPane.setViewportView(adressesTable);
				}
				personButtonPanel = new JPanel();
				GridBagConstraints gbc_personButtonPanel = new GridBagConstraints();
				gbc_personButtonPanel.fill = GridBagConstraints.BOTH;
				gbc_personButtonPanel.gridwidth = 4;
				gbc_personButtonPanel.gridx = 0;
				gbc_personButtonPanel.gridy = 5;
				personPanel.add(personButtonPanel, gbc_personButtonPanel);
				FlowLayout flowLayout = (FlowLayout) personButtonPanel.getLayout();
				flowLayout.setAlignment(FlowLayout.RIGHT);
				{

					btnSavePerson = new JButton("Save");
					btnSavePerson.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							if (person.getId() == null) personPersistence.persist(person);
							else person = personPersistence.merge(person);
							JOptionPane.showMessageDialog(getParent(), "Person saved.\n" + person);
							setPerson(person);
						}
					});
					personButtonPanel.add(btnSavePerson);

					btnNewPerson = new JButton("New");
					btnNewPerson.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							Person newPerson = new Person();
							setPerson(newPerson);
							nameJTextField.requestFocus();
						}
					});

					personButtonPanel.add(btnNewPerson);

					btnDeletePerson = new JButton("Delete");
					btnDeletePerson.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							if (person != null) {
								personPersistence.remove(person);
								btnNewPerson.dispatchEvent(e);
							}
						}
					});
					personButtonPanel.add(btnDeletePerson);
				}
			}
			personsPanel = new JPanel();
			personsPanel.setBorder(new TitledBorder(null, "Find Persons", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			splitPane.setRightComponent(personsPanel);
			GridBagLayout gbl_personsPanel = new GridBagLayout();
			gbl_personsPanel.columnWidths = new int[] { 81, 59, 0, 97, 0 };
			gbl_personsPanel.rowHeights = new int[] { 25, 42, 0 };
			gbl_personsPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
			gbl_personsPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			personsPanel.setLayout(gbl_personsPanel);
			{
				findTextField = new JTextField();
				findTextField.setColumns(10);
				GridBagConstraints gbc_findTextField = new GridBagConstraints();
				gbc_findTextField.fill = GridBagConstraints.HORIZONTAL;
				gbc_findTextField.insets = new Insets(0, 0, 5, 5);
				gbc_findTextField.gridx = 0;
				gbc_findTextField.gridy = 0;
				personsPanel.add(findTextField, gbc_findTextField);

				btnFind = new JButton("Find");
				btnFind.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						List<Person> newPpersons;
						String value = findTextField.getText();
						try {
							int val = Integer.valueOf(value);
							newPpersons = personPersistence.getByDocsOR(val, val, val, val);
							newPpersons.add(personPersistence.getById(val));
						} catch (NumberFormatException e1) {
							newPpersons = personPersistence.getByColumn(PersonColumns.NAME.getName(), value);
						}

						persons.setPersons(newPpersons);
						personsTable.repaint();
					}
				});
				GridBagConstraints gbc_btnFind = new GridBagConstraints();
				gbc_btnFind.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnFind.insets = new Insets(0, 0, 5, 5);
				gbc_btnFind.gridx = 1;
				gbc_btnFind.gridy = 0;
				personsPanel.add(btnFind, gbc_btnFind);

				btnEdit = new JButton("Edit");
				btnEdit.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						Person newPerson = persons.getPersons().get(personsTable.getSelectedRow());
						setPerson(newPerson);
					}
				});
				GridBagConstraints gbc_btnEdit = new GridBagConstraints();
				gbc_btnEdit.insets = new Insets(0, 0, 5, 5);
				gbc_btnEdit.gridx = 2;
				gbc_btnEdit.gridy = 0;
				personsPanel.add(btnEdit, gbc_btnEdit);

				btnNewOrder = new JButton("New Order");
				GridBagConstraints gbc_btnNewOrder = new GridBagConstraints();
				gbc_btnNewOrder.anchor = GridBagConstraints.NORTHWEST;
				gbc_btnNewOrder.insets = new Insets(0, 0, 5, 0);
				gbc_btnNewOrder.gridx = 3;
				gbc_btnNewOrder.gridy = 0;
				personsPanel.add(btnNewOrder, gbc_btnNewOrder);

				personsScrollPane = new JScrollPane();
				GridBagConstraints gbc_personsScrollPane = new GridBagConstraints();
				gbc_personsScrollPane.fill = GridBagConstraints.BOTH;
				gbc_personsScrollPane.gridwidth = 4;
				gbc_personsScrollPane.gridx = 0;
				gbc_personsScrollPane.gridy = 1;
				personsPanel.add(personsScrollPane, gbc_personsScrollPane);
				{
					personsTable = new JTable();
					personsScrollPane.setViewportView(personsTable);
				}
			}
		}

		if (person != null) {
			m_bindingGroup = initDataBindings();
		}
	}

	public Person getPerson() {

		return person;
	}

	public void setPerson(Person newPerson) {

		setPerson(newPerson, true);
	}

	public void setPerson(Person newPerson, boolean update) {

		person = newPerson;
		if (update) {
			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}
			if (person != null) {
				m_bindingGroup = initDataBindings();
			}
		}
	}

	public void addNewOrderActionListener(ActionListener action) {

		btnNewOrder.addActionListener(action);
	}

	public Person getSelectedPerson() {

		return persons.getPerson(personsTable.getSelectedRow());
	}

	protected BindingGroup initDataBindings() {

		BeanProperty<Person, Integer> idProperty = BeanProperty.create("id");
		BeanProperty<JTextField, String> idTextProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JTextField, String> idAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, person, idProperty,
				idJTextField, idTextProperty);
		idAutoBinding.bind();
		//
		BeanProperty<Person, String> nameProperty = BeanProperty.create("name");
		BeanProperty<JTextField, String> nameTextProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> nameAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				nameProperty, nameJTextField, nameTextProperty);
		nameAutoBinding.bind();
		//
		BeanProperty<Person, String> personBeanProperty_2 = BeanProperty.create("email");
		BeanProperty<JFormattedTextField, String> jFormattedTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JFormattedTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				personBeanProperty_2, emailJFormattedTextField, jFormattedTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<Person, Integer> cNPJProperty = BeanProperty.create("cnpj");
		BeanProperty<JFormattedTextField, String> cNPJTextProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JFormattedTextField, String> cNPJautoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, cNPJProperty, CNPJJFormattedTextField, cNPJTextProperty);
		cNPJautoBinding.bind();
		//
		BeanProperty<Person, Integer> iEProperty = BeanProperty.create("ie");
		BeanProperty<JFormattedTextField, String> iETextProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JFormattedTextField, String> iEAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, iEProperty, IEJFormattedTextField, iETextProperty);
		iEAutoBinding.bind();
		//
		BeanProperty<Person, Integer> cPFProperty = BeanProperty.create("cpf");
		BeanProperty<JFormattedTextField, String> cPFPTextProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JFormattedTextField, String> cPFPAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, cPFProperty, CPFJFormattedTextField, cPFPTextProperty);
		cPFPAutoBinding.bind();
		//
		BeanProperty<Person, String> rGProperty = BeanProperty.create("rg");
		BeanProperty<JFormattedTextField, String> rGTextProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JFormattedTextField, String> rGAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, rGProperty, RGJFormattedTextField, rGTextProperty);
		rGAutoBinding.bind();
		//
		BeanProperty<Person, List<Phone>> personBeanProperty = BeanProperty.create("phones");
		JTableBinding<Phone, Person, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, person,
				personBeanProperty, phonesTable);
		//
		BeanProperty<Phone, Integer> phoneBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(phoneBeanProperty).setColumnName("Id");
		//
		BeanProperty<Phone, String> phoneBeanProperty_1 = BeanProperty.create("type");
		jTableBinding.addColumnBinding(phoneBeanProperty_1).setColumnName("Type");
		//
		BeanProperty<Phone, Integer> phoneBeanProperty_2 = BeanProperty.create("number");
		jTableBinding.addColumnBinding(phoneBeanProperty_2).setColumnName("Number");
		//
		jTableBinding.bind();
		//
		BeanProperty<Person, List<Adress>> personBeanProperty_1 = BeanProperty.create("adresses");
		JTableBinding<Adress, Person, JTable> jTableBinding_1 = SwingBindings.createJTableBinding(UpdateStrategy.READ, person,
				personBeanProperty_1, adressesTable);
		//
		BeanProperty<Adress, Integer> adressBeanProperty = BeanProperty.create("id");
		jTableBinding_1.addColumnBinding(adressBeanProperty).setColumnName("Id");
		//
		BeanProperty<Adress, String> adressBeanProperty_1 = BeanProperty.create("adress");
		jTableBinding_1.addColumnBinding(adressBeanProperty_1).setColumnName("Adress");
		//
		BeanProperty<Adress, Integer> adressBeanProperty_2 = BeanProperty.create("number");
		jTableBinding_1.addColumnBinding(adressBeanProperty_2).setColumnName("Number");
		//
		BeanProperty<Adress, String> adressBeanProperty_3 = BeanProperty.create("complement");
		jTableBinding_1.addColumnBinding(adressBeanProperty_3).setColumnName("Complement");
		//
		BeanProperty<Adress, String> adressBeanProperty_4 = BeanProperty.create("region");
		jTableBinding_1.addColumnBinding(adressBeanProperty_4).setColumnName("Region");
		//
		BeanProperty<Adress, String> adressBeanProperty_5 = BeanProperty.create("city");
		jTableBinding_1.addColumnBinding(adressBeanProperty_5).setColumnName("City");
		//
		BeanProperty<Adress, String> adressBeanProperty_6 = BeanProperty.create("country");
		jTableBinding_1.addColumnBinding(adressBeanProperty_6).setColumnName("Country");
		//
		BeanProperty<Adress, Integer> adressBeanProperty_7 = BeanProperty.create("zipcode");
		jTableBinding_1.addColumnBinding(adressBeanProperty_7).setColumnName("Zip Code");
		//
		jTableBinding_1.bind();
		//
		BeanProperty<Persons, List<Person>> personsBeanProperty = BeanProperty.create("persons");
		JTableBinding<Person, Persons, JTable> jTableBinding_2 = SwingBindings.createJTableBinding(UpdateStrategy.READ, persons,
				personsBeanProperty, personsTable);
		//
		BeanProperty<Person, Integer> personBeanProperty_3 = BeanProperty.create("id");
		jTableBinding_2.addColumnBinding(personBeanProperty_3).setColumnName("Id");
		//
		BeanProperty<Person, String> personBeanProperty_4 = BeanProperty.create("name");
		jTableBinding_2.addColumnBinding(personBeanProperty_4).setColumnName("Name");
		//
		BeanProperty<Person, String> personBeanProperty_5 = BeanProperty.create("email");
		jTableBinding_2.addColumnBinding(personBeanProperty_5).setColumnName("Email");
		//
		BeanProperty<Person, Integer> personBeanProperty_6 = BeanProperty.create("CNPJ");
		jTableBinding_2.addColumnBinding(personBeanProperty_6).setColumnName("CNPJ");
		//
		BeanProperty<Person, Integer> personBeanProperty_7 = BeanProperty.create("IE");
		jTableBinding_2.addColumnBinding(personBeanProperty_7).setColumnName("IE");
		//
		BeanProperty<Person, Integer> personBeanProperty_8 = BeanProperty.create("CPF");
		jTableBinding_2.addColumnBinding(personBeanProperty_8).setColumnName("CPF");
		//
		BeanProperty<Person, String> personBeanProperty_9 = BeanProperty.create("RG");
		jTableBinding_2.addColumnBinding(personBeanProperty_9).setColumnName("RG");
		//
		jTableBinding_2.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(idAutoBinding);
		bindingGroup.addBinding(nameAutoBinding);
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(cNPJautoBinding);
		bindingGroup.addBinding(iEAutoBinding);
		bindingGroup.addBinding(cPFPAutoBinding);
		bindingGroup.addBinding(rGAutoBinding);
		bindingGroup.addBinding(jTableBinding);
		bindingGroup.addBinding(jTableBinding_1);
		bindingGroup.addBinding(jTableBinding_2);
		return bindingGroup;
	}
}

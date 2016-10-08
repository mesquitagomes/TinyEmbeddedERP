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
import org.jdesktop.beansbinding.ELProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import main.java.br.com.mesquitagomes.model.Adress;
import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Person.PersonColumnsEnum;
import main.java.br.com.mesquitagomes.model.Persons;
import main.java.br.com.mesquitagomes.model.Phone;
import main.java.br.com.mesquitagomes.model.validation.PersonValidator;
import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;
import main.java.br.com.mesquitagomes.persistence.PersonPersistence;

public class PersonJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private PersistenceFactory persistenceFactory;
	private PersonPersistence personPersistence;
	private BindingGroup m_bindingGroup;
	private Person person = new Person();
	private Persons persons = new Persons();
	private PhoneJDialog phoneDialog;
	private AdressJDialog adressDialog;
	private JTextField idJTextField;
	private JTextField nameJTextField;
	private JFormattedTextField cnpjJFormattedTextField;
	private JFormattedTextField ieJFormattedTextField;
	private JFormattedTextField cpfJFormattedTextField;
	private JFormattedTextField rgJFormattedTextField;
	private JButton personSaveButton;
	private JPanel personButtonPanel;
	private JButton personDeleteButton;
	private JTable phonesTable;
	private JPanel phonesButtonPanel;
	private JButton phoneNewButton;
	private JButton phoneEditButton;
	private JButton phoneDeleteButton;
	private JTable adressesTable;
	private JPanel adressesButtonPanel;
	private JButton adressNewButton;
	private JButton adressEditButton;
	private JButton adressDeleteButton;
	private JPanel phonesPanel;
	private JPanel adressesPanel;
	private JButton personNewButton;
	private JLabel emailLable;
	private JFormattedTextField emailJFormattedTextField;
	private JPanel personPanel;
	private JSplitPane splitPane;
	private JPanel personsPanel;
	private JTextField findTextField;
	private JButton personFindButton;
	private JButton orderNewButton;
	private JScrollPane personsScrollPane;
	private JTable personsTable;
	private JScrollPane adressesScrollPane;
	private JScrollPane phonesScrollPane;
	private JButton personEditButton;

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

				JLabel cnpjJLabel = new JLabel("CNPJ:");
				GridBagConstraints gbc_cnpjJLabel = new GridBagConstraints();
				gbc_cnpjJLabel.anchor = GridBagConstraints.EAST;
				gbc_cnpjJLabel.fill = GridBagConstraints.VERTICAL;
				gbc_cnpjJLabel.insets = new Insets(0, 0, 5, 5);
				gbc_cnpjJLabel.gridx = 0;
				gbc_cnpjJLabel.gridy = 2;
				personPanel.add(cnpjJLabel, gbc_cnpjJLabel);

				cnpjJFormattedTextField = new JFormattedTextField(PersonValidator.getCnpjMaskFormatter());
				GridBagConstraints gbc_cnpjJFormattedTextField = new GridBagConstraints();
				gbc_cnpjJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_cnpjJFormattedTextField.insets = new Insets(0, 0, 5, 5);
				gbc_cnpjJFormattedTextField.gridx = 1;
				gbc_cnpjJFormattedTextField.gridy = 2;
				personPanel.add(cnpjJFormattedTextField, gbc_cnpjJFormattedTextField);

				JLabel ieLabel = new JLabel("IE:");
				GridBagConstraints gbc_ieLabel = new GridBagConstraints();
				gbc_ieLabel.anchor = GridBagConstraints.EAST;
				gbc_ieLabel.fill = GridBagConstraints.VERTICAL;
				gbc_ieLabel.insets = new Insets(0, 0, 5, 5);
				gbc_ieLabel.gridx = 2;
				gbc_ieLabel.gridy = 2;
				personPanel.add(ieLabel, gbc_ieLabel);

				ieJFormattedTextField = new JFormattedTextField(PersonValidator.getIeMaskFormatter());
				GridBagConstraints gbc_ieJFormattedTextField = new GridBagConstraints();
				gbc_ieJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_ieJFormattedTextField.insets = new Insets(0, 0, 5, 0);
				gbc_ieJFormattedTextField.gridx = 3;
				gbc_ieJFormattedTextField.gridy = 2;
				personPanel.add(ieJFormattedTextField, gbc_ieJFormattedTextField);

				JLabel cpfLabel = new JLabel("CPF:");
				GridBagConstraints gbc_cpfLabel = new GridBagConstraints();
				gbc_cpfLabel.anchor = GridBagConstraints.EAST;
				gbc_cpfLabel.fill = GridBagConstraints.VERTICAL;
				gbc_cpfLabel.insets = new Insets(0, 0, 5, 5);
				gbc_cpfLabel.gridx = 0;
				gbc_cpfLabel.gridy = 3;
				personPanel.add(cpfLabel, gbc_cpfLabel);

				cpfJFormattedTextField = new JFormattedTextField(PersonValidator.getCpfMaskFormatter());
				GridBagConstraints gbc_cpfJFormattedTextField = new GridBagConstraints();
				gbc_cpfJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_cpfJFormattedTextField.insets = new Insets(0, 0, 5, 5);
				gbc_cpfJFormattedTextField.gridx = 1;
				gbc_cpfJFormattedTextField.gridy = 3;
				personPanel.add(cpfJFormattedTextField, gbc_cpfJFormattedTextField);

				JLabel rgLabel = new JLabel("RG:");
				GridBagConstraints gbc_rgLabel = new GridBagConstraints();
				gbc_rgLabel.anchor = GridBagConstraints.EAST;
				gbc_rgLabel.fill = GridBagConstraints.VERTICAL;
				gbc_rgLabel.insets = new Insets(0, 0, 5, 5);
				gbc_rgLabel.gridx = 2;
				gbc_rgLabel.gridy = 3;
				personPanel.add(rgLabel, gbc_rgLabel);

				rgJFormattedTextField = new JFormattedTextField(PersonValidator.getRgMaskFormatter());
				GridBagConstraints gbc_rgJFormattedTextField = new GridBagConstraints();
				gbc_rgJFormattedTextField.fill = GridBagConstraints.BOTH;
				gbc_rgJFormattedTextField.insets = new Insets(0, 0, 5, 0);
				gbc_rgJFormattedTextField.gridx = 3;
				gbc_rgJFormattedTextField.gridy = 3;
				personPanel.add(rgJFormattedTextField, gbc_rgJFormattedTextField);

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
						phoneNewButton = new JButton("New");
						phoneNewButton.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {

								Phone phone = new Phone(person);
								person.addPhone(phone);
								phoneDialog = new PhoneJDialog(MainJFrame.getInstance(null), phone);
								phoneDialog.setVisible(true);
								phonesTable.repaint();
							}
						});
						phonesButtonPanel.add(phoneNewButton);

						phoneEditButton = new JButton("Edit");
						phoneEditButton.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {

								Phone phone = person.getPhone(phonesTable.getSelectedRow());
								phoneDialog = new PhoneJDialog(MainJFrame.getInstance(null), phone);
								phoneDialog.setVisible(true);
								phonesTable.repaint();
							}
						});
						phonesButtonPanel.add(phoneEditButton);

						phoneDeleteButton = new JButton("Delete");
						phoneDeleteButton.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {

								Phone phone = person.getPhone(phonesTable.getSelectedRow());
								person.removePhone(phone);
								phonesTable.repaint();
							}
						});
						phonesButtonPanel.add(phoneDeleteButton);
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
						adressNewButton = new JButton("New");
						adressNewButton.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {

								Adress adress = new Adress(person);
								person.addAdress(adress);
								adressDialog = new AdressJDialog(MainJFrame.getInstance(null), adress);
								adressDialog.setVisible(true);
								adressesTable.repaint();
							}
						});
						adressesButtonPanel.add(adressNewButton);

						adressEditButton = new JButton("Edit");
						adressEditButton.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {

								Adress adress = person.getAdress(adressesTable.getSelectedRow());
								adressDialog = new AdressJDialog(MainJFrame.getInstance(null), adress);
								adressDialog.setVisible(true);
								adressesTable.repaint();
							}
						});
						adressesButtonPanel.add(adressEditButton);

						adressDeleteButton = new JButton("Delete");
						adressDeleteButton.addActionListener(new ActionListener() {

							public void actionPerformed(ActionEvent e) {

								Adress adress = person.getAdress(adressesTable.getSelectedRow());
								person.removeAdress(adress);
								adressesTable.repaint();
							}
						});
						adressesButtonPanel.add(adressDeleteButton);
					}

					adressesScrollPane = new JScrollPane();
					GridBagConstraints gbc_adressesScrollPane = new GridBagConstraints();
					gbc_adressesScrollPane.fill = GridBagConstraints.BOTH;
					gbc_adressesScrollPane.gridx = 0;
					gbc_adressesScrollPane.gridy = 1;
					adressesPanel.add(adressesScrollPane, gbc_adressesScrollPane);
					{
						adressesTable = new JTable();
						adressesScrollPane.setViewportView(adressesTable);
					}
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

					personSaveButton = new JButton("Save");
					personSaveButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							if (person.getId() == null) personPersistence.persist(person);
							else person = personPersistence.merge(person);
							JOptionPane.showMessageDialog(getParent(), "Person saved.\n" + person);
							setPerson(person);
						}
					});
					personButtonPanel.add(personSaveButton);

					personNewButton = new JButton("New");
					personNewButton.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							Person newPerson = new Person();
							setPerson(newPerson);
							nameJTextField.requestFocus();
						}
					});

					personButtonPanel.add(personNewButton);
				}
			}
			personsPanel = new JPanel();
			personsPanel.setBorder(new TitledBorder(null, "Find Persons", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			splitPane.setRightComponent(personsPanel);
			GridBagLayout gbl_personsPanel = new GridBagLayout();
			gbl_personsPanel.columnWidths = new int[] { 81, 59, 0, 0, 97, 0 };
			gbl_personsPanel.rowHeights = new int[] { 25, 42, 0 };
			gbl_personsPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
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

				personFindButton = new JButton("Find");
				personFindButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						List<Person> newPpersons;
						String value = findTextField.getText();
						try {
							int val = Integer.valueOf(value);
							newPpersons = personPersistence.getByDocsLikeOr(val, val, val, val);
							newPpersons.add(personPersistence.getById(val));
						} catch (NumberFormatException e1) {
							newPpersons = personPersistence.getByColumn(PersonColumnsEnum.name.name(), value);
						}
						persons.setPersons(newPpersons);
						personsTable.repaint();
					}
				});
				GridBagConstraints gbc_personFindButton = new GridBagConstraints();
				gbc_personFindButton.anchor = GridBagConstraints.NORTHWEST;
				gbc_personFindButton.insets = new Insets(0, 0, 5, 5);
				gbc_personFindButton.gridx = 1;
				gbc_personFindButton.gridy = 0;
				personsPanel.add(personFindButton, gbc_personFindButton);

				personEditButton = new JButton("Edit");
				personEditButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						Person newPerson = persons.getPerson(personsTable.getSelectedRow());
						setPerson(newPerson);
					}
				});
				GridBagConstraints gbc_personEditButton = new GridBagConstraints();
				gbc_personEditButton.insets = new Insets(0, 0, 5, 5);
				gbc_personEditButton.gridx = 2;
				gbc_personEditButton.gridy = 0;
				personsPanel.add(personEditButton, gbc_personEditButton);

				personDeleteButton = new JButton("Delete");
				GridBagConstraints gbc_personDeleteButton = new GridBagConstraints();
				gbc_personDeleteButton.insets = new Insets(0, 0, 5, 5);
				gbc_personDeleteButton.gridx = 3;
				gbc_personDeleteButton.gridy = 0;
				personsPanel.add(personDeleteButton, gbc_personDeleteButton);
				personDeleteButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						Person newPerson = persons.getPerson(personsTable.getSelectedRow());
						personPersistence.remove(newPerson);
						persons.removePerson(newPerson);
						personsTable.repaint();
					}
				});

				orderNewButton = new JButton("New Order");
				GridBagConstraints gbc_orderNewButton = new GridBagConstraints();
				gbc_orderNewButton.anchor = GridBagConstraints.NORTHWEST;
				gbc_orderNewButton.insets = new Insets(0, 0, 5, 0);
				gbc_orderNewButton.gridx = 4;
				gbc_orderNewButton.gridy = 0;
				personsPanel.add(orderNewButton, gbc_orderNewButton);

				personsScrollPane = new JScrollPane();
				GridBagConstraints gbc_personsScrollPane = new GridBagConstraints();
				gbc_personsScrollPane.fill = GridBagConstraints.BOTH;
				gbc_personsScrollPane.gridwidth = 5;
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
			if (person != null) m_bindingGroup = initDataBindings();
		}
	}

	public void addNewOrderButtonActionListener(ActionListener action) {

		orderNewButton.addActionListener(action);
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
		BeanProperty<Person, String> emailBeanProperty = BeanProperty.create("email");
		BeanProperty<JFormattedTextField, String> emailTextProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JFormattedTextField, String> emailAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, emailBeanProperty, emailJFormattedTextField, emailTextProperty);
		emailAutoBinding.bind();
		//
		BeanProperty<Person, String> cnpjProperty = BeanProperty.create("cnpj");
		BeanProperty<JFormattedTextField, String> cnpjTextProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JFormattedTextField, String> cnpjAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, cnpjProperty, cnpjJFormattedTextField, cnpjTextProperty);
		cnpjAutoBinding.bind();
		//
		BeanProperty<Person, String> ieProperty = BeanProperty.create("ie");
		BeanProperty<JFormattedTextField, String> ieTextProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JFormattedTextField, String> ieAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, ieProperty, ieJFormattedTextField, ieTextProperty);
		ieAutoBinding.bind();
		//
		BeanProperty<Person, String> cpfProperty = BeanProperty.create("cpf");
		BeanProperty<JFormattedTextField, String> cpfTextProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JFormattedTextField, String> cpfAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, cpfProperty, cpfJFormattedTextField, cpfTextProperty);
		cpfAutoBinding.bind();
		//
		BeanProperty<Person, String> rgProperty = BeanProperty.create("rg");
		BeanProperty<JFormattedTextField, String> rgTextProperty = BeanProperty.create("text");
		AutoBinding<Person, String, JFormattedTextField, String> rgAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, rgProperty, rgJFormattedTextField, rgTextProperty);
		rgAutoBinding.bind();
		//
		BeanProperty<Person, List<Phone>> phonesBeanProperty = BeanProperty.create("phones");
		JTableBinding<Phone, Person, JTable> phonesJTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, person,
				phonesBeanProperty, phonesTable);
		//
		BeanProperty<Phone, String> phoneBeanProperty_1 = BeanProperty.create("type");
		phonesJTableBinding.addColumnBinding(phoneBeanProperty_1).setColumnName("Type");
		//
		BeanProperty<Phone, Integer> phoneBeanProperty_2 = BeanProperty.create("number");
		phonesJTableBinding.addColumnBinding(phoneBeanProperty_2).setColumnName("Number");
		//
		phonesJTableBinding.bind();
		//
		BeanProperty<Person, List<Adress>> adressesBeanProperty = BeanProperty.create("adresses");
		JTableBinding<Adress, Person, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, person,
				adressesBeanProperty, adressesTable);
		//
		BeanProperty<Adress, String> adressBeanProperty = BeanProperty.create("adress");
		jTableBinding.addColumnBinding(adressBeanProperty).setColumnName("Adress");
		//
		BeanProperty<Adress, Integer> adressBeanProperty_1 = BeanProperty.create("number");
		jTableBinding.addColumnBinding(adressBeanProperty_1).setColumnName("Number");
		//
		BeanProperty<Adress, String> adressBeanProperty_2 = BeanProperty.create("complement");
		jTableBinding.addColumnBinding(adressBeanProperty_2).setColumnName("Complement");
		//
		BeanProperty<Adress, String> adressBeanProperty_3 = BeanProperty.create("district");
		jTableBinding.addColumnBinding(adressBeanProperty_3).setColumnName("District");
		//
		BeanProperty<Adress, String> adressBeanProperty_4 = BeanProperty.create("region");
		jTableBinding.addColumnBinding(adressBeanProperty_4).setColumnName("Region");
		//
		BeanProperty<Adress, String> adressBeanProperty_5 = BeanProperty.create("city");
		jTableBinding.addColumnBinding(adressBeanProperty_5).setColumnName("City");
		//
		BeanProperty<Adress, String> adressBeanProperty_6 = BeanProperty.create("country");
		jTableBinding.addColumnBinding(adressBeanProperty_6).setColumnName("Country");
		//
		BeanProperty<Adress, String> adressBeanProperty_7 = BeanProperty.create("zipcode");
		jTableBinding.addColumnBinding(adressBeanProperty_7).setColumnName("Zip Code");
		//
		jTableBinding.bind();
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
		BeanProperty<Person, String> personBeanProperty_6 = BeanProperty.create("cnpj");
		jTableBinding_2.addColumnBinding(personBeanProperty_6).setColumnName("CNPJ");
		//
		BeanProperty<Person, String> personBeanProperty_7 = BeanProperty.create("ie");
		jTableBinding_2.addColumnBinding(personBeanProperty_7).setColumnName("IE");
		//
		BeanProperty<Person, String> personBeanProperty_8 = BeanProperty.create("cpf");
		jTableBinding_2.addColumnBinding(personBeanProperty_8).setColumnName("CPF");
		//
		BeanProperty<Person, String> personBeanProperty_9 = BeanProperty.create("rg");
		jTableBinding_2.addColumnBinding(personBeanProperty_9).setColumnName("RG");
		//
		jTableBinding_2.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty = ELProperty.create("${selectedElement != null}");
		BeanProperty<JButton, Boolean> jButtonBeanProperty = BeanProperty.create("enabled");
		AutoBinding<JTable, Object, JButton, Boolean> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ, phonesTable,
				jTableEvalutionProperty, phoneEditButton, jButtonBeanProperty);
		autoBinding.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty_1 = ELProperty.create("${selectedElement != null}");
		AutoBinding<JTable, Object, JButton, Boolean> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ, phonesTable,
				jTableEvalutionProperty_1, phoneDeleteButton, jButtonBeanProperty);
		autoBinding_1.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty_2 = ELProperty.create("${selectedElement != null}");
		AutoBinding<JTable, Object, JButton, Boolean> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ, adressesTable,
				jTableEvalutionProperty_2, adressEditButton, jButtonBeanProperty);
		autoBinding_2.bind();
		//
		ELProperty<JTable, Object> jTableEvalutionProperty_3 = ELProperty.create("${selectedElement != null}");
		AutoBinding<JTable, Object, JButton, Boolean> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ, adressesTable,
				jTableEvalutionProperty_3, adressDeleteButton, jButtonBeanProperty);
		autoBinding_3.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(idAutoBinding);
		bindingGroup.addBinding(nameAutoBinding);
		bindingGroup.addBinding(emailAutoBinding);
		bindingGroup.addBinding(cnpjAutoBinding);
		bindingGroup.addBinding(ieAutoBinding);
		bindingGroup.addBinding(cpfAutoBinding);
		bindingGroup.addBinding(rgAutoBinding);
		bindingGroup.addBinding(phonesJTableBinding);
		bindingGroup.addBinding(jTableBinding);
		bindingGroup.addBinding(jTableBinding_2);
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		return bindingGroup;
	}
}

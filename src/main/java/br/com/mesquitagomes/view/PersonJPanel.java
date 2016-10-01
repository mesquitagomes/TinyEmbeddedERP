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
import main.java.br.com.mesquitagomes.model.Phone;
import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;
import main.java.br.com.mesquitagomes.persistence.PersonPersistence;

public class PersonJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private PersistenceFactory persistenceFactory;
	private PersonPersistence personPersistence;
	private BindingGroup m_bindingGroup;
	private Person person = new Person();
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
	private JButton btnAddPhone;
	private JButton btnEditPhone;
	private JButton btnDeletePhone;
	private JTable adressesTable;
	private JPanel adressesButtonPanel;
	private JButton btnAddAdress;
	private JButton btnEditAdress;
	private JButton btnDeleteAdress;
	private JPanel phonesPanel;
	private JPanel adressesPanel;
	private JButton btnNewPerson;
	private JLabel emailLable;
	private JFormattedTextField emailJFormattedTextField;

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
		gridBagLayout.columnWidths = new int[] { 50, 0, 50, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4 };
		setLayout(gridBagLayout);

		JLabel idLabel = new JLabel("Id:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.anchor = GridBagConstraints.EAST;
		labelGbc_0.fill = GridBagConstraints.VERTICAL;
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		add(idLabel, labelGbc_0);

		idJTextField = new JTextField();
		idJTextField.setEditable(false);
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 5);
		componentGbc_0.fill = GridBagConstraints.BOTH;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		add(idJTextField, componentGbc_0);

		JLabel nameLabel = new JLabel("Name:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.anchor = GridBagConstraints.EAST;
		labelGbc_1.fill = GridBagConstraints.VERTICAL;
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		add(nameLabel, labelGbc_1);

		nameJTextField = new JTextField();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 5);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		add(nameJTextField, componentGbc_1);

		emailLable = new JLabel("Email:");
		GridBagConstraints gbc_emailLable = new GridBagConstraints();
		gbc_emailLable.anchor = GridBagConstraints.EAST;
		gbc_emailLable.insets = new Insets(0, 0, 5, 5);
		gbc_emailLable.gridx = 2;
		gbc_emailLable.gridy = 1;
		add(emailLable, gbc_emailLable);

		emailJFormattedTextField = new JFormattedTextField();
		GridBagConstraints gbc_emailJFormattedTextField = new GridBagConstraints();
		gbc_emailJFormattedTextField.insets = new Insets(0, 0, 5, 0);
		gbc_emailJFormattedTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailJFormattedTextField.gridx = 3;
		gbc_emailJFormattedTextField.gridy = 1;
		add(emailJFormattedTextField, gbc_emailJFormattedTextField);

		JLabel CNPJLabel = new JLabel("CNPJ:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.anchor = GridBagConstraints.EAST;
		labelGbc_2.fill = GridBagConstraints.VERTICAL;
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 2;
		add(CNPJLabel, labelGbc_2);

		CNPJJFormattedTextField = new JFormattedTextField();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.insets = new Insets(5, 0, 5, 5);
		componentGbc_2.fill = GridBagConstraints.BOTH;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 2;
		add(CNPJJFormattedTextField, componentGbc_2);

		JLabel IELabel = new JLabel("IE:");
		GridBagConstraints labelGbc_3 = new GridBagConstraints();
		labelGbc_3.anchor = GridBagConstraints.EAST;
		labelGbc_3.fill = GridBagConstraints.VERTICAL;
		labelGbc_3.insets = new Insets(5, 5, 5, 5);
		labelGbc_3.gridx = 2;
		labelGbc_3.gridy = 2;
		add(IELabel, labelGbc_3);

		IEJFormattedTextField = new JFormattedTextField();
		GridBagConstraints componentGbc_3 = new GridBagConstraints();
		componentGbc_3.insets = new Insets(5, 0, 5, 0);
		componentGbc_3.fill = GridBagConstraints.BOTH;
		componentGbc_3.gridx = 3;
		componentGbc_3.gridy = 2;
		add(IEJFormattedTextField, componentGbc_3);

		JLabel CPFLabel = new JLabel("CPF:");
		GridBagConstraints labelGbc_4 = new GridBagConstraints();
		labelGbc_4.anchor = GridBagConstraints.EAST;
		labelGbc_4.fill = GridBagConstraints.VERTICAL;
		labelGbc_4.insets = new Insets(5, 5, 5, 5);
		labelGbc_4.gridx = 0;
		labelGbc_4.gridy = 3;
		add(CPFLabel, labelGbc_4);

		CPFJFormattedTextField = new JFormattedTextField();
		GridBagConstraints componentGbc_4 = new GridBagConstraints();
		componentGbc_4.insets = new Insets(5, 0, 5, 5);
		componentGbc_4.fill = GridBagConstraints.BOTH;
		componentGbc_4.gridx = 1;
		componentGbc_4.gridy = 3;
		add(CPFJFormattedTextField, componentGbc_4);

		JLabel RGLabel = new JLabel("RG:");
		GridBagConstraints labelGbc_5 = new GridBagConstraints();
		labelGbc_5.anchor = GridBagConstraints.EAST;
		labelGbc_5.fill = GridBagConstraints.VERTICAL;
		labelGbc_5.insets = new Insets(5, 5, 5, 5);
		labelGbc_5.gridx = 2;
		labelGbc_5.gridy = 3;
		add(RGLabel, labelGbc_5);

		RGJFormattedTextField = new JFormattedTextField();
		GridBagConstraints componentGbc_5 = new GridBagConstraints();
		componentGbc_5.insets = new Insets(5, 0, 5, 0);
		componentGbc_5.fill = GridBagConstraints.BOTH;
		componentGbc_5.gridx = 3;
		componentGbc_5.gridy = 3;
		add(RGJFormattedTextField, componentGbc_5);

		phonesPanel = new JPanel();
		phonesPanel.setBorder(new TitledBorder(null, "Phones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridwidth = 4;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		add(phonesPanel, gbc_panel_2);
		{
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[] { 0, 0 };
			gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
			phonesPanel.setLayout(gbl_panel_2);

			phonesButtonPanel = new JPanel();
			GridBagConstraints gbc_panel = new GridBagConstraints();
			gbc_panel.anchor = GridBagConstraints.WEST;
			gbc_panel.fill = GridBagConstraints.VERTICAL;
			gbc_panel.insets = new Insets(0, 0, 5, 0);
			gbc_panel.gridx = 0;
			gbc_panel.gridy = 0;
			phonesPanel.add(phonesButtonPanel, gbc_panel);
			{
				btnAddPhone = new JButton("Add");
				phonesButtonPanel.add(btnAddPhone);

				btnEditPhone = new JButton("Edit");
				phonesButtonPanel.add(btnEditPhone);

				btnDeletePhone = new JButton("Delete");
				phonesButtonPanel.add(btnDeletePhone);
			}
		}

		phonesTable = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridheight = 2;
		gbc_table.gridx = 0;
		gbc_table.gridy = 1;
		phonesPanel.add(phonesTable, gbc_table);

		adressesPanel = new JPanel();
		adressesPanel.setBorder(new TitledBorder(null, "Adresses", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_adressesPanel = new GridBagConstraints();
		gbc_adressesPanel.fill = GridBagConstraints.BOTH;
		gbc_adressesPanel.gridwidth = 4;
		gbc_adressesPanel.insets = new Insets(0, 0, 5, 0);
		gbc_adressesPanel.gridx = 0;
		gbc_adressesPanel.gridy = 5;
		add(adressesPanel, gbc_adressesPanel);
		{
			GridBagLayout gbl_adressesPanel = new GridBagLayout();
			gbl_adressesPanel.columnWidths = new int[] { 0, 0 };
			gbl_adressesPanel.rowHeights = new int[] { 0, 0, 0, 0 };
			gbl_adressesPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
			gbl_adressesPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
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
				btnAddAdress = new JButton("Add");
				adressesButtonPanel.add(btnAddAdress);

				btnEditAdress = new JButton("Edit");
				adressesButtonPanel.add(btnEditAdress);

				btnDeleteAdress = new JButton("Delete");
				adressesButtonPanel.add(btnDeleteAdress);
			}
			adressesTable = new JTable();
			GridBagConstraints gbc_adressesTable = new GridBagConstraints();
			gbc_adressesTable.gridheight = 2;
			gbc_adressesTable.fill = GridBagConstraints.BOTH;
			gbc_adressesTable.gridx = 0;
			gbc_adressesTable.gridy = 1;
			adressesPanel.add(adressesTable, gbc_adressesTable);
		}

		personButtonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) personButtonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_personButtonPanel = new GridBagConstraints();
		gbc_personButtonPanel.gridwidth = 4;
		gbc_personButtonPanel.fill = GridBagConstraints.BOTH;
		gbc_personButtonPanel.gridx = 0;
		gbc_personButtonPanel.gridy = 6;
		add(personButtonPanel, gbc_personButtonPanel);
		{

			btnNewPerson = new JButton("New");
			btnNewPerson.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					Person newPerson = new Person();
					newPerson.setName("??????");
					setPerson(newPerson);
				}
			});
			personButtonPanel.add(btnNewPerson);

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

			btnDeletePerson = new JButton("Delete");
			btnDeletePerson.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {

					personPersistence.remove(person);
				}
			});
			personButtonPanel.add(btnDeletePerson);
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
		BeanProperty<Person, Integer> cNPJProperty = BeanProperty.create("CNPJ");
		BeanProperty<JFormattedTextField, String> cNPJTextProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JFormattedTextField, String> cNPJautoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, cNPJProperty, CNPJJFormattedTextField, cNPJTextProperty);
		cNPJautoBinding.bind();
		//
		BeanProperty<Person, Integer> iEProperty = BeanProperty.create("IE");
		BeanProperty<JFormattedTextField, String> iETextProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JFormattedTextField, String> iEAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, iEProperty, IEJFormattedTextField, iETextProperty);
		iEAutoBinding.bind();
		//
		BeanProperty<Person, Integer> cPFProperty = BeanProperty.create("CPF");
		BeanProperty<JFormattedTextField, String> cPFPTextProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JFormattedTextField, String> cPFPAutoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				person, cPFProperty, CPFJFormattedTextField, cPFPTextProperty);
		cPFPAutoBinding.bind();
		//
		BeanProperty<Person, String> rGProperty = BeanProperty.create("RG");
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
		return bindingGroup;
	}
}

package main.java.br.com.mesquitagomes.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Persons;
import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;
import main.java.br.com.mesquitagomes.persistence.PersonPersistence;

public class PersonTableJPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private PersistenceFactory persistenceFactory;
	private PersonPersistence personPersistence;
	private Persons persons = new Persons();
	private JTextField textField;
	private JTable personsTable;
	private JButton btnNewOrder;

	public PersonTableJPanel(PersistenceFactory persistenceFactory) {

		this();
		this.persistenceFactory = persistenceFactory;
		personPersistence = this.persistenceFactory.getPersonPersistence();
		persons.setPersons(personPersistence.getAll());
		// initDataBindings();
	}

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
		btnFind.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// TODO
				textField.getText();
			}
		});
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
			// personsTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			scrollPane.setViewportView(personsTable);
		}

		initDataBindings();
	}

	public void addPerson(Person person) {

		persons.addPerson(person);
	}

	public void removePerson(Person person) {

		persons.removePerson(person);
	}

	protected void initDataBindings() {

		BeanProperty<Persons, List<Person>> personsBeanProperty = BeanProperty.create("persons");
		JTableBinding<Person, Persons, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, persons,
				personsBeanProperty, personsTable);
		//
		BeanProperty<Person, Integer> personBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personBeanProperty).setColumnName("Id");
		//
		BeanProperty<Person, String> personBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(personBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Person, String> personBeanProperty_2 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(personBeanProperty_2).setColumnName("Email");
		//
		BeanProperty<Person, Integer> personBeanProperty_3 = BeanProperty.create("CNPJ");
		jTableBinding.addColumnBinding(personBeanProperty_3).setColumnName("CNPJ");
		//
		BeanProperty<Person, Integer> personBeanProperty_4 = BeanProperty.create("IE");
		jTableBinding.addColumnBinding(personBeanProperty_4).setColumnName("IE");
		//
		BeanProperty<Person, Integer> personBeanProperty_5 = BeanProperty.create("CPF");
		jTableBinding.addColumnBinding(personBeanProperty_5).setColumnName("CPF");
		//
		BeanProperty<Person, String> personBeanProperty_6 = BeanProperty.create("RG");
		jTableBinding.addColumnBinding(personBeanProperty_6).setColumnName("RG");
		//
		jTableBinding.bind();
	}
}

package test.java.br.com.mesquitagomes.view;

import java.awt.EventQueue;
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

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.model.Persons;

public class PersonTest extends JFrame {

	private static final long serialVersionUID = 1L;

	private BindingGroup m_bindingGroup;
	private JPanel m_contentPane;
	private Persons persons = new Persons();
	private Person person = new Person();
	private JTextField CNPJJTextField;
	private JTextField CPFJTextField;
	private JTextField IEJTextField;
	private JTextField RGJTextField;
	private JTextField emailJTextField;
	private JTextField idJTextField;
	private JTextField nameJTextField;
	private JButton btnTest;
	private JPanel buttonPanel;
	private JButton btnTest_1;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnShow;
	private JButton btnSave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {

				try {
					PersonTest frame = new PersonTest();
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
	public PersonTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 366);
		m_contentPane = new JPanel();
		setContentPane(m_contentPane);
		//
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0E-4 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4 };
		m_contentPane.setLayout(gridBagLayout);

		JLabel CNPJLabel = new JLabel("CNPJ:");
		GridBagConstraints labelGbc_0 = new GridBagConstraints();
		labelGbc_0.insets = new Insets(5, 5, 5, 5);
		labelGbc_0.gridx = 0;
		labelGbc_0.gridy = 0;
		m_contentPane.add(CNPJLabel, labelGbc_0);

		CNPJJTextField = new JTextField();
		GridBagConstraints componentGbc_0 = new GridBagConstraints();
		componentGbc_0.insets = new Insets(5, 0, 5, 0);
		componentGbc_0.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_0.gridx = 1;
		componentGbc_0.gridy = 0;
		m_contentPane.add(CNPJJTextField, componentGbc_0);

		JLabel CPFLabel = new JLabel("CPF:");
		GridBagConstraints labelGbc_1 = new GridBagConstraints();
		labelGbc_1.insets = new Insets(5, 5, 5, 5);
		labelGbc_1.gridx = 0;
		labelGbc_1.gridy = 1;
		m_contentPane.add(CPFLabel, labelGbc_1);

		CPFJTextField = new JTextField();
		GridBagConstraints componentGbc_1 = new GridBagConstraints();
		componentGbc_1.insets = new Insets(5, 0, 5, 0);
		componentGbc_1.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_1.gridx = 1;
		componentGbc_1.gridy = 1;
		m_contentPane.add(CPFJTextField, componentGbc_1);

		JLabel IELabel = new JLabel("IE:");
		GridBagConstraints labelGbc_2 = new GridBagConstraints();
		labelGbc_2.insets = new Insets(5, 5, 5, 5);
		labelGbc_2.gridx = 0;
		labelGbc_2.gridy = 2;
		m_contentPane.add(IELabel, labelGbc_2);

		IEJTextField = new JTextField();
		GridBagConstraints componentGbc_2 = new GridBagConstraints();
		componentGbc_2.insets = new Insets(5, 0, 5, 0);
		componentGbc_2.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_2.gridx = 1;
		componentGbc_2.gridy = 2;
		m_contentPane.add(IEJTextField, componentGbc_2);

		JLabel RGLabel = new JLabel("RG:");
		GridBagConstraints labelGbc_3 = new GridBagConstraints();
		labelGbc_3.insets = new Insets(5, 5, 5, 5);
		labelGbc_3.gridx = 0;
		labelGbc_3.gridy = 3;
		m_contentPane.add(RGLabel, labelGbc_3);

		RGJTextField = new JTextField();
		GridBagConstraints componentGbc_3 = new GridBagConstraints();
		componentGbc_3.insets = new Insets(5, 0, 5, 0);
		componentGbc_3.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_3.gridx = 1;
		componentGbc_3.gridy = 3;
		m_contentPane.add(RGJTextField, componentGbc_3);

		JLabel emailLabel = new JLabel("Email:");
		GridBagConstraints labelGbc_4 = new GridBagConstraints();
		labelGbc_4.insets = new Insets(5, 5, 5, 5);
		labelGbc_4.gridx = 0;
		labelGbc_4.gridy = 4;
		m_contentPane.add(emailLabel, labelGbc_4);

		emailJTextField = new JTextField();
		GridBagConstraints componentGbc_4 = new GridBagConstraints();
		componentGbc_4.insets = new Insets(5, 0, 5, 0);
		componentGbc_4.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_4.gridx = 1;
		componentGbc_4.gridy = 4;
		m_contentPane.add(emailJTextField, componentGbc_4);

		JLabel idLabel = new JLabel("Id:");
		GridBagConstraints labelGbc_5 = new GridBagConstraints();
		labelGbc_5.insets = new Insets(5, 5, 5, 5);
		labelGbc_5.gridx = 0;
		labelGbc_5.gridy = 5;
		m_contentPane.add(idLabel, labelGbc_5);

		idJTextField = new JTextField();
		GridBagConstraints componentGbc_5 = new GridBagConstraints();
		componentGbc_5.insets = new Insets(5, 0, 5, 0);
		componentGbc_5.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_5.gridx = 1;
		componentGbc_5.gridy = 5;
		m_contentPane.add(idJTextField, componentGbc_5);

		JLabel nameLabel = new JLabel("Name:");
		GridBagConstraints labelGbc_6 = new GridBagConstraints();
		labelGbc_6.insets = new Insets(5, 5, 5, 5);
		labelGbc_6.gridx = 0;
		labelGbc_6.gridy = 6;
		m_contentPane.add(nameLabel, labelGbc_6);

		nameJTextField = new JTextField();
		GridBagConstraints componentGbc_6 = new GridBagConstraints();
		componentGbc_6.insets = new Insets(5, 0, 5, 0);
		componentGbc_6.fill = GridBagConstraints.HORIZONTAL;
		componentGbc_6.gridx = 1;
		componentGbc_6.gridy = 6;
		m_contentPane.add(nameJTextField, componentGbc_6);

		buttonPanel = new JPanel();
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 0);
		gbc_buttonPanel.anchor = GridBagConstraints.EAST;
		gbc_buttonPanel.fill = GridBagConstraints.VERTICAL;
		gbc_buttonPanel.gridx = 1;
		gbc_buttonPanel.gridy = 7;
		m_contentPane.add(buttonPanel, gbc_buttonPanel);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.columnWidths = new int[] { 0, 59, 67, 0, 0 };
		gbl_buttonPanel.rowHeights = new int[] { 25, 0 };
		gbl_buttonPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_buttonPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		buttonPanel.setLayout(gbl_buttonPanel);

		btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(m_contentPane.getParent(), person.toString());
			}
		});
		GridBagConstraints gbc_btnShow = new GridBagConstraints();
		gbc_btnShow.insets = new Insets(0, 0, 0, 5);
		gbc_btnShow.gridx = 0;
		gbc_btnShow.gridy = 0;
		buttonPanel.add(btnShow, gbc_btnShow);

		btnTest = new JButton("New");
		GridBagConstraints gbc_btnTest = new GridBagConstraints();
		gbc_btnTest.insets = new Insets(0, 0, 0, 5);
		gbc_btnTest.gridx = 1;
		gbc_btnTest.gridy = 0;
		buttonPanel.add(btnTest, gbc_btnTest);
		btnTest.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				persons.addPerson(person);
				setPerson(new Person());
				table.repaint();
			}
		});

		btnTest_1 = new JButton("Edit");
		btnTest_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				setPerson(persons.getPerson(table.getSelectedRow()));
			}
		});
		GridBagConstraints gbc_btnTest_1 = new GridBagConstraints();
		gbc_btnTest_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnTest_1.gridx = 2;
		gbc_btnTest_1.gridy = 0;
		buttonPanel.add(btnTest_1, gbc_btnTest_1);

		btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				setPerson(new Person());
				table.repaint();
			}
		});
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.gridx = 3;
		gbc_btnSave.gridy = 0;
		buttonPanel.add(btnSave, gbc_btnSave);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 8;
		m_contentPane.add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

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

		BeanProperty<Person, Integer> cNPJProperty = BeanProperty.create("CNPJ");
		BeanProperty<JTextField, String> textProperty = BeanProperty.create("text");
		AutoBinding<Person, Integer, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				cNPJProperty, CNPJJTextField, textProperty);
		autoBinding.bind();
		//
		BeanProperty<Person, Integer> cPFProperty = BeanProperty.create("CPF");
		BeanProperty<JTextField, String> textProperty_1 = BeanProperty.create("text");
		AutoBinding<Person, Integer, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				cPFProperty, CPFJTextField, textProperty_1);
		autoBinding_1.bind();
		//
		BeanProperty<Person, Integer> iEProperty = BeanProperty.create("IE");
		BeanProperty<JTextField, String> textProperty_2 = BeanProperty.create("text");
		AutoBinding<Person, Integer, JTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				iEProperty, IEJTextField, textProperty_2);
		autoBinding_2.bind();
		//
		BeanProperty<Person, String> rGProperty = BeanProperty.create("RG");
		BeanProperty<JTextField, String> textProperty_3 = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				rGProperty, RGJTextField, textProperty_3);
		autoBinding_3.bind();
		//
		BeanProperty<Person, String> emailProperty = BeanProperty.create("email");
		BeanProperty<JTextField, String> textProperty_4 = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				emailProperty, emailJTextField, textProperty_4);
		autoBinding_4.bind();
		//
		BeanProperty<Person, Integer> idProperty = BeanProperty.create("id");
		BeanProperty<JTextField, String> textProperty_5 = BeanProperty.create("text");
		AutoBinding<Person, Integer, JTextField, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				idProperty, idJTextField, textProperty_5);
		autoBinding_5.bind();
		//
		BeanProperty<Person, String> nameProperty = BeanProperty.create("name");
		BeanProperty<JTextField, String> textProperty_6 = BeanProperty.create("text");
		AutoBinding<Person, String, JTextField, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, person,
				nameProperty, nameJTextField, textProperty_6);
		autoBinding_6.bind();
		//
		BeanProperty<Persons, List<Person>> personsBeanProperty = BeanProperty.create("persons");
		JTableBinding<Person, Persons, JTable> jTableBinding = SwingBindings.createJTableBinding(UpdateStrategy.READ, persons,
				personsBeanProperty, table);
		//
		BeanProperty<Person, Integer> personBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(personBeanProperty).setColumnName("Id");
		//
		BeanProperty<Person, String> personBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(personBeanProperty_1).setColumnName("Name");
		//
		BeanProperty<Person, Integer> personBeanProperty_2 = BeanProperty.create("CNPJ");
		jTableBinding.addColumnBinding(personBeanProperty_2).setColumnName("CNPJ");
		//
		BeanProperty<Person, Integer> personBeanProperty_4 = BeanProperty.create("CPF");
		jTableBinding.addColumnBinding(personBeanProperty_4).setColumnName("CPF");
		//
		BeanProperty<Person, String> personBeanProperty_3 = BeanProperty.create("email");
		jTableBinding.addColumnBinding(personBeanProperty_3).setColumnName("Email");
		//
		jTableBinding.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		bindingGroup.addBinding(autoBinding_2);
		bindingGroup.addBinding(autoBinding_3);
		bindingGroup.addBinding(autoBinding_4);
		bindingGroup.addBinding(autoBinding_5);
		bindingGroup.addBinding(autoBinding_6);
		bindingGroup.addBinding(jTableBinding);
		return bindingGroup;
	}
}

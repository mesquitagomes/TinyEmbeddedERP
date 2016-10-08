package main.java.br.com.mesquitagomes.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

import main.java.br.com.mesquitagomes.model.Adress;
import main.java.br.com.mesquitagomes.model.validation.AdressValidator;

public class AdressJDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private BindingGroup m_bindingGroup;
	private Adress adress;
	private final JPanel contentPanel = new JPanel();
	private JFormattedTextField zipcodeFormattedTextField;
	private JTextField adressJTextField;
	private JFormattedTextField numberFormattedTextField;
	private JTextField complementTextField;
	private JTextField cityTextField;
	private JTextField regionTextField;
	private JTextField contryTextField;
	private JTextField districtTextField;

	public AdressJDialog(Frame frame, Adress adress) {

		super(frame);

		this.adress = adress;

		setTitle("Adress");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 500, 210);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel typeLabel = new JLabel("Zip Code:");
			GridBagConstraints gbc_typeLabel = new GridBagConstraints();
			gbc_typeLabel.insets = new Insets(0, 0, 5, 5);
			gbc_typeLabel.anchor = GridBagConstraints.EAST;
			gbc_typeLabel.gridx = 0;
			gbc_typeLabel.gridy = 0;
			contentPanel.add(typeLabel, gbc_typeLabel);
		}
		{
			zipcodeFormattedTextField = new JFormattedTextField(AdressValidator.getZipcodeMaskFormatter());
			GridBagConstraints gbc_typeFormattedTextField = new GridBagConstraints();
			gbc_typeFormattedTextField.insets = new Insets(0, 0, 5, 5);
			gbc_typeFormattedTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_typeFormattedTextField.gridx = 1;
			gbc_typeFormattedTextField.gridy = 0;
			contentPanel.add(zipcodeFormattedTextField, gbc_typeFormattedTextField);
			zipcodeFormattedTextField.setColumns(10);
		}
		{
			JLabel adressLabel = new JLabel("Adress:");
			GridBagConstraints gbc_adressLabel = new GridBagConstraints();
			gbc_adressLabel.anchor = GridBagConstraints.EAST;
			gbc_adressLabel.insets = new Insets(0, 0, 5, 5);
			gbc_adressLabel.gridx = 0;
			gbc_adressLabel.gridy = 1;
			contentPanel.add(adressLabel, gbc_adressLabel);
		}
		{
			adressJTextField = new JTextField();
			GridBagConstraints gbc_adressJTextField = new GridBagConstraints();
			gbc_adressJTextField.gridwidth = 3;
			gbc_adressJTextField.insets = new Insets(0, 0, 5, 0);
			gbc_adressJTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_adressJTextField.gridx = 1;
			gbc_adressJTextField.gridy = 1;
			contentPanel.add(adressJTextField, gbc_adressJTextField);
		}
		{
			JLabel numberLabel = new JLabel("Number:");
			GridBagConstraints gbc_numberLabel = new GridBagConstraints();
			gbc_numberLabel.anchor = GridBagConstraints.EAST;
			gbc_numberLabel.insets = new Insets(0, 0, 5, 5);
			gbc_numberLabel.gridx = 0;
			gbc_numberLabel.gridy = 2;
			contentPanel.add(numberLabel, gbc_numberLabel);
		}
		{
			numberFormattedTextField = new JFormattedTextField(new NumberFormatter());
			GridBagConstraints gbc_numberFormattedTextField = new GridBagConstraints();
			gbc_numberFormattedTextField.insets = new Insets(0, 0, 5, 5);
			gbc_numberFormattedTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_numberFormattedTextField.gridx = 1;
			gbc_numberFormattedTextField.gridy = 2;
			contentPanel.add(numberFormattedTextField, gbc_numberFormattedTextField);
		}
		{
			JLabel complementLabel = new JLabel("Complement:");
			GridBagConstraints gbc_complementLabel = new GridBagConstraints();
			gbc_complementLabel.anchor = GridBagConstraints.EAST;
			gbc_complementLabel.insets = new Insets(0, 0, 5, 5);
			gbc_complementLabel.gridx = 2;
			gbc_complementLabel.gridy = 2;
			contentPanel.add(complementLabel, gbc_complementLabel);
		}
		{
			complementTextField = new JTextField();
			GridBagConstraints gbc_complementTextField = new GridBagConstraints();
			gbc_complementTextField.insets = new Insets(0, 0, 5, 0);
			gbc_complementTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_complementTextField.gridx = 3;
			gbc_complementTextField.gridy = 2;
			contentPanel.add(complementTextField, gbc_complementTextField);
			complementTextField.setColumns(10);
		}
		{
			JLabel districtLabel = new JLabel("District:");
			GridBagConstraints gbc_districtLabel = new GridBagConstraints();
			gbc_districtLabel.anchor = GridBagConstraints.EAST;
			gbc_districtLabel.insets = new Insets(0, 0, 5, 5);
			gbc_districtLabel.gridx = 0;
			gbc_districtLabel.gridy = 3;
			contentPanel.add(districtLabel, gbc_districtLabel);
		}
		{
			districtTextField = new JTextField();
			GridBagConstraints gbc_districtTextField = new GridBagConstraints();
			gbc_districtTextField.insets = new Insets(0, 0, 5, 5);
			gbc_districtTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_districtTextField.gridx = 1;
			gbc_districtTextField.gridy = 3;
			contentPanel.add(districtTextField, gbc_districtTextField);
			districtTextField.setColumns(10);
		}
		{
			JLabel cityLabel = new JLabel("City:");
			GridBagConstraints gbc_cityLabel = new GridBagConstraints();
			gbc_cityLabel.anchor = GridBagConstraints.EAST;
			gbc_cityLabel.insets = new Insets(0, 0, 5, 5);
			gbc_cityLabel.gridx = 2;
			gbc_cityLabel.gridy = 3;
			contentPanel.add(cityLabel, gbc_cityLabel);
		}
		{
			cityTextField = new JTextField();
			GridBagConstraints gbc_cityTextField = new GridBagConstraints();
			gbc_cityTextField.insets = new Insets(0, 0, 5, 0);
			gbc_cityTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_cityTextField.gridx = 3;
			gbc_cityTextField.gridy = 3;
			contentPanel.add(cityTextField, gbc_cityTextField);
			cityTextField.setColumns(10);
		}
		{
			JLabel regionLabel = new JLabel("Region:");
			GridBagConstraints gbc_regionLabel = new GridBagConstraints();
			gbc_regionLabel.anchor = GridBagConstraints.EAST;
			gbc_regionLabel.insets = new Insets(0, 0, 0, 5);
			gbc_regionLabel.gridx = 0;
			gbc_regionLabel.gridy = 4;
			contentPanel.add(regionLabel, gbc_regionLabel);
		}
		{
			regionTextField = new JTextField();
			GridBagConstraints gbc_regionTextField = new GridBagConstraints();
			gbc_regionTextField.insets = new Insets(0, 0, 0, 5);
			gbc_regionTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_regionTextField.gridx = 1;
			gbc_regionTextField.gridy = 4;
			contentPanel.add(regionTextField, gbc_regionTextField);
			regionTextField.setColumns(10);
		}
		{
			JLabel contryLabel = new JLabel("Contry:");
			GridBagConstraints gbc_contryLabel = new GridBagConstraints();
			gbc_contryLabel.anchor = GridBagConstraints.EAST;
			gbc_contryLabel.insets = new Insets(0, 0, 0, 5);
			gbc_contryLabel.gridx = 2;
			gbc_contryLabel.gridy = 4;
			contentPanel.add(contryLabel, gbc_contryLabel);
		}
		{
			contryTextField = new JTextField();
			GridBagConstraints gbc_contryTextField = new GridBagConstraints();
			gbc_contryTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_contryTextField.gridx = 3;
			gbc_contryTextField.gridy = 4;
			contentPanel.add(contryTextField, gbc_contryTextField);
			contryTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {

						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		initDataBindings();
	}

	public Adress getAdress() {

		return adress;
	}

	public void setAdress(Adress newAdress) {

		setAdress(newAdress, true);
	}

	public void setAdress(Adress newAdress, boolean update) {

		adress = newAdress;
		if (update) {

			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}

			if (adress != null) initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {

		BeanProperty<Adress, String> adressBeanProperty = BeanProperty.create("zipcode");
		BeanProperty<JFormattedTextField, String> jFormattedTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Adress, String, JFormattedTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, adress,
				adressBeanProperty, zipcodeFormattedTextField, jFormattedTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<Adress, String> adressBeanProperty_1 = BeanProperty.create("adress");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Adress, String, JTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, adress,
				adressBeanProperty_1, adressJTextField, jTextFieldBeanProperty);
		autoBinding_1.bind();
		//
		BeanProperty<Adress, Integer> adressBeanProperty_2 = BeanProperty.create("number");
		BeanProperty<JFormattedTextField, String> jFormattedTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Adress, Integer, JFormattedTextField, String> autoBinding_2 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE,
				adress, adressBeanProperty_2, numberFormattedTextField, jFormattedTextFieldBeanProperty_1);
		autoBinding_2.bind();
		//
		BeanProperty<Adress, String> adressBeanProperty_3 = BeanProperty.create("complement");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_1 = BeanProperty.create("text");
		AutoBinding<Adress, String, JTextField, String> autoBinding_3 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, adress,
				adressBeanProperty_3, complementTextField, jTextFieldBeanProperty_1);
		autoBinding_3.bind();
		//
		BeanProperty<Adress, String> adressBeanProperty_4 = BeanProperty.create("district");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_2 = BeanProperty.create("text");
		AutoBinding<Adress, String, JTextField, String> autoBinding_4 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, adress,
				adressBeanProperty_4, districtTextField, jTextFieldBeanProperty_2);
		autoBinding_4.bind();
		//
		BeanProperty<Adress, String> adressBeanProperty_5 = BeanProperty.create("city");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_3 = BeanProperty.create("text");
		AutoBinding<Adress, String, JTextField, String> autoBinding_5 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, adress,
				adressBeanProperty_5, cityTextField, jTextFieldBeanProperty_3);
		autoBinding_5.bind();
		//
		BeanProperty<Adress, String> adressBeanProperty_6 = BeanProperty.create("region");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_4 = BeanProperty.create("text");
		AutoBinding<Adress, String, JTextField, String> autoBinding_6 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, adress,
				adressBeanProperty_6, regionTextField, jTextFieldBeanProperty_4);
		autoBinding_6.bind();
		//
		BeanProperty<Adress, String> adressBeanProperty_7 = BeanProperty.create("country");
		BeanProperty<JTextField, String> jTextFieldBeanProperty_5 = BeanProperty.create("text");
		AutoBinding<Adress, String, JTextField, String> autoBinding_7 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, adress,
				adressBeanProperty_7, contryTextField, jTextFieldBeanProperty_5);
		autoBinding_7.bind();
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
		bindingGroup.addBinding(autoBinding_7);
		return bindingGroup;
	}
}

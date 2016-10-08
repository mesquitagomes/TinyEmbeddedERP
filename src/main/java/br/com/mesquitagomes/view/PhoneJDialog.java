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

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.beansbinding.Bindings;

import main.java.br.com.mesquitagomes.model.Phone;

public class PhoneJDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	private BindingGroup m_bindingGroup;
	private Phone phone;
	private final JPanel contentPanel = new JPanel();
	private JTextField typeTextField;
	private JFormattedTextField numberFormattedTextField;

	public PhoneJDialog(Frame frame, Phone phone) {

		super(frame);

		this.phone = phone;

		setTitle("Phone");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 400, 120);
		setLocationRelativeTo(frame);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel typeLabel = new JLabel("Type:");
			GridBagConstraints gbc_typeLabel = new GridBagConstraints();
			gbc_typeLabel.insets = new Insets(0, 0, 5, 5);
			gbc_typeLabel.anchor = GridBagConstraints.EAST;
			gbc_typeLabel.gridx = 0;
			gbc_typeLabel.gridy = 0;
			contentPanel.add(typeLabel, gbc_typeLabel);
		}
		{
			typeTextField = new JTextField();
			GridBagConstraints gbc_typeTextField = new GridBagConstraints();
			gbc_typeTextField.insets = new Insets(0, 0, 5, 0);
			gbc_typeTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_typeTextField.gridx = 1;
			gbc_typeTextField.gridy = 0;
			contentPanel.add(typeTextField, gbc_typeTextField);
			typeTextField.setColumns(10);
		}
		{
			JLabel numberLabel = new JLabel("Number:");
			GridBagConstraints gbc_numberLabel = new GridBagConstraints();
			gbc_numberLabel.anchor = GridBagConstraints.EAST;
			gbc_numberLabel.insets = new Insets(0, 0, 0, 5);
			gbc_numberLabel.gridx = 0;
			gbc_numberLabel.gridy = 1;
			contentPanel.add(numberLabel, gbc_numberLabel);
		}
		{
			numberFormattedTextField = new JFormattedTextField();
			GridBagConstraints gbc_numberFormattedTextField = new GridBagConstraints();
			gbc_numberFormattedTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_numberFormattedTextField.gridx = 1;
			gbc_numberFormattedTextField.gridy = 1;
			contentPanel.add(numberFormattedTextField, gbc_numberFormattedTextField);
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

	public Phone getPhone() {

		return phone;
	}

	public void setPhone(Phone newPhone) {

		setPhone(newPhone, true);
	}

	public void setPhone(Phone newPerson, boolean update) {

		phone = newPerson;
		if (update) {

			if (m_bindingGroup != null) {
				m_bindingGroup.unbind();
				m_bindingGroup = null;
			}

			if (phone != null) initDataBindings();
		}
	}

	protected BindingGroup initDataBindings() {

		BeanProperty<Phone, String> phoneBeanProperty = BeanProperty.create("type");
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Phone, String, JTextField, String> autoBinding = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, phone,
				phoneBeanProperty, typeTextField, jTextFieldBeanProperty);
		autoBinding.bind();
		//
		BeanProperty<Phone, String> phoneBeanProperty_1 = BeanProperty.create("number");
		BeanProperty<JFormattedTextField, String> jFormattedTextFieldBeanProperty = BeanProperty.create("text");
		AutoBinding<Phone, String, JFormattedTextField, String> autoBinding_1 = Bindings.createAutoBinding(UpdateStrategy.READ_WRITE, phone,
				phoneBeanProperty_1, numberFormattedTextField, jFormattedTextFieldBeanProperty);
		autoBinding_1.bind();
		//
		BindingGroup bindingGroup = new BindingGroup();
		//
		bindingGroup.addBinding(autoBinding);
		bindingGroup.addBinding(autoBinding_1);
		return bindingGroup;
	}
}

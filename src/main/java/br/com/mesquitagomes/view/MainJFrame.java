package main.java.br.com.mesquitagomes.view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import main.java.br.com.mesquitagomes.model.Person;
import main.java.br.com.mesquitagomes.persistence.PersistenceFactory;

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	private PersistenceFactory persistenceFactory;
	private JMenuItem mntmPerson;
	private JTabbedPane centerTabbedPane;
	private PersonJPanel personPanel;
	private OrderJPanel orderPanel;

	/**
	 * Create the application.
	 */
	public MainJFrame(PersistenceFactory persistenceFactory) {

		this.persistenceFactory = persistenceFactory;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setTitle("TinyEmbeddedERP - by Marcel Mesquita Gomes");
		setBounds(100, 100, 800, 700);
		setMinimumSize(getSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent e) {

				exitProcedure();
			}
		});
		getContentPane().setLayout(new BorderLayout(0, 0));
		{
			JPanel northPanel = new JPanel();
			getContentPane().add(northPanel, BorderLayout.NORTH);
			GridBagLayout gbl_northPanel = new GridBagLayout();
			gbl_northPanel.columnWidths = new int[] { 168, 90, 0 };
			gbl_northPanel.rowHeights = new int[] { 31, 0 };
			gbl_northPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
			gbl_northPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
			northPanel.setLayout(gbl_northPanel);
			{
				JToolBar mainToolBar = new JToolBar();
				mainToolBar.setFloatable(false);
				GridBagConstraints gbc_mainToolBar = new GridBagConstraints();
				gbc_mainToolBar.anchor = GridBagConstraints.NORTHWEST;
				gbc_mainToolBar.insets = new Insets(0, 0, 0, 5);
				gbc_mainToolBar.gridx = 0;
				gbc_mainToolBar.gridy = 0;
				northPanel.add(mainToolBar, gbc_mainToolBar);
				{
					mntmPerson = new JMenuItem("Person");
					mntmPerson.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							centerTabbedPane.setSelectedComponent(personPanel);
						}
					});
					mainToolBar.add(mntmPerson);
				}
				{
					JMenuItem mntmOrder = new JMenuItem("Order");
					mntmOrder.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							centerTabbedPane.setSelectedComponent(orderPanel);
						}
					});
					mainToolBar.add(mntmOrder);
				}
				{
					JMenuItem mntmPrintOrder = new JMenuItem("Print Order");
					mntmPrintOrder.setEnabled(false);
					mainToolBar.add(mntmPrintOrder);
				}
			}
			{
				JToolBar otherToolBar = new JToolBar();
				otherToolBar.setFloatable(false);
				GridBagConstraints gbc_otherToolBar = new GridBagConstraints();
				gbc_otherToolBar.anchor = GridBagConstraints.NORTHEAST;
				gbc_otherToolBar.gridx = 1;
				gbc_otherToolBar.gridy = 0;
				northPanel.add(otherToolBar, gbc_otherToolBar);
				{
					JMenuItem mntmAbout = new JMenuItem("About");
					mntmAbout.setIcon(new ImageIcon(MainJFrame.class.getResource("/main/resources/images/About.png")));
					otherToolBar.add(mntmAbout);
				}
				{
					JMenuItem mntmExit = new JMenuItem("Exit");
					mntmExit.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							exitProcedure();
						}
					});
					mntmExit.setIcon(new ImageIcon(MainJFrame.class.getResource("/main/resources/images/Exit.png")));
					otherToolBar.add(mntmExit);
				}
			}
		}
		{
			centerTabbedPane = new JTabbedPane(JTabbedPane.TOP);
			getContentPane().add(centerTabbedPane, BorderLayout.CENTER);
			{
				personPanel = new PersonJPanel(persistenceFactory);
				centerTabbedPane.addTab("Person", null, personPanel, null);
			}
			{
				orderPanel = new OrderJPanel(persistenceFactory);
				centerTabbedPane.addTab("Order", null, orderPanel, null);
			}
		}

		initDataBindings();

	}

	public void newOrder(Person client) {

		personPanel.addNewOrderActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Person person = personPanel.getSelectedPerson();

				if (person == null) JOptionPane.showMessageDialog(getParent(), "Select a person.", "", JOptionPane.WARNING_MESSAGE);
				else {
					orderPanel.setClient(person);
					orderPanel.setFocusable(true);
				}
			}
		});
	}

	public void exitProcedure() {

		persistenceFactory.close();
		dispose();
		System.exit(0);
	}

	protected void initDataBindings() {}

}

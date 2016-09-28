package main.java.br.com.mesquitagomes.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JMenuItem mntmPerson;
	private JLayeredPane centerLayeredPane;
	private JSplitPane personSplitPane;
	private JPanel personPanel;
	private JPanel personTablePanel;
	private JPanel orderPanel;

	/**
	 * Create the application.
	 */
	public MainJFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		setBounds(100, 100, 550, 600);
		setMinimumSize(getSize());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

							setMainBorderTitle("PERSON");
							orderPanel.setVisible(false);
							personSplitPane.setVisible(true);
						}
					});
					mainToolBar.add(mntmPerson);
				}
				{
					JMenuItem mntmOrder = new JMenuItem("Order");
					mntmOrder.addActionListener(new ActionListener() {

						public void actionPerformed(ActionEvent e) {

							setMainBorderTitle("ORDER");
							orderPanel.setVisible(true);
							personSplitPane.setVisible(false);
						}
					});
					mainToolBar.add(mntmOrder);
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
					mntmAbout.setIcon(new ImageIcon(MainJFrame.class.getResource("/resources/images/About.png")));
					otherToolBar.add(mntmAbout);
				}
				{
					JMenuItem mntmExit = new JMenuItem("Exit");
					mntmExit.setIcon(new ImageIcon(MainJFrame.class.getResource("/resources/images/Exit.png")));
					otherToolBar.add(mntmExit);
				}
			}
		}
		{
			centerLayeredPane = new JLayeredPane();
			centerLayeredPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Main", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
			getContentPane().add(centerLayeredPane, BorderLayout.CENTER);
			centerLayeredPane.setLayout(new BorderLayout(0, 0));
			{
				personSplitPane = new JSplitPane();
				personSplitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
				centerLayeredPane.add(personSplitPane);
				{
					personPanel = new PersonJPanel();
					personSplitPane.setTopComponent(personPanel);

					personTablePanel = new PersonTableJPanel();
					personSplitPane.setBottomComponent(personTablePanel);
				}
				orderPanel = new OrderJPanel();
				centerLayeredPane.add(orderPanel, BorderLayout.NORTH);
			}
		}

		initDataBindings();

	}

	protected void initDataBindings() {}

	@SuppressWarnings("unused")
	private void setMainBorderTitle(String title) {

		TitledBorder titledBorder = (TitledBorder) centerLayeredPane.getBorder();
		titledBorder.setTitle(title);
		centerLayeredPane.repaint();
	}

}

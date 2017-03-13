package Interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;

public class SkiToDoSupervisor extends JFrame {

	//private JPanel contentPane;
	//private BufferedImage bi ;
	static String nomPhoto ;
	static JPanel contentPane = new PannelPhoto();
	

	public SkiToDoSupervisor() {

		try{
		
		
		
		JComboBox<String> jcomboBoxPhotos = new JComboBox<>();
		jcomboBoxPhotos.setModel(new DefaultComboBoxModel(new String[] {"image1.jpg", "image2.jpg", "image3.jpg", 
				"image4.jpg", "image5.jpg", "image6.jpg", "image7.jpg", "image8.jpg"}));
		
		jcomboBoxPhotos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nomPhoto = (String)jcomboBoxPhotos.getSelectedItem();
				System.out.println(nomPhoto);
				//PannelPhoto p1 = new PannelPhoto();
				//p1.setNomPhoto(nomPhoto);
				
				contentPane = new PannelPhoto(nomPhoto);
				
			}
		});
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		//BufferedImage bi = ImageIO.read(new File("src/main/java/Photos/"+nomPhoto));
		
		JLabel jLabelPhotos = new JLabel("Photos :");
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(40)
							.addComponent(jLabelPhotos)
							.addGap(18)
							.addComponent(jcomboBoxPhotos, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE))
						.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelPhotos)
						.addComponent(jcomboBoxPhotos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 600, Short.MAX_VALUE))
		);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		tabbedPane.addTab("Home", null, menuBar, null);
		
		JMenuBar menuBar_2 = new JMenuBar();
		tabbedPane.addTab("Account", null, menuBar_2, null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(Color.RED);
		tabbedPane.addTab("Store", null, menuBar_1, null);
		
		JMenuBar menuBar_3 = new JMenuBar();
		tabbedPane.addTab("Equipment", null, menuBar_3, null);
		
		JMenuBar menuBar_4 = new JMenuBar();
		tabbedPane.addTab("Events", null, menuBar_4, null);
		
		JMenuBar menuBar_5 = new JMenuBar();
		tabbedPane.addTab("SkiSpace", null, menuBar_5, null);
		
		JMenuBar menuBar_6 = new JMenuBar();
		tabbedPane.addTab("SkiType", null, menuBar_6, null);
		
		JMenuBar menuBar_7 = new JMenuBar();
		tabbedPane.addTab("Hotels", null, menuBar_7, null);
		
		JMenuBar menuBar_8 = new JMenuBar();
		tabbedPane.addTab("Competition winner", null, menuBar_8, null);
		
		contentPane.setLayout(gl_contentPane);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					SkiToDoSupervisor frame = new SkiToDoSupervisor();										

					frame.setSize(1400, 800);
					frame.setResizable(false);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					frame.getContentPane().add(contentPane);
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
			}
		});
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

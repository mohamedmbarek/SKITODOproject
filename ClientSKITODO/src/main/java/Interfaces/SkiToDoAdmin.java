package Interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Domaines.User;
import Services.User.AdminServicesEJBRemote;
import Services.User.ClientServicesEJBRemote;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.imageio.ImageIO;
import javax.naming.InitialContext;
import javax.naming.NamingException;
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
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Point;

import javax.swing.JTable;

public class SkiToDoAdmin extends JFrame {

	//private JPanel contentPane;
	//private BufferedImage bi ;
	static String nomPhoto ;
	static JPanel contentPane = new PannelPhoto();
	private JTextField txtFirstname;
	private JTextField txtLogin;
	private JTextField txtDateofbirth;
	private JTextField txtCountry;
	private JTextField txtLastname;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtCity;
	public static JTable clientRequests;
	public static JTable tableAgencyRequest;
	public static JTable tableActiveAgency;
	public static JTable tableBlockedAgency;
	public static JTable tableClientActive;
	public static JTable tableClientBlock;
	int row=-1;
	int col=-1;
	int row1=-1;
	int col1=-1;
	int row2=-1;
	int col2=-1;
	int row3=-1;
	int col3=-1;
	int row4=-1;
	int col4=-1;
	int row5=-1;
	int col5=-1;
	
	private final String[] entetes = { "Nom", "Prénom", "Année", "Sexe", "Note","Nom", "Prénom", "Année", "Sexe", "Note" };	

	

	
	public SkiToDoAdmin() {

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
		tabbedPane.setBackground(new Color(30, 144, 255));

		
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
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1000, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(133, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(jLabelPhotos)
						.addComponent(jcomboBoxPhotos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE))
		);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");
		tabbedPane.addTab("Home", null, menuBar, null);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBackground(new Color(30, 144, 255));
		tabbedPane.addTab("Account", null, menuBar_2, null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(30, 144, 255));
		panel.setForeground(new Color(0, 0, 255));
		menuBar_2.add(panel);
		

			
			
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setForeground(Color.WHITE);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblLogin.setForeground(Color.WHITE);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblLastName.setForeground(Color.WHITE);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblEmail.setForeground(Color.WHITE);
		
		JLabel lblDateOfBirth = new JLabel("Date of birth:");
		lblDateOfBirth.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblDateOfBirth.setForeground(Color.WHITE);
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblPhone.setForeground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Country:");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setForeground(Color.WHITE);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 20));
		lblCity.setForeground(Color.WHITE);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 InitialContext ctx;
				try {
					Object object;
					ctx = new InitialContext();
					object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
					  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

						User c = proxy.findAdmin("admin");
						//System.out.println(c.getFirstName());
						
						c.setFirstName(txtFirstname.getText());
						c.setCity(txtCity.getText());
						c.setCountry(txtCountry.getText());
						c.setEmail(txtEmail.getText());
						c.setLogin(txtLogin.getText());
						c.setName(txtLastname.getText());
						c.setPhone(Integer.parseInt(txtPhone.getText()));
						
						DateFormat df = new SimpleDateFormat("MM/dd/yyyy");

						c.setDateOfBirth(df.parse(txtDateofbirth.getText()));
						
						proxy.updateAdmin(c);

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				

					  
						
			}
		});
		btnUpdate.setBackground(new Color(135, 206, 250));
		btnUpdate.setFont(new Font("American Typewriter", Font.BOLD | Font.ITALIC, 20));
		
       InitialContext ctx = new InitialContext();
		
       Object object;
		ctx = new InitialContext();
		object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
		  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

			User c = proxy.findAdmin("admin");
	//		System.out.println(c.getName());
			
		txtFirstname = new JTextField();
		txtFirstname.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtFirstname.setBackground(new Color(30, 144, 255));
		txtFirstname.setText(c.getFirstName());
		txtFirstname.setColumns(10);
		
		
		
		txtLogin = new JTextField();
		txtLogin.setBackground(new Color(30, 144, 255));
		txtLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtLogin.setText(c.getLogin());
		txtLogin.setColumns(10);
		
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = Calendar.getInstance().getTime();        

		txtDateofbirth = new JTextField();
		txtDateofbirth.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtDateofbirth.setBackground(new Color(30, 144, 255));
		txtDateofbirth.setText(df.format(c.getDateOfBirth()));
		txtDateofbirth.setColumns(10);
		
		txtCountry = new JTextField();
		txtCountry.setBackground(new Color(30, 144, 255));
		txtCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtCountry.setText(c.getCountry());
		txtCountry.setColumns(10);
		
		txtLastname = new JTextField();
		txtLastname.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtLastname.setBackground(new Color(30, 144, 255));
		txtLastname.setText(c.getName());
		txtLastname.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtEmail.setBackground(new Color(30, 144, 255));
		txtEmail.setText(c.getEmail());
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtPhone.setBackground(new Color(30, 144, 255));
	    txtPhone.setText(Integer.toString(c.getPhone()));
		txtPhone.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		txtCity.setBackground(new Color(30, 144, 255));
		txtCity.setText(c.getCity());
		txtCity.setColumns(10);
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(124)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(240)
							.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtFirstname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblLogin)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblDateOfBirth)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtDateofbirth, GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED, 33, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblCity)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 189, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblLastName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtLastname, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblEmail)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPhone)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(35))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(91)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(lblLastName)
						.addComponent(txtFirstname, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtLastname, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLogin)
						.addComponent(lblEmail)
						.addComponent(txtLogin, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDateOfBirth)
						.addComponent(lblPhone)
						.addComponent(txtDateofbirth, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblCity)
						.addComponent(txtCountry, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCity, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
		);
		panel.setLayout(gl_panel);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setForeground(Color.RED);
		tabbedPane.addTab("User account", null, menuBar_1, null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setForeground(Color.BLUE);
		panel_3.setBackground(new Color(30, 144, 255));
		menuBar_1.add(panel_3);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane_1, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenuBar agencyAccount = new JMenuBar();
		tabbedPane_1.addTab("Agency account", null, agencyAccount, null);
		
		JPanel agencyAccountPanel = new JPanel();
		agencyAccountPanel.setForeground(Color.BLUE);
		agencyAccountPanel.setBackground(new Color(30, 144, 255));
		agencyAccount.add(agencyAccountPanel);
		
		JTabbedPane ActivBlockedAgency = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_agencyAccountPanel = new GroupLayout(agencyAccountPanel);
		gl_agencyAccountPanel.setHorizontalGroup(
			gl_agencyAccountPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 847, Short.MAX_VALUE)
				.addGroup(gl_agencyAccountPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ActivBlockedAgency, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_agencyAccountPanel.setVerticalGroup(
			gl_agencyAccountPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 493, Short.MAX_VALUE)
				.addGroup(gl_agencyAccountPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ActivBlockedAgency, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenuBar activeAgency = new JMenuBar();
		ActivBlockedAgency.addTab("Activated accounts", null, activeAgency, null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(Color.BLUE);
		panel_4.setBackground(new Color(30, 144, 255));
		activeAgency.add(panel_4);
		
		JLabel label_1 = new JLabel("List of active agency:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Chalkboard SE", Font.BOLD | Font.ITALIC, 25));
		
		JButton buttonActiveAgency = new JButton("View account");
		
		
		tableActiveAgency = new JTable();
		tableActiveAgency.setModel(new AgencyActiveModel());
		
		tableActiveAgency.addMouseListener(new MouseAdapter() {
            
            @Override
      public void mouseClicked(MouseEvent me) {
         
          Point p = me.getPoint();
           row4 = tableActiveAgency.rowAtPoint(p);
           col4 =tableActiveAgency.columnAtPoint(p);
                System.out.println(row4+""+col4);
     
              }});
		
      buttonActiveAgency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 InitialContext ctx;
				try {
					Object object;
					ctx = new InitialContext();
					object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
					  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

					  
					  if (row4==-1 || col4==-1)
				        {
				           JOptionPane.showMessageDialog(null, "Cochez la personne souhaitée","access denied",JOptionPane.ERROR_MESSAGE);
				        }
				        else
				        {
				        int id =((AgencyActiveModel)tableActiveAgency.getModel()).list.get(row4).getId();
				       AgencyActiveFrame d= new AgencyActiveFrame(id);
				       d.setVisible(true);}						//System.out.println(c.getFirstName());
						
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 					
			}
		});
		
		
		
		
		
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(325)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_4.createSequentialGroup()
							.addGap(380)
							.addComponent(buttonActiveAgency, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableActiveAgency, GroupLayout.PREFERRED_SIZE, 897, GroupLayout.PREFERRED_SIZE))
					.addGap(51))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(tableActiveAgency, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonActiveAgency, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panel_4.setLayout(gl_panel_4);
		
		JMenuBar blockedAgency = new JMenuBar();
		ActivBlockedAgency.addTab("Blocked accounts", null, blockedAgency, null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(Color.BLUE);
		panel_5.setBackground(new Color(30, 144, 255));
		blockedAgency.add(panel_5);
		
		JLabel label_2 = new JLabel("List of Blocked agency:");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Chalkboard SE", Font.BOLD | Font.ITALIC, 25));
		
		JButton buttonBlockedAgency = new JButton("View account");
		
		
		tableBlockedAgency = new JTable();
		tableBlockedAgency.setModel(new AgencyBlockModel());
		
		tableBlockedAgency.addMouseListener(new MouseAdapter() {
             
             @Override
       public void mouseClicked(MouseEvent me) {
          
           Point p = me.getPoint();
            row5 = tableBlockedAgency.rowAtPoint(p);
            col5 =tableBlockedAgency.columnAtPoint(p);
                 System.out.println(row5+""+col5);
      
               }});
		
       buttonBlockedAgency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 InitialContext ctx;
				try {
					Object object;
					ctx = new InitialContext();
					object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
					  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

					  
					  if (row5==-1 || col5==-1)
				        {
				           JOptionPane.showMessageDialog(null, "Cochez la personne souhaitée","access denied",JOptionPane.ERROR_MESSAGE);
				        }
				        else
				        {
				        int id =((AgencyBlockModel)tableBlockedAgency.getModel()).list.get(row5).getId();
				       AgencyBlockedFrame d= new AgencyBlockedFrame(id);
				       d.setVisible(true);}						//System.out.println(c.getFirstName());
						
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 					
			}
		});
		
		
		
		
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_5.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(380)
							.addComponent(buttonBlockedAgency, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableBlockedAgency, GroupLayout.PREFERRED_SIZE, 900, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_5.createSequentialGroup()
							.addGap(325)
							.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)))
					.addGap(48))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(tableBlockedAgency, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonBlockedAgency, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panel_5.setLayout(gl_panel_5);
		agencyAccountPanel.setLayout(gl_agencyAccountPanel);
		
		JMenuBar clientAccount = new JMenuBar();
		tabbedPane_1.addTab("Client account", null, clientAccount, null);
		
		JPanel clientAccountPanel = new JPanel();
		clientAccountPanel.setForeground(Color.BLUE);
		clientAccountPanel.setBackground(new Color(30, 144, 255));
		clientAccount.add(clientAccountPanel);
		
		JTabbedPane ActivBlockedClient = new JTabbedPane(JTabbedPane.TOP);
		GroupLayout gl_clientAccountPanel = new GroupLayout(clientAccountPanel);
		gl_clientAccountPanel.setHorizontalGroup(
			gl_clientAccountPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 847, Short.MAX_VALUE)
				.addGroup(gl_clientAccountPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ActivBlockedClient, GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_clientAccountPanel.setVerticalGroup(
			gl_clientAccountPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 493, Short.MAX_VALUE)
				.addGroup(gl_clientAccountPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(ActivBlockedClient, GroupLayout.PREFERRED_SIZE, 695, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JMenuBar activeClient = new JMenuBar();
		ActivBlockedClient.addTab("Actived accounts", null, activeClient, null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setForeground(Color.BLUE);
		panel_6.setBackground(new Color(30, 144, 255));
		activeClient.add(panel_6);
		
		JLabel label_3 = new JLabel("List of active client:");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Chalkboard SE", Font.BOLD | Font.ITALIC, 25));
		
		JButton buttonActiveClient = new JButton("View account");
		
		
		tableClientActive = new JTable();
		tableClientActive.setModel(new ClientActiveModel());
		
		
		
       tableClientActive.addMouseListener(new MouseAdapter() {
             
             @Override
       public void mouseClicked(MouseEvent me) {
          
           Point p = me.getPoint();
            row = tableClientActive.rowAtPoint(p);
            col =tableClientActive.columnAtPoint(p);
                 System.out.println(row+""+col);
      
               }});
		
       buttonActiveClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 InitialContext ctx;
				try {
					Object object;
					ctx = new InitialContext();
					object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
					  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

					  
					  if (row==-1 || col==-1)
				        {
				           JOptionPane.showMessageDialog(null, "Cochez la personne souhaitée","access denied",JOptionPane.ERROR_MESSAGE);
				        }
				        else
				        {
				        int id =((ClientActiveModel)tableClientActive.getModel()).list.get(row).getId();
				       ClientActiveFrame d= new ClientActiveFrame(id);
				       d.setVisible(true);}						//System.out.println(c.getFirstName());
						
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 					
			}
		});
		
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(325)
							.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_6.createSequentialGroup()
							.addGap(380)
							.addComponent(buttonActiveClient, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableClientActive, GroupLayout.PREFERRED_SIZE, 894, GroupLayout.PREFERRED_SIZE))
					.addGap(54))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(tableClientActive, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonActiveClient, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		
		JMenuBar blockedClient = new JMenuBar();
		ActivBlockedClient.addTab("Blocked accounts", null, blockedClient, null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setForeground(Color.BLUE);
		panel_7.setBackground(new Color(30, 144, 255));
		blockedClient.add(panel_7);
		
		JLabel label_4 = new JLabel("List of blocked client:");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Chalkboard SE", Font.BOLD | Font.ITALIC, 25));
		
		JButton buttonBlockedClient = new JButton("View account");
		
		
		
		tableClientBlock = new JTable();
		tableClientBlock.setModel(new ClientBlockModel());
		
		tableClientBlock.addMouseListener(new MouseAdapter() {
             
             @Override
       public void mouseClicked(MouseEvent me) {
          
           Point p = me.getPoint();
            row1 = tableClientBlock.rowAtPoint(p);
            col1 =tableClientBlock.columnAtPoint(p);
                 System.out.println(row1+""+col1);
      
               }});
		
		buttonBlockedClient.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 InitialContext ctx;
				try {
					Object object;
					ctx = new InitialContext();
					object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
					  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

					  
					  if (row1==-1 || col1==-1)
				        {
				           JOptionPane.showMessageDialog(null, "Cochez la personne souhaitée","access denied",JOptionPane.ERROR_MESSAGE);
				        }
				        else
				        {
				        int id =((ClientBlockModel)tableClientBlock.getModel()).list.get(row1).getId();
				       ClientBlockedFrame d= new ClientBlockedFrame(id);
				       d.setVisible(true);}						//System.out.println(c.getFirstName());
						
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 					
			}
		});
		
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_7.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(325)
							.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_7.createSequentialGroup()
							.addGap(380)
							.addComponent(buttonBlockedClient, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableClientBlock, GroupLayout.PREFERRED_SIZE, 906, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_7.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_4, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(tableClientBlock, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(buttonBlockedClient, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_7.setLayout(gl_panel_7);
		clientAccountPanel.setLayout(gl_clientAccountPanel);
		panel_3.setLayout(gl_panel_3);
		
		JMenuBar menuBar_4 = new JMenuBar();
		tabbedPane.addTab("Agency Requests", null, menuBar_4, null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLUE);
		panel_1.setBackground(new Color(30, 144, 255));
		menuBar_4.add(panel_1);
		
		JLabel label = new JLabel("List of client requests:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Chalkboard SE", Font.BOLD | Font.ITALIC, 25));
		
		JButton buttonAgencyRequest = new JButton("View account");
		
		tableAgencyRequest = new JTable();
		tableAgencyRequest.setModel(new AgencyRequestsModel());
		
		tableAgencyRequest.addMouseListener(new MouseAdapter() {
             
             @Override
       public void mouseClicked(MouseEvent me) {
          
           Point p = me.getPoint();
            row3 = tableAgencyRequest.rowAtPoint(p);
            col3 =tableAgencyRequest.columnAtPoint(p);
                 System.out.println(row3+""+col3);
      
               }});
		
       buttonAgencyRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 InitialContext ctx;
				try {
					Object object;
					ctx = new InitialContext();
					object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
					  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

					  
					  if (row3==-1 || col3==-1)
				        {
				           JOptionPane.showMessageDialog(null, "Cochez la personne souhaitée","access denied",JOptionPane.ERROR_MESSAGE);
				        }
				        else
				        {
				        int id =((AgencyRequestsModel)tableAgencyRequest.getModel()).list.get(row3).getId();
				       AgencyRequestsFrame d= new AgencyRequestsFrame(id);
				       d.setVisible(true);}						//System.out.println(c.getFirstName());
						
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 					
			}
		});
		
		
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(325)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addComponent(tableAgencyRequest, GroupLayout.PREFERRED_SIZE, 942, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(380)
							.addComponent(buttonAgencyRequest, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(tableAgencyRequest, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(buttonAgencyRequest, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JMenuBar menuBar_5 = new JMenuBar();
		tabbedPane.addTab("Client Requests", null, menuBar_5, null);
		
		 JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLUE);
		panel_2.setBackground(new Color(30, 144, 255));
		menuBar_5.add(panel_2);
		
		JLabel lblListOfClient = new JLabel("List of client requests:");
		lblListOfClient.setFont(new Font("Chalkboard SE", Font.BOLD | Font.ITALIC, 25));
		lblListOfClient.setForeground(Color.WHITE);
		
		clientRequests = new JTable();
		
		JButton btnAcceptRequest = new JButton("View account");
		
		clientRequests.addMouseListener(new MouseAdapter() {
             
             @Override
       public void mouseClicked(MouseEvent me) {
          
           Point p = me.getPoint();
            row2 = clientRequests.rowAtPoint(p);
            col2 =clientRequests.columnAtPoint(p);
                 System.out.println(row2+""+col2);
      
               }});
		
		btnAcceptRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 InitialContext ctx;
				try {
					Object object;
					ctx = new InitialContext();
					object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AdminServicesEJB!Services.User.AdminServicesEJBRemote");
					  AdminServicesEJBRemote proxy = (AdminServicesEJBRemote) object;

					  
					  if (row2==-1 || col2==-1)
				        {
				           JOptionPane.showMessageDialog(null, "Cochez la personne souhaitée","access denied",JOptionPane.ERROR_MESSAGE);
				        }
				        else
				        {
				        int id =((ClientRequestsModel)clientRequests.getModel()).list.get(row2).getId();
				       ClientRequestsFrame d= new ClientRequestsFrame(id);
				       d.setVisible(true);}						//System.out.println(c.getFirstName());
						
						

				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 					
			}
		});
		
	  
      // TODO add your handling code here:
		
	    
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap(331, Short.MAX_VALUE)
					.addComponent(lblListOfClient)
					.addGap(350))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(386)
					.addComponent(btnAcceptRequest)
					.addContainerGap(430, Short.MAX_VALUE))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(clientRequests, GroupLayout.PREFERRED_SIZE, 942, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(18)
					.addComponent(lblListOfClient)
					.addGap(28)
					.addComponent(clientRequests, GroupLayout.PREFERRED_SIZE, 434, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnAcceptRequest, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		
		clientRequests.setModel(new ClientRequestsModel());
		
		
		
		
		JMenuBar menuBar_6 = new JMenuBar();
		tabbedPane.addTab("Competition Requests", null, menuBar_6, null);
		
		JMenuBar menuBar_7 = new JMenuBar();
		tabbedPane.addTab("Statistics", null, menuBar_7, null);
		
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
					SkiToDoAdmin frame = new SkiToDoAdmin();										

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

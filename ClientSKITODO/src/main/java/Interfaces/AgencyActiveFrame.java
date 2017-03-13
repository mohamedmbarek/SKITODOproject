package Interfaces;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Domaines.User;
import Services.User.AgencyServicesEJBRemote;
import Services.User.ClientServicesEJBRemote;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgencyActiveFrame extends JFrame {

	private JPanel contentPane;
	public static int id;
	public User u;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AgencyActiveFrame frame = new AgencyActiveFrame(id);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws NamingException 
	 */
	public AgencyActiveFrame(int id) throws NamingException {
		
	InitialContext ctx = new InitialContext();
		
	Object object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AgencyServicesEJB!Services.User.AgencyServicesEJBRemote");

	  AgencyServicesEJBRemote proxy = (AgencyServicesEJBRemote) object;

u =   proxy.findAgencyById(id); 
	 
	 
	 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 640);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(100, 149, 237));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblClientInformations = new JLabel("Agency informations:");
		lblClientInformations.setFont(new Font("Copperplate", Font.BOLD | Font.ITALIC, 26));
		lblClientInformations.setForeground(new Color(100, 149, 237));
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblFirstName.setForeground(new Color(100, 149, 237));
		
		JLabel lblLastName = new JLabel("Last name:");
		lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblLastName.setForeground(new Color(100, 149, 237));
		
		JLabel login = new JLabel("Login:");
		login.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		login.setForeground(new Color(100, 149, 237));
		
		JLabel email = new JLabel("Email:");
		email.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		email.setForeground(new Color(100, 149, 237));
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		city.setForeground(new Color(100, 149, 237));
		
		JLabel country = new JLabel("Country:");
		country.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		country.setForeground(new Color(100, 149, 237));
		
		JLabel dateofbirth = new JLabel("Date of birth:");
		dateofbirth.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		dateofbirth.setForeground(new Color(100, 149, 237));
		
		JLabel sex = new JLabel("Sex:");
		sex.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		sex.setForeground(new Color(100, 149, 237));
		
		JLabel phone = new JLabel("Phone:");
		phone.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		phone.setForeground(new Color(100, 149, 237));
		
		JLabel level = new JLabel("Level:");
		level.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		level.setForeground(new Color(100, 149, 237));
		
		JLabel lblGetFirstName = new JLabel("New label");
		lblGetFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetLastName = new JLabel("New label");
		lblGetLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetLogin = new JLabel("New label");
		lblGetLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetCity = new JLabel("New label");
		lblGetCity.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetDate = new JLabel("New label");
		lblGetDate.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel label = new JLabel("");
		
		JLabel lblGetEmail = new JLabel("New label");
		lblGetEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetCountry = new JLabel("New label");
		lblGetCountry.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetSex = new JLabel("New label");
		lblGetSex.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetLevel = new JLabel("New label");
		lblGetLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		JLabel lblGetPhone = new JLabel("New label");
		lblGetPhone.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		lblGetCity.setText(u.getCity());
		lblGetCountry.setText(u.getCountry());
		lblGetEmail.setText(u.getEmail());
		lblGetFirstName.setText(u.getFirstName());
		lblGetLastName.setText(u.getName());
		lblGetLevel.setText(Integer.toString(u.getLevel()));
		lblGetLogin.setText(u.getLogin());
		lblGetSex.setText(u.getSexe());
	    lblGetPhone.setText(Integer.toString(u.getPhone()));
	    DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date today = Calendar.getInstance().getTime(); 
	    lblGetDate.setText(df.format(u.getDateOfBirth()));
		
		JButton btnBlockAccount = new JButton("Block account");
		btnBlockAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InitialContext ctx = new InitialContext();
					
					Object object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AgencyServicesEJB!Services.User.AgencyServicesEJBRemote");

					  AgencyServicesEJBRemote proxy = (AgencyServicesEJBRemote) object;

				 u =   proxy.findAgencyById(id); 
					  
					  u.setState("Blocked");
					  
					  proxy.updateAgency(u);
					  
					  SkiToDoAdmin.tableBlockedAgency.setModel(new AgencyBlockModel());
					  SkiToDoAdmin.tableActiveAgency.setModel(new AgencyActiveModel());

					  
					  JOptionPane.showMessageDialog(null,"Request Accepted");
					  
					   	setDefaultCloseOperation(DISPOSE_ON_CLOSE);     


				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnDeleteAccount = new JButton("Delete account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					InitialContext ctx = new InitialContext();
					
					Object object = ctx.lookup("/SKITODOproject-ear/SKITODOproject-ejb/AgencyServicesEJB!Services.User.AgencyServicesEJBRemote");

					  AgencyServicesEJBRemote proxy = (AgencyServicesEJBRemote) object;

				 u =   proxy.findAgencyById(id); 
					  
					 
					  
					  proxy.deleteAgency(u);
					  
					  SkiToDoAdmin.tableActiveAgency.setModel(new AgencyActiveModel());

				       
					  JOptionPane.showMessageDialog(null,"Request deleted");
				
				} catch (NamingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 					
			}
		});
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFirstName)
										.addComponent(dateofbirth))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblGetDate)
												.addComponent(label)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(lblGetFirstName))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(login, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
										.addComponent(city, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblGetLogin)
										.addComponent(lblGetCity)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(phone, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblGetPhone)))
							.addGap(123)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblLastName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblGetLastName))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(email, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblGetEmail))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(country)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblGetCountry))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(sex, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblGetSex))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(level, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblGetLevel))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(178)
							.addComponent(lblClientInformations))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(228)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnDeleteAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnBlockAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
					.addGap(176))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(22)
					.addComponent(lblClientInformations, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(48)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblFirstName)
						.addComponent(lblLastName)
						.addComponent(lblGetLastName)
						.addComponent(lblGetFirstName))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(login)
							.addComponent(lblGetLogin))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(email)
							.addComponent(lblGetEmail)))
					.addGap(52)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(city)
							.addComponent(lblGetCity))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(country)
							.addComponent(lblGetCountry)))
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(sex)
							.addComponent(lblGetSex))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(dateofbirth)
							.addComponent(lblGetDate)))
					.addGap(42)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(phone)
							.addComponent(label)
							.addComponent(lblGetPhone))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(level)
							.addComponent(lblGetLevel)))
					.addGap(40)
					.addComponent(btnBlockAccount, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeleteAccount, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	   	setDefaultCloseOperation(DISPOSE_ON_CLOSE);     

	}
}

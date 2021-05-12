package Gui;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jdesktop.swingx.JXPanel;

import Models.*;

import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class SecretairePage extends JFrame {	

	private Secretaire secretaire;
	private JPanel contentPane = new JPanel();
	private JXPanel patients;
	private JTextField textField;

	public SecretairePage(Secretaire s) {
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		this.setSize(1354, 703);
		setSecretaire(s); 
		// à utiliser avec les tablecell rendrer (en bas) pour bien afficher la date dans les jtable, et pour formater la date du Jcalendar
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

//TODO initialiser le panel Menu panel , celui de gauche et il contiendra des boutons pour afficher les rdv ou les patients

		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(0, 102, 255));
		MenuPanel.setBounds(0, 0, 228, 664);
		MenuPanel.setLayout(null);
		
		getContentPane().add(MenuPanel);

//TODO les boutons du panel menu 

		// home button pour afficher le panel homepanel, ou y'aura les rdv
		JButton HomeButton = new JButton((String) null);
		HomeButton.setIcon(new ImageIcon(SecretairePage.class.getResource("/Assets/Home 2.png")));
		HomeButton.setBackground(new Color(0, 102, 255));
		HomeButton.setBounds(0, 215, 228, 44);
		HomeButton.setOpaque(true);

		// patient button pour afficher le panel patientpanel , ou y'aura les patients
		JButton PatientButton = new JButton("");
		PatientButton.setIcon(new ImageIcon(SecretairePage.class.getResource("/Assets/Patients.png")));
		PatientButton.setOpaque(true);
		PatientButton.setBackground(new Color(0, 102, 255));
		PatientButton.setBounds(0, 270, 228, 44);

//TODO ajouter les bouton au panel menu
		MenuPanel.add(HomeButton);
		MenuPanel.add(PatientButton);

//TODO initialiser le panel Main panel , celui à droite et il aura le layout : CardLayout il contiendra les panel homepanel et patientpanel 

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setBounds(227, 0, 1103, 668);
		getContentPane().add(MainPanel);
		MainPanel.setLayout(new CardLayout(0, 0));

//TODO init home panel il contiendra la liste des rdv , c'est le panel qui s'affichera après avoir cliqué sur le bouton home Button
		JPanel HomePanel = new JPanel();
		HomePanel.setBackground(Color.WHITE);

//TODO init tous les composants du panel panel home 

		//la ruban bleu en haut
		JPanel DecoHomePanel = new JPanel(); 
		DecoHomePanel.setBounds(0, 0, 1103, 61);
		DecoHomePanel.setBackground(new Color(0, 102, 255));

		// le calendrier 			

		CalendarPanel calendarPanel = new CalendarPanel();


		calendarPanel.setBounds(802, 106, 252, 273);


		//Pour afficher le jpanel des rdv 	!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		JXPanel RdvPanel = new JXPanel();
		RdvPanel.setBounds(10, 72, 779, 585);
		RdvPanel.setBackground(new java.awt.Color(241, 241, 241));
		RdvPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rendez-vous", javax.swing.border.TitledBorder.CENTER, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N


		//init la Default Table Model
		Object[] Rcolumn = {"DATE RDV", "HEURE RDV", "TYPE", "PATIENT"};
		DefaultTableModel tm = new DefaultTableModel(Rcolumn,0); //0 lignes à l'initialisation
		tm.setColumnIdentifiers(Rcolumn);
		JTable Rtable = new JTable(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DATE RDV", "HEURE RDV", "TYPE", "PATIENT"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}); 
		Rtable.setToolTipText("Pour rafrichir la table changez de date puis recliquez sur la date voulu ");

		Rtable.setBounds(23, 55, 435, 217);

		JScrollPane Rscroll = new JScrollPane(Rtable);
		Rtable.setFillsViewportHeight(true);
		Rtable.setForeground(Color.BLACK);
		Rtable.setRowHeight(30);

		//on cree un tableCellRendrer pour bien afficher la date au format dd-mm-yyyy
		TableCellRenderer RtableCellRenderer = new DefaultTableCellRenderer() {

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if( value instanceof Date) {
					value = f.format(value);
				}
				return super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
			}
		};
		//On applique le format à la colonne date de naissance
				Rtable.getColumnModel().getColumn(0).setCellRenderer(RtableCellRenderer);


		//le layout pour  rdvpanel et add rscroll ...
		GroupLayout gl_RdvPanel = new GroupLayout(RdvPanel);
		gl_RdvPanel.setHorizontalGroup(
				gl_RdvPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(Rscroll, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
				);
		gl_RdvPanel.setVerticalGroup(
				gl_RdvPanel.createParallelGroup(Alignment.LEADING)
				.addComponent(Rscroll, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
				);
		RdvPanel.setLayout(gl_RdvPanel);

		//ajouter les composant au panel homePanel
		HomePanel.setLayout(null);
		HomePanel.add(DecoHomePanel);
		HomePanel.add(calendarPanel);
		HomePanel.add(RdvPanel);
		
//TODO PAR DEFAULT ON REMPLIT LA JTABLE PAR DEFAULT AVEC LES RDV DU JOUR 

		LocalDate now = LocalDate.now();
		Date today = new Date();
		calendarPanel.setSelectedDate(now);
		ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		String date;
		Date d = new Date();
		try {	
			date = f.format(today);
			d = f.parse(date);
			rdvs.addAll(Rdv.allDate(getSecretaire().getRdvs(),d));
			for (Rdv r : rdvs) {
				String string ;
				if(r.getPatient()!= null) string = r.getPatient().getNom()+" "+r.getPatient().getPrenom();//si le patient existe dans la bd
				else string = "Nouveau patient"; //si le patient n'existe pas
				((DefaultTableModel) Rtable.getModel()).addRow(new Object[] {
						r.getDate_rdv(),
						r.getHeure_rdv(),
						r.getType(),
						string
				});}
		}//fin try
		catch(Exception e) {
			System.out.println(e);
		}
//TODO implementer l'action listener du calendrier pour afficher les rdv selon les dates selectionné dans le calendrier
		
		calendarPanel.addCalendarListener(new CalendarListener() {
			public void selectedDateChanged(CalendarSelectionEvent event) {
				LocalDate newDate;
				//LocalDate oldDate;
				String date;
				Date d = new Date();
				try {
					//oldDate = event.getOldDate();
					
					if(event.isDuplicate() == false) {
						((DefaultTableModel) Rtable.getModel()).setRowCount(0);
						newDate = event.getNewDate();
						
						date = newDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

						d = f.parse(date);
						ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
						rdvs.addAll(Rdv.allDate(getSecretaire().getRdvs(), d));
						for (Rdv r : rdvs) {
							String string ;
							if(r.getPatient()!= null) string = r.getPatient().getNom()+" "+r.getPatient().getPrenom();
							else string = "Nouveau patient";
							((DefaultTableModel) Rtable.getModel()).addRow(new Object[] {
									r.getDate_rdv(),
									r.getHeure_rdv(),
									r.getType(),
									string
							});}
					}else ((DefaultTableModel) Rtable.getModel()).setRowCount(0);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			@Override
			public void yearMonthChanged(YearMonthChangeEvent arg0) {

			}

		});


//TODO init patient panel il contiendra la liste des patients , c'est le panel qui s'affichera après avoir cliqué sur le bouton patient

		JPanel PatientPanel = new JPanel();
		PatientPanel.setBackground(Color.WHITE);

		// Pour afficher la jtable des patients

		patients = new JXPanel(); //panel de fond 
		patients.setBounds(10, 72, 640, 378);
		patients.setBackground(new java.awt.Color(241, 241, 241));
		patients.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patients", javax.swing.border.TitledBorder.CENTER, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13)));

		//init la Default Table Model
		Object[] column = {"ID", "NON", "PRENOM", "DATE DE NAISSANCE", "SEXE", "ADRESSE","NUMERO","EMAIL"};
		DefaultTableModel dtm = new DefaultTableModel(column,0); //0 lignes à l'initialisation
		dtm.setColumnIdentifiers(column);
		JTable table = new JTable(dtm); 
		table.setToolTipText("Cliquez sur un patient pour lui prendre un rdv");

		table.setBounds(23, 55, 435, 217);
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "NON", "PRENOM", "DATE DE NAISSANCE", "SEXE", "ADRESSE", "NUMERO", "EMAIL"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false //la secretaire ne peut pas changer les infos du patient
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JScrollPane scroll = new JScrollPane(table); //on met la table dans un scrollpane 
		table.setFillsViewportHeight(true);
		table.setForeground(Color.BLACK);
		table.setRowHeight(30);
		//on remplit la table avec l'arraylist patients de la classe secretaire
		for (Patient p : getSecretaire().getPatients()) {
			((DefaultTableModel) table.getModel()).addRow(new Object[] {
					p.getId_patient(),
					p.getNom(),
					p.getPrenom(),
					p.getDate_naissance(),
					p.getSexe(),
					p.getAdresse(),
					p.getNum_tel(),
					p.getEmail()});
		}

		//on cree un tableCellRendrer pour bien afficher la date au format dd-mm-yyyy
		TableCellRenderer tableCellRenderer = new DefaultTableCellRenderer() {

			SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

			public Component getTableCellRendererComponent(JTable table,
					Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if( value instanceof Date) {
					value = f.format(value);
				}
				return super.getTableCellRendererComponent(table, value, isSelected,
						hasFocus, row, column);
			}
		};

		//On applique le format à la colonne date de naissance
		table.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);


//TODO implementer LES COMPOSANTS DU PATIENT PANEL POUR Faire LA RECHERCHE

		//le row sorter pour faire la recherche dans la jtable

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(table.getModel());
		table.setRowSorter(rowSorter);

		textField = new JTextField("Entrez le nom d'un patient..."); //text field pour chercher un patient avec son nom	

		//key listener pour rechercher le patient dans la jtable 
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {					
				String text = textField.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
				table.setRowSorter(rowSorter);
				rowSorter.setRowFilter(RowFilter.regexFilter(text));

			}
		});
// TODO implementer le mouse listener pour enlever le message Entrez le nom d'un patient... du textfield
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});

		//le label a gauche du textfield qui contient l'icone recherche !	
		JLabel search = new JLabel();
		search.setIcon(new ImageIcon(SecretairePage.class.getResource("/Assets/search25.png")));

		// deco patient , layout ...
		JPanel DecoPatientPanel = new JPanel();
		DecoPatientPanel.setBackground(new Color(0, 102, 255));
		GroupLayout gl_PatientPanel = new GroupLayout(PatientPanel);
		gl_PatientPanel.setHorizontalGroup(
				gl_PatientPanel.createParallelGroup(Alignment.TRAILING)
				.addComponent(DecoPatientPanel, GroupLayout.PREFERRED_SIZE, 950, Short.MAX_VALUE)
				.addComponent(patients, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 950, Short.MAX_VALUE)
				);
		gl_PatientPanel.setVerticalGroup(
				gl_PatientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PatientPanel.createSequentialGroup()
						.addComponent(DecoPatientPanel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(patients, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
				);

		GroupLayout gl_DecoPatientPanel = new GroupLayout(DecoPatientPanel);
		gl_DecoPatientPanel.setHorizontalGroup(
				gl_DecoPatientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DecoPatientPanel.createSequentialGroup()
						.addGap(682)
						.addComponent(search)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(196, Short.MAX_VALUE))
				);
		gl_DecoPatientPanel.setVerticalGroup(
				gl_DecoPatientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DecoPatientPanel.createSequentialGroup()
						.addGap(20)
						.addGroup(gl_DecoPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(search))
						.addContainerGap())
				);
		DecoPatientPanel.setLayout(gl_DecoPatientPanel);
		GroupLayout gl_patients = new GroupLayout(patients);
		gl_patients.setHorizontalGroup(
				gl_patients.createParallelGroup(Alignment.LEADING)
				.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 938, Short.MAX_VALUE)
				);
		gl_patients.setVerticalGroup(
				gl_patients.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_patients.createSequentialGroup()
						.addGap(5)
						.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
						.addContainerGap())
				);
		patients.setLayout(gl_patients);
		PatientPanel.setLayout(gl_PatientPanel);


//TODO Implementer l'action listener pour prendre des rdv 
		//a chaque click sur une ligne de la jtable
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("Entrez le nom d'un patient...");
				rowSorter.setRowFilter(null);
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				String nom = model.getValueAt(index, 1).toString();
				String prenom = model.getValueAt(index, 2).toString();
				Planning p = new Planning(nom,prenom,getSecretaire());
				p.setVisible(true);
			 ((AbstractTableModel) Rtable.getModel()).fireTableDataChanged();		
			}
		});
		
//TODO Implementer un bouton pour prendre un rdv a partir du home panel quand c'est un nouveau patient
		JButton btnNewButton = new JButton("");
		btnNewButton.setToolTipText("Pour ajouter un rdv d'un patient non enregitré");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planning p = new Planning(" ","",getSecretaire());
				p.setVisible(true);
				 ((AbstractTableModel) Rtable.getModel()).fireTableDataChanged();	
			}
		});
		btnNewButton.setIcon(new ImageIcon(SecretairePage.class.getResource("/Assets/plus-25.png")));
		btnNewButton.setBounds(905, 379, 35, 33);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 6;
		

//TODO Ajouter les panels home panel et patient panel au main panel pour realiser le cardlayout
		MainPanel.add(HomePanel, "HomePanel");
		HomePanel.add(btnNewButton);
		MainPanel.add(PatientPanel,"PatientPanel");
		CardLayout cl = (CardLayout) MainPanel.getLayout();



//TODO implmenter les action listeners pour réaliser le card layout
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(MainPanel, "HomePanel");
				textField.setText("Entrez le nom d'un patient...");
			}
		});

		PatientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(MainPanel, "PatientPanel");
			}
		});
	}

	public Secretaire getSecretaire() {
		return secretaire;
	}
	public void setSecretaire(Secretaire secretaire) {
		this.secretaire = secretaire;
	}
}

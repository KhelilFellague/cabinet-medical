package Gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.jdesktop.swingx.JXPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

import com.github.lgooddatepicker.components.CalendarPanel;
import com.github.lgooddatepicker.optionalusertools.CalendarListener;
import com.github.lgooddatepicker.zinternaltools.CalendarSelectionEvent;
import com.github.lgooddatepicker.zinternaltools.YearMonthChangeEvent;
//FROM U K W
import java.text.DecimalFormat;  
 
import org.jfree.chart.labels.PieSectionLabelGenerator;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;

import Models.Consultation;
import Models.DossierPatient;

import Models.Medecin;
import Models.Patient;
import Models.Rdv;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MedecinPage extends JFrame {

	private JPanel contentPane;
	private Medecin medecin;
	private JRadioButton parSexe;
	private JTextField patienttf;
	private JTextField tailletf;
	private JTextField gstf;
	
	/**
	 * Create the frame.
	 */

	public MedecinPage(Medecin medecin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		this.setSize(1354, 703);
		setContentPane(contentPane);

		setMedecin(medecin);
//TODO à utiliser avec les tablecell rendrer (en bas) pour bien afficher la date dans les jtable, et pour formater la date du Jcalendar
		SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");

//TODO initialiser le Menu panel , celui de gauche et il contiendra des boutons pour changer de panel (homepanel/patientPanel/...)

		JPanel MenuPanel = new JPanel();
		MenuPanel.setBackground(new Color(0, 102, 255));
		MenuPanel.setBounds(0, 0, 228, 664);
		MenuPanel.setLayout(null);
		getContentPane().add(MenuPanel);

//TODO les boutons du menupanel 

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


		//StatButton pour afficher le panel StatPanel, ou y'aura les differents graphes
		JButton StatButton = new JButton("");
		
		StatButton.setIcon(new ImageIcon(MedecinPage.class.getResource("/Assets/graphique-combiné.png")));
		StatButton.setOpaque(true);
		StatButton.setBackground(new Color(0, 102, 255));
		StatButton.setBounds(0, 327, 228, 44);
		
	//TODO ajouter les bouton au panel menu
		MenuPanel.add(HomeButton);
		MenuPanel.add(PatientButton);	
		MenuPanel.add(StatButton);
		
		

/*§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§                                 ON A FINI AVEC LE MENU PANEL                        §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
*/

//TODO initialiser le panel Main panel , celui à droite et il aura le layout : CardLayout il contiendra les panel homepanel et patientpanel... 

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(new Color(255, 255, 255));
		MainPanel.setBounds(227, 0, 1111, 668);
		getContentPane().add(MainPanel);
		MainPanel.setLayout(new CardLayout(0, 0));

//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ON IMPLEMENTE LES PANELS COMPOSANTS DU MAIN PANEL !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! HomePanel   /   PatientPanel   /  StatisquesPanel !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       On les ajoutera a la fin (ligne 454)        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!       et on implementra le card layout            !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!		
		

//TODO init homepanel il contiendra la liste des rdv , c'est le panel qui s'affichera après avoir cliqué sur le bouton homeButton
		JPanel HomePanel = new JPanel();
		HomePanel.setBackground(Color.WHITE);
		

//TODO init tous les composants du panel homepanel  

		//la ruban bleu en haut
		JPanel DecoHomePanel = new JPanel(); 
		DecoHomePanel.setBounds(0, 0, 1111, 61);
		DecoHomePanel.setBackground(new Color(0, 102, 255));

		// le calendrier 			

		CalendarPanel calendarPanel = new CalendarPanel();
		calendarPanel.setBounds(799, 119, 279, 279);
		
		

		//Pour afficher le jpanel des rdv 	
		JXPanel RdvPanel = new JXPanel();//panel de fond 
		RdvPanel.setBounds(10, 72, 779, 585);
		RdvPanel.setBackground(new java.awt.Color(241, 241, 241));
		RdvPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rendez-vous", javax.swing.border.TitledBorder.CENTER, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13))); // NOI18N
		
		//init la Default Table Model des rdv 
		
		Object[] Rcolumn = {"DATE RDV", "HEURE RDV", "TYPE", "PATIENT"};

		DefaultTableModel tm = new DefaultTableModel(Rcolumn,0); //0 lignes à l'initialisation
		tm.setColumnIdentifiers(Rcolumn);
		
		JTable Rtable = new JTable(tm); //creer la jtable avec la default table model
		 Rtable.setModel((new DefaultTableModel(
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
			})); 
		Rtable.setBounds(23, 55, 435, 217);
		Rtable.setFillsViewportHeight(true);
		Rtable.setForeground(Color.BLACK);
		Rtable.setRowHeight(30);

		JScrollPane Rscroll = new JScrollPane(Rtable); //pour bien afficher la jtable , on l'a met dans un scrollpane


		//on cree un tableCellRendrer pour bien afficher la date au format dd-mm-yyyy dans la jtable
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

		//On applique le cell rendrer à la colonne date de naissance
		Rtable.getColumnModel().getColumn(0).setCellRenderer(RtableCellRenderer);


		//le group layout pour  rdvpanel et add rscroll ...
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

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//TODO ajouter les composants crées au panel homePanel
		HomePanel.setLayout(null);
		HomePanel.add(DecoHomePanel);
		HomePanel.add(calendarPanel);
		HomePanel.add(RdvPanel);
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

//TODO PAR DEFAULT ON REMPLIT LA JTABLE AVEC LES RDV DU JOUR 
		
		LocalDate now = LocalDate.now();
		Date today = new Date();
		calendarPanel.setSelectedDate(now);
		ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
		String date;
		Date d = new Date();
	try {	
		date = f.format(today);
		d = f.parse(date);
		rdvs.addAll(Rdv.allDate(getMedecin().getRdvs(),d));
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
		System.out.println(e); //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ JOPTIONPANE
	}
//TODO implementer l'action listener du calendrier

		calendarPanel.addCalendarListener(new CalendarListener() {
		public void selectedDateChanged(CalendarSelectionEvent event) {
				LocalDate newDate;
			//	LocalDate oldDate;
				String date;
				Date d = new Date();
				
				try {
				//	oldDate = event.getOldDate();
					//System.out.println(oldDate);

					if(event.isDuplicate() == false) {
						((DefaultTableModel) Rtable.getModel()).setRowCount(0);
						newDate = event.getNewDate();
						//System.out.println(newDate);
						date = newDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));

						d = f.parse(date);
						ArrayList<Rdv> rdvs = new ArrayList<Rdv>();
						rdvs.addAll(Rdv.allDate(getMedecin().getRdvs(), d));
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
					}
					else ((DefaultTableModel) Rtable.getModel()).setRowCount(0);
					

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

			@Override
			public void yearMonthChanged(YearMonthChangeEvent arg0) {

			}

		});
		
/*§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§                                 ON A FINI AVEC LE HOME PANEL                        §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
*/

//TODO init patientpanel il contiendra la liste des patients , c'est le panel qui s'affichera après avoir cliqué sur le bouton patientBUTTON
		
		/*
		 * le panel patient panel aura lui aussi un card layout pour afficher les panel patient / dossier/consultations ...
		 */

		JPanel PatientPanel = new JPanel();
		PatientPanel.setBackground(Color.WHITE);
		PatientPanel.setLayout(new CardLayout(0,0));

//TODO init les composants du panel PatientPanel

/*TODO init un panel patient qui contient les deux panels patientJtablePanel et decoPatientPanel ; 
		il affichera les infos générales des patients dans une jtable*/

		JPanel patient = new JPanel();
		patient.setBackground(Color.WHITE);

		// Pour afficher la jtable des patients
		JXPanel patientJtablePanel = new JXPanel(); //panel de fond 
		patientJtablePanel.setBounds(10, 72, 640, 378);
		patientJtablePanel.setBackground(new java.awt.Color(241, 241, 241));
		patientJtablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Patients", javax.swing.border.TitledBorder.CENTER, 
				javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Lucida Grande", 1, 13)));

		//init la Default Table Model
		Object[] column = {"ID", "NON", "PRENOM", "DATE DE NAISSANCE", "SEXE", "ADRESSE","NUMERO","EMAIL"};
		DefaultTableModel dtm = new DefaultTableModel(column,0); //0 lignes à l'initialisation
		dtm.setColumnIdentifiers(column);
		
		JTable Ptable = new JTable(dtm); //on crée la jtable avec la default table model
		Ptable.setToolTipText("Click droit pour voir le menu\r\nClick gauche pour voir le dossier");
		Ptable.setBounds(23, 55, 435, 217);
		Ptable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"ID", "NON", "PRENOM", "DATE DE NAISSANCE", "SEXE", "ADRESSE", "NUMERO", "EMAIL"
				}
				) {
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false, false 
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		JScrollPane scroll = new JScrollPane(Ptable); //on met la table dans un scrollpane pour bien l'afficher
		
		Ptable.setFillsViewportHeight(true);
		Ptable.setForeground(Color.BLACK);
		Ptable.setRowHeight(30);
		
		//on remplit la table avec l'arraylist patients de la classe secretaire
				for (Patient p : getMedecin().getPatients()) {
					((DefaultTableModel) Ptable.getModel()).addRow(new Object[] {
							p.getId_patient(),
							p.getNom(),
							p.getPrenom(),
							p.getDate_naissance(),
							p.getSexe(),
							p.getAdresse(),
							p.getNum_tel(),
							p.getEmail()});
				}

		

//TODO implementer LES COMPOSANTS DU panel "patient" POUR Faire LA RECHERCHE

		//le row sorter pour faire la recherche dans la jtable

		TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(Ptable.getModel());
		Ptable.setRowSorter(rowSorter);
		
		//on cree un tableCellRendrer pour bien afficher la date au format dd-mm-yyyy dans la jtable
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
		Ptable.getColumnModel().getColumn(3).setCellRenderer(tableCellRenderer);
		
		// deco patient , layout et composants (textfield pour la recherche et un label avec une icone de recherche)...
		JPanel DecoPatientPanel = new JPanel();
		DecoPatientPanel.setBackground(new Color(0, 102, 255));
		
		// le textField pour rechercher le patient
		JTextField textField = new JTextField("Entrez le nom d'un patient...");
		//le label a gauche du textfield qui contient l'icone recherche !	
				JLabel search = new JLabel();
				search.setIcon(new ImageIcon(SecretairePage.class.getResource("/Assets/search25.png")));
				DecoPatientPanel.add(search);
				
		//les boutons pour la jtable
		JButton AddButton = new JButton("");
		
		//pour ajouter un patient 
		AddButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientAction ap = new PatientAction(getMedecin(), Ptable);
				ap.setVisible(true);
				 ((AbstractTableModel) Ptable.getModel()).fireTableDataChanged(); //ne marche pas mais marche dans la jframe SecretairePage
				 rowSorter.setRowFilter(null);
				 
			}
		});
		AddButton.setIcon(new ImageIcon(MedecinPage.class.getResource("/Assets/plus-2-25.png")));
		AddButton.setBackground(new Color(0, 102, 255));
		
		GroupLayout gl_DecoPatientPanel = new GroupLayout(DecoPatientPanel);
		gl_DecoPatientPanel.setHorizontalGroup(
			gl_DecoPatientPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_DecoPatientPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(AddButton)
					.addGap(527)
					.addComponent(search)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(313, Short.MAX_VALUE))
		);
		gl_DecoPatientPanel.setVerticalGroup(
			gl_DecoPatientPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_DecoPatientPanel.createSequentialGroup()
					.addGroup(gl_DecoPatientPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_DecoPatientPanel.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_DecoPatientPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
								.addComponent(search)))
						.addGroup(gl_DecoPatientPanel.createSequentialGroup()
							.addContainerGap(27, Short.MAX_VALUE)
							.addComponent(AddButton)))
					.addContainerGap())
		);
		DecoPatientPanel.setLayout(gl_DecoPatientPanel);

//TODO Implementer un key listener pour rechercher le patient dans la jtable aprés l'introduction du nom ou prenom du patient
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {					
				String text = textField.getText();
				if (text.trim().length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
				}
				Ptable.setRowSorter(rowSorter);
				rowSorter.setRowFilter(RowFilter.regexFilter(text));

			}
		});
		
// TODO implementer le mouse listener pour enlever le message "Entrez le nom d'un patient..." du textfield apres le click
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
			}
		});

		
		//PatienJtablePanel layout...
		GroupLayout gl_patientJtablePanel = new GroupLayout(patientJtablePanel);
		gl_patientJtablePanel.setHorizontalGroup(
			gl_patientJtablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_patientJtablePanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE))
		);
		gl_patientJtablePanel.setVerticalGroup(
			gl_patientJtablePanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_patientJtablePanel.createSequentialGroup()
					.addGap(5)
					.addComponent(scroll, GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE))
		);
		patientJtablePanel.setLayout(gl_patientJtablePanel);
		GroupLayout gl_patient = new GroupLayout(patient);
		gl_patient.setHorizontalGroup(
			gl_patient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_patient.createSequentialGroup()
					.addGroup(gl_patient.createParallelGroup(Alignment.LEADING)
						.addComponent(DecoPatientPanel, GroupLayout.PREFERRED_SIZE, 1111, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_patient.createSequentialGroup()
							.addGap(10)
							.addComponent(patientJtablePanel, GroupLayout.PREFERRED_SIZE, 1091, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_patient.setVerticalGroup(
			gl_patient.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_patient.createSequentialGroup()
					.addComponent(DecoPatientPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
					.addComponent(patientJtablePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		patient.setLayout(gl_patient);

//TODO INIT UN POPUP MENU QUI SERA UTILISE DANS PATIENTPANEL POUR LA JTABLE (A CHAQUE CLICK DROIT) 
				JPopupMenu popupMenu = new JPopupMenu();
				popupMenu.setBounds(0, 0, 200, 50);
				Ptable.setComponentPopupMenu(popupMenu); //ajouter le menu a la jtable
				popupMenu.setVisible(false);
				
				JMenuItem deleteItem = new JMenuItem("Supprimer");
				deleteItem.setBounds(0, 0, 137, 26);
				popupMenu.add(deleteItem);
				
				JMenuItem updateItem = new JMenuItem("Mettre à jour");
				updateItem.setBounds(0, 0, 137, 26);
				popupMenu.add(updateItem);
		
//TODO init un panel dossier pour afficher le dossier d'un patient
		JPanel dossier = new JPanel(); 
		dossier.setBackground(Color.WHITE);
		
//TODO INIT COMPOSANTS DE DECODOSSIER    
		JPanel DecoDossier = new JPanel();
		DecoDossier.setBackground(new Color(0, 102, 255));
//TODO INIT LES COMPOSANTS DE DOSSIER	
				// pour retourner à la jtable
				JButton retourJtable = new JButton("");
				
				retourJtable.setBackground(SystemColor.controlHighlight);
				retourJtable.setIcon(new ImageIcon(MedecinPage.class.getResource("/Assets/gauche-30.png")));
				retourJtable.setOpaque(true);
				//les labels du dossier
				JLabel patientLabel = new JLabel("Patient :");
				patientLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel lblInformationGnrales = new JLabel("Information générales");
				lblInformationGnrales.setFont(new Font("Tahoma", Font.BOLD, 12));
				
				JLabel groupeSanguinLabel = new JLabel("Groupe sanguin :");
				groupeSanguinLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel tailleLabel = new JLabel("Taille :");
				tailleLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				
				JLabel antecedantLabel = new JLabel("Antécédants :");
				antecedantLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
				//textfield et text area du dossier , non modifiables directement si on modifie le patient son nom se modifiera directement ici
				patienttf = new JTextField();
				patienttf.setEditable(false);
				patienttf.setColumns(10);
				
				tailletf = new JTextField();
				tailletf.setEditable(false);
				tailletf.setToolTipText("En cm ");
				tailletf.setColumns(10);
				
				gstf = new JTextField();
				gstf.setEditable(false);
				gstf.setColumns(10);
				
				JTextArea antecta = new JTextArea();
				antecta.setBackground(SystemColor.control);
				antecta.setEditable(false);
				antecta.setToolTipText("");
				
				//tabbedpane pour afficher les differentes consultations du patient ...
				JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
				
				JButton modifierdos = new JButton("");
				
				modifierdos.setIcon(new ImageIcon(MedecinPage.class.getResource("/Assets/modifier-25.png")));
				modifierdos.setOpaque(true);
				modifierdos.setBackground(SystemColor.controlHighlight);
				
				//DECO DOSSIER LAYOUT ... 
				GroupLayout gl_dossier = new GroupLayout(dossier);
				gl_dossier.setHorizontalGroup(
					gl_dossier.createParallelGroup(Alignment.LEADING)
						.addComponent(DecoDossier, GroupLayout.DEFAULT_SIZE, 1119, Short.MAX_VALUE)
						.addGroup(gl_dossier.createSequentialGroup()
							.addContainerGap()
							.addComponent(retourJtable, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dossier.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dossier.createSequentialGroup()
									.addGap(438)
									.addComponent(lblInformationGnrales, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 392, Short.MAX_VALUE)
									.addComponent(modifierdos, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
									.addGap(20))
								.addGroup(gl_dossier.createSequentialGroup()
									.addGap(32)
									.addGroup(gl_dossier.createParallelGroup(Alignment.LEADING)
										.addComponent(patientLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
										.addComponent(tailleLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_dossier.createParallelGroup(Alignment.LEADING)
										.addComponent(patienttf, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
										.addComponent(tailletf, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
									.addGap(220)
									.addGroup(gl_dossier.createParallelGroup(Alignment.LEADING, false)
										.addComponent(antecedantLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(groupeSanguinLabel, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
									.addGap(10)
									.addGroup(gl_dossier.createParallelGroup(Alignment.LEADING)
										.addComponent(antecta, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
										.addComponent(gstf, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
									.addContainerGap(121, Short.MAX_VALUE))))
						.addGroup(gl_dossier.createSequentialGroup()
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 1109, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				gl_dossier.setVerticalGroup(
					gl_dossier.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dossier.createSequentialGroup()
							.addComponent(DecoDossier, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_dossier.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_dossier.createSequentialGroup()
									.addComponent(lblInformationGnrales, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(32)
									.addGroup(gl_dossier.createParallelGroup(Alignment.BASELINE)
										.addComponent(patientLabel)
										.addComponent(groupeSanguinLabel)
										.addComponent(patienttf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(gstf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(36)
									.addGroup(gl_dossier.createParallelGroup(Alignment.BASELINE)
										.addComponent(antecedantLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(tailleLabel, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
										.addComponent(tailletf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(antecta, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_dossier.createSequentialGroup()
									.addComponent(retourJtable, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addGap(168))
								.addComponent(modifierdos, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE))
				);
//TODO INIT PREMIER PANEL DE TABBEDPANE
				JPanel Consultations = new JPanel();
				Consultations.setName("Consultations");
				Consultations.setBackground(SystemColor.controlHighlight);
				tabbedPane.addTab("Consultations", null, Consultations, null);
				
				//composants de consultations..
				DefaultListModel<String> C = new DefaultListModel<>();
				JList <String> Clist = new JList<String>(C);
				
				Clist.setValueIsAdjusting(true);
				Clist.setBounds(10, 11, 215, 359);
				Clist.setBackground(SystemColor.controlHighlight);
				JScrollPane c = new JScrollPane(Clist);
				c.setBackground(SystemColor.controlHighlight);
				
				Clist.setModel(C);
//TODO IMPLEMENTER ACTION LISTENER POUR AJOUTER UNE CONSULTATION °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
				//°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
				JButton addVisite = new JButton("");
				addVisite.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						VisiteAction va = new VisiteAction(Patient.ReadString(patienttf.getText().substring(0, patienttf.getText().indexOf(' '))),C);
						va.setVisible(true);
						
					}
				});
				addVisite.setToolTipText("Pour ajouter une consultation/ordonnances/analyses");
				addVisite.setIcon(new ImageIcon(MedecinPage.class.getResource("/Assets/plus-2-25.png")));
				
				//consultation layout ...
				GroupLayout gl_Consultations = new GroupLayout(Consultations);
				gl_Consultations.setHorizontalGroup(
					gl_Consultations.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_Consultations.createSequentialGroup()
							.addComponent(c, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 773, Short.MAX_VALUE)
							.addComponent(addVisite)
							.addGap(35))
				);
				gl_Consultations.setVerticalGroup(
					gl_Consultations.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Consultations.createSequentialGroup()
							.addGroup(gl_Consultations.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_Consultations.createSequentialGroup()
									.addContainerGap()
									.addComponent(addVisite))
								.addComponent(c, GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE))
							.addContainerGap())
				);
				Consultations.setLayout(gl_Consultations);
				dossier.setLayout(gl_dossier);
				

				
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		
//TODO Ajouter les panels patient et  au Patient pour realiser le cardlayout
				PatientPanel.add(patient,"patient");
				PatientPanel.add(dossier,"dossier");
				
				CardLayout crd = (CardLayout) PatientPanel.getLayout();
				crd.show(PatientPanel, "patient"); //par défault le panel patient s'affichera en premier , celui qui a la jtable des patients


//TODO INIT L'ACTION PERFORMED retourJtable
				retourJtable.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
						crd.show(PatientPanel, "patient"); //on retourne au panel de la jtable
						C.removeAllElements();
					}
				});		
//TODO INIT LE MOUSE LISTENER POUR UPDATE Patient (click sur mettre a jour dans le menu)
				updateItem.addMouseListener(new MouseAdapter() { 
					@Override
					public void mouseReleased(MouseEvent e) {
						Date d;
						String date;
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
						try {
							int row = Ptable.getSelectedRow();

							DefaultTableModel model = (DefaultTableModel) Ptable.getModel();

							int id = Integer.parseInt(model.getValueAt(row, 0).toString());
							String n = model.getValueAt(row, 1).toString();
							String p = model.getValueAt(row, 2).toString();
							date = sdf.format(model.getValueAt(row, 3));
							d = sdf.parse(date);
							String s = model.getValueAt(row, 4).toString();
							String a = model.getValueAt(row, 5).toString();
							String num = model.getValueAt(row, 6).toString();
							String em = model.getValueAt(row, 7).toString();

							//open panel update..
							PatientAction pa = new PatientAction(getMedecin(),Ptable,id,n,p,d,s,a,num,em,row);
							pa.setVisible(true);
							rowSorter.setRowFilter(null);
							textField.setText("Entrez le nom d'un patient...");
						}//fin try
						catch(Exception ex) {
							JOptionPane.showMessageDialog(rootPane, ex, "Erreur", 1);

						}
						//}//fin if

					}
				});
//TODO INIT LE MOUSE LISTENER POUR DELETE Patient (click sur supprimer dans le menu)				
				deleteItem.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseReleased(MouseEvent e) {
						Date d;
						String date;
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						try {
							int row = Ptable.getSelectedRow();

							DefaultTableModel model = (DefaultTableModel) Ptable.getModel();
							Patient p = new Patient();
							//on recuper le patient
							p.setId_patient(Integer.parseInt(model.getValueAt(row, 0).toString())) ;
							p.setNom(model.getValueAt(row, 1).toString());
							p.setPrenom(model.getValueAt(row, 2).toString()) ;
							 date = sdf.format(model.getValueAt(row, 3));
							 d = sdf.parse(date);
							p.setDate_naissance(d);
							 p.setSexe(model.getValueAt(row, 4).toString());
							 p.setAdresse(model.getValueAt(row, 5).toString()) ;
							 p.setNum_tel(model.getValueAt(row, 6).toString()) ;
							p.setEmail( model.getValueAt(row, 7).toString());
							//on le supprime de la bd
							Patient.delete(p);
							model.removeRow(row); //on supprime de la jtable
							rowSorter.setRowFilter(null);
							textField.setText("Entrez le nom d'un patient...");
						}//fin try
						catch(Exception ex) {
							JOptionPane.showMessageDialog(rootPane, ex, "Erreur", 1);

						}
						//}//fin if

					}
				});
 				

//TODO INIT LE MOUSE LISTENER DE LA JTABLE DES PATIENTS pour afficher le dossier patient et le menu pour modifier ou supprimer
Ptable.addMouseListener(new MouseAdapter() {
					
					public void mousePressed(MouseEvent e) {
						
						//POUR SELECTIONNER LA LIGNE
						int r = Ptable.rowAtPoint(e.getPoint());
				        if (r >= 0 && r < Ptable.getRowCount()) {
				            Ptable.setRowSelectionInterval(r, r);
				        } else {
				            Ptable.clearSelection();
				        }
				        //SI C'EST UN EVENEMENT QUI DECLANCHE UN POPUPMENU
						if(e.isPopupTrigger() && SwingUtilities.isRightMouseButton(e)) {
							JTable source = (JTable)e.getSource();
							
				            int row = source.rowAtPoint( e.getPoint() );
				            int column = source.columnAtPoint( e.getPoint() );

				            if (! source.isRowSelected(row))
				                source.changeSelection(row, column, false, false);

							popupMenu.show(e.getComponent(),e.getX(),e.getY());

						}//fin if
						else {//pas de menu donc on affiche le dossier
							
							popupMenu.setVisible(false);
							if(SwingUtilities.isLeftMouseButton(e)) { //c'est un click normal (click gauche) on ouvre le panel dossier du patient
								int row = Ptable.getSelectedRow();
								DefaultTableModel model = (DefaultTableModel) Ptable.getModel();
								
								int id = Integer.parseInt(model.getValueAt(row, 0).toString());
								DossierPatient dp ;
								dp = DossierPatient.ReadP(id);//init dossier du patient selectionné
								
								Patient p = new Patient();
								p = Patient.ReadString(model.getValueAt(row, 1).toString());//on recupere le patient pour l'utiliser si il n'a pas
																							//de dossier (on le crée)
								
								if(dp != null ) { //si le dosier existe on l'affiche directement
									dp.setPatient(p);
									dp.setConsultations(Consultation.all(p.getId_patient()));
									
									patienttf.setText( dp.getPatient().getNom() + " "+ dp.getPatient().getPrenom()); 
									tailletf.setText(dp.getTaille());
									antecta.setText(dp.getAntecedants());
									gstf.setText(dp.getGroupe_sanguin());
								crd.show(PatientPanel, "dossier");
								
								//on affiche les consultations du patient
						

								if(dp.getConsultations()!=null) { //le patient a deja des consultation enredistrés
								
								//charger les consultations dans la jlist
								for(Consultation c : dp.getConsultations()) {
									C.addElement(Integer.toString(c.getId_consultation()));
									
								}	//fin for
								
								}// fin if dp consultation != null
								
								
								}
								else { //sinon on lui créé un dossier
									//ouvrir frame pour ajouet un dossier au patient
									
									DossierAction da = new DossierAction(p);
									da.setVisible(true);
								}
							}
						}
					}
				}); //fin mouse listener  

modifierdos.addActionListener(new ActionListener() { // si on veut modifier des infos dans le dossier du patient
	public void actionPerformed(ActionEvent e) {
		Patient p = new Patient ();
		p = Patient.ReadString(patienttf.getText().substring(0, patienttf.getText().indexOf(' ')));
		String gs = gstf.getText();
		String t = tailletf.getText();
		String a = antecta.getText();
		DossierAction da = new DossierAction(p,gs,t,a);
		da.setVisible(true);
		crd.show(PatientPanel, "patient"); //on retourne au panel de la jtable
	}
});
				
//TODO MOUSE LISTENER CLIST  pour afficher les infos sur la consultation + LES ANALYSES DEMANDES + LES ORDONNANCES...
			Clist.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			    if(Clist.getSelectedIndex()!= -1) {
				int row = Integer.parseInt(Clist.getSelectedValue());
				Consultation c = new Consultation();
				c = Consultation.Read(row);
				VisiteAction v = new VisiteAction(c);
				v.setVisible(true);
			    }//fin if
			}
				});				
		
				
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

/*§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§                                 ON A FINI AVEC LE PATIENT PANEL                        §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
*/

//TODO init le stat panel il contiendra des panel qui afficheront des graphes, c'est le panel qui s'affichera après avoir cliqué sur le bouton StatBUTTON
		JPanel StatPanel = new JPanel();
		StatPanel.setBackground(Color.WHITE);
		
		//Les composants de StatPanel
		//les boutons 
		parSexe = new JRadioButton();
		parSexe.setText("Femme/Homme");
		JRadioButton parAge = new JRadioButton();
		parAge.setText("Par tranche d'âge");
		
		//les panels 
		JPanel showStatFH = new JPanel();
		showStatFH.setBackground(Color.WHITE);
		JPanel showStatA = new JPanel();
		showStatA.setBackground(Color.WHITE);
		
		JPanel DecoPanel = new JPanel();
		DecoPanel.setBackground(new Color(0, 102, 255));
		//Layout...
		GroupLayout gl_StatPanel = new GroupLayout(StatPanel);
		gl_StatPanel.setHorizontalGroup(
			gl_StatPanel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_StatPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_StatPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(showStatA, GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE)
						.addComponent(showStatFH, GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE))
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(gl_StatPanel.createSequentialGroup()
					.addGap(32)
					.addComponent(parSexe, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(parAge)
					.addContainerGap(671, Short.MAX_VALUE))
				.addComponent(DecoPanel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE)
		);
		gl_StatPanel.setVerticalGroup(
			gl_StatPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_StatPanel.createSequentialGroup()
					.addComponent(DecoPanel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(52)
					.addGroup(gl_StatPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(parAge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(parSexe, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(35)
					.addComponent(showStatA, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(showStatFH, GroupLayout.PREFERRED_SIZE, 468, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		StatPanel.setLayout(gl_StatPanel);
		
//TODO init les stats chart

//TODO ........................................init le chart patient : Femmes/Hommes .......................................................................................
		
		//chart data
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(Patient.nombreFemme(), "f", "Femmes");
		dataset.setValue(Patient.nombreHomme(), "h", "Hommes");
		
		//init le graphe
		JFreeChart chart = ChartFactory.createBarChart("Statistiques", "", "", dataset,PlotOrientation.VERTICAL,false,false,false);
		CategoryPlot catPlot = chart.getCategoryPlot();
		catPlot.setRangeGridlinePaint(Color.WHITE);
		catPlot.setRangeMinorGridlinePaint(Color.WHITE);
		catPlot.setBackgroundPaint(SystemColor.inactiveCaption);
		//init le rendrer pour bien afficher le
		BarRenderer br = (BarRenderer) catPlot.getRenderer();
		br.setMaximumBarWidth(.1); // set maximum width to 35% of chart
		br.setBarPainter(new StandardBarPainter());
	
		//Pour colorier les barres
		
		 catPlot.getRenderer().setSeriesPaint(0, Color.PINK);
	        catPlot.getRenderer().setSeriesPaint(1, Color.BLUE);
		 
		ChartPanel CP = new ChartPanel(chart);
		
		
		
		

//TODO ........................................init le chart patient : par tranche d'age ...................................................................................
		
		
		  // Create datasetp  
  //calculer les nb de patients < 18 ans ...
   
    int tab[] = new int[3];
	tab = Patient.byAge();
    DefaultPieDataset datasetp=new DefaultPieDataset();  
     
    datasetp.setValue("< 18 ans", tab[0]);  
    datasetp.setValue("18-40 ans", tab[1]);  
    datasetp.setValue("> 40",  tab[2]);  
 
    // Create chart  
    JFreeChart chartp = ChartFactory.createPieChart(  
        "Patients par tranches d'age",  
        datasetp,  
        true,   
        true,  
        false);  
  
    //Format Label  
    PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(  
        "Age {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));  
    ((PiePlot) chartp.getPlot()).setLabelGenerator(labelGenerator);  
      
    ChartPanel CP2 = new ChartPanel(chartp);
    
//......................................................MOUSE LISTENER............................................................    
    //par default on affiche le premier graphe f/h
    showStatFH.add(CP);
    //mouse listener pour afficher les stats F/H

		parSexe.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showStatA.setVisible(false);
				parAge.setSelected(false);
				parSexe.setSelected(true);
				showStatFH.add(CP,BorderLayout.CENTER);
				showStatFH.validate();
				showStatFH.setVisible(true);
			}
		});
		
		//mouse listener pour afficher les stats AGE
		parAge.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				showStatFH.setVisible(false);
				parSexe.setSelected(false);
				parAge.setSelected(true);
				showStatA.add(CP2,BorderLayout.CENTER);
				showStatA.validate();
				showStatA.setVisible(true);
			}
		});

/*§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§                                 ON A FINI AVEC LE STAT PANEL                        §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
* §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
*/
		
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//TODO Ajouter les panels HomePanel et PatientPanel au MainPanel pour realiser le cardlayout
		MainPanel.add(HomePanel, "HomePanel");
		MainPanel.add(PatientPanel,"PatientPanel");
		MainPanel.add(StatPanel,"StatPanel");
		
		
		CardLayout cl = (CardLayout) MainPanel.getLayout();



//TODO implmenter les action listeners pour réaliser le card layout
		HomeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
						cl.show(MainPanel, "HomePanel");
						textField.setText("Entrez le nom d'un patient");//reinitiliser le message du textfield de PatientPanel : patient
					}
				});

		PatientButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
						cl.show(MainPanel, "PatientPanel");
					}
				});
		StatButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(MainPanel, "StatPanel");
				textField.setText("Entrez le nom d'un patient");
			}
		});
		
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^	
		

}//fin du constructeur

	
	//GETTERS + SETTERS
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
}

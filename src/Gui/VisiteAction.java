package Gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Models.*;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VisiteAction extends JFrame {

	private JPanel contentPane;
	private JTextField poidstf;
	private JTextField choltf;
	private JTextField glytf;
	private JTextField tensiontf;
	private JTextArea obstf;
	private JTextField montanttf;
	private JTextArea maladiestf;
	private Consultation c = new Consultation();
	private ArrayList<Bilan> b = new  ArrayList<Bilan>();
	private ArrayList<Ordonnance> o = new  ArrayList<Ordonnance>();
	/**
	 * Create the frame.
	 */
public VisiteAction(Patient dp,DefaultListModel<String> j ) {
		setType(Type.POPUP);
		setBounds(100, 100, 907, 501);
//TODO INIT the main panel
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
//TODO INIT TABBEDPANE		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 891, 462);
		contentPane.add(tabbedPane);
//TODO INIT LES PANELS DE TABBEDPANE
		//panel pour enregistrer une consultation
		JPanel consultation = new JPanel();
		consultation.setBackground(Color.WHITE);
		tabbedPane.addTab("Nouvelle consultation", null, consultation, null);
		consultation.setLayout(null);
		
		JLabel poidsl = new JLabel("Poids :");
		poidsl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		poidsl.setBounds(33, 36, 46, 14);
		consultation.add(poidsl);
		
		JLabel glycemiel = new JLabel("Glycémie :");
		glycemiel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		glycemiel.setBounds(561, 36, 60, 14);
		consultation.add(glycemiel);
		
		JLabel choll = new JLabel("Cholestérole :");
		choll.setFont(new Font("Tahoma", Font.PLAIN, 12));
		choll.setBounds(20, 96, 75, 14);
		consultation.add(choll);
		
		JLabel tensionl = new JLabel("Tension :");
		tensionl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		tensionl.setBounds(561, 96, 75, 14);
		consultation.add(tensionl);
		
		JLabel maladiesl = new JLabel("Maladies :");
		maladiesl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		maladiesl.setBounds(33, 164, 75, 14);
		consultation.add(maladiesl);
		
		JLabel obsl = new JLabel("Observation :");
		obsl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		obsl.setBounds(561, 164, 75, 14);
		consultation.add(obsl);
		
		JLabel montantl = new JLabel("Montant :");
		montantl.setFont(new Font("Tahoma", Font.PLAIN, 12));
		montantl.setBounds(561, 303, 75, 14);
		consultation.add(montantl);
		
		poidstf = new JTextField();
		poidstf.setBackground(SystemColor.control);
		poidstf.setBounds(101, 34, 86, 20);
		consultation.add(poidstf);
		poidstf.setColumns(10);
		
		choltf = new JTextField();
		choltf.setBackground(SystemColor.control);
		choltf.setColumns(10);
		choltf.setBounds(101, 94, 86, 20);
		consultation.add(choltf);
		
		glytf = new JTextField();
		glytf.setBackground(SystemColor.control);
		glytf.setColumns(10);
		glytf.setBounds(646, 34, 86, 20);
		consultation.add(glytf);
		
		tensiontf = new JTextField();
		tensiontf.setBackground(SystemColor.control);
		tensiontf.setColumns(10);
		tensiontf.setBounds(646, 94, 86, 20);
		consultation.add(tensiontf);
		
		obstf = new JTextArea();
		obstf.setBackground(SystemColor.control);
		obstf.setColumns(10);
		obstf.setBounds(646, 164, 230, 99);
		consultation.add(obstf);
		
		montanttf = new JTextField();
		montanttf.setBackground(SystemColor.control);
		montanttf.setColumns(10);
		montanttf.setBounds(677, 301, 86, 20);
		consultation.add(montanttf);
		
		maladiestf = new JTextArea();
		maladiestf.setBackground(SystemColor.control);
		maladiestf.setToolTipText("Ecrivez toutes les maladies diagnostiquées");
		maladiestf.setColumns(10);
		maladiestf.setBounds(101, 164, 292, 116);
		consultation.add(maladiestf);
		
		JButton addButton = new JButton("Enregistrer");
		
		addButton.setBounds(304, 400, 101, 23);
		consultation.add(addButton);
		
		JButton cancelButton = new JButton("Annuler");
		
		cancelButton.setBounds(447, 400, 89, 23);
		consultation.add(cancelButton);
		
/*		//Panel pour enresitrer des analyses
		JPanel analyses = new JPanel();
		analyses.setBackground(Color.WHITE);
		tabbedPane.addTab("Nouvelles Analyses", null, analyses, null);
		
		//JTABLE ANALYSES
		  Object[] acolumn = {
				 "Nom Bilan", "Resultat"};
		DefaultTableModel adtm = new DefaultTableModel(acolumn,20); //20 lignes à l'initialisation
		adtm.setColumnIdentifiers(acolumn);
		JTable ana = new JTable(adtm);
		ana.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
			new String[] {
				 "Nom Bilan", "Resultat"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				 true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}); 
		ana.setToolTipText("Remplissez les lignes avec les analyses demandées ");
		
		 
		JScrollPane ascroll = new JScrollPane(ana);
		ana.setFillsViewportHeight(true);
		
		//analyses panel layout ....
		GroupLayout gl_analyses = new GroupLayout(analyses);
		gl_analyses.setHorizontalGroup(
			gl_analyses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 886, Short.MAX_VALUE)
				.addComponent(ascroll)
		);
		gl_analyses.setVerticalGroup(
			gl_analyses.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
				.addComponent(ascroll)
		);
		analyses.setLayout(gl_analyses);
		
		
		//Panel pour enresitrer des ordonnances
		JPanel ordonnance = new JPanel();
		tabbedPane.addTab("Nouvelles Ordonnances", null, ordonnance, null);
		
		//JTABLE ANALYSES
		  Object[] ocolumn = {
				 "Nom Medicament", "Dosage","duree traitement","posologie"};
		DefaultTableModel odtm = new DefaultTableModel(ocolumn,20); //20 lignes à l'initialisation
		adtm.setColumnIdentifiers(ocolumn);
		JTable ord = new JTable(odtm);
		ord.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
					{null, null, null},
				},
			new String[] {
					 "Nom Medicament", "Dosage","duree traitement","posologie"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				 true, true,true,true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}); 
		ana.setToolTipText("Remplissez les lignes avec les medicaments demandées ");
		
		 
		JScrollPane oscroll = new JScrollPane(ord);
		ord.setFillsViewportHeight(true);
		
		GroupLayout gl_ordonnance = new GroupLayout(ordonnance);
		gl_ordonnance.setHorizontalGroup(
			gl_ordonnance.createParallelGroup(Alignment.LEADING)
				.addGap(0, 886, Short.MAX_VALUE)
				.addComponent(oscroll)
		);
		gl_ordonnance.setVerticalGroup(
			gl_ordonnance.createParallelGroup(Alignment.LEADING)
				.addGap(0, 434, Short.MAX_VALUE)
				.addComponent(oscroll)
		);
		ordonnance.setLayout(gl_ordonnance);*/
	
//TODO IMPLEMENTER ACTION LISTENERS
	addButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");	
			String strDateFormat = "hh:mm";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
			Date d = new Date();
			String date;
			
			try {
				//charger la consultation °°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°
				date = sdf.format(d);
				c.setDate_consultation(sdf.parse(date));
				
				date = dateFormat.format(d);
				c.setHeure_consultation(date);
				c.setPoids(Double.parseDouble(poidstf.getText()));
				c.setCholesterol(Double.parseDouble(choltf.getText()));
				c.setTension(Double.parseDouble(tensiontf.getText()));
				c.setMaladies(maladiestf.getText());
				c.setMontant_paye(Double.parseDouble(montanttf.getText()));
				if(Consultation.create(c, dp.getId_patient())==false) {
					JOptionPane.showMessageDialog(rootPane, "La consultation n'a pas été enregistré veuillez réessayer", "Erreur Enregistrement", 1);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(rootPane, "La consultation a bien été  enregistré", "Enregistrement effectué", 1);
					j.addElement(Integer.toString(c.getId_consultation()));
				dispose();
				}
			}//fin try
			catch(Exception ex) {
				JOptionPane.showMessageDialog( null, ex, "Erreur", 1);
				
			}
		}
	});
	
	cancelButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	
	}//FIN 1 ER CONSTRUCTEUR
//TODO §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ INIT LE DEUXIEME CONSTRUCTEUR POUR AFFICHER LES CONSULTATIONS §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§
public VisiteAction(Consultation c) {
	setType(Type.POPUP);
	setBounds(100, 100, 907, 501);
//TODO INIT the main panel
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
//TODO CHARGER LES ANALYSES ET ORDONNANCES DE LA CONSULTATION
	c.setBilans2();
	c.setOrdonnances2();
//TODO INIT TABBEDPANE		
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	tabbedPane.setBounds(0, 0, 891, 462);
	contentPane.add(tabbedPane);
//TODO INIT LES PANELS DE TABBEDPANE
	//panel pour enregistrer une consultation
	JPanel consultation = new JPanel();
	consultation.setBackground(Color.WHITE);
	tabbedPane.addTab("Consultation", null, consultation, null);
	consultation.setLayout(null);
	
	JLabel poidsl = new JLabel("Poids :");
	poidsl.setFont(new Font("Tahoma", Font.PLAIN, 12));
	poidsl.setBounds(33, 36, 46, 14);
	consultation.add(poidsl);
	
	JLabel glycemiel = new JLabel("Glycémie :");
	glycemiel.setFont(new Font("Tahoma", Font.PLAIN, 13));
	glycemiel.setBounds(561, 36, 60, 14);
	consultation.add(glycemiel);
	
	JLabel choll = new JLabel("Cholestérole :");
	choll.setFont(new Font("Tahoma", Font.PLAIN, 12));
	choll.setBounds(20, 96, 75, 14);
	consultation.add(choll);
	
	JLabel tensionl = new JLabel("Tension :");
	tensionl.setFont(new Font("Tahoma", Font.PLAIN, 12));
	tensionl.setBounds(561, 96, 75, 14);
	consultation.add(tensionl);
	
	JLabel maladiesl = new JLabel("Maladies :");
	maladiesl.setFont(new Font("Tahoma", Font.PLAIN, 12));
	maladiesl.setBounds(33, 164, 75, 14);
	consultation.add(maladiesl);
	
	JLabel obsl = new JLabel("Observation :");
	obsl.setFont(new Font("Tahoma", Font.PLAIN, 12));
	obsl.setBounds(561, 164, 75, 14);
	consultation.add(obsl);
	
	JLabel montantl = new JLabel("Montant :");
	montantl.setFont(new Font("Tahoma", Font.PLAIN, 12));
	montantl.setBounds(561, 303, 75, 14);
	consultation.add(montantl);
	
	poidstf = new JTextField();
	poidstf.setBackground(SystemColor.control);
	poidstf.setBounds(101, 34, 86, 20);
	consultation.add(poidstf);
	poidstf.setColumns(10);
	poidstf.setEditable(false);
	poidstf.setText(Double.toString(c.getPoids()));
	
	choltf = new JTextField();
	choltf.setBackground(SystemColor.control);
	choltf.setColumns(10);
	choltf.setBounds(101, 94, 86, 20);
	consultation.add(choltf);
	choltf.setEditable(false);
	choltf.setText(Double.toString(c.getCholesterol()));
	
	glytf = new JTextField();
	glytf.setBackground(SystemColor.control);
	glytf.setColumns(10);
	glytf.setBounds(646, 34, 86, 20);
	consultation.add(glytf);
	glytf.setEditable(false);
	glytf.setText(Double.toString(c.getGlycemie()));
	
	tensiontf = new JTextField();
	tensiontf.setBackground(SystemColor.control);
	tensiontf.setColumns(10);
	tensiontf.setBounds(646, 94, 86, 20);
	consultation.add(tensiontf);
	tensiontf.setEditable(false);
	tensiontf.setText(Double.toString(c.getTension()));
	
	obstf = new JTextArea();
	obstf.setBackground(SystemColor.control);
	obstf.setColumns(10);
	obstf.setBounds(646, 164, 230, 99);
	consultation.add(obstf);
	obstf.setEditable(false);
	obstf.setText(c.getObservation());
	
	montanttf = new JTextField();
	montanttf.setBackground(SystemColor.control);
	montanttf.setColumns(10);
	montanttf.setBounds(677, 301, 86, 20);
	consultation.add(montanttf);
	montanttf.setEditable(false);
	montanttf.setText(Double.toString(c.getMontant_paye()));
	
	maladiestf = new JTextArea();
	maladiestf.setBackground(SystemColor.control);
	maladiestf.setToolTipText("Ecrivez toutes les maladies diagnostiquées");
	maladiestf.setColumns(10);
	maladiestf.setBounds(101, 164, 292, 116);
	consultation.add(maladiestf);
	maladiestf.setEditable(false);
	maladiestf.setText(c.getMaladies());
	
	
	JButton cancelButton = new JButton("Annuler");
	
	cancelButton.setBounds(447, 400, 89, 23);
	consultation.add(cancelButton);
	
	//Panel pour enresitrer des analyses
	JPanel analyses = new JPanel();
	analyses.setBackground(Color.WHITE);
	tabbedPane.addTab("Analyses", null, analyses, null);
	
	//JTABLE ANALYSES
	  Object[] acolumn = {
			 "Nom Bilan", "Resultat"};
	DefaultTableModel adtm = new DefaultTableModel(acolumn,0); //0 lignes à l'initialisation
	adtm.setColumnIdentifiers(acolumn);
	JTable ana = new JTable(adtm);
	ana.setModel(new DefaultTableModel(
			new Object[][] {
			},
		new String[] {
			 "Nom Bilan", "Resultat"
		}
	) {
		boolean[] columnEditables = new boolean[] {
				false, false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	}); 
	ana.setToolTipText("Remplissez les lignes avec les analyses demandées ");
	//ana.setModel(adtm);
	 
	JScrollPane ascroll = new JScrollPane(ana);
	ana.setFillsViewportHeight(true);
	
//TODO Remplir la jtable avec les analyses
	
	  //on remplit la table avec l'arraylist patients de la classe secretaire
				for (Bilan b : c.getBilans()) {
					 adtm.addRow(new Object[] {
							 b.getNom_bilan(),
							 b.getResultat_bilan()
							});
				}

	 
	//analyses panel layout ....
	GroupLayout gl_analyses = new GroupLayout(analyses);
	gl_analyses.setHorizontalGroup(
		gl_analyses.createParallelGroup(Alignment.LEADING)
			.addGap(0, 886, Short.MAX_VALUE)
			.addComponent(ascroll)
	);
	gl_analyses.setVerticalGroup(
		gl_analyses.createParallelGroup(Alignment.LEADING)
			.addGap(0, 434, Short.MAX_VALUE)
			.addComponent(ascroll)
	);
	analyses.setLayout(gl_analyses);
	
	
	//Panel pour enresitrer des ordonnances
	JPanel ordonnance = new JPanel();
	tabbedPane.addTab("Ordonnances", null, ordonnance, null);
	
	//JTABLE ANALYSES
	  Object[] ocolumn = {
			 "Nom Medicament", "Dosage","duree traitement","posologie"};
	DefaultTableModel odtm = new DefaultTableModel(ocolumn,20); //20 lignes à l'initialisation
	adtm.setColumnIdentifiers(ocolumn);
	JTable ord = new JTable(odtm);
	ord.setModel(new DefaultTableModel(
			new Object[][] {
			},
		new String[] {
				 "Nom Medicament", "Dosage","duree traitement","posologie"
		}
	) {
		boolean[] columnEditables = new boolean[] {
			 false, false,false,false
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	}); 
	ana.setToolTipText("Remplissez les lignes avec les medicaments demandées ");
	//ana.setModel(adtm);
	 
	JScrollPane oscroll = new JScrollPane(ord);
	ord.setFillsViewportHeight(true);

  //TODO Remplir la jtable avec les ordonnances
	
	  //on remplit la table avec l'arraylist patients de la classe secretaire
				for (Ordonnance o : c.getOrdonnances()) {
					 odtm.addRow(new Object[] {
							o.getNom_Med(),
							o.getDosage_Med(),
							o.getDureeTraitement(),
							o.getPosologie()
							});
				}
 
	//layout ...
	GroupLayout gl_ordonnance = new GroupLayout(ordonnance);
	gl_ordonnance.setHorizontalGroup(
		gl_ordonnance.createParallelGroup(Alignment.LEADING)
			.addGap(0, 886, Short.MAX_VALUE)
			.addComponent(oscroll)
	);
	gl_ordonnance.setVerticalGroup(
		gl_ordonnance.createParallelGroup(Alignment.LEADING)
			.addGap(0, 434, Short.MAX_VALUE)
			.addComponent(oscroll)
	);
	ordonnance.setLayout(gl_ordonnance);

//TODO IMPLEMENTER ACTION LISTENERS

cancelButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
});

}//FIN  CONSTRUCTEUR 


//FIN DU DEUXIEME CONSTRUCTEUR
	public Consultation getC() {
		return c;
	}
	public void setC(Consultation c) {
		this.c = c;
	}
	public ArrayList<Bilan> getB() {
		return b;
	}
	public void setB(ArrayList<Bilan> b) {
		this.b = b;
	}
	public ArrayList<Ordonnance> getO() {
		return o;
	}
	public void setO(ArrayList<Ordonnance> o) {
		this.o = o;
	}
}
